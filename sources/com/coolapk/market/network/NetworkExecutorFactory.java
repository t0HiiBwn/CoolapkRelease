package com.coolapk.market.network;

import com.coolapk.market.download.DownloadUtils;
import com.coolapk.market.download.NetworkExecutor;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.util.CacheUrlUtils;

public class NetworkExecutorFactory {
    public static NetworkExecutor newExecutor(String str, String[] strArr) {
        if (CacheUrlUtils.isCoolMarketHost(str)) {
            return new CoolMarketDownloadNetworkExecutor(mergeDownloadHeaders(str, strArr));
        }
        return new DownloadNetworkExecutor(mergeDownloadHeaders(str, strArr));
    }

    private static String[] mergeDownloadHeaders(String str, String[] strArr) {
        DownloadState downloadStateWithUrl = DataManager.getInstance().getDownloadStateWithUrl(str);
        String[] generateDownloadHeader = DownloadUtils.generateDownloadHeader((downloadStateWithUrl == null || downloadStateWithUrl.isSuccess()) ? null : downloadStateWithUrl.getFilePath());
        String[] strArr2 = new String[(generateDownloadHeader.length + (strArr != null ? strArr.length : 0))];
        System.arraycopy(generateDownloadHeader, 0, strArr2, 0, generateDownloadHeader.length);
        if (strArr != null) {
            System.arraycopy(strArr, 0, strArr2, generateDownloadHeader.length, strArr.length);
        }
        return strArr2;
    }
}
