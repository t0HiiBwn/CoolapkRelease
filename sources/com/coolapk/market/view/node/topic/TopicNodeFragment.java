package com.coolapk.market.view.node.topic;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ProductNodeToolbarContentBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.block.AddBlockDialog;
import com.coolapk.market.view.block.BlockItem;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.node.NodeActivityBehavior;
import com.coolapk.market.view.node.NodeFeedDialogInterceptor;
import com.coolapk.market.view.node.NodeHelper;
import com.coolapk.market.view.user.EntityFollowEvent;
import com.coolapk.market.widget.Toast;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bH\u0002J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J&\u0010-\u001a\u0004\u0018\u00010\u00192\u0006\u0010+\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020\u001fH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006A"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicNodeFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/node/topic/TopicNodeFragmentBehavior;", "()V", "behavior", "Lcom/coolapk/market/view/node/NodeActivityBehavior;", "getBehavior", "()Lcom/coolapk/market/view/node/NodeActivityBehavior;", "headerViewPart", "Lcom/coolapk/market/view/node/topic/TopicNodeHeaderViewPart;", "presenter", "Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "getPresenter", "()Lcom/coolapk/market/view/node/topic/TopicVXPresenter;", "setPresenter", "(Lcom/coolapk/market/view/node/topic/TopicVXPresenter;)V", "toolbarBinding", "Lcom/coolapk/market/databinding/ProductNodeToolbarContentBinding;", "viewModel", "Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "getViewModel", "()Lcom/coolapk/market/view/node/topic/TopicVXViewModel;", "setViewModel", "(Lcom/coolapk/market/view/node/topic/TopicVXViewModel;)V", "createToolbarContentView", "Landroid/view/View;", "data", "Lcom/coolapk/market/model/Topic;", "getData", "Lcom/coolapk/market/model/Entity;", "installTopicContent", "", "model", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onApplyWindowsInset", "inset", "Landroid/graphics/Rect;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFloatingButtonAction", "translationY", "", "onFollowStateChanged", "oldValue", "", "newValue", "error", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "updateFollowState", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: TopicNodeFragment.kt */
public final class TopicNodeFragment extends BaseFragment implements TopicNodeFragmentBehavior {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_MODEL = "MODEL";
    private TopicNodeHeaderViewPart headerViewPart;
    public TopicVXPresenter presenter;
    private ProductNodeToolbarContentBinding toolbarBinding;
    public TopicVXViewModel viewModel;

    @Override // com.coolapk.market.view.node.topic.TopicNodeFragmentBehavior
    public TopicVXViewModel getViewModel() {
        TopicVXViewModel topicVXViewModel = this.viewModel;
        if (topicVXViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return topicVXViewModel;
    }

    public void setViewModel(TopicVXViewModel topicVXViewModel) {
        Intrinsics.checkNotNullParameter(topicVXViewModel, "<set-?>");
        this.viewModel = topicVXViewModel;
    }

    @Override // com.coolapk.market.view.node.topic.TopicNodeFragmentBehavior
    public TopicVXPresenter getPresenter() {
        TopicVXPresenter topicVXPresenter = this.presenter;
        if (topicVXPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return topicVXPresenter;
    }

    public void setPresenter(TopicVXPresenter topicVXPresenter) {
        Intrinsics.checkNotNullParameter(topicVXPresenter, "<set-?>");
        this.presenter = topicVXPresenter;
    }

    /* access modifiers changed from: private */
    public final NodeActivityBehavior getBehavior() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.node.NodeActivityBehavior");
        return (NodeActivityBehavior) activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/node/topic/TopicNodeFragment$Companion;", "", "()V", "KEY_MODEL", "", "newInstance", "Lcom/coolapk/market/view/node/topic/TopicNodeFragment;", "model", "Lcom/coolapk/market/model/Topic;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TopicNodeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TopicNodeFragment newInstance(Topic topic) {
            Intrinsics.checkNotNullParameter(topic, "model");
            TopicNodeFragment topicNodeFragment = new TopicNodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MODEL", topic);
            Unit unit = Unit.INSTANCE;
            topicNodeFragment.setArguments(bundle);
            return topicNodeFragment;
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        StatisticHelper.Companion.getInstance().recordNodeClickAction("话题");
        Parcelable parcelable = requireArguments().getParcelable("MODEL");
        if (parcelable != null) {
            Topic topic = (Topic) parcelable;
            setViewModel(new TopicVXViewModel(topic));
            getViewModel().onInitSavedInstanceState(bundle);
            String title = topic.getTitle();
            if (title == null) {
                title = "";
            }
            setPresenter(new TopicVXPresenter(title, this));
            getPresenter().onInitSavedInstanceState(bundle);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return new Space(layoutInflater.getContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Topic model = getViewModel().getModel();
        installTopicContent(model);
        TopicVXViewModel viewModel2 = getViewModel();
        viewModel2.addOnPropertyChangedCallback(new TopicNodeFragment$onActivityCreated$1(this));
        if (UserPermissionChecker.INSTANCE.isLoginAdmin()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            List<String> topIds = viewModel2.getTopIds();
            String id = model.getId();
            if (id == null) {
                id = "";
            }
            NodeFeedDialogInterceptor nodeFeedDialogInterceptor = new NodeFeedDialogInterceptor(fragmentActivity, topIds, "topic", id, false, 16, null);
            SheetGroupModifierManager.INSTANCE.addModifier(nodeFeedDialogInterceptor);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new TopicNodeFragment$onActivityCreated$2(nodeFeedDialogInterceptor));
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        getViewModel().onSaveInstanceState(bundle);
        getPresenter().onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onApplyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        TopicNodeHeaderViewPart topicNodeHeaderViewPart = this.headerViewPart;
        if (topicNodeHeaderViewPart != null) {
            topicNodeHeaderViewPart.applyWindowsInset(rect);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        MenuItem add = menu.add(0, 2131361961, 0, getString(2131886450));
        add.setIcon(2131231545);
        add.setShowAsAction(2);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0097: APUT  
      (r5v2 com.coolapk.market.view.block.BlockItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.coolapk.market.view.block.BlockItem : 0x0094: CONSTRUCTOR  (r17v0 com.coolapk.market.view.block.BlockItem) = 
      (null java.lang.String)
      (r9v1 java.lang.String)
      (r10v4 java.lang.String)
      (r11v0 java.lang.String)
      false
      (null java.lang.String)
      ("node")
      (49 int)
      (null kotlin.jvm.internal.DefaultConstructorMarker)
     call: com.coolapk.market.view.block.BlockItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void type: CONSTRUCTOR)
     */
    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        String str = "";
        if (itemId == 2131361876) {
            Topic model = getViewModel().getModel();
            AddBlockDialog addBlockDialog = AddBlockDialog.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            BlockItem[] blockItemArr = new BlockItem[1];
            StringBuilder sb = new StringBuilder();
            sb.append('#');
            String title = model.getTitle();
            if (title == null) {
                title = str;
            }
            sb.append(title);
            sb.append('#');
            String sb2 = sb.toString();
            String str2 = "[话题] " + model.getTitle();
            String logo = model.getLogo();
            blockItemArr[0] = new BlockItem(null, sb2, str2, logo != null ? logo : str, false, null, "node", 49, null);
            addBlockDialog.showBlockNodeDialog(fragmentActivity, CollectionsKt.mutableListOf(blockItemArr));
        } else if (itemId == 2131361961) {
            FragmentActivity activity = getActivity();
            String title2 = getViewModel().getModel().getTitle();
            if (title2 != null) {
                str = title2;
            }
            ActionManager.startSceneSearchActivity(activity, "tag", str);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onFloatingButtonAction(float f) {
        NodeHelper nodeHelper = NodeHelper.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        nodeHelper.showTopicFabView(requireActivity, getViewModel().getModel(), f);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public Entity getData() {
        return getViewModel().getModel();
    }

    private final void installTopicContent(Topic topic) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        TopicNodeHeaderViewPart topicNodeHeaderViewPart = new TopicNodeHeaderViewPart(requireActivity, getViewModel(), getPresenter());
        LayoutInflater from = LayoutInflater.from(getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        topicNodeHeaderViewPart.createView(from, null);
        topicNodeHeaderViewPart.bindToContent(topic);
        topicNodeHeaderViewPart.loadLogoAndBG(topic, new TopicNodeFragment$installTopicContent$1(this));
        getBehavior().installBackgroundView(topicNodeHeaderViewPart.getView());
        topicNodeHeaderViewPart.getView().requestApplyInsets();
        this.headerViewPart = topicNodeHeaderViewPart;
        List<ConfigPage> tabApiList = topic.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList, "model.tabApiList");
        Iterator<ConfigPage> it2 = tabApiList.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            }
            ConfigPage next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "it");
            if (Intrinsics.areEqual(next.getPageName(), topic.getSelectedTab())) {
                break;
            }
            i++;
        }
        NodeActivityBehavior behavior = getBehavior();
        AppHolder.getMainThreadHandler().post(new TopicNodeFragment$installTopicContent$2(this, behavior, topic, i));
        List<ConfigPage> tabApiList2 = topic.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList2, "model.tabApiList");
        int i2 = 0;
        for (T t : tabApiList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity2).getSupportFragmentManager();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(t2, "configPage");
            sb.append(t2.getTitle());
            sb.append('_');
            sb.append(i2);
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(sb.toString());
            if (findFragmentByTag instanceof TopicNodeDataListFragment) {
                TopicNodeDataListFragment topicNodeDataListFragment = (TopicNodeDataListFragment) findFragmentByTag;
                topicNodeDataListFragment.setViewModel$presentation_coolapkAppRelease(getViewModel());
                topicNodeDataListFragment.setPresenter$presentation_coolapkAppRelease(getPresenter());
            }
            i2 = i3;
        }
        behavior.installToolbarContentView(createToolbarContentView(topic));
        updateFollowState();
        String cover = topic.getCover();
        if (cover == null || cover.length() == 0) {
            z = true;
        }
        if (!z) {
            behavior.setToolbarAlphaScrollYStartThreshold(NumberExtendsKt.getDp((Number) 239));
        }
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final View createToolbarContentView(Topic topic) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559117, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…bar_content, null, false)");
        ProductNodeToolbarContentBinding productNodeToolbarContentBinding = (ProductNodeToolbarContentBinding) inflate;
        this.toolbarBinding = productNodeToolbarContentBinding;
        TextView textView = productNodeToolbarContentBinding.toolbarNameView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.toolbarNameView");
        textView.setText(topic.getTitle());
        TextView textView2 = productNodeToolbarContentBinding.toolbarActionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.toolbarActionView");
        ShapeExtends shapeExtends = ShapeExtends.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        textView2.setBackground(shapeExtends.createNodeCapsuleActionBackground(requireActivity, (float) NumberExtendsKt.getDp((Number) 14)));
        TextView textView3 = productNodeToolbarContentBinding.toolbarActionView;
        ShapeExtends shapeExtends2 = ShapeExtends.INSTANCE;
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        textView3.setTextColor(shapeExtends2.createNodeActionTextColors(requireActivity2));
        productNodeToolbarContentBinding.toolbarActionView.setOnClickListener(new TopicNodeFragment$createToolbarContentView$1(this));
        TextView textView4 = productNodeToolbarContentBinding.subtitleView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.subtitleView");
        textView4.setText(KotlinExtendKt.toDisplayString(topic.getHotNum()) + " 热度");
        TextView textView5 = productNodeToolbarContentBinding.subtitleView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.subtitleView");
        textView5.setVisibility(0);
        GlideApp.with(productNodeToolbarContentBinding.toolbarUserAvatarView).load(topic.getLogo()).placeholder(2131231628).diskCacheStrategy(DiskCacheStrategy.DATA).into(productNodeToolbarContentBinding.toolbarUserAvatarView);
        View root = productNodeToolbarContentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = NumberExtendsKt.getDp((Number) 60);
        layoutParams.rightMargin = NumberExtendsKt.getDp((Number) 60);
        Unit unit = Unit.INSTANCE;
        root.setLayoutParams(layoutParams);
        View root2 = productNodeToolbarContentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    /* access modifiers changed from: private */
    public final void updateFollowState() {
        TopicVXViewModel viewModel2;
        ProductNodeToolbarContentBinding productNodeToolbarContentBinding = this.toolbarBinding;
        if (productNodeToolbarContentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarBinding");
        }
        if (productNodeToolbarContentBinding != null && (viewModel2 = getViewModel()) != null) {
            boolean followState = viewModel2.getFollowState();
            TextView textView = productNodeToolbarContentBinding.toolbarActionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.toolbarActionView");
            textView.setSelected(followState);
            if (followState) {
                productNodeToolbarContentBinding.toolbarActionView.setText(2131887204);
            } else {
                productNodeToolbarContentBinding.toolbarActionView.setText(2131887205);
            }
        }
    }

    public final void onFollowStateChanged(boolean z, boolean z2, Throwable th) {
        TopicVXViewModel viewModel2 = getViewModel();
        if (viewModel2 == null) {
            return;
        }
        if (th == null) {
            viewModel2.setFollowState(z2);
            EventBus eventBus = EventBus.getDefault();
            String id = viewModel2.getModel().getId();
            if (id == null) {
                id = "";
            }
            eventBus.post(new EntityFollowEvent(id, "topic", z2));
            return;
        }
        viewModel2.setFollowState(z);
        Toast.error(getActivity(), th);
    }
}
