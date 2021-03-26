package com.huawei.updatesdk.service.c;

import android.content.Context;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import com.huawei.updatesdk.a.b.a.a;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class h {
    private static String[] a;

    public static String[] a() {
        if (a == null) {
            a = a(a.a().b());
        }
        return (String[]) a.clone();
    }

    private static String[] a(Context context) {
        String b = b(context);
        return new String[]{b + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName() + File.separator + "files"};
    }

    private static String b(Context context) {
        boolean z;
        String str;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        StorageVolume[] storageVolumeArr = new StorageVolume[0];
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            storageVolumeArr = (StorageVolume[]) method.invoke(storageManager, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not find method:getVolumeList", e);
        }
        if (storageVolumeArr == null || storageVolumeArr.length <= 0) {
            return null;
        }
        Method b = b();
        Method c = c();
        for (StorageVolume storageVolume : storageVolumeArr) {
            if (b != null) {
                try {
                    z = ((Boolean) b.invoke(storageVolume, new Object[0])).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not invoke method:getVolumeList", e2);
                }
                str = (String) c.invoke(storageVolume, new Object[0]);
                if (z && !str.contains("usb")) {
                    return str;
                }
            }
            z = false;
            try {
                str = (String) c.invoke(storageVolume, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e3) {
                com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not invoke method:getPath", e3);
                str = "";
            }
            if (z) {
            }
        }
        return null;
    }

    private static Method b() {
        Method method = null;
        try {
            method = StorageVolume.class.getMethod("isRemovable", new Class[0]);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not find method:isRemovable", e);
            return method;
        }
    }

    private static Method c() {
        Method method = null;
        try {
            method = StorageVolume.class.getMethod("getPath", new Class[0]);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not find method:getPath", e);
            return method;
        }
    }
}
