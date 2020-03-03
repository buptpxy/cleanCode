package com.pxy.goodname;

import java.util.ArrayList;
import java.util.List;

/**
 * 扫雷游戏中，得到标记的格子
 */
public class Minesweeper {
    /**错误示范：
     * 以下是一段正确的，但意义模糊的代码，不看注释看不懂代码的作用
     */
    List<int[]> theList = new ArrayList<int[]>();//游戏面板格子代表的值

    public List<int[]> getList() { //
        List<int[]> list1 =  new ArrayList<int[]>();//定义所有标记的格子
        for (int[] x : theList) { //遍历每格，如果格子的状态为已标记，则将此格子加入已标记列表
            if (x[0] == 4) { //x[0]用来记录格子的状态，4为已标记状态
                list1.add(x);
            }
        }
        return list1;
    }
    /**改进1：
     * 改进后的代码，明确命名每一个变量，望名知意
     * 这段代码就比上段易读得多
     */
    final int CELL_STATUS = 0;
    final int FLAGGED = 4;
    List<int[]> gameBoard = new ArrayList<int[]>();
    public List<int[]> getFlaggedIntCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for (int[] cell : gameBoard) {
            if (cell[CELL_STATUS] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
    /**改进2：
     * 更进一步地，可创建一个Cell类，不再使用int[]替代，则下面的代码无需注释也能完全看懂，且解耦了判断格子是否标记的逻辑，使得方法功能更专一
     */
    class Cell { //此处省略了getter/setter方法，和其他未使用属性
        private int status;
        public boolean isFlagged() {
            return status == FLAGGED;
        }
    }
    List<Cell> cellGameBoard = new ArrayList<Cell>();
    public List<Cell> getFlaggedCells() {
        List<Cell> flaggedCells = new ArrayList<Cell>();
        for (Cell cell : cellGameBoard) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
