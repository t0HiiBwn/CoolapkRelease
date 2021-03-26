package com.coolapk.market.view.feedv8;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.QuestionTitleBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.feed.CommentHelper;
import com.coolapk.market.view.feedv8.SubmitExtraViewPart;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.decoration.VerticalItemDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import group.infotech.drawable.dsl.Drawable_dslKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rx.Emitter;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/feedv8/QuestionTitleActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "dataList", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/model/Entity;", "mBinding", "Lcom/coolapk/market/databinding/QuestionTitleBinding;", "subscription", "Lrx/Subscription;", "loadSimilarQuestions", "", "title", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "processTitle", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionTitleActivity.kt */
public final class QuestionTitleActivity extends FakeStatusBarActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_MULTI_PART = "MULTI_PART";
    public static final String EXTRA_UI_CONFIG = "UI_CONFIG";
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private QuestionTitleBinding mBinding;
    private Subscription subscription;

    public static final /* synthetic */ QuestionTitleBinding access$getMBinding$p(QuestionTitleActivity questionTitleActivity) {
        QuestionTitleBinding questionTitleBinding = questionTitleActivity.mBinding;
        if (questionTitleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return questionTitleBinding;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setToolbarColorEqualContentColor(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131559120);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte… R.layout.question_title)");
        QuestionTitleBinding questionTitleBinding = (QuestionTitleBinding) contentView;
        this.mBinding = questionTitleBinding;
        if (questionTitleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        questionTitleBinding.setClick(this);
        QuestionTitleBinding questionTitleBinding2 = this.mBinding;
        if (questionTitleBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        questionTitleBinding2.editText.addTextChangedListener(new CommentHelper.CharRejectHelper('\n'));
        QuestionTitleBinding questionTitleBinding3 = this.mBinding;
        if (questionTitleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EditText editText = questionTitleBinding3.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "mBinding.editText");
        editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(60)});
        QuestionTitleBinding questionTitleBinding4 = this.mBinding;
        if (questionTitleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        RecyclerView recyclerView = questionTitleBinding4.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131231380);
        drawable.mutate().setTint(AppHolder.getAppTheme().getTextColorSecondary());
        Intrinsics.checkNotNullExpressionValue(drawable, "warnDrawable");
        LayerDrawable layerDrawable = Drawable_dslKt.layerDrawable(drawable);
        layerDrawable.setLayerInset(0, 0, 0, NumberExtendsKt.getDp((Number) 2), 0);
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 20), NumberExtendsKt.getDp((Number) 18));
        QuestionTitleBinding questionTitleBinding5 = this.mBinding;
        if (questionTitleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        questionTitleBinding5.warningView.setCompoundDrawables(layerDrawable, null, null, null);
        FeedUIConfig feedUIConfig = (FeedUIConfig) getIntent().getParcelableExtra("UI_CONFIG");
        if (feedUIConfig != null) {
            SubmitExtraViewPart.Companion companion = SubmitExtraViewPart.Companion;
            QuestionTitleBinding questionTitleBinding6 = this.mBinding;
            if (questionTitleBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            }
            LinearLayout linearLayout = questionTitleBinding6.relativeView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.relativeView");
            SubmitExtraViewPart.Companion.fillRelativeInfoViewIntoLayout$default(companion, linearLayout, feedUIConfig, null, 4, null);
        }
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        QuestionTitleBinding questionTitleBinding7 = this.mBinding;
        if (questionTitleBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        RecyclerView recyclerView2 = questionTitleBinding7.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "mBinding.recyclerView");
        MultiTypeAdapter multiTypeAdapter2 = multiTypeAdapter;
        recyclerView2.setAdapter(multiTypeAdapter2);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(multiTypeAdapter2));
        BaseMultiTypeAdapter.register$default(multiTypeAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558893).suitedEntityType("feedQuestion").constructor(new QuestionTitleActivity$onCreate$2(new ContextBindingComponent(this))).build(), 0, 2, null);
        VerticalItemDecoration create = ItemDecorations.vertical(getActivity()).type(2131558893, 2131231062).create();
        QuestionTitleBinding questionTitleBinding8 = this.mBinding;
        if (questionTitleBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        questionTitleBinding8.recyclerView.addItemDecoration(create);
        Observable.create(new QuestionTitleActivity$onCreate$3(this), Emitter.BackpressureMode.LATEST).doOnNext(new QuestionTitleActivity$onCreate$4(this)).throttleWithTimeout(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new QuestionTitleActivity$onCreate$5(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == 2131362262) {
            finish();
        } else if (id == 2131363475) {
            processTitle();
        }
    }

    /* access modifiers changed from: private */
    public final void loadSimilarQuestions(String str) {
        this.subscription = DataManager.getInstance().getRelatedQuestion(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new QuestionTitleActivity$loadSimilarQuestions$1(this));
    }

    private final void processTitle() {
        QuestionTitleBinding questionTitleBinding = this.mBinding;
        if (questionTitleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        EditText editText = questionTitleBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "mBinding.editText");
        String obj = editText.getText().toString();
        boolean z = true;
        int length = obj.length() - 1;
        int i = 0;
        boolean z2 = false;
        while (i <= length) {
            boolean z3 = Intrinsics.compare(obj.charAt(!z2 ? i : length), 32) <= 0;
            if (!z2) {
                if (!z3) {
                    z2 = true;
                } else {
                    i++;
                }
            } else if (!z3) {
                break;
            } else {
                length--;
            }
        }
        String obj2 = obj.subSequence(i, length + 1).toString();
        if (obj2.length() != 0) {
            z = false;
        }
        if (!z) {
            if (!StringsKt.endsWith$default(obj2, "?", false, 2, (Object) null) && !StringsKt.endsWith$default(obj2, "？", false, 2, (Object) null)) {
                obj2 = obj2 + "？";
            }
            if (obj2.length() > 60) {
                Toast.show$default(getActivity(), "问题过长，请精简", 0, false, 12, null);
                return;
            }
            Object parcelableExtra = getIntent().getParcelableExtra("UI_CONFIG");
            if (parcelableExtra == null) {
                parcelableExtra = FeedUIConfig.builder().build();
            }
            FeedUIConfig feedUIConfig = (FeedUIConfig) parcelableExtra;
            BaseActivity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Intrinsics.checkNotNullExpressionValue(feedUIConfig, "oldConfig");
            FeedUIConfig uiConfigForQuestion = FeedArgsFactory.uiConfigForQuestion(activity, feedUIConfig);
            BaseActivity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            ActionManager.startSubmitFeedV8Activity(getActivity(), uiConfigForQuestion, FeedArgsFactory.multiPartForQuestion(activity2, obj2, (FeedMultiPart) getIntent().getParcelableExtra("MULTI_PART")));
            finish();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feedv8/QuestionTitleActivity$Companion;", "", "()V", "EXTRA_MULTI_PART", "", "EXTRA_UI_CONFIG", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionTitleActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
