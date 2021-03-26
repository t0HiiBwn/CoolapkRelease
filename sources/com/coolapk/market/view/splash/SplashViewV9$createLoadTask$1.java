package com.coolapk.market.view.splash;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import rx.subjects.ReplaySubject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/splash/SplashViewV9$createLoadTask$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SplashViewV9.kt */
public final class SplashViewV9$createLoadTask$1 implements RequestListener<Drawable> {
    final /* synthetic */ ReplaySubject $replaySubject;
    final /* synthetic */ SplashViewV9 this$0;

    SplashViewV9$createLoadTask$1(SplashViewV9 splashViewV9, ReplaySubject replaySubject) {
        this.this$0 = splashViewV9;
        this.$replaySubject = replaySubject;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        this.$replaySubject.onNext(false);
        return false;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        this.$replaySubject.onNext(true);
        this.this$0.onImageLoad();
        return false;
    }
}
