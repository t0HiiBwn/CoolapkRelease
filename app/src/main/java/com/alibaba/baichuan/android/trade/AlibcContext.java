package com.alibaba.baichuan.android.trade;

import android.content.Context;

public class AlibcContext {
    public static String ETICKET_URL = null;
    public static String HOME_URL = "https://h5.m.taobao.com/";
    public static String MINI_APP_BASE_URL = "https://m.duanqu.com?";
    public static String MINI_SHOUTAO_ITEM_DETAIL_URL = null;
    public static String MY_ORDERS_URL = null;
    public static String PROMOTION_URL = null;
    public static String SHOUTAO_ITEM_DETAIL_URL = null;
    public static String SHOW_CART_URL = null;
    public static String TB_ITEM_DETAIL_URL = null;
    public static String TB_SHOP_URL = null;
    public static String TMALL_ITEM_DETAIL_URL = null;
    public static volatile Context context = null;
    public static String[] detailPatterns = {"^http(s)?://h5\\.(.*)\\.taobao.com/cm/snap/index\\.html(.*)", "^http(s)?://h5\\.(.*)\\.taobao\\.com/awp/core/detail\\.htm(.*)", "^http(s)?://detail\\.(.*)\\.tmall\\.(com|hk)/item\\.htm(.*)"};
    public static volatile boolean isShowTitleBar = true;
    public static boolean isVip;
    public static String[] tunionUrlPatterns = {"^http[s]{0,1}:\\/\\/s\\.click\\.taobao\\.com\\/(.*)", "^http[s]{0,1}:\\/\\/uland\\.taobao\\.com\\/(.*)", "^http[s]?://pre-uland\\.taobao\\.com/(.*)"};
}
