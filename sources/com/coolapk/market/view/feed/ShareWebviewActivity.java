package com.coolapk.market.view.feed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ShareWebviewBinding;
import com.coolapk.market.util.AnimationUtils;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.PhotoUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.util.TipsUtil;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.webview.WebViewDialog;
import com.coolapk.market.view.webview.WebViewFragment;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.SlideUpView;
import java.io.File;
import java.util.ArrayList;
import rx.Subscriber;

public class ShareWebviewActivity extends BaseActivity {
    public static final int EXTRA_MAX_PHOTO_COUNT = 9;
    public static final String EXTRA_PHOTO_PATHS = "PICKED_PHOTO_PATHS";
    public static final String EXTRA_URL = "extra_url";
    public static final String EXTRA_URL_TITLE = "PICKED_TITLE";
    public static final int REQUEST_PICK_PHOTO = 341;
    private ShareWebviewBinding binding;

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (ShareWebviewBinding) DataBindingUtil.setContentView(getActivity(), 2131559149);
        setupSlideView();
        setupToolbar();
        setupFragment();
    }

    private void setupSlideView() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
        setSlidrEnable(false);
        this.binding.mainContent.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.feed.ShareWebviewActivity.AnonymousClass1 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareWebviewActivity.this.onBackPressed();
            }
        });
        this.binding.slideUpView.setClickable(true);
        this.binding.slideUpView.setInitTranslationY((float) DisplayUtils.dp2px(getActivity(), 120.0f));
        this.binding.slideUpView.setCallback(new SlideUpView.Callback() {
            /* class com.coolapk.market.view.feed.ShareWebviewActivity.AnonymousClass2 */

            @Override // com.coolapk.market.widget.view.SlideUpView.Callback
            public void onShow() {
                ShareWebviewActivity.this.binding.mainContent.setBackgroundColor(-1728053248);
            }

            @Override // com.coolapk.market.widget.view.SlideUpView.Callback
            public void onTranslateYChange(int i) {
                ShareWebviewActivity.this.binding.mainContent.setBackgroundColor(AnimationUtils.calculateColor(((float) i) / ((float) ShareWebviewActivity.this.binding.slideUpView.getHeight()), -1728053248, 0));
            }

            @Override // com.coolapk.market.widget.view.SlideUpView.Callback
            public void onDismiss() {
                ShareWebviewActivity.this.finish();
                ShareWebviewActivity.this.overridePendingTransition(0, 0);
            }
        });
    }

    private void setupToolbar() {
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131231211);
        drawable.mutate().setColorFilter(AppHolder.getAppTheme().getTextColorSecondary(), PorterDuff.Mode.SRC_IN);
        this.binding.toolbar.setTitleTextColor(AppHolder.getAppTheme().getTextColorSecondary());
        this.binding.toolbar.setNavigationIcon(drawable);
        setSupportActionBar(this.binding.toolbar);
        this.binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.feed.ShareWebviewActivity.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareWebviewActivity.this.onBackPressed();
            }
        });
    }

    private void setupFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (((ShareWebViewFragment) supportFragmentManager.findFragmentById(2131363614)) == null) {
            String stringExtra = getIntent().getStringExtra("extra_url");
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("PICKED_PHOTO_PATHS");
            ShareWebViewFragment newInstance = ShareWebViewFragment.newInstance(stringExtra);
            newInstance.pathList.addAll(stringArrayListExtra);
            supportFragmentManager.beginTransaction().add(2131363614, newInstance).commit();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ShareWebViewFragment shareWebViewFragment = (ShareWebViewFragment) getSupportFragmentManager().findFragmentById(2131363614);
        if (shareWebViewFragment != null) {
            shareWebViewFragment.addResultBeforeFinished();
        }
        this.binding.slideUpView.dismissView();
    }

    public static class ShareWebViewFragment extends WebViewFragment {
        private boolean hasReceiveTitleBefore = false;
        private String newTitle = "";
        private ArrayList<String> pathList = new ArrayList<>();

        @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        }

        public static ShareWebViewFragment newInstance(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("external_url", str);
            ShareWebViewFragment shareWebViewFragment = new ShareWebViewFragment();
            shareWebViewFragment.setArguments(bundle);
            return shareWebViewFragment;
        }

        @Override // com.coolapk.market.view.webview.WebViewFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (!TipsUtil.getKeyTipsSign("TIP_LINK_PIC")) {
                TipsUtil.tipSign("TIP_LINK_PIC", true);
                Toast.show(getActivity(), "长按网页中的图片可以直接添加到分享");
            }
            getWebView().setDownloadListener(null);
        }

        @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (!this.hasReceiveTitleBefore) {
                this.hasReceiveTitleBefore = true;
                this.newTitle = str;
            }
        }

        @Override // com.coolapk.market.view.webview.WebViewFragment, com.coolapk.market.view.webview.CoolWebViewCallback
        public void onLongClickUrl(WebView webView, String str) {
            final WebView.HitTestResult hitTestResult = webView.getHitTestResult();
            if (hitTestResult != null && hitTestResult.getExtra() != null) {
                if (hitTestResult.getType() == 8 || hitTestResult.getType() == 5) {
                    WebViewDialog newInstance = WebViewDialog.newInstance();
                    newInstance.setSaveImage(true);
                    newInstance.setShowCopyLink(false);
                    newInstance.setUrl(hitTestResult.getExtra());
                    newInstance.setAddToFeed(true, new Runnable() {
                        /* class com.coolapk.market.view.feed.ShareWebviewActivity.ShareWebViewFragment.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            ShareWebViewFragment.this.addPhotoToFeed(hitTestResult.getExtra());
                        }
                    });
                    newInstance.show(getChildFragmentManager(), (String) null);
                }
            }
        }

        public void addResultBeforeFinished() {
            Intent intent = new Intent();
            intent.putExtra("PICKED_PHOTO_PATHS", this.pathList);
            intent.putExtra("PICKED_TITLE", this.newTitle);
            getActivity().setResult(-1, intent);
        }

        /* access modifiers changed from: private */
        public void addPhotoToFeed(String str) {
            String generateFileOutputPath = BitmapUtil.generateFileOutputPath(getActivity(), str);
            if (this.pathList.contains(generateFileOutputPath)) {
                Toast.show(getActivity(), "图片已添加");
            } else if (this.pathList.size() >= 9) {
                Toast.show(getActivity(), "添加失败，超过 9 张图片");
            } else {
                File webViewSaveCacheFile = PhotoUtils.getWebViewSaveCacheFile(str);
                if (webViewSaveCacheFile.exists()) {
                    str = webViewSaveCacheFile.getAbsolutePath();
                }
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setProgressStyle(0);
                progressDialog.setMessage(getString(2131886820));
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                PhotoUtils.saveImageObservable(new GlideUrl(str), generateFileOutputPath, true).subscribe((Subscriber<? super File>) new EmptySubscriber<File>() {
                    /* class com.coolapk.market.view.feed.ShareWebviewActivity.ShareWebViewFragment.AnonymousClass2 */

                    public void onNext(File file) {
                        super.onNext((AnonymousClass2) file);
                        if (file.exists() && !ShareWebViewFragment.this.pathList.contains(file.getAbsolutePath())) {
                            ShareWebViewFragment.this.pathList.add(file.getAbsolutePath());
                            Toast.show(ShareWebViewFragment.this.getActivity(), "图片添加成功");
                        }
                        progressDialog.dismiss();
                    }

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        progressDialog.dismiss();
                    }
                });
            }
        }
    }
}
