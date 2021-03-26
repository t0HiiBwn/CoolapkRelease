package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.jg;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class s {
    private static volatile s a;

    /* renamed from: a  reason: collision with other field name */
    private static final Object f158a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Context f159a;

    private s(Context context) {
        this.f159a = context;
    }

    public static s a(Context context) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(context);
                }
            }
        }
        return a;
    }

    private File a(String str) {
        File file = new File(this.f159a.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile() && listFiles[i].getName().startsWith(str)) {
                return listFiles[i];
            }
        }
        return null;
    }

    public String a(File file) {
        if (file == null) {
            return "";
        }
        String[] split = file.getName().split(":");
        return split.length != 2 ? "" : split[0];
    }

    public ArrayList<File> a() {
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(this.f159a.getFilesDir() + "/crash");
        if (!file.exists()) {
            file.mkdirs();
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            String[] split = listFiles[i].getName().split(":");
            if (split.length >= 2 && Integer.parseInt(split[1]) >= 1 && listFiles[i].isFile()) {
                arrayList.add(listFiles[i]);
            }
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        Throwable th;
        Exception e;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            synchronized (f158a) {
                File a2 = a(str2);
                if (a2 != null) {
                    String[] split = a2.getName().split(":");
                    if (split.length >= 2) {
                        a2.renameTo(new File(this.f159a.getFilesDir() + "/crash/" + str2 + ":" + String.valueOf(Integer.parseInt(split[1]) + 1)));
                    }
                } else {
                    FileOutputStream fileOutputStream = null;
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.f159a.getFilesDir() + "/crash/" + str2 + ":1"));
                        try {
                            fileOutputStream2.write(str.getBytes());
                            fileOutputStream2.flush();
                            jg.a(fileOutputStream2);
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                c.a(e);
                                jg.a(fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                jg.a(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            jg.a(fileOutputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        c.a(e);
                        jg.a(fileOutputStream);
                    }
                }
            }
        }
    }
}
