package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.col.s.ad;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: BasicHandler */
public abstract class a<T, V> extends bp {
    protected boolean a = true;
    protected T b;
    protected int c = 1;
    protected String d = "";
    protected Context e;
    protected String f = "";
    private int j = 1;

    protected abstract V a(String str) throws AMapException;

    protected abstract String a();

    @Override // com.amap.api.col.s.cy
    public final String c() {
        return "sea";
    }

    protected ad.b d() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public Map<String, String> e() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public Map<String, String> f() {
        return null;
    }

    public a(Context context, T t) {
        this.e = context;
        this.b = t;
        this.c = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    private String i() {
        String a_ = a_();
        if (a_ == null) {
            return null;
        }
        try {
            int indexOf = a_.indexOf(".com/");
            int indexOf2 = a_.indexOf("?");
            if (indexOf2 == -1) {
                return a_.substring(indexOf + 5);
            }
            return a_.substring(indexOf + 5, indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    protected V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.b(str);
        return a(str);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0043: INVOKE  (r5v3 int) = (r0v2 'e' com.amap.api.services.core.AMapException) type: VIRTUAL call: com.amap.api.services.core.AMapException.getErrorCode():int)] */
    public final V b() throws AMapException {
        String str;
        if (this.b == null) {
            return null;
        }
        try {
            return l();
        } catch (AMapException e2) {
            String i = i();
            String str2 = this.f;
            if (i != null) {
                String errorType = e2.getErrorType();
                if (e2.getErrorLevel() == 0) {
                    int errorCode = e2.getErrorCode();
                    if (errorCode == 0) {
                        str = "4";
                    } else {
                        int pow = (int) Math.pow(10.0d, Math.floor(Math.log10((double) errorCode)));
                        str = String.valueOf((errorCode % pow) + (pow * 4));
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(e2.getErrorCode());
                    str = sb.toString();
                }
                if (str != null && str.length() > 0) {
                    cg.a(h.a(true), i, errorType, str2, str);
                }
            }
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c0 A[SYNTHETIC, Splitter:B:52:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e2 A[SYNTHETIC, Splitter:B:59:0x00e2] */
    private V l() throws AMapException {
        Object obj;
        Throwable th;
        bh e2;
        AMapException e3;
        ad a2;
        byte[] bArr;
        ad.c a3;
        try {
            ad.b d2 = d();
            boolean b2 = ad.a().b(d2);
            boolean z = false;
            int i = 0;
            V v = null;
            boolean z2 = false;
            while (i < this.c) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    int protocol = ServiceSettings.getInstance().getProtocol();
                    bo.a().a(this.e);
                    cx b3 = cx.b();
                    if (!(!b2 || (a3 = ad.a().a(d2)) == null || a3.a == null)) {
                        v = (V) a3.a;
                        try {
                            am.a(this.e, d2.a, a3.b);
                            z2 = true;
                        } catch (bh e4) {
                            e2 = e4;
                            z2 = true;
                            am.a(this.e, i(), System.currentTimeMillis() - currentTimeMillis, z);
                            i++;
                            if (i >= this.c) {
                                try {
                                    Thread.sleep((long) (this.j * 1000));
                                    if (b2 && !z2) {
                                        ad.a().a(d2, v);
                                    }
                                    z = false;
                                } catch (InterruptedException unused) {
                                    if ("http连接失败 - ConnectionException".equals(e2.getMessage()) || "socket 连接异常 - SocketException".equals(e2.getMessage()) || "服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                                        throw new AMapException("http或socket连接失败 - ConnectionException", 1, e2.c());
                                    }
                                    throw new AMapException(e2.a(), 1, e2.c());
                                }
                            } else if ("http连接失败 - ConnectionException".equals(e2.getMessage()) || "socket 连接异常 - SocketException".equals(e2.getMessage()) || "未知的错误".equals(e2.a()) || "服务器连接失败 - UnknownServiceException".equals(e2.getMessage())) {
                                throw new AMapException("http或socket连接失败 - ConnectionException", 1, e2.c());
                            } else {
                                throw new AMapException(e2.a(), 1, e2.c());
                            }
                        } catch (AMapException e5) {
                            e3 = e5;
                            z2 = true;
                            try {
                                am.a(this.e, i(), System.currentTimeMillis() - currentTimeMillis, z);
                                i++;
                                if (i >= this.c) {
                                    if (b2 && !z2) {
                                        a2 = ad.a();
                                        a2.a(d2, v);
                                    }
                                    z = false;
                                } else {
                                    try {
                                        throw e3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = v;
                                ad.a().a(d2, obj);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj = v;
                            z2 = true;
                            if (b2 && !z2) {
                                ad.a().a(d2, obj);
                            }
                            throw th;
                        }
                    }
                    if (v == null) {
                        if (protocol == 1) {
                            if (this.a) {
                                bArr = b3.b(this);
                            } else {
                                bArr = cx.d(this);
                            }
                        } else if (protocol != 2) {
                            bArr = null;
                        } else if (this.a) {
                            bArr = cx.a(this);
                        } else {
                            bArr = cx.e(this);
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        v = a(bArr);
                        am.a(this.e, i(), currentTimeMillis2 - currentTimeMillis, true);
                    }
                    i = this.c;
                    if (b2 && !z2) {
                        a2 = ad.a();
                        a2.a(d2, v);
                    }
                } catch (bh e6) {
                    e2 = e6;
                    am.a(this.e, i(), System.currentTimeMillis() - currentTimeMillis, z);
                    i++;
                    if (i >= this.c) {
                    }
                } catch (AMapException e7) {
                    e3 = e7;
                    am.a(this.e, i(), System.currentTimeMillis() - currentTimeMillis, z);
                    i++;
                    if (i >= this.c) {
                    }
                }
                z = false;
            }
            return v;
        } catch (AMapException e8) {
            throw e8;
        } catch (Throwable th5) {
            th5.printStackTrace();
            throw new AMapException("未知错误");
        }
    }
}
