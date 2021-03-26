package com.coolapk.market.view.feedv8;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ShareFeedV8Binding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ShareFeedInfo;
import com.coolapk.market.model.Video;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.video.VideoModelKt;
import com.coolapk.market.widget.view.KeyBoardLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0015H\u0014J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u000200H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lcom/coolapk/market/view/feedv8/ShareFeedV8Activity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/ShareFeedV8Binding;", "getBinding$presentation_coolapkAppRelease", "()Lcom/coolapk/market/databinding/ShareFeedV8Binding;", "setBinding$presentation_coolapkAppRelease", "(Lcom/coolapk/market/databinding/ShareFeedV8Binding;)V", "imageList", "Ljava/util/ArrayList;", "", "loadLocalAppPackageName", "mSubscription", "Lrx/subscriptions/CompositeSubscription;", "shareText", "sourcePackageName", "getSourcePackageName", "()Ljava/lang/String;", "loadShareInfo", "", "url", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onShareInfoLoadError", "e", "", "onShareInfoLoaded", "info", "Lcom/coolapk/market/model/ShareFeedInfo;", "processArgs", "saveFileFromExternal", "Landroid/net/Uri;", "uri", "setupKeyBoardMenu", "shouldReturnToMainActivity", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareFeedV8Activity.kt */
public class ShareFeedV8Activity extends FakeStatusBarActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONTENT_TEXT = "text";
    public ShareFeedV8Binding binding;
    private final ArrayList<String> imageList = new ArrayList<>();
    private String loadLocalAppPackageName;
    private final CompositeSubscription mSubscription = new CompositeSubscription();
    private String shareText;

    @Override // com.coolapk.market.view.base.BaseActivity
    public boolean shouldReturnToMainActivity() {
        return false;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feedv8/ShareFeedV8Activity$Companion;", "", "()V", "EXTRA_CONTENT_TEXT", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareFeedV8Activity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ShareFeedV8Binding getBinding$presentation_coolapkAppRelease() {
        ShareFeedV8Binding shareFeedV8Binding = this.binding;
        if (shareFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return shareFeedV8Binding;
    }

    public final void setBinding$presentation_coolapkAppRelease(ShareFeedV8Binding shareFeedV8Binding) {
        Intrinsics.checkNotNullParameter(shareFeedV8Binding, "<set-?>");
        this.binding = shareFeedV8Binding;
    }

    private final String getSourcePackageName() {
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                Uri referrer = activity.getReferrer();
                if (referrer == null) {
                    return "";
                }
                return referrer.getAuthority();
            }
        } catch (BadParcelableException e) {
            Toast.error(getActivity(), e);
        }
        return "";
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setToolbarColorEqualContentColor(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559145);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…, R.layout.share_feed_v8)");
        ShareFeedV8Binding shareFeedV8Binding = (ShareFeedV8Binding) contentView;
        this.binding = shareFeedV8Binding;
        if (shareFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        shareFeedV8Binding.setClick(this);
        ShareFeedV8Binding shareFeedV8Binding2 = this.binding;
        if (shareFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        shareFeedV8Binding2.executePendingBindings();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        if (!loginSession.isLogin()) {
            ActionManager.startLoginActivity(getActivity());
            finish();
            return;
        }
        processArgs();
        setupKeyBoardMenu();
    }

    private final void setupKeyBoardMenu() {
        ShareFeedV8Binding shareFeedV8Binding = this.binding;
        if (shareFeedV8Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = shareFeedV8Binding.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
        this.mSubscription.add(keyBoardLayout.getKeyboardObservable().subscribe((Subscriber<? super Boolean>) new ShareFeedV8Activity$setupKeyBoardMenu$s3$1(this)));
        ShareFeedV8Binding shareFeedV8Binding2 = this.binding;
        if (shareFeedV8Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout2 = shareFeedV8Binding2.keyBoardInteractLayout;
        Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
        this.mSubscription.add(keyBoardLayout2.getKeyboardHeightObservable().subscribe((Subscriber<? super Integer>) new ShareFeedV8Activity$setupKeyBoardMenu$s4$1(this)));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mSubscription.unsubscribe();
    }

    private final void processArgs() {
        Uri uri;
        ArrayList parcelableArrayListExtra;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String action = intent.getAction();
        String type = intent.getType();
        if (action == null || type == null) {
            String stringExtra = getIntent().getStringExtra("text");
            String str = stringExtra;
            if (!TextUtils.isEmpty(str)) {
                ShareFeedV8Binding shareFeedV8Binding = this.binding;
                if (shareFeedV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                shareFeedV8Binding.editText.setText(str);
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                instance.getPreferencesEditor().putString("PREF_URL_SIGN", stringExtra).apply();
                return;
            }
            UserPermissionChecker userPermissionChecker = UserPermissionChecker.INSTANCE;
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            String obj = userPermissionChecker.getClipBoardText(activity).toString();
            if (!TextUtils.isEmpty(obj) && StringUtils.isUrl(obj)) {
                String preferencesString = DataManager.getInstance().getPreferencesString("PREF_URL_SIGN", "");
                String repairUrl = StringUtils.getRepairUrl(obj);
                String str2 = repairUrl;
                if (!TextUtils.isEmpty(str2) && (!Intrinsics.areEqual(repairUrl, preferencesString))) {
                    ShareFeedV8Binding shareFeedV8Binding2 = this.binding;
                    if (shareFeedV8Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    shareFeedV8Binding2.editText.setText(str2);
                    DataManager instance2 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                    instance2.getPreferencesEditor().putString("PREF_URL_SIGN", repairUrl).apply();
                    return;
                }
                return;
            }
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1173264947) {
            if (hashCode == -58484670 && action.equals("android.intent.action.SEND_MULTIPLE")) {
                String sourcePackageName = getSourcePackageName();
                if (StringsKt.startsWith$default(type, "image/", false, 2, (Object) null) && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM")) != null) {
                    Iterator it2 = parcelableArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        Uri uri2 = (Uri) it2.next();
                        Intrinsics.checkNotNullExpressionValue(uri2, "uri");
                        Uri saveFileFromExternal = saveFileFromExternal(uri2);
                        if (BitmapUtil.isValidBitmapUri(this, saveFileFromExternal)) {
                            this.imageList.add(saveFileFromExternal.toString());
                        }
                    }
                }
                String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
                this.shareText = stringExtra2;
                if (!TextUtils.isEmpty(stringExtra2)) {
                    String extraUrl = StringUtils.getExtraUrl(getActivity(), this.shareText);
                    Intrinsics.checkNotNullExpressionValue(extraUrl, "StringUtils.getExtraUrl(activity, shareText)");
                    loadShareInfo(this.shareText, extraUrl, sourcePackageName);
                    return;
                }
            }
        } else if (action.equals("android.intent.action.SEND")) {
            String sourcePackageName2 = getSourcePackageName();
            if (StringsKt.startsWith$default(type, "image/", false, 2, (Object) null) && (uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                Uri saveFileFromExternal2 = saveFileFromExternal(uri);
                if (BitmapUtil.isValidBitmapUri(this, saveFileFromExternal2)) {
                    this.imageList.add(saveFileFromExternal2.toString());
                }
            }
            String stringExtra3 = intent.getStringExtra("android.intent.extra.TEXT");
            this.shareText = stringExtra3;
            if (!TextUtils.isEmpty(stringExtra3)) {
                String extraUrl2 = StringUtils.getExtraUrl(getActivity(), this.shareText);
                Intrinsics.checkNotNullExpressionValue(extraUrl2, "StringUtils.getExtraUrl(activity, shareText)");
                loadShareInfo(this.shareText, extraUrl2, sourcePackageName2);
                return;
            }
        }
        if (!this.imageList.isEmpty()) {
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForFeed(activity2).build(), FeedMultiPart.builder(FeedArgsFactory.multiPartForFeed().build()).imageUriList((List) Observable.from(this.imageList).map(ShareFeedV8Activity$processArgs$imageUrls$1.INSTANCE).toList().toBlocking().first()).message(StringUtils.emptyIfNull(this.shareText)).build());
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        throw r1;
     */
    private final Uri saveFileFromExternal(Uri uri) {
        File file = new File(BitmapUtil.generateFileOutputPath(this, uri.getPath()));
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        Throwable th = null;
        InputStream inputStream = openInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Throwable th2 = null;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        IOUtils.copyLarge(inputStream, fileOutputStream2);
        IOUtils.closeQuietly((OutputStream) fileOutputStream2);
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(fileOutputStream, th2);
        IOUtils.closeQuietly(inputStream);
        Unit unit2 = Unit.INSTANCE;
        CloseableKt.closeFinally(openInputStream, th);
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }

    private final void loadShareInfo(String str, String str2, String str3) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getString(2131886928));
        progressDialog.setProgressStyle(0);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        this.mSubscription.add(DataManager.getInstance().loadShareUrl(str, str2, str3).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe((Subscriber<? super R>) new ShareFeedV8Activity$loadShareInfo$subscription$1(this, progressDialog)));
    }

    protected void onShareInfoLoaded(ShareFeedInfo shareFeedInfo) {
        Intrinsics.checkNotNullParameter(shareFeedInfo, "info");
        Video parseJsonAsVideo = VideoModelKt.parseJsonAsVideo(shareFeedInfo.getMediaInfo());
        if (parseJsonAsVideo != null) {
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            FeedMultiPart multiPartForShareVideo = FeedArgsFactory.multiPartForShareVideo(activity, shareFeedInfo, parseJsonAsVideo.getName());
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForShareVideo(activity2).newBuilder().relativeInfoPickable(true).build(), multiPartForShareVideo);
        } else {
            List list = (List) Observable.from(this.imageList).map(ShareFeedV8Activity$onShareInfoLoaded$imageUrls$1.INSTANCE).toList().toBlocking().first();
            List list2 = (List) Observable.from(shareFeedInfo.getImgList()).map(ShareFeedV8Activity$onShareInfoLoaded$infoUrls$1.INSTANCE).toList().toBlocking().first();
            if (!list2.isEmpty()) {
                list = list2;
            }
            BaseActivity activity3 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity3, "activity");
            Intrinsics.checkNotNullExpressionValue(list, "list");
            FeedMultiPart multiPartForShareInfo = FeedArgsFactory.multiPartForShareInfo(activity3, shareFeedInfo, list);
            BaseActivity activity4 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity4, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForShareInfo(activity4, shareFeedInfo).newBuilder().relativeInfoPickable(true).build(), multiPartForShareInfo);
        }
        finish();
        overridePendingTransition(0, 0);
    }

    protected void onShareInfoLoadError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        if (TextUtils.isEmpty(this.loadLocalAppPackageName)) {
            String str = this.shareText;
            if (TextUtils.isEmpty(str)) {
                ShareFeedV8Binding shareFeedV8Binding = this.binding;
                if (shareFeedV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText = shareFeedV8Binding.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                str = editText.getText().toString();
            }
            if (!TextUtils.isEmpty(str) || !this.imageList.isEmpty()) {
                BaseActivity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                ActionManager.startSubmitFeedV8Activity(getActivity(), FeedArgsFactory.uiConfigForFeed(activity).relativeInfoPickable(true).build(), FeedArgsFactory.multiPartForFeed().imageUriList((List) Observable.from(this.imageList).map(ShareFeedV8Activity$onShareInfoLoadError$imageUrls$1.INSTANCE).toList().toBlocking().first()).message(StringUtils.emptyIfNull(str)).build());
                getActivity().finish();
                getActivity().overridePendingTransition(0, 0);
                return;
            }
            Toast.error(getActivity(), th);
            return;
        }
        MobileApp mobileApp = DataManager.getInstance().getMobileApp(this.loadLocalAppPackageName);
        if (mobileApp != null) {
            ActionManager.startNewDiscoveryV8Activity(getActivity(), mobileApp);
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
            return;
        }
        Toast.error(getActivity(), th);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        switch (view.getId()) {
            case 2131361896:
                ActionManager.startPickAppActivity(getActivity(), 1561);
                return;
            case 2131362262:
                getActivity().finish();
                return;
            case 2131362933:
                ShareFeedV8Binding shareFeedV8Binding = this.binding;
                if (shareFeedV8Binding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout = shareFeedV8Binding.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout, "binding.keyBoardInteractLayout");
                if (keyBoardLayout.isRealKeyboard()) {
                    ShareFeedV8Binding shareFeedV8Binding2 = this.binding;
                    if (shareFeedV8Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    UiUtils.closeKeyboard(shareFeedV8Binding2.editText);
                    return;
                }
                ShareFeedV8Binding shareFeedV8Binding3 = this.binding;
                if (shareFeedV8Binding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                KeyBoardLayout keyBoardLayout2 = shareFeedV8Binding3.keyBoardInteractLayout;
                Intrinsics.checkNotNullExpressionValue(keyBoardLayout2, "binding.keyBoardInteractLayout");
                if (keyBoardLayout2.isFakeKeyBoardShowed()) {
                    ShareFeedV8Binding shareFeedV8Binding4 = this.binding;
                    if (shareFeedV8Binding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    shareFeedV8Binding4.keyBoardInteractLayout.showFakeKeyBoardView(false);
                    ShareFeedV8Binding shareFeedV8Binding5 = this.binding;
                    if (shareFeedV8Binding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    shareFeedV8Binding5.keyBoardInteractLayout.requestLayout();
                    return;
                }
                ShareFeedV8Binding shareFeedV8Binding6 = this.binding;
                if (shareFeedV8Binding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                UiUtils.openKeyboard(shareFeedV8Binding6.editText);
                return;
            case 2131363475:
                ShareFeedV8Binding shareFeedV8Binding7 = this.binding;
                if (shareFeedV8Binding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText = shareFeedV8Binding7.editText;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
                String obj = editText.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    BaseActivity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    Toast.show(activity, 2131886847);
                    return;
                }
                loadShareInfo("", obj, "");
                this.loadLocalAppPackageName = null;
                return;
            default:
                return;
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1561 && i2 == -1) {
            Intrinsics.checkNotNull(intent);
            String stringExtra = intent.getStringExtra("pick_app_result");
            Intrinsics.checkNotNull(stringExtra);
            Intrinsics.checkNotNullExpressionValue(stringExtra, "data!!.getStringExtra(PICK_APP_RESULT_CODE)!!");
            loadShareInfo("", stringExtra, "");
            this.loadLocalAppPackageName = stringExtra;
        }
    }
}
