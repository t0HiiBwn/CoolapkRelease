package com.coolapk.market.view.search;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.search.SecondhandSortListFragment;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.SecondHandFilterViewHolder;
import com.coolapk.market.widget.SuperSearchFilterView;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onActivityCreated$10 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SuperSearchFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperSearchFragment$onActivityCreated$10(SuperSearchFragment superSearchFragment) {
        super(1);
        this.this$0 = superSearchFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new SecondHandFilterViewHolder(view, SuperSearchFragment.access$getSearchType$p(this.this$0), SuperSearchFragment.access$getViewModel$p(this.this$0), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onActivityCreated$10.AnonymousClass1 */
            final /* synthetic */ SuperSearchFragment$onActivityCreated$10 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                ArrayList<Pair<String, String>> outDataList;
                ArrayList<Pair<String, String>> outDataList2;
                ArrayList<Pair<String, String>> outDataList3;
                ArrayList<Pair<String, String>> outDataList4;
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                int id = view.getId();
                SecondHandFilterViewHolder secondHandFilterViewHolder = null;
                if (id == 2131362476) {
                    SuperSearchFragment.access$getViewModel$p(this.this$0.this$0).setFilterType("1");
                    SuperSearchFilterView superSearchFilterView = this.this$0.this$0.dealTypeFilterView;
                    if (superSearchFilterView != null) {
                        superSearchFilterView.hide(true);
                    }
                    SuperSearchFilterView superSearchFilterView2 = this.this$0.this$0.secondHandOtherFilterView;
                    if (superSearchFilterView2 != null) {
                        superSearchFilterView2.hide(true);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                    if (!(itemSecondHandFilterViewHolder instanceof SecondHandFilterViewHolder)) {
                        itemSecondHandFilterViewHolder = null;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder2 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder;
                    if (secondHandFilterViewHolder2 != null) {
                        secondHandFilterViewHolder2.resetChevronView(true, 1);
                    }
                    float f = 5.0f;
                    if (this.this$0.this$0.secondHandSortFilterView == null) {
                        SuperSearchFragment superSearchFragment = this.this$0.this$0;
                        FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                        FragmentActivity fragmentActivity = requireActivity;
                        float f2 = (float) this.this$0.this$0.height;
                        if (this.this$0.this$0.isExchange) {
                            f = 7.0f;
                        }
                        superSearchFragment.secondHandSortFilterView = new SuperSearchFilterView(fragmentActivity, 2131363366, f2 * f);
                        SuperSearchFilterView superSearchFilterView3 = this.this$0.this$0.secondHandSortFilterView;
                        if (superSearchFilterView3 != null) {
                            superSearchFilterView3.setOnClickListener(new SuperSearchFragment$onActivityCreated$10$1$onItemClick$1(this));
                        }
                        View view2 = this.this$0.this$0.getView();
                        Objects.requireNonNull(view2, "null cannot be cast to non-null type android.widget.FrameLayout");
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        View view3 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                        layoutParams.topMargin = view3.getBottom();
                        Unit unit = Unit.INSTANCE;
                        ((FrameLayout) view2).addView(this.this$0.this$0.secondHandSortFilterView, layoutParams);
                        SuperSearchFragment superSearchFragment2 = this.this$0.this$0;
                        SecondhandSortListFragment.Companion companion = SecondhandSortListFragment.Companion;
                        int i = 2;
                        if (!this.this$0.this$0.isExchange) {
                            i = 1;
                        }
                        superSearchFragment2.secondhandSortListFragment = companion.newInstance(i);
                        SecondhandSortListFragment secondhandSortListFragment = this.this$0.this$0.secondhandSortListFragment;
                        if (secondhandSortListFragment != null) {
                            secondhandSortListFragment.setSuperSearchViewModel(SuperSearchFragment.access$getViewModel$p(this.this$0.this$0));
                        }
                        FragmentTransaction beginTransaction = this.this$0.this$0.getChildFragmentManager().beginTransaction();
                        SuperSearchFilterView superSearchFilterView4 = this.this$0.this$0.secondHandSortFilterView;
                        Intrinsics.checkNotNull(superSearchFilterView4);
                        int contentId = superSearchFilterView4.getContentId();
                        SecondhandSortListFragment secondhandSortListFragment2 = this.this$0.this$0.secondhandSortListFragment;
                        Intrinsics.checkNotNull(secondhandSortListFragment2);
                        beginTransaction.replace(contentId, secondhandSortListFragment2).commit();
                    } else {
                        if (this.this$0.this$0.isExchange) {
                            SuperSearchFilterView superSearchFilterView5 = this.this$0.this$0.secondHandSortFilterView;
                            if (superSearchFilterView5 != null) {
                                superSearchFilterView5.setHeight(((float) NumberExtendsKt.getDp((Number) 46)) * 7.0f);
                            }
                            SuperSearchFilterView superSearchFilterView6 = this.this$0.this$0.secondHandSortFilterView;
                            if (superSearchFilterView6 != null) {
                                superSearchFilterView6.resetView();
                            }
                            SecondhandSortListFragment secondhandSortListFragment3 = this.this$0.this$0.secondhandSortListFragment;
                            if (secondhandSortListFragment3 != null) {
                                secondhandSortListFragment3.setIndex(3);
                            }
                            SecondhandSortListFragment secondhandSortListFragment4 = this.this$0.this$0.secondhandSortListFragment;
                            if (!(secondhandSortListFragment4 == null || (outDataList2 = secondhandSortListFragment4.getOutDataList()) == null)) {
                                outDataList2.clear();
                            }
                            SecondhandSortListFragment secondhandSortListFragment5 = this.this$0.this$0.secondhandSortListFragment;
                            if (secondhandSortListFragment5 != null) {
                                secondhandSortListFragment5.reloadData();
                            }
                        } else if (this.this$0.this$0.isChangeSortList) {
                            SuperSearchFilterView superSearchFilterView7 = this.this$0.this$0.secondHandSortFilterView;
                            if (superSearchFilterView7 != null) {
                                superSearchFilterView7.setHeight(((float) NumberExtendsKt.getDp((Number) 46)) * 5.0f);
                            }
                            SuperSearchFilterView superSearchFilterView8 = this.this$0.this$0.secondHandSortFilterView;
                            if (superSearchFilterView8 != null) {
                                superSearchFilterView8.resetView();
                            }
                            SecondhandSortListFragment secondhandSortListFragment6 = this.this$0.this$0.secondhandSortListFragment;
                            if (secondhandSortListFragment6 != null) {
                                secondhandSortListFragment6.setIndex(1);
                            }
                            SecondhandSortListFragment secondhandSortListFragment7 = this.this$0.this$0.secondhandSortListFragment;
                            if (!(secondhandSortListFragment7 == null || (outDataList = secondhandSortListFragment7.getOutDataList()) == null)) {
                                outDataList.clear();
                            }
                            SecondhandSortListFragment secondhandSortListFragment8 = this.this$0.this$0.secondhandSortListFragment;
                            if (secondhandSortListFragment8 != null) {
                                secondhandSortListFragment8.reloadData();
                            }
                        }
                        SuperSearchFilterView superSearchFilterView9 = this.this$0.this$0.secondHandSortFilterView;
                        if (superSearchFilterView9 != null) {
                            FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            superSearchFilterView9.notifyDataSetChanged(childFragmentManager);
                        }
                    }
                    SuperSearchFilterView superSearchFilterView10 = this.this$0.this$0.secondHandSortFilterView;
                    if (superSearchFilterView10 == null || !superSearchFilterView10.isShow()) {
                        SuperSearchFilterView superSearchFilterView11 = this.this$0.this$0.secondHandSortFilterView;
                        if (superSearchFilterView11 != null) {
                            superSearchFilterView11.show();
                        }
                        RecyclerView.ViewHolder itemSecondHandFilterViewHolder2 = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                        if (itemSecondHandFilterViewHolder2 instanceof SecondHandFilterViewHolder) {
                            secondHandFilterViewHolder = itemSecondHandFilterViewHolder2;
                        }
                        SecondHandFilterViewHolder secondHandFilterViewHolder3 = secondHandFilterViewHolder;
                        if (secondHandFilterViewHolder3 != null) {
                            secondHandFilterViewHolder3.rotateSortChevronView();
                            return;
                        }
                        return;
                    }
                    SuperSearchFilterView superSearchFilterView12 = this.this$0.this$0.secondHandSortFilterView;
                    if (superSearchFilterView12 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView12, false, 1, null);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder3 = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                    if (!(itemSecondHandFilterViewHolder3 instanceof SecondHandFilterViewHolder)) {
                        itemSecondHandFilterViewHolder3 = null;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder4 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder3;
                    if (secondHandFilterViewHolder4 != null) {
                        SecondHandFilterViewHolder.resetSortChevronView$default(secondHandFilterViewHolder4, false, 1, null);
                    }
                } else if (id == 2131363365) {
                    SuperSearchFragment.access$getViewModel$p(this.this$0.this$0).setFilterType("2");
                    SuperSearchFilterView superSearchFilterView13 = this.this$0.this$0.dealTypeFilterView;
                    if (superSearchFilterView13 != null) {
                        superSearchFilterView13.hide(true);
                    }
                    SuperSearchFilterView superSearchFilterView14 = this.this$0.this$0.secondHandSortFilterView;
                    if (superSearchFilterView14 != null) {
                        superSearchFilterView14.hide(true);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder4 = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                    if (!(itemSecondHandFilterViewHolder4 instanceof SecondHandFilterViewHolder)) {
                        itemSecondHandFilterViewHolder4 = null;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder5 = (SecondHandFilterViewHolder) itemSecondHandFilterViewHolder4;
                    if (secondHandFilterViewHolder5 != null) {
                        secondHandFilterViewHolder5.resetChevronView(true, 0);
                    }
                    if (this.this$0.this$0.secondHandOtherFilterView == null) {
                        SuperSearchFragment superSearchFragment3 = this.this$0.this$0;
                        FragmentActivity requireActivity2 = this.this$0.this$0.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                        superSearchFragment3.secondHandOtherFilterView = new SuperSearchFilterView(requireActivity2, 2131363362, ((float) this.this$0.this$0.height) * 2.0f);
                        SuperSearchFilterView superSearchFilterView15 = this.this$0.this$0.secondHandOtherFilterView;
                        if (superSearchFilterView15 != null) {
                            superSearchFilterView15.setOnClickListener(new SuperSearchFragment$onActivityCreated$10$1$onItemClick$3(this));
                        }
                        View view4 = this.this$0.this$0.getView();
                        Objects.requireNonNull(view4, "null cannot be cast to non-null type android.widget.FrameLayout");
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                        View view5 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view5, "holder.itemView");
                        layoutParams2.topMargin = view5.getBottom();
                        Unit unit2 = Unit.INSTANCE;
                        ((FrameLayout) view4).addView(this.this$0.this$0.secondHandOtherFilterView, layoutParams2);
                        this.this$0.this$0.secondhandFilterListFragment = SecondhandFilterListFragment.Companion.newInstance(0);
                        SecondhandFilterListFragment secondhandFilterListFragment = this.this$0.this$0.secondhandFilterListFragment;
                        if (secondhandFilterListFragment != null) {
                            secondhandFilterListFragment.setSuperSearchViewModel(SuperSearchFragment.access$getViewModel$p(this.this$0.this$0));
                        }
                        FragmentTransaction beginTransaction2 = this.this$0.this$0.getChildFragmentManager().beginTransaction();
                        SuperSearchFilterView superSearchFilterView16 = this.this$0.this$0.secondHandOtherFilterView;
                        Intrinsics.checkNotNull(superSearchFilterView16);
                        int contentId2 = superSearchFilterView16.getContentId();
                        SecondhandFilterListFragment secondhandFilterListFragment2 = this.this$0.this$0.secondhandFilterListFragment;
                        Intrinsics.checkNotNull(secondhandFilterListFragment2);
                        beginTransaction2.replace(contentId2, secondhandFilterListFragment2).commit();
                    } else {
                        if (this.this$0.this$0.isBuy) {
                            SuperSearchFilterView superSearchFilterView17 = this.this$0.this$0.secondHandOtherFilterView;
                            if (superSearchFilterView17 != null) {
                                superSearchFilterView17.setHeight(((float) NumberExtendsKt.getDp((Number) 46)) * 2.0f);
                            }
                            SuperSearchFilterView superSearchFilterView18 = this.this$0.this$0.secondHandOtherFilterView;
                            if (superSearchFilterView18 != null) {
                                superSearchFilterView18.resetView();
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment3 = this.this$0.this$0.secondhandFilterListFragment;
                            if (secondhandFilterListFragment3 != null) {
                                secondhandFilterListFragment3.setIndex(1);
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment4 = this.this$0.this$0.secondhandFilterListFragment;
                            if (!(secondhandFilterListFragment4 == null || (outDataList4 = secondhandFilterListFragment4.getOutDataList()) == null)) {
                                outDataList4.clear();
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment5 = this.this$0.this$0.secondhandFilterListFragment;
                            if (secondhandFilterListFragment5 != null) {
                                secondhandFilterListFragment5.reloadData(true);
                            }
                        } else if (this.this$0.this$0.isChangeFilterList) {
                            SuperSearchFilterView superSearchFilterView19 = this.this$0.this$0.secondHandOtherFilterView;
                            if (superSearchFilterView19 != null) {
                                superSearchFilterView19.setHeight(((float) NumberExtendsKt.getDp((Number) 46)) * 3.0f);
                            }
                            SuperSearchFilterView superSearchFilterView20 = this.this$0.this$0.secondHandOtherFilterView;
                            if (superSearchFilterView20 != null) {
                                superSearchFilterView20.resetView();
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment6 = this.this$0.this$0.secondhandFilterListFragment;
                            if (secondhandFilterListFragment6 != null) {
                                secondhandFilterListFragment6.setIndex(0);
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment7 = this.this$0.this$0.secondhandFilterListFragment;
                            if (!(secondhandFilterListFragment7 == null || (outDataList3 = secondhandFilterListFragment7.getOutDataList()) == null)) {
                                outDataList3.clear();
                            }
                            SecondhandFilterListFragment secondhandFilterListFragment8 = this.this$0.this$0.secondhandFilterListFragment;
                            if (secondhandFilterListFragment8 != null) {
                                secondhandFilterListFragment8.reloadData(true);
                            }
                        }
                        SuperSearchFilterView superSearchFilterView21 = this.this$0.this$0.secondHandOtherFilterView;
                        if (superSearchFilterView21 != null) {
                            FragmentManager childFragmentManager2 = this.this$0.this$0.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                            superSearchFilterView21.notifyDataSetChanged(childFragmentManager2);
                        }
                    }
                    SuperSearchFilterView superSearchFilterView22 = this.this$0.this$0.secondHandOtherFilterView;
                    if (superSearchFilterView22 == null || !superSearchFilterView22.isShow()) {
                        SuperSearchFilterView superSearchFilterView23 = this.this$0.this$0.secondHandOtherFilterView;
                        if (superSearchFilterView23 != null) {
                            superSearchFilterView23.show();
                        }
                        RecyclerView.ViewHolder itemSecondHandFilterViewHolder5 = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                        if (itemSecondHandFilterViewHolder5 instanceof SecondHandFilterViewHolder) {
                            secondHandFilterViewHolder = itemSecondHandFilterViewHolder5;
                        }
                        SecondHandFilterViewHolder secondHandFilterViewHolder6 = (SecondHandFilterViewHolder) secondHandFilterViewHolder;
                        if (secondHandFilterViewHolder6 != null) {
                            secondHandFilterViewHolder6.rotateChevronView(0);
                            return;
                        }
                        return;
                    }
                    SuperSearchFilterView superSearchFilterView24 = this.this$0.this$0.secondHandOtherFilterView;
                    if (superSearchFilterView24 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView24, false, 1, null);
                    }
                    RecyclerView.ViewHolder itemSecondHandFilterViewHolder6 = this.this$0.this$0.getItemSecondHandFilterViewHolder();
                    if (itemSecondHandFilterViewHolder6 instanceof SecondHandFilterViewHolder) {
                        secondHandFilterViewHolder = itemSecondHandFilterViewHolder6;
                    }
                    SecondHandFilterViewHolder secondHandFilterViewHolder7 = (SecondHandFilterViewHolder) secondHandFilterViewHolder;
                    if (secondHandFilterViewHolder7 != null) {
                        secondHandFilterViewHolder7.resetChevronView(true, 0);
                    }
                }
            }
        });
    }
}
