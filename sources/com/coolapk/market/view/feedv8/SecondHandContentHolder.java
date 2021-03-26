package com.coolapk.market.view.feedv8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.SecondHandContentV8Binding;
import com.coolapk.market.databinding.SubmitFeedExtraLogoBinding;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.emotion.BaseEmotion;
import com.hjq.permissions.XXPermissions;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020'H\u0002J\r\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\b*J\r\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u000200H\u0002J\r\u00101\u001a\u00020'H\u0010¢\u0006\u0002\b2J \u00103\u001a\u00020'2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u001dH\u0016J\u0015\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\b>J\b\u0010?\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0016J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020'H\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010F\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0016J\u0016\u0010G\u001a\u00020'2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020J0IH\u0016J\u0010\u0010K\u001a\u00020'2\u0006\u00107\u001a\u000208H\u0016J\b\u0010L\u001a\u00020'H\u0016J\b\u0010M\u001a\u00020'H\u0016J\b\u0010N\u001a\u00020'H\u0016J\u0013\u0010O\u001a\b\u0012\u0004\u0012\u00020,0PH\u0010¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020'H\u0002J\b\u0010S\u001a\u00020'H\u0002J\b\u0010T\u001a\u00020'H\u0002J\u000e\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020,J\u000e\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020YR\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/coolapk/market/view/feedv8/SecondHandContentHolder;", "Lcom/coolapk/market/view/feedv8/BaseFeedContentHolder;", "Landroid/view/View$OnClickListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "adapter", "Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "getAdapter$presentation_coolapkAppRelease", "()Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;", "setAdapter$presentation_coolapkAppRelease", "(Lcom/coolapk/market/view/feedv8/PickPhotoAdapterV8;)V", "binding", "Lcom/coolapk/market/databinding/SecondHandContentV8Binding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/SecondHandContentV8Binding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/SecondHandContentV8Binding;)V", "extraView", "Lcom/coolapk/market/view/feedv8/SubmitSecondHandExtraViewPart;", "getExtraView", "()Lcom/coolapk/market/view/feedv8/SubmitSecondHandExtraViewPart;", "extraView$delegate", "Lkotlin/Lazy;", "focusEditText", "Landroid/widget/EditText;", "getFocusEditText", "()Landroid/widget/EditText;", "focusEditorView", "Landroid/view/View;", "getFocusEditorView", "()Landroid/view/View;", "locationClientSingle", "Lcom/amap/api/location/AMapLocationClient;", "locationSingleListener", "Lcom/amap/api/location/AMapLocationListener;", "pickGoodsBinding", "Lcom/coolapk/market/databinding/SubmitFeedExtraLogoBinding;", "checkAgree", "", "checkSubmittable", "", "checkSubmittable$presentation_coolapkAppRelease", "generateDraftCopy", "Lcom/coolapk/market/model/FeedMultiPart;", "generateDraftCopy$presentation_coolapkAppRelease", "newSmallDividerView", "context", "Landroid/content/Context;", "notifyUIChange", "notifyUIChange$presentation_coolapkAppRelease", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "onCreateContentView", "inflater", "Landroid/view/LayoutInflater;", "onCreateContentView$presentation_coolapkAppRelease", "onDeleteButtonClick", "onDestroy", "onEmotionClick", "emotions", "Lcom/coolapk/market/widget/emotion/BaseEmotion;", "onPause", "onPickAppIntent", "onPickAtIntent", "onPickImageListChange", "pathList", "", "", "onPickTopicIntent", "onRequestPickImage", "onSubmitButtonClick", "onSubmitToButtonClick", "prepareMultiFeed", "Lrx/Observable;", "prepareMultiFeed$presentation_coolapkAppRelease", "setPickTopicUI", "startSingleLocation", "stopSingleLocation", "updateFeedMultiPart", "part", "updateUIConfig", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandContentHolder.kt */
public class SecondHandContentHolder extends BaseFeedContentHolder implements View.OnClickListener {
    public PickPhotoAdapterV8 adapter;
    public SecondHandContentV8Binding binding;
    private final Lazy extraView$delegate;
    private AMapLocationClient locationClientSingle;
    private final AMapLocationListener locationSingleListener = new SecondHandContentHolder$locationSingleListener$1(this);
    private SubmitFeedExtraLogoBinding pickGoodsBinding;

    /* access modifiers changed from: private */
    public final SubmitSecondHandExtraViewPart getExtraView() {
        return (SubmitSecondHandExtraViewPart) this.extraView$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecondHandContentHolder(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.extraView$delegate = LazyKt.lazy(new SecondHandContentHolder$extraView$2(activity));
    }

    public static final /* synthetic */ SubmitFeedExtraLogoBinding access$getPickGoodsBinding$p(SecondHandContentHolder secondHandContentHolder) {
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding = secondHandContentHolder.pickGoodsBinding;
        if (submitFeedExtraLogoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
        }
        return submitFeedExtraLogoBinding;
    }

    public final SecondHandContentV8Binding getBinding$presentation_coolapkAppRelease() {
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return secondHandContentV8Binding;
    }

    public final void setBinding$presentation_coolapkAppRelease(SecondHandContentV8Binding secondHandContentV8Binding) {
        Intrinsics.checkNotNullParameter(secondHandContentV8Binding, "<set-?>");
        this.binding = secondHandContentV8Binding;
    }

    public final PickPhotoAdapterV8 getAdapter$presentation_coolapkAppRelease() {
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return pickPhotoAdapterV8;
    }

    public final void setAdapter$presentation_coolapkAppRelease(PickPhotoAdapterV8 pickPhotoAdapterV8) {
        Intrinsics.checkNotNullParameter(pickPhotoAdapterV8, "<set-?>");
        this.adapter = pickPhotoAdapterV8;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View getFocusEditorView() {
        return getFocusEditText();
    }

    private final EditText getFocusEditText() {
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = secondHandContentV8Binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        return editText;
    }

    /* access modifiers changed from: private */
    public final void startSingleLocation() {
        if (this.locationClientSingle == null) {
            this.locationClientSingle = new AMapLocationClient(getActivity().getApplicationContext());
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setLocationCacheEnable(false);
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient);
        aMapLocationClient.setLocationOption(aMapLocationClientOption);
        AMapLocationClient aMapLocationClient2 = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient2);
        aMapLocationClient2.setLocationListener(this.locationSingleListener);
        AMapLocationClient aMapLocationClient3 = this.locationClientSingle;
        Intrinsics.checkNotNull(aMapLocationClient3);
        aMapLocationClient3.startLocation();
    }

    private final void stopSingleLocation() {
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        if (aMapLocationClient != null) {
            Intrinsics.checkNotNull(aMapLocationClient);
            aMapLocationClient.stopLocation();
        }
    }

    public final void updateUIConfig(FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(feedUIConfig, "uiConfig");
        if (getActivity() instanceof SubmitFeedV8Activity) {
            ((SubmitFeedV8Activity) getActivity()).updateUIConfig(feedUIConfig);
        }
    }

    public final void updateFeedMultiPart(FeedMultiPart feedMultiPart) {
        Intrinsics.checkNotNullParameter(feedMultiPart, "part");
        if (getActivity() instanceof SubmitFeedV8Activity) {
            ((SubmitFeedV8Activity) getActivity()).updateMultiPart(feedMultiPart);
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public View onCreateContentView$presentation_coolapkAppRelease(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559133, null, false, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ndingComponent(activity))");
        SecondHandContentV8Binding secondHandContentV8Binding = (SecondHandContentV8Binding) inflate;
        this.binding = secondHandContentV8Binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        secondHandContentV8Binding.setUiConfig(getUiConfig());
        PickPhotoAdapterV8 pickPhotoAdapterV8 = new PickPhotoAdapterV8(getActivity());
        this.adapter = pickPhotoAdapterV8;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.setOnPhotoCountChangeListener(new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$1(pickPhotoAdapterV8, this));
        if (getUiConfig().isSecondHandViewVisible()) {
            PickPhotoAdapterV8 pickPhotoAdapterV82 = this.adapter;
            if (pickPhotoAdapterV82 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            pickPhotoAdapterV82.setBindType(1);
        }
        pickPhotoAdapterV8.setPickPhotoClickListener(new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$2(this));
        pickPhotoAdapterV8.setInitList(getMultiPart().imageUriList());
        pickPhotoAdapterV8.setEditTable(true);
        pickPhotoAdapterV8.setMaxPickCount(getUiConfig().maxPickPhotoCount());
        SecondHandContentV8Binding secondHandContentV8Binding2 = this.binding;
        if (secondHandContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = secondHandContentV8Binding2.recyclerView;
        PickPhotoAdapterV8 pickPhotoAdapterV83 = this.adapter;
        if (pickPhotoAdapterV83 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(pickPhotoAdapterV83);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setOverScrollMode(2);
        SecondHandContentV8Binding secondHandContentV8Binding3 = this.binding;
        if (secondHandContentV8Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = secondHandContentV8Binding3.editTitle;
        editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(getUiConfig().editTitleMaxLength())});
        editText.setText(getMultiPart().messageTitle());
        editText.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        editText.setOnFocusChangeListener(new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$3(this));
        SecondHandContentV8Binding secondHandContentV8Binding4 = this.binding;
        if (secondHandContentV8Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = secondHandContentV8Binding4.editTitleFreeNum;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.editTitleFreeNum");
        textView.setText(String.valueOf(getUiConfig().editTitleMaxLength()));
        SecondHandContentV8Binding secondHandContentV8Binding5 = this.binding;
        if (secondHandContentV8Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = secondHandContentV8Binding5.editText;
        editText2.addTextChangedListener(new CommentHelper.EmotionTextModifier());
        editText2.setText(getMultiPart().message());
        editText2.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
        editText2.addTextChangedListener(new CommentHelper.OnTextInputListener("@", new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$4(this)));
        editText2.addTextChangedListener(new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$5(this));
        editText2.setOnFocusChangeListener(new SecondHandContentHolder$onCreateContentView$$inlined$apply$lambda$6(this));
        SecondHandContentV8Binding secondHandContentV8Binding6 = this.binding;
        if (secondHandContentV8Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        secondHandContentV8Binding6.setClick(this);
        if (getUiConfig().isForward()) {
            String message = getMultiPart().message();
            Intrinsics.checkNotNullExpressionValue(message, "multiPart.message()");
            if (StringsKt.startsWith$default(message, "//", false, 2, (Object) null)) {
                z = true;
            }
        }
        if ((!Intrinsics.areEqual(getMultiPart().type(), "discovery")) && !z) {
            SecondHandContentV8Binding secondHandContentV8Binding7 = this.binding;
            if (secondHandContentV8Binding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = secondHandContentV8Binding7.editText;
            SecondHandContentV8Binding secondHandContentV8Binding8 = this.binding;
            if (secondHandContentV8Binding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            editText3.setSelection(secondHandContentV8Binding8.editText.length());
        }
        setPickTopicUI();
        SecondHandContentV8Binding secondHandContentV8Binding9 = this.binding;
        if (secondHandContentV8Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.replaceView(secondHandContentV8Binding9.spaceView, getExtraView().getView());
        SecondHandContentV8Binding secondHandContentV8Binding10 = this.binding;
        if (secondHandContentV8Binding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        secondHandContentV8Binding10.executePendingBindings();
        if (Intrinsics.areEqual(getMultiPart().type(), "ershou")) {
            XXPermissions permission = XXPermissions.with(getActivity()).permission("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
            Intrinsics.checkNotNullExpressionValue(permission, "XXPermissions.with(activ…ion.ACCESS_FINE_LOCATION)");
            LibraryExtentsKt.asObservable(permission).subscribe((Subscriber<? super Boolean>) new SecondHandContentHolder$onCreateContentView$5(this));
        }
        SecondHandContentV8Binding secondHandContentV8Binding11 = this.binding;
        if (secondHandContentV8Binding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = secondHandContentV8Binding11.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setPickTopicUI() {
        if (this.pickGoodsBinding == null) {
            SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
            if (secondHandContentV8Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = secondHandContentV8Binding.relativeView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.relativeView");
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(linearLayout.getContext()), 2131559158, linearLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…a_logo, container, false)");
            SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding = (SubmitFeedExtraLogoBinding) inflate;
            this.pickGoodsBinding = submitFeedExtraLogoBinding;
            if (submitFeedExtraLogoBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
            }
            submitFeedExtraLogoBinding.setClick(new SecondHandContentHolder$setPickTopicUI$2(this));
            SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding2 = this.pickGoodsBinding;
            if (submitFeedExtraLogoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
            }
            linearLayout.addView(submitFeedExtraLogoBinding2.getRoot());
            View newSmallDividerView = newSmallDividerView(getActivity());
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
            relativeTitle = "选择要出售的商品";
        }
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding3 = this.pickGoodsBinding;
        if (submitFeedExtraLogoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
        }
        TextView textView = submitFeedExtraLogoBinding3.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "pickGoodsBinding.titleView");
        textView.setText(relativeTitle);
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding4 = this.pickGoodsBinding;
        if (submitFeedExtraLogoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
        }
        ImageView imageView = submitFeedExtraLogoBinding4.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "pickGoodsBinding.imageView");
        ViewExtendsKt.clipView(imageView, 0, (float) NumberExtendsKt.getDp((Number) 4));
        ImageLoaderOptions build = ImageLoaderOptions.newBuilder().placeHolderRes(2131231172).build();
        GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
        Activity activity = getActivity();
        String relativeLogo = getUiConfig().relativeLogo();
        SubmitFeedExtraLogoBinding submitFeedExtraLogoBinding5 = this.pickGoodsBinding;
        if (submitFeedExtraLogoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickGoodsBinding");
        }
        contextImageLoader.displayImage((Context) activity, relativeLogo, submitFeedExtraLogoBinding5.imageView, build, (OnImageLoadListener) null, (OnBitmapTransformListener) new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 4), false, 2, null));
    }

    private final View newSmallDividerView(Context context) {
        View view = new View(context);
        view.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(2131165598));
        layoutParams.leftMargin = DisplayUtils.dp2px(context, 16.0f);
        layoutParams.rightMargin = DisplayUtils.dp2px(context, 16.0f);
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void notifyUIChange$presentation_coolapkAppRelease() {
        super.notifyUIChange$presentation_coolapkAppRelease();
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        secondHandContentV8Binding.setUiConfig(getUiConfig());
        SecondHandContentV8Binding secondHandContentV8Binding2 = this.binding;
        if (secondHandContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        secondHandContentV8Binding2.executePendingBindings();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onDestroy() {
        super.onDestroy();
        AMapLocationClient aMapLocationClient = this.locationClientSingle;
        if (aMapLocationClient != null) {
            Intrinsics.checkNotNull(aMapLocationClient);
            aMapLocationClient.onDestroy();
            this.locationClientSingle = null;
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onPause() {
        super.onPause();
        if (this.locationClientSingle != null) {
            stopSingleLocation();
        }
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onActivityResult(int i, int i2, Intent intent) {
        Product product;
        Intrinsics.checkNotNullParameter(intent, "data");
        super.onActivityResult(i, i2, intent);
        getExtraView().onActivityResult(i, i2, intent);
        if ((i == 2323 || i == 5555) && (product = (Product) intent.getParcelableExtra("product")) != null) {
            FeedUIConfig build = FeedUIConfig.builder(getUiConfig()).relativeLogo(product.getLogo()).relativeTitle(product.getTitle()).isProductPicked(true).showParamsItem(!Intrinsics.areEqual(product.getSecondHandSthType(), "104")).build();
            Activity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.feedv8.SubmitFeedV8Activity");
            Intrinsics.checkNotNullExpressionValue(build, "newUiConfig");
            ((SubmitFeedV8Activity) activity).updateUIConfig(build);
            setPickTopicUI();
            FeedMultiPart.Builder builder = FeedMultiPart.builder(((SubmitFeedV8Activity) getActivity()).getMultiPart());
            builder.productId(product.getId());
            String secondHandSthType = product.getSecondHandSthType();
            if (secondHandSthType == null) {
                secondHandSthType = "100";
            }
            builder.secondHandSthType(secondHandSthType);
            FeedMultiPart build2 = builder.build();
            Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
            ((SubmitFeedV8Activity) getActivity()).updateMultiPart(build2);
            getExtraView().updataSecondParams();
        }
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
    public void onPickImageListChange(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "pathList");
        super.onPickImageListChange(list);
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.onPickedImageChange(list);
        requestCheckSubmittable$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onRequestPickImage() {
        super.onRequestPickImage();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pickPhotoAdapterV8.pickImage();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitButtonClick() {
        if (Intrinsics.areEqual(getMultiPart().type(), "discovery") || Intrinsics.areEqual(getMultiPart().type(), "ershou")) {
            PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
            if (pickPhotoAdapterV8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            if (pickPhotoAdapterV8.getImageUrls().size() <= 0) {
                Toast.show$default(getActivity(), "亲，至少添加一张图片喔", 0, false, 12, null);
                return;
            }
        }
        if (Intrinsics.areEqual("ershou", getMultiPart().type())) {
            String secondHandOutLink = getMultiPart().secondHandOutLink();
            if (!(secondHandOutLink == null || secondHandOutLink.length() == 0) || getMultiPart().secondHandDealType() == 1) {
                checkAgree();
            } else {
                Toast.show$default(getActivity(), "请填写商品的闲鱼链接", 0, false, 12, null);
            }
        } else {
            startSubmitFeed$presentation_coolapkAppRelease();
        }
    }

    private final void checkAgree() {
        DataManager.getInstance().onCheckAgree().compose(RxUtils.applyIOSchedulers()).subscribe(new SecondHandContentHolder$checkAgree$1(this), new SecondHandContentHolder$checkAgree$2(this));
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public FeedMultiPart generateDraftCopy$presentation_coolapkAppRelease() {
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = secondHandContentV8Binding.editText;
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
        SecondHandContentV8Binding secondHandContentV8Binding2 = this.binding;
        if (secondHandContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = secondHandContentV8Binding2.editTitle;
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
        Map map = (Map) Observable.from(getMultiPart().imageUriList()).toMap(SecondHandContentHolder$generateDraftCopy$oldImageMap$1.INSTANCE).toBlocking().first();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        builder.imageUriList((List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new SecondHandContentHolder$generateDraftCopy$fixedList$1(map)).toList().toBlocking().first());
        FeedMultiPart build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public Observable<FeedMultiPart> prepareMultiFeed$presentation_coolapkAppRelease() {
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = secondHandContentV8Binding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        FeedMultiPart.Builder builder = FeedMultiPart.builder(getMultiPart());
        if (!TextUtils.isEmpty(getUiConfig().topicTitle())) {
            if (!StringsKt.contains$default((CharSequence) obj, (CharSequence) ("#" + getUiConfig().topicTitle() + "#"), false, 2, (Object) null)) {
                obj = "#" + getUiConfig().topicTitle() + "# " + obj;
            }
        }
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
        SecondHandContentV8Binding secondHandContentV8Binding2 = this.binding;
        if (secondHandContentV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = secondHandContentV8Binding2.editTitle;
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
        updateMultiPart$presentation_coolapkAppRelease(build);
        FeedMultiPart multiPart = getMultiPart();
        Map map = (Map) Observable.from(multiPart.imageUriList()).toMap(SecondHandContentHolder$prepareMultiFeed$oldImageMap$1.INSTANCE).toBlocking().first();
        PickPhotoAdapterV8 pickPhotoAdapterV8 = this.adapter;
        if (pickPhotoAdapterV8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        List list = (List) Observable.from(pickPhotoAdapterV8.getImageUrls()).map(new SecondHandContentHolder$prepareMultiFeed$fixedList$1(map)).toList().toBlocking().first();
        multiPart.imageUriList().clear();
        List<ImageUrl> imageUriList = multiPart.imageUriList();
        Intrinsics.checkNotNullExpressionValue(list, "fixedList");
        imageUriList.addAll(list);
        return super.prepareMultiFeed$presentation_coolapkAppRelease();
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public boolean checkSubmittable$presentation_coolapkAppRelease() {
        SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
        if (secondHandContentV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = secondHandContentV8Binding.editText;
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
        return !TextUtils.isEmpty(obj.subSequence(i, length + 1).toString());
    }

    @Override // com.coolapk.market.view.feedv8.BaseFeedContentHolder
    public void onSubmitToButtonClick() {
        super.onSubmitToButtonClick();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == 2131362256) {
            SecondHandContentV8Binding secondHandContentV8Binding = this.binding;
            if (secondHandContentV8Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            FeedWarningBinding feedWarningBinding = secondHandContentV8Binding.alertView;
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
                SecondHandContentV8Binding secondHandContentV8Binding2 = this.binding;
                if (secondHandContentV8Binding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                FeedWarningBinding feedWarningBinding2 = secondHandContentV8Binding2.alertView;
                Intrinsics.checkNotNullExpressionValue(feedWarningBinding2, "binding.alertView");
                View root2 = feedWarningBinding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.alertView.root");
                root2.setVisibility(8);
            }
        }
    }
}
