package com.coolapk.market.view.message;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMessageSelectViewBinding;
import com.coolapk.market.event.MessageEvent;
import com.coolapk.market.event.UserBlockedEvent;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.manager.AppNotification;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Message;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.notification.NotificationActivity;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import rx.Observable;
import rx.Subscriber;

/* compiled from: NewMessageListFragment.kt */
public final class NewMessageListFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    private LinkedHashMap<String, Message> delList = new LinkedHashMap<>();
    private boolean editState;
    private boolean isFirstLoad = true;
    private boolean isPassiveSelect;
    private boolean isRefreshByUser;
    private boolean isSelectAll;
    private AppNotification.PMIntercept mPMIntercept;
    private ItemMessageSelectViewBinding messageSelectViewBinding;
    private boolean showDelView;

    public static final NewMessageListFragment newInstance() {
        return Companion.newInstance();
    }

    public static final /* synthetic */ ItemMessageSelectViewBinding access$getMessageSelectViewBinding$p(NewMessageListFragment newMessageListFragment) {
        ItemMessageSelectViewBinding itemMessageSelectViewBinding = newMessageListFragment.messageSelectViewBinding;
        if (itemMessageSelectViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
        }
        return itemMessageSelectViewBinding;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        String str2 = null;
        if (z) {
            Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, "message", null, false, false, 14, null);
            if (!(findFirstEntity$default instanceof Message)) {
                findFirstEntity$default = null;
            }
            Message message = (Message) findFirstEntity$default;
            if (message != null) {
                str = message.getUKey();
                if (!z) {
                    Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, "message", false, 2, null);
                    if (!(findLastEntity$default instanceof Message)) {
                        findLastEntity$default = null;
                    }
                    Message message2 = (Message) findLastEntity$default;
                    if (message2 != null) {
                        str2 = message2.getUKey();
                    }
                }
                Observable<R> doOnNext = DataManager.getInstance().getMessageList(i, str, str2).map(RxUtils.checkResultToData()).doOnNext(new NewMessageListFragment$onCreateRequest$1(z));
                Intrinsics.checkNotNullExpressionValue(doOnNext, "DataManager.getInstance(…      }\n                }");
                return doOnNext;
            }
        }
        str = null;
        if (!z) {
        }
        Observable<R> doOnNext = DataManager.getInstance().getMessageList(i, str, str2).map(RxUtils.checkResultToData()).doOnNext(new NewMessageListFragment$onCreateRequest$1(z));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "DataManager.getInstance(…      }\n                }");
        return doOnNext;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getVxDividerDecoration$presentation_coolapkAppRelease().setDefaultNoMargin();
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(new NewMessageListFragment$onActivityCreated$1());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558824).constructor(new NewMessageListFragment$onActivityCreated$2(this)).suitedMethod(NewMessageListFragment$onActivityCreated$3.INSTANCE).build(), -1);
        AppNotification appNotification = AppHolder.getAppNotification();
        AppNotification.PMIntercept pMIntercept = new AppNotification.PMIntercept(new NewMessageListFragment$onActivityCreated$4(this));
        this.mPMIntercept = pMIntercept;
        appNotification.addIntercept(pMIntercept);
        setHasOptionsMenu(true);
        updateMessageNum();
        onShowDelView();
        if (getUserVisibleHint()) {
            initData();
        }
    }

    private final void updateMessageNum() {
        DataManager.getInstance().checkNotificationCount().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new NewMessageListFragment$updateMessageNum$1(this));
    }

    public final void updateEditState(int i) {
        boolean z = true;
        int i2 = 0;
        if (i != 1) {
            z = false;
        }
        this.editState = z;
        getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
        if (!this.editState) {
            LinkedHashMap<String, Message> linkedHashMap = this.delList;
            Intrinsics.checkNotNull(linkedHashMap);
            linkedHashMap.clear();
            this.isSelectAll = false;
            ItemMessageSelectViewBinding itemMessageSelectViewBinding = this.messageSelectViewBinding;
            if (itemMessageSelectViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            CheckBox checkBox = itemMessageSelectViewBinding.checkBox;
            Intrinsics.checkNotNullExpressionValue(checkBox, "messageSelectViewBinding.checkBox");
            checkBox.setChecked(this.isSelectAll);
            onRefresh();
        }
        ItemMessageSelectViewBinding itemMessageSelectViewBinding2 = this.messageSelectViewBinding;
        if (itemMessageSelectViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
        }
        LinearLayout linearLayout = itemMessageSelectViewBinding2.rootView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "messageSelectViewBinding.rootView");
        if (!this.editState) {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        getRecyclerView().post(new NewMessageListFragment$updateEditState$1(this));
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.notification.NotificationActivity");
        MenuItem findItem = ((NotificationActivity) activity).getToolbar().getMenu().findItem(2131361901);
        Intrinsics.checkNotNullExpressionValue(findItem, "(activity as Notificatio…indItem(R.id.action_edit)");
        findItem.setTitle(this.editState ? "完成" : "批量删除");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361901, 0, "批量删除").setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == 2131361901) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof NotificationActivity)) {
                activity = null;
            }
            NotificationActivity notificationActivity = (NotificationActivity) activity;
            Intrinsics.checkNotNull(notificationActivity);
            notificationActivity.setMessageState(!this.editState ? 1 : 0);
        }
        return true;
    }

    public final boolean refresh(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.editState) {
            return false;
        }
        reloadData();
        return isResumed();
    }

    public final void updateDelView() {
        LinkedHashMap<String, Message> linkedHashMap = this.delList;
        Intrinsics.checkNotNull(linkedHashMap);
        String str = "删除会话";
        if (linkedHashMap.isEmpty()) {
            setDelViewBackgroundColor(AppHolder.getAppTheme().getCurrencyColorDivider());
            setDelViewText(str);
            return;
        }
        setDelViewBackgroundColor(ResourceUtils.getColorInt(getActivity(), 2131099882));
        boolean z = this.isSelectAll;
        StringBuilder sb = new StringBuilder();
        sb.append("删除会话(");
        LinkedHashMap<String, Message> linkedHashMap2 = this.delList;
        Intrinsics.checkNotNull(linkedHashMap2);
        sb.append(linkedHashMap2.size());
        sb.append(')');
        String sb2 = sb.toString();
        if (!z) {
            str = sb2;
        }
        setDelViewText(str);
    }

    private final void setDelViewBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        ItemMessageSelectViewBinding itemMessageSelectViewBinding = this.messageSelectViewBinding;
        if (itemMessageSelectViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
        }
        TextView textView = itemMessageSelectViewBinding.deleteView;
        Intrinsics.checkNotNullExpressionValue(textView, "messageSelectViewBinding.deleteView");
        textView.setBackground(colorDrawable);
    }

    private final void setDelViewText(String str) {
        ItemMessageSelectViewBinding itemMessageSelectViewBinding = this.messageSelectViewBinding;
        if (itemMessageSelectViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
        }
        TextView textView = itemMessageSelectViewBinding.deleteView;
        Intrinsics.checkNotNullExpressionValue(textView, "messageSelectViewBinding.deleteView");
        textView.setText(str);
    }

    public final boolean isSelectAll() {
        return this.isSelectAll;
    }

    public final void setSelectAllState(boolean z) {
        if (!z) {
            this.isPassiveSelect = true;
        }
        ItemMessageSelectViewBinding itemMessageSelectViewBinding = this.messageSelectViewBinding;
        if (itemMessageSelectViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
        }
        CheckBox checkBox = itemMessageSelectViewBinding.checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "messageSelectViewBinding.checkBox");
        checkBox.setChecked(z);
    }

    public final void selectAll(boolean z) {
        for (T t : getDataList()) {
            if (t instanceof Message) {
                if (z) {
                    LinkedHashMap<String, Message> linkedHashMap = this.delList;
                    Intrinsics.checkNotNull(linkedHashMap);
                    if (!linkedHashMap.containsValue(t)) {
                        LinkedHashMap<String, Message> linkedHashMap2 = this.delList;
                        Intrinsics.checkNotNull(linkedHashMap2);
                        String entityId = t.getEntityId();
                        Intrinsics.checkNotNull(entityId);
                        Intrinsics.checkNotNullExpressionValue(entityId, "it.entityId!!");
                        linkedHashMap2.put(entityId, t);
                    }
                } else if (this.isPassiveSelect) {
                    this.isPassiveSelect = false;
                    return;
                } else {
                    LinkedHashMap<String, Message> linkedHashMap3 = this.delList;
                    Intrinsics.checkNotNull(linkedHashMap3);
                    if (linkedHashMap3.containsValue(t)) {
                        LinkedHashMap<String, Message> linkedHashMap4 = this.delList;
                        Intrinsics.checkNotNull(linkedHashMap4);
                        LinkedHashMap<String, Message> linkedHashMap5 = linkedHashMap4;
                        String entityId2 = t.getEntityId();
                        Objects.requireNonNull(linkedHashMap5, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                        TypeIntrinsics.asMutableMap(linkedHashMap5).remove(entityId2);
                    }
                }
            }
        }
        getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
    }

    private final void onShowDelView() {
        FrameLayout frameLayout;
        View view = getView();
        if (view != null) {
            if (!(view instanceof FrameLayout)) {
                view = null;
            }
            frameLayout = (FrameLayout) view;
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558827, null, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_select_view, null, true)");
            ItemMessageSelectViewBinding itemMessageSelectViewBinding = (ItemMessageSelectViewBinding) inflate;
            this.messageSelectViewBinding = itemMessageSelectViewBinding;
            if (itemMessageSelectViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            LinearLayout linearLayout = itemMessageSelectViewBinding.rootView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "messageSelectViewBinding.rootView");
            linearLayout.setVisibility(8);
            ItemMessageSelectViewBinding itemMessageSelectViewBinding2 = this.messageSelectViewBinding;
            if (itemMessageSelectViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            CheckBox checkBox = itemMessageSelectViewBinding2.checkBox;
            Intrinsics.checkNotNullExpressionValue(checkBox, "messageSelectViewBinding.checkBox");
            checkBox.setChecked(this.isSelectAll);
            ItemMessageSelectViewBinding itemMessageSelectViewBinding3 = this.messageSelectViewBinding;
            if (itemMessageSelectViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            itemMessageSelectViewBinding3.allSelectView.setOnClickListener(new NewMessageListFragment$onShowDelView$1(this));
            ItemMessageSelectViewBinding itemMessageSelectViewBinding4 = this.messageSelectViewBinding;
            if (itemMessageSelectViewBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            itemMessageSelectViewBinding4.deleteView.setOnClickListener(new NewMessageListFragment$onShowDelView$2(this));
            ItemMessageSelectViewBinding itemMessageSelectViewBinding5 = this.messageSelectViewBinding;
            if (itemMessageSelectViewBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
            }
            itemMessageSelectViewBinding5.checkBox.setOnCheckedChangeListener(new NewMessageListFragment$onShowDelView$3(this));
            if (!this.showDelView) {
                updateDelView();
                ItemMessageSelectViewBinding itemMessageSelectViewBinding6 = this.messageSelectViewBinding;
                if (itemMessageSelectViewBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageSelectViewBinding");
                }
                View root = itemMessageSelectViewBinding6.getRoot();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                Unit unit = Unit.INSTANCE;
                frameLayout.addView(root, layoutParams);
                this.showDelView = true;
            }
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new NewMessageListFragment$onShowDelView$5(this));
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mPMIntercept != null) {
            AppHolder.getAppNotification().removeIntercept(this.mPMIntercept);
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected void onRefresh() {
        super.onRefresh();
        updateMessageNum();
        this.isRefreshByUser = true;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean z2;
        removeHintOrRefreshView();
        List<? extends Entity> list2 = list;
        if (!CollectionUtils.isEmpty(list2)) {
            if (!z) {
                List<Parcelable> dataList = getDataList();
                if (!TypeIntrinsics.isMutableList(dataList)) {
                    dataList = null;
                }
                EntityUtils.removeReduplicatedEntity(list, dataList, null);
                List<Parcelable> dataList2 = getDataList();
                Intrinsics.checkNotNull(list);
                dataList2.addAll(list2);
                if (this.editState && this.isSelectAll) {
                    for (T t : list) {
                        if (t instanceof Message) {
                            LinkedHashMap<String, Message> linkedHashMap = this.delList;
                            Intrinsics.checkNotNull(linkedHashMap);
                            if (!linkedHashMap.containsValue(t)) {
                                LinkedHashMap<String, Message> linkedHashMap2 = this.delList;
                                Intrinsics.checkNotNull(linkedHashMap2);
                                String entityId = t.getEntityId();
                                Intrinsics.checkNotNull(entityId);
                                Intrinsics.checkNotNullExpressionValue(entityId, "it.entityId!!");
                                linkedHashMap2.put(entityId, t);
                            }
                        }
                    }
                    getAdapter$presentation_coolapkAppRelease().notifyDataSetChanged();
                }
            } else if (this.isRefreshByUser) {
                List<Parcelable> dataList3 = getDataList();
                if (!TypeIntrinsics.isMutableList(dataList3)) {
                    dataList3 = null;
                }
                EntityUtils.removeReduplicatedEntity(list, dataList3, null);
                List<Parcelable> dataList4 = getDataList();
                Intrinsics.checkNotNull(list);
                dataList4.addAll(0, list2);
            } else {
                Intrinsics.checkNotNull(list);
                filterList(list);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        updateContentUI();
        this.isFirstLoad = false;
        this.isRefreshByUser = false;
        return z2;
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private final void filterList(List<? extends Entity> list) {
        if (!list.isEmpty()) {
            if (getDataList().isEmpty()) {
                getDataList().addAll(0, list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            for (int size = list.size() - 1; size >= 0; size--) {
                int size2 = getDataList().size() - 1;
                while (true) {
                    if (size2 < 0) {
                        break;
                    }
                    String entityId = ((Entity) list.get(size)).getEntityId();
                    Parcelable parcelable = getDataList().get(size2);
                    Object obj = null;
                    if (!(parcelable instanceof Entity)) {
                        parcelable = null;
                    }
                    Entity entity = (Entity) parcelable;
                    Intrinsics.checkNotNull(entity);
                    if (TextUtils.equals(entityId, entity.getEntityId())) {
                        arrayList.remove(list.get(size));
                        Long dateline = ((Entity) list.get(size)).getDateline();
                        Parcelable parcelable2 = getDataList().get(size2);
                        if (!(parcelable2 instanceof Entity)) {
                            parcelable2 = null;
                        }
                        Entity entity2 = (Entity) parcelable2;
                        Intrinsics.checkNotNull(entity2);
                        if (!Intrinsics.areEqual(dateline, entity2.getDateline())) {
                            Object obj2 = list.get(size);
                            if (obj2 instanceof Message) {
                                obj = obj2;
                            }
                            Message message = (Message) obj;
                            Intrinsics.checkNotNull(message);
                            int findNewIndex = findNewIndex(message);
                            if (findNewIndex <= -1 || findNewIndex == size2) {
                                getDataList().set(size2, list.get(size));
                            } else {
                                getDataList().add(findNewIndex, list.get(size));
                                List<Parcelable> dataList = getDataList();
                                int i = size2 + 1;
                                if (!(findNewIndex > size2)) {
                                    size2 = i;
                                }
                                dataList.remove(size2);
                            }
                        }
                    }
                    size2--;
                }
            }
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                Object obj3 = arrayList.get(size3);
                Intrinsics.checkNotNullExpressionValue(obj3, "noExistedData[newListIndex]");
                Parcelable parcelable3 = (Parcelable) obj3;
                if (parcelable3 instanceof Message) {
                    if (((Message) parcelable3).isToped()) {
                        getDataList().add(0, parcelable3);
                    } else if (findLastTopIndex() <= -1) {
                        getDataList().add(findLastTopIndex() + 1, parcelable3);
                    }
                }
            }
        }
    }

    public final void deleteChat(List<Parcelable> list, List<String> list2) {
        int size = list.size();
        Observable.range(0, size).map(new NewMessageListFragment$deleteChat$1(size)).filter(new NewMessageListFragment$deleteChat$2(list, list2)).subscribe(new NewMessageListFragment$deleteChat$3(list));
    }

    private final int findLastTopIndex() {
        if (getDataList().isEmpty()) {
            return -1;
        }
        for (int size = getDataList().size() - 1; size >= 0; size--) {
            Parcelable parcelable = getDataList().get(size);
            if ((parcelable instanceof Message) && ((Message) parcelable).isToped()) {
                return size;
            }
        }
        return -1;
    }

    private final int findNewIndex(Message message) {
        int findLastTopIndex = findLastTopIndex();
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Message) {
                if (message.isToped()) {
                    Long dateline = message.getDateline();
                    Intrinsics.checkNotNull(dateline);
                    long longValue = dateline.longValue();
                    Long dateline2 = t.getDateline();
                    Intrinsics.checkNotNull(dateline2);
                    Intrinsics.checkNotNullExpressionValue(dateline2, "item.dateline!!");
                    if (longValue >= dateline2.longValue() && i <= findLastTopIndex) {
                        return i;
                    }
                } else {
                    T t2 = t;
                    if (t2.isToped()) {
                        continue;
                    } else {
                        Long dateline3 = message.getDateline();
                        Intrinsics.checkNotNull(dateline3);
                        long longValue2 = dateline3.longValue();
                        Long dateline4 = t2.getDateline();
                        Intrinsics.checkNotNull(dateline4);
                        Intrinsics.checkNotNullExpressionValue(dateline4, "item.dateline!!");
                        if (longValue2 >= dateline4.longValue()) {
                            return i;
                        }
                    }
                }
            }
            i++;
        }
        return -1;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        super.onRequestFailure(z, th);
        this.isRefreshByUser = false;
    }

    public final void onUserBlockedEvent(UserBlockedEvent userBlockedEvent) {
        Intrinsics.checkNotNullParameter(userBlockedEvent, "event");
        int i = 0;
        if (userBlockedEvent.getIsInBlackList() > 0) {
            List<Parcelable> dataList = getDataList();
            while (i < dataList.size()) {
                Parcelable parcelable = dataList.get(i);
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.Message");
                if (TextUtils.equals(userBlockedEvent.getUid(), ((Message) parcelable).getMessageUid())) {
                    dataList.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public void reloadData() {
        updateMessageNum();
        super.reloadData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.isFirstLoad && !this.editState) {
            reloadData();
        }
    }

    public final void onMessageEvent(MessageEvent messageEvent) {
        Intrinsics.checkNotNullParameter(messageEvent, "event");
        Message message = messageEvent.getMessage();
        int i = 0;
        for (T t : getDataList()) {
            if (t instanceof Message) {
                Intrinsics.checkNotNullExpressionValue(message, "message");
                if (!TextUtils.equals(t.getUKey(), message.getUKey())) {
                    continue;
                } else if (messageEvent.isDeleteChat()) {
                    getDataList().remove(i);
                    return;
                } else if (messageEvent.isAddTop()) {
                    getDataList().remove(i);
                    getDataList().add(0, message);
                    getRecyclerView().smoothScrollToPosition(0);
                    return;
                } else if (messageEvent.isRemoveTop()) {
                    getDataList().add(findLastTopIndex(i), message);
                    return;
                } else if (messageEvent.isUpdataMessage()) {
                    updataMessage(message, i);
                    return;
                }
            }
            i++;
        }
    }

    private final int findLastTopIndex(int i) {
        int i2 = 0;
        if (getDataList().size() == 1) {
            getDataList().remove(i);
            return 0;
        }
        for (T t : getDataList()) {
            if (i2 == getDataList().size() - 1) {
                getDataList().remove(i);
                return getDataList().size();
            }
            int i3 = i2 + 1;
            Parcelable parcelable = getDataList().get(i3);
            if (!(parcelable instanceof Message) || !(t instanceof Message) || ((Message) parcelable).isToped() || !t.isToped()) {
                i2 = i3;
            } else {
                getDataList().remove(i);
                return i2;
            }
        }
        return -1;
    }

    private final void updataMessage(Message message, int i) {
        Message.Builder builder = Message.builder(message);
        builder.setEntityTemplate("messageListItem").setEntityId(message.getUKey()).setIsNew(0).setUnreadNum(0);
        if (!TextUtils.isEmpty(message.getMessagePic())) {
            builder.setMessage("[图片]");
        }
        List<Parcelable> dataList = getDataList();
        Message build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        dataList.set(i, build);
    }

    /* compiled from: NewMessageListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NewMessageListFragment newInstance() {
            Bundle bundle = new Bundle();
            NewMessageListFragment newMessageListFragment = new NewMessageListFragment();
            newMessageListFragment.setArguments(bundle);
            return newMessageListFragment;
        }
    }
}
