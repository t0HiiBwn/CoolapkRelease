package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: TotalCountLruDiskFile */
public class c extends b {
    private int a = 15;
    private int b = 3;
    private volatile boolean c;

    public c(int i, int i2) {
        if (i > 0) {
            this.a = i;
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    public c(int i, int i2, boolean z) {
        if (i > 0) {
            this.a = i;
            this.b = i2;
            this.c = z;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(long j, int i) {
        return i <= this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected boolean a(File file, long j, int i) {
        return i <= this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        if (this.c) {
            d(list);
            this.c = false;
            return;
        }
        c(list);
    }

    private void c(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        if (!a(b2, size)) {
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b2 -= length;
                    u.c("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    u.c("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
                }
                if (a(file, b2, size)) {
                    return;
                }
            }
        }
    }

    private void d(List<File> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    long b2 = b(list);
                    int size = list.size();
                    boolean a2 = a(b2, size);
                    if (a2) {
                        u.c("splashLoadAd", "不满足删除条件，不执行删除操作(true)" + a2);
                        return;
                    }
                    TreeMap treeMap = new TreeMap();
                    for (File file : list) {
                        treeMap.put(Long.valueOf(file.lastModified()), file);
                    }
                    for (Map.Entry entry : treeMap.entrySet()) {
                        if (entry != null && !a2) {
                            u.f("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                            File file2 = (File) entry.getValue();
                            long length = file2.length();
                            if (file2.delete()) {
                                size--;
                                b2 -= length;
                                u.c("splashLoadAd", "删除 一个 Cache file 当前总个数：" + size);
                            } else {
                                u.f("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                            }
                            if (a(file2, b2, size)) {
                                u.c("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.a + " 最小个数 " + this.b);
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
