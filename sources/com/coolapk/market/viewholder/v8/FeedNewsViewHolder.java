package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFeedNewsViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedNewsViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedNewsViewBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "Lkotlin/Lazy;", "bindToContent", "", "data", "onClick", "view", "onRecycled", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedNewsViewHolder.kt */
public final class FeedNewsViewHolder extends GenericBindHolder<ItemFeedNewsViewBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558710;
    private Feed feed;
    private final Lazy ninePicViewPart$delegate;

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedNewsViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.ninePicViewPart$delegate = LazyKt.lazy(new FeedNewsViewHolder$ninePicViewPart$2(this, dataBindingComponent));
        ItemFeedNewsViewBinding itemFeedNewsViewBinding = (ItemFeedNewsViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedNewsViewBinding, "binding");
        itemFeedNewsViewBinding.setClick(this);
        itemFeedNewsViewBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedNewsViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedNewsViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                this.this$0.showItemDialog();
                return true;
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedNewsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedNewsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        ItemFeedNewsViewBinding itemFeedNewsViewBinding = (ItemFeedNewsViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedNewsViewBinding, "binding");
        itemFeedNewsViewBinding.setModel(null);
        ((ItemFeedNewsViewBinding) getBinding()).extraImageView.setImageDrawable(null);
    }

    public void bindToContent(Feed feed2) {
        Boolean bool;
        String str;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(feed2, "data");
        ItemFeedNewsViewBinding itemFeedNewsViewBinding = (ItemFeedNewsViewBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedNewsViewBinding, "binding");
        if (feed2 != itemFeedNewsViewBinding.getModel()) {
            itemFeedNewsViewBinding.setModel(feed2);
            List<String> htmlPicArray = EntityExtendsKt.getHtmlPicArray(feed2);
            htmlPicArray.size();
            String editorTitle = feed2.getEditorTitle();
            if (editorTitle != null) {
                bool = Boolean.valueOf(editorTitle.length() > 0);
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                str = feed2.getEditorTitle();
            } else {
                String messageTitle = feed2.getMessageTitle();
                if (messageTitle != null) {
                    bool2 = Boolean.valueOf(messageTitle.length() > 0);
                } else {
                    bool2 = null;
                }
                Intrinsics.checkNotNull(bool2);
                if (bool2.booleanValue()) {
                    str = feed2.getMessageTitle();
                } else {
                    String message = feed2.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "data.message");
                    str = new Regex("[\\n\\r]").replace(message, " ");
                }
            }
            CoolEllipsizeTextView coolEllipsizeTextView = itemFeedNewsViewBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 2, str);
            int widthPixels = (DisplayUtils.getWidthPixels(getContext()) - NumberExtendsKt.getDp((Number) 50)) / 3;
            CardView cardView = itemFeedNewsViewBinding.imageCardView;
            Intrinsics.checkNotNullExpressionValue(cardView, "binding.imageCardView");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            layoutParams.width = widthPixels;
            layoutParams.height = (int) (((double) widthPixels) * 0.75d);
            boolean contains = ArraysKt.contains(new String[]{"feedCover", "feedMiniCover"}, feed2.getEntityTemplate());
            String messageCover = feed2.getMessageCover();
            boolean z = !(messageCover == null || messageCover.length() == 0);
            StringBuilder sb = new StringBuilder();
            sb.append(feed2.getUserName());
            sb.append("  ");
            if (feed2.getReplyNum() > 0) {
                sb.append(feed2.getReplyNum() + "评论");
                sb.append("  ");
            }
            sb.append(DateUtils.getTimeDescription(getContext(), feed2.getDateline()));
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "itemInfoBuilder.toString()");
            TextView textView = itemFeedNewsViewBinding.leftBottomText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.leftBottomText");
            textView.setText(sb2);
            getNinePicViewPart().setCoverSizeWhenOne(false);
            if (contains) {
                getNinePicViewPart().setCoverSizeWhenOne(true);
                if (z) {
                    NinePicViewPart ninePicViewPart = getNinePicViewPart();
                    String messageCover2 = feed2.getMessageCover();
                    if (messageCover2 != null) {
                        str2 = messageCover2;
                    }
                    ninePicViewPart.bindToContent(CollectionsKt.listOf(str2));
                } else if (htmlPicArray.isEmpty()) {
                    getNinePicViewPart().bindToContent(htmlPicArray);
                } else {
                    getNinePicViewPart().bindToContent(CollectionsKt.listOf(CollectionsKt.first((List<? extends Object>) htmlPicArray)));
                }
                itemFeedNewsViewBinding.setImageUrl(null);
            } else if (htmlPicArray.size() >= 3) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    String messageCover3 = feed2.getMessageCover();
                    if (messageCover3 != null) {
                        str2 = messageCover3;
                    }
                    arrayList.add(str2);
                    arrayList.addAll(htmlPicArray);
                    getNinePicViewPart().bindToContent(arrayList);
                } else {
                    getNinePicViewPart().bindToContent(htmlPicArray);
                }
                itemFeedNewsViewBinding.setImageUrl(null);
            } else if (z) {
                NinePicViewPart ninePicViewPart2 = getNinePicViewPart();
                List emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
                ninePicViewPart2.bindToContent(emptyList);
                ImageArgs.Companion companion = ImageArgs.Companion;
                String messageCover4 = feed2.getMessageCover();
                if (messageCover4 != null) {
                    str2 = messageCover4;
                }
                itemFeedNewsViewBinding.setImageUrl(companion.smallSizeProvider(str2));
            } else {
                NinePicViewPart ninePicViewPart3 = getNinePicViewPart();
                List emptyList2 = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList2, "Collections.emptyList()");
                ninePicViewPart3.bindToContent(emptyList2);
                ImageArgs.Companion companion2 = ImageArgs.Companion;
                String str3 = (String) CollectionsKt.firstOrNull((List<? extends Object>) htmlPicArray);
                if (str3 != null) {
                    str2 = str3;
                }
                itemFeedNewsViewBinding.setImageUrl(companion2.smallSizeProvider(str2));
            }
        }
        itemFeedNewsViewBinding.executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedNewsViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        instance.traceFeedStayInList(root, feed2.getFeedTypeName());
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            int id = view.getId();
            if (id == 2131362200) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, FeedUriAction.Companion.buildUrl(feed2), null, null, 12, null);
            } else if (id != 2131362489) {
                super.onClick(view);
            } else {
                ActionManager.startPhotoViewActivity(view, feed2.getMessageCover(), Intrinsics.stringPlus(feed2.getMessageCover(), ".s.jpg"));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showItemDialog() {
        Feed feed2 = this.feed;
        if (feed2 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            EntityExtendsKt.showItemDialog(feed2, context);
        }
    }
}
