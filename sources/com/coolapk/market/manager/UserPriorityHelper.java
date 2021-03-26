package com.coolapk.market.manager;

import com.blankj.utilcode.util.NetworkUtils;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.util.StringUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0005\u001a\u00020\u0006H\bJ\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\bJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/manager/UserPriorityHelper;", "", "()V", "TYPE_SHARE_VIDEO", "", "canUserAddVideo", "", "checkKeyByType", "key", "type", "getKey", "saveKeyByType", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserPriorityHelper.kt */
public final class UserPriorityHelper {
    public static final UserPriorityHelper INSTANCE = new UserPriorityHelper();
    public static final String TYPE_SHARE_VIDEO = "shareVideo";

    private UserPriorityHelper() {
    }

    public final boolean canUserAddVideo() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (loginSession.isAdmin() && NetworkUtils.isConnected()) {
            return true;
        }
        String preferencesString = DataManager.getInstance().getPreferencesString(getKey("shareVideo"), "");
        Intrinsics.checkNotNullExpressionValue(preferencesString, "userVideoKey");
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
        LoginSession loginSession2 = instance2.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "session");
        String uid = loginSession2.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        int intOrNull = StringsKt.toIntOrNull(uid);
        if (intOrNull == null) {
            intOrNull = 0;
        }
        int intValue = intOrNull.intValue();
        String md5 = StringUtils.toMd5("shareVideo" + (intValue + 14301));
        Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(type + (uidInt + 14301))");
        Objects.requireNonNull(md5, "null cannot be cast to non-null type java.lang.String");
        String substring = md5.substring(5, 11);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String md52 = StringUtils.toMd5("shareVideo111401");
        Intrinsics.checkNotNullExpressionValue(md52, "StringUtils.toMd5(type + (97100 + 14301))");
        Objects.requireNonNull(md52, "null cannot be cast to non-null type java.lang.String");
        String substring2 = md52.substring(5, 11);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (StringsKt.equals(preferencesString, substring, true) || StringsKt.equals(preferencesString, substring2, true)) {
            return true;
        }
        return false;
    }

    public final boolean checkKeyByType(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "type");
        if (str2.hashCode() != -1796610084 || !str2.equals("shareVideo")) {
            return false;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        String uid = loginSession.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        int intOrNull = StringsKt.toIntOrNull(uid);
        if (intOrNull == null) {
            intOrNull = 0;
        }
        int intValue = intOrNull.intValue();
        String md5 = StringUtils.toMd5(str2 + (intValue + 14301));
        Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(type + (uidInt + 14301))");
        Objects.requireNonNull(md5, "null cannot be cast to non-null type java.lang.String");
        String substring = md5.substring(5, 11);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String md52 = StringUtils.toMd5(str2 + 111401);
        Intrinsics.checkNotNullExpressionValue(md52, "StringUtils.toMd5(type + (97100 + 14301))");
        Objects.requireNonNull(md52, "null cannot be cast to non-null type java.lang.String");
        String substring2 = md52.substring(5, 11);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (StringsKt.equals(str, substring, true) || StringsKt.equals(str, substring2, true)) {
            return true;
        }
        return false;
    }

    public final void saveKeyByType(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "type");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString(getKey(str2), str).apply();
    }

    public final String getKey(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return str + "Key";
    }
}
