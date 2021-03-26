package com.coolapk.market.view.live;

import android.os.Parcelable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.UiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroid/os/Parcelable;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: LiveMessageListFragment.kt */
final class LiveMessageListFragment$onRequestResponse$1 extends Lambda implements Function1<List<Parcelable>, Unit> {
    final /* synthetic */ List $data;
    final /* synthetic */ Ref.BooleanRef $hasData;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ LiveMessageListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveMessageListFragment$onRequestResponse$1(LiveMessageListFragment liveMessageListFragment, boolean z, List list, Ref.BooleanRef booleanRef) {
        super(1);
        this.this$0 = liveMessageListFragment;
        this.$isRefresh = z;
        this.$data = list;
        this.$hasData = booleanRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<Parcelable> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0193 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public final void invoke(List<Parcelable> list) {
        Object obj;
        String str;
        boolean z;
        List list2;
        Entity entity;
        Integer num;
        String str2;
        Object obj2;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "it");
        boolean z3 = this.$isRefresh;
        if (Intrinsics.areEqual(this.this$0.getMessageType(), "0")) {
            SwipeRefreshLayout swipeRefreshLayout = this.this$0.getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(false);
            z3 = !this.$isRefresh;
        }
        if (Intrinsics.areEqual(this.this$0.getMessageType(), "0")) {
            RecyclerView recyclerView = this.this$0.getRecyclerView();
            Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition != -1) {
                obj = this.this$0.getAdapter$presentation_coolapkAppRelease().getItem(findFirstVisibleItemPosition);
                str = this.this$0.getMessageType();
                if (str.hashCode() == 48 && str.equals("0")) {
                    z = UiUtils.canScrollUp(this.this$0.getRecyclerView());
                } else {
                    z = UiUtils.canScrollDown(this.this$0.getRecyclerView());
                }
                boolean unused = LiveMessageListFragment$onRequestResponse$1.super.onRequestResponse(z3, (List<? extends Entity>) this.$data);
                list2 = this.$data;
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        Entity entity2 = (Entity) obj2;
                        if (Intrinsics.areEqual(entity2.getEntityType(), "liveMessage") || Intrinsics.areEqual(entity2.getEntityType(), "liveSystemMessage")) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            break;
                        }
                    }
                    entity = (Entity) obj2;
                } else {
                    entity = null;
                }
                this.$hasData.element = entity != null;
                num = null;
                if (Intrinsics.areEqual(this.this$0.getMessageType(), "0") && obj != null) {
                    num = Integer.valueOf(CollectionsKt.indexOf((List<? extends Object>) this.this$0.getDataList(), obj));
                }
                str2 = this.this$0.getMessageType();
                if (str2.hashCode() == 48 && str2.equals("0")) {
                    if (!this.this$0.getDataList().isEmpty()) {
                        return;
                    }
                    if (z3) {
                        if (num != null) {
                            this.this$0.scrollTo(num.intValue(), Integer.valueOf(NumberExtendsKt.getDp((Number) 48)));
                            return;
                        }
                        return;
                    } else if (z) {
                        return;
                    } else {
                        if (this.this$0.firstShowList) {
                            RecyclerView recyclerView2 = this.this$0.getRecyclerView();
                            Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                            ViewExtendsKt.onceOnGlobalLayoutListener(recyclerView2, new Function0<Unit>(this) {
                                /* class com.coolapk.market.view.live.LiveMessageListFragment$onRequestResponse$1.AnonymousClass1 */
                                final /* synthetic */ LiveMessageListFragment$onRequestResponse$1 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final void invoke() {
                                    boolean z = (this.this$0.this$0.firstShowList) && CollectionUtils.isNotEmpty(this.this$0.$data);
                                    if (z) {
                                        this.this$0.this$0.firstShowList = false;
                                        RecyclerView recyclerView = this.this$0.this$0.getRecyclerView();
                                        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                                        recyclerView.setVisibility(4);
                                    }
                                    LiveMessageListFragment.scrollTo$default(this.this$0.this$0, CollectionsKt.getLastIndex(this.this$0.this$0.getDataList()), null, 2, null);
                                    if (z) {
                                        this.this$0.this$0.getRecyclerView().post(new Runnable(this) {
                                            /* class com.coolapk.market.view.live.LiveMessageListFragment$onRequestResponse$1.AnonymousClass1.AnonymousClass1 */
                                            final /* synthetic */ AnonymousClass1 this$0;

                                            {
                                                this.this$0 = r1;
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                RecyclerView recyclerView = this.this$0.this$0.this$0.getRecyclerView();
                                                Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                                                recyclerView.setVisibility(0);
                                            }
                                        });
                                    }
                                }
                            });
                            return;
                        } else if (CollectionsKt.getLastIndex(this.this$0.getDataList()) > 0) {
                            this.this$0.getAdapter$presentation_coolapkAppRelease().notifyItemChanged(CollectionsKt.getLastIndex(this.this$0.getDataList()) - 1);
                            LiveMessageListFragment liveMessageListFragment = this.this$0;
                            LiveMessageListFragment.scrollTo$default(liveMessageListFragment, CollectionsKt.getLastIndex(liveMessageListFragment.getDataList()), null, 2, null);
                            return;
                        } else {
                            return;
                        }
                    }
                } else if (!(!this.this$0.getDataList().isEmpty()) && !z) {
                    LiveMessageListFragment.scrollTo$default(this.this$0, 0, null, 2, null);
                    return;
                } else {
                    return;
                }
            }
        }
        obj = null;
        str = this.this$0.getMessageType();
        if (str.hashCode() == 48) {
            z = UiUtils.canScrollUp(this.this$0.getRecyclerView());
            boolean unused = LiveMessageListFragment$onRequestResponse$1.super.onRequestResponse(z3, (List<? extends Entity>) this.$data);
            list2 = this.$data;
            if (list2 != null) {
            }
            this.$hasData.element = entity != null;
            num = null;
            num = Integer.valueOf(CollectionsKt.indexOf((List<? extends Object>) this.this$0.getDataList(), obj));
            str2 = this.this$0.getMessageType();
            if (str2.hashCode() == 48) {
                if (!this.this$0.getDataList().isEmpty()) {
                }
            }
            if (!(!this.this$0.getDataList().isEmpty())) {
                return;
            }
            return;
        }
        z = UiUtils.canScrollDown(this.this$0.getRecyclerView());
        boolean unused = LiveMessageListFragment$onRequestResponse$1.super.onRequestResponse(z3, (List<? extends Entity>) this.$data);
        list2 = this.$data;
        if (list2 != null) {
        }
        this.$hasData.element = entity != null;
        num = null;
        num = Integer.valueOf(CollectionsKt.indexOf((List<? extends Object>) this.this$0.getDataList(), obj));
        str2 = this.this$0.getMessageType();
        if (str2.hashCode() == 48) {
        }
        if (!(!this.this$0.getDataList().isEmpty())) {
        }
    }
}
