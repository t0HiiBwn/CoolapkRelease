package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new Parcelable.Creator<RemoteMessage>() {
        /* class com.huawei.hms.push.RemoteMessage.AnonymousClass1 */

        /* renamed from: a */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        /* renamed from: a */
        public RemoteMessage[] newArray(int i) {
            return new RemoteMessage[i];
        }
    };
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    private static final String[] a;
    private static final int[] b;
    private static final long[] c;
    private static final HashMap<String, Object> d;
    private static final HashMap<String, Object> e;
    private static final HashMap<String, Object> f;
    private static final HashMap<String, Object> g;
    private static final HashMap<String, Object> h;
    private Bundle i;
    private Notification j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        String[] strArr = new String[0];
        a = strArr;
        int[] iArr = new int[0];
        b = iArr;
        long[] jArr = new long[0];
        c = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(6);
        d = hashMap;
        hashMap.put("from", "");
        hashMap.put("collapseKey", "");
        hashMap.put("sendTime", "");
        hashMap.put("ttl", 86400);
        hashMap.put("urgency", 2);
        hashMap.put("oriUrgency", 2);
        hashMap.put("sendMode", 0);
        hashMap.put("receiptMode", 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        e = hashMap2;
        hashMap2.put("title_loc_key", "");
        hashMap2.put("body_loc_key", "");
        hashMap2.put("notifyIcon", "");
        hashMap2.put("title_loc_args", strArr);
        hashMap2.put("body_loc_args", strArr);
        hashMap2.put("ticker", "");
        hashMap2.put("notifyTitle", "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put("sound", "");
        hashMap3.put("defaultLightSettings", 1);
        hashMap3.put("lightSettings", iArr);
        hashMap3.put("defaultSound", 1);
        hashMap3.put("defaultVibrateTimings", 1);
        hashMap3.put("vibrateTimings", jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        g = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put("when", "");
        hashMap4.put("localOnly", 1);
        hashMap4.put("badgeSetNum", "");
        hashMap4.put("priority", "");
        hashMap4.put("autoCancel", 1);
        hashMap4.put("visibility", "");
        hashMap4.put("channelId", "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        h = hashMap5;
        hashMap5.put("acn", "");
        hashMap5.put("intentUri", "");
        hashMap5.put("url", "");
    }

    public RemoteMessage(Bundle bundle) {
        this.i = a(bundle);
    }

    public RemoteMessage(Parcel parcel) {
        this.i = parcel.readBundle();
        this.j = (Notification) parcel.readSerializable();
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b2 = b(bundle);
        JSONObject a2 = a(b2);
        String string = JsonUtil.getString(a2, "data", null);
        bundle2.putString("device_token", bundle.getString("device_token"));
        JSONObject b3 = b(a2);
        JSONObject c2 = c(b3);
        JSONObject d2 = d(b3);
        if (bundle.getInt("inputType") != 1 || !w.a(a2, b3, string)) {
            String string2 = bundle.getString("to");
            String string3 = bundle.getString("message_type");
            String string4 = JsonUtil.getString(a2, "msgId", null);
            bundle2.putString("to", string2);
            bundle2.putString("data", string);
            bundle2.putString("msgId", string4);
            bundle2.putString("message_type", string3);
            JsonUtil.transferJsonObjectToBundle(b2, bundle2, d);
            bundle2.putBundle("notification", a(b2, a2, b3, c2, d2));
            return bundle2;
        }
        bundle2.putString("data", aa.a(bundle.getByteArray("message_body")));
        return bundle2;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, e);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, g);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, h);
        bundle.putInt("notifyId", JsonUtil.getInt(jSONObject2, "notifyId", 0));
        return bundle;
    }

    public String getFrom() {
        return this.i.getString("from");
    }

    public String getTo() {
        return this.i.getString("to");
    }

    public String getData() {
        return this.i.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.i.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.i.getString("collapseKey");
    }

    public String getMessageId() {
        return this.i.getString("msgId");
    }

    public String getMessageType() {
        return this.i.getString("message_type");
    }

    public long getSentTime() {
        try {
            String string = this.i.getString("sendTime");
            if (!TextUtils.isEmpty(string)) {
                return Long.parseLong(string);
            }
            return 0;
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0;
        }
    }

    public int getTtl() {
        return this.i.getInt("ttl");
    }

    public int getSendMode() {
        return this.i.getInt("sendMode");
    }

    public int getReceiptMode() {
        return this.i.getInt("receiptMode");
    }

    public int getOriginalUrgency() {
        int i2 = this.i.getInt("oriUrgency");
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    public int getUrgency() {
        int i2 = this.i.getInt("urgency");
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    public String getToken() {
        return this.i.getString("device_token");
    }

    public Notification getNotification() {
        Bundle bundle = this.i.getBundle("notification");
        if (this.j == null && bundle != null) {
            this.j = new Notification(bundle);
        }
        if (this.j == null) {
            this.j = new Notification(new Bundle());
        }
        return this.j;
    }

    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;
        private final String a;
        private final String b;
        private final String[] c;
        private final String d;
        private final String e;
        private final String[] f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final Uri n;
        private final int o;
        private final String p;
        private final int q;
        private final int r;
        private final int s;
        private final int[] t;
        private final String u;
        private final int v;
        private final String w;
        private final int x;
        private final String y;
        private final String z;

        private Notification(Bundle bundle) {
            this.a = bundle.getString("notifyTitle");
            this.d = bundle.getString("content");
            this.b = bundle.getString("title_loc_key");
            this.e = bundle.getString("body_loc_key");
            this.c = bundle.getStringArray("title_loc_args");
            this.f = bundle.getStringArray("body_loc_args");
            this.g = bundle.getString("icon");
            this.j = bundle.getString("color");
            this.h = bundle.getString("sound");
            this.i = bundle.getString("tag");
            this.m = bundle.getString("channelId");
            this.k = bundle.getString("acn");
            this.l = bundle.getString("intentUri");
            this.o = bundle.getInt("notifyId");
            String string = bundle.getString("url");
            this.n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.p = bundle.getString("notifyIcon");
            this.q = bundle.getInt("defaultLightSettings");
            this.r = bundle.getInt("defaultSound");
            this.s = bundle.getInt("defaultVibrateTimings");
            this.t = bundle.getIntArray("lightSettings");
            this.u = bundle.getString("when");
            this.v = bundle.getInt("localOnly");
            this.w = bundle.getString("badgeSetNum", null);
            this.x = bundle.getInt("autoCancel");
            this.y = bundle.getString("priority", null);
            this.z = bundle.getString("ticker");
            this.A = bundle.getLongArray("vibrateTimings");
            this.B = bundle.getString("visibility", null);
        }

        public String getTitle() {
            return this.a;
        }

        public String getTitleLocalizationKey() {
            return this.b;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.c;
            if (strArr == null) {
                return null;
            }
            return (String[]) strArr.clone();
        }

        public String getBody() {
            return this.d;
        }

        public String getBodyLocalizationKey() {
            return this.e;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f;
            if (strArr == null) {
                return null;
            }
            return (String[]) strArr.clone();
        }

        public String getIcon() {
            return this.g;
        }

        public Uri getImageUrl() {
            String str = this.p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public String getSound() {
            return this.h;
        }

        public String getTag() {
            return this.i;
        }

        public String getColor() {
            return this.j;
        }

        public String getClickAction() {
            return this.k;
        }

        public String getIntentUri() {
            return this.l;
        }

        public String getChannelId() {
            return this.m;
        }

        public Uri getLink() {
            return this.n;
        }

        public int getNotifyId() {
            return this.o;
        }

        public boolean isDefaultLight() {
            return this.q == 1;
        }

        public boolean isDefaultSound() {
            return this.r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.s == 1;
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.u));
                } catch (ParseException unused) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                } catch (StringIndexOutOfBoundsException unused2) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                }
            }
            return null;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            if (iArr == null) {
                return null;
            }
            return (int[]) iArr.clone();
        }

        public boolean isLocalOnly() {
            return this.v == 1;
        }

        public Integer getBadgeNumber() {
            return a(this.w);
        }

        public boolean isAutoCancel() {
            return this.x == 1;
        }

        public Integer getImportance() {
            return a(this.y);
        }

        public String getTicker() {
            return this.z;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            if (jArr == null) {
                return null;
            }
            return (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        private Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }
    }

    public static class Builder {
        private final Bundle a;
        private final Map<String, String> b = new HashMap();

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.a = bundle;
            bundle.putString("to", str);
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String string = this.a.getString("msgId");
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("collapseKey", this.a.getString("collapseKey"));
                    jSONObject3.put("ttl", this.a.getInt("ttl"));
                    jSONObject3.put("sendMode", this.a.getInt("sendMode"));
                    jSONObject3.put("receiptMode", this.a.getInt("receiptMode"));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put("msgId", string);
                    jSONObject3.put("msgContent", jSONObject4);
                    bundle.putByteArray("message_body", jSONObject3.toString().getBytes(ab.a));
                    bundle.putString("to", this.a.getString("to"));
                    bundle.putString("message_type", this.a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException("send message failed");
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException("send message failed");
            }
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public Builder setData(Map<String, String> map) {
            this.b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder clearData() {
            this.b.clear();
            return this;
        }

        public Builder setMessageId(String str) {
            this.a.putString("msgId", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.a.putString("message_type", str);
            return this;
        }

        public Builder setTtl(int i) {
            if (i < 1 || i > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.a.putInt("ttl", i);
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.a.putString("collapseKey", str);
            return this;
        }

        public Builder setSendMode(int i) {
            if (i == 0 || i == 1) {
                this.a.putInt("sendMode", i);
                return this;
            }
            throw new IllegalArgumentException("send mode can only be 0 or 1.");
        }

        public Builder setReceiptMode(int i) {
            if (i == 1 || i == 0) {
                this.a.putInt("receiptMode", i);
                return this;
            }
            throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
        }
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(aa.a(bundle.getByteArray("message_body")));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("msgContent");
        }
        return null;
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("psContent");
        }
        return null;
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("notifyDetail");
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("param");
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.i);
        parcel.writeSerializable(this.j);
    }
}
