package com.coolapk.market.view.search;

import androidx.databinding.Observable;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.AppFilterViewHolder;
import com.coolapk.market.viewholder.SecondHandFilterViewHolder;
import com.coolapk.market.widget.SuperSearchFilterView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/search/SuperSearchFragment$onPropertyChangedCallback$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
public final class SuperSearchFragment$onPropertyChangedCallback$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ SuperSearchFragment this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    SuperSearchFragment$onPropertyChangedCallback$1(SuperSearchFragment superSearchFragment) {
        this.this$0 = superSearchFragment;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable observable, int i) {
        Intrinsics.checkNotNullParameter(observable, "sender");
        if (this.this$0.isAdded()) {
            RecyclerView.ViewHolder viewHolder = null;
            if (i == 28 || i == 31) {
                if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "apk")) {
                    this.this$0.updateItemAppFilter();
                    this.this$0.clearDataAndReload();
                    SuperSearchFilterView superSearchFilterView = this.this$0.appFilterView;
                    if (superSearchFilterView != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView, false, 1, null);
                    }
                    SuperSearchFilterView superSearchFilterView2 = this.this$0.sortFilterView;
                    if (superSearchFilterView2 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView2, false, 1, null);
                    }
                    RecyclerView.ViewHolder viewHolder2 = this.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder2 instanceof AppFilterViewHolder)) {
                        viewHolder2 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder = (AppFilterViewHolder) viewHolder2;
                    if (appFilterViewHolder != null) {
                        AppFilterViewHolder.resetCategoryChevronView$default(appFilterViewHolder, false, 1, null);
                    }
                    RecyclerView.ViewHolder viewHolder3 = this.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder3 instanceof AppFilterViewHolder)) {
                        viewHolder3 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder2 = (AppFilterViewHolder) viewHolder3;
                    if (appFilterViewHolder2 != null) {
                        AppFilterViewHolder.resetSortChevronView$default(appFilterViewHolder2, false, 1, null);
                    }
                }
            } else if (i != 38) {
                if (i != 65) {
                    if (i != 108) {
                        if (i != 110) {
                            if (i != 128 && i != 129) {
                                switch (i) {
                                    case 238:
                                        if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ershou")) {
                                            SuperSearchFragment superSearchFragment = this.this$0;
                                            superSearchFragment.lastSecondHandSort = SuperSearchFragment.access$getViewModel$p(superSearchFragment).getSecondHandChangeSort();
                                            this.this$0.updateItemSecondHandFilter();
                                            this.this$0.clearDataAndReload();
                                            SuperSearchFilterView superSearchFilterView3 = this.this$0.secondHandSortFilterView;
                                            if (superSearchFilterView3 != null) {
                                                SuperSearchFilterView.hide$default(superSearchFilterView3, false, 1, null);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (!(itemSecondHandFilterViewHolder instanceof SecondHandFilterViewHolder)) {
                                                itemSecondHandFilterViewHolder = null;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder;
                                            if (secondHandFilterViewHolder != null) {
                                                secondHandFilterViewHolder.resetChevronView(false, 0);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder2 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (!(itemSecondHandFilterViewHolder2 instanceof SecondHandFilterViewHolder)) {
                                                itemSecondHandFilterViewHolder2 = null;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder2 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder2;
                                            if (secondHandFilterViewHolder2 != null) {
                                                secondHandFilterViewHolder2.resetChevronView(false, 1);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder3 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (itemSecondHandFilterViewHolder3 instanceof SecondHandFilterViewHolder) {
                                                viewHolder = itemSecondHandFilterViewHolder3;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder3 = (SecondHandFilterViewHolder) viewHolder;
                                            if (secondHandFilterViewHolder3 != null) {
                                                secondHandFilterViewHolder3.resetChevronView(false, 2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 239:
                                        if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ershou")) {
                                            this.this$0.updateItemSecondHandFilter();
                                            this.this$0.clearDataAndReload();
                                            SuperSearchFilterView superSearchFilterView4 = this.this$0.secondHandOtherFilterView;
                                            if (superSearchFilterView4 != null) {
                                                SuperSearchFilterView.hide$default(superSearchFilterView4, false, 1, null);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder4 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (!(itemSecondHandFilterViewHolder4 instanceof SecondHandFilterViewHolder)) {
                                                itemSecondHandFilterViewHolder4 = null;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder4 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder4;
                                            if (secondHandFilterViewHolder4 != null) {
                                                secondHandFilterViewHolder4.resetChevronView(false, 2);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder5 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (itemSecondHandFilterViewHolder5 instanceof SecondHandFilterViewHolder) {
                                                viewHolder = itemSecondHandFilterViewHolder5;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder5 = (SecondHandFilterViewHolder) viewHolder;
                                            if (secondHandFilterViewHolder5 != null) {
                                                secondHandFilterViewHolder5.resetChevronView(false, 2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 240:
                                        if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ershou")) {
                                            SuperSearchFragment superSearchFragment2 = this.this$0;
                                            superSearchFragment2.lastSecondHandFilter = SuperSearchFragment.access$getViewModel$p(superSearchFragment2).getSecondHandOther();
                                            this.this$0.updateItemSecondHandFilter();
                                            this.this$0.clearDataAndReload();
                                            SuperSearchFilterView superSearchFilterView5 = this.this$0.secondHandOtherFilterView;
                                            if (superSearchFilterView5 != null) {
                                                SuperSearchFilterView.hide$default(superSearchFilterView5, false, 1, null);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder6 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (!(itemSecondHandFilterViewHolder6 instanceof SecondHandFilterViewHolder)) {
                                                itemSecondHandFilterViewHolder6 = null;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder6 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder6;
                                            if (secondHandFilterViewHolder6 != null) {
                                                secondHandFilterViewHolder6.resetChevronView(false, 0);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder7 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (!(itemSecondHandFilterViewHolder7 instanceof SecondHandFilterViewHolder)) {
                                                itemSecondHandFilterViewHolder7 = null;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder7 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder7;
                                            if (secondHandFilterViewHolder7 != null) {
                                                secondHandFilterViewHolder7.resetChevronView(false, 1);
                                            }
                                            RecyclerView.ViewHolder itemSecondHandFilterViewHolder8 = this.this$0.getItemSecondHandFilterViewHolder();
                                            if (itemSecondHandFilterViewHolder8 instanceof SecondHandFilterViewHolder) {
                                                viewHolder = itemSecondHandFilterViewHolder8;
                                            }
                                            SecondHandFilterViewHolder secondHandFilterViewHolder8 = (SecondHandFilterViewHolder) viewHolder;
                                            if (secondHandFilterViewHolder8 != null) {
                                                secondHandFilterViewHolder8.resetChevronView(false, 2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    case 241:
                                        try {
                                            if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ershou")) {
                                                SuperSearchFragment superSearchFragment3 = this.this$0;
                                                superSearchFragment3.lastSecondHandSort = SuperSearchFragment.access$getViewModel$p(superSearchFragment3).getSecondHandSort();
                                                this.this$0.updateItemSecondHandFilter();
                                                this.this$0.clearDataAndReload();
                                                SuperSearchFilterView superSearchFilterView6 = this.this$0.secondHandSortFilterView;
                                                if (superSearchFilterView6 != null) {
                                                    SuperSearchFilterView.hide$default(superSearchFilterView6, false, 1, null);
                                                }
                                                RecyclerView.ViewHolder itemSecondHandFilterViewHolder9 = this.this$0.getItemSecondHandFilterViewHolder();
                                                if (!(itemSecondHandFilterViewHolder9 instanceof SecondHandFilterViewHolder)) {
                                                    itemSecondHandFilterViewHolder9 = null;
                                                }
                                                SecondHandFilterViewHolder secondHandFilterViewHolder9 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder9;
                                                if (secondHandFilterViewHolder9 != null) {
                                                    secondHandFilterViewHolder9.resetChevronView(false, 0);
                                                }
                                                RecyclerView.ViewHolder itemSecondHandFilterViewHolder10 = this.this$0.getItemSecondHandFilterViewHolder();
                                                if (!(itemSecondHandFilterViewHolder10 instanceof SecondHandFilterViewHolder)) {
                                                    itemSecondHandFilterViewHolder10 = null;
                                                }
                                                SecondHandFilterViewHolder secondHandFilterViewHolder10 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder10;
                                                if (secondHandFilterViewHolder10 != null) {
                                                    secondHandFilterViewHolder10.resetChevronView(false, 1);
                                                }
                                                RecyclerView.ViewHolder itemSecondHandFilterViewHolder11 = this.this$0.getItemSecondHandFilterViewHolder();
                                                if (itemSecondHandFilterViewHolder11 instanceof SecondHandFilterViewHolder) {
                                                    viewHolder = itemSecondHandFilterViewHolder11;
                                                }
                                                SecondHandFilterViewHolder secondHandFilterViewHolder11 = (SecondHandFilterViewHolder) viewHolder;
                                                if (secondHandFilterViewHolder11 != null) {
                                                    secondHandFilterViewHolder11.resetChevronView(false, 2);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            return;
                                        }
                                    default:
                                        return;
                                }
                            } else if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "game")) {
                                this.this$0.updateItemAppFilter();
                                this.this$0.clearDataAndReload();
                                SuperSearchFilterView superSearchFilterView7 = this.this$0.appFilterView;
                                if (superSearchFilterView7 != null) {
                                    SuperSearchFilterView.hide$default(superSearchFilterView7, false, 1, null);
                                }
                                SuperSearchFilterView superSearchFilterView8 = this.this$0.sortFilterView;
                                if (superSearchFilterView8 != null) {
                                    SuperSearchFilterView.hide$default(superSearchFilterView8, false, 1, null);
                                }
                                RecyclerView.ViewHolder viewHolder4 = this.this$0.getItemAppFilterViewHolder();
                                if (!(viewHolder4 instanceof AppFilterViewHolder)) {
                                    viewHolder4 = null;
                                }
                                AppFilterViewHolder appFilterViewHolder3 = (AppFilterViewHolder) viewHolder4;
                                if (appFilterViewHolder3 != null) {
                                    AppFilterViewHolder.resetCategoryChevronView$default(appFilterViewHolder3, false, 1, null);
                                }
                                RecyclerView.ViewHolder viewHolder5 = this.this$0.getItemAppFilterViewHolder();
                                if (!(viewHolder5 instanceof AppFilterViewHolder)) {
                                    viewHolder5 = null;
                                }
                                AppFilterViewHolder appFilterViewHolder4 = (AppFilterViewHolder) viewHolder5;
                                if (appFilterViewHolder4 != null) {
                                    AppFilterViewHolder.resetSortChevronView$default(appFilterViewHolder4, false, 1, null);
                                }
                            }
                        } else if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "feed")) {
                            this.this$0.updateItemFeedFilter();
                            this.this$0.clearDataAndReload();
                        }
                    } else if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "feed")) {
                        this.this$0.updateItemFeedFilter();
                        this.this$0.clearDataAndReload();
                    }
                } else if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ershou")) {
                    if (!Intrinsics.areEqual(this.this$0.lastSecondHandDealType, SuperSearchFragment.access$getViewModel$p(this.this$0).getDealType())) {
                        SuperSearchFragment.access$getViewModel$p(this.this$0).setSecondHandSort("default");
                    }
                    this.this$0.updateItemSecondHandFilter();
                    this.this$0.clearDataAndReload();
                    SuperSearchFilterView superSearchFilterView9 = this.this$0.dealTypeFilterView;
                    if (superSearchFilterView9 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView9, false, 1, null);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder12 = this.this$0.getItemSecondHandFilterViewHolder();
                    if (!(itemSecondHandFilterViewHolder12 instanceof SecondHandFilterViewHolder)) {
                        itemSecondHandFilterViewHolder12 = null;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder12 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder12;
                    if (secondHandFilterViewHolder12 != null) {
                        secondHandFilterViewHolder12.resetChevronView(false, 0);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder13 = this.this$0.getItemSecondHandFilterViewHolder();
                    if (!(itemSecondHandFilterViewHolder13 instanceof SecondHandFilterViewHolder)) {
                        itemSecondHandFilterViewHolder13 = null;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder13 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder13;
                    if (secondHandFilterViewHolder13 != null) {
                        secondHandFilterViewHolder13.resetChevronView(false, 1);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder14 = this.this$0.getItemSecondHandFilterViewHolder();
                    if (itemSecondHandFilterViewHolder14 instanceof SecondHandFilterViewHolder) {
                        viewHolder = itemSecondHandFilterViewHolder14;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder14 = (SecondHandFilterViewHolder) viewHolder;
                    if (secondHandFilterViewHolder14 != null) {
                        secondHandFilterViewHolder14.resetChevronView(false, 2);
                    }
                    SuperSearchFragment superSearchFragment4 = this.this$0;
                    superSearchFragment4.isChangeSortList = !Intrinsics.areEqual(SuperSearchFragment.access$getViewModel$p(superSearchFragment4).getDealType(), this.this$0.lastSecondHandDealType);
                    SuperSearchFragment superSearchFragment5 = this.this$0;
                    superSearchFragment5.isChangeFilterList = !Intrinsics.areEqual(SuperSearchFragment.access$getViewModel$p(superSearchFragment5).getDealType(), this.this$0.lastSecondHandDealType);
                    SuperSearchFragment superSearchFragment6 = this.this$0;
                    superSearchFragment6.isExchange = Intrinsics.areEqual(SuperSearchFragment.access$getViewModel$p(superSearchFragment6).getDealType(), "2");
                    SuperSearchFragment superSearchFragment7 = this.this$0;
                    superSearchFragment7.isBuy = Intrinsics.areEqual(SuperSearchFragment.access$getViewModel$p(superSearchFragment7).getDealType(), "1");
                    SuperSearchFragment superSearchFragment8 = this.this$0;
                    superSearchFragment8.lastSecondHandDealType = SuperSearchFragment.access$getViewModel$p(superSearchFragment8).getDealType();
                }
            } else if (Intrinsics.areEqual(SuperSearchFragment.access$getSearchType$p(this.this$0), "ask")) {
                this.this$0.updateItemAskFilter();
                this.this$0.clearDataAndReload();
            }
        }
    }
}
