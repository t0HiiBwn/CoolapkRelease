package com.coolapk.market.widget.view;

import android.content.Context;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoViewCompat.kt */
final class PhotoViewCompat$showExceptionRunnable$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhotoViewCompat this$0;

    PhotoViewCompat$showExceptionRunnable$1(PhotoViewCompat photoViewCompat, Context context) {
        this.this$0 = photoViewCompat;
        this.$context = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.this$0.lastException;
        if (th != null) {
            Toast.error(this.$context, th);
            this.this$0.isRunnablePosted = false;
        }
    }
}
