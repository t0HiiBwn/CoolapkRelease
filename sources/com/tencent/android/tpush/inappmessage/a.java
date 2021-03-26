package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
abstract class a extends Dialog {
    protected RelativeLayout a;
    protected Activity b;
    protected boolean c = false;

    abstract void a(RelativeLayout relativeLayout);

    abstract RelativeLayout.LayoutParams b();

    abstract boolean c();

    abstract boolean d();

    abstract void e();

    protected a(Activity activity) {
        super(activity, j.a(activity));
        this.b = activity;
        i.a((Context) activity);
    }

    protected void a() {
        this.a = g();
        RelativeLayout h = h();
        this.a.addView(h);
        if (c()) {
            this.a.addView(a((View) h));
        }
        RelativeLayout relativeLayout = this.a;
        setContentView(relativeLayout, relativeLayout.getLayoutParams());
        this.a.setAnimation(j.a(350L));
        e();
    }

    private RelativeLayout g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.b);
        relativeLayout.setId(View.generateViewId());
        relativeLayout.setLayoutParams(b());
        j.a(relativeLayout, 0, !d());
        a(relativeLayout);
        return relativeLayout;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (!this.c) {
            this.c = true;
            f();
        }
    }

    protected void f() {
        super.cancel();
    }

    private e a(View view) {
        e eVar = new e(this.b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (d()) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, i.c, i.c, 0);
        } else {
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(7, view.getId());
            layoutParams.setMargins(0, -i.i, -i.i, 0);
        }
        eVar.setLayoutParams(layoutParams);
        eVar.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.android.tpush.inappmessage.a.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.cancel();
                a.this.b.finish();
                a.this.b.overridePendingTransition(0, 0);
            }
        });
        return eVar;
    }
}
