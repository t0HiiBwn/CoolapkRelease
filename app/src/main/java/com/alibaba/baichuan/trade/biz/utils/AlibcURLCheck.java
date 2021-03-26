package com.alibaba.baichuan.trade.biz.utils;

import android.text.TextUtils;

public enum AlibcURLCheck {
    regular(0) {
        @Override // com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.matches(str2))) {
                    return true;
                }
            }
            return false;
        }
    },
    contains(1) {
        @Override // com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.contains(str2))) {
                    return true;
                }
            }
            return false;
        }
    },
    equal(2) {
        @Override // com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck
        public boolean check(String[] strArr, String str) {
            if (str == null) {
                return false;
            }
            for (String str2 : strArr) {
                if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !TextUtils.equals(str2, str))) {
                    return true;
                }
            }
            return false;
        }
    };
    
    public int type;
    public String[] urlList;

    private AlibcURLCheck(int i) {
        this.type = -1;
    }

    public static AlibcURLCheck getUrlCheckType(int i) {
        AlibcURLCheck alibcURLCheck = regular;
        return i != 0 ? i != 1 ? i != 2 ? alibcURLCheck : equal : contains : alibcURLCheck;
    }

    public abstract boolean check(String[] strArr, String str);
}
