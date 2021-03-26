package com.coolapk.market.view.appmanager;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.appmanager.UpgradeContract;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public class UpgradePresenter extends UpgradeContract.Presenter {
    private static final String KEY_CONTAIN_IGNORE = "CONTAIN_IGNORE";
    private static final String KEY_IGNORE_NUM = "IGNORE_NUM";
    private boolean containIgnore;
    private boolean firstInit = true;
    private int ignoreNum = 0;
    private boolean isTaskLoading;
    private final Object taskLock = this;

    public UpgradePresenter(UpgradeContract.View view) {
        super(view);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        super.onInitPresenterState(bundle);
        if (bundle != null) {
            this.ignoreNum = bundle.getInt("IGNORE_NUM");
            this.containIgnore = bundle.getBoolean("CONTAIN_IGNORE");
        } else if (this.firstInit) {
            this.ignoreNum = 0;
            this.containIgnore = false;
        }
        this.firstInit = false;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter, com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("IGNORE_NUM", this.ignoreNum);
        bundle.putBoolean("CONTAIN_IGNORE", this.containIgnore);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<MobileApp>> onCreateRequest(boolean z, int i) {
        this.ignoreNum = 0;
        return Observable.create(new Observable.OnSubscribe() {
            /* class com.coolapk.market.view.appmanager.$$Lambda$UpgradePresenter$1KpAMIJ3ocZlDHmmYBDUtM6R0k */

            @Override // rx.functions.Action1
            public final void call(Object obj) {
                UpgradePresenter.this.lambda$onCreateRequest$0$UpgradePresenter((Subscriber) obj);
            }
        }).flatMap($$Lambda$M7gyumnwyxUDcGvQPRepc4osISw.INSTANCE).filter(new Func1() {
            /* class com.coolapk.market.view.appmanager.$$Lambda$UpgradePresenter$o0mI_QWuLj7GA_W70OjcUM26zOs */

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return UpgradePresenter.this.lambda$onCreateRequest$1$UpgradePresenter((MobileApp) obj);
            }
        }).toSortedList(new Func2() {
            /* class com.coolapk.market.view.appmanager.$$Lambda$UpgradePresenter$UQ8fH569YWkFUcwA31MbYFjKWzc */

            @Override // rx.functions.Func2
            public final Object call(Object obj, Object obj2) {
                return UpgradePresenter.this.lambda$onCreateRequest$2$UpgradePresenter((MobileApp) obj, (MobileApp) obj2);
            }
        });
    }

    public /* synthetic */ void lambda$onCreateRequest$0$UpgradePresenter(Subscriber subscriber) {
        synchronized (this.taskLock) {
            while (this.isTaskLoading) {
                try {
                    this.taskLock.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        subscriber.onNext(DataManager.getInstance().getMobileAppUpgradeListFast());
        subscriber.onCompleted();
    }

    public /* synthetic */ Boolean lambda$onCreateRequest$1$UpgradePresenter(MobileApp mobileApp) {
        if (mobileApp.getIgnoreInfo() == null || !mobileApp.getIgnoreInfo().isIgnore()) {
            return true;
        }
        this.ignoreNum++;
        return Boolean.valueOf(this.containIgnore);
    }

    public /* synthetic */ Integer lambda$onCreateRequest$2$UpgradePresenter(MobileApp mobileApp, MobileApp mobileApp2) {
        if (mobileApp.getIgnoreInfo() == null || mobileApp2.getIgnoreInfo() != null) {
            if (mobileApp.getIgnoreInfo() != null || mobileApp2.getIgnoreInfo() == null) {
                if (mobileApp.getIgnoreInfo() == null || mobileApp2.getIgnoreInfo() == null) {
                    return Integer.valueOf(sortByUpgradeTime(mobileApp, mobileApp2));
                }
                if (mobileApp.getIgnoreInfo().isIgnore() && !mobileApp2.getIgnoreInfo().isIgnore()) {
                    return 1;
                }
                if (mobileApp.getIgnoreInfo().isIgnore() || !mobileApp2.getIgnoreInfo().isIgnore()) {
                    return Integer.valueOf(sortByUpgradeTime(mobileApp, mobileApp2));
                }
                return -1;
            } else if (!mobileApp2.getIgnoreInfo().isIgnore()) {
                return Integer.valueOf(sortByUpgradeTime(mobileApp, mobileApp2));
            } else {
                return -1;
            }
        } else if (!mobileApp.getIgnoreInfo().isIgnore()) {
            return Integer.valueOf(sortByUpgradeTime(mobileApp, mobileApp2));
        } else {
            return 1;
        }
    }

    private int sortByUpgradeTime(MobileApp mobileApp, MobileApp mobileApp2) {
        if (mobileApp2.getUpgradeInfo() == null || mobileApp.getUpgradeInfo() == null) {
            return Long.signum(mobileApp2.getLastUpdateTime() - mobileApp.getLastUpdateTime());
        }
        return Long.signum(mobileApp2.getUpgradeInfo().getLastUpdate() - mobileApp.getUpgradeInfo().getLastUpdate());
    }

    @Override // com.coolapk.market.view.appmanager.UpgradeContract.Presenter
    public boolean isContainIgnore() {
        return this.containIgnore;
    }

    @Override // com.coolapk.market.view.appmanager.UpgradeContract.Presenter
    public void setContainIgnore(boolean z) {
        this.containIgnore = z;
    }

    @Override // com.coolapk.market.view.appmanager.UpgradeContract.Presenter
    public int getIgnoreNum() {
        return this.ignoreNum;
    }

    @Override // com.coolapk.market.view.appmanager.UpgradeContract.Presenter
    public void setTaskLoading(boolean z) {
        synchronized (this.taskLock) {
            this.isTaskLoading = z;
            this.taskLock.notifyAll();
        }
    }
}
