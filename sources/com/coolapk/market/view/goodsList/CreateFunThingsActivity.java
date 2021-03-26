package com.coolapk.market.view.goodsList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.CreateFunThingsBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.KeyBoardLayout;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0014J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/goodsList/CreateFunThingsActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/CreateFunThingsBinding;", "checkSubscription", "Lrx/Subscription;", "coverUrl", "", "createSubscription", "fomePage", "funThingsViewModel", "Lcom/coolapk/market/view/goodsList/FunThingsViewModel;", "isEdit", "", "isLoaded", "isNeedUpload", "checkCount", "", "getKeyData", "getKeyDataFromIntent", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "post", "putKeyData", "setupImage", "url", "setupInitView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateFunThingsActivity.kt */
public final class CreateFunThingsActivity extends FakeStatusBarActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_COVER = "KEY_COVER";
    public static final String KEY_CREATE_AND_BACK_STATE = "KEY_CREATE_AND_BACK_STATE";
    public static final String KEY_DES = "KEY_DES";
    public static final String KEY_EDIT_STATE = "KEY_EDIT_STATE";
    public static final String KEY_FROM = "KEY_FROM";
    public static final String KEY_ID = "KEY_ID";
    public static final String KEY_OPEN_STATE = "KEY_OPEN_STATE";
    public static final String KEY_TITLE = "KEY_TITLE";
    public static final int REQUEST_CREATE_CODE = 424;
    private static final int REQUEST_PICK_COVER = 433;
    private CreateFunThingsBinding binding;
    private Subscription checkSubscription;
    private String coverUrl = "";
    private Subscription createSubscription;
    private String fomePage;
    private FunThingsViewModel funThingsViewModel;
    private boolean isEdit;
    private boolean isLoaded;
    private boolean isNeedUpload;

    public static final /* synthetic */ CreateFunThingsBinding access$getBinding$p(CreateFunThingsActivity createFunThingsActivity) {
        CreateFunThingsBinding createFunThingsBinding = createFunThingsActivity.binding;
        if (createFunThingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return createFunThingsBinding;
    }

    public static final /* synthetic */ FunThingsViewModel access$getFunThingsViewModel$p(CreateFunThingsActivity createFunThingsActivity) {
        FunThingsViewModel funThingsViewModel2 = createFunThingsActivity.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        return funThingsViewModel2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/goodsList/CreateFunThingsActivity$Companion;", "", "()V", "KEY_COVER", "", "KEY_CREATE_AND_BACK_STATE", "KEY_DES", "KEY_EDIT_STATE", "KEY_FROM", "KEY_ID", "KEY_OPEN_STATE", "KEY_TITLE", "REQUEST_CREATE_CODE", "", "REQUEST_PICK_COVER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CreateFunThingsActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("KEY_FROM");
        this.fomePage = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.fomePage = "defaultPage";
        }
        BaseActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this.funThingsViewModel = new FunThingsViewModel(activity);
        getKeyDataFromIntent();
        setupInitView();
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        if (!funThingsViewModel2.getFunThingsIsEdit()) {
            checkCount();
        }
    }

    private final void checkCount() {
        this.checkSubscription = DataManager.getInstance().checkCollectionCount().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe(CreateFunThingsActivity$checkCount$1.INSTANCE, new CreateFunThingsActivity$checkCount$2(this));
    }

    private final void getKeyDataFromIntent() {
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel2.setFunThingsTitle(getIntent().getStringExtra("KEY_TITLE"));
        FunThingsViewModel funThingsViewModel3 = this.funThingsViewModel;
        if (funThingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel3.setFunThingsId(getIntent().getStringExtra("KEY_ID"));
        FunThingsViewModel funThingsViewModel4 = this.funThingsViewModel;
        if (funThingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel4.setFunThingsCoverUrl(getIntent().getStringExtra("KEY_COVER"));
        FunThingsViewModel funThingsViewModel5 = this.funThingsViewModel;
        if (funThingsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel5.setFunThingsDescription(getIntent().getStringExtra("KEY_DES"));
        FunThingsViewModel funThingsViewModel6 = this.funThingsViewModel;
        if (funThingsViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel6.setFunThingsIsOpen(getIntent().getBooleanExtra("KEY_OPEN_STATE", true));
        FunThingsViewModel funThingsViewModel7 = this.funThingsViewModel;
        if (funThingsViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel7.setFunThingsIsEdit(getIntent().getBooleanExtra("KEY_EDIT_STATE", false));
    }

    private final void setupInitView() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558491, new ContextBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…xtBindingComponent(this))");
        CreateFunThingsBinding createFunThingsBinding = (CreateFunThingsBinding) contentView;
        this.binding = createFunThingsBinding;
        if (createFunThingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createFunThingsBinding.setClick(this);
        CreateFunThingsBinding createFunThingsBinding2 = this.binding;
        if (createFunThingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createFunThingsBinding2.setToolbarTitle("创建好物单");
        CreateFunThingsBinding createFunThingsBinding3 = this.binding;
        if (createFunThingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createFunThingsBinding3.setActionTitle("下一步");
        CreateFunThingsBinding createFunThingsBinding4 = this.binding;
        if (createFunThingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = createFunThingsBinding4.keyBoardInteractLayout;
        CreateFunThingsBinding createFunThingsBinding5 = this.binding;
        if (createFunThingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        keyBoardLayout.setKeyBoardView(createFunThingsBinding5.fakeKeyboardView);
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        if (funThingsViewModel2.getFunThingsIsEdit()) {
            putKeyData();
        }
        CreateFunThingsBinding createFunThingsBinding6 = this.binding;
        if (createFunThingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createFunThingsBinding6.executePendingBindings();
    }

    private final void putKeyData() {
        CreateFunThingsBinding createFunThingsBinding = this.binding;
        if (createFunThingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = createFunThingsBinding.etTitle;
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        editText.setText(funThingsViewModel2.getTitle());
        CreateFunThingsBinding createFunThingsBinding2 = this.binding;
        if (createFunThingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = createFunThingsBinding2.etDes;
        FunThingsViewModel funThingsViewModel3 = this.funThingsViewModel;
        if (funThingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        editText2.setText(funThingsViewModel3.getDescription());
        FunThingsViewModel funThingsViewModel4 = this.funThingsViewModel;
        if (funThingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        String coverUrl2 = funThingsViewModel4.getCoverUrl();
        Intrinsics.checkNotNull(coverUrl2);
        setupImage(coverUrl2);
    }

    private final void getKeyData() {
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        CreateFunThingsBinding createFunThingsBinding = this.binding;
        if (createFunThingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = createFunThingsBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.etTitle");
        funThingsViewModel2.setFunThingsTitle(editText.getText().toString());
        FunThingsViewModel funThingsViewModel3 = this.funThingsViewModel;
        if (funThingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        CreateFunThingsBinding createFunThingsBinding2 = this.binding;
        if (createFunThingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = createFunThingsBinding2.etDes;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.etDes");
        funThingsViewModel3.setFunThingsDescription(editText2.getText().toString());
        FunThingsViewModel funThingsViewModel4 = this.funThingsViewModel;
        if (funThingsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        boolean startsWith$default = StringsKt.startsWith$default(this.coverUrl, "http", false, 2, (Object) null);
        String str = this.coverUrl;
        if (!startsWith$default) {
            str = "";
        }
        funThingsViewModel4.setFunThingsCoverUrl(str);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RxUtils.unsubscribe(this.checkSubscription);
        RxUtils.unsubscribe(this.createSubscription);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                Intrinsics.checkNotNull(intent);
                Uri output = UCrop.getOutput(intent);
                if (output != null) {
                    Intrinsics.checkNotNullExpressionValue(output, "UCrop.getOutput(data!!) ?: return");
                    String uri = output.toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "path.toString()");
                    setupImage(uri);
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
                UCrop.of(Uri.fromFile(new File(path)), Uri.fromFile(file)).withAspectRatio(21.0f, 9.0f).withMaxResultSize(1600, 720).withOptions(options).start(getActivity());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void setupImage(String str) {
        this.coverUrl = str;
        CreateFunThingsBinding createFunThingsBinding = this.binding;
        if (createFunThingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AspectRatioImageView aspectRatioImageView = createFunThingsBinding.ivCover;
        Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.ivCover");
        aspectRatioImageView.setAspectRatio(0.43f);
        FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
        if (funThingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        funThingsViewModel2.setFunThingsCoverUrl(str);
        FunThingsViewModel funThingsViewModel3 = this.funThingsViewModel;
        if (funThingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
        }
        boolean funThingsIsEdit = funThingsViewModel3.getFunThingsIsEdit();
        Uri parse = Uri.parse(StringUtils.notNull(str));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(url))");
        Comparable safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        if (funThingsIsEdit) {
            safeFileUri = str;
        }
        GlideRequest diskCacheStrategy = GlideApp.with((FragmentActivity) getActivity()).load((Object) safeFileUri).diskCacheStrategy(DiskCacheStrategy.NONE);
        CreateFunThingsBinding createFunThingsBinding2 = this.binding;
        if (createFunThingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        diskCacheStrategy.into(createFunThingsBinding2.ivCover);
        int i = 0;
        boolean startsWith$default = StringsKt.startsWith$default(str, "http", false, 2, (Object) null);
        String str2 = str;
        boolean isEmpty = TextUtils.isEmpty(str2);
        if (isEmpty) {
            Toast.show$default(getActivity(), "封面不能为空", 0, false, 12, null);
            return;
        }
        boolean z = true;
        boolean z2 = !startsWith$default && !TextUtils.isEmpty(str2);
        this.isNeedUpload = z2;
        if (isEmpty || z2) {
            z = false;
        }
        CreateFunThingsBinding createFunThingsBinding3 = this.binding;
        if (createFunThingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = createFunThingsBinding3.picCloseView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.picCloseView");
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        if (this.isNeedUpload) {
            DataManager.getInstance().uploadImage(CollectionsKt.listOf(ImageUploadOption.create(str, "feed_cover", "FEED", null))).compose(RxUtils.applyIOSchedulers()).first().subscribe((Subscriber<? super R>) new CreateFunThingsActivity$setupImage$1(this));
        }
    }

    private final void post() {
        if (this.isLoaded || !this.isNeedUpload) {
            getKeyData();
            FunThings.Builder newBuilder = FunThings.newBuilder();
            FunThingsViewModel funThingsViewModel2 = this.funThingsViewModel;
            if (funThingsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
            }
            FunThings.Builder coverPic = newBuilder.coverPic(funThingsViewModel2.getUploadPic());
            FunThingsViewModel funThingsViewModel3 = this.funThingsViewModel;
            if (funThingsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
            }
            FunThings.Builder title = coverPic.title(funThingsViewModel3.getFunThingsTitle());
            FunThingsViewModel funThingsViewModel4 = this.funThingsViewModel;
            if (funThingsViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
            }
            FunThings.Builder description = title.description(funThingsViewModel4.getFunThingsDescription());
            FunThingsViewModel funThingsViewModel5 = this.funThingsViewModel;
            if (funThingsViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funThingsViewModel");
            }
            FunThings build = description.isOpen(funThingsViewModel5.getFunThingsIsOpen() ? 1 : 0).id("").followNum(0).likeNum(0).replyNum(0).copyNum(0).itemNum(0).shareNum(0).favNum(0).isAdded(0).build();
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在创建好物单...");
            progressDialog.setProgressStyle(0);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(true);
            progressDialog.show();
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(build, "funThings");
            this.createSubscription = instance.createFunThings(build.getTitle(), build.getDescription(), build.getCoverPic()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe(new CreateFunThingsActivity$post$1(this, progressDialog), new CreateFunThingsActivity$post$2(this, progressDialog));
            return;
        }
        Toast.show$default(getActivity(), "封面还未上传完成，请稍等", 0, false, 12, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        switch (view.getId()) {
            case 2131362002:
            case 2131362804:
                ActionManager.startPhotoPickerActivity(getActivity(), 1, (List<String>) null, 433);
                return;
            case 2131362262:
                getActivity().finish();
                return;
            case 2131363115:
                setupImage("");
                return;
            case 2131363475:
                post();
                return;
            default:
                return;
        }
    }
}
