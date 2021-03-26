package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.text.Editable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.SubmitRatingNoramlContentBinding;
import com.coolapk.market.databinding.TagProductOwnerBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.SubmitExtraViewPart;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.coolapk.market.widget.view.BadBadRatingBar;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0018\u001a\u00020\u0016H\u0010¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\r\u0010\u001c\u001a\u00020\u001dH\u0010¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\r\u0010\"\u001a\u00020\u001bH\u0010¢\u0006\u0002\b#J \u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0012H\u0016J\u0015\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b/J\b\u00100\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u00106\u001a\u00020\u001b2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0016J\u0010\u0010:\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010;\u001a\u00020\u001bH\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0>H\u0010¢\u0006\u0002\b?J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020&H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/coolapk/market/view/feedv8/RatingContentHolderVX1;", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "advantageAdapter", "Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "binding", "Lcom/coolapk/market/databinding/SubmitRatingNoramlContentBinding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/SubmitRatingNoramlContentBinding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/SubmitRatingNoramlContentBinding;)V", "disAdvantageAdapter", "focusEditText", "Landroid/widget/EditText;", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "isContentTextCollapsed", "", "summaryAdapter", "checkSubmittable", "checkSubmittable$presentation_coolapkAppRelease", "fillRelativeViewIfNeed", "", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "initEditTexts", "initPhotoViewsAndAdapters", "insertOwnerLabel", "notifyUIChange", "notifyUIChange$presentation_coolapkAppRelease", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onPickAppIntent", "onPickAtIntent", "onPickImageListChange", "pathList", "", "", "onPickTopicIntent", "onRequestPickImage", "onSubmitButtonClick", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "updateBuyStateVisibility", "updateCollapsedState", "updateRatingScore", "score", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RatingContentHolderVX1.kt */
public final class RatingContentHolderVX1 extends BaseFeedContentHolder implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final int PICK_PHOTO_FOR_ADVANTAGE = 2355;
    public static final int PICK_PHOTO_FOR_DISADVANTAGE = 2354;
    public static final int PICK_PHOTO_FOR_SUMMARY = 2353;
    private PickPhotoAdapterV8 advantageAdapter;
    public SubmitRatingNoramlContentBinding binding;
    private PickPhotoAdapterV8 disAdvantageAdapter;
    private EditText focusEditText;
    private boolean isContentTextCollapsed;
    private PickPhotoAdapterV8 summaryAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatingContentHolderVX1(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static final /* synthetic */ PickPhotoAdapterV8 access$getAdvantageAdapter$p(RatingContentHolderVX1 ratingContentHolderVX1) {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = ratingContentHolderVX1.advantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        return pickPhotoAdapterV8;
    }

    public static final /* synthetic */ PickPhotoAdapterV8 access$getDisAdvantageAdapter$p(RatingContentHolderVX1 ratingContentHolderVX1) {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = ratingContentHolderVX1.disAdvantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        return pickPhotoAdapterV8;
    }

    public static final /* synthetic */ PickPhotoAdapterV8 access$getSummaryAdapter$p(RatingContentHolderVX1 ratingContentHolderVX1) {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = ratingContentHolderVX1.summaryAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        return pickPhotoAdapterV8;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/RatingContentHolderVX1$Companion;", "", "()V", "PICK_PHOTO_FOR_ADVANTAGE", "", "PICK_PHOTO_FOR_DISADVANTAGE", "PICK_PHOTO_FOR_SUMMARY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RatingContentHolderVX1.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SubmitRatingNoramlContentBinding getBinding$presentation_coolapkAppRelease() {
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitRatingNoramlContentBinding;
    }

    public final void setBinding$presentation_coolapkAppRelease(SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding) {
        Intrinsics.checkNotNullParameter(submitRatingNoramlContentBinding, "<set-?>");
        this.binding = submitRatingNoramlContentBinding;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        EditText editText = this.focusEditText;
        if (editText == null) {
            SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
            if (submitRatingNoramlContentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            editText = submitRatingNoramlContentBinding.advantageEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.advantageEditText");
        }
        return editText;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0166  */
    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        boolean z;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z2 = false;
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559176, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = (SubmitRatingNoramlContentBinding) inflate;
        this.binding = submitRatingNoramlContentBinding2;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding2.setUiConfig(getUiConfig());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding3.setClick(this);
        initPhotoViewsAndAdapters();
        initEditTexts();
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding4 = this.binding;
        if (submitRatingNoramlContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        BadBadRatingBar badBadRatingBar = submitRatingNoramlContentBinding4.ratingBar;
        badBadRatingBar.setProgressBar(NumberExtendsKt.getDp((Number) 36), false);
        badBadRatingBar.setProgressBackgroundTintList(ColorStateList.valueOf((int) 4292335575L));
        badBadRatingBar.setRating((float) getMultiPart().ratingScore1());
        updateRatingScore(getMultiPart().ratingScore1());
        badBadRatingBar.setOnRatingBarChangeListener(new RatingContentHolderVX1$onCreateContentView$$inlined$apply$lambda$1(this));
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding5 = this.binding;
        if (submitRatingNoramlContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.replaceView(submitRatingNoramlContentBinding5.spaceView, getExtraViewPart$presentation_coolapkAppRelease().getView());
        fillRelativeViewIfNeed();
        int i = 8;
        if (getUiConfig().isRatingTextCollapsed()) {
            SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding6 = this.binding;
            if (submitRatingNoramlContentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = submitRatingNoramlContentBinding6.expandView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.expandView");
            linearLayout.setVisibility(0);
            FeedMultiPart multiPart = getMultiPart();
            String commentGood = multiPart.commentGood();
            Intrinsics.checkNotNullExpressionValue(commentGood, "it.commentGood()");
            if (commentGood.length() == 0) {
                String commentGoodPic = multiPart.commentGoodPic();
                Intrinsics.checkNotNullExpressionValue(commentGoodPic, "it.commentGoodPic()");
                if (commentGoodPic.length() == 0) {
                    String commentBad = multiPart.commentBad();
                    Intrinsics.checkNotNullExpressionValue(commentBad, "it.commentBad()");
                    if (commentBad.length() == 0) {
                        String commentBadPic = multiPart.commentBadPic();
                        Intrinsics.checkNotNullExpressionValue(commentBadPic, "it.commentBadPic()");
                        if (commentBadPic.length() == 0) {
                            String commentGeneral = multiPart.commentGeneral();
                            Intrinsics.checkNotNullExpressionValue(commentGeneral, "it.commentGeneral()");
                            if (commentGeneral.length() == 0) {
                                String commentGeneralPic = multiPart.commentGeneralPic();
                                Intrinsics.checkNotNullExpressionValue(commentGeneralPic, "it.commentGeneralPic()");
                                if (commentGeneralPic.length() == 0) {
                                    z = true;
                                    this.isContentTextCollapsed = z;
                                    submitRatingNoramlContentBinding = this.binding;
                                    if (submitRatingNoramlContentBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                                    }
                                    LinearLayout linearLayout2 = submitRatingNoramlContentBinding.contentContainer;
                                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentContainer");
                                    LinearLayout linearLayout3 = linearLayout2;
                                    if (!this.isContentTextCollapsed) {
                                        i = 0;
                                    }
                                    linearLayout3.setVisibility(i);
                                    updateCollapsedState();
                                }
                            }
                        }
                    }
                }
            }
            z = false;
            this.isContentTextCollapsed = z;
            submitRatingNoramlContentBinding = this.binding;
            if (submitRatingNoramlContentBinding == null) {
            }
            LinearLayout linearLayout2 = submitRatingNoramlContentBinding.contentContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentContainer");
            LinearLayout linearLayout3 = linearLayout2;
            if (!this.isContentTextCollapsed) {
            }
            linearLayout3.setVisibility(i);
            updateCollapsedState();
        } else {
            SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding7 = this.binding;
            if (submitRatingNoramlContentBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout4 = submitRatingNoramlContentBinding7.expandView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.expandView");
            linearLayout4.setVisibility(8);
            SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding8 = this.binding;
            if (submitRatingNoramlContentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout5 = submitRatingNoramlContentBinding8.contentContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.contentContainer");
            linearLayout5.setVisibility(0);
        }
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding9 = this.binding;
        if (submitRatingNoramlContentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(submitRatingNoramlContentBinding9.buyStateView, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
        updateBuyStateVisibility();
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding10 = this.binding;
        if (submitRatingNoramlContentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CheckBox checkBox = submitRatingNoramlContentBinding10.buyStateView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.buyStateView");
        checkBox.setChecked(getMultiPart().buyStatus());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding11 = this.binding;
        if (submitRatingNoramlContentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding11.buyStateView.setOnCheckedChangeListener(new RatingContentHolderVX1$onCreateContentView$3(this));
        if (getUiConfig().isFeedTargetPhoneOrTablet() && Intrinsics.areEqual(getMultiPart().targetType(), "product_phone")) {
            String targetId = getMultiPart().targetId();
            Intrinsics.checkNotNullExpressionValue(targetId, "multiPart.targetId()");
            if (targetId.length() > 0) {
                z2 = true;
            }
            if (z2) {
                DataManager.getInstance().getProductDetail(getMultiPart().targetId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new RatingContentHolderVX1$onCreateContentView$4(this));
            }
        }
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding12 = this.binding;
        if (submitRatingNoramlContentBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding12.executePendingBindings();
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding13 = this.binding;
        if (submitRatingNoramlContentBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = submitRatingNoramlContentBinding13.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void updateCollapsedState() {
        String str;
        boolean z = this.isContentTextCollapsed;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitRatingNoramlContentBinding.expandTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.expandTextView");
        textView.setText(z ? "展开写评语" : "收起写评语");
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = submitRatingNoramlContentBinding2.expandImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.expandImageView");
        imageView.setRotation(z ? 0.0f : 180.0f);
        if (z) {
            str = "";
        } else {
            str = getActivity().getString(2131887005);
            Intrinsics.checkNotNullExpressionValue(str, "activity.getString(R.string.str_rating_hint)");
        }
        if (getUiConfig().isFeedTargetPhoneOrTablet()) {
            str = "·使用 " + getUiConfig().relativeTitle() + " 发布点评时，自动标记【机主】标签\n" + str;
        }
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = submitRatingNoramlContentBinding3.ratingHint;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.ratingHint");
        textView2.setText(str);
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding4 = this.binding;
        if (submitRatingNoramlContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = submitRatingNoramlContentBinding4.contentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentContainer");
        ViewParent parent = linearLayout.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        TransitionManager.beginDelayedTransition((ViewGroup) parent);
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding5 = this.binding;
        if (submitRatingNoramlContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = submitRatingNoramlContentBinding5.contentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentContainer");
        linearLayout2.setVisibility(z ? 8 : 0);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x009a: APUT  
      (r5v8 com.coolapk.market.view.feedv8.PickPhotoAdapterV8[])
      (0 ??[int, short, byte, char])
      (r6v0 com.coolapk.market.view.feedv8.PickPhotoAdapterV8)
     */
    private final void initPhotoViewsAndAdapters() {
        this.advantageAdapter = new PickPhotoAdapterV8(getActivity());
        this.disAdvantageAdapter = new PickPhotoAdapterV8(getActivity());
        this.summaryAdapter = new PickPhotoAdapterV8(getActivity());
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        pickPhotoAdapterV8.setOnPhotoCountChangeListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$1(this));
        PickPhotoAdapterV8 pickPhotoAdapterV82 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV82 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        pickPhotoAdapterV82.setOnPhotoCountChangeListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$2(this));
        PickPhotoAdapterV8 pickPhotoAdapterV83 = this.summaryAdapter;
        if (pickPhotoAdapterV83 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        pickPhotoAdapterV83.setOnPhotoCountChangeListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$3(this));
        PickPhotoAdapterV8 pickPhotoAdapterV84 = this.advantageAdapter;
        if (pickPhotoAdapterV84 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        pickPhotoAdapterV84.setPickPhotoClickListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$4(this));
        PickPhotoAdapterV8 pickPhotoAdapterV85 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV85 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        pickPhotoAdapterV85.setPickPhotoClickListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$5(this));
        PickPhotoAdapterV8 pickPhotoAdapterV86 = this.summaryAdapter;
        if (pickPhotoAdapterV86 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        pickPhotoAdapterV86.setPickPhotoClickListener(new RatingContentHolderVX1$initPhotoViewsAndAdapters$6(this));
        PickPhotoAdapterV8[] pickPhotoAdapterV8Arr = new PickPhotoAdapterV8[3];
        PickPhotoAdapterV8 pickPhotoAdapterV87 = this.advantageAdapter;
        if (pickPhotoAdapterV87 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        pickPhotoAdapterV8Arr[0] = pickPhotoAdapterV87;
        PickPhotoAdapterV8 pickPhotoAdapterV88 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV88 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        pickPhotoAdapterV8Arr[1] = pickPhotoAdapterV88;
        PickPhotoAdapterV8 pickPhotoAdapterV89 = this.summaryAdapter;
        if (pickPhotoAdapterV89 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        pickPhotoAdapterV8Arr[2] = pickPhotoAdapterV89;
        for (int i = 0; i < 3; i++) {
            PickPhotoAdapterV8 pickPhotoAdapterV810 = pickPhotoAdapterV8Arr[i];
            pickPhotoAdapterV810.setEditTable(true);
            pickPhotoAdapterV810.setMaxPickCount(getUiConfig().maxPickPhotoCount());
        }
        PickPhotoAdapterV8 pickPhotoAdapterV811 = this.advantageAdapter;
        if (pickPhotoAdapterV811 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        String commentGoodPic = getMultiPart().commentGoodPic();
        Intrinsics.checkNotNullExpressionValue(commentGoodPic, "multiPart.commentGoodPic()");
        ArrayList arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) commentGoodPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (String str : arrayList2) {
            arrayList3.add(ImageUrl.create(str, str));
        }
        pickPhotoAdapterV811.setInitList(arrayList3);
        PickPhotoAdapterV8 pickPhotoAdapterV812 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV812 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        String commentBadPic = getMultiPart().commentBadPic();
        Intrinsics.checkNotNullExpressionValue(commentBadPic, "multiPart.commentBadPic()");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : StringsKt.split$default((CharSequence) commentBadPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList<String> arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        for (String str2 : arrayList5) {
            arrayList6.add(ImageUrl.create(str2, str2));
        }
        pickPhotoAdapterV812.setInitList(arrayList6);
        PickPhotoAdapterV8 pickPhotoAdapterV813 = this.summaryAdapter;
        if (pickPhotoAdapterV813 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        String commentGeneralPic = getMultiPart().commentGeneralPic();
        Intrinsics.checkNotNullExpressionValue(commentGeneralPic, "multiPart.commentGeneralPic()");
        ArrayList arrayList7 = new ArrayList();
        for (Object obj3 : StringsKt.split$default((CharSequence) commentGeneralPic, new String[]{","}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) obj3)) {
                arrayList7.add(obj3);
            }
        }
        ArrayList<String> arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        for (String str3 : arrayList8) {
            arrayList9.add(ImageUrl.create(str3, str3));
        }
        pickPhotoAdapterV813.setInitList(arrayList9);
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = submitRatingNoramlContentBinding.advantageRecyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV814 = this.advantageAdapter;
        if (pickPhotoAdapterV814 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        recyclerView.setAdapter(pickPhotoAdapterV814);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setOverScrollMode(2);
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = submitRatingNoramlContentBinding2.disadvantageRecyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV815 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV815 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        recyclerView2.setAdapter(pickPhotoAdapterV815);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setOverScrollMode(2);
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = submitRatingNoramlContentBinding3.summaryRecyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV816 = this.summaryAdapter;
        if (pickPhotoAdapterV816 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        recyclerView3.setAdapter(pickPhotoAdapterV816);
        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView3.setNestedScrollingEnabled(false);
        recyclerView3.setOverScrollMode(2);
    }

    /* access modifiers changed from: private */
    public final void insertOwnerLabel() {
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View childAt = submitRatingNoramlContentBinding.relativeView.getChildAt(0);
        Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) childAt;
        TagProductOwnerBinding tagProductOwnerBinding = (TagProductOwnerBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559185, linearLayout, false);
        TextView textView = tagProductOwnerBinding.ownerTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.ownerTextView");
        textView.setText("机主");
        Intrinsics.checkNotNullExpressionValue(tagProductOwnerBinding, "binding");
        linearLayout.addView(tagProductOwnerBinding.getRoot());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x000f: APUT  
      (r1v0 android.widget.EditText[])
      (0 ??[int, short, byte, char])
      (wrap: android.widget.EditText : 0x000c: IGET  (r2v1 android.widget.EditText) = (r2v0 com.coolapk.market.databinding.SubmitRatingNoramlContentBinding) com.coolapk.market.databinding.SubmitRatingNoramlContentBinding.disadvantageEditText android.widget.EditText)
     */
    private final void initEditTexts() {
        EditText[] editTextArr = new EditText[3];
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        editTextArr[0] = submitRatingNoramlContentBinding.disadvantageEditText;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        editTextArr[1] = submitRatingNoramlContentBinding2.advantageEditText;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        editTextArr[2] = submitRatingNoramlContentBinding3.summaryEditText;
        for (int i = 0; i < 3; i++) {
            EditText editText = editTextArr[i];
            editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
            editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
            editText.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$1(this)));
            editText.addTextChangedListener(new RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$2(this));
            editText.setOnFocusChangeListener(new RatingContentHolderVX1$initEditTexts$$inlined$forEach$lambda$3(this));
        }
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding4 = this.binding;
        if (submitRatingNoramlContentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding4.disadvantageEditText.setText(getMultiPart().commentBad());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding5 = this.binding;
        if (submitRatingNoramlContentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding5.advantageEditText.setText(getMultiPart().commentGood());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding6 = this.binding;
        if (submitRatingNoramlContentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding6.summaryEditText.setText(getMultiPart().commentGeneral());
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding7 = this.binding;
        if (submitRatingNoramlContentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = submitRatingNoramlContentBinding7.advantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.advantageEditText");
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding8 = this.binding;
        if (submitRatingNoramlContentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText3 = submitRatingNoramlContentBinding8.disadvantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.disadvantageEditText");
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding9 = this.binding;
        if (submitRatingNoramlContentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText4 = submitRatingNoramlContentBinding9.summaryEditText;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.summaryEditText");
        String targetType = getMultiPart().targetType();
        Intrinsics.checkNotNullExpressionValue(targetType, "multiPart.targetType()");
        ratingContentHelper.setTextViewHint(editText2, editText3, editText4, targetType);
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void notifyUIChange$presentation_coolapkAppRelease() {
        super.notifyUIChange$presentation_coolapkAppRelease();
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding.setUiConfig(getUiConfig());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitRatingNoramlContentBinding2.executePendingBindings();
    }

    private final void fillRelativeViewIfNeed() {
        SubmitExtraViewPart.Companion companion = SubmitExtraViewPart.Companion;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = submitRatingNoramlContentBinding.relativeView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
        companion.fillRelativeInfoViewIntoLayout(linearLayout, getUiConfig(), new LinearLayout.LayoutParams(-1, NumberExtendsKt.getDp(Double.valueOf(0.5d))));
    }

    /* access modifiers changed from: private */
    public final void updateRatingScore(int i) {
        int constrain = KotlinExtendKt.constrain(i, 5, 0);
        RatingContentHelper ratingContentHelper = RatingContentHelper.INSTANCE;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        BadBadRatingBar badBadRatingBar = submitRatingNoramlContentBinding.ratingBar;
        Intrinsics.checkNotNullExpressionValue(badBadRatingBar, "binding.ratingBar");
        BadBadRatingBar badBadRatingBar2 = badBadRatingBar;
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitRatingNoramlContentBinding2.scoreTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.scoreTextView");
        String targetType = getMultiPart().targetType();
        Intrinsics.checkNotNullExpressionValue(targetType, "multiPart.targetType()");
        ratingContentHelper.setRatingUI(badBadRatingBar2, textView, targetType, constrain);
        if (getMultiPart().ratingScore1() != constrain) {
            FeedMultiPart build = getMultiPart().newBuilder().ratingScore1(constrain).build();
            Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().r…Score1(realScore).build()");
            updateMultiPart$presentation_coolapkAppRelease(build);
            requestCheckSubmittable$presentation_coolapkAppRelease();
        }
        updateBuyStateVisibility();
    }

    private final void updateBuyStateVisibility() {
        if (getMultiPart().ratingScore1() > 0 || getMultiPart().buyStatus()) {
            SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
            if (submitRatingNoramlContentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            CheckBox checkBox = submitRatingNoramlContentBinding.buyStateView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.buyStateView");
            if ((checkBox.getVisibility() == 8) && !getUiConfig().isFeedTargetPhoneOrTablet() && Intrinsics.areEqual(getMultiPart().targetType(), "product_phone")) {
                SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
                if (submitRatingNoramlContentBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox2 = submitRatingNoramlContentBinding2.buyStateView;
                Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.buyStateView");
                ViewParent parent = checkBox2.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                TransitionManager.beginDelayedTransition((ViewGroup) parent);
                SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
                if (submitRatingNoramlContentBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox3 = submitRatingNoramlContentBinding3.buyStateView;
                Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.buyStateView");
                checkBox3.setVisibility(0);
            }
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onDeleteButtonClick() {
        super.onDeleteButtonClick();
        EditText editText = this.focusEditText;
        if (editText != null) {
            ViewExtendsKt.insertBackKey(editText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder, com.coolapk.market.widget.emotion.EmotionPanel.EmotionPanelListener
    public void onEmotionClick(BaseEmotion baseEmotion) {
        Intrinsics.checkNotNullParameter(baseEmotion, "emotions");
        super.onEmotionClick(baseEmotion);
        String realText = baseEmotion.getRealText();
        EditText editText = this.focusEditText;
        if (editText != null) {
            Intrinsics.checkNotNullExpressionValue(realText, "emotionText");
            ViewExtendsKt.insertText(editText, realText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickTopicIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickTopicIntent(intent);
        EditText editText = this.focusEditText;
        if (editText != null) {
            CommentHelper.processTopicResult(intent, editText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAtIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAtIntent(intent);
        EditText editText = this.focusEditText;
        if (editText != null) {
            CommentHelper.processAtUserResult(intent, editText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickAppIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onPickAppIntent(intent);
        EditText editText = this.focusEditText;
        if (editText != null) {
            CommentHelper.processAddAppResult(intent, editText);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        super.onPickImageListChange(list);
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        pickPhotoAdapterV8.onPickedImageChange(list);
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRequestPickImage() {
        super.onRequestPickImage();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        pickPhotoAdapterV8.pickImage();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        startSubmitFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitRatingNoramlContentBinding.disadvantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.disadvantageEditText");
        String obj = editText.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        FeedMultiPart.Builder commentBad = builder.commentBad(StringsKt.trim((CharSequence) obj).toString());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = submitRatingNoramlContentBinding2.advantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.advantageEditText");
        String obj2 = editText2.getText().toString();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
        FeedMultiPart.Builder commentGood = commentBad.commentGood(StringsKt.trim((CharSequence) obj2).toString());
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText3 = submitRatingNoramlContentBinding3.summaryEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.summaryEditText");
        String obj3 = editText3.getText().toString();
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.CharSequence");
        commentGood.commentGeneral(StringsKt.trim((CharSequence) obj3).toString());
        List<ImageUrl> imageUriList = getMultiPart().imageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "multiPart.imageUriList()");
        ArrayList arrayList = new ArrayList();
        for (T t : imageUriList) {
            T t2 = t;
            Intrinsics.checkNotNullExpressionValue(t2, "it");
            if (!Intrinsics.areEqual(t2.getSourceUrl(), t2.getCompressedUrl())) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj4 : arrayList2) {
            ImageUrl imageUrl = (ImageUrl) obj4;
            Intrinsics.checkNotNullExpressionValue(imageUrl, "it");
            linkedHashMap.put(imageUrl.getSourceUrl(), obj4);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        List<ImageUrl> imageUrls = pickPhotoAdapterV8.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls, "advantageAdapter.imageUrls");
        linkedHashSet.addAll(imageUrls);
        PickPhotoAdapterV8 pickPhotoAdapterV82 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV82 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        List<ImageUrl> imageUrls2 = pickPhotoAdapterV82.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls2, "disAdvantageAdapter.imageUrls");
        linkedHashSet.addAll(imageUrls2);
        PickPhotoAdapterV8 pickPhotoAdapterV83 = this.summaryAdapter;
        if (pickPhotoAdapterV83 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        List<ImageUrl> imageUrls3 = pickPhotoAdapterV83.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls3, "summaryAdapter.imageUrls");
        linkedHashSet.addAll(imageUrls3);
        LinkedHashSet<ImageUrl> linkedHashSet2 = linkedHashSet;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet2, 10));
        for (ImageUrl imageUrl2 : linkedHashSet2) {
            if (linkedHashMap.containsKey(imageUrl2.getSourceUrl())) {
                Object obj5 = linkedHashMap.get(imageUrl2.getSourceUrl());
                Intrinsics.checkNotNull(obj5);
                imageUrl2 = (ImageUrl) obj5;
            }
            arrayList3.add(imageUrl2);
        }
        builder.imageUriList(arrayList3);
        PickPhotoAdapterV8 pickPhotoAdapterV84 = this.advantageAdapter;
        if (pickPhotoAdapterV84 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
        }
        List<ImageUrl> imageUrls4 = pickPhotoAdapterV84.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls4, "advantageAdapter.imageUrls");
        builder.commentGoodPic(CollectionsKt.joinToString$default(imageUrls4, ",", null, null, 0, null, RatingContentHolderVX1$generateDraftCopy$1.INSTANCE, 30, null));
        PickPhotoAdapterV8 pickPhotoAdapterV85 = this.disAdvantageAdapter;
        if (pickPhotoAdapterV85 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
        }
        List<ImageUrl> imageUrls5 = pickPhotoAdapterV85.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls5, "disAdvantageAdapter.imageUrls");
        builder.commentBadPic(CollectionsKt.joinToString$default(imageUrls5, ",", null, null, 0, null, RatingContentHolderVX1$generateDraftCopy$2.INSTANCE, 30, null));
        PickPhotoAdapterV8 pickPhotoAdapterV86 = this.summaryAdapter;
        if (pickPhotoAdapterV86 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
        }
        List<ImageUrl> imageUrls6 = pickPhotoAdapterV86.getImageUrls();
        Intrinsics.checkNotNullExpressionValue(imageUrls6, "summaryAdapter.imageUrls");
        builder.commentGeneralPic(CollectionsKt.joinToString$default(imageUrls6, ",", null, null, 0, null, RatingContentHolderVX1$generateDraftCopy$3.INSTANCE, 30, null));
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        updateMultiPart$presentation_coolapkAppRelease(generateDraftCopy$presentation_coolapkAppRelease());
        Observable<R> map = super.prepareMultiFeed$presentation_coolapkAppRelease().map(new RatingContentHolderVX1$prepareMultiFeed$1(this));
        Intrinsics.checkNotNullExpressionValue(map, "super.prepareMultiFeed()…ltiPart\n                }");
        return map;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        if (getMultiPart().ratingScore1() <= 0) {
            return false;
        }
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
        if (submitRatingNoramlContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = submitRatingNoramlContentBinding.advantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.advantageEditText");
        Editable text = editText.getText();
        boolean z = !(text == null || StringsKt.isBlank(text));
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
        if (submitRatingNoramlContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = submitRatingNoramlContentBinding2.disadvantageEditText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.disadvantageEditText");
        Editable text2 = editText2.getText();
        boolean z2 = !(text2 == null || StringsKt.isBlank(text2));
        SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding3 = this.binding;
        if (submitRatingNoramlContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText3 = submitRatingNoramlContentBinding3.summaryEditText;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.summaryEditText");
        Editable text3 = editText3.getText();
        boolean z3 = !(text3 == null || StringsKt.isBlank(text3));
        if (!z && !z2 && !z3) {
            PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
            if (pickPhotoAdapterV8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
            }
            List<ImageUrl> imageUrls = pickPhotoAdapterV8.getImageUrls();
            Intrinsics.checkNotNullExpressionValue(imageUrls, "advantageAdapter.imageUrls");
            if (!imageUrls.isEmpty()) {
                return false;
            }
            PickPhotoAdapterV8 pickPhotoAdapterV82 = this.disAdvantageAdapter;
            if (pickPhotoAdapterV82 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
            }
            List<ImageUrl> imageUrls2 = pickPhotoAdapterV82.getImageUrls();
            Intrinsics.checkNotNullExpressionValue(imageUrls2, "disAdvantageAdapter.imageUrls");
            if (!imageUrls2.isEmpty()) {
                return false;
            }
            PickPhotoAdapterV8 pickPhotoAdapterV83 = this.summaryAdapter;
            if (pickPhotoAdapterV83 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
            }
            List<ImageUrl> imageUrls3 = pickPhotoAdapterV83.getImageUrls();
            Intrinsics.checkNotNullExpressionValue(imageUrls3, "summaryAdapter.imageUrls");
            if (!imageUrls3.isEmpty()) {
                return false;
            }
            return true;
        } else if (!z || !z2 || !z3) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362005:
                Activity activity = getActivity();
                PickPhotoAdapterV8 pickPhotoAdapterV8 = this.advantageAdapter;
                if (pickPhotoAdapterV8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
                }
                List<ImageUrl> imageUrls = pickPhotoAdapterV8.getImageUrls();
                Intrinsics.checkNotNullExpressionValue(imageUrls, "advantageAdapter.imageUrls");
                List<ImageUrl> list = imageUrls;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (T t : list) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    Uri parse = Uri.parse(t.getSourceUrl());
                    Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(it.sourceUrl)");
                    arrayList.add(parse.getPath());
                }
                ActionManager.startPhotoPickerActivity(activity, 9, arrayList, 2355);
                UiUtils.closeKeyboard(getFocusEditorView());
                return;
            case 2131362261:
                SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding = this.binding;
                if (submitRatingNoramlContentBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FeedWarningBinding feedWarningBinding = submitRatingNoramlContentBinding.alertView;
                Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
                View root = feedWarningBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
                ViewParent parent = root.getParent();
                if (!(parent instanceof ViewGroup)) {
                    parent = null;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup != null) {
                    TransitionManager.beginDelayedTransition(viewGroup);
                    SubmitRatingNoramlContentBinding submitRatingNoramlContentBinding2 = this.binding;
                    if (submitRatingNoramlContentBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    FeedWarningBinding feedWarningBinding2 = submitRatingNoramlContentBinding2.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    return;
                }
                return;
            case 2131362411:
                Activity activity2 = getActivity();
                PickPhotoAdapterV8 pickPhotoAdapterV82 = this.disAdvantageAdapter;
                if (pickPhotoAdapterV82 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
                }
                List<ImageUrl> imageUrls2 = pickPhotoAdapterV82.getImageUrls();
                Intrinsics.checkNotNullExpressionValue(imageUrls2, "disAdvantageAdapter.imageUrls");
                List<ImageUrl> list2 = imageUrls2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (T t2 : list2) {
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    Uri parse2 = Uri.parse(t2.getSourceUrl());
                    Intrinsics.checkNotNullExpressionValue(parse2, "Uri.parse(it.sourceUrl)");
                    arrayList2.add(parse2.getPath());
                }
                ActionManager.startPhotoPickerActivity(activity2, 9, arrayList2, 2354);
                UiUtils.closeKeyboard(getFocusEditorView());
                return;
            case 2131362486:
                this.isContentTextCollapsed = !this.isContentTextCollapsed;
                updateCollapsedState();
                return;
            case 2131363482:
                Activity activity3 = getActivity();
                PickPhotoAdapterV8 pickPhotoAdapterV83 = this.summaryAdapter;
                if (pickPhotoAdapterV83 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
                }
                List<ImageUrl> imageUrls3 = pickPhotoAdapterV83.getImageUrls();
                Intrinsics.checkNotNullExpressionValue(imageUrls3, "summaryAdapter.imageUrls");
                List<ImageUrl> list3 = imageUrls3;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (T t3 : list3) {
                    Intrinsics.checkNotNullExpressionValue(t3, "it");
                    Uri parse3 = Uri.parse(t3.getSourceUrl());
                    Intrinsics.checkNotNullExpressionValue(parse3, "Uri.parse(it.sourceUrl)");
                    arrayList3.add(parse3.getPath());
                }
                ActionManager.startPhotoPickerActivity(activity3, 9, arrayList3, 2353);
                UiUtils.closeKeyboard(getFocusEditorView());
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 2353:
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                PickPhotoAdapterV8 pickPhotoAdapterV8 = this.summaryAdapter;
                if (pickPhotoAdapterV8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("summaryAdapter");
                }
                pickPhotoAdapterV8.onPickedImageChange(stringArrayListExtra);
                requestCheckSubmittable$presentation_coolapkAppRelease();
                return;
            case 2354:
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                PickPhotoAdapterV8 pickPhotoAdapterV82 = this.disAdvantageAdapter;
                if (pickPhotoAdapterV82 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disAdvantageAdapter");
                }
                pickPhotoAdapterV82.onPickedImageChange(stringArrayListExtra2);
                requestCheckSubmittable$presentation_coolapkAppRelease();
                return;
            case 2355:
                ArrayList<String> stringArrayListExtra3 = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                PickPhotoAdapterV8 pickPhotoAdapterV83 = this.advantageAdapter;
                if (pickPhotoAdapterV83 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advantageAdapter");
                }
                pickPhotoAdapterV83.onPickedImageChange(stringArrayListExtra3);
                requestCheckSubmittable$presentation_coolapkAppRelease();
                return;
            default:
                return;
        }
    }
}
