package com.coolapk.market.view.photo.loader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0007J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001fHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006-"}, d2 = {"Lcom/coolapk/market/view/photo/loader/PhotoDirectory;", "", "id", "", "coverPath", "name", "dateAdded", "", "photos", "", "Lcom/coolapk/market/view/photo/loader/Photo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "getDateAdded", "()J", "setDateAdded", "(J)V", "getId", "setId", "getName", "setName", "photoPaths", "", "getPhotoPaths", "()Ljava/util/List;", "getPhotos", "addPhoto", "", "", "path", "dateTaken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: Photo.kt */
public final class PhotoDirectory {
    private String coverPath;
    private long dateAdded;
    private String id;
    private String name;
    private final List<Photo> photos;

    public PhotoDirectory() {
        this(null, null, null, 0, null, 31, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.coolapk.market.view.photo.loader.PhotoDirectory */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhotoDirectory copy$default(PhotoDirectory photoDirectory, String str, String str2, String str3, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = photoDirectory.id;
        }
        if ((i & 2) != 0) {
            str2 = photoDirectory.coverPath;
        }
        if ((i & 4) != 0) {
            str3 = photoDirectory.name;
        }
        if ((i & 8) != 0) {
            j = photoDirectory.dateAdded;
        }
        if ((i & 16) != 0) {
            list = photoDirectory.photos;
        }
        return photoDirectory.copy(str, str2, str3, j, list);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.coverPath;
    }

    public final String component3() {
        return this.name;
    }

    public final long component4() {
        return this.dateAdded;
    }

    public final List<Photo> component5() {
        return this.photos;
    }

    public final PhotoDirectory copy(String str, String str2, String str3, long j, List<Photo> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "coverPath");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(list, "photos");
        return new PhotoDirectory(str, str2, str3, j, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoDirectory)) {
            return false;
        }
        PhotoDirectory photoDirectory = (PhotoDirectory) obj;
        return Intrinsics.areEqual(this.id, photoDirectory.id) && Intrinsics.areEqual(this.coverPath, photoDirectory.coverPath) && Intrinsics.areEqual(this.name, photoDirectory.name) && this.dateAdded == photoDirectory.dateAdded && Intrinsics.areEqual(this.photos, photoDirectory.photos);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.coverPath;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.dateAdded)) * 31;
        List<Photo> list = this.photos;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PhotoDirectory(id=" + this.id + ", coverPath=" + this.coverPath + ", name=" + this.name + ", dateAdded=" + this.dateAdded + ", photos=" + this.photos + ")";
    }

    public PhotoDirectory(String str, String str2, String str3, long j, List<Photo> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "coverPath");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(list, "photos");
        this.id = str;
        this.coverPath = str2;
        this.name = str3;
        this.dateAdded = j;
        this.photos = list;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }

    public final void setDateAdded(long j) {
        this.dateAdded = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ PhotoDirectory(String str, String str2, String str3, long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? r0 : str, (i & 2) != 0 ? r0 : str2, (i & 4) == 0 ? str3 : r0, (i & 8) != 0 ? 0 : j, (i & 16) != 0 ? new ArrayList() : list);
        String str4 = "";
    }

    public final List<Photo> getPhotos() {
        return this.photos;
    }

    public final void addPhoto(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.photos.add(new Photo(i, str, j));
    }

    public final List<String> getPhotoPaths() {
        List<Photo> list = this.photos;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getPath());
        }
        return arrayList;
    }
}
