package com.coolapk.market.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.coolapk.market.widget.photoview.PhotoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/widget/view/PhotoViewCompat;", "Lcom/coolapk/market/widget/photoview/PhotoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isRunnablePosted", "", "lastException", "", "showExceptionRunnable", "Ljava/lang/Runnable;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoViewCompat.kt */
public final class PhotoViewCompat extends PhotoView {
    private boolean isRunnablePosted;
    private Throwable lastException;
    private final Runnable showExceptionRunnable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoViewCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showExceptionRunnable = new PhotoViewCompat$showExceptionRunnable$1(this, context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            this.lastException = th;
            if (!this.isRunnablePosted) {
                this.isRunnablePosted = true;
                postDelayed(this.showExceptionRunnable, 500);
            }
        }
    }
}
