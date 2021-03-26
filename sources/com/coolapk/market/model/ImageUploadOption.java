package com.coolapk.market.model;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class ImageUploadOption {
    public static final String API_COLLECTION = "COLLECTION";
    public static final String API_FEED = "FEED";
    public static final String API_LIVE = "LIVE";
    public static final String EXTRA_ANONYMOUS = "extra_anonymous";
    public static final String UPLOAD_DIR_ALBUM = "album";
    public static final String UPLOAD_DIR_APK_LOGO = "apk_logo";
    public static final String UPLOAD_DIR_BACK_LIST = "back_list";
    public static final String UPLOAD_DIR_COVER = "cover";
    public static final String UPLOAD_DIR_DISCOVERY = "discovery";
    public static final String UPLOAD_DIR_FEED = "feed";
    public static final String UPLOAD_DIR_FEED_COVER = "feed_cover";
    public static final String UPLOAD_DIR_FEED_IMAGE = "feed_image";
    public static final String UPLOAD_DIR_GOODS_COVER = "goods_cover";
    public static final String UPLOAD_DIR_LIVE = "live";
    public static final String UPLOAD_DIR_LIVE_PIC = "live_pic";
    public static final String UPLOAD_DIR_MESSAGE = "message";
    public static final String UPLOAD_DIR_PICTURE = "picture";

    public abstract String getApi();

    public abstract Bundle getBundle();

    public abstract String getUid();

    public abstract String getUploadDir();

    public abstract String getUrl();

    public static ImageUploadOption create(String str, String str2, String str3, Bundle bundle) {
        return new AutoValue_ImageUploadOption(str, str2, str3, bundle, "");
    }

    public static ImageUploadOption create(String str, String str2, String str3, Bundle bundle, String str4) {
        return new AutoValue_ImageUploadOption(str, str2, str3, bundle, str4);
    }

    public static List<ImageUploadOption> transformList(List<String> list, String str, String str2, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || str == null)) {
            for (String str3 : list) {
                arrayList.add(create(str3, str, str2, bundle));
            }
        }
        return arrayList;
    }

    public static List<ImageUploadOption> transformList(List<String> list, String str, String str2, Bundle bundle, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || str == null)) {
            for (String str4 : list) {
                arrayList.add(create(str4, str, str2, bundle, str3));
            }
        }
        return arrayList;
    }
}
