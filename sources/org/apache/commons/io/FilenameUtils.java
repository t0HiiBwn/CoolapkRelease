package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final int NOT_FOUND = -1;
    private static final char OTHER_SEPARATOR;
    private static final char SYSTEM_SEPARATOR = File.separatorChar;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    private static boolean isSeparator(char c) {
        return c == '/' || c == '\\';
    }

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static String normalize(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static String normalize(String str, boolean z) {
        return doNormalize(str, z ? '/' : '\\', true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static String normalizeNoEndSeparator(String str, boolean z) {
        return doNormalize(str, z ? '/' : '\\', false);
    }

    private static String doNormalize(String str, char c, boolean z) {
        boolean z2;
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i = length + 2;
        char[] cArr = new char[i];
        str.getChars(0, str.length(), cArr, 0);
        char c2 = SYSTEM_SEPARATOR;
        if (c == c2) {
            c2 = OTHER_SEPARATOR;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] == c2) {
                cArr[i2] = c;
            }
        }
        if (cArr[length - 1] != c) {
            cArr[length] = c;
            length++;
            z2 = false;
        } else {
            z2 = true;
        }
        int i3 = prefixLength + 1;
        int i4 = i3;
        while (i4 < length) {
            if (cArr[i4] == c) {
                int i5 = i4 - 1;
                if (cArr[i5] == c) {
                    System.arraycopy(cArr, i4, cArr, i5, length - i4);
                    length--;
                    i4--;
                }
            }
            i4++;
        }
        int i6 = i3;
        while (i6 < length) {
            if (cArr[i6] == c) {
                int i7 = i6 - 1;
                if (cArr[i7] == '.' && (i6 == i3 || cArr[i6 - 2] == c)) {
                    if (i6 == length - 1) {
                        z2 = true;
                    }
                    System.arraycopy(cArr, i6 + 1, cArr, i7, length - i6);
                    length -= 2;
                    i6--;
                }
            }
            i6++;
        }
        int i8 = prefixLength + 2;
        int i9 = i8;
        while (i9 < length) {
            if (cArr[i9] == c && cArr[i9 - 1] == '.' && cArr[i9 - 2] == '.' && (i9 == i8 || cArr[i9 - 3] == c)) {
                if (i9 == i8) {
                    return null;
                }
                if (i9 == length - 1) {
                    z2 = true;
                }
                int i10 = i9 - 4;
                while (true) {
                    if (i10 < prefixLength) {
                        int i11 = i9 + 1;
                        System.arraycopy(cArr, i11, cArr, prefixLength, length - i9);
                        length -= i11 - prefixLength;
                        i9 = i3;
                        break;
                    } else if (cArr[i10] == c) {
                        int i12 = i10 + 1;
                        System.arraycopy(cArr, i9 + 1, cArr, i12, length - i9);
                        length -= i9 - i10;
                        i9 = i12;
                        break;
                    } else {
                        i10--;
                    }
                }
            }
            i9++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= prefixLength) {
            return new String(cArr, 0, length);
        }
        if (!z2 || !z) {
            return new String(cArr, 0, length - 1);
        }
        return new String(cArr, 0, length);
    }

    public static String concat(String str, String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + '/' + str2);
    }

    public static boolean directoryContains(String str, String str2) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Directory must not be null");
        } else if (str2 != null && !IOCase.SYSTEM.checkEquals(str, str2)) {
            return IOCase.SYSTEM.checkStartsWith(str2, str);
        } else {
            return false;
        }
    }

    public static String separatorsToUnix(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public static String separatorsToWindows(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace('/', '\\');
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        if (isSystemWindows()) {
            return separatorsToWindows(str);
        }
        return separatorsToUnix(str);
    }

    public static int getPrefixLength(String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length != 1) {
            if (charAt == '~') {
                int indexOf = str.indexOf(47, 1);
                int indexOf2 = str.indexOf(92, 1);
                if (indexOf == -1 && indexOf2 == -1) {
                    return length + 1;
                }
                if (indexOf == -1) {
                    indexOf = indexOf2;
                }
                if (indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                min = Math.min(indexOf, indexOf2);
            } else {
                char charAt2 = str.charAt(1);
                if (charAt2 == ':') {
                    char upperCase = Character.toUpperCase(charAt);
                    if (upperCase < 'A' || upperCase > 'Z') {
                        if (upperCase == '/') {
                            return 1;
                        }
                        return -1;
                    } else if (length == 2 || !isSeparator(str.charAt(2))) {
                        return 2;
                    } else {
                        return 3;
                    }
                } else if (!isSeparator(charAt) || !isSeparator(charAt2)) {
                    return isSeparator(charAt) ? 1 : 0;
                } else {
                    int indexOf3 = str.indexOf(47, 2);
                    int indexOf4 = str.indexOf(92, 2);
                    if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                        return -1;
                    }
                    if (indexOf3 == -1) {
                        indexOf3 = indexOf4;
                    }
                    if (indexOf4 == -1) {
                        indexOf4 = indexOf3;
                    }
                    min = Math.min(indexOf3, indexOf4);
                }
            }
            return min + 1;
        } else if (charAt == '~') {
            return 2;
        } else {
            return isSeparator(charAt) ? 1 : 0;
        }
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength > str.length()) {
            failIfNullBytePresent(str + '/');
            return str + '/';
        }
        String substring = str.substring(0, prefixLength);
        failIfNullBytePresent(substring);
        return substring;
    }

    public static String getPath(String str) {
        return doGetPath(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return doGetPath(str, 0);
    }

    private static String doGetPath(String str, int i) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i2 = i + indexOfLastSeparator;
        if (prefixLength >= str.length() || indexOfLastSeparator < 0 || prefixLength >= i2) {
            return "";
        }
        String substring = str.substring(prefixLength, i2);
        failIfNullBytePresent(substring);
        return substring;
    }

    public static String getFullPath(String str) {
        return doGetFullPath(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return doGetFullPath(str, false);
    }

    private static String doGetFullPath(String str, boolean z) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            return z ? getPrefix(str) : str;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        if (indexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i = indexOfLastSeparator + (z ? 1 : 0);
        if (i == 0) {
            i++;
        }
        return str.substring(0, i);
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static void failIfNullBytePresent(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 0) {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        failIfNullBytePresent(str);
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return str;
        }
        return str.substring(0, indexOfExtension);
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equals(String str, String str2, boolean z, IOCase iOCase) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z) {
            str = normalize(str);
            str2 = normalize(str2);
            if (str == null || str2 == null) {
                throw new NullPointerException("Error normalizing one or both of the file names");
            }
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        return iOCase.checkEquals(str, str2);
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (str2 != null && !str2.isEmpty()) {
            return getExtension(str).equals(str2);
        }
        if (indexOfExtension(str) == -1) {
            return true;
        }
        return false;
    }

    public static boolean isExtension(String str, String[] strArr) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (strArr != null && strArr.length != 0) {
            String extension = getExtension(str);
            for (String str2 : strArr) {
                if (extension.equals(str2)) {
                    return true;
                }
            }
            return false;
        } else if (indexOfExtension(str) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        failIfNullBytePresent(str);
        if (collection != null && !collection.isEmpty()) {
            String extension = getExtension(str);
            for (String str2 : collection) {
                if (extension.equals(str2)) {
                    return true;
                }
            }
            return false;
        } else if (indexOfExtension(str) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        String[] splitOnTokens = splitOnTokens(str2);
        Stack stack = new Stack();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                i2 = iArr[0];
                i = iArr[1];
                z = true;
            }
            while (i2 < splitOnTokens.length) {
                if (splitOnTokens[i2].equals("?")) {
                    i++;
                    if (i > str.length()) {
                        break;
                    }
                } else if (splitOnTokens[i2].equals("*")) {
                    if (i2 == splitOnTokens.length - 1) {
                        i = str.length();
                    }
                    z = true;
                    i2++;
                } else {
                    if (!z) {
                        if (!iOCase.checkRegionMatches(str, i, splitOnTokens[i2])) {
                            break;
                        }
                    } else {
                        i = iOCase.checkIndexOf(str, i, splitOnTokens[i2]);
                        if (i == -1) {
                            break;
                        }
                        int checkIndexOf = iOCase.checkIndexOf(str, i + 1, splitOnTokens[i2]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i2, checkIndexOf});
                        }
                    }
                    i += splitOnTokens[i2].length();
                }
                z = false;
                i2++;
            }
            if (i2 == splitOnTokens.length && i == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }

    static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == '?' || c2 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c2 == '?') {
                    arrayList.add("?");
                } else if (c != '*') {
                    arrayList.add("*");
                }
            } else {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
