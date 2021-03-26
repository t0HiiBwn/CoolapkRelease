package com.tencent.tpns.mqttchannel.core.common.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.mqttchannel.core.common.c.b;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        /* class com.tencent.tpns.mqttchannel.core.common.a.a.AnonymousClass1 */

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public int a;
    public volatile boolean b = false;
    private long c;
    private String d;
    private String e;
    private String f = "";
    private int g = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected a(Parcel parcel) {
        this.c = parcel.readLong();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public a(long j, String str, String str2) {
        this.c = j;
        this.d = str;
        this.e = str2;
    }

    public long a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public void d() {
        this.g++;
    }

    public int e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a == aVar.a && this.c == aVar.c) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return super.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Request{type=" + this.a + ", id=" + this.c + ", topic='" + this.d + "', content='" + this.e + "', retryCount=" + this.g + '}';
    }

    public void a(String str) {
        if (!b.a(str)) {
            try {
                if (!b.a(this.e)) {
                    JSONObject jSONObject = new JSONObject(this.e);
                    com.tencent.tpns.mqttchannel.core.common.c.a.b("Request", "Update token to: " + str);
                    jSONObject.put("token", str);
                    String jSONObject2 = jSONObject.toString();
                    this.e = jSONObject2;
                    this.f = Md5.md5(jSONObject2);
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.c.a.d("Request", "request content null");
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.c.a.a("Request", "setCurrentToken", th);
            }
        }
    }
}
