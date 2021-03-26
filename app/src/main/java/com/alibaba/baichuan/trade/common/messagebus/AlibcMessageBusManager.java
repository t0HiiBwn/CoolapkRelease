package com.alibaba.baichuan.trade.common.messagebus;

import android.os.Message;
import com.alibaba.baichuan.trade.common.messagebus.AlibcMessageQueue;
import com.alibaba.baichuan.trade.common.utils.ExecutorServiceUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlibcMessageBusManager {
    private static AlibcMessageBusManager c;
    private Map<Integer, List<AlibcMessageListener>> a = new HashMap();
    private AlibcMessageQueue b = new AlibcMessageQueue(new a());

    class a extends AlibcMessageQueue.MessageCallback {
        a() {
        }

        @Override // com.alibaba.baichuan.trade.common.messagebus.AlibcMessageQueue.MessageCallback
        void a(Message message) {
            final int i = message.what;
            final Object obj = message.obj;
            synchronized (AlibcMessageBusManager.class) {
                List<AlibcMessageListener> list = (List) AlibcMessageBusManager.this.a.get(Integer.valueOf(i));
                if (list != null && list.size() > 0) {
                    for (final AlibcMessageListener alibcMessageListener : list) {
                        if (alibcMessageListener.isRunOnUIThread) {
                            ExecutorServiceUtils.getInstance().postUITask(new Runnable() {
                                /* class com.alibaba.baichuan.trade.common.messagebus.AlibcMessageBusManager.a.AnonymousClass1 */

                                @Override // java.lang.Runnable
                                public void run() {
                                    alibcMessageListener.onMessageEvent(i, obj);
                                }
                            });
                        } else {
                            alibcMessageListener.onMessageEvent(i, obj);
                        }
                    }
                }
            }
        }
    }

    private AlibcMessageBusManager() {
    }

    public static synchronized AlibcMessageBusManager getInstance() {
        AlibcMessageBusManager alibcMessageBusManager;
        synchronized (AlibcMessageBusManager.class) {
            if (c == null) {
                c = new AlibcMessageBusManager();
            }
            alibcMessageBusManager = c;
        }
        return alibcMessageBusManager;
    }

    public synchronized void registerListener(AlibcMessageListener alibcMessageListener) {
        if (alibcMessageListener != null) {
            if (this.a.get(Integer.valueOf(alibcMessageListener.eventId)) == null) {
                this.a.put(Integer.valueOf(alibcMessageListener.eventId), new LinkedList());
            }
            this.a.get(Integer.valueOf(alibcMessageListener.eventId)).add(alibcMessageListener);
        }
    }

    public synchronized void removeListner(AlibcMessageListener alibcMessageListener) {
        if (alibcMessageListener != null) {
            List<AlibcMessageListener> list = this.a.get(Integer.valueOf(alibcMessageListener.eventId));
            if (list != null) {
                if (list.size() != 0) {
                    list.remove(alibcMessageListener);
                }
            }
        }
    }

    public void sendMessage(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        this.b.sendMessage(message);
    }
}
