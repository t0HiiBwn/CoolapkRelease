package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver2);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver2) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver2;
        this.parsers = list;
    }

    int getOrientation(Uri uri) {
        InputStream inputStream = null;
        try {
            inputStream = this.contentResolver.openInputStream(uri);
            int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return orientation;
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.service.get(path);
        if (!isValid(file)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(file);
        try {
            return this.contentResolver.openInputStream(fromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d  */
    private String getPath(Uri uri) {
        Throwable th;
        SecurityException e;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = this.query.query(uri);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (SecurityException e2) {
                    e = e2;
                    try {
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (SecurityException e3) {
            e = e3;
            cursor = null;
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
            }
            if (cursor != null) {
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    private boolean isValid(File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }
}
