package com.coolapk.market.view.feed.vote;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.coolapk.market.databinding.ItemFeedVotePkResultBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.view.VoteResultShape;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VotePKResultDetailViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemFeedVotePkResultBinding;", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "drawableShape", "Lcom/coolapk/market/widget/view/VoteResultShape;", "feed", "Lcom/coolapk/market/model/Feed;", "haveShownAnimation", "", "bindResult", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "setPercentView", "leftPercent", "", "rightPercent", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VotePKResultDetailViewPart.kt */
public final class VotePKResultDetailViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558750;
    private ItemFeedVotePkResultBinding binding;
    private final DataBindingComponent component;
    private VoteResultShape drawableShape;
    private Feed feed;
    private boolean haveShownAnimation;

    public VotePKResultDetailViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VotePKResultDetailViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VotePKResultDetailViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final Context getContext() {
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding = this.binding;
        if (itemFeedVotePkResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemFeedVotePkResultBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root.getContext();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558750, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding = (ItemFeedVotePkResultBinding) inflate;
        this.binding = itemFeedVotePkResultBinding;
        if (itemFeedVotePkResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemFeedVotePkResultBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding = this.binding;
        if (itemFeedVotePkResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkResultBinding.pkLeftPercentView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkLeftPercentView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding2 = this.binding;
        if (itemFeedVotePkResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = itemFeedVotePkResultBinding2.pkRightPercentView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkRightPercentView");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context2));
    }

    public final void bindResult(Feed feed2) {
        double d;
        Intrinsics.checkNotNullParameter(feed2, "data");
        this.feed = feed2;
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        List<String> userVoteIds = EntityExtendsKt.getUserVoteIds(vote);
        VoteOption voteOption = vote.getVoteOptions().get(0);
        VoteOption voteOption2 = vote.getVoteOptions().get(1);
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionLeft");
        Integer stringToColor = ColorUtils.stringToColor(voteOption.getColor());
        if (stringToColor == null) {
            stringToColor = Integer.valueOf(ResourceUtils.getColorInt(getContext(), 2131099792));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
        int intValue = stringToColor.intValue();
        Intrinsics.checkNotNullExpressionValue(voteOption2, "optionRight");
        Integer stringToColor2 = ColorUtils.stringToColor(voteOption2.getColor());
        if (stringToColor2 == null) {
            stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(getContext(), 2131099791));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
        int intValue2 = stringToColor2.intValue();
        float f = (float) 100;
        float totalSelectNum = (((float) voteOption.getTotalSelectNum()) / ((float) (voteOption.getTotalSelectNum() + voteOption2.getTotalSelectNum()))) * f;
        if (voteOption.getTotalSelectNum() >= voteOption2.getTotalSelectNum()) {
            d = Math.rint((double) (totalSelectNum + 0.5f));
        } else {
            d = Math.rint((double) (totalSelectNum - 0.5f));
        }
        float f2 = ((float) d) / f;
        float f3 = ((float) 1) - f2;
        String[] strArr = {voteOption.getId(), voteOption2.getId()};
        int[] iArr = {intValue, intValue2};
        boolean contains = userVoteIds.contains(voteOption.getId());
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding = this.binding;
        if (itemFeedVotePkResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkResultBinding.pkLeftCountView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkLeftCountView");
        textView.setText(String.valueOf(voteOption.getTotalSelectNum()));
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding2 = this.binding;
        if (itemFeedVotePkResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding2.pkLeftPercentView.setTextColor(intValue);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding3 = this.binding;
        if (itemFeedVotePkResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding3.pkLeftCountView.setTextColor(-1);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding4 = this.binding;
        if (itemFeedVotePkResultBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = itemFeedVotePkResultBinding4.pkLeftCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.pkLeftCheckView");
        imageView.setVisibility(contains ? 0 : 8);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding5 = this.binding;
        if (itemFeedVotePkResultBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding5.pkLeftTitleView.setTextColor(intValue);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding6 = this.binding;
        if (itemFeedVotePkResultBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = itemFeedVotePkResultBinding6.pkLeftTitleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkLeftTitleView");
        textView2.setText(voteOption.getTitle());
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding7 = this.binding;
        if (itemFeedVotePkResultBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding7.leftView.setOnClickListener(new VotePKResultDetailViewPart$bindResult$1(this, feed2, voteOption, strArr, iArr));
        boolean contains2 = userVoteIds.contains(voteOption2.getId());
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding8 = this.binding;
        if (itemFeedVotePkResultBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = itemFeedVotePkResultBinding8.pkRightCountView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pkRightCountView");
        textView3.setText(String.valueOf(voteOption2.getTotalSelectNum()));
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding9 = this.binding;
        if (itemFeedVotePkResultBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding9.pkRightPercentView.setTextColor(intValue2);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding10 = this.binding;
        if (itemFeedVotePkResultBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding10.pkRightCountView.setTextColor(-1);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding11 = this.binding;
        if (itemFeedVotePkResultBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = itemFeedVotePkResultBinding11.pkRightCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pkRightCheckView");
        imageView2.setVisibility(contains2 ? 0 : 8);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding12 = this.binding;
        if (itemFeedVotePkResultBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding12.pkRightTitleView.setTextColor(intValue2);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding13 = this.binding;
        if (itemFeedVotePkResultBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView4 = itemFeedVotePkResultBinding13.pkRightTitleView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.pkRightTitleView");
        textView4.setText(voteOption2.getTitle());
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding14 = this.binding;
        if (itemFeedVotePkResultBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding14.rightView.setOnClickListener(new VotePKResultDetailViewPart$bindResult$2(this, feed2, voteOption2, strArr, iArr));
        this.drawableShape = new VoteResultShape(intValue, intValue2, f2, NumberExtendsKt.getDp((Number) 9));
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding15 = this.binding;
        if (itemFeedVotePkResultBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = itemFeedVotePkResultBinding15.pkResultView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultView");
        VoteResultShape voteResultShape = this.drawableShape;
        if (voteResultShape == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawableShape");
        }
        linearLayout.setBackground(new ShapeDrawable(voteResultShape));
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding16 = this.binding;
        if (itemFeedVotePkResultBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkResultBinding16.executePendingBindings();
        if (this.haveShownAnimation) {
            setPercentView(f2, f3);
            return;
        }
        setPercentView(0.0f, 0.0f);
        this.haveShownAnimation = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new VotePKResultDetailViewPart$bindResult$$inlined$apply$lambda$1(this, f2, f3));
        valueAnimator.setDuration(1200L);
        valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimator.start();
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0041: CAST (r3v3 int) = (int) (wrap: float : 0x003f: ARITH  (r3v2 float) = (r3v1 float) * (r7v0 float))), ('%' char)] */
    /* access modifiers changed from: private */
    public final void setPercentView(float f, float f2) {
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding = this.binding;
        if (itemFeedVotePkResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkResultBinding.pkLeftPercentView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkLeftPercentView");
        StringBuilder sb = new StringBuilder();
        float f3 = (float) 100;
        sb.append((int) (f * f3));
        sb.append('%');
        textView.setText(sb.toString());
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding2 = this.binding;
        if (itemFeedVotePkResultBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = itemFeedVotePkResultBinding2.pkRightPercentView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkRightPercentView");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((int) (f3 * f2));
        sb2.append('%');
        textView2.setText(sb2.toString());
        VoteResultShape voteResultShape = this.drawableShape;
        if (voteResultShape == null) {
            Intrinsics.throwUninitializedPropertyAccessException("drawableShape");
        }
        voteResultShape.setPercents(f, f2);
        ItemFeedVotePkResultBinding itemFeedVotePkResultBinding3 = this.binding;
        if (itemFeedVotePkResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = itemFeedVotePkResultBinding3.pkResultView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkResultView");
        Drawable background = linearLayout.getBackground();
        if (background != null) {
            background.invalidateSelf();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (this.feed != null && view.getId() != 2131363607) {
            super.onClick(view);
        }
    }
}
