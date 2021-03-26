package com.coolapk.market.view.feedv8;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.coolapk.market.model.FeedGoodsCategory;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 2})
/* compiled from: GoodsContentHolder.kt */
final class GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$2 implements View.OnTouchListener {
    final /* synthetic */ FeedGoodsCategory $data;
    final /* synthetic */ FrameLayout $frameLayout;
    final /* synthetic */ GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1 $updateBg$1;
    final /* synthetic */ GoodsContentHolder$showCategoryDialog$2 this$0;

    GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$2(GoodsContentHolder$showCategoryDialog$2 goodsContentHolder$showCategoryDialog$2, FeedGoodsCategory feedGoodsCategory, GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$1 goodsContentHolder$showCategoryDialog$2$onBindViewHolder$1, FrameLayout frameLayout) {
        this.this$0 = goodsContentHolder$showCategoryDialog$2;
        this.$data = feedGoodsCategory;
        this.$updateBg$1 = goodsContentHolder$showCategoryDialog$2$onBindViewHolder$1;
        this.$frameLayout = frameLayout;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FeedGoodsCategory feedGoodsCategory = this.$data;
        Intrinsics.checkNotNullExpressionValue(feedGoodsCategory, "data");
        if (((int) feedGoodsCategory.getId()) == this.this$0.$selectId.element) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        int action = motionEvent.getAction();
        int i = -1;
        if (action == 0) {
            Ref.ObjectRef objectRef = this.this$0.$tempSelectId;
            FeedGoodsCategory feedGoodsCategory2 = this.$data;
            Intrinsics.checkNotNullExpressionValue(feedGoodsCategory2, "data");
            objectRef.element = (T) Integer.valueOf((int) feedGoodsCategory2.getId());
            this.$updateBg$1.invoke();
            Iterator it2 = this.this$0.$categoryRows.iterator();
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                FeedGoodsCategory feedGoodsCategory3 = (FeedGoodsCategory) it2.next();
                Intrinsics.checkNotNullExpressionValue(feedGoodsCategory3, "it");
                if (((int) feedGoodsCategory3.getId()) == this.this$0.$selectId.element) {
                    i = i2;
                    break;
                }
                i2++;
            }
            this.this$0.notifyItemChanged(i);
        } else if (action == 1 || action == 3) {
            this.this$0.$tempSelectId.element = (T) null;
            Iterator it3 = this.this$0.$categoryRows.iterator();
            int i3 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                FeedGoodsCategory feedGoodsCategory4 = (FeedGoodsCategory) it3.next();
                Intrinsics.checkNotNullExpressionValue(feedGoodsCategory4, "it");
                if (((int) feedGoodsCategory4.getId()) == this.this$0.$selectId.element) {
                    i = i3;
                    break;
                }
                i3++;
            }
            this.this$0.notifyItemChanged(i);
            this.$frameLayout.post(new Runnable(this) {
                /* class com.coolapk.market.view.feedv8.GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$2.AnonymousClass1 */
                final /* synthetic */ GoodsContentHolder$showCategoryDialog$2$onBindViewHolder$2 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.$updateBg$1.invoke();
                }
            });
        }
        return false;
    }
}
