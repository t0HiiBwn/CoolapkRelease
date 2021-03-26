package com.coolapk.market.view.feed.reply;

import android.util.SparseArray;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.HolderItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020JJ\u000e\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020KJ\u000e\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020LJ\u0006\u0010M\u001a\u00020FR\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00170\u00170\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR6\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0$j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!`%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u000b\u001a\u0004\u0018\u00010*@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\bR\u001f\u00100\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\bR\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020403¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\"\u00107\u001a\u0004\u0018\u00010*2\b\u0010\u000b\u001a\u0004\u0018\u00010*@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u001d\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR6\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0$j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!`%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001d\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\bR6\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0$j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!`%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010'\"\u0004\bD\u0010)¨\u0006O"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "blockNum", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getBlockNum", "()Landroidx/lifecycle/MutableLiveData;", "commentNum", "getCommentNum", "<set-?>", "", "feedId", "getFeedId", "()Ljava/lang/String;", "feedType", "getFeedType", "feedUid", "getFeedUid", "feedUserName", "getFeedUserName", "filterArgs", "Lcom/coolapk/market/view/feed/reply/FilterArgs;", "getFilterArgs", "forwardNum", "getForwardNum", "", "hideAllComments", "getHideAllComments", "()Z", "hotReplyList", "", "Lcom/coolapk/market/model/FeedReply;", "getHotReplyList", "hotReplyMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHotReplyMap", "()Ljava/util/HashMap;", "setHotReplyMap", "(Ljava/util/HashMap;)V", "Lcom/coolapk/market/model/Entity;", "hotSponsorCard", "getHotSponsorCard", "()Lcom/coolapk/market/model/Entity;", "likeNum", "getLikeNum", "loadDataType", "getLoadDataType", "loadedDataArray", "Landroid/util/SparseArray;", "Lcom/coolapk/market/view/feed/reply/LoadedData;", "getLoadedDataArray", "()Landroid/util/SparseArray;", "noticeSponsorCard", "getNoticeSponsorCard", "replyMeList", "getReplyMeList", "topReplyList", "getTopReplyList", "topReplyMap", "getTopReplyMap", "setTopReplyMap", "userReplyList", "getUserReplyList", "userReplyMap", "getUserReplyMap", "setUserReplyMap", "addUserReply", "", "feedReply", "initWith", "data", "Lcom/coolapk/market/model/Album;", "Lcom/coolapk/market/model/DyhArticle;", "Lcom/coolapk/market/model/Feed;", "setPreviewMode", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyViewModel.kt */
public final class FeedReplyViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    public static final int DATA_FORWARD_LIST = 2;
    public static final int DATA_LIKE_LIST = 0;
    public static final int DATA_REPLY_LIST = 1;
    private static final HolderItem commentCountHolder = HolderItem.newBuilder().entityType("COMMENT_COUNT").build();
    private static final HolderItem currentReplyHolder = HolderItem.newBuilder().entityType("SMALL_CURRENT_TITLE").string("当前回复").build();
    private static final HolderItem hotReplyHolder = HolderItem.newBuilder().entityType("SMALL_HOT_TITLE").string("热门回复").build();
    private static final HolderItem newestReplyHolder = HolderItem.newBuilder().entityType("SMALL_NEWEST_TITLE").string("最新回复").build();
    private static final HolderItem viewHotReplyHolder = HolderItem.newBuilder().entityType("REPLY_HOT_ACTION").build();
    private final MutableLiveData<Integer> blockNum;
    private final MutableLiveData<Integer> commentNum;
    private String feedId;
    private String feedType;
    private String feedUid;
    private String feedUserName;
    private final MutableLiveData<FilterArgs> filterArgs;
    private final MutableLiveData<Integer> forwardNum;
    private boolean hideAllComments;
    private final MutableLiveData<List<FeedReply>> hotReplyList;
    private HashMap<String, FeedReply> hotReplyMap;
    private Entity hotSponsorCard;
    private final MutableLiveData<Integer> likeNum;
    private final MutableLiveData<Integer> loadDataType = new MutableLiveData<>(1);
    private final SparseArray<LoadedData> loadedDataArray;
    private Entity noticeSponsorCard;
    private final MutableLiveData<List<FeedReply>> replyMeList;
    private final MutableLiveData<List<FeedReply>> topReplyList;
    private HashMap<String, FeedReply> topReplyMap;
    private final MutableLiveData<List<FeedReply>> userReplyList;
    private HashMap<String, FeedReply> userReplyMap;

    public FeedReplyViewModel() {
        SparseArray<LoadedData> sparseArray = new SparseArray<>();
        sparseArray.put(2, new LoadedData(1, new ArrayList()));
        sparseArray.put(1, new LoadedData(1, new ArrayList()));
        sparseArray.put(0, new LoadedData(1, new ArrayList()));
        Unit unit = Unit.INSTANCE;
        this.loadedDataArray = sparseArray;
        MutableLiveData<FilterArgs> mutableLiveData = new MutableLiveData<>(FilterArgs.FILTER_BY_RECENT_REPLY);
        this.filterArgs = mutableLiveData;
        this.likeNum = new MutableLiveData<>(0);
        this.forwardNum = new MutableLiveData<>(0);
        this.commentNum = new MutableLiveData<>(0);
        this.blockNum = new MutableLiveData<>(0);
        MutableLiveData<List<FeedReply>> mutableLiveData2 = new MutableLiveData<>(CollectionsKt.emptyList());
        this.hotReplyList = mutableLiveData2;
        this.replyMeList = new MutableLiveData<>(CollectionsKt.emptyList());
        MutableLiveData<List<FeedReply>> mutableLiveData3 = new MutableLiveData<>(CollectionsKt.emptyList());
        this.topReplyList = mutableLiveData3;
        MutableLiveData<List<FeedReply>> mutableLiveData4 = new MutableLiveData<>(CollectionsKt.emptyList());
        this.userReplyList = mutableLiveData4;
        this.hotReplyMap = new HashMap<>();
        this.topReplyMap = new HashMap<>();
        this.userReplyMap = new HashMap<>();
        this.feedId = "";
        this.feedType = "";
        this.feedUid = "";
        this.feedUserName = "";
        mutableLiveData2.observeForever(new Observer<List<? extends FeedReply>>(this) {
            /* class com.coolapk.market.view.feed.reply.FeedReplyViewModel.AnonymousClass1 */
            final /* synthetic */ FeedReplyViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(List<? extends FeedReply> list) {
                this.this$0.getHotReplyMap().clear();
                Intrinsics.checkNotNullExpressionValue(list, "it");
                for (T t : list) {
                    HashMap<String, FeedReply> hotReplyMap = this.this$0.getHotReplyMap();
                    String id = t.getId();
                    if (id == null) {
                        id = "";
                    }
                    hotReplyMap.put(id, t);
                }
            }
        });
        mutableLiveData3.observeForever(new Observer<List<? extends FeedReply>>(this) {
            /* class com.coolapk.market.view.feed.reply.FeedReplyViewModel.AnonymousClass2 */
            final /* synthetic */ FeedReplyViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(List<? extends FeedReply> list) {
                this.this$0.getTopReplyMap().clear();
                Intrinsics.checkNotNullExpressionValue(list, "it");
                for (T t : list) {
                    HashMap<String, FeedReply> topReplyMap = this.this$0.getTopReplyMap();
                    String id = t.getId();
                    if (id == null) {
                        id = "";
                    }
                    topReplyMap.put(id, t);
                }
            }
        });
        mutableLiveData4.observeForever(new Observer<List<? extends FeedReply>>(this) {
            /* class com.coolapk.market.view.feed.reply.FeedReplyViewModel.AnonymousClass3 */
            final /* synthetic */ FeedReplyViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(List<? extends FeedReply> list) {
                this.this$0.getUserReplyMap().clear();
                Intrinsics.checkNotNullExpressionValue(list, "it");
                for (T t : list) {
                    HashMap<String, FeedReply> userReplyMap = this.this$0.getUserReplyMap();
                    String id = t.getId();
                    if (id == null) {
                        id = "";
                    }
                    userReplyMap.put(id, t);
                }
            }
        });
        mutableLiveData.observeForever(new Observer<FilterArgs>(this) {
            /* class com.coolapk.market.view.feed.reply.FeedReplyViewModel.AnonymousClass4 */
            final /* synthetic */ FeedReplyViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(FilterArgs filterArgs) {
                LoadedData loadedData = this.this$0.getLoadedDataArray().get(1);
                loadedData.setLoadedPage(1);
                loadedData.getLoadedData().clear();
            }
        });
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel$Companion;", "", "()V", "DATA_FORWARD_LIST", "", "DATA_LIKE_LIST", "DATA_REPLY_LIST", "commentCountHolder", "Lcom/coolapk/market/model/HolderItem;", "kotlin.jvm.PlatformType", "getCommentCountHolder", "()Lcom/coolapk/market/model/HolderItem;", "currentReplyHolder", "getCurrentReplyHolder", "hotReplyHolder", "getHotReplyHolder", "newestReplyHolder", "getNewestReplyHolder", "viewHotReplyHolder", "getViewHotReplyHolder", "obtain", "Lcom/coolapk/market/view/feed/reply/FeedReplyViewModel;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedReplyViewModel obtain(AppCompatActivity appCompatActivity) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
            ViewModel viewModel = ViewModelProviders.of(appCompatActivity).get(FeedReplyViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…plyViewModel::class.java)");
            return (FeedReplyViewModel) viewModel;
        }

        public final HolderItem getNewestReplyHolder() {
            return FeedReplyViewModel.newestReplyHolder;
        }

        public final HolderItem getHotReplyHolder() {
            return FeedReplyViewModel.hotReplyHolder;
        }

        public final HolderItem getCurrentReplyHolder() {
            return FeedReplyViewModel.currentReplyHolder;
        }

        public final HolderItem getViewHotReplyHolder() {
            return FeedReplyViewModel.viewHotReplyHolder;
        }

        public final HolderItem getCommentCountHolder() {
            return FeedReplyViewModel.commentCountHolder;
        }
    }

    public final SparseArray<LoadedData> getLoadedDataArray() {
        return this.loadedDataArray;
    }

    public final MutableLiveData<Integer> getLoadDataType() {
        return this.loadDataType;
    }

    public final MutableLiveData<FilterArgs> getFilterArgs() {
        return this.filterArgs;
    }

    public final MutableLiveData<Integer> getLikeNum() {
        return this.likeNum;
    }

    public final MutableLiveData<Integer> getForwardNum() {
        return this.forwardNum;
    }

    public final MutableLiveData<Integer> getCommentNum() {
        return this.commentNum;
    }

    public final MutableLiveData<Integer> getBlockNum() {
        return this.blockNum;
    }

    public final MutableLiveData<List<FeedReply>> getHotReplyList() {
        return this.hotReplyList;
    }

    public final MutableLiveData<List<FeedReply>> getReplyMeList() {
        return this.replyMeList;
    }

    public final MutableLiveData<List<FeedReply>> getTopReplyList() {
        return this.topReplyList;
    }

    public final MutableLiveData<List<FeedReply>> getUserReplyList() {
        return this.userReplyList;
    }

    public final HashMap<String, FeedReply> getHotReplyMap() {
        return this.hotReplyMap;
    }

    public final void setHotReplyMap(HashMap<String, FeedReply> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.hotReplyMap = hashMap;
    }

    public final HashMap<String, FeedReply> getTopReplyMap() {
        return this.topReplyMap;
    }

    public final void setTopReplyMap(HashMap<String, FeedReply> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.topReplyMap = hashMap;
    }

    public final HashMap<String, FeedReply> getUserReplyMap() {
        return this.userReplyMap;
    }

    public final void setUserReplyMap(HashMap<String, FeedReply> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.userReplyMap = hashMap;
    }

    public final String getFeedId() {
        return this.feedId;
    }

    public final String getFeedType() {
        return this.feedType;
    }

    public final String getFeedUid() {
        return this.feedUid;
    }

    public final String getFeedUserName() {
        return this.feedUserName;
    }

    public final Entity getHotSponsorCard() {
        return this.hotSponsorCard;
    }

    public final Entity getNoticeSponsorCard() {
        return this.noticeSponsorCard;
    }

    public final boolean getHideAllComments() {
        return this.hideAllComments;
    }

    public final void initWith(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        String uid = feed.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
        this.feedUid = uid;
        String id = feed.getId();
        if (id == null) {
            id = "";
        }
        this.feedId = id;
        String userName = feed.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "data.userName");
        this.feedUserName = userName;
        this.hotSponsorCard = feed.getHotSponsorCard();
        this.noticeSponsorCard = feed.getNoticeSponsorCard();
        this.commentNum.setValue(Integer.valueOf(feed.getReplyNum()));
        this.blockNum.setValue(Integer.valueOf(feed.getCommentBlockNum()));
        this.forwardNum.setValue(Integer.valueOf(feed.getForwardNum()));
        this.likeNum.setValue(Integer.valueOf(feed.getLikeNum()));
        this.hotReplyList.setValue(feed.getHotReplyRows());
        this.replyMeList.setValue(feed.getReplyMeRows());
        this.topReplyList.setValue(feed.getTopReplyRows());
        String feedType2 = feed.getFeedType();
        Intrinsics.checkNotNullExpressionValue(feedType2, "data.feedType");
        this.feedType = feedType2;
        boolean z = true;
        if (feed.getIsHistory() != 1) {
            z = false;
        }
        this.hideAllComments = z;
    }

    public final void setPreviewMode() {
        this.hideAllComments = true;
    }

    public final void initWith(Album album) {
        Intrinsics.checkNotNullParameter(album, "data");
        String uid = album.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
        this.feedUid = uid;
        String id = album.getId();
        if (id == null) {
            id = "";
        }
        this.feedId = id;
        String userName = album.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "data.userName");
        this.feedUserName = userName;
        this.commentNum.setValue(Integer.valueOf(album.getReplyNum()));
        this.blockNum.setValue(Integer.valueOf(album.getCommentBlockNum()));
        this.forwardNum.setValue(Integer.valueOf(album.getForwardNum()));
        this.likeNum.setValue(Integer.valueOf(album.getLikeNum()));
        this.hotReplyList.setValue(album.getAlbumHotReplies());
        this.replyMeList.setValue(album.getReplyMeRows());
        String entityType = album.getEntityType();
        Intrinsics.checkNotNullExpressionValue(entityType, "data.entityType");
        this.feedType = entityType;
    }

    public final void initWith(DyhArticle dyhArticle) {
        Intrinsics.checkNotNullParameter(dyhArticle, "data");
        String str = "";
        this.feedUid = str;
        String id = dyhArticle.getId();
        if (id != null) {
            str = id;
        }
        this.feedId = str;
        String userName = dyhArticle.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "data.userName");
        this.feedUserName = userName;
        this.commentNum.setValue(Integer.valueOf(dyhArticle.getReplyNum()));
        this.blockNum.setValue(0);
        this.forwardNum.setValue(Integer.valueOf(dyhArticle.getForwardNum()));
        this.likeNum.setValue(Integer.valueOf(dyhArticle.getLikeNum()));
        this.hotReplyList.setValue(CollectionsKt.emptyList());
        this.replyMeList.setValue(dyhArticle.getReplyMeRows());
        String entityType = dyhArticle.getEntityType();
        Intrinsics.checkNotNullExpressionValue(entityType, "data.entityType");
        this.feedType = entityType;
    }

    public final void addUserReply(FeedReply feedReply) {
        Intrinsics.checkNotNullParameter(feedReply, "feedReply");
        MutableLiveData<List<FeedReply>> mutableLiveData = this.userReplyList;
        List<FeedReply> value = mutableLiveData.getValue();
        Intrinsics.checkNotNull(value);
        Intrinsics.checkNotNullExpressionValue(value, "userReplyList.value!!");
        List<FeedReply> mutableList = CollectionsKt.toMutableList((Collection) value);
        mutableList.add(0, feedReply);
        Unit unit = Unit.INSTANCE;
        mutableLiveData.setValue(mutableList);
    }
}
