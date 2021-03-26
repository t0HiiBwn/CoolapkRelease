package com.amap.api.col.s;

import com.amap.api.col.s.cp;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* compiled from: LogEngine */
public final class db {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    public static void a(String str, byte[] bArr, da daVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        cp cpVar;
        OutputStream outputStream = null;
        try {
            if (!a(daVar.a, str)) {
                File file = new File(daVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cpVar = cp.a(file, daVar.b);
                try {
                    cpVar.a(daVar.d);
                    byte[] b = daVar.e.b(bArr);
                    cp.a b2 = cpVar.b(str);
                    outputStream = b2.a();
                    outputStream.write(b);
                    b2.b();
                    cpVar.b();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (cpVar != null) {
                        try {
                            cpVar.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    if (cpVar != null) {
                        try {
                            cpVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            cpVar = null;
            if (outputStream != null) {
            }
            if (cpVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a1  */
    public static int a(da daVar) {
        Throwable th;
        cp cpVar = null;
        try {
            if (daVar.f.c()) {
                daVar.f.a(true);
                cp a = cp.a(new File(daVar.a), daVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(a, daVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            JSONObject jSONObject = new JSONObject(new String(cs.a().b(new cf(a2, daVar.c))));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                cpVar = a;
                            } else {
                                if (!(daVar.f == null || a2 == null)) {
                                    daVar.f.a(a2.length);
                                }
                                if (daVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    try {
                                        a.c();
                                    } catch (Throwable th2) {
                                        cg.c(th2, "ofm", "dlo");
                                    }
                                }
                                return a2.length;
                            }
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th4) {
                    th = th4;
                    cpVar = a;
                    try {
                        cg.c(th, "leg", "uts");
                        if (cpVar != null) {
                        }
                        return -1;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (cpVar != null) {
                try {
                    cpVar.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            cg.c(th, "leg", "uts");
            if (cpVar != null) {
                cpVar.close();
            }
            return -1;
        }
        return -1;
        throw th;
    }

    private static byte[] a(cp cpVar, da daVar, List<String> list) {
        try {
            File a = cpVar.a();
            if (a != null && a.exists()) {
                String[] list2 = a.list();
                int i = 0;
                for (String str : list2) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a2 = dg.a(cpVar, str2);
                        i += a2.length;
                        list.add(str2);
                        if (i > daVar.f.b()) {
                            break;
                        }
                        daVar.g.b(a2);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return daVar.g.a();
            }
        } catch (Throwable th) {
            cg.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(cp cpVar, List<String> list) {
        if (cpVar != null) {
            try {
                for (String str : list) {
                    cpVar.c(str);
                }
                cpVar.close();
            } catch (Throwable th) {
                cg.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            cg.c(th, "leg", "fet");
            return false;
        }
    }
}
