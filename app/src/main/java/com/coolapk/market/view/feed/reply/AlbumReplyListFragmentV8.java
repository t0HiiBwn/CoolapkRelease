package com.coolapk.market.view.feed.reply;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014J\b\u0010\u001a\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/view/feed/reply/AlbumReplyListFragmentV8;", "Lcom/coolapk/market/view/feed/reply/FeedReplyListFragmentV8;", "()V", "album", "Lcom/coolapk/market/model/Album;", "getAlbum", "()Lcom/coolapk/market/model/Album;", "setAlbum", "(Lcom/coolapk/market/model/Album;)V", "handleFeedReply", "", "reply", "Lcom/coolapk/market/model/FeedReply;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onLikeChange", "event", "Lcom/coolapk/market/event/AlbumLikeEvent;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "updateHeaderData", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumReplyListFragmentV8.kt */
public final class AlbumReplyListFragmentV8 extends FeedReplyListFragmentV8 {
    public static final Companion Companion = new Companion(null);
    public Album album;

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void updateHeaderData() {
    }

    public final Album getAlbum() {
        Album album2 = this.album;
        if (album2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("album");
        }
        return album2;
    }

    public final void setAlbum(Album album2) {
        Intrinsics.checkNotNullParameter(album2, "<set-?>");
        this.album = album2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feed/reply/AlbumReplyListFragmentV8$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/reply/AlbumReplyListFragmentV8;", "album", "Lcom/coolapk/market/model/Album;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumReplyListFragmentV8.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlbumReplyListFragmentV8 newInstance(Album album) {
            Intrinsics.checkNotNullParameter(album, "album");
            AlbumReplyListFragmentV8 albumReplyListFragmentV8 = new AlbumReplyListFragmentV8();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ALBUM", album);
            albumReplyListFragmentV8.setArguments(bundle);
            return albumReplyListFragmentV8;
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelable = requireArguments().getParcelable("ALBUM");
        Intrinsics.checkNotNull(parcelable);
        this.album = (Album) parcelable;
        FeedReplyViewModel viewModel = getViewModel();
        Album album2 = this.album;
        if (album2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("album");
        }
        viewModel.initWith(album2);
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(swipeRefreshLayout);
        if (marginParams != null) {
            marginParams.topMargin = UiUtils.getActionBarSize(getActivity()) + UiUtils.getStatusBarHeight(getActivity());
        }
        boolean z = false;
        getRecyclerView().setPadding(0, 0, 0, DisplayUtils.dp2px(getActivity(), 42.0f));
        if (bundle == null) {
            z = true;
        }
        if (z) {
            updateContentUI();
            Album album2 = this.album;
            if (album2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            List<FeedReply> replyMeRows = album2.getReplyMeRows();
            Intrinsics.checkNotNullExpressionValue(replyMeRows, "album.replyMeRows");
            if (!replyMeRows.isEmpty()) {
                fadeCommentPosition();
                scrollToCommentPosition();
            }
        }
        initData();
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8, com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (!onRequestResponse && EntityListFragment.findFirstEntityIndex$default(this, "feed_reply", null, false, false, 14, null) < 0) {
            String string = getString(2131886865);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_left_a_comment)");
            addHintView(string, new AlbumReplyListFragmentV8$onRequestResponse$1(this));
        }
        return onRequestResponse;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    @Subscribe
    public void onLikeChange(AlbumLikeEvent albumLikeEvent) {
        Intrinsics.checkNotNullParameter(albumLikeEvent, "event");
        String id = albumLikeEvent.getId();
        Album album2 = this.album;
        if (album2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("album");
        }
        if (Intrinsics.areEqual(id, album2.getAlbumId())) {
            Album album3 = this.album;
            if (album3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            Album.Builder newBuilder = Album.newBuilder(album3);
            if (albumLikeEvent.isLiked()) {
                Album album4 = this.album;
                if (album4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("album");
                }
                newBuilder.userAction(UserAction.newBuilder(album4.getUserAction()).like(1).build());
            } else {
                Album album5 = this.album;
                if (album5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("album");
                }
                newBuilder.userAction(UserAction.newBuilder(album5.getUserAction()).like(0).build());
            }
            LikeResult result = albumLikeEvent.getResult();
            Intrinsics.checkNotNullExpressionValue(result, "event.result");
            newBuilder.likeNum(result.getCount());
            Album build = newBuilder.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            this.album = build;
            Bundle requireArguments = requireArguments();
            Album album6 = this.album;
            if (album6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            requireArguments.putParcelable("ALBUM", album6);
            Album album7 = this.album;
            if (album7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            notifyCommentCountChange(album7.getCommentNum());
        }
    }

    @Override // com.coolapk.market.view.feed.reply.FeedReplyListFragmentV8
    public void handleFeedReply(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "reply");
        super.handleFeedReply(feedReply);
        String feedId = feedReply.getFeedId();
        Album album2 = this.album;
        if (album2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("album");
        }
        if (!(!Intrinsics.areEqual(feedId, album2.getId()))) {
            Album album3 = this.album;
            if (album3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            Album.Builder newBuilder = Album.newBuilder(album3);
            Album album4 = this.album;
            if (album4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            newBuilder.replyNum(album4.getReplyNum() + 1);
            Album build = newBuilder.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            this.album = build;
            Bundle requireArguments = requireArguments();
            Album album5 = this.album;
            if (album5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            requireArguments.putParcelable("ALBUM", album5);
            Album album6 = this.album;
            if (album6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("album");
            }
            notifyCommentCountChange(album6.getCommentNum());
        }
    }
}
