package com.kk.taurus.playerbase.event;

import android.os.Bundle;
import com.kk.taurus.playerbase.log.PLog;
import java.util.ArrayList;
import java.util.List;

public class BundlePool {
    private static final int POOL_SIZE = 3;
    private static List<Bundle> mPool = new ArrayList();

    static {
        for (int i = 0; i < 3; i++) {
            mPool.add(new Bundle());
        }
    }

    public static synchronized Bundle obtain() {
        synchronized (BundlePool.class) {
            for (int i = 0; i < 3; i++) {
                if (mPool.get(i).isEmpty()) {
                    return mPool.get(i);
                }
            }
            PLog.w("BundlePool", "<create new bundle object>");
            return new Bundle();
        }
    }
}
