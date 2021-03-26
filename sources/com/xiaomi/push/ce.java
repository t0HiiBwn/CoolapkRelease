package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.a.a.a.a;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ce implements a {
    public static String a = "/MiPushLog";
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    private static m c = new m(true);
    private static List<Pair<String, Throwable>> g = Collections.synchronizedList(new ArrayList());
    private String d;
    private Context e;
    private String f = "";

    public ce(Context context) {
        this.e = context;
        if (context.getApplicationContext() != null) {
            this.e = context.getApplicationContext();
        }
        this.d = this.e.getPackageName();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014b A[SYNTHETIC, Splitter:B:66:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0177 A[SYNTHETIC, Splitter:B:83:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0195 A[SYNTHETIC, Splitter:B:95:0x0195] */
    public void b() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        Throwable th;
        Exception e2;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            if (TextUtils.isEmpty(this.f) && (externalFilesDir = this.e.getExternalFilesDir(null)) != null) {
                this.f = externalFilesDir.getAbsolutePath() + "";
            }
            File file = new File(this.f + a);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.d, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
            } catch (Exception e3) {
                e2 = e3;
                fileLock = null;
                try {
                    Log.e(this.d, "", e2);
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            Log.e(this.d, "", e4);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            Log.e(this.d, "", e5);
                        }
                    }
                    if (randomAccessFile == null) {
                        randomAccessFile.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e6) {
                            Log.e(this.d, "", e6);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e7) {
                            Log.e(this.d, "", e7);
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e8) {
                            Log.e(this.d, "", e8);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                if (bufferedWriter != null) {
                }
                fileLock.release();
                if (randomAccessFile != null) {
                }
                throw th;
            }
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                while (!g.isEmpty()) {
                    try {
                        Pair<String, Throwable> remove = g.remove(0);
                        String str = (String) remove.first;
                        if (remove.second != null) {
                            str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                        }
                        bufferedWriter2.write(str + "\n");
                    } catch (Exception e9) {
                        e2 = e9;
                        bufferedWriter = bufferedWriter2;
                        Log.e(this.d, "", e2);
                        if (bufferedWriter != null) {
                        }
                        fileLock.release();
                        if (randomAccessFile == null) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        fileLock.release();
                        if (randomAccessFile != null) {
                        }
                        throw th;
                    }
                }
                bufferedWriter2.flush();
                bufferedWriter2.close();
                File file3 = new File(file, "log1.txt");
                if (file3.length() >= 1048576) {
                    File file4 = new File(file, "log0.txt");
                    if (file4.exists() && file4.isFile()) {
                        file4.delete();
                    }
                    file3.renameTo(file4);
                }
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e10) {
                        Log.e(this.d, "", e10);
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e11) {
                    Log.e(this.d, "", e11);
                }
            } catch (Exception e12) {
                e2 = e12;
                Log.e(this.d, "", e2);
                if (bufferedWriter != null) {
                }
                fileLock.release();
                if (randomAccessFile == null) {
                }
            }
        } catch (Exception e13) {
            e2 = e13;
            fileLock = null;
            randomAccessFile = null;
            Log.e(this.d, "", e2);
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile == null) {
            }
        } catch (Throwable th5) {
            th = th5;
            fileLock = null;
            randomAccessFile = null;
            if (bufferedWriter != null) {
            }
            fileLock.release();
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    @Override // com.xiaomi.a.a.a.a
    public final void a(String str) {
        a(str, null);
    }

    @Override // com.xiaomi.a.a.a.a
    public final void a(String str, Throwable th) {
        g.add(new Pair<>(String.format("%1$s %2$s %3$s ", b.format(new Date()), this.d, str), th));
        c.a(new cf(this));
    }
}
