package com.coolapk.market.util;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.coolapk.market.model.Entity;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String HTML_PATTERN = "<[a-zA-Z]+(\\s+[a-zA-Z]+\\s*=\\s*(\"([^\"]*)\"|'([^']*)'))*\\s*/>";
    private static final DecimalFormat PERCENT_FORMATTER = new DecimalFormat("0.#'%'");
    private static final DecimalFormat SIZE_FORMATTER = new DecimalFormat("0.0#");
    private static final String[] SIZE_UNIT = {"B", "K", "M", "G", "T"};
    public static final String URL_PATTERN = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";

    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static String notNull(String str) {
        return str == null ? "" : str;
    }

    public static String defaultIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static String formatSize(long j) {
        if (j < 0) {
            j = 0;
        }
        int i = 0;
        float f = (float) j;
        while (f > 1024.0f) {
            f /= 1024.0f;
            i++;
        }
        if (f >= 1000.0f) {
            f /= 1024.0f;
            i++;
        }
        return SIZE_FORMATTER.format((double) f) + SIZE_UNIT[i];
    }

    public static String formatPercent(float f, float f2) {
        if (f2 == 0.0f) {
            return PERCENT_FORMATTER.format(0L);
        }
        return PERCENT_FORMATTER.format((double) ((f * 100.0f) / f2));
    }

    public static int getUniqueInteger(String str) {
        int hashCode = str.hashCode();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            String bigInteger = new BigInteger(1, instance.digest()).toString(10);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            int i = 0;
            for (int i2 = 0; i2 < bigInteger.length(); i2++) {
                i += bigInteger.charAt(i2);
            }
            return hashCode + i;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return hashCode;
        }
    }

    public static String toMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                sb.append(Character.forDigit(digest[i] & 15, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean isPhoneNumber(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 7;
    }

    public static String hideNumber(String str) {
        if (str.length() < 8 || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        switch (sb.length()) {
            case 8:
                sb.replace(2, 6, "****");
                break;
            case 9:
            case 10:
            case 11:
                sb.replace(3, 7, "****");
                break;
            default:
                sb.replace((sb.length() / 2) - 1, (sb.length() / 2) + 3, "****");
                break;
        }
        return sb.toString();
    }

    public static String getAllLinkAndText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Pattern.compile("<a class=\"feed-link-url\"\\s+href=\"([^<>\"]*)\"[^<]*[^>]*>").matcher(str).replaceAll(" $1 ");
    }

    public static String getTextFromUlr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("<(\\S*?)[^>]*>.*?|<.*? />").matcher(str);
        return matcher.find() ? matcher.replaceAll(" $1 ") : str;
    }

    public static void copyText(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("textFromCoolapk", str));
    }

    public static String getUrl(String str) {
        Matcher matcher = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?").matcher(str);
        String str2 = "";
        while (matcher.find()) {
            str2 = matcher.group(0);
        }
        return str2;
    }

    public static String getStandardShareText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("https://")) {
            return str.replace("https://", " https://");
        } else if (!str.contains("http://")) {
            return str;
        } else {
            return str.replace("http://", " http://");
        }
    }

    public static String getExtraUrl(Context context, String str) {
        String standardShareText = getStandardShareText(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(standardShareText)) {
            return "";
        }
        try {
            TextView textView = new TextView(context);
            textView.setText(standardShareText);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            URLSpan[] urls = textView.getUrls();
            if (urls.length > 0) {
                return urls[0].getURL();
            }
            return getUrl(str);
        } catch (Exception unused) {
            return getUrl(str);
        }
    }

    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(", ");
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }

    public static String lineToHtmlBr(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\n", "<br />");
    }

    public static String lineToHtmln(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\n", "");
    }

    public static String notNull(int i) {
        return notNull(String.valueOf(i));
    }

    public static int safeNum(Collection collection) {
        return CollectionUtils.safeSize(collection);
    }

    public static String titleWithNum(String str, Collection collection) {
        return titleWithNum(str, safeNum(collection));
    }

    public static String titleWithNum(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == 0) {
            return str;
        }
        return str + "(" + i + ")";
    }

    public static String titleWithNum(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals("0", str2)) {
            return str;
        }
        return str + "(" + str2 + ")";
    }

    public static String[] getWidthAndHeight(String str) {
        return str.split("x");
    }

    public static CharSequence getLastClipBoardText(Context context) {
        ClipData.Item lastClipboardData = getLastClipboardData(context);
        if (lastClipboardData == null) {
            return "";
        }
        try {
            return lastClipboardData.coerceToText(context);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getLastClipBoardUrlText(Context context) {
        String str;
        CharSequence lastClipBoardText = getLastClipBoardText(context);
        if (lastClipBoardText != null) {
            str = lastClipBoardText.toString();
        } else {
            str = "";
        }
        if (!isUrl(str) || TextUtils.isEmpty(str)) {
            return "";
        }
        return getExtraUrl(context, str);
    }

    public static String getRepairUrl(String str) {
        String url = getUrl(str);
        if (url.contains("://")) {
            return url;
        }
        return "http://" + url;
    }

    public static boolean isUrl(String str) {
        return !TextUtils.isEmpty(getUrl(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A[Catch:{ Exception -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    public static ClipData.Item getLastClipboardData(Context context) {
        boolean z;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            ClipDescription description = primaryClip.getDescription();
            if (!description.hasMimeType("text/plain")) {
                if (!description.hasMimeType("text/uri-list")) {
                    z = false;
                    if (!z) {
                        return primaryClip.getItemAt(primaryClip.getItemCount() - 1);
                    }
                    return null;
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean containsEmojiOrIllegalCharacter(String str) {
        int charAt;
        if (!Pattern.compile("^[a-zA-Z0-9\\u4E00-\\u9FA5]+$").matcher(str).find()) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt2 = str.charAt(i);
            if (55296 > charAt2 || charAt2 > 56319) {
                if (8448 <= charAt2 && charAt2 <= 10239 && charAt2 != 9787) {
                    return true;
                }
                if (11013 <= charAt2 && charAt2 <= 11015) {
                    return true;
                }
                if (10548 <= charAt2 && charAt2 <= 10549) {
                    return true;
                }
                if ((12951 <= charAt2 && charAt2 <= 12953) || charAt2 == 169 || charAt2 == 174 || charAt2 == 12349 || charAt2 == 12336 || charAt2 == 11093 || charAt2 == 11036 || charAt2 == 11035 || charAt2 == 11088 || charAt2 == 8986) {
                    return true;
                }
                if (str.length() > 1 && i < str.length() - 1 && str.charAt(i + 1) == 8419) {
                    return true;
                }
            } else if (str.length() > 1 && 118784 <= (charAt = ((charAt2 - 55296) * 1024) + (str.charAt(i + 1) - 56320) + 65536) && charAt <= 128895) {
                return true;
            }
        }
        return false;
    }

    public static boolean isViaSign(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, "mark.via") || (!str.contains("viaurl{") && !str.contains("viascript{") && !str.contains("viarule{"))) {
            return false;
        }
        return true;
    }

    public static String getReplyInfoText(String... strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        if (strArr.length == 1) {
            return sb.toString();
        }
        for (int i = 1; i < strArr.length; i++) {
            sb.append(" · " + strArr[i]);
        }
        return sb.toString();
    }

    public static String getShortString(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i) + "...";
    }

    public static String getModelInfo(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(",");
        for (String str2 : split) {
            sb.append(str2 + "\n");
        }
        return sb.toString();
    }

    public static String getUrlHost(String str) {
        return Uri.parse(str).getHost();
    }

    public static String getForwardId(Entity entity) {
        if (!EntityUtils.isDyhArticleType(entity.getEntityType())) {
            return entity.getId();
        }
        return "/article/" + entity.getId();
    }
}
