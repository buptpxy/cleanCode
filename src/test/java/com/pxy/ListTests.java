package com.pxy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListTests {
    @Test
    public void testEmptyList() {
        List emptyList = Collections.emptyList();
        //emptyList是EmptyList类型的，并未重写Collection类的add方法，因此会报java.lang.UnsupportedOperationException异常
        emptyList.add("hello");
        System.out.println(emptyList.size());
    }
    @Test
    public void testAsList() {
        String[] array = {"1","2","3"};
        List<String> arrayList = Arrays.asList(array);
//      这个Arrays#asList 返回的 ArrayList 其实仅仅只是 Arrays 一个内部类，并非真正的 java.util.ArrayList。
//      因此会报java.lang.UnsupportedOperationException异常
        arrayList.add("4");
//      李鬼 ArrayList 除了不支持增删操作这个坑以外，还存在另外一个大坑，改动内部元素将会同步影响原数组。
        arrayList.set(0,"0");
        Assert.assertNotEquals("1",array[0]);
//      不管我们是修改原数组，还是新 List 集合，两者都会互相影响。
        array[1] = "1";
        Assert.assertNotEquals("2",arrayList.get(1));
//      知道了实际原因，修复的办法也很简单，套娃一层 ArrayList 呗！
        List<String> newArrayList = new ArrayList<String>(Arrays.asList(array));
        newArrayList.add("4");
        newArrayList.set(2,"2");
        Assert.assertNotEquals("2",array[2]);
//      不过这么写感觉十分繁琐，推荐使用 Guava Lists 提供的方法。
        List<String> newArrayListByGuava = Lists.newArrayList(array);
        newArrayListByGuava.add("5");
        newArrayListByGuava.set(2,"2");
        Assert.assertNotEquals("2",array[2]);
    }
    @Test
    public void testSubList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //取原list的0-1个元素，不包括第2个
        List<String> subList = list.subList(0,2);
        Assert.assertEquals(2,subList.size());
        //subList 生成新list会与原list 互相影响
        subList.set(0,"0");
        Assert.assertEquals("0",list.get(0));
        //容易引发OOM问题
//      data 看起来最终保存的只是 1000 个具有 1 个元素的 List，不会占用很大空间。但是程序很快就会 OOM。
//      OOM 的原因正是因为每个 SubList 都强引用个一个 10 万个元素的原始 List，导致 GC 无法回收。
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
//          data.add(rawList.subList(0, 1));
//          这里修复的办法也很简单，跟上面一样，也来个套娃呗，加一层 ArrayList
            data.add(new ArrayList<>(rawList.subList(0, 1)));
        }
    }

    @Test
    public void testUnmodifiableList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        //会报java.lang.UnsupportedOperationException异常，确实不可直接修改unmodifiableList
//        unmodifiableList.set(0,"0");
//        但可修改原list，则unmodifiableList也会随之改变
        list.set(0,"0");
        Assert.assertEquals("0",unmodifiableList.get(0));
        //可使用List.of()方法
        List<String> unmodifiableListOf = List.of(list.toArray(new String[]{}));
        list.set(1,"1");
        Assert.assertNotEquals("1",unmodifiableListOf.get(1));
        //或者直接使用 Guava immutable list
        List<String> unmodifiableListGuava = ImmutableList.copyOf(list);
        list.set(2,"2");
        Assert.assertNotEquals("2",unmodifiableListGuava.get(2));
    }

    @Test
    public void testForeach() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (String str:list) {
            //会报java.util.ConcurrentModificationException异常，但删除ArrayList倒数第二个（即第 size - 1个元素）就会出现不抛异常的假象。
//            因为删除倒数第二个元素后，hasNext()再进来时，cursor = size ，所以不会执行foreach的代码，也不会出现后面检测modCount值抛ConcurrentModificationException
            if ("2".equals(str)) {
                list.remove(str);
            }
        }
        //应使用Iterator的remove方法，不应使用list的remove方法
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("1".equals(iterator.next())) {
                iterator.remove();
            }
        }
        //或使用removeIf
        list.removeIf(str -> str.equals("2"));
    }
}

