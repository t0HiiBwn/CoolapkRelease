package com.coolapk.market.viewholder.v8;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemVideoViewPartBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.video.PlayerArg;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoAutoPlayManager;
import com.coolapk.market.widget.video.VideoManager;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.render.AspectRatio;
import com.kk.taurus.playerbase.utils.TimeUtil;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001BB\u000f\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020&H\u0016J'\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u001b2\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010*H\u0016¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0003H\u0014J\u0010\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u000201H\u0016J\u001a\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u00020\"H\u0016J\u001a\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\b\u0010=\u001a\u00020\"H\u0014J\u0010\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u000eH\u0002J\u0010\u0010@\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u000eH\u0002J\b\u0010A\u001a\u00020\"H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012¨\u0006C"}, d2 = {"Lcom/coolapk/market/viewholder/v8/VideoViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemVideoViewPartBinding;", "Lcom/coolapk/market/widget/video/VideoModel;", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "coverFunctionOnly", "", "getCoverFunctionOnly", "()Z", "setCoverFunctionOnly", "(Z)V", "data", "orderKey", "", "getOrderKey", "()I", "setOrderKey", "(I)V", "sourceKey", "", "getSourceKey", "()Ljava/lang/String;", "willFixTop", "getWillFixTop", "setWillFixTop", "checkStateForAutoPlay", "", "attach", "detachVideoIfPlaying", "getPlayerArg", "Lcom/coolapk/market/widget/video/PlayerArg;", "onAction", "actionType", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onAttach", "onBindToContent", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onDetach", "onEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onRecycled", "onViewCreated", "setCoverVisible", "visible", "setPauseCoverVisible", "startVideoFullScreen", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoViewPart.kt */
public final class VideoViewPart extends BindingViewPart<ItemVideoViewPartBinding, VideoModel> implements VideoPlayerBridge, Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558986;
    private RelationAssist assist;
    private final DataBindingComponent component;
    private boolean coverFunctionOnly;
    private VideoModel data = VideoModel.Companion.getNO_VIDEO();
    private int orderKey = -1;
    private boolean willFixTop;

    public VideoViewPart(DataBindingComponent dataBindingComponent) {
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/VideoViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getOrderKey() {
        return this.orderKey;
    }

    public final void setOrderKey(int i) {
        this.orderKey = i;
    }

    public final boolean getCoverFunctionOnly() {
        return this.coverFunctionOnly;
    }

    public final void setCoverFunctionOnly(boolean z) {
        this.coverFunctionOnly = z;
    }

    public final boolean getWillFixTop() {
        return this.willFixTop;
    }

    public final void setWillFixTop(boolean z) {
        this.willFixTop = z;
    }

    private final String getSourceKey() {
        return getClass().getSimpleName() + hashCode() + this.data.getKey();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemVideoViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558986, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemVideoViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemVideoViewPartBinding) getBinding()).itemView.setAspectRatio(1.7777778f);
        ((ItemVideoViewPartBinding) getBinding()).itemView.addOnAttachStateChangeListener(new VideoViewPart$onViewCreated$1(this));
        FrameLayout frameLayout = ((ItemVideoViewPartBinding) getBinding()).videoCoverContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoCoverContainer");
        VideoViewPart videoViewPart = this;
        ViewUtil.clickListener(frameLayout, videoViewPart);
        ImageView imageView = ((ItemVideoViewPartBinding) getBinding()).playView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.playView");
        ViewUtil.clickListener(imageView, videoViewPart);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "data");
        super.onBindToContent((VideoViewPart) videoModel);
        Fragment fragment = null;
        AppHolder.setWeakValue(getSourceKey(), null);
        this.data = videoModel;
        View root = ((ItemVideoViewPartBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setVisibility(videoModel.isValid() ? 0 : 8);
        FrameLayout frameLayout = ((ItemVideoViewPartBinding) getBinding()).videoPlayer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoPlayer");
        if (frameLayout.isAttachedToWindow()) {
            checkStateForAutoPlay(true);
        }
        DataBindingComponent dataBindingComponent = this.component;
        if (!(dataBindingComponent instanceof FragmentBindingComponent)) {
            dataBindingComponent = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) dataBindingComponent;
        if (fragmentBindingComponent != null) {
            fragment = (Fragment) fragmentBindingComponent.getContainer();
        }
        if (fragment == null) {
            AppHolder.getContextImageLoader().displayImage(getContext(), videoModel.getCoverUrl(), ((ItemVideoViewPartBinding) getBinding()).videoCover);
        } else {
            AppHolder.getFragmentImageLoader().displayImage(fragment, videoModel.getCoverUrl(), ((ItemVideoViewPartBinding) getBinding()).videoCover);
        }
        if (videoModel.isLive()) {
            LinearLayout linearLayout = ((ItemVideoViewPartBinding) getBinding()).liveViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.liveViewContainer");
            linearLayout.setVisibility(0);
            TextView textView = ((ItemVideoViewPartBinding) getBinding()).remainTimeView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.remainTimeView");
            textView.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = ((ItemVideoViewPartBinding) getBinding()).liveViewContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.liveViewContainer");
            linearLayout2.setVisibility(8);
            if (videoModel.getDuration() > 0) {
                String timeSmartFormat = TimeUtil.getTimeSmartFormat((long) videoModel.getDuration());
                TextView textView2 = ((ItemVideoViewPartBinding) getBinding()).remainTimeView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.remainTimeView");
                textView2.setText(timeSmartFormat);
                TextView textView3 = ((ItemVideoViewPartBinding) getBinding()).remainTimeView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.remainTimeView");
                textView3.setContentDescription("视频 " + timeSmartFormat);
                TextView textView4 = ((ItemVideoViewPartBinding) getBinding()).remainTimeView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.remainTimeView");
                textView4.setVisibility(0);
            } else {
                TextView textView5 = ((ItemVideoViewPartBinding) getBinding()).remainTimeView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.remainTimeView");
                textView5.setVisibility(8);
            }
        }
        setPauseCoverVisible(false);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int id = view.getId();
        if (id != 2131363129) {
            if (id == 2131363914) {
                startVideoFullScreen();
            }
        } else if (this.coverFunctionOnly) {
            startVideoFullScreen();
        } else {
            TransitionManager.beginDelayedTransition(((ItemVideoViewPartBinding) getBinding()).videoCoverContainer);
            VideoManager.INSTANCE.getSharedPlayer().attachPlayerBridge(this);
        }
    }

    /* access modifiers changed from: private */
    public final void checkStateForAutoPlay(boolean z) {
        EntityListFragment entityListFragment;
        DataBindingComponent dataBindingComponent = this.component;
        if (dataBindingComponent != null && (entityListFragment = KotlinExtendKt.getEntityListFragment(dataBindingComponent)) != null) {
            if (!this.data.isValid() || !z || this.coverFunctionOnly) {
                VideoAutoPlayManager.INSTANCE.removeFromVideoViewPartList(entityListFragment, this);
            } else {
                VideoAutoPlayManager.INSTANCE.addToVideoViewPartList(entityListFragment, this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void detachVideoIfPlaying() {
        SharedPlayer optSharePlayer;
        SharedPlayer optSharePlayer2 = VideoManager.INSTANCE.optSharePlayer();
        if (Intrinsics.areEqual(optSharePlayer2 != null ? optSharePlayer2.getPlayerBridge() : null, this) && (optSharePlayer = VideoManager.INSTANCE.optSharePlayer()) != null) {
            optSharePlayer.detachPlayerBridge();
        }
    }

    private final void setCoverVisible(boolean z) {
        int i = z ? 0 : 8;
        FrameLayout frameLayout = ((ItemVideoViewPartBinding) getBinding()).videoCoverContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoCoverContainer");
        frameLayout.setVisibility(i);
    }

    private final void setPauseCoverVisible(boolean z) {
        if (z) {
            Bitmap renderingBitmap = VideoManager.INSTANCE.getSharedPlayer().getRenderingBitmap();
            if (renderingBitmap != null) {
                ((ItemVideoViewPartBinding) getBinding()).pauseImageView.setImageBitmap(renderingBitmap);
                return;
            }
            return;
        }
        ((ItemVideoViewPartBinding) getBinding()).pauseImageView.setImageDrawable(null);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        super.onRecycled();
        AppHolder.setWeakValue(getSourceKey(), null);
        detachVideoIfPlaying();
        ImageView imageView = ((ItemVideoViewPartBinding) getBinding()).videoCover;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.videoCover");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.videoCover.context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null && !activityNullable.isDestroyed()) {
            GlideApp.with(activityNullable).clear(((ItemVideoViewPartBinding) getBinding()).videoCover);
        }
        ((ItemVideoViewPartBinding) getBinding()).videoCover.setImageDrawable(null);
        this.data = VideoModel.Companion.getNO_VIDEO();
        this.orderKey = 0;
        this.coverFunctionOnly = false;
        this.willFixTop = false;
        setPauseCoverVisible(false);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onDetach() {
        this.assist = null;
        setCoverVisible(true);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        relationAssist.setAspectRatio(AspectRatio.AspectRatio_FILL_PARENT);
        setCoverVisible(false);
        this.assist = relationAssist;
        setPauseCoverVisible(false);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        Set of = SetsKt.setOf((Object[]) new String[]{"simeple_controller_cover", "complete_cover", "loading_cover", "error_cover"});
        FrameLayout frameLayout = ((ItemVideoViewPartBinding) getBinding()).videoPlayer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoPlayer");
        return new PlayerArg(frameLayout, this.data, of, false, 8, null);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i == -99016) {
            RelationAssist relationAssist = this.assist;
            if (relationAssist != null) {
                relationAssist.stop();
            }
        } else if (i == -107) {
            Entity relatedEntity = this.data.getRelatedEntity();
            if (relatedEntity != null) {
                ActionManager.shareText(getContext(), relatedEntity);
            }
        } else if (i == -104) {
            startVideoFullScreen();
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAction(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "actionType");
        if (str.hashCode() == 647082476 && str.equals("show_pause_cover")) {
            setPauseCoverVisible(true);
        }
    }

    private final void startVideoFullScreen() {
        if (this.data.isValid()) {
            SharedPlayer optSharePlayer = VideoManager.INSTANCE.optSharePlayer();
            if (Intrinsics.areEqual(optSharePlayer != null ? optSharePlayer.getVideoModel() : null, this.data)) {
                setPauseCoverVisible(true);
            }
            if (this.coverFunctionOnly) {
                ActionManager.startVideoDetailListActivity(getContext(), this.data, ((ItemVideoViewPartBinding) getBinding()).videoPlayer, "");
                return;
            }
            AppHolder.setWeakValue(getSourceKey(), this);
            ActionManager.startVideoDetailListActivity(getContext(), this.data, ((ItemVideoViewPartBinding) getBinding()).videoPlayer, getSourceKey());
        }
    }
}
