package com.coolapk.market.view.photo.loader;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "o1", "Lcom/coolapk/market/view/photo/loader/Photo;", "kotlin.jvm.PlatformType", "o2", "compare"}, k = 3, mv = {1, 4, 2})
/* compiled from: PhotoGalleryUtils.kt */
final class PhotoGalleryUtils$getDataFromCursor$1$1<T> implements Comparator<Photo> {
    public static final PhotoGalleryUtils$getDataFromCursor$1$1 INSTANCE = new PhotoGalleryUtils$getDataFromCursor$1$1();

    PhotoGalleryUtils$getDataFromCursor$1$1() {
    }

    public final int compare(Photo photo, Photo photo2) {
        return -(photo.getDateTaken() > photo2.getDateTaken() ? 1 : (photo.getDateTaken() == photo2.getDateTaken() ? 0 : -1));
    }
}
