package com.coolapk.market.remote;

import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import java.io.IOException;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Converter;

public class JSONObjectResponseBodyConvert implements Converter<ResponseBody, Result<JSONObject>> {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0018 A[Catch:{ all -> 0x000e }] */
    public Result<JSONObject> convert(ResponseBody responseBody) throws IOException {
        Exception e;
        try {
            try {
                Result<JSONObject> convertJSONObject = EntityConvertUtils.convertJSONObject(responseBody.string());
                responseBody.close();
                return convertJSONObject;
            } catch (Exception e2) {
                e = e2;
                try {
                    if (TextUtils.isEmpty(null)) {
                    }
                    LogUtils.file("PARSE_ERROR", r0);
                    throw e;
                } catch (Throwable th) {
                    responseBody.close();
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            String str = null;
            if (TextUtils.isEmpty(null)) {
                str = "nothing";
            }
            LogUtils.file("PARSE_ERROR", str);
            throw e;
        }
    }
}
