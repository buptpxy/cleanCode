package com.pxy.argumentsmarshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.pxy.argumentsmarshaler.ArgsException.ErrorCode.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    private String[] stringArray = {};
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            String strs = currentArgument.next();
            parseStringArray(strs);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    private void parseStringArray(String strs) throws ArgsException {
        if (isStringArray(strs)) {
            strs = strs.substring(1,strs.length()-1);
        } else {
            throw new ArgsException(INVALID_ARGUMENT_FORMAT);
        }
        int index = 0;
        for (String str: strs.split(",")) {
            stringArray[index++] = str;
        }
    }

    private boolean isStringArray(String strs) {
        return strs.startsWith("[") && strs.endsWith("]");
    }

    public static String[] getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler)
            return ((StringArrayArgumentMarshaler) am).stringArray;
        else
            return new String[]{};
    }

}
