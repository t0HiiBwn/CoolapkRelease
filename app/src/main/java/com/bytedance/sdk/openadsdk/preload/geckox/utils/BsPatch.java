package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import java.io.File;
import java.io.FileNotFoundException;

public class BsPatch {
    private static native int patch(String str, String str2, String str3) throws Exception;

    static {
        g.a("geckox_bspatch");
    }

    public static void a(File file, File file2, File file3, String str) throws Exception {
        if (!file.exists()) {
            throw new FileNotFoundException("full package not exist：" + file.getAbsolutePath());
        } else if (file2.exists()) {
            file3.mkdirs();
            File file4 = new File(file3, str);
            file4.delete();
            int patch = patch(file.getAbsolutePath(), file4.getAbsolutePath(), file2.getAbsolutePath());
            if (patch != 0) {
                throw new RuntimeException("patch merged failed, code：" + patch + " full:" + file.getAbsolutePath() + " patch:" + file2.getAbsolutePath() + " dest:" + file4.getAbsolutePath());
            }
        } else {
            throw new FileNotFoundException("patch package not exist：" + file2.getAbsolutePath());
        }
    }
}
