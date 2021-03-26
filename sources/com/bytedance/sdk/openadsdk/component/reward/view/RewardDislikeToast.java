package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;

public class RewardDislikeToast extends FrameLayout {
    private Handler a;
    private TextView b;

    public RewardDislikeToast(Context context) {
        this(context, null);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    private void a(Context context) {
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setClickable(false);
        this.b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int a2 = (int) ak.a(p.a(), 20.0f);
        int a3 = (int) ak.a(p.a(), 12.0f);
        this.b.setPadding(a2, a3, a2, a3);
        this.b.setLayoutParams(layoutParams);
        this.b.setTextColor(-1);
        this.b.setTextSize(16.0f);
        this.b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(ak.a(p.a(), 6.0f));
        this.b.setBackgroundDrawable(gradientDrawable);
        addView(this.b);
    }

    public void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.removeCallbacksAndMessages(null);
            this.a.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    if (RewardDislikeToast.this.b != null) {
                        RewardDislikeToast.this.b.setText(String.valueOf(str));
                    }
                    RewardDislikeToast.this.setVisibility(0);
                }
            });
            this.a.postDelayed(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    RewardDislikeToast.this.setVisibility(8);
                }
            }, 2000);
        }
    }

    public void a() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages(null);
    }

    public void b() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages(null);
    }
}
