package com.rd.utils;

import android.os.Build;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

public class IdUtils {
    private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < 17) {
            return generateId();
        }
        return View.generateViewId();
    }

    private static int generateId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = nextGeneratedId;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }
}
