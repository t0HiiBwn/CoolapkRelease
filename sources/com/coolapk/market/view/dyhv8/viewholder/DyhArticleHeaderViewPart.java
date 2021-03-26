package com.coolapk.market.view.dyhv8.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemDyhArticleHeaderBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.view.dyhv8.DyhContract;
import com.coolapk.market.view.dyhv8.DyhPresenter;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemDyhArticleHeaderBinding;", "Lcom/coolapk/market/model/Entity;", "Lcom/coolapk/market/view/dyhv8/DyhContract$View;", "dataBindingComponent", "Landroidx/databinding/DataBindingComponent;", "mDyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/dyhv8/DyhViewModel;)V", "mEntity", "mPresenter", "Lcom/coolapk/market/view/dyhv8/DyhContract$Presenter;", "DyhFollowed", "", "s", "", "isFollowAction", "", "DyhFollowedFailed", "e", "", "onBindToContent", "data", "onClick", "view", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleHeaderViewPart.kt */
public final class DyhArticleHeaderViewPart extends BindingViewPart<ItemDyhArticleHeaderBinding, Entity> implements DyhContract.View {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558677;
    private final DataBindingComponent dataBindingComponent;
    private final DyhViewModel mDyhViewModel;
    private Entity mEntity;
    private DyhContract.Presenter mPresenter;

    @JvmStatic
    public static final DyhArticleHeaderViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent2, DyhViewModel dyhViewModel) {
        return Companion.newInstance(viewGroup, dataBindingComponent2, dyhViewModel);
    }

    public DyhArticleHeaderViewPart(DataBindingComponent dataBindingComponent2, DyhViewModel dyhViewModel) {
        Intrinsics.checkNotNullParameter(dataBindingComponent2, "dataBindingComponent");
        Intrinsics.checkNotNullParameter(dyhViewModel, "mDyhViewModel");
        this.dataBindingComponent = dataBindingComponent2;
        this.mDyhViewModel = dyhViewModel;
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.View
    public void DyhFollowed(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mDyhViewModel.setLoading(false);
            this.mDyhViewModel.setFollowed(z);
            this.mDyhViewModel.setIsShowActionView(false);
        }
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.View
    public void DyhFollowedFailed(Throwable th, boolean z) {
        Toast.error(getContext(), th);
        this.mDyhViewModel.setLoading(false);
        this.mDyhViewModel.setFollowed(!z);
        DyhViewModel dyhViewModel = this.mDyhViewModel;
        dyhViewModel.setIsShowActionView(!dyhViewModel.getIsFollowDyh());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "newInstance", "Lcom/coolapk/market/view/dyhv8/viewholder/DyhArticleHeaderViewPart;", "container", "Landroid/view/ViewGroup;", "component", "Landroidx/databinding/DataBindingComponent;", "mDyhViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DyhArticleHeaderViewPart newInstance(ViewGroup viewGroup, DataBindingComponent dataBindingComponent, DyhViewModel dyhViewModel) {
            Intrinsics.checkNotNullParameter(viewGroup, "container");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            Intrinsics.checkNotNullParameter(dyhViewModel, "mDyhViewModel");
            DyhArticleHeaderViewPart dyhArticleHeaderViewPart = new DyhArticleHeaderViewPart(dataBindingComponent, dyhViewModel);
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(container.context)");
            dyhArticleHeaderViewPart.createView(from, viewGroup);
            return dyhArticleHeaderViewPart;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemDyhArticleHeaderBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558677, viewGroup, false, this.dataBindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…se, dataBindingComponent)");
        return (ItemDyhArticleHeaderBinding) inflate;
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        super.onBindToContent((DyhArticleHeaderViewPart) entity);
        this.mEntity = entity;
        Intrinsics.checkNotNull(entity);
        if (EntityUtils.isDyhArticleType(entity.getEntityType())) {
            DyhViewModel dyhViewModel = this.mDyhViewModel;
            Entity entity2 = this.mEntity;
            Objects.requireNonNull(entity2, "null cannot be cast to non-null type com.coolapk.market.model.DyhArticle");
            dyhViewModel.setDyhArticle((DyhArticle) entity2);
        } else {
            Entity entity3 = this.mEntity;
            Intrinsics.checkNotNull(entity3);
            if (EntityUtils.isFeedType(entity3.getEntityType())) {
                DyhViewModel dyhViewModel2 = this.mDyhViewModel;
                Entity entity4 = this.mEntity;
                Objects.requireNonNull(entity4, "null cannot be cast to non-null type com.coolapk.market.model.Feed");
                dyhViewModel2.setDyhModel(((Feed) entity4).getDyhModel());
            }
        }
        TextView textView = ((ItemDyhArticleHeaderBinding) getBinding()).headerActionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.headerActionView");
        textView.setBackground(ShapeUtils.createDyhUnFollowedRevealBg(getContext()));
        ((ItemDyhArticleHeaderBinding) getBinding()).setClick(this);
        DyhModel dyhModel = this.mDyhViewModel.getDyhModel();
        Intrinsics.checkNotNullExpressionValue(dyhModel, "mDyhViewModel.dyhModel");
        this.mPresenter = new DyhPresenter(this, dyhModel.getId());
        ((ItemDyhArticleHeaderBinding) getBinding()).setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 4), false));
        ((ItemDyhArticleHeaderBinding) getBinding()).setEntity(this.mEntity);
        ((ItemDyhArticleHeaderBinding) getBinding()).setViewModel(this.mDyhViewModel);
        ((ItemDyhArticleHeaderBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        switch (view.getId()) {
            case 2131362633:
            case 2131362889:
            case 2131363260:
            case 2131363391:
                Context context = getContext();
                DyhModel dyhModel = this.mDyhViewModel.getDyhModel();
                Intrinsics.checkNotNullExpressionValue(dyhModel, "mDyhViewModel.dyhModel");
                ActionManager.startDyhDetailActivity(context, dyhModel.getId());
                return;
            case 2131362641:
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                LoginSession loginSession = instance.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
                if (!loginSession.isLogin()) {
                    ActionManager.startLoginActivity(getContext());
                    return;
                }
                this.mDyhViewModel.setLoading(true);
                DyhViewModel dyhViewModel = this.mDyhViewModel;
                dyhViewModel.setIsShowActionView(!dyhViewModel.isFollowDyhLoading());
                if (!this.mDyhViewModel.getIsFollowDyh()) {
                    this.mDyhViewModel.setIsShowActionView(false);
                    DyhContract.Presenter presenter = this.mPresenter;
                    if (presenter != null) {
                        presenter.followDyh();
                        return;
                    }
                    return;
                }
                this.mDyhViewModel.setIsShowActionView(true);
                DyhContract.Presenter presenter2 = this.mPresenter;
                if (presenter2 != null) {
                    presenter2.unFollowDyh();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
