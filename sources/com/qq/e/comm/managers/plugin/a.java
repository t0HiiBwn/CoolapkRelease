package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class a {
    private final File a;
    private final File b;
    private String c;
    private int d;

    public a(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    public static boolean a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            String str2 = Sig.ASSET_PLUGIN_SIG;
            if (str2 == null) {
                str2 = "";
            }
            StringUtil.writeTo("1203#####" + str2, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    int i3 = 0;
                    while (i3 < read) {
                        int i4 = i + 1;
                        if (i >= 64) {
                            bArr[i3] = (byte) (bArr[i3] ^ bytes[i2 % length]);
                            i2++;
                        }
                        i3++;
                        i = i4;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[Catch:{ all -> 0x004b }] */
    boolean a() {
        boolean z;
        try {
            if (this.b.exists() && this.a.exists()) {
                String[] split = StringUtil.readAll(this.b).split("#####");
                if (split.length == 2) {
                    String str = split[1];
                    int parseInteger = StringUtil.parseInteger(split[0], 0);
                    com.qq.e.comm.util.a a2 = com.qq.e.comm.util.a.a();
                    File file = this.a;
                    if (file != null) {
                        if (file.exists()) {
                            z = a2.b(str, Md5Util.encode(file));
                            if (z) {
                                this.c = str;
                                this.d = parseInteger;
                                return true;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.report("Exception while checking plugin", th);
            return false;
        }
    }

    boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return (file.equals(this.a) || FileUtil.renameTo(this.a, file)) && (file2.equals(this.b) || FileUtil.renameTo(this.b, file2));
    }

    int b() {
        return this.d;
    }

    String c() {
        return this.c;
    }
}
