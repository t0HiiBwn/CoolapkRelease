package com.coolapk.market.view.feed.vote;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemFeedVotePkBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.widget.view.VotePKTagShape;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0019H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VotePKViewPart;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemFeedVotePkBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/ItemFeedVotePkBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/ItemFeedVotePkBinding;)V", "getComponent", "()Landroidx/databinding/DataBindingComponent;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext$presentation_coolapkAppRelease", "()Landroid/content/Context;", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed$presentation_coolapkAppRelease", "()Lcom/coolapk/market/model/Feed;", "setFeed$presentation_coolapkAppRelease", "(Lcom/coolapk/market/model/Feed;)V", "bindToDisplay", "", "data", "bindUserVoteComment", "onClick", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VotePKViewPart.kt */
public class VotePKViewPart extends ViewPart {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558749;
    public ItemFeedVotePkBinding binding;
    private final DataBindingComponent component;
    private Feed feed;

    public VotePKViewPart(DataBindingComponent dataBindingComponent) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
    }

    public final DataBindingComponent getComponent() {
        return this.component;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VotePKViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VotePKViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Feed getFeed$presentation_coolapkAppRelease() {
        return this.feed;
    }

    public final void setFeed$presentation_coolapkAppRelease(Feed feed2) {
        this.feed = feed2;
    }

    public final ItemFeedVotePkBinding getBinding$presentation_coolapkAppRelease() {
        ItemFeedVotePkBinding itemFeedVotePkBinding = this.binding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return itemFeedVotePkBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(ItemFeedVotePkBinding itemFeedVotePkBinding) {
        Intrinsics.checkNotNullParameter(itemFeedVotePkBinding, "<set-?>");
        this.binding = itemFeedVotePkBinding;
    }

    public final Context getContext$presentation_coolapkAppRelease() {
        ItemFeedVotePkBinding itemFeedVotePkBinding = this.binding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemFeedVotePkBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root.getContext();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558749, viewGroup, false, this.component);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…wGroup, false, component)");
        ItemFeedVotePkBinding itemFeedVotePkBinding = (ItemFeedVotePkBinding) inflate;
        this.binding = itemFeedVotePkBinding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = itemFeedVotePkBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ItemFeedVotePkBinding itemFeedVotePkBinding = this.binding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkBinding.setClick(this);
        ItemFeedVotePkBinding itemFeedVotePkBinding2 = this.binding;
        if (itemFeedVotePkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkBinding2.pkVsView;
        Context context$presentation_coolapkAppRelease = getContext$presentation_coolapkAppRelease();
        Intrinsics.checkNotNullExpressionValue(context$presentation_coolapkAppRelease, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context$presentation_coolapkAppRelease), 3);
    }

    public final void bindUserVoteComment(Feed feed2) {
        List list;
        Intrinsics.checkNotNullParameter(feed2, "data");
        this.feed = feed2;
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        String extraKey = feed2.getExtraKey();
        if (extraKey == null || (list = StringsKt.split$default((CharSequence) extraKey, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            list = CollectionsKt.emptyList();
        }
        VoteOption voteOption = vote.getVoteOptions().get(0);
        VoteOption voteOption2 = vote.getVoteOptions().get(1);
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionLeft");
        Integer stringToColor = ColorUtils.stringToColor(voteOption.getColor());
        if (stringToColor == null) {
            stringToColor = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099792));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
        int intValue = stringToColor.intValue();
        Intrinsics.checkNotNullExpressionValue(voteOption2, "optionRight");
        Integer stringToColor2 = ColorUtils.stringToColor(voteOption2.getColor());
        if (stringToColor2 == null) {
            stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099791));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
        int intValue2 = stringToColor2.intValue();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  VS  ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue), 2, 3, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue2), 3, 4, 33);
        ItemFeedVotePkBinding itemFeedVotePkBinding = this.binding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkBinding.pkVsView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkVsView");
        textView.setText(spannableStringBuilder);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new VotePKTagShape(true));
        if (list.contains(voteOption.getId())) {
            ItemFeedVotePkBinding itemFeedVotePkBinding2 = this.binding;
            if (itemFeedVotePkBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = itemFeedVotePkBinding2.pkLeftView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkLeftView");
            linearLayout.setBackground(ViewExtendsKt.tintColor(shapeDrawable, intValue));
            ItemFeedVotePkBinding itemFeedVotePkBinding3 = this.binding;
            if (itemFeedVotePkBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = itemFeedVotePkBinding3.pkLeftCheckView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.pkLeftCheckView");
            imageView.setVisibility(0);
            ItemFeedVotePkBinding itemFeedVotePkBinding4 = this.binding;
            if (itemFeedVotePkBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemFeedVotePkBinding4.pkLeftTextView.setTextColor(-1);
        } else {
            int adjustAlpha = ColorUtils.adjustAlpha(intValue, 0.1f);
            ItemFeedVotePkBinding itemFeedVotePkBinding5 = this.binding;
            if (itemFeedVotePkBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = itemFeedVotePkBinding5.pkLeftView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pkLeftView");
            linearLayout2.setBackground(ViewExtendsKt.tintColor(shapeDrawable, adjustAlpha));
            ItemFeedVotePkBinding itemFeedVotePkBinding6 = this.binding;
            if (itemFeedVotePkBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = itemFeedVotePkBinding6.pkLeftCheckView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pkLeftCheckView");
            imageView2.setVisibility(8);
            ItemFeedVotePkBinding itemFeedVotePkBinding7 = this.binding;
            if (itemFeedVotePkBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemFeedVotePkBinding7.pkLeftTextView.setTextColor(intValue);
        }
        ItemFeedVotePkBinding itemFeedVotePkBinding8 = this.binding;
        if (itemFeedVotePkBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = itemFeedVotePkBinding8.pkLeftTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkLeftTextView");
        textView2.setText(voteOption.getTitle());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new VotePKTagShape(false));
        if (list.contains(voteOption2.getId())) {
            ItemFeedVotePkBinding itemFeedVotePkBinding9 = this.binding;
            if (itemFeedVotePkBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout3 = itemFeedVotePkBinding9.pkRightView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pkRightView");
            linearLayout3.setBackground(ViewExtendsKt.tintColor(shapeDrawable2, intValue2));
            ItemFeedVotePkBinding itemFeedVotePkBinding10 = this.binding;
            if (itemFeedVotePkBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemFeedVotePkBinding10.pkRightTextView.setTextColor(-1);
            ItemFeedVotePkBinding itemFeedVotePkBinding11 = this.binding;
            if (itemFeedVotePkBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView3 = itemFeedVotePkBinding11.pkRightCheckView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.pkRightCheckView");
            imageView3.setVisibility(0);
        } else {
            int adjustAlpha2 = ColorUtils.adjustAlpha(intValue2, 0.1f);
            ItemFeedVotePkBinding itemFeedVotePkBinding12 = this.binding;
            if (itemFeedVotePkBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout4 = itemFeedVotePkBinding12.pkRightView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.pkRightView");
            linearLayout4.setBackground(ViewExtendsKt.tintColor(shapeDrawable2, adjustAlpha2));
            ItemFeedVotePkBinding itemFeedVotePkBinding13 = this.binding;
            if (itemFeedVotePkBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            itemFeedVotePkBinding13.pkRightTextView.setTextColor(intValue2);
            ItemFeedVotePkBinding itemFeedVotePkBinding14 = this.binding;
            if (itemFeedVotePkBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView4 = itemFeedVotePkBinding14.pkRightCheckView;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.pkRightCheckView");
            imageView4.setVisibility(8);
        }
        ItemFeedVotePkBinding itemFeedVotePkBinding15 = this.binding;
        if (itemFeedVotePkBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = itemFeedVotePkBinding15.pkRightTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pkRightTextView");
        textView3.setText(voteOption2.getTitle());
        ItemFeedVotePkBinding itemFeedVotePkBinding16 = this.binding;
        if (itemFeedVotePkBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkBinding16.executePendingBindings();
    }

    public final void bindToDisplay(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        this.feed = feed2;
        Vote vote = feed2.getVote();
        Intrinsics.checkNotNull(vote);
        Intrinsics.checkNotNullExpressionValue(vote, "data.vote!!");
        VoteOption voteOption = vote.getVoteOptions().get(0);
        VoteOption voteOption2 = vote.getVoteOptions().get(1);
        Intrinsics.checkNotNullExpressionValue(voteOption, "optionLeft");
        Integer stringToColor = ColorUtils.stringToColor(voteOption.getColor());
        if (stringToColor == null) {
            stringToColor = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099792));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
        int intValue = stringToColor.intValue();
        Intrinsics.checkNotNullExpressionValue(voteOption2, "optionRight");
        Integer stringToColor2 = ColorUtils.stringToColor(voteOption2.getColor());
        if (stringToColor2 == null) {
            stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(getContext$presentation_coolapkAppRelease(), 2131099791));
        }
        Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
        int intValue2 = stringToColor2.intValue();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  VS  ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue), 2, 3, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue2), 3, 4, 33);
        ItemFeedVotePkBinding itemFeedVotePkBinding = this.binding;
        if (itemFeedVotePkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = itemFeedVotePkBinding.pkVsView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pkVsView");
        textView.setText(spannableStringBuilder);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new VotePKTagShape(true));
        int adjustAlpha = ColorUtils.adjustAlpha(intValue, 0.1f);
        ItemFeedVotePkBinding itemFeedVotePkBinding2 = this.binding;
        if (itemFeedVotePkBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = itemFeedVotePkBinding2.pkLeftView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pkLeftView");
        linearLayout.setBackground(ViewExtendsKt.tintColor(shapeDrawable, adjustAlpha));
        ItemFeedVotePkBinding itemFeedVotePkBinding3 = this.binding;
        if (itemFeedVotePkBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = itemFeedVotePkBinding3.pkLeftCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.pkLeftCheckView");
        imageView.setVisibility(8);
        ItemFeedVotePkBinding itemFeedVotePkBinding4 = this.binding;
        if (itemFeedVotePkBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkBinding4.pkLeftTextView.setTextColor(intValue);
        ItemFeedVotePkBinding itemFeedVotePkBinding5 = this.binding;
        if (itemFeedVotePkBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = itemFeedVotePkBinding5.pkLeftTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.pkLeftTextView");
        textView2.setText(voteOption.getTitle());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new VotePKTagShape(false));
        int adjustAlpha2 = ColorUtils.adjustAlpha(intValue2, 0.1f);
        ItemFeedVotePkBinding itemFeedVotePkBinding6 = this.binding;
        if (itemFeedVotePkBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = itemFeedVotePkBinding6.pkRightView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pkRightView");
        linearLayout2.setBackground(ViewExtendsKt.tintColor(shapeDrawable2, adjustAlpha2));
        ItemFeedVotePkBinding itemFeedVotePkBinding7 = this.binding;
        if (itemFeedVotePkBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkBinding7.pkRightTextView.setTextColor(intValue2);
        ItemFeedVotePkBinding itemFeedVotePkBinding8 = this.binding;
        if (itemFeedVotePkBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = itemFeedVotePkBinding8.pkRightCheckView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.pkRightCheckView");
        imageView2.setVisibility(8);
        ItemFeedVotePkBinding itemFeedVotePkBinding9 = this.binding;
        if (itemFeedVotePkBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = itemFeedVotePkBinding9.pkRightTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.pkRightTextView");
        textView3.setText(voteOption2.getTitle());
        ItemFeedVotePkBinding itemFeedVotePkBinding10 = this.binding;
        if (itemFeedVotePkBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemFeedVotePkBinding10.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (this.feed != null && view.getId() != 2131363607) {
            super.onClick(view);
        }
    }
}
