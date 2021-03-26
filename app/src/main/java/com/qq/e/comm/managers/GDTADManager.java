package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    private volatile Boolean a;
    private volatile Context b;
    private volatile SM c;
    private volatile PM d;
    private volatile DevTools e;
    private volatile APPStatus f;
    private volatile DeviceStatus g;
    private volatile String h;
    private PM.a.AbstractC0076a i;

    static final class a {
        private static GDTADManager a = new GDTADManager((byte) 0);
    }

    private GDTADManager() {
        this.a = Boolean.FALSE;
    }

    /* synthetic */ GDTADManager(byte b2) {
        this();
    }

    public static GDTADManager getInstance() {
        return a.a;
    }

    public JSONObject buildS2SSBaseInfo() throws JSONException {
        if (!isInitialized()) {
            return null;
        }
        JSONObject a2 = com.qq.e.comm.net.a.a(this.c);
        a2.put("app", com.qq.e.comm.net.a.a(this.f));
        a2.put("c", com.qq.e.comm.net.a.a(this.g));
        a2.put("sdk", com.qq.e.comm.net.a.a(this.d));
        return a2;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.b;
    }

    public APPStatus getAppStatus() {
        return this.f;
    }

    public DevTools getDevTools() {
        if (this.e == null) {
            this.e = new DevTools();
        }
        return this.e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.g;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public String getLandscapeADActivityClazz() {
        return CustomPkgConstants.getLandscapeADActivityName();
    }

    public PM getPM() {
        return this.d;
    }

    public String getPortraitADActivityClazz() {
        return CustomPkgConstants.getPortraitADActivityName();
    }

    public String getProcessName() {
        return this.h;
    }

    public String getRewardvideoLandscapeADActivityClazz() {
        return CustomPkgConstants.getRewardvideoLandscapeADActivityName();
    }

    public String getRewardvideoPortraitADActivityClazz() {
        return CustomPkgConstants.getRewardvideoPortraitADActivityName();
    }

    public SM getSM() {
        return this.c;
    }

    public synchronized boolean initWith(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("system version not support !");
            return false;
        } else if (this.a.booleanValue()) {
            return true;
        } else {
            if (context == null || StringUtil.isEmpty(str)) {
                GDTLogger.e("Context And APPID should Never Be NULL while init GDTADManager");
                return false;
            }
            try {
                long nanoTime = System.nanoTime();
                this.h = SystemUtil.getProcessName(context);
                this.b = context.getApplicationContext();
                this.c = new SM(this.b);
                this.d = new PM(this.b, this.i);
                this.f = new APPStatus(str, this.b);
                this.g = new DeviceStatus(this.b);
                if (Build.VERSION.SDK_INT > 7) {
                    com.qq.e.comm.services.a.a().a(this.b, this.c, this.d, this.g, this.f, nanoTime);
                }
                this.a = Boolean.TRUE;
                return true;
            } catch (Throwable th) {
                GDTLogger.report("ADManager init error", th);
                return false;
            }
        }
    }

    public boolean isInitialized() {
        if (this.a == null) {
            return false;
        }
        return this.a.booleanValue();
    }

    public void setPluginLoadListener(PM.a.AbstractC0076a aVar) {
        this.i = aVar;
    }
}
