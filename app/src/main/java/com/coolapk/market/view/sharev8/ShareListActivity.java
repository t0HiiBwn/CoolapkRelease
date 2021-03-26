package com.coolapk.market.view.sharev8;

import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemForwardEntityShareAppBinding;
import com.coolapk.market.databinding.ShareListBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/ShareListBinding;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "entity", "Lcom/coolapk/market/model/Entity;", "isAnimating", "", "finish", "", "initView", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "setAnimationValue", "value", "", "startCloseAnimation", "startOpenAnimation", "Companion", "DataAdapter", "SimpleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareListActivity.kt */
public final class ShareListActivity extends BaseActivity implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ENTITY = "extra_entity";
    private ShareListBinding binding;
    private ColorDrawable colorDrawable = new ColorDrawable(-16777216);
    private Entity entity;
    private boolean isAnimating;

    public static final /* synthetic */ ShareListBinding access$getBinding$p(ShareListActivity shareListActivity) {
        ShareListBinding shareListBinding = shareListActivity.binding;
        if (shareListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return shareListBinding;
    }

    public static final /* synthetic */ Entity access$getEntity$p(ShareListActivity shareListActivity) {
        Entity entity2 = shareListActivity.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        return entity2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity$Companion;", "", "()V", "EXTRA_ENTITY", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        ShareListActivity shareListActivity = this;
        ThemeUtils.setSystemBarDrawFlags(shareListActivity);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(shareListActivity, 2131559140, null);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte….layout.share_list, null)");
        this.binding = (ShareListBinding) contentView;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra_entity");
        Intrinsics.checkNotNull(parcelableExtra);
        this.entity = (Entity) parcelableExtra;
        setSlidrEnable(false);
        initView();
    }

    private final void initView() {
        if (this.entity == null) {
            finish();
            return;
        }
        Entity entity2 = this.entity;
        if (entity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("entity");
        }
        float dp = (float) NumberExtendsKt.getDp((Number) 8);
        ShareListBinding shareListBinding = this.binding;
        if (shareListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = shareListBinding.bottomView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i = 0;
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        ShareListBinding shareListBinding2 = this.binding;
        if (shareListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        shareListBinding2.setClick(this);
        ShareListBinding shareListBinding3 = this.binding;
        if (shareListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        shareListBinding3.executePendingBindings();
        ShareListBinding shareListBinding4 = this.binding;
        if (shareListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = shareListBinding4.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        ShareListActivity shareListActivity = this;
        recyclerView.setAdapter(new DataAdapter(shareListActivity, entity2));
        ShareListBinding shareListBinding5 = this.binding;
        if (shareListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView2 = shareListBinding5.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new GridLayoutManager(shareListActivity, 5));
        ShareListBinding shareListBinding6 = this.binding;
        if (shareListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView3 = shareListBinding6.recyclerView;
        int widthDp = 8 - (((DisplayUtils.getWidthDp(recyclerView3.getContext()) - 16) - 310) / 8);
        if (widthDp >= 0) {
            i = widthDp;
        }
        recyclerView3.setPadding(NumberExtendsKt.getDp(Integer.valueOf(i)), recyclerView3.getPaddingTop(), NumberExtendsKt.getDp(Integer.valueOf(i)), recyclerView3.getPaddingBottom());
        ShareListBinding shareListBinding7 = this.binding;
        if (shareListBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = shareListBinding7.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().addOnPreDrawListener(new ShareListActivity$initView$4(this));
    }

    /* access modifiers changed from: private */
    public final void startOpenAnimation() {
        this.isAnimating = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new ShareListActivity$startOpenAnimation$$inlined$apply$lambda$1(this));
        ExtraExtendsKt.doOnEnd(valueAnimator, new ShareListActivity$startOpenAnimation$$inlined$apply$lambda$2(this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
    }

    private final void startCloseAnimation() {
        if (!isFinishing()) {
            this.isAnimating = true;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            valueAnimator.addUpdateListener(new ShareListActivity$startCloseAnimation$$inlined$apply$lambda$1(this));
            valueAnimator.setDuration(300L);
            ExtraExtendsKt.doOnEnd(valueAnimator, new ShareListActivity$startCloseAnimation$$inlined$apply$lambda$2(this));
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setAnimationValue(float f) {
        this.colorDrawable.setAlpha((int) (((float) 66) * f));
        ShareListBinding shareListBinding = this.binding;
        if (shareListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = shareListBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.colorDrawable);
        ShareListBinding shareListBinding2 = this.binding;
        if (shareListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = shareListBinding2.bottomView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomView");
        float f2 = ((float) 1) - f;
        ShareListBinding shareListBinding3 = this.binding;
        if (shareListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = shareListBinding3.bottomView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.bottomView");
        linearLayout.setTranslationY(f2 * ((float) linearLayout2.getHeight()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131362196 || id == 2131362908) {
            onBackPressed();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.isAnimating) {
            startCloseAnimation();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0010H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/sharev8/ShareListActivity$SimpleViewHolder;", "context", "Landroid/content/Context;", "entity", "Lcom/coolapk/market/model/Entity;", "(Landroid/content/Context;Lcom/coolapk/market/model/Entity;)V", "getContext", "()Landroid/content/Context;", "dataList", "", "Lcom/coolapk/market/model/HolderItem;", "getEntity", "()Lcom/coolapk/market/model/Entity;", "shareApps", "Landroid/content/pm/ResolveInfo;", "shareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "shareTextTo", "resolvedInfo", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareListActivity.kt */
    private static final class DataAdapter extends RecyclerView.Adapter<SimpleViewHolder> {
        public static final Companion Companion = new Companion(null);
        public static final String ENTITY_TYPE_COLLECTION = "collection";
        public static final String ENTITY_TYPE_COPY_LINK = "copy_link";
        public static final String ENTITY_TYPE_KANKANHAO = "kankanhao";
        public static final String ENTITY_TYPE_MESSAGE = "message";
        public static final String ENTITY_TYPE_MORE = "more";
        public static final String ENTITY_TYPE_NEW_FEED = "new_feed";
        public static final String ENTITY_TYPE_QQ = "qq";
        public static final String ENTITY_TYPE_TIM = "tim";
        public static final String ENTITY_TYPE_WEIBO = "weibo";
        public static final String ENTITY_TYPE_WEXIN = "wexin";
        public static final String ENTITY_TYPE_WEXIN_MOMENT = "wexin_moment";
        public static final String ENTITY_TYPE_ZHIHU = "zhihu";
        private final Context context;
        private final List<HolderItem> dataList;
        private final Entity entity;
        private final List<ResolveInfo> shareApps;
        private final ShareUtils.ShareInfo shareInfo;

        public DataAdapter(Context context2, Entity entity2) {
            T t;
            Object obj;
            T t2;
            T t3;
            T t4;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(entity2, "entity");
            this.context = context2;
            this.entity = entity2;
            ShareUtils.ShareInfo obtainShareInfo = ShareUtils.obtainShareInfo(entity2);
            this.shareInfo = obtainShareInfo;
            ArrayList arrayList = new ArrayList();
            this.dataList = arrayList;
            ArrayList arrayList2 = new ArrayList();
            List<ResolveInfo> shareApps2 = PackageUtils.getShareApps(context2);
            Intrinsics.checkNotNullExpressionValue(shareApps2, "PackageUtils.getShareApps(context)");
            arrayList2.addAll(shareApps2);
            Unit unit = Unit.INSTANCE;
            this.shareApps = arrayList2;
            if (obtainShareInfo.getUrl().length() > 0) {
                HolderItem build = HolderItem.newBuilder().entityType("new_feed").build();
                Intrinsics.checkNotNullExpressionValue(build, "HolderItem.newBuilder().…TY_TYPE_NEW_FEED).build()");
                arrayList.add(build);
                HolderItem build2 = HolderItem.newBuilder().entityType("message").build();
                Intrinsics.checkNotNullExpressionValue(build2, "HolderItem.newBuilder().…ITY_TYPE_MESSAGE).build()");
                arrayList.add(build2);
            }
            if ((entity2 instanceof Feed) || (entity2 instanceof DyhArticle)) {
                HolderItem build3 = HolderItem.newBuilder().entityType("kankanhao").build();
                Intrinsics.checkNotNullExpressionValue(build3, "HolderItem.newBuilder().…Y_TYPE_KANKANHAO).build()");
                arrayList.add(build3);
            }
            Iterator it2 = arrayList2.iterator();
            while (true) {
                t = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (Intrinsics.areEqual(((ResolveInfo) obj).activityInfo.packageName, "com.tencent.mm")) {
                    break;
                }
            }
            if (obj != null) {
                List<HolderItem> list = this.dataList;
                HolderItem build4 = HolderItem.newBuilder().entityType("wexin").build();
                Intrinsics.checkNotNullExpressionValue(build4, "HolderItem.newBuilder().…NTITY_TYPE_WEXIN).build()");
                list.add(build4);
                List<HolderItem> list2 = this.dataList;
                HolderItem build5 = HolderItem.newBuilder().entityType("wexin_moment").build();
                Intrinsics.checkNotNullExpressionValue(build5, "HolderItem.newBuilder().…YPE_WEXIN_MOMENT).build()");
                list2.add(build5);
            }
            Iterator<T> it3 = this.shareApps.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it3.next();
                if (Intrinsics.areEqual(((ResolveInfo) t2).activityInfo.packageName, "com.sina.weibo")) {
                    break;
                }
            }
            if (t2 != null) {
                List<HolderItem> list3 = this.dataList;
                HolderItem build6 = HolderItem.newBuilder().entityType("weibo").build();
                Intrinsics.checkNotNullExpressionValue(build6, "HolderItem.newBuilder().…NTITY_TYPE_WEIBO).build()");
                list3.add(build6);
            }
            Iterator<T> it4 = this.shareApps.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it4.next();
                if (Intrinsics.areEqual(((ResolveInfo) t3).activityInfo.packageName, "com.tencent.mobileqq")) {
                    break;
                }
            }
            if (t3 != null) {
                List<HolderItem> list4 = this.dataList;
                HolderItem build7 = HolderItem.newBuilder().entityType("qq").build();
                Intrinsics.checkNotNullExpressionValue(build7, "HolderItem.newBuilder().…e(ENTITY_TYPE_QQ).build()");
                list4.add(build7);
            }
            Iterator<T> it5 = this.shareApps.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    t4 = null;
                    break;
                }
                t4 = it5.next();
                if (Intrinsics.areEqual(((ResolveInfo) t4).activityInfo.packageName, "com.tencent.tim")) {
                    break;
                }
            }
            if (t4 != null) {
                List<HolderItem> list5 = this.dataList;
                HolderItem build8 = HolderItem.newBuilder().entityType("tim").build();
                Intrinsics.checkNotNullExpressionValue(build8, "HolderItem.newBuilder().…(ENTITY_TYPE_TIM).build()");
                list5.add(build8);
            }
            Iterator<T> it6 = this.shareApps.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                T next = it6.next();
                if (Intrinsics.areEqual(((ResolveInfo) next).activityInfo.packageName, "com.zhihu.android")) {
                    t = next;
                    break;
                }
            }
            if (t != null) {
                List<HolderItem> list6 = this.dataList;
                HolderItem build9 = HolderItem.newBuilder().entityType("zhihu").build();
                Intrinsics.checkNotNullExpressionValue(build9, "HolderItem.newBuilder().…NTITY_TYPE_ZHIHU).build()");
                list6.add(build9);
            }
            List<HolderItem> list7 = this.dataList;
            HolderItem build10 = HolderItem.newBuilder().entityType("copy_link").build();
            Intrinsics.checkNotNullExpressionValue(build10, "HolderItem.newBuilder().…Y_TYPE_COPY_LINK).build()");
            list7.add(build10);
            List<HolderItem> list8 = this.dataList;
            HolderItem build11 = HolderItem.newBuilder().entityType("more").build();
            Intrinsics.checkNotNullExpressionValue(build11, "HolderItem.newBuilder().…ENTITY_TYPE_MORE).build()");
            list8.add(build11);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Entity getEntity() {
            return this.entity;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity$DataAdapter$Companion;", "", "()V", "ENTITY_TYPE_COLLECTION", "", "ENTITY_TYPE_COPY_LINK", "ENTITY_TYPE_KANKANHAO", "ENTITY_TYPE_MESSAGE", "ENTITY_TYPE_MORE", "ENTITY_TYPE_NEW_FEED", "ENTITY_TYPE_QQ", "ENTITY_TYPE_TIM", "ENTITY_TYPE_WEIBO", "ENTITY_TYPE_WEXIN", "ENTITY_TYPE_WEXIN_MOMENT", "ENTITY_TYPE_ZHIHU", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ShareListActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(2131558749, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…LAYOUT_ID, parent, false)");
            return new SimpleViewHolder(inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataList.size();
        }

        public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int i) {
            Intrinsics.checkNotNullParameter(simpleViewHolder, "holder");
            ItemForwardEntityShareAppBinding itemForwardEntityShareAppBinding = (ItemForwardEntityShareAppBinding) simpleViewHolder.getBinding();
            GlideApp.with(itemForwardEntityShareAppBinding.iconView).clear(itemForwardEntityShareAppBinding.iconView);
            String entityType = this.dataList.get(i).getEntityType();
            if (entityType != null) {
                switch (entityType.hashCode()) {
                    case -1462912464:
                        if (entityType.equals("wexin_moment")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231318);
                            TextView textView = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
                            textView.setText("朋友圈");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$5(this));
                            return;
                        }
                        return;
                    case -872750698:
                        if (entityType.equals("kankanhao")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231316);
                            TextView textView2 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
                            textView2.setText("看看号");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$3(this));
                            return;
                        }
                        return;
                    case 3616:
                        if (entityType.equals("qq")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231319);
                            TextView textView3 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleView");
                            textView3.setText("QQ");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$6(this));
                            return;
                        }
                        return;
                    case 114840:
                        if (entityType.equals("tim")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231320);
                            TextView textView4 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView4, "binding.titleView");
                            textView4.setText("TIM");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$7(this));
                            return;
                        }
                        return;
                    case 3357525:
                        if (entityType.equals("more")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231317);
                            TextView textView5 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView5, "binding.titleView");
                            textView5.setText("更多");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$10(this));
                            return;
                        }
                        return;
                    case 113011944:
                        if (entityType.equals("weibo")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231322);
                            TextView textView6 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView6, "binding.titleView");
                            textView6.setText("微博");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$11(this));
                            return;
                        }
                        return;
                    case 113026575:
                        if (entityType.equals("wexin")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231321);
                            TextView textView7 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView7, "binding.titleView");
                            textView7.setText("微信");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$4(this));
                            return;
                        }
                        return;
                    case 115872072:
                        if (entityType.equals("zhihu")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231323);
                            TextView textView8 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView8, "binding.titleView");
                            textView8.setText("知乎");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$8(this));
                            return;
                        }
                        return;
                    case 954925063:
                        if (entityType.equals("message")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231496);
                            TextView textView9 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView9, "binding.titleView");
                            textView9.setText("私信");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$2(this));
                            return;
                        }
                        return;
                    case 1376909533:
                        if (entityType.equals("new_feed")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231315);
                            TextView textView10 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView10, "binding.titleView");
                            textView10.setText("动态");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$1(this));
                            return;
                        }
                        return;
                    case 1505434244:
                        if (entityType.equals("copy_link")) {
                            itemForwardEntityShareAppBinding.iconView.setImageResource(2131231314);
                            TextView textView11 = itemForwardEntityShareAppBinding.titleView;
                            Intrinsics.checkNotNullExpressionValue(textView11, "binding.titleView");
                            textView11.setText("复制链接");
                            itemForwardEntityShareAppBinding.rootView.setOnClickListener(new ShareListActivity$DataAdapter$onBindViewHolder$9(this));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* access modifiers changed from: private */
        public final void shareTextTo(ResolveInfo resolveInfo) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            intent.setType("text/*");
            intent.putExtra("android.intent.extra.TEXT", this.shareInfo.getContent());
            intent.addFlags(268435456);
            this.context.startActivity(intent);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity$SimpleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareListActivity.kt */
    private static final class SimpleViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558749;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleViewHolder(View view) {
            super(view, null, null);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemForwardEntityShareAppBinding itemForwardEntityShareAppBinding = (ItemForwardEntityShareAppBinding) getBinding();
            View root = itemForwardEntityShareAppBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "root");
            root.getLayoutParams().width = -1;
            itemForwardEntityShareAppBinding.getRoot().setPadding(0, 0, 0, 0);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sharev8/ShareListActivity$SimpleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ShareListActivity.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
