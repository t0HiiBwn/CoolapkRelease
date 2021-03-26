package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.amap.api.maps2d.MapsInitializer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: Mediator */
class az {
    static double a = 0.6499999761581421d;
    public d b;
    public c c;
    public b d;
    public a e;
    public v f;
    public b g;
    public av h = null;
    private an i;

    public az(Context context, b bVar, int i2) {
        this.g = bVar;
        c cVar = new c(bVar);
        this.c = cVar;
        av avVar = new av(cVar);
        this.h = avVar;
        avVar.a = i2;
        this.h.b = i2;
        this.h.a();
        a(context);
        this.e = new a(context);
        this.b = new d();
        this.d = new b();
        this.f = new v(bVar);
        this.c.a(false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    public void a(Context context) {
        Field field;
        int i2;
        new DisplayMetrics();
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (SecurityException e2) {
            cm.a(e2, "Mediator", "initialize");
        } catch (NoSuchFieldException e3) {
            cm.a(e3, "Mediator", "initialize");
        }
        if (field == null) {
            long j = (long) (displayMetrics.widthPixels * displayMetrics.heightPixels);
            try {
                i2 = field.getInt(displayMetrics);
            } catch (IllegalArgumentException e4) {
                cm.a(e4, "Mediator", "initialize");
            } catch (IllegalAccessException e5) {
                cm.a(e5, "Mediator", "initialize");
            }
            if (i2 > 120) {
                q.m = 1;
            } else if (i2 <= 160) {
                q.m = 3;
            } else if (i2 <= 240) {
                q.m = 2;
            } else {
                int i3 = (j > 153600 ? 1 : (j == 153600 ? 0 : -1));
                if (i3 > 0) {
                    q.m = 2;
                } else if (i3 < 0) {
                    q.m = 1;
                } else {
                    q.m = 3;
                }
            }
        } else {
            int i4 = (((long) (displayMetrics.widthPixels * displayMetrics.heightPixels)) > 153600 ? 1 : (((long) (displayMetrics.widthPixels * displayMetrics.heightPixels)) == 153600 ? 0 : -1));
            if (i4 > 0) {
                q.m = 2;
            } else if (i4 < 0) {
                q.m = 1;
            } else {
                q.m = 3;
            }
        }
        if (q.m != 2) {
            q.c = 18;
        }
        bg.a(context);
        if (MapsInitializer.getUpdateDataActiveEnable()) {
            bg.a();
            bg.b("UpdateDataActiveEnable", true);
        }
        bg.a();
        MapsInitializer.setUpdateDataActiveEnable(bg.a("UpdateDataActiveEnable", false));
        b();
        i2 = 160;
        if (i2 > 120) {
        }
        if (q.m != 2) {
        }
        bg.a(context);
        if (MapsInitializer.getUpdateDataActiveEnable()) {
        }
        bg.a();
        MapsInitializer.setUpdateDataActiveEnable(bg.a("UpdateDataActiveEnable", false));
        b();
        field = null;
        if (field == null) {
        }
        if (q.m != 2) {
        }
        bg.a(context);
        if (MapsInitializer.getUpdateDataActiveEnable()) {
        }
        bg.a();
        MapsInitializer.setUpdateDataActiveEnable(bg.a("UpdateDataActiveEnable", false));
        b();
    }

    public void a() {
        this.e.a();
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        if (MapsInitializer.getUpdateDataActiveEnable() && q.b()) {
            c();
        }
    }

    private void b() {
        if (MapsInitializer.getUpdateDataActiveEnable()) {
            bg.a();
            String a2 = bg.a("updateDataPeriodDate");
            if (a2 == null || a2.equals("")) {
                bg.a().b("updateDataPeriodDate", t.a());
            } else if (t.a(a2, t.a()) > ((double) bg.a().a("period_day", q.q))) {
                c();
            }
        }
    }

    private void c() {
        bg.a();
        String a2 = bg.a("cache_path", (String) null);
        if (a2 != null) {
            u.a(a2);
        }
        bg.a().b("updateDataPeriodDate", t.a());
    }

    public void a(boolean z) {
        this.e.b(z);
    }

    /* compiled from: Mediator */
    public class b {
        public boolean a = false;
        int b = 0;

        public b() {
            e();
        }

        public void a() {
            if (az.this.e.o) {
                az.this.e.b();
            }
            int i = this.b + 1;
            this.b = i;
            if (i >= 20 && i % 20 == 0 && az.this.e.a != null && az.this.e.a.size() != 0) {
                int size = az.this.e.a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    az.this.e.a.get(i2).q.i();
                }
            }
        }

        public void b() {
            az.this.c.a = false;
            if (!(az.this.e.a == null || az.this.e.a.size() == 0)) {
                int size = az.this.e.a.size();
                for (int i = 0; i < size; i++) {
                    az.this.e.a.get(i).q.b();
                }
            }
        }

        public void c() {
            if (az.this.e.a != null && az.this.e.a.size() != 0) {
                try {
                    int size = az.this.e.a.size();
                    for (int i = 0; i < size; i++) {
                        az.this.e.a.get(i).q.d();
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public void d() {
            bv bvVar;
            if (!(az.this.e.a == null || az.this.e.a.size() == 0)) {
                int size = az.this.e.a.size();
                for (int i = 0; i < size; i++) {
                    an anVar = az.this.e.a.get(i);
                    if (!(anVar == null || (bvVar = anVar.q) == null)) {
                        bvVar.c();
                    }
                }
            }
        }

        public void e() {
            bv bvVar;
            if (!(az.this.e.a == null || az.this.e.a.size() == 0)) {
                int size = az.this.e.a.size();
                for (int i = 0; i < size; i++) {
                    an anVar = az.this.e.a.get(i);
                    if (!(anVar == null || (bvVar = anVar.q) == null)) {
                        bvVar.h();
                    }
                }
            }
        }
    }

    /* compiled from: Mediator */
    public class d implements bh {
        private float b = 0.0f;
        private HashMap<Float, Float> c = new HashMap<>();

        public d() {
        }

        @Override // com.amap.api.mapcore2d.bh
        public Point a(w wVar, Point point) {
            int i;
            int i2;
            boolean z;
            if (wVar == null) {
                return null;
            }
            PointF b2 = az.this.h.b(wVar, az.this.h.l, az.this.h.n, az.this.h.k);
            bb l = az.this.c.c.l();
            Point point2 = az.this.c.c.a().h.n;
            if (l.m) {
                try {
                    z = az.this.g.h.isZoomGesturesEnabled();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    z = true;
                }
                if (!l.l || !z) {
                    int i3 = (int) b2.x;
                    i2 = (int) b2.y;
                    i = i3;
                } else {
                    float f = (bb.j * (((float) ((int) b2.x)) - l.f.x)) + l.f.x + (l.g.x - l.f.x);
                    float f2 = (bb.j * (((float) ((int) b2.y)) - l.f.y)) + l.f.y + (l.g.y - l.f.y);
                    i = (int) f;
                    i2 = (int) f2;
                    if (((double) f) >= ((double) i) + 0.5d) {
                        i++;
                    }
                    if (((double) f2) >= ((double) i2) + 0.5d) {
                        i2++;
                    }
                }
            } else {
                float f3 = (az.this.h.c * ((float) (((int) b2.x) - point2.x))) + ((float) point2.x);
                float f4 = (az.this.h.c * ((float) (((int) b2.y) - point2.y))) + ((float) point2.y);
                i = (int) f3;
                int i4 = (int) f4;
                if (((double) f3) >= ((double) i) + 0.5d) {
                    i++;
                }
                i2 = ((double) f4) >= ((double) i4) + 0.5d ? i4 + 1 : i4;
            }
            Point point3 = new Point(i, i2);
            if (point != null) {
                point.x = point3.x;
                point.y = point3.y;
            }
            return point3;
        }

        @Override // com.amap.api.mapcore2d.bh
        public w a(int i, int i2) {
            return az.this.h.a(new PointF((float) i, (float) i2), az.this.h.l, az.this.h.n, az.this.h.k, az.this.h.o);
        }

        public float a(float f) {
            float e = az.this.c.e();
            if (this.c.size() > 30 || e != this.b) {
                this.b = e;
                this.c.clear();
            }
            if (!this.c.containsKey(Float.valueOf(f))) {
                float a2 = az.this.h.a(a(0, 0), a(0, 100));
                if (a2 <= 0.0f) {
                    return 0.0f;
                }
                this.c.put(Float.valueOf(f), Float.valueOf((f / a2) * 100.0f));
            }
            return this.c.get(Float.valueOf(f)).floatValue();
        }

        public int a(int i, int i2, int i3) {
            return a(i, i2, i3, false);
        }

        public int b(int i, int i2, int i3) {
            return a(i, i2, i3, true);
        }

        private int a(int i, int i2, int i3, boolean z) {
            if (i <= 0) {
                i = az.this.c.c();
            }
            if (i2 <= 0) {
                i2 = az.this.c.d();
            }
            w a2 = a(i3, i2 - i3);
            w a3 = a(i - i3, i3);
            if (z) {
                return Math.abs(a2.a() - a3.a());
            }
            return Math.abs(a2.b() - a3.b());
        }
    }

    /* compiled from: Mediator */
    public class a {
        public bn<an> a;
        public boolean b;
        public boolean c;
        String d;
        int e;
        int f;
        String g;
        String h;
        String i;
        String j;
        private boolean l;
        private boolean m;
        private Context n;
        private boolean o;

        private int c() {
            return 3;
        }

        public boolean a(int i2, KeyEvent keyEvent) {
            return false;
        }

        public boolean a(MotionEvent motionEvent) {
            return false;
        }

        public boolean b(int i2, KeyEvent keyEvent) {
            return false;
        }

        protected boolean b(MotionEvent motionEvent) {
            return false;
        }

        private a(Context context) {
            this.l = false;
            this.m = true;
            this.a = null;
            this.b = false;
            this.c = false;
            this.d = "zh_cn";
            this.e = 0;
            this.f = 0;
            this.h = "SatelliteMap3";
            this.i = "GridTmc3";
            this.j = "SateliteTmc3";
            this.o = false;
            if (context != null) {
                this.n = context;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int c2 = (displayMetrics.widthPixels / az.this.h.a) + c();
                int c3 = (displayMetrics.heightPixels / az.this.h.a) + c();
                int i2 = (c2 * c3) + c2 + c3;
                this.e = i2;
                int i3 = (i2 / 8) + 1;
                this.f = i3;
                if (i3 == 0) {
                    this.f = 1;
                } else if (i3 > 5) {
                    this.f = 5;
                }
                a(context, "zh_cn");
            }
        }

        public void a(String str) {
            if (str != null && !str.equals("") && !this.d.equals(str)) {
                if (str.equals("zh_cn") || str.equals("en")) {
                    if (q.g != null && !q.g.equals("")) {
                        this.g = q.g;
                    } else if (str.equals("zh_cn")) {
                        this.g = "GridMapV3";
                    } else if (str.equals("en")) {
                        this.g = "GridMapEnV3";
                    }
                    az.this.i = b(this.g);
                    if (az.this.i == null) {
                        az azVar = az.this;
                        azVar.i = new an(azVar.h);
                        an anVar = az.this.i;
                        az azVar2 = az.this;
                        anVar.q = new bv(azVar2, azVar2.i);
                        az.this.i.j = new cb() {
                            /* class com.amap.api.mapcore2d.az.a.AnonymousClass1 */

                            @Override // com.amap.api.mapcore2d.cb
                            public String a(int i, int i2, int i3) {
                                if (q.h != null && !q.h.equals("")) {
                                    return String.format(Locale.US, q.h, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                                }
                                return String.format(Locale.US, ax.a().b(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), a.this.d);
                            }
                        };
                        if (q.h == null || q.h.equals("")) {
                            az.this.i.h = true;
                        } else {
                            az.this.i.h = false;
                        }
                        az.this.i.b = this.g;
                        az.this.i.e = true;
                        az.this.i.a(true);
                        az.this.i.f = true;
                        az.this.i.c = q.c;
                        az.this.i.d = q.d;
                        a(az.this.i, this.n);
                    }
                    a(this.g, true);
                    this.d = str;
                }
            }
        }

        private void a(Context context, String str) {
            if (this.a == null) {
                this.a = new bn<>();
            }
            if (q.g != null && !q.g.equals("")) {
                this.g = q.g;
            } else if (str.equals("zh_cn")) {
                this.g = "GridMapV3";
            } else if (str.equals("en")) {
                this.g = "GridMapEnV3";
            }
            an anVar = new an(az.this.h);
            anVar.j = new cb() {
                /* class com.amap.api.mapcore2d.az.a.AnonymousClass2 */

                @Override // com.amap.api.mapcore2d.cb
                public String a(int i, int i2, int i3) {
                    if (q.h != null && !q.h.equals("")) {
                        return String.format(Locale.US, q.h, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                    }
                    return String.format(Locale.US, ax.a().b(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), a.this.d);
                }
            };
            if (q.h == null || q.h.equals("")) {
                anVar.h = true;
            } else {
                anVar.h = false;
            }
            anVar.b = this.g;
            anVar.e = true;
            anVar.f = true;
            anVar.c = q.c;
            anVar.d = q.d;
            anVar.q = new bv(az.this, anVar);
            anVar.a(true);
            a(anVar, context);
        }

        boolean a(String str, boolean z) {
            if (str.equals("")) {
                return false;
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                an anVar = this.a.get(i2);
                if (anVar != null && anVar.b.equals(str)) {
                    anVar.a(z);
                    if (!anVar.e) {
                        return true;
                    }
                    if (z) {
                        if (anVar.c > anVar.d) {
                            az.this.c.a(anVar.c);
                            az.this.c.b(anVar.d);
                        }
                        c(str);
                        az.this.c.a(false, false);
                        return true;
                    }
                }
            }
            return false;
        }

        private void c(String str) {
            if (!str.equals("")) {
                int size = this.a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    an anVar = this.a.get(i2);
                    if (anVar != null && !anVar.b.equals(str) && anVar.e && anVar.a()) {
                        anVar.a(false);
                    }
                }
            }
        }

        private boolean d(String str) {
            bn<an> bnVar = this.a;
            if (bnVar == null) {
                return false;
            }
            int size = bnVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                an anVar = this.a.get(i2);
                if (anVar != null && anVar.b.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        boolean a(an anVar, Context context) {
            boolean z = false;
            if (anVar == null || anVar.b.equals("") || d(anVar.b)) {
                return false;
            }
            anVar.p = new bn<>();
            anVar.n = new ba(this.e, this.f, anVar.g, anVar.i, anVar);
            anVar.o = new u(context, az.this.c.c.d, anVar);
            anVar.o.a(anVar.n);
            int size = this.a.size();
            if (!anVar.e || size == 0) {
                z = this.a.add(anVar);
            } else {
                int i2 = size - 1;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    an anVar2 = this.a.get(i2);
                    if (anVar2 != null && anVar2.e) {
                        this.a.add(i2, anVar);
                        break;
                    }
                    i2--;
                }
            }
            d();
            if (anVar.a()) {
                a(anVar.b, true);
            }
            return z;
        }

        private void d() {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                an anVar = this.a.get(i2);
                if (anVar != null) {
                    anVar.l = i2;
                }
            }
        }

        an b(String str) {
            bn<an> bnVar;
            if (!(str.equals("") || (bnVar = this.a) == null || bnVar.size() == 0)) {
                int size = this.a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    an anVar = this.a.get(i2);
                    if (anVar != null && anVar.b.equals(str)) {
                        return anVar;
                    }
                }
            }
            return null;
        }

        public void a() {
            if (az.this.e.a != null) {
                Iterator<an> it2 = az.this.e.a.iterator();
                while (it2.hasNext()) {
                    an next = it2.next();
                    if (next != null) {
                        next.b();
                    }
                }
                az.this.e.a.clear();
                az.this.e.a = null;
            }
        }

        public void b() {
            if (az.this.c != null && az.this.c.c != null) {
                az.this.c.c.postInvalidate();
            }
        }

        public void a(boolean z) {
            this.l = z;
        }

        public void a(Canvas canvas, Matrix matrix, float f2, float f3) {
            try {
                if (this.l) {
                    canvas.save();
                    canvas.translate(f2, f3);
                    canvas.concat(matrix);
                    a(canvas);
                    if (az.this.g.i.a()) {
                        b(canvas);
                    }
                    az.this.g.i.a(canvas);
                    canvas.restore();
                    if (!az.this.g.i.a()) {
                        b(canvas);
                    }
                    if (!this.b && !this.c) {
                        a(false);
                        az.this.c.c.b(new Matrix());
                        az.this.c.c.c(1.0f);
                        az.this.c.c.p();
                    }
                } else {
                    a(canvas);
                    az.this.g.i.a(canvas);
                    b(canvas);
                }
                c(canvas);
            } catch (Throwable th) {
                cm.a(th, "Mediator", "draw");
            }
        }

        public void b(boolean z) {
            this.m = z;
        }

        private void a(Canvas canvas) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                an anVar = this.a.get(i2);
                if (anVar != null && anVar.a()) {
                    anVar.a(canvas);
                }
            }
        }

        private void b(Canvas canvas) {
            if (this.m) {
                az.this.f.a(canvas);
            }
        }

        private void c(Canvas canvas) {
            az.this.g.j.a(canvas);
        }
    }

    /* compiled from: Mediator */
    public class c {
        public boolean a;
        private b c;
        private ArrayList<cc> d;

        private c(b bVar) {
            this.a = true;
            this.c = bVar;
            this.d = new ArrayList<>();
        }

        public void a(float f) {
            double d2;
            if (f != az.this.h.j) {
                az.this.h.j = f;
                int i = (int) f;
                double d3 = az.this.h.d / ((double) (1 << i));
                float f2 = f - ((float) i);
                double d4 = (double) f2;
                if (d4 < az.a) {
                    az.this.h.a = (int) (((double) az.this.h.b) * ((d4 * 0.4d) + 1.0d));
                    d2 = ((double) az.this.h.a) / ((double) az.this.h.b);
                } else {
                    az.this.h.a = (int) (((float) az.this.h.b) / (2.0f / (2.0f - ((1.0f - f2) * 0.4f))));
                    d2 = ((double) az.this.h.a) / ((double) az.this.h.b);
                    d3 /= 2.0d;
                }
                az.this.h.k = d3 / d2;
                az.this.g.c[1] = f;
                az.this.g.f.a(f);
            }
            a(false, false);
        }

        public void a(int i, int i2) {
            if (i != q.n || i2 != q.o) {
                q.n = i;
                q.o = i2;
                a(true, false);
            }
        }

        public void a(w wVar) {
            if (wVar != null) {
                if (q.s) {
                    az.this.h.l = az.this.h.a(wVar);
                }
                a(false, false);
            }
        }

        public void b(w wVar) {
            w f = az.this.c.f();
            if (wVar != null && !wVar.equals(f)) {
                if (q.s) {
                    az.this.h.l = az.this.h.a(wVar);
                }
                a(false, true);
            }
        }

        public int a() {
            try {
                return az.this.h.i;
            } catch (Throwable th) {
                cm.a(th, "Mediator", "getMaxZoomLevel");
                return 0;
            }
        }

        public void a(int i) {
            if (i > 0) {
                try {
                    az.this.h.i = i;
                    q.a(i);
                } catch (Throwable th) {
                    cm.a(th, "Mediator", "setMaxZoomLevel");
                }
            }
        }

        public int b() {
            try {
                return az.this.h.h;
            } catch (Throwable th) {
                cm.a(th, "Mediator", "getMinZoomLevel");
                return 0;
            }
        }

        public void b(int i) {
            if (i > 0) {
                try {
                    az.this.h.h = i;
                    q.b(i);
                } catch (Throwable th) {
                    cm.a(th, "Mediator", "setMinZoomLevel");
                }
            }
        }

        public int c() {
            return q.n;
        }

        public int d() {
            return q.o;
        }

        public float e() {
            try {
                return az.this.h.j;
            } catch (Throwable th) {
                cm.a(th, "Mediator", "getZoomLevel");
                return 0.0f;
            }
        }

        public w f() {
            w b2 = az.this.h.b(az.this.h.l);
            return (az.this.d == null || !az.this.d.a) ? b2 : az.this.h.m;
        }

        public void a(cc ccVar) {
            this.d.add(ccVar);
        }

        public void b(cc ccVar) {
            this.d.remove(ccVar);
        }

        public void a(boolean z, boolean z2) {
            Iterator<cc> it2 = this.d.iterator();
            while (it2.hasNext()) {
                it2.next().a(z, z2);
            }
            if (az.this.g != null && az.this.g.i != null) {
                az.this.g.i.a(true);
                az.this.g.postInvalidate();
            }
        }

        public b g() {
            return this.c;
        }
    }
}
