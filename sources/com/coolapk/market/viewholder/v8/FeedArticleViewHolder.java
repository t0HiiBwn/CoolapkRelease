package com.coolapk.market.viewholder.v8;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedCoverViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.uri.FeedUriAction;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.viewholder.v8.image.NinePicViewPart;
import com.coolapk.market.widget.hotplug.BaseHotReplyHotPlug;
import com.coolapk.market.widget.hotplug.BaseRatingDataHotPlug;
import com.coolapk.market.widget.hotplug.BaseRatingHotPlug;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u001f\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001(B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\"H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006)"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedArticleViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemFeedCoverViewBinding;", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "feed", "headerViewPart", "Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "getHeaderViewPart", "()Lcom/coolapk/market/viewholder/v8/FeedIntegratedHeaderViewPart;", "headerViewPart$delegate", "Lkotlin/Lazy;", "hotReplyHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseHotReplyHotPlug;", "ninePicViewPart", "Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "getNinePicViewPart", "()Lcom/coolapk/market/viewholder/v8/image/NinePicViewPart;", "ninePicViewPart$delegate", "ratingDataHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingDataHotPlug;", "ratingHotPlug", "Lcom/coolapk/market/widget/hotplug/BaseRatingHotPlug;", "relativeInfoHotPlug", "com/coolapk/market/viewholder/v8/FeedArticleViewHolder$relativeInfoHotPlug$1", "Lcom/coolapk/market/viewholder/v8/FeedArticleViewHolder$relativeInfoHotPlug$1;", "bindToContent", "", "data", "onClick", "view", "onRecycled", "showItemDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedArticleViewHolder.kt */
public final class FeedArticleViewHolder extends GenericBindHolder<ItemFeedCoverViewBinding, Feed> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558702;
    private Feed feed;
    private final Lazy headerViewPart$delegate;
    private final BaseHotReplyHotPlug hotReplyHotPlug;
    private final Lazy ninePicViewPart$delegate;
    private final BaseRatingDataHotPlug ratingDataHotPlug;
    private final BaseRatingHotPlug ratingHotPlug;
    private final FeedArticleViewHolder$relativeInfoHotPlug$1 relativeInfoHotPlug;

    private final FeedIntegratedHeaderViewPart getHeaderViewPart() {
        return (FeedIntegratedHeaderViewPart) this.headerViewPart$delegate.getValue();
    }

    private final NinePicViewPart getNinePicViewPart() {
        return (NinePicViewPart) this.ninePicViewPart$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedArticleViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.headerViewPart$delegate = LazyKt.lazy(new FeedArticleViewHolder$headerViewPart$2(this, dataBindingComponent));
        Space space = ((ItemFeedCoverViewBinding) getBinding()).relativeSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.relativeSpaceView");
        this.relativeInfoHotPlug = new FeedArticleViewHolder$relativeInfoHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
        this.ninePicViewPart$delegate = LazyKt.lazy(new FeedArticleViewHolder$ninePicViewPart$2(this, dataBindingComponent));
        Space space2 = ((ItemFeedCoverViewBinding) getBinding()).hotReplySpaceView;
        Intrinsics.checkNotNullExpressionValue(space2, "binding.hotReplySpaceView");
        this.hotReplyHotPlug = new BaseHotReplyHotPlug(space2, dataBindingComponent, null, false, 12, null);
        Space space3 = ((ItemFeedCoverViewBinding) getBinding()).ratingSpaceView;
        Intrinsics.checkNotNullExpressionValue(space3, "binding.ratingSpaceView");
        this.ratingHotPlug = new BaseRatingHotPlug(space3, dataBindingComponent, null, false, 12, null);
        Space space4 = ((ItemFeedCoverViewBinding) getBinding()).ratingDataSpaceView;
        Intrinsics.checkNotNullExpressionValue(space4, "binding.ratingDataSpaceView");
        this.ratingDataHotPlug = new BaseRatingDataHotPlug(space4, dataBindingComponent, null, false, 12, null);
        ItemFeedCoverViewBinding itemFeedCoverViewBinding = (ItemFeedCoverViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedCoverViewBinding, "binding");
        itemFeedCoverViewBinding.setClick(this);
        itemFeedCoverViewBinding.cardView.setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.coolapk.market.viewholder.v8.FeedArticleViewHolder.AnonymousClass1 */
            final /* synthetic */ FeedArticleViewHolder this$0;

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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/v8/FeedArticleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedArticleViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        ItemFeedCoverViewBinding itemFeedCoverViewBinding = (ItemFeedCoverViewBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemFeedCoverViewBinding, "binding");
        itemFeedCoverViewBinding.setModel(null);
        ((ItemFeedCoverViewBinding) getBinding()).extraImageView.setImageDrawable(null);
        this.relativeInfoHotPlug.onRecycled();
        this.hotReplyHotPlug.onRecycled();
        this.ratingHotPlug.onRecycled();
        this.ratingDataHotPlug.onRecycled();
    }

    public void bindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        ItemFeedCoverViewBinding itemFeedCoverViewBinding = (ItemFeedCoverViewBinding) getBinding();
        this.feed = feed2;
        Intrinsics.checkNotNullExpressionValue(itemFeedCoverViewBinding, "binding");
        if (feed2 != itemFeedCoverViewBinding.getModel()) {
            itemFeedCoverViewBinding.setModel(feed2);
            getHeaderViewPart().bindTo(feed2);
            this.hotReplyHotPlug.bindTo(feed2);
            this.relativeInfoHotPlug.bindTo(feed2);
            this.ratingHotPlug.bindTo(feed2);
            this.ratingDataHotPlug.bindTo(feed2);
            CoolEllipsizeTextView coolEllipsizeTextView = itemFeedCoverViewBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.titleView");
            String messageTitle = feed2.getMessageTitle();
            String str = "";
            if (messageTitle == null) {
                messageTitle = str;
            }
            ViewExtendsKt.setMaxLineEllipsize(coolEllipsizeTextView, 2, messageTitle);
            String message = feed2.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "data.message");
            SpannableStringBuilder convert = LinkTextUtils.convert(new Regex("[\\n\\r]").replace(message, " "), AppHolder.getAppTheme().getColorAccent(), null);
            CoolEllipsizeTextView coolEllipsizeTextView2 = itemFeedCoverViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.textView");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView2, 3, convert, null, false, 12, null);
            boolean contains = ArraysKt.contains(new String[]{"feedCover", "feedMiniCover"}, feed2.getEntityTemplate());
            List<String> htmlPicArray = EntityExtendsKt.getHtmlPicArray(feed2);
            String messageCover = feed2.getMessageCover();
            boolean z = !(messageCover == null || messageCover.length() == 0);
            getNinePicViewPart().setCoverSizeWhenOne(false);
            if (contains) {
                getNinePicViewPart().setCoverSizeWhenOne(true);
                if (z) {
                    NinePicViewPart ninePicViewPart = getNinePicViewPart();
                    String messageCover2 = feed2.getMessageCover();
                    if (messageCover2 != null) {
                        str = messageCover2;
                    }
                    ninePicViewPart.bindToContent(CollectionsKt.listOf(str));
                } else if (htmlPicArray.isEmpty()) {
                    getNinePicViewPart().bindToContent(htmlPicArray);
                } else {
                    getNinePicViewPart().bindToContent(CollectionsKt.listOf(CollectionsKt.first((List<? extends Object>) htmlPicArray)));
                }
                itemFeedCoverViewBinding.setImageUrl(null);
            } else if (htmlPicArray.size() >= 3) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    String messageCover3 = feed2.getMessageCover();
                    if (messageCover3 != null) {
                        str = messageCover3;
                    }
                    arrayList.add(str);
                    arrayList.addAll(htmlPicArray);
                    getNinePicViewPart().bindToContent(arrayList);
                } else {
                    getNinePicViewPart().bindToContent(htmlPicArray);
                }
                itemFeedCoverViewBinding.setImageUrl(null);
            } else if (z) {
                NinePicViewPart ninePicViewPart2 = getNinePicViewPart();
                List emptyList = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList, "Collections.emptyList()");
                ninePicViewPart2.bindToContent(emptyList);
                ImageArgs.Companion companion = ImageArgs.Companion;
                String messageCover4 = feed2.getMessageCover();
                if (messageCover4 != null) {
                    str = messageCover4;
                }
                itemFeedCoverViewBinding.setImageUrl(companion.smallSizeProvider(str));
            } else {
                NinePicViewPart ninePicViewPart3 = getNinePicViewPart();
                List emptyList2 = Collections.emptyList();
                Intrinsics.checkNotNullExpressionValue(emptyList2, "Collections.emptyList()");
                ninePicViewPart3.bindToContent(emptyList2);
                ImageArgs.Companion companion2 = ImageArgs.Companion;
                String str2 = (String) CollectionsKt.firstOrNull((List<? extends Object>) htmlPicArray);
                if (str2 != null) {
                    str = str2;
                }
                itemFeedCoverViewBinding.setImageUrl(companion2.smallSizeProvider(str));
            }
        } else {
            itemFeedCoverViewBinding.feedActionView.updateFeed(feed2);
        }
        itemFeedCoverViewBinding.executePendingBindings();
        StatisticHelper instance = StatisticHelper.Companion.getInstance();
        View root = itemFeedCoverViewBinding.getRoot();
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
            } else if (id != 2131362497) {
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
