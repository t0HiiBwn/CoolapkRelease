package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class StoryMessage implements Parcelable {
    public static final Parcelable.Creator<StoryMessage> CREATOR = new Parcelable.Creator<StoryMessage>() {
        /* class com.sina.weibo.sdk.api.StoryMessage.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public StoryMessage createFromParcel(Parcel parcel) {
            return new StoryMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public StoryMessage[] newArray(int i) {
            return new StoryMessage[i];
        }
    };
    private Uri imageUri;
    private Uri videoUri;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    public StoryMessage() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeParcelable(this.videoUri, i);
    }

    protected StoryMessage(Parcel parcel) {
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.videoUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public boolean checkSource() {
        Uri uri = this.imageUri;
        if (uri != null && this.videoUri != null) {
            return false;
        }
        if (uri == null && this.videoUri == null) {
            return false;
        }
        return true;
    }
}
