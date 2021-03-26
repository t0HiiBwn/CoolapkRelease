package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ac;

public class TopLayoutDislike2 extends FrameLayout implements a<TopLayoutDislike2> {
    private View a;
    private ImageView b;
    private TextView c;
    private boolean d;
    private l e;
    private boolean f;
    private b g;
    private CharSequence h;
    private CharSequence i;

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowCountDown(boolean z) {
    }

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = "";
        this.i = "";
    }

    public TopLayoutDislike2 a(boolean z, l lVar) {
        this.d = z;
        this.e = lVar;
        LayoutInflater.from(getContext()).inflate(ac.f(getContext(), "tt_top_reward_dislike_2"), (ViewGroup) this, true);
        this.a = findViewById(ac.e(getContext(), "tt_top_dislike"));
        this.b = (ImageView) findViewById(ac.e(getContext(), "tt_top_mute"));
        TextView textView = (TextView) findViewById(ac.e(getContext(), "tt_top_skip"));
        this.c = textView;
        textView.setVisibility(0);
        this.c.setText("");
        this.c.setEnabled(false);
        this.c.setClickable(false);
        d();
        return this;
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.AnonymousClass1 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.c(view);
                    }
                }
            });
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.AnonymousClass2 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.f = !topLayoutDislike2.f;
                    if (TopLayoutDislike2.this.f) {
                        i = ac.d(TopLayoutDislike2.this.getContext(), "tt_mute");
                    } else {
                        i = ac.d(TopLayoutDislike2.this.getContext(), "tt_unmute");
                    }
                    TopLayoutDislike2.this.b.setImageResource(i);
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.b(view);
                    }
                }
            });
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.AnonymousClass3 */

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TopLayoutDislike2.this.g != null) {
                        TopLayoutDislike2.this.g.a(view);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowSkip(boolean z) {
        TextView textView = this.c;
        if (textView != null) {
            if (!z) {
                textView.setText("");
            }
            if (this.c.getVisibility() != 4) {
                this.c.setVisibility(z ? 0 : 8);
            }
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
        int i2;
        this.f = z;
        if (z) {
            i2 = ac.d(getContext(), "tt_mute");
        } else {
            i2 = ac.d(getContext(), "tt_unmute");
        }
        this.b.setImageResource(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.h = charSequence;
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.i = charSequence2;
        }
        if (this.c != null) {
            CharSequence charSequence3 = this.h;
            if (!TextUtils.isEmpty(this.i)) {
                charSequence3 = ((Object) charSequence3) + " | " + ((Object) this.i);
            }
            this.c.setText(charSequence3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void setShowDislike(boolean z) {
        View view = this.a;
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

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.a
    public void c() {
        this.c.setWidth(20);
        this.c.setVisibility(4);
    }
}
