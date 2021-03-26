package com.coolapk.market.view.live;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blankj.utilcode.util.KeyboardUtils;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.view.live.LivePost;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/coolapk/market/view/live/LiveVideoViewPart$onViewCreated$8", "Lcom/coolapk/market/view/live/LivePost$Callback;", "onError", "", "error", "", "onNext", "data", "", "Lcom/coolapk/market/model/LiveMessage;", "onSubscribe", "onUnsubscribe", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
public final class LiveVideoViewPart$onViewCreated$8 implements LivePost.Callback {
    final /* synthetic */ LiveVideoViewPart this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    LiveVideoViewPart$onViewCreated$8(LiveVideoViewPart liveVideoViewPart) {
        this.this$0 = liveVideoViewPart;
    }

    @Override // com.coolapk.market.view.live.LivePost.Callback
    public void onSubscribe() {
        ImageView imageView = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.danmakuSendView");
        imageView.setVisibility(8);
        ProgressBar progressBar = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendProgressView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.danmakuSendProgressView");
        progressBar.setVisibility(0);
        ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit.clearFocus();
    }

    @Override // com.coolapk.market.view.live.LivePost.Callback
    public void onNext(List<? extends LiveMessage> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        EventBus.getDefault().post(new LiveMessageEvent(3, list, "0", null, null, 24, null));
        if (!((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit.hasFocus()) {
            EditText editText = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.danmakuSendEdit");
            editText.getText().clear();
            KeyboardUtils.hideSoftInput(((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit);
        }
        ImageView imageView = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.danmakuSendView");
        imageView.setVisibility(0);
        ProgressBar progressBar = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendProgressView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.danmakuSendProgressView");
        progressBar.setVisibility(8);
    }

    @Override // com.coolapk.market.view.live.LivePost.Callback
    public void onError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(this.this$0.getActivity(), th);
        ImageView imageView = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.danmakuSendView");
        imageView.setVisibility(0);
        ProgressBar progressBar = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendProgressView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.danmakuSendProgressView");
        progressBar.setVisibility(8);
    }

    @Override // com.coolapk.market.view.live.LivePost.Callback
    public void onUnsubscribe() {
        ImageView imageView = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.danmakuSendView");
        imageView.setVisibility(0);
        ProgressBar progressBar = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendProgressView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.danmakuSendProgressView");
        progressBar.setVisibility(8);
    }
}
