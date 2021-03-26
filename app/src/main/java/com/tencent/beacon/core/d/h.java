package com.tencent.beacon.core.d;

import android.content.Context;
import com.tencent.beacon.core.b.b;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.event.o;
import com.tencent.beacon.core.protocol.a.a;
import com.tencent.beacon.core.protocol.a.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.util.EncodingUtils;

/* compiled from: Utils */
public final class h {
    public static Date a(String str) {
        if (str != null && str.trim().length() > 0) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
            } catch (ParseException e) {
                b.a(e);
            }
        }
        return null;
    }

    public static long a(long j) {
        return new Date().getTime() + j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[SYNTHETIC, Splitter:B:24:0x004b] */
    public static byte[] a(Object obj) {
        Throwable th;
        ObjectOutputStream objectOutputStream;
        b.b("en obj 2 bytes ", new Object[0]);
        if (obj == null || !Serializable.class.isInstance(obj)) {
            b.d("not serial obj ", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    b.a(e);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    b.a(e2);
                }
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                try {
                    b.a(th);
                    b.d(th.getMessage(), new Object[0]);
                    return null;
                } finally {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e3) {
                            b.a(e3);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        b.a(e4);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            b.a(th);
            b.d(th.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC, Splitter:B:24:0x0039] */
    public static Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        if (bArr == null || bArr.length < 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    b.a(e);
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    b.a(e2);
                }
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                try {
                    b.a(th);
                    b.d(th.getMessage(), new Object[0]);
                    return null;
                } finally {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            b.a(e3);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4) {
                        b.a(e4);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            b.a(th);
            b.d(th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        b.b("enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
        try {
            return c.b(i, str, bArr);
        } catch (Throwable th) {
            b.a(th);
            b.d("err enD: %s", th.toString());
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            return c.a(i, str, bArr);
        } catch (Throwable th) {
            b.a(th);
            b.d("err unD: %s", th.toString());
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        b.b("zp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        if (i == 1) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                ZipEntry zipEntry = new ZipEntry("zip");
                zipEntry.setSize((long) bArr.length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(bArr);
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                b.a(th);
                b.d("err zp : %s", th.toString());
            }
        } else {
            if (i == 2) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.close();
                return byteArray2;
            }
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        b.b("unzp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        try {
            return a.a(i, bArr);
        } catch (Throwable th) {
            b.a(th);
            b.d("err unzp}" + th.toString(), new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, i), i2, str);
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        try {
            return b(b(bArr, i2, str), i);
        } catch (Exception e) {
            b.a(e);
            return null;
        }
    }

    public static String a() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    public static String b(String str) {
        String str2;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str2 = "";
            b.d("Read file %s failed.", str);
            return str2;
        }
        return str2;
    }

    private static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            b.a(e);
            return str;
        }
    }

    private static String d(String str) {
        String c = c(str);
        if (c == null) {
            return c;
        }
        try {
            return c.substring(8, 24);
        } catch (Exception unused) {
            return c;
        }
    }

    public static String a(Context context, int i) {
        try {
            d a = d.a(context);
            String a2 = a.a();
            String b = a.b();
            return d(a2 + "_" + b + "_" + new Date().getTime() + "_" + i);
        } catch (Exception e) {
            b.d("get Rid error", e);
            return null;
        }
    }

    public static String a(Context context) {
        try {
            String d = d.a(context).d();
            String str = "";
            b a = b.a(o.a);
            if (a != null) {
                str = a.a();
            }
            return d(str + "_" + d + "_" + new Date().getTime() + "_" + ((int) (Math.random() * 2.147483647E9d)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static HashSet<String> a(ArrayList<String> arrayList) {
        int size = arrayList.size();
        if (arrayList == null || size <= 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>(size);
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            hashSet.add(it2.next());
        }
        return hashSet;
    }

    public static int a(String str, int i, int i2, int i3) {
        int i4;
        if (str == null) {
            return i;
        }
        try {
            i4 = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            i4 = i;
        } catch (Throwable th) {
            b.a(th);
            return i;
        }
        return (i4 < i2 || i4 > i3) ? i : i4;
    }

    public static long a(String str, long j) {
        long j2;
        if (str == null) {
            return j;
        }
        try {
            j2 = Long.valueOf(str).longValue();
        } catch (Exception unused) {
            j2 = j;
        } catch (Throwable th) {
            b.a(th);
            return j;
        }
        return (j2 < 1000 || j2 > 20000) ? j : j2;
    }

    public static boolean a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        try {
            if (str.toLowerCase().equals("y")) {
                return true;
            }
            if (str.toLowerCase().equals("n")) {
                return false;
            }
            return z;
        } catch (Throwable th) {
            b.a(th);
            return z;
        }
    }

    public static void a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String replace = (th.getMessage() + "\n" + stringWriter.getBuffer().toString()).replace("\t", " ");
        HashMap hashMap = new HashMap();
        hashMap.put("A125", replace);
        o.a("rqd_exception", true, 0, 0, hashMap, true);
    }
}
