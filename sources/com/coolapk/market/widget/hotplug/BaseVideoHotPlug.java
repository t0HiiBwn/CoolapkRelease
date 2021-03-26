package com.coolapk.market.widget.hotplug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.databinding.DataBindingComponent;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import com.coolapk.market.widget.video.VideoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/widget/hotplug/BaseVideoHotPlug;", "Lcom/coolapk/market/widget/hotplug/ViewPartHotPlug;", "Lcom/coolapk/market/viewholder/v8/VideoViewPart;", "Lcom/coolapk/market/widget/video/VideoModel;", "viewToReplace", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "viewPartPool", "Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "useListPadding", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/widget/hotplug/ViewPartPool;Z)V", "initParent", "Landroid/view/ViewGroup;", "bindData", "", "viewPart", "data", "createViewPart", "onViewPartLoad", "recycleViewPart", "setOrderKey", "order", "", "shouldShowView", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BaseVideoHotPlug.kt */
public class BaseVideoHotPlug extends ViewPartHotPlug<VideoViewPart, VideoModel> {
    private final DataBindingComponent component;
    private final ViewGroup initParent;
    private final View viewToReplace;

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ BaseVideoHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, dataBindingComponent, viewPartPool, (i & 8) != 0 ? true : z);
        if ((i & 4) != 0) {
            viewPartPool = dataBindingComponent != null ? KotlinExtendKt.getViewPartPool(dataBindingComponent) : null;
            if (viewPartPool == null) {
                viewPartPool = new ViewPartPool();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseVideoHotPlug(View view, DataBindingComponent dataBindingComponent, ViewPartPool viewPartPool, boolean z) {
        super(-917611398, viewPartPool, z);
        Intrinsics.checkNotNullParameter(view, "viewToReplace");
        Intrinsics.checkNotNullParameter(viewPartPool, "viewPartPool");
        this.viewToReplace = view;
        this.component = dataBindingComponent;
        ViewParent parent = view.getParent();
        this.initParent = (ViewGroup) (!(parent instanceof ViewGroup) ? null : parent);
    }

    /* access modifiers changed from: protected */
    public boolean shouldShowView(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "data");
        return videoModel.isValid();
    }

    /* access modifiers changed from: protected */
    public void recycleViewPart(VideoViewPart videoViewPart) {
        Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
        ViewUtil.replaceView(videoViewPart.getView(), this.viewToReplace);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.widget.hotplug.ViewPartHotPlug
    public VideoViewPart createViewPart() {
        VideoViewPart videoViewPart = new VideoViewPart(this.component);
        LayoutInflater from = LayoutInflater.from(this.viewToReplace.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewToReplace.context)");
        videoViewPart.createView(from, this.initParent);
        return videoViewPart;
    }

    /* access modifiers changed from: protected */
    public void onViewPartLoad(VideoViewPart videoViewPart) {
        Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
        ViewUtil.replaceView(this.viewToReplace, videoViewPart.getView());
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(videoViewPart.getView());
        if (marginParams != null) {
            marginParams.topMargin = ConvertUtils.dp2px(12.0f);
            marginParams.leftMargin = getAssumedPadding();
            marginParams.rightMargin = getAssumedPadding();
            marginParams.bottomMargin = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void bindData(VideoViewPart videoViewPart, VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoViewPart, "viewPart");
        Intrinsics.checkNotNullParameter(videoModel, "data");
        videoViewPart.bindToContent(videoModel);
    }

    public final void setOrderKey(int i) {
        VideoViewPart videoViewPart = (VideoViewPart) optViewPart();
        if (videoViewPart != null) {
            videoViewPart.setOrderKey(i);
        }
    }
}
