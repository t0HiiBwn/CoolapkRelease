package com.coolapk.market.view.video;

import android.app.Activity;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemVideoDetailViewPartBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.widget.video.PlayerArg;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0014J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/video/SimpleVideoDetailViewPart;", "Lcom/coolapk/market/view/video/BaseVideoDetailViewPart;", "Lcom/coolapk/market/databinding/ItemVideoDetailViewPartBinding;", "Lcom/coolapk/market/widget/video/VideoModel;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "detailControlCover", "Lcom/coolapk/market/view/video/DetailControlCover;", "lastWindowsRect", "Landroid/graphics/Rect;", "applyWindowsInset", "", "rect", "getPlayerArg", "Lcom/coolapk/market/widget/video/PlayerArg;", "onAnimationEvent", "isOpenAnimation", "", "isStartEvent", "onAttach", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "onBindToContent", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleVideoDetailViewPart.kt */
public final class SimpleVideoDetailViewPart extends BaseVideoDetailViewPart<ItemVideoDetailViewPartBinding, VideoModel> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558991;
    private DetailControlCover detailControlCover;
    private Rect lastWindowsRect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleVideoDetailViewPart(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static final /* synthetic */ DetailControlCover access$getDetailControlCover$p(SimpleVideoDetailViewPart simpleVideoDetailViewPart) {
        DetailControlCover detailControlCover2 = simpleVideoDetailViewPart.detailControlCover;
        if (detailControlCover2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
        }
        return detailControlCover2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/video/SimpleVideoDetailViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SimpleVideoDetailViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemVideoDetailViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558991, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemVideoDetailViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart, com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemVideoDetailViewPartBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        super.applyWindowsInset(rect);
        ((ItemVideoDetailViewPartBinding) getBinding()).topContainer.setPadding(0, rect.top - NumberExtendsKt.getDp((Number) 4), rect.right, 0);
        ((ItemVideoDetailViewPartBinding) getBinding()).bottomContainer.setPadding(0, 0, rect.right, rect.bottom);
        this.lastWindowsRect = rect;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "data");
        super.onBindToContent((SimpleVideoDetailViewPart) videoModel);
        setData$presentation_coolapkAppRelease(videoModel);
        TextView textView = ((ItemVideoDetailViewPartBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(videoModel.getTitle());
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart, com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        if (this.detailControlCover == null) {
            this.detailControlCover = DetailControlCover.Companion.createWith((ItemVideoDetailViewPartBinding) getBinding());
        }
        IReceiverGroup receiverGroup = relationAssist.getReceiverGroup();
        DetailControlCover detailControlCover2 = this.detailControlCover;
        if (detailControlCover2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
        }
        receiverGroup.addReceiver("proxy_cover", detailControlCover2);
        super.onAttach(relationAssist);
        IReceiverGroup receiverGroup2 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup2, "assist.receiverGroup");
        receiverGroup2.getGroupValue().putBoolean("isLandscape", isLandScape$presentation_coolapkAppRelease());
        IReceiverGroup receiverGroup3 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup3, "assist.receiverGroup");
        receiverGroup3.getGroupValue().putBoolean("hide_frame_content", true);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        FrameLayout frameLayout = ((ItemVideoDetailViewPartBinding) getBinding()).videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
        return new PlayerArg(frameLayout, getData$presentation_coolapkAppRelease(), SetsKt.setOf((Object[]) new String[]{"gesture_cover", "loading_cover", "error_cover"}), false);
    }

    @Override // com.coolapk.market.view.video.BaseVideoDetailViewPart
    public void onAnimationEvent(boolean z, boolean z2) {
        super.onAnimationEvent(z, z2);
        if (z && !z2) {
            getReceiverGroup$presentation_coolapkAppRelease().getGroupValue().putBoolean("hide_frame_content", false);
            DetailControlCover detailControlCover2 = this.detailControlCover;
            if (detailControlCover2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailControlCover");
            }
            BaseControlCover.setControllerState$default(detailControlCover2, true, null, 2, null);
        }
        if (!z && z2) {
            LinearLayout linearLayout = ((ItemVideoDetailViewPartBinding) getBinding()).topContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topContainer");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = ((ItemVideoDetailViewPartBinding) getBinding()).bottomContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
            linearLayout2.setVisibility(8);
        }
    }
}
