package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;

public class ADActivity extends Activity {
    private ACTD a;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        try {
            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString("gdt_activity_delegate_name");
                    String string2 = extras.getString("appid");
                    if (!StringUtil.isEmpty(string)) {
                        if (!StringUtil.isEmpty(string2)) {
                            if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                                ACTD activityDelegate = pOFactory.getActivityDelegate(string, this);
                                this.a = activityDelegate;
                                if (activityDelegate == null) {
                                    str = "Init ADActivity Delegate return null,delegateName" + string;
                                }
                            } else {
                                str = "Init GDTADManager fail in AdActivity";
                            }
                            GDTLogger.e(str);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + ((String) null), th);
        }
        ACTD actd = this.a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Exception e) {
                GDTLogger.report("finish ADActivity err", e);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Exception e2) {
            GDTLogger.report("onCreate ADActivity err", e2);
        }
        ACTD actd2 = this.a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        ACTD actd = this.a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        ACTD actd = this.a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }
}
