package com.coolapk.market.manager;

import com.coolapk.market.AppHolder;
import com.coolapk.market.util.KotlinExtendKt;
import com.xiaomi.mipush.sdk.MiPushMessage;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/manager/PushMessage;", "", "type", "", "content", "topic", "shouldShowNotification", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getShouldShowNotification", "()Z", "getTopic", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PushMessage.kt */
public final class PushMessage {
    public static final Companion Companion = new Companion(null);
    private static final PushMessage EMPTY_MESSAGE = new PushMessage("NONE", "", null, false, 12, null);
    private static final String KEY_NOTIFY_TYPE = "notifyType";
    private static final String KEY_TYPE = "notifyType";
    private final String content;
    private final boolean shouldShowNotification;
    private final String topic;
    private final String type;

    public static /* synthetic */ PushMessage copy$default(PushMessage pushMessage, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = pushMessage.content;
        }
        if ((i & 4) != 0) {
            str3 = pushMessage.topic;
        }
        if ((i & 8) != 0) {
            z = pushMessage.shouldShowNotification;
        }
        return pushMessage.copy(str, str2, str3, z);
    }

    @JvmStatic
    public static final PushMessage fromMiPush(MiPushMessage miPushMessage) {
        return Companion.fromMiPush(miPushMessage);
    }

    @JvmStatic
    public static final PushMessage fromOldMiPush(MiPushMessage miPushMessage) {
        return Companion.fromOldMiPush(miPushMessage);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.topic;
    }

    public final boolean component4() {
        return this.shouldShowNotification;
    }

    public final PushMessage copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "content");
        return new PushMessage(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushMessage)) {
            return false;
        }
        PushMessage pushMessage = (PushMessage) obj;
        return Intrinsics.areEqual(this.type, pushMessage.type) && Intrinsics.areEqual(this.content, pushMessage.content) && Intrinsics.areEqual(this.topic, pushMessage.topic) && this.shouldShowNotification == pushMessage.shouldShowNotification;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.topic;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.shouldShowNotification;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public String toString() {
        return "PushMessage(type=" + this.type + ", content=" + this.content + ", topic=" + this.topic + ", shouldShowNotification=" + this.shouldShowNotification + ")";
    }

    public PushMessage(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "content");
        this.type = str;
        this.content = str2;
        this.topic = str3;
        this.shouldShowNotification = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PushMessage(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z);
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getShouldShowNotification() {
        return this.shouldShowNotification;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/manager/PushMessage$Companion;", "", "()V", "EMPTY_MESSAGE", "Lcom/coolapk/market/manager/PushMessage;", "KEY_NOTIFY_TYPE", "", "KEY_TYPE", "fromMiPush", "message", "Lcom/xiaomi/mipush/sdk/MiPushMessage;", "fromOldMiPush", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PushMessage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PushMessage fromMiPush(MiPushMessage miPushMessage) {
            Intrinsics.checkNotNullParameter(miPushMessage, "message");
            String content = miPushMessage.getContent();
            JSONObject convertToJson = content != null ? KotlinExtendKt.convertToJson(content) : null;
            if (convertToJson == null || !convertToJson.has("notifyType")) {
                return PushMessage.EMPTY_MESSAGE;
            }
            String string = convertToJson.getString("notifyType");
            convertToJson.remove("notifyType");
            boolean z = Intrinsics.areEqual(string, "message") && AppHolder.getActivityLifeCycle().isAppForeground();
            Intrinsics.checkNotNullExpressionValue(string, "type");
            String jSONObject = convertToJson.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObj.toString()");
            return new PushMessage(string, jSONObject, miPushMessage.getTopic(), z);
        }

        @JvmStatic
        public final PushMessage fromOldMiPush(MiPushMessage miPushMessage) {
            Intrinsics.checkNotNullParameter(miPushMessage, "message");
            String content = miPushMessage.getContent();
            JSONObject convertToJson = content != null ? KotlinExtendKt.convertToJson(content) : null;
            if (convertToJson == null || !convertToJson.has("notifyType")) {
                String title = miPushMessage.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "message.title");
                String content2 = miPushMessage.getContent();
                Intrinsics.checkNotNullExpressionValue(content2, "message.content");
                return new PushMessage(title, content2, miPushMessage.getTopic(), true);
            }
            String string = convertToJson.getString("notifyType");
            Intrinsics.checkNotNullExpressionValue(string, "type");
            String content3 = miPushMessage.getContent();
            Intrinsics.checkNotNullExpressionValue(content3, "message.content");
            return new PushMessage(string, content3, miPushMessage.getTopic(), true);
        }
    }
}
