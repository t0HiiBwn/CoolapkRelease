package com.alibaba.baichuan.trade.biz.urlroute;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.baichuan.trade.biz.core.config.AlibcConfigService;
import com.alibaba.baichuan.trade.biz.core.config.model.ConfigDO;
import com.alibaba.baichuan.trade.biz.utils.AlibcURLCheck;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlibcUriContext {
    private String a;
    private Map<String, List<String>> b = new LinkedHashMap();
    private String c;

    public AlibcUriContext(String str) {
        this.a = str;
        a();
    }

    private Map<String, List<String>> a(Map<String, String> map) {
        Map<String, List<String>> map2 = this.b;
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue()) && !map2.containsKey(entry.getKey())) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(entry.getValue());
                map2.put(entry.getKey(), arrayList);
            }
        }
        return map2;
    }

    private void a() {
        try {
            String uri = getUri();
            int indexOf = uri.indexOf("#");
            if (indexOf == -1) {
                this.c = null;
            } else if (indexOf != uri.length() - 1) {
                this.c = uri.substring(indexOf + 1);
            }
            int indexOf2 = uri.indexOf("?");
            this.b.clear();
            if (!(indexOf2 == -1 || indexOf2 == uri.length() - 1)) {
                if (indexOf == -1 || indexOf2 < indexOf) {
                    int i = indexOf2 + 1;
                    String[] split = (indexOf == -1 ? uri.substring(i) : uri.substring(i, indexOf)).split("[\\&]");
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            int indexOf3 = str.indexOf(61);
                            if (indexOf3 != -1) {
                                if (indexOf3 != str.length() - 1) {
                                    String decode = Uri.decode(str.substring(0, indexOf3));
                                    String decode2 = Uri.decode(str.substring(indexOf3 + 1));
                                    List<String> list = this.b.get(decode);
                                    if (list == null) {
                                        ArrayList arrayList = new ArrayList(2);
                                        arrayList.add(decode2);
                                        this.b.put(decode, arrayList);
                                    } else {
                                        list.add(decode2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            AlibcLogger.e("ui", "fail to parse the uri " + getUri(), e);
        }
    }

    private String b(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(Uri.encode(entry.getKey()));
                sb.append("=");
                sb.append(Uri.encode(value.get(i)));
            }
        }
        return sb.toString();
    }

    public static boolean isTradeAddParamURL(String str) {
        List<String> addParamUrls;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config == null || (addParamUrls = config.getAddParamUrls()) == null) {
            return false;
        }
        return AlibcURLCheck.regular.check((String[]) addParamUrls.toArray(new String[addParamUrls.size()]), str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    public String getAddParamsUrl(Map<String, String> map) {
        String b2;
        if (map == null || map.size() <= 0) {
            return this.a;
        }
        Map<String, List<String>> a2 = a(map);
        String uri = getUri();
        int indexOf = uri.indexOf("?");
        StringBuilder sb = new StringBuilder();
        if (indexOf != -1) {
            uri = uri.substring(0, indexOf);
        } else {
            int indexOf2 = uri.indexOf("#");
            if (indexOf2 != -1) {
                sb.append(uri.subSequence(0, indexOf2));
                b2 = b(a2);
                if (b2 != null) {
                    sb.append("?");
                    sb.append(b2);
                }
                if (this.c != null) {
                    sb.append("#");
                    sb.append(this.c);
                }
                return sb.toString();
            }
        }
        sb.append(uri);
        b2 = b(a2);
        if (b2 != null) {
        }
        if (this.c != null) {
        }
        return sb.toString();
    }

    public String getFragment() {
        return this.c;
    }

    public String getQueryParameter(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.b.get(str)) == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public String getUri() {
        return this.a;
    }
}
