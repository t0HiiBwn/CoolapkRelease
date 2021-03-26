package com.coolapk.market.manager;

import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;
import com.coolapk.market.app.EmptySubscriber;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/coolapk/market/manager/CoolNotificationHandler$notifyPrivateMessage$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Landroid/graphics/Bitmap;", "onNext", "", "bitmap", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolNotificationHandler.kt */
public final class CoolNotificationHandler$notifyPrivateMessage$1 extends EmptySubscriber<Bitmap> {
    final /* synthetic */ NotificationCompat.Builder $builder;
    final /* synthetic */ int $notificationId;
    final /* synthetic */ CoolNotificationHandler this$0;

    CoolNotificationHandler$notifyPrivateMessage$1(CoolNotificationHandler coolNotificationHandler, NotificationCompat.Builder builder, int i) {
        this.this$0 = coolNotificationHandler;
        this.$builder = builder;
        this.$notificationId = i;
    }

    public void onNext(Bitmap bitmap) {
        this.$builder.setLargeIcon(bitmap);
        this.this$0.buildAndPost(this.$notificationId, this.$builder);
    }
}
