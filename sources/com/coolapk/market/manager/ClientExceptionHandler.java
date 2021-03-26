package com.coolapk.market.manager;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.network.ClientException;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.view.feedv8.MessageStatusHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/manager/ClientExceptionHandler;", "", "()V", "lastHandleErrorHashCode", "", "getValidActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "handleException", "", "e", "Lcom/coolapk/market/network/ClientException;", "showBindMobileDialog", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ClientExceptionHandler.kt */
public final class ClientExceptionHandler {
    public static final ClientExceptionHandler INSTANCE = new ClientExceptionHandler();
    private static int lastHandleErrorHashCode;

    private ClientExceptionHandler() {
    }

    @JvmStatic
    public static final boolean handleException(Context context, ClientException clientException) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(clientException, "e");
        ClientExceptionHandler clientExceptionHandler = INSTANCE;
        Activity validActivity = clientExceptionHandler.getValidActivity(context);
        if (validActivity != null) {
            String message = clientException.getMessage();
            String str = "";
            if (message == null) {
                message = str;
            }
            boolean z = true;
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) "绑定手机号", false, 2, (Object) null)) {
                clientExceptionHandler.showBindMobileDialog(validActivity, clientException);
                return true;
            } else if (clientException.hashCode() == lastHandleErrorHashCode) {
                return false;
            } else {
                lastHandleErrorHashCode = clientException.hashCode();
                String forwardUrl = clientException.getForwardUrl();
                if (!(forwardUrl == null || forwardUrl.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    ActionManagerCompat.startActivityByUrl(validActivity, clientException.getForwardUrl(), null, null);
                }
                MessageStatusHelper.Companion companion = MessageStatusHelper.Companion;
                String messageStatus = clientException.getMessageStatus();
                if (messageStatus == null) {
                    messageStatus = str;
                }
                if (companion.needShowVerifyDialog(messageStatus)) {
                    MessageStatusHelper messageStatusHelper = new MessageStatusHelper(validActivity, null, 2, null);
                    String messageStatus2 = clientException.getMessageStatus();
                    if (messageStatus2 == null) {
                        messageStatus2 = str;
                    }
                    String message2 = clientException.getMessage();
                    if (message2 != null) {
                        str = message2;
                    }
                    messageStatusHelper.handleMessageStatus(messageStatus2, str, clientException.getMessageExtra());
                }
            }
        }
        return false;
    }

    private final void showBindMobileDialog(Context context, ClientException clientException) {
        SimpleDialog newInstance = SimpleDialog.newInstance();
        newInstance.setMessage(clientException.getMessage());
        newInstance.setNegativeButton(2131886768);
        newInstance.setPositiveButton(2131887073, new ClientExceptionHandler$showBindMobileDialog$1(context));
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    private final Activity getValidActivity(Context context) {
        Activity activityNullable = UiUtils.getActivityNullable(context);
        return (activityNullable == null || activityNullable.isFinishing()) ? AppHolder.getCurrentActivity() : activityNullable;
    }
}
