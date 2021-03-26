package com.coolapk.market.view.feed.reply;

import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018J\u001c\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(J&\u0010)\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0018J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00061"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyPresenter;", "", "view", "Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "viewModel", "Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getView", "()Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "getViewModel", "()Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "addUserReply", "", "feedReply", "Lcom/coolapk/market/model/FeedReply;", "buildReplyList", "", "Lcom/coolapk/market/model/Entity;", "buildSimpleList", "loadDataType", "", "checkAddToReplyMeRows", "", "reply", "createRequest", "Lrx/Observable;", "page", "dispatchIntoDataList", "dataList", "", "Landroid/os/Parcelable;", "findFirstItem", "", "findLastItem", "handleFeedReplyTopEvent", "event", "Lcom/coolapk/market/view/feed/reply/FeedReplyTopEvent;", "markDataResult", "data", "switchDataType", "type", "switchFilterArgs", "args", "Lcom/coolapk/market/view/feed/reply/FilterArgs;", "viewHotComments", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyPresenter.kt */
public final class FeedReplyPresenter {
    private final LifecycleOwner lifecycleOwner;
    private final FeedReplyListFragmentV8 view;
    private final FeedReplyViewModel viewModel;

    public FeedReplyPresenter(FeedReplyListFragmentV8 feedReplyListFragmentV8, FeedReplyViewModel feedReplyViewModel, LifecycleOwner lifecycleOwner2) {
        Intrinsics.checkNotNullParameter(feedReplyListFragmentV8, "view");
        Intrinsics.checkNotNullParameter(feedReplyViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        this.view = feedReplyListFragmentV8;
        this.viewModel = feedReplyViewModel;
        this.lifecycleOwner = lifecycleOwner2;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final FeedReplyListFragmentV8 getView() {
        return this.view;
    }

    public final FeedReplyViewModel getViewModel() {
        return this.viewModel;
    }

    public final void switchDataType(int i) {
        Integer value = this.viewModel.getLoadDataType().getValue();
        if (value == null || value.intValue() != i) {
            this.viewModel.getLoadDataType().setValue(Integer.valueOf(i));
        }
    }

    public final void switchFilterArgs(FilterArgs filterArgs) {
        Intrinsics.checkNotNullParameter(filterArgs, "args");
        if (this.viewModel.getFilterArgs().getValue() != filterArgs) {
            this.viewModel.getFilterArgs().setValue(filterArgs);
        }
    }

    public final void viewHotComments() {
        this.view.viewHotComments();
    }

    public final Observable<List<Entity>> createRequest(int i, int i2) {
        if (this.viewModel.getHideAllComments()) {
            Observable<List<Entity>> just = Observable.just(null);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(null)");
            return just;
        }
        String feedId = this.viewModel.getFeedId();
        String feedType = this.viewModel.getFeedType();
        FilterArgs value = this.viewModel.getFilterArgs().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.filterArgs.value!!");
        FilterArgs filterArgs = value;
        if (i == 0) {
            Observable<R> compose = DataManager.getInstance().getFeedLikeList(feedId, feedType, i2, findFirstItem(i), findLastItem(i)).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose;
        } else if (i == 1) {
            Observable<R> compose2 = DataManager.getInstance().getFeedReplyDiscussList(feedId, filterArgs.getListType(), feedType, i2, findFirstItem(i), findLastItem(i), filterArgs.getBlockStatus(), filterArgs.getFromAuthor()).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose2, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose2;
        } else if (i != 2) {
            Observable<List<Entity>> just2 = Observable.just(null);
            Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(null)");
            return just2;
        } else {
            Observable<R> compose3 = DataManager.getInstance().getFeedForwardList(feedId, feedType, i2, findFirstItem(i), findLastItem(i)).compose(RxUtils.apiCommonToData());
            Intrinsics.checkNotNullExpressionValue(compose3, "DataManager.getInstance(…xUtils.apiCommonToData())");
            return compose3;
        }
    }

    public final void markDataResult(int i, int i2, List<? extends Entity> list) {
        if (list != null) {
            LoadedData loadedData = this.viewModel.getLoadedDataArray().get(i);
            if (i2 > 1) {
                loadedData.setLoadedPage(i2);
            }
            List<? extends Entity> list2 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (T t : list2) {
                linkedHashMap.put(EntityExtendsKt.entityUniqueId(t), t);
            }
            CollectionsKt.removeAll((List) loadedData.getLoadedData(), (Function1) new FeedReplyPresenter$markDataResult$1$1$1(linkedHashMap));
            List<Entity> loadedData2 = loadedData.getLoadedData();
            if (i2 <= 1) {
                loadedData2.addAll(0, list);
            } else {
                loadedData2.addAll(list);
            }
        }
    }

    public final void addUserReply(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "feedReply");
        this.viewModel.addUserReply(feedReply);
    }

    public final void dispatchIntoDataList(int i, List<Parcelable> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        int indexOf = list.indexOf(FeedReplyViewModel.Companion.getCommentCountHolder());
        if (indexOf >= 0) {
            list.removeAll(new ArrayList(list.subList(indexOf + 1, list.size())));
        }
        if (!this.viewModel.getHideAllComments()) {
            if (i != 0) {
                if (i == 1) {
                    list.addAll(buildReplyList());
                    return;
                } else if (i != 2) {
                    return;
                }
            }
            list.addAll(buildSimpleList(i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0190 A[SYNTHETIC] */
    private final List<Entity> buildReplyList() {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        boolean z4 = this.viewModel.getFilterArgs().getValue() == FilterArgs.FILTER_BY_RECENT_REPLY;
        FeedReplyViewModel feedReplyViewModel = this.viewModel;
        if (z4) {
            List<FeedReply> value = feedReplyViewModel.getReplyMeList().getValue();
            if (!(value == null || value.isEmpty())) {
                HolderItem currentReplyHolder = FeedReplyViewModel.Companion.getCurrentReplyHolder();
                Intrinsics.checkNotNullExpressionValue(currentReplyHolder, "FeedReplyViewModel.currentReplyHolder");
                arrayList.add(currentReplyHolder);
                List<FeedReply> value2 = feedReplyViewModel.getReplyMeList().getValue();
                Intrinsics.checkNotNull(value2);
                Intrinsics.checkNotNullExpressionValue(value2, "replyMeList.value!!");
                arrayList.addAll(value2);
                Entity noticeSponsorCard = feedReplyViewModel.getNoticeSponsorCard();
                if (noticeSponsorCard != null) {
                    arrayList.add(noticeSponsorCard);
                }
                z = true;
                if (z4) {
                    List<FeedReply> value3 = feedReplyViewModel.getHotReplyList().getValue();
                    if (!(value3 == null || value3.isEmpty())) {
                        HolderItem hotReplyHolder = FeedReplyViewModel.Companion.getHotReplyHolder();
                        Intrinsics.checkNotNullExpressionValue(hotReplyHolder, "FeedReplyViewModel.hotReplyHolder");
                        arrayList.add(hotReplyHolder);
                        List<FeedReply> value4 = feedReplyViewModel.getTopReplyList().getValue();
                        Intrinsics.checkNotNull(value4);
                        Intrinsics.checkNotNullExpressionValue(value4, "topReplyList.value!!");
                        arrayList.addAll(value4);
                        List<FeedReply> value5 = feedReplyViewModel.getHotReplyList().getValue();
                        Intrinsics.checkNotNull(value5);
                        Intrinsics.checkNotNullExpressionValue(value5, "hotReplyList.value!!");
                        ArrayList arrayList2 = new ArrayList();
                        for (T t : value5) {
                            HashMap<String, FeedReply> topReplyMap = feedReplyViewModel.getTopReplyMap();
                            String id = t.getId();
                            Objects.requireNonNull(topReplyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                            if (!topReplyMap.containsKey(id)) {
                                arrayList2.add(t);
                            }
                        }
                        arrayList.addAll(arrayList2);
                        HolderItem viewHotReplyHolder = FeedReplyViewModel.Companion.getViewHotReplyHolder();
                        Intrinsics.checkNotNullExpressionValue(viewHotReplyHolder, "FeedReplyViewModel.viewHotReplyHolder");
                        arrayList.add(viewHotReplyHolder);
                        Entity hotSponsorCard = feedReplyViewModel.getHotSponsorCard();
                        if (hotSponsorCard != null) {
                            arrayList.add(hotSponsorCard);
                        }
                        z2 = true;
                        if (z || z2) {
                            HolderItem newestReplyHolder = FeedReplyViewModel.Companion.getNewestReplyHolder();
                            Intrinsics.checkNotNullExpressionValue(newestReplyHolder, "FeedReplyViewModel.newestReplyHolder");
                            arrayList.add(newestReplyHolder);
                        }
                        if (!z2 && z4) {
                            List<FeedReply> value6 = feedReplyViewModel.getTopReplyList().getValue();
                            Intrinsics.checkNotNull(value6);
                            Intrinsics.checkNotNullExpressionValue(value6, "topReplyList.value!!");
                            arrayList.addAll(value6);
                        }
                        if (z4) {
                            List<FeedReply> value7 = feedReplyViewModel.getUserReplyList().getValue();
                            Intrinsics.checkNotNull(value7);
                            Intrinsics.checkNotNullExpressionValue(value7, "userReplyList.value!!");
                            ArrayList arrayList3 = new ArrayList();
                            for (T t2 : value7) {
                                HashMap<String, FeedReply> topReplyMap2 = feedReplyViewModel.getTopReplyMap();
                                String id2 = t2.getId();
                                Objects.requireNonNull(topReplyMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                                if (!topReplyMap2.containsKey(id2)) {
                                    arrayList3.add(t2);
                                }
                            }
                            arrayList.addAll(arrayList3);
                        }
                        if (z4) {
                            ArrayList arrayList4 = new ArrayList();
                            for (T t3 : buildSimpleList(1)) {
                                T t4 = t3;
                                HashMap<String, FeedReply> hotReplyMap = feedReplyViewModel.getHotReplyMap();
                                String id3 = t4.getId();
                                Objects.requireNonNull(hotReplyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                                if (!hotReplyMap.containsKey(id3)) {
                                    HashMap<String, FeedReply> topReplyMap3 = feedReplyViewModel.getTopReplyMap();
                                    String id4 = t4.getId();
                                    Objects.requireNonNull(topReplyMap3, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                                    if (!topReplyMap3.containsKey(id4)) {
                                        HashMap<String, FeedReply> userReplyMap = feedReplyViewModel.getUserReplyMap();
                                        String id5 = t4.getId();
                                        Objects.requireNonNull(userReplyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                                        if (!userReplyMap.containsKey(id5)) {
                                            z3 = true;
                                            if (!z3) {
                                                arrayList4.add(t3);
                                            }
                                        }
                                    }
                                }
                                z3 = false;
                                if (!z3) {
                                }
                            }
                            arrayList.addAll(arrayList4);
                        } else {
                            arrayList.addAll(buildSimpleList(1));
                        }
                        return arrayList;
                    }
                }
                z2 = false;
                HolderItem newestReplyHolder = FeedReplyViewModel.Companion.getNewestReplyHolder();
                Intrinsics.checkNotNullExpressionValue(newestReplyHolder, "FeedReplyViewModel.newestReplyHolder");
                arrayList.add(newestReplyHolder);
                List<FeedReply> value6 = feedReplyViewModel.getTopReplyList().getValue();
                Intrinsics.checkNotNull(value6);
                Intrinsics.checkNotNullExpressionValue(value6, "topReplyList.value!!");
                arrayList.addAll(value6);
                if (z4) {
                }
                if (z4) {
                }
                return arrayList;
            }
        }
        z = false;
        if (z4) {
        }
        z2 = false;
        HolderItem newestReplyHolder = FeedReplyViewModel.Companion.getNewestReplyHolder();
        Intrinsics.checkNotNullExpressionValue(newestReplyHolder, "FeedReplyViewModel.newestReplyHolder");
        arrayList.add(newestReplyHolder);
        List<FeedReply> value6 = feedReplyViewModel.getTopReplyList().getValue();
        Intrinsics.checkNotNull(value6);
        Intrinsics.checkNotNullExpressionValue(value6, "topReplyList.value!!");
        arrayList.addAll(value6);
        if (z4) {
        }
        if (z4) {
        }
        return arrayList;
    }

    private final List<Entity> buildSimpleList(int i) {
        return this.viewModel.getLoadedDataArray().get(i).getLoadedData();
    }

    private final String findFirstItem(int i) {
        Entity entity = (Entity) CollectionsKt.firstOrNull((List<? extends Object>) this.viewModel.getLoadedDataArray().get(i).getLoadedData());
        if (entity == null) {
            return null;
        }
        String entityId = entity.getEntityId();
        return entityId != null ? entityId : entity.getId();
    }

    private final String findLastItem(int i) {
        Entity entity = (Entity) CollectionsKt.lastOrNull((List<? extends Object>) this.viewModel.getLoadedDataArray().get(i).getLoadedData());
        if (entity == null) {
            return null;
        }
        String entityId = entity.getEntityId();
        return entityId != null ? entityId : entity.getId();
    }

    public final void handleFeedReplyTopEvent(FeedReplyTopEvent feedReplyTopEvent) {
        Intrinsics.checkNotNullParameter(feedReplyTopEvent, "event");
        if (!(!Intrinsics.areEqual(feedReplyTopEvent.getReply().getFeedId(), this.viewModel.getFeedId()))) {
            if (feedReplyTopEvent.isTopNow()) {
                this.viewModel.getTopReplyList().setValue(CollectionsKt.mutableListOf(feedReplyTopEvent.getReply()));
            } else {
                this.viewModel.getTopReplyList().setValue(CollectionsKt.emptyList());
            }
        }
    }

    public final boolean checkAddToReplyMeRows(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        String parentReplyId = feedReply.getParentReplyId();
        boolean z = false;
        if (!(!(parentReplyId == null || parentReplyId.length() == 0) && (Intrinsics.areEqual(feedReply.getParentReplyId(), "0") ^ true))) {
            return false;
        }
        List<FeedReply> value = this.viewModel.getReplyMeList().getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "viewModel.replyMeList.value!!");
        List<FeedReply> list = value;
        if (list.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (Intrinsics.areEqual(it2.next().getParentReplyId(), feedReply.getParentReplyId())) {
                z = true;
            }
        }
        if (z) {
            MutableLiveData<List<FeedReply>> replyMeList = this.viewModel.getReplyMeList();
            List<FeedReply> mutableList = CollectionsKt.toMutableList((Collection) list);
            mutableList.add(feedReply);
            Unit unit = Unit.INSTANCE;
            replyMeList.setValue(mutableList);
        }
        return z;
    }
}
