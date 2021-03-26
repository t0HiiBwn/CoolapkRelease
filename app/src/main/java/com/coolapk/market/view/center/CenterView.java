package com.coolapk.market.view.center;

import com.coolapk.market.model.UserProfile;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/center/CenterView;", "", "onRequestReloadUserProfile", "", "onUserProfileUpdate", "profile", "Lcom/coolapk/market/model/UserProfile;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterViewModel.kt */
public interface CenterView {
    void onRequestReloadUserProfile();

    void onUserProfileUpdate(UserProfile userProfile);
}
