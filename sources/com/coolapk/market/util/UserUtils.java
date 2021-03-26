package com.coolapk.market.util;

public class UserUtils {
    private static final String BASE_AVATAR_URL = "http://avatar.coolapk.com";
    public static final String FOLDED_INDICATOR = "[折叠]";
    public static final String FOLDED_SPAN_FORMAT = "<img src=\"[折叠]\"/>";
    public static final String LZ_INDICATOR = "[楼主]";
    public static final String LZ_SPAN_FORMAT = "<img src=\"[楼主]\"/>";
    public static final String PHONE_INDICATOR = "[手机]";
    public static final String PHONE_SPAN_FORMAT = "<img src=\"[手机]\"/>";
    public static final String PIC_INDICATOR = "[图片]";
    public static final String PIC_SPAN_FORMAT = "<img src=\"[图片]\"/>";
    private static final String USER_NAME_SPAN_FORMAT = "<a href=\"/n/%s\">%s</a>";
    private static final String USER_SPAN_FORMAT = "<a href=\"coolmarket://userDetails?id=%s\">%s</a>";

    public static String getAvatarUrl(String str) {
        return getAvatarUrl(str, "middle");
    }

    public static String getBigAvatarUrl(String str) {
        return getAvatarUrl(str, "big");
    }

    public static String getSmallAvatarUrl(String str) {
        return getAvatarUrl(str, "small");
    }

    public static String getAvatarUrl(String str, String str2) {
        return getUserAvatar(str, str2, "avatar");
    }

    public static String getCoverUrl(String str) {
        return getCoverUrl(str, "big");
    }

    public static String getCoverUrl(String str, String str2) {
        return getUserAvatar(str, str2, "messageCover");
    }

    private static String getUserAvatar(String str, String str2, String str3) {
        String format = String.format("%09d", Integer.valueOf(str));
        return "http://avatar.coolapk.com" + ("/data/" + format.substring(0, 3) + "/" + format.substring(3, 5) + "/" + format.substring(5, 7)) + "/" + (format.substring(7) + "_" + str3 + "_" + str2 + ".jpg");
    }

    public static String getUserSpan(String str, String str2) {
        return String.format("<a href=\"coolmarket://userDetails?id=%s\">%s</a>", str, str2);
    }

    public static String getUserNameSpan(String str) {
        return String.format("<a href=\"/n/%s\">%s</a>", str, str);
    }
}
