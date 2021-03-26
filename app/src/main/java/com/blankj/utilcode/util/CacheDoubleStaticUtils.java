package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDoubleStaticUtils {
    private static CacheDoubleUtils sDefaultCacheDoubleUtils;

    public static void setDefaultCacheDoubleUtils(CacheDoubleUtils cacheDoubleUtils) {
        sDefaultCacheDoubleUtils = cacheDoubleUtils;
    }

    public static void put(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, byte[] bArr, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, i, getDefaultCacheDoubleUtils());
    }

    public static byte[] getBytes(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, getDefaultCacheDoubleUtils());
    }

    public static byte[] getBytes(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, bArr, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, String str2, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, i, getDefaultCacheDoubleUtils());
    }

    public static String getString(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, getDefaultCacheDoubleUtils());
    }

    public static String getString(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, str2, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, i, getDefaultCacheDoubleUtils());
    }

    public static JSONObject getJSONObject(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, getDefaultCacheDoubleUtils());
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, jSONObject, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, i, getDefaultCacheDoubleUtils());
    }

    public static JSONArray getJSONArray(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, getDefaultCacheDoubleUtils());
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, jSONArray, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Bitmap bitmap, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, i, getDefaultCacheDoubleUtils());
    }

    public static Bitmap getBitmap(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, getDefaultCacheDoubleUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, bitmap, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Drawable drawable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, i, getDefaultCacheDoubleUtils());
    }

    public static Drawable getDrawable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, getDefaultCacheDoubleUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, drawable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Parcelable parcelable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, i, getDefaultCacheDoubleUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) getParcelable(str, (Parcelable.Creator<Object>) creator, getDefaultCacheDoubleUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) getParcelable(str, creator, t, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, getDefaultCacheDoubleUtils());
    }

    public static void put(String str, Serializable serializable, int i) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, i, getDefaultCacheDoubleUtils());
    }

    public static Object getSerializable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, getDefaultCacheDoubleUtils());
    }

    public static Object getSerializable(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, obj, getDefaultCacheDoubleUtils());
    }

    public static long getCacheDiskSize() {
        return getCacheDiskSize(getDefaultCacheDoubleUtils());
    }

    public static int getCacheDiskCount() {
        return getCacheDiskCount(getDefaultCacheDoubleUtils());
    }

    public static int getCacheMemoryCount() {
        return getCacheMemoryCount(getDefaultCacheDoubleUtils());
    }

    public static void remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        remove(str, getDefaultCacheDoubleUtils());
    }

    public static void clear() {
        clear(getDefaultCacheDoubleUtils());
    }

    public static void put(String str, byte[] bArr, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, bArr);
    }

    public static void put(String str, byte[] bArr, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, bArr, i);
    }

    public static byte[] getBytes(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getBytes(str);
    }

    public static byte[] getBytes(String str, byte[] bArr, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getBytes(str, bArr);
    }

    public static void put(String str, String str2, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, str2);
    }

    public static void put(String str, String str2, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, str2, i);
    }

    public static String getString(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getString(str);
    }

    public static String getString(String str, String str2, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getString(str, str2);
    }

    public static void put(String str, JSONObject jSONObject, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, jSONObject);
    }

    public static void put(String str, JSONObject jSONObject, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, jSONObject, i);
    }

    public static JSONObject getJSONObject(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getJSONObject(str);
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getJSONObject(str, jSONObject);
    }

    public static void put(String str, JSONArray jSONArray, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, jSONArray);
    }

    public static void put(String str, JSONArray jSONArray, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, jSONArray, i);
    }

    public static JSONArray getJSONArray(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getJSONArray(str);
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getJSONArray(str, jSONArray);
    }

    public static void put(String str, Bitmap bitmap, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, bitmap);
    }

    public static void put(String str, Bitmap bitmap, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, bitmap, i);
    }

    public static Bitmap getBitmap(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getBitmap(str);
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getBitmap(str, bitmap);
    }

    public static void put(String str, Drawable drawable, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, drawable);
    }

    public static void put(String str, Drawable drawable, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, drawable, i);
    }

    public static Drawable getDrawable(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getDrawable(str);
    }

    public static Drawable getDrawable(String str, Drawable drawable, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getDrawable(str, drawable);
    }

    public static void put(String str, Parcelable parcelable, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, parcelable);
    }

    public static void put(String str, Parcelable parcelable, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, parcelable, i);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) cacheDoubleUtils.getParcelable(str, creator);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) cacheDoubleUtils.getParcelable(str, creator, t);
    }

    public static void put(String str, Serializable serializable, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, serializable);
    }

    public static void put(String str, Serializable serializable, int i, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.put(str, serializable, i);
    }

    public static Object getSerializable(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getSerializable(str);
    }

    public static Object getSerializable(String str, Object obj, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getSerializable(str, obj);
    }

    public static long getCacheDiskSize(CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getCacheDiskSize();
    }

    public static int getCacheDiskCount(CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getCacheDiskCount();
    }

    public static int getCacheMemoryCount(CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDoubleUtils.getCacheMemoryCount();
    }

    public static void remove(String str, CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.remove(str);
    }

    public static void clear(CacheDoubleUtils cacheDoubleUtils) {
        Objects.requireNonNull(cacheDoubleUtils, "Argument 'cacheDoubleUtils' of type CacheDoubleUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDoubleUtils.clear();
    }

    private static CacheDoubleUtils getDefaultCacheDoubleUtils() {
        CacheDoubleUtils cacheDoubleUtils = sDefaultCacheDoubleUtils;
        return cacheDoubleUtils != null ? cacheDoubleUtils : CacheDoubleUtils.getInstance();
    }
}
