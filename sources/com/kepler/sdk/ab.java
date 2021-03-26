package com.kepler.sdk;

import java.util.HashMap;
import java.util.Map;

public class ab {
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = false;
    public static String d = "kepler exception";
    public static final Map<String, String> e;
    public static String f = "https://router.jd.com/api";
    public static String g = "https://joauth.jd.com/oauth/authorize?";
    public static String h = "https://kploauth.jd.com/oauth/passport_access_confirm";
    public static String i = "http://kepler.jd.com/oauth/code.do";
    public static String j = "https://kploauth.jd.com/oauth/token?";
    public static String k = "http://plogin.m.jd.com/user/login.action?qbautologin=false";
    public static String[] l = {"https://plogin.m.jd.com/user/login", "https://plogin.m.jd.com/cgi-bin/m/mlogin", "https://kepler.jd.com/oauth/sdk/do"};
    public static String m = "https://passport.m.jd.com/user/logout.action";
    public static String[] n = {".*\\.jd\\.com.*$", ".*\\.jd\\.hk.*$", ".*\\.yiyaojd\\.com.*$", ".*\\.admaster\\.com\\.cn.*$"};
    @Deprecated
    public static String o = "http://kepler.jd.com/category_q/jump?";
    public static String p = "https://item.m.jd.com/product";
    @Deprecated
    public static String q = "http://kepler.jd.com/freelogin/view";
    public static String r = "https://mapi.m.jd.com/js/ksdk/getUnpl.js";
    @Deprecated
    public static String s = "https://mapi.m.jd.com/js/ksdk/jdkeplerjsbridge.js";
    public static String t = "https://mapi.m.jd.com/js/ksdk/m.keepalive.js";
    public static String u = "https://mapi.m.jd.com/ksdk/mid-page.html";
    public static String v = ".jd.com;sid=\"\",.jd.hk;sid=\"\",.360buy.com;sid=\"\",.yiyaojd.com;sid=\"\"";

    static {
        if (0 == 0) {
            i.a(false);
        }
        HashMap hashMap = new HashMap();
        e = hashMap;
        hashMap.put("热门分类", "1098");
        hashMap.put("手机", "9987");
        hashMap.put("家用电器", "737");
        hashMap.put("电脑办公", "670");
        hashMap.put("摄影数码", "652");
        hashMap.put("女装服饰", "819");
        hashMap.put("男装服饰", "821");
        hashMap.put("时尚鞋靴", "11729");
        hashMap.put("内衣配件", "980");
        hashMap.put("运动户外", "1318");
        hashMap.put("珠宝饰品", "6144");
        hashMap.put("钟表", "5025");
        hashMap.put("母婴用品", "1319");
        hashMap.put("童装童鞋", "1014");
        hashMap.put("玩具乐器", "6233");
        hashMap.put("护肤美妆", "826");
        hashMap.put("清洁洗护", "1146");
        hashMap.put("皮具箱包", "1017");
        hashMap.put("家居家纺", "1620");
        hashMap.put("生活用品", "1018");
        hashMap.put("食品生鲜", "1019");
        hashMap.put("酒水饮料", "1020");
        hashMap.put("奢品礼品", "977");
        hashMap.put("家具建材", "6855");
        hashMap.put("热卖品牌", "1058");
        hashMap.put("营养保健", "91912");
        hashMap.put("汽车用品", "6728");
        hashMap.put("宠物专区", "6994");
        hashMap.put("图书音像", "833");
        hashMap.put("情趣用品", "1016");
    }
}
