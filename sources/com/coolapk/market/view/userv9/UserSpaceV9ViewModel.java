package com.coolapk.market.view.userv9;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u0004H\u0007J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\"\u001a\u00020\nH\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001aR*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR*\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "Landroidx/databinding/BaseObservable;", "()V", "value", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "", "follow", "getFollow", "()Z", "setFollow", "(Z)V", "ignoreFollowingNotify", "isBlackList", "setBlackList", "<set-?>", "isLoginUser", "loading", "getLoading", "setLoading", "mutualConcern", "getMutualConcern", "Lcom/coolapk/market/model/UserProfile;", "userProfile", "getUserProfile", "()Lcom/coolapk/market/model/UserProfile;", "setUserProfile", "(Lcom/coolapk/market/model/UserProfile;)V", "getUserAvatar", "getUserVerifyStatusIcon", "isShowContent", "notifyPropertyChanged", "", "fieldId", "", "replaceModelSilently", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9Presenter.kt */
public final class UserSpaceV9ViewModel extends BaseObservable {
    @Bindable
    private String errorMessage;
    @Bindable
    private boolean follow;
    private boolean ignoreFollowingNotify;
    @Bindable
    private boolean isBlackList;
    private boolean isLoginUser;
    @Bindable
    private boolean loading;
    @Bindable
    private UserProfile userProfile;

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4, r2 != null ? r2.getUid() : null) != false) goto L_0x004e;
     */
    public final void setUserProfile(UserProfile userProfile2) {
        this.userProfile = userProfile2;
        boolean z = true;
        setFollow(userProfile2 != null && userProfile2.getIsFollow() > 0);
        setBlackList(userProfile2 != null && userProfile2.getIsInBlackList() == 1);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isLogin()) {
            String uid = loginSession.getUid();
            UserProfile userProfile3 = this.userProfile;
        }
        z = false;
        this.isLoginUser = z;
        notifyPropertyChanged(247);
        notifyPropertyChanged(294);
        notifyPropertyChanged(299);
        notifyPropertyChanged(300);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
        notifyPropertyChanged(99);
        notifyPropertyChanged(247);
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
        notifyPropertyChanged(187);
    }

    public final boolean getFollow() {
        return this.follow;
    }

    public final void setFollow(boolean z) {
        this.follow = z;
        notifyPropertyChanged(116);
    }

    public final boolean isBlackList() {
        return this.isBlackList;
    }

    public final void setBlackList(boolean z) {
        this.isBlackList = z;
        notifyPropertyChanged(164);
    }

    public final boolean getMutualConcern() {
        UserProfile userProfile2 = this.userProfile;
        if (userProfile2 == null) {
            return false;
        }
        if (!(userProfile2.getIsFans() == 1) || !this.follow) {
            return false;
        }
        return true;
    }

    @Bindable
    public final String getUserAvatar() {
        String userAvatar;
        UserProfile userProfile2 = this.userProfile;
        return (userProfile2 == null || (userAvatar = userProfile2.getUserAvatar()) == null) ? "" : userAvatar;
    }

    @Bindable
    public final String getUserVerifyStatusIcon() {
        UserProfile userProfile2 = this.userProfile;
        if (userProfile2 != null) {
            return userProfile2.getVerifyStatusIcon();
        }
        return null;
    }

    @Bindable
    public final boolean isShowContent() {
        return this.userProfile != null && this.errorMessage == null && !this.loading;
    }

    public final void replaceModelSilently(UserProfile userProfile2) {
        Intrinsics.checkNotNullParameter(userProfile2, "userProfile");
        this.ignoreFollowingNotify = true;
        setUserProfile(userProfile2);
        this.ignoreFollowingNotify = false;
    }

    public final boolean isLoginUser() {
        return this.isLoginUser;
    }

    @Override // androidx.databinding.BaseObservable
    public void notifyPropertyChanged(int i) {
        if (!this.ignoreFollowingNotify) {
            super.notifyPropertyChanged(i);
        }
    }
}
