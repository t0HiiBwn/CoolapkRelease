package com.huawei.updatesdk.a.b.d;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.a.a.a.b;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.a.b.d.a.a;
import com.huawei.updatesdk.a.b.d.a.c;
import com.huawei.updatesdk.a.b.d.a.d;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends AsyncTask<c, Void, d> {
    protected c a = null;
    private d b = null;
    private a c = null;
    private com.huawei.updatesdk.a.a.a.b d = null;
    private int e = 0;
    private int f = 0;

    public b(c cVar, a aVar) {
        this.a = cVar;
        this.c = aVar;
    }

    private d a(String str, String str2, d dVar) {
        try {
            dVar.fromJson(new JSONObject(str2));
            dVar.a(0);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | JSONException e2) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "parse json error", e2);
        }
        return dVar;
    }

    private void a(d dVar, int i, d.a aVar, Throwable th) {
        if (dVar != null) {
            dVar.a(i);
            dVar.a(aVar);
            dVar.a(th.toString());
        }
    }

    private void a(d dVar, Throwable th, String str) {
        d.a aVar;
        int i;
        d.a aVar2;
        if (th instanceof ConnectException) {
            aVar = d.a.CONNECT_EXCEPTION;
        } else if (!(th instanceof SocketTimeoutException) && !(th instanceof ConnectTimeoutException)) {
            if (th instanceof IllegalArgumentException) {
                i = 5;
                aVar2 = d.a.PARAM_ERROR;
            } else if (th instanceof IllegalAccessException) {
                aVar = d.a.UNKNOWN_EXCEPTION;
            } else if (th instanceof ArrayIndexOutOfBoundsException) {
                i = 6;
                aVar2 = d.a.NO_PROGUARD;
            } else if ((th instanceof InterruptedException) || (th instanceof InterruptedIOException)) {
                a(dVar, 0, d.a.NORMAL, th);
                Log.e("StoreTask", "UpdateSDK task is canceled");
                a(str, th);
            } else if (th instanceof IOException) {
                aVar = d.a.IO_EXCEPTION;
            } else {
                if (dVar != null) {
                    dVar.a(th.toString());
                }
                a(str, th);
            }
            a(dVar, i, aVar2, th);
            a(str, th);
        } else {
            a(dVar, 2, d.a.CONNECT_EXCEPTION, th);
            a(str, th);
        }
        a(dVar, 1, aVar, th);
        a(str, th);
    }

    private void a(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("invoke store error");
        sb.append(", exceptionType:");
        sb.append(th.toString());
        sb.append(", url:");
        sb.append(str);
        sb.append(", method:");
        sb.append(this.a.a());
        sb.append(", retryTimes:" + this.e);
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", sb.toString(), th);
        Log.e("StoreTask", "UpdateSDK call store error: " + th.toString());
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) || !g.b(str);
    }

    private void b(String str) {
        Log.e("StoreTask", TextUtils.isEmpty(str) ? "UpdateSDK response error, resData == null" : "UpdateSDK response error, resData is not json string");
    }

    private boolean c(d dVar) {
        if (isCancelled()) {
            return false;
        }
        if (dVar.a() != 1 && dVar.a() != 2) {
            return false;
        }
        int i = this.e;
        this.e = i + 1;
        if (i >= 3) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "retry completed total times = " + this.e + ",response.responseCode = " + dVar.a());
            return false;
        }
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "retry times = " + this.e + ",response.responseCode = " + dVar.a());
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    private void d(d dVar) {
        d.a aVar;
        StringBuilder sb;
        Throwable e2;
        if (!isCancelled() && this.c != null) {
            if (dVar == null) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("StoreTask", "notifyResult, response is null");
                try {
                    dVar = a.a(this.a.a());
                } catch (InstantiationException e3) {
                    e2 = e3;
                    sb = new StringBuilder();
                } catch (IllegalAccessException e4) {
                    e2 = e4;
                    sb = new StringBuilder();
                }
                if (dVar != null) {
                    dVar = new d();
                    aVar = d.a.PARAM_ERROR;
                } else {
                    aVar = d.a.UNKNOWN_EXCEPTION;
                }
                dVar.a(aVar);
                dVar.a(1);
            }
            this.c.b(this.a, dVar);
        }
        return;
        sb.append("notifyResult, create response error, method:");
        sb.append(this.a.a());
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", sb.toString(), e2);
        if (dVar != null) {
        }
        dVar.a(aVar);
        dVar.a(1);
        this.c.b(this.a, dVar);
    }

    private void e() {
        d(this.b);
    }

    public final d a() {
        d dVar = null;
        do {
            if (this.e > 0 && dVar != null) {
                com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "call store error! responseCode:" + dVar.a() + ", retryTimes:" + this.e);
            }
            dVar = b();
            a(dVar);
        } while (c(dVar));
        this.b = dVar;
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public d doInBackground(c... cVarArr) {
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "doInBackground, method:" + this.a.a());
        com.huawei.updatesdk.service.d.a.b.a(this);
        d a2 = a();
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this.a, a2);
        }
        return a2;
    }

    public void a(d dVar) {
    }

    public final void a(Executor executor) {
        executeOnExecutor(executor, this.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    protected d b() {
        d dVar;
        String str;
        Throwable th;
        d dVar2 = null;
        try {
            dVar = a.a(this.a.a());
            try {
                if (!com.huawei.updatesdk.a.a.c.b.b.a(com.huawei.updatesdk.a.b.a.a.a().b())) {
                    dVar.a(3);
                    dVar.a(d.a.NO_NETWORK);
                } else {
                    String b2 = this.a.b();
                    String d2 = this.a.d();
                    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "callStore, method:" + this.a.a() + ", url:" + d2 + ", body:" + b2);
                    com.huawei.updatesdk.a.a.a.b bVar = new com.huawei.updatesdk.a.a.a.b();
                    this.d = bVar;
                    b.a a2 = bVar.a(d2, b2, "UTF-8", c(), com.huawei.updatesdk.a.b.a.a.a().b());
                    String a3 = a2.a();
                    dVar.b(a2.b());
                    Log.i("StoreTask", "UpdateSDK call store responsecode: " + dVar.b());
                    if (a2.b() / 100 == 5) {
                        dVar.a(0);
                        return dVar;
                    } else if (a(a3)) {
                        dVar.a(1);
                        dVar.a(d.a.JSON_ERROR);
                        b(a3);
                    } else {
                        dVar = a(b2, a3, dVar);
                        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "callStore response, method:" + this.a.a() + ", url:" + d2 + ", body:" + b2 + ", Receive Json msg:" + dVar.toJson());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
                dVar2 = dVar;
                a(dVar2, th, str);
                dVar = dVar2;
                if (dVar != null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            a(dVar2, th, str);
            dVar = dVar2;
            if (dVar != null) {
            }
        }
        if (dVar != null) {
            return dVar;
        }
        d dVar3 = new d();
        dVar3.a(5);
        dVar3.a(d.a.PARAM_ERROR);
        return dVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(d dVar) {
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "onPostExecute, method:" + this.a.a());
        com.huawei.updatesdk.service.d.a.b.a().remove(this);
        e();
    }

    protected String c() {
        String a2 = com.huawei.updatesdk.service.d.a.a.a();
        return TextUtils.isEmpty(a2) ? "Android/1.0" : a2;
    }

    public void d() {
        com.huawei.updatesdk.a.a.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a();
            this.d = null;
        }
    }
}
