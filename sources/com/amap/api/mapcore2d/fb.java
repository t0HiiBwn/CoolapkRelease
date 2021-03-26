package com.amap.api.mapcore2d;

import com.amap.api.mapcore2d.em;
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
public class fb {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[SYNTHETIC, Splitter:B:25:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[SYNTHETIC, Splitter:B:30:0x0063] */
    public static void a(String str, byte[] bArr, fa faVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        em emVar;
        OutputStream outputStream = null;
        try {
            if (!a(faVar.a, str)) {
                File file = new File(faVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                emVar = em.a(file, 1, 1, faVar.b);
                try {
                    emVar.a(faVar.d);
                    byte[] b = faVar.e.b(bArr);
                    em.a b2 = emVar.b(str);
                    outputStream = b2.a(0);
                    outputStream.write(b);
                    b2.a();
                    emVar.d();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (emVar != null) {
                        try {
                            emVar.close();
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
                    if (emVar != null) {
                        try {
                            emVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            emVar = null;
            if (outputStream != null) {
            }
            if (emVar != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    public static void a(fa faVar) {
        Throwable th;
        em emVar = null;
        try {
            if (faVar.f.c()) {
                faVar.f.a(true);
                em a = em.a(new File(faVar.a), 1, 1, faVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(a, faVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            JSONObject jSONObject = new JSONObject(new String(er.a().b(new dn(a2, faVar.c))));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                emVar = a;
                            } else {
                                if (!(faVar.f == null || a2 == null)) {
                                    faVar.f.a(a2.length);
                                }
                                if (faVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    a(a);
                                }
                            }
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                            return;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    emVar = a;
                    try {
                        Cdo.c(th, "leg", "uts");
                        if (emVar == null) {
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
            if (emVar != null) {
                try {
                    emVar.close();
                    return;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return;
                }
            } else {
                return;
            }
        } catch (Throwable th6) {
            th = th6;
            Cdo.c(th, "leg", "uts");
            if (emVar == null) {
                emVar.close();
                return;
            }
            return;
        }
        throw th;
    }

    private static byte[] a(em emVar, fa faVar, List<String> list) {
        try {
            File c = emVar.c();
            if (c != null && c.exists()) {
                String[] list2 = c.list();
                int length = list2.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = list2[i];
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = fh.a(emVar, str2, false);
                        i2 += a.length;
                        list.add(str2);
                        if (i2 > faVar.f.b()) {
                            break;
                        }
                        faVar.g.b(a);
                    }
                    i++;
                }
                return faVar.g.a();
            }
        } catch (Throwable th) {
            Cdo.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(em emVar) {
        if (emVar != null) {
            try {
                emVar.e();
            } catch (Throwable th) {
                Cdo.c(th, "ofm", "dlo");
            }
        }
    }

    private static void a(em emVar, List<String> list) {
        if (emVar != null) {
            try {
                for (String str : list) {
                    emVar.c(str);
                }
                emVar.close();
            } catch (Throwable th) {
                Cdo.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            Cdo.c(th, "leg", "fet");
            return false;
        }
    }
}
