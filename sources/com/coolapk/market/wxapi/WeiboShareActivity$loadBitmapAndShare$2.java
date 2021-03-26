package com.coolapk.market.wxapi;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import com.coolapk.market.app.EmptySubscriber;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/wxapi/WeiboShareActivity$loadBitmapAndShare$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Landroid/graphics/Bitmap;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: WeiboShareActivity.kt */
public final class WeiboShareActivity$loadBitmapAndShare$2 extends EmptySubscriber<Bitmap> {
    final /* synthetic */ ProgressDialog $dialog;
    final /* synthetic */ WeiboMultiMessage $weiboMessage;
    final /* synthetic */ WeiboShareActivity this$0;

    WeiboShareActivity$loadBitmapAndShare$2(WeiboShareActivity weiboShareActivity, WeiboMultiMessage weiboMultiMessage, ProgressDialog progressDialog) {
        this.this$0 = weiboShareActivity;
        this.$weiboMessage = weiboMultiMessage;
        this.$dialog = progressDialog;
    }

    public void onNext(Bitmap bitmap) {
        super.onNext((WeiboShareActivity$loadBitmapAndShare$2) bitmap);
        if (bitmap != null) {
            WeiboMultiMessage weiboMultiMessage = this.$weiboMessage;
            ImageObject imageObject = new ImageObject();
            imageObject.setImageObject(bitmap);
            Unit unit = Unit.INSTANCE;
            weiboMultiMessage.imageObject = imageObject;
        }
        this.this$0.sendWeiboRequest(this.$weiboMessage);
        this.$dialog.dismiss();
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.this$0.sendWeiboRequest(this.$weiboMessage);
        this.$dialog.dismiss();
    }
}
