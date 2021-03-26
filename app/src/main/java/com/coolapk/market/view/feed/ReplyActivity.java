package com.coolapk.market.view.feed;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemReplyPhotoAddBinding;
import com.coolapk.market.databinding.ItemReplyPhotoBinding;
import com.coolapk.market.databinding.ReplyBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.FeedDraft;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.coolapk.market.widget.emotion.EmotionUtils;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import com.coolapk.market.widget.view.KeyBoardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0005ABCDEB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0013H\u0016J\u0016\u0010$\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\b\u0010(\u001a\u00020\u0013H\u0014J\b\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0018H\u0002J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0013H\u0002J\b\u00104\u001a\u00020\u0013H\u0002J\u0010\u00105\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JO\u00106\u001a\u00020\u0013\"\u0004\b\u0000\u00107*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H709082\u0006\u0010:\u001a\u00020;2'\u0010<\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H709¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u00130=H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/ReplyBinding;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "feedDraft", "Lcom/coolapk/market/model/FeedDraft;", "isAnimating", "", "isPosting", "photoAdapter", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "shouldCacheTheDraftOnPause", "uiConfig", "Lcom/coolapk/market/view/feed/ReplyActivity$ReplyUiConfig;", "checkPostButtonState", "", "finish", "initView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onPhotoPick", "pathList", "", "", "onSetStatusBarColor", "pickPhoto", "removeAllPhoto", "removePhoto", "index", "sendFeedReplyResult", "type", "setAnimationValue", "value", "", "startCloseAnimation", "startOpenAnimation", "submitReply", "updateUiConfig", "doPost", "T", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "dialog", "Landroid/app/Dialog;", "send", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Companion", "ItemAddPhotoViewHolder", "ItemPhotoViewHolder", "MyDiffCallback", "ReplyUiConfig", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity extends BaseActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    private static final String ITEM_TYPE_ADD = "ADD";
    public static final String KEY_EXTRA_DRAFT = "EXTRA_DRAFT";
    public static final String KEY_EXTRA_ENTITY = "EXTRA_FEED_REPLY";
    private ReplyBinding binding;
    private ColorDrawable colorDrawable = new ColorDrawable(-16777216);
    private FeedDraft feedDraft;
    private boolean isAnimating;
    private boolean isPosting;
    private BaseMultiTypeAdapter photoAdapter;
    private boolean shouldCacheTheDraftOnPause = true;
    private ReplyUiConfig uiConfig;

    public static final /* synthetic */ ReplyBinding access$getBinding$p(ReplyActivity replyActivity) {
        ReplyBinding replyBinding = replyActivity.binding;
        if (replyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return replyBinding;
    }

    public static final /* synthetic */ FeedDraft access$getFeedDraft$p(ReplyActivity replyActivity) {
        FeedDraft feedDraft2 = replyActivity.feedDraft;
        if (feedDraft2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        return feedDraft2;
    }

    public static final /* synthetic */ ReplyUiConfig access$getUiConfig$p(ReplyActivity replyActivity) {
        ReplyUiConfig replyUiConfig = replyActivity.uiConfig;
        if (replyUiConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        return replyUiConfig;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$Companion;", "", "()V", "ITEM_TYPE_ADD", "", "KEY_EXTRA_DRAFT", "KEY_EXTRA_ENTITY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0090: APUT  
      (r1v1 android.text.InputFilter$LengthFilter[])
      (0 ??[int, short, byte, char])
      (wrap: android.text.InputFilter$LengthFilter : 0x008d: CONSTRUCTOR  (r3v3 android.text.InputFilter$LengthFilter) = 
      (wrap: int : 0x0089: INVOKE  (r0v8 int) = (r4v0 com.coolapk.market.view.feed.ReplyActivity$ReplyUiConfig) type: VIRTUAL call: com.coolapk.market.view.feed.ReplyActivity.ReplyUiConfig.getMaxWords():int)
     call: android.text.InputFilter.LengthFilter.<init>(int):void type: CONSTRUCTOR)
     */
    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        ReplyActivity replyActivity = this;
        ThemeUtils.setSystemBarDrawFlags(replyActivity);
        super.onCreate(bundle);
        ReplyActivity replyActivity2 = this;
        ViewDataBinding contentView = DataBindingUtil.setContentView(replyActivity, 2131559116, new ContextBindingComponent(replyActivity2));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…xtBindingComponent(this))");
        this.binding = (ReplyBinding) contentView;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("EXTRA_DRAFT");
        Intrinsics.checkNotNull(parcelableExtra);
        this.feedDraft = (FeedDraft) parcelableExtra;
        DataManager instance = DataManager.getInstance();
        FeedDraft feedDraft2 = this.feedDraft;
        if (feedDraft2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        FeedDraft draftLike = instance.getDraftLike(feedDraft2);
        if (draftLike != null) {
            this.feedDraft = draftLike;
        }
        ReplyUiConfig.Companion companion = ReplyUiConfig.Companion;
        FeedDraft feedDraft3 = this.feedDraft;
        if (feedDraft3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        ReplyUiConfig buildReplyUiConfig = companion.buildReplyUiConfig(replyActivity2, feedDraft3);
        this.uiConfig = buildReplyUiConfig;
        if (buildReplyUiConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        if (buildReplyUiConfig.getMaxWords() > 0) {
            ReplyBinding replyBinding = this.binding;
            if (replyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = replyBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            InputFilter.LengthFilter[] lengthFilterArr = new InputFilter.LengthFilter[1];
            ReplyUiConfig replyUiConfig = this.uiConfig;
            if (replyUiConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            lengthFilterArr[0] = new InputFilter.LengthFilter(replyUiConfig.getMaxWords());
            editText.setFilters(lengthFilterArr);
        }
        setSlidrEnable(false);
        initView();
    }

    private final void initView() {
        float dp = (float) NumberExtendsKt.getDp((Number) 8);
        ReplyBinding replyBinding = this.binding;
        if (replyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = replyBinding.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        boolean z = true;
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        ReplyBinding replyBinding2 = this.binding;
        if (replyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding2.setClick(this);
        ReplyBinding replyBinding3 = this.binding;
        if (replyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ReplyUiConfig replyUiConfig = this.uiConfig;
        if (replyUiConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        replyBinding3.setUiConfig(replyUiConfig);
        ReplyBinding replyBinding4 = this.binding;
        if (replyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding4.executePendingBindings();
        ReplyBinding replyBinding5 = this.binding;
        if (replyBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = replyBinding5.editText;
        editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        editText.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new ReplyActivity$initView$$inlined$apply$lambda$1(this)));
        editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        editText.addTextChangedListener(new ReplyActivity$initView$$inlined$apply$lambda$2(this));
        FeedDraft feedDraft2 = this.feedDraft;
        if (feedDraft2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        String message = feedDraft2.getMessage();
        if (!(message == null || message.length() == 0)) {
            z = false;
        }
        if (z) {
            ReplyBinding replyBinding6 = this.binding;
            if (replyBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText2 = replyBinding6.editText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
            String obj = editText2.getText().toString();
            ReplyBinding replyBinding7 = this.binding;
            if (replyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = replyBinding7.editText;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
            Editable text = editText3.getText();
            text.clear();
            text.append((CharSequence) obj);
            ReplyBinding replyBinding8 = this.binding;
            if (replyBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            replyBinding8.editText.setSelection(0, 0);
        } else {
            ReplyBinding replyBinding9 = this.binding;
            if (replyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText4 = replyBinding9.editText;
            FeedDraft feedDraft3 = this.feedDraft;
            if (feedDraft3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
            }
            String message2 = feedDraft3.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            editText4.setText(message2);
            ReplyBinding replyBinding10 = this.binding;
            if (replyBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText5 = replyBinding10.editText;
            ReplyBinding replyBinding11 = this.binding;
            if (replyBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            editText5.setSelection(replyBinding11.editText.length());
        }
        checkPostButtonState();
        ReplyBinding replyBinding12 = this.binding;
        if (replyBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = replyBinding12.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().addOnPreDrawListener(new ReplyActivity$initView$4(this));
        ReplyBinding replyBinding13 = this.binding;
        if (replyBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding13.getRoot().postDelayed(new ReplyActivity$initView$5(this), 100);
        ReplyBinding replyBinding14 = this.binding;
        if (replyBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding14.iconView.setOnLongClickListener(new ReplyActivity$initView$6(this));
        ReplyBinding replyBinding15 = this.binding;
        if (replyBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EmotionPanel emotionPanel = replyBinding15.emotionPanel;
        ReplyBinding replyBinding16 = this.binding;
        if (replyBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        emotionPanel.setupWithEditText(replyBinding16.editText);
        ReplyBinding replyBinding17 = this.binding;
        if (replyBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = replyBinding17.keyBoardInteractLayout;
        ReplyBinding replyBinding18 = this.binding;
        if (replyBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        keyBoardLayout.setKeyBoardView(replyBinding18.fakeKeyboardView);
        ReplyBinding replyBinding19 = this.binding;
        if (replyBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = replyBinding19.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        keyBoardLayout2.getFakeKeyboardObservable().subscribe((Subscriber<? super Boolean>) new ReplyActivity$initView$7(this));
        ReplyBinding replyBinding20 = this.binding;
        if (replyBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout3 = replyBinding20.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout3, "binding.keyBoardInteractLayout");
        PublishSubject<Boolean> fakeKeyboardObservable = keyBoardLayout3.getFakeKeyboardObservable();
        ReplyBinding replyBinding21 = this.binding;
        if (replyBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout4 = replyBinding21.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout4, "binding.keyBoardInteractLayout");
        Observable.combineLatest(fakeKeyboardObservable, keyBoardLayout4.getKeyboardObservable(), ReplyActivity$initView$8.INSTANCE).subscribe((Subscriber) new ReplyActivity$initView$9(this));
        ReplyActivity replyActivity = this;
        ContextBindingComponent contextBindingComponent = new ContextBindingComponent(replyActivity);
        ReplyActivity$initView$10 replyActivity$initView$10 = new ReplyActivity$initView$10(this);
        this.photoAdapter = replyActivity$initView$10;
        if (replyActivity$initView$10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoAdapter");
        }
        BaseMultiTypeAdapter.register$default(replyActivity$initView$10, SimpleViewHolderFactor.Companion.withLayoutId(2131558900).suitedMethod(ReplyActivity$initView$11.INSTANCE).constructor(new ReplyActivity$initView$12(this, contextBindingComponent)).build(), 0, 2, null);
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.photoAdapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoAdapter");
        }
        BaseMultiTypeAdapter.register$default(baseMultiTypeAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558901).suitedMethod(ReplyActivity$initView$13.INSTANCE).constructor(new ReplyActivity$initView$14(this, contextBindingComponent)).build(), 0, 2, null);
        ReplyBinding replyBinding22 = this.binding;
        if (replyBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = replyBinding22.photoListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.photoListView");
        BaseMultiTypeAdapter baseMultiTypeAdapter2 = this.photoAdapter;
        if (baseMultiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoAdapter");
        }
        recyclerView.setAdapter(baseMultiTypeAdapter2);
        ReplyBinding replyBinding23 = this.binding;
        if (replyBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = replyBinding23.photoListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.photoListView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(replyActivity, 0, false));
        RecyclerViewDivider build = RecyclerViewDivider.Companion.with(replyActivity).size(NumberExtendsKt.getDp((Number) 8)).asSpace().hideLastDivider().build();
        ReplyBinding replyBinding24 = this.binding;
        if (replyBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = replyBinding24.photoListView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.photoListView");
        build.addTo(recyclerView3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        ViewGroup viewGroup = null;
        switch (view.getId()) {
            case 2131362196:
            case 2131362908:
                onBackPressed();
                return;
            case 2131362225:
                ReplyBinding replyBinding = this.binding;
                if (replyBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox = replyBinding.checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
                ReplyBinding replyBinding2 = this.binding;
                if (replyBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox2 = replyBinding2.checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.checkBox");
                checkBox.setChecked(!checkBox2.isChecked());
                return;
            case 2131362256:
                ReplyBinding replyBinding3 = this.binding;
                if (replyBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FeedWarningBinding feedWarningBinding = replyBinding3.alertView;
                Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
                View root = feedWarningBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.alertView.root");
                ViewParent parent = root.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = parent;
                }
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 != null) {
                    TransitionManager.beginDelayedTransition(viewGroup2);
                    ReplyBinding replyBinding4 = this.binding;
                    if (replyBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    FeedWarningBinding feedWarningBinding2 = replyBinding4.alertView;
                    Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                    View root2 = feedWarningBinding2.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                    root2.setVisibility(8);
                    return;
                }
                return;
            case 2131362441:
                ReplyBinding replyBinding5 = this.binding;
                if (replyBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout = replyBinding5.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
                if (!keyBoardLayout.isRealKeyboard()) {
                    ReplyBinding replyBinding6 = this.binding;
                    if (replyBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    UiUtils.openKeyboard(replyBinding6.editText);
                    return;
                }
                return;
            case 2131362672:
                FeedDraft feedDraft2 = this.feedDraft;
                if (feedDraft2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                ImageUrl imageUrl = feedDraft2.getImageUriList().get(0);
                Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                ActionManager.startPhotoViewActivity(view, imageUrl.getSourceUrl(), imageUrl.getCompressedUrl());
                return;
            case 2131362917:
                pickPhoto();
                return;
            case 2131362918:
                ActionManager.startPickUserActivity(this, 8655, 5, getString(2131886950));
                return;
            case 2131362921:
                ReplyBinding replyBinding7 = this.binding;
                if (replyBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout2 = replyBinding7.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
                if (keyBoardLayout2.isRealKeyboard()) {
                    ReplyBinding replyBinding8 = this.binding;
                    if (replyBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    UiUtils.closeKeyboard(replyBinding8.editText);
                    return;
                }
                ReplyBinding replyBinding9 = this.binding;
                if (replyBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout3 = replyBinding9.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout3, "binding.keyBoardInteractLayout");
                if (keyBoardLayout3.isFakeKeyBoardShowed()) {
                    ReplyBinding replyBinding10 = this.binding;
                    if (replyBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    replyBinding10.keyBoardInteractLayout.showFakeKeyBoardView(false);
                    ReplyBinding replyBinding11 = this.binding;
                    if (replyBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    replyBinding11.keyBoardInteractLayout.requestLayout();
                    return;
                }
                ReplyBinding replyBinding12 = this.binding;
                if (replyBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                UiUtils.openKeyboard(replyBinding12.editText);
                return;
            case 2131362923:
                ReplyBinding replyBinding13 = this.binding;
                if (replyBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout4 = replyBinding13.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout4, "binding.keyBoardInteractLayout");
                if (keyBoardLayout4.isRealKeyboard()) {
                    ReplyBinding replyBinding14 = this.binding;
                    if (replyBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    UiUtils.closeKeyboard(replyBinding14.editText);
                    ReplyBinding replyBinding15 = this.binding;
                    if (replyBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    replyBinding15.keyBoardInteractLayout.showFakeKeyBoardView(true);
                    ReplyBinding replyBinding16 = this.binding;
                    if (replyBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    replyBinding16.keyBoardInteractLayout.requestLayout();
                    return;
                }
                ReplyBinding replyBinding17 = this.binding;
                if (replyBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout5 = replyBinding17.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout5, "binding.keyBoardInteractLayout");
                if (keyBoardLayout5.isFakeKeyBoardShowed()) {
                    ReplyBinding replyBinding18 = this.binding;
                    if (replyBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    UiUtils.openKeyboard(replyBinding18.editText);
                    return;
                }
                ReplyBinding replyBinding19 = this.binding;
                if (replyBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                replyBinding19.keyBoardInteractLayout.showFakeKeyBoardView(true);
                ReplyBinding replyBinding20 = this.binding;
                if (replyBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                replyBinding20.keyBoardInteractLayout.requestLayout();
                return;
            case 2131362927:
                ActionManager.startPickAppActivity(this, 1561);
                return;
            case 2131362928:
                ActionManager.startPickTopicActivity(this, 6666);
                return;
            case 2131363134:
                if (PrivacyAlertDialog.Companion.shouldShowByIntent()) {
                    PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                }
                submitReply();
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 3925) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                Intrinsics.checkNotNull(stringArrayListExtra);
                Intrinsics.checkNotNullExpressionValue(stringArrayListExtra, "data.getStringArrayListE…TRA_PICKED_PHOTO_PATHS)!!");
                onPhotoPick(stringArrayListExtra);
                return;
            } else if (i == 1561) {
                ReplyBinding replyBinding = this.binding;
                if (replyBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CommentHelper.processAddAppResult(intent, replyBinding.editText);
                return;
            } else {
                if (i == 8655) {
                    ReplyBinding replyBinding2 = this.binding;
                    if (replyBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    CommentHelper.processAtUserResult(intent, replyBinding2.editText);
                }
                if (i == 6666) {
                    ReplyBinding replyBinding3 = this.binding;
                    if (replyBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    CommentHelper.processTopicResult(intent, replyBinding3.editText);
                }
            }
        }
        ReplyBinding replyBinding4 = this.binding;
        if (replyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding4.editText.clearFocus();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isAnimating && !this.isPosting) {
            ReplyBinding replyBinding = this.binding;
            if (replyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = replyBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            if (StringsKt.isBlank(editText.getText().toString())) {
                ReplyUiConfig replyUiConfig = this.uiConfig;
                if (replyUiConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                }
                if (replyUiConfig.getImageUrls().isEmpty()) {
                    ReplyBinding replyBinding2 = this.binding;
                    if (replyBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    KeyBoardLayout keyBoardLayout = replyBinding2.keyBoardInteractLayout;
                    Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
                    if (keyBoardLayout.isRealKeyboard()) {
                        ReplyBinding replyBinding3 = this.binding;
                        if (replyBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        UiUtils.closeKeyboard(replyBinding3.editText);
                    }
                    ReplyBinding replyBinding4 = this.binding;
                    if (replyBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    KeyBoardLayout keyBoardLayout2 = replyBinding4.keyBoardInteractLayout;
                    Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
                    if (keyBoardLayout2.isFakeKeyBoardShowed()) {
                        ReplyBinding replyBinding5 = this.binding;
                        if (replyBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        replyBinding5.keyBoardInteractLayout.showFakeKeyBoardView(false);
                        ReplyBinding replyBinding6 = this.binding;
                        if (replyBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        replyBinding6.keyBoardInteractLayout.requestLayout();
                    }
                    startCloseAnimation();
                    return;
                }
            }
            ReplyBinding replyBinding7 = this.binding;
            if (replyBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            KeyBoardLayout keyBoardLayout3 = replyBinding7.keyBoardInteractLayout;
            Intrinsics.checkNotNullExpressionValue(keyBoardLayout3, "binding.keyBoardInteractLayout");
            if (keyBoardLayout3.isRealKeyboard()) {
                ReplyBinding replyBinding8 = this.binding;
                if (replyBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                UiUtils.closeKeyboard(replyBinding8.editText);
                return;
            }
            ReplyBinding replyBinding9 = this.binding;
            if (replyBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            KeyBoardLayout keyBoardLayout4 = replyBinding9.keyBoardInteractLayout;
            Intrinsics.checkNotNullExpressionValue(keyBoardLayout4, "binding.keyBoardInteractLayout");
            if (keyBoardLayout4.isFakeKeyBoardShowed()) {
                ReplyBinding replyBinding10 = this.binding;
                if (replyBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                replyBinding10.keyBoardInteractLayout.showFakeKeyBoardView(false);
                ReplyBinding replyBinding11 = this.binding;
                if (replyBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                replyBinding11.keyBoardInteractLayout.requestLayout();
                return;
            }
            startCloseAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    public final void checkPostButtonState() {
        boolean z;
        ReplyBinding replyBinding;
        ReplyBinding replyBinding2;
        ReplyBinding replyBinding3 = this.binding;
        if (replyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = replyBinding3.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        int emotionCount = EmotionUtils.getEmotionCount(editText.getText().toString());
        ReplyBinding replyBinding4 = this.binding;
        if (replyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = replyBinding4.editText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
        Editable text = editText2.getText();
        Intrinsics.checkNotNullExpressionValue(text, "binding.editText.text");
        if (StringsKt.isBlank(text)) {
            FeedDraft feedDraft2 = this.feedDraft;
            if (feedDraft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
            }
            if (feedDraft2.getImageCount() == 0) {
                z = true;
                boolean z2 = emotionCount <= 100;
                if (!z || z2) {
                    replyBinding = this.binding;
                    if (replyBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView = replyBinding.postButton;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.postButton");
                    textView.setEnabled(false);
                    replyBinding2 = this.binding;
                    if (replyBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    replyBinding2.postButton.setTextColor(ResourceUtils.getColorInt(getActivity(), 2131099893));
                }
                ReplyBinding replyBinding5 = this.binding;
                if (replyBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TextView textView2 = replyBinding5.postButton;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.postButton");
                textView2.setEnabled(true);
                ReplyBinding replyBinding6 = this.binding;
                if (replyBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                replyBinding6.postButton.setTextColor(AppHolder.getAppTheme().getColorAccent());
                return;
            }
        }
        z = false;
        if (emotionCount <= 100) {
        }
        if (!z) {
        }
        replyBinding = this.binding;
        if (replyBinding == null) {
        }
        TextView textView = replyBinding.postButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.postButton");
        textView.setEnabled(false);
        replyBinding2 = this.binding;
        if (replyBinding2 == null) {
        }
        replyBinding2.postButton.setTextColor(ResourceUtils.getColorInt(getActivity(), 2131099893));
    }

    /* access modifiers changed from: private */
    public final void pickPhoto() {
        FeedDraft feedDraft2 = this.feedDraft;
        if (feedDraft2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        List<ImageUrl> imageUriList = feedDraft2.getImageUriList();
        Intrinsics.checkNotNullExpressionValue(imageUriList, "feedDraft.imageUriList");
        ArrayList arrayList = new ArrayList();
        for (T t : imageUriList) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(CoolFileUtils.unwrap(t.getSourceUrl()));
        }
        ArrayList arrayList2 = arrayList;
        FeedDraft feedDraft3 = this.feedDraft;
        if (feedDraft3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
        }
        ActionManager.startPhotoPickerActivity(getActivity(), Intrinsics.areEqual(feedDraft3.getType(), "live_message") ? 9 : 1, arrayList2);
    }

    /* access modifiers changed from: private */
    public final void removePhoto(int i) {
        ReplyUiConfig replyUiConfig = this.uiConfig;
        if (replyUiConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        if (!replyUiConfig.getImageUrls().isEmpty()) {
            ReplyUiConfig replyUiConfig2 = this.uiConfig;
            if (replyUiConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            if (replyUiConfig2.getImageUrls().size() == 2) {
                removeAllPhoto();
                return;
            }
            ReplyUiConfig replyUiConfig3 = this.uiConfig;
            if (replyUiConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            ReplyUiConfig replyUiConfig4 = this.uiConfig;
            if (replyUiConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            ArrayList arrayList = new ArrayList(replyUiConfig4.getImageUrls());
            arrayList.remove(i);
            Unit unit = Unit.INSTANCE;
            updateUiConfig(ReplyUiConfig.copy$default(replyUiConfig3, null, null, null, arrayList, null, false, null, false, false, false, false, 0, 4087, null));
            FeedDraft feedDraft2 = this.feedDraft;
            if (feedDraft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
            }
            feedDraft2.getImageUriList().remove(i);
            checkPostButtonState();
        }
    }

    /* access modifiers changed from: private */
    public final void removeAllPhoto() {
        ReplyUiConfig replyUiConfig = this.uiConfig;
        if (replyUiConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        if (!replyUiConfig.getImageUrls().isEmpty()) {
            ReplyUiConfig replyUiConfig2 = this.uiConfig;
            if (replyUiConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            updateUiConfig(ReplyUiConfig.copy$default(replyUiConfig2, null, null, null, CollectionsKt.emptyList(), null, false, null, false, false, false, false, 0, 4087, null));
            FeedDraft feedDraft2 = this.feedDraft;
            if (feedDraft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
            }
            feedDraft2.getImageUriList().clear();
            checkPostButtonState();
        }
    }

    private final void onPhotoPick(List<String> list) {
        Observable.from(list).flatMap(new ReplyActivity$onPhotoPick$1(this)).compose(RxUtils.applyIOSchedulers()).toList().subscribe((Subscriber) new ReplyActivity$onPhotoPick$2(this, list));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x022a, code lost:
        if (r7.equals("dyh_article_reply") != false) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x022c, code lost:
        r2 = com.coolapk.market.manager.DataManager.getInstance();
        r3 = r13.feedDraft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0232, code lost:
        if (r3 != null) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0234, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0237, code lost:
        r0 = r2.postDyhArticleReply(r3.getExtraId(), r0, r6, r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "DataManager.getInstance(…, url, isCheckBoxChecked)");
        doPost(r0, r1, new com.coolapk.market.view.feed.ReplyActivity$submitReply$4(r13));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0143, code lost:
        if (r7.equals("live_discuss") != false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014a, code lost:
        if (r7.equals("live_message") != false) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014c, code lost:
        r6 = null;
        r7 = r13.feedDraft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0151, code lost:
        if (r7 != null) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0153, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x015a, code lost:
        if (r7.getExtraData() == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015c, code lost:
        r7 = r13.feedDraft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0160, code lost:
        if (r7 != null) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0162, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0165, code lost:
        r6 = new org.json.JSONObject(r7.getExtraData());
        r7 = r6.optString("source_id");
        r6 = r6.optBoolean("is_presenter");
        r11 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017a, code lost:
        r11 = r6;
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017c, code lost:
        r7 = r13.feedDraft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017e, code lost:
        if (r7 != null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0180, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x018b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7.getType(), "live_message") != false) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018d, code lost:
        if (r0 == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0190, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0191, code lost:
        r0 = com.coolapk.market.manager.DataManager.getInstance();
        r4 = r13.feedDraft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0197, code lost:
        if (r4 != null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0199, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x019c, code lost:
        r7 = r4.getExtraId();
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a3, code lost:
        if (r6 == false) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a5, code lost:
        r2 = "live_pic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a8, code lost:
        r2 = "live";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01aa, code lost:
        r0 = r0.postLiveMessage(r7, r0, r9, r11, r3, r2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "DataManager.getInstance(…adOption.UPLOAD_DIR_LIVE)");
        doPost(r0, r1, new com.coolapk.market.view.feed.ReplyActivity$submitReply$5(r13, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cb, code lost:
        if (r7.equals("article_reply") != false) goto L_0x022c;
     */
    private final void submitReply() {
        if (!this.isPosting) {
            ReplyBinding replyBinding = this.binding;
            if (replyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = replyBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            String obj = editText.getText().toString();
            int i = 1;
            if (obj.length() == 0) {
                FeedDraft feedDraft2 = this.feedDraft;
                if (feedDraft2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                if (feedDraft2.getImageCount() == 0) {
                    ReplyBinding replyBinding2 = this.binding;
                    if (replyBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    Toast.show(replyBinding2.getRoot(), 2131886785);
                    return;
                }
                obj = "[图片]";
            }
            if (EmotionUtils.getEmotionCount(obj) <= 100) {
                FeedDraft feedDraft3 = this.feedDraft;
                if (feedDraft3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                List<ImageUrl> imageUriList = feedDraft3.getImageUriList();
                Intrinsics.checkNotNullExpressionValue(imageUriList, "feedDraft.imageUriList");
                ArrayList arrayList = new ArrayList();
                for (T t : imageUriList) {
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    arrayList.add(t.getCompressedUrl());
                }
                ArrayList arrayList2 = arrayList;
                FeedDraft feedDraft4 = this.feedDraft;
                if (feedDraft4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                String str = "";
                if (feedDraft4.getImageCount() > 0) {
                    FeedDraft feedDraft5 = this.feedDraft;
                    if (feedDraft5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                    }
                    ImageUrl imageUrl = feedDraft5.getImageUriList().get(0);
                    Intrinsics.checkNotNullExpressionValue(imageUrl, "feedDraft.imageUriList[0]");
                    String compressedUrl = imageUrl.getCompressedUrl();
                    if (compressedUrl != null) {
                        str = compressedUrl;
                    }
                }
                ReplyBinding replyBinding3 = this.binding;
                if (replyBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox = replyBinding3.checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
                boolean isChecked = checkBox.isChecked();
                this.isPosting = true;
                ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setCancelable(false);
                progressDialog.setProgressStyle(0);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setMessage("正在提交...");
                try {
                    progressDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FeedDraft feedDraft6 = this.feedDraft;
                if (feedDraft6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                String type = feedDraft6.getType();
                if (type != null) {
                    switch (type.hashCode()) {
                        case -1709390443:
                            break;
                        case -538116930:
                            if (type.equals("feed_comment")) {
                                DataManager instance = DataManager.getInstance();
                                FeedDraft feedDraft7 = this.feedDraft;
                                if (feedDraft7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                                }
                                Observable<Result<FeedReply>> postFeedComment = instance.postFeedComment(feedDraft7.getExtraId(), obj, str, isChecked);
                                Intrinsics.checkNotNullExpressionValue(postFeedComment, "DataManager.getInstance(…, url, isCheckBoxChecked)");
                                doPost(postFeedComment, progressDialog, new ReplyActivity$submitReply$2(this));
                                return;
                            }
                            break;
                        case 108401386:
                            if (type.equals("reply")) {
                                DataManager instance2 = DataManager.getInstance();
                                FeedDraft feedDraft8 = this.feedDraft;
                                if (feedDraft8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                                }
                                Observable<Result<FeedReply>> postFeedReply = instance2.postFeedReply(feedDraft8.getExtraId(), obj, str, isChecked);
                                Intrinsics.checkNotNullExpressionValue(postFeedReply, "DataManager.getInstance(…, url, isCheckBoxChecked)");
                                doPost(postFeedReply, progressDialog, new ReplyActivity$submitReply$1(this));
                                return;
                            }
                            break;
                        case 660550241:
                            break;
                        case 789818292:
                            break;
                        case 1506279309:
                            break;
                        case 2104140362:
                            if (type.equals("dyh_article_comment")) {
                                DataManager instance3 = DataManager.getInstance();
                                FeedDraft feedDraft9 = this.feedDraft;
                                if (feedDraft9 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                                }
                                Observable<Result<FeedReply>> postDyhArticleComment = instance3.postDyhArticleComment(feedDraft9.getExtraId(), obj, str, isChecked);
                                Intrinsics.checkNotNullExpressionValue(postDyhArticleComment, "DataManager.getInstance(…, url, isCheckBoxChecked)");
                                doPost(postDyhArticleComment, progressDialog, new ReplyActivity$submitReply$3(this));
                                return;
                            }
                            break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown type ");
                FeedDraft feedDraft10 = this.feedDraft;
                if (feedDraft10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
                }
                sb.append(feedDraft10.getType());
                throw new RuntimeException(sb.toString());
            }
        }
    }

    private final <T> void doPost(Observable<Result<T>> observable, Dialog dialog, Function1<? super Result<T>, Unit> function1) {
        observable.compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new ReplyActivity$doPost$1(this, dialog, function1));
    }

    /* access modifiers changed from: private */
    public final void sendFeedReplyResult(String str) {
        String str2;
        switch (str.hashCode()) {
            case -1709390443:
                if (str.equals("dyh_article_reply")) {
                    str2 = "看看号文章的二级回复";
                    break;
                } else {
                    return;
                }
            case -538116930:
                if (str.equals("feed_comment")) {
                    str2 = "动态的一级回复";
                    break;
                } else {
                    return;
                }
            case 108401386:
                if (str.equals("reply")) {
                    str2 = "动态的二级回复";
                    break;
                } else {
                    return;
                }
            case 660550241:
                if (str.equals("article_reply")) {
                    str2 = "文章的回复";
                    break;
                } else {
                    return;
                }
            case 789818292:
                if (str.equals("live_message")) {
                    str2 = "直播消息";
                    break;
                } else {
                    return;
                }
            case 1506279309:
                if (str.equals("live_discuss")) {
                    str2 = "讨论消息";
                    break;
                } else {
                    return;
                }
            case 2104140362:
                if (str.equals("dyh_article_comment")) {
                    str2 = "看看号文章的一级回复";
                    break;
                } else {
                    return;
                }
            default:
                return;
        }
        StatisticHelper.Companion.getInstance().recordPostReplyEvent(str2);
    }

    /* access modifiers changed from: private */
    public final void updateUiConfig(ReplyUiConfig replyUiConfig) {
        ReplyUiConfig replyUiConfig2 = this.uiConfig;
        if (replyUiConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        List<String> imageUrls = replyUiConfig2.getImageUrls();
        this.uiConfig = replyUiConfig;
        ReplyBinding replyBinding = this.binding;
        if (replyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding.setUiConfig(replyUiConfig);
        ReplyBinding replyBinding2 = this.binding;
        if (replyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        replyBinding2.executePendingBindings();
        List<String> imageUrls2 = replyUiConfig.getImageUrls();
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new ReplyActivity$updateUiConfig$1(imageUrls, imageUrls2, imageUrls, imageUrls2), true);
        BaseMultiTypeAdapter baseMultiTypeAdapter = this.photoAdapter;
        if (baseMultiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoAdapter");
        }
        calculateDiff.dispatchUpdatesTo(baseMultiTypeAdapter);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.shouldCacheTheDraftOnPause) {
            FeedDraft feedDraft2 = this.feedDraft;
            if (feedDraft2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDraft");
            }
            FeedDraft.Builder builder = FeedDraft.builder(feedDraft2);
            ReplyBinding replyBinding = this.binding;
            if (replyBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText = replyBinding.editText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
            DataManager.getInstance().addFeedDraft(builder.setMessage(editText.getText().toString()).build());
        }
    }

    /* access modifiers changed from: private */
    public final void startOpenAnimation() {
        this.isAnimating = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new ReplyActivity$startOpenAnimation$$inlined$apply$lambda$1(this));
        ExtraExtendsKt.doOnEnd(valueAnimator, new ReplyActivity$startOpenAnimation$$inlined$apply$lambda$2(this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public final void startCloseAnimation() {
        if (!isFinishing()) {
            this.isAnimating = true;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            valueAnimator.addUpdateListener(new ReplyActivity$startCloseAnimation$$inlined$apply$lambda$1(this));
            valueAnimator.setDuration(300L);
            ExtraExtendsKt.doOnEnd(valueAnimator, new ReplyActivity$startCloseAnimation$$inlined$apply$lambda$2(this));
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setAnimationValue(float f) {
        this.colorDrawable.setAlpha((int) (((float) 66) * f));
        ReplyBinding replyBinding = this.binding;
        if (replyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = replyBinding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        keyBoardLayout.setBackground(this.colorDrawable);
        ReplyBinding replyBinding2 = this.binding;
        if (replyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = replyBinding2.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        float f2 = ((float) 1) - f;
        ReplyBinding replyBinding3 = this.binding;
        if (replyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = replyBinding3.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentView");
        linearLayout.setTranslationY(f2 * ((float) linearLayout2.getHeight()));
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b$\b\b\u0018\u0000 42\u00020\u0001:\u00014B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\u0011HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0011HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ReplyUiConfig;", "", "titleText", "", "editTextHint", "imageHint", "imageUrls", "", "sourceMessage", "checkBoxViewVisible", "", "checkBoxText", "atUserViewVisible", "topicViewVisible", "pickAppVisible", "sourceViewVisible", "maxWords", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZZZZI)V", "getAtUserViewVisible", "()Z", "getCheckBoxText", "()Ljava/lang/String;", "getCheckBoxViewVisible", "getEditTextHint", "getImageHint", "getImageUrls", "()Ljava/util/List;", "getMaxWords", "()I", "getPickAppVisible", "getSourceMessage", "getSourceViewVisible", "getTitleText", "getTopicViewVisible", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyActivity.kt */
    public static final class ReplyUiConfig {
        public static final Companion Companion = new Companion(null);
        private final boolean atUserViewVisible;
        private final String checkBoxText;
        private final boolean checkBoxViewVisible;
        private final String editTextHint;
        private final String imageHint;
        private final List<String> imageUrls;
        private final int maxWords;
        private final boolean pickAppVisible;
        private final String sourceMessage;
        private final boolean sourceViewVisible;
        private final String titleText;
        private final boolean topicViewVisible;

        public ReplyUiConfig() {
            this(null, null, null, null, null, false, null, false, false, false, false, 0, 4095, null);
        }

        public static /* synthetic */ ReplyUiConfig copy$default(ReplyUiConfig replyUiConfig, String str, String str2, String str3, List list, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, Object obj) {
            return replyUiConfig.copy((i2 & 1) != 0 ? replyUiConfig.titleText : str, (i2 & 2) != 0 ? replyUiConfig.editTextHint : str2, (i2 & 4) != 0 ? replyUiConfig.imageHint : str3, (i2 & 8) != 0 ? replyUiConfig.imageUrls : list, (i2 & 16) != 0 ? replyUiConfig.sourceMessage : str4, (i2 & 32) != 0 ? replyUiConfig.checkBoxViewVisible : z, (i2 & 64) != 0 ? replyUiConfig.checkBoxText : str5, (i2 & 128) != 0 ? replyUiConfig.atUserViewVisible : z2, (i2 & 256) != 0 ? replyUiConfig.topicViewVisible : z3, (i2 & 512) != 0 ? replyUiConfig.pickAppVisible : z4, (i2 & 1024) != 0 ? replyUiConfig.sourceViewVisible : z5, (i2 & 2048) != 0 ? replyUiConfig.maxWords : i);
        }

        public final String component1() {
            return this.titleText;
        }

        public final boolean component10() {
            return this.pickAppVisible;
        }

        public final boolean component11() {
            return this.sourceViewVisible;
        }

        public final int component12() {
            return this.maxWords;
        }

        public final String component2() {
            return this.editTextHint;
        }

        public final String component3() {
            return this.imageHint;
        }

        public final List<String> component4() {
            return this.imageUrls;
        }

        public final String component5() {
            return this.sourceMessage;
        }

        public final boolean component6() {
            return this.checkBoxViewVisible;
        }

        public final String component7() {
            return this.checkBoxText;
        }

        public final boolean component8() {
            return this.atUserViewVisible;
        }

        public final boolean component9() {
            return this.topicViewVisible;
        }

        public final ReplyUiConfig copy(String str, String str2, String str3, List<String> list, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
            Intrinsics.checkNotNullParameter(str, "titleText");
            Intrinsics.checkNotNullParameter(str2, "editTextHint");
            Intrinsics.checkNotNullParameter(str3, "imageHint");
            Intrinsics.checkNotNullParameter(list, "imageUrls");
            Intrinsics.checkNotNullParameter(str4, "sourceMessage");
            Intrinsics.checkNotNullParameter(str5, "checkBoxText");
            return new ReplyUiConfig(str, str2, str3, list, str4, z, str5, z2, z3, z4, z5, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReplyUiConfig)) {
                return false;
            }
            ReplyUiConfig replyUiConfig = (ReplyUiConfig) obj;
            return Intrinsics.areEqual(this.titleText, replyUiConfig.titleText) && Intrinsics.areEqual(this.editTextHint, replyUiConfig.editTextHint) && Intrinsics.areEqual(this.imageHint, replyUiConfig.imageHint) && Intrinsics.areEqual(this.imageUrls, replyUiConfig.imageUrls) && Intrinsics.areEqual(this.sourceMessage, replyUiConfig.sourceMessage) && this.checkBoxViewVisible == replyUiConfig.checkBoxViewVisible && Intrinsics.areEqual(this.checkBoxText, replyUiConfig.checkBoxText) && this.atUserViewVisible == replyUiConfig.atUserViewVisible && this.topicViewVisible == replyUiConfig.topicViewVisible && this.pickAppVisible == replyUiConfig.pickAppVisible && this.sourceViewVisible == replyUiConfig.sourceViewVisible && this.maxWords == replyUiConfig.maxWords;
        }

        public int hashCode() {
            String str = this.titleText;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.editTextHint;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.imageHint;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<String> list = this.imageUrls;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            String str4 = this.sourceMessage;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            boolean z = this.checkBoxViewVisible;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode5 + i3) * 31;
            String str5 = this.checkBoxText;
            if (str5 != null) {
                i = str5.hashCode();
            }
            int i7 = (i6 + i) * 31;
            boolean z2 = this.atUserViewVisible;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (i7 + i8) * 31;
            boolean z3 = this.topicViewVisible;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (i11 + i12) * 31;
            boolean z4 = this.pickAppVisible;
            if (z4) {
                z4 = true;
            }
            int i16 = z4 ? 1 : 0;
            int i17 = z4 ? 1 : 0;
            int i18 = z4 ? 1 : 0;
            int i19 = (i15 + i16) * 31;
            boolean z5 = this.sourceViewVisible;
            if (!z5) {
                i2 = z5 ? 1 : 0;
            }
            return ((i19 + i2) * 31) + this.maxWords;
        }

        public String toString() {
            return "ReplyUiConfig(titleText=" + this.titleText + ", editTextHint=" + this.editTextHint + ", imageHint=" + this.imageHint + ", imageUrls=" + this.imageUrls + ", sourceMessage=" + this.sourceMessage + ", checkBoxViewVisible=" + this.checkBoxViewVisible + ", checkBoxText=" + this.checkBoxText + ", atUserViewVisible=" + this.atUserViewVisible + ", topicViewVisible=" + this.topicViewVisible + ", pickAppVisible=" + this.pickAppVisible + ", sourceViewVisible=" + this.sourceViewVisible + ", maxWords=" + this.maxWords + ")";
        }

        public ReplyUiConfig(String str, String str2, String str3, List<String> list, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
            Intrinsics.checkNotNullParameter(str, "titleText");
            Intrinsics.checkNotNullParameter(str2, "editTextHint");
            Intrinsics.checkNotNullParameter(str3, "imageHint");
            Intrinsics.checkNotNullParameter(list, "imageUrls");
            Intrinsics.checkNotNullParameter(str4, "sourceMessage");
            Intrinsics.checkNotNullParameter(str5, "checkBoxText");
            this.titleText = str;
            this.editTextHint = str2;
            this.imageHint = str3;
            this.imageUrls = list;
            this.sourceMessage = str4;
            this.checkBoxViewVisible = z;
            this.checkBoxText = str5;
            this.atUserViewVisible = z2;
            this.topicViewVisible = z3;
            this.pickAppVisible = z4;
            this.sourceViewVisible = z5;
            this.maxWords = i;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final String getEditTextHint() {
            return this.editTextHint;
        }

        public final String getImageHint() {
            return this.imageHint;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public /* synthetic */ ReplyUiConfig(String str, String str2, String str3, List list, String str4, boolean z, String str5, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? r2 : str, (i2 & 2) != 0 ? r2 : str2, (i2 & 4) != 0 ? r2 : str3, (i2 & 8) != 0 ? new ArrayList() : list, (i2 & 16) != 0 ? r2 : str4, (i2 & 32) != 0 ? false : z, (i2 & 64) == 0 ? str5 : r2, (i2 & 128) != 0 ? true : z2, (i2 & 256) != 0 ? true : z3, (i2 & 512) == 0 ? z4 : true, (i2 & 1024) == 0 ? z5 : false, (i2 & 2048) != 0 ? -1 : i);
            String str6 = "";
        }

        public final List<String> getImageUrls() {
            return this.imageUrls;
        }

        public final String getSourceMessage() {
            return this.sourceMessage;
        }

        public final boolean getCheckBoxViewVisible() {
            return this.checkBoxViewVisible;
        }

        public final String getCheckBoxText() {
            return this.checkBoxText;
        }

        public final boolean getAtUserViewVisible() {
            return this.atUserViewVisible;
        }

        public final boolean getTopicViewVisible() {
            return this.topicViewVisible;
        }

        public final boolean getPickAppVisible() {
            return this.pickAppVisible;
        }

        public final boolean getSourceViewVisible() {
            return this.sourceViewVisible;
        }

        public final int getMaxWords() {
            return this.maxWords;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ReplyUiConfig$Companion;", "", "()V", "buildReplyUiConfig", "Lcom/coolapk/market/view/feed/ReplyActivity$ReplyUiConfig;", "context", "Landroid/content/Context;", "feedDraft", "Lcom/coolapk/market/model/FeedDraft;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ReplyActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0053, code lost:
                if (r3.equals("dyh_article_comment") != false) goto L_0x01fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:63:0x01df, code lost:
                if (r3.equals("article_reply") != false) goto L_0x01fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e8, code lost:
                if (r3.equals("reply") != false) goto L_0x01fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:0x01f1, code lost:
                if (r3.equals("feed_comment") != false) goto L_0x01fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:69:0x01fa, code lost:
                if (r3.equals("dyh_article_reply") != false) goto L_0x01fc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x01fc, code lost:
                r3 = r21.getString(2131887297);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "context.getString(R.string.title_reply)");
                r2 = r22.getExtraData();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:71:0x020e, code lost:
                if (r2 == null) goto L_0x0219;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:73:0x0214, code lost:
                if (r2.length() != 0) goto L_0x0217;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:0x0217, code lost:
                r2 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:75:0x0219, code lost:
                r2 = true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:76:0x021a, code lost:
                if (r2 == false) goto L_0x021f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:77:0x021c, code lost:
                r4 = "";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:78:0x021f, code lost:
                r2 = r21.getString(2131886801, r22.getExtraData());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "context.getString(R.stri…int, feedDraft.extraData)");
                r4 = r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:79:0x0235, code lost:
                r9 = r21.getString(2131886957);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "context.getString(R.string.str_reply_and_forward)");
                r0 = r22.getImageUriList();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "feedDraft.imageUriList");
                r2 = new java.util.ArrayList();
                r0 = r0.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:81:0x0259, code lost:
                if (r0.hasNext() == false) goto L_0x026c;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:82:0x025b, code lost:
                r6 = r0.next();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "it");
                r2.add(r6.getSourceUrl());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
                return com.coolapk.market.view.feed.ReplyActivity.ReplyUiConfig.copy$default(r1, r3, r4, "长按图片可删除图片\n发无关图、色情图将会被禁言", r2, null, true, r9, false, false, false, false, 0, 3984, null);
             */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x0103  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0105  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0108  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x010a  */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01c0  */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x01c2  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x01c5  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x01c7  */
            public final ReplyUiConfig buildReplyUiConfig(Context context, FeedDraft feedDraft) {
                boolean z;
                int i;
                String str;
                boolean z2;
                int i2;
                boolean z3;
                String str2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(feedDraft, "feedDraft");
                ReplyUiConfig replyUiConfig = new ReplyUiConfig(null, null, null, null, null, false, null, false, false, false, false, 0, 4095, null);
                String type = feedDraft.getType();
                if (type != null) {
                    switch (type.hashCode()) {
                        case -1709390443:
                            break;
                        case -538116930:
                            break;
                        case 108401386:
                            break;
                        case 660550241:
                            break;
                        case 789818292:
                            if (type.equals("live_message")) {
                                String str3 = null;
                                if (feedDraft.getExtraData() != null) {
                                    JSONObject jSONObject = new JSONObject(feedDraft.getExtraData());
                                    z = jSONObject.optBoolean("is_presenter");
                                    String optString = jSONObject.optString("source_uid", null);
                                    if (optString != null) {
                                        str3 = "<a href=\"/u/" + optString + "\">" + jSONObject.optString("source_user_name") + "</a>: " + jSONObject.optString("source_message");
                                    }
                                } else {
                                    z = false;
                                }
                                String str4 = z ? "发布直播内容" : "参与直播讨论";
                                List<ImageUrl> imageUriList = feedDraft.getImageUriList();
                                Intrinsics.checkNotNullExpressionValue(imageUriList, "feedDraft.imageUriList");
                                ArrayList arrayList = new ArrayList();
                                for (T t : imageUriList) {
                                    Intrinsics.checkNotNullExpressionValue(t, "it");
                                    arrayList.add(t.getSourceUrl());
                                }
                                ArrayList arrayList2 = arrayList;
                                if (!z) {
                                    DataManager instance = DataManager.getInstance();
                                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                                    LoginSession loginSession = instance.getLoginSession();
                                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                                    if (!loginSession.isAdmin()) {
                                        i = 30;
                                        ArrayList arrayList3 = arrayList2;
                                        boolean z4 = str3 == null;
                                        if (str3 == null) {
                                            str = str3;
                                        } else {
                                            str = "";
                                        }
                                        return ReplyUiConfig.copy$default(replyUiConfig, str4, "我来说两句", "长按图片可删除图片\n发无关图、色情图将会被禁言", arrayList3, str, false, null, false, false, false, z4, i, 64, null);
                                    }
                                }
                                i = -1;
                                ArrayList arrayList3 = arrayList2;
                                if (str3 == null) {
                                }
                                if (str3 == null) {
                                }
                                return ReplyUiConfig.copy$default(replyUiConfig, str4, "我来说两句", "长按图片可删除图片\n发无关图、色情图将会被禁言", arrayList3, str, false, null, false, false, false, z4, i, 64, null);
                            }
                            break;
                        case 1506279309:
                            if (type.equals("live_discuss")) {
                                Boolean bool = null;
                                String str5 = null;
                                if (feedDraft.getExtraData() != null) {
                                    JSONObject jSONObject2 = new JSONObject(feedDraft.getExtraData());
                                    z2 = jSONObject2.optBoolean("is_presenter");
                                    Boolean valueOf = Boolean.valueOf(z2);
                                    String optString2 = jSONObject2.optString("source_uid", null);
                                    if (optString2 != null) {
                                        str5 = "<a href=\"/u/" + optString2 + "\">" + jSONObject2.optString("source_user_name") + "</a>: " + jSONObject2.optString("source_message");
                                    }
                                    bool = valueOf;
                                } else {
                                    z2 = false;
                                }
                                List<ImageUrl> imageUriList2 = feedDraft.getImageUriList();
                                Intrinsics.checkNotNullExpressionValue(imageUriList2, "feedDraft.imageUriList");
                                ArrayList arrayList4 = new ArrayList();
                                for (T t2 : imageUriList2) {
                                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                                    arrayList4.add(t2.getSourceUrl());
                                }
                                ArrayList arrayList5 = arrayList4;
                                if (!z2) {
                                    DataManager instance2 = DataManager.getInstance();
                                    Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                                    LoginSession loginSession2 = instance2.getLoginSession();
                                    Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                                    if (!loginSession2.isAdmin()) {
                                        z3 = true;
                                        i2 = 30;
                                        boolean areEqual = Intrinsics.areEqual(bool, Boolean.valueOf(z3));
                                        ArrayList arrayList6 = arrayList5;
                                        boolean z5 = str5 == null;
                                        if (str5 == null) {
                                            str2 = str5;
                                        } else {
                                            str2 = "";
                                        }
                                        return replyUiConfig.copy("参与直播讨论", "我来说两句", "长按图片可删除图片\n发无关图、色情图将会被禁言", arrayList6, str2, areEqual, "评论并上墙", false, false, false, z5, i2);
                                    }
                                }
                                z3 = true;
                                i2 = -1;
                                boolean areEqual = Intrinsics.areEqual(bool, Boolean.valueOf(z3));
                                ArrayList arrayList6 = arrayList5;
                                if (str5 == null) {
                                }
                                if (str5 == null) {
                                }
                                return replyUiConfig.copy("参与直播讨论", "我来说两句", "长按图片可删除图片\n发无关图、色情图将会被禁言", arrayList6, str2, areEqual, "评论并上墙", false, false, false, z5, i2);
                            }
                            break;
                        case 2104140362:
                            break;
                    }
                }
                throw new RuntimeException("请支持这个类型");
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0012\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ItemPhotoViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemReplyPhotoBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemReplyPhotoBinding;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyActivity.kt */
    private static class ItemPhotoViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558900;
        private final ItemReplyPhotoBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemPhotoViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            ItemReplyPhotoBinding itemReplyPhotoBinding = (ItemReplyPhotoBinding) getBinding();
            this.binding = itemReplyPhotoBinding;
            ItemPhotoViewHolder itemPhotoViewHolder = this;
            itemReplyPhotoBinding.iconView.setOnClickListener(itemPhotoViewHolder);
            itemReplyPhotoBinding.closeView.setOnClickListener(itemPhotoViewHolder);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ItemPhotoViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ReplyActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        protected final ItemReplyPhotoBinding getBinding() {
            return this.binding;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            ItemReplyPhotoBinding itemReplyPhotoBinding = this.binding;
            Intrinsics.checkNotNullExpressionValue(itemReplyPhotoBinding, "binding");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            itemReplyPhotoBinding.setUrl((String) obj);
            this.binding.executePendingBindings();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ItemAddPhotoViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemReplyPhotoAddBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemReplyPhotoAddBinding;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyActivity.kt */
    private static final class ItemAddPhotoViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558901;
        private final ItemReplyPhotoAddBinding binding;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemAddPhotoViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            ItemReplyPhotoAddBinding itemReplyPhotoAddBinding = (ItemReplyPhotoAddBinding) getBinding();
            this.binding = itemReplyPhotoAddBinding;
            itemReplyPhotoAddBinding.iconView.setOnClickListener(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$ItemAddPhotoViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ReplyActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        protected final ItemReplyPhotoAddBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\"\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/ReplyActivity$MyDiffCallback;", "T", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", "", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "getNewListSize", "getOldListSize", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyActivity.kt */
    private static abstract class MyDiffCallback<T> extends DiffUtil.Callback {
        private final List<T> newData;
        private final List<T> oldData;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends T> */
        /* JADX WARN: Multi-variable type inference failed */
        public MyDiffCallback(List<? extends T> list, List<? extends T> list2) {
            Intrinsics.checkNotNullParameter(list, "oldData");
            Intrinsics.checkNotNullParameter(list2, "newData");
            this.oldData = list;
            this.newData = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldData.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newData.size();
        }
    }
}
