package com.coolapk.market.view.message;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemChatingMineBinding;
import com.coolapk.market.databinding.ItemChatingMineCardBinding;
import com.coolapk.market.databinding.ItemChatingUserBinding;
import com.coolapk.market.databinding.ItemChatingUserCardBinding;
import com.coolapk.market.databinding.ItemMessageExtraBinding;
import com.coolapk.market.databinding.MessageTopTipBinding;
import com.coolapk.market.event.MessageEvent;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.view.ShapedImageView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/* compiled from: ChatListFragment.kt */
public final class ChatListFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_DATA = "DATA";
    public static final String TYPE_TIPS = "messageExtra";
    private MultiTypeAdapter adapter;
    private final FragmentBindingComponent bindingComponent = new FragmentBindingComponent(this);
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private AppNotification.PMIntercept mPMIntercept;
    private final Lazy myId$delegate = LazyKt.lazy(new ChatListFragment$myId$2(this));
    private boolean passiveRefresh;
    private boolean showTipView;
    private final Lazy uKey$delegate = LazyKt.lazy(new ChatListFragment$uKey$2(this));
    private Subscription updateSubscription;
    private final Lazy userId$delegate = LazyKt.lazy(new ChatListFragment$userId$2(this));

    public static final ChatListFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    public final String getMyId() {
        return (String) this.myId$delegate.getValue();
    }

    public final String getUKey() {
        return (String) this.uKey$delegate.getValue();
    }

    public final String getUserId() {
        return (String) this.userId$delegate.getValue();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return false;
    }

    public final FragmentBindingComponent getBindingComponent() {
        return this.bindingComponent;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_DATA);
            if (parcelableArrayList != null) {
                this.dataList.addAll(parcelableArrayList);
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setAutoUpdateContentUiOnDataChanged(true);
        setLayoutManager(new LinearLayoutManager(getActivity(), 1, true));
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        getRecyclerView().setPadding(0, DisplayUtils.dp2px(getActivity(), 14.0f), 0, DisplayUtils.dp2px(getActivity(), 14.0f));
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.adapter = multiTypeAdapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter);
        if (getUserVisibleHint()) {
            initData();
        }
        this.updateSubscription = Observable.interval(10, 10, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new ChatListFragment$onActivityCreated$1(this));
        AppNotification appNotification = AppHolder.getAppNotification();
        AppNotification.PMIntercept pMIntercept = new AppNotification.PMIntercept(new ChatListFragment$onActivityCreated$2(this));
        this.mPMIntercept = pMIntercept;
        appNotification.addIntercept(pMIntercept);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558648).constructor(new ChatListFragment$onActivityCreated$3(this)).suitedMethod(ChatListFragment$onActivityCreated$4.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter3 = this.adapter;
        if (multiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter3.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558649).constructor(new ChatListFragment$onActivityCreated$5(this)).suitedMethod(ChatListFragment$onActivityCreated$6.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter4 = this.adapter;
        if (multiTypeAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter4.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558651).constructor(new ChatListFragment$onActivityCreated$7(this)).suitedMethod(ChatListFragment$onActivityCreated$8.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter5 = this.adapter;
        if (multiTypeAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter5.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558650).constructor(new ChatListFragment$onActivityCreated$9(this)).suitedMethod(ChatListFragment$onActivityCreated$10.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter6 = this.adapter;
        if (multiTypeAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter6.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558826).constructor(new ChatListFragment$onActivityCreated$11(this)).suitedMethod(ChatListFragment$onActivityCreated$12.INSTANCE).build(), -1);
        ObservableArrayList<Entity> observableArrayList = this.dataList;
        MultiTypeAdapter multiTypeAdapter7 = this.adapter;
        if (multiTypeAdapter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        observableArrayList.addOnListChangedCallback(new AdapterListChangedCallback(multiTypeAdapter7));
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.updateSubscription;
        if (subscription != null) {
            Intrinsics.checkNotNull(subscription);
            if (!subscription.isUnsubscribed()) {
                Subscription subscription2 = this.updateSubscription;
                Intrinsics.checkNotNull(subscription2);
                subscription2.unsubscribe();
            }
        }
        if (this.mPMIntercept != null) {
            AppHolder.getAppNotification().removeIntercept(this.mPMIntercept);
        }
        EventBus.getDefault().unregister(this);
    }

    public final boolean onNewMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (TextUtils.equals(message.getFromUid(), getUserId())) {
            loadLongMessageAndAdd(message);
            return isResumed();
        } else if (!TextUtils.equals(message.getFromUid(), getMyId()) || !TextUtils.equals(message.getUid(), getUserId())) {
            return false;
        } else {
            if (this.dataList.size() > 0) {
                loadLongMessageAndAdd(message);
            } else {
                insertMessage(message);
            }
            return isResumed();
        }
    }

    public final void insertMessageList(List<? extends Entity> list) {
        List<? extends Entity> list2 = list;
        if (!CollectionUtils.isEmpty(list2)) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                getRecyclerView().post(new ChatListFragment$insertMessageList$1(this, list));
            } else if (!hasSameMessageIdWith(list)) {
                Intrinsics.checkNotNull(list);
                Message findMessage = findMessage(list);
                if (!CollectionUtils.isEmpty(this.dataList) && findMessage != null) {
                    Long dateline = findMessage.getDateline();
                    Object obj = this.dataList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "dataList[0]");
                    if (DateUtils.isShowTimeInMessage(dateline, ((Entity) obj).getDateline())) {
                        this.dataList.add(0, HolderItem.newBuilder().dateline(findMessage.getDateline()).entityType("messageExtra").entityTemplate("time").title(DateUtils.getHourTimeDescription(findMessage.getDateline())).build());
                    }
                }
                Collections.reverse(list);
                this.dataList.addAll(0, list2);
                if (isVisible()) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            }
        }
    }

    private final Message findMessage(List<? extends Entity> list) {
        for (T t : list) {
            if (t instanceof Message) {
                return t;
            }
        }
        return null;
    }

    public final void insertMessage(Entity entity) {
        if (entity != null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                getRecyclerView().post(new ChatListFragment$insertMessage$1(this, entity));
            } else if (!hasSameMessageIdWith(entity)) {
                if (!CollectionUtils.isEmpty(this.dataList)) {
                    Long dateline = entity.getDateline();
                    Object obj = this.dataList.get(0);
                    Intrinsics.checkNotNullExpressionValue(obj, "dataList[0]");
                    if (DateUtils.isShowTimeInMessage(dateline, ((Entity) obj).getDateline())) {
                        this.dataList.add(0, HolderItem.newBuilder().dateline(entity.getDateline()).entityType("messageExtra").entityTemplate("time").title(DateUtils.getHourTimeDescription(entity.getDateline())).build());
                    }
                }
                this.dataList.add(0, entity);
                if (isVisible()) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            }
        }
    }

    public final void onMessageEvent(MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(messageEvent, "event");
        Message build = Message.builder(messageEvent.getMessage()).setEntityTemplate("").build();
        int i = 0;
        for (Entity entity : this.dataList) {
            if (entity instanceof Message) {
                Intrinsics.checkNotNullExpressionValue(build, "message");
                if (TextUtils.equals(((Message) entity).getId(), build.getId())) {
                    if (messageEvent.isDeleteMessage()) {
                        if (deleteTime(i)) {
                            this.dataList.remove(i + 1);
                        }
                        this.dataList.remove(i);
                    } else {
                        messageEvent.isUpdataMessage();
                    }
                }
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0077  */
    private final boolean deleteTime(int i) {
        boolean z;
        boolean z2;
        if (CollectionUtils.safeSize(this.dataList) != 1 && CollectionUtils.safeSize(this.dataList) > i && i >= 0) {
            int i2 = i + 1;
            Object obj = this.dataList.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[index + 1]");
            if (Intrinsics.areEqual(((Entity) obj).getEntityTemplate(), "time")) {
                Object obj2 = this.dataList.get(i);
                Intrinsics.checkNotNullExpressionValue(obj2, "dataList[index]");
                Long dateline = ((Entity) obj2).getDateline();
                Object obj3 = this.dataList.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj3, "dataList[index + 1]");
                if (Intrinsics.areEqual(dateline, ((Entity) obj3).getDateline())) {
                    z = true;
                    if (i <= 0) {
                        Object obj4 = this.dataList.get(i - 1);
                        Intrinsics.checkNotNullExpressionValue(obj4, "dataList[index - 1]");
                        z2 = !Intrinsics.areEqual(((Entity) obj4).getEntityTemplate(), "time");
                    } else {
                        z2 = false;
                    }
                    if (!z && !z2) {
                        return true;
                    }
                }
            }
            z = false;
            if (i <= 0) {
            }
            if (!z) {
            }
        }
        return false;
    }

    private final boolean hasSameMessageIdWith(List<? extends Entity> list) {
        Intrinsics.checkNotNull(list);
        if (findFirstMessageIndex(list) < 0) {
            return false;
        }
        int size = this.dataList.size();
        for (int i = 0; i < size; i++) {
            String id = ((Entity) list.get(findFirstMessageIndex(list))).getId();
            Object obj = this.dataList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "dataList[index]");
            if (Intrinsics.areEqual(id, ((Entity) obj).getId())) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasSameMessageIdWith(Entity entity) {
        Iterator<E> it2 = this.dataList.iterator();
        while (it2.hasNext()) {
            E next = it2.next();
            Intrinsics.checkNotNull(entity);
            String id = entity.getId();
            Intrinsics.checkNotNullExpressionValue(next, "item");
            if (Intrinsics.areEqual(id, next.getId())) {
                return true;
            }
        }
        return false;
    }

    private final void sort() {
        CollectionsKt.sortWith(this.dataList, ChatListFragment$sort$1.INSTANCE);
    }

    private final void loadLongMessageAndAdd(Message message) {
        DataManager.getInstance().receiveLongMessage(message.getId()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new ChatListFragment$loadLongMessageAndAdd$1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppHolder.getAppPushManager().clearNotification(347);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onLoadMore() {
        reloadData(false);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        loadMore();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        reloadData(false);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public void onLoadDataFailed(boolean z, boolean z2, int i, Throwable th) {
        super.onLoadDataFailed(z, z2, i, th);
        if (!z) {
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        T t;
        boolean z2;
        boolean z3 = false;
        if (!z) {
            SwipeRefreshLayout swipeRefreshLayout = getSwipeRefreshLayout();
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "swipeRefreshLayout");
            swipeRefreshLayout.setRefreshing(false);
        }
        Intrinsics.checkNotNull(list);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            T t2 = t;
            if (!Intrinsics.areEqual(t2.getEntityType(), "messageExtra") || !Intrinsics.areEqual(t2.getEntityTemplate(), "float")) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        T t3 = t;
        if (t3 != null) {
            onShowTip(t3);
            removeData(list, t3);
        }
        List<? extends Entity> list2 = list;
        if (!CollectionUtils.isEmpty(list2)) {
            Collections.reverse(list);
            EntityUtils.removeReduplicatedEntity(list, this.dataList, null);
            if (z) {
                this.dataList.addAll(0, list2);
                getRecyclerView().smoothScrollToPosition(0);
            } else {
                this.dataList.addAll(list2);
            }
            sort();
            DataManager.getInstance().markConversationRead(getUKey()).map(RxUtils.checkResult()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new ChatListFragment$onRequestResponse$1());
            z3 = true;
        }
        updateContentUI();
        return z3;
    }

    private final void onShowTip(Entity entity) {
        View view = getView();
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNullExpressionValue(view, "view!!");
        ViewParent parent = view.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        MessageTopTipBinding messageTopTipBinding = (MessageTopTipBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559020, frameLayout, true);
        Intrinsics.checkNotNullExpressionValue(messageTopTipBinding, "binding");
        messageTopTipBinding.getRoot().setOnClickListener(new ChatListFragment$onShowTip$1(this, frameLayout, messageTopTipBinding));
        if (!this.showTipView) {
            frameLayout.removeView(messageTopTipBinding.getRoot());
            TextView textView = messageTopTipBinding.tipTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tipTitle");
            String title = entity.getTitle();
            Intrinsics.checkNotNull(title);
            textView.setText(title);
            RelativeLayout relativeLayout = messageTopTipBinding.tipView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.tipView");
            relativeLayout.setVisibility(0);
            ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor());
            colorDrawable.setAlpha(240);
            View root = messageTopTipBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setBackground(colorDrawable);
            frameLayout.addView(messageTopTipBinding.getRoot(), new FrameLayout.LayoutParams(-1, -2));
            this.showTipView = true;
        }
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new ChatListFragment$onShowTip$2(messageTopTipBinding));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
    /* JADX WARN: Multi-variable type inference failed */
    private final List<Entity> removeData(List<? extends Entity> list, Entity entity) {
        if (list instanceof ArrayList) {
            ((ArrayList) list).remove(entity);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Entity) obj) != entity) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> map = DataManager.getInstance().getChatList(getUKey(), i, findFirstItem(), findLastItem()).map(RxUtils.checkResultToData());
        Intrinsics.checkNotNullExpressionValue(map, "DataManager.getInstance(…tils.checkResultToData())");
        return map;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public final String findFirstItem() {
        int size = this.dataList.size();
        for (int i = 0; i < size; i++) {
            Entity entity = (Entity) this.dataList.get(i);
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            if (Intrinsics.areEqual(entity.getEntityType(), "message")) {
                return entity.getEntityId();
            }
        }
        return null;
    }

    public final String findLastItem() {
        for (int size = this.dataList.size() - 1; size >= 0; size--) {
            Entity entity = (Entity) this.dataList.get(size);
            Intrinsics.checkNotNullExpressionValue(entity, "entity");
            if (Intrinsics.areEqual(entity.getEntityType(), "message")) {
                return entity.getEntityId();
            }
        }
        return null;
    }

    private final int findFirstMessageIndex(List<? extends Entity> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(((Entity) list.get(i)).getEntityType(), "message")) {
                return i;
            }
        }
        return -1;
    }

    public final ObservableArrayList<Entity> getDataList() {
        return this.dataList;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList(KEY_DATA, this.dataList);
    }

    /* compiled from: ChatListFragment.kt */
    private static final class ChatMineViewHolder extends GenericBindHolder<ItemChatingMineBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558648;
        private final Activity activity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatMineViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.activity = UiUtils.getActivityNullable(context);
        }

        public void bindToContent(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            ItemChatingMineBinding itemChatingMineBinding = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding, "binding");
            itemChatingMineBinding.setModel(message);
            ItemChatingMineBinding itemChatingMineBinding2 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding2, "binding");
            itemChatingMineBinding2.setClick(this);
            ItemChatingMineBinding itemChatingMineBinding3 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding3, "binding");
            itemChatingMineBinding3.setShowPic(Boolean.valueOf(!message.isShowError() && !TextUtils.isEmpty(message.getMessagePic())));
            ItemChatingMineBinding itemChatingMineBinding4 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding4, "binding");
            String str = null;
            itemChatingMineBinding4.setTransformer(new CircleTransform(false, 0, 3, null));
            TextView textView = ((ItemChatingMineBinding) getBinding()).errorPicView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorPicView");
            textView.setBackground(ShapeUtils.createMessageErrorBg(getContext(), false));
            ItemChatingMineBinding itemChatingMineBinding5 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding5, "binding");
            itemChatingMineBinding5.setShowError(Boolean.valueOf(message.isShowError()));
            MessageContentBindHelp messageContentBindHelp = MessageContentBindHelp.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ShapedImageView shapedImageView = ((ItemChatingMineBinding) getBinding()).picView;
            Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.picView");
            String messageImageUrl = DataManager.getInstance().getMessageImageUrl(message.getId(), messageContentBindHelp.messagePicSizeBind(context, shapedImageView, message.getMessagePic()));
            ItemChatingMineBinding itemChatingMineBinding6 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding6, "binding");
            if (!TextUtils.isEmpty(message.getMessagePic())) {
                str = messageImageUrl;
            }
            itemChatingMineBinding6.setPic(str);
            ((ItemChatingMineBinding) getBinding()).executePendingBindings();
            MessageContentBindHelp messageContentBindHelp2 = MessageContentBindHelp.INSTANCE;
            TextView textView2 = ((ItemChatingMineBinding) getBinding()).textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            messageContentBindHelp2.messageTextBind(textView2, false);
            ItemChatingMineBinding itemChatingMineBinding7 = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding7, "binding");
            itemChatingMineBinding7.getRoot().setOnLongClickListener(new ChatListFragment$ChatMineViewHolder$bindToContent$1(this, message));
            ((ItemChatingMineBinding) getBinding()).picView.setOnLongClickListener(new ChatListFragment$ChatMineViewHolder$bindToContent$2(this, message));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            MessageContentBindHelp messageContentBindHelp = MessageContentBindHelp.INSTANCE;
            ItemChatingMineBinding itemChatingMineBinding = (ItemChatingMineBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineBinding, "binding");
            Message model = itemChatingMineBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            Activity activity2 = this.activity;
            Intrinsics.checkNotNull(activity2);
            ShapedImageView shapedImageView = ((ItemChatingMineBinding) getBinding()).picView;
            Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.picView");
            messageContentBindHelp.messageClickAction(view, model, activity2, shapedImageView);
        }

        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: ChatListFragment.kt */
    private static final class ChatUserViewHolder extends GenericBindHolder<ItemChatingUserBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558650;
        private final Activity activity;
        private String imageShowType = "m";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatUserViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.activity = UiUtils.getActivityNullable(context);
        }

        public void bindToContent(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            ItemChatingUserBinding itemChatingUserBinding = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding, "binding");
            itemChatingUserBinding.setClick(this);
            ItemChatingUserBinding itemChatingUserBinding2 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding2, "binding");
            boolean z = false;
            String str = null;
            itemChatingUserBinding2.setTransformer(new CircleTransform(false, 0, 3, null));
            Drawable mutate = ResourceUtils.getDrawable(UiUtils.getActivity(getContext()), 2131230898).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "ResourceUtils.getDrawabl…_corner_rect_bg).mutate()");
            mutate.setColorFilter(AppHolder.getAppTheme().getContentBackgroundColor(), PorterDuff.Mode.SRC_IN);
            LinearLayout linearLayout = ((ItemChatingUserBinding) getBinding()).messageView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.messageView");
            linearLayout.setBackground(mutate);
            ItemChatingUserBinding itemChatingUserBinding3 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding3, "binding");
            itemChatingUserBinding3.setModel(message);
            TextView textView = ((ItemChatingUserBinding) getBinding()).errorPicView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.errorPicView");
            textView.setBackground(ShapeUtils.createMessageErrorBg(getContext()));
            ItemChatingUserBinding itemChatingUserBinding4 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding4, "binding");
            if (!message.isShowError() && !TextUtils.isEmpty(message.getMessagePic())) {
                z = true;
            }
            itemChatingUserBinding4.setShowPic(Boolean.valueOf(z));
            ItemChatingUserBinding itemChatingUserBinding5 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding5, "binding");
            itemChatingUserBinding5.setShowError(Boolean.valueOf(message.isShowError()));
            MessageContentBindHelp messageContentBindHelp = MessageContentBindHelp.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ShapedImageView shapedImageView = ((ItemChatingUserBinding) getBinding()).picView;
            Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.picView");
            String messagePicSizeBind = messageContentBindHelp.messagePicSizeBind(context, shapedImageView, message.getMessagePic());
            ItemChatingUserBinding itemChatingUserBinding6 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding6, "binding");
            if (!TextUtils.isEmpty(message.getMessagePic())) {
                str = DataManager.getInstance().getMessageImageUrl(message.getId(), messagePicSizeBind);
            }
            itemChatingUserBinding6.setPic(str);
            ((ItemChatingUserBinding) getBinding()).executePendingBindings();
            MessageContentBindHelp messageContentBindHelp2 = MessageContentBindHelp.INSTANCE;
            TextView textView2 = ((ItemChatingUserBinding) getBinding()).textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            messageContentBindHelp2.messageTextBind(textView2, true);
            ItemChatingUserBinding itemChatingUserBinding7 = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding7, "binding");
            itemChatingUserBinding7.getRoot().setOnLongClickListener(new ChatListFragment$ChatUserViewHolder$bindToContent$1(this, message));
            ((ItemChatingUserBinding) getBinding()).picView.setOnLongClickListener(new ChatListFragment$ChatUserViewHolder$bindToContent$2(this, message));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            MessageContentBindHelp messageContentBindHelp = MessageContentBindHelp.INSTANCE;
            ItemChatingUserBinding itemChatingUserBinding = (ItemChatingUserBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserBinding, "binding");
            Message model = itemChatingUserBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            Activity activity2 = this.activity;
            Intrinsics.checkNotNull(activity2);
            ShapedImageView shapedImageView = ((ItemChatingUserBinding) getBinding()).picView;
            Intrinsics.checkNotNullExpressionValue(shapedImageView, "binding.picView");
            messageContentBindHelp.messageClickAction(view, model, activity2, shapedImageView);
        }

        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: ChatListFragment.kt */
    private static final class ChatUserCardViewHolder extends GenericBindHolder<ItemChatingUserCardBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558651;
        private String url = "";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatUserCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        public void bindToContent(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            ItemChatingUserCardBinding itemChatingUserCardBinding = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding, "binding");
            itemChatingUserCardBinding.setClick(this);
            JSONObject jSONObject = new JSONObject(message.getMessageCard());
            String optString = jSONObject.optString("pic");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("extra_text");
            String optString4 = jSONObject.optString("extra_pic");
            String optString5 = jSONObject.optString("sub_title");
            String optString6 = jSONObject.optString("type");
            String optString7 = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"url\")");
            this.url = optString7;
            if (Intrinsics.areEqual(optString6, "user")) {
                TextView textView = ((ItemChatingUserCardBinding) getBinding()).titleMessage;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleMessage");
                textView.setTypeface(Typeface.defaultFromStyle(0));
            } else {
                if (Intrinsics.areEqual(optString6, "album")) {
                    RoundedImageView roundedImageView = ((ItemChatingUserCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView, "binding.contentPicView");
                    roundedImageView.setBorderWidth(NumberExtendsKt.getDpf((Number) 1));
                    RoundedImageView roundedImageView2 = ((ItemChatingUserCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView2, "binding.contentPicView");
                    roundedImageView2.setBorderColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
                } else {
                    RoundedImageView roundedImageView3 = ((ItemChatingUserCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView3, "binding.contentPicView");
                    roundedImageView3.setBorderWidth(NumberExtendsKt.getDpf((Number) 0));
                }
                TextView textView2 = ((ItemChatingUserCardBinding) getBinding()).titleMessage;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleMessage");
                textView2.setTypeface(Typeface.defaultFromStyle(1));
            }
            ItemChatingUserCardBinding itemChatingUserCardBinding2 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding2, "binding");
            itemChatingUserCardBinding2.setModel(message);
            ItemChatingUserCardBinding itemChatingUserCardBinding3 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding3, "binding");
            if (optString == null) {
                optString = optString4;
            }
            itemChatingUserCardBinding3.setContentPic(optString);
            ItemChatingUserCardBinding itemChatingUserCardBinding4 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding4, "binding");
            itemChatingUserCardBinding4.setTitle(optString2);
            ItemChatingUserCardBinding itemChatingUserCardBinding5 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding5, "binding");
            itemChatingUserCardBinding5.setAvatar(optString4);
            ItemChatingUserCardBinding itemChatingUserCardBinding6 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding6, "binding");
            itemChatingUserCardBinding6.setContent(optString5);
            ItemChatingUserCardBinding itemChatingUserCardBinding7 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding7, "binding");
            itemChatingUserCardBinding7.setSubtitle(optString3);
            ItemChatingUserCardBinding itemChatingUserCardBinding8 = (ItemChatingUserCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding8, "binding");
            itemChatingUserCardBinding8.setTransformer(new CircleTransform(false, 0, 3, null));
            ((ItemChatingUserCardBinding) getBinding()).executePendingBindings();
            ((ItemChatingUserCardBinding) getBinding()).contentLayout.setOnLongClickListener(new ChatListFragment$ChatUserCardViewHolder$bindToContent$1(this, message));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            int id = view.getId();
            if (id == 2131362312) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, this.url, null, null, 12, null);
            } else if (id == 2131363877) {
                ItemChatingUserCardBinding itemChatingUserCardBinding = (ItemChatingUserCardBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding, "binding");
                Message model = itemChatingUserCardBinding.getModel();
                String str = null;
                String fromUid = model != null ? model.getFromUid() : null;
                ItemChatingUserCardBinding itemChatingUserCardBinding2 = (ItemChatingUserCardBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemChatingUserCardBinding2, "binding");
                Message model2 = itemChatingUserCardBinding2.getModel();
                if (model2 != null) {
                    str = model2.getFromUserAvatar();
                }
                ActionManager.startUserSpaceActivity(view, fromUid, str);
            }
        }

        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: ChatListFragment.kt */
    private static final class ChatMineCardViewHolder extends GenericBindHolder<ItemChatingMineCardBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558649;
        private String url = "";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatMineCardViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        public void bindToContent(Message message) {
            Intrinsics.checkNotNullParameter(message, "message");
            ItemChatingMineCardBinding itemChatingMineCardBinding = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding, "binding");
            itemChatingMineCardBinding.setClick(this);
            JSONObject jSONObject = new JSONObject(message.getMessageCard());
            String optString = jSONObject.optString("pic");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("extra_text");
            String optString4 = jSONObject.optString("extra_pic");
            String optString5 = jSONObject.optString("sub_title");
            String optString6 = jSONObject.optString("type");
            if (Intrinsics.areEqual(optString6, "user")) {
                TextView textView = ((ItemChatingMineCardBinding) getBinding()).titleMessage;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleMessage");
                textView.setTypeface(Typeface.defaultFromStyle(0));
            } else {
                if (Intrinsics.areEqual(optString6, "album")) {
                    RoundedImageView roundedImageView = ((ItemChatingMineCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView, "binding.contentPicView");
                    roundedImageView.setBorderWidth(NumberExtendsKt.getDpf((Number) 1));
                    RoundedImageView roundedImageView2 = ((ItemChatingMineCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView2, "binding.contentPicView");
                    roundedImageView2.setBorderColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
                } else {
                    RoundedImageView roundedImageView3 = ((ItemChatingMineCardBinding) getBinding()).contentPicView;
                    Intrinsics.checkNotNullExpressionValue(roundedImageView3, "binding.contentPicView");
                    roundedImageView3.setBorderWidth(NumberExtendsKt.getDpf((Number) 0));
                }
                TextView textView2 = ((ItemChatingMineCardBinding) getBinding()).titleMessage;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleMessage");
                textView2.setTypeface(Typeface.defaultFromStyle(1));
            }
            String optString7 = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"url\")");
            this.url = optString7;
            ItemChatingMineCardBinding itemChatingMineCardBinding2 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding2, "binding");
            itemChatingMineCardBinding2.setModel(message);
            ItemChatingMineCardBinding itemChatingMineCardBinding3 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding3, "binding");
            if (optString == null) {
                optString = optString4;
            }
            itemChatingMineCardBinding3.setContentPic(optString);
            ItemChatingMineCardBinding itemChatingMineCardBinding4 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding4, "binding");
            itemChatingMineCardBinding4.setTitle(optString2);
            ItemChatingMineCardBinding itemChatingMineCardBinding5 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding5, "binding");
            itemChatingMineCardBinding5.setAvatar(optString4);
            ItemChatingMineCardBinding itemChatingMineCardBinding6 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding6, "binding");
            itemChatingMineCardBinding6.setContent(optString5);
            ItemChatingMineCardBinding itemChatingMineCardBinding7 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding7, "binding");
            itemChatingMineCardBinding7.setSubtitle(optString3);
            ItemChatingMineCardBinding itemChatingMineCardBinding8 = (ItemChatingMineCardBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding8, "binding");
            itemChatingMineCardBinding8.setTransformer(new CircleTransform(false, 0, 3, null));
            ((ItemChatingMineCardBinding) getBinding()).executePendingBindings();
            ((ItemChatingMineCardBinding) getBinding()).contentLayout.setOnLongClickListener(new ChatListFragment$ChatMineCardViewHolder$bindToContent$1(this, message));
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            int id = view.getId();
            if (id == 2131362312) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, this.url, null, null, 12, null);
            } else if (id == 2131363877) {
                ItemChatingMineCardBinding itemChatingMineCardBinding = (ItemChatingMineCardBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding, "binding");
                Message model = itemChatingMineCardBinding.getModel();
                String str = null;
                String fromUid = model != null ? model.getFromUid() : null;
                ItemChatingMineCardBinding itemChatingMineCardBinding2 = (ItemChatingMineCardBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemChatingMineCardBinding2, "binding");
                Message model2 = itemChatingMineCardBinding2.getModel();
                if (model2 != null) {
                    str = model2.getFromUserAvatar();
                }
                ActionManager.startUserSpaceActivity(view, fromUid, str);
            }
        }

        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: ChatListFragment.kt */
    private static final class ChatTipViewHolder extends GenericBindHolder<ItemMessageExtraBinding, Entity> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558826;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatTipViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
            super(view, dataBindingComponent, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        }

        @Override // com.coolapk.market.viewholder.GenericBindHolder
        public void bindToContent(Entity entity) {
            Intrinsics.checkNotNullParameter(entity, "message");
            ItemMessageExtraBinding itemMessageExtraBinding = (ItemMessageExtraBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemMessageExtraBinding, "binding");
            itemMessageExtraBinding.setEntity(entity);
            ((ItemMessageExtraBinding) getBinding()).cardView.setOnClickListener(new ChatListFragment$ChatTipViewHolder$bindToContent$1(this));
            Space space = ((ItemMessageExtraBinding) getBinding()).marginView;
            Intrinsics.checkNotNullExpressionValue(space, "binding.marginView");
            ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
            if (Intrinsics.areEqual(entity.getEntityTemplate(), "time")) {
                ((ItemMessageExtraBinding) getBinding()).titleView.setTextColor(Color.parseColor("#BDBDBD"));
                TextView textView = ((ItemMessageExtraBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                textView.setBackground(null);
                layoutParams.height = DisplayUtils.dp2px(getContext(), 24.0f);
            } else {
                ((ItemMessageExtraBinding) getBinding()).titleView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099891));
                TextView textView2 = ((ItemMessageExtraBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setBackground(ResourceUtils.getDrawable(getContext(), 2131231754));
                layoutParams.height = DisplayUtils.dp2px(getContext(), 14.0f);
            }
            Space space2 = ((ItemMessageExtraBinding) getBinding()).marginView;
            Intrinsics.checkNotNullExpressionValue(space2, "binding.marginView");
            space2.setLayoutParams(layoutParams);
            ((ItemMessageExtraBinding) getBinding()).executePendingBindings();
        }

        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: ChatListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChatListFragment newInstance(String str, String str2, String str3) {
            Bundle bundle = new Bundle();
            ChatListFragment chatListFragment = new ChatListFragment();
            bundle.putString("myId", str2);
            bundle.putString("userId", str3);
            bundle.putString("uKey", str);
            chatListFragment.setArguments(bundle);
            return chatListFragment;
        }
    }
}
