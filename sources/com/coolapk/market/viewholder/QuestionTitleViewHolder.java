package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemQuestionTitleViewBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.FeedQuestion;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/QuestionTitleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemQuestionTitleViewBinding;", "Lcom/coolapk/market/model/FeedQuestion;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "feed", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionTitleViewHolder.kt */
public final class QuestionTitleViewHolder extends GenericBindHolder<ItemQuestionTitleViewBinding, FeedQuestion> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558893;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuestionTitleViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(FeedQuestion feedQuestion) {
        Intrinsics.checkNotNullParameter(feedQuestion, "feed");
        ItemQuestionTitleViewBinding itemQuestionTitleViewBinding = (ItemQuestionTitleViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionTitleViewBinding, "binding");
        itemQuestionTitleViewBinding.setModel(feedQuestion);
        ItemQuestionTitleViewBinding itemQuestionTitleViewBinding2 = (ItemQuestionTitleViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionTitleViewBinding2, "binding");
        View root = itemQuestionTitleViewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.setUtilClickListener(root, new QuestionTitleViewHolder$bindToContent$1(this, feedQuestion));
        TextView textView = ((ItemQuestionTitleViewBinding) getBinding()).nameView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nameView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d人回答 · %d人关注", Arrays.copyOf(new Object[]{Integer.valueOf(feedQuestion.getQuestionAnswerNum()), Integer.valueOf(feedQuestion.getQuestionFollowNum())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        ((ItemQuestionTitleViewBinding) getBinding()).executePendingBindings();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/QuestionTitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionTitleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
