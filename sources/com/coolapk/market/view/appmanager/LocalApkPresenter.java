package com.coolapk.market.view.appmanager;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.coolapk.market.model.LocalApk;
import com.coolapk.market.util.LocalApkUtils;
import com.coolapk.market.view.appmanager.LocalApkContract;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AbstractFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;

public class LocalApkPresenter extends LocalApkContract.Presenter {
    private final Activity context;
    private boolean isStop;
    private final PackageManager packageManager;

    public LocalApkPresenter(LocalApkContract.View view, Activity activity) {
        super(view);
        this.context = activity;
        this.packageManager = activity.getPackageManager();
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<LocalApk>> onCreateRequest(boolean z, int i) {
        return loadApk();
    }

    private Observable<List<LocalApk>> loadApk() {
        this.isStop = false;
        return Observable.create(new Observable.OnSubscribe<List<LocalApk>>() {
            /* class com.coolapk.market.view.appmanager.LocalApkPresenter.AnonymousClass2 */

            public void call(Subscriber<? super List<LocalApk>> subscriber) {
                ArrayList arrayList = new ArrayList();
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    if (!externalStorageDirectory.canRead()) {
                        subscriber.onNext(arrayList);
                        subscriber.onCompleted();
                        return;
                    }
                    Collection<File> listFiles = FileUtils.listFiles(externalStorageDirectory, FileFilterUtils.suffixFileFilter("apk"), FileFilterUtils.and(new AbstractFileFilter() {
                        /* class com.coolapk.market.view.appmanager.LocalApkPresenter.AnonymousClass2.AnonymousClass1 */

                        @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
                        public boolean accept(File file) {
                            return !LocalApkPresenter.this.isStop;
                        }
                    }, FileFilterUtils.notFileFilter(FileFilterUtils.prefixFileFilter(".")), SpecialFileFilter.newInstance(externalStorageDirectory)));
                    if (!listFiles.isEmpty()) {
                        for (File file : listFiles) {
                            PackageInfo packageArchiveInfo = LocalApkPresenter.this.packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 0);
                            if (packageArchiveInfo != null) {
                                packageArchiveInfo.applicationInfo.sourceDir = file.getAbsolutePath();
                                packageArchiveInfo.applicationInfo.publicSourceDir = file.getAbsolutePath();
                                LocalApk app = LocalApkUtils.getApp(LocalApkPresenter.this.packageManager, packageArchiveInfo);
                                if (app != null) {
                                    arrayList.add(app);
                                }
                            }
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<LocalApk>() {
                    /* class com.coolapk.market.view.appmanager.LocalApkPresenter.AnonymousClass2.AnonymousClass2 */

                    public int compare(LocalApk localApk, LocalApk localApk2) {
                        return Long.signum(localApk2.getLastUpdateTime() - localApk.getLastUpdateTime());
                    }
                });
                subscriber.onNext(arrayList);
                subscriber.onCompleted();
            }
        }).doOnUnsubscribe(new Action0() {
            /* class com.coolapk.market.view.appmanager.LocalApkPresenter.AnonymousClass1 */

            @Override // rx.functions.Action0
            public void call() {
                LocalApkPresenter.this.isStop = true;
            }
        });
    }

    public static class SpecialFileFilter extends AbstractFileFilter {
        private static final String TENCENT_MICRO_MSG = "/tencent/MicroMsg";
        private static final String TENCENT_MOBILEQQ_DISKCACHE = "/tencent/MobileQQ/diskcache";
        private static final String TENCENT_MSFLOGS = "/tencent/msflogs";
        private static final String TENCENT_TASSISTANT_THUMBNAILCACHE = "/tencent/tassistant/ThumbnailCache";
        private int mStartIndex;

        public SpecialFileFilter(File file) {
            this.mStartIndex = file.getPath().length();
        }

        public static SpecialFileFilter newInstance(File file) {
            return new SpecialFileFilter(file);
        }

        @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
        public boolean accept(File file) {
            return !file.getPath().startsWith("/tencent/MicroMsg", this.mStartIndex) && !file.getPath().startsWith("/tencent/tassistant/ThumbnailCache", this.mStartIndex) && !file.getPath().startsWith("/tencent/msflogs", this.mStartIndex) && !file.getPath().startsWith("/tencent/MobileQQ/diskcache", this.mStartIndex) && !file.getName().equalsIgnoreCase("cache");
        }
    }
}
