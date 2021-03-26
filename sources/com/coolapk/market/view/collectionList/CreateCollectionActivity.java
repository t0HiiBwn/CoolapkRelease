package com.coolapk.market.view.collectionList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.CreateCollectListBinding;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.model.ImageUploadOption;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.AspectRatioImageView;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.view.KeyBoardLayout;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0014J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/coolapk/market/view/collectionList/CreateCollectionActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/CreateCollectListBinding;", "checkSubscription", "Lrx/Subscription;", "collectionViewModel", "Lcom/coolapk/market/view/collectionList/CollectionListViewModel;", "coverUrl", "", "createSubscription", "fomePage", "isEdit", "", "isLoaded", "isNeedUpload", "checkCount", "", "getKeyData", "getKeyDataFromIntent", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "post", "putKeyData", "setupImage", "url", "setupInitView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CreateCollectionActivity.kt */
public final class CreateCollectionActivity extends FakeStatusBarActivity implements View.OnClickListener {
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
    public static final int REQUEST_PICK_COVER = 433;
    private CreateCollectListBinding binding;
    private Subscription checkSubscription;
    private CollectionListViewModel collectionViewModel;
    private String coverUrl = "";
    private Subscription createSubscription;
    private String fomePage;
    private boolean isEdit;
    private boolean isLoaded;
    private boolean isNeedUpload;

    public static final /* synthetic */ CreateCollectListBinding access$getBinding$p(CreateCollectionActivity createCollectionActivity) {
        CreateCollectListBinding createCollectListBinding = createCollectionActivity.binding;
        if (createCollectListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return createCollectListBinding;
    }

    public static final /* synthetic */ CollectionListViewModel access$getCollectionViewModel$p(CreateCollectionActivity createCollectionActivity) {
        CollectionListViewModel collectionListViewModel = createCollectionActivity.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        return collectionListViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/collectionList/CreateCollectionActivity$Companion;", "", "()V", "KEY_COVER", "", "KEY_CREATE_AND_BACK_STATE", "KEY_DES", "KEY_EDIT_STATE", "KEY_FROM", "KEY_ID", "KEY_OPEN_STATE", "KEY_TITLE", "REQUEST_CREATE_CODE", "", "REQUEST_PICK_COVER", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CreateCollectionActivity.kt */
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
        this.collectionViewModel = new CollectionListViewModel();
        getKeyDataFromIntent();
        setupInitView();
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        if (!collectionListViewModel.getCollectionIsEdit()) {
            checkCount();
        }
    }

    private final void checkCount() {
        this.checkSubscription = DataManager.getInstance().checkCollectionCount().compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe(CreateCollectionActivity$checkCount$1.INSTANCE, new CreateCollectionActivity$checkCount$2(this));
    }

    private final void getKeyDataFromIntent() {
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        String str = this.fomePage;
        Intrinsics.checkNotNull(str);
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        collectionListViewModel.setCollectionCreateAndBack(StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "collectionselect", false, 2, (Object) null));
        CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
        if (collectionListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel2.setCollectionTitle(getIntent().getStringExtra("KEY_TITLE"));
        CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
        if (collectionListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel3.setCollectionId(getIntent().getStringExtra("KEY_ID"));
        CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
        if (collectionListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel4.setCollectionCoverUrl(getIntent().getStringExtra("KEY_COVER"));
        CollectionListViewModel collectionListViewModel5 = this.collectionViewModel;
        if (collectionListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel5.setCollectionDescription(getIntent().getStringExtra("KEY_DES"));
        CollectionListViewModel collectionListViewModel6 = this.collectionViewModel;
        if (collectionListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel6.setCollectionIsOpen(getIntent().getBooleanExtra("KEY_OPEN_STATE", true));
        CollectionListViewModel collectionListViewModel7 = this.collectionViewModel;
        if (collectionListViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel7.setCollectionIsEdit(getIntent().getBooleanExtra("KEY_EDIT_STATE", false));
    }

    private final void setupInitView() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558489, new ContextBindingComponent(this));
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…xtBindingComponent(this))");
        CreateCollectListBinding createCollectListBinding = (CreateCollectListBinding) contentView;
        this.binding = createCollectListBinding;
        if (createCollectListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createCollectListBinding.setClick(this);
        CreateCollectListBinding createCollectListBinding2 = this.binding;
        if (createCollectListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        createCollectListBinding2.setToolbarTitle(collectionListViewModel.getCollectionIsEdit() ? "编辑收藏单" : "创建收藏单");
        CreateCollectListBinding createCollectListBinding3 = this.binding;
        if (createCollectListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
        if (collectionListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        createCollectListBinding3.setActionTitle(collectionListViewModel2.getCollectionIsEdit() ? "确认修改" : "确认创建");
        CreateCollectListBinding createCollectListBinding4 = this.binding;
        if (createCollectListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = createCollectListBinding4.addPicView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addPicView");
        CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
        if (collectionListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        int i = 0;
        linearLayout.setVisibility(collectionListViewModel3.getHasPic() ? 8 : 0);
        CreateCollectListBinding createCollectListBinding5 = this.binding;
        if (createCollectListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = createCollectListBinding5.coverView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.coverView");
        CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
        if (collectionListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        if (!collectionListViewModel4.getHasPic()) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        CreateCollectListBinding createCollectListBinding6 = this.binding;
        if (createCollectListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        KeyBoardLayout keyBoardLayout = createCollectListBinding6.keyBoardInteractLayout;
        CreateCollectListBinding createCollectListBinding7 = this.binding;
        if (createCollectListBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        keyBoardLayout.setKeyBoardView(createCollectListBinding7.fakeKeyboardView);
        CollectionListViewModel collectionListViewModel5 = this.collectionViewModel;
        if (collectionListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        if (collectionListViewModel5.getCollectionIsEdit()) {
            putKeyData();
        }
        CreateCollectListBinding createCollectListBinding8 = this.binding;
        if (createCollectListBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        createCollectListBinding8.executePendingBindings();
    }

    private final void putKeyData() {
        CreateCollectListBinding createCollectListBinding = this.binding;
        if (createCollectListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = createCollectListBinding.etTitle;
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        editText.setText(collectionListViewModel.getTitle());
        CreateCollectListBinding createCollectListBinding2 = this.binding;
        if (createCollectListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = createCollectListBinding2.etDes;
        CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
        if (collectionListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        editText2.setText(collectionListViewModel2.getDescription());
        CreateCollectListBinding createCollectListBinding3 = this.binding;
        if (createCollectListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SwitchCompat switchCompat = createCollectListBinding3.switchView;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.switchView");
        CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
        if (collectionListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        Boolean isOpen = collectionListViewModel3.getIsOpen();
        Intrinsics.checkNotNull(isOpen);
        switchCompat.setChecked(!isOpen.booleanValue());
        CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
        if (collectionListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        String coverUrl2 = collectionListViewModel4.getCoverUrl();
        Intrinsics.checkNotNull(coverUrl2);
        setupImage(coverUrl2);
    }

    private final void getKeyData() {
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        CreateCollectListBinding createCollectListBinding = this.binding;
        if (createCollectListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = createCollectListBinding.etTitle;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.etTitle");
        collectionListViewModel.setCollectionTitle(editText.getText().toString());
        CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
        if (collectionListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        CreateCollectListBinding createCollectListBinding2 = this.binding;
        if (createCollectListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = createCollectListBinding2.etDes;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.etDes");
        collectionListViewModel2.setCollectionDescription(editText2.getText().toString());
        CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
        if (collectionListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        CreateCollectListBinding createCollectListBinding3 = this.binding;
        if (createCollectListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SwitchCompat switchCompat = createCollectListBinding3.switchView;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "binding.switchView");
        collectionListViewModel3.setCollectionIsOpen(!switchCompat.isChecked());
        CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
        if (collectionListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        boolean startsWith$default = StringsKt.startsWith$default(this.coverUrl, "http", false, 2, (Object) null);
        String str = this.coverUrl;
        if (!startsWith$default) {
            str = "";
        }
        collectionListViewModel4.setCollectionCoverUrl(str);
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
                UCrop.of(Uri.fromFile(new File(path)), Uri.fromFile(file)).withAspectRatio(20.0f, 9.0f).withMaxResultSize(1600, 720).withOptions(options).start(getActivity());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void setupImage(String str) {
        this.coverUrl = str;
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            CreateCollectListBinding createCollectListBinding = this.binding;
            if (createCollectListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AspectRatioImageView aspectRatioImageView = createCollectListBinding.ivCover;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView, "binding.ivCover");
            aspectRatioImageView.setAspectRatio(0.45f);
        } else {
            int widthDp = DisplayUtils.getWidthDp(getActivity());
            CreateCollectListBinding createCollectListBinding2 = this.binding;
            if (createCollectListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            AspectRatioImageView aspectRatioImageView2 = createCollectListBinding2.ivCover;
            Intrinsics.checkNotNullExpressionValue(aspectRatioImageView2, "binding.ivCover");
            aspectRatioImageView2.setAspectRatio(80.0f / ((float) ((widthDp - 16) - 16)));
        }
        CollectionListViewModel collectionListViewModel = this.collectionViewModel;
        if (collectionListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        collectionListViewModel.setCollectionCoverUrl(str);
        CreateCollectListBinding createCollectListBinding3 = this.binding;
        if (createCollectListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = createCollectListBinding3.addPicView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.addPicView");
        CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
        if (collectionListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        int i = 8;
        linearLayout.setVisibility(collectionListViewModel2.getHasPic() ? 8 : 0);
        CreateCollectListBinding createCollectListBinding4 = this.binding;
        if (createCollectListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        FrameLayout frameLayout = createCollectListBinding4.coverView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.coverView");
        CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
        if (collectionListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        frameLayout.setVisibility(collectionListViewModel3.getHasPic() ? 0 : 8);
        CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
        if (collectionListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
        }
        boolean collectionIsEdit = collectionListViewModel4.getCollectionIsEdit();
        Uri parse = Uri.parse(StringUtils.notNull(str));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(StringUtils.notNull(url))");
        Comparable safeFileUri = UtilExtendsKt.toSafeFileUri(parse);
        if (collectionIsEdit) {
            safeFileUri = str;
        }
        GlideRequest diskCacheStrategy = GlideApp.with((FragmentActivity) getActivity()).load((Object) safeFileUri).diskCacheStrategy(DiskCacheStrategy.NONE);
        CreateCollectListBinding createCollectListBinding5 = this.binding;
        if (createCollectListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        diskCacheStrategy.into(createCollectListBinding5.ivCover);
        boolean startsWith$default = StringsKt.startsWith$default(str, "http", false, 2, (Object) null);
        boolean isEmpty = TextUtils.isEmpty(str2);
        boolean z = true;
        boolean z2 = !startsWith$default && !TextUtils.isEmpty(str2);
        this.isNeedUpload = z2;
        if (isEmpty || z2) {
            z = false;
        }
        CreateCollectListBinding createCollectListBinding6 = this.binding;
        if (createCollectListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = createCollectListBinding6.picCloseView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.picCloseView");
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
        if (this.isNeedUpload) {
            CreateCollectListBinding createCollectListBinding7 = this.binding;
            if (createCollectListBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = createCollectListBinding7.picAddPh;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.picAddPh");
            linearLayout2.setVisibility(0);
            DataManager.getInstance().uploadImage(CollectionsKt.listOf(ImageUploadOption.create(str, "feed_image", "COLLECTION", null))).compose(RxUtils.applyIOSchedulers()).first().subscribe((Subscriber<? super R>) new CreateCollectionActivity$setupImage$1(this));
        }
    }

    private final void post() {
        if (this.isLoaded || !this.isNeedUpload) {
            getKeyData();
            Collection.Builder newBuilder = Collection.newBuilder();
            CollectionListViewModel collectionListViewModel = this.collectionViewModel;
            if (collectionListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            Collection.Builder coverPic = newBuilder.coverPic(collectionListViewModel.getUploadPic());
            CollectionListViewModel collectionListViewModel2 = this.collectionViewModel;
            if (collectionListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            Collection.Builder title = coverPic.title(collectionListViewModel2.getCollectionTitle());
            CollectionListViewModel collectionListViewModel3 = this.collectionViewModel;
            if (collectionListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            Collection.Builder description = title.description(collectionListViewModel3.getCollectionDescription());
            CollectionListViewModel collectionListViewModel4 = this.collectionViewModel;
            if (collectionListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            Collection.Builder isOpen = description.isOpen(collectionListViewModel4.getCollectionIsOpen() ? 1 : 0);
            CollectionListViewModel collectionListViewModel5 = this.collectionViewModel;
            if (collectionListViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            Collection build = isOpen.id(collectionListViewModel5.getCollectionId()).followNum(0).apkNum(0).likeNum(0).replyNum(0).copyNum(0).feedNum(0).itemNum(0).shareNum(0).isBeCollected(0).defaultCollected(0).build();
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在创建收藏单...");
            progressDialog.setProgressStyle(0);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(true);
            progressDialog.show();
            CollectionListViewModel collectionListViewModel6 = this.collectionViewModel;
            if (collectionListViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("collectionViewModel");
            }
            this.createSubscription = Observable.just(Boolean.valueOf(collectionListViewModel6.getCollectionIsEdit())).flatMap(new CreateCollectionActivity$post$1(build)).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe(new CreateCollectionActivity$post$2(this, progressDialog), new CreateCollectionActivity$post$3(this, progressDialog));
            return;
        }
        Toast.show$default(getActivity(), "封面还未上传完成，请稍等", 0, false, 12, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNull(view);
        switch (view.getId()) {
            case 2131362001:
            case 2131362793:
                ActionManager.startPhotoPickerActivity(getActivity(), 1, (List<String>) null, 433);
                return;
            case 2131362257:
                getActivity().finish();
                return;
            case 2131363101:
                setupImage("");
                return;
            case 2131363457:
                post();
                return;
            default:
                return;
        }
    }
}
