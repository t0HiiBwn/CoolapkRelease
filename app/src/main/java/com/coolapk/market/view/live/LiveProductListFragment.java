package com.coolapk.market.view.live;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import group.infotech.drawable.dsl.Drawable_dslKt;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.Size;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001d\u0010\f\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/live/LiveProductListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "Lkotlin/Lazy;", "productId", "getProductId", "productId$delegate", "productLogo", "getProductLogo", "productLogo$delegate", "productName", "getProductName", "productName$delegate", "createPostButton", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveProductListFragment.kt */
public final class LiveProductListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE_ID = "LIVE_ID";
    public static final String KEY_LIVE_PRODUCT = "LIVE_PRODUCT";
    public static final String KEY_LIVE_PRODUCT_ID = "LIVE_PRODUCT_ID";
    public static final String KEY_LIVE_PRODUCT_LOGO = "LIVE_PRODUCT_LOGO";
    private final Lazy liveId$delegate = LazyKt.lazy(new LiveProductListFragment$liveId$2(this));
    private final Lazy productId$delegate = LazyKt.lazy(new LiveProductListFragment$productId$2(this));
    private final Lazy productLogo$delegate = LazyKt.lazy(new LiveProductListFragment$productLogo$2(this));
    private final Lazy productName$delegate = LazyKt.lazy(new LiveProductListFragment$productName$2(this));

    private final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getProductId() {
        return (String) this.productId$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getProductLogo() {
        return (String) this.productLogo$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getProductName() {
        return (String) this.productName$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/live/LiveProductListFragment$Companion;", "", "()V", "KEY_LIVE_ID", "", "KEY_LIVE_PRODUCT", "KEY_LIVE_PRODUCT_ID", "KEY_LIVE_PRODUCT_LOGO", "newInstance", "Lcom/coolapk/market/view/live/LiveProductListFragment;", "liveId", "productId", "productName", "productLogo", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveProductListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveProductListFragment newInstance(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "liveId");
            Intrinsics.checkNotNullParameter(str2, "productId");
            Intrinsics.checkNotNullParameter(str3, "productName");
            Intrinsics.checkNotNullParameter(str4, "productLogo");
            LiveProductListFragment liveProductListFragment = new LiveProductListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LIVE_ID", str);
            bundle.putString("LIVE_PRODUCT", str3);
            bundle.putString("LIVE_PRODUCT_ID", str2);
            bundle.putString("LIVE_PRODUCT_LOGO", str4);
            Unit unit = Unit.INSTANCE;
            liveProductListFragment.setArguments(bundle);
            return liveProductListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        createPostButton();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Entity findLastEntity$default;
        Entity findFirstEntity$default;
        DataManager instance = DataManager.getInstance();
        String liveId = getLiveId();
        String str = null;
        String entityId = (!z || (findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null)) == null) ? null : findFirstEntity$default.getEntityId();
        if (!z && (findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null)) != null) {
            str = findLastEntity$default.getEntityId();
        }
        Observable<R> map = instance.getLiveProductList(liveId, i, entityId, str).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    private final void createPostButton() {
        TextView textView = new TextView(getActivity());
        textView.setText("发布动态");
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setPadding(NumberExtendsKt.getDp((Number) 16), 0, NumberExtendsKt.getDp((Number) 16), 0);
        textView.setElevation((float) NumberExtendsKt.getDp((Number) 2));
        float[] fArr = new float[8];
        Arrays.fill(fArr, (float) NumberExtendsKt.getDp((Number) 20));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        int parseColor = Color.parseColor("#CCCCCC");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        ShapesKt.setSolidColor(gradientDrawable, AppHolder.getAppTheme().getColorAccent());
        Size size = new Size();
        size.setHeight(NumberExtendsKt.getDp((Number) 40));
        gradientDrawable.setSize(size.getWidth(), size.getHeight());
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 20));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(Drawable_dslKt.rippleCompat(parseColor, gradientDrawable, shapeDrawable));
        textView.setOnClickListener(new LiveProductListFragment$createPostButton$2(this));
        View view = getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        TextView textView2 = textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = NumberExtendsKt.getDp((Number) 40);
        Unit unit2 = Unit.INSTANCE;
        ((FrameLayout) view).addView(textView2, layoutParams);
        ViewExtents2Kt.tryListenWindowsInset(textView2, new LiveProductListFragment$createPostButton$4(textView));
    }
}
