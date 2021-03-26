package com.coolapk.market.view.feed.vote;

import android.graphics.drawable.ShapeDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.widget.view.VotePKTagShape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nJ\b\u0010\f\u001a\u00020\u0006H\u0014¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteDetailPKViewPart;", "Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "bindVoteDetail", "", "data", "Lcom/coolapk/market/model/Feed;", "voteListener", "Lkotlin/Function1;", "", "onViewCreated", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VotePKViewPart.kt */
public final class VoteDetailPKViewPart extends VotePKViewPart {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteDetailPKViewPart(DataBindingComponent dataBindingComponent) {
        super(dataBindingComponent);
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Override // com.coolapk.market.view.feed.vote.VotePKViewPart, com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = getBinding$presentation_coolapkAppRelease().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getLayoutParams().height = NumberExtendsKt.getDp((Number) 42);
        TextView textView = getBinding$presentation_coolapkAppRelease().pkLeftTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkLeftTextView");
        textView.setTextSize(14.0f);
        TextView textView2 = getBinding$presentation_coolapkAppRelease().pkRightTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkRightTextView");
        textView2.setTextSize(14.0f);
        TextView textView3 = getBinding$presentation_coolapkAppRelease().pkVsView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pkVsView");
        textView3.setTextSize(27.0f);
    }

    public final void bindVoteDetail(Feed feed, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(feed, "data");
        setFeed$presentation_coolapkAppRelease(feed);
        Vote vote = feed.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        VoteOption voteOption = vote.getVoteOptions().get(0);
        VoteOption voteOption2 = vote.getVoteOptions().get(1);
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionLeft");
        Integer stringToColor = ColorUtils.stringToColor(voteOption.getColor());
        if (stringToColor == null) {
            stringToColor = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099790));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
        int intValue = stringToColor.intValue();
        Intrinsics.checkNotNullExpressionValue(voteOption2, "optionRight");
        Integer stringToColor2 = ColorUtils.stringToColor(voteOption2.getColor());
        if (stringToColor2 == null) {
            stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099789));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
        int intValue2 = stringToColor2.intValue();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  VS  ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue), 2, 3, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue2), 3, 4, 33);
        TextView textView = getBinding$presentation_coolapkAppRelease().pkVsView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkVsView");
        textView.setText(spannableStringBuilder);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new VotePKTagShape(true));
        LinearLayout linearLayout = getBinding$presentation_coolapkAppRelease().pkLeftView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkLeftView");
        linearLayout.setBackground(ViewExtendsKt.tintColor(shapeDrawable, intValue));
        getBinding$presentation_coolapkAppRelease().pkLeftTextView.setTextColor(-1);
        ImageView imageView = getBinding$presentation_coolapkAppRelease().pkLeftCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.pkLeftCheckView");
        imageView.setVisibility(8);
        TextView textView2 = getBinding$presentation_coolapkAppRelease().pkLeftTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkLeftTextView");
        textView2.setText(voteOption.getTitle());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new VotePKTagShape(false));
        LinearLayout linearLayout2 = getBinding$presentation_coolapkAppRelease().pkRightView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pkRightView");
        linearLayout2.setBackground(ViewExtendsKt.tintColor(shapeDrawable2, intValue2));
        getBinding$presentation_coolapkAppRelease().pkRightTextView.setTextColor(-1);
        ImageView imageView2 = getBinding$presentation_coolapkAppRelease().pkRightCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pkRightCheckView");
        imageView2.setVisibility(8);
        TextView textView3 = getBinding$presentation_coolapkAppRelease().pkRightTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pkRightTextView");
        textView3.setText(voteOption2.getTitle());
        if (function1 != null) {
            getBinding$presentation_coolapkAppRelease().pkLeftView.setOnClickListener(new VoteDetailPKViewPart$bindVoteDetail$1(function1, voteOption));
            getBinding$presentation_coolapkAppRelease().pkRightView.setOnClickListener(new VoteDetailPKViewPart$bindVoteDetail$2(function1, voteOption2));
        } else {
            LinearLayout linearLayout3 = getBinding$presentation_coolapkAppRelease().pkLeftView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pkLeftView");
            linearLayout3.setClickable(false);
            LinearLayout linearLayout4 = getBinding$presentation_coolapkAppRelease().pkRightView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.pkRightView");
            linearLayout4.setClickable(false);
        }
        getBinding$presentation_coolapkAppRelease().executePendingBindings();
    }
}
