package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.SubmitFeedExtraLogoBinding;
import com.coolapk.market.databinding.VoteFeedContentBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.BaseEmotion;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u001c\u001a\u00020\u001dH\u0010¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H\u0010¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020#H\u0010¢\u0006\u0002\b$J \u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0015\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0010¢\u0006\u0002\b0J\b\u00101\u001a\u00020#H\u0016J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0016J\b\u00108\u001a\u00020#H\u0016J\u0013\u00109\u001a\b\u0012\u0004\u0012\u00020 0:H\u0010¢\u0006\u0002\b;J\b\u0010<\u001a\u00020#H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020#H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006A"}, d2 = {"Lcom/coolapk/market/view/feedv8/VoteContentHolder;", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "binding", "Lcom/coolapk/market/databinding/VoteFeedContentBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/VoteFeedContentBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/VoteFeedContentBinding;)V", "focusEditText", "Landroid/widget/EditText;", "getFocusEditText", "()Landroid/widget/EditText;", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "pickTopicBinding", "Lcom/coolapk/market/databinding/SubmitFeedExtraLogoBinding;", "voteExtraView", "Lcom/coolapk/market/view/feedv8/VoteExtraView;", "getVoteExtraView", "()Lcom/coolapk/market/view/feedv8/VoteExtraView;", "voteExtraView$delegate", "Lkotlin/Lazy;", "checkSubmittable", "", "checkSubmittable$presentation_coolapkAppRelease", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "notifyUIChange", "", "notifyUIChange$presentation_coolapkAppRelease", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onPickAppIntent", "onPickAtIntent", "onPickTopicIntent", "onSubmitButtonClick", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "setPickTopicUI", "setVoteTypeUI", "vote", "showMoreSettings", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteContentHolder.kt */
public final class VoteContentHolder extends BaseFeedContentHolder implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int PICK_TOPIC_ID = 1345;
    public VoteFeedContentBinding binding;
    private SubmitFeedExtraLogoBinding pickTopicBinding;
    private final Lazy voteExtraView$delegate = LazyKt.lazy(new VoteContentHolder$voteExtraView$2(this));

    private final VoteExtraView getVoteExtraView() {
        return (VoteExtraView) this.voteExtraView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoteContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static final /* synthetic */ SubmitFeedExtraLogoBinding access$getPickTopicBinding$p(VoteContentHolder voteContentHolder) {
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding = voteContentHolder.pickTopicBinding;
        if (submitFeedExtraLogoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
        }
        return submitFeedExtraLogoBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/VoteContentHolder$Companion;", "", "()V", "PICK_TOPIC_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteContentHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final VoteFeedContentBinding getBinding$presentation_coolapkAppRelease() {
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return voteFeedContentBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(VoteFeedContentBinding voteFeedContentBinding) {
        Intrinsics.checkNotNullParameter(voteFeedContentBinding, "<set-?>");
        this.binding = voteFeedContentBinding;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        return getFocusEditText();
    }

    private final EditText getFocusEditText() {
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = voteFeedContentBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        return editText;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559309, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        VoteFeedContentBinding voteFeedContentBinding = (VoteFeedContentBinding) inflate;
        this.binding = voteFeedContentBinding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        voteFeedContentBinding.setUiConfig(getUiConfig());
        VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
        if (voteFeedContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = voteFeedContentBinding2.editTitle;
        editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(getUiConfig().editTitleMaxLength())});
        editText.setText(getMultiPart().messageTitle());
        editText.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        editText.addTextChangedListener(new VoteContentHolder$onCreateContentView$$inlined$apply$lambda$1(this));
        editText.setOnFocusChangeListener(new VoteContentHolder$onCreateContentView$$inlined$apply$lambda$2(this));
        VoteFeedContentBinding voteFeedContentBinding3 = this.binding;
        if (voteFeedContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = voteFeedContentBinding3.editText;
        editText2.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        editText2.setText(getMultiPart().message());
        editText2.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        editText2.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new VoteContentHolder$onCreateContentView$$inlined$apply$lambda$3(this)));
        editText2.addTextChangedListener(new VoteContentHolder$onCreateContentView$$inlined$apply$lambda$4(this));
        editText2.setOnFocusChangeListener(new VoteContentHolder$onCreateContentView$$inlined$apply$lambda$5(this));
        if (UserPermissionChecker.INSTANCE.getCanUseAdvancedVoteOptions()) {
            setPickTopicUI();
        }
        setVoteTypeUI(getMultiPart().voteType());
        if (!(getMultiPart().voteEndTime() == 604800 && getMultiPart().voteShowAuthor() == 1 && getMultiPart().voteAnonymousStatus() == 1 && getMultiPart().voteMaxSelectNum() == 1)) {
            showMoreSettings();
        }
        VoteFeedContentBinding voteFeedContentBinding4 = this.binding;
        if (voteFeedContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        voteFeedContentBinding4.setClick(this);
        VoteFeedContentBinding voteFeedContentBinding5 = this.binding;
        if (voteFeedContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        voteFeedContentBinding5.executePendingBindings();
        VoteFeedContentBinding voteFeedContentBinding6 = this.binding;
        if (voteFeedContentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = voteFeedContentBinding6.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setPickTopicUI() {
        if (this.pickTopicBinding == null) {
            VoteFeedContentBinding voteFeedContentBinding = this.binding;
            if (voteFeedContentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = voteFeedContentBinding.relativeView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559166, linearLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…a_logo, container, false)");
            SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding = (SubmitFeedExtraLogoBinding) inflate;
            this.pickTopicBinding = submitFeedExtraLogoBinding;
            if (submitFeedExtraLogoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
            }
            submitFeedExtraLogoBinding.setClick(new VoteContentHolder$setPickTopicUI$2(this));
            SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding2 = this.pickTopicBinding;
            if (submitFeedExtraLogoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
            }
            linearLayout.addView(submitFeedExtraLogoBinding2.getRoot());
            View newSmallDividerView = SubmitExtraViewPart.Companion.newSmallDividerView(getActivity());
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(newSmallDividerView);
            if (marginParams != null) {
                marginParams.height = DisplayUtils.dp2px(getActivity(), 8.0f);
                marginParams.leftMargin = 0;
                marginParams.rightMargin = 0;
            }
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(newSmallDividerView);
        }
        String relativeTitle = getUiConfig().relativeTitle();
        Intrinsics.checkNotNullExpressionValue(relativeTitle, "title");
        if (relativeTitle.length() == 0) {
            relativeTitle = "选择绑定话题";
        }
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding3 = this.pickTopicBinding;
        if (submitFeedExtraLogoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
        }
        TextView textView = submitFeedExtraLogoBinding3.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "pickTopicBinding.titleView");
        textView.setText(relativeTitle);
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding4 = this.pickTopicBinding;
        if (submitFeedExtraLogoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
        }
        ImageView imageView = submitFeedExtraLogoBinding4.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "pickTopicBinding.imageView");
        ViewExtendsKt.clipView(imageView, 0, (float) NumberExtendsKt.getDp((Number) 4));
        ImageLoaderOptions build = ImageLoaderOptions.newBuilder().placeHolderRes(2131231628).build();
        GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
        Activity activity = getActivity();
        String relativeLogo = getUiConfig().relativeLogo();
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding5 = this.pickTopicBinding;
        if (submitFeedExtraLogoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickTopicBinding");
        }
        contextImageLoader.displayImage((Context) activity, relativeLogo, submitFeedExtraLogoBinding5.imageView, build, (OnImageLoadListener) null, (OnBitmapTransformListener) new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 4), false, 2, null));
    }

    private final void setVoteTypeUI(int i) {
        Pair pair;
        getVoteExtraView().requestUpdateDataList();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        boolean z = true;
        boolean z2 = loginSession.isLogin() && loginSession.isAdmin();
        if (i != 0) {
            z = false;
        }
        String str = (!z || z2) ? (!z || !z2) ? (z || z2) ? (z || !z2) ? "" : "默认允许匿名，单选，截止时间7天，显示发布者信息" : "默认允许匿名，单选，截止时间7天" : "默认允许匿名，截止时间7天，显示发布者信息" : "默认允许匿名，截止时间7天";
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = voteFeedContentBinding.voteHintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.voteHintView");
        textView.setText(str);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        int adjustAlpha = ColorUtils.adjustAlpha(colorAccent, 0.1f);
        int i2 = (int) 4285887861L;
        int adjustAlpha2 = ColorUtils.adjustAlpha(i2, 0.1f);
        if (i == 0) {
            VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
            if (voteFeedContentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = voteFeedContentBinding2.pkModeView;
            VoteFeedContentBinding voteFeedContentBinding3 = this.binding;
            if (voteFeedContentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            pair = TuplesKt.to(textView2, voteFeedContentBinding3.multiModeView);
        } else {
            VoteFeedContentBinding voteFeedContentBinding4 = this.binding;
            if (voteFeedContentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView3 = voteFeedContentBinding4.multiModeView;
            VoteFeedContentBinding voteFeedContentBinding5 = this.binding;
            if (voteFeedContentBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            pair = TuplesKt.to(textView3, voteFeedContentBinding5.pkModeView);
        }
        TextView textView4 = (TextView) pair.component1();
        TextView textView5 = (TextView) pair.component2();
        textView4.setTextColor(colorAccent);
        textView4.setBackgroundColor(adjustAlpha);
        textView5.setTextColor(i2);
        textView5.setBackgroundColor(adjustAlpha2);
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    private final void showMoreSettings() {
        getVoteExtraView().showMoreSettings();
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = voteFeedContentBinding.moreSettingView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.moreSettingView");
        linearLayout.setVisibility(8);
        VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
        if (voteFeedContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = voteFeedContentBinding2.voteHintView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.voteHintView");
        textView.setVisibility(8);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void notifyUIChange$presentation_coolapkAppRelease() {
        super.notifyUIChange$presentation_coolapkAppRelease();
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        voteFeedContentBinding.setUiConfig(getUiConfig());
        VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
        if (voteFeedContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        voteFeedContentBinding2.executePendingBindings();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
        super.onDeleteButtonClick();
        ViewExtendsKt.insertBackKey(getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
        super.onEmotionClick(baseEmotion);
        String realText = baseEmotion.getRealText();
        EditText focusEditText = getFocusEditText();
        Intrinsics.checkNotNullExpressionValue(realText, "emotionText");
        ViewExtendsKt.insertText(focusEditText, realText);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickTopicIntent(intent);
        CommentHelper.processTopicResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAtIntent(intent);
        CommentHelper.processAtUserResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAppIntent(intent);
        CommentHelper.processAddAppResult(intent, getFocusEditText());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        startSubmitFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = voteFeedContentBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        String str = obj;
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        builder.message(str.subSequence(i, length + 1).toString());
        VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
        if (voteFeedContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = voteFeedContentBinding2.editTitle;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
        String obj2 = editText2.getText().toString();
        int length2 = obj2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare(obj2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        builder.messageTitle(obj2.subSequence(i2, length2 + 1).toString());
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = voteFeedContentBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        int length = obj.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(obj.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        builder.message(obj.subSequence(i, length + 1).toString());
        VoteFeedContentBinding voteFeedContentBinding2 = this.binding;
        if (voteFeedContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = voteFeedContentBinding2.editTitle;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editTitle");
        String obj2 = editText2.getText().toString();
        int length2 = obj2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare(obj2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        builder.messageTitle(obj2.subSequence(i2, length2 + 1).toString());
        if (getMultiPart().voteType() == 0 && getMultiPart().voteMaxSelectNum() > 1) {
            builder.voteMaxSelectNum(1);
        }
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        updateMultiPart$presentation_coolapkAppRelease(build);
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b4 A[RETURN] */
    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        VoteFeedContentBinding voteFeedContentBinding = this.binding;
        if (voteFeedContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = voteFeedContentBinding.editTitle;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editTitle");
        if (ViewExtendsKt.isTrimTextEmpty(editText)) {
            return false;
        }
        if (getMultiPart().voteType() == 0) {
            List<String> voteOptions = getMultiPart().voteOptions();
            if (voteOptions.size() >= 2) {
                List<String> subList = voteOptions.subList(0, 2);
                if (!(subList instanceof Collection) || !subList.isEmpty()) {
                    Iterator<T> it2 = subList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        T next = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next, "it");
                        if (next.length() == 0) {
                            z5 = true;
                            continue;
                        } else {
                            z5 = false;
                            continue;
                        }
                        if (z5) {
                            z4 = true;
                            break;
                        }
                    }
                    if (!z4) {
                        z3 = false;
                        if (z3) {
                            return false;
                        }
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
            z3 = true;
            if (z3) {
            }
        } else {
            List<String> voteOptions2 = getMultiPart().voteOptions();
            Intrinsics.checkNotNullExpressionValue(voteOptions2, "multiPart.voteOptions()");
            List<String> list = voteOptions2;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next2 = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "it");
                    if (next2.length() == 0) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return false;
                }
            }
            z = false;
            if (z) {
            }
        }
        if (getMultiPart().voteEndTime() <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        if (i != 1345) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        Topic topic = (Topic) intent.getParcelableExtra("KEY_TOPIC_MODEL");
        if (topic != null) {
            FeedUIConfig build = getUiConfig().newBuilder().relativeLogo(topic.getLogo()).relativeTitle(topic.getTitle()).build();
            Intrinsics.checkNotNullExpressionValue(build, "uiConfig.newBuilder()\n  …                 .build()");
            updateUiConfig$presentation_coolapkAppRelease(build);
            setPickTopicUI();
            FeedMultiPart build2 = getMultiPart().newBuilder().voteTag(topic.getTitle()).build();
            Intrinsics.checkNotNullExpressionValue(build2, "multiPart.newBuilder().v…eTag(topic.title).build()");
            updateMultiPart$presentation_coolapkAppRelease(build2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131362979) {
            showMoreSettings();
        } else if (id != 2131363004) {
            if (id == 2131363134) {
                if (!getUiConfig().canUpdateVoteMode()) {
                    Toast.show$default(getActivity(), "投票模式不可修改", 0, false, 12, null);
                } else if (getMultiPart().voteType() != 0) {
                    FeedMultiPart build = getMultiPart().newBuilder().voteType(0).build();
                    Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().v…ote.VOTE_TYPE_PK).build()");
                    updateMultiPart$presentation_coolapkAppRelease(build);
                    setVoteTypeUI(0);
                }
            }
        } else if (!getUiConfig().canUpdateVoteMode()) {
            Toast.show$default(getActivity(), "投票模式不可修改", 0, false, 12, null);
        } else if (getMultiPart().voteType() != 1) {
            FeedMultiPart build2 = getMultiPart().newBuilder().voteType(1).build();
            Intrinsics.checkNotNullExpressionValue(build2, "multiPart.newBuilder().v….VOTE_TYPE_MULTI).build()");
            updateMultiPart$presentation_coolapkAppRelease(build2);
            setVoteTypeUI(1);
        }
    }
}
