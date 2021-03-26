package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    private static final String TAG = "OkHttpFetcher";
    private volatile Call call;
    private DataFetcher.DataCallback<? super InputStream> callback;
    private final Call.Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder url2 = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            url2.addHeader(entry.getKey(), entry.getValue());
        }
        Request build = url2.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        this.call.enqueue(this);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call2, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.callback.onLoadFailed(iOException);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call2, Response response) {
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            InputStream obtain = ContentLengthInputStream.obtain(this.responseBody.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.responseBody)).contentLength());
            this.stream = obtain;
            this.callback.onDataReady(obtain);
            return;
        }
        this.callback.onLoadFailed(new HttpException(response.message(), response.code()));
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody2 = this.responseBody;
        if (responseBody2 != null) {
            responseBody2.close();
        }
        this.callback = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Call call2 = this.call;
        if (call2 != null) {
            call2.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
