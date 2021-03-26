package com.coolapk.market.view.user.profile;

import android.util.Pair;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012F\u0010\u0003\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Landroid/util/Pair;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: UserCoverPresenter.kt */
final class UserCoverPresenter$checkAndUpload$1<T, R> implements Func1<Pair<String, String>, String> {
    public static final UserCoverPresenter$checkAndUpload$1 INSTANCE = new UserCoverPresenter$checkAndUpload$1();

    UserCoverPresenter$checkAndUpload$1() {
    }

    public final String call(Pair<String, String> pair) {
        return (String) pair.second;
    }
}
