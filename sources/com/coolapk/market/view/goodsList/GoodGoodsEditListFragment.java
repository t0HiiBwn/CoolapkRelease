package com.coolapk.market.view.goodsList;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.LayoutListEditButtonBinding;
import com.coolapk.market.event.GoodsAddedEvent;
import com.coolapk.market.extend.LifeCycleExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.view.cardlist.divider.ViewMarginRule;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.touchhelper.OnStartDragListener;
import com.coolapk.market.widget.touchhelper.SimpleItemTouchHelperCallback;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0003CDEB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0002J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\"\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J$\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001303022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001dH\u0016J\u0010\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u000209H\u0007J\u0010\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001bH\u0014J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0016J\u000e\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u001dR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsEditListFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/widget/touchhelper/OnStartDragListener;", "()V", "delList", "Ljava/util/HashSet;", "Lcom/coolapk/market/model/GoodsListItem;", "editButtonBinding", "Lcom/coolapk/market/databinding/LayoutListEditButtonBinding;", "feed", "Lcom/coolapk/market/model/Feed;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "feed$delegate", "Lkotlin/Lazy;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "list", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "listData", "Landroidx/databinding/ObservableArrayList;", "Landroid/os/Parcelable;", "viewModel", "Lcom/coolapk/market/view/goodsList/GoodsListDetailViewModel;", "delListChange", "", "findItem", "", "targetId", "", "findTargetPosition", "moveItem", "fromPosition", "toPosition", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "", "isRefresh", "", "page", "onGoodsAddedEvent", "event", "Lcom/coolapk/market/event/GoodsAddedEvent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRegisterCards", "onStartDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "startDrag", "position", "Companion", "GoodsListViewMarginRule", "ItemOrder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: GoodGoodsEditListFragment.kt */
public final class GoodGoodsEditListFragment extends EntityListFragment implements OnStartDragListener {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_DATA = "DATA";
    private static final String KEY_ID = "KEY_ID";
    public static final int REQUEST_PICK_COVER = 433;
    private HashSet<GoodsListItem> delList = new HashSet<>();
    private LayoutListEditButtonBinding editButtonBinding;
    private final Lazy feed$delegate = LazyKt.lazy(new GoodGoodsEditListFragment$feed$2(this));
    private ItemTouchHelper itemTouchHelper;
    private ArrayList<Entity> list = new ArrayList<>();
    private ObservableArrayList<Parcelable> listData;
    private GoodsListDetailViewModel viewModel = new GoodsListDetailViewModel();

    /* access modifiers changed from: private */
    public final Feed getFeed() {
        return (Feed) this.feed$delegate.getValue();
    }

    @JvmStatic
    public static final GoodGoodsEditListFragment newInstance(Feed feed) {
        return Companion.newInstance(feed);
    }

    public GoodGoodsEditListFragment() {
        List<Parcelable> dataList = getDataList();
        Objects.requireNonNull(dataList, "null cannot be cast to non-null type androidx.databinding.ObservableArrayList<android.os.Parcelable>");
        this.listData = (ObservableArrayList) dataList;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsEditListFragment$Companion;", "", "()V", "KEY_DATA", "", "KEY_ID", "REQUEST_PICK_COVER", "", "newInstance", "Lcom/coolapk/market/view/goodsList/GoodGoodsEditListFragment;", "feed", "Lcom/coolapk/market/model/Feed;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodGoodsEditListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GoodGoodsEditListFragment newInstance(Feed feed) {
            Intrinsics.checkNotNullParameter(feed, "feed");
            GoodGoodsEditListFragment goodGoodsEditListFragment = new GoodGoodsEditListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("DATA", feed);
            Unit unit = Unit.INSTANCE;
            goodGoodsEditListFragment.setArguments(bundle);
            return goodGoodsEditListFragment;
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        FrameLayout frameLayout;
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setTitle("编辑好物单");
        setHasOptionsMenu(true);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipToPadding(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        getVxDividerDecoration$presentation_coolapkAppRelease().addViewMarginRule(new GoodsListViewMarginRule());
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new SimpleItemTouchHelperCallback(new GoodGoodsEditListFragment$onActivityCreated$callback$1(this)));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.attachToRecyclerView(getRecyclerView());
        FrameLayout.LayoutParams layoutParams = null;
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558997, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…edit_button, null, false)");
        LayoutListEditButtonBinding layoutListEditButtonBinding = (LayoutListEditButtonBinding) inflate;
        this.editButtonBinding = layoutListEditButtonBinding;
        if (layoutListEditButtonBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButtonBinding");
        }
        layoutListEditButtonBinding.actionAdd.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
        LayoutListEditButtonBinding layoutListEditButtonBinding2 = this.editButtonBinding;
        if (layoutListEditButtonBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButtonBinding");
        }
        LinearLayout linearLayout = layoutListEditButtonBinding2.actionAdd;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "editButtonBinding.actionAdd");
        ViewExtendsKt.setUtilClickListener(linearLayout, new GoodGoodsEditListFragment$onActivityCreated$1(this));
        LayoutListEditButtonBinding layoutListEditButtonBinding3 = this.editButtonBinding;
        if (layoutListEditButtonBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButtonBinding");
        }
        LinearLayout linearLayout2 = layoutListEditButtonBinding3.actionDel;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "editButtonBinding.actionDel");
        ViewExtendsKt.setUtilClickListener(linearLayout2, new GoodGoodsEditListFragment$onActivityCreated$2(this));
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
            LayoutListEditButtonBinding layoutListEditButtonBinding4 = this.editButtonBinding;
            if (layoutListEditButtonBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editButtonBinding");
            }
            View root = layoutListEditButtonBinding4.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "editButtonBinding.root");
            frameLayout.addView(root);
            ViewGroup.LayoutParams layoutParams2 = root.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2);
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = layoutParams2;
            }
            FrameLayout.LayoutParams layoutParams3 = layoutParams;
            if (layoutParams3 != null) {
                layoutParams3.bottomMargin = NumberExtendsKt.getDp((Number) 24);
                layoutParams3.gravity = 81;
                layoutParams3.width = -2;
                layoutParams3.height = NumberExtendsKt.getDp((Number) 40);
            }
            root.setElevation((float) DisplayUtils.dp2px(getActivity(), 0.5f));
            root.setVisibility(0);
            if (root != null) {
                ViewExtents2Kt.tryListenWindowsInset(root, new GoodGoodsEditListFragment$onActivityCreated$4(this, root));
            }
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
            LifeCycleExtendsKt.oneTimeOnDestroy(lifecycle, new GoodGoodsEditListFragment$onActivityCreated$5(frameLayout, root));
            this.viewModel.addOnPropertyChangedCallback(new GoodGoodsEditListFragment$onActivityCreated$6(this));
        }
    }

    public final void delListChange() {
        int i;
        if (CollectionUtils.isNotEmpty(this.delList)) {
            i = Color.parseColor("#F44336");
        } else {
            i = Color.parseColor("#BDBDBD");
        }
        LayoutListEditButtonBinding layoutListEditButtonBinding = this.editButtonBinding;
        if (layoutListEditButtonBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editButtonBinding");
        }
        LinearLayout linearLayout = layoutListEditButtonBinding.actionDel;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "editButtonBinding.actionDel");
        linearLayout.setBackground(new ColorDrawable(i));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                Intrinsics.checkNotNull(intent);
                Uri output = UCrop.getOutput(intent);
                if (output != null) {
                    Intrinsics.checkNotNullExpressionValue(output, "UCrop.getOutput(data!!) ?: return");
                    String uri = output.toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "path.toString()");
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(0);
                    if (findViewHolderForAdapterPosition instanceof GoodsListEditHeaderViewHolder) {
                        ((GoodsListEditHeaderViewHolder) findViewHolderForAdapterPosition).submitNewCover(uri);
                    }
                }
            } else if (i == 433) {
                Intrinsics.checkNotNull(intent);
                Uri data = intent.getData();
                Intrinsics.checkNotNull(data);
                File file = new File(BitmapUtil.generateFileOutputPath(getActivity(), data.toString()));
                String path = BitmapUtil.getPath(getActivity(), intent.getData());
                if (TextUtils.isEmpty(path)) {
                    Toast.show$default(getActivity(), "无法读取图片", 0, false, 12, null);
                    return;
                }
                AppTheme appTheme = AppHolder.getAppTheme();
                UCrop.Options options = new UCrop.Options();
                options.setActiveWidgetColor(appTheme.getColorAccent());
                options.setStatusBarColor(appTheme.isLightColorTheme() ? appTheme.getColorPrimaryDark() : appTheme.getColorPrimary());
                options.setToolbarColor(appTheme.getColorPrimary());
                options.setToolbarWidgetColor(appTheme.getMainTextColor());
                Intrinsics.checkNotNull(path);
                UCrop.of(Uri.fromFile(new File(path)), Uri.fromFile(file)).withAspectRatio(20.0f, 9.0f).withMaxResultSize(1600, 720).withOptions(options).start(requireActivity(), this);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361899, 0, "完成").setShowAsAction(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361899) {
            return super.onOptionsItemSelected(menuItem);
        }
        requireActivity().finish();
        return true;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsEditListFragment$GoodsListViewMarginRule;", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginRule;", "()V", "getViewMarginData", "Lcom/coolapk/market/view/cardlist/divider/ViewMarginData;", "position", "", "current", "", "default", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodGoodsEditListFragment.kt */
    public static final class GoodsListViewMarginRule implements ViewMarginRule {
        @Override // com.coolapk.market.view.cardlist.divider.ViewMarginRule
        public ViewMarginData getViewMarginData(int i, Object obj, ViewMarginData viewMarginData) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(viewMarginData, "default");
            return ViewMarginData.Companion.getDEFAULT();
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    protected void onRegisterCards() {
        super.onRegisterCards();
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558759).suitedMethod(GoodGoodsEditListFragment$onRegisterCards$1.INSTANCE).constructor(new GoodGoodsEditListFragment$onRegisterCards$2(this)).build(), -1);
        getAdapter$presentation_coolapkAppRelease().register(SimpleViewHolderFactor.Companion.withLayoutId(2131558686).suitedMethod(GoodGoodsEditListFragment$onRegisterCards$3.INSTANCE).constructor(new GoodGoodsEditListFragment$onRegisterCards$4(this)).build(), 0);
    }

    private final int findTargetPosition() {
        Iterator<T> it2 = getDataList().iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (it2.next() instanceof GoodsListItem) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void moveItem(int i, int i2) {
        synchronized (new Object()) {
            this.listData.removeOnListChangedCallback(getAdapterListChangedCallback());
            Collections.swap(getDataList(), i, i2);
            this.listData.addOnListChangedCallback(getAdapterListChangedCallback());
            Unit unit = Unit.INSTANCE;
        }
        getAdapter$presentation_coolapkAppRelease().notifyItemMoved(i, i2);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        this.list.add(getFeed());
        this.list.addAll(getFeed().getGoodsListItem());
        Observable<List<Entity>> just = Observable.just(this.list);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(list)");
        return just;
    }

    @Override // com.coolapk.market.widget.touchhelper.OnStartDragListener
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ItemTouchHelper itemTouchHelper2 = this.itemTouchHelper;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.startDrag(viewHolder);
    }

    public final void startDrag(int i) {
        new GoodGoodsEditListFragment$startDrag$1(this, i).invoke();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/goodsList/GoodGoodsEditListFragment$ItemOrder;", "", "id", "", "order", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getOrder", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: GoodGoodsEditListFragment.kt */
    public static final class ItemOrder {
        private final String id;
        private final String order;

        public static /* synthetic */ ItemOrder copy$default(ItemOrder itemOrder, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = itemOrder.id;
            }
            if ((i & 2) != 0) {
                str2 = itemOrder.order;
            }
            return itemOrder.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.order;
        }

        public final ItemOrder copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "order");
            return new ItemOrder(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemOrder)) {
                return false;
            }
            ItemOrder itemOrder = (ItemOrder) obj;
            return Intrinsics.areEqual(this.id, itemOrder.id) && Intrinsics.areEqual(this.order, itemOrder.order);
        }

        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.order;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ItemOrder(id=" + this.id + ", order=" + this.order + ")";
        }

        public ItemOrder(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "order");
            this.id = str;
            this.order = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getOrder() {
            return this.order;
        }
    }

    @Subscribe
    public final void onGoodsAddedEvent(GoodsAddedEvent goodsAddedEvent) {
        Intrinsics.checkNotNullParameter(goodsAddedEvent, "event");
        GoodsListItem goodsListItem = goodsAddedEvent.getGoodsListItem();
        String entityId = goodsListItem != null ? goodsListItem.getEntityId() : null;
        Intrinsics.checkNotNull(entityId);
        Intrinsics.checkNotNullExpressionValue(entityId, "goodsListItem?.entityId!!");
        int findItem = findItem(entityId);
        if (findItem > -1) {
            getDataList().set(findItem, goodsListItem);
        } else {
            getDataList().add(1, goodsListItem);
        }
    }

    private final int findItem(String str) {
        int size = getDataList().size();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = getDataList().get(i);
            String str2 = null;
            if (!(parcelable instanceof GoodsListItem)) {
                parcelable = null;
            }
            GoodsListItem goodsListItem = (GoodsListItem) parcelable;
            if (goodsListItem != null) {
                str2 = goodsListItem.getEntityId();
            }
            if (Intrinsics.areEqual(str, str2)) {
                return i;
            }
        }
        return -1;
    }
}
