package com.coolapk.market.view.file;

import android.os.Bundle;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.file.FileContractor;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class FilePresenter implements FileContractor.Presenter {
    FileFilter fileFilter = new FileFilter() {
        /* class com.coolapk.market.view.file.FilePresenter.AnonymousClass1 */

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    FileContractor.View view;

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
    }

    public FilePresenter(FileContractor.View view2) {
        this.view = view2;
    }

    @Override // com.coolapk.market.view.file.FileContractor.Presenter
    public void loadFileDir(String str) {
        Observable.just(str).map(new Func1<String, File>() {
            /* class com.coolapk.market.view.file.FilePresenter.AnonymousClass4 */

            public File call(String str) {
                return new File(str);
            }
        }).map(new Func1<File, List<File>>() {
            /* class com.coolapk.market.view.file.FilePresenter.AnonymousClass3 */

            public List<File> call(File file) {
                File[] listFiles;
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles(FilePresenter.this.fileFilter)) == null) {
                    return new ArrayList();
                }
                return Arrays.asList(listFiles);
            }
        }).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new Subscriber<List<File>>() {
            /* class com.coolapk.market.view.file.FilePresenter.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
            }

            public void onNext(List<File> list) {
                FilePresenter.this.view.onLoadSuccess(list);
            }
        });
    }
}
