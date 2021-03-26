package com.bytedance.sdk.openadsdk.component.reward.top;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;

public class TopLayout1 extends FrameLayout implements a<TopLayout1> {
    private TextView a;
    private ImageView b;
    private TextView c;
    private View d;
    private boolean e;
    private boolean f;
    private b g;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSkipEnable(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setEnabled(z);
            this.c.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSound(boolean z) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setSoundMute(boolean z) {
        int i;
        this.f = z;
        if (z) {
            i = ac.d(getContext(), "tt_mute");
        } else {
            i = ac.d(getContext(), "tt_unmute");
        }
        this.b.setImageResource(i);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        float f2;
        if (this.a != null && !TextUtils.isEmpty(charSequence)) {
            this.a.setText(charSequence);
        }
        if (this.c != null && !TextUtils.isEmpty(charSequence2)) {
            this.c.setText(charSequence2);
            if (!this.e) {
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                if (charSequence2.length() <= 2) {
                    f2 = ak.a(getContext(), 53.0f);
                } else {
                    f2 = ak.a(getContext(), 96.0f);
                }
                layoutParams.width = (int) f2;
                this.c.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setListener(b bVar) {
        this.g = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a() {
        TextView textView = this.c;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void b() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.performClick();
        }
    }
}
