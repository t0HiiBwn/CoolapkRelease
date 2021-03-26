package com.umeng.analytics.pro;

import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer */
public class bl {
    private final ch a;
    private final cu b;

    public bl() {
        this(new cb.a());
    }

    public bl(cj cjVar) {
        cu cuVar = new cu();
        this.b = cuVar;
        this.a = cjVar.a(cuVar);
    }

    public void a(bi biVar, byte[] bArr) throws bo {
        try {
            this.b.a(bArr);
            biVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(bi biVar, String str, String str2) throws bo {
        try {
            a(biVar, str.getBytes(str2));
            this.a.B();
        } catch (UnsupportedEncodingException unused) {
            throw new bo("JVM DOES NOT SUPPORT ENCODING: " + str2);
        } catch (Throwable th) {
            this.a.B();
            throw th;
        }
    }

    public void a(bi biVar, byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        try {
            if (j(bArr, bpVar, bpVarArr) != null) {
                biVar.read(this.a);
            }
            this.b.e();
            this.a.B();
        } catch (Exception e) {
            throw new bo(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    public Boolean a(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Boolean) a((byte) 2, bArr, bpVar, bpVarArr);
    }

    public Byte b(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Byte) a((byte) 3, bArr, bpVar, bpVarArr);
    }

    public Double c(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Double) a((byte) 4, bArr, bpVar, bpVarArr);
    }

    public Short d(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Short) a((byte) 6, bArr, bpVar, bpVarArr);
    }

    public Integer e(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Integer) a((byte) 8, bArr, bpVar, bpVarArr);
    }

    public Long f(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (Long) a((byte) 10, bArr, bpVar, bpVarArr);
    }

    public String g(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (String) a((byte) 11, bArr, bpVar, bpVarArr);
    }

    public ByteBuffer h(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        return (ByteBuffer) a((byte) 100, bArr, bpVar, bpVarArr);
    }

    public Short i(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        Short sh;
        try {
            if (j(bArr, bpVar, bpVarArr) != null) {
                this.a.j();
                sh = Short.valueOf(this.a.l().c);
            } else {
                sh = null;
            }
            this.b.e();
            this.a.B();
            return sh;
        } catch (Exception e) {
            throw new bo(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    private Object a(byte b2, byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        Object obj;
        try {
            cc j = j(bArr, bpVar, bpVarArr);
            if (j != null) {
                if (b2 != 2) {
                    if (b2 != 3) {
                        if (b2 != 4) {
                            if (b2 != 6) {
                                if (b2 != 8) {
                                    if (b2 != 100) {
                                        if (b2 != 10) {
                                            if (b2 == 11) {
                                                if (j.b == 11) {
                                                    obj = this.a.z();
                                                    this.b.e();
                                                    this.a.B();
                                                    return obj;
                                                }
                                            }
                                        } else if (j.b == 10) {
                                            obj = Long.valueOf(this.a.x());
                                            this.b.e();
                                            this.a.B();
                                            return obj;
                                        }
                                    } else if (j.b == 11) {
                                        obj = this.a.A();
                                        this.b.e();
                                        this.a.B();
                                        return obj;
                                    }
                                } else if (j.b == 8) {
                                    obj = Integer.valueOf(this.a.w());
                                    this.b.e();
                                    this.a.B();
                                    return obj;
                                }
                            } else if (j.b == 6) {
                                obj = Short.valueOf(this.a.v());
                                this.b.e();
                                this.a.B();
                                return obj;
                            }
                        } else if (j.b == 4) {
                            obj = Double.valueOf(this.a.y());
                            this.b.e();
                            this.a.B();
                            return obj;
                        }
                    } else if (j.b == 3) {
                        obj = Byte.valueOf(this.a.u());
                        this.b.e();
                        this.a.B();
                        return obj;
                    }
                } else if (j.b == 2) {
                    obj = Boolean.valueOf(this.a.t());
                    this.b.e();
                    this.a.B();
                    return obj;
                }
            }
            obj = null;
            this.b.e();
            this.a.B();
            return obj;
        } catch (Exception e) {
            throw new bo(e);
        } catch (Throwable th) {
            this.b.e();
            this.a.B();
            throw th;
        }
    }

    private cc j(byte[] bArr, bp bpVar, bp... bpVarArr) throws bo {
        this.b.a(bArr);
        int length = bpVarArr.length + 1;
        bp[] bpVarArr2 = new bp[length];
        int i = 0;
        bpVarArr2[0] = bpVar;
        int i2 = 0;
        while (i2 < bpVarArr.length) {
            int i3 = i2 + 1;
            bpVarArr2[i3] = bpVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        cc ccVar = null;
        while (i < length) {
            ccVar = this.a.l();
            if (ccVar.b == 0 || ccVar.c > bpVarArr2[i].a()) {
                return null;
            }
            if (ccVar.c != bpVarArr2[i].a()) {
                ck.a(this.a, ccVar.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return ccVar;
    }

    public void a(bi biVar, String str) throws bo {
        a(biVar, str.getBytes());
    }
}
