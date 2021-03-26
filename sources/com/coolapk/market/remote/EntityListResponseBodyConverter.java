package com.coolapk.market.remote;

import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityConvertUtils;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public final class EntityListResponseBodyConverter implements Converter<ResponseBody, Result<List<Entity>>> {
    private final Gson gson;

    EntityListResponseBodyConverter(Gson gson2) {
        this.gson = gson2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001a A[Catch:{ all -> 0x0010 }] */
    public Result<List<Entity>> convert(ResponseBody responseBody) throws IOException {
        Exception e;
        try {
            try {
                Result<List<Entity>> convertEntityList = EntityConvertUtils.convertEntityList(this.gson, responseBody.string());
                responseBody.close();
                return convertEntityList;
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
