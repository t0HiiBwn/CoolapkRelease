package com.coolapk.market.view.feed;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ForwardPreviewBinding;
import com.coolapk.market.databinding.ItemForwardEntityShareAppBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideContextImageLoader;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedDraft;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0003,-.B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u000fH\u0014J\b\u0010%\u001a\u00020\u000fH\u0014J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/ForwardPreviewBinding;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "entity", "Lcom/coolapk/market/model/Entity;", "forwardAndReply", "", "isAnimating", "isPosting", "bindView", "", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "feed", "Lcom/coolapk/market/model/Feed;", "buildMultiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "messageWhenInputNothing", "", "buildUiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "finish", "getEntityHint", "initView", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSetStatusBarColor", "setAnimationValue", "value", "", "startCloseAnimation", "startOpenAnimation", "submitForwardFeed", "Companion", "DataAdapter", "SimpleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ForwardEntityActivity.kt */
public final class ForwardEntityActivity extends BaseActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ENTITY = "extra_entity";
    private ForwardPreviewBinding binding;
    private ColorDrawable colorDrawable = new ColorDrawable(-16777216);
    private Entity entity;
    private boolean forwardAndReply;
    private boolean isAnimating;
    private boolean isPosting;

    public static final /* synthetic */ ForwardPreviewBinding access$getBinding$p(ForwardEntityActivity forwardEntityActivity) {
        ForwardPreviewBinding forwardPreviewBinding = forwardEntityActivity.binding;
        if (forwardPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return forwardPreviewBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity$Companion;", "", "()V", "EXTRA_ENTITY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ForwardEntityActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        ForwardEntityActivity forwardEntityActivity = this;
        ThemeUtils.setSystemBarDrawFlags(forwardEntityActivity);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(forwardEntityActivity, 2131558569, null);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…ut.forward_preview, null)");
        this.binding = (ForwardPreviewBinding) contentView;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_entity");
        Intrinsics.checkNotNull(parcelableExtra);
        this.entity = (Entity) parcelableExtra;
        setSlidrEnable(false);
        initView();
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    private final void initView() {
        ForwardPreviewBinding forwardPreviewBinding;
        ForwardPreviewBinding forwardPreviewBinding2;
        ForwardPreviewBinding forwardPreviewBinding3;
        ForwardPreviewBinding forwardPreviewBinding4;
        ForwardPreviewBinding forwardPreviewBinding5;
        ForwardPreviewBinding forwardPreviewBinding6;
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        boolean z = entity2 instanceof Feed;
        if (z) {
            bindView((Feed) entity2);
        } else if (entity2 instanceof DyhArticle) {
            bindView((DyhArticle) entity2);
        } else {
            finish();
        }
        if (!isFinishing()) {
            float dp = (float) NumberExtendsKt.getDp((Number) 8);
            ForwardPreviewBinding forwardPreviewBinding7 = this.binding;
            if (forwardPreviewBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = forwardPreviewBinding7.contentView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            boolean z2 = false;
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
            Unit unit = Unit.INSTANCE;
            linearLayout.setBackground(gradientDrawable);
            ForwardPreviewBinding forwardPreviewBinding8 = this.binding;
            if (forwardPreviewBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding8.forwardAndReplyView.setOnCheckedChangeListener(new ForwardEntityActivity$initView$2(this));
            ForwardPreviewBinding forwardPreviewBinding9 = this.binding;
            if (forwardPreviewBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding9.setClick(this);
            ForwardPreviewBinding forwardPreviewBinding10 = this.binding;
            if (forwardPreviewBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding10.executePendingBindings();
            ForwardPreviewBinding forwardPreviewBinding11 = this.binding;
            if (forwardPreviewBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding11.editText.addTextChangedListener(new CommentHelper.EmotionTextModifier());
            ForwardPreviewBinding forwardPreviewBinding12 = this.binding;
            if (forwardPreviewBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding12.editText.setOnKeyListener(new CommentHelper.FastDeleteAtUserKeyListener());
            String str = "";
            FeedDraft draftLike = DataManager.getInstance().getDraftLike(FeedDraft.builder().setType("forward").setExtraId(EntityExtendsKt.entityUniqueId(entity2)).setExtraData(str).build());
            if (draftLike != null) {
                String message = draftLike.getMessage();
                if (!(message == null || message.length() == 0)) {
                    ForwardPreviewBinding forwardPreviewBinding13 = this.binding;
                    if (forwardPreviewBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    EditText editText = forwardPreviewBinding13.editText;
                    Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                    String message2 = draftLike.getMessage();
                    if (message2 != null) {
                        str = message2;
                    }
                    editText.setText(LinkTextUtils.convert(str, AppHolder.getAppTheme().getColorAccent(), null));
                    forwardPreviewBinding = this.binding;
                    if (forwardPreviewBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    forwardPreviewBinding.editText.setOnFocusChangeListener(new ForwardEntityActivity$initView$4(this));
                    forwardPreviewBinding2 = this.binding;
                    if (forwardPreviewBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RecyclerView recyclerView = forwardPreviewBinding2.recyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
                    ForwardEntityActivity forwardEntityActivity = this;
                    recyclerView.setAdapter(new DataAdapter(forwardEntityActivity, entity2));
                    forwardPreviewBinding3 = this.binding;
                    if (forwardPreviewBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RecyclerView recyclerView2 = forwardPreviewBinding3.recyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
                    recyclerView2.setLayoutManager(new LinearLayoutManager(forwardEntityActivity, 0, false));
                    forwardPreviewBinding4 = this.binding;
                    if (forwardPreviewBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    View root = forwardPreviewBinding4.getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                    root.getViewTreeObserver().addOnPreDrawListener(new ForwardEntityActivity$initView$5(this));
                    forwardPreviewBinding5 = this.binding;
                    if (forwardPreviewBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    EditText editText2 = forwardPreviewBinding5.editText;
                    Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
                    editText2.setHint(getEntityHint());
                    forwardPreviewBinding6 = this.binding;
                    if (forwardPreviewBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    forwardPreviewBinding6.maskView.addOnInsetChangeListener(new ForwardEntityActivity$initView$6(this));
                    if (z && Intrinsics.areEqual(((Feed) entity2).getFeedType(), "question")) {
                        z2 = true;
                    }
                    if (!z2) {
                        ForwardPreviewBinding forwardPreviewBinding14 = this.binding;
                        if (forwardPreviewBinding14 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        TextView textView = forwardPreviewBinding14.forwardAndReplyTextView;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.forwardAndReplyTextView");
                        textView.setVisibility(8);
                        ForwardPreviewBinding forwardPreviewBinding15 = this.binding;
                        if (forwardPreviewBinding15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        CheckBox checkBox = forwardPreviewBinding15.forwardAndReplyView;
                        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.forwardAndReplyView");
                        checkBox.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
            ForwardPreviewBinding forwardPreviewBinding16 = this.binding;
            if (forwardPreviewBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = forwardPreviewBinding16.editText;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(editText3.getText());
            ForwardPreviewBinding forwardPreviewBinding17 = this.binding;
            if (forwardPreviewBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText4 = forwardPreviewBinding17.editText;
            Intrinsics.checkNotNullExpressionValue(editText4, "binding.editText");
            Editable text = editText4.getText();
            text.clear();
            text.append((CharSequence) spannableStringBuilder);
            ForwardPreviewBinding forwardPreviewBinding18 = this.binding;
            if (forwardPreviewBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            forwardPreviewBinding18.editText.setSelection(0, 0);
            forwardPreviewBinding = this.binding;
            if (forwardPreviewBinding == null) {
            }
            forwardPreviewBinding.editText.setOnFocusChangeListener(new ForwardEntityActivity$initView$4(this));
            forwardPreviewBinding2 = this.binding;
            if (forwardPreviewBinding2 == null) {
            }
            RecyclerView recyclerView = forwardPreviewBinding2.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            ForwardEntityActivity forwardEntityActivity = this;
            recyclerView.setAdapter(new DataAdapter(forwardEntityActivity, entity2));
            forwardPreviewBinding3 = this.binding;
            if (forwardPreviewBinding3 == null) {
            }
            RecyclerView recyclerView2 = forwardPreviewBinding3.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
            recyclerView2.setLayoutManager(new LinearLayoutManager(forwardEntityActivity, 0, false));
            forwardPreviewBinding4 = this.binding;
            if (forwardPreviewBinding4 == null) {
            }
            View root = forwardPreviewBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.getViewTreeObserver().addOnPreDrawListener(new ForwardEntityActivity$initView$5(this));
            forwardPreviewBinding5 = this.binding;
            if (forwardPreviewBinding5 == null) {
            }
            EditText editText2 = forwardPreviewBinding5.editText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
            editText2.setHint(getEntityHint());
            forwardPreviewBinding6 = this.binding;
            if (forwardPreviewBinding6 == null) {
            }
            forwardPreviewBinding6.maskView.addOnInsetChangeListener(new ForwardEntityActivity$initView$6(this));
            z2 = true;
            if (!z2) {
            }
        }
    }

    private final void bindView(Feed feed) {
        String pic = feed.getPic();
        if (pic == null || pic.length() == 0) {
            ForwardPreviewBinding forwardPreviewBinding = this.binding;
            if (forwardPreviewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = forwardPreviewBinding.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
            imageView.setVisibility(8);
        } else {
            ForwardPreviewBinding forwardPreviewBinding2 = this.binding;
            if (forwardPreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = forwardPreviewBinding2.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconView");
            imageView2.setVisibility(0);
            GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
            ForwardEntityActivity forwardEntityActivity = this;
            String thumbSquarePic = feed.getThumbSquarePic();
            ForwardPreviewBinding forwardPreviewBinding3 = this.binding;
            if (forwardPreviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            contextImageLoader.displayImage(forwardEntityActivity, thumbSquarePic, forwardPreviewBinding3.iconView, 2131231374);
        }
        SpannableStringBuilder convert = LinkTextUtils.convert(FeedArgsFactory.multiPartForForwardFeed(feed).message(), AppHolder.getAppTheme().getColorAccent(), null);
        ForwardPreviewBinding forwardPreviewBinding4 = this.binding;
        if (forwardPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = forwardPreviewBinding4.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setText(convert);
        SpannableStringBuilder append = new SpannableStringBuilder("@").append((CharSequence) feed.getUserName()).append((CharSequence) "\n").append((CharSequence) LinkTextUtils.convert(feed.getMessage(), AppHolder.getAppTheme().getTextColorPrimary(), null));
        ForwardPreviewBinding forwardPreviewBinding5 = this.binding;
        if (forwardPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CoolEllipsizeTextView coolEllipsizeTextView = forwardPreviewBinding5.textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
        Intrinsics.checkNotNullExpressionValue(append, "text");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 2, append, null, false, 12, null);
    }

    private final void bindView(DyhArticle dyhArticle) {
        String logo = dyhArticle.getLogo();
        String str = logo;
        boolean z = true;
        if (str == null || str.length() == 0) {
            DyhModel dyhModel = dyhArticle.getDyhModel();
            logo = dyhModel != null ? dyhModel.getLogo() : null;
        }
        String str2 = logo;
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (z) {
            ForwardPreviewBinding forwardPreviewBinding = this.binding;
            if (forwardPreviewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = forwardPreviewBinding.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
            imageView.setVisibility(8);
        } else {
            ForwardPreviewBinding forwardPreviewBinding2 = this.binding;
            if (forwardPreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = forwardPreviewBinding2.iconView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.iconView");
            imageView2.setVisibility(0);
            GlideContextImageLoader contextImageLoader = AppHolder.getContextImageLoader();
            ForwardEntityActivity forwardEntityActivity = this;
            ForwardPreviewBinding forwardPreviewBinding3 = this.binding;
            if (forwardPreviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            contextImageLoader.displayImage(forwardEntityActivity, logo, forwardPreviewBinding3.iconView, 2131231374);
        }
        ForwardPreviewBinding forwardPreviewBinding4 = this.binding;
        if (forwardPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        forwardPreviewBinding4.editText.setText(FeedArgsFactory.multiPartForForwardDyhArticle(this, dyhArticle).message());
        SpannableStringBuilder append = new SpannableStringBuilder("@").append((CharSequence) dyhArticle.getDyhName()).append((CharSequence) "\n").append((CharSequence) LinkTextUtils.convert(dyhArticle.getMessage(), AppHolder.getAppTheme().getTextColorPrimary(), null));
        ForwardPreviewBinding forwardPreviewBinding5 = this.binding;
        if (forwardPreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CoolEllipsizeTextView coolEllipsizeTextView = forwardPreviewBinding5.textView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView");
        Intrinsics.checkNotNullExpressionValue(append, "text");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 2, append, null, false, 12, null);
    }

    /* access modifiers changed from: private */
    public final void startOpenAnimation() {
        this.isAnimating = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new ForwardEntityActivity$startOpenAnimation$$inlined$apply$lambda$1(this));
        ExtraExtendsKt.doOnEnd(valueAnimator, new ForwardEntityActivity$startOpenAnimation$$inlined$apply$lambda$2(this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
    }

    private final void startCloseAnimation() {
        ForwardPreviewBinding forwardPreviewBinding = this.binding;
        if (forwardPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = forwardPreviewBinding.maskView;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.maskView");
        if (drawSystemBarFrameLayout.getLastInsetsRect().bottom > UiUtils.getNavigationBarHeight(getActivity())) {
            finish();
        } else if (!isFinishing()) {
            this.isAnimating = true;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            valueAnimator.addUpdateListener(new ForwardEntityActivity$startCloseAnimation$$inlined$apply$lambda$1(this));
            valueAnimator.setDuration(300L);
            ExtraExtendsKt.doOnEnd(valueAnimator, new ForwardEntityActivity$startCloseAnimation$$inlined$apply$lambda$2(this));
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setAnimationValue(float f) {
        this.colorDrawable.setAlpha((int) (((float) 66) * f));
        ForwardPreviewBinding forwardPreviewBinding = this.binding;
        if (forwardPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = forwardPreviewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.colorDrawable);
        ForwardPreviewBinding forwardPreviewBinding2 = this.binding;
        if (forwardPreviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = forwardPreviewBinding2.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        float f2 = ((float) 1) - f;
        ForwardPreviewBinding forwardPreviewBinding3 = this.binding;
        if (forwardPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = forwardPreviewBinding3.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentView");
        linearLayout.setTranslationY(f2 * ((float) linearLayout2.getHeight()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131362200:
            case 2131362920:
                onBackPressed();
                return;
            case 2131362596:
                ForwardPreviewBinding forwardPreviewBinding = this.binding;
                if (forwardPreviewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                CheckBox checkBox = forwardPreviewBinding.forwardAndReplyView;
                Intrinsics.checkNotNullExpressionValue(checkBox, "binding.forwardAndReplyView");
                checkBox.setChecked(!this.forwardAndReply);
                return;
            case 2131362607:
                ActionManager.startSubmitFeedV8Activity(this, buildUiConfig(), buildMultiPart(""));
                finish();
                return;
            case 2131363148:
                submitForwardFeed();
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ForwardPreviewBinding forwardPreviewBinding = this.binding;
        if (forwardPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = forwardPreviewBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String obj = editText.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        if (StringsKt.trim(obj).toString().length() > 0) {
            FeedDraft.Builder type = FeedDraft.builder().setType("forward");
            Entity entity2 = this.entity;
            if (entity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("entity");
            }
            FeedDraft.Builder extraData = type.setExtraId(EntityExtendsKt.entityUniqueId(entity2)).setExtraData("");
            LinkTextUtils linkTextUtils = LinkTextUtils.INSTANCE;
            ForwardPreviewBinding forwardPreviewBinding2 = this.binding;
            if (forwardPreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText2 = forwardPreviewBinding2.editText;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.editText");
            DataManager.getInstance().addFeedDraft(extraData.setMessage(linkTextUtils.reconvertToString(new SpannableStringBuilder(editText2.getText()))).build());
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isAnimating) {
            startCloseAnimation();
        }
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

    private final void submitForwardFeed() {
        if (!this.isPosting) {
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
            this.isPosting = true;
            DataManager.getInstance().createFeed(buildMultiPart(getEntityHint())).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new ForwardEntityActivity$submitForwardFeed$1(this, progressDialog));
        }
    }

    private final FeedUIConfig buildUiConfig() {
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        if (entity2 instanceof Feed) {
            return FeedArgsFactory.uiConfigForForwardFeed(this, (Feed) entity2);
        }
        if (entity2 instanceof DyhArticle) {
            return FeedArgsFactory.uiConfigForForwardDyhArticle(this, (DyhArticle) entity2);
        }
        throw new RuntimeException("NOT SUPPORT");
    }

    private final FeedMultiPart buildMultiPart(String str) {
        FeedMultiPart feedMultiPart;
        LinkTextUtils linkTextUtils = LinkTextUtils.INSTANCE;
        ForwardPreviewBinding forwardPreviewBinding = this.binding;
        if (forwardPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = forwardPreviewBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        String reconvertToString = linkTextUtils.reconvertToString(new SpannableStringBuilder(editText.getText()));
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        if (entity2 instanceof Feed) {
            feedMultiPart = FeedArgsFactory.multiPartForForwardFeed((Feed) entity2);
        } else if (entity2 instanceof DyhArticle) {
            feedMultiPart = FeedArgsFactory.multiPartForForwardDyhArticle(this, (DyhArticle) entity2);
        } else {
            throw new RuntimeException("NOT SUPPORT");
        }
        FeedMultiPart.Builder isReplyWithForward = feedMultiPart.newBuilder().isReplyWithForward(this.forwardAndReply);
        if (!(reconvertToString.length() == 0)) {
            str = reconvertToString;
        }
        FeedMultiPart build = isReplyWithForward.message(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "multiPart.newBuilder().i…\n                .build()");
        return build;
    }

    private final String getEntityHint() {
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        if (entity2 instanceof Feed) {
            String string = getString(2131887321);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.title_forward_feed)");
            return string;
        } else if (entity2 instanceof DyhArticle) {
            String string2 = getString(2131887320);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.title_forward_article)");
            return string2;
        } else {
            throw new RuntimeException("NOT SUPPORT");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0010H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/feed/ForwardEntityActivity$SimpleViewHolder;", "context", "Landroid/content/Context;", "entity", "Lcom/coolapk/market/model/Entity;", "(Landroid/content/Context;Lcom/coolapk/market/model/Entity;)V", "getContext", "()Landroid/content/Context;", "dataList", "", "Lcom/coolapk/market/model/HolderItem;", "getEntity", "()Lcom/coolapk/market/model/Entity;", "shareApps", "Landroid/content/pm/ResolveInfo;", "shareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "doUserClickStatistic", "", "textView", "Landroid/widget/TextView;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "shareTextTo", "resolvedInfo", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ForwardEntityActivity.kt */
    private static final class DataAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        public static final Companion Companion = new Companion(null);
        public static final String ENTITY_TYPE_COPY_LINK = "copy_link";
        public static final String ENTITY_TYPE_KANKANHAO = "kankanhao";
        public static final String ENTITY_TYPE_MORE = "more";
        public static final String ENTITY_TYPE_NEW_FEED = "new_feed";
        public static final String ENTITY_TYPE_PRIVATE_MESSAGE = "private_message";
        public static final String ENTITY_TYPE_QQ = "qq";
        public static final String ENTITY_TYPE_TIM = "tim";
        public static final String ENTITY_TYPE_WEIBO = "weibo";
        public static final String ENTITY_TYPE_WEXIN = "wexin";
        public static final String ENTITY_TYPE_WEXIN_MOMENT = "wexin_moment";
        public static final String ENTITY_TYPE_ZHIHU = "zhihu";
        private final Context context;
        private final List<HolderItem> dataList;
        private final Entity entity;
        private final List<ResolveInfo> shareApps;
        private final ShareUtils.ShareInfo shareInfo;

        public DataAdapter(Context context2, Entity entity2) {
            T t;
            Object obj;
            T t2;
            T t3;
            T t4;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(entity2, "entity");
            this.context = context2;
            this.entity = entity2;
            this.shareInfo = ShareUtils.obtainShareInfo(entity2);
            ArrayList arrayList = new ArrayList();
            this.dataList = arrayList;
            ArrayList arrayList2 = new ArrayList();
            List<ResolveInfo> shareApps2 = PackageUtils.getShareApps(context2);
            Intrinsics.checkNotNullExpressionValue(shareApps2, "PackageUtils.getShareApps(context)");
            arrayList2.addAll(shareApps2);
            Unit unit = Unit.INSTANCE;
            this.shareApps = arrayList2;
            HolderItem build = HolderItem.newBuilder().entityType("kankanhao").build();
            Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…Y_TYPE_KANKANHAO).build()");
            arrayList.add(build);
            HolderItem build2 = HolderItem.newBuilder().entityType("private_message").build();
            Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder().…_PRIVATE_MESSAGE).build()");
            arrayList.add(build2);
            Iterator it2 = arrayList2.iterator();
            while (true) {
                t = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (Intrinsics.areEqual(((ResolveInfo) obj).activityInfo.packageName, "com.tencent.mm")) {
                    break;
                }
            }
            if (obj != null) {
                List<HolderItem> list = this.dataList;
                HolderItem build3 = HolderItem.newBuilder().entityType("wexin").build();
                Intrinsics.checkNotNullExpressionValue(build3, "HolderItem.newBuilder().…NTITY_TYPE_WEXIN).build()");
                list.add(build3);
                List<HolderItem> list2 = this.dataList;
                HolderItem build4 = HolderItem.newBuilder().entityType("wexin_moment").build();
                Intrinsics.checkNotNullExpressionValue(build4, "HolderItem.newBuilder().…YPE_WEXIN_MOMENT).build()");
                list2.add(build4);
            }
            Iterator<T> it3 = this.shareApps.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it3.next();
                if (Intrinsics.areEqual(((ResolveInfo) t2).activityInfo.packageName, "com.sina.weibo")) {
                    break;
                }
            }
            if (t2 != null) {
                List<HolderItem> list3 = this.dataList;
                HolderItem build5 = HolderItem.newBuilder().entityType("weibo").build();
                Intrinsics.checkNotNullExpressionValue(build5, "HolderItem.newBuilder().…NTITY_TYPE_WEIBO).build()");
                list3.add(build5);
            }
            Iterator<T> it4 = this.shareApps.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it4.next();
                if (Intrinsics.areEqual(((ResolveInfo) t3).activityInfo.packageName, "com.tencent.mobileqq")) {
                    break;
                }
            }
            if (t3 != null) {
                List<HolderItem> list4 = this.dataList;
                HolderItem build6 = HolderItem.newBuilder().entityType("qq").build();
                Intrinsics.checkNotNullExpressionValue(build6, "HolderItem.newBuilder().…e(ENTITY_TYPE_QQ).build()");
                list4.add(build6);
            }
            Iterator<T> it5 = this.shareApps.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    t4 = null;
                    break;
                }
                t4 = it5.next();
                if (Intrinsics.areEqual(((ResolveInfo) t4).activityInfo.packageName, "com.tencent.tim")) {
                    break;
                }
            }
            if (t4 != null) {
                List<HolderItem> list5 = this.dataList;
                HolderItem build7 = HolderItem.newBuilder().entityType("tim").build();
                Intrinsics.checkNotNullExpressionValue(build7, "HolderItem.newBuilder().…(ENTITY_TYPE_TIM).build()");
                list5.add(build7);
            }
            Iterator<T> it6 = this.shareApps.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                T next = it6.next();
                if (Intrinsics.areEqual(((ResolveInfo) next).activityInfo.packageName, "com.zhihu.android")) {
                    t = next;
                    break;
                }
            }
            if (t != null) {
                List<HolderItem> list6 = this.dataList;
                HolderItem build8 = HolderItem.newBuilder().entityType("zhihu").build();
                Intrinsics.checkNotNullExpressionValue(build8, "HolderItem.newBuilder().…NTITY_TYPE_ZHIHU).build()");
                list6.add(build8);
            }
            List<HolderItem> list7 = this.dataList;
            HolderItem build9 = HolderItem.newBuilder().entityType("copy_link").build();
            Intrinsics.checkNotNullExpressionValue(build9, "HolderItem.newBuilder().…Y_TYPE_COPY_LINK).build()");
            list7.add(build9);
            List<HolderItem> list8 = this.dataList;
            HolderItem build10 = HolderItem.newBuilder().entityType("more").build();
            Intrinsics.checkNotNullExpressionValue(build10, "HolderItem.newBuilder().…ENTITY_TYPE_MORE).build()");
            list8.add(build10);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Entity getEntity() {
            return this.entity;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity$DataAdapter$Companion;", "", "()V", "ENTITY_TYPE_COPY_LINK", "", "ENTITY_TYPE_KANKANHAO", "ENTITY_TYPE_MORE", "ENTITY_TYPE_NEW_FEED", "ENTITY_TYPE_PRIVATE_MESSAGE", "ENTITY_TYPE_QQ", "ENTITY_TYPE_TIM", "ENTITY_TYPE_WEIBO", "ENTITY_TYPE_WEXIN", "ENTITY_TYPE_WEXIN_MOMENT", "ENTITY_TYPE_ZHIHU", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ForwardEntityActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(2131558756, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…LAYOUT_ID, parent, false)");
            return new SimpleViewHolder(inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }

        public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int i) {
            Intrinsics.checkNotNullParameter(simpleViewHolder, "holder");
            ItemForwardEntityShareAppBinding itemForwardEntityShareAppBinding = (ItemForwardEntityShareAppBinding) simpleViewHolder.getBinding();
            GlideApp.with(itemForwardEntityShareAppBinding.iconView).clear(itemForwardEntityShareAppBinding.iconView);
            String entityType = this.dataList.get(i).getEntityType();
            if (entityType != null) {
                switch (entityType.hashCode()) {
                    case -1530160821:
                        if (entityType.equals("private_message")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231507);
                            TextView textView = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                            textView.setText("私信");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$3(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case -1462912464:
                        if (entityType.equals("wexin_moment")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231329);
                            TextView textView2 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                            textView2.setText("朋友圈");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$5(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case -872750698:
                        if (entityType.equals("kankanhao")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231327);
                            TextView textView3 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                            textView3.setText("看看号");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$2(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 3616:
                        if (entityType.equals("qq")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231330);
                            TextView textView4 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                            textView4.setText("QQ");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$6(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 114840:
                        if (entityType.equals("tim")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231331);
                            TextView textView5 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
                            textView5.setText("TIM");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$7(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 3357525:
                        if (entityType.equals("more")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231328);
                            TextView textView6 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleView");
                            textView6.setText("更多");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$10(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 113011944:
                        if (entityType.equals("weibo")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231333);
                            TextView textView7 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
                            textView7.setText("微博");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$11(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 113026575:
                        if (entityType.equals("wexin")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231332);
                            TextView textView8 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView8, "binding.titleView");
                            textView8.setText("微信");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$4(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 115872072:
                        if (entityType.equals("zhihu")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231334);
                            TextView textView9 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView9, "binding.titleView");
                            textView9.setText("知乎");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$8(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 1376909533:
                        if (entityType.equals("new_feed")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231326);
                            TextView textView10 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView10, "binding.titleView");
                            textView10.setText("动态");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$1(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    case 1505434244:
                        if (entityType.equals("copy_link")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231325);
                            TextView textView11 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView11, "binding.titleView");
                            textView11.setText("复制链接");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ForwardEntityActivity$DataAdapter$onBindViewHolder$9(this, itemForwardEntityShareAppBinding));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* access modifiers changed from: private */
        public final void doUserClickStatistic(TextView textView) {
            StatisticHelper.Companion.getInstance().recordShareFeedToEvent(textView.getText().toString());
        }

        /* access modifiers changed from: private */
        public final void shareTextTo(ResolveInfo resolveInfo) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent.setType("text/*");
            intent.putExtra("android.intent.extra.TEXT", this.shareInfo.getContent());
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity$SimpleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ForwardEntityActivity.kt */
    private static final class SimpleViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558756;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/ForwardEntityActivity$SimpleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ForwardEntityActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
