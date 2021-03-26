package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jc {
    private static final Set<String> e = Collections.synchronizedSet(new HashSet());
    private Context a;
    private FileLock b;
    private String c;
    private RandomAccessFile d;

    private jc(Context context) {
        this.a = context;
    }

    /* JADX INFO: finally extract failed */
    public static jc a(Context context, File file) {
        c.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = e;
        if (set.add(str)) {
            jc jcVar = new jc(context);
            jcVar.c = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                jcVar.d = randomAccessFile;
                jcVar.b = randomAccessFile.getChannel().lock();
                c.c("Locked: " + str + " :" + jcVar.b);
                if (jcVar.b == null) {
                    RandomAccessFile randomAccessFile2 = jcVar.d;
                    if (randomAccessFile2 != null) {
                        jg.a(randomAccessFile2);
                    }
                    set.remove(jcVar.c);
                }
                return jcVar;
            } catch (Throwable th) {
                if (jcVar.b == null) {
                    RandomAccessFile randomAccessFile3 = jcVar.d;
                    if (randomAccessFile3 != null) {
                        jg.a(randomAccessFile3);
                    }
                    e.remove(jcVar.c);
                }
                throw th;
            }
        } else {
            throw new IOException("abtain lock failure");
        }
    }

    public void a() {
        c.c("unLock: " + this.b);
        FileLock fileLock = this.b;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.b.release();
            } catch (IOException unused) {
            }
            this.b = null;
        }
        RandomAccessFile randomAccessFile = this.d;
        if (randomAccessFile != null) {
            jg.a(randomAccessFile);
        }
        e.remove(this.c);
    }
}
