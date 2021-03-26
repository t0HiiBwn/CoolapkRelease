package com.coolapk.market.view.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemCircleFeedTopBinding;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.imageloader.GlideFragmentImageLoader;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.feedv8.FeedArgsFactory;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.FilterLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0003-./B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u0014H\u0014J \u0010%\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0014J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/coolapk/market/view/main/CircleFeedV8Fragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "lastFeedGroupType", "Lcom/coolapk/market/view/main/CircleFeedV8Fragment$FeedGroupType;", "loginSession", "Lcom/coolapk/market/local/LoginSession;", "kotlin.jvm.PlatformType", "createFilterLayout", "Lcom/coolapk/market/widget/view/FilterLayout;", "filterDataWhenRefresh", "", "originData", "", "index", "newDataByCardId", "", "", "findUserActionTopPosition", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "onEmptyViewClick", "onRequestResponse", "setFeedGroupType", "type", "shouldInterceptFeedEvent", "event", "showPopMenu", "target", "Landroid/view/View;", "CircleTopViewHolder", "Companion", "FeedGroupType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CircleFeedV8Fragment.kt */
public final class CircleFeedV8Fragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private static final String ENTITY_TYPE_ACTION_TOP = "ACTION_TOP";
    private static final String PREF_KEY_LAST_GROUP_FEED_TYPE = "last_group_feed_type";
    private FeedGroupType lastFeedGroupType = FeedGroupType.FEED_TYPE_ALL;
    private final LoginSession loginSession;

    public CircleFeedV8Fragment() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        this.loginSession = instance.getLoginSession();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/main/CircleFeedV8Fragment$Companion;", "", "()V", "ENTITY_TYPE_ACTION_TOP", "", "PREF_KEY_LAST_GROUP_FEED_TYPE", "newInstance", "Lcom/coolapk/market/view/main/CircleFeedV8Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CircleFeedV8Fragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CircleFeedV8Fragment newInstance() {
            CircleFeedV8Fragment circleFeedV8Fragment = new CircleFeedV8Fragment();
            circleFeedV8Fragment.setArguments(new Bundle());
            return circleFeedV8Fragment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/main/CircleFeedV8Fragment$FeedGroupType;", "", "type", "", "textId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTextId", "()I", "getType", "()Ljava/lang/String;", "validId", "FEED_TYPE_ALL", "FEED_TYPE_CIRCLE", "FEED_TYPE_APK", "FEED_TYPE_TOPIC", "FEED_TYPE_QUESTION", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CircleFeedV8Fragment.kt */
    public enum FeedGroupType {
        FEED_TYPE_ALL("all", 2131886359),
        FEED_TYPE_CIRCLE("circle", 2131886361),
        FEED_TYPE_APK("apk", 2131886360),
        FEED_TYPE_TOPIC("tag", 2131886363),
        FEED_TYPE_QUESTION("question", 2131886362);
        
        private final int textId;
        private final String type;

        private FeedGroupType(String str, int i) {
            this.type = str;
            this.textId = i;
        }

        public final int getTextId() {
            return this.textId;
        }

        public final String getType() {
            return this.type;
        }

        public final int validId() {
            return ordinal() + 100;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        FeedGroupType feedGroupType;
        super.onCreate(bundle);
        String preferencesString = DataManager.getInstance().getPreferencesString(PREF_KEY_LAST_GROUP_FEED_TYPE, "");
        FeedGroupType[] values = FeedGroupType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                feedGroupType = null;
                break;
            }
            feedGroupType = values[i];
            if (Intrinsics.areEqual(feedGroupType.getType(), preferencesString)) {
                break;
            }
            i++;
        }
        if (feedGroupType == null) {
            feedGroupType = FeedGroupType.FEED_TYPE_ALL;
        }
        this.lastFeedGroupType = feedGroupType;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558658, 2131231066).create());
        RecyclerView recyclerView = getRecyclerView();
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView.setPadding(0, 0, 0, recyclerView2.getPaddingBottom());
        if (getUserVisibleHint()) {
            initData();
        }
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558658).suitedEntityType(ENTITY_TYPE_ACTION_TOP).constructor(new CircleFeedV8Fragment$onActivityCreated$1(this)).build(), 0, 2, null);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.feed.FeedEventProcessor.EventInterceptor
    public boolean shouldInterceptFeedEvent(Object obj) {
        int findUserActionTopPosition;
        Intrinsics.checkNotNullParameter(obj, "event");
        if (!(obj instanceof FeedPostEvent)) {
            return super.shouldInterceptFeedEvent(obj);
        }
        Feed feed = ((FeedPostEvent) obj).getFeed();
        if (feed != null && Intrinsics.areEqual(feed.getFeedType(), "feed")) {
            LoginSession loginSession2 = this.loginSession;
            Intrinsics.checkNotNullExpressionValue(loginSession2, "loginSession");
            if (loginSession2.isLogin() && EntityListFragment.findFirstEntityIndex$default(this, "REFRESH_PROGRESS_BAR", null, false, false, 6, null) < 0 && (findUserActionTopPosition = findUserActionTopPosition()) >= 0) {
                getDataList().add(findUserActionTopPosition + 1, feed);
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void setFeedGroupType(FeedGroupType feedGroupType) {
        if (this.lastFeedGroupType != feedGroupType) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().putString(PREF_KEY_LAST_GROUP_FEED_TYPE, feedGroupType.getType()).apply();
            List<Parcelable> dataList = getDataList();
            this.lastFeedGroupType = feedGroupType;
            int findUserActionTopPosition = findUserActionTopPosition();
            if (findUserActionTopPosition >= 0) {
                while (dataList.size() - 1 > findUserActionTopPosition) {
                    dataList.remove(dataList.size() - 1);
                }
            }
            setPage(1);
            reloadData();
            addRefreshView();
        }
    }

    /* access modifiers changed from: private */
    public final void showPopMenu(View view) {
        BasePopMenu basePopMenu = new BasePopMenu(getActivity(), view);
        Menu menu = basePopMenu.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "popupMenu.menu");
        FeedGroupType[] values = FeedGroupType.values();
        for (FeedGroupType feedGroupType : values) {
            menu.add(0, feedGroupType.validId(), feedGroupType.validId(), feedGroupType.getTextId());
            if (feedGroupType == this.lastFeedGroupType) {
                MenuItem findItem = menu.findItem(feedGroupType.validId());
                Intrinsics.checkNotNullExpressionValue(findItem, "item");
                findItem.setTitle(findItem.getTitle().toString() + "(当前)");
            }
        }
        basePopMenu.setOnMenuItemClickListener(new CircleFeedV8Fragment$showPopMenu$1(this));
        basePopMenu.show();
    }

    public final FilterLayout createFilterLayout() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FilterLayout filterLayout = new FilterLayout(requireActivity);
        FeedGroupType[] values = FeedGroupType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (FeedGroupType feedGroupType : values) {
            String string = getString(feedGroupType.getTextId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(it.textId)");
            arrayList.add(string);
        }
        filterLayout.setFilterArgs(arrayList, this.lastFeedGroupType.ordinal(), new CircleFeedV8Fragment$createFilterLayout$2(this));
        StatisticHelper.Companion.getInstance().recordEvent("V9圈子头部", "切换");
        return filterLayout;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String id;
        String str = null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        if (findLastEntity$default != null) {
            str = findLastEntity$default.getId();
        }
        String str2 = "";
        if (!z) {
            Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
            if (!(findFirstEntity$default == null || (id = findFirstEntity$default.getId()) == null)) {
                str2 = id;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "findFirstEntity()?.id ?: \"\"");
        }
        Observable<R> compose = DataManager.getInstance().getFeedListByType(this.lastFeedGroupType.getType(), i, str2, str).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onEmptyViewClick() {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession2 = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
        if (!loginSession2.isLogin()) {
            ActionManager.startLoginActivity(getActivity());
        } else {
            super.onEmptyViewClick();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean onRequestResponse = super.onRequestResponse(z, list);
        if (findUserActionTopPosition() < 0) {
            LoginSession loginSession2 = this.loginSession;
            Intrinsics.checkNotNullExpressionValue(loginSession2, "loginSession");
            if (loginSession2.isLogin()) {
                List<Parcelable> dataList = getDataList();
                HolderItem build = HolderItem.newBuilder().entityType(ENTITY_TYPE_ACTION_TOP).entityFixed(1).build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…P).entityFixed(1).build()");
                dataList.add(0, build);
            }
        }
        return onRequestResponse;
    }

    private final int findUserActionTopPosition() {
        return EntityListFragment.findFirstEntityIndex$default(this, ENTITY_TYPE_ACTION_TOP, null, false, false, 2, null);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenRefresh(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        if (!(obj instanceof HolderItem) || !Intrinsics.areEqual(((HolderItem) obj).getEntityType(), ENTITY_TYPE_ACTION_TOP)) {
            return super.filterDataWhenRefresh(obj, i, map);
        }
        LoginSession loginSession2 = this.loginSession;
        Intrinsics.checkNotNullExpressionValue(loginSession2, "loginSession");
        return loginSession2.isLogin() ? -1 : 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 3925 && i2 == -1 && intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                Toast.show$default(getActivity(), getString(2131886996), 0, false, 12, null);
                return;
            }
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FeedMultiPart multiPartForCoolPic = FeedArgsFactory.multiPartForCoolPic(requireActivity);
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            FeedUIConfig uiConfigForCoolPic = FeedArgsFactory.uiConfigForCoolPic(requireActivity2);
            Iterator<String> it2 = stringArrayListExtra.iterator();
            while (it2.hasNext()) {
                multiPartForCoolPic.imageUriList().add(ImageUrl.create(CoolFileUtils.wrap(it2.next()), null));
            }
            ActionManager.startSubmitFeedV8Activity(getActivity(), uiConfigForCoolPic, multiPartForCoolPic);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/main/CircleFeedV8Fragment$CircleTopViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCircleFeedTopBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "(Landroid/view/View;Lcom/coolapk/market/binding/FragmentBindingComponent;)V", "bindToContent", "", "holderItem", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CircleFeedV8Fragment.kt */
    private static final class CircleTopViewHolder extends GenericBindHolder<ItemCircleFeedTopBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558658;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CircleTopViewHolder(View view, FragmentBindingComponent fragmentBindingComponent) {
            super(view, fragmentBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(fragmentBindingComponent, "component");
            ItemCircleFeedTopBinding itemCircleFeedTopBinding = (ItemCircleFeedTopBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCircleFeedTopBinding, "binding");
            itemCircleFeedTopBinding.setClick(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/CircleFeedV8Fragment$CircleTopViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: CircleFeedV8Fragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable != null) {
                LifecycleOwner lifecycleOwner = null;
                switch (view.getId()) {
                    case 2131362197:
                        DataBindingComponent component = getComponent();
                        if (!(component instanceof FragmentBindingComponent)) {
                            component = null;
                        }
                        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                        if (!(fragment instanceof CircleFeedV8Fragment)) {
                            fragment = null;
                        }
                        CircleFeedV8Fragment circleFeedV8Fragment = (CircleFeedV8Fragment) fragment;
                        if (circleFeedV8Fragment != null) {
                            ActionManager.startPhotoPickerActivity(circleFeedV8Fragment, 9, (List<String>) null);
                            StatisticHelper.Companion.getInstance().recordEvent("V9圈子头部", "酷图");
                            return;
                        }
                        return;
                    case 2131362454:
                    case 2131363604:
                        ActionManager.startNewFeedV8Activity(activityNullable);
                        StatisticHelper.Companion.getInstance().recordEvent("V9圈子头部", "动态");
                        return;
                    case 2131362563:
                        DataBindingComponent component2 = getComponent();
                        if (!(component2 instanceof FragmentBindingComponent)) {
                            component2 = null;
                        }
                        FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                        if (lifecycleOwner2 instanceof CircleFeedV8Fragment) {
                            lifecycleOwner = lifecycleOwner2;
                        }
                        CircleFeedV8Fragment circleFeedV8Fragment2 = (CircleFeedV8Fragment) lifecycleOwner;
                        if (circleFeedV8Fragment2 != null) {
                            circleFeedV8Fragment2.showPopMenu(view);
                        }
                        StatisticHelper.Companion.getInstance().recordEvent("V9圈子头部", "切换");
                        return;
                    case 2131362900:
                        StatisticHelper.Companion.getInstance().recordEvent("V9圈子头部", "个人主页");
                        Context context2 = getContext();
                        DataManager instance = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                        LoginSession loginSession = instance.getLoginSession();
                        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                        ActionManager.startUserSpaceActivity(context2, loginSession.getUid());
                        return;
                    default:
                        return;
                }
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            DataBindingComponent component = getComponent();
            if (!(component instanceof FragmentBindingComponent)) {
                component = null;
            }
            FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
            Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
            if (!(fragment instanceof CircleFeedV8Fragment)) {
                fragment = null;
            }
            CircleFeedV8Fragment circleFeedV8Fragment = (CircleFeedV8Fragment) fragment;
            if (circleFeedV8Fragment != null) {
                ((ItemCircleFeedTopBinding) getBinding()).executePendingBindings();
                ImageLoaderOptions build = ImageLoaderOptions.newBuilder().placeHolderRes(2131231162).build();
                GlideFragmentImageLoader fragmentImageLoader = AppHolder.getFragmentImageLoader();
                CircleFeedV8Fragment circleFeedV8Fragment2 = circleFeedV8Fragment;
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                fragmentImageLoader.displayImage((Fragment) circleFeedV8Fragment2, loginSession.getUserAvatar(), (ImageView) ((ItemCircleFeedTopBinding) getBinding()).userAvatarView, build, (OnImageLoadListener) null, (OnBitmapTransformListener) new CircleTransform(false, 0, 3, null));
            }
        }
    }
}
