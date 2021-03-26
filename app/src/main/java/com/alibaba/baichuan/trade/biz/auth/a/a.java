package com.alibaba.baichuan.trade.biz.auth.a;

import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkBusiness;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkClient;
import com.alibaba.baichuan.trade.common.utils.JSONUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class a extends NetworkBusiness {
    public a() {
        this.API_NAME = "mtop.alibaba.baichuan.auth.token.get";
        this.IS_NEED_LOGIN = true;
        this.TIME_OUT = 90000;
    }

    private HashMap<String, Serializable> a(Set<String> set, String str) {
        HashMap<String, Serializable> hashMap = new HashMap<>();
        hashMap.put("hintArray", set == null ? "[]" : JSONUtils.toJsonString(new ArrayList(set)));
        if (str == null) {
            str = "";
        }
        hashMap.put("oldToken", str);
        return hashMap;
    }

    public boolean a(Set<String> set, String str, NetworkClient.NetworkRequestListener networkRequestListener) {
        return sendRequest(a(set, str), networkRequestListener);
    }
}
