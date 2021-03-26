package com.coolapk.market.view.userv9;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.view.album.UserAlbumListPresenter;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;
import com.coolapk.market.view.center.DeveloperAppListFragment;
import com.coolapk.market.view.center.RelativeAppListFragment;
import com.coolapk.market.view.center.UserHtmlFeedListFragment;
import com.coolapk.market.view.center.UserQAListFragment;
import com.coolapk.market.view.goodsList.FunThingsListFragment;
import com.coolapk.market.view.main.AlbumListFragment;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.view.user.UserDiscoveryListPresenter;
import com.coolapk.market.view.user.UserFlexPictureFragment;
import com.coolapk.market.view.userv9.UserBlockListFragment;
import com.coolapk.market.view.userv9.UserCollectionListFragment;
import com.coolapk.market.view.userv9.UserRatingListFragment;
import com.coolapk.market.view.userv9.UserSpaceV9FeedListFragment;
import com.coolapk.market.view.userv9.UserSpaceV9ReplyListFragment;
import com.coolapk.market.view.wallpaper.coolpic.FallsListFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\bJ\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000208J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010:\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>J\u0016\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u0002042\u0006\u00105\u001a\u00020\bR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0014\u0010\u001d\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0014\u0010\u001f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\nR\u0014\u0010!\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\nR\u0014\u0010#\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\nR\u0014\u0010'\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020\b0,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006A"}, d2 = {"Lcom/coolapk/market/view/userv9/UserSpaceV9TabHelper;", "", "context", "Landroid/app/Activity;", "viewModel", "Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "(Landroid/app/Activity;Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;)V", "VIEW_PAGER_ALBUM", "", "getVIEW_PAGER_ALBUM", "()I", "VIEW_PAGER_APK_FOLLOW", "getVIEW_PAGER_APK_FOLLOW", "VIEW_PAGER_ARTICLE", "getVIEW_PAGER_ARTICLE", "VIEW_PAGER_COLLECTION", "getVIEW_PAGER_COLLECTION", "VIEW_PAGER_COOLPIC", "getVIEW_PAGER_COOLPIC", "VIEW_PAGER_DEVELOPER_APP", "getVIEW_PAGER_DEVELOPER_APP", "VIEW_PAGER_DISCOVERY", "getVIEW_PAGER_DISCOVERY", "VIEW_PAGER_FEEDS", "getVIEW_PAGER_FEEDS", "VIEW_PAGER_MAIN", "getVIEW_PAGER_MAIN", "VIEW_PAGER_QA", "getVIEW_PAGER_QA", "VIEW_PAGER_RATING", "getVIEW_PAGER_RATING", "VIEW_PAGER_REPLY", "getVIEW_PAGER_REPLY", "VIEW_PAGE_BLOCK", "getVIEW_PAGE_BLOCK", "VIEW_PAGE_GOODS", "getVIEW_PAGE_GOODS", "VIEW_PAGE_GOODS_LIST", "getVIEW_PAGE_GOODS_LIST", "VIEW_PAGE_RECYCLE_BIN", "getVIEW_PAGE_RECYCLE_BIN", "getContext", "()Landroid/app/Activity;", "tabList", "", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "getViewModel", "()Lcom/coolapk/market/view/userv9/UserSpaceV9ViewModel;", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "getPreferDisplayPage", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "onCreateTabTitleList", "profile", "restorePresenter", "", "savedInstanceState", "Landroid/os/Bundle;", "setPresenter", "pendingFragment", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserSpaceV9TabHelper.kt */
public final class UserSpaceV9TabHelper {
    private final int VIEW_PAGER_ALBUM = 2131887128;
    private final int VIEW_PAGER_APK_FOLLOW = 2131887129;
    private final int VIEW_PAGER_ARTICLE = 2131887131;
    private final int VIEW_PAGER_COLLECTION = 2131887133;
    private final int VIEW_PAGER_COOLPIC = 2131886687;
    private final int VIEW_PAGER_DEVELOPER_APP = 2131887134;
    private final int VIEW_PAGER_DISCOVERY = 2131887136;
    private final int VIEW_PAGER_FEEDS = 2131887137;
    private final int VIEW_PAGER_MAIN = 2131887139;
    private final int VIEW_PAGER_QA = 2131887140;
    private final int VIEW_PAGER_RATING = 2131887130;
    private final int VIEW_PAGER_REPLY = 2131887297;
    private final int VIEW_PAGE_BLOCK = 2131887132;
    private final int VIEW_PAGE_GOODS = 2131887138;
    private final int VIEW_PAGE_GOODS_LIST = 2131886828;
    private final int VIEW_PAGE_RECYCLE_BIN = 2131887141;
    private final Activity context;
    private List<Integer> tabList;
    private final UserSpaceV9ViewModel viewModel;

    public UserSpaceV9TabHelper(Activity activity, UserSpaceV9ViewModel userSpaceV9ViewModel) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(userSpaceV9ViewModel, "viewModel");
        this.context = activity;
        this.viewModel = userSpaceV9ViewModel;
        UserProfile userProfile = userSpaceV9ViewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        this.tabList = onCreateTabTitleList(userProfile);
    }

    public final Activity getContext() {
        return this.context;
    }

    public final UserSpaceV9ViewModel getViewModel() {
        return this.viewModel;
    }

    public final int getVIEW_PAGER_FEEDS() {
        return this.VIEW_PAGER_FEEDS;
    }

    public final int getVIEW_PAGER_DEVELOPER_APP() {
        return this.VIEW_PAGER_DEVELOPER_APP;
    }

    public final int getVIEW_PAGER_APK_FOLLOW() {
        return this.VIEW_PAGER_APK_FOLLOW;
    }

    public final int getVIEW_PAGER_ALBUM() {
        return this.VIEW_PAGER_ALBUM;
    }

    public final int getVIEW_PAGER_DISCOVERY() {
        return this.VIEW_PAGER_DISCOVERY;
    }

    public final int getVIEW_PAGER_RATING() {
        return this.VIEW_PAGER_RATING;
    }

    public final int getVIEW_PAGER_COOLPIC() {
        return this.VIEW_PAGER_COOLPIC;
    }

    public final int getVIEW_PAGER_REPLY() {
        return this.VIEW_PAGER_REPLY;
    }

    public final int getVIEW_PAGER_ARTICLE() {
        return this.VIEW_PAGER_ARTICLE;
    }

    public final int getVIEW_PAGER_QA() {
        return this.VIEW_PAGER_QA;
    }

    public final int getVIEW_PAGER_COLLECTION() {
        return this.VIEW_PAGER_COLLECTION;
    }

    public final int getVIEW_PAGER_MAIN() {
        return this.VIEW_PAGER_MAIN;
    }

    public final int getVIEW_PAGE_BLOCK() {
        return this.VIEW_PAGE_BLOCK;
    }

    public final int getVIEW_PAGE_GOODS_LIST() {
        return this.VIEW_PAGE_GOODS_LIST;
    }

    public final int getVIEW_PAGE_GOODS() {
        return this.VIEW_PAGE_GOODS;
    }

    public final int getVIEW_PAGE_RECYCLE_BIN() {
        return this.VIEW_PAGE_RECYCLE_BIN;
    }

    public final List<Integer> getTabList() {
        return this.tabList;
    }

    public final void setTabList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tabList = list;
    }

    public final void setPresenter(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "pendingFragment");
        UserProfile userProfile = this.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        String uid = userProfile.getUid();
        int intValue = this.tabList.get(i).intValue();
        if (intValue == this.VIEW_PAGER_DISCOVERY) {
            CompatFeedListFragment compatFeedListFragment = (CompatFeedListFragment) fragment;
            compatFeedListFragment.setPresenter(new UserDiscoveryListPresenter(compatFeedListFragment, uid));
        } else if (intValue == this.VIEW_PAGER_ALBUM) {
            AlbumListFragment albumListFragment = (AlbumListFragment) fragment;
            albumListFragment.setPresenter(new UserAlbumListPresenter(albumListFragment, uid));
        }
    }

    public final Fragment getFragmentItem(int i) {
        DataListFragment dataListFragment;
        UserProfile userProfile = this.viewModel.getUserProfile();
        Intrinsics.checkNotNull(userProfile);
        String uid = userProfile.getUid();
        int intValue = this.tabList.get(i).intValue();
        if (intValue == this.VIEW_PAGER_MAIN) {
            dataListFragment = UserSpaceHomeTabFragment.Companion.newInstance(new ArrayList<>(userProfile.getHomeTabCardRows()));
        } else if (intValue == this.VIEW_PAGER_FEEDS) {
            UserSpaceV9FeedListFragment.Companion companion = UserSpaceV9FeedListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion.newInstance(uid, userProfile.getFeedNum());
        } else if (intValue == this.VIEW_PAGER_DISCOVERY) {
            dataListFragment = CompatFeedListFragment.Companion.newInstance();
        } else if (intValue == this.VIEW_PAGER_DEVELOPER_APP) {
            dataListFragment = DeveloperAppListFragment.Companion.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_APK_FOLLOW) {
            dataListFragment = RelativeAppListFragment.Companion.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_RATING) {
            UserRatingListFragment.Companion companion2 = UserRatingListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion2.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_ALBUM) {
            AlbumListFragment newInstance = AlbumListFragment.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "AlbumListFragment.newInstance()");
            dataListFragment = newInstance;
        } else if (intValue == this.VIEW_PAGER_COOLPIC) {
            UserFlexPictureFragment.Companion companion3 = UserFlexPictureFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion3.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_REPLY) {
            UserSpaceV9ReplyListFragment.Companion companion4 = UserSpaceV9ReplyListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion4.newInstance(uid, userProfile.getReplyNum());
        } else if (intValue == this.VIEW_PAGER_ARTICLE) {
            UserHtmlFeedListFragment.Companion companion5 = UserHtmlFeedListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion5.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_QA) {
            UserQAListFragment.Companion companion6 = UserQAListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion6.newInstance(uid);
        } else if (intValue == this.VIEW_PAGER_COLLECTION) {
            UserCollectionListFragment.Companion companion7 = UserCollectionListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion7.newInstance(uid);
        } else if (intValue == this.VIEW_PAGE_BLOCK) {
            UserBlockListFragment.Companion companion8 = UserBlockListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion8.newInstance(uid);
        } else if (intValue == this.VIEW_PAGE_GOODS_LIST) {
            FunThingsListFragment.Companion companion9 = FunThingsListFragment.Companion;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dataListFragment = companion9.newInstance(uid);
        } else if (intValue == this.VIEW_PAGE_GOODS) {
            FallsListFragment.Companion companion10 = FallsListFragment.Companion;
            dataListFragment = FallsListFragment.Companion.newInstance$default(companion10, "/goods/goodsFeedList?uid=" + uid + "&type=default&fragmentTemplate=flex", null, null, 6, null);
        } else if (intValue == this.VIEW_PAGE_RECYCLE_BIN) {
            DataListFragment.Companion companion11 = DataListFragment.Companion;
            dataListFragment = DataListFragment.Companion.newInstance$default(companion11, "#/feed/userDeleteFeedList?uid=" + uid, null, null, 0, 14, null);
        } else {
            throw new RuntimeException("unknown position " + i);
        }
        setPresenter(dataListFragment, i);
        return dataListFragment;
    }

    public final int getPreferDisplayPage(UserProfile userProfile) {
        Intrinsics.checkNotNullParameter(userProfile, "userProfile");
        if (!this.tabList.contains(Integer.valueOf(this.VIEW_PAGER_MAIN))) {
            return this.tabList.indexOf(Integer.valueOf(this.VIEW_PAGER_FEEDS));
        }
        if (Intrinsics.areEqual(userProfile.getSelectedTab(), "home")) {
            return this.tabList.indexOf(Integer.valueOf(this.VIEW_PAGER_MAIN));
        }
        if (Intrinsics.areEqual(userProfile.getSelectedTab(), "feed")) {
            return this.tabList.indexOf(Integer.valueOf(this.VIEW_PAGER_FEEDS));
        }
        if (userProfile.getIsFollow() != 1) {
            String uid = userProfile.getUid();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            if (!Intrinsics.areEqual(uid, loginSession.getUid())) {
                return this.tabList.indexOf(Integer.valueOf(this.VIEW_PAGER_MAIN));
            }
        }
        return this.tabList.indexOf(Integer.valueOf(this.VIEW_PAGER_FEEDS));
    }

    private final List<Integer> onCreateTabTitleList(UserProfile userProfile) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean isAdmin = loginSession.isAdmin();
        ArrayList arrayList = new ArrayList();
        List<Entity> homeTabCardRows = userProfile.getHomeTabCardRows();
        Intrinsics.checkNotNullExpressionValue(homeTabCardRows, "profile.homeTabCardRows");
        if (!homeTabCardRows.isEmpty()) {
            arrayList.add(Integer.valueOf(this.VIEW_PAGER_MAIN));
        }
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_FEEDS));
        if (isAdmin) {
            arrayList.add(Integer.valueOf(this.VIEW_PAGER_REPLY));
            arrayList.add(Integer.valueOf(this.VIEW_PAGE_BLOCK));
        }
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_RATING));
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_ARTICLE));
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_QA));
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_COOLPIC));
        arrayList.add(Integer.valueOf(this.VIEW_PAGE_GOODS));
        arrayList.add(Integer.valueOf(this.VIEW_PAGE_GOODS_LIST));
        arrayList.add(Integer.valueOf(this.VIEW_PAGER_COLLECTION));
        AppMetadataKt.runOnAppMode$default(this, null, UserSpaceV9TabHelper$onCreateTabTitleList$1.INSTANCE, null, new UserSpaceV9TabHelper$onCreateTabTitleList$2(this, arrayList), 5, null);
        if (isAdmin) {
            arrayList.add(Integer.valueOf(this.VIEW_PAGE_RECYCLE_BIN));
        }
        return arrayList;
    }

    public final void restorePresenter(Bundle bundle) {
        if (!(bundle == null || this.viewModel.getUserProfile() == null)) {
            int size = this.tabList.size();
            for (int i = 0; i < size; i++) {
                String string = this.context.getString(this.tabList.get(i).intValue());
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(tabList.get(i))");
                Fragment findFragmentByTag = ContextExtendsKt.requireAppCompatActivity(this.context).getSupportFragmentManager().findFragmentByTag(string);
                if (findFragmentByTag != null) {
                    setPresenter(findFragmentByTag, i);
                }
            }
        }
    }
}
