package com.ss.android.downloadad.a.b;

import com.ss.android.a.a.b.a;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadad.a.a.a;
import com.ss.android.downloadad.a.a.b;
import com.ss.android.downloadad.a.a.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: NativeDownloadModel */
public class b implements a {
    private long A;
    private int B;
    private int C;
    private String D;
    private boolean E;
    private String F;
    private boolean G;
    private boolean H;
    private String I;
    private String J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private String S;
    private boolean T;
    private boolean U;
    private boolean V;
    private long W;
    private transient boolean X;
    private boolean Y;
    private boolean Z;
    public final AtomicBoolean a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    public final AtomicBoolean b;
    private long c;
    private long d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    /* renamed from: l  reason: collision with root package name */
    private int f1400l;
    private int m;
    private int n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private long s;
    private JSONObject t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private long y;
    private long z;

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject k() {
        return null;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public List<String> n() {
        return null;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public Object o() {
        return null;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject p() {
        return null;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject r() {
        return null;
    }

    private b() {
        this.f = 1;
        this.r = true;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.E = false;
        this.G = false;
        this.H = true;
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.N = 1;
        this.Q = true;
        this.W = -1;
    }

    public b(c cVar, com.ss.android.a.a.b.b bVar, a aVar) {
        this(cVar, bVar, aVar, 0);
    }

    public b(c cVar, com.ss.android.a.a.b.b bVar, a aVar, int i2) {
        this.f = 1;
        this.r = true;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.E = false;
        this.G = false;
        this.H = true;
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.N = 1;
        this.Q = true;
        this.W = -1;
        this.c = cVar.d();
        this.d = cVar.g();
        this.e = cVar.u();
        this.g = cVar.v();
        this.t = cVar.z();
        this.r = cVar.t();
        this.n = cVar.r();
        this.o = cVar.s();
        this.h = cVar.a();
        if (cVar.x() != null) {
            this.i = cVar.x().b();
            this.j = cVar.x().a();
        }
        this.k = cVar.A();
        this.p = cVar.h();
        this.q = cVar.w();
        this.F = cVar.i();
        this.I = bVar.b();
        this.J = bVar.a();
        this.K = bVar.m();
        this.v = aVar.c();
        this.f1400l = aVar.a();
        this.m = aVar.b();
        this.Q = aVar.e();
        this.R = aVar.f();
        this.H = aVar.g();
        this.u = i2;
        long currentTimeMillis = System.currentTimeMillis();
        this.s = currentTimeMillis;
        this.y = currentTimeMillis;
        this.G = cVar.E();
    }

    public int w() {
        return this.w;
    }

    public void a(int i2) {
        this.w = i2;
    }

    public synchronized void x() {
        this.w++;
    }

    public int y() {
        return this.x;
    }

    public void b(int i2) {
        this.x = i2;
    }

    public synchronized void z() {
        this.x++;
    }

    public long A() {
        long j2 = this.y;
        return j2 == 0 ? this.s : j2;
    }

    public void a(long j2) {
        this.y = j2;
    }

    public long B() {
        return this.z;
    }

    public void b(long j2) {
        this.z = j2;
    }

    public void c(long j2) {
        this.A = j2;
    }

    public int C() {
        return this.B;
    }

    public void c(int i2) {
        this.B = i2;
    }

    public int D() {
        return this.C;
    }

    public void d(int i2) {
        this.C = i2;
    }

    public String E() {
        return this.D;
    }

    public void a(String str) {
        this.D = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public long b() {
        return this.c;
    }

    public void d(long j2) {
        this.c = j2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public long l() {
        return this.d;
    }

    public void e(long j2) {
        this.d = j2;
    }

    public int F() {
        return this.f;
    }

    public void e(int i2) {
        this.f = i2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String e() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public long G() {
        return this.s;
    }

    public void f(long j2) {
        if (j2 > 0) {
            this.s = j2;
        }
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean c() {
        return this.r;
    }

    public void a(boolean z2) {
        this.r = z2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public JSONObject g() {
        return this.t;
    }

    public void a(JSONObject jSONObject) {
        this.t = jSONObject;
    }

    public void f(int i2) {
        this.n = i2;
    }

    public void d(String str) {
        this.o = str;
    }

    public int H() {
        return this.n;
    }

    public String I() {
        return this.o;
    }

    public void g(int i2) {
        this.u = i2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public int s() {
        return this.u;
    }

    public void b(boolean z2) {
        this.K = z2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean m() {
        return this.K;
    }

    public void h(int i2) {
        this.M = i2;
    }

    public int J() {
        return this.M;
    }

    public void i(int i2) {
        this.N = i2;
    }

    public void e(String str) {
        this.j = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public int h() {
        return this.N;
    }

    public void c(boolean z2) {
        this.v = z2;
    }

    public boolean K() {
        return this.v;
    }

    public void f(String str) {
        this.I = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String j() {
        return this.I;
    }

    public void g(String str) {
        this.J = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String i() {
        return this.J;
    }

    public void h(String str) {
        this.h = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String a() {
        return this.h;
    }

    public void i(String str) {
        this.i = str;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public String f() {
        return this.i;
    }

    public void g(long j2) {
        this.W = j2;
    }

    public long L() {
        return this.W;
    }

    public void j(String str) {
        this.p = str;
    }

    public String M() {
        return this.p;
    }

    public void k(String str) {
        this.q = str;
    }

    public void j(int i2) {
        this.f1400l = i2;
    }

    public int N() {
        return this.f1400l;
    }

    public void k(int i2) {
        this.m = i2;
    }

    public void l(int i2) {
        this.k = i2;
    }

    public void d(boolean z2) {
        this.T = z2;
    }

    public String O() {
        return this.S;
    }

    public void l(String str) {
        this.S = str;
    }

    public boolean P() {
        return this.U;
    }

    public void e(boolean z2) {
        this.U = z2;
    }

    public boolean Q() {
        return this.L;
    }

    public void f(boolean z2) {
        this.L = z2;
    }

    public boolean R() {
        return this.V;
    }

    public void g(boolean z2) {
        this.V = z2;
    }

    public long S() {
        return this.O;
    }

    public void h(long j2) {
        this.O = j2;
    }

    public long T() {
        return this.P;
    }

    public void i(long j2) {
        this.P = j2;
    }

    public boolean U() {
        return this.E;
    }

    public void h(boolean z2) {
        this.E = z2;
    }

    public String V() {
        return this.F;
    }

    public void m(String str) {
        this.F = str;
    }

    public boolean W() {
        return this.G;
    }

    public void i(boolean z2) {
        this.G = z2;
    }

    public boolean X() {
        return this.X;
    }

    public void j(boolean z2) {
        this.X = z2;
    }

    public boolean Y() {
        return this.Y;
    }

    public void k(boolean z2) {
        this.Y = z2;
    }

    public boolean Z() {
        return this.aa;
    }

    public void l(boolean z2) {
        this.aa = z2;
    }

    public boolean aa() {
        return this.Z;
    }

    public void m(boolean z2) {
        this.Z = z2;
    }

    public boolean ab() {
        return this.ab;
    }

    public void n(boolean z2) {
        this.ab = z2;
    }

    public boolean ac() {
        return this.ac;
    }

    public void o(boolean z2) {
        this.ac = z2;
    }

    public void p(boolean z2) {
        this.Q = z2;
    }

    public void q(boolean z2) {
        this.R = z2;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public boolean q() {
        return this.H;
    }

    public void r(boolean z2) {
        this.H = z2;
    }

    public JSONObject ad() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.c);
            jSONObject.put("mExtValue", this.d);
            jSONObject.put("mLogExtra", this.e);
            jSONObject.put("mDownloadStatus", this.f);
            jSONObject.put("mPackageName", this.g);
            jSONObject.put("mIsAd", this.r);
            jSONObject.put("mTimeStamp", this.s);
            jSONObject.put("mExtras", this.t);
            jSONObject.put("mVersionCode", this.n);
            jSONObject.put("mVersionName", this.o);
            jSONObject.put("mDownloadId", this.u);
            jSONObject.put("mIsV3Event", this.K);
            jSONObject.put("mScene", this.M);
            jSONObject.put("mEventTag", this.I);
            jSONObject.put("mEventRefer", this.J);
            jSONObject.put("mDownloadUrl", this.h);
            jSONObject.put("mEnableBackDialog", this.v);
            jSONObject.put("hasSendInstallFinish", this.a.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.b.get());
            jSONObject.put("mLastFailedErrCode", this.C);
            jSONObject.put("mLastFailedErrMsg", this.D);
            jSONObject.put("mOpenUrl", this.i);
            jSONObject.put("mLinkMode", this.f1400l);
            jSONObject.put("mDownloadMode", this.m);
            jSONObject.put("mModelType", this.k);
            jSONObject.put("mAppName", this.p);
            jSONObject.put("mAppIcon", this.q);
            jSONObject.put("mDownloadFailedTimes", this.w);
            long j2 = this.y;
            if (j2 == 0) {
                j2 = this.s;
            }
            jSONObject.put("mRecentDownloadResumeTime", j2);
            jSONObject.put("mClickPauseTimes", this.x);
            jSONObject.put("mJumpInstallTime", this.z);
            jSONObject.put("mCancelInstallTime", this.A);
            jSONObject.put("mLastFailedResumeCount", this.B);
            jSONObject.put("mIsUpdateDownload", this.E);
            jSONObject.put("mOriginMimeType", this.F);
            jSONObject.put("mIsPatchApplyHandled", this.G);
            jSONObject.put("downloadFinishReason", this.S);
            jSONObject.put("clickDownloadTime", this.O);
            jSONObject.put("clickDownloadSize", this.P);
            jSONObject.put("installAfterCleanSpace", this.L);
            jSONObject.put("funnelType", this.N);
            jSONObject.put("webUrl", this.j);
            jSONObject.put("enableShowComplianceDialog", this.Q);
            jSONObject.put("isAutoDownloadOnCardShow", this.R);
            jSONObject.put("enable_new_activity", this.H ? 1 : 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.d(com.ss.android.a.a.d.a.a(jSONObject, "mId"));
            bVar.e(com.ss.android.a.a.d.a.a(jSONObject, "mExtValue"));
            bVar.c(jSONObject.optString("mLogExtra"));
            bVar.e(jSONObject.optInt("mDownloadStatus"));
            bVar.b(jSONObject.optString("mPackageName"));
            bVar.a(jSONObject.optBoolean("mIsAd"));
            bVar.f(com.ss.android.a.a.d.a.a(jSONObject, "mTimeStamp"));
            bVar.f(jSONObject.optInt("mVersionCode"));
            bVar.d(jSONObject.optString("mVersionName"));
            bVar.g(jSONObject.optInt("mDownloadId"));
            bVar.b(jSONObject.optBoolean("mIsV3Event"));
            bVar.h(jSONObject.optInt("mScene"));
            bVar.f(jSONObject.optString("mEventTag"));
            bVar.g(jSONObject.optString("mEventRefer"));
            bVar.h(jSONObject.optString("mDownloadUrl"));
            bVar.c(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.a.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.b.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.d(jSONObject.optInt("mLastFailedErrCode"));
            bVar.a(jSONObject.optString("mLastFailedErrMsg"));
            bVar.i(jSONObject.optString("mOpenUrl"));
            bVar.j(jSONObject.optInt("mLinkMode"));
            bVar.k(jSONObject.optInt("mDownloadMode"));
            bVar.l(jSONObject.optInt("mModelType"));
            bVar.j(jSONObject.optString("mAppName"));
            bVar.k(jSONObject.optString("mAppIcon"));
            boolean z2 = false;
            bVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.a(com.ss.android.a.a.d.a.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.b(jSONObject.optInt("mClickPauseTimes"));
            bVar.b(com.ss.android.a.a.d.a.a(jSONObject, "mJumpInstallTime"));
            bVar.c(com.ss.android.a.a.d.a.a(jSONObject, "mCancelInstallTime"));
            bVar.c(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.l(jSONObject.optString("downloadFinishReason"));
            bVar.i(jSONObject.optLong("clickDownloadSize"));
            bVar.h(jSONObject.optLong("clickDownloadTime"));
            bVar.h(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.m(jSONObject.optString("mOriginMimeType"));
            bVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.i(jSONObject.optInt("funnelType", 1));
            bVar.e(jSONObject.optString("webUrl"));
            bVar.p(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bVar.q(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            if (jSONObject.optInt("enable_new_activity") == 1) {
                z2 = true;
            }
            bVar.r(z2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            bVar.a(jSONObject.optJSONObject("mExtras"));
        } catch (Exception unused) {
            bVar.a((JSONObject) null);
        }
        return bVar;
    }

    @Override // com.ss.android.downloadad.a.b.a
    public c t() {
        return ae();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public com.ss.android.a.a.b.b u() {
        return af();
    }

    @Override // com.ss.android.downloadad.a.b.a
    public a v() {
        return ag();
    }

    public com.ss.android.downloadad.a.a.c ae() {
        return new c.a().a(this.c).b(this.d).a(this.e).b(this.g).a(this.t).a(this.r).b(this.n).g(this.o).d(this.h).a(this.k).f(this.F).e(this.p).c(this.q).a(new com.ss.android.a.a.c.b(this.i, this.j, null)).a();
    }

    public com.ss.android.downloadad.a.a.b af() {
        return new b.a().a(this.I).i(this.J).c(this.K).a();
    }

    public com.ss.android.downloadad.a.a.a ag() {
        return new a.C0080a().a(this.v).a(this.f1400l).b(this.m).e(this.Q).a();
    }
}
