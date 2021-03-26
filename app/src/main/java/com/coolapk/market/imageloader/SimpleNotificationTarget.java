package com.coolapk.market.imageloader;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

@Deprecated
public class SimpleNotificationTarget extends CustomTarget<Bitmap> {
    private final NotificationCompat.Builder builder;
    private final Context context;
    private final int notificationId;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public SimpleNotificationTarget(Context context2, NotificationCompat.Builder builder2, int i) {
        this.context = context2;
        this.builder = builder2;
        this.notificationId = i;
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService("notification")).notify(this.notificationId, this.builder.build());
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        this.builder.setLargeIcon(bitmap);
        update();
    }
}
