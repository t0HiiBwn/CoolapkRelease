package com.bytedance.sdk.openadsdk.preload.a;

import java.lang.reflect.Field;
import java.util.Locale;

/* compiled from: FieldNamingPolicy */
public enum d implements e {
    IDENTITY {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return a(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return a(a(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS {
        @Override // com.bytedance.sdk.openadsdk.preload.a.e
        public String a(Field field) {
            return a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String a(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }
}
