package com.coolapk.market.view.user.profile;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUserCoverAddBinding;
import com.coolapk.market.databinding.ItemUserCoverImageBinding;
import com.coolapk.market.databinding.ItemUserCoverTitleBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.ShortAsyncListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0014\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment;", "Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "Lcom/coolapk/market/model/HolderItem;", "()V", "presenter", "Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "getPresenter", "()Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "presenter$delegate", "Lkotlin/Lazy;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "onDataListChanged", "holderList", "Companion", "CoverAddViewHolder", "CoverImageViewHolder", "TitleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserCoverFragment.kt */
public final class UserCoverFragment extends ShortAsyncListFragment<HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ENTITY = "extra_entity";
    public static final String HOLDER_TYPE_ADD = "holder_type_add";
    public static final String HOLDER_TYPE_IMAGE = "holder_type_image";
    public static final String HOLDER_TYPE_TITLE = "holder_type_title";
    private final Lazy presenter$delegate = LazyKt.lazy(new UserCoverFragment$presenter$2(this));

    /* access modifiers changed from: private */
    public final UserCoverPresenter getPresenter() {
        return (UserCoverPresenter) this.presenter$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$Companion;", "", "()V", "EXTRA_ENTITY", "", "HOLDER_TYPE_ADD", "HOLDER_TYPE_IMAGE", "HOLDER_TYPE_TITLE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserCoverFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.ShortAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558977).suitedEntityType("holder_type_title").constructor(new UserCoverFragment$onActivityCreated$1(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558976).suitedEntityType("holder_type_image").constructor(new UserCoverFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter(), SimpleViewHolderFactor.Companion.withLayoutId(2131558975).suitedEntityType("holder_type_add").constructor(new UserCoverFragment$onActivityCreated$3(this)).build(), 0, 2, null);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(new UserCoverFragment$onActivityCreated$$inlined$apply$lambda$1(this));
        Unit unit = Unit.INSTANCE;
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView2 = getRecyclerView();
        recyclerView2.addItemDecoration(new UserCoverFragment$onActivityCreated$5$1());
        recyclerView2.setClipToPadding(false);
        recyclerView2.setClipChildren(false);
        recyclerView2.setPadding(NumberExtendsKt.getDp((Number) 12), recyclerView2.getPaddingTop(), NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12));
        recyclerView2.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        initData();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<HolderItem>> onCreateRequest(boolean z, int i) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        Observable<R> map = instance.getAvatarCoverList().flatMap(RxUtils.flatCheckResultToData()).map(UserCoverFragment$onCreateRequest$1.INSTANCE).map(new UserCoverFragment$onCreateRequest$2(this));
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…ter.processDataList(it) }");
        return map;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            getPresenter().handleActivityResult(i, intent);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e0  */
    public final void onDataListChanged(List<? extends HolderItem> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "holderList");
        int i = 0;
        if (list.size() == getDataList().size()) {
            List<? extends HolderItem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getUrl());
            }
            ArrayList arrayList2 = arrayList;
            ObservableArrayList<HolderItem> dataList = getDataList();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(dataList, 10));
            for (HolderItem holderItem : dataList) {
                Intrinsics.checkNotNullExpressionValue(holderItem, "it");
                arrayList3.add(holderItem.getUrl());
            }
            if (Intrinsics.areEqual(arrayList2, arrayList3)) {
                z = true;
                if (!z) {
                    ArrayList<Number> arrayList4 = new ArrayList();
                    for (Object obj : getDataList()) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (!Intrinsics.areEqual((HolderItem) obj, (HolderItem) list.get(i))) {
                            arrayList4.add(Integer.valueOf(i));
                        }
                        i = i2;
                    }
                    changeDataListWithoutChangeCallback(new UserCoverFragment$onDataListChanged$2(this, list));
                    for (Number number : arrayList4) {
                        int intValue = number.intValue();
                        getAdapter().notifyItemChanged(intValue, Integer.valueOf(intValue));
                    }
                    return;
                }
                changeDataListAndAutoCalculateDiff(new UserCoverFragment$onDataListChanged$4(this, list));
                return;
            }
        }
        z = false;
        if (!z) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$CoverImageViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserCoverImageBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "presenter", "Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/view/user/profile/UserCoverPresenter;)V", "bg", "Landroid/graphics/drawable/GradientDrawable;", "getBg", "()Landroid/graphics/drawable/GradientDrawable;", "data", "getData", "()Lcom/coolapk/market/model/HolderItem;", "setData", "(Lcom/coolapk/market/model/HolderItem;)V", "getPresenter", "()Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "bindToContent", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserCoverFragment.kt */
    private static final class CoverImageViewHolder extends GenericBindHolder<ItemUserCoverImageBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558976;
        private final GradientDrawable bg;
        private HolderItem data;
        private final UserCoverPresenter presenter;

        public final UserCoverPresenter getPresenter() {
            return this.presenter;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CoverImageViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, UserCoverPresenter userCoverPresenter) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            Intrinsics.checkNotNullParameter(userCoverPresenter, "presenter");
            this.presenter = userCoverPresenter;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 2));
            Unit unit = Unit.INSTANCE;
            this.bg = gradientDrawable;
            View view2 = ((ItemUserCoverImageBinding) getBinding()).foregroundView;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.foregroundView");
            view2.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 2130706432}));
        }

        public final GradientDrawable getBg() {
            return this.bg;
        }

        public final HolderItem getData() {
            return this.data;
        }

        public final void setData(HolderItem holderItem) {
            this.data = holderItem;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0108, code lost:
            if ((!kotlin.jvm.internal.Intrinsics.areEqual(r0 != null ? r0.getUrl() : null, r11.getUrl())) != false) goto L_0x010a;
         */
        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            ((ItemUserCoverImageBinding) getBinding()).executePendingBindings();
            String value = holderItem.getValue();
            if (!(value == null || StringsKt.isBlank(value))) {
                TextView textView = ((ItemUserCoverImageBinding) getBinding()).textView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
                textView.setText("正在使用");
                TextView textView2 = ((ItemUserCoverImageBinding) getBinding()).textView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
                textView2.setClickable(false);
                this.bg.setStroke(NumberExtendsKt.getDp((Number) 1), -1);
                this.bg.setColor(0);
            } else {
                TextView textView3 = ((ItemUserCoverImageBinding) getBinding()).textView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.textView");
                textView3.setText("设为背景");
                ((ItemUserCoverImageBinding) getBinding()).textView.setOnClickListener(new UserCoverFragment$CoverImageViewHolder$bindToContent$1(this, holderItem));
                this.bg.setStroke(0, -1);
                this.bg.setColor(AppHolder.getAppTheme().getColorAccent());
            }
            TextView textView4 = ((ItemUserCoverImageBinding) getBinding()).textView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.textView");
            textView4.setBackground(this.bg);
            Integer intValue = holderItem.getIntValue();
            if (intValue != null && intValue.intValue() == 1) {
                TextView textView5 = ((ItemUserCoverImageBinding) getBinding()).editView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.editView");
                textView5.setVisibility(0);
                ((ItemUserCoverImageBinding) getBinding()).editView.setOnClickListener(new UserCoverFragment$CoverImageViewHolder$bindToContent$2(this));
            } else {
                TextView textView6 = ((ItemUserCoverImageBinding) getBinding()).editView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.editView");
                textView6.setVisibility(8);
                TextView textView7 = ((ItemUserCoverImageBinding) getBinding()).editView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.editView");
                textView7.setClickable(false);
            }
            HolderItem holderItem2 = this.data;
            if (holderItem2 != null) {
            }
            AppHolder.getContextImageLoader().displayImage(getContext(), holderItem.getUrl(), (ImageView) ((ItemUserCoverImageBinding) getBinding()).imageView, ImageLoaderOptions.newBuilder().placeHolderRes(2131231707).useAnimate(true).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) null);
            ((ItemUserCoverImageBinding) getBinding()).imageView.setOnClickListener(new UserCoverFragment$CoverImageViewHolder$bindToContent$3(holderItem));
            ((ItemUserCoverImageBinding) getBinding()).foregroundView.post(new UserCoverFragment$CoverImageViewHolder$bindToContent$4(this));
            this.data = holderItem;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$CoverImageViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: UserCoverFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$CoverAddViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserCoverAddBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "presenter", "Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;Lcom/coolapk/market/view/user/profile/UserCoverPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/user/profile/UserCoverPresenter;", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserCoverFragment.kt */
    private static final class CoverAddViewHolder extends GenericBindHolder<ItemUserCoverAddBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558975;
        private final UserCoverPresenter presenter;

        public final UserCoverPresenter getPresenter() {
            return this.presenter;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CoverAddViewHolder(View view, FragmentBindingComponent fragmentBindingComponent, UserCoverPresenter userCoverPresenter) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            Intrinsics.checkNotNullParameter(userCoverPresenter, "presenter");
            this.presenter = userCoverPresenter;
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            ((ItemUserCoverAddBinding) getBinding()).executePendingBindings();
            ((ItemUserCoverAddBinding) getBinding()).imageView.setOnClickListener(new UserCoverFragment$CoverAddViewHolder$bindToContent$1(this));
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$CoverAddViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: UserCoverFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$TitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserCoverTitleBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindToContent", "", "data", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserCoverFragment.kt */
    private static final class TitleViewHolder extends GenericBindHolder<ItemUserCoverTitleBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558977;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(View view, FragmentBindingComponent fragmentBindingComponent) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "data");
            TextView textView = ((ItemUserCoverTitleBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(holderItem.getString());
            ((ItemUserCoverTitleBinding) getBinding()).executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/profile/UserCoverFragment$TitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: UserCoverFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
