package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

final class AutoValue_PermissionItem extends C$AutoValue_PermissionItem {
    public static final Parcelable.Creator<AutoValue_PermissionItem> CREATOR = new Parcelable.Creator<AutoValue_PermissionItem>() {
        /* class com.coolapk.market.model.AutoValue_PermissionItem.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_PermissionItem createFromParcel(Parcel parcel) {
            return new AutoValue_PermissionItem((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null, parcel.readInt() == 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null, parcel.readInt() == 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_PermissionItem[] newArray(int i) {
            return new AutoValue_PermissionItem[i];
        }
    };

    AutoValue_PermissionItem(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i) {
        super(charSequence, charSequence2, charSequence3, charSequence4, i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(label(), parcel, i);
        if (sourceString() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            TextUtils.writeToParcel(sourceString(), parcel, i);
        }
        if (description() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            TextUtils.writeToParcel(description(), parcel, i);
        }
        if (group() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            TextUtils.writeToParcel(group(), parcel, i);
        }
        parcel.writeInt(level());
    }
}
