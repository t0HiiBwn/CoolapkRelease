package com.coolapk.market.view.feed;

import com.coolapk.market.event.ContactsEvent;
import com.coolapk.market.event.DyhHandleEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.RemoveItemEvent;
import com.coolapk.market.event.TopicListDeleteEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.widget.Toast;
import java.util.Objects;
import kotlin.Metadata;
import org.greenrobot.eventbus.EventBus;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: CancelFollowItemDialog.kt */
final class CancelFollowItemDialog$CancelFollowActionItem$takeAction$1 implements Runnable {
    final /* synthetic */ CancelFollowItemDialog.CancelFollowActionItem this$0;

    CancelFollowItemDialog$CancelFollowActionItem$takeAction$1(CancelFollowItemDialog.CancelFollowActionItem cancelFollowActionItem) {
        this.this$0 = cancelFollowActionItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataManager.getInstance().cancelFollow(this.this$0.getId$presentation_coolapkAppRelease(), this.this$0.getType$presentation_coolapkAppRelease()).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).subscribe(new Action1<String>(this) {
            /* class com.coolapk.market.view.feed.CancelFollowItemDialog$CancelFollowActionItem$takeAction$1.AnonymousClass1 */
            final /* synthetic */ CancelFollowItemDialog$CancelFollowActionItem$takeAction$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(String str) {
                Toast.show$default(this.this$0.this$0.this$0.getActivity(), str, 0, false, 12, null);
                String type$presentation_coolapkAppRelease = this.this$0.this$0.getType$presentation_coolapkAppRelease();
                switch (type$presentation_coolapkAppRelease.hashCode()) {
                    case -567451565:
                        if (type$presentation_coolapkAppRelease.equals("contacts")) {
                            EventBus.getDefault().post(new ContactsEvent(false, this.this$0.this$0.getId$presentation_coolapkAppRelease()));
                            return;
                        }
                        break;
                    case -309474065:
                        if (type$presentation_coolapkAppRelease.equals("product")) {
                            return;
                        }
                        break;
                    case 96796:
                        if (type$presentation_coolapkAppRelease.equals("apk")) {
                            EventBus eventBus = EventBus.getDefault();
                            Entity access$getEntity$p = CancelFollowItemDialog.access$getEntity$p(this.this$0.this$0.this$0);
                            Objects.requireNonNull(access$getEntity$p, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                            eventBus.post(new RemoveItemEvent((ServiceApp) access$getEntity$p));
                            return;
                        }
                        break;
                    case 99955:
                        if (type$presentation_coolapkAppRelease.equals("dyh")) {
                            EventBus eventBus2 = EventBus.getDefault();
                            Entity access$getEntity$p2 = CancelFollowItemDialog.access$getEntity$p(this.this$0.this$0.this$0);
                            Objects.requireNonNull(access$getEntity$p2, "null cannot be cast to non-null type com.coolapk.market.model.DyhModel");
                            eventBus2.post(new DyhHandleEvent((DyhModel) access$getEntity$p2));
                            return;
                        }
                        break;
                    case 110546223:
                        if (type$presentation_coolapkAppRelease.equals("topic")) {
                            EventBus.getDefault().post(new TopicListDeleteEvent(CancelFollowItemDialog.access$getEntity$p(this.this$0.this$0.this$0).getId()));
                            return;
                        }
                        break;
                }
                EventBus.getDefault().post(new FeedDeleteEvent(CancelFollowItemDialog.access$getEntity$p(this.this$0.this$0.this$0).getId()));
            }
        }, new Action1<Throwable>(this) {
            /* class com.coolapk.market.view.feed.CancelFollowItemDialog$CancelFollowActionItem$takeAction$1.AnonymousClass2 */
            final /* synthetic */ CancelFollowItemDialog$CancelFollowActionItem$takeAction$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void call(Throwable th) {
                Toast.error(this.this$0.this$0.this$0.getActivity(), th);
            }
        });
    }
}
