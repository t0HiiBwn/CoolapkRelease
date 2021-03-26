package com.alibaba.baichuan.trade.biz.core.taoke.a;

import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkBusiness;
import com.alibaba.baichuan.trade.common.adapter.mtop.NetworkResponse;
import java.util.HashMap;

public class a extends NetworkBusiness {
    public a() {
        this.API_NAME = "mtop.taobao.tbk.sdk.item.convertnew";
        this.IS_POST = false;
    }

    public static String a(NetworkResponse networkResponse) {
        if (networkResponse.data == null || !networkResponse.isSuccess || !networkResponse.errorCode.equals("SUCCESS")) {
            return null;
        }
        return (String) ((HashMap) networkResponse.data.get("convert")).get("url");
    }
}
