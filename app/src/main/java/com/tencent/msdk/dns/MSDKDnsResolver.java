package com.tencent.msdk.dns;

import android.content.Context;
import com.tencent.msdk.dns.DnsConfig;
import com.tencent.msdk.dns.base.e.a;
import com.tencent.msdk.dns.base.log.ILogNode;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.IpSet;

public class MSDKDnsResolver {
    public static final String AES_HTTP_CHANNEL = "AesHttp";
    public static final String DES_HTTP_CHANNEL = "DesHttp";
    public static final String UDP_CHANNEL = "Udp";
    private static volatile MSDKDnsResolver sInstance;

    public static MSDKDnsResolver getInstance() {
        if (sInstance == null) {
            synchronized (MSDKDnsResolver.class) {
                if (sInstance == null) {
                    sInstance = new MSDKDnsResolver();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context, String str, boolean z, int i) {
        init(context, str, z, i, true);
    }

    public void init(Context context, String str, boolean z, int i, boolean z2) {
        try {
            init(context, str, (String) null, (String) null, z, i, z2);
        } catch (Exception unused) {
        }
    }

    public void init(Context context, String str, String str2, String str3, boolean z, int i) {
        init(context, str, str2, str3, z, i, true);
    }

    public void init(Context context, String str, String str2, String str3, boolean z, int i, boolean z2) {
        init(context, str, str2, str3, z, i, z2 ? "DesHttp" : "Udp");
    }

    public void init(Context context, String str, String str2, String str3, boolean z, int i, String str4) {
        DnsConfig.Builder timeoutMills = new DnsConfig.Builder().logLevel(z ? 3 : 5).appId(str).timeoutMills(i);
        if (str2 != null) {
            timeoutMills.dnsId(str2);
        }
        if (str3 != null) {
            timeoutMills.dnsKey(str3);
        }
        if ("Udp".equals(str4)) {
            timeoutMills.udp();
        } else if ("AesHttp".equals(str4)) {
            timeoutMills.aesHttp();
        } else {
            timeoutMills.desHttp();
        }
        DnsService.init(context, timeoutMills.build());
        b.b("MSDKDnsResolver.init() called, ver:%s, channel:%s", "3.3.0a", str4);
    }

    public boolean WGSetDnsOpenId(String str) {
        b.a("MSDKDnsResolver.WGSetDnsOpenId() called.", new Object[0]);
        try {
            DnsService.setUserId(str);
            return true;
        } catch (Exception e) {
            b.c(e, "WGSetDnsOpenId failed", new Object[0]);
            return false;
        }
    }

    public String getAddrByName(String str) {
        return getAddrByName(str, "DesHttp", -1);
    }

    public String getAddrByName(String str, String str2) {
        return getAddrByName(str, str2, -1);
    }

    public String getAddrByName(String str, String str2, int i) {
        b.b("MSDKDnsResolver.getAddrByName() called, domain:" + str + ", channel:" + str2 + ", token:" + i, new Object[0]);
        IpSet ipSet = IpSet.EMPTY;
        try {
            ipSet = DnsService.getAddrsByName(str, str2, i);
        } catch (Exception unused) {
        }
        String str3 = "0";
        String str4 = !a.a(ipSet.v4Ips) ? ipSet.v4Ips[0] : str3;
        if (!a.a((Object[]) ipSet.v6Ips)) {
            str3 = ipSet.v6Ips[0];
        }
        return str4 + ";" + str3;
    }

    public String getDnsDetail(String str) {
        b.a("MSDKDnsResolver.getDnsDetail() called.", new Object[0]);
        try {
            return DnsService.getDnsDetail(str);
        } catch (Exception e) {
            b.a("getDnsDetail exception:" + e, new Object[0]);
            return "";
        }
    }

    public void addLogNode(ILogNode iLogNode) {
        b.a(iLogNode);
    }
}
