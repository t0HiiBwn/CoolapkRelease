package com.coolapk.market.view.album;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class ConfirmAlbumBlockDialog extends BaseDialogFragment {
    private static final int FEED_BANNDED = 2;
    public static final String FEED_BLOCK = "FEED";
    private static final int FEED_FOLDED = 1;
    private static final int FEED_PRIIVATE = 0;
    public static final String FEED_REPLY_BLOCK = "FEED_REPLY";
    private int action;
    private Entity entity;

    public static ConfirmAlbumBlockDialog newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("content", str2);
        ConfirmAlbumBlockDialog confirmAlbumBlockDialog = new ConfirmAlbumBlockDialog();
        confirmAlbumBlockDialog.setArguments(bundle);
        return confirmAlbumBlockDialog;
    }

    public void setAction(Entity entity2, int i) {
        this.entity = entity2;
        this.action = i;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("content");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(string).setMessage(LinkTextUtils.convert(string2, AppHolder.getAppTheme().getTextColorPrimary(), null)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ConfirmAlbumBlockDialog.this.executeAction();
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        return builder.create();
    }

    /* access modifiers changed from: private */
    public void executeAction() {
        executeAction(this.entity, this.action, getActivity());
    }

    private static void executeAction(Entity entity2, int i, final Context context) {
        if (entity2 != null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        throw new RuntimeException("error action or type: " + i + "or" + entity2.getEntityType());
                    } else if (EntityUtils.isAlbumType(entity2.getEntityType())) {
                        final Album album = (Album) entity2;
                        AlbumActionPresenter.getInstance().feedBlockBanned(album).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                            /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass6 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                super.onError(th);
                                Toast.error(context, th);
                            }

                            public void onNext(String str) {
                                super.onNext((AnonymousClass6) str);
                                Toast.show(AppHolder.getApplication(), str);
                                EventBus.getDefault().post(new FeedDeleteEvent(album.getAlbumId()));
                            }
                        });
                    } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                        final FeedReply feedReply = (FeedReply) entity2;
                        AlbumActionPresenter.getInstance().feedReplyBlockBanned(feedReply).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                            /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass7 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                super.onError(th);
                                Toast.error(context, th);
                            }

                            public void onNext(String str) {
                                super.onNext((AnonymousClass7) str);
                                Toast.show(AppHolder.getApplication(), str);
                                EventBus.getDefault().post(new FeedReplyDeleteEvent(feedReply));
                            }
                        });
                    }
                } else if (EntityUtils.isAlbumType(entity2.getEntityType())) {
                    final Album album2 = (Album) entity2;
                    AlbumActionPresenter.getInstance().feedBlockFolded(album2).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                        /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass4 */

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            Toast.error(context, th);
                        }

                        public void onNext(String str) {
                            super.onNext((AnonymousClass4) str);
                            Toast.show(AppHolder.getApplication(), str);
                            EventBus.getDefault().post(new FeedDeleteEvent(album2.getAlbumId()));
                        }
                    });
                } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                    final FeedReply feedReply2 = (FeedReply) entity2;
                    AlbumActionPresenter.getInstance().feedReplyBlockFolded(feedReply2).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                        /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass5 */

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            Toast.error(context, th);
                        }

                        public void onNext(String str) {
                            super.onNext((AnonymousClass5) str);
                            Toast.show(AppHolder.getApplication(), str);
                            EventBus.getDefault().post(new FeedReplyDeleteEvent(feedReply2));
                        }
                    });
                }
            } else if (EntityUtils.isAlbumType(entity2.getEntityType())) {
                final Album album3 = (Album) entity2;
                AlbumActionPresenter.getInstance().feedBlockPrivate(album3).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                    /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass2 */

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        Toast.error(context, th);
                    }

                    public void onNext(String str) {
                        super.onNext((AnonymousClass2) str);
                        Toast.show(AppHolder.getApplication(), str);
                        EventBus.getDefault().post(new FeedDeleteEvent(album3.getAlbumId()));
                    }
                });
            } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                final FeedReply feedReply3 = (FeedReply) entity2;
                AlbumActionPresenter.getInstance().feedReplyBlockPrivate(feedReply3).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                    /* class com.coolapk.market.view.album.ConfirmAlbumBlockDialog.AnonymousClass3 */

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        Toast.error(context, th);
                    }

                    public void onNext(String str) {
                        super.onNext((AnonymousClass3) str);
                        Toast.show(AppHolder.getApplication(), str);
                        EventBus.getDefault().post(new FeedReplyDeleteEvent(feedReply3));
                    }
                });
            }
        }
    }
}
