package com.coolapk.market.view.feed.reply;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.FeedCommentBarBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\tH\u0014R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/FeedCommentBarBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "()V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "feed", "getFeed", "()Lcom/coolapk/market/model/Feed;", "setFeed", "(Lcom/coolapk/market/model/Feed;)V", "applyWindowsInset", "inset", "Landroid/graphics/Rect;", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedCommentBarViewPart.kt */
public final class FeedCommentBarViewPart extends BindingViewPart<FeedCommentBarBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Function1<? super View, Unit> externalListener;
    private Feed feed;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/FeedCommentBarViewPart;", "feed", "Lcom/coolapk/market/model/Feed;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedCommentBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedCommentBarViewPart newInstance(Feed feed, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            FeedCommentBarViewPart feedCommentBarViewPart = new FeedCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            feedCommentBarViewPart.createView(from, viewGroup);
            feedCommentBarViewPart.bindToContent(feed);
            return feedCommentBarViewPart;
        }
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final void setFeed(Feed feed2) {
        this.feed = feed2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit>, kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> */
    public final Function1<View, Unit> getExternalListener() {
        return this.externalListener;
    }

    public final void setExternalListener(Function1<? super View, Unit> function1) {
        this.externalListener = function1;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public FeedCommentBarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558558, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…nt_bar, viewGroup, false)");
        return (FeedCommentBarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((FeedCommentBarBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
        FrameLayout frameLayout = ((FeedCommentBarBinding) getBinding()).likeView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.likeView");
        ViewExtendsKt.disableAccessibilityClick(frameLayout);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedCommentBarViewPart) feed2);
        if (!Intrinsics.areEqual(this.feed, feed2)) {
            this.feed = feed2;
            ((FeedCommentBarBinding) getBinding()).setClick(this);
            String str4 = "1w+";
            String valueOf = feed2.getReplyNum() < 9999 ? String.valueOf(feed2.getReplyNum()) : str4;
            String valueOf2 = feed2.getLikeNum() < 9999 ? String.valueOf(feed2.getLikeNum()) : str4;
            String valueOf3 = feed2.getFavoriteNum() < 9999 ? String.valueOf(feed2.getFavoriteNum()) : str4;
            if (feed2.getShareNum() < 9999) {
                str4 = String.valueOf(feed2.getShareNum());
            }
            TextView textView = ((FeedCommentBarBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.commentCount");
            String str5 = "";
            textView.setText(feed2.getReplyNum() > 0 ? valueOf : str5);
            TextView textView2 = ((FeedCommentBarBinding) getBinding()).likeCount;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeCount");
            textView2.setText(feed2.getLikeNum() > 0 ? valueOf2 : str5);
            TextView textView3 = ((FeedCommentBarBinding) getBinding()).starCount;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.starCount");
            textView3.setText(feed2.getFavoriteNum() > 0 ? valueOf3 : str5);
            TextView textView4 = ((FeedCommentBarBinding) getBinding()).shareCount;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.shareCount");
            textView4.setText(feed2.getShareNum() > 0 ? str4 : str5);
            ((FeedCommentBarBinding) getBinding()).executePendingBindings();
            UserAction userAction = feed2.getUserAction();
            boolean z = false;
            boolean z2 = userAction != null && userAction.getLike() == 1;
            UserAction userAction2 = feed2.getUserAction();
            if (userAction2 != null && userAction2.getCollect() == 1) {
                z = true;
            }
            ((FeedCommentBarBinding) getBinding()).likeIcon.setImageResource(z2 ? 2131689495 : 2131689494);
            ImageView imageView = ((FeedCommentBarBinding) getBinding()).likeIcon;
            AppTheme appTheme = AppHolder.getAppTheme();
            imageView.setColorFilter(z2 ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
            TextView textView5 = ((FeedCommentBarBinding) getBinding()).likeCount;
            AppTheme appTheme2 = AppHolder.getAppTheme();
            textView5.setTextColor(z2 ? appTheme2.getColorAccent() : appTheme2.getTextColorSecondary());
            ((FeedCommentBarBinding) getBinding()).starIcon.setImageResource(z ? 2131689478 : 2131689477);
            ImageView imageView2 = ((FeedCommentBarBinding) getBinding()).starIcon;
            AppTheme appTheme3 = AppHolder.getAppTheme();
            imageView2.setColorFilter(z ? appTheme3.getColorAccent() : appTheme3.getTextColorSecondary());
            TextView textView6 = ((FeedCommentBarBinding) getBinding()).starCount;
            AppTheme appTheme4 = AppHolder.getAppTheme();
            textView6.setTextColor(z ? appTheme4.getColorAccent() : appTheme4.getTextColorSecondary());
            FrameLayout frameLayout = ((FeedCommentBarBinding) getBinding()).commentView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.commentView");
            StringBuilder sb = new StringBuilder();
            sb.append("评论");
            if (feed2.getReplyNum() > 0) {
                str = ' ' + valueOf;
            } else {
                str = str5;
            }
            sb.append(str);
            sb.append(')');
            frameLayout.setContentDescription(sb.toString());
            FrameLayout frameLayout2 = ((FeedCommentBarBinding) getBinding()).likeView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.likeView");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z2 ? "已点赞" : "点赞");
            if (feed2.getLikeNum() > 0) {
                str2 = ' ' + valueOf2;
            } else {
                str2 = str5;
            }
            sb2.append(str2);
            frameLayout2.setContentDescription(sb2.toString());
            FrameLayout frameLayout3 = ((FeedCommentBarBinding) getBinding()).starView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.starView");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(z ? "已收藏" : "收藏");
            if (feed2.getFavoriteNum() > 0) {
                str3 = ' ' + valueOf3;
            } else {
                str3 = str5;
            }
            sb3.append(str3);
            frameLayout3.setContentDescription(sb3.toString());
            FrameLayout frameLayout4 = ((FeedCommentBarBinding) getBinding()).shareView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.shareView");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("分享");
            if (feed2.getShareNum() > 0) {
                str5 = ' ' + str4;
            }
            sb4.append(str5);
            frameLayout4.setContentDescription(sb4.toString());
        }
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        ((FeedCommentBarBinding) getBinding()).rootView.setPadding(0, 0, 0, rect.bottom);
        ((FeedCommentBarBinding) getBinding()).rootView.requestLayout();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        Function1<? super View, Unit> function1 = this.externalListener;
        if (function1 != null) {
            function1.invoke(view);
        }
    }
}
