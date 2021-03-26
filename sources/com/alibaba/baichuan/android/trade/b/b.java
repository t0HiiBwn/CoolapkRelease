package com.alibaba.baichuan.android.trade.b;

import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTaokeParam;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeTrackParam;
import com.alibaba.baichuan.trade.biz.core.taoke.AlibcTaokeParams;
import java.util.Map;

public class b {
    public static AlibcShowParams a(AlibcTradeShowParam alibcTradeShowParam) {
        OpenType openType;
        AlibcShowParams alibcShowParams = new AlibcShowParams();
        alibcShowParams.setBackUrl(alibcTradeShowParam.getBackUrl());
        alibcShowParams.setDegradeUrl(alibcTradeShowParam.getDegradeUrl());
        alibcShowParams.setClientType(alibcTradeShowParam.getClientType());
        alibcShowParams.setNativeOpenFailedMode(alibcTradeShowParam.getNativeOpenFailedMode());
        if (alibcTradeShowParam.getOpenType() == AlibcTradeShowParam.OpenType.Native) {
            alibcShowParams.setOpenType(OpenType.Native);
            openType = OpenType.Native;
        } else {
            alibcShowParams.setOpenType(OpenType.Auto);
            openType = OpenType.Auto;
        }
        alibcShowParams.setOriginalOpenType(openType);
        alibcShowParams.setProxyWebview(alibcTradeShowParam.isProxyWebview());
        alibcShowParams.setShowTitleBar(alibcTradeShowParam.isShowTitleBar());
        alibcShowParams.setTitle(alibcTradeShowParam.getTitle());
        return alibcShowParams;
    }

    public static AlibcTradeShowParam a(AlibcShowParams alibcShowParams) {
        AlibcTradeShowParam.OpenType openType;
        AlibcTradeShowParam alibcTradeShowParam = new AlibcTradeShowParam();
        alibcTradeShowParam.setBackUrl(alibcShowParams.getBackUrl());
        alibcTradeShowParam.setDegradeUrl(alibcShowParams.getDegradeUrl());
        alibcTradeShowParam.setClientType(alibcShowParams.getClientType());
        alibcTradeShowParam.setNativeOpenFailedMode(alibcShowParams.getNativeOpenFailedMode());
        alibcTradeShowParam.setIsClose(alibcShowParams.isClose());
        if (alibcShowParams.getOpenType().equals(OpenType.Native)) {
            alibcTradeShowParam.setOpenType(AlibcTradeShowParam.OpenType.Native);
            openType = AlibcTradeShowParam.OpenType.Native;
        } else {
            if (alibcShowParams.getOpenType().equals(OpenType.Auto)) {
                alibcTradeShowParam.setOpenType(AlibcTradeShowParam.OpenType.Auto);
                openType = AlibcTradeShowParam.OpenType.Auto;
            }
            alibcTradeShowParam.setProxyWebview(alibcShowParams.isProxyWebview());
            alibcTradeShowParam.setShowTitleBar(alibcShowParams.isShowTitleBar());
            alibcTradeShowParam.setTitle(alibcShowParams.getTitle());
            return alibcTradeShowParam;
        }
        alibcTradeShowParam.setOriginalOpenType(openType);
        alibcTradeShowParam.setProxyWebview(alibcShowParams.isProxyWebview());
        alibcTradeShowParam.setShowTitleBar(alibcShowParams.isShowTitleBar());
        alibcTradeShowParam.setTitle(alibcShowParams.getTitle());
        return alibcTradeShowParam;
    }

    public static AlibcTradeTaokeParam a(AlibcTaokeParams alibcTaokeParams) {
        if (alibcTaokeParams == null) {
            return null;
        }
        AlibcTradeTaokeParam alibcTradeTaokeParam = new AlibcTradeTaokeParam("", "", "");
        alibcTradeTaokeParam.setSubPid(alibcTaokeParams.subPid).setUnionId(alibcTaokeParams.unionId).setPid(alibcTaokeParams.pid);
        if (alibcTaokeParams.isAdZoneIdExist()) {
            alibcTradeTaokeParam.adzoneid = alibcTaokeParams.adzoneid;
        }
        alibcTradeTaokeParam.extraParams = alibcTaokeParams.extraParams;
        return alibcTradeTaokeParam;
    }

    public static AlibcTradeTrackParam a(Map<String, String> map) {
        AlibcTradeTrackParam alibcTradeTrackParam = new AlibcTradeTrackParam();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            alibcTradeTrackParam.put(entry.getKey(), entry.getValue());
        }
        return alibcTradeTrackParam;
    }

    public static AlibcTaokeParams a(AlibcTradeTaokeParam alibcTradeTaokeParam) {
        if (alibcTradeTaokeParam == null) {
            return null;
        }
        AlibcTaokeParams alibcTaokeParams = new AlibcTaokeParams("", "", "");
        alibcTaokeParams.setSubPid(alibcTradeTaokeParam.subPid).setUnionId(alibcTradeTaokeParam.unionId).setPid(alibcTradeTaokeParam.pid);
        if (alibcTradeTaokeParam.isAdZoneIdExist()) {
            alibcTaokeParams.adzoneid = alibcTradeTaokeParam.adzoneid;
        }
        alibcTaokeParams.extraParams = alibcTradeTaokeParam.extraParams;
        return alibcTaokeParams;
    }
}
