package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import com.blankj.utilcode.constant.CacheConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDoubleUtils implements CacheConstants {
    private static final Map<String, CacheDoubleUtils> CACHE_MAP = new HashMap();
    private final CacheDiskUtils mCacheDiskUtils;
    private final CacheMemoryUtils mCacheMemoryUtils;

    public static CacheDoubleUtils getInstance() {
        return getInstance(CacheMemoryUtils.getInstance(), CacheDiskUtils.getInstance());
    }

    public static CacheDoubleUtils getInstance(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(cacheMemoryUtils, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str = cacheDiskUtils.toString() + "_" + cacheMemoryUtils.toString();
        Map<String, CacheDoubleUtils> map = CACHE_MAP;
        CacheDoubleUtils cacheDoubleUtils = map.get(str);
        if (cacheDoubleUtils == null) {
            synchronized (CacheDoubleUtils.class) {
                cacheDoubleUtils = map.get(str);
                if (cacheDoubleUtils == null) {
                    cacheDoubleUtils = new CacheDoubleUtils(cacheMemoryUtils, cacheDiskUtils);
                    map.put(str, cacheDoubleUtils);
                }
            }
        }
        return cacheDoubleUtils;
    }

    private CacheDoubleUtils(CacheMemoryUtils cacheMemoryUtils, CacheDiskUtils cacheDiskUtils) {
        this.mCacheMemoryUtils = cacheMemoryUtils;
        this.mCacheDiskUtils = cacheDiskUtils;
    }

    public void put(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, -1);
    }

    public void put(String str, byte[] bArr, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, bArr, i);
        this.mCacheDiskUtils.put(str, bArr, i);
    }

    public byte[] getBytes(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, null);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArr2 = (byte[]) this.mCacheMemoryUtils.get(str);
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bytes = this.mCacheDiskUtils.getBytes(str);
        if (bytes == null) {
            return bArr;
        }
        this.mCacheMemoryUtils.put(str, bytes);
        return bytes;
    }

    public void put(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, -1);
    }

    public void put(String str, String str2, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, str2, i);
        this.mCacheDiskUtils.put(str, str2, i);
    }

    public String getString(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, null);
    }

    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str3 = (String) this.mCacheMemoryUtils.get(str);
        if (str3 != null) {
            return str3;
        }
        String string = this.mCacheDiskUtils.getString(str);
        if (string == null) {
            return str2;
        }
        this.mCacheMemoryUtils.put(str, string);
        return string;
    }

    public void put(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, -1);
    }

    public void put(String str, JSONObject jSONObject, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, jSONObject, i);
        this.mCacheDiskUtils.put(str, jSONObject, i);
    }

    public JSONObject getJSONObject(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        JSONObject jSONObject2 = (JSONObject) this.mCacheMemoryUtils.get(str);
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        JSONObject jSONObject3 = this.mCacheDiskUtils.getJSONObject(str);
        if (jSONObject3 == null) {
            return jSONObject;
        }
        this.mCacheMemoryUtils.put(str, jSONObject3);
        return jSONObject3;
    }

    public void put(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, -1);
    }

    public void put(String str, JSONArray jSONArray, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, jSONArray, i);
        this.mCacheDiskUtils.put(str, jSONArray, i);
    }

    public JSONArray getJSONArray(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        JSONArray jSONArray2 = (JSONArray) this.mCacheMemoryUtils.get(str);
        if (jSONArray2 != null) {
            return jSONArray2;
        }
        JSONArray jSONArray3 = this.mCacheDiskUtils.getJSONArray(str);
        if (jSONArray3 == null) {
            return jSONArray;
        }
        this.mCacheMemoryUtils.put(str, jSONArray3);
        return jSONArray3;
    }

    public void put(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, -1);
    }

    public void put(String str, Bitmap bitmap, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, bitmap, i);
        this.mCacheDiskUtils.put(str, bitmap, i);
    }

    public Bitmap getBitmap(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, null);
    }

    public Bitmap getBitmap(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Bitmap bitmap2 = (Bitmap) this.mCacheMemoryUtils.get(str);
        if (bitmap2 != null) {
            return bitmap2;
        }
        Bitmap bitmap3 = this.mCacheDiskUtils.getBitmap(str);
        if (bitmap3 == null) {
            return bitmap;
        }
        this.mCacheMemoryUtils.put(str, bitmap3);
        return bitmap3;
    }

    public void put(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, -1);
    }

    public void put(String str, Drawable drawable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, drawable, i);
        this.mCacheDiskUtils.put(str, drawable, i);
    }

    public Drawable getDrawable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, null);
    }

    public Drawable getDrawable(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Drawable drawable2 = (Drawable) this.mCacheMemoryUtils.get(str);
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawable3 = this.mCacheDiskUtils.getDrawable(str);
        if (drawable3 == null) {
            return drawable;
        }
        this.mCacheMemoryUtils.put(str, drawable3);
        return drawable3;
    }

    public void put(String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, -1);
    }

    public void put(String str, Parcelable parcelable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, parcelable, i);
        this.mCacheDiskUtils.put(str, parcelable, i);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) getParcelable(str, creator, null);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T t2 = (T) this.mCacheMemoryUtils.get(str);
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) this.mCacheDiskUtils.getParcelable(str, creator);
        if (t3 == null) {
            return t;
        }
        this.mCacheMemoryUtils.put(str, t3);
        return t3;
    }

    public void put(String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.put(str, serializable, i);
        this.mCacheDiskUtils.put(str, serializable, i);
    }

    public Object getSerializable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, null);
    }

    public Object getSerializable(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Object obj2 = this.mCacheMemoryUtils.get(str);
        if (obj2 != null) {
            return obj2;
        }
        Object serializable = this.mCacheDiskUtils.getSerializable(str);
        if (serializable == null) {
            return obj;
        }
        this.mCacheMemoryUtils.put(str, serializable);
        return serializable;
    }

    public long getCacheDiskSize() {
        return this.mCacheDiskUtils.getCacheSize();
    }

    public int getCacheDiskCount() {
        return this.mCacheDiskUtils.getCacheCount();
    }

    public int getCacheMemoryCount() {
        return this.mCacheMemoryUtils.getCacheCount();
    }

    public void remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.mCacheMemoryUtils.remove(str);
        this.mCacheDiskUtils.remove(str);
    }

    public void clear() {
        this.mCacheMemoryUtils.clear();
        this.mCacheDiskUtils.clear();
    }
}
