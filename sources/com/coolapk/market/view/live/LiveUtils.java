package com.coolapk.market.view.live;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Live;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u000b*\u00020\u0011H\u0002J\u0014\u0010\u0015\u001a\u00020\u000b*\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/live/LiveUtils;", "", "()V", "isDarkTheme", "", "()Z", "isTestMultiDanmaku", "currentUserIsPresenter", "live", "Lcom/coolapk/market/model/Live;", "getMessageBackgroundColor", "", "getPresenterMessageBackgroundColor", "getPresenterSourceBackgroundColor", "getSourceBackgroundColor", "isPresenter", "uid", "", "alpha", "", "colorInt", "orLight", "lightThemeColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveUtils.kt */
public final class LiveUtils {
    public static final LiveUtils INSTANCE = new LiveUtils();

    public final boolean isTestMultiDanmaku() {
        return false;
    }

    private LiveUtils() {
    }

    private final boolean isDarkTheme() {
        return AppHolder.getAppTheme().isDarkTheme();
    }

    private final int colorInt(String str) {
        return Color.parseColor(str);
    }

    private final int alpha(int i, float f) {
        return ColorUtils.setAlphaComponent(i, (int) f);
    }

    private final int orLight(String str, String str2) {
        return isDarkTheme() ? colorInt(str) : colorInt(str2);
    }

    public final int getMessageBackgroundColor() {
        return AppHolder.getAppTheme().getContentBackgroundColor();
    }

    public final int getSourceBackgroundColor() {
        return orLight("#424242", "#f0f0f0");
    }

    public final int getPresenterMessageBackgroundColor() {
        return alpha(AppHolder.getAppTheme().getColorAccent(), 25.5f);
    }

    public final int getPresenterSourceBackgroundColor() {
        return alpha(AppHolder.getAppTheme().getColorAccent(), ((float) 255) * (isDarkTheme() ? 0.25f : 0.15f));
    }

    public final boolean currentUserIsPresenter(Live live) {
        Intrinsics.checkNotNullParameter(live, "live");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        String uid = loginSession.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "DataManager.getInstance().loginSession.uid");
        return isPresenter(live, uid);
    }

    public final boolean isPresenter(Live live, String str) {
        Intrinsics.checkNotNullParameter(live, "live");
        Intrinsics.checkNotNullParameter(str, "uid");
        for (String str2 : live.getPresenterUidList()) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }
}
