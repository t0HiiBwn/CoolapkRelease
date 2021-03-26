package com.coolapk.market.manager;

import com.coolapk.market.download.DownloadJob;
import com.coolapk.market.model.Extra;

public interface DownloadStartInterceptor {
    Extra intercept(DownloadJob downloadJob);
}
