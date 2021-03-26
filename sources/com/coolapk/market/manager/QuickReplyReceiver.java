package com.coolapk.market.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.EmptySubscriber;
import com.coolapk.market.event.FeedReplyEvent;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.widget.Toast;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import rx.Subscriber;

public class QuickReplyReceiver extends BroadcastReceiver {
    public static final String QUICK_REPLY_BUNDLE_ID = "bundle_id";
    @Deprecated
    public static final String QUICK_REPLY_FEED_REPLY_ACTION = "com.coolapk.market.quick.reply.feed_reply";
    public static final String QUICK_REPLY_PRIVATE_MESSAGE_ACTION = "com.coolapk.market.quick.reply.private_message";
    public static final String QUICK_REPLY_REMOTE_INPUT_TEXT = "remote_input_text";

    private static void postFeedReply(String str, String str2) {
        DataManager.getInstance().postFeedReply(str, str2, null, false).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).delay(2, TimeUnit.SECONDS).subscribe((Subscriber<? super R>) new EmptySubscriber<FeedReply>() {
            /* class com.coolapk.market.manager.QuickReplyReceiver.AnonymousClass1 */

            public void onNext(FeedReply feedReply) {
                super.onNext((AnonymousClass1) feedReply);
                EventBus.getDefault().post(new FeedReplyEvent(feedReply));
                NotificationManagerCompat.from(AppHolder.getApplication()).cancel(5);
            }

            @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
            public void onError(Throwable th) {
                Toast.error(AppHolder.getApplication(), th);
            }
        });
    }

    private static void postPrivateMessage(String str, String str2) {
        DataManager.getInstance().sendMessageDirect(str, str2).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).delay(2, TimeUnit.SECONDS).subscribe((Subscriber<? super R>) new Subscriber<List<Entity>>() {
            /* class com.coolapk.market.manager.QuickReplyReceiver.AnonymousClass2 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(AppHolder.getApplication(), th);
            }

            public void onNext(List<Entity> list) {
                NotificationManagerCompat.from(AppHolder.getApplication()).cancel(5);
            }
        });
    }

    public void register(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolapk.market.quick.reply.private_message");
        intentFilter.addAction("com.coolapk.market.quick.reply.feed_reply");
        context.registerReceiver(this, intentFilter);
    }

    public void unregister(Context context) {
        context.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("com.coolapk.market.quick.reply.feed_reply")) {
            String remoteInputString = getRemoteInputString(intent);
            String stringExtra = intent.getStringExtra("bundle_id");
            if (!TextUtils.isEmpty(remoteInputString) && !TextUtils.isEmpty(stringExtra)) {
                postFeedReply(stringExtra, remoteInputString);
            }
        } else if (action.equals("com.coolapk.market.quick.reply.private_message")) {
            String remoteInputString2 = getRemoteInputString(intent);
            String stringExtra2 = intent.getStringExtra("bundle_id");
            if (!TextUtils.isEmpty(remoteInputString2) && !TextUtils.isEmpty(stringExtra2)) {
                postPrivateMessage(stringExtra2, remoteInputString2);
            }
        }
    }

    public String getRemoteInputString(Intent intent) {
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        CharSequence charSequence = resultsFromIntent != null ? resultsFromIntent.getCharSequence("remote_input_text") : null;
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }
}
