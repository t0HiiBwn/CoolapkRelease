package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;

final class d {
    private static String a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");
    private static String b = SystemUtil.buildNewPathByProcessName("e_qq_com_dex");

    static File a(Context context) {
        return context.getDir(b, 0);
    }

    static File b(Context context) {
        return new File(i(context), "gdt_plugin.jar");
    }

    static File c(Context context) {
        return new File(i(context), "gdt_plugin.tmp");
    }

    static File d(Context context) {
        return new File(i(context), "gdt_plugin.next");
    }

    static File e(Context context) {
        return new File(i(context), "gdt_plugin.jar.sig");
    }

    static File f(Context context) {
        return new File(i(context), "gdt_plugin.tmp.sig");
    }

    static File g(Context context) {
        return new File(i(context), "gdt_plugin.next.sig");
    }

    static File h(Context context) {
        return new File(i(context), "update_lc");
    }

    private static File i(Context context) {
        return context.getDir(a, 0);
    }
}
