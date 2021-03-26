package com.coolapk.market.view.search;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Entity;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.SearchRecommendViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SearchRecommendListFragment.kt */
final class SearchRecommendListFragment$onActivityCreated$2 extends Lambda implements Function1<View, RecyclerView.ViewHolder> {
    final /* synthetic */ SearchRecommendListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchRecommendListFragment$onActivityCreated$2(SearchRecommendListFragment searchRecommendListFragment) {
        super(1);
        this.this$0 = searchRecommendListFragment;
    }

    public final RecyclerView.ViewHolder invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        return new SearchRecommendViewHolder(view, this.this$0.getBindingComponent(), new ItemActionHandler(this) {
            /* class com.coolapk.market.view.search.SearchRecommendListFragment$onActivityCreated$2.AnonymousClass1 */
            final /* synthetic */ SearchRecommendListFragment$onActivityCreated$2 this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // com.coolapk.market.viewholder.ItemActionHandler
            public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
                Intrinsics.checkNotNullParameter(viewHolder, "holder");
                Intrinsics.checkNotNullParameter(view, "view");
                super.onItemClick(viewHolder, view);
                Object tag = viewHolder.itemView.getTag(2131362753);
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
                Entity entity = (Entity) tag;
                String url = entity.getUrl();
                if (url == null || url.length() == 0) {
                    FragmentActivity activity = this.this$0.this$0.getActivity();
                    Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
                    String title = entity.getTitle();
                    Intrinsics.checkNotNull(title);
                    Intrinsics.checkNotNullExpressionValue(title, "entity.title!!");
                    ((SuperSearchActivity) activity).inputKeyword(title);
                    return;
                }
                FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ActionManagerCompat.startActivityByUrl(requireActivity, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
                String queryParameter = Uri.parse(entity.getUrl()).getQueryParameter("keyword");
                Intrinsics.checkNotNull(queryParameter);
                Intrinsics.checkNotNullExpressionValue(queryParameter, "Uri.parse(entity.url).ge…eryParameter(\"keyword\")!!");
                FragmentActivity activity2 = this.this$0.this$0.getActivity();
                Objects.requireNonNull(activity2, "null cannot be cast to non-null type com.coolapk.market.view.search.SuperSearchActivity");
                ((SuperSearchActivity) activity2).updateDatabase(queryParameter);
            }
        });
    }
}
