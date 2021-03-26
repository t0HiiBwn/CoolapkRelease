package com.alibaba.baichuan.trade.common.messagebus;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class AlibcMessageQueue {
    private Handler a;
    private HandlerThread b;

    public static class MessageCallback {
        void a(Message message) {
        }
    }

    class a implements Handler.Callback {
        private MessageCallback b;

        a(MessageCallback messageCallback) {
            this.b = messageCallback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            this.b.a(message);
            return true;
        }
    }

    public AlibcMessageQueue(MessageCallback messageCallback) {
        HandlerThread handlerThread = new HandlerThread("AlibcMessageQueue");
        this.b = handlerThread;
        handlerThread.start();
        this.a = new Handler(this.b.getLooper(), new a(messageCallback == null ? new MessageCallback() : messageCallback));
    }

    public void sendMessage(Message message) {
        if (message != null) {
            this.a.sendMessage(message);
        }
    }
}
