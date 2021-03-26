package com.coolapk.market.view.main.channel;

import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.model.ConfigPage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\nj\b\u0012\u0004\u0012\u00020\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\nj\b\u0012\u0004\u0012\u00020\r`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\nj\b\u0012\u0004\u0012\u00020\u000f`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/main/channel/ChannelViewModel;", "", "()V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "mergeChannelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "myChannelList", "Lcom/coolapk/market/view/main/channel/Channel;", "myConfigPageList", "Lcom/coolapk/market/model/ConfigPage;", "otherChannelList", "otherConfigPageList", "convertToChannelData", "", "externalList", "", "getChannelList", "getConfigPageList", "getDataList", "isOtherChannelEmpty", "", "mergeChannel", "moveToMyChannel", "fromPosition", "", "moveToOtherChannel", "onItemMove", "toPosition", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChannelViewModel.kt */
public final class ChannelViewModel {
    public RecyclerView.Adapter<?> adapter;
    private final ArrayList<Object> mergeChannelList = new ArrayList<>();
    private final ArrayList<Channel> myChannelList = new ArrayList<>();
    private final ArrayList<ConfigPage> myConfigPageList = new ArrayList<>();
    private final ArrayList<Channel> otherChannelList = new ArrayList<>();
    private final ArrayList<ConfigPage> otherConfigPageList = new ArrayList<>();

    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    public final void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final List<Object> getDataList() {
        return this.mergeChannelList;
    }

    public final List<Channel> getChannelList() {
        return CollectionsKt.plus((Collection) this.myChannelList, (Iterable) this.otherChannelList);
    }

    public final List<ConfigPage> getConfigPageList() {
        return CollectionsKt.plus((Collection) this.myConfigPageList, (Iterable) this.otherConfigPageList);
    }

    public final boolean isOtherChannelEmpty() {
        return this.otherChannelList.isEmpty();
    }

    public final void convertToChannelData(List<? extends ConfigPage> list) {
        Intrinsics.checkNotNullParameter(list, "externalList");
        this.myChannelList.clear();
        this.otherChannelList.clear();
        this.myConfigPageList.clear();
        this.otherConfigPageList.clear();
        for (ConfigPage configPage : list) {
            String id = configPage.getId();
            Intrinsics.checkNotNull(id);
            Intrinsics.checkNotNullExpressionValue(id, "data.id!!");
            String title = configPage.getTitle();
            Intrinsics.checkNotNull(title);
            Intrinsics.checkNotNullExpressionValue(title, "data.title!!");
            Channel channel = new Channel(id, title, configPage.getLogo(), configPage.isVisibility(), configPage.isFixed(), configPage.getOrder(), configPage.getPageName());
            if (configPage.isVisibility()) {
                this.myChannelList.add(channel);
                this.myConfigPageList.add(configPage);
            } else {
                this.otherChannelList.add(channel);
                this.otherConfigPageList.add(configPage);
            }
        }
        mergeChannel();
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.notifyDataSetChanged();
    }

    public final void moveToMyChannel(int i) {
        int size = this.myChannelList.size() + 1;
        ArrayList<Channel> arrayList = this.myChannelList;
        Channel remove = this.otherChannelList.remove((i - arrayList.size()) - 2);
        remove.setVisible(true);
        Unit unit = Unit.INSTANCE;
        arrayList.add(remove);
        ArrayList<ConfigPage> arrayList2 = this.myConfigPageList;
        arrayList2.add(ConfigPage.newBuilder(this.otherConfigPageList.remove((i - arrayList2.size()) - 2)).visibility(1).build());
        mergeChannel();
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.notifyItemMoved(i, size);
        RecyclerView.Adapter<?> adapter3 = this.adapter;
        if (adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter3.notifyItemChanged(i);
        RecyclerView.Adapter<?> adapter4 = this.adapter;
        if (adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter4.notifyItemChanged(size);
    }

    public final void moveToOtherChannel(int i) {
        int i2;
        boolean z;
        int i3 = i - 1;
        Channel remove = this.myChannelList.remove(i3);
        Channel channel = remove;
        channel.setVisible(false);
        Intrinsics.checkNotNullExpressionValue(remove, "myChannelList.removeAt(f…so { it.visible = false }");
        this.otherChannelList.add(channel);
        CollectionsKt.sortWith(this.otherChannelList, ChannelViewModel$moveToOtherChannel$1.INSTANCE);
        this.otherConfigPageList.add(ConfigPage.newBuilder(this.myConfigPageList.remove(i3)).visibility(0).build());
        CollectionsKt.sortWith(this.otherConfigPageList, ChannelViewModel$moveToOtherChannel$3.INSTANCE);
        mergeChannel();
        ArrayList<Object> arrayList = this.mergeChannelList;
        ListIterator<Object> listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i2 = -1;
                break;
            }
            Object previous = listIterator.previous();
            if (!(previous instanceof Channel) || !Intrinsics.areEqual(((Channel) previous).getId(), channel.getId())) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                i2 = listIterator.nextIndex();
                break;
            }
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.notifyItemMoved(i, i2);
        RecyclerView.Adapter<?> adapter3 = this.adapter;
        if (adapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter3.notifyItemChanged(i);
        RecyclerView.Adapter<?> adapter4 = this.adapter;
        if (adapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter4.notifyItemChanged(i2);
    }

    public final void onItemMove(int i, int i2) {
        ArrayList<Channel> arrayList = this.myChannelList;
        int i3 = i2 - 1;
        int i4 = i - 1;
        arrayList.add(i3, arrayList.remove(i4));
        ArrayList<ConfigPage> arrayList2 = this.myConfigPageList;
        arrayList2.add(i3, arrayList2.remove(i4));
        ArrayList<Object> arrayList3 = this.mergeChannelList;
        arrayList3.add(i2, arrayList3.remove(i));
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.notifyItemMoved(i, i2);
    }

    private final void mergeChannel() {
        this.mergeChannelList.clear();
        this.mergeChannelList.add(new ChannelTitle(0));
        this.mergeChannelList.addAll(this.myChannelList);
        this.mergeChannelList.add(new ChannelTitle(1));
        this.mergeChannelList.addAll(this.otherChannelList);
    }
}
