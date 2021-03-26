package com.xiaomi.b.c;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.b.a.d;
import com.xiaomi.b.b.b;
import com.xiaomi.push.ah;
import com.xiaomi.push.al;
import com.xiaomi.push.fv;
import com.xiaomi.push.jg;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class c implements a {
    protected Context a;
    private HashMap<String, ArrayList<d>> b;

    public c(Context context) {
        a(context);
    }

    public static String a(d dVar) {
        return String.valueOf(dVar.e);
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                com.xiaomi.a.a.a.c.a(e);
            }
        }
        jg.a(randomAccessFile);
    }

    private void a(String str, String str2) {
        b a2 = b.a(this.a);
        com.xiaomi.b.a.b a3 = a2.a(5001, "24:" + str + "," + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a3.b());
        a(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        com.xiaomi.a.a.a.c.d(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K";
     */
    private List<String> b(String str) {
        Throwable th;
        Exception e;
        FileInputStream fileInputStream;
        int read;
        String str2;
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            com.xiaomi.a.a.a.c.d("eventData read from cache file failed because magicNumber error");
            jg.a(fileInputStream);
        } catch (Exception e2) {
            e = e2;
            try {
                com.xiaomi.a.a.a.c.a(e);
                jg.a(fileInputStream2);
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                jg.a(fileInputStream2);
                throw th;
            }
        }
        while (true) {
            try {
                read = fileInputStream.read(bArr);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                com.xiaomi.a.a.a.c.a(e);
                jg.a(fileInputStream2);
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                jg.a(fileInputStream2);
                throw th;
            }
            if (read != -1) {
                if (read == 4 && com.xiaomi.push.d.a(bArr) == -573785174) {
                    int read2 = fileInputStream.read(bArr2);
                    if (read2 == -1) {
                        break;
                    } else if (read2 != 4) {
                        str2 = "eventData read from cache file failed cause lengthBuffer error";
                        break;
                    } else {
                        int a2 = com.xiaomi.push.d.a(bArr2);
                        if (a2 < 1 || a2 > 4096) {
                            break;
                        }
                        byte[] bArr3 = new byte[a2];
                        if (fileInputStream.read(bArr3) != a2) {
                            str2 = "eventData read from cache file failed cause buffer size not equal length";
                            break;
                        }
                        String a3 = a(bArr3);
                        if (!TextUtils.isEmpty(a3)) {
                            arrayList.add(a3);
                        }
                    }
                }
            } else {
                break;
            }
        }
        return arrayList;
    }

    private d[] b(d[] dVarArr) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        String c = c(dVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        try {
            File file = new File(c + ".lock");
            jg.c(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(c), true));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                    try {
                        com.xiaomi.a.a.a.c.a("event data write to cache file failed cause exception", e);
                        jg.a(bufferedOutputStream);
                        a(randomAccessFile, fileLock);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        jg.a(bufferedOutputStream2);
                        a(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jg.a(bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                bufferedOutputStream = null;
                com.xiaomi.a.a.a.c.a("event data write to cache file failed cause exception", e);
                jg.a(bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                jg.a(bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
            try {
                int i = 0;
                for (d dVar : dVarArr) {
                    if (dVar != null) {
                        byte[] a2 = a(dVar.b());
                        if (a2 != null && a2.length >= 1) {
                            if (a2.length <= 4096) {
                                if (!al.b(this.a, c)) {
                                    int length = dVarArr.length - i;
                                    d[] dVarArr2 = new d[length];
                                    System.arraycopy(dVarArr, i, dVarArr2, 0, length);
                                    jg.a(bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return dVarArr2;
                                }
                                bufferedOutputStream.write(com.xiaomi.push.d.a(-573785174));
                                bufferedOutputStream.write(com.xiaomi.push.d.a(a2.length));
                                bufferedOutputStream.write(a2);
                                bufferedOutputStream.flush();
                                i++;
                            }
                        }
                        com.xiaomi.a.a.a.c.d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e4) {
                e = e4;
                com.xiaomi.a.a.a.c.a("event data write to cache file failed cause exception", e);
                jg.a(bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
            com.xiaomi.a.a.a.c.a("event data write to cache file failed cause exception", e);
            jg.a(bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        } catch (Throwable th5) {
            th = th5;
            fileLock = null;
            randomAccessFile = null;
            jg.a(bufferedOutputStream2);
            a(randomAccessFile, fileLock);
            throw th;
        }
        jg.a(bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private String c(d dVar) {
        File externalFilesDir = this.a.getExternalFilesDir("event");
        String a2 = a(dVar);
        if (externalFilesDir == null) {
            return null;
        }
        String str = externalFilesDir.getAbsolutePath() + File.separator + a2;
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (al.b(this.a, str2)) {
                return str2;
            }
        }
        return null;
    }

    public String a(byte[] bArr) {
        byte[] a2;
        if (bArr != null && bArr.length >= 1) {
            if (!b.a(this.a).a().b()) {
                return ah.a(bArr);
            }
            String a3 = al.a(this.a);
            if (!TextUtils.isEmpty(a3) && (a2 = al.a(a3)) != null && a2.length > 0) {
                try {
                    return ah.a(Base64.decode(fv.a(a2, bArr), 2));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                    com.xiaomi.a.a.a.c.a(e);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010c A[SYNTHETIC] */
    @Override // com.xiaomi.b.c.e
    public void a() {
        Throwable th;
        Exception e;
        RandomAccessFile randomAccessFile;
        al.a(this.a, "event", "eventUploading");
        File[] c = al.c(this.a, "eventUploading");
        if (c != null && c.length > 0) {
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file = null;
            for (File file2 : c) {
                if (file2 == null) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            com.xiaomi.a.a.a.c.a(e2);
                        }
                    }
                    jg.a(randomAccessFile2);
                    if (file == null) {
                    }
                } else {
                    try {
                        if (file2.length() > 5242880) {
                            com.xiaomi.a.a.a.c.d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                            a(file2.getName(), Formatter.formatFileSize(this.a, file2.length()));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    com.xiaomi.a.a.a.c.a(e3);
                                }
                            }
                            jg.a(randomAccessFile2);
                            if (file == null) {
                            }
                        } else {
                            String absolutePath = file2.getAbsolutePath();
                            File file3 = new File(absolutePath + ".lock");
                            try {
                                jg.c(file3);
                                randomAccessFile = new RandomAccessFile(file3, "rw");
                            } catch (Exception e4) {
                                e = e4;
                                file = file3;
                                try {
                                    com.xiaomi.a.a.a.c.a(e);
                                    try {
                                        fileLock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.a.a.a.c.a(e5);
                                    }
                                    jg.a(randomAccessFile2);
                                    if (file == null) {
                                    }
                                    file.delete();
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        com.xiaomi.a.a.a.c.a(e6);
                                    }
                                    jg.a(randomAccessFile2);
                                    if (file != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                file = file3;
                                if (fileLock != null && fileLock.isValid()) {
                                    fileLock.release();
                                }
                                jg.a(randomAccessFile2);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                a(b(absolutePath));
                                file2.delete();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e7) {
                                        com.xiaomi.a.a.a.c.a(e7);
                                    }
                                }
                                jg.a(randomAccessFile);
                                file3.delete();
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                            } catch (Exception e8) {
                                e = e8;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                com.xiaomi.a.a.a.c.a(e);
                                fileLock.release();
                                jg.a(randomAccessFile2);
                                if (file == null) {
                                }
                                file.delete();
                            } catch (Throwable th4) {
                                th = th4;
                                randomAccessFile2 = randomAccessFile;
                                file = file3;
                                fileLock.release();
                                jg.a(randomAccessFile2);
                                if (file != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e9) {
                        e = e9;
                        com.xiaomi.a.a.a.c.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        jg.a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    }
                }
                file.delete();
            }
        }
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.b.c.a
    public void a(HashMap<String, ArrayList<d>> hashMap) {
        this.b = hashMap;
    }

    public void a(List<String> list) {
        al.a(this.a, list);
    }

    public void a(d[] dVarArr) {
        if (dVarArr == null || dVarArr.length == 0 || dVarArr[0] == null) {
            com.xiaomi.a.a.a.c.a("event data write to cache file failed because data null");
            return;
        }
        do {
            dVarArr = b(dVarArr);
            if (dVarArr == null || dVarArr.length <= 0) {
                return;
            }
        } while (dVarArr[0] != null);
    }

    public byte[] a(String str) {
        byte[] a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!b.a(this.a).a().b()) {
            return ah.c(str);
        }
        String a3 = al.a(this.a);
        byte[] c = ah.c(str);
        if (!TextUtils.isEmpty(a3) && c != null && c.length > 1 && (a2 = al.a(a3)) != null) {
            try {
                if (a2.length > 1) {
                    return fv.b(a2, Base64.encode(c, 2));
                }
            } catch (Exception e) {
                com.xiaomi.a.a.a.c.a(e);
            }
        }
        return null;
    }

    @Override // com.xiaomi.b.c.f
    public void b() {
        HashMap<String, ArrayList<d>> hashMap = this.b;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.b.keySet()) {
                    ArrayList<d> arrayList = this.b.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        d[] dVarArr = new d[arrayList.size()];
                        arrayList.toArray(dVarArr);
                        a(dVarArr);
                    }
                }
            }
            this.b.clear();
        }
    }

    @Override // com.xiaomi.b.c.f
    public void b(d dVar) {
        if ((dVar instanceof com.xiaomi.b.a.b) && this.b != null) {
            com.xiaomi.b.a.b bVar = (com.xiaomi.b.a.b) dVar;
            String a2 = a(bVar);
            ArrayList<d> arrayList = this.b.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(bVar);
            this.b.put(a2, arrayList);
        }
    }
}
