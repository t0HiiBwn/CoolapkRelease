package com.alibaba.baichuan.trade.biz.core.taoke.a;

import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkBusiness;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;

public class c extends NetworkBusiness {
    public c() {
        this.API_NAME = "mtop.alibaba.baichuan.nbsdk.sclick.create";
    }

    public static String a(NetworkResponse networkResponse) {
        if (networkResponse.data == null || !networkResponse.isSuccess || !networkResponse.errorCode.equals("SUCCESS")) {
            return null;
        }
        return networkResponse.data.get("data").toString();
    }
}
