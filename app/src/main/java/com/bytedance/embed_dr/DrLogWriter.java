package com.bytedance.embed_dr;

import android.util.Log;

public interface DrLogWriter {
    void logD(String str, String str2, Throwable th);

    void logE(String str, String str2, Throwable th);

    void logI(String str, String str2, Throwable th);

    void logV(String str, String str2, Throwable th);

    void logW(String str, String str2, Throwable th);

    public static class a implements DrLogWriter {
        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logV(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logD(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logI(String str, String str2, Throwable th) {
            Log.i(str, str2, th);
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logE(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        @Override // com.bytedance.embed_dr.DrLogWriter
        public void logW(String str, String str2, Throwable th) {
            Log.w(str, str2, th);
        }
    }
}
