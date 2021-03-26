package com.tencent.tpns.baseapi.base;

import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Util;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: ProGuard */
public class DNSResolver implements Runnable {
    public static byte DNS_REASON = 0;
    private static String a = "DNSResolver";
    private String b;
    private String c;

    private DNSResolver(String str) {
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            set(b(this.b));
        } catch (Throwable th) {
            String str = a;
            TBaseLogger.ww(str, "unexpected for dns resolver:" + th.getMessage());
        }
    }

    public synchronized void set(String str) {
        this.c = str;
    }

    public synchronized String get() {
        return this.c;
    }

    public static String hostToIp(String str, String str2) {
        String str3;
        String str4;
        String str5 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("Get MqttServer address: ");
        sb.append(str);
        sb.append(", portList:");
        sb.append(str2 == null ? "null" : str2);
        Logger.i(str5, sb.toString());
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrEmptyString(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (JSONException e) {
                Logger.e(a, "Get MqttServer parse mqttPortList error ", e);
            }
        }
        if (arrayList.size() > 0) {
            str3 = (String) arrayList.get(new Random().nextInt(arrayList.size()));
            Logger.i(a, "Get MqttServer random port: " + str3);
        } else {
            str3 = "1883";
            Logger.i(a, "Get MqttServer use default port: " + str3);
        }
        String str6 = null;
        if (str.startsWith("tcp://")) {
            try {
                String[] split = str.substring(6).split(":");
                if (split.length > 1) {
                    str4 = split[0];
                    Logger.i(a, "Get MqttServer address no need to parse, ip: ");
                }
            } catch (Throwable th) {
                Logger.e(a, "Get MqttServer parse tcp ip error ", th);
            }
            str4 = null;
            Logger.i(a, "Get MqttServer address no need to parse, ip: ");
        } else {
            DNSResolver dNSResolver = new DNSResolver(str);
            try {
                Thread thread = new Thread(dNSResolver);
                thread.start();
                thread.join(4000);
            } catch (Throwable th2) {
                Logger.e(a, "t.join", th2);
            }
            str4 = dNSResolver.get();
        }
        if (Util.isNullOrEmptyString(str4)) {
            TBaseLogger.ee(a, "Get MqttServer ip is null");
        } else {
            str6 = "tcp://" + str4 + ":" + str3;
        }
        TBaseLogger.i(a, "DNS " + str + " -> " + str6);
        return str6;
    }

    private static boolean a(String str) {
        return str == null || str.equals("");
    }

    private static String b(String str) {
        InetAddress inetAddress;
        if (a(str)) {
            return null;
        }
        try {
            long nanoTime = System.nanoTime();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            long nanoTime2 = System.nanoTime();
            if (allByName == null || allByName.length <= 0) {
                inetAddress = null;
            } else {
                inetAddress = allByName[0];
                DNS_REASON = 2;
                TBaseLogger.dd(a, "getAllByName: " + Arrays.toString(allByName) + " in " + ((nanoTime2 - nanoTime) / 1000000) + "ms");
            }
            if (inetAddress != null) {
                TBaseLogger.d(a, "addr:" + inetAddress.getHostAddress());
                if (inetAddress instanceof Inet4Address) {
                    return inetAddress.getHostAddress();
                }
                if (inetAddress instanceof Inet6Address) {
                    return "[" + inetAddress.getHostAddress() + "]";
                }
            }
        } catch (Throwable th) {
            Logger.e(a, "NSLookup error: ", th);
            DNS_REASON = 2;
        }
        return null;
    }
}
