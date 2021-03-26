package com.coolapk.market.view.photo.loader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/photo/loader/Photo;", "", "id", "", "path", "", "dateTaken", "", "(ILjava/lang/String;J)V", "getDateTaken", "()J", "getId", "()I", "getPath", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: Photo.kt */
public final class Photo {
    private final long dateTaken;
    private final int id;
    private final String path;

    public static /* synthetic */ Photo copy$default(Photo photo, int i, String str, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = photo.id;
        }
        if ((i2 & 2) != 0) {
            str = photo.path;
        }
        if ((i2 & 4) != 0) {
            j = photo.dateTaken;
        }
        return photo.copy(i, str, j);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.path;
    }

    public final long component3() {
        return this.dateTaken;
    }

    public final Photo copy(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "path");
        return new Photo(i, str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) obj;
        return this.id == photo.id && Intrinsics.areEqual(this.path, photo.path) && this.dateTaken == photo.dateTaken;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.path;
        return ((i + (str != null ? str.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.dateTaken);
    }

    public String toString() {
        return "Photo(id=" + this.id + ", path=" + this.path + ", dateTaken=" + this.dateTaken + ")";
    }

    public Photo(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.id = i;
        this.path = str;
        this.dateTaken = j;
    }

    public final long getDateTaken() {
        return this.dateTaken;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }
}
