package com.coolapk.market.model;

import java.util.List;
import java.util.Objects;

/* renamed from: com.coolapk.market.model.$$AutoValue_VideoUrls  reason: invalid class name */
abstract class C$$AutoValue_VideoUrls extends VideoUrls {
    private final List<Integer> durationList;
    private final List<String> urlList;

    C$$AutoValue_VideoUrls(List<String> list, List<Integer> list2) {
        Objects.requireNonNull(list, "Null urlList");
        this.urlList = list;
        Objects.requireNonNull(list2, "Null durationList");
        this.durationList = list2;
    }

    @Override // com.coolapk.market.model.VideoUrls
    public List<String> getUrlList() {
        return this.urlList;
    }

    @Override // com.coolapk.market.model.VideoUrls
    public List<Integer> getDurationList() {
        return this.durationList;
    }

    @Override // java.lang.Object
    public String toString() {
        return "VideoUrls{urlList=" + this.urlList + ", durationList=" + this.durationList + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoUrls)) {
            return false;
        }
        VideoUrls videoUrls = (VideoUrls) obj;
        if (!this.urlList.equals(videoUrls.getUrlList()) || !this.durationList.equals(videoUrls.getDurationList())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.urlList.hashCode() ^ 1000003) * 1000003) ^ this.durationList.hashCode();
    }
}
