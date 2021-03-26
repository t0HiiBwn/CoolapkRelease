package com.huawei.hms.stats;

import com.huawei.hms.stats.e;
import java.io.File;
import java.io.IOException;

public class al {
    private String a = b.j().getFilesDir().getPath();

    al() {
    }

    private String a(String str) {
        String b = b(str);
        File file = new File(b, "hianalytics_" + str);
        if (a(file)) {
            return ba.a(file);
        }
        String b2 = e.a().b(e.a.RSA);
        ba.a(file, b2);
        return b2;
    }

    private void a(String str, String str2) {
        File file = new File(b(str));
        String b = b(str);
        File file2 = new File(b, "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            af.b("ComponentManager", "file directory is mkdirs");
        }
        if (a(file2)) {
            ba.a(file2, str2);
        } else {
            af.c("ComponentManager", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            af.c("ComponentManager", "create new file error!");
            return false;
        }
    }

    private char[] a(String str, String str2, String str3, String str4) {
        byte[] b = e.a().b(str);
        byte[] b2 = e.a().b(str2);
        byte[] b3 = e.a().b(str3);
        byte[] b4 = e.a().b(str4);
        int length = b.length;
        if (length > b2.length) {
            length = b2.length;
        }
        if (length > b3.length) {
            length = b3.length;
        }
        if (length > b4.length) {
            length = b4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((b[i] ^ b2[i]) ^ b3[i]) ^ b4[i]);
        }
        return cArr;
    }

    private String b(String str) {
        return this.a + "/hms/component/".replace("component", str);
    }

    private boolean b() {
        long b = ap.b(b.j(), "Privacy_MY", "assemblyFlash", -1);
        if (-1 != b) {
            return System.currentTimeMillis() - b > 31536000000L;
        }
        af.b("ComponentManager", "First init components");
        return true;
    }

    private String c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() {
        String str;
        String str2;
        String str3;
        String str4;
        String c = c();
        if (b()) {
            af.b("ComponentManager", "refresh components");
            str4 = e.a().b(e.a.RSA);
            a("aprpap", str4);
            str = e.a().b(e.a.RSA);
            a("febdoc", str);
            str2 = e.a().b(e.a.RSA);
            a("marfil", str2);
            str3 = e.a().b(e.a.RSA);
            a("maywnj", str3);
            ap.a(b.j(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            str4 = a("aprpap");
            str = a("febdoc");
            str2 = a("marfil");
            str3 = a("maywnj");
        }
        return e.a().a(a(str4, str, str2, c), e.a().b(str3));
    }
}
