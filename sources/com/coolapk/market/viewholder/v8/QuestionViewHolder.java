package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemQuestionViewBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.widget.hotplug.BaseFeedRelativeHotPlug;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemQuestionViewBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "relativeInfoHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseFeedRelativeHotPlug;", "bindToContent", "", "onClick", "view", "onRecycled", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionViewHolder.kt */
public final class QuestionViewHolder extends GenericBindHolder<ItemQuestionViewBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558894;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final BaseFeedRelativeHotPlug relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuestionViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new QuestionViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space = ((ItemQuestionViewBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new BaseFeedRelativeHotPlug(space, dataBindingComponent, null, false, 12, null);
        ItemQuestionViewBinding itemQuestionViewBinding = (ItemQuestionViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionViewBinding, "binding");
        itemQuestionViewBinding.setClick(this);
        ((ItemQuestionViewBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.QuestionViewHolder.AnonymousClass1 */
            final /* synthetic */ QuestionViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                Feed feed = this.this$0.feed;
                boolean z = false;
                if (feed != null && EntityExtendsKt.getIntExtraData(feed, "showCancelFollowMenu", 0) == 1) {
                    z = true;
                }
                if (z) {
                    CancelFollowItemDialog.Companion companion = CancelFollowItemDialog.Companion;
                    Feed feed2 = this.this$0.feed;
                    Intrinsics.checkNotNull(feed2);
                    CancelFollowItemDialog newInstance = companion.newInstance(feed2);
                    Context context = this.this$0.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                } else {
                    Feed feed3 = this.this$0.feed;
                    if (feed3 != null) {
                        Context context2 = this.this$0.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        EntityExtendsKt.showItemDialog(feed3, context2);
                    }
                }
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/QuestionViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.relativeInfoHotPlug.onRecycled();
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.feed = feed2;
        ItemQuestionViewBinding itemQuestionViewBinding = (ItemQuestionViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemQuestionViewBinding, "binding");
        itemQuestionViewBinding.setModel(feed2);
        getHeaderViewPart().bindTo(this.feed);
        this.relativeInfoHotPlug.bindTo(feed2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("[Question]");
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setBounds(0, 0, DisplayUtils.dp2px(getContext(), 38.0f), 0);
        spannableStringBuilder.setSpan(new ImageSpan(colorDrawable, "[Question]"), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) feed2.getMessageTitle());
        TextView textView = itemQuestionViewBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(spannableStringBuilder);
        TextView textView2 = itemQuestionViewBinding.countView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.countView");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d人回答 · %d人关注", Arrays.copyOf(new Object[]{Integer.valueOf(feed2.getQuestionAnswerNum()), Integer.valueOf(feed2.getQuestionFollowNum())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        textView2.setText(format);
        itemQuestionViewBinding.executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemQuestionViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            int id = view.getId();
            if (id == 2131362205) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
            } else if (id != 2131363900) {
                super.onClick(view);
            } else {
                ActionManager.startUserSpaceActivity(view, feed2.getUid(), feed2.getUserAvatar());
            }
        }
    }
}
