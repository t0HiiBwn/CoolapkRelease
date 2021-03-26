package com.kk.taurus.playerbase.extension;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.utils.NetworkUtils;
import java.lang.ref.WeakReference;

public class NetworkEventProducer extends BaseEventProducer {
    private static final int MSG_CODE_NETWORK_CHANGE = 100;
    private final String TAG = "NetworkEventProducer";
    private Context mAppContext;
    private NetChangeBroadcastReceiver mBroadcastReceiver;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.kk.taurus.playerbase.extension.NetworkEventProducer.AnonymousClass1 */

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int intValue;
            super.handleMessage(message);
            if (message.what == 100 && NetworkEventProducer.this.mState != (intValue = ((Integer) message.obj).intValue())) {
                NetworkEventProducer.this.mState = intValue;
                ReceiverEventSender sender = NetworkEventProducer.this.getSender();
                if (sender != null) {
                    sender.sendInt("network_state", NetworkEventProducer.this.mState);
                    PLog.d("NetworkEventProducer", "onNetworkChange : " + NetworkEventProducer.this.mState);
                }
            }
        }
    };
    private int mState;

    public NetworkEventProducer(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    private void registerNetChangeReceiver() {
        unregisterNetChangeReceiver();
        if (this.mAppContext != null) {
            this.mBroadcastReceiver = new NetChangeBroadcastReceiver(this.mAppContext, this.mHandler);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.mAppContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void unregisterNetChangeReceiver() {
        NetChangeBroadcastReceiver netChangeBroadcastReceiver;
        try {
            Context context = this.mAppContext;
            if (context != null && (netChangeBroadcastReceiver = this.mBroadcastReceiver) != null) {
                context.unregisterReceiver(netChangeBroadcastReceiver);
                this.mBroadcastReceiver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kk.taurus.playerbase.extension.EventProducer
    public void onAdded() {
        this.mState = NetworkUtils.getNetworkState(this.mAppContext);
        registerNetChangeReceiver();
    }

    @Override // com.kk.taurus.playerbase.extension.EventProducer
    public void onRemoved() {
        destroy();
    }

    @Override // com.kk.taurus.playerbase.extension.EventProducer
    public void destroy() {
        NetChangeBroadcastReceiver netChangeBroadcastReceiver = this.mBroadcastReceiver;
        if (netChangeBroadcastReceiver != null) {
            netChangeBroadcastReceiver.destroy();
        }
        unregisterNetChangeReceiver();
        this.mHandler.removeMessages(100);
    }

    public static class NetChangeBroadcastReceiver extends BroadcastReceiver {
        private Handler handler;
        private WeakReference<Context> mContextRefer;
        private Runnable mDelayRunnable = new Runnable() {
            /* class com.kk.taurus.playerbase.extension.NetworkEventProducer.NetChangeBroadcastReceiver.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                if (NetChangeBroadcastReceiver.this.mContextRefer != null && NetChangeBroadcastReceiver.this.mContextRefer.get() != null) {
                    int networkState = NetworkUtils.getNetworkState((Context) NetChangeBroadcastReceiver.this.mContextRefer.get());
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    obtain.obj = Integer.valueOf(networkState);
                    NetChangeBroadcastReceiver.this.handler.sendMessage(obtain);
                }
            }
        };

        public NetChangeBroadcastReceiver(Context context, Handler handler2) {
            this.mContextRefer = new WeakReference<>(context);
            this.handler = handler2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                this.handler.removeCallbacks(this.mDelayRunnable);
                this.handler.postDelayed(this.mDelayRunnable, 1000);
            }
        }

        public void destroy() {
            this.handler.removeCallbacks(this.mDelayRunnable);
        }
    }
}
