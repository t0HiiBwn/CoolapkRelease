package com.coolapk.market.view.feedv8;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feedv8/MessageStatusHelper;", "", "activity", "Landroid/app/Activity;", "verifySucceedCallback", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "handleMessageStatus", "messageStatus", "", "message", "messageExtra", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MessageStatusHelper.kt */
public final class MessageStatusHelper {
    public static final Companion Companion = new Companion(null);
    private final Activity activity;
    private final Function0<Unit> verifySucceedCallback;

    public MessageStatusHelper(Activity activity2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
        this.verifySucceedCallback = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageStatusHelper(Activity activity2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, (i & 2) != 0 ? null : function0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/MessageStatusHelper$Companion;", "", "()V", "needShowVerifyDialog", "", "messageStatus", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MessageStatusHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean needShowVerifyDialog(String str) {
            Intrinsics.checkNotNullParameter(str, "messageStatus");
            int hashCode = str.hashCode();
            if (hashCode != -1846832656) {
                if (hashCode != -730613140 || !str.equals("err_request_mobile")) {
                    return false;
                }
            } else if (!str.equals("err_request_captcha")) {
                return false;
            }
            if (AppHolder.getCurrentActivity() != null) {
                return true;
            }
            return false;
        }
    }

    public final void handleMessageStatus(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "messageStatus");
        Intrinsics.checkNotNullParameter(str2, "message");
        int hashCode = str.hashCode();
        if (hashCode != -1846832656) {
            if (hashCode == -730613140 && str.equals("err_request_mobile")) {
                MobileCodeVerifyDialog newInstance = MobileCodeVerifyDialog.Companion.newInstance(str2, str3, this.verifySucceedCallback);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
            }
        } else if (str.equals("err_request_captcha")) {
            CaptchaVerifyDialog newInstance2 = CaptchaVerifyDialog.Companion.newInstance(str2, this.verifySucceedCallback);
            FragmentManager supportFragmentManager2 = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "activity.requireAppCompa…().supportFragmentManager");
            newInstance2.show(supportFragmentManager2, (String) null);
        }
    }
}
