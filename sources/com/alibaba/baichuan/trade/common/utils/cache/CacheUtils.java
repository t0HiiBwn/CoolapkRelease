package com.alibaba.baichuan.trade.common.utils.cache;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.adapter.security.AlibcSecurityGuard;
import java.util.ArrayList;
import java.util.List;

public class CacheUtils {
    public static final String SHARE_PREFERENCE_EXPIRE = "SHARE_PREFERENCE_EXPIRE";
    public static final String SHARE_PREFERENCE_NAME = "ali_bc_auth_cache";

    public static class CacheInfo {
        public String key;
        public String obj;

        public CacheInfo() {
        }

        public CacheInfo(String str, String str2) {
            this.key = str;
            this.obj = str2;
        }
    }

    public static void asyncPutCache(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new CacheInfo(str, str2));
            asyncPutCacheList(arrayList);
        }
    }

    public static void asyncPutCacheList(List<CacheInfo> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i) == null || TextUtils.isEmpty(list.get(i).key) || list.get(i).obj == null)) {
                    putCache(list.get(i).key, list.get(i).obj);
                }
            }
        }
    }

    public static void asyncPutEncryptedCache(String str, String str2) {
        asyncPutCache(str, AlibcSecurityGuard.getInstance().dynamicEncrypt(str2));
    }

    public static synchronized void cleanCache(String str) {
        synchronized (CacheUtils.class) {
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences.Editor edit = AlibcTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0).edit();
                edit.remove(str);
                edit.remove(str + "SHARE_PREFERENCE_EXPIRE");
                edit.apply();
            }
        }
    }

    public static synchronized String getCache(String str) {
        synchronized (CacheUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            SharedPreferences sharedPreferences = AlibcTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0);
            String string = sharedPreferences.getString(str, "");
            Long.valueOf(sharedPreferences.getLong(str + "SHARE_PREFERENCE_EXPIRE", 0));
            return string;
        }
    }

    public static String getDecryptedCache(String str) {
        String cache = getCache(str);
        if (!TextUtils.isEmpty(cache)) {
            return AlibcSecurityGuard.getInstance().dynamicDecrypt(cache);
        }
        return null;
    }

    public static synchronized void putCache(String str, String str2) {
        synchronized (CacheUtils.class) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                try {
                    SharedPreferences.Editor edit = AlibcTradeCommon.context.getSharedPreferences("ali_bc_auth_cache", 0).edit();
                    edit.putString(str, str2);
                    edit.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
