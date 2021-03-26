package com.bytedance.sdk.openadsdk.preload.geckox.a;

import com.bytedance.sdk.openadsdk.preload.geckox.g.a;
import com.bytedance.sdk.openadsdk.preload.geckox.g.b;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.j;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChannelCleanHelper */
public class c {
    public static void a(final String str) {
        j.a().execute(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.a.c.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.d(str);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException("delete old channel version failed，path：" + str, th));
                }
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static void d(String str) throws Exception {
        a a = a.a(str + File.separator + "update.lock");
        if (a != null) {
            try {
                b a2 = b.a(str + File.separator + "select.lock");
                try {
                    List<File> e = e(str);
                    if (e != null) {
                        if (!e.isEmpty()) {
                            Iterator<File> it2 = e.iterator();
                            while (it2.hasNext()) {
                                com.bytedance.sdk.openadsdk.preload.geckox.g.c.c(it2.next().getAbsolutePath() + File.separator + "using.lock");
                            }
                            a2.a();
                            a.a();
                            return;
                        }
                    }
                    a2.a();
                } catch (Throwable th) {
                    a2.a();
                    throw th;
                }
            } finally {
                a.a();
            }
        }
    }

    public static boolean b(String str) {
        try {
            a a = a.a(str + File.separator + "update.lock");
            if (a == null) {
                return true;
            }
            try {
                b a2 = b.a(str + File.separator + "select.lock");
                try {
                    d.c(new File(str));
                } catch (Throwable unused) {
                }
                a2.a();
                return true;
            } finally {
                a.a();
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static List<File> e(String str) {
        File[] listFiles = new File(str).listFiles(new FileFilter() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.a.c.AnonymousClass2 */

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        if (listFiles == null || listFiles.length == 0 || listFiles.length == 1) {
            return null;
        }
        return a(listFiles);
    }

    private static List<File> a(File[] fileArr) {
        long j;
        ArrayList<File> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File file = null;
        long j2 = -1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file2);
            } else if (name.endsWith("--pending-delete")) {
                a(file2);
            } else {
                try {
                    long parseLong = Long.parseLong(name);
                    if (parseLong > j2) {
                        if (file != null) {
                            try {
                                arrayList2.add(file);
                            } catch (Exception unused) {
                                j2 = parseLong;
                            }
                        }
                        file = file2;
                        j2 = parseLong;
                    } else {
                        arrayList2.add(file2);
                    }
                } catch (Exception unused2) {
                    a(file2);
                }
            }
        }
        for (File file3 : arrayList) {
            String name2 = file3.getName();
            int indexOf = name2.indexOf("--updating");
            if (indexOf == -1) {
                a(file3);
            } else {
                try {
                    j = Long.parseLong(name2.substring(0, indexOf));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (j <= j2) {
                    a(file3);
                }
            }
        }
        return arrayList2;
    }

    private static void a(final File file) {
        f.a().execute(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.preload.geckox.a.c.AnonymousClass3 */

            @Override // java.lang.Runnable
            public void run() {
                d.a(file);
            }
        });
    }
}
