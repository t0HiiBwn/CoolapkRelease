package com.coolapk.market.view.backupList;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.backupList.BackupMobileAppContract;
import java.text.Collator;
import java.util.List;
import java.util.concurrent.Callable;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class BackupMobileAppPresenter extends BackupMobileAppContract.Presenter {
    private static final String KEY_IS_SHOW_SYSTEM = "IS_SHOW_SYSTEM";
    private final Collator collator = Collator.getInstance();
    private boolean isFirstInit = true;
    private boolean isShowSystem;
    private boolean isTaskLoading;
    private int sortBy = 0;
    private final Object taskLock = this;

    public BackupMobileAppPresenter(BackupMobileAppContract.View view) {
        super(view);
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<MobileApp>> onCreateRequest(boolean z, int i) {
        return Observable.fromCallable(new Callable<List<MobileApp>>() {
            /* class com.coolapk.market.view.backupList.BackupMobileAppPresenter.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public List<MobileApp> call() throws Exception {
                synchronized (BackupMobileAppPresenter.this.taskLock) {
                    while (BackupMobileAppPresenter.this.isTaskLoading) {
                        BackupMobileAppPresenter.this.taskLock.wait();
                    }
                }
                return DataManager.getInstance().getMobileAppExistListFast();
            }
        }).flatMap(new Func1<List<MobileApp>, Observable<MobileApp>>() {
            /* class com.coolapk.market.view.backupList.BackupMobileAppPresenter.AnonymousClass3 */

            public Observable<MobileApp> call(List<MobileApp> list) {
                return Observable.from(list);
            }
        }).filter(new Func1<MobileApp, Boolean>() {
            /* class com.coolapk.market.view.backupList.BackupMobileAppPresenter.AnonymousClass2 */

            public Boolean call(MobileApp mobileApp) {
                return Boolean.valueOf(!mobileApp.isSystemApp() || BackupMobileAppPresenter.this.isShowSystem());
            }
        }).toSortedList(new Func2<MobileApp, MobileApp, Integer>() {
            /* class com.coolapk.market.view.backupList.BackupMobileAppPresenter.AnonymousClass1 */

            public Integer call(MobileApp mobileApp, MobileApp mobileApp2) {
                int i;
                int i2 = BackupMobileAppPresenter.this.sortBy;
                if (i2 == 0) {
                    i = BackupMobileAppPresenter.this.collator.compare(mobileApp.getAppName().trim(), mobileApp2.getAppName().trim());
                } else if (i2 == 1) {
                    i = Long.signum(mobileApp2.getFirstInstallTime() - mobileApp.getFirstInstallTime());
                } else if (i2 != 2) {
                    i = i2 != 3 ? 0 : Long.signum(mobileApp2.getApkLength() - mobileApp.getApkLength());
                } else {
                    i = Long.signum(mobileApp2.getLastUpdateTime() - mobileApp.getLastUpdateTime());
                }
                if (i == 0) {
                    i = mobileApp.getPackageName().compareTo(mobileApp2.getPackageName());
                }
                return Integer.valueOf(i);
            }
        });
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
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("IS_SHOW_SYSTEM", this.isShowSystem);
    }

    @Override // com.coolapk.market.view.backupList.BackupMobileAppContract.Presenter
    public boolean isShowSystem() {
        return this.isShowSystem;
    }

    @Override // com.coolapk.market.view.backupList.BackupMobileAppContract.Presenter
    public void setShowSystem(boolean z) {
        this.isShowSystem = z;
    }

    @Override // com.coolapk.market.view.backupList.BackupMobileAppContract.Presenter
    public void setSortBy(int i) {
        this.sortBy = i;
    }

    @Override // com.coolapk.market.view.backupList.BackupMobileAppContract.Presenter
    public void setTaskLoading(boolean z) {
        synchronized (this.taskLock) {
            this.isTaskLoading = z;
            this.taskLock.notifyAll();
        }
    }

    @Override // com.coolapk.market.view.backupList.BackupMobileAppContract.Presenter
    public boolean isTaskLoading() {
        return this.isTaskLoading;
    }
}
