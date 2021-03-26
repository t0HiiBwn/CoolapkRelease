package com.coolapk.market.view.feed.reply;

import com.coolapk.market.model.Entity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feed/reply/LoadedData;", "", "loadedPage", "", "loadedData", "", "Lcom/coolapk/market/model/Entity;", "(ILjava/util/List;)V", "getLoadedData", "()Ljava/util/List;", "getLoadedPage", "()I", "setLoadedPage", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyViewModel.kt */
public final class LoadedData {
    private final List<Entity> loadedData;
    private int loadedPage;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.coolapk.market.view.feed.reply.LoadedData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadedData copy$default(LoadedData loadedData2, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = loadedData2.loadedPage;
        }
        if ((i2 & 2) != 0) {
            list = loadedData2.loadedData;
        }
        return loadedData2.copy(i, list);
    }

    public final int component1() {
        return this.loadedPage;
    }

    public final List<Entity> component2() {
        return this.loadedData;
    }

    public final LoadedData copy(int i, List<Entity> list) {
        Intrinsics.checkNotNullParameter(list, "loadedData");
        return new LoadedData(i, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadedData)) {
            return false;
        }
        LoadedData loadedData2 = (LoadedData) obj;
        return this.loadedPage == loadedData2.loadedPage && Intrinsics.areEqual(this.loadedData, loadedData2.loadedData);
    }

    public int hashCode() {
        int i = this.loadedPage * 31;
        List<Entity> list = this.loadedData;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "LoadedData(loadedPage=" + this.loadedPage + ", loadedData=" + this.loadedData + ")";
    }

    public LoadedData(int i, List<Entity> list) {
        Intrinsics.checkNotNullParameter(list, "loadedData");
        this.loadedPage = i;
        this.loadedData = list;
    }

    public final List<Entity> getLoadedData() {
        return this.loadedData;
    }

    public final int getLoadedPage() {
        return this.loadedPage;
    }

    public final void setLoadedPage(int i) {
        this.loadedPage = i;
    }
}
