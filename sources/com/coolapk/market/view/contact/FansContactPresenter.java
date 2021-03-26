package com.coolapk.market.view.contact;

import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.ContactsEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.contact.ContactContract;
import com.coolapk.market.widget.Toast;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;

public class FansContactPresenter extends ContactContract.FansPresenter {
    String uid;
    ContactContract.View view;

    public FansContactPresenter(ContactContract.View view2, String str) {
        super(view2);
        this.uid = str;
        this.view = view2;
    }

    @Override // com.coolapk.market.view.base.asynclist.AsyncListPresenter
    protected Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
        return DataManager.getInstance().getUserFansList(this.uid, i, this.view.findFirstItem(), this.view.findLastItem());
    }

    @Override // com.coolapk.market.view.contact.ContactContract.FansPresenter
    public void followUser(final String str) {
        DataManager.getInstance().followUser(str).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Integer>>() {
            /* class com.coolapk.market.view.contact.FansContactPresenter.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
            }

            public void onNext(Result<Integer> result) {
                super.onNext((AnonymousClass1) result);
                if (result.isSuccess()) {
                    EventBus.getDefault().post(new ContactsEvent(true, str));
                } else {
                    Toast.show(AppHolder.getApplication(), 2131886739);
                }
            }
        });
    }

    @Override // com.coolapk.market.view.contact.ContactContract.FansPresenter
    public void unfollowUser(final String str) {
        DataManager.getInstance().unfollowUser(str).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<Integer>>() {
            /* class com.coolapk.market.view.contact.FansContactPresenter.AnonymousClass2 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
            }

            public void onNext(Result<Integer> result) {
                super.onNext((AnonymousClass2) result);
                if (result.isSuccess()) {
                    EventBus.getDefault().post(new ContactsEvent(false, str));
                } else {
                    Toast.show(AppHolder.getApplication(), 2131886742);
                }
            }
        });
    }

    @Override // com.coolapk.market.view.contact.ContactContract.FansPresenter
    public String getUid() {
        return this.uid;
    }
}
