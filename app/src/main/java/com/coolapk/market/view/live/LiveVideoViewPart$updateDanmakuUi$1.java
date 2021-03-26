package com.coolapk.market.view.live;

import android.text.InputFilter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"showDanmaku", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
final class LiveVideoViewPart$updateDanmakuUi$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LiveVideoViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveVideoViewPart$updateDanmakuUi$1(LiveVideoViewPart liveVideoViewPart) {
        super(0);
        this.this$0 = liveVideoViewPart;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ImageView imageView = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuOpenView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.danmakuOpenView");
        imageView.setVisibility(0);
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.danmakuFrame");
        int i = 8;
        frameLayout.setVisibility(this.this$0.isDanmakuFrameShow ? 0 : 8);
        LinearLayout linearLayout = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.danmakuSendLayout");
        linearLayout.setVisibility((this.this$0.isFullScreen) || (this.this$0.isLandscape()) ? 0 : 8);
        LinearLayout linearLayout2 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomContainer");
        boolean z = linearLayout2.getTranslationY() != 0.0f;
        ImageView imageView2 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.danmakuSendView");
        imageView2.setVisibility((z || (this.this$0.isLandscape())) && !this.this$0.livePost.isPosting() ? 0 : 8);
        ProgressBar progressBar = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendProgressView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.danmakuSendProgressView");
        progressBar.setVisibility((z || (this.this$0.isLandscape())) && this.this$0.livePost.isPosting() ? 0 : 8);
        ImageView imageView3 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuPencilView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.danmakuPencilView");
        ImageView imageView4 = imageView3;
        if (z || (this.this$0.isLandscape())) {
            i = 0;
        }
        imageView4.setVisibility(i);
        ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuOpenView.setImageResource(this.this$0.isDanmakuFrameShow ? 2131231165 : 2131231164);
        EditText editText = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.danmakuSendEdit");
        editText.setHint(this.this$0.isLandscape() ? "发送弹幕，参与讨论" : "发送弹幕");
        if (!this.this$0.getViewModel().currentUserIsPresenter()) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (!loginSession.isAdmin()) {
                EditText editText2 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.danmakuSendEdit");
                editText2.setFilters((InputFilter[]) ArraysKt.plus((InputFilter.LengthFilter[]) editText2.getFilters(), this.this$0.maxLengthFilter));
                return;
            }
        }
        EditText editText3 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.danmakuSendEdit");
        EditText editText4 = ((ItemLiveVideoViewPartBinding) this.this$0.getBinding()).danmakuSendEdit;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.danmakuSendEdit");
        InputFilter[] filters = editText4.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "binding.danmakuSendEdit.filters");
        ArrayList arrayList = new ArrayList();
        for (InputFilter inputFilter : filters) {
            if (!Intrinsics.areEqual(inputFilter, this.this$0.maxLengthFilter)) {
                arrayList.add(inputFilter);
            }
        }
        Object[] array = arrayList.toArray(new InputFilter[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        editText3.setFilters((InputFilter[]) array);
    }
}
