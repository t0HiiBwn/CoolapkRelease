package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/viewholder/ImageXScrollCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "aspectRatio", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;F)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageXScrollCardViewHolder.kt */
public final class ImageXScrollCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageXScrollCardViewHolder(final View view, DataBindingComponent dataBindingComponent, final float f) {
        super(view, dataBindingComponent, null, new TitleRecycleViewCardViewHolder.Callback() {
            /* class com.coolapk.market.viewholder.ImageXScrollCardViewHolder.AnonymousClass1 */

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                ViewGroup.LayoutParams layoutParams = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ConvertUtils.dp2px(8.0f);
                ViewGroup.LayoutParams layoutParams2 = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ConvertUtils.dp2px(12.0f);
                titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
                titleRecycleViewCardViewHolder.getRecyclerView().setClipToPadding(false);
                titleRecycleViewCardViewHolder.getRecyclerView().addItemDecoration(((VerticalDividerItemDecoration.Builder) ((VerticalDividerItemDecoration.Builder) new VerticalDividerItemDecoration.Builder(view.getContext()).color(0)).size(SizeUtils.dp2px(8.0f))).build());
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558793, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
                Intrinsics.checkNotNullExpressionValue(component, "holder.component");
                return new ImageXScrollCardViewHolder$1$onCreateViewHolder$1(this, titleRecycleViewCardViewHolder, inflate, inflate, component, f);
            }

            @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
            public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
                Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
                Intrinsics.checkNotNullParameter(obj, "data");
                super.onBindTo(titleRecycleViewCardViewHolder, obj);
                ViewGroup.LayoutParams layoutParams = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                LinearLayoutManager linearLayoutManager = null;
                if (!(obj instanceof Entity)) {
                    obj = null;
                }
                Entity entity = (Entity) obj;
                String title = entity != null ? entity.getTitle() : null;
                float f = 12.0f;
                if (!(title == null || StringsKt.isBlank(title))) {
                    f = 8.0f;
                }
                marginLayoutParams.topMargin = ConvertUtils.dp2px(f);
                int default_size = ViewMarginData.Companion.getDEFAULT_SIZE();
                titleRecycleViewCardViewHolder.getRecyclerView().setPadding(default_size, 0, default_size, 0);
                RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    linearLayoutManager = layoutManager;
                }
                LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
                if (linearLayoutManager2 != null) {
                    linearLayoutManager2.setInitialPrefetchItemCount(4);
                }
            }
        });
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }
}
