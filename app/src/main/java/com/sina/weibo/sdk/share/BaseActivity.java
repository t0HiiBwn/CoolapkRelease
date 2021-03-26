package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import com.sina.weibo.sdk.utils.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity extends Activity {
    private static final String TAG = "BaseActivity";

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            boolean fixOrientation = fixOrientation();
            LogUtil.i("BaseActivity", "onCreate fixOrientation when Oreo, result = " + fixOrientation);
        }
        super.onCreate(bundle);
    }

    private boolean isTranslucentOrFloating() {
        boolean z;
        Exception e;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT != 26 || !isTranslucentOrFloating()) {
            super.setRequestedOrientation(i);
        } else {
            LogUtil.i("BaseActivity", "avoid calling setRequestedOrientation when Oreo.");
        }
    }
}
