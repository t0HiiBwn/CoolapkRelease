package com.coolapk.market.view.video;

import android.app.ProgressDialog;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPriorityHelper;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/view/video/UserKeyInputFragment$checkInputKeyAndType$1", "Lcom/coolapk/market/app/EmptySubscriber;", "", "onError", "", "e", "", "onNext", "t", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserKeyInputFragment.kt */
public final class UserKeyInputFragment$checkInputKeyAndType$1 extends EmptySubscriber<String> {
    final /* synthetic */ String $key;
    final /* synthetic */ ProgressDialog $pDialog;
    final /* synthetic */ String $type;
    final /* synthetic */ UserKeyInputFragment this$0;

    UserKeyInputFragment$checkInputKeyAndType$1(UserKeyInputFragment userKeyInputFragment, ProgressDialog progressDialog, String str, String str2) {
        this.this$0 = userKeyInputFragment;
        this.$pDialog = progressDialog;
        this.$type = str;
        this.$key = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b9, code lost:
        if (kotlin.text.StringsKt.equals(r10, r1, true) == false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00e5  */
    public void onNext(String str) {
        super.onNext((UserKeyInputFragment$checkInputKeyAndType$1) str);
        this.$pDialog.dismiss();
        String str2 = this.$type;
        if (str2.hashCode() == -1796610084 && str2.equals("shareVideo")) {
            UserPriorityHelper userPriorityHelper = UserPriorityHelper.INSTANCE;
            String str3 = this.$key;
            String str4 = this.$type;
            boolean z = true;
            if (str4.hashCode() == -1796610084 && str4.equals("shareVideo")) {
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
                String md5 = StringUtils.toMd5(str4 + (intValue + 14301));
                Intrinsics.checkNotNullExpressionValue(md5, "StringUtils.toMd5(type + (uidInt + 14301))");
                Objects.requireNonNull(md5, "null cannot be cast to non-null type java.lang.String");
                String substring = md5.substring(5, 11);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String md52 = StringUtils.toMd5(str4 + 111401);
                Intrinsics.checkNotNullExpressionValue(md52, "StringUtils.toMd5(type + (97100 + 14301))");
                Objects.requireNonNull(md52, "null cannot be cast to non-null type java.lang.String");
                String substring2 = md52.substring(5, 11);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (!StringsKt.equals(str3, substring, true)) {
                }
                if (!z) {
                    Toast.show$default(this.this$0.getActivity(), "验证通过，现在可以使用新功能哟", 0, false, 12, null);
                    UserPriorityHelper.INSTANCE.saveKeyByType(this.$key, this.$type);
                    this.this$0.requireActivity().finish();
                    return;
                }
                Toast.show$default(this.this$0.getActivity(), "验证失败", 0, false, 12, null);
                return;
            }
            z = false;
            if (!z) {
            }
        } else {
            Toast.show$default(this.this$0.getActivity(), "验证失败，当前版本不支持该功能", 0, false, 12, null);
        }
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.$pDialog.dismiss();
        Toast.show$default(this.this$0.getActivity(), "网络错误", 0, false, 12, null);
    }
}
