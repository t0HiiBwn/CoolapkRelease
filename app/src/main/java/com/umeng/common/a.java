package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: EncryptHelper */
public class a {
    private static String a = null;
    private static final String b = "umeng+";
    private static final String c = "ek__id";
    private static final String d = "ek_key";
    private static String e = "";
    private static final String f = "umeng_subprocess_info";
    private static String g = "";
    private static a h;

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    private String c(String str) {
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < substring.length(); i++) {
                char charAt = substring.charAt(i);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            String sb2 = sb.toString();
            return sb2 + new StringBuilder(sb2).reverse().toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, "ek__id");
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    e = c(multiProcessSP);
                    UMRTLog.e("MobclickRT", "--->>>> primaryKey: " + e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("umeng_subprocess_info", 0);
                if (sharedPreferences != null) {
                    g = sharedPreferences.getString("ek__id", null);
                    UMRTLog.e("MobclickRT", "--->>> 子进程备份秘钥：主进程key: " + g);
                }
                a = c(UMUtils.genId());
                UMRTLog.e("MobclickRT", "--->>>> 正式秘钥：key: " + a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(e)) {
                return null;
            }
            UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
                try {
                    UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), g.getBytes()));
                        try {
                            UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                            return str2;
                        } catch (Throwable unused3) {
                            str3 = str2;
                            UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                            return str3;
                        }
                    } catch (Throwable unused4) {
                        UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
                UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), g.getBytes()));
                UMRTLog.e("MobclickRT", "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                return str2;
            }
        }
    }
}
