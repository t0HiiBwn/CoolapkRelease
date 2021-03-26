package com.alibaba.baichuan.trade.biz.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigBusiness;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.core.config.model.ExtendDO;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import com.alibaba.baichuan.trade.biz.utils.CacheUtil;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.Environment;
import com.alibaba.baichuan.trade.common.adapter.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import com.alibaba.baichuan.trade.common.utils.http.HttpHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlibcConfigService {
    private static AlibcConfigService c;
    public static String channel;
    private final long a = 21600000;
    private final long b = 3600000;
    private AlibcConfigBusiness d;
    private ConfigDO e;
    public long expiredTimeStamp = (System.currentTimeMillis() + 3600000);
    private JSONArray f;
    public String isvVersion = "1.0.0";
    public AlibcTaokeParams taokeParams;

    class a implements AlibcConfigBusiness.ConfigPullCallback {
        a() {
        }

        @Override // com.alibaba.baichuan.trade.biz.core.config.AlibcConfigBusiness.ConfigPullCallback
        public void onError(String str) {
            AlibcLogger.e("AlibcConfigService", "拉取新的配置数据失败");
        }

        @Override // com.alibaba.baichuan.trade.biz.core.config.AlibcConfigBusiness.ConfigPullCallback
        public void onSuccess(AlibcConfigAdapter alibcConfigAdapter, String str) {
            AlibcConfigService.this.e = alibcConfigAdapter.getConfig();
            if (AlibcConfigService.this.e != null) {
                CacheUtil.getInstance().setContent("bc_config", AlibcConfigService.this.e, true);
                final ExtendDO misc = AlibcConfigService.this.e.getMisc();
                if (misc != null && !TextUtils.isEmpty(misc.getUrlApi())) {
                    ExecutorServiceUtils.getInstance().postDelayTask(new Runnable() {
                        /* class com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService.a.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String str = HttpHelper.get(misc.getUrlApi(), null);
                                JSONObject jSONObject = (JSONObject) JSON.parse(str);
                                if (AlibcConfigBusiness.dataIsReal(String.valueOf(jSONObject.get("sign")), str)) {
                                    JSONArray jSONArray = (JSONArray) jSONObject.get("urls");
                                    AlibcConfigService.this.f = jSONArray;
                                    if (jSONArray != null && jSONArray.size() > 0) {
                                        CacheUtil.getInstance().setContent("pattern_urls", jSONArray, true);
                                        return;
                                    }
                                    return;
                                }
                                AlibcLogger.i("AlibcConfigService", "数据被篡改");
                            } catch (Exception e) {
                                AlibcLogger.e("AlibcConfigService", "解析异常:  msg=" + e.getMessage());
                            }
                        }
                    }, 2000);
                }
                AlibcUserTracker instance = AlibcUserTracker.getInstance();
                if (instance != null) {
                    AlibcConfigService alibcConfigService = AlibcConfigService.this;
                    instance.setSampling(alibcConfigService.a(alibcConfigService.e));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int a(ConfigDO configDO) {
        ExtendDO misc = configDO.getMisc();
        if (misc == null) {
            return 10000;
        }
        try {
            return Integer.parseInt(misc.getSampling());
        } catch (NumberFormatException unused) {
            AlibcLogger.e("AlibcConfigService", "number format exception");
            return 10000;
        }
    }

    public static synchronized AlibcConfigService getInstance() {
        AlibcConfigService alibcConfigService;
        synchronized (AlibcConfigService.class) {
            if (c == null) {
                c = new AlibcConfigService();
            }
            alibcConfigService = c;
        }
        return alibcConfigService;
    }

    public ConfigDO getConfig() {
        if (this.e == null) {
            this.e = (ConfigDO) CacheUtil.getInstance().getContent("bc_config");
        }
        return this.e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[SYNTHETIC, Splitter:B:21:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053 A[SYNTHETIC, Splitter:B:29:0x0053] */
    public String getFromAssets(String str) {
        Throwable th;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(AlibcTradeCommon.context.getResources().getAssets().open(str));
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String str2 = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str2 = str2 + readLine;
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                inputStreamReader.close();
                return str2;
            } catch (Exception unused) {
                try {
                    AlibcLogger.e("AlibcConfigService", "本地默认配置文件读取错误");
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
            AlibcLogger.e("AlibcConfigService", "本地默认配置文件读取错误");
            if (inputStreamReader != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public String getGlobalIsvCode() {
        ExtendDO misc = this.e.getMisc();
        if (misc != null) {
            return misc.getIsvCode();
        }
        return null;
    }

    public AlibcTaokeParams getGlobalTaokeParams() {
        return this.taokeParams;
    }

    public boolean getIsSyncForTaoke(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        return (configDO == null || (misc = configDO.getMisc()) == null) ? z : "YES".equals(misc.getIsSyncForTaoke());
    }

    public boolean getIsTUnionMtopDegrade() {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        if (configDO == null || (misc = configDO.getMisc()) == null) {
            return false;
        }
        return "YES".equals(misc.getIsTUnionMtopDegrade());
    }

    public boolean getLoginDegrade(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        return (configDO == null || (misc = configDO.getMisc()) == null) ? z : "YES".equals(misc.getLoginDegarade());
    }

    public AlibcTaokeParams getTaokeParams() {
        return this.taokeParams;
    }

    public long getTime() {
        return (AlibcTradeCommon.getEnvironment() == null || !AlibcTradeCommon.getEnvironment().equals(Environment.PRE)) ? 1800000 : 15000;
    }

    public JSONArray getUrls() {
        if (this.f == null) {
            this.f = (JSONArray) CacheUtil.getInstance().getContent("pattern_urls");
        }
        return this.f;
    }

    public void init(Context context, String str) {
        this.d = new AlibcConfigBusiness(context, new a(), str);
        try {
            if (((ConfigDO) CacheUtil.getInstance().getContent("bc_config")) == null) {
                AlibcLogger.i("AlibcConfigService", "初始化读取文件存储数据为空");
                ConfigDO configDO = (ConfigDO) JSONObject.parseObject("{\"version\":\"1.0\",\"sign\":\"523f78c45d8a2bf539dddd50be87dba6\",\"forbidByCode\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao.com/cm/snap/index\\\\.html(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.taobao.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.tmall.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop(.*)\\\\.(.*)\\\\.taobao.com/shop/shopIndex.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cart/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/order\\\\.htm(.*)\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirmOrderWap\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/cart\\\\.htm(.*)\",\"^http(s)?://cart\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/myCart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/bag\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/olist\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/olist/index\\\\.htm(.*)\",\"^http(s)?://login\\\\.(.*)\\\\.taobao.com/login\\\\.htm(.*)$\",\"^http(s)?://login\\\\.tmall\\\\.com(.*)$\",\"^http(s)?://login.taobao.com/member/login.jhtml(.*)$\",\"^http(s)?://login\\\\.(.*)\\\\.taobao\\\\.com/logout(.*)$\"],\"codeConfig\":[{\"name\":\"detail\",\"url\":\"https://h5.m.taobao.com/awp/core/detail.htm\"},{\"name\":\"shop\",\"url\":\"https://shop.m.taobao.com/shop/shop_index.htm\"},{\"name\":\"cart\",\"url\":\"https://main.m.taobao.com/cart/index.html\"},{\"name\":\"addCart\",\"url\":\"https://h5.m.taobao.com/cm/snap/index.html\"},{\"name\":\"olist\",\"url\":\"https://h5.m.taobao.com/mlapp/olist.html\"}],\"urlTypeConfig\":[{\"type\":\"h5\",\"pattern\":[\"reg1\",\"reg2\"]},{\"type\":\"miniapp\",\"pattern\":[\"^http(s)?://m.duanqu.com(.*)\"]}],\"routeConfig\":[{\"match\":\"(^http(s)?://login(\\\\..*)?\\\\.taobao.com(.*)$)|(^http(s)?://login\\\\.tmall\\\\.com(.*)$)|(^http(s)?://login.taobao.com/member/login.jhtml(.*)$)|(^http(s)?://login\\\\.(.*)\\\\.taobao\\\\.com/logout(.*)$)|(^http(s)?://(maliprod|mclient|premcgw)\\\\.alipay\\\\.com/w/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/w/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(maliprod|mclient)\\\\.alipay\\\\.com/(trade_pay|batch_payment)\\\\.do(.*)$)|(^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/(trade_pay|batch_payment)\\\\.do(.*)$)|(.*wapp.m.taobao.com.*)|(^https?://temai\\\\.m\\\\.taobao\\\\.com/index\\\\.htm.*$)|(^https?://temai\\\\.m\\\\.taobao\\\\.com/search\\\\.htm.*$)|(^https?://mo\\\\.m\\\\.taobao\\\\.com/union/chaojidanpin20181201.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/union/pinpaitemaib.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/activity_newer.*$)|(^https?://oauth(\\\\.m)?\\\\.taobao\\\\.com/authorize.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/register.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/offline-verify.*$)|(^https?://mos\\\\.m\\\\.taobao\\\\.com/inviter/recruit.*$)|(^https?://market(.*)?\\\\.taobao\\\\.com/app/dinamic/h5-tb-detail/index\\\\.html.*$)|(^https?://main(.*)?\\\\.taobao\\\\.com/detail/index\\\\.html.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/nv/haiwaiju/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/o/juhuasuanliyid/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/o/fcdp2017/mtp\\\\.htm.*$)|(^https?://ju\\\\.taobao\\\\.com/m/jusp/other/lftnew/mtp\\\\.htm.*$)|(^https?://uland\\\\.taobao\\\\.com/semm/tbsearch.*$)\",\"index\":[],\"action\":[{\"openType\":\"h5\",\"param\":{}}]},{\"match\":\"(^http(s)?://h5\\\\.(.*)\\\\.taobao.com/cm/snap/index\\\\.html(.*))|(^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*))|(^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*))\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{\"clientType\":\"taobao\",\"clientPage\":\"detail\"}}]},{\"match\":\"(^http(s)?://shop\\\\.(.*)\\\\.taobao.com/shop/shop_index.htm(.*))|(^http(s)?://shop\\\\.(.*)\\\\.tmall.com/shop/shop_index.htm(.*))|(^http(s)?://shop(.*)\\\\.(.*)\\\\.taobao.com/shop/shopIndex.htm(.*))\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{\"clientType\":\"taobao\",\"clientPage\":\"shop\"}}]},{\"match\":\"^https?:\\\\/\\\\/(([^/\\\\?#]+\\\\.)*((rantu|aligames|fliggy|youku|taobao|jaeapp|cainiao|guoguo-app|tmall|juhuasuan|xiami|amap|taobaocdn|alipay|etao|alibaba|aliyun|alimama|weibo|tanx|laiwang|alicdn|mmstat|yunos|alibaba-inc|alitrip|aliloan|kanbox|wirlesshare|duanqu|dingtalk|alimei|cnzz|kuaidadi|autonavi|m\\\\.yintai|polyinno|spdyidea|h5util|h5tool|5945i|miaostreet|1688)\\\\.com|(tb|tbcdn|weibo|mashort|mybank|ba\\\\.ugame\\\\.uc|game\\\\.uc)\\\\.cn|(fastidea|juzone|tb\\\\.ele)\\\\.(me|cc)|lwurl\\\\.to|taobao\\\\.net|tdd\\\\.la|yao\\\\.95095\\\\.com|tmall\\\\.hk|ahd\\\\.so|atb\\\\.so|mshare\\\\.cc|juhs\\\\.me|xianyu\\\\.mobi)([\\\\?|#|/].*)?|go(/.*)?)$\",\"index\":[],\"action\":[{\"openType\":\"native\",\"param\":{\"clientType\":\"taobao\"}}]}],\"bizPattern\":[{\"bizCode\":\"detail\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao.com/cm/snap/index\\\\.html(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*)\"]},{\"bizCode\":\"shop\",\"pattern\":[\"^http(s)?://shop\\\\.(.*)\\\\.taobao.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.tmall.com/shop/shop_index.htm(.*)\",\"^http(s)?://shop(.*)\\\\.(.*)\\\\.taobao.com/shop/shopIndex.htm(.*)\"]},{\"bizCode\":\"order\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cart/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/order\\\\.htm(.*)\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirmOrderWap\\\\.htm(.*)\"]},{\"bizCode\":\"cart\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/cart\\\\.htm(.*)\",\"^http(s)?://cart\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/myCart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/bag\\\\.htm(.*)\"]},{\"bizCode\":\"olist\",\"pattern\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/olist\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/olist/index\\\\.htm(.*)\"]},{\"bizCode\":\"logout\",\"pattern\":[\"^http(s)?://login\\\\.(.*)\\\\.taobao\\\\.com/logout(.*)$\"]},{\"bizCode\":\"login\",\"pattern\":[\"^http(s)?://login(\\\\..*)?\\\\.taobao.com(.*login.*)$\",\"^http(s)?://login\\\\.tmall\\\\.com(.*)$\",\"^http(s)?://login.taobao.com/member/login.jhtml(.*)$\"]},{\"bizCode\":\"alipay\",\"pattern\":[\"^http(s)?://(maliprod|mclient|premcgw)\\\\.alipay\\\\.com/w/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/w/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(maliprod|mclient)\\\\.alipay\\\\.com/(trade_pay|batch_payment)\\\\.do(.*)$\",\"^http(s)?://(mobileclientgw|maliprod)\\\\.stable\\\\.alipay\\\\.net/(trade_pay|batch_payment)\\\\.do(.*)$\"]},{\"bizCode\":\"alipayReceipt\",\"pattern\":[\".*://safepay.*\"]}],\"addParamUrls\":[\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cm/snap/index\\\\.html(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/base/bag\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/cart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/cart/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/awp/core/detail\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/mlapp/olist\\\\.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.taobao\\\\.com/shop/shopIndex\\\\.htm(.*)\",\"^http(s)?://shop\\\\.(.*)\\\\.taobao\\\\.com/shop/shop_index\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.taobao\\\\.com/trade/detail\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/olist/index\\\\.htm(.*)\",\"^http(s)?://main\\\\.(.*)\\\\.taobao\\\\.com/cart/index\\\\.htm(.*)\",\"^http(s)?://detail\\\\.(.*)\\\\.tmall\\\\.(com|hk)/item\\\\.htm(.*)\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirmOrderWap\\\\.htm(.*)\",\"^http(s)?://((?!(login|buy|s.click))\\\\.)(.*)\\\\.tmall\\\\.com(.*)$\",\"^http(s)?://buy\\\\.(.*)\\\\.tmall\\\\.(com|hk)/order/confirm_order_wap\\\\.htm(.*)\",\"^http(s)?://cart\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/myCart\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/awp/base/order\\\\.htm(.*)\",\"^http(s)?://h5\\\\.(.*)\\\\.tmall\\\\.(com|hk)/cart/order\\\\.htm(.*)\"],\"misc\":{\"failMode\":\"download\",\"isNeedAlipay\":\"YES\",\"sampling\":\"10000\",\"loginDegarade\":\"NO\",\"isSyncForTaoke\":\"YES\"}}", ConfigDO.class);
                this.e = configDO;
                if (configDO != null) {
                    CacheUtil.getInstance().setContent("bc_config", this.e, true);
                }
            }
        } catch (Exception e2) {
            AlibcLogger.e("AlibcConfigService", "初始化解析或写入文件异常: " + e2.getMessage());
        }
        AlibcConfigBusiness alibcConfigBusiness = this.d;
        if (alibcConfigBusiness != null) {
            alibcConfigBusiness.startProcessor(str);
        }
    }

    public void setConfig(ConfigDO configDO) {
        this.e = configDO;
    }

    public boolean setIsSyncForTaoke(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        if (configDO == null || (misc = configDO.getMisc()) == null) {
            return false;
        }
        misc.setIsSyncForTaoke(z ? "YES" : "NO");
        return true;
    }

    public void setIsTUnionMtopDegrade(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        if (configDO != null && (misc = configDO.getMisc()) != null) {
            misc.setIsTUnionMtopDegrade(z ? "YES" : "NO");
        }
    }

    public boolean setIsvCode(String str) {
        ExtendDO misc = this.e.getMisc();
        if (misc == null) {
            return false;
        }
        misc.setIsvCode(str);
        return true;
    }

    public boolean setShouldUseAlipay(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        if (configDO == null || (misc = configDO.getMisc()) == null) {
            return false;
        }
        misc.setIsNeedAlipay(z ? "YES" : "NO");
        return true;
    }

    public void setTaokeParams(AlibcTaokeParams alibcTaokeParams) {
        if (alibcTaokeParams != null) {
            this.taokeParams = alibcTaokeParams;
        }
    }

    public void setUrls(JSONArray jSONArray) {
        this.f = jSONArray;
    }

    public boolean shouldUseAlipay(boolean z) {
        ExtendDO misc;
        ConfigDO configDO = this.e;
        return (configDO == null || (misc = configDO.getMisc()) == null) ? z : "YES".equals(misc.getIsNeedAlipay());
    }
}
