package com.coolapk.market.view.feed.question;

import android.app.Activity;
import android.graphics.Rect;
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
import com.coolapk.market.databinding.ItemQuestionDetailBottomBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

/* compiled from: QuestionDetailBottomViewPart.kt */
public final class QuestionDetailBottomViewPart extends BindingViewPart<ItemQuestionDetailBottomBinding, Feed> {
    private Feed feed;
    private boolean isCheckAnswerCount;
    private final QuestionPresenter questionPresenter;
    private final QuestionView questionView;

    public final QuestionPresenter getQuestionPresenter() {
        return this.questionPresenter;
    }

    public final QuestionView getQuestionView() {
        return this.questionView;
    }

    public QuestionDetailBottomViewPart(QuestionView questionView2, QuestionPresenter questionPresenter2) {
        Intrinsics.checkNotNullParameter(questionView2, "questionView");
        Intrinsics.checkNotNullParameter(questionPresenter2, "questionPresenter");
        this.questionView = questionView2;
        this.questionPresenter = questionPresenter2;
    }

    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemQuestionDetailBottomBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558884, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…bottom, viewGroup, false)");
        return (ItemQuestionDetailBottomBinding) inflate;
    }

    public final void applyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        ((ItemQuestionDetailBottomBinding) getBinding()).rootView.setPadding(0, 0, 0, rect.bottom);
        ((ItemQuestionDetailBottomBinding) getBinding()).rootView.requestLayout();
    }

    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((QuestionDetailBottomViewPart) feed2);
        View root = ((ItemQuestionDetailBottomBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        boolean z = true;
        root.setClickable(true);
        this.feed = feed2;
        ((ItemQuestionDetailBottomBinding) getBinding()).setModel(feed2);
        ((ItemQuestionDetailBottomBinding) getBinding()).setClick(this);
        Feed feed3 = this.feed;
        if (feed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
        }
        UserAction userAction = feed3.getUserAction();
        if (userAction == null || userAction.getFollow() != 1) {
            z = false;
        }
        setFollowSate(z);
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131361998) {
            onAddAnswerViewClick();
        } else if (id == 2131362582) {
            Activity currentActivity = AppHolder.getCurrentActivity();
            if (currentActivity != null) {
                Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                if (checkLogin.booleanValue()) {
                    Feed feed2 = this.feed;
                    if (feed2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feed");
                    }
                    UserAction userAction = feed2.getUserAction();
                    Intrinsics.checkNotNull(userAction);
                    Intrinsics.checkNotNullExpressionValue(userAction, "feed.userAction!!");
                    boolean z = true;
                    if (userAction.getFollow() != 1) {
                        z = false;
                    }
                    QuestionPresenter questionPresenter2 = this.questionPresenter;
                    Feed feed3 = this.feed;
                    if (feed3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feed");
                    }
                    String id2 = feed3.getId();
                    if (id2 == null) {
                        id2 = "";
                    }
                    questionPresenter2.followQuestion(z, id2);
                }
            }
        } else if (id == 2131362749) {
            this.questionView.pickUserToInvite();
        }
    }

    private final void setFollowSate(boolean z) {
        if (z) {
            TextView textView = ((ItemQuestionDetailBottomBinding) getBinding()).followTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.followTextView");
            textView.setText("已关注");
            return;
        }
        TextView textView2 = ((ItemQuestionDetailBottomBinding) getBinding()).followTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.followTextView");
        textView2.setText("关注问题");
    }

    private final void onAddAnswerViewClick() {
        if (!this.isCheckAnswerCount) {
            StatisticHelper.Companion.getInstance().recordQuestionAction("邀请回答");
            this.isCheckAnswerCount = true;
            LinearLayout linearLayout = ((ItemQuestionDetailBottomBinding) getBinding()).addAnswerView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addAnswerView");
            linearLayout.setClickable(false);
            ImageView imageView = ((ItemQuestionDetailBottomBinding) getBinding()).addAnswerImage;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.addAnswerImage");
            imageView.setVisibility(8);
            TextView textView = ((ItemQuestionDetailBottomBinding) getBinding()).addAnswerText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.addAnswerText");
            textView.setVisibility(8);
            ProgressBar progressBar = ((ItemQuestionDetailBottomBinding) getBinding()).addAnswerProgress;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.addAnswerProgress");
            progressBar.setVisibility(0);
            DataManager instance = DataManager.getInstance();
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            instance.checkAnswerCount(feed2.getId(), null).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new QuestionDetailBottomViewPart$onAddAnswerViewClick$1(this)).subscribe((Subscriber<? super R>) new QuestionDetailBottomViewPart$onAddAnswerViewClick$2(this));
        }
    }

    public final void enterAnswerActivity() {
        StatisticHelper.Companion.getInstance().recordQuestionAction("添加回答");
        Activity activityNullable = UiUtils.getActivityNullable(getContext());
        if (activityNullable != null) {
            Feed feed2 = this.feed;
            if (feed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feed");
            }
            ActionManager.startAnswerFeedActivity(activityNullable, feed2);
        }
    }
}
