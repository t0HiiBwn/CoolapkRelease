package com.coolapk.market.model;

import android.os.Parcelable;
import com.coolapk.market.model.C$AutoValue_ImageUrl;
import java.util.ArrayList;
import java.util.List;

public abstract class ImageUrl implements Parcelable {

    public static abstract class Builder {
        public abstract ImageUrl build();

        public abstract Builder setCompressedUrl(String str);

        public abstract Builder setSourceUrl(String str);

        public abstract Builder setUploadDir(String str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract String getCompressedUrl();

    public abstract String getSourceUrl();

    public abstract String getUploadDir();

    public static ImageUrl create(String str, String str2) {
        return builder().setSourceUrl(str).setCompressedUrl(str2).build();
    }

    public static ImageUrl create(String str, String str2, String str3) {
        return builder().setSourceUrl(str).setCompressedUrl(str2).setUploadDir(str3).build();
    }

    public static Builder builder() {
        return new C$AutoValue_ImageUrl.Builder();
    }

    public static List<ImageUrl> from(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            throw new IllegalArgumentException("sources is null");
        } else if (strArr2 == null || strArr2.length == strArr.length) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (int i = 0; i < strArr.length; i++) {
                arrayList.add(builder().setCompressedUrl(strArr2 == null ? null : strArr2[i]).setSourceUrl(strArr[i]).build());
            }
            return arrayList;
        } else {
            throw new IllegalArgumentException("thumbnails with incompatible length");
        }
    }

    public static List<ImageUrl> from(List<String> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(builder().setCompressedUrl(list.get(i)).setSourceUrl(list.get(i)).build());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("sources is null");
    }
}
