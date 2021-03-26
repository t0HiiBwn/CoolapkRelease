package com.coolapk.market.view.photo.loader;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.coolapk.market.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/photo/loader/PhotoGalleryUtils;", "", "()V", "DATE_MODE", "", "IMAGE_GIF", "IMAGE_JPEG", "IMAGE_PNG", "IMAGE_PROJECTION", "", "[Ljava/lang/String;", "IMAGE_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "SELECTION", "SORT", "checkImgCorrupted", "", "filePath", "createCursor", "Landroid/database/Cursor;", "context", "Landroid/content/Context;", "getDataFromCursor", "", "Lcom/coolapk/market/view/photo/loader/PhotoDirectory;", "data", "getPhotos", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PhotoGalleryUtils.kt */
public final class PhotoGalleryUtils {
    private static final String DATE_MODE = "date_modified";
    private static final String IMAGE_GIF = "image/gif";
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final String[] IMAGE_PROJECTION = {"_id", "_data", "bucket_id", "bucket_display_name", "date_modified", "datetaken"};
    private static final Uri IMAGE_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    public static final PhotoGalleryUtils INSTANCE = new PhotoGalleryUtils();
    private static final String SELECTION = "(_size > 0 or _size is null)";
    private static final String SORT = "date_modified DESC";

    private PhotoGalleryUtils() {
    }

    @JvmStatic
    public static final List<PhotoDirectory> getPhotos(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PhotoGalleryUtils photoGalleryUtils = INSTANCE;
        Cursor createCursor = photoGalleryUtils.createCursor(context);
        if (createCursor == null) {
            return CollectionsKt.emptyList();
        }
        List<PhotoDirectory> dataFromCursor = photoGalleryUtils.getDataFromCursor(context, createCursor);
        createCursor.close();
        return dataFromCursor;
    }

    private final Cursor createCursor(Context context) {
        return context.getContentResolver().query(IMAGE_URI, IMAGE_PROJECTION, "(_size > 0 or _size is null)", null, "date_modified DESC");
    }

    private final List<PhotoDirectory> getDataFromCursor(Context context, Cursor cursor) {
        Object obj;
        boolean z;
        ArrayList<PhotoDirectory> arrayList = new ArrayList();
        PhotoDirectory photoDirectory = new PhotoDirectory(null, null, null, 0, null, 31, null);
        String string = context.getString(2131886927);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.str_photo_picker_all)");
        photoDirectory.setName(string);
        photoDirectory.setId("ALL");
        while (cursor.moveToNext()) {
            int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_id"));
            String string3 = cursor.getString(cursor.getColumnIndexOrThrow("bucket_display_name"));
            String string4 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow("date_modified"));
            long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("datetaken"));
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it2.next();
                PhotoDirectory photoDirectory2 = (PhotoDirectory) next;
                if (!Intrinsics.areEqual(photoDirectory2.getName(), string3) || !Intrinsics.areEqual(photoDirectory2.getId(), string2)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            PhotoDirectory photoDirectory3 = (PhotoDirectory) obj;
            if (photoDirectory3 == null) {
                photoDirectory3 = new PhotoDirectory(null, null, null, 0, null, 31, null);
                String emptyIfNull = StringUtils.emptyIfNull(string2);
                Intrinsics.checkNotNullExpressionValue(emptyIfNull, "StringUtils.emptyIfNull(bucketId)");
                photoDirectory3.setId(emptyIfNull);
                String emptyIfNull2 = StringUtils.emptyIfNull(string3);
                Intrinsics.checkNotNullExpressionValue(emptyIfNull2, "StringUtils.emptyIfNull(name)");
                photoDirectory3.setName(emptyIfNull2);
                Intrinsics.checkNotNullExpressionValue(string4, "path");
                photoDirectory3.setCoverPath(string4);
                photoDirectory3.setDateAdded(j);
                arrayList.add(photoDirectory3);
            }
            long j3 = (long) 1000;
            long min = j2 > 0 ? Math.min(j2, j * j3) : j3 * j;
            Intrinsics.checkNotNullExpressionValue(string4, "path");
            photoDirectory3.addPhoto(i, string4, min);
            photoDirectory.addPhoto(i, string4, min);
        }
        if (photoDirectory.getPhotos().size() > 0) {
            Photo photo = (Photo) CollectionsKt.firstOrNull((List<? extends Object>) photoDirectory.getPhotos());
            String path = photo != null ? photo.getPath() : null;
            if (path == null) {
                path = "";
            }
            photoDirectory.setCoverPath(path);
        }
        arrayList.add(0, photoDirectory);
        for (PhotoDirectory photoDirectory4 : arrayList) {
            CollectionsKt.sortWith(photoDirectory4.getPhotos(), PhotoGalleryUtils$getDataFromCursor$1$1.INSTANCE);
        }
        return arrayList;
    }

    @JvmStatic
    public static final boolean checkImgCorrupted(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return true;
        }
        return false;
    }
}
