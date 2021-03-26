package com.coolapk.market.view.appmanager;

import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.base.asynclist.AsyncListContract;
import com.coolapk.market.view.base.asynclist.AsyncListPresenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppContract;", "", "()V", "Presenter", "View", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppContract.kt */
public final class MobileAppContract {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppContract$View;", "Lcom/coolapk/market/view/base/asynclist/AsyncListContract$View;", "", "Lcom/coolapk/market/model/MobileApp;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppContract.kt */
    public interface View extends AsyncListContract.View<List<? extends MobileApp>> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u00122\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH&¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter;", "Lcom/coolapk/market/view/base/asynclist/AsyncListPresenter;", "", "Lcom/coolapk/market/model/MobileApp;", "view", "Lcom/coolapk/market/view/appmanager/MobileAppContract$View;", "(Lcom/coolapk/market/view/appmanager/MobileAppContract$View;)V", "isShowSystem", "", "isTaskLoading", "setShowSystem", "", "showSystem", "setSortBy", "sortBy", "", "setTaskLoading", "taskLoading", "Companion", "SortBy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppContract.kt */
    public static abstract class Presenter extends AsyncListPresenter<List<? extends MobileApp>> {
        public static final Companion Companion = new Companion(null);
        public static final int SORT_BY_APP_SIZE = 3;
        public static final int SORT_BY_INSTALL_TIME = 1;
        public static final int SORT_BY_NAME = 0;
        public static final int SORT_BY_PACKAGE_NAME = 4;
        public static final int SORT_BY_UPDATE_TIME = 2;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter$SortBy;", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        /* compiled from: MobileAppContract.kt */
        public @interface SortBy {
        }

        public abstract boolean isShowSystem();

        public abstract boolean isTaskLoading();

        public abstract void setShowSystem(boolean z);

        public abstract void setSortBy(int i);

        public abstract void setTaskLoading(boolean z);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Presenter(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter$Companion;", "", "()V", "SORT_BY_APP_SIZE", "", "SORT_BY_INSTALL_TIME", "SORT_BY_NAME", "SORT_BY_PACKAGE_NAME", "SORT_BY_UPDATE_TIME", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: MobileAppContract.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
