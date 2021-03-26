package com.coolapk.market.widget.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0015¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003J)\u0010-\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0015HÂ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u000bHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122(\b\u0002\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0015HÆ\u0001J\b\u00107\u001a\u00020\u000bH\u0016J\u0013\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\b\u0010;\u001a\u00020\u000bH\u0016J\t\u0010<\u001a\u00020\u0006HÖ\u0001J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u000bH\u0016R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR.\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0015X\u0004¢\u0006\u0002\n\u0000R1\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00158F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001fR\u0011\u0010 \u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0011\u0010!\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006A"}, d2 = {"Lcom/coolapk/market/widget/video/VideoModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "url", "", "title", "coverUrl", "sourceUrl", "duration", "", "liveStatus", "isNetworkResource", "", "isRedirectSource", "tagKey", "relatedEntity", "Lcom/coolapk/market/model/Entity;", "headerMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZLjava/lang/String;Lcom/coolapk/market/model/Entity;Ljava/util/HashMap;)V", "getCoverUrl", "()Ljava/lang/String;", "getDuration", "()I", "headerMapClone", "getHeaderMapClone", "()Ljava/util/HashMap;", "isLive", "()Z", "isUserSharedFeed", "isValid", "key", "getKey", "getLiveStatus", "getRelatedEntity", "()Lcom/coolapk/market/model/Entity;", "getSourceUrl", "getTagKey", "getTitle", "getUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoModel.kt */
public final class VideoModel implements Parcelable {
    public static final Parcelable.Creator<VideoModel> CREATOR = new VideoModel$Companion$CREATOR$1();
    public static final Companion Companion = new Companion(null);
    private static final VideoModel NO_VIDEO = new VideoModel(null, null, null, null, 0, 0, false, false, null, null, null, 2047, null);
    private final String coverUrl;
    private final int duration;
    private final HashMap<String, String> headerMap;
    private final boolean isLive;
    private final boolean isNetworkResource;
    private final boolean isRedirectSource;
    private final int liveStatus;
    private final Entity relatedEntity;
    private final String sourceUrl;
    private final String tagKey;
    private final String title;
    private final String url;

    public VideoModel() {
        this(null, null, null, null, 0, 0, false, false, null, null, null, 2047, null);
    }

    private final HashMap<String, String> component11() {
        return this.headerMap;
    }

    public static /* synthetic */ VideoModel copy$default(VideoModel videoModel, String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, String str5, Entity entity, HashMap hashMap, int i3, Object obj) {
        return videoModel.copy((i3 & 1) != 0 ? videoModel.url : str, (i3 & 2) != 0 ? videoModel.title : str2, (i3 & 4) != 0 ? videoModel.coverUrl : str3, (i3 & 8) != 0 ? videoModel.sourceUrl : str4, (i3 & 16) != 0 ? videoModel.duration : i, (i3 & 32) != 0 ? videoModel.liveStatus : i2, (i3 & 64) != 0 ? videoModel.isNetworkResource : z, (i3 & 128) != 0 ? videoModel.isRedirectSource : z2, (i3 & 256) != 0 ? videoModel.tagKey : str5, (i3 & 512) != 0 ? videoModel.relatedEntity : entity, (i3 & 1024) != 0 ? videoModel.headerMap : hashMap);
    }

    public final String component1() {
        return this.url;
    }

    public final Entity component10() {
        return this.relatedEntity;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final String component4() {
        return this.sourceUrl;
    }

    public final int component5() {
        return this.duration;
    }

    public final int component6() {
        return this.liveStatus;
    }

    public final boolean component7() {
        return this.isNetworkResource;
    }

    public final boolean component8() {
        return this.isRedirectSource;
    }

    public final String component9() {
        return this.tagKey;
    }

    public final VideoModel copy(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, String str5, Entity entity, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        Intrinsics.checkNotNullParameter(str4, "sourceUrl");
        Intrinsics.checkNotNullParameter(str5, "tagKey");
        return new VideoModel(str, str2, str3, str4, i, i2, z, z2, str5, entity, hashMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VideoModel(url=" + this.url + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", sourceUrl=" + this.sourceUrl + ", duration=" + this.duration + ", liveStatus=" + this.liveStatus + ", isNetworkResource=" + this.isNetworkResource + ", isRedirectSource=" + this.isRedirectSource + ", tagKey=" + this.tagKey + ", relatedEntity=" + this.relatedEntity + ", headerMap=" + this.headerMap + ")";
    }

    public VideoModel(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, String str5, Entity entity, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "coverUrl");
        Intrinsics.checkNotNullParameter(str4, "sourceUrl");
        Intrinsics.checkNotNullParameter(str5, "tagKey");
        this.url = str;
        this.title = str2;
        this.coverUrl = str3;
        this.sourceUrl = str4;
        this.duration = i;
        this.liveStatus = i2;
        this.isNetworkResource = z;
        this.isRedirectSource = z2;
        this.tagKey = str5;
        this.relatedEntity = entity;
        this.headerMap = hashMap;
        this.isLive = i2 != 1 ? false : true;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getLiveStatus() {
        return this.liveStatus;
    }

    public final boolean isNetworkResource() {
        return this.isNetworkResource;
    }

    public final boolean isRedirectSource() {
        return this.isRedirectSource;
    }

    public final String getTagKey() {
        return this.tagKey;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public /* synthetic */ VideoModel(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, String str5, Entity entity, HashMap hashMap, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? r2 : str, (i3 & 2) != 0 ? r2 : str2, (i3 & 4) != 0 ? r2 : str3, (i3 & 8) != 0 ? r2 : str4, (i3 & 16) != 0 ? 0 : i, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? true : z, (i3 & 128) == 0 ? z2 : true, (i3 & 256) == 0 ? str5 : r2, (i3 & 512) != 0 ? null : entity, (i3 & 1024) != 0 ? null : hashMap);
        String str6 = "";
    }

    public final Entity getRelatedEntity() {
        return this.relatedEntity;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public VideoModel(Parcel parcel) {
        this(r2, r3, r4, r5, r6, r7, r11, r9, r10, r0, !(r14 instanceof HashMap) ? null : r14);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString()!!");
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString()!!");
        String readString3 = parcel.readString();
        Intrinsics.checkNotNull(readString3);
        Intrinsics.checkNotNullExpressionValue(readString3, "parcel.readString()!!");
        String readString4 = parcel.readString();
        Intrinsics.checkNotNull(readString4);
        Intrinsics.checkNotNullExpressionValue(readString4, "parcel.readString()!!");
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        byte b = (byte) 0;
        boolean z = parcel.readByte() != b;
        boolean z2 = parcel.readByte() != b;
        String readString5 = parcel.readString();
        Intrinsics.checkNotNull(readString5);
        Intrinsics.checkNotNullExpressionValue(readString5, "parcel.readString()!!");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        Entity entity = (Entity) parcel.readParcelable(currentThread.getContextClassLoader());
        Thread currentThread2 = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
        HashMap readHashMap = parcel.readHashMap(currentThread2.getContextClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.sourceUrl);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.liveStatus);
        parcel.writeByte(this.isNetworkResource ? (byte) 1 : 0);
        parcel.writeByte(this.isRedirectSource ? (byte) 1 : 0);
        parcel.writeString(this.tagKey);
        parcel.writeParcelable(this.relatedEntity, i);
        parcel.writeMap(this.headerMap);
    }

    public final boolean isLive() {
        return this.isLive;
    }

    public final HashMap<String, String> getHeaderMapClone() {
        if (this.headerMap == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(this.headerMap);
        return hashMap;
    }

    public final boolean isValid() {
        return (this.url.length() > 0) || this.relatedEntity != null;
    }

    public final int getKey() {
        return hashCode();
    }

    public final boolean isUserSharedFeed() {
        return this.relatedEntity instanceof Feed;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof VideoModel)) {
            return false;
        }
        Entity entity = this.relatedEntity;
        if (entity instanceof Feed) {
            VideoModel videoModel = (VideoModel) obj;
            if (videoModel.relatedEntity instanceof Feed) {
                if (Intrinsics.areEqual(((Feed) entity).getId(), ((Feed) videoModel.relatedEntity).getId())) {
                    return true;
                }
                return false;
            }
        }
        VideoModel videoModel2 = (VideoModel) obj;
        if (!Intrinsics.areEqual(videoModel2.url, this.url) || !Intrinsics.areEqual(videoModel2.title, this.title) || !Intrinsics.areEqual(videoModel2.coverUrl, this.coverUrl) || !Intrinsics.areEqual(videoModel2.sourceUrl, this.sourceUrl) || videoModel2.duration != this.duration || !Intrinsics.areEqual(videoModel2.headerMap, this.headerMap)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Entity entity = this.relatedEntity;
        if (entity instanceof Feed) {
            String id = ((Feed) entity).getId();
            if (id == null) {
                id = "";
            }
            return id.hashCode();
        }
        int hashCode = (this.url.hashCode() * 33) + (this.title.hashCode() * 33) + (this.coverUrl.hashCode() * 33);
        Entity entity2 = this.relatedEntity;
        int valueOf = entity2 != null ? Integer.valueOf(entity2.hashCode()) : null;
        if (valueOf == null) {
            valueOf = 0;
        }
        return hashCode + valueOf.intValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/widget/video/VideoModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/coolapk/market/widget/video/VideoModel;", "NO_VIDEO", "getNO_VIDEO", "()Lcom/coolapk/market/widget/video/VideoModel;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoModel getNO_VIDEO() {
            return VideoModel.NO_VIDEO;
        }
    }
}
