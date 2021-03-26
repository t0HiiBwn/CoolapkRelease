package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.utils.l;
import java.io.File;
import java.util.List;

/* compiled from: TotalCountLruDiskDir */
public class c extends com.bytedance.sdk.openadsdk.b.c {
    public c(int i, int i2) {
        super(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.b.c, com.bytedance.sdk.openadsdk.b.b
    protected void a(List<File> list) {
        int size = list.size();
        if (!a(0, size)) {
            for (File file : list) {
                l.c(file);
                size--;
                if (a(file, 0, size)) {
                    return;
                }
            }
        }
    }
}
