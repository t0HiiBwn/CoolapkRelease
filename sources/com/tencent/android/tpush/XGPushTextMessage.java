package com.tencent.android.tpush;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ProGuard */
public class XGPushTextMessage implements Parcelable {
    public static final Parcelable.Creator<XGPushTextMessage> CREATOR = new Parcelable.Creator<XGPushTextMessage>() {
        /* class com.tencent.android.tpush.XGPushTextMessage.AnonymousClass1 */

        /* renamed from: a */
        public XGPushTextMessage createFromParcel(Parcel parcel) {
            return new XGPushTextMessage(parcel);
        }

        /* renamed from: a */
        public XGPushTextMessage[] newArray(int i) {
            return new XGPushTextMessage[i];
        }
    };
    String a = "";
    String b = "";
    String c = "";
    int d = 100;
    private Intent e = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected XGPushTextMessage() {
    }

    protected XGPushTextMessage(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, 1);
    }

    public String getTitle() {
        return this.a;
    }

    public String getContent() {
        return this.b;
    }

    public String getCustomContent() {
        return this.c;
    }

    public int getPushChannel() {
        return this.d;
    }

    void a(Intent intent) {
        this.e = intent;
        if (intent != null) {
            intent.removeExtra("content");
        }
    }

    Intent a() {
        return this.e;
    }

    @Override // java.lang.Object
    public String toString() {
        return "XGPushShowedResult [title=" + this.a + ", content=" + this.b + ", customContent=" + this.c + "]";
    }
}
