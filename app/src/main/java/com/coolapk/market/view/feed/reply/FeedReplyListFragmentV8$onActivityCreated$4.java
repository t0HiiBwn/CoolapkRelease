package com.coolapk.market.view.feed.reply;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemFeedReplyBinding;
import com.coolapk.market.extend.DrawableExtendsKt;
import com.coolapk.market.extend.DrawableFactory;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.MultiFeedReplyViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedReplyListFragmentV8.kt */
final class FeedReplyListFragmentV8$onActivityCreated$4 extends Lambda implements Function2<RecyclerView.ViewHolder, Object, Unit> {
    public static final FeedReplyListFragmentV8$onActivityCreated$4 INSTANCE = new FeedReplyListFragmentV8$onActivityCreated$4();

    FeedReplyListFragmentV8$onActivityCreated$4() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        invoke(viewHolder, obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RecyclerView.ViewHolder viewHolder, Object obj) {
        Intrinsics.checkNotNullParameter(viewHolder, "p1");
        TextView textView = ((ItemFeedReplyBinding) ((MultiFeedReplyViewHolder) viewHolder).getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "vh.binding.titleView");
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "tv.text");
        if (!StringsKt.endsWith$default(text, (CharSequence) "[置顶] ", false, 2, (Object) null)) {
            ViewExtendsKt.applyText(textView, new Function1<SpannableStringBuilder, Unit>("[置顶]") {
                /* class com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8$onActivityCreated$4.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SpannableStringBuilder spannableStringBuilder) {
                    invoke(spannableStringBuilder);
                    return Unit.INSTANCE;
                }

                public final void invoke(SpannableStringBuilder spannableStringBuilder) {
                    Intrinsics.checkNotNullParameter(spannableStringBuilder, "$receiver");
                    if (!StringsKt.endsWith$default((CharSequence) spannableStringBuilder, (CharSequence) "[楼主] ", false, 2, (Object) null)) {
                        spannableStringBuilder.insert(spannableStringBuilder.length(), " ");
                    }
                    spannableStringBuilder.insert(spannableStringBuilder.length(), (CharSequence) DrawableExtendsKt.toSpannable(DrawableFactory.INSTANCE.createFixTopIndicator(), "[置顶]"));
                    spannableStringBuilder.insert(spannableStringBuilder.length(), " ");
                }
            });
        }
    }
}
