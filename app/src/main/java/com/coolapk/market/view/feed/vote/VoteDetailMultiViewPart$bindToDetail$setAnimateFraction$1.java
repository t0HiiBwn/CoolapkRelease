package com.coolapk.market.view.feed.vote;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.databinding.ItemFeedVoteMultiBinding;
import com.coolapk.market.model.VoteOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: VoteMultiViewPart.kt */
final class VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ ClipDrawable $clipDrawable;
    final /* synthetic */ LayerDrawable $layerDrawable;
    final /* synthetic */ VoteOption $option;
    final /* synthetic */ float $percentFloat;
    final /* synthetic */ VoteDetailMultiViewPart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1(VoteDetailMultiViewPart voteDetailMultiViewPart, ClipDrawable clipDrawable, float f, LayerDrawable layerDrawable, VoteOption voteOption) {
        super(1);
        this.this$0 = voteDetailMultiViewPart;
        this.$clipDrawable = clipDrawable;
        this.$percentFloat = f;
        this.$layerDrawable = layerDrawable;
        this.$option = voteOption;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Float f) {
        invoke(f.floatValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0042: INVOKE  (r2v5 int) = 
      (wrap: float : 0x0040: ARITH  (r2v4 float) = (wrap: float : 0x003f: CAST (r2v3 float) = (float) (wrap: int : 0x003b: INVOKE  (r2v2 int) = 
      (wrap: com.coolapk.market.model.VoteOption : 0x0039: IGET  (r2v1 com.coolapk.market.model.VoteOption) = 
      (r3v0 'this' com.coolapk.market.view.feed.vote.VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1 A[IMMUTABLE_TYPE, THIS])
     com.coolapk.market.view.feed.vote.VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1.$option com.coolapk.market.model.VoteOption)
     type: VIRTUAL call: com.coolapk.market.model.VoteOption.getTotalSelectNum():int)) * (r4v0 float))
     type: STATIC call: kotlin.math.MathKt.roundToInt(float):int), (31080 char)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0074: INVOKE  (r4v3 int) = 
      (wrap: float : 0x0072: ARITH  (r2v9 float) = (wrap: float : 0x006d: ARITH  (r2v8 float) = (wrap: float : 0x006b: IGET  (r2v7 float) = 
      (r3v0 'this' com.coolapk.market.view.feed.vote.VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1 A[IMMUTABLE_TYPE, THIS])
     com.coolapk.market.view.feed.vote.VoteDetailMultiViewPart$bindToDetail$setAnimateFraction$1.$percentFloat float) * (r4v0 float)) * (wrap: float : 0x0071: CAST (r4v2 float) = (float) (100 int)))
     type: STATIC call: kotlin.math.MathKt.roundToInt(float):int), ('%' char)] */
    public final void invoke(float f) {
        this.$clipDrawable.setLevel((int) (((float) 10000) * this.$percentFloat * f));
        LinearLayout linearLayout = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.rootView");
        linearLayout.setBackground(this.$layerDrawable);
        TextView textView = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).totalVoteNumView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.totalVoteNumView");
        StringBuilder sb = new StringBuilder();
        sb.append(MathKt.roundToInt(((float) this.$option.getTotalSelectNum()) * f));
        sb.append((char) 31080);
        textView.setText(sb.toString());
        TextView textView2 = ((ItemFeedVoteMultiBinding) this.this$0.getBinding()).percentView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.percentView");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(MathKt.roundToInt(this.$percentFloat * f * ((float) 100)));
        sb2.append('%');
        textView2.setText(sb2.toString());
    }
}
