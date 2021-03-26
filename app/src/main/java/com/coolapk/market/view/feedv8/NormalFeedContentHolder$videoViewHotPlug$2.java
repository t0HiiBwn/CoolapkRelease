package com.coolapk.market.view.feedv8;

import android.view.ViewGroup;
import android.widget.Space;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import com.coolapk.market.widget.hotplug.BaseVideoHotPlug;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/coolapk/market/view/feedv8/NormalFeedContentHolder$videoViewHotPlug$2$1", "invoke", "()Lcom/coolapk/market/view/feedv8/NormalFeedContentHolder$videoViewHotPlug$2$1;"}, k = 3, mv = {1, 4, 2})
/* compiled from: NormalFeedContentHolder.kt */
final class NormalFeedContentHolder$videoViewHotPlug$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ NormalFeedContentHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NormalFeedContentHolder$videoViewHotPlug$2(NormalFeedContentHolder normalFeedContentHolder) {
        super(0);
        this.this$0 = normalFeedContentHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        Space space = this.this$0.getBinding$presentation_coolapkAppRelease().videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.videoPlayerSpaceView");
        return new BaseVideoHotPlug(this, space, null) {
            /* class com.coolapk.market.view.feedv8.NormalFeedContentHolder$videoViewHotPlug$2.AnonymousClass1 */
            final /* synthetic */ NormalFeedContentHolder$videoViewHotPlug$2 this$0;

            {
                this.this$0 = r8;
            }

            /* access modifiers changed from: protected */
            @Override // com.coolapk.market.widget.hotplug.BaseVideoHotPlug
            public void onViewPartLoad(VideoViewPart videoViewPart) {
                Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
                super.onViewPartLoad(videoViewPart);
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(videoViewPart.getView());
                if (marginParams != null) {
                    marginParams.topMargin = ConvertUtils.dp2px(8.0f);
                    marginParams.leftMargin = ConvertUtils.dp2px(16.0f);
                    marginParams.rightMargin = ConvertUtils.dp2px(16.0f);
                    marginParams.bottomMargin = ConvertUtils.dp2px(10.0f);
                }
                videoViewPart.setCoverFunctionOnly(true);
            }
        };
    }
}
