package com.coolapk.market.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.databinding.AlbumActionBarBinding;
import com.coolapk.market.event.AlbumLikeEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Album;
import com.coolapk.market.model.AlbumItem;
import com.coolapk.market.model.DownloadInfo;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.LikeResult;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.album.AlbumActionPresenter;
import com.coolapk.market.view.album.albumv8.AlbumDetailActivity;
import com.coolapk.market.view.base.SimpleDialog;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class AlbumActionView extends LinearLayout implements View.OnClickListener {
    public static final FeedItem COLLECT = new FeedItem(2131886848, 2131231216, 2131362013);
    public static final int COLLECTED = 2131231218;
    public static final FeedItem DELETE = new FeedItem(2131886849, null, 2131362014);
    public static final FeedItem DOWNLOAD = new FeedItem(2131886850, 2131231280, 2131362015);
    public static final int DOWNLOADING = 2131231477;
    public static final FeedItem LIKE = new FeedItem(2131886852, 2131231617, 2131362017);
    public static final int LIKED = 2131231619;
    public static final FeedItem REPLY = new FeedItem(2131886853, 2131231226, 2131362018);
    private Album album;
    private AlbumActionBarBinding binding;
    boolean collectState;
    boolean isDownloading;
    boolean isReQuestAlbum;
    boolean likeState;
    private AlbumActionPresenter mAlbumActionPresenter = AlbumActionPresenter.getInstance();
    private View.OnClickListener outerOnClickListener;
    boolean postingCollect;
    boolean postingDelete;
    boolean postingLike;

    public AlbumActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public AlbumActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.binding = (AlbumActionBarBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), 2131558439, this, true);
        this.binding.downloadLayout.setVisibility(AppHolder.getAppMetadata().isCommunityMode() ? 8 : 0);
        ViewUtil.clickListener(this.binding.starLayout, this);
        ViewUtil.clickListener(this.binding.likeLayout, this);
        ViewUtil.clickListener(this.binding.commentLayout, this);
        ViewUtil.clickListener(this.binding.downloadLayout, this);
    }

    public void updateAlbum(Album album2) {
        String str;
        String str2;
        String str3;
        this.album = album2;
        if (album2 != null) {
            UserAction userAction = album2.getUserAction();
            this.postingLike = false;
            this.postingCollect = false;
            boolean z = true;
            this.likeState = userAction != null && userAction.getLike() > 0;
            TextView textView = this.binding.likeText;
            if (album2.getLikeNum() > 0) {
                str = String.valueOf(album2.getLikeNum());
            } else {
                str = getContext().getString(LIKE.title.intValue());
            }
            textView.setText(str);
            TextView textView2 = this.binding.commentText;
            if (album2.getReplyNum() > 0) {
                str2 = String.valueOf(album2.getReplyNum());
            } else {
                str2 = getContext().getString(REPLY.title.intValue());
            }
            textView2.setText(str2);
            TextView textView3 = this.binding.starText;
            if (album2.getFavoriteNum() > 0) {
                str3 = String.valueOf(album2.getFavoriteNum());
            } else {
                str3 = getContext().getString(COLLECT.title.intValue());
            }
            textView3.setText(str3);
            if (userAction == null) {
                this.binding.likeView.setImageResource(LIKE.icon.intValue());
                this.binding.starView.setImageResource(COLLECT.icon.intValue());
            } else {
                this.binding.likeView.setImageResource(userAction.getLike() > 0 ? 2131231619 : LIKE.icon.intValue());
                this.binding.starView.setImageResource(userAction.getCollect() > 0 ? 2131231218 : COLLECT.icon.intValue());
                this.collectState = userAction.getCollect() > 0;
            }
            if (DataManager.getInstance().getDownloadTaskCount() <= 0) {
                z = false;
            }
            this.isDownloading = z;
            if (!z) {
                this.isDownloading = false;
                this.binding.downloadText.setText(2131886128);
                this.binding.downloadView.setImageResource(DOWNLOAD.icon.intValue());
            }
        }
    }

    private void setDeleteButtonVisibility(boolean z) {
        View findViewById = findViewById(DELETE.containerId.intValue());
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.album != null) {
            switch (view.getId()) {
                case 2131362293:
                    Activity activity = UiUtils.getActivity(getContext());
                    if (activity instanceof AlbumDetailActivity) {
                        ((AlbumDetailActivity) activity).selectPage(1);
                        break;
                    }
                    break;
                case 2131362427:
                    if (!this.isDownloading) {
                        SimpleDialog newInstance = SimpleDialog.newInstance();
                        newInstance.setMessage(getContext().getString(2131886787));
                        newInstance.setPositiveButton(2131886128, new DialogInterface.OnClickListener() {
                            /* class com.coolapk.market.widget.AlbumActionView.AnonymousClass2 */

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (!AlbumActionView.this.isReQuestAlbum) {
                                    DataManager.getInstance().getAlbumAllApkList(AlbumActionView.this.album.getAlbumId()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<List<AlbumItem>>>() {
                                        /* class com.coolapk.market.widget.AlbumActionView.AnonymousClass2.AnonymousClass1 */

                                        @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
                                        public void onError(Throwable th) {
                                            Toast.error(AlbumActionView.this.getContext(), th);
                                        }

                                        public void onNext(Result<List<AlbumItem>> result) {
                                            AlbumActionView.this.album = Album.newBuilder(AlbumActionView.this.album).albumItems(result.getData()).build();
                                            AlbumActionView.this.isReQuestAlbum = true;
                                            AlbumActionView.this.onDownload(AlbumActionView.this.album.getAlbumItems());
                                        }
                                    });
                                    return;
                                }
                                AlbumActionView albumActionView = AlbumActionView.this;
                                albumActionView.onDownload(albumActionView.album.getAlbumItems());
                            }
                        });
                        newInstance.setNegativeButton(2131886115, (DialogInterface.OnClickListener) null);
                        newInstance.show(ContextExtendsKt.requireAppCompatActivity(getContext()).getSupportFragmentManager(), (String) null);
                        break;
                    } else {
                        onDownload(this.album.getAlbumItems());
                        break;
                    }
                case 2131362855:
                    ActionManager.checkLogin(getContext(), new Runnable() {
                        /* class com.coolapk.market.widget.AlbumActionView.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumActionView.this.onLikeClick();
                        }
                    });
                    break;
                case 2131363434:
                    onCollectClick();
                    break;
            }
            View.OnClickListener onClickListener = this.outerOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onLikeClick() {
        if (!this.postingLike) {
            this.postingLike = true;
            final Album album2 = this.album;
            if (!this.likeState) {
                this.mAlbumActionPresenter.likeAlbum(album2).compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResult()).subscribe((Subscriber<? super R>) new Subscriber<Result<LikeResult>>() {
                    /* class com.coolapk.market.widget.AlbumActionView.AnonymousClass3 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        if (album2 == AlbumActionView.this.album) {
                            Toast.error(AlbumActionView.this.getContext(), th);
                            AlbumActionView.this.updateAlbum(album2);
                        }
                    }

                    public void onNext(Result<LikeResult> result) {
                        AlbumActionView.this.postingLike = false;
                        if (album2 == AlbumActionView.this.album) {
                            EventBus.getDefault().post(new AlbumLikeEvent(album2.getAlbumId(), true, result.getData()));
                        }
                    }
                });
                this.likeState = true;
                this.binding.likeText.setText(String.valueOf(album2.getLikeNum() + 1));
                this.binding.likeView.setImageResource(2131231619);
                return;
            }
            this.mAlbumActionPresenter.unlikeAlbum(album2).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<LikeResult>>() {
                /* class com.coolapk.market.widget.AlbumActionView.AnonymousClass4 */

                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    if (album2 == AlbumActionView.this.album) {
                        Toast.error(AlbumActionView.this.getContext(), th);
                        AlbumActionView.this.updateAlbum(album2);
                    }
                }

                public void onNext(Result<LikeResult> result) {
                    AlbumActionView.this.postingLike = false;
                    if (album2 == AlbumActionView.this.album) {
                        EventBus.getDefault().post(new AlbumLikeEvent(album2.getAlbumId(), false, result.getData()));
                    }
                }
            });
            this.likeState = false;
            int likeNum = album2.getLikeNum() - 1;
            this.binding.likeText.setText(likeNum > 0 ? String.valueOf(likeNum) : getContext().getString(LIKE.title.intValue()));
            this.binding.likeView.setImageResource(LIKE.icon.intValue());
        }
    }

    private void onCollectClick() {
        Album album2 = this.album;
        ActionManager.startCollectionSelectActivity(getContext(), album2.getId(), album2.getEntityType());
    }

    /* access modifiers changed from: private */
    public void onDownload(List<AlbumItem> list) {
        DownloadState findLatestDownloadState;
        if (this.album == null || CollectionUtils.isEmpty(list)) {
            return;
        }
        if (!this.isDownloading) {
            List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
            for (AlbumItem albumItem : list) {
                if (!TextUtils.equals(albumItem.getApkId(), "0")) {
                    albumItem.getDownloadUrlMd5();
                    MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(albumItem.getPackageName());
                    if (mobileAppExistFast == null || !mobileAppUpgradeListFast.contains(mobileAppExistFast)) {
                        if (mobileAppExistFast == null) {
                            ActionManager.startDownload(getContext(), albumItem, 0);
                            this.isDownloading = true;
                        }
                    } else if (mobileAppExistFast.getUpgradeInfo() != null && ((findLatestDownloadState = StateUtils.findLatestDownloadState(mobileAppExistFast.getUpgradeInfo().getDownloadUrlMd5(0), mobileAppExistFast.getUpgradeInfo().getDownloadUrlMd5(1))) == null || !findLatestDownloadState.isSuccess())) {
                        ActionManager.startDownload(getContext(), mobileAppExistFast, mobileAppExistFast.getUpgradeInfo().getDownloadUrlTypeSmart());
                        this.isDownloading = true;
                    }
                }
            }
            this.binding.downloadText.setText(2131886130);
            this.binding.downloadView.setImageResource(2131231477);
            return;
        }
        Iterator<DownloadInfo> it2 = DataManager.getInstance().getDownloadInfoList().iterator();
        while (it2.hasNext()) {
            DownloadState findLatestDownloadState2 = StateUtils.findLatestDownloadState(it2.next().getUrlMd5());
            if (findLatestDownloadState2 != null && findLatestDownloadState2.isRunning()) {
                ActionManager.stopDownload(getContext(), findLatestDownloadState2.getUrl());
            }
        }
        this.isDownloading = false;
        this.binding.downloadText.setText(2131886128);
        this.binding.downloadView.setImageResource(DOWNLOAD.icon.intValue());
    }

    public static class FeedItem {
        final Integer containerId;
        final Integer icon;
        final Integer title;

        FeedItem(Integer num, Integer num2, Integer num3) {
            this.title = num;
            this.icon = num2;
            this.containerId = num3;
        }
    }
}
