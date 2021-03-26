package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1049a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1050a;

    /* renamed from: a  reason: collision with other field name */
    private String f1051a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1052a;

    private u(Context context) {
        this.f1049a = context;
    }

    /* JADX INFO: finally extract failed */
    public static u a(Context context, File file) {
        b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = a;
        if (set.add(str)) {
            u uVar = new u(context);
            uVar.f1051a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                uVar.f1050a = randomAccessFile;
                uVar.f1052a = randomAccessFile.getChannel().lock();
                b.c("Locked: " + str + " :" + uVar.f1052a);
                if (uVar.f1052a == null) {
                    RandomAccessFile randomAccessFile2 = uVar.f1050a;
                    if (randomAccessFile2 != null) {
                        y.a(randomAccessFile2);
                    }
                    set.remove(uVar.f1051a);
                }
                return uVar;
            } catch (Throwable th) {
                if (uVar.f1052a == null) {
                    RandomAccessFile randomAccessFile3 = uVar.f1050a;
                    if (randomAccessFile3 != null) {
                        y.a(randomAccessFile3);
                    }
                    a.remove(uVar.f1051a);
                }
                throw th;
            }
        } else {
            throw new IOException("abtain lock failure");
        }
    }

    public void a() {
        b.c("unLock: " + this.f1052a);
        FileLock fileLock = this.f1052a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1052a.release();
            } catch (IOException unused) {
            }
            this.f1052a = null;
        }
        RandomAccessFile randomAccessFile = this.f1050a;
        if (randomAccessFile != null) {
            y.a(randomAccessFile);
        }
        a.remove(this.f1051a);
    }
}
