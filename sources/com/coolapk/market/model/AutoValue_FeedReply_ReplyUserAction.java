package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_FeedReply_ReplyUserAction extends C$AutoValue_FeedReply_ReplyUserAction {
    public static final Parcelable.Creator<AutoValue_FeedReply_ReplyUserAction> CREATOR = new Parcelable.Creator<AutoValue_FeedReply_ReplyUserAction>() {
        /* class com.coolapk.market.model.AutoValue_FeedReply_ReplyUserAction.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedReply_ReplyUserAction createFromParcel(Parcel parcel) {
            return new AutoValue_FeedReply_ReplyUserAction(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_FeedReply_ReplyUserAction[] newArray(int i) {
            return new AutoValue_FeedReply_ReplyUserAction[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_FeedReply_ReplyUserAction(int i) {
        super(i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getLike());
    }
}
