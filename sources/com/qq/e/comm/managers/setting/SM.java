package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.managers.setting.e;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;

public class SM {
    private a a;
    private String b;
    private a c;
    private a d;
    private String e;
    private d f;
    private d g = null;
    private d h;
    private String i;
    private c j;
    private String k;
    private String l = "";
    private Context m;
    private String n;

    public SM(Context context) {
        this.m = context;
        this.a = new a();
        this.d = new a();
        this.h = new b();
        this.j = new c();
        this.n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");
        try {
            this.k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.k = null;
            GDTLogger.e("IO Exception while loading suid");
        }
        a();
        b();
        c();
    }

    private void a() {
        e.a<d> b2 = e.b(this.m);
        if (b2 != null) {
            this.e = b2.a();
            this.f = b2.b();
            return;
        }
        GDTLogger.d("Load Local SDK Cloud setting fail");
    }

    private void b() {
        e.a<a> a2 = e.a(this.m);
        if (a2 != null) {
            this.c = a2.b();
            this.b = a2.a();
            return;
        }
        GDTLogger.d("Load Local DEV Cloud setting fail");
    }

    private void c() {
        e.a<c> c2 = e.c(this.m);
        if (c2 != null) {
            this.j = c2.b();
            this.i = c2.a();
            return;
        }
        GDTLogger.d("Load Local DEV Cloud setting fail");
    }

    public Object get(String str) {
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            a aVar = this.a;
            if (aVar != null && (a5 = aVar.a(str)) != null) {
                return a5;
            }
            a aVar2 = this.c;
            if (aVar2 != null && (a4 = aVar2.a(str)) != null) {
                return a4;
            }
            a aVar3 = this.d;
            if (aVar3 != null && (a3 = aVar3.a(str)) != null) {
                return a3;
            }
            d dVar = this.f;
            if (dVar != null && (a2 = dVar.a(str)) != null) {
                return a2;
            }
            d dVar2 = this.h;
            if (dVar2 != null) {
                return dVar2.a(str);
            }
            return null;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th);
            return null;
        }
    }

    public Object getDebugSetting() {
        return null;
    }

    public String getDevCloudSettingSig() {
        return this.b;
    }

    public Object getForPlacement(String str, String str2) {
        Object a2;
        Object a3;
        Object a4;
        Object a5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return get(str);
        }
        try {
            c cVar = this.j;
            if (cVar != null && (a5 = cVar.a(str, str2)) != null) {
                return a5;
            }
            a aVar = this.a;
            if (aVar != null && (a4 = aVar.a(str, str2)) != null) {
                return a4;
            }
            a aVar2 = this.c;
            if (aVar2 != null && (a3 = aVar2.a(str, str2)) != null) {
                return a3;
            }
            a aVar3 = this.d;
            return (aVar3 == null || (a2 = aVar3.a(str, str2)) == null) ? get(str) : a2;
        } catch (Throwable th) {
            GDTLogger.report("Exception in settingManager.getForPlacement", th);
            return null;
        }
    }

    public int getInteger(String str, int i2) {
        Object obj = get(str);
        return (obj == null || !(obj instanceof Integer)) ? i2 : ((Integer) obj).intValue();
    }

    public int getIntegerForPlacement(String str, String str2, int i2) {
        Object forPlacement = getForPlacement(str, str2);
        return (forPlacement == null || !(forPlacement instanceof Integer)) ? i2 : ((Integer) forPlacement).intValue();
    }

    public String getPlacementCloudSettingSig() {
        return this.i;
    }

    public String getSdkCloudSettingSig() {
        return this.e;
    }

    public String getSettingDir() {
        return this.n;
    }

    public String getSid() {
        return this.l;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getString(String str, String str2) {
        Object obj = get(str);
        return obj == null ? str2 : obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement == null) {
            return null;
        }
        return forPlacement.toString();
    }

    public String getSuid() {
        return this.k;
    }

    public void modifyDebugSetting(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
        }
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.d.a(str, obj);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.d.a(str, obj, str2);
    }

    public void updateContextSetting(String str) {
        try {
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar = new a(new String(Base64.decode(str, 0), "UTF-8"));
            }
            this.a = aVar;
        } catch (Throwable th) {
            GDTLogger.report("Exception while update Context Setting", th);
        }
    }

    public void updateDEVCloudSetting(String str, String str2) {
        if (e.b(this.m, str, str2)) {
            b();
        }
    }

    public void updatePlacementSetting(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            e.d(this.m);
            this.j = new c();
            this.i = null;
        } else if (e.c(this.m, str, str2)) {
            c();
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        if (e.a(this.m, str, str2)) {
            a();
        }
    }

    public void updateSID(String str) {
        this.l = str;
    }

    public void updateSUID(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.k)) {
            this.k = str;
            try {
                StringUtil.writeTo(str, new File(this.m.getDir(this.n, 0), "gdt_suid"));
            } catch (IOException e2) {
                GDTLogger.report("Exception while persit suid", e2);
            }
        }
    }
}
