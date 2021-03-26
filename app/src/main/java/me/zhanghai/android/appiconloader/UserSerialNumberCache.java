package me.zhanghai.android.appiconloader;

import android.content.Context;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;

class UserSerialNumberCache {
    private static final long CACHE_MILLIS = 1000;
    private static final ArrayMap<UserHandle, long[]> sCache = new ArrayMap<>();

    UserSerialNumberCache() {
    }

    public static long getSerialNumber(UserHandle userHandle, Context context) {
        long j;
        ArrayMap<UserHandle, long[]> arrayMap = sCache;
        synchronized (arrayMap) {
            long[] jArr = arrayMap.get(userHandle);
            if (jArr == null) {
                jArr = new long[2];
                arrayMap.put(userHandle, jArr);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (jArr[1] + 1000 <= currentTimeMillis) {
                jArr[0] = ((UserManager) context.getSystemService("user")).getSerialNumberForUser(userHandle);
                jArr[1] = currentTimeMillis;
            }
            j = jArr[0];
        }
        return j;
    }
}
