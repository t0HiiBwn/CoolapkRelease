package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

public final class Status extends Result implements Parcelable {
    public static final Parcelable.Creator<Status> CREATOR = new Parcelable.Creator() {
        /* class com.huawei.hms.support.api.client.Status.AnonymousClass1 */

        /* renamed from: a */
        public Status createFromParcel(Parcel parcel) {
            return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        /* renamed from: a */
        public Status[] newArray(int i) {
            return new Status[i];
        }
    };
    public static final Status CoreException = new Status(500);
    public static final Status FAILURE = new Status(1);
    public static final Status MessageNotFound = new Status(404);
    @Deprecated
    public static final Status RESULT_CANCELED = new Status(16);
    @Deprecated
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @Deprecated
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @Deprecated
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @Deprecated
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status SUCCESS = new Status(0);
    @Packed
    private Intent intent;
    @Packed
    private PendingIntent pendingIntent;
    @Packed
    private int statusCode;
    @Packed
    private String statusMessage;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        return this;
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isInterrupted() {
        return false;
    }

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    public Status(int i, String str, PendingIntent pendingIntent2) {
        this.statusCode = i;
        this.statusMessage = str;
        this.pendingIntent = pendingIntent2;
    }

    public Status(int i, String str, Intent intent2) {
        this.statusCode = i;
        this.statusMessage = str;
        this.intent = intent2;
    }

    private static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean hasResolution() {
        return (this.pendingIntent == null && this.intent == null) ? false : true;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent2 = this.pendingIntent;
            if (pendingIntent2 != null) {
                activity.startIntentSenderForResult(pendingIntent2.getIntentSender(), i, null, 0, 0, 0);
            } else {
                activity.startActivityForResult(this.intent, i);
            }
        }
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public boolean isSuccess() {
        return this.statusCode <= 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent});
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.statusCode != status.statusCode || !equal(this.statusMessage, status.statusMessage) || !equal(this.pendingIntent, status.pendingIntent)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + this.pendingIntent + ", }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.statusMessage);
        PendingIntent pendingIntent2 = this.pendingIntent;
        if (pendingIntent2 != null) {
            pendingIntent2.writeToParcel(parcel, i);
        }
        PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, parcel);
        Intent intent2 = this.intent;
        if (intent2 != null) {
            intent2.writeToParcel(parcel, i);
        }
    }

    public String getErrorString() {
        return getStatusMessage();
    }
}
