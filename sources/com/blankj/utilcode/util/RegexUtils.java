package com.blankj.utilcode.util;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtils {
    private static final SimpleArrayMap<String, String> CITY_MAP = new SimpleArrayMap<>();

    private RegexUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isMobileSimple(CharSequence charSequence) {
        return isMatch("^[1]\\d{10}$", charSequence);
    }

    public static boolean isMobileExact(CharSequence charSequence) {
        return isMobileExact(charSequence, null);
    }

    public static boolean isMobileExact(CharSequence charSequence, List<String> list) {
        if (isMatch("^((13[0-9])|(14[579])|(15[0-35-9])|(16[2567])|(17[0-35-8])|(18[0-9])|(19[0-35-9]))\\d{8}$", charSequence)) {
            return true;
        }
        if (!(list == null || charSequence == null || charSequence.length() != 11)) {
            String charSequence2 = charSequence.toString();
            for (char c : charSequence2.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            for (String str : list) {
                if (charSequence2.startsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isTel(CharSequence charSequence) {
        return isMatch("^0\\d{2,3}[- ]?\\d{7,8}$", charSequence);
    }

    public static boolean isIDCard15(CharSequence charSequence) {
        return isMatch("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$", charSequence);
    }

    public static boolean isIDCard18(CharSequence charSequence) {
        return isMatch("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$", charSequence);
    }

    public static boolean isIDCard18Exact(CharSequence charSequence) {
        if (!isIDCard18(charSequence)) {
            return false;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        SimpleArrayMap<String, String> simpleArrayMap = CITY_MAP;
        if (simpleArrayMap.isEmpty()) {
            simpleArrayMap.put("11", "??????");
            simpleArrayMap.put("12", "??????");
            simpleArrayMap.put("13", "??????");
            simpleArrayMap.put("14", "??????");
            simpleArrayMap.put("15", "?????????");
            simpleArrayMap.put("21", "??????");
            simpleArrayMap.put("22", "??????");
            simpleArrayMap.put("23", "?????????");
            simpleArrayMap.put("31", "??????");
            simpleArrayMap.put("32", "??????");
            simpleArrayMap.put("33", "??????");
            simpleArrayMap.put("34", "??????");
            simpleArrayMap.put("35", "??????");
            simpleArrayMap.put("36", "??????");
            simpleArrayMap.put("37", "??????");
            simpleArrayMap.put("41", "??????");
            simpleArrayMap.put("42", "??????");
            simpleArrayMap.put("43", "??????");
            simpleArrayMap.put("44", "??????");
            simpleArrayMap.put("45", "??????");
            simpleArrayMap.put("46", "??????");
            simpleArrayMap.put("50", "??????");
            simpleArrayMap.put("51", "??????");
            simpleArrayMap.put("52", "??????");
            simpleArrayMap.put("53", "??????");
            simpleArrayMap.put("54", "??????");
            simpleArrayMap.put("61", "??????");
            simpleArrayMap.put("62", "??????");
            simpleArrayMap.put("63", "??????");
            simpleArrayMap.put("64", "??????");
            simpleArrayMap.put("65", "??????");
            simpleArrayMap.put("71", "?????????");
            simpleArrayMap.put("81", "??????");
            simpleArrayMap.put("82", "??????");
            simpleArrayMap.put("83", "?????????");
            simpleArrayMap.put("91", "??????");
        }
        if (simpleArrayMap.get(charSequence.subSequence(0, 2).toString()) == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < 17; i2++) {
            i += (charSequence.charAt(i2) - '0') * iArr[i2];
        }
        if (charSequence.charAt(17) == cArr[i % 11]) {
            return true;
        }
        return false;
    }

    public static boolean isEmail(CharSequence charSequence) {
        return isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", charSequence);
    }

    public static boolean isURL(CharSequence charSequence) {
        return isMatch("[a-zA-z]+://[^\\s]*", charSequence);
    }

    public static boolean isZh(CharSequence charSequence) {
        return isMatch("^[\\u4e00-\\u9fa5]+$", charSequence);
    }

    public static boolean isUsername(CharSequence charSequence) {
        return isMatch("^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$", charSequence);
    }

    public static boolean isDate(CharSequence charSequence) {
        return isMatch("^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$", charSequence);
    }

    public static boolean isIP(CharSequence charSequence) {
        return isMatch("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)", charSequence);
    }

    public static boolean isMatch(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static List<String> getMatches(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static String[] getSplits(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static String getReplaceFirst(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceFirst(str3);
    }

    public static String getReplaceAll(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceAll(str3);
    }
}
