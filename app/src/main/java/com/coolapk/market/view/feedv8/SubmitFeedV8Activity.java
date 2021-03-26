package com.coolapk.market.view.feedv8;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.SubmitFeedAddMoreItemDialogBinding;
import com.coolapk.market.databinding.SubmitFeedAddVideoItemDialogBinding;
import com.coolapk.market.databinding.SubmitFeedBottomAddMoreV8Binding;
import com.coolapk.market.databinding.SubmitFeedV8Binding;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.OtherPostEvent;
import com.coolapk.market.extend.FeedMultiPartExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feedv8.draft.RoughDraft;
import com.coolapk.market.view.feedv8.draft.RoughDraftHelper;
import com.coolapk.market.widget.PrivacyAlertDialog;
import com.coolapk.market.widget.emotion.EmotionPanel;
import com.coolapk.market.widget.view.KeyBoardLayout;
import group.infotech.drawable.dsl.ViewStates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0002fgB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u0013H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00100\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u00020-H\u0002J\"\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u00020-H\u0016J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020\u001aH\u0016J\u0012\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u00020\u0011H\u0002J\b\u0010A\u001a\u00020-H\u0014J\u000e\u0010B\u001a\u00020-2\u0006\u00108\u001a\u00020CJ\b\u0010D\u001a\u00020-H\u0014J\u0006\u0010E\u001a\u00020-J\u0006\u0010F\u001a\u00020-J\u0006\u0010G\u001a\u00020-J\u0006\u0010H\u001a\u00020-J\u001c\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u0002062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130LJ\u0006\u0010M\u001a\u00020-J\u001c\u0010N\u001a\u00020-2\u0006\u00100\u001a\u00020\u00132\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130PJ\b\u0010Q\u001a\u00020-H\u0014J\u0010\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020?H\u0014J\b\u0010T\u001a\u00020-H\u0016J\b\u0010U\u001a\u00020-H\u0002J\b\u0010V\u001a\u00020-H\u0002J\b\u0010W\u001a\u00020-H\u0002J\u0012\u0010X\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010Y\u001a\u00020-H\u0002J\u0018\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u0013H\u0002J \u0010]\u001a\u00020-2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u00132\u0006\u0010^\u001a\u000206H\u0002J\u0010\u0010_\u001a\u00020-2\u0006\u0010`\u001a\u00020\u001aH\u0002J\b\u0010a\u001a\u00020-H\u0002J\u000e\u0010b\u001a\u00020-2\u0006\u0010c\u001a\u00020\"J\u000e\u0010d\u001a\u00020-2\u0006\u0010e\u001a\u00020(R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010 R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX.¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020(@BX.¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006h"}, d2 = {"Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "addMoreBinding", "Lcom/coolapk/market/databinding/SubmitFeedBottomAddMoreV8Binding;", "getAddMoreBinding", "()Lcom/coolapk/market/databinding/SubmitFeedBottomAddMoreV8Binding;", "addMoreBinding$delegate", "Lkotlin/Lazy;", "autoSaveTrigger", "Lrx/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "binding", "Lcom/coolapk/market/databinding/SubmitFeedV8Binding;", "contentHolder", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "draftId", "", "emotionPanel", "Lcom/coolapk/market/widget/emotion/EmotionPanel;", "getEmotionPanel", "()Lcom/coolapk/market/widget/emotion/EmotionPanel;", "emotionPanel$delegate", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "lastActiveMenu", "Landroid/widget/ImageView;", "lastSubmittableState", "Ljava/lang/Boolean;", "<set-?>", "Lcom/coolapk/market/model/FeedMultiPart;", "multiPart", "getMultiPart", "()Lcom/coolapk/market/model/FeedMultiPart;", "subscription", "Lrx/subscriptions/CompositeSubscription;", "Lcom/coolapk/market/model/FeedUIConfig;", "uiConfig", "getUiConfig", "()Lcom/coolapk/market/model/FeedUIConfig;", "closeKeyboardOrFakeKeyboard", "", "finishOrShowSaveDraftDialog", "loadShareInfo", "url", "loadVideoInfo", "makeKeyboardAndMenuInteractive", "notifyUIChange", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "v", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContentHolder", "onDestroy", "onFeedPosted", "Lcom/coolapk/market/model/Entity;", "onPause", "onRequestCheckSubmittable", "onRequestConvertToArticleMode", "onRequestPickApp", "onRequestPickContacts", "onRequestPickPhoto", "count", "currentList", "", "onRequestPickTopic", "onRequestWebViewUrl", "strings", "Ljava/util/ArrayList;", "onResume", "onSaveInstanceState", "outState", "recreate", "requestLoadProductPhoneTitleLogo", "saveDraftRightNow", "setupAutoSaveFunction", "setupInitValue", "setupInitView", "showAddVideoDialog", "title", "hint", "showShareDialog", "typeId", "switchBottomViewOrKeyboard", "view", "triggerAutoSave", "updateMultiPart", "part", "updateUIConfig", "config", "Companion", "SaveDialog", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SubmitFeedV8Activity.kt */
public final class SubmitFeedV8Activity extends FakeStatusBarActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_DRAFT_ID = "DRAFT_ID";
    public static final String EXTRA_MULTI_PART = "MULTI_PART";
    public static final String EXTRA_RESULT_FEED = "extra_result_feed";
    public static final String EXTRA_UI_CONFIG = "UI_CONFIG";
    public static final String KEY_CLICK_ADD_GOODS_BANDAGE_BEFORE = "click_add_goods_bandage_before";
    private final Lazy addMoreBinding$delegate = LazyKt.lazy(new SubmitFeedV8Activity$addMoreBinding$2(this));
    private final PublishSubject<Boolean> autoSaveTrigger = PublishSubject.create();
    private SubmitFeedV8Binding binding;
    private BaseFeedContentHolder contentHolder;
    private String draftId = "";
    private final Lazy emotionPanel$delegate = LazyKt.lazy(new SubmitFeedV8Activity$emotionPanel$2(this));
    private ImageView lastActiveMenu;
    private Boolean lastSubmittableState;
    private FeedMultiPart multiPart;
    private final CompositeSubscription subscription = new CompositeSubscription();
    private FeedUIConfig uiConfig;

    private final SubmitFeedBottomAddMoreV8Binding getAddMoreBinding() {
        return (SubmitFeedBottomAddMoreV8Binding) this.addMoreBinding$delegate.getValue();
    }

    private final EmotionPanel getEmotionPanel() {
        return (EmotionPanel) this.emotionPanel$delegate.getValue();
    }

    public static final /* synthetic */ SubmitFeedV8Binding access$getBinding$p(SubmitFeedV8Activity submitFeedV8Activity) {
        SubmitFeedV8Binding submitFeedV8Binding = submitFeedV8Activity.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return submitFeedV8Binding;
    }

    public static final /* synthetic */ BaseFeedContentHolder access$getContentHolder$p(SubmitFeedV8Activity submitFeedV8Activity) {
        BaseFeedContentHolder baseFeedContentHolder = submitFeedV8Activity.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        return baseFeedContentHolder;
    }

    public static final /* synthetic */ FeedUIConfig access$getUiConfig$p(SubmitFeedV8Activity submitFeedV8Activity) {
        FeedUIConfig feedUIConfig = submitFeedV8Activity.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        return feedUIConfig;
    }

    public final FeedUIConfig getUiConfig() {
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        return feedUIConfig;
    }

    public final FeedMultiPart getMultiPart() {
        FeedMultiPart feedMultiPart = this.multiPart;
        if (feedMultiPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
        }
        return feedMultiPart;
    }

    /* access modifiers changed from: private */
    public final View getFocusEditorView() {
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        return baseFeedContentHolder.getFocusEditorView();
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setInitSlidrDisable();
        setToolbarColorEqualContentColor(true);
        super.onCreate(bundle);
        setupInitValue(bundle);
        setupInitView();
        onRequestCheckSubmittable();
        setupAutoSaveFunction();
    }

    private final void setupInitValue(Bundle bundle) {
        T t = null;
        FeedUIConfig feedUIConfig = null;
        FeedMultiPart feedMultiPart = null;
        if (bundle != null) {
            feedUIConfig = (FeedUIConfig) bundle.getParcelable("UI_CONFIG");
            feedMultiPart = (FeedMultiPart) bundle.getParcelable("MULTI_PART");
            String string = bundle.getString("DRAFT_ID", this.draftId);
            Intrinsics.checkNotNullExpressionValue(string, "savedInstanceState.getSt…(EXTRA_DRAFT_ID, draftId)");
            this.draftId = string;
        }
        if (feedUIConfig == null && (feedUIConfig = (FeedUIConfig) getIntent().getParcelableExtra("UI_CONFIG")) == null) {
            throw new RuntimeException("FeedUIConfig required!!!");
        }
        FeedUIConfig feedUIConfig2 = feedUIConfig;
        if (feedMultiPart == null && (feedMultiPart = (FeedMultiPart) getIntent().getParcelableExtra("MULTI_PART")) == null) {
            throw new RuntimeException("FeedMultiPart required!!!");
        }
        FeedMultiPart feedMultiPart2 = feedMultiPart;
        boolean z = true;
        if (this.draftId.length() == 0) {
            String stringExtra = getIntent().getStringExtra("DRAFT_ID");
            if (stringExtra == null) {
                stringExtra = this.draftId;
            }
            this.draftId = stringExtra;
        }
        T t2 = null;
        if (this.draftId.length() > 0) {
            Iterator<T> it2 = RoughDraftHelper.Companion.getInstance().getRoughDraftList().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (Intrinsics.areEqual(next.getId(), this.draftId)) {
                    t = next;
                    break;
                }
            }
            t2 = t;
        }
        if (t2 == null) {
            t2 = RoughDraftHelper.Companion.getInstance().getSimilarDraft(feedMultiPart2, feedUIConfig2);
        }
        if (t2 != null) {
            feedMultiPart2 = t2.getMultiPart();
            feedUIConfig2 = t2.getUiConfig();
            this.draftId = t2.getId();
            RoughDraftHelper.Companion.getInstance().startEditingFromBox(t2);
        } else {
            this.draftId = RoughDraftHelper.Companion.getInstance().generateDraftID();
            RoughDraftHelper.Companion.getInstance().startEditing(RoughDraft.Companion.create(this.draftId, feedMultiPart2, feedUIConfig2, System.currentTimeMillis()));
        }
        this.uiConfig = feedUIConfig2;
        this.multiPart = feedMultiPart2;
        if (Intrinsics.areEqual(feedMultiPart2.targetType(), "product_phone") && Intrinsics.areEqual(feedMultiPart2.type(), "rating")) {
            String relativeLogo = feedUIConfig2.relativeLogo();
            if (!(relativeLogo == null || relativeLogo.length() == 0)) {
                String relativeTitle = feedUIConfig2.relativeTitle();
                if (!(relativeTitle == null || relativeTitle.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    return;
                }
            }
            requestLoadProductPhoneTitleLogo();
        }
    }

    private final void requestLoadProductPhoneTitleLogo() {
        FeedMultiPart feedMultiPart = this.multiPart;
        if (feedMultiPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
        }
        String targetId = feedMultiPart.targetId();
        FeedMultiPart feedMultiPart2 = this.multiPart;
        if (feedMultiPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
        }
        String targetType = feedMultiPart2.targetType();
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载数据...");
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        DataManager.getInstance().getTargetInfo(targetType, targetId).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new SubmitFeedV8Activity$requestLoadProductPhoneTitleLogo$1(this, progressDialog));
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0172  */
    private final void setupInitView() {
        boolean z;
        SubmitFeedV8Binding submitFeedV8Binding;
        BaseFeedContentHolder baseFeedContentHolder;
        SubmitFeedV8Binding submitFeedV8Binding2;
        SubmitFeedV8Binding submitFeedV8Binding3;
        FeedUIConfig feedUIConfig;
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559162, new ContextBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…xtBindingComponent(this))");
        SubmitFeedV8Binding submitFeedV8Binding4 = (SubmitFeedV8Binding) contentView;
        this.binding = submitFeedV8Binding4;
        if (submitFeedV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FeedUIConfig feedUIConfig2 = this.uiConfig;
        if (feedUIConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        submitFeedV8Binding4.setUiConfig(feedUIConfig2);
        SubmitFeedV8Binding submitFeedV8Binding5 = this.binding;
        if (submitFeedV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedV8Binding5.setClick(this);
        SubmitFeedV8Binding submitFeedV8Binding6 = this.binding;
        if (submitFeedV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = submitFeedV8Binding6.keyBoardInteractLayout;
        SubmitFeedV8Binding submitFeedV8Binding7 = this.binding;
        if (submitFeedV8Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        keyBoardLayout.setKeyBoardView(submitFeedV8Binding7.fakeKeyboardView);
        SubmitFeedV8Binding submitFeedV8Binding8 = this.binding;
        if (submitFeedV8Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedV8Binding8.executePendingBindings();
        SubmitFeedV8Binding submitFeedV8Binding9 = this.binding;
        if (submitFeedV8Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitFeedV8Binding9.toArticleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.toArticleView");
        TextView textView2 = textView;
        FeedMultiPart feedMultiPart = this.multiPart;
        if (feedMultiPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
        }
        int i = 0;
        if (Intrinsics.areEqual(feedMultiPart.type(), "rating")) {
            FeedUIConfig feedUIConfig3 = this.uiConfig;
            if (feedUIConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            if (!feedUIConfig3.isShowInArticleMode()) {
                z = true;
                textView2.setVisibility(!z ? 0 : 8);
                this.contentHolder = onCreateContentHolder();
                submitFeedV8Binding = this.binding;
                if (submitFeedV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FrameLayout frameLayout = submitFeedV8Binding.contentView;
                baseFeedContentHolder = this.contentHolder;
                if (baseFeedContentHolder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                frameLayout.addView(baseFeedContentHolder.getContentView(), -1, -1);
                submitFeedV8Binding2 = this.binding;
                if (submitFeedV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                TextView textView3 = submitFeedV8Binding2.submitView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.submitView");
                StateListDrawable stateListDrawable = new StateListDrawable();
                int[] enabled = ViewStates.INSTANCE.enabled();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
                gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
                stateListDrawable.addState(enabled, gradientDrawable);
                int[] disabled = ViewStates.INSTANCE.disabled();
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setGradientType(0);
                gradientDrawable2.setStroke(NumberExtendsKt.getDp((Number) 1), AppHolder.getAppTheme().getTextColorTertiary());
                gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
                stateListDrawable.addState(disabled, gradientDrawable2);
                Unit unit = Unit.INSTANCE;
                textView3.setBackground(stateListDrawable);
                submitFeedV8Binding3 = this.binding;
                if (submitFeedV8Binding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                View view = submitFeedV8Binding3.menuAddGoodsBandageView;
                Intrinsics.checkNotNullExpressionValue(view, "binding.menuAddGoodsBandageView");
                if (DataManager.getInstance().getPreferencesBoolean("click_add_goods_bandage_before", false)) {
                    i = 8;
                }
                view.setVisibility(i);
                onRequestCheckSubmittable();
                makeKeyboardAndMenuInteractive();
                feedUIConfig = this.uiConfig;
                if (feedUIConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                }
                if (feedUIConfig.openKeyboardWhenInit()) {
                    SubmitFeedV8Binding submitFeedV8Binding10 = this.binding;
                    if (submitFeedV8Binding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    submitFeedV8Binding10.getRoot().postDelayed(new SubmitFeedV8Activity$setupInitView$2(this), 100);
                }
                AppMetadataKt.runOnAppMode$default(this, null, new SubmitFeedV8Activity$setupInitView$3(this), null, SubmitFeedV8Activity$setupInitView$4.INSTANCE, 5, null);
            }
        }
        z = false;
        textView2.setVisibility(!z ? 0 : 8);
        this.contentHolder = onCreateContentHolder();
        submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
        }
        FrameLayout frameLayout = submitFeedV8Binding.contentView;
        baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
        }
        frameLayout.addView(baseFeedContentHolder.getContentView(), -1, -1);
        submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
        }
        TextView textView3 = submitFeedV8Binding2.submitView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.submitView");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] enabled = ViewStates.INSTANCE.enabled();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColor(AppHolder.getAppTheme().getColorAccent());
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
        stateListDrawable.addState(enabled, gradientDrawable);
        int[] disabled = ViewStates.INSTANCE.disabled();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setStroke(NumberExtendsKt.getDp((Number) 1), AppHolder.getAppTheme().getTextColorTertiary());
        gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
        stateListDrawable.addState(disabled, gradientDrawable2);
        Unit unit = Unit.INSTANCE;
        textView3.setBackground(stateListDrawable);
        submitFeedV8Binding3 = this.binding;
        if (submitFeedV8Binding3 == null) {
        }
        View view = submitFeedV8Binding3.menuAddGoodsBandageView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.menuAddGoodsBandageView");
        if (DataManager.getInstance().getPreferencesBoolean("click_add_goods_bandage_before", false)) {
        }
        view.setVisibility(i);
        onRequestCheckSubmittable();
        makeKeyboardAndMenuInteractive();
        feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
        }
        if (feedUIConfig.openKeyboardWhenInit()) {
        }
        AppMetadataKt.runOnAppMode$default(this, null, new SubmitFeedV8Activity$setupInitView$3(this), null, SubmitFeedV8Activity$setupInitView$4.INSTANCE, 5, null);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        bundle.putParcelable("MULTI_PART", baseFeedContentHolder.generateDraftCopy$presentation_coolapkAppRelease());
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        bundle.putParcelable("UI_CONFIG", feedUIConfig);
        bundle.putString("DRAFT_ID", this.draftId);
    }

    private final void setupAutoSaveFunction() {
        this.subscription.add(this.autoSaveTrigger.asObservable().throttleWithTimeout(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new SubmitFeedV8Activity$setupAutoSaveFunction$sub$1(this)));
    }

    /* access modifiers changed from: private */
    public final void saveDraftRightNow() {
        RoughDraftHelper instance = RoughDraftHelper.Companion.getInstance();
        RoughDraft.Companion companion = RoughDraft.Companion;
        String str = this.draftId;
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease = baseFeedContentHolder.generateDraftCopy$presentation_coolapkAppRelease();
        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
        if (baseFeedContentHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        instance.setEditing(companion.create(str, generateDraftCopy$presentation_coolapkAppRelease, baseFeedContentHolder2.getUiConfig(), System.currentTimeMillis()));
    }

    private final void makeKeyboardAndMenuInteractive() {
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = submitFeedV8Binding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        this.subscription.add(keyBoardLayout.getKeyboardObservable().subscribe(new SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s1$1(this)));
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = submitFeedV8Binding2.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        this.subscription.add(keyBoardLayout2.getFakeKeyboardObservable().subscribe(new SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s2$1(this)));
        SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
        if (submitFeedV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout3 = submitFeedV8Binding3.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout3, "binding.keyBoardInteractLayout");
        PublishSubject<Boolean> fakeKeyboardObservable = keyBoardLayout3.getFakeKeyboardObservable();
        SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
        if (submitFeedV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout4 = submitFeedV8Binding4.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout4, "binding.keyBoardInteractLayout");
        this.subscription.add(Observable.combineLatest(fakeKeyboardObservable, keyBoardLayout4.getKeyboardObservable(), SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s3$1.INSTANCE).subscribe((Subscriber) new SubmitFeedV8Activity$makeKeyboardAndMenuInteractive$s3$2(this)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r0.equals("comment") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bb, code lost:
        if (r0.equals("feed") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        if (r0.equals("url") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e8, code lost:
        if (r0.equals("discovery") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0121, code lost:
        if (r0.equals("question") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0143, code lost:
        if (r0.equals("answer") != false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        r1 = getActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "activity");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0155, code lost:
        return new com.coolapk.market.view.feedv8.NormalFeedContentHolder(r1);
     */
    private final BaseFeedContentHolder onCreateContentHolder() {
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        if (feedUIConfig.isShowInArticleMode()) {
            FeedMultiPart feedMultiPart = this.multiPart;
            if (feedMultiPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiPart");
            }
            if (Intrinsics.areEqual(feedMultiPart.type(), "rating")) {
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                return new ArticleRatingContentHolder(activity);
            }
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            return new ArticleFeedContentHolder2(activity2);
        }
        FeedMultiPart feedMultiPart2 = this.multiPart;
        if (feedMultiPart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
        }
        String type = feedMultiPart2.type();
        if (type != null) {
            switch (type.hashCode()) {
                case -1412808770:
                    break;
                case -1294612184:
                    if (type.equals("ershou")) {
                        BaseActivity activity3 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity3, "activity");
                        return new SecondHandContentHolder(activity3);
                    }
                    break;
                case -1165870106:
                    break;
                case -938102371:
                    if (type.equals("rating")) {
                        BaseActivity activity4 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity4, "activity");
                        return new RatingContentHolderVX1(activity4);
                    }
                    break;
                case -577741570:
                    if (type.equals("picture")) {
                        BaseActivity activity5 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity5, "activity");
                        return new CoolPicContentHolder(activity5);
                    }
                    break;
                case -121207376:
                    break;
                case 99955:
                    if (type.equals("dyh")) {
                        BaseActivity activity6 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity6, "activity");
                        return new DyhContentHolder(activity6);
                    }
                    break;
                case 116079:
                    break;
                case 3138974:
                    break;
                case 3625706:
                    if (type.equals("vote")) {
                        BaseActivity activity7 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity7, "activity");
                        return new VoteContentHolder(activity7);
                    }
                    break;
                case 98539350:
                    if (type.equals("goods")) {
                        BaseActivity activity8 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity8, "activity");
                        return new GoodsContentHolder(activity8);
                    }
                    break;
                case 950398559:
                    break;
                case 1408890901:
                    if (type.equals("voteComment")) {
                        BaseActivity activity9 = getActivity();
                        Intrinsics.checkNotNullExpressionValue(activity9, "activity");
                        return new VoteCommentContentHolder(activity9);
                    }
                    break;
            }
        }
        BaseActivity activity10 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity10, "activity");
        return new NormalFeedContentHolder(activity10);
    }

    private final void notifyUIChange() {
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        submitFeedV8Binding.setUiConfig(feedUIConfig);
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedV8Binding2.executePendingBindings();
    }

    public final void updateMultiPart(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "part");
        this.multiPart = feedMultiPart;
    }

    private final void switchBottomViewOrKeyboard(View view) {
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = submitFeedV8Binding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        if (keyBoardLayout.isRealKeyboard()) {
            UiUtils.closeKeyboard(getFocusEditorView());
            SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
            if (submitFeedV8Binding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding2.fakeKeyboardExtraContainer.removeAllViews();
            SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
            if (submitFeedV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding3.fakeKeyboardExtraContainer.addView(view);
            SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
            if (submitFeedV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding4.keyBoardInteractLayout.showFakeKeyBoardView(true);
            return;
        }
        SubmitFeedV8Binding submitFeedV8Binding5 = this.binding;
        if (submitFeedV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        if (submitFeedV8Binding5.fakeKeyboardExtraContainer.getChildAt(0) != view) {
            SubmitFeedV8Binding submitFeedV8Binding6 = this.binding;
            if (submitFeedV8Binding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding6.fakeKeyboardExtraContainer.removeAllViews();
            SubmitFeedV8Binding submitFeedV8Binding7 = this.binding;
            if (submitFeedV8Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding7.fakeKeyboardExtraContainer.addView(view);
            SubmitFeedV8Binding submitFeedV8Binding8 = this.binding;
            if (submitFeedV8Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding8.keyBoardInteractLayout.showFakeKeyBoardView(true);
            return;
        }
        SubmitFeedV8Binding submitFeedV8Binding9 = this.binding;
        if (submitFeedV8Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = submitFeedV8Binding9.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        if (!keyBoardLayout2.isFakeKeyBoardShowed()) {
            SubmitFeedV8Binding submitFeedV8Binding10 = this.binding;
            if (submitFeedV8Binding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding10.keyBoardInteractLayout.showFakeKeyBoardView(true);
            SubmitFeedV8Binding submitFeedV8Binding11 = this.binding;
            if (submitFeedV8Binding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding11.keyBoardInteractLayout.requestLayout();
            return;
        }
        UiUtils.openKeyboard(getFocusEditorView());
    }

    public final void onRequestPickContacts() {
        ActionManager.startPickUserActivity(this, 8655, 5, getString(2131886950));
    }

    public final void onRequestPickPhoto(int i, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "currentList");
        ActionManager.startPhotoPickerActivity(getActivity(), i, list);
        UiUtils.closeKeyboard(getFocusEditorView());
    }

    public final void onRequestPickTopic() {
        ActionManager.startPickTopicActivity(this, 6666);
    }

    public final void onRequestPickApp() {
        ActionManager.startPickAppActivity(getActivity(), 1561);
    }

    public final void onRequestConvertToArticleMode() {
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
        }
        FeedUIConfig build = FeedUIConfig.builder(feedUIConfig).isShowInArticleMode(true).submitToText("").isSubmitToViewVisible(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…iewVisible(false).build()");
        this.uiConfig = build;
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        this.multiPart = baseFeedContentHolder.generateDraftCopy$presentation_coolapkAppRelease();
        notifyUIChange();
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = submitFeedV8Binding.toArticleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.toArticleView");
        textView.setVisibility(8);
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = submitFeedV8Binding2.contentView;
        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
        if (baseFeedContentHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        frameLayout.removeView(baseFeedContentHolder2.getContentView());
        this.contentHolder = onCreateContentHolder();
        SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
        if (submitFeedV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout2 = submitFeedV8Binding3.contentView;
        BaseFeedContentHolder baseFeedContentHolder3 = this.contentHolder;
        if (baseFeedContentHolder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        frameLayout2.addView(baseFeedContentHolder3.getContentView(), new ViewGroup.LayoutParams(-1, -1));
    }

    public final void onRequestWebViewUrl(String str, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(arrayList, "strings");
        ActionManager.startShareWebviewActivity(getActivity(), str, arrayList);
    }

    private final void triggerAutoSave() {
        this.autoSaveTrigger.onNext(true);
    }

    public final void onRequestCheckSubmittable() {
        if (this.contentHolder != null) {
            triggerAutoSave();
            BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
            if (baseFeedContentHolder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
            }
            boolean checkSubmittable$presentation_coolapkAppRelease = baseFeedContentHolder.checkSubmittable$presentation_coolapkAppRelease();
            if (!Intrinsics.areEqual(Boolean.valueOf(checkSubmittable$presentation_coolapkAppRelease), this.lastSubmittableState)) {
                if (checkSubmittable$presentation_coolapkAppRelease) {
                    SubmitFeedV8Binding submitFeedV8Binding = this.binding;
                    if (submitFeedV8Binding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    submitFeedV8Binding.submitView.setTextColor(ResourceUtils.getColorInt(getActivity(), 2131099912));
                    SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
                    if (submitFeedV8Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView = submitFeedV8Binding2.submitView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.submitView");
                    textView.setEnabled(true);
                    SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
                    if (submitFeedV8Binding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView2 = submitFeedV8Binding3.submitView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.submitView");
                    textView2.setClickable(true);
                    FeedUIConfig feedUIConfig = this.uiConfig;
                    if (feedUIConfig == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                    }
                    if (feedUIConfig.isPreviewable()) {
                        SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
                        if (submitFeedV8Binding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView3 = submitFeedV8Binding4.previewView;
                        Intrinsics.checkNotNullExpressionValue(textView3, "binding.previewView");
                        textView3.setVisibility(0);
                        SubmitFeedV8Binding submitFeedV8Binding5 = this.binding;
                        if (submitFeedV8Binding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        submitFeedV8Binding5.previewView.setTextColor(AppHolder.getAppTheme().getColorAccent());
                    }
                } else {
                    int resolveData = ResourceUtils.resolveData(getActivity(), 16843282);
                    SubmitFeedV8Binding submitFeedV8Binding6 = this.binding;
                    if (submitFeedV8Binding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    submitFeedV8Binding6.submitView.setTextColor(resolveData);
                    SubmitFeedV8Binding submitFeedV8Binding7 = this.binding;
                    if (submitFeedV8Binding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView4 = submitFeedV8Binding7.submitView;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.submitView");
                    textView4.setEnabled(false);
                    SubmitFeedV8Binding submitFeedV8Binding8 = this.binding;
                    if (submitFeedV8Binding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    TextView textView5 = submitFeedV8Binding8.submitView;
                    Intrinsics.checkNotNullExpressionValue(textView5, "binding.submitView");
                    textView5.setClickable(false);
                    FeedUIConfig feedUIConfig2 = this.uiConfig;
                    if (feedUIConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                    }
                    if (feedUIConfig2.isPreviewable()) {
                        SubmitFeedV8Binding submitFeedV8Binding9 = this.binding;
                        if (submitFeedV8Binding9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView6 = submitFeedV8Binding9.previewView;
                        Intrinsics.checkNotNullExpressionValue(textView6, "binding.previewView");
                        textView6.setVisibility(8);
                    }
                }
                this.lastSubmittableState = Boolean.valueOf(checkSubmittable$presentation_coolapkAppRelease);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0104, code lost:
        if (r5.isShowAddGoodsInMenuBar() != false) goto L_0x010b;
     */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362180:
            case 2131362927:
                onRequestPickApp();
                return;
            case 2131362181:
                showShareDialog("添加网页链接", "添加网页链接", 2131362181);
                return;
            case 2131362182:
                showShareDialog("添加音乐链接", "支持网易云音乐、QQ音乐网址解析", 2131362182);
                return;
            case 2131362183:
                showAddVideoDialog("添加视频链接", "支持秒拍、微博、哔哩哔哩视频网站解析");
                return;
            case 2131362257:
                finishOrShowSaveDraftDialog();
                return;
            case 2131362914:
                ActionManager.startGoodsSearchActivity(this, 349);
                SubmitFeedV8Binding submitFeedV8Binding = this.binding;
                if (submitFeedV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                View view2 = submitFeedV8Binding.menuAddGoodsBandageView;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.menuAddGoodsBandageView");
                view2.setVisibility(8);
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                instance.getPreferencesEditor().putBoolean("click_add_goods_bandage_before", true).apply();
                return;
            case 2131362916:
                FeedUIConfig feedUIConfig = this.uiConfig;
                if (feedUIConfig == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                }
                if (!feedUIConfig.canAddMusic()) {
                    FeedUIConfig feedUIConfig2 = this.uiConfig;
                    if (feedUIConfig2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                    }
                    if (!feedUIConfig2.canAddVideo()) {
                        FeedUIConfig feedUIConfig3 = this.uiConfig;
                        if (feedUIConfig3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                        }
                        if (feedUIConfig3.isShareAppItemVisible()) {
                            FeedUIConfig feedUIConfig4 = this.uiConfig;
                            if (feedUIConfig4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                            }
                            break;
                        }
                        showShareDialog("添加网页链接", "添加网页链接", 2131362181);
                        return;
                    }
                }
                View root = getAddMoreBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "addMoreBinding.root");
                switchBottomViewOrKeyboard(root);
                SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
                if (submitFeedV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                this.lastActiveMenu = submitFeedV8Binding2.menuAddMore;
                return;
            case 2131362917:
                BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
                if (baseFeedContentHolder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder.onRequestPickImage();
                return;
            case 2131362918:
                onRequestPickContacts();
                return;
            case 2131362921:
                SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
                if (submitFeedV8Binding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout = submitFeedV8Binding3.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
                if (keyBoardLayout.isRealKeyboard()) {
                    UiUtils.closeKeyboard(getFocusEditorView());
                    return;
                }
                SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
                if (submitFeedV8Binding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout2 = submitFeedV8Binding4.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
                if (keyBoardLayout2.isFakeKeyBoardShowed()) {
                    SubmitFeedV8Binding submitFeedV8Binding5 = this.binding;
                    if (submitFeedV8Binding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    submitFeedV8Binding5.keyBoardInteractLayout.showFakeKeyBoardView(false);
                    SubmitFeedV8Binding submitFeedV8Binding6 = this.binding;
                    if (submitFeedV8Binding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    submitFeedV8Binding6.keyBoardInteractLayout.requestLayout();
                    return;
                }
                UiUtils.openKeyboard(getFocusEditorView());
                return;
            case 2131362923:
                switchBottomViewOrKeyboard(getEmotionPanel());
                SubmitFeedV8Binding submitFeedV8Binding7 = this.binding;
                if (submitFeedV8Binding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                this.lastActiveMenu = submitFeedV8Binding7.menuEmotion;
                return;
            case 2131362928:
                onRequestPickTopic();
                return;
            case 2131363140:
                BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
                if (baseFeedContentHolder2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder2.onPreviewClicked();
                return;
            case 2131363457:
                if (PrivacyAlertDialog.Companion.shouldShowByIntent()) {
                    PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
                    FragmentManager supportFragmentManager = getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                }
                BaseFeedContentHolder baseFeedContentHolder3 = this.contentHolder;
                if (baseFeedContentHolder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder3.onSubmitButtonClick();
                return;
            case 2131363583:
                onRequestConvertToArticleMode();
                return;
            default:
                return;
        }
    }

    public final void onFeedPosted(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        if (entity instanceof Feed) {
            EventBus eventBus = EventBus.getDefault();
            Feed feed = (Feed) entity;
            FeedMultiPart feedMultiPart = this.multiPart;
            if (feedMultiPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiPart");
            }
            FeedUIConfig feedUIConfig = this.uiConfig;
            if (feedUIConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            eventBus.post(new FeedPostEvent(feed, feedMultiPart, feedUIConfig));
            getActivity().setResult(-1, new Intent().putExtra("extra_result_feed", entity));
        } else {
            EventBus eventBus2 = EventBus.getDefault();
            FeedMultiPart feedMultiPart2 = this.multiPart;
            if (feedMultiPart2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiPart");
            }
            FeedUIConfig feedUIConfig2 = this.uiConfig;
            if (feedUIConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
            }
            eventBus2.post(new OtherPostEvent(entity, feedMultiPart2, feedUIConfig2));
        }
        RoughDraftHelper.Companion.getInstance().setEditingDraftSaveToDisk(false, true);
        getActivity().finish();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (!isFinishing()) {
            BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
            if (baseFeedContentHolder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
            }
            if (!baseFeedContentHolder.isPosting()) {
                saveDraftRightNow();
            }
        }
        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
        if (baseFeedContentHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        baseFeedContentHolder2.onPause();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = submitFeedV8Binding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        if (keyBoardLayout.isRealKeyboard()) {
            UiUtils.closeKeyboard(getFocusEditorView());
            return;
        }
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = submitFeedV8Binding2.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        if (keyBoardLayout2.isFakeKeyBoardShowed()) {
            SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
            if (submitFeedV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding3.fakeKeyboardExtraContainer.removeAllViews();
            SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
            if (submitFeedV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding4.keyBoardInteractLayout.showFakeKeyBoardView(false);
            return;
        }
        finishOrShowSaveDraftDialog();
    }

    public final void updateUIConfig(FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feedUIConfig, "config");
        this.uiConfig = feedUIConfig;
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedV8Binding.setUiConfig(feedUIConfig);
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        baseFeedContentHolder.notifyUIChange$presentation_coolapkAppRelease();
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        submitFeedV8Binding2.executePendingBindings();
    }

    /* access modifiers changed from: private */
    public final void closeKeyboardOrFakeKeyboard() {
        SubmitFeedV8Binding submitFeedV8Binding = this.binding;
        if (submitFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = submitFeedV8Binding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        if (keyBoardLayout.isRealKeyboard()) {
            UiUtils.closeKeyboard(getFocusEditorView());
            return;
        }
        SubmitFeedV8Binding submitFeedV8Binding2 = this.binding;
        if (submitFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = submitFeedV8Binding2.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        if (keyBoardLayout2.isFakeKeyBoardShowed()) {
            SubmitFeedV8Binding submitFeedV8Binding3 = this.binding;
            if (submitFeedV8Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding3.keyBoardInteractLayout.showFakeKeyBoardView(false);
            SubmitFeedV8Binding submitFeedV8Binding4 = this.binding;
            if (submitFeedV8Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            submitFeedV8Binding4.keyBoardInteractLayout.requestLayout();
        }
    }

    private final void finishOrShowSaveDraftDialog() {
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease = baseFeedContentHolder.generateDraftCopy$presentation_coolapkAppRelease();
        if (!FeedMultiPartExtendsKt.hasUserInputContent(generateDraftCopy$presentation_coolapkAppRelease)) {
            finish();
            RoughDraftHelper.Companion.getInstance().setEditingDraftSaveToDisk(false, false);
            return;
        }
        RoughDraftHelper instance = RoughDraftHelper.Companion.getInstance();
        RoughDraft.Companion companion = RoughDraft.Companion;
        String str = this.draftId;
        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
        if (baseFeedContentHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        instance.setEditing(companion.create(str, generateDraftCopy$presentation_coolapkAppRelease, baseFeedContentHolder2.getUiConfig(), System.currentTimeMillis()));
        SaveDialog saveDialog = new SaveDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        saveDialog.show(supportFragmentManager, (String) null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity$SaveDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SubmitFeedV8Activity.kt */
    public static final class SaveDialog extends BaseDialogFragment {
        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog create = new AlertDialog.Builder(requireActivity()).setMessage("是否保存到草稿箱？").setNeutralButton("继续编辑", SubmitFeedV8Activity$SaveDialog$onCreateDialog$1.INSTANCE).setPositiveButton("保存", new SubmitFeedV8Activity$SaveDialog$onCreateDialog$2(this)).setNegativeButton("放弃", new SubmitFeedV8Activity$SaveDialog$onCreateDialog$3(this)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…               }.create()");
            return create;
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        saveDraftRightNow();
        super.recreate();
    }

    private final void showShareDialog(String str, String str2, int i) {
        SubmitFeedAddMoreItemDialogBinding submitFeedAddMoreItemDialogBinding = (SubmitFeedAddMoreItemDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559147, null, false);
        AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setTitle(str);
        Intrinsics.checkNotNullExpressionValue(submitFeedAddMoreItemDialogBinding, "binding");
        AlertDialog create = title.setView(submitFeedAddMoreItemDialogBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        UserPermissionChecker userPermissionChecker = UserPermissionChecker.INSTANCE;
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String extraUrl = StringUtils.getExtraUrl(getActivity(), userPermissionChecker.getClipBoardText(activity).toString());
        if (!TextUtils.isEmpty(extraUrl)) {
            submitFeedAddMoreItemDialogBinding.editText.setText(extraUrl);
        } else {
            Window window = create.getWindow();
            Intrinsics.checkNotNull(window);
            window.setSoftInputMode(5);
            submitFeedAddMoreItemDialogBinding.editText.postDelayed(new SubmitFeedV8Activity$showShareDialog$1(submitFeedAddMoreItemDialogBinding), 100);
        }
        EditText editText = submitFeedAddMoreItemDialogBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint(str2);
        ViewUtil.clickListener(submitFeedAddMoreItemDialogBinding.cancelButton, new SubmitFeedV8Activity$showShareDialog$2(create));
        ViewUtil.clickListener(submitFeedAddMoreItemDialogBinding.okButton, new SubmitFeedV8Activity$showShareDialog$3(this, create, submitFeedAddMoreItemDialogBinding, i));
    }

    private final void showAddVideoDialog(String str, String str2) {
        SubmitFeedAddVideoItemDialogBinding submitFeedAddVideoItemDialogBinding = (SubmitFeedAddVideoItemDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559148, null, false);
        AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setTitle(str);
        Intrinsics.checkNotNullExpressionValue(submitFeedAddVideoItemDialogBinding, "binding");
        AlertDialog create = title.setView(submitFeedAddVideoItemDialogBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        UserPermissionChecker userPermissionChecker = UserPermissionChecker.INSTANCE;
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String extraUrl = StringUtils.getExtraUrl(getActivity(), userPermissionChecker.getClipBoardText(activity).toString());
        if (!TextUtils.isEmpty(extraUrl)) {
            submitFeedAddVideoItemDialogBinding.editText.setText(extraUrl);
        } else {
            Window window = create.getWindow();
            Intrinsics.checkNotNull(window);
            window.setSoftInputMode(5);
        }
        TextView textView = submitFeedAddVideoItemDialogBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(str2);
        ViewUtil.clickListener(submitFeedAddVideoItemDialogBinding.cancelButton, new SubmitFeedV8Activity$showAddVideoDialog$1(create));
        ViewUtil.clickListener(submitFeedAddVideoItemDialogBinding.okButton, new SubmitFeedV8Activity$showAddVideoDialog$2(this, create, submitFeedAddVideoItemDialogBinding));
    }

    /* access modifiers changed from: private */
    public final void loadShareInfo(String str) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(2131886866));
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        this.subscription.add(DataManager.getInstance().loadShareUrlV11(str).subscribeOn(Schedulers.io()).flatMap(new SubmitFeedV8Activity$loadShareInfo$subscription$1(str)).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new SubmitFeedV8Activity$loadShareInfo$subscription$2(this)).doOnTerminate(new SubmitFeedV8Activity$loadShareInfo$subscription$3(this)).subscribe((Subscriber<? super R>) new SubmitFeedV8Activity$loadShareInfo$subscription$4(this, progressDialog)));
    }

    /* access modifiers changed from: private */
    public final void loadVideoInfo(String str) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(2131886866));
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        this.subscription.add(DataManager.getInstance().getUrlVideoInfo(str).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new SubmitFeedV8Activity$loadVideoInfo$subscription$1(this, progressDialog, str)));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.subscription.unsubscribe();
        BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
        if (baseFeedContentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
        }
        baseFeedContentHolder.onDestroy();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 341) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                if (stringArrayListExtra != null && CollectionUtils.isNotEmpty(stringArrayListExtra)) {
                    BaseFeedContentHolder baseFeedContentHolder = this.contentHolder;
                    if (baseFeedContentHolder == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                    }
                    baseFeedContentHolder.onPickImageListChange(stringArrayListExtra);
                }
                FeedMultiPart feedMultiPart = this.multiPart;
                if (feedMultiPart == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiPart");
                }
                if (!UriUtils.isCoolApkHost(feedMultiPart.extraUrl())) {
                    String stringExtra = intent.getStringExtra("PICKED_TITLE");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        FeedUIConfig feedUIConfig = this.uiConfig;
                        if (feedUIConfig == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("uiConfig");
                        }
                        FeedUIConfig build = FeedUIConfig.builder(feedUIConfig).extraViewTitle(stringExtra).build();
                        Intrinsics.checkNotNullExpressionValue(build, "FeedUIConfig.builder(uiC…                 .build()");
                        this.uiConfig = build;
                        FeedMultiPart feedMultiPart2 = this.multiPart;
                        if (feedMultiPart2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("multiPart");
                        }
                        FeedMultiPart build2 = FeedMultiPart.builder(feedMultiPart2).extraTitle(stringExtra).build();
                        Intrinsics.checkNotNullExpressionValue(build2, "FeedMultiPart.builder(mu…extraTitle(title).build()");
                        this.multiPart = build2;
                        notifyUIChange();
                        BaseFeedContentHolder baseFeedContentHolder2 = this.contentHolder;
                        if (baseFeedContentHolder2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                        }
                        baseFeedContentHolder2.notifyUIChange$presentation_coolapkAppRelease();
                    }
                }
            } else if (i == 349) {
                Parcelable parcelableExtra = intent.getParcelableExtra("FEED_GOODS");
                Intrinsics.checkNotNull(parcelableExtra);
                Intrinsics.checkNotNullExpressionValue(parcelableExtra, "data.getParcelableExtra<…vity.RESULT_FEED_GOODS)!!");
                FeedGoods feedGoods = (FeedGoods) parcelableExtra;
                BaseFeedContentHolder baseFeedContentHolder3 = this.contentHolder;
                if (baseFeedContentHolder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder3.onExtraEntityLoaded(feedGoods);
            } else if (i == 1561) {
                BaseFeedContentHolder baseFeedContentHolder4 = this.contentHolder;
                if (baseFeedContentHolder4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder4.onPickAppIntent(intent);
            } else if (i == 3925) {
                ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                if (stringArrayListExtra2 != null) {
                    BaseFeedContentHolder baseFeedContentHolder5 = this.contentHolder;
                    if (baseFeedContentHolder5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                    }
                    baseFeedContentHolder5.onPickImageListChange(stringArrayListExtra2);
                }
            } else if (i == 6666) {
                BaseFeedContentHolder baseFeedContentHolder6 = this.contentHolder;
                if (baseFeedContentHolder6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder6.onPickTopicIntent(intent);
            } else if (i != 8655) {
                BaseFeedContentHolder baseFeedContentHolder7 = this.contentHolder;
                if (baseFeedContentHolder7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder7.onActivityResult(i, i2, intent);
            } else {
                BaseFeedContentHolder baseFeedContentHolder8 = this.contentHolder;
                if (baseFeedContentHolder8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentHolder");
                }
                baseFeedContentHolder8.onPickAtIntent(intent);
            }
        }
        getFocusEditorView().clearFocus();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/SubmitFeedV8Activity$Companion;", "", "()V", "EXTRA_DRAFT_ID", "", "EXTRA_MULTI_PART", "EXTRA_RESULT_FEED", "EXTRA_UI_CONFIG", "KEY_CLICK_ADD_GOODS_BANDAGE_BEFORE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SubmitFeedV8Activity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
