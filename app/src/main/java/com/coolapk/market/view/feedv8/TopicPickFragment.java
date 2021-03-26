package com.coolapk.market.view.feedv8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.databinding.ItemTopicViewBinding;
import com.coolapk.market.databinding.ItemUserDeleteRecentBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.TopBottomDividerRule;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.TopicViewHolder;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleHolderFactorBuilder;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.github.salomonbrys.kotson.GsonBuilderKt;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001c\u001d\u001e\u001f B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001b\u001a\u00020\u0017H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "atHelper", "Lcom/coolapk/market/view/feedv8/TopicPickFragment$AtHelper;", "currentKey", "", "filterDataWhenLoadMore", "", "originData", "", "index", "newDataByCardId", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "", "page", "searchKeyword", "keyword", "shouldShowEmptyView", "AtHelper", "Companion", "DeleteRecentViewHolder", "TopicPickerViewHolder", "TopicPickerWriteViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicPickFragment.kt */
public final class TopicPickFragment extends EntityListFragment {
    public static final Companion Companion = new Companion(null);
    public static final String HOLDER_TYPE_ALERT = "HOLDER_TYPE_ALERT";
    public static final String HOLDER_TYPE_DELETE = "HOLDER_TYPE_DELETE_RECENT";
    private final AtHelper atHelper = new AtHelper();
    private String currentKey = "";

    @JvmStatic
    public static final TopicPickFragment newInstance(String str) {
        return Companion.newInstance(str);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected int filterDataWhenLoadMore(Object obj, int i, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "originData");
        Intrinsics.checkNotNullParameter(map, "newDataByCardId");
        return -1;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowEmptyView() {
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$Companion;", "", "()V", "HOLDER_TYPE_ALERT", "", "HOLDER_TYPE_DELETE", "newInstance", "Lcom/coolapk/market/view/feedv8/TopicPickFragment;", "type", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TopicPickFragment newInstance(String str) {
            TopicPickFragment topicPickFragment = new TopicPickFragment();
            Bundle bundle = new Bundle();
            bundle.putString("TYPE", str);
            Unit unit = Unit.INSTANCE;
            topicPickFragment.setArguments(bundle);
            return topicPickFragment;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (r9.equals("ACTION_TYPE_LIST") == false) goto L_0x007a;
     */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String string = requireArguments().getString("TYPE");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1353319389) {
                if (hashCode == 371650490) {
                }
            } else if (string.equals("ACTION_TYPE_WRITE")) {
                BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease = getAdapter$presentation_coolapkAppRelease();
                SimpleHolderFactorBuilder constructor = SimpleViewHolderFactor.Companion.withLayoutId(2131558962).suitedMethod(TopicPickFragment$onActivityCreated$1.INSTANCE).constructor(new TopicPickFragment$onActivityCreated$2(this));
                Integer num = getItemViewTypeByEntityType().get("topic");
                Intrinsics.checkNotNull(num);
                Intrinsics.checkNotNullExpressionValue(num, "itemViewTypeByEntityType…tils.ENTITY_TYPE_TOPIC]!!");
                BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease, constructor.resetItemViewType(num.intValue()).build(), 0, 2, null);
                BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558954).suitedMethod(TopicPickFragment$onActivityCreated$5.INSTANCE).constructor(TopicPickFragment$onActivityCreated$6.INSTANCE).build(), 0, 2, null);
                BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558971).suitedMethod(TopicPickFragment$onActivityCreated$7.INSTANCE).constructor(new TopicPickFragment$onActivityCreated$8(this)).build(), 0, 2, null);
                BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558586).suitedMethod(TopicPickFragment$onActivityCreated$9.INSTANCE).constructor(TopicPickFragment$onActivityCreated$10.INSTANCE).build(), 0, 2, null);
                getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.TB12DP);
                getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new TopicPickFragment$onActivityCreated$11());
                initData();
            }
        }
        BaseMultiTypeAdapter adapter$presentation_coolapkAppRelease2 = getAdapter$presentation_coolapkAppRelease();
        SimpleHolderFactorBuilder constructor2 = SimpleViewHolderFactor.Companion.withLayoutId(2131558962).suitedMethod(TopicPickFragment$onActivityCreated$3.INSTANCE).constructor(new TopicPickFragment$onActivityCreated$4(this));
        Integer num2 = getItemViewTypeByEntityType().get("topic");
        Intrinsics.checkNotNull(num2);
        Intrinsics.checkNotNullExpressionValue(num2, "itemViewTypeByEntityType…tils.ENTITY_TYPE_TOPIC]!!");
        BaseMultiTypeAdapter.register$default(adapter$presentation_coolapkAppRelease2, constructor2.resetItemViewType(num2.intValue()).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558954).suitedMethod(TopicPickFragment$onActivityCreated$5.INSTANCE).constructor(TopicPickFragment$onActivityCreated$6.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558971).suitedMethod(TopicPickFragment$onActivityCreated$7.INSTANCE).constructor(new TopicPickFragment$onActivityCreated$8(this)).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558586).suitedMethod(TopicPickFragment$onActivityCreated$9.INSTANCE).constructor(TopicPickFragment$onActivityCreated$10.INSTANCE).build(), 0, 2, null);
        getVxDividerDecoration$presentation_coolapkAppRelease().addDividerRule(TopBottomDividerRule.TB12DP);
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new TopicPickFragment$onActivityCreated$11());
        initData();
    }

    public final void searchKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "keyword");
        if (!Intrinsics.areEqual(this.currentKey, str)) {
            cancelLoadData();
            getDataList().clear();
            this.currentKey = str;
            setPage(1);
            reloadData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String str;
        if (this.currentKey.length() == 0) {
            List<Topic> load = this.atHelper.load();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(load, 10));
            Iterator<T> it2 = load.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getId());
            }
            str = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        } else {
            str = "";
        }
        DataManager instance = DataManager.getInstance();
        String str2 = this.currentKey;
        Entity findFirstEntity$default = EntityListFragment.findFirstEntity$default(this, null, null, false, false, 15, null);
        String id = findFirstEntity$default != null ? findFirstEntity$default.getId() : null;
        Entity findLastEntity$default = EntityListFragment.findLastEntity$default(this, null, false, 3, null);
        Observable<R> flatMap = instance.searchTopic(str2, i, id, findLastEntity$default != null ? findLastEntity$default.getId() : null, z ? str : null).compose(RxUtils.apiCommonToData()).flatMap(new TopicPickFragment$onCreateRequest$1(this, z, i));
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…tities)\n                }");
        return flatMap;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$TopicPickerViewHolder;", "Lcom/coolapk/market/viewholder/TopicViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/view/feedv8/TopicPickFragment;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "data", "Lcom/coolapk/market/model/Topic;", "onClick", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickFragment.kt */
    public class TopicPickerViewHolder extends TopicViewHolder {
        final /* synthetic */ TopicPickFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TopicPickerViewHolder(TopicPickFragment topicPickFragment, View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.this$0 = topicPickFragment;
        }

        @Override // com.coolapk.market.viewholder.TopicViewHolder
        public void bindToContent(Topic topic) {
            Intrinsics.checkNotNullParameter(topic, "data");
            super.bindToContent(topic);
            if (Intrinsics.areEqual(topic.getId(), "0")) {
                TextView textView = ((ItemTopicViewBinding) getBinding()).descriptionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView");
                textView.setText(topic.getDescription());
            }
            TextView textView2 = ((ItemTopicViewBinding) getBinding()).descriptionView;
            CharSequence text = textView2.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            int i = 0;
            if (text.length() == 0) {
                i = 8;
            }
            textView2.setVisibility(i);
            ((ItemTopicViewBinding) getBinding()).rootView.setOnLongClickListener(new TopicPickFragment$TopicPickerViewHolder$bindToContent$2(this, topic));
        }

        @Override // com.coolapk.market.viewholder.TopicViewHolder, com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getId() != 2131363260) {
                super.onClick(view);
                return;
            }
            Object orNull = CollectionsKt.getOrNull(this.this$0.getDataList(), getAdapterPosition());
            if (!(orNull instanceof Topic)) {
                orNull = null;
            }
            Topic topic = (Topic) orNull;
            if (topic != null) {
                this.this$0.requireActivity().setResult(-1, new Intent().putExtra("KEY_TOPIC_TITLE", topic.getTitle()).putExtra("KEY_TOPIC_MODEL", topic));
                this.this$0.atHelper.save(topic);
                this.this$0.requireActivity().finish();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$TopicPickerWriteViewHolder;", "Lcom/coolapk/market/view/feedv8/TopicPickFragment$TopicPickerViewHolder;", "Lcom/coolapk/market/view/feedv8/TopicPickFragment;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/view/feedv8/TopicPickFragment;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "onClick", "", "view", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickFragment.kt */
    public final class TopicPickerWriteViewHolder extends TopicPickerViewHolder {
        final /* synthetic */ TopicPickFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TopicPickerWriteViewHolder(TopicPickFragment topicPickFragment, View view, DataBindingComponent dataBindingComponent) {
            super(topicPickFragment, view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.this$0 = topicPickFragment;
        }

        @Override // com.coolapk.market.view.feedv8.TopicPickFragment.TopicPickerViewHolder, com.coolapk.market.viewholder.TopicViewHolder, com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getId() != 2131363260) {
                super.onClick(view);
                return;
            }
            Object orNull = CollectionsKt.getOrNull(this.this$0.getDataList(), getAdapterPosition());
            if (!(orNull instanceof Topic)) {
                orNull = null;
            }
            Topic topic = (Topic) orNull;
            if (topic != null) {
                FeedMultiPart build = FeedArgsFactoryKt.applyTopic(FeedArgsFactory.multiPartForFeed(), topic).build();
                FragmentActivity requireActivity = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                FeedUIConfig.Builder uiConfigForFeed = FeedArgsFactory.uiConfigForFeed(requireActivity);
                FragmentActivity requireActivity2 = this.this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                ActionManager.startSubmitFeedV8Activity(this.this$0.getActivity(), FeedArgsFactoryKt.applyTopic(uiConfigForFeed, requireActivity2, topic).build(), build);
                this.this$0.atHelper.save(topic);
                this.this$0.requireActivity().finish();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$DeleteRecentViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserDeleteRecentBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "holderItem", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickFragment.kt */
    private static final class DeleteRecentViewHolder extends GenericBindHolder<ItemUserDeleteRecentBinding, HolderItem> {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558971;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeleteRecentViewHolder(View view, ItemActionHandler itemActionHandler) {
            super(view, null, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$DeleteRecentViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: TopicPickFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public void bindToContent(HolderItem holderItem) {
            Intrinsics.checkNotNullParameter(holderItem, "holderItem");
            ItemUserDeleteRecentBinding itemUserDeleteRecentBinding = (ItemUserDeleteRecentBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemUserDeleteRecentBinding, "binding");
            itemUserDeleteRecentBinding.setModel(holderItem);
            ((ItemUserDeleteRecentBinding) getBinding()).actionView.setOnClickListener(this);
            ((ItemUserDeleteRecentBinding) getBinding()).executePendingBindings();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$AtHelper;", "", "()V", "clear", "", "load", "", "Lcom/coolapk/market/model/Topic;", "save", "saveTopic", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicPickFragment.kt */
    private static final class AtHelper {
        public static final Companion Companion = new Companion(null);
        public static final int MAX_SAVE_COUNT = 6;
        public static final String PREF_KEY_AT_TOPIC = "AT_TOPIC_ARRAY";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/feedv8/TopicPickFragment$AtHelper$Companion;", "", "()V", "MAX_SAVE_COUNT", "", "PREF_KEY_AT_TOPIC", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: TopicPickFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final List<Topic> load() {
            Type type;
            String preferencesString = DataManager.getInstance().getPreferencesString("AT_TOPIC_ARRAY", "[]");
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            Gson gson = instance.getGson();
            Intrinsics.checkNotNullExpressionValue(gson, "DataManager.getInstance().gson");
            Intrinsics.checkNotNullExpressionValue(preferencesString, "jsonString");
            Type type2 = new TopicPickFragment$AtHelper$load$$inlined$fromJson$1().getType();
            Intrinsics.checkExpressionValueIsNotNull(type2, "object : TypeToken<T>() {} .type");
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                if (GsonBuilderKt.isWildcard(parameterizedType)) {
                    type = parameterizedType.getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(type, "type.rawType");
                    Object fromJson = gson.fromJson(preferencesString, type);
                    Intrinsics.checkExpressionValueIsNotNull(fromJson, "fromJson(json, typeToken<T>())");
                    return (List) fromJson;
                }
            }
            type = GsonBuilderKt.removeTypeWildcards(type2);
            Object fromJson = gson.fromJson(preferencesString, type);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "fromJson(json, typeToken<T>())");
            return (List) fromJson;
        }

        public final void save(Topic topic) {
            Intrinsics.checkNotNullParameter(topic, "saveTopic");
            ArrayList arrayList = new ArrayList();
            for (T t : load()) {
                if (true ^ Intrinsics.areEqual(t.getId(), topic.getId())) {
                    arrayList.add(t);
                }
            }
            List plus = CollectionsKt.plus((Collection) CollectionsKt.arrayListOf(topic), (Iterable) arrayList);
            if (!plus.isEmpty()) {
                if (plus.size() > 6) {
                    plus = plus.subList(0, 6);
                }
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                String json = instance.getGson().toJson(plus);
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                instance2.getPreferencesEditor().putString("AT_TOPIC_ARRAY", json).apply();
                return;
            }
            clear();
        }

        public final void clear() {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            instance.getPreferencesEditor().remove("AT_TOPIC_ARRAY").apply();
        }
    }
}
