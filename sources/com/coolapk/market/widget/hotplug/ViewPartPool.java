package com.coolapk.market.widget.hotplug;

import android.util.SparseArray;
import com.coolapk.market.viewholder.iview.ViewPart;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\r\u0010\u0014\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/widget/hotplug/ViewPartPool;", "", "()V", "scrap", "Landroid/util/SparseArray;", "Lcom/coolapk/market/widget/hotplug/ViewPartPool$ScrapData;", "clear", "", "getRecycledViewPart", "T", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "viewType", "", "(I)Lcom/coolapk/market/viewholder/iview/ViewPart;", "getRecycledViewPartCount", "getScrapDataForType", "putRecycledViewPart", "viewPart", "setMaxRecycledViews", "max", "size", "size$presentation_coolapkAppRelease", "Companion", "ScrapData", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewPartPool.kt */
public final class ViewPartPool {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MAX_SCRAP = 5;
    private final SparseArray<ScrapData> scrap = new SparseArray<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/widget/hotplug/ViewPartPool$ScrapData;", "", "()V", "maxScrap", "", "getMaxScrap", "()I", "setMaxScrap", "(I)V", "scrapHeap", "Ljava/util/ArrayList;", "Lcom/coolapk/market/viewholder/iview/ViewPart;", "getScrapHeap", "()Ljava/util/ArrayList;", "setScrapHeap", "(Ljava/util/ArrayList;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ViewPartPool.kt */
    private static final class ScrapData {
        private int maxScrap = 5;
        private ArrayList<ViewPart> scrapHeap = new ArrayList<>();

        public final ArrayList<ViewPart> getScrapHeap() {
            return this.scrapHeap;
        }

        public final void setScrapHeap(ArrayList<ViewPart> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.scrapHeap = arrayList;
        }

        public final int getMaxScrap() {
            return this.maxScrap;
        }

        public final void setMaxScrap(int i) {
            this.maxScrap = i;
        }
    }

    public final void clear() {
        int size = this.scrap.size();
        for (int i = 0; i < size; i++) {
            this.scrap.valueAt(i).getScrapHeap().clear();
        }
    }

    public final void setMaxRecycledViews(int i, int i2) {
        ScrapData scrapDataForType = getScrapDataForType(i);
        scrapDataForType.setMaxScrap(i2);
        ArrayList<ViewPart> scrapHeap = scrapDataForType.getScrapHeap();
        while (scrapHeap.size() > i2) {
            scrapHeap.remove(scrapHeap.size() - 1);
        }
    }

    public final int getRecycledViewPartCount(int i) {
        return getScrapDataForType(i).getScrapHeap().size();
    }

    public final <T extends ViewPart> T getRecycledViewPart(int i) {
        ScrapData scrapData = this.scrap.get(i);
        if (scrapData == null || scrapData.getScrapHeap().isEmpty()) {
            return null;
        }
        ArrayList<ViewPart> scrapHeap = scrapData.getScrapHeap();
        ViewPart remove = scrapHeap.remove(scrapHeap.size() - 1);
        Objects.requireNonNull(remove, "null cannot be cast to non-null type T");
        return (T) remove;
    }

    public final int size$presentation_coolapkAppRelease() {
        int size = this.scrap.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.scrap.valueAt(i2).getScrapHeap().size();
        }
        return i;
    }

    public final void putRecycledViewPart(ViewPart viewPart, int i) {
        Intrinsics.checkNotNullParameter(viewPart, "viewPart");
        ArrayList<ViewPart> scrapHeap = getScrapDataForType(i).getScrapHeap();
        viewPart.onRecycled();
        if (this.scrap.get(i).getMaxScrap() > scrapHeap.size()) {
            scrapHeap.add(viewPart);
        }
    }

    private final ScrapData getScrapDataForType(int i) {
        ScrapData scrapData = this.scrap.get(i);
        if (scrapData != null) {
            return scrapData;
        }
        ScrapData scrapData2 = new ScrapData();
        this.scrap.put(i, scrapData2);
        return scrapData2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/widget/hotplug/ViewPartPool$Companion;", "", "()V", "DEFAULT_MAX_SCRAP", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ViewPartPool.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
