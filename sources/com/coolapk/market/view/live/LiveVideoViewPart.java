package com.coolapk.market.view.live;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.KeyboardUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.ImageLoaderOptions;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.app.OnImageLoadListener;
import com.coolapk.market.databinding.ItemLiveVideoViewPartBinding;
import com.coolapk.market.event.ActivityResumeEvent;
import com.coolapk.market.event.ApplicationVisibleEvent;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.Video;
import com.coolapk.market.util.NotchUtil;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.refresh.BasePopMenu;
import com.coolapk.market.view.danmaku.DanmakuManager;
import com.coolapk.market.view.danmaku.EasyDanmakuBehavior;
import com.coolapk.market.view.feed.ReplyActivity;
import com.coolapk.market.view.photo.PhotoPickerActivity;
import com.coolapk.market.view.photo.PhotoViewActivity;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.FloatWindowBridge;
import com.coolapk.market.widget.video.PlayerArg;
import com.coolapk.market.widget.video.SharedPlayer;
import com.coolapk.market.widget.video.VideoManager;
import com.coolapk.market.widget.video.VideoModel;
import com.coolapk.market.widget.video.VideoModelKt;
import com.coolapk.market.widget.video.VideoPlayerBridge;
import com.coolapk.market.widget.video.cover.BaseControlCover;
import com.kk.taurus.playerbase.assist.RelationAssist;
import com.kk.taurus.playerbase.receiver.GroupValue;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.render.AspectRatio;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 k2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u0004:\u0001kB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\"J\u0006\u0010:\u001a\u000208J\u0006\u0010;\u001a\u000208J\b\u0010<\u001a\u00020=H\u0016J\u0006\u0010>\u001a\u000208J\u0006\u0010?\u001a\u000208J\u0006\u0010@\u001a\u000208J\u0006\u0010A\u001a\u000208J\b\u0010B\u001a\u00020\u0019H\u0007J\u0010\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u0019H\u0003J\u000e\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020GJ'\u0010H\u001a\u0002082\u0006\u0010I\u001a\u0002022\u0010\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010L\u0018\u00010KH\u0016¢\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020PH\u0007J\u0010\u0010Q\u001a\u0002082\u0006\u0010O\u001a\u00020RH\u0007J\u0010\u0010S\u001a\u0002082\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010T\u001a\u0002082\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010U\u001a\u0002082\u0006\u0010V\u001a\u00020WH\u0016J\u001a\u0010X\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\b\u0010]\u001a\u000208H\u0016J\u001a\u0010^\u001a\u0002082\u0006\u0010_\u001a\u00020G2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u000208H\u0014J\b\u0010c\u001a\u000208H\u0002J\u000e\u0010d\u001a\u0002082\u0006\u0010e\u001a\u00020fJ\u0006\u0010g\u001a\u000208J\b\u0010h\u001a\u000208H\u0002J\b\u0010i\u001a\u000208H\u0002J\u0006\u0010j\u001a\u000208R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00198B@CX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u0002028BX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006l"}, d2 = {"Lcom/coolapk/market/view/live/LiveVideoViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemLiveVideoViewPartBinding;", "Lcom/coolapk/market/model/Live;", "Lcom/coolapk/market/widget/video/VideoPlayerBridge;", "activity", "Lcom/coolapk/market/view/live/LiveActivity;", "viewModel", "Lcom/coolapk/market/view/live/LiveViewModel;", "presenter", "Lcom/coolapk/market/view/live/LivePresenter;", "(Lcom/coolapk/market/view/live/LiveActivity;Lcom/coolapk/market/view/live/LiveViewModel;Lcom/coolapk/market/view/live/LivePresenter;)V", "getActivity", "()Lcom/coolapk/market/view/live/LiveActivity;", "assist", "Lcom/kk/taurus/playerbase/assist/RelationAssist;", "danmakuManager", "Lcom/coolapk/market/view/danmaku/DanmakuManager;", "getDanmakuManager", "()Lcom/coolapk/market/view/danmaku/DanmakuManager;", "setDanmakuManager", "(Lcom/coolapk/market/view/danmaku/DanmakuManager;)V", "data", "Lcom/coolapk/market/widget/video/VideoModel;", "isAvailable", "", "()Z", "isDanmakuFrameShow", "isFullScreen", "value", "isLandscape", "setLandscape", "(Z)V", "lastRect", "Landroid/graphics/Rect;", "liveControllerCover", "Lcom/coolapk/market/view/live/LiveVideoControllerCover;", "liveLineSelectViewPart", "Lcom/coolapk/market/view/live/LiveLineSelectViewPart;", "livePost", "Lcom/coolapk/market/view/live/LivePost;", "maxLengthFilter", "Landroid/text/InputFilter$LengthFilter;", "player", "Lcom/coolapk/market/widget/video/SharedPlayer;", "getPresenter", "()Lcom/coolapk/market/view/live/LivePresenter;", "receiverGroup", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup;", "sourceKey", "", "getSourceKey", "()Ljava/lang/String;", "getViewModel", "()Lcom/coolapk/market/view/live/LiveViewModel;", "applyWindowsInset", "", "rect", "detachVideoWhenFinish", "enterFloatingWindow", "getPlayerArg", "Lcom/coolapk/market/widget/video/PlayerArg;", "handleActivityDestroy", "handleActivityPause", "handleActivityResume", "handleActivityStop", "handleBackPress", "handleOrientation", "ifFullScreen", "offsetBottomContainerWithSoftHeight", "height", "", "onAction", "actionType", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "onActivityResume", "event", "Lcom/coolapk/market/event/ActivityResumeEvent;", "onApplicationVisibleChange", "Lcom/coolapk/market/event/ApplicationVisibleEvent;", "onAttach", "onBindToContent", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onDetach", "onEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onViewCreated", "sendMessage", "setItemViewRatio", "ratio", "", "showSelectLineView", "toggleFullScreen", "updateDanmakuUi", "updateLiveUI", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveVideoViewPart.kt */
public final class LiveVideoViewPart extends BindingViewPart<ItemLiveVideoViewPartBinding, Live> implements VideoPlayerBridge {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558817;
    private final LiveActivity activity;
    private RelationAssist assist;
    public DanmakuManager danmakuManager;
    private VideoModel data = VideoModel.Companion.getNO_VIDEO();
    private boolean isDanmakuFrameShow = true;
    private boolean isFullScreen;
    private Rect lastRect;
    private LiveVideoControllerCover liveControllerCover;
    private LiveLineSelectViewPart liveLineSelectViewPart;
    private final LivePost livePost;
    private final InputFilter.LengthFilter maxLengthFilter = new InputFilter.LengthFilter(30);
    private SharedPlayer player;
    private final LivePresenter presenter;
    private IReceiverGroup receiverGroup;
    private final LiveViewModel viewModel;

    public final void handleActivityStop() {
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAction(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "actionType");
    }

    public static final /* synthetic */ SharedPlayer access$getPlayer$p(LiveVideoViewPart liveVideoViewPart) {
        SharedPlayer sharedPlayer = liveVideoViewPart.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return sharedPlayer;
    }

    public final LiveActivity getActivity() {
        return this.activity;
    }

    public final LivePresenter getPresenter() {
        return this.presenter;
    }

    public final LiveViewModel getViewModel() {
        return this.viewModel;
    }

    public LiveVideoViewPart(LiveActivity liveActivity, LiveViewModel liveViewModel, LivePresenter livePresenter) {
        Intrinsics.checkNotNullParameter(liveActivity, "activity");
        Intrinsics.checkNotNullParameter(liveViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(livePresenter, "presenter");
        this.activity = liveActivity;
        this.viewModel = liveViewModel;
        this.presenter = livePresenter;
        this.livePost = new LivePost(liveActivity);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/LiveVideoViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveVideoViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getSourceKey() {
        return getClass().getSimpleName() + hashCode() + this.data.getKey();
    }

    private final boolean isAvailable() {
        LiveVideoViewPart liveVideoViewPart = this;
        if (liveVideoViewPart.player != null) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            if (Intrinsics.areEqual(sharedPlayer.getPlayerBridge(), liveVideoViewPart)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isLandscape() {
        return this.activity.getRequestedOrientation() == 0;
    }

    /* access modifiers changed from: private */
    public final void setLandscape(boolean z) {
        if (z) {
            this.activity.setRequestedOrientation(0);
        } else {
            this.activity.setRequestedOrientation(1);
        }
    }

    public final DanmakuManager getDanmakuManager() {
        DanmakuManager danmakuManager2 = this.danmakuManager;
        if (danmakuManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmakuManager");
        }
        return danmakuManager2;
    }

    public final void setDanmakuManager(DanmakuManager danmakuManager2) {
        Intrinsics.checkNotNullParameter(danmakuManager2, "<set-?>");
        this.danmakuManager = danmakuManager2;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemLiveVideoViewPartBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558817, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemLiveVideoViewPartBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemLiveVideoViewPartBinding) getBinding()).itemView.setAspectRatio(1.7777778f);
        ((ItemLiveVideoViewPartBinding) getBinding()).itemView.requestLayout();
        LiveVideoControllerCover liveVideoControllerCover = new LiveVideoControllerCover(getContext(), (ItemLiveVideoViewPartBinding) getBinding());
        this.liveControllerCover = liveVideoControllerCover;
        if (liveVideoControllerCover == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveControllerCover");
        }
        liveVideoControllerCover.setLiveViewModel(this.viewModel);
        ImageView imageView = ((ItemLiveVideoViewPartBinding) getBinding()).navigationView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.navigationView");
        LiveVideoViewPart liveVideoViewPart = this;
        ViewUtil.clickListener(imageView, liveVideoViewPart);
        ImageView imageView2 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.moreView");
        ViewUtil.clickListener(imageView2, liveVideoViewPart);
        ImageView imageView3 = ((ItemLiveVideoViewPartBinding) getBinding()).shareView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.shareView");
        ViewUtil.clickListener(imageView3, liveVideoViewPart);
        TextView textView = ((ItemLiveVideoViewPartBinding) getBinding()).lineTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.lineTextView");
        ViewUtil.clickListener(textView, liveVideoViewPart);
        TextView textView2 = ((ItemLiveVideoViewPartBinding) getBinding()).lineTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.lineTextView");
        textView2.setVisibility(8);
        ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView.setOnClickListener(new LiveVideoViewPart$onViewCreated$1(this));
        TextView textView3 = ((ItemLiveVideoViewPartBinding) getBinding()).lineTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.lineTextView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), -1);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 12));
        Unit unit = Unit.INSTANCE;
        textView3.setBackground(gradientDrawable);
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) getBinding()).danmakuFrame;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.danmakuFrame");
        this.danmakuManager = new DanmakuManager(new EasyDanmakuBehavior(frameLayout));
        ((ItemLiveVideoViewPartBinding) getBinding()).danmakuOpenView.setOnClickListener(new LiveVideoViewPart$onViewCreated$3(this));
        EditText editText = ((ItemLiveVideoViewPartBinding) getBinding()).danmakuSendEdit;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.danmakuSendEdit");
        editText.addTextChangedListener(new LiveVideoViewPart$onViewCreated$$inlined$addTextChangedListener$1(this));
        ((ItemLiveVideoViewPartBinding) getBinding()).danmakuSendEdit.setOnEditorActionListener(new LiveVideoViewPart$onViewCreated$5(this));
        ((ItemLiveVideoViewPartBinding) getBinding()).videoPlayer.addOnLayoutChangeListener(new LiveVideoViewPart$onViewCreated$6(this));
        ((ItemLiveVideoViewPartBinding) getBinding()).danmakuSendView.setOnClickListener(new LiveVideoViewPart$onViewCreated$7(this));
        this.livePost.setCallback(new LiveVideoViewPart$onViewCreated$8(this));
    }

    public final void offsetBottomContainerWithSoftHeight(int i) {
        LinearLayout linearLayout = ((ItemLiveVideoViewPartBinding) getBinding()).bottomContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomContainer");
        linearLayout.setTranslationY(-((float) i));
        updateDanmakuUi();
    }

    /* access modifiers changed from: private */
    public final void sendMessage() {
        EditText editText = ((ItemLiveVideoViewPartBinding) getBinding()).danmakuSendEdit;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.danmakuSendEdit");
        String obj = editText.getText().toString();
        if (obj.length() == 0) {
            Toast.show(((ItemLiveVideoViewPartBinding) getBinding()).getRoot(), 2131886847);
            return;
        }
        Live live = this.viewModel.getLive();
        if (live != null) {
            LivePost livePost2 = this.livePost;
            String id = live.getId();
            Intrinsics.checkNotNull(id);
            Intrinsics.checkNotNullExpressionValue(id, "live.id!!");
            livePost2.post(id, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Live live) {
        VideoModel videoToVideoModel;
        super.onBindToContent((LiveVideoViewPart) live);
        Video video = null;
        if (!(this.viewModel.getVideoLineKey().length() == 0)) {
            Map<String, Video> videoLineMap = this.presenter.getVideoLineMap(this.viewModel.getLiveStatus());
            if (videoLineMap.containsKey(this.viewModel.getVideoLineKey())) {
                video = videoLineMap.get(this.viewModel.getVideoLineKey());
            }
        }
        if (video == null) {
            video = live != null ? VideoModelKt.findVideo(live, Integer.valueOf(this.viewModel.getLiveStatus())) : null;
        }
        VideoModel no_video = VideoModel.Companion.getNO_VIDEO();
        if (video != null) {
            if (this.viewModel.getVideoLineKey().length() == 0) {
                this.viewModel.setVideoLineKey(VideoModelKt.findDefaultParamsKey(video));
            }
            TextView textView = ((ItemLiveVideoViewPartBinding) getBinding()).lineTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.lineTextView");
            textView.setText(this.viewModel.getVideoLineKey());
            Live live2 = this.presenter.getLive();
            if (live2 == null || (videoToVideoModel = VideoModelKt.videoToVideoModel(live2, video, Integer.valueOf(this.viewModel.getLiveStatus()))) == null || (no_video = VideoModel.copy$default(videoToVideoModel, null, null, null, null, 0, 0, false, false, this.viewModel.getVideoLineKey(), null, null, 1791, null)) == null) {
                no_video = VideoModel.Companion.getNO_VIDEO();
            }
        }
        AppHolder.setWeakValue(getSourceKey(), null);
        this.data = no_video;
        updateLiveUI();
        Live live3 = this.viewModel.getLive();
        if (live3 != null) {
            AppHolder.getContextImageLoader().displayImage((Context) this.activity, live3.getPicUrl(), ((ItemLiveVideoViewPartBinding) getBinding()).imageCover, ImageLoaderOptions.newBuilder().bitmapOnly(true).build(), (OnImageLoadListener) null, (OnBitmapTransformListener) new LiveBlurTransformation());
        }
        if (!isAvailable() && this.activity.isResume() && !this.activity.isFinishing() && this.data.isValid()) {
            VideoManager.INSTANCE.getSharedPlayer().attachPlayerBridge(this);
            if (this.viewModel.isLiveStart()) {
                TextView textView2 = ((ItemLiveVideoViewPartBinding) getBinding()).lineTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.lineTextView");
                textView2.setVisibility(0);
                ImageView imageView = ((ItemLiveVideoViewPartBinding) getBinding()).refreshView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.refreshView");
                imageView.setVisibility(0);
            }
        }
    }

    public final void updateLiveUI() {
        Live live = this.viewModel.getLive();
        int i = 8;
        if (live != null) {
            FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.upperCoverView");
            frameLayout.setVisibility(0);
            TextView textView = ((ItemLiveVideoViewPartBinding) getBinding()).peopleNumView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.peopleNumView");
            textView.setText(this.viewModel.getLivePopulateString());
            TextView textView2 = ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.subscribeView");
            textView2.setText(this.viewModel.getLiveSubscribeStateString());
            TextView textView3 = ((ItemLiveVideoViewPartBinding) getBinding()).infoView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.infoView");
            textView3.setText(this.viewModel.getLiveShowTimeString());
            ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView.setBackgroundResource(this.viewModel.getLiveSubscribeStateBackground());
            boolean z = true;
            if (!this.viewModel.isFollowLive()) {
                TextView textView4 = ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.subscribeView");
                UiUtils.setDrawableSolidColors(textView4.getBackground(), new int[]{1}, AppHolder.getAppTheme().getColorAccent());
            }
            TextView textView5 = ((ItemLiveVideoViewPartBinding) getBinding()).liveTypeView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.liveTypeView");
            textView5.setText(this.viewModel.getLiveStatusString());
            LinearLayout linearLayout = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverBottomView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.upperCoverBottomView");
            linearLayout.setVisibility(8);
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
            boolean z2 = loginSession.isAdmin() || LiveUtils.INSTANCE.currentUserIsPresenter(live);
            boolean z3 = this.viewModel.getLiveType() == 2;
            int liveStatus = this.viewModel.getLiveStatus();
            if (liveStatus == -1) {
                if (z3) {
                    Live live2 = this.viewModel.getLive();
                    if (!TextUtils.isEmpty(live2 != null ? live2.getVideoPlaybackUrl() : null)) {
                        LinearLayout linearLayout2 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverBottomView;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.upperCoverBottomView");
                        linearLayout2.setVisibility(0);
                        FrameLayout frameLayout2 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverView;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.upperCoverView");
                        frameLayout2.setVisibility(8);
                        ImageView imageView = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                        Intrinsics.checkNotNullExpressionValue(imageView, "binding.moreView");
                        if (imageView.getVisibility() != 0) {
                            ImageView imageView2 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.moreView");
                            imageView2.setVisibility(0);
                        }
                    }
                }
                TextView textView6 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleView");
                textView6.setVisibility(0);
                TextView textView7 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
                textView7.setText("直播已结束");
                TextView textView8 = ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView;
                Intrinsics.checkNotNullExpressionValue(textView8, "binding.subscribeView");
                textView8.setVisibility(8);
                TextView textView9 = ((ItemLiveVideoViewPartBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView9, "binding.infoView");
                textView9.setVisibility(8);
                if (!z2 && !z3) {
                    z = false;
                }
                if (z) {
                    i = 0;
                }
                ImageView imageView3 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.moreView");
                if (i != imageView3.getVisibility()) {
                    ImageView imageView4 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "binding.moreView");
                    imageView4.setVisibility(i);
                }
            } else if (liveStatus == 0) {
                TextView textView10 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView10, "binding.titleView");
                textView10.setVisibility(8);
                TextView textView11 = ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView;
                Intrinsics.checkNotNullExpressionValue(textView11, "binding.subscribeView");
                textView11.setVisibility(0);
                TextView textView12 = ((ItemLiveVideoViewPartBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView12, "binding.infoView");
                textView12.setVisibility(0);
                if (z2) {
                    i = 0;
                }
                ImageView imageView5 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                Intrinsics.checkNotNullExpressionValue(imageView5, "binding.moreView");
                if (i != imageView5.getVisibility()) {
                    ImageView imageView6 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "binding.moreView");
                    imageView6.setVisibility(i);
                }
            } else if (liveStatus == 1) {
                TextView textView13 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView13, "binding.titleView");
                textView13.setVisibility(0);
                TextView textView14 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
                Intrinsics.checkNotNullExpressionValue(textView14, "binding.titleView");
                textView14.setText(live.getTitle());
                TextView textView15 = ((ItemLiveVideoViewPartBinding) getBinding()).subscribeView;
                Intrinsics.checkNotNullExpressionValue(textView15, "binding.subscribeView");
                textView15.setVisibility(8);
                TextView textView16 = ((ItemLiveVideoViewPartBinding) getBinding()).infoView;
                Intrinsics.checkNotNullExpressionValue(textView16, "binding.infoView");
                textView16.setVisibility(8);
                LinearLayout linearLayout3 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverBottomView;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.upperCoverBottomView");
                linearLayout3.setVisibility(0);
                FrameLayout frameLayout3 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverView;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.upperCoverView");
                frameLayout3.setVisibility(z3 ? 8 : 0);
                if (!z2 && !z3) {
                    z = false;
                }
                if (z) {
                    i = 0;
                }
                ImageView imageView7 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                Intrinsics.checkNotNullExpressionValue(imageView7, "binding.moreView");
                if (i != imageView7.getVisibility()) {
                    ImageView imageView8 = ((ItemLiveVideoViewPartBinding) getBinding()).moreView;
                    Intrinsics.checkNotNullExpressionValue(imageView8, "binding.moreView");
                    imageView8.setVisibility(i);
                }
            }
        } else {
            FrameLayout frameLayout4 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.upperCoverView");
            frameLayout4.setVisibility(8);
        }
        updateDanmakuUi();
    }

    /* access modifiers changed from: private */
    public final void updateDanmakuUi() {
        LiveVideoViewPart$updateDanmakuUi$1 liveVideoViewPart$updateDanmakuUi$1 = new LiveVideoViewPart$updateDanmakuUi$1(this);
        LiveVideoViewPart$updateDanmakuUi$2 liveVideoViewPart$updateDanmakuUi$2 = new LiveVideoViewPart$updateDanmakuUi$2(this);
        Live live = this.viewModel.getLive();
        if (live != null) {
            int liveStatus = this.viewModel.getLiveStatus();
            if (liveStatus != -1) {
                if (liveStatus == 0 || liveStatus == 1) {
                    liveVideoViewPart$updateDanmakuUi$1.invoke();
                }
            } else if (!live.isDiscussEnable() || !TextUtils.isEmpty(live.getVideoPlaybackUrl())) {
                liveVideoViewPart$updateDanmakuUi$2.invoke();
            } else {
                liveVideoViewPart$updateDanmakuUi$1.invoke();
            }
        } else {
            liveVideoViewPart$updateDanmakuUi$2.invoke();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        switch (view.getId()) {
            case 2131362867:
                showSelectLineView();
                return;
            case 2131362982:
                Live live = this.viewModel.getLive();
                if (live != null) {
                    BasePopMenu basePopMenu = new BasePopMenu(AppHolder.getCurrentActivity(), view);
                    basePopMenu.inflate(2131623954);
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    LoginSession loginSession = instance.getLoginSession();
                    Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                    boolean z = false;
                    boolean z2 = loginSession.isAdmin() || LiveUtils.INSTANCE.currentUserIsPresenter(live);
                    MenuItem findItem = basePopMenu.getMenu().findItem(2131361865);
                    MenuItem findItem2 = basePopMenu.getMenu().findItem(2131361866);
                    MenuItem findItem3 = basePopMenu.getMenu().findItem(2131361920);
                    MenuItem findItem4 = basePopMenu.getMenu().findItem(2131361867);
                    Intrinsics.checkNotNullExpressionValue(findItem, "banPost");
                    findItem.setVisible(z2);
                    Intrinsics.checkNotNullExpressionValue(findItem2, "banPostPic");
                    findItem2.setVisible(z2);
                    Intrinsics.checkNotNullExpressionValue(findItem3, "liveStatus");
                    findItem3.setVisible(z2);
                    Intrinsics.checkNotNullExpressionValue(findItem4, "banUserManager");
                    findItem4.setVisible(z2);
                    VideoModel videoModel = VideoModelKt.toVideoModel(live, Integer.valueOf(this.viewModel.getLiveStatus()));
                    MenuItem findItem5 = basePopMenu.getMenu().findItem(2131361982);
                    MenuItem findItem6 = basePopMenu.getMenu().findItem(2131361908);
                    Intrinsics.checkNotNullExpressionValue(findItem5, "viewSource");
                    if (videoModel.isValid() && videoModel.isRedirectSource()) {
                        z = true;
                    }
                    findItem5.setVisible(z);
                    Intrinsics.checkNotNullExpressionValue(findItem6, "floatingWindow");
                    findItem6.setVisible(videoModel.isValid());
                    findItem.setTitle(live.canPost() ? "开启全员禁言" : "关闭全员禁言");
                    findItem2.setTitle(live.canPostPic() ? "开启全员禁止发图" : "关闭全员禁止发图");
                    int liveStatus = live.getLiveStatus();
                    if (liveStatus != -1) {
                        if (liveStatus != 1) {
                        }
                    }
                    findItem3.setTitle(str);
                    basePopMenu.setOnMenuItemClickListener(new LiveVideoViewPart$onClick$1(this, findItem, live, findItem2, findItem3));
                    basePopMenu.show();
                    return;
                }
                return;
            case 2131363022:
                this.activity.onBackPressed();
                return;
            case 2131363374:
                Live live2 = this.viewModel.getLive();
                if (live2 != null) {
                    ActionManager.shareText(getContext(), live2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void enterFloatingWindow() {
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        Application application2 = application;
        VideoModel videoModel = this.data;
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        FloatWindowBridge floatWindowBridge = new FloatWindowBridge(application2, videoModel, sharedPlayer.getRenderAspect());
        this.activity.finish();
        AppHolder.setWeakValue(floatWindowBridge.getSourceKey(), floatWindowBridge);
        AppHolder.getMainThreadHandler().postDelayed(new LiveVideoViewPart$enterFloatingWindow$1(floatWindowBridge), 400);
    }

    public final void detachVideoWhenFinish() {
        SharedPlayer optSharePlayer;
        SharedPlayer optSharePlayer2 = VideoManager.INSTANCE.optSharePlayer();
        if (Intrinsics.areEqual(optSharePlayer2 != null ? optSharePlayer2.getPlayerBridge() : null, this) && (optSharePlayer = VideoManager.INSTANCE.optSharePlayer()) != null) {
            optSharePlayer.detachPlayerBridge();
        }
    }

    public final void applyWindowsInset(Rect rect) {
        RelationAssist relationAssist;
        IReceiverGroup receiverGroup2;
        GroupValue groupValue;
        RelationAssist relationAssist2;
        IReceiverGroup receiverGroup3;
        GroupValue groupValue2;
        Intrinsics.checkNotNullParameter(rect, "rect");
        NotchUtil notchUtil = NotchUtil.INSTANCE;
        Window window = this.activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        if (notchUtil.hasStatusCutout(window)) {
            ((ItemLiveVideoViewPartBinding) getBinding()).topContainer.setPadding(0, rect.top, 0, 0);
            LinearLayout linearLayout = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverBottomView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.upperCoverBottomView");
            TextView textView = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            RelativeLayout relativeLayout = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverSubscribeView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.upperCoverSubscribeView");
            View[] viewArr = {linearLayout, textView, relativeLayout};
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
                if (marginParams != null) {
                    marginParams.topMargin = rect.top;
                }
                view.requestLayout();
            }
            if (!(!isAvailable() || (relationAssist2 = this.assist) == null || (receiverGroup3 = relationAssist2.getReceiverGroup()) == null || (groupValue2 = receiverGroup3.getGroupValue()) == null)) {
                groupValue2.putObject("apply_windows_insets", rect);
            }
        } else {
            ((ItemLiveVideoViewPartBinding) getBinding()).topContainer.setPadding(0, rect.top, 0, 0);
            LinearLayout linearLayout2 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverBottomView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.upperCoverBottomView");
            TextView textView2 = ((ItemLiveVideoViewPartBinding) getBinding()).titleView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
            RelativeLayout relativeLayout2 = ((ItemLiveVideoViewPartBinding) getBinding()).upperCoverSubscribeView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.upperCoverSubscribeView");
            View[] viewArr2 = {linearLayout2, textView2, relativeLayout2};
            for (int i2 = 0; i2 < 3; i2++) {
                View view2 = viewArr2[i2];
                ViewGroup.MarginLayoutParams marginParams2 = ViewExtendsKt.getMarginParams(view2);
                if (marginParams2 != null) {
                    marginParams2.topMargin = 0;
                }
                view2.requestLayout();
            }
            if (!(!isAvailable() || (relationAssist = this.assist) == null || (receiverGroup2 = relationAssist.getReceiverGroup()) == null || (groupValue = receiverGroup2.getGroupValue()) == null)) {
                groupValue.putObject("apply_windows_insets", new Rect());
            }
        }
        this.lastRect = rect;
    }

    public final void handleActivityResume() {
        if (isAvailable()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.tryAutoResume();
        }
        DanmakuManager danmakuManager2 = this.danmakuManager;
        if (danmakuManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmakuManager");
        }
        danmakuManager2.resume();
    }

    public final void handleActivityPause() {
        DanmakuManager danmakuManager2 = this.danmakuManager;
        if (danmakuManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmakuManager");
        }
        danmakuManager2.pause();
    }

    public final void handleActivityDestroy() {
        this.livePost.unsubscribe();
        DanmakuManager danmakuManager2 = this.danmakuManager;
        if (danmakuManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("danmakuManager");
        }
        danmakuManager2.release();
        KeyboardUtils.unregisterSoftInputChangedListener(this.activity.getWindow());
    }

    @Subscribe
    public final void onActivityResume(ActivityResumeEvent activityResumeEvent) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(activityResumeEvent, "event");
        List<Activity> activityList = AppHolder.getActivityStackManager().getActivityList();
        int indexOf = activityList.indexOf(this.activity);
        if (indexOf >= 0) {
            boolean z2 = true;
            Iterator<T> it2 = activityList.subList(indexOf + 1, activityList.size()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                T t2 = t;
                if ((t2 instanceof PhotoViewActivity) || (t2 instanceof ReplyActivity) || (t2 instanceof LiveReplyListActivity) || (t2 instanceof PhotoPickerActivity)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            if (t == null) {
                z2 = false;
            }
            if (z2) {
                SharedPlayer sharedPlayer = this.player;
                if (sharedPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("player");
                }
                sharedPlayer.reset();
            }
        }
    }

    @Subscribe
    public final void onApplicationVisibleChange(ApplicationVisibleEvent applicationVisibleEvent) {
        Intrinsics.checkNotNullParameter(applicationVisibleEvent, "event");
        if (!applicationVisibleEvent.isShown()) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            sharedPlayer.reset();
        }
    }

    public final boolean handleBackPress() {
        if (!this.isFullScreen) {
            return false;
        }
        toggleFullScreen();
        return true;
    }

    public final void showSelectLineView() {
        Map<String, Video> videoLineMap = this.presenter.getVideoLineMap(this.viewModel.getLiveStatus());
        if (!videoLineMap.isEmpty()) {
            LiveVideoControllerCover liveVideoControllerCover = this.liveControllerCover;
            if (liveVideoControllerCover == null) {
                Intrinsics.throwUninitializedPropertyAccessException("liveControllerCover");
            }
            BaseControlCover.setControllerState$default(liveVideoControllerCover, false, null, 2, null);
            if (this.liveLineSelectViewPart == null) {
                LiveLineSelectViewPart liveLineSelectViewPart2 = new LiveLineSelectViewPart();
                LayoutInflater from = LayoutInflater.from(getContext());
                Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(context)");
                liveLineSelectViewPart2.createView(from, ((ItemLiveVideoViewPartBinding) getBinding()).selectLineView);
                liveLineSelectViewPart2.setOnCloseListener(new LiveVideoViewPart$showSelectLineView$1(this));
                ((ItemLiveVideoViewPartBinding) getBinding()).selectLineView.addView(liveLineSelectViewPart2.getView());
                this.liveLineSelectViewPart = liveLineSelectViewPart2;
            }
            LiveLineSelectViewPart liveLineSelectViewPart3 = this.liveLineSelectViewPart;
            Intrinsics.checkNotNull(liveLineSelectViewPart3);
            String videoLineKey = this.viewModel.getVideoLineKey();
            liveLineSelectViewPart3.bindAndShow(this.isFullScreen, CollectionsKt.toList(videoLineMap.keySet()), videoLineKey, new LiveVideoViewPart$showSelectLineView$2(this, videoLineKey, videoLineMap));
            FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) getBinding()).selectLineView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.selectLineView");
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onAttach(RelationAssist relationAssist) {
        Intrinsics.checkNotNullParameter(relationAssist, "assist");
        this.player = VideoManager.INSTANCE.getSharedPlayer();
        IReceiverGroup receiverGroup2 = relationAssist.getReceiverGroup();
        Intrinsics.checkNotNullExpressionValue(receiverGroup2, "assist.receiverGroup");
        this.receiverGroup = receiverGroup2;
        IReceiverGroup receiverGroup3 = relationAssist.getReceiverGroup();
        LiveVideoControllerCover liveVideoControllerCover = this.liveControllerCover;
        if (liveVideoControllerCover == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveControllerCover");
        }
        receiverGroup3.addReceiver("proxy_cover", liveVideoControllerCover);
        relationAssist.setAspectRatio(AspectRatio.AspectRatio_FIT_PARENT);
        if (this.lastRect != null) {
            IReceiverGroup receiverGroup4 = relationAssist.getReceiverGroup();
            Intrinsics.checkNotNullExpressionValue(receiverGroup4, "assist.receiverGroup");
            receiverGroup4.getGroupValue().putObject("apply_windows_insets", this.lastRect);
        }
        this.assist = relationAssist;
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.setHandleByActivity(true);
        EventBus.getDefault().register(this);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onDetach() {
        this.assist = null;
        SharedPlayer sharedPlayer = this.player;
        if (sharedPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        sharedPlayer.setHandleByActivity(false);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public PlayerArg getPlayerArg() {
        Set of = SetsKt.setOf((Object[]) new String[]{"complete_cover", "loading_cover", "error_cover", "gesture_cover"});
        FrameLayout frameLayout = ((ItemLiveVideoViewPartBinding) getBinding()).videoPlayer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.videoPlayer");
        return new PlayerArg(frameLayout, this.data, of, false);
    }

    @Override // com.coolapk.market.widget.video.VideoPlayerBridge
    public void onEvent(int i, Bundle bundle) {
        if (i == -99015) {
            handleOrientation(this.isFullScreen);
        } else if (i == -107) {
            Entity relatedEntity = this.data.getRelatedEntity();
            if (relatedEntity != null) {
                ActionManager.shareText(getContext(), relatedEntity);
            }
        } else if (i == -104) {
            toggleFullScreen();
        } else if (i == -100) {
            this.activity.onBackPressed();
        }
    }

    private final void toggleFullScreen() {
        boolean z = true;
        boolean isLandscape = isLandscape();
        handleOrientation(!this.isFullScreen);
        boolean isLandscape2 = isLandscape();
        if (isLandscape || isLandscape2) {
            z = false;
        }
        this.isFullScreen = this.activity.requireToggleVideoFullScreen(z);
        LiveVideoControllerCover liveVideoControllerCover = this.liveControllerCover;
        if (liveVideoControllerCover == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveControllerCover");
        }
        liveVideoControllerCover.setFullScreen(this.isFullScreen);
        updateDanmakuUi();
    }

    public final void setItemViewRatio(float f) {
        ((ItemLiveVideoViewPartBinding) getBinding()).itemView.setAspectRatio(f);
        ((ItemLiveVideoViewPartBinding) getBinding()).itemView.requestLayout();
    }

    private final void handleOrientation(boolean z) {
        if (z) {
            SharedPlayer sharedPlayer = this.player;
            if (sharedPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("player");
            }
            int i = sharedPlayer.getRenderAspect() > ((float) 1) ? 1 : 0;
            if (i != 0) {
                this.activity.setRequestedOrientation(i ^ 1);
            }
        } else {
            this.activity.setRequestedOrientation(1);
        }
        this.activity.getRequestedOrientation();
        RelationAssist relationAssist = this.assist;
        if (relationAssist != null) {
            IReceiverGroup receiverGroup2 = relationAssist.getReceiverGroup();
            Intrinsics.checkNotNullExpressionValue(receiverGroup2, "assist.receiverGroup");
            receiverGroup2.getGroupValue().putBoolean("isLandscape", isLandscape());
        }
    }
}
