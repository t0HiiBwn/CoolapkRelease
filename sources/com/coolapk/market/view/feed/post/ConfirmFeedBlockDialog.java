package com.coolapk.market.view.feed.post;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedBlockEvent;
import com.coolapk.market.event.FeedDeleteEvent;
import com.coolapk.market.event.FeedReplyBlockEvent;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.album.AlbumActionPresenter;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.view.feed.FeedActionPresenter;
import com.coolapk.market.widget.Toast;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class ConfirmFeedBlockDialog extends BaseDialogFragment {
    public static final int FEED_BANNDED = 2;
    public static final String FEED_BLOCK = "FEED";
    public static final int FEED_FOLDED = 1;
    public static final int FEED_PRIIVATE = 0;
    public static final String FEED_REPLY_BLOCK = "FEED_REPLY";
    public static final int FEED_SOFT_FOLDED = 4;
    public static final int FEED_UNBANNED_WITH_ONLY_HOME_SELF = 5;
    public static final int FEED_UNLINK = 3;
    private int action;
    private Context context;
    private Entity entity;
    private boolean isSet;
    private String type;

    public static ConfirmFeedBlockDialog newInstance(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("content", str2);
        ConfirmFeedBlockDialog confirmFeedBlockDialog = new ConfirmFeedBlockDialog();
        confirmFeedBlockDialog.setArguments(bundle);
        return confirmFeedBlockDialog;
    }

    public void setAction(Entity entity2, int i, boolean z, Context context2) {
        this.entity = entity2;
        this.action = i;
        this.isSet = z;
        this.context = context2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        String string2 = getArguments().getString("content");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(string).setMessage(LinkTextUtils.convert(string2, AppHolder.getAppTheme().getTextColorPrimary(), null)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass1 */

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ConfirmFeedBlockDialog.this.executeAction();
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        return builder.create();
    }

    /* access modifiers changed from: private */
    public void executeAction() {
        executeAction(this.entity, this.action, this.isSet, this.context);
    }

    public static void executeAction(Entity entity2, int i, final boolean z, final Context context2) {
        if (entity2 != null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            final Feed feed = (Feed) entity2;
                            FeedActionPresenter.getInstance().feedUnLink(feed).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                                /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass20 */

                                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                public void onError(Throwable th) {
                                    super.onError(th);
                                    Toast.error(context2, th);
                                }

                                public void onNext(String str) {
                                    super.onNext((AnonymousClass20) str);
                                    Toast.show(context2, str);
                                    EventBus.getDefault().post(new FeedDeleteEvent(feed.getId()));
                                }
                            });
                        } else if (i == 4) {
                            String entityType = entity2.getEntityType();
                            entityType.hashCode();
                            if (entityType.equals("feed")) {
                                final Feed feed2 = (Feed) entity2;
                                FeedActionPresenter.getInstance().feedUnsetMessageStatus(feed2).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass12 */

                                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                    public void onError(Throwable th) {
                                        super.onError(th);
                                        Toast.error(context2, th);
                                    }

                                    public void onNext(String str) {
                                        super.onNext((AnonymousClass12) str);
                                        Toast.show(AppHolder.getApplication(), str);
                                        EventBus.getDefault().post(new FeedBlockEvent(feed2.getId(), z));
                                        EventBus.getDefault().post(new FeedDeleteEvent(feed2.getId()));
                                    }
                                });
                            } else if (entityType.equals("album")) {
                                final Album album = (Album) entity2;
                                AlbumActionPresenter.getInstance().feedUnsetMessageStatus(album).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass13 */

                                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                    public void onError(Throwable th) {
                                        super.onError(th);
                                        Toast.error(context2, th);
                                    }

                                    public void onNext(String str) {
                                        super.onNext((AnonymousClass13) str);
                                        Toast.show(AppHolder.getApplication(), str);
                                        EventBus.getDefault().post(new FeedBlockEvent(album.getId(), z));
                                        EventBus.getDefault().post(new FeedDeleteEvent(album.getId()));
                                    }
                                });
                            }
                        } else if (i != 5) {
                            throw new RuntimeException("error action or type: " + i + " o r" + entity2.getEntityType());
                        } else if (EntityUtils.isFeedType(entity2.getEntityType())) {
                            final Feed feed3 = (Feed) entity2;
                            FeedActionPresenter.getInstance().feedUnBlockBannedWithOnlyHomeSelf(feed3).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<String>() {
                                /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass21 */

                                @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                public void onError(Throwable th) {
                                    super.onError(th);
                                    Toast.error(context2, th);
                                }

                                public void onNext(String str) {
                                    super.onNext((AnonymousClass21) str);
                                    Toast.show(AppHolder.getApplication(), str);
                                    EventBus.getDefault().post(new FeedDeleteEvent(feed3.getId()));
                                }
                            });
                        }
                    } else if (EntityUtils.isFeedType(entity2.getEntityType())) {
                        final Feed feed4 = (Feed) entity2;
                        Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass15 */

                            public Observable<Result<String>> call(Boolean bool) {
                                if (bool.booleanValue()) {
                                    return FeedActionPresenter.getInstance().feedUnBlockBanned(feed4);
                                }
                                return FeedActionPresenter.getInstance().feedBlockBanned(feed4);
                            }
                        }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass14 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                super.onError(th);
                                Toast.error(context2, th);
                            }

                            public void onNext(String str) {
                                super.onNext((AnonymousClass14) str);
                                Toast.show(AppHolder.getApplication(), str);
                                EventBus.getDefault().post(new FeedDeleteEvent(feed4.getId()));
                            }
                        });
                    } else if (EntityUtils.isAlbumType(entity2.getEntityType())) {
                        final Album album2 = (Album) entity2;
                        Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass17 */

                            public Observable<Result<String>> call(Boolean bool) {
                                if (bool.booleanValue()) {
                                    return AlbumActionPresenter.getInstance().feedUnBlockBanned(album2);
                                }
                                return AlbumActionPresenter.getInstance().feedBlockBanned(album2);
                            }
                        }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass16 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                super.onError(th);
                                Toast.error(context2, th);
                            }

                            public void onNext(String str) {
                                super.onNext((AnonymousClass16) str);
                                Toast.show(AppHolder.getApplication(), str);
                                EventBus.getDefault().post(new FeedDeleteEvent(album2.getId()));
                            }
                        });
                    } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                        final FeedReply feedReply = (FeedReply) entity2;
                        Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass19 */

                            public Observable<Result<String>> call(Boolean bool) {
                                if (bool.booleanValue()) {
                                    return FeedActionPresenter.getInstance().feedReplyUnBlockBanned(feedReply);
                                }
                                return FeedActionPresenter.getInstance().feedReplyBlockBanned(feedReply);
                            }
                        }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                            /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass18 */

                            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                            public void onError(Throwable th) {
                                super.onError(th);
                                Toast.error(context2, th);
                            }

                            public void onNext(String str) {
                                super.onNext((AnonymousClass18) str);
                                Toast.show(AppHolder.getApplication(), str);
                                EventBus.getDefault().post(new FeedReplyBlockEvent(feedReply, z));
                            }
                        });
                    }
                } else if (EntityUtils.isFeedType(entity2.getEntityType())) {
                    final Feed feed5 = (Feed) entity2;
                    Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass7 */

                        public Observable<Result<String>> call(Boolean bool) {
                            if (bool.booleanValue()) {
                                return FeedActionPresenter.getInstance().feedUnBlockFolded(feed5);
                            }
                            return FeedActionPresenter.getInstance().feedBlockFolded(feed5);
                        }
                    }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass6 */

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            Toast.error(context2, th);
                        }

                        public void onNext(String str) {
                            super.onNext((AnonymousClass6) str);
                            Toast.show(AppHolder.getApplication(), str);
                            EventBus.getDefault().post(new FeedBlockEvent(feed5.getId(), z));
                            EventBus.getDefault().post(new FeedDeleteEvent(feed5.getId()));
                        }
                    });
                } else if (EntityUtils.isAlbumType(entity2.getEntityType())) {
                    final Album album3 = (Album) entity2;
                    Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass9 */

                        public Observable<Result<String>> call(Boolean bool) {
                            if (bool.booleanValue()) {
                                return AlbumActionPresenter.getInstance().feedUnBlockFolded(album3);
                            }
                            return AlbumActionPresenter.getInstance().feedBlockFolded(album3);
                        }
                    }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass8 */

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            Toast.error(context2, th);
                        }

                        public void onNext(String str) {
                            super.onNext((AnonymousClass8) str);
                            Toast.show(AppHolder.getApplication(), str);
                            EventBus.getDefault().post(new FeedBlockEvent(album3.getId(), z));
                            EventBus.getDefault().post(new FeedDeleteEvent(album3.getId()));
                        }
                    });
                } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                    final FeedReply feedReply2 = (FeedReply) entity2;
                    Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass11 */

                        public Observable<Result<String>> call(Boolean bool) {
                            if (bool.booleanValue()) {
                                return FeedActionPresenter.getInstance().feedReplyUnBlockFolded(feedReply2);
                            }
                            return FeedActionPresenter.getInstance().feedReplyBlockFolded(feedReply2);
                        }
                    }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                        /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass10 */

                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            Toast.error(context2, th);
                        }

                        public void onNext(String str) {
                            super.onNext((AnonymousClass10) str);
                            Toast.show(AppHolder.getApplication(), str);
                            EventBus.getDefault().post(new FeedReplyBlockEvent(feedReply2, z));
                        }
                    });
                }
            } else if (EntityUtils.isFeedType(entity2.getEntityType())) {
                final Feed feed6 = (Feed) entity2;
                Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass3 */

                    public Observable<Result<String>> call(Boolean bool) {
                        if (bool.booleanValue()) {
                            return FeedActionPresenter.getInstance().feedUnBlockPrivate(feed6);
                        }
                        return FeedActionPresenter.getInstance().feedBlockPrivate(feed6);
                    }
                }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass2 */

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        Toast.error(context2, th);
                    }

                    public void onNext(String str) {
                        super.onNext((AnonymousClass2) str);
                        Toast.show(AppHolder.getApplication(), str);
                        if (!z) {
                            EventBus.getDefault().post(new FeedDeleteEvent(feed6.getId()));
                        }
                    }
                });
            } else if (EntityUtils.isFeedreply(entity2.getEntityType())) {
                final FeedReply feedReply3 = (FeedReply) entity2;
                Observable.just(Boolean.valueOf(z)).flatMap(new Func1<Boolean, Observable<Result<String>>>() {
                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass5 */

                    public Observable<Result<String>> call(Boolean bool) {
                        if (bool.booleanValue()) {
                            return FeedActionPresenter.getInstance().feedReplyUnBlockPrivate(feedReply3);
                        }
                        return FeedActionPresenter.getInstance().feedReplyBlockPrivate(feedReply3);
                    }
                }).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new EmptySubscriber<String>() {
                    /* class com.coolapk.market.view.feed.post.ConfirmFeedBlockDialog.AnonymousClass4 */

                    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                    public void onError(Throwable th) {
                        super.onError(th);
                        Toast.error(context2, th);
                    }

                    public void onNext(String str) {
                        super.onNext((AnonymousClass4) str);
                        Toast.show(AppHolder.getApplication(), str);
                        EventBus.getDefault().post(new FeedReplyBlockEvent(feedReply3, z));
                    }
                });
            }
        }
    }
}
