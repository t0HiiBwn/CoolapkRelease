package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.FeedGoods;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
final class FeedBindGoodsViewPart$showAsBottomSheetDialog$3 implements View.OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $dismissAction;
    final /* synthetic */ FeedBindGoodsViewPart this$0;

    FeedBindGoodsViewPart$showAsBottomSheetDialog$3(FeedBindGoodsViewPart feedBindGoodsViewPart, Function0 function0, Activity activity) {
        this.this$0 = feedBindGoodsViewPart;
        this.$dismissAction = function0;
        this.$activity = activity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$dismissAction.invoke();
        ActionManagerCompat.INSTANCE.startGoodsSearchActivityWithCallback(this.this$0.getContext(), new Function1<FeedGoods, Unit>(this) {
            /* class com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart$showAsBottomSheetDialog$3.AnonymousClass1 */
            final /* synthetic */ FeedBindGoodsViewPart$showAsBottomSheetDialog$3 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FeedGoods feedGoods) {
                invoke(feedGoods);
                return Unit.INSTANCE;
            }

            public final void invoke(FeedGoods feedGoods) {
                if (feedGoods != null) {
                    this.this$0.this$0.insertFeedGoods(feedGoods);
                }
                Activity activity = this.this$0.$activity;
                Objects.requireNonNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                Lifecycle lifecycle = ((AppCompatActivity) activity).getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "(activity as AppCompatActivity).lifecycle");
                LifeCycleExtendsKt.oneTimeOnResume(lifecycle, new Function0<Unit>(this) {
                    /* class com.coolapk.market.view.feed.goods.FeedBindGoodsViewPart$showAsBottomSheetDialog$3.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        Handler mainThreadHandler = AppHolder.getMainThreadHandler();
                        Intrinsics.checkNotNullExpressionValue(mainThreadHandler, "AppHolder.getMainThreadHandler()");
                        mainThreadHandler.postDelayed(new FeedBindGoodsViewPart$showAsBottomSheetDialog$3$1$2$$special$$inlined$postDelayed$1(this), 300);
                    }
                });
            }
        });
        ViewExtendsKt.detachFromParent(this.this$0.getView());
    }
}
