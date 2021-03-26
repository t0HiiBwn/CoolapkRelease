package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.VideoCompleteBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/widget/video/cover/CompleteCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoCompleteBinding;", "onGroupValueUpdateListener", "com/coolapk/market/widget/video/cover/CompleteCover$onGroupValueUpdateListener$1", "Lcom/coolapk/market/widget/video/cover/CompleteCover$onGroupValueUpdateListener$1;", "getCoverLevel", "", "onClick", "", "v", "Landroid/view/View;", "onCoverAttachedToWindow", "onCoverDetachedToWindow", "onCreateCoverView", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onReceiverBind", "onReceiverEvent", "onReceiverUnBind", "setPlayCompleteState", "state", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CompleteCover.kt */
public final class CompleteCover extends ThemeableCover {
    private VideoCompleteBinding binding;
    private final CompleteCover$onGroupValueUpdateListener$1 onGroupValueUpdateListener = new CompleteCover$onGroupValueUpdateListener$1();

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverEvent(int i, Bundle bundle) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompleteCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131363254) {
            requestReplay(null);
            setPlayCompleteState(false);
        } else if (id == 2131363374) {
            notifyReceiverEvent(-107, null);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        VideoCompleteBinding videoCompleteBinding = this.binding;
        if (videoCompleteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CompleteCover completeCover = this;
        videoCompleteBinding.replayView.setOnClickListener(completeCover);
        VideoCompleteBinding videoCompleteBinding2 = this.binding;
        if (videoCompleteBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoCompleteBinding2.shareView.setOnClickListener(completeCover);
        getGroupValue().registerOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        int i = 8;
        setCoverVisibility(8);
        if (getGroupValue().getBoolean("complete_show")) {
            setPlayCompleteState(true);
        }
        boolean z = getGroupValue().getBoolean("share_view_visible", true);
        VideoCompleteBinding videoCompleteBinding = this.binding;
        if (videoCompleteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = videoCompleteBinding.shareView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.shareView");
        if (z) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverDetachedToWindow() {
        super.onCoverDetachedToWindow();
        setCoverVisibility(8);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        getGroupValue().unregisterOnGroupValueUpdateListener(this.onGroupValueUpdateListener);
    }

    private final void setPlayCompleteState(boolean z) {
        setCoverVisibility(z ? 0 : 8);
        getGroupValue().putBoolean("complete_show", z);
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        switch (i) {
            case -99016:
                setPlayCompleteState(true);
                return;
            case -99015:
            case -99001:
                setPlayCompleteState(false);
                return;
            default:
                return;
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559298, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…eo_complete, null, false)");
        VideoCompleteBinding videoCompleteBinding = (VideoCompleteBinding) inflate;
        this.binding = videoCompleteBinding;
        if (videoCompleteBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoCompleteBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelMedium(20);
    }
}
