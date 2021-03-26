package com.coolapk.market.view.collectionList;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.event.CollectionDelEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.center.CenterV9Fragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 4, 2})
/* compiled from: CollectionItemViewholder.kt */
final class CollectionItemViewholder$bindToContent$1 implements View.OnLongClickListener {
    final /* synthetic */ Collection $entity;
    final /* synthetic */ CollectionItemViewholder this$0;

    CollectionItemViewholder$bindToContent$1(CollectionItemViewholder collectionItemViewholder, Collection collection) {
        this.this$0 = collectionItemViewholder;
        this.$entity = collection;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        DataBindingComponent component = this.this$0.getComponent();
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (!(fragment instanceof CenterV9Fragment)) {
            fragment = null;
        }
        CenterV9Fragment centerV9Fragment = (CenterV9Fragment) fragment;
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (!TextUtils.equals(loginSession.getUid(), this.$entity.getUid()) || centerV9Fragment != null) {
            return false;
        }
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要删除此收藏单么？删除后会取消收藏内部所有的内容", "确定", "取消");
        newInstance.setOnOkRunnable(new Runnable(this) {
            /* class com.coolapk.market.view.collectionList.CollectionItemViewholder$bindToContent$1.AnonymousClass1 */
            final /* synthetic */ CollectionItemViewholder$bindToContent$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DataManager.getInstance().deleteCollection(this.this$0.$entity.getId()).compose(RxUtils.apiCommonToData()).subscribe(new Action1<String>(this) {
                    /* class com.coolapk.market.view.collectionList.CollectionItemViewholder$bindToContent$1.AnonymousClass1.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            Toast.show$default(this.this$0.this$0.this$0.getContext(), str, 0, false, 12, null);
                            EventBus.getDefault().post(new CollectionDelEvent(this.this$0.this$0.$entity.getId()));
                        }
                    }
                }, new Action1<Throwable>(this) {
                    /* class com.coolapk.market.view.collectionList.CollectionItemViewholder$bindToContent$1.AnonymousClass1.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void call(Throwable th) {
                        Toast.error(this.this$0.this$0.this$0.getContext(), th);
                    }
                });
            }
        });
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
        return true;
    }
}
