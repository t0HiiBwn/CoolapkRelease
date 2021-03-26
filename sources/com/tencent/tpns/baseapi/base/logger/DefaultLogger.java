package com.tencent.tpns.baseapi.base.logger;

import android.util.Log;

/* compiled from: ProGuard */
class DefaultLogger implements LoggerInterface {
    DefaultLogger() {
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void v(String str, String str2) {
        Log.v(str, str2);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void w(String str, String str2) {
        Log.w(str, str2);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.tencent.tpns.baseapi.base.logger.LoggerInterface
    public void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }
}
