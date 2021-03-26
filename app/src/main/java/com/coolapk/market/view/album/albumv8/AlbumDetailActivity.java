package com.coolapk.market.view.album.albumv8;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.AlbumDetailtViewBinding;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedEditorChoiceEvent;
import com.coolapk.market.event.FeedFavoriteEvent;
import com.coolapk.market.event.FeedRecommendEvent;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.EventBusExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumActionPresenter;
import com.coolapk.market.view.album.AlbumDetailContract;
import com.coolapk.market.view.album.AlbumDetailPresenter;
import com.coolapk.market.view.album.AlbumDetailViewModel;
import com.coolapk.market.view.album.albumv8.AlbumCommentBarViewPart;
import com.coolapk.market.view.album.albumv8.AlbumDetailListFragment;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.base.FragmentStatePagerAdapter;
import com.coolapk.market.view.feed.reply.AlbumReplyListFragmentV8;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.photoview.PhotoView;
import com.coolapk.market.widget.slidr.ScrollStateViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002[\\B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\u0015H\u0016J\u0006\u00102\u001a\u00020#J\b\u00103\u001a\u00020#H\u0002J\u0006\u00104\u001a\u00020#J\u001c\u00105\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020#2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0014J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020AH\u0007J\u0010\u0010B\u001a\u00020#2\u0006\u0010@\u001a\u00020CH\u0007J\u0010\u0010B\u001a\u00020#2\u0006\u0010@\u001a\u00020DH\u0007J\u0010\u0010E\u001a\u00020#2\u0006\u0010@\u001a\u00020FH\u0007J\u0010\u0010G\u001a\u00020#2\u0006\u0010@\u001a\u00020HH\u0007J\b\u0010I\u001a\u00020#H\u0002J\u0010\u0010J\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020#H\u0014J\u0010\u0010Q\u001a\u00020#2\u0006\u0010@\u001a\u00020RH\u0007J\b\u0010S\u001a\u00020#H\u0002J\u000e\u0010T\u001a\u00020#2\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020\rH\u0002J\u0010\u0010W\u001a\u00020#2\u0006\u0010V\u001a\u00020\rH\u0016J\u0012\u0010X\u001a\u00020#2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010Z\u001a\u00020#H\u0002R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumDetailActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/view/base/AlphableToolbar;", "Lcom/coolapk/market/view/album/AlbumDetailContract$View;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "adapter", "Lcom/coolapk/market/view/album/albumv8/AlbumDetailActivity$DataAdapter;", "albumCommentBarViewPart", "Lcom/coolapk/market/view/album/albumv8/AlbumCommentBarViewPart;", "appbarAnimId", "", "appbarBgAlpha", "", "binding", "Lcom/coolapk/market/databinding/AlbumDetailtViewBinding;", "currentPage", "getCurrentPage", "()I", "filter", "isInit", "", "isPostingLike", "mContentVisible", "presenter", "Lcom/coolapk/market/view/album/AlbumDetailPresenter;", "replyId", "", "showCommentFirst", "toolBarAnimator", "Landroid/animation/ValueAnimator;", "verticalTop", "viewModel", "Lcom/coolapk/market/view/album/AlbumDetailViewModel;", "appBarInitStateFor2edPage", "", "getAppBar", "Lcom/google/android/material/appbar/AppBarLayout;", "getFilter", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "getToolBar", "Landroidx/appcompat/widget/Toolbar;", "getViewPagerFragment", "initCommentBar", "album", "Lcom/coolapk/market/model/Album;", "initUI", "isNavigationBarTranslucent", "listLoaded", "maskContentAnim", "notifyCommentBarChange", "onAlbumLoaded", "throwable", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onFeedDeleted", "event", "Lcom/coolapk/market/event/FeedDeleteEvent;", "onFeedRecommendChange", "Lcom/coolapk/market/event/FeedEditorChoiceEvent;", "Lcom/coolapk/market/event/FeedRecommendEvent;", "onFeedReply", "Lcom/coolapk/market/event/FeedReplyEvent;", "onLikeChange", "Lcom/coolapk/market/event/AlbumLikeEvent;", "onLikeClick", "onModelLoaded", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onSetStatusBarColor", "onStarChange", "Lcom/coolapk/market/event/FeedFavoriteEvent;", "onStarClick", "selectPage", "setAppBarShadow", "alpha", "setToolbarAlpha", "setToolbarTitle", "title", "showContent", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AlbumDetailActivity.kt */
public final class AlbumDetailActivity extends FakeStatusBarActivity implements AlphableToolbar, AlbumDetailContract.View, TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_FLAG = "extra_flag";
    public static final String EXTRA_MODEL = "EXTRA_MODEL";
    public static final String KEY_ALBUM = "ALBUM";
    public static final String KEY_ALBUM_ID = "ALBUM_ID";
    public static final String KEY_ALBUM_RID = "ALBUM_RID";
    private DataAdapter adapter;
    private AlbumCommentBarViewPart albumCommentBarViewPart;
    private int appbarAnimId = 2130837510;
    private float appbarBgAlpha = -1.0f;
    private AlbumDetailtViewBinding binding;
    private float filter = -1.0f;
    private boolean isInit;
    private boolean isPostingLike;
    private boolean mContentVisible;
    private AlbumDetailPresenter presenter = new AlbumDetailPresenter(this);
    private String replyId;
    private boolean showCommentFirst;
    private ValueAnimator toolBarAnimator;
    private boolean verticalTop = true;
    private AlbumDetailViewModel viewModel;

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ AlbumDetailtViewBinding access$getBinding$p(AlbumDetailActivity albumDetailActivity) {
        AlbumDetailtViewBinding albumDetailtViewBinding = albumDetailActivity.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return albumDetailtViewBinding;
    }

    public static final /* synthetic */ AlbumDetailViewModel access$getViewModel$p(AlbumDetailActivity albumDetailActivity) {
        AlbumDetailViewModel albumDetailViewModel = albumDetailActivity.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return albumDetailViewModel;
    }

    /* access modifiers changed from: private */
    public final int getCurrentPage() {
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = albumDetailtViewBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        return scrollStateViewPager.getCurrentItem();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumDetailActivity$Companion;", "", "()V", "EXTRA_FLAG", "", "EXTRA_MODEL", "KEY_ALBUM", "KEY_ALBUM_ID", "KEY_ALBUM_RID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String str;
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        this.replyId = getIntent().getStringExtra("ALBUM_RID");
        boolean z = false;
        if ((getIntent().getIntExtra("extra_flag", 0) & 1) > 0) {
            z = true;
        }
        this.showCommentFirst = z;
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131558445, new ContextBindingComponent(getActivity()));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…ndingComponent(activity))");
        AlbumDetailtViewBinding albumDetailtViewBinding = (AlbumDetailtViewBinding) contentView;
        this.binding = albumDetailtViewBinding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        albumDetailtViewBinding.mainContent.addOnInsetChangeListener(new AlbumDetailActivity$onCreate$1(this));
        AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
        if (albumDetailtViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        albumDetailtViewBinding2.mainContent.requestLayoutRecursive = true;
        this.viewModel = new AlbumDetailViewModel(this);
        AlbumDetailtViewBinding albumDetailtViewBinding3 = this.binding;
        if (albumDetailtViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        albumDetailtViewBinding3.setViewModel(albumDetailViewModel);
        initUI();
        if (bundle != null) {
            Album album = (Album) bundle.getParcelable("EXTRA_MODEL");
            if (album != null) {
                onModelLoaded(album);
            }
        } else {
            Album album2 = (Album) getIntent().getParcelableExtra("ALBUM");
            if (album2 == null) {
                str = getIntent().getStringExtra("ALBUM_ID");
            } else {
                str = album2.getAlbumId();
            }
            this.presenter.loadAlbum(str, this.replyId);
            StatisticHelper.Companion.getInstance().recordFeedClickAction("应用集");
        }
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeRegister(eventBus, this);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        EventBus eventBus = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(eventBus, "EventBus.getDefault()");
        EventBusExtendsKt.safeUnregister(eventBus, this);
        this.presenter.cancelLoadAlbum();
        super.onDestroy();
    }

    @Subscribe
    public final void onFeedRecommendChange(FeedRecommendEvent feedRecommendEvent) {
        Intrinsics.checkNotNullParameter(feedRecommendEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (TextUtils.equals(albumDetailViewModel.getAlbumId(), feedRecommendEvent.getId())) {
            AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
            if (albumDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            AlbumDetailViewModel albumDetailViewModel3 = this.viewModel;
            if (albumDetailViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            albumDetailViewModel2.setAlbum(feedRecommendEvent.handleEvent(albumDetailViewModel3.getAlbum()));
        }
    }

    @Subscribe
    public final void onFeedDeleted(FeedDeleteEvent feedDeleteEvent) {
        Intrinsics.checkNotNullParameter(feedDeleteEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (TextUtils.equals(albumDetailViewModel.getAlbumId(), feedDeleteEvent.id)) {
            getActivity().finish();
        }
    }

    @Subscribe
    public final void onFeedRecommendChange(FeedEditorChoiceEvent feedEditorChoiceEvent) {
        Intrinsics.checkNotNullParameter(feedEditorChoiceEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (TextUtils.equals(albumDetailViewModel.getAlbumId(), feedEditorChoiceEvent.getId())) {
            AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
            if (albumDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            AlbumDetailViewModel albumDetailViewModel3 = this.viewModel;
            if (albumDetailViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            albumDetailViewModel2.setAlbum(feedEditorChoiceEvent.handleEvent(albumDetailViewModel3.getAlbum()));
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void initUI() {
        ?? load = GlideApp.with((FragmentActivity) getActivity()).load(Integer.valueOf(AppHolder.getAppTheme().isDarkTheme() ? 2131230831 : 2131230830));
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        load.into(albumDetailtViewBinding.maskView);
        AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
        if (albumDetailtViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        PhotoView photoView = albumDetailtViewBinding2.maskView;
        Intrinsics.checkNotNullExpressionValue(photoView, "binding.maskView");
        photoView.setScaleType(ImageView.ScaleType.FIT_START);
        AlbumDetailtViewBinding albumDetailtViewBinding3 = this.binding;
        if (albumDetailtViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = albumDetailtViewBinding3.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        setSupportActionBar(toolbar);
        setToolbarAlpha(0.0f);
        setToolbarTitle("");
        toolbar.setNavigationOnClickListener(new AlbumDetailActivity$initUI$1(this));
    }

    public final float getFilter() {
        return this.filter;
    }

    public final Toolbar getToolBar() {
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = albumDetailtViewBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        return toolbar;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z;
        Intrinsics.checkNotNullParameter(menu, "menu");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (albumDetailViewModel.getAlbum() != null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            String uid = loginSession.getUid();
            AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
            if (albumDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Album album = albumDetailViewModel2.getAlbum();
            Intrinsics.checkNotNull(album);
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album!!");
            z = TextUtils.equals(uid, album.getUid());
        } else {
            z = false;
        }
        getMenuInflater().inflate(2131623936, menu);
        MenuItem findItem = menu.findItem(2131361902);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.action_edit_album)");
        findItem.setVisible(z);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (albumDetailViewModel.getAlbum() == null) {
            return true;
        }
        AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
        if (albumDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Album album = albumDetailViewModel2.getAlbum();
        Intrinsics.checkNotNull(album);
        Intrinsics.checkNotNullExpressionValue(album, "viewModel.album!!");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361902) {
            ActionManager.startAlbumEditActivity(getActivity(), album);
            return true;
        } else if (itemId != 2131361932) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            EntityExtendsKt.showItemDialog(album, activity);
            return true;
        }
    }

    public final void listLoaded() {
        if (!TextUtils.isEmpty(this.replyId) || this.showCommentFirst) {
            BaseActivity activity = getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type com.coolapk.market.view.album.albumv8.AlbumDetailActivity");
            ((AlbumDetailActivity) activity).selectPage(1);
        }
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        albumDetailViewModel.setShowContentView(true);
        AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
        if (albumDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (albumDetailViewModel2.getShowContentView()) {
            maskContentAnim();
        }
    }

    @Override // com.coolapk.market.view.album.AlbumDetailContract.View
    public void onAlbumLoaded(Album album, Throwable th) {
        if (album != null) {
            onModelLoaded(album);
        } else if (th != null) {
            Toast.error(getActivity(), th);
            finish();
        }
    }

    private final void onModelLoaded(Album album) {
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        albumDetailViewModel.setAlbum(album);
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        albumDetailtViewBinding.executePendingBindings();
        initCommentBar(album);
        showContent();
        invalidateOptionsMenu();
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(this);
    }

    public final AppBarLayout getAppBar() {
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppBarLayout appBarLayout = albumDetailtViewBinding.appBar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
        return appBarLayout;
    }

    private final void showContent() {
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        if (albumDetailViewModel.getAlbum() != null && !this.mContentVisible) {
            this.mContentVisible = true;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            this.adapter = new DataAdapter(this, supportFragmentManager);
            AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
            if (albumDetailtViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ScrollStateViewPager scrollStateViewPager = albumDetailtViewBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
            scrollStateViewPager.setAdapter(this.adapter);
            AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
            if (albumDetailtViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            albumDetailtViewBinding2.viewPager.addOnPageChangeListener(onPageChangeListener());
            AlbumDetailtViewBinding albumDetailtViewBinding3 = this.binding;
            if (albumDetailtViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ViewUtil.doubleClickListener(albumDetailtViewBinding3.toolbar, new AlbumDetailActivity$showContent$1(this));
        }
    }

    private final void initCommentBar(Album album) {
        AlbumCommentBarViewPart.Companion companion = AlbumCommentBarViewPart.Companion;
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = albumDetailtViewBinding.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        AlbumCommentBarViewPart newInstance = companion.newInstance(album, drawSystemBarFrameLayout);
        newInstance.setExternalListener(new AlbumDetailActivity$initCommentBar$1(this, album));
        AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
        if (albumDetailtViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.replaceView(albumDetailtViewBinding2.commentBarSpaceView, newInstance.getView());
        ViewGroup.LayoutParams layoutParams = newInstance.getView().getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 80;
        }
        this.albumCommentBarViewPart = newInstance;
    }

    /* access modifiers changed from: private */
    public final void onLikeClick() {
        if (!this.isPostingLike) {
            boolean z = true;
            this.isPostingLike = true;
            AlbumDetailViewModel albumDetailViewModel = this.viewModel;
            if (albumDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Album album = albumDetailViewModel.getAlbum();
            if (album != null) {
                Intrinsics.checkNotNullExpressionValue(album, "viewModel.album ?: return");
                UserAction userAction = album.getUserAction();
                if (userAction == null || userAction.getLike() != 1) {
                    z = false;
                }
                if (z) {
                    AlbumActionPresenter.getInstance().unlikeAlbum(album).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new AlbumDetailActivity$onLikeClick$1(this, album));
                } else {
                    AlbumActionPresenter.getInstance().likeAlbum(album).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new AlbumDetailActivity$onLikeClick$2(this, album));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onStarClick() {
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Album album = albumDetailViewModel.getAlbum();
        if (album != null) {
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album ?: return");
            ActionManager.startCollectionSelectActivity(getActivity(), album.getId(), album.getEntityType());
        }
    }

    @Subscribe
    public final void onLikeChange(AlbumLikeEvent albumLikeEvent) {
        Intrinsics.checkNotNullParameter(albumLikeEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Album album = albumDetailViewModel.getAlbum();
        if (album != null) {
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album ?: return");
            if (Intrinsics.areEqual(albumLikeEvent.getId(), album.getAlbumId())) {
                AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
                if (albumDetailViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                albumDetailViewModel2.setAlbum(albumLikeEvent.handleEvent(album));
                notifyCommentBarChange();
            }
        }
    }

    @Subscribe
    public final void onStarChange(FeedFavoriteEvent feedFavoriteEvent) {
        Intrinsics.checkNotNullParameter(feedFavoriteEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Album album = albumDetailViewModel.getAlbum();
        if (album != null) {
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album ?: return");
            if (Intrinsics.areEqual(feedFavoriteEvent.getId(), album.getAlbumId())) {
                AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
                if (albumDetailViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                albumDetailViewModel2.setAlbum(feedFavoriteEvent.handleEvent(album));
                notifyCommentBarChange();
            }
        }
    }

    @Subscribe
    public final void onFeedReply(FeedReplyEvent feedReplyEvent) {
        Intrinsics.checkNotNullParameter(feedReplyEvent, "event");
        AlbumDetailViewModel albumDetailViewModel = this.viewModel;
        if (albumDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Album album = albumDetailViewModel.getAlbum();
        if (album != null) {
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album ?: return");
            String id = album.getId();
            FeedReply feedReply = feedReplyEvent.getFeedReply();
            Intrinsics.checkNotNullExpressionValue(feedReply, "event.feedReply");
            if (Intrinsics.areEqual(id, feedReply.getFeedId())) {
                Album.Builder newBuilder = Album.newBuilder(album);
                newBuilder.replyNum(album.getReplyNum() + 1);
                AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
                if (albumDetailViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                albumDetailViewModel2.setAlbum(newBuilder.build());
                notifyCommentBarChange();
            }
        }
    }

    private final void maskContentAnim() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(1.0f, 0.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.addUpdateListener(new AlbumDetailActivity$maskContentAnim$1(this));
        valueAnimator.addListener(new AlbumDetailActivity$maskContentAnim$2(this));
        valueAnimator.start();
    }

    public final void selectPage(int i) {
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ScrollStateViewPager scrollStateViewPager = albumDetailtViewBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(scrollStateViewPager, "binding.viewPager");
        scrollStateViewPager.setCurrentItem(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarTitle(String str) {
        String str2 = str;
        boolean isEmpty = TextUtils.isEmpty(str2);
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = albumDetailtViewBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        if (isEmpty == TextUtils.isEmpty(toolbar.getTitle())) {
            AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
            if (albumDetailtViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            Toolbar toolbar2 = albumDetailtViewBinding2.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar2, "binding.toolbar");
            toolbar2.setTitle(str2);
            return;
        }
        AlbumDetailtViewBinding albumDetailtViewBinding3 = this.binding;
        if (albumDetailtViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar3 = albumDetailtViewBinding3.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar3, "binding.toolbar");
        if (!Intrinsics.areEqual(toolbar3.getTitle(), str)) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = str;
            ValueAnimator valueAnimator = this.toolBarAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            if (TextUtils.isEmpty(str2)) {
                valueAnimator2.setFloatValues(1.0f, 0.0f);
                AlbumDetailtViewBinding albumDetailtViewBinding4 = this.binding;
                if (albumDetailtViewBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                Toolbar toolbar4 = albumDetailtViewBinding4.toolbar;
                Intrinsics.checkNotNullExpressionValue(toolbar4, "binding.toolbar");
                CharSequence title = toolbar4.getTitle();
                objectRef.element = title != null ? (T) title.toString() : null;
                valueAnimator2.addListener(new AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$1(this, str, objectRef));
            } else {
                valueAnimator2.setFloatValues(0.0f, 1.0f);
            }
            valueAnimator2.setDuration(100L);
            valueAnimator2.addUpdateListener(new AlbumDetailActivity$setToolbarTitle$$inlined$apply$lambda$2(this, str, objectRef));
            Unit unit = Unit.INSTANCE;
            this.toolBarAnimator = valueAnimator2;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setAppBarShadow(float f) {
        if (f > 0.9f) {
            if (this.appbarAnimId != 2130837511) {
                this.appbarAnimId = 2130837511;
                StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(getActivity(), this.appbarAnimId);
                AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
                if (albumDetailtViewBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                AppBarLayout appBarLayout = albumDetailtViewBinding.appBar;
                Intrinsics.checkNotNullExpressionValue(appBarLayout, "binding.appBar");
                appBarLayout.setStateListAnimator(loadStateListAnimator);
            }
        } else if (this.appbarAnimId != 2130837510) {
            this.appbarAnimId = 2130837510;
            StateListAnimator loadStateListAnimator2 = AnimatorInflater.loadStateListAnimator(getActivity(), this.appbarAnimId);
            AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
            if (albumDetailtViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AppBarLayout appBarLayout2 = albumDetailtViewBinding2.appBar;
            Intrinsics.checkNotNullExpressionValue(appBarLayout2, "binding.appBar");
            appBarLayout2.setStateListAnimator(loadStateListAnimator2);
        }
    }

    public final void appBarInitStateFor2edPage() {
        setAppBarShadow(1.0f);
        AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
        if (albumDetailtViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        albumDetailtViewBinding.appBar.setBackgroundColor(AppHolder.getAppTheme().getColorPrimary());
        AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
        if (albumDetailtViewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = albumDetailtViewBinding2.toolbar;
        ViewExtendsKt.adjustTintColorByAlpha$default(toolbar, 1.0f, false, 2, null);
        toolbar.setTitle(getString(2131886667));
        this.isInit = true;
    }

    @Override // com.coolapk.market.view.base.AlphableToolbar
    public void setToolbarAlpha(float f) {
        String str;
        this.verticalTop = f < 1.0f;
        if (f >= ((float) 1)) {
            AlbumDetailViewModel albumDetailViewModel = this.viewModel;
            if (albumDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            str = albumDetailViewModel.getAlbumTitle();
        } else {
            str = "";
        }
        setToolbarTitle(str);
        if (f != this.appbarBgAlpha) {
            this.appbarBgAlpha = f;
            int adjustAlpha = ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorPrimary(), f);
            AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
            if (albumDetailtViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            albumDetailtViewBinding.appBar.setBackgroundColor(adjustAlpha);
            setAppBarShadow(f);
            float f2 = this.filter;
            if (f2 != f || f2 == 1.0f) {
                this.filter = f;
                AlbumDetailtViewBinding albumDetailtViewBinding2 = this.binding;
                if (albumDetailtViewBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                Toolbar toolbar = albumDetailtViewBinding2.toolbar;
                Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
                ViewExtendsKt.adjustTintColorByAlpha$default(toolbar, f, false, 2, null);
            }
        }
    }

    public final void notifyCommentBarChange() {
        AlbumCommentBarViewPart albumCommentBarViewPart2 = this.albumCommentBarViewPart;
        if (albumCommentBarViewPart2 != null) {
            boolean z = true;
            if (getCurrentPage() != 1) {
                z = false;
            }
            albumCommentBarViewPart2.setShowReturnAlbumView(z);
        }
        AlbumCommentBarViewPart albumCommentBarViewPart3 = this.albumCommentBarViewPart;
        if (albumCommentBarViewPart3 != null) {
            AlbumDetailViewModel albumDetailViewModel = this.viewModel;
            if (albumDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Album album = albumDetailViewModel.getAlbum();
            Intrinsics.checkNotNull(album);
            Intrinsics.checkNotNullExpressionValue(album, "viewModel.album!!");
            albumCommentBarViewPart3.bindToContent(album);
        }
    }

    /* access modifiers changed from: private */
    public final Fragment getFragmentItem(int i) {
        if (i == 0) {
            AlbumDetailListFragment.Companion companion = AlbumDetailListFragment.Companion;
            AlbumDetailViewModel albumDetailViewModel = this.viewModel;
            if (albumDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Album album = albumDetailViewModel.getAlbum();
            Intrinsics.checkNotNull(album);
            return companion.newInstance(album, this.replyId);
        } else if (i == 1) {
            AlbumReplyListFragmentV8.Companion companion2 = AlbumReplyListFragmentV8.Companion;
            AlbumDetailViewModel albumDetailViewModel2 = this.viewModel;
            if (albumDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Album album2 = albumDetailViewModel2.getAlbum();
            Intrinsics.checkNotNull(album2);
            Intrinsics.checkNotNullExpressionValue(album2, "viewModel.album!!");
            return companion2.newInstance(album2);
        } else {
            throw new RuntimeException("unknown..");
        }
    }

    private final ViewPager.OnPageChangeListener onPageChangeListener() {
        return new AlbumDetailActivity$onPageChangeListener$1(this);
    }

    public final Fragment getViewPagerFragment(int i) {
        Object obj;
        DataAdapter dataAdapter = this.adapter;
        if (dataAdapter != null) {
            AlbumDetailtViewBinding albumDetailtViewBinding = this.binding;
            if (albumDetailtViewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            obj = dataAdapter.instantiateItem((ViewGroup) albumDetailtViewBinding.viewPager, i);
        } else {
            obj = null;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return (Fragment) obj;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/album/albumv8/AlbumDetailActivity$DataAdapter;", "Lcom/coolapk/market/view/base/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Lcom/coolapk/market/view/album/albumv8/AlbumDetailActivity;Landroidx/fragment/app/FragmentManager;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "any", "", "getItemTag", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AlbumDetailActivity.kt */
    public final class DataAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ AlbumDetailActivity this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "any");
            return -2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(AlbumDetailActivity albumDetailActivity, FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNullParameter(fragmentManager, "fm");
            this.this$0 = albumDetailActivity;
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.this$0.getFragmentItem(i);
        }

        @Override // com.coolapk.market.view.base.FragmentStatePagerAdapter
        public String getItemTag(int i) {
            return String.valueOf(i);
        }
    }
}
