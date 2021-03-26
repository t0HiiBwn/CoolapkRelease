package com.coolapk.market.view.center;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001an\u00120\b\u0001\u0012,\u0012\u0004\u0012\u00020\u0003 \u0005*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004 \u0005*6\u00120\b\u0001\u0012,\u0012\u0004\u0012\u00020\u0003 \u0005*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0018\u00010\u00010\u000120\u0010\u0006\u001a,\u0012\u0004\u0012\u00020\u0003 \u0005*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lrx/Observable;", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "array", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
final class CenterV9Fragment$onCreateRequest$4<T, R> implements Func1<ArrayList<Entity>, Observable<? extends ArrayList<Entity>>> {
    final /* synthetic */ CenterV9Fragment this$0;

    CenterV9Fragment$onCreateRequest$4(CenterV9Fragment centerV9Fragment) {
        this.this$0 = centerV9Fragment;
    }

    public final Observable<? extends ArrayList<Entity>> call(final ArrayList<Entity> arrayList) {
        final CenterUserMenuPresenter menuPresenter = this.this$0.centerPresenter.getMenuPresenter();
        if (menuPresenter.getLastLoadedActivityMenuData().length() == 0) {
            return menuPresenter.loadMenuDataInServe().compose(RxUtils.apiCommonToData()).flatMap(new Func1<String, Observable<? extends ArrayList<Entity>>>() {
                /* class com.coolapk.market.view.center.CenterV9Fragment$onCreateRequest$4.AnonymousClass1 */

                public final Observable<? extends ArrayList<Entity>> call(String str) {
                    CenterUserMenuPresenter centerUserMenuPresenter = menuPresenter;
                    Intrinsics.checkNotNullExpressionValue(str, "it");
                    centerUserMenuPresenter.setLastLoadedActivityMenuData(str);
                    return Observable.just(arrayList);
                }
            }).onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<Entity>>>() {
                /* class com.coolapk.market.view.center.CenterV9Fragment$onCreateRequest$4.AnonymousClass2 */

                public final Observable<? extends ArrayList<Entity>> call(Throwable th) {
                    Toast.error(AppHolder.getApplication(), th);
                    return Observable.just(arrayList);
                }
            });
        }
        return Observable.just(arrayList);
    }
}
