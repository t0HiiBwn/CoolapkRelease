package com.coolapk.market.view.userv9;

import android.content.Context;
import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BasePresenter;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.ToastKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014J\u0012\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020 H\u0016J\u0006\u0010#\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9Presenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "context", "Landroid/content/Context;", "view", "Lcom/coolapk/market/view/userv9/UserSpaceView;", "viewModel", "Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "(Landroid/content/Context;Lcom/coolapk/market/view/userv9/UserSpaceView;Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;)V", "getContext", "()Landroid/content/Context;", "isRequesting", "", "subscription", "Lrx/Subscription;", "getView", "()Lcom/coolapk/market/view/userv9/UserSpaceView;", "getViewModel", "()Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "internalOnLoadError", "", "e", "", "internalOnUserProfiledLoad", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "loadUserProfile", "uid", "", "onDestroy", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "requestChangeFollowState", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
public final class UserSpaceV9Presenter implements BasePresenter {
    private final Context context;
    private boolean isRequesting;
    private Subscription subscription;
    private final UserSpaceView view;
    private final UserSpaceV9ViewModel viewModel;

    public UserSpaceV9Presenter(Context context2, UserSpaceView userSpaceView, UserSpaceV9ViewModel userSpaceV9ViewModel) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(userSpaceView, "view");
        Intrinsics.checkNotNullParameter(userSpaceV9ViewModel, "viewModel");
        this.context = context2;
        this.view = userSpaceView;
        this.viewModel = userSpaceV9ViewModel;
    }

    public final Context getContext() {
        return this.context;
    }

    public final UserSpaceView getView() {
        return this.view;
    }

    public final UserSpaceV9ViewModel getViewModel() {
        return this.viewModel;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        UserProfile userProfile = null;
        if (bundle != null) {
            userProfile = (UserProfile) bundle.getParcelable("extra_model");
        }
        if (userProfile != null) {
            internalOnUserProfiledLoad(userProfile);
        }
    }

    public final void requestChangeFollowState() {
        UserProfile userProfile;
        String uid;
        Observable<Result<Integer>> observable;
        if (!this.isRequesting && !this.viewModel.isLoginUser() && (userProfile = this.viewModel.getUserProfile()) != null && (uid = userProfile.getUid()) != null) {
            if (this.viewModel.isBlackList()) {
                DataManager.getInstance().removeFromBlackList(uid).compose(RxUtils.apiCommonToData()).subscribe(new UserSpaceV9Presenter$requestChangeFollowState$1(this), new UserSpaceV9Presenter$requestChangeFollowState$2(this));
                return;
            }
            boolean z = !this.viewModel.getFollow();
            if (z) {
                observable = DataManager.getInstance().followUser(uid);
            } else {
                observable = DataManager.getInstance().unfollowUser(uid);
            }
            observable.compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new UserSpaceV9Presenter$requestChangeFollowState$3(this)).subscribe((Subscriber) new UserSpaceV9Presenter$requestChangeFollowState$4(this, z));
            this.isRequesting = true;
            this.viewModel.setFollow(z);
        }
    }

    public final void loadUserProfile(String str) {
        Intrinsics.checkNotNullParameter(str, "uid");
        UserSpaceV9Presenter userSpaceV9Presenter = this;
        this.subscription = DataManager.getInstance().getUserSpaceProfile(str).compose(RxUtils.apiCommonToData()).subscribe(new UserSpaceV9Presenter$sam$rx_functions_Action1$0(new UserSpaceV9Presenter$loadUserProfile$1(userSpaceV9Presenter)), new UserSpaceV9Presenter$sam$rx_functions_Action1$0(new UserSpaceV9Presenter$loadUserProfile$2(userSpaceV9Presenter)));
        this.viewModel.setLoading(true);
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        if (this.viewModel.getUserProfile() != null) {
            bundle.putParcelable("extra_model", this.viewModel.getUserProfile());
        }
    }

    /* access modifiers changed from: private */
    public final void internalOnLoadError(Throwable th) {
        this.viewModel.setLoading(false);
        Throwable mayBeCause = ToastKt.getMayBeCause(th);
        if (mayBeCause instanceof ClientException) {
            String message = mayBeCause.getMessage();
            String str = "";
            if (message == null) {
                message = str;
            }
            if (StringsKt.startsWith$default(message, "http", false, 2, (Object) null)) {
                UserSpaceView userSpaceView = this.view;
                String message2 = mayBeCause.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                userSpaceView.onUserProfileLoadedWithUrlResult(str);
                return;
            }
            this.viewModel.setErrorMessage(mayBeCause.getMessage());
            return;
        }
        Toast.error(this.context, mayBeCause);
    }

    /* access modifiers changed from: private */
    public final void internalOnUserProfiledLoad(UserProfile userProfile) {
        this.viewModel.setLoading(false);
        this.viewModel.setUserProfile(userProfile);
        this.view.onUserProfileLoaded();
    }

    public final void onDestroy() {
        RxUtils.unsubscribe(this.subscription);
    }
}
