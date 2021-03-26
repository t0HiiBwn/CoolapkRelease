package com.coolapk.market.manager;

import android.content.Context;
import com.coolapk.market.AppHolder;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.util.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/manager/UserPermissionChecker;", "", "()V", "canCreateNewVote", "", "getCanCreateNewVote", "()Z", "canReadClipBoard", "getCanReadClipBoard", "canUseAdvancedVoteOptions", "getCanUseAdvancedVoteOptions", "isLoginAdmin", "getClipBoardText", "", "context", "Landroid/content/Context;", "getClipBoardUrl", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPermissionChecker.kt */
public final class UserPermissionChecker {
    public static final UserPermissionChecker INSTANCE = new UserPermissionChecker();

    private UserPermissionChecker() {
    }

    public final boolean getCanCreateNewVote() {
        return isLoginAdmin();
    }

    public final boolean getCanUseAdvancedVoteOptions() {
        return isLoginAdmin();
    }

    public final boolean isLoginAdmin() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        return loginSession.isAdmin() && loginSession.isLogin();
    }

    public final boolean getCanReadClipBoard() {
        return AppHolder.getAppSetting().getBooleanPref("read_clipboard");
    }

    public final CharSequence getClipBoardText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!getCanReadClipBoard()) {
            return "";
        }
        CharSequence lastClipBoardText = StringUtils.getLastClipBoardText(context);
        Intrinsics.checkNotNullExpressionValue(lastClipBoardText, "StringUtils.getLastClipBoardText(context)");
        return lastClipBoardText;
    }

    public final String getClipBoardUrl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!getCanReadClipBoard()) {
            return "";
        }
        String lastClipBoardUrlText = StringUtils.getLastClipBoardUrlText(context);
        Intrinsics.checkNotNullExpressionValue(lastClipBoardUrlText, "StringUtils.getLastClipBoardUrlText(context)");
        return lastClipBoardUrlText;
    }
}
