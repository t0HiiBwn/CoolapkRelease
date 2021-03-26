package com.coolapk.market.manager;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppPictureSizeManager {
    private static final int MAX_CACHE_SIZE = 50;
    private static AppPictureSizeManager sInstance;
    private Pattern imageSizePattern = Pattern.compile("^.+@(\\d{1,})x(\\d{1,})\\..+$");
    private Map<String, PictureSize> mSizeMap = new HashMap(50);

    public static AppPictureSizeManager getInstance() {
        if (sInstance == null) {
            sInstance = new AppPictureSizeManager();
        }
        return sInstance;
    }

    private AppPictureSizeManager() {
    }

    public PictureSize getSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PictureSize pictureSize = this.mSizeMap.get(str);
        if (pictureSize != null) {
            return pictureSize;
        }
        Matcher matcher = this.imageSizePattern.matcher(str);
        return matcher.find() ? new PictureSize(str, Integer.valueOf(matcher.group(1)).intValue(), Integer.valueOf(matcher.group(2)).intValue()) : pictureSize;
    }

    public void put(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mSizeMap.size() >= 50) {
                this.mSizeMap.clear();
            }
            this.mSizeMap.put(str, new PictureSize(str, i, i2));
        }
    }

    public static class PictureSize {
        private int height;
        private String url;
        private int width;

        public PictureSize(String str, int i, int i2) {
            this.height = i2;
            this.url = str;
            this.width = i;
        }

        public int getHeight() {
            return this.height;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }
    }
}
