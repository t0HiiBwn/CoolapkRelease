package com.coolapk.market.view.node.prodcut;

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
import android.widget.LinearLayout;
import android.widget.RatingBar;
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
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.OtherPostEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.Product;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.block.AddBlockDialog;
import com.coolapk.market.view.block.BlockItem;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.node.NodeActivityBehavior;
import com.coolapk.market.view.node.NodeFeedDialogInterceptor;
import com.coolapk.market.view.node.NodeFragmentBehavior;
import com.coolapk.market.view.node.rating.NodeRatingDeleteEvent;
import com.coolapk.market.view.product.ProductDataListFragment;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.view.product.ProductPostView;
import com.coolapk.market.view.product.ProductPresenter;
import com.coolapk.market.view.product.ProductView;
import com.coolapk.market.view.product.ProductViewModel;
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
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0007J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0016J\"\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u0010*\u001a\u000206H\u0007J\u0010\u00107\u001a\u0002012\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010*\u001a\u00020;H\u0007J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u0014H\u0016J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001bH\u0016J\"\u0010@\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010A\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020\u0018H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductNodeFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/node/NodeFragmentBehavior;", "Lcom/coolapk/market/view/product/ProductView;", "()V", "behavior", "Lcom/coolapk/market/view/node/NodeActivityBehavior;", "getBehavior", "()Lcom/coolapk/market/view/node/NodeActivityBehavior;", "headerViewPart", "Lcom/coolapk/market/view/node/prodcut/ProductNodeHeaderViewPart;", "presenter", "Lcom/coolapk/market/view/product/ProductPresenter;", "toolbarBinding", "Lcom/coolapk/market/databinding/ProductNodeToolbarContentBinding;", "viewModel", "Lcom/coolapk/market/view/product/ProductViewModel;", "createToolbarContentView", "Landroid/view/View;", "data", "Lcom/coolapk/market/model/Product;", "getData", "Lcom/coolapk/market/model/Entity;", "installTopicContent", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onApplyWindowsInset", "inset", "Landroid/graphics/Rect;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFeedPostEvent", "event", "Lcom/coolapk/market/event/FeedPostEvent;", "onFloatingButtonAction", "translationY", "", "onFollowStateChanged", "oldValue", "", "newValue", "error", "", "onNodeRatingDeleteEvent", "Lcom/coolapk/market/view/node/rating/NodeRatingDeleteEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onOtherPostEvent", "Lcom/coolapk/market/event/OtherPostEvent;", "onProductChanged", "product", "onSaveInstanceState", "outState", "onWishStateChanged", "showPostFloatView", "updateFollowState", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductNodeFragment.kt */
public final class ProductNodeFragment extends BaseFragment implements NodeFragmentBehavior, ProductView {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_MODEL = "MODEL";
    private ProductNodeHeaderViewPart headerViewPart;
    private ProductPresenter presenter;
    private ProductNodeToolbarContentBinding toolbarBinding;
    private ProductViewModel viewModel;

    @Override // com.coolapk.market.view.product.ProductView
    public void onProductChanged(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
    }

    public static final /* synthetic */ ProductPresenter access$getPresenter$p(ProductNodeFragment productNodeFragment) {
        ProductPresenter productPresenter = productNodeFragment.presenter;
        if (productPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return productPresenter;
    }

    public static final /* synthetic */ ProductViewModel access$getViewModel$p(ProductNodeFragment productNodeFragment) {
        ProductViewModel productViewModel = productNodeFragment.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return productViewModel;
    }

    /* access modifiers changed from: private */
    public final NodeActivityBehavior getBehavior() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.node.NodeActivityBehavior");
        return (NodeActivityBehavior) activity;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/node/prodcut/ProductNodeFragment$Companion;", "", "()V", "KEY_MODEL", "", "newInstance", "Lcom/coolapk/market/view/node/prodcut/ProductNodeFragment;", "model", "Lcom/coolapk/market/model/Product;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductNodeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductNodeFragment newInstance(Product product) {
            Intrinsics.checkNotNullParameter(product, "model");
            ProductNodeFragment productNodeFragment = new ProductNodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MODEL", product);
            Unit unit = Unit.INSTANCE;
            productNodeFragment.setArguments(bundle);
            return productNodeFragment;
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatisticHelper.Companion.getInstance().recordNodeClickAction("数码");
        setHasOptionsMenu(true);
        Parcelable parcelable = requireArguments().getParcelable("MODEL");
        if (parcelable != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ProductViewModel productViewModel = new ProductViewModel(requireActivity, (Product) parcelable);
            this.viewModel = productViewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            productViewModel.onInitSavedInstanceState(bundle);
            this.presenter = new ProductPresenter(this);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productViewModel.onSaveInstanceState(bundle);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onApplyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        ProductNodeHeaderViewPart productNodeHeaderViewPart = this.headerViewPart;
        if (productNodeHeaderViewPart != null) {
            productNodeHeaderViewPart.applyWindowsInset(rect);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return new Space(layoutInflater.getContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Product model = productViewModel.getModel();
        installTopicContent(model);
        ProductViewModel productViewModel2 = this.viewModel;
        if (productViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (productViewModel2 != null) {
            productViewModel2.addOnPropertyChangedCallback(new ProductNodeFragment$onActivityCreated$1(this));
            EventBus eventBus = EventBus.getDefault();
            Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
            EventBusExtendsKt.safeRegister(eventBus, this);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new ProductNodeFragment$onActivityCreated$2(this));
            if (UserPermissionChecker.INSTANCE.isLoginAdmin()) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                FragmentActivity fragmentActivity = requireActivity;
                List<String> topIds = productViewModel2.getTopIds();
                String id = model.getId();
                if (id == null) {
                    id = "";
                }
                NodeFeedDialogInterceptor nodeFeedDialogInterceptor = new NodeFeedDialogInterceptor(fragmentActivity, topIds, "product", id, false, 16, null);
                SheetGroupModifierManager.INSTANCE.addModifier(nodeFeedDialogInterceptor);
                Lifecycle lifecycle2 = getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle2, "lifecycle");
                LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle2, new ProductNodeFragment$onActivityCreated$3(nodeFeedDialogInterceptor));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Subscribe
    public final void onFeedPostEvent(FeedPostEvent feedPostEvent) {
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        Feed feed = feedPostEvent.getFeed();
        if (Intrinsics.areEqual(feed.getFeedType(), "rating")) {
            String boundProductID = EntityExtendsKt.getBoundProductID(feed);
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(boundProductID, productViewModel.getModel().getId())) {
                ProductViewModel productViewModel2 = this.viewModel;
                if (productViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                productViewModel2.setRatingScore(feed.getStar());
                ProductViewModel productViewModel3 = this.viewModel;
                if (productViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                String url = feed.getUrl();
                if (url == null) {
                    url = "";
                }
                productViewModel3.setRatingFeedUrl(url);
                FeedMultiPart multiPart = feedPostEvent.getMultiPart();
                if (multiPart != null) {
                    boolean buyStatus = multiPart.buyStatus();
                    ProductViewModel productViewModel4 = this.viewModel;
                    if (productViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    productViewModel4.setBuyStatus(buyStatus);
                }
            }
        }
    }

    @Subscribe
    public final void onOtherPostEvent(OtherPostEvent otherPostEvent) {
        Intrinsics.checkNotNullParameter(otherPostEvent, "event");
        Entity entity = otherPostEvent.getEntity();
        if (!(entity instanceof NodeRating)) {
            entity = null;
        }
        NodeRating nodeRating = (NodeRating) entity;
        if (nodeRating != null) {
            String targetId = nodeRating.getTargetId();
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(targetId, productViewModel.getModel().getId()) && Intrinsics.areEqual(nodeRating.getTargetType(), "7")) {
                ProductViewModel productViewModel2 = this.viewModel;
                if (productViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                productViewModel2.setRatingScore(nodeRating.getStar());
                ProductViewModel productViewModel3 = this.viewModel;
                if (productViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                String url = nodeRating.getUrl();
                if (url == null) {
                    url = "";
                }
                productViewModel3.setRatingFeedUrl(url);
                FeedMultiPart multiPart = otherPostEvent.getMultiPart();
                if (multiPart != null) {
                    boolean buyStatus = multiPart.buyStatus();
                    ProductViewModel productViewModel4 = this.viewModel;
                    if (productViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    productViewModel4.setBuyStatus(buyStatus);
                }
            }
        }
    }

    @Subscribe
    public final void onNodeRatingDeleteEvent(NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        Intrinsics.checkNotNullParameter(nodeRatingDeleteEvent, "event");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "loginSession");
        if (loginSession.isLogin() && !(!Intrinsics.areEqual(nodeRatingDeleteEvent.getUid(), loginSession.getUid()))) {
            String targetId = nodeRatingDeleteEvent.getTargetId();
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(targetId, productViewModel.getModel().getId()) && Intrinsics.areEqual(nodeRatingDeleteEvent.getTargetType(), "7")) {
                ProductViewModel productViewModel2 = this.viewModel;
                if (productViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                productViewModel2.setRatingScore(0);
                ProductViewModel productViewModel3 = this.viewModel;
                if (productViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                productViewModel3.setRatingFeedUrl("");
            }
        }
    }

    @Override // com.coolapk.market.view.product.ProductView
    public void onFollowStateChanged(boolean z, boolean z2, Throwable th) {
        if (th == null) {
            EventBus eventBus = EventBus.getDefault();
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String id = productViewModel.getModel().getId();
            if (id == null) {
                id = "";
            }
            eventBus.post(new EntityFollowEvent(id, "product", z2));
            ProductViewModel productViewModel2 = this.viewModel;
            if (productViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            productViewModel2.setFollowState(z2);
            return;
        }
        ProductViewModel productViewModel3 = this.viewModel;
        if (productViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productViewModel3.setFollowState(z);
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.product.ProductView
    public void onWishStateChanged(boolean z, boolean z2, Throwable th) {
        if (th == null) {
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            productViewModel.setWishState(z2);
            return;
        }
        ProductViewModel productViewModel2 = this.viewModel;
        if (productViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productViewModel2.setWishState(z);
        Toast.error(getActivity(), th);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        MenuItem add = menu.add(0, 2131361961, 0, getString(2131886450));
        add.setIcon(2131231545);
        add.setShowAsAction(2);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00cd: APUT  
      (r4v1 com.coolapk.market.view.block.BlockItem[])
      (0 ??[int, short, byte, char])
      (wrap: com.coolapk.market.view.block.BlockItem : 0x00ca: CONSTRUCTOR  (r7v1 com.coolapk.market.view.block.BlockItem) = 
      (r12v0 java.lang.String)
      (r13v0 java.lang.String)
      (r14v0 java.lang.String)
      (r15v0 java.lang.String)
      false
      (null java.lang.String)
      ("node")
      (48 int)
      (null kotlin.jvm.internal.DefaultConstructorMarker)
     call: com.coolapk.market.view.block.BlockItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void type: CONSTRUCTOR)
     */
    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361876) {
            ProductViewModel productViewModel = this.viewModel;
            if (productViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Product model = productViewModel.getModel();
            String id = model.getId();
            if (id == null) {
                id = "";
            }
            AddBlockDialog addBlockDialog = AddBlockDialog.INSTANCE;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            BlockItem[] blockItemArr = new BlockItem[1];
            String valueOf = String.valueOf(Long.parseLong(id) + 7000000000L);
            String title = model.getTitle();
            if (title != null) {
                str = title;
            } else {
                str = "";
            }
            String str3 = "[数码] " + model.getTitle();
            String logo = model.getLogo();
            if (logo != null) {
                str2 = logo;
            } else {
                str2 = "";
            }
            blockItemArr[0] = new BlockItem(valueOf, str, str3, str2, false, null, "node", 48, null);
            addBlockDialog.showBlockNodeDialog(fragmentActivity, CollectionsKt.mutableListOf(blockItemArr));
        } else if (itemId == 2131361934) {
            ProductViewModel productViewModel2 = this.viewModel;
            if (productViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ActionManager.startProductMediaTabActivity(getActivity(), productViewModel2.getModel().getId(), "待选产品图/视频", false, 0);
            return true;
        } else if (itemId == 2131361961) {
            StatisticHelper.Companion.getInstance().recordPhoneBarAction("点搜索");
            FragmentActivity activity = getActivity();
            ProductViewModel productViewModel3 = this.viewModel;
            if (productViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            ActionManager.startSceneSearchActivity(activity, "product_phone", productViewModel3.getModel().getId());
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onFloatingButtonAction(float f) {
        showPostFloatView(f);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public Entity getData() {
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return productViewModel.getModel();
    }

    private final void installTopicContent(Product product) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FragmentActivity fragmentActivity = requireActivity;
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ProductPresenter productPresenter = this.presenter;
        if (productPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ProductNodeHeaderViewPart productNodeHeaderViewPart = new ProductNodeHeaderViewPart(fragmentActivity, productViewModel, productPresenter);
        LayoutInflater from = LayoutInflater.from(getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        productNodeHeaderViewPart.createView(from, null);
        productNodeHeaderViewPart.bindToContent(product);
        productNodeHeaderViewPart.loadLogoAndBG(product, new ProductNodeFragment$installTopicContent$1(this));
        getBehavior().installBackgroundView(productNodeHeaderViewPart.getView());
        this.headerViewPart = productNodeHeaderViewPart;
        productNodeHeaderViewPart.getView().requestApplyInsets();
        List<ConfigPage> tabApiList = product.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList, "data.tabApiList");
        Iterator<ConfigPage> it2 = tabApiList.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            }
            ConfigPage next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "it");
            if (Intrinsics.areEqual(next.getPageName(), product.getSelectedTab())) {
                break;
            }
            i2++;
        }
        NodeActivityBehavior behavior = getBehavior();
        AppHolder.getMainThreadHandler().post(new ProductNodeFragment$installTopicContent$2(this, behavior, product, i2));
        List<ConfigPage> tabApiList2 = product.getTabApiList();
        Intrinsics.checkNotNullExpressionValue(tabApiList2, "data.tabApiList");
        for (T t : tabApiList2) {
            int i3 = i + 1;
            if (i < 0) {
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
            sb.append(i);
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(sb.toString());
            if (findFragmentByTag instanceof ProductDataListFragment) {
                ProductDataListFragment productDataListFragment = (ProductDataListFragment) findFragmentByTag;
                ProductViewModel productViewModel2 = this.viewModel;
                if (productViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                productDataListFragment.setViewModel$presentation_coolapkAppRelease(productViewModel2);
                ProductPresenter productPresenter2 = this.presenter;
                if (productPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                productDataListFragment.setPresenter$presentation_coolapkAppRelease(productPresenter2);
            }
            i = i3;
        }
        behavior.installToolbarContentView(createToolbarContentView(product));
        updateFollowState();
        List<String> coverPicList = product.getCoverPicList();
        Intrinsics.checkNotNullExpressionValue(coverPicList, "data.coverPicList");
        if (!coverPicList.isEmpty()) {
            behavior.setToolbarAlphaScrollYStartThreshold(NumberExtendsKt.getDp((Number) 239));
        }
    }

    /* access modifiers changed from: private */
    public final void updateFollowState() {
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (productViewModel != null) {
            ProductNodeToolbarContentBinding productNodeToolbarContentBinding = this.toolbarBinding;
            if (productNodeToolbarContentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarBinding");
            }
            if (productNodeToolbarContentBinding != null) {
                boolean followState = productViewModel.getFollowState();
                TextView textView = productNodeToolbarContentBinding.toolbarActionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.toolbarActionView");
                textView.setSelected(followState);
                if (followState) {
                    productNodeToolbarContentBinding.toolbarActionView.setText(2131887204);
                } else {
                    productNodeToolbarContentBinding.toolbarActionView.setText(2131887205);
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* JADX WARN: Type inference failed for: r10v6, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final View createToolbarContentView(Product product) {
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (productViewModel != null) {
            ProductPresenter productPresenter = this.presenter;
            if (productPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (productPresenter != null) {
                ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559117, null, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…bar_content, null, false)");
                ProductNodeToolbarContentBinding productNodeToolbarContentBinding = (ProductNodeToolbarContentBinding) inflate;
                this.toolbarBinding = productNodeToolbarContentBinding;
                TextView textView = productNodeToolbarContentBinding.toolbarActionView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.toolbarActionView");
                ShapeExtends shapeExtends = ShapeExtends.INSTANCE;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                textView.setBackground(shapeExtends.createNodeCapsuleActionBackground(requireActivity, (float) NumberExtendsKt.getDp((Number) 14)));
                TextView textView2 = productNodeToolbarContentBinding.toolbarActionView;
                ShapeExtends shapeExtends2 = ShapeExtends.INSTANCE;
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                textView2.setTextColor(shapeExtends2.createNodeActionTextColors(requireActivity2));
                TextView textView3 = productNodeToolbarContentBinding.toolbarNameView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.toolbarNameView");
                textView3.setText(product.getTitle());
                productNodeToolbarContentBinding.toolbarActionView.setOnClickListener(new ProductNodeFragment$createToolbarContentView$1(productPresenter, product, productViewModel));
                RatingBar ratingBar = productNodeToolbarContentBinding.ratingBar;
                Intrinsics.checkNotNullExpressionValue(ratingBar, "binding.ratingBar");
                ratingBar.setRating(ProductGlobalData.INSTANCE.ratingScoreToStartScore(EntityExtendsKt.getPreferRatingScore(product)));
                TextView textView4 = productNodeToolbarContentBinding.scoreView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.scoreView");
                textView4.setText(KotlinExtendKt.toDisplayScore(EntityExtendsKt.getPreferRatingScore(product)));
                LinearLayout linearLayout = productNodeToolbarContentBinding.scoreViewContainer;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.scoreViewContainer");
                linearLayout.setVisibility(0);
                GlideApp.with(productNodeToolbarContentBinding.toolbarUserAvatarView).load(product.getLogo()).placeholder(2131231374).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(productNodeToolbarContentBinding.toolbarUserAvatarView);
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
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void showPostFloatView(float f) {
        FrameLayout contentView = UiUtils.getContentView(getActivity());
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ProductPostView productPostView = new ProductPostView(requireActivity);
        productPostView.setElevation((float) NumberExtendsKt.getDp((Number) 3));
        ProductViewModel productViewModel = this.viewModel;
        if (productViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productPostView.setViewModel(productViewModel);
        ProductPresenter productPresenter = this.presenter;
        if (productPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        productPostView.setPresenter(productPresenter);
        productPostView.setExtraStartPaddingBottom(-((int) f));
        contentView.addView(productPostView, -1, -1);
        productPostView.showWithAnimator();
    }
}
