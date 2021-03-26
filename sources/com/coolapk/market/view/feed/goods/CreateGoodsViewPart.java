package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.view.ViewGroupKt;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.CreateGoodsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0014J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/goods/CreateGoodsViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/CreateGoodsBinding;", "Lcom/coolapk/market/model/Feed;", "()V", "handleDone", "", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "Lcom/coolapk/market/model/FeedGoods;", "dismissAction", "Lkotlin/Function0;", "onBindToContent", "data", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "showAsBottomSheetDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateGoodsViewPart.kt */
public final class CreateGoodsViewPart extends BindingViewPart<CreateGoodsBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558492;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/goods/CreateGoodsViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CreateGoodsViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public CreateGoodsBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558492, viewGroup, false, new ContextBindingComponent(layoutInflater.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ponent(inflater.context))");
        return (CreateGoodsBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        LinearLayout linearLayout = ((CreateGoodsBinding) getBinding()).containerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.containerView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        float dpf = NumberExtendsKt.getDpf((Number) 12);
        gradientDrawable.setCornerRadii(new float[]{dpf, dpf, dpf, dpf, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("taobao", "淘宝"), TuplesKt.to("tmall", "天猫"), TuplesKt.to("jd", "京东"), TuplesKt.to("pdd", "拼多多")})) {
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setTextSize(12.0f);
            radioButton.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            radioButton.setText((CharSequence) pair.getSecond());
            radioButton.setTag(pair.getFirst());
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
            layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 12);
            Unit unit2 = Unit.INSTANCE;
            radioButton.setLayoutParams(layoutParams);
            TintHelper.setTint(radioButton, AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().isDarkTheme());
            ((CreateGoodsBinding) getBinding()).radioGroup.addView(radioButton);
        }
        ((CreateGoodsBinding) getBinding()).executePendingBindings();
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((CreateGoodsViewPart) feed);
    }

    public final void showAsBottomSheetDialog(Activity activity, Function1<? super FeedGoods, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ((CreateGoodsBinding) getBinding()).actionDone.setOnClickListener(new CreateGoodsViewPart$showAsBottomSheetDialog$1(this, activity, function1, DialogUtil.INSTANCE.showFullScreenDialog(activity, getView())));
        ((CreateGoodsBinding) getBinding()).iconView.setOnClickListener(new CreateGoodsViewPart$showAsBottomSheetDialog$2(this));
        View root = ((CreateGoodsBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtents2Kt.tryListenWindowsInset(root, new CreateGoodsViewPart$showAsBottomSheetDialog$3(this));
    }

    /* access modifiers changed from: private */
    public final void handleDone(Activity activity, Function1<? super FeedGoods, Unit> function1, Function0<Unit> function0) {
        View view;
        boolean z;
        ImageUrl image = ((CreateGoodsBinding) getBinding()).getImage();
        if (image != null) {
            Intrinsics.checkNotNullExpressionValue(image, "binding.image ?: return");
            EditText editText = ((CreateGoodsBinding) getBinding()).titleEditText;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.titleEditText");
            String obj = editText.getText().toString();
            if (!(!StringsKt.isBlank(obj))) {
                obj = null;
            }
            if (obj != null) {
                EditText editText2 = ((CreateGoodsBinding) getBinding()).urlEditText;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.urlEditText");
                String obj2 = editText2.getText().toString();
                if (!(!StringsKt.isBlank(obj2))) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    RadioGroup radioGroup = ((CreateGoodsBinding) getBinding()).radioGroup;
                    Intrinsics.checkNotNullExpressionValue(radioGroup, "binding.radioGroup");
                    Iterator<View> it2 = ViewGroupKt.getChildren(radioGroup).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            view = null;
                            break;
                        }
                        view = it2.next();
                        View view2 = view;
                        if (!(view2 instanceof RadioButton) || !((RadioButton) view2).isChecked()) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    View view3 = view;
                    if (view3 != null) {
                        DataManager.getInstance().uploadImage(CollectionsKt.listOf(ImageUploadOption.create(image.getCompressedUrl(), "goods_cover", "", null))).flatMap(new CreateGoodsViewPart$handleDone$1(view3, obj, obj2)).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new CreateGoodsViewPart$handleDone$2(DialogUtil.showProgressDialog$default(DialogUtil.INSTANCE, activity, "正在提交，请稍等...", false, 4, null))).subscribe((Subscriber<? super R>) new CreateGoodsViewPart$handleDone$3(this, function1, function0));
                    }
                }
            }
        }
    }
}
