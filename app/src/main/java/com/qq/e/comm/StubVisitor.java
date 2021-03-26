package com.qq.e.comm;

import android.content.Context;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.util.SystemUtil;

public class StubVisitor {
    private static volatile StubVisitor a;

    private StubVisitor() {
    }

    public static StubVisitor getInstance() {
        if (a == null) {
            synchronized (StubVisitor.class) {
                if (a == null) {
                    a = new StubVisitor();
                }
            }
        }
        return a;
    }

    public String appendPathName(String str) {
        return SystemUtil.buildNewPathByProcessName(str);
    }

    public boolean jumpToCustomLandingPage(Context context, String str, String str2) {
        CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
        if (customLandingPageListener != null) {
            return customLandingPageListener.jumpToCustomLandingPage(context, str, str2);
        }
        return false;
    }
}
