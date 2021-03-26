package com.coolapk.market.view.feed.post;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.album.AlbumActionPresenter;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.feed.FeedActionPresenter;
import com.coolapk.market.widget.Toast;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class ConfirmDeleteDialog extends BaseDialogFragment {
    private Entity entity;

    public static ConfirmDeleteDialog newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("content", str2);
        ConfirmDeleteDialog confirmDeleteDialog = new ConfirmDeleteDialog();
        confirmDeleteDialog.setArguments(bundle);
        return confirmDeleteDialog;
    }

    public void setDeleteTarget(Entity entity2) {
        this.entity = entity2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("content");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(string).setMessage(LinkTextUtils.convert(string2, AppHolder.getAppTheme().getTextColorPrimary(), null)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.feed.post.$$Lambda$ConfirmDeleteDialog$TD79q3bsNayqGi9SR_JLciMcVr4 */

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConfirmDeleteDialog.this.lambda$onCreateDialog$0$ConfirmDeleteDialog(dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        Entity entity2 = this.entity;
        boolean z = true;
        if (!(entity2 instanceof Feed) || ((Feed) entity2).getIsHistory() != 1) {
            z = false;
        }
        if (DataManager.getInstance().getLoginSession().isAdmin() && !z) {
            builder.setNeutralButton(2131886332, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.view.feed.post.$$Lambda$ConfirmDeleteDialog$fxr1hQyfe65qgNrGVRQaRbi_3F4 */

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ConfirmDeleteDialog.this.lambda$onCreateDialog$1$ConfirmDeleteDialog(dialogInterface, i);
                }
            });
        }
        return builder.create();
    }

    public /* synthetic */ void lambda$onCreateDialog$0$ConfirmDeleteDialog(DialogInterface dialogInterface, int i) {
        executeDelete(0);
    }

    public /* synthetic */ void lambda$onCreateDialog$1$ConfirmDeleteDialog(DialogInterface dialogInterface, int i) {
        executeDelete(1);
    }

    private void executeDelete(int i) {
        Entity entity2 = this.entity;
        if (entity2 != null) {
            if (entity2 instanceof Feed) {
                Feed feed = (Feed) entity2;
                if (feed.getIsHistory() == 1) {
                    deleteHistoryFeed(feed, i, getActivity());
                    return;
                }
            }
            String entityType = this.entity.getEntityType();
            entityType.hashCode();
            char c = 65535;
            switch (entityType.hashCode()) {
                case -121207376:
                    if (entityType.equals("discovery")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3138974:
                    if (entityType.equals("feed")) {
                        c = 1;
                        break;
                    }
                    break;
                case 92896879:
                    if (entityType.equals("album")) {
                        c = 2;
                        break;
                    }
                    break;
                case 580594953:
                    if (entityType.equals("feed_reply")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    Feed feed2 = (Feed) this.entity;
                    if (TextUtils.equals(feed2.getFeedType(), "album")) {
                        ConfirmDialog newInstance = ConfirmDialog.newInstance(getString(2131886784), getString(2131886771, feed2.getExtraTitle()));
                        newInstance.setOnOkRunnable(new Runnable(feed2, i) {
                            /* class com.coolapk.market.view.feed.post.$$Lambda$ConfirmDeleteDialog$c6uTiwfzHVfE_F6m_YUrx9z5WMY */
                            public final /* synthetic */ Feed f$1;
                            public final /* synthetic */ int f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                ConfirmDeleteDialog.this.lambda$executeDelete$2$ConfirmDeleteDialog(this.f$1, this.f$2);
                            }
                        });
                        newInstance.show(requireActivity().getSupportFragmentManager(), (String) null);
                        return;
                    } else if (feed2.getFavoriteNum() >= 100) {
                        ConfirmDialog newInstance2 = ConfirmDialog.newInstance(getString(2131886784), String.format(Locale.getDefault(), "您的这条动态已经有%d人收藏，删除会导致收藏失效并丢失经验，您确定要删除么？💔💔💔", Integer.valueOf(feed2.getFavoriteNum())));
                        newInstance2.setOnOkRunnable(new Runnable(feed2, i) {
                            /* class com.coolapk.market.view.feed.post.$$Lambda$ConfirmDeleteDialog$OtGeIlyetQdMvgadz1uwdzZI18 */
                            public final /* synthetic */ Feed f$1;
                            public final /* synthetic */ int f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                ConfirmDeleteDialog.this.lambda$executeDelete$3$ConfirmDeleteDialog(this.f$1, this.f$2);
                            }
                        });
                        newInstance2.show(requireActivity().getSupportFragmentManager(), (String) null);
                        return;
                    } else {
                        deleteFeed(feed2, i, getActivity());
                        return;
                    }
                case 2:
                    deleteAlbum((Album) this.entity, i, getActivity());
                    return;
                case 3:
                    deleteFeedReply((FeedReply) this.entity, i, getActivity());
                    return;
                default:
                    throw new RuntimeException("error type: " + this.entity.getEntityType());
            }
        }
    }

    public /* synthetic */ void lambda$executeDelete$2$ConfirmDeleteDialog(Feed feed, int i) {
        deleteFeed(feed, i, getActivity());
    }

    public /* synthetic */ void lambda$executeDelete$3$ConfirmDeleteDialog(Feed feed, int i) {
        deleteFeed(feed, i, getActivity());
    }

    private static void deleteFeedReply(final FeedReply feedReply, int i, final Context context) {
        FeedActionPresenter.getInstance().deleteFeedReply(feedReply, i).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.feed.post.ConfirmDeleteDialog.AnonymousClass1 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(context, th);
            }

            public void onNext(Result<String> result) {
                super.onNext((AnonymousClass1) result);
                Toast.show(context, "删除成功");
                EventBus.getDefault().post(new FeedReplyDeleteEvent(feedReply));
            }
        });
    }

    private static void deleteFeed(final Feed feed, int i, final Context context) {
        FeedActionPresenter.getInstance().deleteFeed(feed, i).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.feed.post.ConfirmDeleteDialog.AnonymousClass2 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(context, th);
            }

            public void onNext(Result<String> result) {
                super.onNext((AnonymousClass2) result);
                Toast.show(context, "删除成功");
                EventBus.getDefault().post(new FeedDeleteEvent(feed.getId()));
            }
        });
    }

    private static void deleteHistoryFeed(final Feed feed, int i, final Context context) {
        FeedActionPresenter.getInstance().deleteHistoryFeed(feed, i).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.feed.post.ConfirmDeleteDialog.AnonymousClass3 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(context, th);
            }

            public void onNext(Result<String> result) {
                super.onNext((AnonymousClass3) result);
                Toast.show(context, "删除成功");
                EventBus.getDefault().post(new FeedDeleteEvent(feed.getId()));
            }
        });
    }

    private static void deleteAlbum(final Album album, int i, final Context context) {
        AlbumActionPresenter.getInstance().deleteAlbum(album, i).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.view.feed.post.ConfirmDeleteDialog.AnonymousClass4 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                super.onError(th);
                Toast.error(context, th);
            }

            public void onNext(Result<String> result) {
                super.onNext((AnonymousClass4) result);
                Toast.show(context, "删除成功");
                EventBus.getDefault().post(new FeedDeleteEvent(album.getAlbumId()));
            }
        });
    }
}
