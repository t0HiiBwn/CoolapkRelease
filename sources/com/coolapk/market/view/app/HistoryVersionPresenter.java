package com.coolapk.market.view.app;

import android.text.format.Time;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.VersionApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.app.HistoryVersionContract;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class HistoryVersionPresenter extends HistoryVersionContract.Presenter {
    private final String apkId;

    public HistoryVersionPresenter(HistoryVersionContract.View view, String str) {
        super(view);
        this.apkId = str;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<List<VersionApp>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getHistoryAppList(this.apkId).map(RxUtils.checkResultToData()).flatMap(new Func1<List<VersionApp>, Observable<VersionApp>>() {
            /* class com.coolapk.market.view.app.HistoryVersionPresenter.AnonymousClass2 */

            public Observable<VersionApp> call(List<VersionApp> list) {
                return Observable.from(list);
            }
        }).toSortedList(new Func2<VersionApp, VersionApp, Integer>() {
            /* class com.coolapk.market.view.app.HistoryVersionPresenter.AnonymousClass1 */

            public Integer call(VersionApp versionApp, VersionApp versionApp2) {
                Time time = new Time();
                time.parse3339(versionApp.getVersionDate());
                Time time2 = new Time();
                time2.parse3339(versionApp2.getVersionDate());
                return Integer.valueOf(-Time.compare(time, time2));
            }
        });
    }
}
