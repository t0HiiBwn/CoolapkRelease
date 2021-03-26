package com.coolapk.market.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemTripleCoolPicBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.feed.FeedActionPresenter;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.v8.image.ImageArgs;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001%B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u001a\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\"H\u0002J\u001a\u0010#\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020$H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/viewholder/TripleCoolPicViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemTripleCoolPicBinding;", "Lcom/coolapk/market/model/EntityCard;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "urlParams", "", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Ljava/lang/String;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "card", "isPosting", "", "position", "", "Ljava/lang/Integer;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindToContent", "", "data", "onClick", "view", "onLikeAction", "feed", "Lcom/coolapk/market/model/Feed;", "onLongClick", "onRecycled", "setLikeState", "parentView", "Landroid/view/ViewGroup;", "setMessageText", "Lcom/coolapk/market/widget/view/CoolEllipsizeTextView;", "setMultiPicView", "Landroid/widget/ImageView;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TripleCoolPicViewHolder.kt */
public final class TripleCoolPicViewHolder extends GenericBindHolder<ItemTripleCoolPicBinding, EntityCard> implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558964;
    private EntityCard card;
    private boolean isPosting;
    private Integer position;
    private final String urlParams;
    private final TitleViewPart viewPart;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TripleCoolPicViewHolder(String str, View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(str, "urlParams");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.urlParams = str;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        LinearLayout linearLayout = ((ItemTripleCoolPicBinding) getBinding()).itemWallpaperView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemWallpaperView");
        this.viewPart = companion.newInstance(linearLayout, this);
        ItemTripleCoolPicBinding itemTripleCoolPicBinding = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding, "binding");
        itemTripleCoolPicBinding.setClick(this);
        ItemTripleCoolPicBinding itemTripleCoolPicBinding2 = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding2, "binding");
        itemTripleCoolPicBinding2.setLongClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/TripleCoolPicViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TripleCoolPicViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(EntityCard entityCard) {
        Intrinsics.checkNotNullParameter(entityCard, "data");
        if (entityCard == this.card) {
            List<Entity> entities = entityCard.getEntities();
            ItemTripleCoolPicBinding itemTripleCoolPicBinding = (ItemTripleCoolPicBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding, "binding");
            ItemTripleCoolPicBinding itemTripleCoolPicBinding2 = (ItemTripleCoolPicBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding2, "binding");
            ItemTripleCoolPicBinding itemTripleCoolPicBinding3 = (ItemTripleCoolPicBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding3, "binding");
            if (Intrinsics.areEqual(entities, CollectionsKt.arrayListOf(itemTripleCoolPicBinding.getFeed1(), itemTripleCoolPicBinding2.getFeed2(), itemTripleCoolPicBinding3.getFeed3()))) {
                return;
            }
        }
        this.card = entityCard;
        this.viewPart.bindToContent(entityCard);
        ItemTripleCoolPicBinding itemTripleCoolPicBinding4 = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding4, "binding");
        List<Entity> entities2 = entityCard.getEntities();
        Intrinsics.checkNotNull(entities2);
        Intrinsics.checkNotNullExpressionValue(entities2, "data.entities!!");
        Object orNull = CollectionsKt.getOrNull(entities2, 0);
        if (!(orNull instanceof Feed)) {
            orNull = null;
        }
        itemTripleCoolPicBinding4.setFeed1((Feed) orNull);
        List<Entity> entities3 = entityCard.getEntities();
        Intrinsics.checkNotNull(entities3);
        Intrinsics.checkNotNullExpressionValue(entities3, "data.entities!!");
        Object orNull2 = CollectionsKt.getOrNull(entities3, 1);
        if (!(orNull2 instanceof Feed)) {
            orNull2 = null;
        }
        itemTripleCoolPicBinding4.setFeed2((Feed) orNull2);
        List<Entity> entities4 = entityCard.getEntities();
        Intrinsics.checkNotNull(entities4);
        Intrinsics.checkNotNullExpressionValue(entities4, "data.entities!!");
        Object orNull3 = CollectionsKt.getOrNull(entities4, 2);
        if (!(orNull3 instanceof Feed)) {
            orNull3 = null;
        }
        itemTripleCoolPicBinding4.setFeed3((Feed) orNull3);
        itemTripleCoolPicBinding4.setTransformer(new CircleTransform(false, 0, 3, null));
        itemTripleCoolPicBinding4.executePendingBindings();
        this.isPosting = false;
        Feed feed1 = itemTripleCoolPicBinding4.getFeed1();
        LinearLayout linearLayout = itemTripleCoolPicBinding4.imgUpView1;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.imgUpView1");
        setLikeState(feed1, linearLayout);
        Feed feed2 = itemTripleCoolPicBinding4.getFeed2();
        LinearLayout linearLayout2 = itemTripleCoolPicBinding4.imgUpView2;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.imgUpView2");
        setLikeState(feed2, linearLayout2);
        Feed feed3 = itemTripleCoolPicBinding4.getFeed3();
        LinearLayout linearLayout3 = itemTripleCoolPicBinding4.imgUpView3;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.imgUpView3");
        setLikeState(feed3, linearLayout3);
        Feed feed12 = itemTripleCoolPicBinding4.getFeed1();
        ImageView imageView = itemTripleCoolPicBinding4.multiPicView1;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.multiPicView1");
        setMultiPicView(feed12, imageView);
        Feed feed22 = itemTripleCoolPicBinding4.getFeed2();
        ImageView imageView2 = itemTripleCoolPicBinding4.multiPicView2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.multiPicView2");
        setMultiPicView(feed22, imageView2);
        Feed feed32 = itemTripleCoolPicBinding4.getFeed3();
        ImageView imageView3 = itemTripleCoolPicBinding4.multiPicView3;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.multiPicView3");
        setMultiPicView(feed32, imageView3);
        Feed feed13 = itemTripleCoolPicBinding4.getFeed1();
        CoolEllipsizeTextView coolEllipsizeTextView = itemTripleCoolPicBinding4.textView1;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.textView1");
        setMessageText(feed13, coolEllipsizeTextView);
        Feed feed23 = itemTripleCoolPicBinding4.getFeed2();
        CoolEllipsizeTextView coolEllipsizeTextView2 = itemTripleCoolPicBinding4.textView2;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.textView2");
        setMessageText(feed23, coolEllipsizeTextView2);
        Feed feed33 = itemTripleCoolPicBinding4.getFeed3();
        CoolEllipsizeTextView coolEllipsizeTextView3 = itemTripleCoolPicBinding4.textView3;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView3, "binding.textView3");
        setMessageText(feed33, coolEllipsizeTextView3);
        Feed feed14 = itemTripleCoolPicBinding4.getFeed1();
        if (feed14 != null) {
            StatisticHelper instance = StatisticHelper.Companion.getInstance();
            View root = itemTripleCoolPicBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            Intrinsics.checkNotNullExpressionValue(feed14, "it");
            instance.traceFeedStayInList(root, feed14.getFeedTypeName());
        }
        Feed feed24 = itemTripleCoolPicBinding4.getFeed2();
        if (feed24 != null) {
            StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
            View root2 = itemTripleCoolPicBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            Intrinsics.checkNotNullExpressionValue(feed24, "it");
            instance2.traceFeedStayInList(root2, feed24.getFeedTypeName());
        }
        Feed feed34 = itemTripleCoolPicBinding4.getFeed3();
        if (feed34 != null) {
            StatisticHelper instance3 = StatisticHelper.Companion.getInstance();
            View root3 = itemTripleCoolPicBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
            Intrinsics.checkNotNullExpressionValue(feed34, "it");
            instance3.traceFeedStayInList(root3, feed34.getFeedTypeName());
        }
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.card = null;
        ItemTripleCoolPicBinding itemTripleCoolPicBinding = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding, "binding");
        Feed feed = null;
        itemTripleCoolPicBinding.setFeed1(feed);
        ItemTripleCoolPicBinding itemTripleCoolPicBinding2 = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding2, "binding");
        itemTripleCoolPicBinding2.setFeed2(feed);
        ItemTripleCoolPicBinding itemTripleCoolPicBinding3 = (ItemTripleCoolPicBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding3, "binding");
        itemTripleCoolPicBinding3.setFeed3(feed);
        ((ItemTripleCoolPicBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Integer num;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        EntityCard entityCard = this.card;
        if (entityCard != null) {
            Feed feed = null;
            boolean z = true;
            switch (view.getId()) {
                case 2131362708:
                case 2131362724:
                case 2131362769:
                case 2131363878:
                    List<Entity> entities = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities);
                    Entity entity = entities.get(0);
                    Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                    feed = (Feed) entity;
                    break;
                case 2131362709:
                case 2131362725:
                case 2131362773:
                case 2131363879:
                    List<Entity> entities2 = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities2);
                    Entity entity2 = entities2.get(1);
                    Objects.requireNonNull(entity2, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                    feed = (Feed) entity2;
                    break;
                case 2131362710:
                case 2131362726:
                case 2131362774:
                case 2131363880:
                    List<Entity> entities3 = entityCard.getEntities();
                    Intrinsics.checkNotNull(entities3);
                    Entity entity3 = entities3.get(2);
                    Objects.requireNonNull(entity3, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                    feed = (Feed) entity3;
                    break;
            }
            if (feed != null) {
                switch (view.getId()) {
                    case 2131362708:
                    case 2131362709:
                    case 2131362710:
                        Rect[] rectArr = new Rect[feed.getPicArray().size()];
                        rectArr[0] = ViewExtendsKt.getGlobalRect(view);
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        Activity activityNullable = UiUtils.getActivityNullable(context);
                        List<String> picArray = feed.getPicArray();
                        Intrinsics.checkNotNullExpressionValue(picArray, "feed.picArray");
                        Object[] array = picArray.toArray(new String[0]);
                        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                        String[] strArr = (String[]) array;
                        List<String> picArray2 = feed.getPicArray();
                        Intrinsics.checkNotNullExpressionValue(picArray2, "feed.picArray");
                        List<String> list = picArray2;
                        ImageArgs.Companion companion = ImageArgs.Companion;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(companion.smallSizeProvider(it2.next()));
                        }
                        Object[] array2 = arrayList.toArray(new String[0]);
                        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                        ActionManager.startPhotoViewActivity(activityNullable, strArr, (String[]) array2, 0, feed.getFeedType(), null, rectArr);
                        return;
                    case 2131362724:
                    case 2131362725:
                    case 2131362726:
                        ActionManager.checkLogin(getContext(), new TripleCoolPicViewHolder$onClick$2(this, feed));
                        return;
                    case 2131362769:
                    case 2131362773:
                    case 2131362774:
                        switch (view.getId()) {
                            case 2131362769:
                                num = Integer.valueOf(getAdapterPosition() + 0);
                                break;
                            case 2131362773:
                                num = Integer.valueOf(getAdapterPosition() + 1);
                                break;
                            case 2131362774:
                                num = Integer.valueOf(getAdapterPosition() + 2);
                                break;
                            default:
                                num = Integer.valueOf(getAdapterPosition());
                                break;
                        }
                        this.position = num;
                        Context context2 = getContext();
                        if (getAdapterPosition() != 0) {
                            z = false;
                        }
                        ActionManager.startCoolPicActivity(context2, feed, "list", z ? "old" : "both", this.urlParams);
                        return;
                    case 2131363878:
                    case 2131363879:
                    case 2131363880:
                        ActionManager.startUserSpaceActivity(getContext(), feed.getUid());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private final void setLikeState(Feed feed, ViewGroup viewGroup) {
        if (feed != null) {
            boolean z = false;
            View childAt = viewGroup.getChildAt(0);
            if (!(childAt instanceof ImageView)) {
                childAt = null;
            }
            ImageView imageView = (ImageView) childAt;
            Intrinsics.checkNotNull(imageView);
            if (feed.getUserAction() != null) {
                UserAction userAction = feed.getUserAction();
                Intrinsics.checkNotNull(userAction);
                Intrinsics.checkNotNullExpressionValue(userAction, "feed.userAction!!");
                if (userAction.getLike() > 0) {
                    z = true;
                }
            }
            if (z) {
                imageView.setImageResource(2131689495);
            } else {
                imageView.setImageResource(2131689494);
            }
        }
    }

    private final void setMultiPicView(Feed feed, ImageView imageView) {
        List<String> picArray;
        int valueOf = (feed == null || (picArray = feed.getPicArray()) == null) ? null : Integer.valueOf(picArray.size());
        int i = 0;
        if (valueOf == null) {
            valueOf = 0;
        }
        boolean z = true;
        if (valueOf.intValue() <= 1) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    private final void setMessageText(Feed feed, CoolEllipsizeTextView coolEllipsizeTextView) {
        if (feed != null) {
            String message = feed.getMessage();
            Intrinsics.checkNotNullExpressionValue(message, "feed.message");
            ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView, 1, LinkTextUtils.convert(new Regex("[\\n\\r]").replace(message, " "), AppHolder.getAppTheme().getColorAccent(), null), null, false, 12, null);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Feed feed = null;
        switch (view.getId()) {
            case 2131362769:
                ItemTripleCoolPicBinding itemTripleCoolPicBinding = (ItemTripleCoolPicBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding, "binding");
                feed = itemTripleCoolPicBinding.getFeed1();
                break;
            case 2131362773:
                ItemTripleCoolPicBinding itemTripleCoolPicBinding2 = (ItemTripleCoolPicBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding2, "binding");
                feed = itemTripleCoolPicBinding2.getFeed2();
                break;
            case 2131362774:
                ItemTripleCoolPicBinding itemTripleCoolPicBinding3 = (ItemTripleCoolPicBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemTripleCoolPicBinding3, "binding");
                feed = itemTripleCoolPicBinding3.getFeed3();
                break;
        }
        if (feed == null) {
            return super.onLongClick(view);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        EntityExtendsKt.showItemDialog(feed, context);
        return true;
    }

    /* access modifiers changed from: private */
    public final void onLikeAction(Feed feed) {
        Observable<Result<LikeResult>> observable;
        if (!this.isPosting) {
            boolean z = true;
            this.isPosting = true;
            UserAction userAction = feed.getUserAction();
            if (userAction == null || userAction.getLike() != 1) {
                z = false;
            }
            if (z) {
                observable = FeedActionPresenter.getInstance().unlikeFeed(feed, 0);
            } else {
                observable = FeedActionPresenter.getInstance().likeFeed(feed, 0);
            }
            observable.compose(RxUtils.apiCommonToData()).subscribe((Subscriber) new TripleCoolPicViewHolder$onLikeAction$3(this, feed, z));
        }
    }
}
