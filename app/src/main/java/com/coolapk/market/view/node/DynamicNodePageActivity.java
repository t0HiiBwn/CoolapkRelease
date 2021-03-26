package com.coolapk.market.view.node;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.node.app.AppNodeFragment;
import com.coolapk.market.view.node.prodcut.ProductNodeFragment;
import com.coolapk.market.view.node.topic.TopicNodeFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0014J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001fH\u0014J\u001c\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00100\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u00101\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u000103H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/coolapk/market/view/node/DynamicNodePageActivity;", "Lcom/coolapk/market/view/node/BaseNodePageActivity;", "()V", "delayShowContentRunnable", "Ljava/lang/Runnable;", "elapsedTime", "", "fragment", "Landroidx/fragment/app/Fragment;", "loader", "Lcom/coolapk/market/view/node/Loader;", "getLoader", "()Lcom/coolapk/market/view/node/Loader;", "loader$delegate", "Lkotlin/Lazy;", "nodeFragment", "Lcom/coolapk/market/view/node/NodeFragmentBehavior;", "getNodeFragment", "()Lcom/coolapk/market/view/node/NodeFragmentBehavior;", "subscription", "Lrx/Subscription;", "delayShowContentView", "", "getDataName", "", "entity", "Lcom/coolapk/market/model/Entity;", "getFragment", "name", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataLoad", "data", "onDestroy", "onFloatingButtonAction", "transitionY", "", "onInsetChange", "rect", "Landroid/graphics/Rect;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "restoreData", "dataName", "setAppBarBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DynamicNodePageActivity.kt */
public final class DynamicNodePageActivity extends BaseNodePageActivity {
    public static final String ACTION_DOWNLOAD = "download";
    public static final String ACTION_DOWNLOAD_OR_OPEN = "download_or_open";
    public static final String CLIENT_CONFIG_ACTION = "action";
    public static final String CLIENT_CONFIG_SELECTED_TAB = "selectedTab";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_APP_UNIQUE_ID = "APP_UNIQUE_ID";
    public static final String KEY_CLIENT_CONFIG = "CLIENT_CONFIG";
    private static final String KEY_DATA = "DATA";
    private static final String KEY_DATA_NAME = "DATA_NAME";
    public static final String KEY_EXTRA_ANALYSIS_DATA = "EXTRA_ANALYSIS_DATA";
    public static final String KEY_EXTRA_REQUEST_CONTEXT = "EXTRA_REQUEST_CONTEXT";
    public static final String KEY_FROM_API = "FROM_API";
    public static final String KEY_LOADER_NAME = "LOADER_NAME";
    public static final String KEY_PRODUCT_ID = "PRODUCT_ID";
    public static final String KEY_TOPIC_TITLE = "TOPIC_TITLE";
    public static final String LOADER_APP = "LOADER_APP";
    public static final String LOADER_PRODUCT = "LOADER_PRODUCT";
    public static final String LOADER_TOPIC = "LOADER_TOPIC";
    private static final int MAX_WAITING_TIME_FOR_CONTENT_SHOW = 2000;
    private static final int MIN_WAITING_TIME_FOR_CONTENT_SHOW = 100;
    private static final String TAG_FRAGMENT = "CONTROL_FRAGMENT";
    private Runnable delayShowContentRunnable;
    private long elapsedTime;
    private Fragment fragment;
    private final Lazy loader$delegate = LazyKt.lazy(new DynamicNodePageActivity$loader$2(this));
    private Subscription subscription;

    @JvmStatic
    public static final Intent buildAppIntent(Context context) {
        return Companion.buildAppIntent(context);
    }

    @JvmStatic
    public static final Intent buildProductIntent(Context context) {
        return Companion.buildProductIntent(context);
    }

    @JvmStatic
    public static final Intent buildTopicIntent(Context context) {
        return Companion.buildTopicIntent(context);
    }

    private final Loader getLoader() {
        return (Loader) this.loader$delegate.getValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0019\u001a\u00070\u001a¢\u0006\u0002\b\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/node/DynamicNodePageActivity$Companion;", "", "()V", "ACTION_DOWNLOAD", "", "ACTION_DOWNLOAD_OR_OPEN", "CLIENT_CONFIG_ACTION", "CLIENT_CONFIG_SELECTED_TAB", "KEY_APP_UNIQUE_ID", "KEY_CLIENT_CONFIG", "KEY_DATA", "KEY_DATA_NAME", "KEY_EXTRA_ANALYSIS_DATA", "KEY_EXTRA_REQUEST_CONTEXT", "KEY_FROM_API", "KEY_LOADER_NAME", "KEY_PRODUCT_ID", "KEY_TOPIC_TITLE", "LOADER_APP", "LOADER_PRODUCT", "LOADER_TOPIC", "MAX_WAITING_TIME_FOR_CONTENT_SHOW", "", "MIN_WAITING_TIME_FOR_CONTENT_SHOW", "TAG_FRAGMENT", "buildAppIntent", "Landroid/content/Intent;", "Lorg/jetbrains/annotations/NotNull;", "context", "Landroid/content/Context;", "buildProductIntent", "buildTopicIntent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DynamicNodePageActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Intent buildAppIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, DynamicNodePageActivity.class);
            intent.putExtra("LOADER_NAME", "LOADER_APP");
            return intent;
        }

        @JvmStatic
        public final Intent buildProductIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, DynamicNodePageActivity.class);
            intent.putExtra("LOADER_NAME", "LOADER_PRODUCT");
            return intent;
        }

        @JvmStatic
        public final Intent buildTopicIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, DynamicNodePageActivity.class);
            intent.putExtra("LOADER_NAME", "LOADER_TOPIC");
            return intent;
        }
    }

    private final NodeFragmentBehavior getNodeFragment() {
        Fragment fragment2 = this.fragment;
        if (!(fragment2 instanceof NodeFragmentBehavior)) {
            fragment2 = null;
        }
        return (NodeFragmentBehavior) fragment2;
    }

    @Override // com.coolapk.market.view.node.BaseNodePageActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        String string;
        Entity restoreData;
        super.onCreate(bundle);
        this.elapsedTime = System.currentTimeMillis();
        if (bundle == null || (string = bundle.getString("DATA_NAME")) == null || (restoreData = restoreData(bundle, string)) == null) {
            z = false;
        } else {
            onDataLoad(restoreData);
            setLoadingFinished();
            z = true;
        }
        if (!z && getLoader().checkIdentity()) {
            getBinding$presentation_coolapkAppRelease().loadingPlaceHolder.setImageResource(getLoader().loadingPlaceHolderRes());
            setLoadingStart();
            Subscription subscription2 = this.subscription;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            this.subscription = getLoader().loadData().compose(RxUtils.apiCommonToData()).subscribe(new DynamicNodePageActivity$onCreate$1(this), new DynamicNodePageActivity$onCreate$2(this));
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 16908332 || itemId == 2131362659) {
            supportFinishAfterTransition();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.coolapk.market.view.node.BaseNodePageActivity, com.coolapk.market.widget.DrawSystemBarFrameLayout.OnInsetChangeListener
    public void onInsetChange(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        super.onInsetChange(rect);
        NodeFragmentBehavior nodeFragment = getNodeFragment();
        if (nodeFragment != null) {
            nodeFragment.onApplyWindowsInset(rect);
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Entity data;
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Fragment fragment2 = this.fragment;
        if (fragment2 != null && fragment2.isAdded() && (fragment2 instanceof NodeFragmentBehavior) && (data = ((NodeFragmentBehavior) fragment2).getData()) != null) {
            bundle.putString("DATA_NAME", getDataName(data));
            bundle.putParcelable("DATA", data);
        }
    }

    @Override // com.coolapk.market.view.node.BaseNodePageActivity
    public void onFloatingButtonAction(float f) {
        super.onFloatingButtonAction(f);
        NodeFragmentBehavior nodeFragment = getNodeFragment();
        if (nodeFragment != null) {
            nodeFragment.onFloatingButtonAction(f);
        }
    }

    @Override // com.coolapk.market.view.node.BaseNodePageActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = null;
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void onDataLoad(Entity entity) {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("CONTROL_FRAGMENT");
        if (findFragmentByTag != null) {
            this.fragment = findFragmentByTag;
            return;
        }
        this.fragment = getFragment(entity);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment2 = this.fragment;
        Intrinsics.checkNotNull(fragment2);
        beginTransaction.add(fragment2, "CONTROL_FRAGMENT").commitAllowingStateLoss();
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: private */
    public final void delayShowContentView() {
        long currentTimeMillis = ((long) 2000) - (System.currentTimeMillis() - this.elapsedTime);
        if (currentTimeMillis <= 0) {
            setLoadingFinished();
            return;
        }
        DynamicNodePageActivity$delayShowContentView$1 dynamicNodePageActivity$delayShowContentView$1 = this.delayShowContentRunnable;
        if (dynamicNodePageActivity$delayShowContentView$1 == null) {
            dynamicNodePageActivity$delayShowContentView$1 = new DynamicNodePageActivity$delayShowContentView$1(this);
            this.delayShowContentRunnable = dynamicNodePageActivity$delayShowContentView$1;
        }
        AppHolder.getMainThreadHandler().postDelayed(dynamicNodePageActivity$delayShowContentView$1, currentTimeMillis);
    }

    @Override // com.coolapk.market.view.node.BaseNodePageActivity, com.coolapk.market.view.node.NodeActivityBehavior
    public void setAppBarBackground(Drawable drawable) {
        super.setAppBarBackground(drawable);
        Runnable runnable = this.delayShowContentRunnable;
        if (runnable != null) {
            Handler mainThreadHandler = AppHolder.getMainThreadHandler();
            long currentTimeMillis = ((long) 100) - (System.currentTimeMillis() - this.elapsedTime);
            if (currentTimeMillis > 0) {
                mainThreadHandler.removeCallbacks(runnable);
                mainThreadHandler.postDelayed(runnable, currentTimeMillis);
                return;
            }
            mainThreadHandler.removeCallbacks(runnable);
            Runnable runnable2 = this.delayShowContentRunnable;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    /* access modifiers changed from: private */
    public final Loader getLoader(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 599875747) {
            if (hashCode != 783159253) {
                if (hashCode == 1014284771 && str.equals("LOADER_TOPIC")) {
                    Intent intent = getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "intent");
                    return new TopicNodeLoader(this, intent);
                }
            } else if (str.equals("LOADER_APP")) {
                Intent intent2 = getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "intent");
                return new AppNodeLoader(this, intent2);
            }
        } else if (str.equals("LOADER_PRODUCT")) {
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            return new ProductNodeLoader(this, intent3);
        }
        throw new RuntimeException("Unknown loader: " + str);
    }

    private final Fragment getFragment(Entity entity) {
        if (entity instanceof Product) {
            return ProductNodeFragment.Companion.newInstance((Product) entity);
        }
        if (entity instanceof Topic) {
            return TopicNodeFragment.Companion.newInstance((Topic) entity);
        }
        if (entity instanceof ServiceApp) {
            return AppNodeFragment.Companion.newInstance((ServiceApp) entity);
        }
        throw new RuntimeException("Unknown entity type: " + entity.getEntityType());
    }

    private final Entity restoreData(Bundle bundle, String str) {
        if (Intrinsics.areEqual(str, Product.class.getName())) {
            return (Entity) bundle.getParcelable("DATA");
        }
        if (Intrinsics.areEqual(str, Topic.class.getName())) {
            return (Entity) bundle.getParcelable("DATA");
        }
        if (Intrinsics.areEqual(str, ServiceApp.class.getName())) {
            return (Entity) bundle.getParcelable("DATA");
        }
        return null;
    }

    private final String getDataName(Entity entity) {
        if (entity instanceof Product) {
            String name = Product.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "Product::class.java.name");
            return name;
        } else if (entity instanceof Topic) {
            String name2 = Topic.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "Topic::class.java.name");
            return name2;
        } else if (entity instanceof ServiceApp) {
            String name3 = ServiceApp.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "ServiceApp::class.java.name");
            return name3;
        } else {
            throw new RuntimeException("Unknown entity type: " + entity.getEntityType());
        }
    }
}
