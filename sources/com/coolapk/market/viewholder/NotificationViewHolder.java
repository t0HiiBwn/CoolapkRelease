package com.coolapk.market.viewholder;

import android.app.Activity;
import android.content.Context;
import android.text.style.URLSpan;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.ItemNotificationBinding;
import com.coolapk.market.event.NotificationDeletedEvent;
import com.coolapk.market.event.NotificationReadEvent;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Notification;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class NotificationViewHolder extends GenericBindHolder<ItemNotificationBinding, Notification> {
    public static final int LAYOUT_ID = 2131558849;
    private Notification mNotification;

    public NotificationViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
    }

    public static void deleteNotification(final Notification notification, final Context context) {
        DataManager.getInstance().deleteNotification(notification.getId()).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
            /* class com.coolapk.market.viewholder.NotificationViewHolder.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(context, th);
            }

            public void onNext(String str) {
                super.onNext((AnonymousClass1) str);
                EventBus.getDefault().post(new NotificationDeletedEvent(notification.getId()));
            }
        });
    }

    public static void deleteNotification(List<String> list, final Context context) {
        Observable.from(list).flatMap(new Func1<String, Observable<Result<String>>>() {
            /* class com.coolapk.market.viewholder.NotificationViewHolder.AnonymousClass3 */

            public Observable<Result<String>> call(String str) {
                return DataManager.getInstance().deleteNotification(str);
            }
        }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
            /* class com.coolapk.market.viewholder.NotificationViewHolder.AnonymousClass2 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(context, th);
            }

            public void onNext(String str) {
                super.onNext((AnonymousClass2) str);
                EventBus.getDefault().post(new NotificationDeletedEvent(str));
            }
        });
    }

    public void bindToContent(Notification notification) {
        this.mNotification = notification;
        ((ItemNotificationBinding) getBinding()).setClick(this);
        ((ItemNotificationBinding) getBinding()).setTransformer(new CircleTransform());
        ((ItemNotificationBinding) getBinding()).setModel(notification);
        ((ItemNotificationBinding) getBinding()).executePendingBindings();
        ((ItemNotificationBinding) getBinding()).infoView.setMovementMethod(null);
        ((ItemNotificationBinding) getBinding()).cardView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.viewholder.$$Lambda$NotificationViewHolder$9TcMZXiekeeeDUELJZSVchWEUc */

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return NotificationViewHolder.this.lambda$bindToContent$0$NotificationViewHolder(view);
            }
        });
        this.itemView.setScrollX(0);
        this.itemView.setTranslationX(0.0f);
    }

    public /* synthetic */ boolean lambda$bindToContent$0$NotificationViewHolder(View view) {
        showDeleteNotificationDialog();
        return true;
    }

    private void showDeleteNotificationDialog() {
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        Activity activity = UiUtils.getActivity(getContext());
        dialogUtil.showConfigDialog(activity, "", "删除来自 " + this.mNotification.getFromUserName() + " 的通知?", new Function0() {
            /* class com.coolapk.market.viewholder.$$Lambda$NotificationViewHolder$RqL2Lj4m1CDCsg_9Gt1yK8oSGDw */

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NotificationViewHolder.this.lambda$showDeleteNotificationDialog$1$NotificationViewHolder();
            }
        });
    }

    public /* synthetic */ Unit lambda$showDeleteNotificationDialog$1$NotificationViewHolder() {
        deleteNotification(this.mNotification, getContext());
        return Unit.INSTANCE;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == 2131361892) {
            deleteNotification(this.mNotification, getContext());
        } else if (id == 2131362205) {
            URLSpan[] urls = ((ItemNotificationBinding) getBinding()).infoView.getUrls();
            if (urls != null && urls.length > 0) {
                if (urls[0].getURL().equals("/contacts/fans")) {
                    ActionManager.startUserSpaceActivity(this.itemView.findViewById(2131363900), this.mNotification.getFromUid(), this.mNotification.getUserAvatar());
                } else {
                    urls[0].onClick(view);
                }
            }
            if (this.mNotification.getIsNew() > 0) {
                EventBus.getDefault().post(new NotificationReadEvent(this.mNotification.getId()));
            }
        } else if (id == 2131363900) {
            ActionManagerCompat.startActivityByUrl(getContext(), this.mNotification.getUrl(), null, null);
        }
    }
}
