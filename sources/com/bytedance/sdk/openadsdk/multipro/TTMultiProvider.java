package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.h.g;

public class TTMultiProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        if (!g.a()) {
            return false;
        }
        f.b(getContext()).a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!g.a()) {
            return null;
        }
        return f.b(getContext()).a(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (!g.a()) {
            return null;
        }
        return f.b(getContext()).a(uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!g.a()) {
            return null;
        }
        return f.b(getContext()).a(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (!g.a()) {
            return 0;
        }
        return f.b(getContext()).a(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!g.a()) {
            return 0;
        }
        return f.b(getContext()).a(uri, contentValues, str, strArr);
    }
}
