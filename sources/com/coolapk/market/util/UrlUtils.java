package com.coolapk.market.util;

import android.util.Patterns;
import android.webkit.URLUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtils {
    private static final Pattern ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");
    public static final String QUERY_PLACE_HOLDER = "%s";
    private static final Pattern STRIP_URL_PATTERN = Pattern.compile("^http://(.*?)/?$");

    private UrlUtils() {
    }

    public static String stripUrl(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = STRIP_URL_PATTERN.matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static String smartUrlFilter(String str, boolean z, String str2) {
        String trim = str.trim();
        boolean z2 = trim.indexOf(32) != -1;
        Matcher matcher = ACCEPTED_URI_SCHEMA.matcher(trim);
        if (matcher.matches()) {
            String group2 = matcher.group(1);
            String lowerCase = group2.toLowerCase();
            if (!lowerCase.equals(group2)) {
                trim = lowerCase + matcher.group(2);
            }
            return (!z2 || !Patterns.WEB_URL.matcher(trim).matches()) ? trim : trim.replace(" ", "%20");
        } else if (z2 || !Patterns.WEB_URL.matcher(trim).matches()) {
            return z ? URLUtil.composeSearchUrl(trim, str2, "%s") : "";
        } else {
            return URLUtil.guessUrl(trim);
        }
    }

    static String fixUrl(String str) {
        int indexOf = str.indexOf(58);
        boolean z = true;
        for (int i = 0; i < indexOf; i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetter(charAt)) {
                break;
            }
            z &= Character.isLowerCase(charAt);
            if (i == indexOf - 1 && !z) {
                str = str.substring(0, indexOf).toLowerCase() + str.substring(indexOf);
            }
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        if (!(str.startsWith("http:") || str.startsWith("https:"))) {
            return str;
        }
        if (str.startsWith("http:/") || str.startsWith("https:/")) {
            return str.replaceFirst("/", "//");
        }
        return str.replaceFirst(":", "://");
    }

    static String filteredUrl(String str) {
        if (str != null && !str.startsWith("content:") && !str.startsWith("browser:")) {
            return str;
        }
        return "";
    }
}
