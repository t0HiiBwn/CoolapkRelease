package me.zhanghai.android.appiconloader;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class UserHandleCompat {
    private static final boolean MU_ENABLED = true;
    private static final int PER_USER_RANGE = 100000;
    private static final int USER_SYSTEM = 0;
    private static Constructor<UserHandle> sConstructor;
    private static final Object sConstructorLock = new Object();

    private UserHandleCompat() {
    }

    public static UserHandle getUserHandleForUid(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UserHandle.getUserHandleForUid(i);
        }
        try {
            return getConstructor().newInstance(Integer.valueOf(getUserId(i)));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getUserId(int i) {
        return i / 100000;
    }

    private static Constructor<UserHandle> getConstructor() {
        Constructor<UserHandle> constructor;
        synchronized (sConstructorLock) {
            if (sConstructor == null) {
                try {
                    sConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
            constructor = sConstructor;
        }
        return constructor;
    }
}
