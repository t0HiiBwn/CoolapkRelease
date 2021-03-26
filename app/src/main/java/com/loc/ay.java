package com.loc;

import com.loc.ao;
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
public final class ay {
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
    public static int a(ax axVar) {
        Throwable th;
        ao aoVar = null;
        try {
            if (axVar.f.c()) {
                axVar.f.a(true);
                ao a = ao.a(new File(axVar.a), axVar.b);
                try {
                    ArrayList arrayList = new ArrayList();
                    byte[] a2 = a(a, axVar, arrayList);
                    if (a2 != null) {
                        if (a2.length != 0) {
                            aa aaVar = new aa(a2, axVar.c);
                            aq.a();
                            JSONObject jSONObject = new JSONObject(new String(aq.b(aaVar)));
                            if (!jSONObject.has("code") || jSONObject.getInt("code") != 1) {
                                aoVar = a;
                            } else {
                                if (!(axVar.f == null || a2 == null)) {
                                    axVar.f.a(a2.length);
                                }
                                if (axVar.f.b() < Integer.MAX_VALUE) {
                                    a(a, arrayList);
                                } else {
                                    try {
                                        a.d();
                                    } catch (Throwable th2) {
                                        ab.b(th2, "ofm", "dlo");
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
                    aoVar = a;
                    try {
                        ab.b(th, "leg", "uts");
                        if (aoVar != null) {
                        }
                        return -1;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (aoVar != null) {
                try {
                    aoVar.close();
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
            }
        } catch (Throwable th7) {
            th = th7;
            ab.b(th, "leg", "uts");
            if (aoVar != null) {
                aoVar.close();
            }
            return -1;
        }
        return -1;
        throw th;
    }

    private static void a(ao aoVar, List<String> list) {
        if (aoVar != null) {
            try {
                for (String str : list) {
                    aoVar.c(str);
                }
                aoVar.close();
            } catch (Throwable th) {
                ab.b(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    public static void a(String str, byte[] bArr, ax axVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Throwable th;
        ao aoVar;
        OutputStream outputStream = null;
        try {
            if (!a(axVar.a, str)) {
                File file = new File(axVar.a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                aoVar = ao.a(file, axVar.b);
                try {
                    aoVar.a(axVar.d);
                    byte[] b = axVar.e.b(bArr);
                    ao.a b2 = aoVar.b(str);
                    outputStream = b2.a();
                    outputStream.write(b);
                    b2.b();
                    aoVar.c();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (aoVar != null) {
                        try {
                            aoVar.close();
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
                    if (aoVar != null) {
                        try {
                            aoVar.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            aoVar = null;
            if (outputStream != null) {
            }
            if (aoVar != null) {
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            ab.b(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] a(ao aoVar, ax axVar, List<String> list) {
        try {
            File b = aoVar.b();
            if (b != null && b.exists()) {
                String[] list2 = b.list();
                int i = 0;
                for (String str : list2) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a = bd.a(aoVar, str2);
                        i += a.length;
                        list.add(str2);
                        if (i > axVar.f.b()) {
                            break;
                        }
                        axVar.g.b(a);
                    }
                }
                if (i <= 0) {
                    return null;
                }
                return axVar.g.a();
            }
        } catch (Throwable th) {
            ab.b(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
