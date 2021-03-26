package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBFileTraversalUtil {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static FileLockUtil b = new FileLockUtil();

    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final a aVar) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            a.execute(new Runnable() {
                /* class com.umeng.analytics.process.DBFileTraversalUtil.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        File[] listFiles = file.listFiles();
                        for (File file : listFiles) {
                            if (file.getName().endsWith(".db")) {
                                DBFileTraversalUtil.b.doFileOperateion(file, fileLockCallback);
                                UMRTLog.i("MobclickRT", "--->>> file: " + file.getName());
                            }
                        }
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.i("MobclickRT", "--->>> end *** ");
                }
            });
        }
    }
}
