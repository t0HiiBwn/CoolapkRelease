package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.stat.ServiceStat;

/* compiled from: ProGuard */
abstract class h extends a {
    protected d d;
    protected String e = "PopupMessageTemplate";
    protected Intent f;

    protected h(Activity activity, d dVar, Intent intent) {
        super(activity);
        this.d = dVar;
        this.f = intent;
        a();
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    protected boolean c() {
        return this.d.e() == 1;
    }

    @Override // com.tencent.android.tpush.inappmessage.a
    void a(RelativeLayout relativeLayout) {
        View d2;
        View d3;
        View d4;
        View d5;
        ScrollView scrollView = new ScrollView(this.b);
        scrollView.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        String a = this.d.a(1);
        if ("Title.Location".equals(a) && !TextUtils.isEmpty(this.d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a) && !TextUtils.isEmpty(this.d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a) && !TextUtils.isEmpty(this.d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a) && this.d.f() > 0 && (d5 = d(this.b)) != null) {
            linearLayout.addView(d5);
        }
        String a2 = this.d.a(2);
        if ("Title.Location".equals(a2) && !TextUtils.isEmpty(this.d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a2) && !TextUtils.isEmpty(this.d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a2) && !TextUtils.isEmpty(this.d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a2) && this.d.f() > 0 && (d4 = d(this.b)) != null) {
            linearLayout.addView(d4);
        }
        String a3 = this.d.a(3);
        if ("Title.Location".equals(a3) && !TextUtils.isEmpty(this.d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a3) && !TextUtils.isEmpty(this.d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a3) && !TextUtils.isEmpty(this.d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a3) && this.d.f() > 0 && (d3 = d(this.b)) != null) {
            linearLayout.addView(d3);
        }
        String a4 = this.d.a(4);
        if ("Title.Location".equals(a4) && !TextUtils.isEmpty(this.d.x())) {
            linearLayout.addView(c(this.b));
        } else if ("Message.Location".equals(a4) && !TextUtils.isEmpty(this.d.F())) {
            linearLayout.addView(e(this.b));
        } else if ("Media.Location".equals(a4) && !TextUtils.isEmpty(this.d.h())) {
            linearLayout.addView(a(this.b));
        } else if ("Button.Location".equals(a4) && this.d.f() > 0 && (d2 = d(this.b)) != null) {
            linearLayout.addView(d2);
        }
        b(relativeLayout);
        scrollView.addView(linearLayout);
        relativeLayout.addView(scrollView);
    }

    private RelativeLayout b(RelativeLayout relativeLayout) {
        if (this.d.v() != null && !TextUtils.isEmpty(this.d.v())) {
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            shapeDrawable.setShape(j.a(this.d.g()));
            shapeDrawable.getPaint().setColor(Color.parseColor(this.d.v()));
            relativeLayout.setBackground(shapeDrawable);
        }
        if (this.d.H() != null && !TextUtils.isEmpty(this.d.H())) {
            relativeLayout.setBackgroundColor(-1);
            new f(this.d.H(), relativeLayout, this.b, this.d.g()).execute(new Void[0]);
        }
        return relativeLayout;
    }

    private ImageView a(Context context) {
        ImageView b = b(this.b);
        new f(this.d.h(), b, this.b, 0).execute(new Void[0]);
        return b;
    }

    private ImageView b(Context context) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.d.i(), this.d.j());
        layoutParams.gravity = 1;
        layoutParams.topMargin = i.a(context, 24.0f);
        layoutParams.leftMargin = i.a(context, 24.0f);
        layoutParams.rightMargin = i.a(context, 24.0f);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView c(Context context) {
        TextView textView = new TextView(context);
        textView.setPadding(i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f), 0);
        textView.setText(this.d.x());
        textView.setTextColor(Color.parseColor(this.d.y()));
        textView.setTextSize(2, (float) this.d.A());
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setSingleLine(true);
        int z = this.d.z();
        if (z == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (z == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (z == 2) {
            textView.setTypeface(null, 2);
        } else if (z == 3) {
            textView.getPaint().setFlags(8);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int B = this.d.B();
        if (B == 0) {
            layoutParams.gravity = 3;
        } else if (B == 1) {
            layoutParams.gravity = 1;
        } else if (B == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View d(Context context) {
        if (this.d.f() == 1) {
            Button button = new Button(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i.a(context, 48.0f));
            layoutParams.setMargins(i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f));
            layoutParams.gravity = 1;
            button.setLayoutParams(layoutParams);
            button.setBackgroundColor(Color.parseColor(this.d.I()));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) this.d.l());
            gradientDrawable.setColor(Color.parseColor(this.d.I()));
            button.setBackground(gradientDrawable);
            button.setText(this.d.w());
            button.setTextColor(Color.parseColor(this.d.J()));
            button.setTextSize((float) this.d.k());
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.android.tpush.inappmessage.h.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.f.putExtra("inapp_custom_event_id", "INNER_MESSAGE");
                    h.this.f.putExtra("inapp_button_event_id", h.this.d.m());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f);
                    String n = h.this.d.n();
                    int d = h.this.d.d();
                    if (d == 1) {
                        h.this.cancel();
                    } else if (d == 2) {
                        h.this.b(n);
                    } else if (d == 3) {
                        h.this.a(n);
                    } else if (d == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            return button;
        } else if (this.d.f() != 2) {
            return null;
        } else {
            LinearLayout linearLayout = new LinearLayout(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i.a(context, 48.0f));
            layoutParams2.setMargins(i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f));
            linearLayout.setLayoutParams(layoutParams2);
            linearLayout.setOrientation(0);
            Button button2 = new Button(context);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams3.gravity = 3;
            button2.setLayoutParams(layoutParams3);
            button2.setBackgroundColor(Color.parseColor(this.d.I()));
            button2.setText(this.d.w());
            button2.setTextColor(Color.parseColor(this.d.J()));
            button2.setTextSize((float) this.d.k());
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) this.d.l());
            gradientDrawable2.setColor(Color.parseColor(this.d.I()));
            button2.setBackground(gradientDrawable2);
            button2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.android.tpush.inappmessage.h.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String n = h.this.d.n();
                    h.this.f.putExtra("inapp_custom_event_id", "INNER_MESSAGE");
                    h.this.f.putExtra("inapp_button_event_id", h.this.d.m());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f);
                    int d = h.this.d.d();
                    if (d == 1) {
                        h.this.cancel();
                    } else if (d == 2) {
                        h.this.b(n);
                    } else if (d == 3) {
                        h.this.a(n);
                    } else if (d == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            linearLayout.addView(button2);
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.2f));
            linearLayout.addView(view);
            Button button3 = new Button(context);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams4.gravity = 5;
            button3.setLayoutParams(layoutParams4);
            button3.setBackgroundColor(Color.parseColor(this.d.u()));
            button3.setText(this.d.t());
            button3.setTextColor(Color.parseColor(this.d.s()));
            button3.setTextSize((float) this.d.r());
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) this.d.q());
            gradientDrawable3.setColor(Color.parseColor(this.d.u()));
            button3.setBackground(gradientDrawable3);
            button3.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.android.tpush.inappmessage.h.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String o = h.this.d.o();
                    h.this.f.putExtra("inapp_custom_event_id", "INNER_MESSAGE");
                    h.this.f.putExtra("inapp_button_event_id", h.this.d.p());
                    ServiceStat.appReportNotificationClicked(b.e(), h.this.f);
                    int c = h.this.d.c();
                    if (c == 1) {
                        h.this.cancel();
                    } else if (c == 2) {
                        h.this.b(o);
                    } else if (c == 3) {
                        h.this.a(o);
                    } else if (c == 4) {
                        h.this.g();
                    }
                    h.this.cancel();
                    h.this.b.finish();
                    h.this.b.overridePendingTransition(0, 0);
                }
            });
            linearLayout.addView(button3);
            return linearLayout;
        }
    }

    private TextView e(Context context) {
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int D = this.d.D();
        if (D == 0) {
            layoutParams.gravity = 3;
        } else if (D == 1) {
            layoutParams.gravity = 1;
        } else if (D == 2) {
            layoutParams.gravity = 5;
        }
        textView.setLayoutParams(layoutParams);
        textView.setPadding(i.a(context, 24.0f), i.a(context, 24.0f), i.a(context, 24.0f), 0);
        textView.setText(this.d.F());
        textView.setTextColor(Color.parseColor(this.d.G()));
        textView.setTextSize(2, (float) this.d.C());
        textView.setMaxLines(8);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        int E = this.d.E();
        if (E == 0) {
            textView.setTypeface(Typeface.DEFAULT);
        } else if (E == 1) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (E == 2) {
            textView.setTypeface(null, 2);
        } else if (E == 3) {
            textView.getPaint().setFlags(8);
        }
        return textView;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            String str2 = this.e;
            TLogger.i(str2, "jumpUrl targetActivity :" + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            this.b.startActivity(intent);
        } catch (Throwable th) {
            TLogger.e(this.e, "openUrl error.", th);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            Intent intent = new Intent();
            String str2 = this.e;
            TLogger.i(str2, "jumpIntent targetActivity:" + str);
            Uri parse = Uri.parse(str);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            if (intent.resolveActivity(this.b.getPackageManager()) != null) {
                this.b.startActivity(intent);
            }
        } catch (Throwable th) {
            TLogger.e(this.e, "jumpIntent error.", th);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", this.b.getPackageName());
            intent.putExtra("android.intent.extra.CHANNEL_ID", this.b.getApplicationInfo().uid);
            intent.putExtra("app_package", this.b.getPackageName());
            intent.putExtra("app_uid", this.b.getApplicationInfo().uid);
            this.b.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", this.b.getPackageName(), null));
            this.b.startActivity(intent2);
        }
    }
}
