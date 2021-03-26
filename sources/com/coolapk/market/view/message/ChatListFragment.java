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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 U2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0006PQRSTUB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\"\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010%\u001a\u0004\u0018\u00010&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\fJ\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010)\u001a\u00020\u00142\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010+\u001a\u00020,2\b\u0010*\u001a\u0004\u0018\u00010\u0003J\u0016\u0010-\u001a\u00020,2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0010\u0010.\u001a\u00020,2\u0006\u0010*\u001a\u00020&H\u0002J\u0012\u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u000101H\u0016J$\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002042\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020,H\u0016J*\u00108\u001a\u00020,2\u0006\u00105\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u00142\u0006\u00106\u001a\u00020 2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020,H\u0014J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0007J\u000e\u0010@\u001a\u00020\u00142\u0006\u0010*\u001a\u00020&J\b\u0010A\u001a\u00020,H\u0014J\u0018\u0010B\u001a\u00020,2\u0006\u00105\u001a\u00020\u00142\u0006\u0010:\u001a\u00020;H\u0014J \u0010C\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00142\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\b\u0010E\u001a\u00020,H\u0016J\u0010\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u000201H\u0016J\u0010\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\u0003H\u0002J\b\u0010J\u001a\u00020,H\u0016J\b\u0010K\u001a\u00020\u0014H\u0014J\b\u0010L\u001a\u00020\u0014H\u0014J\b\u0010M\u001a\u00020,H\u0002J \u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010O\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001c\u0010\u0010¨\u0006V"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/Entity;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "bindingComponent", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "getBindingComponent", "()Lcom/coolapk/market/binding/FragmentBindingComponent;", "dataList", "Landroidx/databinding/ObservableArrayList;", "myId", "", "getMyId", "()Ljava/lang/String;", "myId$delegate", "Lkotlin/Lazy;", "passiveRefresh", "", "showTipView", "uKey", "getUKey", "uKey$delegate", "updateSubscription", "Lrx/Subscription;", "userId", "getUserId", "userId$delegate", "deleteTime", "index", "", "findFirstItem", "findFirstMessageIndex", "list", "findLastItem", "findMessage", "Lcom/coolapk/market/model/Message;", "messageList", "getDataList", "hasSameMessageIdWith", "message", "insertMessage", "", "insertMessageList", "loadLongMessageAndAdd", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "onDestroy", "onLoadDataFailed", "showLoading", "error", "", "onLoadMore", "onMessageEvent", "event", "Lcom/coolapk/market/event/MessageEvent;", "onNewMessage", "onRefresh", "onRequestFailure", "onRequestResponse", "result", "onResume", "onSaveInstanceState", "outState", "onShowTip", "entity", "reloadData", "shouldShowEmptyView", "shouldShowList", "sort", "removeData", "item", "ChatMineCardViewHolder", "ChatMineViewHolder", "ChatTipViewHolder", "ChatUserCardViewHolder", "ChatUserViewHolder", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ChatListFragment.kt */
public final class ChatListFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_DATA = "DATA";
    public static final String TYPE_TIPS = "messageExtra";
    private MultiTypeAdapter adapter;
    private final FragmentBindingComponent bindingComponent = new FragmentBindingComponent(this);
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private final Lazy myId$delegate = LazyKt.lazy(new ChatListFragment$myId$2(this));
    private boolean passiveRefresh;
    private boolean showTipView;
    private final Lazy uKey$delegate = LazyKt.lazy(new ChatListFragment$uKey$2(this));
    private Subscription updateSubscription;
    private final Lazy userId$delegate = LazyKt.lazy(new ChatListFragment$userId$2(this));

    @JvmStatic
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
        AppHolder.getAppNotification().interceptInLifeCycle(this, AppNotification.MessageIntercept.Companion.privateMessage(new ChatListFragment$onActivityCreated$2(this)));
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558654).constructor(new ChatListFragment$onActivityCreated$3(this)).suitedMethod(ChatListFragment$onActivityCreated$4.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter3 = this.adapter;
        if (multiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter3.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558655).constructor(new ChatListFragment$onActivityCreated$5(this)).suitedMethod(ChatListFragment$onActivityCreated$6.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter4 = this.adapter;
        if (multiTypeAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter4.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558657).constructor(new ChatListFragment$onActivityCreated$7(this)).suitedMethod(ChatListFragment$onActivityCreated$8.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter5 = this.adapter;
        if (multiTypeAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter5.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558656).constructor(new ChatListFragment$onActivityCreated$9(this)).suitedMethod(ChatListFragment$onActivityCreated$10.INSTANCE).build(), -1);
        MultiTypeAdapter multiTypeAdapter6 = this.adapter;
        if (multiTypeAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter6.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558833).constructor(new ChatListFragment$onActivityCreated$11(this)).suitedMethod(ChatListFragment$onActivityCreated$12.INSTANCE).build(), -1);
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

    @Subscribe
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

    /* access modifiers changed from: protected */
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
        View requireView = requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView()");
        ViewParent parent = requireView.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        MessageTopTipBinding messageTopTipBinding = (MessageTopTipBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559027, frameLayout, true);
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatMineViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemChatingMineBinding;", "Lcom/coolapk/market/model/Message;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "activity", "Landroid/app/Activity;", "bindToContent", "", "message", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    private static final class ChatMineViewHolder extends GenericBindHolder<ItemChatingMineBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558654;
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatMineViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatUserViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemChatingUserBinding;", "Lcom/coolapk/market/model/Message;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "activity", "Landroid/app/Activity;", "imageShowType", "", "bindToContent", "", "message", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    private static final class ChatUserViewHolder extends GenericBindHolder<ItemChatingUserBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558656;
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatUserCardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemChatingUserCardBinding;", "Lcom/coolapk/market/model/Message;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "url", "", "bindToContent", "", "message", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    private static final class ChatUserCardViewHolder extends GenericBindHolder<ItemChatingUserCardBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558657;
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
            if (id == 2131362317) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, this.url, null, null, 12, null);
            } else if (id == 2131363900) {
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatUserCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatMineCardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemChatingMineCardBinding;", "Lcom/coolapk/market/model/Message;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "url", "", "bindToContent", "", "message", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    private static final class ChatMineCardViewHolder extends GenericBindHolder<ItemChatingMineCardBinding, Message> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558655;
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
            if (id == 2131362317) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, this.url, null, null, 12, null);
            } else if (id == 2131363900) {
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatMineCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatTipViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemMessageExtraBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "message", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    private static final class ChatTipViewHolder extends GenericBindHolder<ItemMessageExtraBinding, Entity> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558833;

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
                ((ItemMessageExtraBinding) getBinding()).titleView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099896));
                TextView textView2 = ((ItemMessageExtraBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                textView2.setBackground(ResourceUtils.getDrawable(getContext(), 2131231765));
                layoutParams.height = DisplayUtils.dp2px(getContext(), 14.0f);
            }
            Space space2 = ((ItemMessageExtraBinding) getBinding()).marginView;
            Intrinsics.checkNotNullExpressionValue(space2, "binding.marginView");
            space2.setLayoutParams(layoutParams);
            ((ItemMessageExtraBinding) getBinding()).executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$ChatTipViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ChatListFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/message/ChatListFragment$Companion;", "", "()V", "KEY_DATA", "", "TYPE_TIPS", "newInstance", "Lcom/coolapk/market/view/message/ChatListFragment;", "uKey", "myId", "userId", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ChatListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
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
