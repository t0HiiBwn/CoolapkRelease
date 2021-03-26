package com.coolapk.market.manager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.view.AppLinkActivity;
import com.tencent.android.tpush.XGPushShowedResult;
import com.tencent.android.tpush.XGPushTextMessage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\""}, d2 = {"Lcom/coolapk/market/manager/PushMessage;", "", "type", "", "content", "messageTitle", "messageContnet", "messageUrl", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)V", "getContent", "()Ljava/lang/String;", "getMessageContnet", "getMessageTitle", "getMessageUrl", "()Landroid/net/Uri;", "getType", "buildUriIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PushMessage.kt */
public final class PushMessage {
    public static final Companion Companion = new Companion(null);
    private static final PushMessage EMPTY_MESSAGE = new PushMessage("NONE", "", "", "", null);
    private static final String KEY_NOTIFY_TYPE = "notifyType";
    private final String content;
    private final String messageContnet;
    private final String messageTitle;
    private final Uri messageUrl;
    private final String type;

    public static /* synthetic */ PushMessage copy$default(PushMessage pushMessage, String str, String str2, String str3, String str4, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = pushMessage.content;
        }
        if ((i & 4) != 0) {
            str3 = pushMessage.messageTitle;
        }
        if ((i & 8) != 0) {
            str4 = pushMessage.messageContnet;
        }
        if ((i & 16) != 0) {
            uri = pushMessage.messageUrl;
        }
        return pushMessage.copy(str, str2, str3, str4, uri);
    }

    @JvmStatic
    public static final PushMessage fromPushMessage(XGPushShowedResult xGPushShowedResult) {
        return Companion.fromPushMessage(xGPushShowedResult);
    }

    @JvmStatic
    public static final PushMessage fromPushMessage(XGPushTextMessage xGPushTextMessage) {
        return Companion.fromPushMessage(xGPushTextMessage);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.messageTitle;
    }

    public final String component4() {
        return this.messageContnet;
    }

    public final Uri component5() {
        return this.messageUrl;
    }

    public final PushMessage copy(String str, String str2, String str3, String str4, Uri uri) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "messageTitle");
        Intrinsics.checkNotNullParameter(str4, "messageContnet");
        return new PushMessage(str, str2, str3, str4, uri);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushMessage)) {
            return false;
        }
        PushMessage pushMessage = (PushMessage) obj;
        return Intrinsics.areEqual(this.type, pushMessage.type) && Intrinsics.areEqual(this.content, pushMessage.content) && Intrinsics.areEqual(this.messageTitle, pushMessage.messageTitle) && Intrinsics.areEqual(this.messageContnet, pushMessage.messageContnet) && Intrinsics.areEqual(this.messageUrl, pushMessage.messageUrl);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.messageTitle;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.messageContnet;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Uri uri = this.messageUrl;
        if (uri != null) {
            i = uri.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PushMessage(type=" + this.type + ", content=" + this.content + ", messageTitle=" + this.messageTitle + ", messageContnet=" + this.messageContnet + ", messageUrl=" + this.messageUrl + ")";
    }

    public PushMessage(String str, String str2, String str3, String str4, Uri uri) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "messageTitle");
        Intrinsics.checkNotNullParameter(str4, "messageContnet");
        this.type = str;
        this.content = str2;
        this.messageTitle = str3;
        this.messageContnet = str4;
        this.messageUrl = uri;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getMessageContnet() {
        return this.messageContnet;
    }

    public final String getMessageTitle() {
        return this.messageTitle;
    }

    public final Uri getMessageUrl() {
        return this.messageUrl;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/manager/PushMessage$Companion;", "", "()V", "EMPTY_MESSAGE", "Lcom/coolapk/market/manager/PushMessage;", "getEMPTY_MESSAGE", "()Lcom/coolapk/market/manager/PushMessage;", "KEY_NOTIFY_TYPE", "", "fromPushMessage", "message", "Lcom/tencent/android/tpush/XGPushShowedResult;", "Lcom/tencent/android/tpush/XGPushTextMessage;", "safeConvertXGPushShowedResultUri", "Landroid/net/Uri;", "source", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PushMessage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PushMessage getEMPTY_MESSAGE() {
            return PushMessage.EMPTY_MESSAGE;
        }

        @JvmStatic
        public final PushMessage fromPushMessage(XGPushTextMessage xGPushTextMessage) {
            Intrinsics.checkNotNullParameter(xGPushTextMessage, "message");
            String content = xGPushTextMessage.getContent();
            JSONObject convertToJson = content != null ? KotlinExtendKt.convertToJson(content) : null;
            if (convertToJson == null || !convertToJson.has("notifyType")) {
                return getEMPTY_MESSAGE();
            }
            String string = convertToJson.getString("notifyType");
            convertToJson.remove("notifyType");
            Intrinsics.checkNotNullExpressionValue(string, "type");
            String jSONObject = convertToJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObj.toString()");
            String title = xGPushTextMessage.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "message.title");
            String content2 = xGPushTextMessage.getContent();
            Intrinsics.checkNotNullExpressionValue(content2, "message.content");
            return new PushMessage(string, jSONObject, title, content2, null);
        }

        @JvmStatic
        public final PushMessage fromPushMessage(XGPushShowedResult xGPushShowedResult) {
            Intrinsics.checkNotNullParameter(xGPushShowedResult, "message");
            String customContent = xGPushShowedResult.getCustomContent();
            JSONObject convertToJson = customContent != null ? KotlinExtendKt.convertToJson(customContent) : null;
            if (convertToJson == null || !convertToJson.has("notifyType")) {
                return getEMPTY_MESSAGE();
            }
            String string = convertToJson.getString("notifyType");
            convertToJson.remove("notifyType");
            Intrinsics.checkNotNullExpressionValue(string, "type");
            String jSONObject = convertToJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObj.toString()");
            String title = xGPushShowedResult.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "message.title");
            String content = xGPushShowedResult.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "message.content");
            return new PushMessage(string, jSONObject, title, content, safeConvertXGPushShowedResultUri(xGPushShowedResult));
        }

        private final Uri safeConvertXGPushShowedResultUri(XGPushShowedResult xGPushShowedResult) {
            try {
                Uri parse = Uri.parse(xGPushShowedResult.getActivity());
                Intrinsics.checkNotNullExpressionValue(parse, "it");
                String path = parse.getPath();
                if (!(!(path == null || path.length() == 0))) {
                    parse = null;
                }
                if (parse != null) {
                    return parse;
                }
                return null;
            } catch (Exception unused) {
            }
        }
    }

    public final Intent buildUriIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.messageUrl == null) {
            return null;
        }
        Intent intent = new Intent(context, AppLinkActivity.class);
        intent.setData(this.messageUrl);
        intent.setFlags(268435456);
        return intent;
    }
}
