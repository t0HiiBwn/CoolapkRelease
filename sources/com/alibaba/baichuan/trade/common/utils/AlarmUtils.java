package com.alibaba.baichuan.trade.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import java.lang.reflect.Field;
import java.util.Map;

public class AlarmUtils {
    public static void alarm(final String str, final String str2, final String str3) {
        if (AlibcTradeCommon.isDebug()) {
            ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
                /* class com.alibaba.baichuan.trade.common.utils.AlarmUtils.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Activity currentActivity = AlarmUtils.getCurrentActivity();
                        if (currentActivity != null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
                            builder.setMessage("class = " + str + "\nmethod = " + str2 + "\nerrMsg = " + str3);
                            builder.setTitle("执行过程参数发生错误");
                            builder.show();
                        }
                    } catch (Exception unused) {
                        AlibcLogger.e("AlisdkTrade-alram", "class = " + str + "\nmethod = " + str2 + "\nerrMsg = " + str3);
                    }
                }
            });
        }
    }

    public static Activity getCurrentActivity() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
