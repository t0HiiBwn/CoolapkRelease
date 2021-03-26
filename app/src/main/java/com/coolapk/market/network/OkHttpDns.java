package com.coolapk.market.network;

import android.content.Context;
import android.text.TextUtils;
import com.coolapk.market.manager.DataManager;
import com.tencent.msdk.dns.DnsConfig;
import com.tencent.msdk.dns.DnsService;
import com.tencent.msdk.dns.core.IpSet;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

public class OkHttpDns implements Dns {
    private static OkHttpDns instance;
    private final List<InetAddress> EMPTY = new ArrayList();

    public static OkHttpDns getInstance(Context context) {
        if (instance == null) {
            instance = new OkHttpDns(context);
        }
        return instance;
    }

    private OkHttpDns(Context context) {
        String uid = DataManager.getInstance().getLoginSession().getUid();
        new String[]{"api.coolapk.com", "api2.coolapk.com", "api-dev.coolapk.com", "api-live.coolapk.com", "dl.coolapk.com", "dl.coolapkmarket.com", "dl-cdn.coolapkmarket.com", "dl-tc.coolapkmarket.com"};
        DnsService.init(context, new DnsConfig.Builder().logLevel(6).appId("0I000A6IM54O5ELZ").userId(TextUtils.isEmpty(uid) ? "0000" : uid).initBuiltInReporters().dnsId("3268").dnsKey("3E9dYOvC").timeoutMills(1000).build());
    }

    private String getProxyHost() {
        return System.getProperty("http.proxyHost");
    }

    private String getProxyPort() {
        return System.getProperty("http.proxyPort");
    }

    private Boolean isUsingHttpProxy() {
        return Boolean.valueOf((getProxyHost() == null || getProxyPort() == null) ? false : true);
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        if (isUsingHttpProxy().booleanValue()) {
            return Dns.SYSTEM.lookup(str);
        }
        IpSet addrsByName = DnsService.getAddrsByName(str);
        String[] strArr = addrsByName.v4Ips;
        if (addrsByName == IpSet.EMPTY || strArr.length <= 0) {
            return Dns.SYSTEM.lookup(str);
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            try {
                arrayList.add(InetAddress.getByName(str2));
            } catch (UnknownHostException unused) {
            }
        }
        return arrayList;
    }
}
