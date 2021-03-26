package com.coolapk.market.view.center;

import android.os.Bundle;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.base.BasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u000eR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/center/CenterPresenter;", "Lcom/coolapk/market/view/base/BasePresenter;", "view", "Lcom/coolapk/market/view/center/CenterView;", "(Lcom/coolapk/market/view/center/CenterView;)V", "<set-?>", "", "forceReload", "getForceReload", "()Z", "menuPresenter", "Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "getMenuPresenter", "()Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "Lcom/coolapk/market/model/UserProfile;", "userProfile", "getUserProfile", "()Lcom/coolapk/market/model/UserProfile;", "getView", "()Lcom/coolapk/market/view/center/CenterView;", "markForceReload", "", "onInitPresenterState", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "requestForceReloadUserProfile", "requestReloadUserProfile", "requestUpdateProfile", "profile", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterViewModel.kt */
public final class CenterPresenter implements BasePresenter {
    private boolean forceReload;
    private final CenterUserMenuPresenter menuPresenter = CenterUserMenuPresenter.Companion.getInstance();
    private UserProfile userProfile;
    private final CenterView view;

    public CenterPresenter(CenterView centerView) {
        Intrinsics.checkNotNullParameter(centerView, "view");
        this.view = centerView;
    }

    public final CenterView getView() {
        return this.view;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public final boolean getForceReload() {
        return this.forceReload;
    }

    public final CenterUserMenuPresenter getMenuPresenter() {
        return this.menuPresenter;
    }

    public final void requestUpdateProfile(UserProfile userProfile2) {
        Intrinsics.checkNotNullParameter(userProfile2, "profile");
        this.userProfile = userProfile2;
        this.menuPresenter.setUserProfile(userProfile2);
        this.view.onUserProfileUpdate(userProfile2);
    }

    public final void requestReloadUserProfile() {
        this.view.onRequestReloadUserProfile();
    }

    public final void requestForceReloadUserProfile() {
        this.forceReload = true;
    }

    public final void markForceReload() {
        this.forceReload = false;
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onInitPresenterState(Bundle bundle) {
        if (bundle != null) {
            this.userProfile = (UserProfile) bundle.getParcelable("userProfile");
        }
    }

    @Override // com.coolapk.market.view.base.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putParcelable("userProfile", this.userProfile);
    }
}
