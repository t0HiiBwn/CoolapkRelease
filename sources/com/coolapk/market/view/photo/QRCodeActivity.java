package com.coolapk.market.view.photo;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.Qr.Symbol;
import cn.bertsir.zbar.ScanCallback;
import cn.bertsir.zbar.utils.QRUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.QrCodeBinding;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.camera.CameraPreview;
import com.hjq.permissions.XXPermissions;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0014J\"\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0011H\u0014J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0011H\u0016J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\u0011H\u0014J\b\u0010+\u001a\u00020\u0011H\u0014J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\tH\u0002J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/coolapk/market/view/photo/QRCodeActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcn/bertsir/zbar/ScanCallback;", "()V", "animator", "Landroid/animation/ValueAnimator;", "binding", "Lcom/coolapk/market/databinding/QrCodeBinding;", "lastParsedContent", "", "lastParsedTime", "", "oldDist", "", "parsingQRText", "", "decodeImage", "", "path", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "hideResultView", "init", "initSearchMenu", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onScanResult", "result", "Lcn/bertsir/zbar/Qr/ScanResult;", "text", "onSetStatusBarColor", "onSetStatusBarDarkMode", "processAppQrCode", "processOtherText", "restartCamera", "startCamera", "stopCamera", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QRCodeActivity.kt */
public final class QRCodeActivity extends BaseActivity implements ScanCallback {
    private ValueAnimator animator;
    private QrCodeBinding binding;
    private String lastParsedContent = "";
    private long lastParsedTime;
    private float oldDist;
    private boolean parsingQRText;

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarDarkMode() {
    }

    public static final /* synthetic */ QrCodeBinding access$getBinding$p(QRCodeActivity qRCodeActivity) {
        QrCodeBinding qrCodeBinding = qRCodeActivity.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return qrCodeBinding;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XXPermissions permission = XXPermissions.with((FragmentActivity) this).permission("android.permission.CAMERA");
        Intrinsics.checkNotNullExpressionValue(permission, "XXPermissions.with(this)…nifest.permission.CAMERA)");
        LibraryExtentsKt.asObservable(permission).subscribe((Subscriber<? super Boolean>) new QRCodeActivity$onCreate$1(this));
    }

    /* access modifiers changed from: private */
    public final void init() {
        try {
            ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559112);
            Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…w(this, R.layout.qr_code)");
            this.binding = (QrCodeBinding) contentView;
            Symbol.looperScan = true;
            Symbol.is_only_scan_center = true;
            Symbol.scanType = 1;
            Symbol.scanFormat = 1;
            Symbol.is_auto_zoom = false;
            QrCodeBinding qrCodeBinding = this.binding;
            if (qrCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding.cropLayout.setAspectRatio(1.0f);
            QrCodeBinding qrCodeBinding2 = this.binding;
            if (qrCodeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding2.toolbar.setNavigationOnClickListener(new QRCodeActivity$init$1(this));
            QrCodeBinding qrCodeBinding3 = this.binding;
            if (qrCodeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            Toolbar toolbar = qrCodeBinding3.toolbar;
            Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
            toolbar.setTitle(getTitle());
            QrCodeBinding qrCodeBinding4 = this.binding;
            if (qrCodeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding4.myQrView.setOnClickListener(new QRCodeActivity$init$2(this));
            QrCodeBinding qrCodeBinding5 = this.binding;
            if (qrCodeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding5.readImageView.setOnClickListener(new QRCodeActivity$init$3(this));
            ThemeUtils.setNavigationBarColor(getActivity(), 1711276032);
            if (isResume()) {
                startCamera();
            }
            QrCodeBinding qrCodeBinding6 = this.binding;
            if (qrCodeBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding6.captureContainer.addOnLayoutChangeListener(new QRCodeActivity$init$4(this));
            QrCodeBinding qrCodeBinding7 = this.binding;
            if (qrCodeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding7.mainContent.addOnInsetChangeListener(new QRCodeActivity$init$5(this));
        } catch (Exception e) {
            e.printStackTrace();
            AppHolder.getThirdPartUtils().markException(e);
            Toast.show$default(getActivity(), "没有找到相机", 0, false, 12, null);
            getActivity().finish();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.binding != null) {
            QrCodeBinding qrCodeBinding = this.binding;
            if (qrCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            CameraPreview cameraPreview = qrCodeBinding.qrView;
            Intrinsics.checkNotNullExpressionValue(cameraPreview, "binding.qrView");
            if (cameraPreview.isPreviewStart()) {
                int action = motionEvent.getAction() & 255;
                if (action != 2) {
                    if (action == 5) {
                        this.oldDist = QRUtils.getInstance().getFingerSpacing(motionEvent);
                    }
                } else if (motionEvent.getPointerCount() == 2) {
                    float fingerSpacing = QRUtils.getInstance().getFingerSpacing(motionEvent);
                    float f = this.oldDist;
                    if (fingerSpacing > f) {
                        QrCodeBinding qrCodeBinding2 = this.binding;
                        if (qrCodeBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        qrCodeBinding2.qrView.handleZoom(true);
                    } else if (fingerSpacing < f) {
                        QrCodeBinding qrCodeBinding3 = this.binding;
                        if (qrCodeBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        qrCodeBinding3.qrView.handleZoom(false);
                    }
                    this.oldDist = fingerSpacing;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.binding != null) {
            QrCodeBinding qrCodeBinding = this.binding;
            if (qrCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            CameraPreview cameraPreview = qrCodeBinding.qrView;
            Intrinsics.checkNotNullExpressionValue(cameraPreview, "binding.qrView");
            if (!cameraPreview.isPreviewStart()) {
                startCamera();
            }
        }
    }

    private final void startCamera() {
        QrCodeBinding qrCodeBinding = this.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding.qrView.start();
        QrCodeBinding qrCodeBinding2 = this.binding;
        if (qrCodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding2.qrView.setScanCallback(this);
        QrCodeBinding qrCodeBinding3 = this.binding;
        if (qrCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View view = qrCodeBinding3.scanLineView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.scanLineView");
        view.setVisibility(0);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(2500L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.addUpdateListener(new QRCodeActivity$startCamera$$inlined$apply$lambda$1(this));
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            if (ofFloat != null) {
                ofFloat.start();
            }
            this.animator = ofFloat;
            return;
        }
        valueAnimator.resume();
    }

    private final void stopCamera() {
        QrCodeBinding qrCodeBinding = this.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding.qrView.stop();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        QrCodeBinding qrCodeBinding2 = this.binding;
        if (qrCodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View view = qrCodeBinding2.scanLineView;
        Intrinsics.checkNotNullExpressionValue(view, "binding.scanLineView");
        view.setVisibility(8);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.binding != null) {
            stopCamera();
        }
    }

    @Override // cn.bertsir.zbar.ScanCallback
    public void onScanResult(ScanResult scanResult) {
        if (scanResult != null) {
            String str = scanResult.content;
            Intrinsics.checkNotNullExpressionValue(str, "result.content");
            onScanResult(str);
        }
    }

    /* access modifiers changed from: private */
    public final void onScanResult(String str) {
        if (!this.parsingQRText) {
            if (!Intrinsics.areEqual(this.lastParsedContent, str) || System.currentTimeMillis() - this.lastParsedTime >= 600) {
                this.lastParsedContent = str;
                this.lastParsedTime = System.currentTimeMillis();
                Object systemService = getSystemService("vibrator");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                Vibrator vibrator = (Vibrator) systemService;
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(30, 10));
                } else {
                    vibrator.vibrate(30);
                }
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                if (parse.getHost() != null) {
                    String host = parse.getHost();
                    Intrinsics.checkNotNull(host);
                    Intrinsics.checkNotNullExpressionValue(host, "uri.host!!");
                    if (StringsKt.endsWith$default(host, ".coolapk.com", false, 2, (Object) null) && parse.getQueryParameter("qr") != null) {
                        processAppQrCode(str);
                        return;
                    }
                }
                if (UriUtils.getActionTypeFromUrl(str) == null) {
                    processOtherText(str);
                    return;
                }
                ActionManager.startActivityByUrl(getActivity(), str);
                getActivity().finish();
            }
        }
    }

    private final void processAppQrCode(String str) {
        this.parsingQRText = true;
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(false);
        progressDialog.setMessage(getActivity().getString(2131886160));
        progressDialog.setProgressStyle(0);
        progressDialog.show();
        DataManager.getInstance().getQRCodeResult(Uri.parse(str).getQueryParameter("qr")).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).doOnUnsubscribe(new QRCodeActivity$processAppQrCode$1(this, progressDialog)).subscribe((Subscriber<? super R>) new QRCodeActivity$processAppQrCode$2(this));
    }

    /* access modifiers changed from: private */
    public final void restartCamera() {
        QrCodeBinding qrCodeBinding = this.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding.qrView.stop();
        QrCodeBinding qrCodeBinding2 = this.binding;
        if (qrCodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding2.qrView.start();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.binding != null) {
            QrCodeBinding qrCodeBinding = this.binding;
            if (qrCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            RelativeLayout relativeLayout = qrCodeBinding.resultView;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.resultView");
            if (relativeLayout.isShown()) {
                hideResultView();
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 3925) {
            Intrinsics.checkNotNull(intent);
            Uri data = intent.getData();
            if (data != null) {
                decodeImage(data.getPath());
            }
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.binding != null) {
            QrCodeBinding qrCodeBinding = this.binding;
            if (qrCodeBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            qrCodeBinding.qrView.destroy();
        }
    }

    private final void decodeImage(String str) {
        Observable.just(str).map(QRCodeActivity$decodeImage$1.INSTANCE).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new QRCodeActivity$decodeImage$2(this));
    }

    private final void processOtherText(String str) {
        QrCodeBinding qrCodeBinding = this.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = qrCodeBinding.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setText(str);
        QrCodeBinding qrCodeBinding2 = this.binding;
        if (qrCodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding2.actionOpen.setOnClickListener(new QRCodeActivity$processOtherText$1(this, str));
        QrCodeBinding qrCodeBinding3 = this.binding;
        if (qrCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding3.actionCopy.setOnClickListener(new QRCodeActivity$processOtherText$2(this, str));
        QrCodeBinding qrCodeBinding4 = this.binding;
        if (qrCodeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding4.imageView.setOnClickListener(new QRCodeActivity$processOtherText$3(this));
        QrCodeBinding qrCodeBinding5 = this.binding;
        if (qrCodeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        qrCodeBinding5.resultMaskView.setOnClickListener(new QRCodeActivity$processOtherText$4(this));
        QrCodeBinding qrCodeBinding6 = this.binding;
        if (qrCodeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = qrCodeBinding6.resultMaskView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.resultMaskView");
        frameLayout.setVisibility(0);
        QrCodeBinding qrCodeBinding7 = this.binding;
        if (qrCodeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TransitionManager.beginDelayedTransition(qrCodeBinding7.resultView, new Slide());
        QrCodeBinding qrCodeBinding8 = this.binding;
        if (qrCodeBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RelativeLayout relativeLayout = qrCodeBinding8.resultView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.resultView");
        relativeLayout.setVisibility(0);
        ThemeUtils.setNavigationBarColor(getActivity(), ColorUtils.darkerColor(AppHolder.getAppTheme().getContentBackgroundColor(), 0.85f));
    }

    /* access modifiers changed from: private */
    public final void hideResultView() {
        QrCodeBinding qrCodeBinding = this.binding;
        if (qrCodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TransitionManager.beginDelayedTransition(qrCodeBinding.resultView, new Slide());
        QrCodeBinding qrCodeBinding2 = this.binding;
        if (qrCodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewPropertyAnimator animate = qrCodeBinding2.resultView.animate();
        QrCodeBinding qrCodeBinding3 = this.binding;
        if (qrCodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RelativeLayout relativeLayout = qrCodeBinding3.resultView;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.resultView");
        animate.translationY((float) relativeLayout.getHeight()).setListener(new QRCodeActivity$hideResultView$1(this)).start();
    }
}
