package com.amap.api.mapcore2d;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* compiled from: DiskCachManager */
class u {
    private Context a;
    private ba b = null;
    private String c = "/sdcard/Amap/RMap";
    private final int d = 128;

    private byte[] a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    public u(Context context, boolean z, an anVar) {
        this.a = context;
        if (anVar != null) {
            if (z) {
                this.c = context.getFilesDir().getPath();
            } else {
                boolean z2 = false;
                if (anVar.m != null && !anVar.m.equals("")) {
                    File file = new File(anVar.m);
                    boolean exists = file.exists();
                    z2 = !exists ? file.mkdirs() : exists;
                    this.c = anVar.m;
                }
                if (!z2) {
                    this.c = a(this.a, this.c, anVar);
                }
            }
            bg.a().b("cache_path", this.c);
        }
    }

    public static String a(Context context, String str, an anVar) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getFilesDir().getPath();
        }
        File file = new File(cm.b(context), anVar.b);
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + "/";
    }

    private String[] a(bs bsVar, boolean z) {
        int i = (bsVar.b / 128) / 10;
        int i2 = (bsVar.c / 128) / 10;
        String[] strArr = new String[2];
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append("/");
            sb.append(bsVar.d);
            sb.append("/");
            sb.append(i);
            sb.append("/");
            sb.append(i2);
            sb.append("/");
            if (!z) {
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            sb.append(bsVar.c());
            strArr[0] = sb.toString() + ".idx";
            strArr[1] = sb.toString() + ".dat";
        } catch (Throwable th) {
            cm.a(th, "CachManager", "getCachFileName");
        }
        return strArr;
    }

    public void a(ba baVar) {
        this.b = baVar;
    }

    private void a(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            byte b2 = bArr[0];
            bArr[0] = bArr[3];
            bArr[3] = b2;
            byte b3 = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = b3;
        }
    }

    private int b(byte[] bArr) {
        return ((bArr[3] << 24) & -16777216) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    private int a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    public int a(bs bsVar) {
        int a2;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        try {
            String[] a3 = a(bsVar, true);
            if (a3 != null && a3.length == 2 && !a3[0].equals("")) {
                if (!Arrays.equals(a3, new String[a3.length])) {
                    File file = new File(a3[0]);
                    if (!file.exists() || (a2 = a(bsVar.b, bsVar.c)) < 0) {
                        return -1;
                    }
                    byte[] bArr = null;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "r");
                    } catch (FileNotFoundException e) {
                        cm.a(e, "CachManager", "getTileFromCach");
                        randomAccessFile = null;
                    }
                    if (randomAccessFile == null) {
                        return -1;
                    }
                    try {
                        randomAccessFile.seek((long) (a2 * 4));
                    } catch (IOException e2) {
                        cm.a(e2, "CachManager", "getTileFromCach");
                    }
                    byte[] bArr2 = new byte[4];
                    try {
                        randomAccessFile.read(bArr2, 0, 4);
                    } catch (IOException e3) {
                        cm.a(e3, "CachManager", "getTileFromCach");
                    }
                    a(bArr2);
                    int b2 = b(bArr2);
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        cm.a(th, "CachManager", "getTileFromCach");
                    }
                    if (b2 < 0) {
                        return -1;
                    }
                    File file2 = new File(a3[1]);
                    if (!file2.exists()) {
                        return -1;
                    }
                    try {
                        randomAccessFile2 = new RandomAccessFile(file2, "r");
                    } catch (FileNotFoundException e4) {
                        cm.a(e4, "CachManager", "getTileFromCach");
                        randomAccessFile2 = null;
                    }
                    if (randomAccessFile2 == null) {
                        return -1;
                    }
                    try {
                        randomAccessFile2.seek((long) b2);
                    } catch (IOException e5) {
                        cm.a(e5, "CachManager", "getTileFromCach");
                    }
                    try {
                        randomAccessFile2.read(bArr2, 0, 4);
                    } catch (IOException e6) {
                        cm.a(e6, "CachManager", "getTileFromCach");
                    }
                    a(bArr2);
                    int b3 = b(bArr2);
                    if (b3 <= 0 || b3 > 204800) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e7) {
                            cm.a(e7, "CachManager", "getTileFromCach");
                        }
                    } else {
                        try {
                            bArr = new byte[b3];
                            randomAccessFile2.read(bArr, 0, b3);
                        } catch (Throwable th2) {
                            cm.a(th2, "CachManager", "getTileFromCach");
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e8) {
                            cm.a(e8, "CachManager", "getTileFromCach");
                        }
                        ba baVar = this.b;
                        if (baVar == null) {
                            return -1;
                        }
                        return baVar.a(bArr, null, true, null, bsVar.c());
                    }
                }
            }
            return -1;
        } catch (Throwable th3) {
            cm.a(th3, "CachManager", "getTileFromCach");
            return -1;
        }
    }

    public synchronized boolean a(byte[] bArr, bs bsVar) {
        RandomAccessFile randomAccessFile;
        long j;
        long j2;
        boolean z;
        boolean z2;
        if (bArr == null) {
            return false;
        }
        int length = bArr.length;
        if (length <= 0) {
            return false;
        }
        try {
            String[] a2 = a(bsVar, false);
            if (a2 != null && a2.length == 2 && !a2[0].equals("")) {
                if (!Arrays.equals(a2, new String[a2.length])) {
                    File file = new File(a2[1]);
                    if (!file.exists()) {
                        try {
                            z2 = file.createNewFile();
                        } catch (Throwable th) {
                            cm.a(th, "CachManager", "addDataToCach");
                            z2 = false;
                        }
                        if (!z2) {
                            return false;
                        }
                    }
                    RandomAccessFile randomAccessFile2 = null;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rws");
                    } catch (Throwable th2) {
                        cm.a(th2, "CachManager", "addDataToCach");
                        randomAccessFile = null;
                    }
                    if (randomAccessFile == null) {
                        return false;
                    }
                    byte[] a3 = a(length);
                    a(a3);
                    try {
                        j = randomAccessFile.length();
                    } catch (Throwable th3) {
                        cm.a(th3, "CachManager", "addDataToCach");
                        j = 0;
                    }
                    try {
                        randomAccessFile.seek(j);
                    } catch (Throwable th4) {
                        cm.a(th4, "CachManager", "addDataToCach");
                    }
                    try {
                        randomAccessFile.write(a3);
                    } catch (Throwable th5) {
                        cm.a(th5, "CachManager", "addDataToCach");
                    }
                    try {
                        randomAccessFile.write(bArr);
                    } catch (Throwable th6) {
                        cm.a(th6, "CachManager", "addDataToCach");
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th7) {
                        cm.a(th7, "CachManager", "addDataToCach");
                    }
                    File file2 = new File(a2[0]);
                    if (!file2.exists()) {
                        try {
                            z = file2.createNewFile();
                        } catch (IOException e) {
                            cm.a(e, "CachManager", "addDataToCach");
                            z = false;
                        }
                        if (!z) {
                            return false;
                        }
                    }
                    try {
                        randomAccessFile2 = new RandomAccessFile(file2, "rws");
                    } catch (Throwable th8) {
                        cm.a(th8, "CachManager", "addDataToCach");
                    }
                    if (randomAccessFile2 == null) {
                        return false;
                    }
                    try {
                        j2 = randomAccessFile2.length();
                    } catch (Throwable th9) {
                        cm.a(th9, "CachManager", "addDataToCach");
                        j2 = 0;
                    }
                    if (j2 == 0) {
                        try {
                            byte[] bArr2 = new byte[65536];
                            Arrays.fill(bArr2, (byte) -1);
                            randomAccessFile2.write(bArr2);
                        } catch (Throwable th10) {
                            cm.a(th10, "CachManager", "addDataToCach");
                        }
                    }
                    int a4 = a(bsVar.b, bsVar.c);
                    if (a4 < 0) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable th11) {
                            cm.a(th11, "CachManager", "addDataToCach");
                        }
                        return false;
                    }
                    try {
                        randomAccessFile2.seek((long) (a4 * 4));
                    } catch (Throwable th12) {
                        cm.a(th12, "CachManager", "addDataToCach");
                    }
                    byte[] a5 = a((int) j);
                    a(a5);
                    try {
                        randomAccessFile2.write(a5);
                    } catch (Throwable th13) {
                        cm.a(th13, "CachManager", "addDataToCach");
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Throwable th14) {
                        cm.a(th14, "CachManager", "addDataToCach");
                    }
                    return true;
                }
            }
            return false;
        } catch (Throwable th15) {
            cm.a(th15, "CachManager", "addDataToCach");
        }
    }

    public static void a(final String str) {
        new Thread(new Runnable() {
            /* class com.amap.api.mapcore2d.u.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.b(str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return c(str);
        }
        return d(str);
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean d(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (!listFiles[i].isFile()) {
                    z = d(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = c(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                }
            }
            if (z && file.delete()) {
                return true;
            }
        }
        return false;
    }
}
