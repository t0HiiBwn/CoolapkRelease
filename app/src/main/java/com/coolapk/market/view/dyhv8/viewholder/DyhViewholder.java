package com.coolapk.market.view.dyhv8.viewholder;

import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemFollowDyhBinding;
import com.coolapk.market.event.DyhHandleEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.view.dyhv8.DyhContract;
import com.coolapk.market.view.dyhv8.DyhPresenter;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.functions.Action1;

public class DyhViewholder extends GenericBindHolder<ItemFollowDyhBinding, DyhModel> implements DyhContract.View {
    public static final int LAYOUT_ID = 2131558747;
    private final DyhViewModel dyhViewModel = new DyhViewModel();
    private boolean isRequesting;
    private DyhPresenter mPresenter;

    public DyhViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public void bindToContent(final DyhModel dyhModel) {
        this.mPresenter = new DyhPresenter(this, dyhModel.getId());
        this.dyhViewModel.setDyhModel(dyhModel);
        ((ItemFollowDyhBinding) getBinding()).setModel(this.dyhViewModel);
        ((ItemFollowDyhBinding) getBinding()).setClick(this);
        ((ItemFollowDyhBinding) getBinding()).actionView.setBackground(this.dyhViewModel.getIsFollowDyh() ? ShapeUtils.createDyhFollowBg(getContext()) : ShapeUtils.createDyhUnFollowBg(getContext()));
        boolean z = false;
        ((ItemFollowDyhBinding) getBinding()).setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf(8), false));
        if (EntityExtendsKt.getIntExtraData(dyhModel, "showCancelFollowMenu", 0) == 1) {
            z = true;
        }
        if (z || this.dyhViewModel.getIsDyhFollowList()) {
            ((ItemFollowDyhBinding) getBinding()).rootView.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.coolapk.market.view.dyhv8.viewholder.DyhViewholder.AnonymousClass1 */

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    CancelFollowItemDialog.newInstance(dyhModel).show(ContextExtendsKt.requireAppCompatActivity(DyhViewholder.this.getContext()).getSupportFragmentManager(), (String) null);
                    return true;
                }
            });
        }
        ((ItemFollowDyhBinding) getBinding()).executePendingBindings();
    }

    private void updateViewModel(boolean z) {
        this.dyhViewModel.setFollowDyh(z);
        this.dyhViewModel.setDyhModel(DyhModel.newBuilder(this.dyhViewModel.getDyhModel()).entityTemplate(this.dyhViewModel.getNewBuildEntityTemplate()).userAction(UserAction.newBuilder(this.dyhViewModel.getDyhModel().getUserAction()).follow(z ? 1 : 0).build()).followNum(z ? this.dyhViewModel.getDyhModel().getFollowNum() + 1 : this.dyhViewModel.getDyhModel().getFollowNum() - 1).build());
        ((ItemFollowDyhBinding) getBinding()).actionView.setBackground(this.dyhViewModel.getIsFollowDyh() ? ShapeUtils.createDyhFollowBg(getContext()) : ShapeUtils.createDyhUnFollowBg(getContext()));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id != 2131361981) {
            if (id == 2131363260) {
                Observable.timer(2000, TimeUnit.MILLISECONDS).subscribe(new Action1<Long>() {
                    /* class com.coolapk.market.view.dyhv8.viewholder.DyhViewholder.AnonymousClass2 */

                    public void call(Long l2) {
                        DyhViewholder.this.dyhViewModel.cleanRedPoint();
                    }
                });
                EventBus.getDefault().post(new DyhHandleEvent(this.dyhViewModel.getDyhModel()));
                ActionManager.startDyhDetailActivity(getContext(), this.dyhViewModel.getDyhModel());
                StatisticHelper.getInstance().recordEntityEvent("", this.dyhViewModel.getDyhModel(), getAdapterPosition(), null, "");
            }
        } else if (!DataManager.getInstance().getLoginSession().isLogin()) {
            ActionManager.startLoginActivity(getContext());
        } else if (!this.isRequesting) {
            this.isRequesting = true;
            if (!this.dyhViewModel.getIsFollowDyh()) {
                updateViewModel(true);
                this.mPresenter.followDyh();
                return;
            }
            updateViewModel(false);
            this.mPresenter.unFollowDyh();
        }
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.View
    public void DyhFollowed(String str, boolean z) {
        this.isRequesting = false;
        EventBus.getDefault().post(new DyhHandleEvent(this.dyhViewModel.getDyhModel()));
    }

    @Override // com.coolapk.market.view.dyhv8.DyhContract.View
    public void DyhFollowedFailed(Throwable th, boolean z) {
        Toast.error(getContext(), th);
        this.isRequesting = false;
        DyhViewModel dyhViewModel2 = this.dyhViewModel;
        dyhViewModel2.setFollowDyh(!dyhViewModel2.getIsFollowDyh());
        EventBus.getDefault().post(new DyhHandleEvent(this.dyhViewModel.getDyhModel()));
    }
}
