package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, long j) {
        this(context, "image_manager_disk_cache", j);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, long j) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() {
            /* class com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.AnonymousClass1 */

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}
