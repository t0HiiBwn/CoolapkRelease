package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.ss.android.socialbase.appdownloader.c.e;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.c;
import com.ss.android.socialbase.downloader.notification.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AppTaskBuilder */
public class f {
    private boolean A;
    private int B = 5;
    private int C;
    private boolean D;
    private String E;
    private boolean F = true;
    private boolean G;
    private boolean H;
    private boolean I;
    private com.ss.android.socialbase.downloader.constants.f J = com.ss.android.socialbase.downloader.constants.f.ENQUEUE_NONE;
    private int K = 150;
    private int L;
    private boolean M = true;
    private z N;
    private n O;
    private e P;
    private t Q;
    private r R;
    private boolean S;
    private ah T;
    private boolean U;
    private JSONObject V;
    private String W;
    private List<m> X = new ArrayList();
    private int Y;
    private long Z;
    private Activity a;
    private int aa;
    private boolean ab = true;
    private String ac;
    private int[] ad;
    private Context b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<c> h;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1406l = false;
    private IDownloadListener m;
    private IDownloadListener n;
    private String o;
    private String p = "application/vnd.android.package-archive";
    private boolean q;
    private com.ss.android.socialbase.downloader.downloader.f r;
    private g s;
    private q t;
    private a u;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private long z;

    public f(Context context, String str) {
        this.b = context.getApplicationContext();
        this.c = str;
    }

    public Activity a() {
        return this.a;
    }

    public Context b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public List<c> f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.f1406l;
    }

    public IDownloadListener k() {
        return this.m;
    }

    public IDownloadListener l() {
        return this.n;
    }

    public String m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public boolean o() {
        return this.q;
    }

    public a p() {
        return this.u;
    }

    public g q() {
        return this.s;
    }

    public com.ss.android.socialbase.downloader.downloader.f r() {
        return this.r;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public int u() {
        return this.aa;
    }

    public void a(int i2) {
        this.aa = i2;
    }

    public String v() {
        return this.x;
    }

    public String w() {
        return this.y;
    }

    public long x() {
        return this.z;
    }

    public int y() {
        return this.B;
    }

    public int z() {
        return this.C;
    }

    public boolean A() {
        return this.D;
    }

    public String B() {
        return this.E;
    }

    public boolean C() {
        return this.F;
    }

    public boolean D() {
        return this.G;
    }

    public q E() {
        return this.t;
    }

    public int F() {
        return this.K;
    }

    public int G() {
        return this.L;
    }

    public boolean H() {
        return this.H;
    }

    public boolean I() {
        return this.I;
    }

    public boolean J() {
        return this.M;
    }

    public boolean K() {
        return this.S;
    }

    public com.ss.android.socialbase.downloader.constants.f L() {
        return this.J;
    }

    public boolean M() {
        return this.A;
    }

    public String N() {
        return this.f;
    }

    public z O() {
        return this.N;
    }

    public n P() {
        return this.O;
    }

    public e Q() {
        return this.P;
    }

    public t R() {
        return this.Q;
    }

    public ah S() {
        return this.T;
    }

    public List<m> T() {
        return this.X;
    }

    public boolean U() {
        return this.U;
    }

    public int V() {
        return this.Y;
    }

    public long W() {
        return this.Z;
    }

    public boolean X() {
        return this.ab;
    }

    public String Y() {
        return this.ac;
    }

    public int[] Z() {
        return this.ad;
    }

    public f a(String str) {
        this.e = str;
        return this;
    }

    public f b(String str) {
        this.f = str;
        return this;
    }

    public f c(String str) {
        this.g = str;
        return this;
    }

    public f a(List<c> list) {
        this.h = list;
        return this;
    }

    public f a(boolean z2) {
        this.i = z2;
        return this;
    }

    public f b(boolean z2) {
        this.j = z2;
        return this;
    }

    public f c(boolean z2) {
        this.f1406l = z2;
        return this;
    }

    public f a(IDownloadListener iDownloadListener) {
        this.m = iDownloadListener;
        return this;
    }

    public f d(String str) {
        this.o = str;
        return this;
    }

    public f e(String str) {
        this.p = str;
        return this;
    }

    public f d(boolean z2) {
        this.q = z2;
        return this;
    }

    public f a(g gVar) {
        this.s = gVar;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.f fVar) {
        this.r = fVar;
        return this;
    }

    public f e(boolean z2) {
        this.v = z2;
        return this;
    }

    public f f(boolean z2) {
        this.w = z2;
        return this;
    }

    public f f(String str) {
        this.x = str;
        return this;
    }

    public f g(String str) {
        this.y = str;
        return this;
    }

    public f a(long j2) {
        this.z = j2;
        return this;
    }

    public f b(int i2) {
        this.B = i2;
        return this;
    }

    public f c(int i2) {
        this.C = i2;
        return this;
    }

    public f g(boolean z2) {
        this.D = z2;
        return this;
    }

    public f h(String str) {
        this.E = str;
        return this;
    }

    public f h(boolean z2) {
        this.S = z2;
        return this;
    }

    public f i(boolean z2) {
        this.F = z2;
        return this;
    }

    public f j(boolean z2) {
        this.G = z2;
        return this;
    }

    public f k(boolean z2) {
        this.H = z2;
        return this;
    }

    public f l(boolean z2) {
        this.I = z2;
        return this;
    }

    public f d(int i2) {
        this.K = i2;
        return this;
    }

    public f e(int i2) {
        this.L = i2;
        return this;
    }

    public f m(boolean z2) {
        this.M = z2;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.constants.f fVar) {
        this.J = fVar;
        return this;
    }

    public f n(boolean z2) {
        this.A = z2;
        return this;
    }

    public f a(t tVar) {
        this.Q = tVar;
        return this;
    }

    public f i(String str) {
        this.ac = str;
        return this;
    }

    public f j(String str) {
        this.W = str;
        return this;
    }

    public String aa() {
        return this.W;
    }

    public f f(int i2) {
        this.Y = i2;
        return this;
    }

    public List<String> ab() {
        return this.d;
    }

    public f b(List<String> list) {
        this.d = list;
        return this;
    }

    public r ac() {
        return this.R;
    }

    public f a(r rVar) {
        this.R = rVar;
        return this;
    }

    public JSONObject ad() {
        return this.V;
    }

    public f a(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public f a(m mVar) {
        synchronized (this.X) {
            if (mVar != null) {
                if (!this.X.contains(mVar)) {
                    this.X.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }
}
