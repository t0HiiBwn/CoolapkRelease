package com.coolapk.market.view.live;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0003/01B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010'\u001a\u00020\u001d2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fJ\u000e\u0010)\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/coolapk/market/view/live/BubbleMessenger;", "", "allowedDuplicate", "", "(Z)V", "alreadyOutputIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/coolapk/market/model/Entity;", "handler", "Lcom/coolapk/market/view/live/BubbleMessenger$MyHandler;", "loggerable", "getLoggerable", "()Z", "setLoggerable", "outputDuration", "Ljava/util/concurrent/atomic/AtomicLong;", "outputListener", "Lcom/coolapk/market/view/live/BubbleMessenger$OutputListener;", "getOutputListener", "()Lcom/coolapk/market/view/live/BubbleMessenger$OutputListener;", "setOutputListener", "(Lcom/coolapk/market/view/live/BubbleMessenger$OutputListener;)V", "taskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "addAllToAlreadyOutputId", "", "ids", "", "addToAlreadyOutputId", "id", "bubbleMessengerLogD", "message", "computeSpeed", "ensureStart", "getLastItem", "input", "inputDataList", "isAlreadyOutput", "restoreInstanceState", "savedInstanceState", "Landroid/os/Bundle;", "saveInstanceState", "outState", "Companion", "MyHandler", "OutputListener", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BubbleMessenger.kt */
public final class BubbleMessenger {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_BUBBLE_MESSENGER_DATA = "BUBBLE_MESSENGER_DATA";
    public static final long MIN_OUTPUT_DURATION = 500;
    public static final long TASK_RUNNING_DURATION = 3000;
    private final boolean allowedDuplicate;
    private final HashMap<String, Boolean> alreadyOutputIds = new HashMap<>();
    private final ConcurrentLinkedQueue<Entity> dataList = new ConcurrentLinkedQueue<>();
    private MyHandler handler = new MyHandler();
    private boolean loggerable;
    private AtomicLong outputDuration = new AtomicLong(500);
    private OutputListener outputListener;
    private AtomicInteger taskId = new AtomicInteger(0);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/live/BubbleMessenger$OutputListener;", "", "onOutput", "", "data", "Lcom/coolapk/market/model/Entity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BubbleMessenger.kt */
    public interface OutputListener {
        void onOutput(Entity entity);
    }

    public BubbleMessenger(boolean z) {
        this.allowedDuplicate = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/live/BubbleMessenger$Companion;", "", "()V", "KEY_BUBBLE_MESSENGER_DATA", "", "MIN_OUTPUT_DURATION", "", "TASK_RUNNING_DURATION", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BubbleMessenger.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean getLoggerable() {
        return this.loggerable;
    }

    public final void setLoggerable(boolean z) {
        this.loggerable = z;
    }

    public final OutputListener getOutputListener() {
        return this.outputListener;
    }

    public final void setOutputListener(OutputListener outputListener2) {
        this.outputListener = outputListener2;
    }

    /* access modifiers changed from: private */
    public final void bubbleMessengerLogD(String str) {
        if (this.loggerable) {
            LogUtils.d(str, new Object[0]);
        }
    }

    public final synchronized void input(List<? extends Entity> list) {
        Intrinsics.checkNotNullParameter(list, "inputDataList");
        if (!this.allowedDuplicate) {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (!Intrinsics.areEqual((Object) this.alreadyOutputIds.get(EntityExtendsKt.entityUniqueId(t)), (Object) true)) {
                    arrayList.add(t);
                }
            }
            list = arrayList;
        }
        if (!list.isEmpty()) {
            bubbleMessengerLogD("Input size: " + list.size());
            this.dataList.addAll(list);
            if (!this.allowedDuplicate) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    this.alreadyOutputIds.put(EntityExtendsKt.entityUniqueId(it2.next()), true);
                }
            }
            computeSpeed();
            ensureStart();
        }
    }

    private final void computeSpeed() {
        if (!this.dataList.isEmpty()) {
            long size = 3000 / ((long) this.dataList.size());
            bubbleMessengerLogD("Average speed: " + size);
            this.outputDuration.set(Math.min(size, 500L));
        }
    }

    private final void ensureStart() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.sendEmptyMessage(this.taskId.incrementAndGet());
    }

    public final boolean isAlreadyOutput(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Boolean bool = this.alreadyOutputIds.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final Entity getLastItem() {
        return (Entity) CollectionsKt.lastOrNull(this.dataList);
    }

    public final void addToAlreadyOutputId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.alreadyOutputIds.put(str, true);
    }

    public final void addAllToAlreadyOutputId(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            this.alreadyOutputIds.put(it2.next(), true);
        }
    }

    public final void restoreInstanceState(Bundle bundle) {
        String[] strArr;
        if (bundle != null) {
            strArr = bundle.getStringArray("BUBBLE_MESSENGER_DATA");
        } else {
            strArr = null;
        }
        if (strArr != null) {
            for (String str : strArr) {
                Intrinsics.checkNotNullExpressionValue(str, "it");
                addToAlreadyOutputId(str);
            }
        }
    }

    public final void saveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Set<String> keySet = this.alreadyOutputIds.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "alreadyOutputIds.keys");
        Object[] array = keySet.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        bundle.putStringArray("BUBBLE_MESSENGER_DATA", (String[]) array);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/view/live/BubbleMessenger$MyHandler;", "Landroid/os/Handler;", "(Lcom/coolapk/market/view/live/BubbleMessenger;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BubbleMessenger.kt */
    private final class MyHandler extends Handler {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            if (BubbleMessenger.this.taskId.get() != message.what) {
                BubbleMessenger bubbleMessenger = BubbleMessenger.this;
                bubbleMessenger.bubbleMessengerLogD("Discard message: " + message.what + ", current: " + BubbleMessenger.this.taskId.get());
                return;
            }
            Entity entity = (Entity) BubbleMessenger.this.dataList.poll();
            if (entity != null) {
                BubbleMessenger bubbleMessenger2 = BubbleMessenger.this;
                bubbleMessenger2.bubbleMessengerLogD("Output: " + EntityExtendsKt.entityUniqueId(entity));
                OutputListener outputListener = BubbleMessenger.this.getOutputListener();
                if (outputListener != null) {
                    outputListener.onOutput(entity);
                }
            }
            if (!BubbleMessenger.this.dataList.isEmpty()) {
                BubbleMessenger bubbleMessenger3 = BubbleMessenger.this;
                bubbleMessenger3.bubbleMessengerLogD("Delay next task duration: " + BubbleMessenger.this.outputDuration);
                sendEmptyMessageDelayed(message.what, BubbleMessenger.this.outputDuration.get());
            }
        }
    }
}
