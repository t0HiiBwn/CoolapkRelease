package com.coolapk.market.view.goods.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.RxUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "bgColor", "Landroidx/lifecycle/MutableLiveData;", "", "getBgColor", "()Landroidx/lifecycle/MutableLiveData;", "feedGoods", "Lcom/coolapk/market/model/FeedGoods;", "getFeedGoods", "isLoading", "", "()Z", "loadingStatus", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel$LoadingStatus;", "kotlin.jvm.PlatformType", "getLoadingStatus", "loadGoodsDetail", "Landroidx/lifecycle/LiveData;", "id", "", "setBgColor", "", "color", "Companion", "LoadingStatus", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodsDetailPresenter.kt */
public final class GoodsDetailViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    private final MutableLiveData<Integer> bgColor = new MutableLiveData<>(null);
    private final MutableLiveData<FeedGoods> feedGoods = new MutableLiveData<>(null);
    private final MutableLiveData<LoadingStatus> loadingStatus = new MutableLiveData<>(new LoadingStatus(false, null, 2, null));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel$Companion;", "", "()V", "obtain", "Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsDetailPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoodsDetailViewModel obtain(AppCompatActivity appCompatActivity) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
            ViewModel viewModel = ViewModelProviders.of(appCompatActivity).get(GoodsDetailViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…ailViewModel::class.java)");
            return (GoodsDetailViewModel) viewModel;
        }
    }

    public final MutableLiveData<FeedGoods> getFeedGoods() {
        return this.feedGoods;
    }

    public final MutableLiveData<LoadingStatus> getLoadingStatus() {
        return this.loadingStatus;
    }

    public final MutableLiveData<Integer> getBgColor() {
        return this.bgColor;
    }

    public final boolean isLoading() {
        LoadingStatus value = this.loadingStatus.getValue();
        Intrinsics.checkNotNull(value);
        return value.isLoading();
    }

    public final LiveData<FeedGoods> loadGoodsDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (this.feedGoods.getValue() == null && !isLoading()) {
            this.loadingStatus.setValue(new LoadingStatus(true, null, 2, null));
            DataManager.getInstance().getGoodsDetail(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new GoodsDetailViewModel$loadGoodsDetail$1(this));
        }
        return this.feedGoods;
    }

    public final void setBgColor(int i) {
        this.bgColor.setValue(Integer.valueOf(i));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/goods/detail/GoodsDetailViewModel$LoadingStatus;", "", "isLoading", "", "errorMessage", "", "(ZLjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodsDetailPresenter.kt */
    public static final class LoadingStatus {
        private final String errorMessage;
        private final boolean isLoading;

        public static /* synthetic */ LoadingStatus copy$default(LoadingStatus loadingStatus, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = loadingStatus.isLoading;
            }
            if ((i & 2) != 0) {
                str = loadingStatus.errorMessage;
            }
            return loadingStatus.copy(z, str);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final String component2() {
            return this.errorMessage;
        }

        public final LoadingStatus copy(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new LoadingStatus(z, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadingStatus)) {
                return false;
            }
            LoadingStatus loadingStatus = (LoadingStatus) obj;
            return this.isLoading == loadingStatus.isLoading && Intrinsics.areEqual(this.errorMessage, loadingStatus.errorMessage);
        }

        public int hashCode() {
            boolean z = this.isLoading;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = i * 31;
            String str = this.errorMessage;
            return i4 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "LoadingStatus(isLoading=" + this.isLoading + ", errorMessage=" + this.errorMessage + ")";
        }

        public LoadingStatus(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.isLoading = z;
            this.errorMessage = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LoadingStatus(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? "" : str);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }
    }
}
