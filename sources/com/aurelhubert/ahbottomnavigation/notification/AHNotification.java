package com.aurelhubert.ahbottomnavigation.notification;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class AHNotification implements Parcelable {
    public static final Parcelable.Creator<AHNotification> CREATOR = new Parcelable.Creator<AHNotification>() {
        /* class com.aurelhubert.ahbottomnavigation.notification.AHNotification.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AHNotification createFromParcel(Parcel parcel) {
            return new AHNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AHNotification[] newArray(int i) {
            return new AHNotification[i];
        }
    };
    private int backgroundColor;
    private String text;
    private int textColor;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AHNotification() {
    }

    private AHNotification(Parcel parcel) {
        this.text = parcel.readString();
        this.textColor = parcel.readInt();
        this.backgroundColor = parcel.readInt();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.text);
    }

    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public static AHNotification justText(String str) {
        return new Builder().setText(str).build();
    }

    public static List<AHNotification> generateEmptyList(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new AHNotification());
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
        parcel.writeInt(this.textColor);
        parcel.writeInt(this.backgroundColor);
    }

    public static class Builder {
        private int backgroundColor;
        private String text;
        private int textColor;

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setTextColor(int i) {
            this.textColor = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public AHNotification build() {
            AHNotification aHNotification = new AHNotification();
            aHNotification.text = this.text;
            aHNotification.textColor = this.textColor;
            aHNotification.backgroundColor = this.backgroundColor;
            return aHNotification;
        }
    }
}
