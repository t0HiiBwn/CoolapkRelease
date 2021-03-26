package com.coolapk.market.view.wallpaper.coolpic;

import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/wallpaper/coolpic/CoolPicDetailActivity$loadFeedInfo$1", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/coolapk/market/model/Entity;", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolPicDetailActivity.kt */
public final class CoolPicDetailActivity$loadFeedInfo$1 extends EmptySubscriber<Entity> {
    final /* synthetic */ CoolPicDetailActivity this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    CoolPicDetailActivity$loadFeedInfo$1(CoolPicDetailActivity coolPicDetailActivity) {
        this.this$0 = coolPicDetailActivity;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        super.onError(th);
        String str = "获取信息失败，请重试";
        if (th instanceof ClientException) {
            CoolPicDetailActivity coolPicDetailActivity = this.this$0;
            String message = th.getMessage();
            if (message != null) {
                str = message;
            }
            coolPicDetailActivity.setLoadingError(str);
        } else {
            this.this$0.setLoadingError(str);
        }
        Toast.error(this.this$0.getActivity(), th);
    }

    public void onNext(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "t");
        super.onNext((CoolPicDetailActivity$loadFeedInfo$1) entity);
        if (entity instanceof Feed) {
            this.this$0.feed = (Feed) entity;
            CoolPicDetailActivity coolPicDetailActivity = this.this$0;
            Feed feed = coolPicDetailActivity.feed;
            Intrinsics.checkNotNull(feed);
            String str = this.this$0.listType;
            Intrinsics.checkNotNull(str);
            String str2 = this.this$0.direction;
            Intrinsics.checkNotNull(str2);
            String str3 = this.this$0.params;
            Intrinsics.checkNotNull(str3);
            coolPicDetailActivity.setupFragment(feed, str, str2, str3, this.this$0.index);
        }
    }
}
