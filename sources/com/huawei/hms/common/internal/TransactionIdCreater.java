package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransactionIdCreater {
    public static String getId(String str, String str2) {
        return StringUtil.addByteForNum(str, 9, '0') + StringUtil.addByteForNum(str2, 6, '0') + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new SecureRandom().nextInt(1000000)));
    }
}
