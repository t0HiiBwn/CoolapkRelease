package com.coolapk.market.view.search;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.viewholder.AppFilterViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.SuperSearchFilterView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SuperSearchFragment.kt */
final class SuperSearchFragment$onActivityCreated$8 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SuperSearchFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuperSearchFragment$onActivityCreated$8(SuperSearchFragment superSearchFragment) {
        super(1);
        this.this$0 = superSearchFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new AppFilterViewHolder(view, SuperSearchFragment.access$getSearchType$p(this.this$0), SuperSearchFragment.access$getViewModel$p(this.this$0), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.search.SuperSearchFragment$onActivityCreated$8.AnonymousClass1 */
            final /* synthetic */ SuperSearchFragment$onActivityCreated$8 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                String str;
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                String access$getSearchType$p = SuperSearchFragment.access$getSearchType$p(this.this$0.this$0);
                int hashCode = access$getSearchType$p.hashCode();
                if (hashCode != 96796) {
                    if (hashCode == 3165170 && access$getSearchType$p.equals("game")) {
                        str = "2";
                    }
                    throw new RuntimeException("Unknown searchType to apkType: " + SuperSearchFragment.access$getSearchType$p(this.this$0.this$0));
                }
                if (access$getSearchType$p.equals("apk")) {
                    str = "1";
                }
                throw new RuntimeException("Unknown searchType to apkType: " + SuperSearchFragment.access$getSearchType$p(this.this$0.this$0));
                int id = view.getId();
                AppFilterViewHolder appFilterViewHolder = null;
                if (id == 2131362073) {
                    SuperSearchFilterView superSearchFilterView = this.this$0.this$0.sortFilterView;
                    if (superSearchFilterView != null) {
                        superSearchFilterView.hide(true);
                    }
                    RecyclerView.ViewHolder viewHolder2 = this.this$0.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder2 instanceof AppFilterViewHolder)) {
                        viewHolder2 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder2 = (AppFilterViewHolder) viewHolder2;
                    if (appFilterViewHolder2 != null) {
                        appFilterViewHolder2.resetSortChevronView(true);
                    }
                    if (this.this$0.this$0.appFilterView == null) {
                        SuperSearchFragment superSearchFragment = this.this$0.this$0;
                        FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                        superSearchFragment.appFilterView = new SuperSearchFilterView(requireActivity, 2131362078, ((float) this.this$0.this$0.height) * 7.5f);
                        SuperSearchFilterView superSearchFilterView2 = this.this$0.this$0.appFilterView;
                        if (superSearchFilterView2 != null) {
                            superSearchFilterView2.setOnClickListener(new SuperSearchFragment$onActivityCreated$8$1$onItemClick$1(this));
                        }
                        View view2 = this.this$0.this$0.getView();
                        Objects.requireNonNull(view2, "null cannot be cast to non-null type android.widget.FrameLayout");
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        View view3 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                        layoutParams.topMargin = view3.getBottom();
                        Unit unit = Unit.INSTANCE;
                        ((FrameLayout) view2).addView(this.this$0.this$0.appFilterView, layoutParams);
                        AppCategoryListFragment newInstance = AppCategoryListFragment.Companion.newInstance(str);
                        newInstance.setSuperSearchViewModel(SuperSearchFragment.access$getViewModel$p(this.this$0.this$0));
                        FragmentTransaction beginTransaction = this.this$0.this$0.getChildFragmentManager().beginTransaction();
                        SuperSearchFilterView superSearchFilterView3 = this.this$0.this$0.appFilterView;
                        Intrinsics.checkNotNull(superSearchFilterView3);
                        beginTransaction.replace(superSearchFilterView3.getContentId(), newInstance).commit();
                    } else {
                        SuperSearchFilterView superSearchFilterView4 = this.this$0.this$0.appFilterView;
                        if (superSearchFilterView4 != null) {
                            FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                            superSearchFilterView4.notifyDataSetChanged(childFragmentManager);
                        }
                    }
                    SuperSearchFilterView superSearchFilterView5 = this.this$0.this$0.appFilterView;
                    if (superSearchFilterView5 == null || !superSearchFilterView5.isShow()) {
                        SuperSearchFilterView superSearchFilterView6 = this.this$0.this$0.appFilterView;
                        if (superSearchFilterView6 != null) {
                            superSearchFilterView6.show();
                        }
                        RecyclerView.ViewHolder viewHolder3 = this.this$0.this$0.getItemAppFilterViewHolder();
                        if (viewHolder3 instanceof AppFilterViewHolder) {
                            appFilterViewHolder = viewHolder3;
                        }
                        AppFilterViewHolder appFilterViewHolder3 = appFilterViewHolder;
                        if (appFilterViewHolder3 != null) {
                            appFilterViewHolder3.rotateCategoryChevronView();
                            return;
                        }
                        return;
                    }
                    SuperSearchFilterView superSearchFilterView7 = this.this$0.this$0.appFilterView;
                    if (superSearchFilterView7 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView7, false, 1, null);
                    }
                    RecyclerView.ViewHolder viewHolder4 = this.this$0.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder4 instanceof AppFilterViewHolder)) {
                        viewHolder4 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder4 = (AppFilterViewHolder) viewHolder4;
                    if (appFilterViewHolder4 != null) {
                        AppFilterViewHolder.resetCategoryChevronView$default(appFilterViewHolder4, false, 1, null);
                    }
                } else if (id == 2131362082) {
                    SuperSearchFilterView superSearchFilterView8 = this.this$0.this$0.appFilterView;
                    if (superSearchFilterView8 != null) {
                        superSearchFilterView8.hide(true);
                    }
                    RecyclerView.ViewHolder viewHolder5 = this.this$0.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder5 instanceof AppFilterViewHolder)) {
                        viewHolder5 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder5 = (AppFilterViewHolder) viewHolder5;
                    if (appFilterViewHolder5 != null) {
                        appFilterViewHolder5.resetCategoryChevronView(true);
                    }
                    if (this.this$0.this$0.sortFilterView == null) {
                        SuperSearchFragment superSearchFragment2 = this.this$0.this$0;
                        FragmentActivity requireActivity2 = this.this$0.this$0.requireActivity();
                        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                        superSearchFragment2.sortFilterView = new SuperSearchFilterView(requireActivity2, 2131363399, ((float) this.this$0.this$0.height) * 7.0f);
                        SuperSearchFilterView superSearchFilterView9 = this.this$0.this$0.sortFilterView;
                        if (superSearchFilterView9 != null) {
                            superSearchFilterView9.setOnClickListener(new SuperSearchFragment$onActivityCreated$8$1$onItemClick$3(this));
                        }
                        View view4 = this.this$0.this$0.getView();
                        Objects.requireNonNull(view4, "null cannot be cast to non-null type android.widget.FrameLayout");
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                        View view5 = viewHolder.itemView;
                        Intrinsics.checkNotNullExpressionValue(view5, "holder.itemView");
                        layoutParams2.topMargin = view5.getBottom();
                        Unit unit2 = Unit.INSTANCE;
                        ((FrameLayout) view4).addView(this.this$0.this$0.sortFilterView, layoutParams2);
                        AppSortListFragment newInstance2 = AppSortListFragment.Companion.newInstance(str);
                        newInstance2.setSuperSearchViewModel(SuperSearchFragment.access$getViewModel$p(this.this$0.this$0));
                        FragmentTransaction beginTransaction2 = this.this$0.this$0.getChildFragmentManager().beginTransaction();
                        SuperSearchFilterView superSearchFilterView10 = this.this$0.this$0.sortFilterView;
                        Intrinsics.checkNotNull(superSearchFilterView10);
                        beginTransaction2.replace(superSearchFilterView10.getContentId(), newInstance2).commit();
                    } else {
                        SuperSearchFilterView superSearchFilterView11 = this.this$0.this$0.sortFilterView;
                        if (superSearchFilterView11 != null) {
                            FragmentManager childFragmentManager2 = this.this$0.this$0.getChildFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
                            superSearchFilterView11.notifyDataSetChanged(childFragmentManager2);
                        }
                    }
                    SuperSearchFilterView superSearchFilterView12 = this.this$0.this$0.sortFilterView;
                    if (superSearchFilterView12 == null || !superSearchFilterView12.isShow()) {
                        SuperSearchFilterView superSearchFilterView13 = this.this$0.this$0.sortFilterView;
                        if (superSearchFilterView13 != null) {
                            superSearchFilterView13.show();
                        }
                        RecyclerView.ViewHolder viewHolder6 = this.this$0.this$0.getItemAppFilterViewHolder();
                        if (viewHolder6 instanceof AppFilterViewHolder) {
                            appFilterViewHolder = viewHolder6;
                        }
                        AppFilterViewHolder appFilterViewHolder6 = (AppFilterViewHolder) appFilterViewHolder;
                        if (appFilterViewHolder6 != null) {
                            appFilterViewHolder6.rotateSortChevronView();
                            return;
                        }
                        return;
                    }
                    SuperSearchFilterView superSearchFilterView14 = this.this$0.this$0.sortFilterView;
                    if (superSearchFilterView14 != null) {
                        SuperSearchFilterView.hide$default(superSearchFilterView14, false, 1, null);
                    }
                    RecyclerView.ViewHolder viewHolder7 = this.this$0.this$0.getItemAppFilterViewHolder();
                    if (!(viewHolder7 instanceof AppFilterViewHolder)) {
                        viewHolder7 = null;
                    }
                    AppFilterViewHolder appFilterViewHolder7 = (AppFilterViewHolder) viewHolder7;
                    if (appFilterViewHolder7 != null) {
                        AppFilterViewHolder.resetSortChevronView$default(appFilterViewHolder7, false, 1, null);
                    }
                }
            }
        });
    }
}
