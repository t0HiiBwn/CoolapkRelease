package com.coolapk.market.view.node.app;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.event.FeedPostEvent;
import com.coolapk.market.event.OtherPostEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.ConfigPage;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.NodeRating;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.feed.dialog.SheetGroupModifierManager;
import com.coolapk.market.view.node.BaseNodePageActivity;
import com.coolapk.market.view.node.NodeFeedDialogInterceptor;
import com.coolapk.market.view.node.NodeFragmentBehavior;
import com.coolapk.market.view.node.rating.NodeRatingDeleteEvent;
import com.coolapk.market.view.user.EntityFollowEvent;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000é\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0014\u0010'\u001a\u00020#2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\"\u00102\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\b\u0010%\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020#H\u0016J2\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020KH\u0007J\u0010\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020NH\u0016J>\u0010O\u001a\u00020#2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u001a\u0010E\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0P\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010Q\u001a\u00020#2\u0006\u0010J\u001a\u00020RH\u0007J\u0010\u0010S\u001a\u00020C2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020#2\u0006\u0010J\u001a\u00020WH\u0007J>\u0010X\u001a\u00020#2\u0006\u0010D\u001a\u0002042\u0006\u0010B\u001a\u0002042\u001a\u0010E\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0P\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J6\u0010Y\u001a\u00020#2\u0006\u0010B\u001a\u0002042\u001a\u0010E\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0P\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J8\u0010Z\u001a\u0004\u0018\u0001H[\"\u0004\b\u0000\u0010[2!\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b^\u0012\b\b_\u0012\u0004\b\b(`\u0012\u0004\u0012\u0002H[0]H\u0002¢\u0006\u0002\u0010aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00108BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 ¨\u0006c"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "Lcom/coolapk/market/view/node/NodeFragmentBehavior;", "Lcom/coolapk/market/view/node/app/AppNodeView;", "()V", "appNodeToolbar", "Lcom/coolapk/market/view/node/app/AppNodeToolbar;", "configList", "", "Lkotlin/Pair;", "", "getConfigList", "()Ljava/util/List;", "configList$delegate", "Lkotlin/Lazy;", "headerViewPart", "Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "Landroidx/databinding/ViewDataBinding;", "getHeaderViewPart", "()Lcom/coolapk/market/view/node/app/BaseAppNodeViewPart;", "headerViewPart$delegate", "presenter", "Lcom/coolapk/market/view/node/app/AppNodePresenter;", "getPresenter", "()Lcom/coolapk/market/view/node/app/AppNodePresenter;", "presenter$delegate", "stateEventChangedAdapter", "com/coolapk/market/view/node/app/AppNodeFragment$stateEventChangedAdapter$1", "Lcom/coolapk/market/view/node/app/AppNodeFragment$stateEventChangedAdapter$1;", "viewModel", "Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "getViewModel", "()Lcom/coolapk/market/view/node/app/AppNodeViewModel;", "viewModel$delegate", "checkAction", "", "checkAppUpdate", "data", "Lcom/coolapk/market/model/ServiceApp;", "doActionFunction", "clickListener", "Lcom/coolapk/market/model/ClickInfo$ClickHandleListener;", "getData", "Lcom/coolapk/market/model/Entity;", "getNodeActivity", "Lcom/coolapk/market/view/node/BaseNodePageActivity;", "installTopicContent", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "Landroid/content/Intent;", "onApplyWindowsInset", "inset", "Landroid/graphics/Rect;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDestroy", "onFavoriteAppComplete", "oldValue", "", "newValue", "result", "Lcom/coolapk/market/network/Result;", "error", "", "onFeedPostEvent", "event", "Lcom/coolapk/market/event/FeedPostEvent;", "onFloatingButtonAction", "translationY", "", "onFollowAppComplete", "", "onNodeRatingDeleteEvent", "Lcom/coolapk/market/view/node/rating/NodeRatingDeleteEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onOtherPostEvent", "Lcom/coolapk/market/event/OtherPostEvent;", "onRatingComplete", "onUnratingComplete", "runIfAppExist", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "app", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppNodeFragment.kt */
public final class AppNodeFragment extends BaseFragment implements NodeFragmentBehavior, AppNodeView {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_APP = "APP";
    private static final String URL_APK_DETAIL = "#/apk/detail";
    private final AppNodeToolbar appNodeToolbar = new AppNodeToolbar();
    private final Lazy configList$delegate = LazyKt.lazy(new AppNodeFragment$configList$2(this));
    private final Lazy headerViewPart$delegate = LazyKt.lazy(new AppNodeFragment$headerViewPart$2(this));
    private final Lazy presenter$delegate = LazyKt.lazy(new AppNodeFragment$presenter$2(this));
    private AppNodeFragment$stateEventChangedAdapter$1 stateEventChangedAdapter = new AppNodeFragment$stateEventChangedAdapter$1(this);
    private final Lazy viewModel$delegate = LazyKt.lazy(new AppNodeFragment$viewModel$2(this));

    /* access modifiers changed from: private */
    public final List<Pair<String, String>> getConfigList() {
        return (List) this.configList$delegate.getValue();
    }

    private final BaseAppNodeViewPart<? extends ViewDataBinding> getHeaderViewPart() {
        return (BaseAppNodeViewPart) this.headerViewPart$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AppNodePresenter getPresenter() {
        return (AppNodePresenter) this.presenter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AppNodeViewModel getViewModel() {
        return (AppNodeViewModel) this.viewModel$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/node/app/AppNodeFragment$Companion;", "", "()V", "KEY_APP", "", "URL_APK_DETAIL", "newInstance", "Lcom/coolapk/market/view/node/app/AppNodeFragment;", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppNodeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppNodeFragment newInstance(ServiceApp serviceApp) {
            Intrinsics.checkNotNullParameter(serviceApp, "serviceApp");
            AppNodeFragment appNodeFragment = new AppNodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APP", serviceApp);
            Unit unit = Unit.INSTANCE;
            appNodeFragment.setArguments(bundle);
            return appNodeFragment;
        }
    }

    @Override // com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        List<ConfigPage> tabApiList;
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        StatisticHelper.Companion.getInstance().recordNodeClickAction("应用");
        Parcelable parcelable = requireArguments().getParcelable("APP");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "requireArguments().getPa…le<ServiceApp>(KEY_APP)!!");
        ServiceApp serviceApp = (ServiceApp) parcelable;
        getViewModel().updateServiceApp(serviceApp);
        getViewModel().getServiceApp().addOnPropertyChangedCallback(new AppNodeFragment$onCreate$1(this));
        if (!(bundle == null || (tabApiList = serviceApp.getTabApiList()) == null)) {
            int i = 0;
            for (T t : tabApiList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(requireActivity).getSupportFragmentManager();
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(t2, "configPage");
                sb.append(t2.getTitle());
                sb.append('_');
                sb.append(i);
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(sb.toString());
                if (findFragmentByTag instanceof AppNodeListFragment) {
                    AppNodeListFragment appNodeListFragment = (AppNodeListFragment) findFragmentByTag;
                    appNodeListFragment.setViewModel(getViewModel());
                    appNodeListFragment.setPresenter(getPresenter());
                }
                i = i2;
            }
        }
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0089, code lost:
        if (r10 != null) goto L_0x0093;
     */
    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList arrayList;
        List<String> topIds;
        super.onActivityCreated(bundle);
        ServiceApp serviceApp = getViewModel().getServiceApp().get();
        Intrinsics.checkNotNull(serviceApp);
        Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get()!!");
        ServiceApp serviceApp2 = serviceApp;
        installTopicContent(serviceApp2);
        this.stateEventChangedAdapter.onAttach();
        checkAppUpdate(serviceApp2);
        checkAction();
        if (UserPermissionChecker.INSTANCE.isLoginAdmin()) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            FragmentActivity fragmentActivity = requireActivity;
            ServiceApp serviceApp3 = getViewModel().getServiceApp().get();
            if (!(serviceApp3 == null || (topIds = serviceApp3.getTopIds()) == null)) {
                ArrayList arrayList2 = new ArrayList();
                for (T t : topIds) {
                    T t2 = t;
                    Intrinsics.checkNotNullExpressionValue(t2, "it");
                    if (t2.length() > 0) {
                        arrayList2.add(t);
                    }
                }
                arrayList = CollectionsKt.toMutableList((Collection) arrayList2);
            }
            arrayList = new ArrayList();
            ServiceApp serviceApp4 = getViewModel().getServiceApp().get();
            String id = serviceApp4 != null ? serviceApp4.getId() : null;
            if (id == null) {
                id = "";
            }
            NodeFeedDialogInterceptor nodeFeedDialogInterceptor = new NodeFeedDialogInterceptor(fragmentActivity, arrayList, "apk", id, false, 16, null);
            SheetGroupModifierManager.INSTANCE.addModifier(nodeFeedDialogInterceptor);
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new AppNodeFragment$onActivityCreated$1(nodeFeedDialogInterceptor));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
        this.stateEventChangedAdapter.onDetach();
        super.onDestroy();
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onApplyWindowsInset(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "inset");
        getHeaderViewPart().applyWindowsInset(rect);
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public void onFloatingButtonAction(float f) {
        runIfAppExist(new AppNodeFragment$onFloatingButtonAction$1(this, f));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        menuInflater.inflate(2131623940, menu);
        ServiceApp serviceApp = getViewModel().getServiceApp().get();
        MenuItem findItem = menu.findItem(2131361961);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_search)");
        boolean z = true;
        findItem.setVisible(serviceApp != null);
        MobileApp mobileAppExistFast = serviceApp != null ? DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName()) : null;
        MenuItem findItem2 = menu.findItem(2131361939);
        Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.action_open)");
        findItem2.setVisible(mobileAppExistFast != null);
        MenuItem findItem3 = menu.findItem(2131361981);
        Intrinsics.checkNotNullExpressionValue(findItem3, "menu.findItem(R.id.action_uninstall)");
        findItem3.setVisible(mobileAppExistFast != null);
        MenuItem findItem4 = menu.findItem(2131361859);
        Intrinsics.checkNotNullExpressionValue(findItem4, "menu.findItem(R.id.action_apk_manage)");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        findItem4.setVisible(loginSession.isAdmin());
        menu.findItem(2131361905).setTitle(getViewModel().isFavor().get() ? 2131886113 : 2131886131);
        MenuItem findItem5 = menu.findItem(2131361933);
        Intrinsics.checkNotNullExpressionValue(findItem5, "menu.findItem(R.id.action_more_item)");
        if (serviceApp == null) {
            z = false;
        }
        findItem5.setVisible(z);
        AppMetadataKt.runOnAppMode$default(this, null, new AppNodeFragment$onCreateOptionsMenu$1(menu), null, new AppNodeFragment$onCreateOptionsMenu$2(serviceApp, menu), 5, null);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131361855:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$11(this));
                break;
            case 2131361859:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$9(this));
                break;
            case 2131361862:
                doActionFunction$default(this, null, 1, null);
                break;
            case 2131361876:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$13(this));
                break;
            case 2131361889:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$3(this));
                break;
            case 2131361901:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$6(this));
                break;
            case 2131361905:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$10(this, this));
                break;
            case 2131361913:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$12(this));
                break;
            case 2131361939:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$4(this));
                break;
            case 2131361941:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$5(this));
                break;
            case 2131361958:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$8(this));
                break;
            case 2131361961:
                ServiceApp serviceApp = getViewModel().getServiceApp().get();
                if (serviceApp != null) {
                    Intrinsics.checkNotNullExpressionValue(serviceApp, "it");
                    ActionManager.startSceneSearchActivity(getActivity(), "apk", serviceApp.getApkId());
                    break;
                }
                break;
            case 2131361969:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$2(this));
                break;
            case 2131361981:
                runIfAppExist(new AppNodeFragment$onOptionsItemSelected$7(this));
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // com.coolapk.market.view.node.NodeFragmentBehavior
    public Entity getData() {
        return getViewModel().getServiceApp().get();
    }

    private final void installTopicContent(ServiceApp serviceApp) {
        BaseAppNodeViewPart<? extends ViewDataBinding> headerViewPart = getHeaderViewPart();
        LayoutInflater from = LayoutInflater.from(getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(activity)");
        headerViewPart.createView(from, null);
        getHeaderViewPart().bindToContent(serviceApp);
        getHeaderViewPart().loadLogoAndBG(serviceApp, new AppNodeFragment$installTopicContent$1(this));
        getNodeActivity().installBackgroundView(getHeaderViewPart().getView());
        getHeaderViewPart().getView().requestApplyInsets();
        List<ConfigPage> tabApiList = serviceApp.getTabApiList();
        if (tabApiList == null) {
            tabApiList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(tabApiList);
        if (arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(TuplesKt.to("详情", "#/apk/detail"));
            ArrayList<Pair> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (Pair pair : arrayList3) {
                arrayList4.add(ConfigPage.newBuilder().url((String) pair.getSecond()).title((String) pair.getFirst()).entityType("page").rawEntities(CollectionsKt.emptyList()).build());
            }
            arrayList.addAll(arrayList4);
        }
        AppHolder.getMainThreadHandler().post(new AppNodeFragment$installTopicContent$3(this, serviceApp, arrayList, getNodeActivity()));
        BaseNodePageActivity nodeActivity = getNodeActivity();
        AppNodeToolbar appNodeToolbar2 = this.appNodeToolbar;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        nodeActivity.installToolbarContentView(appNodeToolbar2.init(requireActivity, getViewModel(), getPresenter(), serviceApp));
        String cover = serviceApp.getCover();
        if (cover == null || cover.length() == 0) {
            getNodeActivity().setToolbarAlphaScrollYStartThreshold(NumberExtendsKt.getDp((Number) 115));
        } else {
            getNodeActivity().setToolbarAlphaScrollYStartThreshold(NumberExtendsKt.getDp((Number) 238));
        }
    }

    private final void checkAppUpdate(ServiceApp serviceApp) {
        MobileApp mobileAppExistFast;
        if (!AppHolder.getAppMetadata().isCommunityMode() && (mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName())) != null && mobileAppExistFast.isExist()) {
            ActionManager.startCheckMobileAppForUpgrade(getActivity(), serviceApp.getPackageName());
        }
    }

    private final void checkAction() {
        List<Pair<String, String>> configList = getConfigList();
        String findValueFromUrlClientConfig = configList != null ? EntityExtendsKt.findValueFromUrlClientConfig(configList, "action") : null;
        if (findValueFromUrlClientConfig != null) {
            int hashCode = findValueFromUrlClientConfig.hashCode();
            if (hashCode != 445148783) {
                if (hashCode == 1427818632 && findValueFromUrlClientConfig.equals("download")) {
                    doActionFunction(new AppNodeFragment$checkAction$1(this));
                }
            } else if (findValueFromUrlClientConfig.equals("download_or_open")) {
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                Toast.show(requireActivity, 2131887256);
                doActionFunction$default(this, null, 1, null);
            }
        }
    }

    static /* synthetic */ void doActionFunction$default(AppNodeFragment appNodeFragment, ClickInfo.ClickHandleListener clickHandleListener, int i, Object obj) {
        if ((i & 1) != 0) {
            clickHandleListener = null;
        }
        appNodeFragment.doActionFunction(clickHandleListener);
    }

    private final void doActionFunction(ClickInfo.ClickHandleListener clickHandleListener) {
        runIfAppExist(new AppNodeFragment$doActionFunction$1(this, clickHandleListener));
    }

    private final <T> T runIfAppExist(Function1<? super ServiceApp, ? extends T> function1) {
        ServiceApp serviceApp = getViewModel().getServiceApp().get();
        if (serviceApp == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(serviceApp, "it");
        return (T) function1.invoke(serviceApp);
    }

    public final BaseNodePageActivity getNodeActivity() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.node.BaseNodePageActivity");
        return (BaseNodePageActivity) activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null && i == 6666 && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            boolean z = false;
            Integer valueOf = extras != null ? Integer.valueOf(extras.getInt("KEY_DATA", 0)) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                z = true;
            }
            getViewModel().isFavor().set(z);
            ActivityCompat.invalidateOptionsMenu(getActivity());
        }
    }

    @Override // com.coolapk.market.view.node.app.AppNodeView
    public void onRatingComplete(int i, int i2, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            getViewModel().getMyScore().set(i2);
            Toast.error(getActivity(), th);
        } else if (result != null) {
            ObservableFloat appScore = getViewModel().getAppScore();
            String str = result.getData().get("score");
            Intrinsics.checkNotNull(str);
            appScore.set(Float.parseFloat(str));
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Toast.show(requireActivity, 2131887008);
        }
    }

    @Override // com.coolapk.market.view.node.app.AppNodeView
    public void onUnratingComplete(int i, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            getViewModel().getMyScore().set(i);
            Toast.error(getActivity(), th);
        } else if (result != null) {
            ObservableFloat appScore = getViewModel().getAppScore();
            String str = result.getData().get("score");
            Intrinsics.checkNotNull(str);
            appScore.set(Float.parseFloat(str));
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Toast.show(requireActivity, 2131887114);
        }
    }

    @Override // com.coolapk.market.view.node.app.AppNodeView
    public void onFollowAppComplete(boolean z, boolean z2, Result<Map<String, String>> result, Throwable th) {
        if (th != null) {
            getViewModel().isFollow().set(z);
            Toast.error(getActivity(), th);
            return;
        }
        getViewModel().isFollow().set(z2);
        if (z2) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Toast.show(requireActivity, 2131886877);
        } else {
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
            Toast.show(requireActivity2, 2131887109);
        }
        if (getViewModel().getServiceApp().get() != null) {
            EventBus eventBus = EventBus.getDefault();
            ServiceApp serviceApp = getViewModel().getServiceApp().get();
            String str = null;
            String id = serviceApp != null ? serviceApp.getId() : null;
            String str2 = "";
            if (id == null) {
                id = str2;
            }
            eventBus.post(new EntityFollowEvent(id, "appForum", z2));
            EventBus eventBus2 = EventBus.getDefault();
            ServiceApp serviceApp2 = getViewModel().getServiceApp().get();
            if (serviceApp2 != null) {
                str = serviceApp2.getId();
            }
            if (str != null) {
                str2 = str;
            }
            eventBus2.post(new EntityFollowEvent(str2, "apk", z2));
        }
    }

    @Override // com.coolapk.market.view.node.app.AppNodeView
    public void onFavoriteAppComplete(boolean z, boolean z2, Result<Integer> result, Throwable th) {
        if (th != null) {
            getViewModel().isFavor().set(z);
            Toast.error(getActivity(), th);
        } else {
            getViewModel().isFavor().set(z2);
        }
        requireActivity().invalidateOptionsMenu();
    }

    @Subscribe
    public final void onFeedPostEvent(FeedPostEvent feedPostEvent) {
        Intrinsics.checkNotNullParameter(feedPostEvent, "event");
        Feed feed = feedPostEvent.getFeed();
        if (Intrinsics.areEqual(feed.getFeedType(), "rating")) {
            String boundApkID = EntityExtendsKt.getBoundApkID(feed);
            ServiceApp serviceApp = getViewModel().getServiceApp().get();
            if (Intrinsics.areEqual(boundApkID, serviceApp != null ? serviceApp.getApkId() : null)) {
                getViewModel().getMyScore().set(feed.getStar());
                ObservableField<String> ratingFeedUrl = getViewModel().getRatingFeedUrl();
                String url = feed.getUrl();
                if (url == null) {
                    url = "";
                }
                ratingFeedUrl.set(url);
            }
        }
    }

    @Subscribe
    public final void onOtherPostEvent(OtherPostEvent otherPostEvent) {
        Intrinsics.checkNotNullParameter(otherPostEvent, "event");
        Entity entity = otherPostEvent.getEntity();
        String str = null;
        if (!(entity instanceof NodeRating)) {
            entity = null;
        }
        NodeRating nodeRating = (NodeRating) entity;
        if (nodeRating != null) {
            String targetId = nodeRating.getTargetId();
            ServiceApp serviceApp = getViewModel().getServiceApp().get();
            if (serviceApp != null) {
                str = serviceApp.getApkId();
            }
            if (Intrinsics.areEqual(targetId, str) && Intrinsics.areEqual(nodeRating.getTargetType(), "1")) {
                getViewModel().getMyScore().set(nodeRating.getStar());
            }
        }
    }

    @Subscribe
    public final void onNodeRatingDeleteEvent(NodeRatingDeleteEvent nodeRatingDeleteEvent) {
        ServiceApp serviceApp;
        Intrinsics.checkNotNullParameter(nodeRatingDeleteEvent, "event");
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "loginSession");
        if (loginSession.isLogin() && !(!Intrinsics.areEqual(nodeRatingDeleteEvent.getUid(), loginSession.getUid())) && (serviceApp = getViewModel().getServiceApp().get()) != null) {
            Intrinsics.checkNotNullExpressionValue(serviceApp, "viewModel.serviceApp.get() ?: return");
            if (Intrinsics.areEqual(nodeRatingDeleteEvent.getTargetId(), serviceApp.getApkId()) && Intrinsics.areEqual(nodeRatingDeleteEvent.getTargetType(), "1")) {
                getViewModel().getMyScore().set(0);
                getViewModel().getRatingFeedUrl().set("");
            }
        }
    }
}
