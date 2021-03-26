package com.coolapk.market.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedReplyDeleteEvent;
import com.coolapk.market.event.FeedReplyLikeEvent;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.network.Result;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.feed.FeedActionPresenter;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;
import rx.functions.Func1;

public class FeedReplyActionView extends LinearLayout implements View.OnClickListener {
    public static final FeedItem LIKE = new FeedItem(2131886790, 2131689494, 2131362532);
    public static final int LIKED = 2131689495;
    public static final FeedItem REPLY = new FeedItem(2131886791, 2131689479, 2131362533);
    private boolean likeState;
    private Func1<View, Boolean> mExtraListener;
    private FeedReply mFeedReply;
    private FeedActionPresenter mPresenter;
    private boolean postingDelete;
    private boolean postingLike;

    public FeedReplyActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public FeedReplyActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        LayoutInflater from = LayoutInflater.from(getContext());
        addView(newItemView(from, LIKE));
        addView(newItemView(from, REPLY));
        this.mPresenter = FeedActionPresenter.getInstance();
    }

    private View newItemView(LayoutInflater layoutInflater, FeedItem feedItem) {
        View inflate = layoutInflater.inflate(2131558551, (ViewGroup) this, false);
        inflate.setId(feedItem.containerId.intValue());
        ViewUtil.clickListener(inflate, this);
        Holder holder = new Holder();
        holder.parent = inflate;
        holder.textView = (TextView) inflate.findViewById(2131363533);
        holder.imageView = (ImageView) inflate.findViewById(2131362707);
        holder.feedItem = feedItem;
        inflate.setTag(2131362531, holder);
        restoreView(holder);
        return inflate;
    }

    private void restoreView(Holder holder) {
        FeedItem feedItem = holder.feedItem;
        holder.textView.setText("");
        if (feedItem.icon == null) {
            holder.imageView.setVisibility(8);
        } else {
            holder.imageView.setImageResource(feedItem.icon.intValue());
        }
    }

    public void updateFeedReply(FeedReply feedReply) {
        this.mFeedReply = feedReply;
        FeedReply.ReplyUserAction userAction = feedReply.getUserAction();
        boolean z = false;
        this.postingLike = false;
        if (userAction != null && userAction.getLike() > 0) {
            z = true;
        }
        this.likeState = z;
        Holder holder = getHolder(LIKE.containerId.intValue());
        Holder holder2 = getHolder(REPLY.containerId.intValue());
        if (holder != null) {
            setLikeState(holder, Boolean.valueOf(this.likeState), this.mFeedReply.getLikeNum());
        }
        if (holder2 != null) {
            holder2.textView.setText(this.mFeedReply.getReplyNum() > 0 ? String.valueOf(this.mFeedReply.getReplyNum()) : "");
        }
    }

    private Holder getHolder(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            return (Holder) findViewById.getTag(2131362531);
        }
        return null;
    }

    public void setExtraListener(Func1<View, Boolean> func1) {
        this.mExtraListener = func1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mFeedReply != null) {
            Func1<View, Boolean> func1 = this.mExtraListener;
            if (func1 == null || !func1.call(view).booleanValue()) {
                switch (view.getId()) {
                    case 2131362532:
                        ActionManager.checkLogin(getContext(), new Runnable() {
                            /* class com.coolapk.market.widget.FeedReplyActionView.AnonymousClass1 */

                            @Override // java.lang.Runnable
                            public void run() {
                                FeedReplyActionView.this.onLikeClick();
                            }
                        });
                        return;
                    case 2131362533:
                        ActionManager.startReplyActivity(UiUtils.getActivity(getContext()), this.mFeedReply);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onLikeClick() {
        if (!this.postingLike) {
            this.postingLike = true;
            final FeedReply feedReply = this.mFeedReply;
            Holder holder = (Holder) findViewById(LIKE.containerId.intValue()).getTag(2131362531);
            if (!this.likeState) {
                this.mPresenter.likeFeedReply(feedReply).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                    /* class com.coolapk.market.widget.FeedReplyActionView.AnonymousClass2 */

                    @Override // rx.Observer
                    public void onCompleted() {
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        if (feedReply == FeedReplyActionView.this.mFeedReply) {
                            Toast.error(FeedReplyActionView.this.getContext(), th);
                            FeedReplyActionView.this.updateFeedReply(feedReply);
                        }
                    }

                    public void onNext(Result<String> result) {
                        if (feedReply == FeedReplyActionView.this.mFeedReply && !TextUtils.isEmpty(result.getData())) {
                            EventBus.getDefault().post(new FeedReplyLikeEvent(FeedReplyActionView.this.mFeedReply.getId(), Integer.valueOf(result.getData()).intValue(), true));
                        }
                    }
                });
                this.likeState = true;
                setLikeState(holder, true, feedReply.getLikeNum() + 1);
                return;
            }
            this.mPresenter.unLikeFeedReply(feedReply).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
                /* class com.coolapk.market.widget.FeedReplyActionView.AnonymousClass3 */

                @Override // rx.Observer
                public void onCompleted() {
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    if (feedReply == FeedReplyActionView.this.mFeedReply) {
                        Toast.error(FeedReplyActionView.this.getContext(), th);
                        FeedReplyActionView.this.updateFeedReply(feedReply);
                    }
                }

                public void onNext(Result<String> result) {
                    if (feedReply == FeedReplyActionView.this.mFeedReply && !TextUtils.isEmpty(result.getData())) {
                        EventBus.getDefault().post(new FeedReplyLikeEvent(FeedReplyActionView.this.mFeedReply.getId(), Integer.valueOf(result.getData()).intValue(), false));
                    }
                }
            });
            this.likeState = false;
            setLikeState(holder, Boolean.valueOf(this.likeState), feedReply.getLikeNum() - 1);
        }
    }

    private void setLikeState(Holder holder, Boolean bool, int i) {
        if (i > 0) {
            holder.textView.setText(String.valueOf(i));
        } else {
            holder.textView.setText("");
        }
        if (bool.booleanValue()) {
            holder.textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
            holder.imageView.setImageResource(2131689495);
            holder.imageView.setColorFilter(AppHolder.getAppTheme().getColorAccent());
            return;
        }
        holder.textView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099893));
        holder.imageView.setImageResource(2131689494);
        holder.imageView.setColorFilter(ResourceUtils.getColorInt(getContext(), 2131099893));
    }

    public void onDeleteClick() {
        FeedReply feedReply = this.mFeedReply;
        ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(getContext().getString(2131886722), getContext().getString(2131886719, this.mFeedReply.getUserName(), this.mFeedReply.getMessage()));
        newInstance.setDeleteTarget(feedReply);
        newInstance.show(ContextExtendsKt.requireAppCompatActivity(getContext()).getSupportFragmentManager(), (String) null);
    }

    private void doDelete(final FeedReply feedReply, int i) {
        if (this.postingDelete) {
            this.postingDelete = false;
        }
        this.mPresenter.deleteFeedReply(feedReply, i).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new EmptySubscriber<Result<String>>() {
            /* class com.coolapk.market.widget.FeedReplyActionView.AnonymousClass4 */

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onCompleted() {
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(FeedReplyActionView.this.getContext(), th);
            }

            public void onNext(Result<String> result) {
                EventBus.getDefault().post(new FeedReplyDeleteEvent(feedReply));
            }
        });
    }

    private static class Holder {
        FeedItem feedItem;
        ImageView imageView;
        View parent;
        TextView textView;

        private Holder() {
        }
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
