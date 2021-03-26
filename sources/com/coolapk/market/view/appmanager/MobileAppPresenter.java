package com.coolapk.market.view.appmanager;

import android.os.Bundle;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.appmanager.MobileAppContract;
import java.text.Collator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\rH\u0014J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppPresenter;", "Lcom/coolapk/market/view/appmanager/MobileAppContract$Presenter;", "view", "Lcom/coolapk/market/view/appmanager/MobileAppContract$View;", "(Lcom/coolapk/market/view/appmanager/MobileAppContract$View;)V", "collator", "Ljava/text/Collator;", "kotlin.jvm.PlatformType", "isFirstInit", "", "isShowSystem", "isTaskLoading", "sortBy", "", "taskLock", "Ljava/lang/Object;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/MobileApp;", "isRefresh", "page", "onInitPresenterState", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "setShowSystem", "showSystem", "setSortBy", "setTaskLoading", "taskLoading", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppPresenter.kt */
public final class MobileAppPresenter extends MobileAppContract.Presenter {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_IS_SHOW_SYSTEM = "IS_SHOW_SYSTEM";
    private final Collator collator = Collator.getInstance();
    private boolean isFirstInit = true;
    private boolean isShowSystem;
    private boolean isTaskLoading;
    private int sortBy = 2;
    private final Object taskLock = new Object();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileAppPresenter(MobileAppContract.View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* Return type fixed from 'rx.Observable<java.util.List<com.coolapk.market.model.MobileApp>>' to match base method */
    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<? extends MobileApp>> onCreateRequest(boolean z, int i) {
        Observable<List<? extends MobileApp>> sortedList = Observable.fromCallable(new MobileAppPresenter$onCreateRequest$1(this)).flatMap(MobileAppPresenter$onCreateRequest$2.INSTANCE).filter(new MobileAppPresenter$onCreateRequest$3(this)).toSortedList(new MobileAppPresenter$onCreateRequest$4(this));
        Intrinsics.checkNotNullExpressionValue(sortedList, "Observable.fromCallable …eResult\n                }");
        return sortedList;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        super.onInitPresenterState(bundle);
        if (bundle != null) {
            this.isShowSystem = bundle.getBoolean("IS_SHOW_SYSTEM");
        } else if (this.isFirstInit) {
            this.isShowSystem = false;
        }
        this.isFirstInit = false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("IS_SHOW_SYSTEM", this.isShowSystem);
    }

    @Override // com.coolapk.market.view.appmanager.MobileAppContract.Presenter
    public boolean isShowSystem() {
        return this.isShowSystem;
    }

    @Override // com.coolapk.market.view.appmanager.MobileAppContract.Presenter
    public void setShowSystem(boolean z) {
        this.isShowSystem = z;
    }

    @Override // com.coolapk.market.view.appmanager.MobileAppContract.Presenter
    public void setSortBy(int i) {
        this.sortBy = i;
    }

    @Override // com.coolapk.market.view.appmanager.MobileAppContract.Presenter
    public void setTaskLoading(boolean z) {
        synchronized (this.taskLock) {
            this.isTaskLoading = z;
            this.taskLock.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.coolapk.market.view.appmanager.MobileAppContract.Presenter
    public boolean isTaskLoading() {
        return this.isTaskLoading;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/appmanager/MobileAppPresenter$Companion;", "", "()V", "KEY_IS_SHOW_SYSTEM", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
