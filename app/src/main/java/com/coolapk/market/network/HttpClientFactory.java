package com.coolapk.market.network;

import android.text.TextUtils;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.LogUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSource;

public class HttpClientFactory {
    private static final String CLIENT_COOL_MARKET = "COOL_MARKET";
    private static final String CLIENT_COOL_MARKET_DOWNLOAD = "COOL_MARKET_DOWNLOAD";
    private static final String CLIENT_HTTP_DNS = "HTTP_DNS";
    private static final String CLIENT_NORMAL = "NORMAL";
    private static final String CLIENT_VIDEO_PARAMS = "VIDEO_PARAMS";
    private final OkHttpClient httpClient;
    private final Map<String, OkHttpClient> httpClients;

    private static class SingletonHolder {
        private static final HttpClientFactory INSTANCE = new HttpClientFactory();

        private SingletonHolder() {
        }
    }

    public static HttpClientFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private HttpClientFactory() {
        this.httpClients = new HashMap();
        this.httpClient = new OkHttpClient.Builder().protocols(Collections.singletonList(Protocol.HTTP_1_1)).build();
    }

    public OkHttpClient getCoolMarketHttpClient() {
        OkHttpClient okHttpClient = this.httpClients.get("COOL_MARKET");
        if (okHttpClient != null) {
            return okHttpClient;
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient build = this.httpClient.newBuilder().addInterceptor(new CoolMarketHeaderInterceptor()).addInterceptor(new ClientInterceptor()).addInterceptor(new CoolMarketDynamicHostInterceptor()).addInterceptor(httpLoggingInterceptor).connectTimeout(30, TimeUnit.SECONDS).writeTimeout(40, TimeUnit.SECONDS).cookieJar(new CoolMarketCookieJar()).dns(OkHttpDns.getInstance(DataManager.getInstance().getDataConfig().getApplicationContext())).build();
        this.httpClients.put("COOL_MARKET", build);
        return build;
    }

    public OkHttpClient getCoolMarketDownloadHttpClient() {
        OkHttpClient okHttpClient = this.httpClients.get("COOL_MARKET_DOWNLOAD");
        if (okHttpClient != null) {
            return okHttpClient;
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient build = this.httpClient.newBuilder().addInterceptor(new CoolMarketHeaderInterceptor()).addInterceptor(httpLoggingInterceptor).addInterceptor(new ClientInterceptor()).connectTimeout(40, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(40, TimeUnit.SECONDS).cookieJar(new CoolMarketCookieJar()).dns(OkHttpDns.getInstance(DataManager.getInstance().getDataConfig().getApplicationContext())).build();
        this.httpClients.put("COOL_MARKET_DOWNLOAD", build);
        return build;
    }

    public OkHttpClient getDownloadHttpClient() {
        OkHttpClient okHttpClient = this.httpClients.get("NORMAL");
        if (okHttpClient != null) {
            return okHttpClient;
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient build = this.httpClient.newBuilder().addInterceptor(httpLoggingInterceptor).connectTimeout(40, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(40, TimeUnit.SECONDS).build();
        this.httpClients.put("NORMAL", build);
        return build;
    }

    public OkHttpClient getVideoParamsHttpClient() {
        OkHttpClient okHttpClient = this.httpClients.get("VIDEO_PARAMS");
        if (okHttpClient != null) {
            return okHttpClient;
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient build = this.httpClient.newBuilder().addInterceptor(httpLoggingInterceptor).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
        this.httpClients.put("VIDEO_PARAMS", build);
        return build;
    }

    private static class CoolMarketDynamicHostInterceptor implements Interceptor {
        private CoolMarketDynamicHostInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url();
            if (!url.host().matches("api.{0,8}\\.coolapk\\.com")) {
                return chain.proceed(request);
            }
            DataConfig dataConfig = DataManager.getInstance().getDataConfig();
            Request.Builder newBuilder = request.newBuilder();
            String apiHost = DataManager.getInstance().getDataConfig().getApiHost();
            boolean z = false;
            if (!dataConfig.isDebugEnabled()) {
                Map<String, String> specialHosts = dataConfig.getSpecialHosts();
                String encodedPath = url.encodedPath();
                Iterator<String> it2 = specialHosts.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (Pattern.matches(it2.next(), encodedPath)) {
                        String str = specialHosts.get(encodedPath);
                        if (str != null) {
                            newBuilder = newBuilder.url(url.newBuilder().host(str).build());
                            z = true;
                        }
                    }
                }
            }
            if (!z) {
                newBuilder = newBuilder.url(url.newBuilder().host(apiHost).build());
            }
            Response proceed = chain.proceed(newBuilder.build());
            if (!url.encodedPath().startsWith("/v6/main/in") || proceed.code() != 200 || !isBodyEmpty(proceed).booleanValue()) {
                return proceed;
            }
            dataConfig.requestChangeApiHost();
            String apiHost2 = dataConfig.getApiHost();
            return !TextUtils.equals(apiHost, apiHost2) ? chain.proceed(newBuilder.url(url.newBuilder().host(apiHost2).build()).build()) : proceed;
        }

        private Boolean isBodyEmpty(Response response) {
            ResponseBody body = response.body();
            boolean z = true;
            if (body == null) {
                return true;
            }
            try {
                BufferedSource source = body.source();
                source.request(Long.MAX_VALUE);
                if (source.getBuffer().size() != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private static class CoolMarketHeaderInterceptor implements Interceptor {
        private CoolMarketHeaderInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            request.url();
            Request.Builder newBuilder = request.newBuilder();
            try {
                List<String> coolMarketHeaders = DataManager.getInstance().getDataConfig().getCoolMarketHeaders();
                for (int i = 0; i < coolMarketHeaders.size(); i += 2) {
                    newBuilder.header(coolMarketHeaders.get(i), coolMarketHeaders.get(i + 1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chain.proceed(newBuilder.build());
        }
    }

    private static class ClientInterceptor implements Interceptor {
        private ClientInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response proceed = chain.proceed(chain.request());
            try {
                DataManager.getInstance().getDataConfig().onNetworkResponse(proceed);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return proceed;
        }
    }

    private static class CoolMarketCookieJar implements CookieJar {
        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        private CoolMarketCookieJar() {
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            ArrayList arrayList = new ArrayList();
            if (!(httpUrl == null || httpUrl.host() == null)) {
                String lowerCase = httpUrl.host().toLowerCase();
                if (lowerCase.endsWith(".coolapk.com") || lowerCase.equals("coolapk.com")) {
                    LogUtils.v("Add cookies, host: %s", httpUrl.host());
                    DataConfig dataConfig = DataManager.getInstance().getDataConfig();
                    LoginSession loginSession = DataManager.getInstance().getLoginSession();
                    if (loginSession.isLogin()) {
                        arrayList.add(new Cookie.Builder().domain(dataConfig.getCookieDomain()).path(dataConfig.getCookiePath()).name("uid").value(loginSession.getUid()).build());
                        try {
                            arrayList.add(new Cookie.Builder().domain(dataConfig.getCookieDomain()).path(dataConfig.getCookiePath()).name("username").value(URLEncoder.encode(loginSession.getUserName(), dataConfig.getCookieCharset())).build());
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        try {
                            arrayList.add(new Cookie.Builder().domain(dataConfig.getCookieDomain()).path(dataConfig.getCookiePath()).name("token").value(URLEncoder.encode(loginSession.getToken(), dataConfig.getCookieCharset())).build());
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return arrayList;
        }
    }
}
