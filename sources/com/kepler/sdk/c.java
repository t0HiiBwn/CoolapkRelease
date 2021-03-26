package com.kepler.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;

public final class c extends ContextWrapper {
    private String a = null;
    private LayoutInflater b;
    private Resources c;
    private Resources.Theme d;
    private Context e;

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return this;
    }

    public c(Context context, String str) {
        super(context);
        ApplicationInfo applicationInfo = null;
        this.e = context;
        this.b = new d(this);
        Resources a2 = a.a(context, str);
        this.c = a2;
        if (a2 != null) {
            this.d = a2.newTheme();
            PackageInfo b2 = a.b(context, str);
            applicationInfo = b2 != null ? b2.applicationInfo : applicationInfo;
            if (b2 != null && applicationInfo != null) {
                int i = applicationInfo.theme;
                this.a = applicationInfo.packageName;
                Resources.Theme theme = getBaseContext().getTheme();
                if (theme != null) {
                    this.d.setTo(theme);
                }
                if (i != 0) {
                    this.d.applyStyle(i, true);
                    return;
                }
                return;
            }
            return;
        }
        Log.i("PluginContextWrapper", "fail to init plugin resources");
    }

    public LayoutInflater a() {
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            return a();
        }
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.c;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        Resources resources = getResources();
        AssetManager assets = resources != null ? resources.getAssets() : null;
        return assets != null ? assets : super.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme != null ? theme : super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme != null) {
            theme.applyStyle(i, true);
        } else {
            super.setTheme(i);
        }
    }

    private Intent a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        return intent;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(a(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return super.startService(a(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.e.getApplicationContext();
    }
}
