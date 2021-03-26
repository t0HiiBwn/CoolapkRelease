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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Subscriber;

/* compiled from: AnswerCommentBarViewPart.kt */
public final class AnswerCommentBarViewPart extends BindingViewPart<FeedAnswerViewPartBinding, Feed> implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private Function1<? super View, Unit> externalListener;
    private Feed feed;
    private boolean isCheckAnswerCount;

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

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public FeedAnswerViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558555, viewGroup, false);
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
        if (view.getId() == 2131361999) {
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

    public final void enterAnswerActivity() {
        Activity activityNullable;
        Feed feed2 = this.feed;
        if (feed2 != null && (activityNullable = UiUtils.getActivityNullable(getContext())) != null) {
            ActionManager.startAnswerFeedActivity(activityNullable, feed2);
        }
    }
}
