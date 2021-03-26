package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            this.subscribers = EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
    }

    public void call(Subscriber<? super T> subscriber) {
        PublishProducer<T> publishProducer = new PublishProducer<>(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (!add(publishProducer)) {
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        } else if (publishProducer.isUnsubscribed()) {
            remove(publishProducer);
        } else {
            drain();
        }
    }

    @Override // rx.Observer
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    void setProducer(Producer producer2) {
        this.producer = producer2;
        producer2.request((long) this.prefetch);
    }

    void drain() {
        int i;
        if (getAndIncrement() == 0) {
            Queue<T> queue2 = this.queue;
            int i2 = 0;
            do {
                long j = Long.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z = this.done;
                        T poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2)) {
                            if (z2) {
                                break;
                            }
                            for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                                publishProducer2.actual.onNext(poll);
                            }
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i == 0 && checkTerminated(this.done, queue2.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        Producer producer2 = this.producer;
                        if (producer2 != null) {
                            producer2.request(j2);
                        }
                        for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                            BackpressureUtils.produced(publishProducer3, j2);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    PublishProducer<T>[] terminate = terminate();
                    int length = terminate.length;
                    while (i < length) {
                        terminate[i].actual.onError(th);
                        i++;
                    }
                    return true;
                } else if (z2) {
                    PublishProducer<T>[] terminate2 = terminate();
                    int length2 = terminate2.length;
                    while (i < length2) {
                        terminate2[i].actual.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                PublishProducer<T>[] terminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = terminate3.length;
                    while (i < length3) {
                        terminate3[i].actual.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = terminate3.length;
                    while (i < length4) {
                        terminate3[i].actual.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr != publishProducerArr2) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != publishProducerArr2) {
                    this.subscribers = publishProducerArr2;
                }
            }
        }
        return publishProducerArr;
    }

    boolean add(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr == publishProducerArr2) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 == publishProducerArr2) {
                return false;
            }
            int length = publishProducerArr3.length;
            PublishProducer<T>[] publishProducerArr4 = new PublishProducer[(length + 1)];
            System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, length);
            publishProducerArr4[length] = publishProducer;
            this.subscribers = publishProducerArr4;
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v5, resolved type: rx.internal.operators.OnSubscribePublishMulticast$PublishProducer<?>[] */
    /* JADX WARN: Multi-variable type inference failed */
    void remove(PublishProducer<T> publishProducer) {
        PublishProducer<?>[] publishProducerArr;
        PublishProducer<?>[] publishProducerArr2;
        PublishProducer<T>[] publishProducerArr3 = this.subscribers;
        PublishProducer<?>[] publishProducerArr4 = TERMINATED;
        if (publishProducerArr3 != publishProducerArr4 && publishProducerArr3 != (publishProducerArr = EMPTY)) {
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr5 = this.subscribers;
                if (publishProducerArr5 != publishProducerArr4) {
                    if (publishProducerArr5 != publishProducerArr) {
                        int i = -1;
                        int length = publishProducerArr5.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (publishProducerArr5[i2] == publishProducer) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                publishProducerArr2 = EMPTY;
                            } else {
                                PublishProducer<T>[] publishProducerArr6 = new PublishProducer[(length - 1)];
                                System.arraycopy(publishProducerArr5, 0, publishProducerArr6, 0, i);
                                System.arraycopy(publishProducerArr5, i + 1, publishProducerArr6, i, (length - i) - 1);
                                publishProducerArr2 = publishProducerArr6;
                            }
                            this.subscribers = publishProducerArr2;
                        }
                    }
                }
            }
        }
    }

    static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.state.onNext(t);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.state.onError(th);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.onCompleted();
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // rx.Producer
        public void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i != 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                this.parent.drain();
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }
}
