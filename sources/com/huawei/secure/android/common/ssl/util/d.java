package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.secure.android.common.ssl.SecureX509SingleInstance;
import java.io.InputStream;

public class d extends AsyncTask<Context, Integer, InputStream> {
    private static final String TAG = "d";

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InputStream doInBackground(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e) {
            String str = TAG;
            g.e(str, "doInBackground: exception : " + e.getMessage());
            inputStream = null;
        }
        String str2 = TAG;
        g.b(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return inputStream;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(InputStream inputStream) {
        String str = TAG;
        g.b(str, "onPostExecute: current thread name is : " + Thread.currentThread().getName());
        if (inputStream == null) {
            g.e(str, "get bks from tss error , result is null");
        } else {
            SecureX509SingleInstance.updateBks(inputStream);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        String str = TAG;
        g.b(str, "onPreExecute: current thread name is : " + Thread.currentThread().getName());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        String str = TAG;
        g.c(str, "onProgressUpdate: current thread name is : " + Thread.currentThread().getName());
    }
}
