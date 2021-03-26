package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.FeedAnswerViewPartBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001!B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0003H\u0014J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\tH\u0014R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/feed/reply/AnswerCommentBarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/FeedAnswerViewPartBinding;", "Lcom/coolapk/market/model/Feed;", "Landroid/view/View$OnClickListener;", "()V", "externalListener", "Lkotlin/Function1;", "Landroid/view/View;", "", "getExternalListener", "()Lkotlin/jvm/functions/Function1;", "setExternalListener", "(Lkotlin/jvm/functions/Function1;)V", "feed", "getFeed", "()Lcom/coolapk/market/model/Feed;", "setFeed", "(Lcom/coolapk/market/model/Feed;)V", "isCheckAnswerCount", "", "enterAnswerActivity", "onAddAnswerViewClick", "onBindToContent", "data", "onClick", "v", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AnswerCommentBarViewPart.kt */
public final class AnswerCommentBarViewPart extends BindingViewPart<FeedAnswerViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Function1<? super View, Unit> externalListener;
    private Feed feed;
    private boolean isCheckAnswerCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/reply/AnswerCommentBarViewPart$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/AnswerCommentBarViewPart;", "feed", "Lcom/coolapk/market/model/Feed;", "viewGroup", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AnswerCommentBarViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnswerCommentBarViewPart newInstance(Feed feed, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            AnswerCommentBarViewPart answerCommentBarViewPart = new AnswerCommentBarViewPart();
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(viewGroup.context)");
            answerCommentBarViewPart.createView(from, viewGroup);
            answerCommentBarViewPart.bindToContent(feed);
            return answerCommentBarViewPart;
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
    public FeedAnswerViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558553, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…w_part, viewGroup, false)");
        return (FeedAnswerViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        View root = ((FeedAnswerViewPartBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setTopElevation$default(root, 0.0f, 1, null);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((AnswerCommentBarViewPart) feed2);
        if (!Intrinsics.areEqual(this.feed, feed2)) {
            this.feed = feed2;
            ((FeedAnswerViewPartBinding) getBinding()).setClick(this);
            TextView textView = ((FeedAnswerViewPartBinding) getBinding()).commentCount;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.commentCount");
            textView.setText(String.valueOf(feed2.getReplyNum()));
            TextView textView2 = ((FeedAnswerViewPartBinding) getBinding()).likeCount;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.likeCount");
            textView2.setText(String.valueOf(feed2.getLikeNum()));
            ((FeedAnswerViewPartBinding) getBinding()).executePendingBindings();
            UserAction userAction = feed2.getUserAction();
            boolean z = false;
            boolean z2 = userAction != null && userAction.getLike() == 1;
            ((FeedAnswerViewPartBinding) getBinding()).likeIcon.setImageResource(z2 ? 2131689495 : 2131689494);
            ImageView imageView = ((FeedAnswerViewPartBinding) getBinding()).likeIcon;
            AppTheme appTheme = AppHolder.getAppTheme();
            imageView.setColorFilter(z2 ? appTheme.getColorAccent() : appTheme.getTextColorSecondary());
            ((FeedAnswerViewPartBinding) getBinding()).likeCount.setTextColor(z2 ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorSecondary());
            JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(feed2);
            if (jsonExtraData == null) {
                jsonExtraData = new JSONObject();
            }
            if (jsonExtraData.optInt("questionStatus", -1) == 0) {
                z = true;
            }
            if (z) {
                TextView textView3 = ((FeedAnswerViewPartBinding) getBinding()).addAnswerText;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.addAnswerText");
                textView3.setText("无法回答");
                LinearLayout linearLayout = ((FeedAnswerViewPartBinding) getBinding()).addAnswerView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
                linearLayout.setClickable(true);
                return;
            }
            TextView textView4 = ((FeedAnswerViewPartBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.addAnswerText");
            textView4.setText("添加回答");
            LinearLayout linearLayout2 = ((FeedAnswerViewPartBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.addAnswerView");
            linearLayout2.setClickable(true);
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        Function1<? super View, Unit> function1 = this.externalListener;
        if (function1 != null) {
            function1.invoke(view);
        }
        if (view.getId() == 2131361998) {
            onAddAnswerViewClick();
        }
    }

    private final void onAddAnswerViewClick() {
        Feed feed2 = this.feed;
        if (feed2 != null && !EntityExtendsKt.isDeletedQuestion(feed2) && !this.isCheckAnswerCount) {
            this.isCheckAnswerCount = true;
            LinearLayout linearLayout = ((FeedAnswerViewPartBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
            linearLayout.setClickable(false);
            ImageView imageView = ((FeedAnswerViewPartBinding) getBinding()).addAnswerImage;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.addAnswerImage");
            imageView.setVisibility(8);
            TextView textView = ((FeedAnswerViewPartBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.addAnswerText");
            textView.setVisibility(8);
            ProgressBar progressBar = ((FeedAnswerViewPartBinding) getBinding()).addAnswerProgress;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.addAnswerProgress");
            progressBar.setVisibility(0);
            DataManager.getInstance().checkAnswerCount(feed2.getId(), null).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new AnswerCommentBarViewPart$onAddAnswerViewClick$1(this)).subscribe((Subscriber<? super R>) new AnswerCommentBarViewPart$onAddAnswerViewClick$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void enterAnswerActivity() {
        Activity activityNullable;
        Feed feed2 = this.feed;
        if (feed2 != null && (activityNullable = UiUtils.getActivityNullable(getContext())) != null) {
            ActionManager.startAnswerFeedActivity(activityNullable, feed2);
        }
    }
}
