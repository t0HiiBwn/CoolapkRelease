package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;

public class c {
    private SharedPreferences.Editor a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f83a;

    /* renamed from: a  reason: collision with other field name */
    private b.a f84a;

    /* renamed from: a  reason: collision with other field name */
    private b f85a;

    /* renamed from: a  reason: collision with other field name */
    private d f86a;
    private String b = "";
    private String c = "";
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i;
    private Context mContext;

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0177 A[Catch:{ Exception -> 0x0181 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    public c(Context context, String str, String str2, boolean z, boolean z2) {
        long j;
        long j2;
        boolean z3;
        SharedPreferences sharedPreferences;
        b bVar;
        String str3 = null;
        this.f83a = null;
        this.f85a = null;
        this.a = null;
        this.f84a = null;
        this.mContext = null;
        this.f86a = null;
        this.i = false;
        this.f = z;
        this.i = z2;
        this.b = str2;
        this.c = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str2, 0);
            this.f83a = sharedPreferences2;
            j = sharedPreferences2.getLong("t", 0);
        } else {
            j = 0;
        }
        try {
            str3 = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (g.m30a(str3)) {
            this.h = false;
            this.g = false;
        } else if (str3.equals("mounted")) {
            this.h = true;
            this.g = true;
        } else if (str3.equals("mounted_ro")) {
            this.g = true;
            this.h = false;
        } else {
            this.h = false;
            this.g = false;
        }
        if ((this.g || this.h) && context != null && !g.m30a(str)) {
            d a2 = a(str);
            this.f86a = a2;
            if (a2 != null) {
                try {
                    b a3 = a2.a(str2, 0);
                    this.f85a = a3;
                    j2 = a3.getLong("t", 0);
                    if (!z2) {
                        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i2 > 0) {
                            try {
                                a(this.f83a, this.f85a);
                                this.f85a = this.f86a.a(str2, 0);
                            } catch (Exception unused) {
                            }
                        } else if (i2 < 0) {
                            a(this.f85a, this.f83a);
                            this.f83a = context.getSharedPreferences(str2, 0);
                        } else if (i2 == 0) {
                            a(this.f83a, this.f85a);
                            this.f85a = this.f86a.a(str2, 0);
                        }
                    } else {
                        long j3 = this.f83a.getLong("t2", 0);
                        try {
                            j2 = this.f85a.getLong("t2", 0);
                            int i3 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                            if (i3 < 0 && j3 > 0) {
                                a(this.f83a, this.f85a);
                                this.f85a = this.f86a.a(str2, 0);
                                j = j3;
                            } else if (i3 <= 0 || j2 <= 0) {
                                int i4 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
                                if (i4 == 0 && j2 > 0) {
                                    a(this.f85a, this.f83a);
                                    this.f83a = context.getSharedPreferences(str2, 0);
                                    j = j3;
                                } else if (j2 != 0 || i4 <= 0) {
                                    if (i3 == 0) {
                                        a(this.f83a, this.f85a);
                                        this.f85a = this.f86a.a(str2, 0);
                                    }
                                    j = j3;
                                } else {
                                    a(this.f83a, this.f85a);
                                    this.f85a = this.f86a.a(str2, 0);
                                    j = j3;
                                }
                            } else {
                                a(this.f85a, this.f83a);
                                this.f83a = context.getSharedPreferences(str2, 0);
                                j = j3;
                            }
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception unused3) {
                }
                if (j == j2 || (j == 0 && j2 == 0)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z3 = this.i;
                    if (z3 || (z3 && j == 0 && j2 == 0)) {
                        sharedPreferences = this.f83a;
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putLong("t2", currentTimeMillis);
                            edit.commit();
                        }
                        bVar = this.f85a;
                        if (bVar == null) {
                            b.a a4 = bVar.a();
                            a4.a("t2", currentTimeMillis);
                            a4.commit();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        j2 = 0;
        if (j == j2) {
        }
        long currentTimeMillis = System.currentTimeMillis();
        z3 = this.i;
        if (z3) {
        }
        sharedPreferences = this.f83a;
        if (sharedPreferences != null) {
        }
        try {
            bVar = this.f85a;
            if (bVar == null) {
            }
        } catch (Exception unused4) {
        }
    }

    private d a(String str) {
        File a2 = m31a(str);
        if (a2 == null) {
            return null;
        }
        d dVar = new d(a2.getAbsolutePath());
        this.f86a = dVar;
        return dVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private File m31a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a a2;
        if (sharedPreferences != null && bVar != null && (a2 = bVar.a()) != null) {
            a2.b();
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    a2.a(key, (String) value);
                } else if (value instanceof Integer) {
                    a2.a(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    a2.a(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    a2.a(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    a2.a(key, ((Boolean) value).booleanValue());
                }
            }
            try {
                a2.commit();
            } catch (Exception unused) {
            }
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (!(bVar == null || sharedPreferences == null || (edit = sharedPreferences.edit()) == null)) {
            edit.clear();
            for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(key, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
        }
    }

    private boolean c() {
        b bVar = this.f85a;
        if (bVar == null) {
            return false;
        }
        boolean b2 = bVar.b();
        if (!b2) {
            commit();
        }
        return b2;
    }

    private void b() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.a == null && (sharedPreferences = this.f83a) != null) {
            this.a = sharedPreferences.edit();
        }
        if (this.h && this.f84a == null && (bVar = this.f85a) != null) {
            this.f84a = bVar.a();
        }
        c();
    }

    public void putString(String str, String str2) {
        if (!g.m30a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                editor.putString(str, str2);
            }
            b.a aVar = this.f84a;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }
    }

    public void remove(String str) {
        if (!g.m30a(str) && !str.equals("t")) {
            b();
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                editor.remove(str);
            }
            b.a aVar = this.f84a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (r4.commit() == false) goto L_0x007f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0096 A[Catch:{ Exception -> 0x009e }] */
    public boolean commit() {
        boolean z;
        String str;
        d dVar;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.a;
        if (editor != null) {
            if (!this.i && this.f83a != null) {
                editor.putLong("t", currentTimeMillis);
            }
            if (!this.a.commit()) {
                z = false;
                if (!(this.f83a == null || (context = this.mContext) == null)) {
                    this.f83a = context.getSharedPreferences(this.b, 0);
                }
                str = null;
                str = Environment.getExternalStorageState();
                if (!g.m30a(str)) {
                    if (str.equals("mounted")) {
                        if (this.f85a == null) {
                            d a2 = a(this.c);
                            if (a2 != null) {
                                b a3 = a2.a(this.b, 0);
                                this.f85a = a3;
                                if (!this.i) {
                                    a(this.f83a, a3);
                                } else {
                                    a(a3, this.f83a);
                                }
                                this.f84a = this.f85a.a();
                            }
                        } else {
                            try {
                                b.a aVar = this.f84a;
                                if (aVar != null) {
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (str.equals("mounted") || (str.equals("mounted_ro") && this.f85a != null)) {
                        try {
                            dVar = this.f86a;
                            if (dVar != null) {
                                this.f85a = dVar.a(this.b, 0);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
                return z;
            }
        }
        z = true;
        this.f83a = context.getSharedPreferences(this.b, 0);
        str = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!g.m30a(str)) {
        }
        return z;
        z = false;
        dVar = this.f86a;
        if (dVar != null) {
        }
        return z;
    }

    public String getString(String str) {
        c();
        SharedPreferences sharedPreferences = this.f83a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!g.m30a(string)) {
                return string;
            }
        }
        b bVar = this.f85a;
        if (bVar != null) {
            return bVar.getString(str, "");
        }
        return "";
    }
}
