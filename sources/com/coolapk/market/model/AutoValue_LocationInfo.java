package com.coolapk.market.model;

import android.os.Parcel;
import android.os.Parcelable;

final class AutoValue_LocationInfo extends C$AutoValue_LocationInfo {
    public static final Parcelable.Creator<AutoValue_LocationInfo> CREATOR = new Parcelable.Creator<AutoValue_LocationInfo>() {
        /* class com.coolapk.market.model.AutoValue_LocationInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public AutoValue_LocationInfo createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            String readString2 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString3 = parcel.readInt() == 0 ? parcel.readString() : null;
            Integer valueOf = parcel.readInt() == 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString4 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString5 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString6 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString7 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString8 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString9 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString10 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString11 = parcel.readInt() == 0 ? parcel.readString() : null;
            Long valueOf2 = parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null;
            Long valueOf3 = parcel.readInt() == 0 ? Long.valueOf(parcel.readLong()) : null;
            String readString12 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString13 = parcel.readString();
            Double valueOf4 = Double.valueOf(parcel.readDouble());
            Double valueOf5 = Double.valueOf(parcel.readDouble());
            String readString14 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString15 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString16 = parcel.readInt() == 0 ? parcel.readString() : null;
            boolean z = false;
            boolean z2 = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            return new AutoValue_LocationInfo(readString, readString2, readString3, valueOf, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, valueOf2, valueOf3, readString12, readString13, valueOf4, valueOf5, readString14, readString15, readString16, z2, z, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null);
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_LocationInfo[] newArray(int i) {
            return new AutoValue_LocationInfo[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    AutoValue_LocationInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, Long l2, String str12, String str13, Double d, Double d2, String str14, String str15, String str16, boolean z, boolean z2, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27) {
        super(str, str2, str3, num, str4, str5, str6, str7, str8, str9, str10, str11, l, l2, str12, str13, d, d2, str14, str15, str16, z, z2, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getEntityType());
        if (getEntityTemplate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityTemplate());
        }
        if (getEntityId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getEntityId());
        }
        if (getEntityFixed() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(getEntityFixed().intValue());
        }
        if (getTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getTitle());
        }
        if (getUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getUrl());
        }
        if (getDescription() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDescription());
        }
        if (getPic() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPic());
        }
        if (getLogo() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLogo());
        }
        if (getSubTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSubTitle());
        }
        if (getId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getId());
        }
        if (getExtraData() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getExtraData());
        }
        if (getDateline() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getDateline().longValue());
        }
        if (getLastUpdate() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeLong(getLastUpdate().longValue());
        }
        if (getFeedType() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getFeedType());
        }
        parcel.writeString(getAddress());
        parcel.writeDouble(getLatitude().doubleValue());
        parcel.writeDouble(getLongitude().doubleValue());
        if (getBusinessArea() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getBusinessArea());
        }
        if (getSnippet() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getSnippet());
        }
        if (getLongAddress() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getLongAddress());
        }
        parcel.writeInt(getIsChecked() ? 1 : 0);
        parcel.writeInt(getIsHideLocation() ? 1 : 0);
        if (getCity() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCity());
        }
        if (getCountry() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCountry());
        }
        if (getProvince() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getProvince());
        }
        if (getDistrict() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getDistrict());
        }
        if (getCityCode() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getCityCode());
        }
        if (getAdCode() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getAdCode());
        }
        if (getRoad() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getRoad());
        }
        if (getPoiName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getPoiName());
        }
        if (getStreet() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getStreet());
        }
        if (getStreetNum() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(getStreetNum());
        }
        if (getAoiName() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(getAoiName());
    }
}
