package com.huawei.hms.common.data;

import android.os.Bundle;
import java.util.ArrayList;

public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        for (E e : dataBuffer) {
            arrayList.add(e.freeze());
        }
        dataBuffer.release();
        return arrayList;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        return a(dataBuffer.getMetadata(), "next_page");
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        return a(dataBuffer.getMetadata(), "prev_page");
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    private static boolean a(Bundle bundle, String str) {
        return (bundle == null || bundle.getString(str) == null) ? false : true;
    }
}
