package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    protected abstract void close(T t) throws IOException;

    protected abstract T loadResource(AssetManager assetManager2, String str) throws IOException;

    public AssetPathFetcher(AssetManager assetManager2, String str) {
        this.assetManager = assetManager2;
        this.assetPath = str;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.assetManager, this.assetPath);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
