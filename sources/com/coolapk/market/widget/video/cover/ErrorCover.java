package com.coolapk.market.widget.video.cover;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.VideoErrorBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.VideoManager;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.utils.NetworkUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u001a\u0010)\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010'H\u0016J\b\u00100\u001a\u00020\u0011H\u0002J\u001a\u00101\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u00102\u001a\u00020\tH\u0002J\b\u00103\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/coolapk/market/widget/video/cover/ErrorCover;", "Lcom/coolapk/market/widget/video/cover/ThemeableCover;", "Lcom/kk/taurus/playerbase/receiver/IReceiverGroup$OnGroupValueUpdateListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/coolapk/market/databinding/VideoErrorBinding;", "currentPosition", "", "errorShow", "", "isPausedByUser", "isStartWithMobileNetwork", "retryIfCommonError", "status", "checkNetworkState", "", "networkState", "filterKeys", "", "", "()[Ljava/lang/String;", "getCoverLevel", "handleAction1", "handleAction2", "onClick", "v", "Landroid/view/View;", "onCoverAttachedToWindow", "onCreateCoverView", "onErrorEvent", "eventCode", "bundle", "Landroid/os/Bundle;", "onPlayerEvent", "onProducerData", "key", "data", "", "onReceiverBind", "onReceiverEvent", "onReceiverUnBind", "onThemeChange", "appTheme", "Lcom/coolapk/market/AppTheme;", "onValueUpdate", "value", "sendRetryCommand", "setErrorState", "extra", "setViewBackground", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ErrorCover.kt */
public final class ErrorCover extends ThemeableCover implements IReceiverGroup.OnGroupValueUpdateListener {
    public static final Companion Companion = new Companion(null);
    public static final boolean RETRY_IF_COMMON_ERROR_ENABLE = true;
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_MOBILE = 1;
    public static final int STATUS_NETWORK_ERROR = 2;
    public static final int STATUS_UNDEFINE = 0;
    private VideoErrorBinding binding;
    private int currentPosition;
    private boolean errorShow;
    private boolean isPausedByUser;
    private boolean isStartWithMobileNetwork;
    private boolean retryIfCommonError = true;
    private int status;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorCover(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ VideoErrorBinding access$getBinding$p(ErrorCover errorCover) {
        VideoErrorBinding videoErrorBinding = errorCover.binding;
        if (videoErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return videoErrorBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/coolapk/market/widget/video/cover/ErrorCover$Companion;", "", "()V", "RETRY_IF_COMMON_ERROR_ENABLE", "", "STATUS_ERROR", "", "STATUS_MOBILE", "STATUS_NETWORK_ERROR", "STATUS_UNDEFINE", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ErrorCover.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverBind() {
        super.onReceiverBind();
        getGroupValue().registerOnGroupValueUpdateListener(this);
        this.isPausedByUser = false;
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverUnBind() {
        super.onReceiverUnBind();
        getGroupValue().unregisterOnGroupValueUpdateListener(this);
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public String[] filterKeys() {
        return new String[]{"apply_windows_insets"};
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnGroupValueUpdateListener
    public void onValueUpdate(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (str.hashCode() == -488065757 && str.equals("apply_windows_insets")) {
            if (!(obj instanceof Rect)) {
                obj = null;
            }
            Rect rect = (Rect) obj;
            if (rect == null) {
                rect = new Rect();
            }
            View view = getView();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
            if (marginParams != null) {
                marginParams.topMargin = rect.top;
            }
            getView().requestLayout();
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    protected void onCoverAttachedToWindow() {
        super.onCoverAttachedToWindow();
        boolean z = true;
        this.retryIfCommonError = true;
        int networkState = NetworkUtils.getNetworkState(getContext());
        if (getGroupValue().getBoolean("error_show", false)) {
            setErrorState(getGroupValue().getInt("last_error_state", 0), getGroupValue().getInt("last_error_extra", 0));
        } else {
            if (networkState == 1) {
                z = false;
            }
            this.isStartWithMobileNetwork = z;
            checkNetworkState(networkState);
        }
        View view = getView();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ViewGroup.MarginLayoutParams marginParams = ViewExtendsKt.getMarginParams(view);
        if (marginParams != null) {
            marginParams.topMargin = 0;
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        super.onClick(view);
        switch (view.getId()) {
            case 2131361982:
                handleAction1();
                return;
            case 2131361983:
                handleAction2();
                return;
            default:
                return;
        }
    }

    private final void handleAction1() {
        int i = this.status;
        if (i == -1) {
            notifyReceiverEvent(-122, null);
        } else if (i == 1) {
            getGroupValue().putBoolean("ignore_following_network_event", true);
            VideoManager.INSTANCE.setIgnoreMobileNetwork(true);
            setErrorState$default(this, 0, 0, 2, null);
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", this.currentPosition);
            requestResume(obtain);
        }
    }

    private final void handleAction2() {
        int i = this.status;
        if (i == -1) {
            setErrorState$default(this, 0, 0, 2, null);
            sendRetryCommand();
        } else if (i == 1) {
            getGroupValue().putBoolean("ignore_following_network_event", true);
            setErrorState$default(this, 0, 0, 2, null);
            Bundle obtain = BundlePool.obtain();
            obtain.putInt("int_data", this.currentPosition);
            requestResume(obtain);
        } else if (i == 2) {
            setErrorState$default(this, 0, 0, 2, null);
            sendRetryCommand();
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseReceiver, com.kk.taurus.playerbase.receiver.IReceiver
    public void onProducerData(String str, Object obj) {
        super.onProducerData(str, obj);
        if (Intrinsics.areEqual("network_state", str)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            if (intValue == 1 && this.errorShow && AppHolder.getActivityLifeCycle().isAppForeground() && !this.isPausedByUser) {
                Bundle obtain = BundlePool.obtain();
                obtain.putInt("int_data", this.currentPosition);
                requestResume(obtain);
            }
            checkNetworkState(intValue);
        }
    }

    private final void checkNetworkState(int i) {
        if (!getGroupValue().getBoolean("network_resource")) {
            setErrorState$default(this, 0, 0, 2, null);
        } else if (i < 0) {
            setErrorState$default(this, 2, 0, 2, null);
        } else if (i == 1) {
            getGroupValue().putBoolean("ignore_following_network_event", false);
            getGroupValue().putBoolean("reset_when_mobile_network", false);
            this.isStartWithMobileNetwork = false;
            if (this.errorShow) {
                setErrorState$default(this, 0, 0, 2, null);
            } else {
                setErrorState$default(this, 0, 0, 2, null);
            }
        } else if (this.isStartWithMobileNetwork && getGroupValue().getBoolean("user_click_started", false)) {
            setErrorState$default(this, 0, 0, 2, null);
            Toast.show$default(AppHolder.getApplication(), "正在使用数据流量播放...", 0, false, 12, null);
        } else if (getGroupValue().getBoolean("ignore_following_network_event", false)) {
            setErrorState$default(this, 0, 0, 2, null);
        } else if (VideoManager.INSTANCE.getIgnoreMobileNetwork()) {
            getGroupValue().putBoolean("ignore_following_network_event", true);
            setErrorState$default(this, 0, 0, 2, null);
            Toast.show$default(AppHolder.getApplication(), "正在使用数据流量播放...", 0, false, 12, null);
        } else if (getGroupValue().getBoolean("reset_when_mobile_network", false)) {
            setErrorState$default(this, 0, 0, 2, null);
            requestReset(null);
        } else {
            setErrorState$default(this, 1, 0, 2, null);
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onReceiverEvent(int i, Bundle bundle) {
        if (i == -121) {
            this.isPausedByUser = false;
        } else if (i == -120) {
            this.isPausedByUser = true;
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onPlayerEvent(int i, Bundle bundle) {
        if (i != -99019) {
            if (i == -99004) {
                this.retryIfCommonError = true;
            } else if (i == -99001) {
                this.currentPosition = 0;
                checkNetworkState(NetworkUtils.getNetworkState(getContext()));
            }
        } else if (bundle != null) {
            this.currentPosition = bundle.getInt("int_arg1");
        }
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover, com.kk.taurus.playerbase.receiver.IReceiver
    public void onErrorEvent(int i, Bundle bundle) {
        if (!this.errorShow) {
            int valueOf = bundle != null ? Integer.valueOf(bundle.getInt("int_arg1")) : null;
            if (valueOf == null) {
                valueOf = 0;
            }
            int intValue = valueOf.intValue();
            if (i == -88011 && intValue == -10000 && this.retryIfCommonError) {
                this.retryIfCommonError = false;
                sendRetryCommand();
                return;
            }
            setErrorState(-1, i);
        }
    }

    static /* synthetic */ void setErrorState$default(ErrorCover errorCover, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        errorCover.setErrorState(i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010c  */
    private final void setErrorState(int i, int i2) {
        boolean z;
        String str;
        VideoErrorBinding videoErrorBinding;
        VideoErrorBinding videoErrorBinding2;
        String str2;
        VideoErrorBinding videoErrorBinding3;
        VideoErrorBinding videoErrorBinding4;
        VideoErrorBinding videoErrorBinding5;
        this.status = i;
        String str3 = "重新加载";
        String str4 = "";
        boolean z2 = true;
        int i3 = 0;
        if (i != -1) {
            if (i != 0) {
                if (i == 1) {
                    str4 = "播放且不再提醒";
                    str3 = "继续播放";
                    str = "正在使用2G/3G/4G网络，播放将产生流量费用";
                } else if (i == 2) {
                    str = "加载失败，请检查网络后重试";
                }
            }
            str = str4;
            str3 = str;
            z = false;
            videoErrorBinding = this.binding;
            if (videoErrorBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = videoErrorBinding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            String str5 = str4;
            textView.setVisibility(!(str5.length() != 0) ? 8 : 0);
            videoErrorBinding2 = this.binding;
            if (videoErrorBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = videoErrorBinding2.actionView2;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView2");
            str2 = str3;
            if (str2.length() != 0) {
                z2 = false;
            }
            textView2.setVisibility(!z2 ? 8 : 0);
            videoErrorBinding3 = this.binding;
            if (videoErrorBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView3 = videoErrorBinding3.actionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
            textView3.setText(str5);
            videoErrorBinding4 = this.binding;
            if (videoErrorBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView4 = videoErrorBinding4.actionView2;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.actionView2");
            textView4.setText(str2);
            videoErrorBinding5 = this.binding;
            if (videoErrorBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView5 = videoErrorBinding5.infoView;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.infoView");
            textView5.setText(str);
            this.errorShow = z;
            if (!z) {
                i3 = 8;
            }
            setCoverVisibility(i3);
            if (z) {
                notifyReceiverEvent(-111, null);
            }
            getGroupValue().putBoolean("error_show", z);
            getGroupValue().putInt("last_error_state", i);
            getGroupValue().putInt("last_error_extra", i2);
        }
        String string = getGroupValue().getString("view_source_url");
        if (getGroupValue().getBoolean("can_redirect_source", true)) {
            String str6 = string;
            if (!(str6 == null || str6.length() == 0)) {
                String string2 = getContext().getString(2131887215);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.str_view_source_url)");
                str4 = string2;
            }
        }
        str = str4.length() > 0 ? "加载失败，请重试或跳转至原链接" : "加载失败，请重试";
        if (i2 != 0) {
            str = str + " (错误代码" + i2 + ')';
        }
        z = true;
        videoErrorBinding = this.binding;
        if (videoErrorBinding == null) {
        }
        TextView textView = videoErrorBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        String str5 = str4;
        textView.setVisibility(!(str5.length() != 0) ? 8 : 0);
        videoErrorBinding2 = this.binding;
        if (videoErrorBinding2 == null) {
        }
        TextView textView2 = videoErrorBinding2.actionView2;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView2");
        str2 = str3;
        if (str2.length() != 0) {
        }
        textView2.setVisibility(!z2 ? 8 : 0);
        videoErrorBinding3 = this.binding;
        if (videoErrorBinding3 == null) {
        }
        TextView textView3 = videoErrorBinding3.actionView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.actionView");
        textView3.setText(str5);
        videoErrorBinding4 = this.binding;
        if (videoErrorBinding4 == null) {
        }
        TextView textView4 = videoErrorBinding4.actionView2;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.actionView2");
        textView4.setText(str2);
        videoErrorBinding5 = this.binding;
        if (videoErrorBinding5 == null) {
        }
        TextView textView5 = videoErrorBinding5.infoView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.infoView");
        textView5.setText(str);
        this.errorShow = z;
        if (!z) {
        }
        setCoverVisibility(i3);
        if (z) {
        }
        getGroupValue().putBoolean("error_show", z);
        getGroupValue().putInt("last_error_state", i);
        getGroupValue().putInt("last_error_extra", i2);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover
    public View onCreateCoverView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), 2131559300, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…video_error, null, false)");
        VideoErrorBinding videoErrorBinding = (VideoErrorBinding) inflate;
        this.binding = videoErrorBinding;
        if (videoErrorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ErrorCover errorCover = this;
        videoErrorBinding.actionView.setOnClickListener(errorCover);
        VideoErrorBinding videoErrorBinding2 = this.binding;
        if (videoErrorBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoErrorBinding2.actionView2.setOnClickListener(errorCover);
        VideoErrorBinding videoErrorBinding3 = this.binding;
        if (videoErrorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        videoErrorBinding3.actionView2.setTextColor(-1);
        setViewBackground();
        VideoErrorBinding videoErrorBinding4 = this.binding;
        if (videoErrorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = videoErrorBinding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setViewBackground() {
        if (this.binding != null) {
            VideoErrorBinding videoErrorBinding = this.binding;
            if (videoErrorBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            videoErrorBinding.actionView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            VideoErrorBinding videoErrorBinding2 = this.binding;
            if (videoErrorBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = videoErrorBinding2.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), AppHolder.getAppTheme().getColorAccent());
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 15));
            Unit unit = Unit.INSTANCE;
            textView.setBackground(gradientDrawable);
            VideoErrorBinding videoErrorBinding3 = this.binding;
            if (videoErrorBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView2 = videoErrorBinding3.actionView2;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView2");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(AppHolder.getAppTheme().getColorAccent());
            gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 15));
            Unit unit2 = Unit.INSTANCE;
            textView2.setBackground(gradientDrawable2);
        }
    }

    private final void sendRetryCommand() {
        Bundle obtain = BundlePool.obtain();
        obtain.putInt("int_data", this.currentPosition);
        requestRetry(obtain);
        obtain.clear();
    }

    @Override // com.coolapk.market.widget.video.cover.ThemeableCover
    public void onThemeChange(AppTheme appTheme) {
        Intrinsics.checkNotNullParameter(appTheme, "appTheme");
        setViewBackground();
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseCover, com.kk.taurus.playerbase.receiver.ICover
    public int getCoverLevel() {
        return levelHigh(0);
    }
}
