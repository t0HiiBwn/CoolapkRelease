package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemVideoViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Video;
import com.coolapk.market.view.cardlist.EntityListFixTopHelper;
import com.coolapk.market.view.cardlist.EntityVideoHelper;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.viewholder.iview.Recyclable;
import com.coolapk.market.viewholder.iview.ViewPart;
import com.coolapk.market.viewholder.v8.VideoViewPart;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0018\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006!"}, d2 = {"Lcom/coolapk/market/viewholder/VideoViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/viewholder/iview/Recyclable;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "topHelper", "Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "videoHelper", "Lcom/coolapk/market/view/cardlist/EntityVideoHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;Lcom/coolapk/market/view/cardlist/EntityVideoHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemVideoViewBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "titleViewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "getTopHelper", "()Lcom/coolapk/market/view/cardlist/EntityListFixTopHelper;", "getVideoHelper", "()Lcom/coolapk/market/view/cardlist/EntityVideoHelper;", "videoViewHotPlug", "com/coolapk/market/viewholder/VideoViewHolder$videoViewHotPlug$1", "Lcom/coolapk/market/viewholder/VideoViewHolder$videoViewHotPlug$1;", "bindTo", "", "data", "", "onRecycled", "setupFixTop", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VideoViewHolder.kt */
public final class VideoViewHolder extends BindingViewHolder implements Recyclable {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558992;
    private final ItemVideoViewBinding binding;
    private EntityCard card;
    private final TitleViewPart titleViewPart;
    private final EntityListFixTopHelper topHelper;
    private final EntityVideoHelper videoHelper;
    private final VideoViewHolder$videoViewHotPlug$1 videoViewHotPlug;

    public final EntityListFixTopHelper getTopHelper() {
        return this.topHelper;
    }

    public final EntityVideoHelper getVideoHelper() {
        return this.videoHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListFixTopHelper entityListFixTopHelper, EntityVideoHelper entityVideoHelper) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListFixTopHelper, "topHelper");
        Intrinsics.checkNotNullParameter(entityVideoHelper, "videoHelper");
        this.topHelper = entityListFixTopHelper;
        this.videoHelper = entityVideoHelper;
        ItemVideoViewBinding itemVideoViewBinding = (ItemVideoViewBinding) getBinding();
        this.binding = itemVideoViewBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        FrameLayout frameLayout = itemVideoViewBinding.holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.holderView");
        this.titleViewPart = companion.newInstance(frameLayout, this);
        Space space = itemVideoViewBinding.videoPlayerSpaceView;
        Intrinsics.checkNotNullExpressionValue(space, "binding.videoPlayerSpaceView");
        this.videoViewHotPlug = new VideoViewHolder$videoViewHotPlug$1(this, dataBindingComponent, space, dataBindingComponent);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        VideoModel videoModel;
        int i;
        SharedPlayer optSharePlayer;
        String str;
        Intrinsics.checkNotNullParameter(obj, "data");
        ItemVideoViewBinding itemVideoViewBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemVideoViewBinding, "binding");
        if (!Intrinsics.areEqual(obj, itemVideoViewBinding.getCard())) {
            EntityCard entityCard = (EntityCard) obj;
            this.card = entityCard;
            TitleViewPart titleViewPart2 = this.titleViewPart;
            if (entityCard == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            titleViewPart2.bindToContent(entityCard);
            EntityCard entityCard2 = this.card;
            if (entityCard2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("card");
            }
            List<Entity> entities = entityCard2.getEntities();
            VideoModel videoModel2 = null;
            boolean z = false;
            Entity entity = entities != null ? (Entity) CollectionsKt.getOrNull(entities, 0) : null;
            if (!(entity instanceof Video)) {
                entity = null;
            }
            Video video = (Video) entity;
            if (video == null) {
                this.videoViewHotPlug.bindTo(VideoModel.Companion.getNO_VIDEO());
            } else {
                VideoModel viewModel = VideoModelKt.toViewModel(video);
                if (viewModel.getCoverUrl().length() == 0) {
                    EntityCard entityCard3 = this.card;
                    if (entityCard3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    String pic = entityCard3.getPic();
                    if (pic == null) {
                        pic = "";
                    }
                    EntityCard entityCard4 = this.card;
                    if (entityCard4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    String url = entityCard4.getUrl();
                    if (url != null) {
                        str = url;
                    } else {
                        str = "";
                    }
                    i = 1;
                    videoModel = VideoModel.copy$default(viewModel, null, null, pic, str, 0, 0, false, false, null, null, null, 2035, null);
                } else {
                    i = 1;
                    EntityCard entityCard5 = this.card;
                    if (entityCard5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("card");
                    }
                    String url2 = entityCard5.getUrl();
                    if (url2 == null) {
                        url2 = "";
                    }
                    videoModel = VideoModel.copy$default(viewModel, null, null, null, url2, 0, 0, false, false, null, null, null, 2039, null);
                }
                this.videoViewHotPlug.bindTo(videoModel);
                this.videoViewHotPlug.setOrderKey(getAdapterPosition());
                if (EntityExtendsKt.getIntExtraData((Entity) obj, "fixTop", 0) == i) {
                    z = true;
                }
                if (z) {
                    ViewPart optViewPart = this.videoViewHotPlug.optViewPart();
                    Intrinsics.checkNotNull(optViewPart);
                    VideoViewPart videoViewPart = (VideoViewPart) optViewPart;
                    if (this.topHelper.hasFixTopView()) {
                        SharedPlayer optSharePlayer2 = VideoManager.INSTANCE.optSharePlayer();
                        if (optSharePlayer2 != null) {
                            videoModel2 = optSharePlayer2.getVideoModel();
                        }
                        if (Intrinsics.areEqual(videoModel2, videoModel) && (optSharePlayer = VideoManager.INSTANCE.optSharePlayer()) != null) {
                            optSharePlayer.attachPlayerBridge(videoViewPart);
                        }
                    }
                    setupFixTop();
                }
            }
            this.binding.executePendingBindings();
        }
    }

    private final void setupFixTop() {
        EntityListFixTopHelper entityListFixTopHelper = this.topHelper;
        FrameLayout frameLayout = this.binding.videoContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoContainer");
        EntityListFixTopHelper entityListFixTopHelper2 = this.topHelper;
        FrameLayout frameLayout2 = this.binding.holderView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.holderView");
        ItemVideoViewBinding itemVideoViewBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemVideoViewBinding, "binding");
        Entity card2 = itemVideoViewBinding.getCard();
        Intrinsics.checkNotNull(card2);
        Intrinsics.checkNotNullExpressionValue(card2, "binding.card!!");
        entityListFixTopHelper.setFixTopView(frameLayout, new VideoViewHolder$setupFixTop$1(this, entityListFixTopHelper2, frameLayout2, card2));
    }

    @Override // com.coolapk.market.viewholder.iview.Recyclable
    public void onRecycled() {
        this.videoViewHotPlug.onRecycled();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/VideoViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VideoViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
