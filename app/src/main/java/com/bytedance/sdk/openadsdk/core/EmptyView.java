package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.s;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class EmptyView extends View implements al.a {
    private boolean a;
    private boolean b;
    private a c;
    private View d;
    private WeakReference<Activity> e;
    private List<View> f;
    private List<View> g;
    private boolean h;
    private int i;
    private final Handler j = new al(Looper.getMainLooper(), this);
    private final AtomicBoolean k = new AtomicBoolean(true);

    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(p.a());
        if (context instanceof Activity) {
            this.e = new WeakReference<>((Activity) context);
        }
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.h = false;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    private void b() {
        a aVar;
        if (this.k.getAndSet(false) && (aVar = this.c) != null) {
            aVar.a();
        }
    }

    private void c() {
        a aVar;
        if (!this.k.getAndSet(true) && (aVar = this.c) != null) {
            aVar.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.h = true;
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    public void setRefClickViews(List<View> list) {
        this.f = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.g = list;
    }

    public void a() {
        a(this.f, null);
        a(this.g, null);
    }

    public void a(List<View> list, c cVar) {
        if (s.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    private void d() {
        if (this.b && !this.a) {
            this.a = true;
            this.j.sendEmptyMessage(1);
        }
    }

    private void e() {
        if (this.a) {
            this.j.removeCallbacksAndMessages(null);
            this.a = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.a) {
            e();
        } else if (z && !this.a) {
            d();
        }
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setAdType(int i2) {
        this.i = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 == 2) {
                if (f()) {
                    this.j.sendEmptyMessageDelayed(2, 1000);
                } else if (!this.h) {
                    setNeedCheckingShow(true);
                }
            }
        } else if (!this.a) {
        } else {
            if (y.a(this.d, 20, this.i)) {
                e();
                this.j.sendEmptyMessageDelayed(2, 1000);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(this.d);
                    return;
                }
                return;
            }
            this.j.sendEmptyMessageDelayed(1, 1000);
        }
    }

    private boolean f() {
        Activity activity;
        boolean a2 = aj.a();
        WeakReference<Activity> weakReference = this.e;
        boolean z = weakReference != null && ((activity = weakReference.get()) != null || !activity.isFinishing());
        boolean a3 = y.a(this.d, 20, this.i);
        if (!a2) {
            a3 = true;
        }
        if (a2 || !z) {
            return true;
        }
        return a3;
    }
}
