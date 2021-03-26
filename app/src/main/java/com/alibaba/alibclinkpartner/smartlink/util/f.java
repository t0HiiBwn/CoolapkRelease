package com.alibaba.alibclinkpartner.smartlink.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class f {
    private static f a;
    private static SharedPreferences b;

    private f(Context context, String str) {
        b = context.getSharedPreferences(str, 0);
    }

    public static void a(Context context, String str) {
        if (a == null) {
            a = new f(context, str);
        }
    }

    public static boolean a(String str, Object obj) {
        SharedPreferences.Editor edit = b.edit();
        String simpleName = obj.getClass().getSimpleName();
        char c = 65535;
        boolean z = false;
        try {
            switch (simpleName.hashCode()) {
                case -1808118735:
                    if (simpleName.equals("String")) {
                        c = 3;
                        break;
                    }
                    break;
                case -672261858:
                    if (simpleName.equals("Integer")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2374300:
                    if (simpleName.equals("Long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 67973692:
                    if (simpleName.equals("Float")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1729365000:
                    if (simpleName.equals("Boolean")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (c == 1) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (c == 2) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (c == 3) {
                edit.putString(str, (String) obj);
            } else if (c == 4) {
                edit.putInt(str, ((Integer) obj).intValue());
            }
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        edit.apply();
        return z;
    }

    public static Object b(String str, Object obj) {
        Object valueOf;
        String simpleName = obj.getClass().getSimpleName();
        char c = 65535;
        try {
            switch (simpleName.hashCode()) {
                case -1808118735:
                    if (simpleName.equals("String")) {
                        c = 3;
                        break;
                    }
                    break;
                case -672261858:
                    if (simpleName.equals("Integer")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2374300:
                    if (simpleName.equals("Long")) {
                        c = 1;
                        break;
                    }
                    break;
                case 67973692:
                    if (simpleName.equals("Float")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1729365000:
                    if (simpleName.equals("Boolean")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                valueOf = Boolean.valueOf(b.getBoolean(str, ((Boolean) obj).booleanValue()));
            } else if (c == 1) {
                valueOf = Long.valueOf(b.getLong(str, ((Long) obj).longValue()));
            } else if (c == 2) {
                valueOf = Float.valueOf(b.getFloat(str, ((Float) obj).floatValue()));
            } else if (c == 3) {
                valueOf = b.getString(str, (String) obj);
            } else if (c != 4) {
                return obj;
            } else {
                valueOf = Integer.valueOf(b.getInt(str, ((Integer) obj).intValue()));
            }
            return valueOf;
        } catch (Exception unused) {
            return obj;
        }
    }

    public static void c(String str, Object obj) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        ObjectOutputStream objectOutputStream;
        SharedPreferences.Editor edit = b.edit();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    objectOutputStream2.close();
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        objectOutputStream2.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            try {
                objectOutputStream.writeObject(obj);
                edit.putString(str, URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8"));
                edit.commit();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e = e5;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
                objectOutputStream2.close();
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream2 = objectOutputStream;
                objectOutputStream2.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            e.printStackTrace();
            objectOutputStream2.close();
            byteArrayOutputStream.close();
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            objectOutputStream2.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    public static Object d(String str, Object obj) {
        Object obj2;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        Exception e;
        String string = b.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            ObjectInputStream objectInputStream2 = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(string, "UTF-8").getBytes("ISO-8859-1"));
            } catch (Exception e2) {
                byteArrayInputStream = null;
                e = e2;
                objectInputStream = null;
                try {
                    e.printStackTrace();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    obj2 = obj;
                    if (obj2 == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    try {
                        objectInputStream2.close();
                        byteArrayInputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
                objectInputStream2.close();
                byteArrayInputStream.close();
                throw th;
            }
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    obj2 = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    obj2 = obj;
                    if (obj2 == null) {
                    }
                }
            } catch (Exception e7) {
                e = e7;
                objectInputStream = null;
                e.printStackTrace();
                objectInputStream.close();
                byteArrayInputStream.close();
                obj2 = obj;
                if (obj2 == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                objectInputStream2.close();
                byteArrayInputStream.close();
                throw th;
            }
            return obj2 == null ? obj : obj2;
        }
        obj2 = obj;
        if (obj2 == null) {
        }
    }
}
