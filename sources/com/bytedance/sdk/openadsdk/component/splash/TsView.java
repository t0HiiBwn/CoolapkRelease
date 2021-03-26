package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.core.widget.gif.GifView;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.z;

public class TsView extends FrameLayout {
    private final Context a;
    private GifView b;
    private TTCountdownView c;
    private ImageView d;
    private FrameLayout e;
    private FrameLayout f;
    private ImageView g;
    private NativeExpressView h;

    public TsView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.a;
        View inflate = inflate(context, ac.f(context, "tt_splash_view"), this);
        this.b = (GifView) inflate.findViewById(ac.e(this.a, "tt_splash_ad_gif"));
        this.c = (TTCountdownView) inflate.findViewById(ac.e(this.a, "tt_splash_skip_btn"));
        this.d = (ImageView) inflate.findViewById(ac.e(this.a, "tt_splash_video_ad_mute"));
        this.e = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_splash_video_container"));
        this.f = (FrameLayout) inflate.findViewById(ac.e(this.a, "tt_splash_express_container"));
        this.g = (ImageView) inflate.findViewById(ac.e(this.a, "tt_ad_logo"));
    }

    void setExpressView(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            this.h = nativeExpressView;
            this.f.addView(nativeExpressView);
            setExpressViewVisibility(0);
            setVideoViewVisibility(8);
            setImageViewVisibility(8);
        }
    }

    void setCountDownTime(int i) {
        TTCountdownView tTCountdownView = this.c;
        if (tTCountdownView != null) {
            tTCountdownView.setCountDownTime(i);
        }
    }

    void setSkipIconVisibility(int i) {
        ak.a((View) this.c, i);
    }

    FrameLayout getVideoContainer() {
        return this.e;
    }

    void setVideoViewVisibility(int i) {
        ak.a((View) this.e, i);
        ak.a((View) this.d, i);
    }

    void setAdlogoViewVisibility(int i) {
        ak.a((View) this.g, i);
    }

    void setImageViewVisibility(int i) {
        ak.a((View) this.b, i);
    }

    void setExpressViewVisibility(int i) {
        ak.a((View) this.f, i);
    }

    void setDrawable(Drawable drawable) {
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.b.setImageDrawable(drawable);
    }

    void setGifView(byte[] bArr) {
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.a(bArr, false);
    }

    TTCountdownView getCountDownView() {
        return this.c;
    }

    View getDislikeView() {
        return this.c;
    }

    @Override // android.view.View, android.view.ViewGroup
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.component.splash.TsView.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                ak.h(TsView.this.c);
            }
        });
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        z.a("不允许在Splash广告中注册OnClickListener");
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        z.a("不允许在Splash广告中注册OnTouchListener");
    }

    final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    final void setSkipListener(View.OnClickListener onClickListener) {
        TTCountdownView tTCountdownView = this.c;
        if (tTCountdownView != null) {
            tTCountdownView.setOnClickListener(onClickListener);
        }
    }

    final void setVoiceViewListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    final void setVoiceViewImageResource(int i) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }
}
