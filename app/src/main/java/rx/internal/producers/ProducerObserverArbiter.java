package rx.internal.producers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T> implements Producer, Observer<T> {
    static final Producer NULL_PRODUCER = new Producer() {
        /* class rx.internal.producers.ProducerObserverArbiter.AnonymousClass1 */

        @Override // rx.Producer
        public void request(long j) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    @Override // rx.Observer
    public void onNext(T t) {
        synchronized (this) {
            if (this.emitting) {
                List list = this.queue;
                if (list == null) {
                    list = new ArrayList(4);
                    this.queue = list;
                }
                list.add(t);
                return;
            }
            this.emitting = true;
        }
        try {
            this.child.onNext(t);
            long j = this.requested;
            if (j != Long.MAX_VALUE) {
                this.requested = j - 1;
            }
            emitLoop();
        } catch (Throwable th) {
            synchronized (this) {
                this.emitting = false;
                throw th;
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = th;
                z = false;
            } else {
                this.emitting = true;
                z = true;
            }
        }
        if (z) {
            this.child.onError(th);
        } else {
            this.hasError = true;
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = true;
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    @Override // rx.Producer
    public void request(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i != 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.missedRequested += j;
                    return;
                }
                this.emitting = true;
            }
            Producer producer = this.currentProducer;
            try {
                long j2 = this.requested + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.requested = j2;
                emitLoop();
                if (producer != null) {
                    producer.request(j);
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.emitting = false;
                    throw th;
                }
            }
        }
    }

    public void setProducer(Producer producer) {
        synchronized (this) {
            if (this.emitting) {
                if (producer == null) {
                    producer = NULL_PRODUCER;
                }
                this.missedProducer = producer;
                return;
            }
            this.emitting = true;
        }
        this.currentProducer = producer;
        long j = this.requested;
        try {
            emitLoop();
            if (producer != null && j != 0) {
                producer.request(j);
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.emitting = false;
                throw th;
            }
        }
    }

    void emitLoop() {
        long j;
        Producer producer;
        Object obj;
        List<T> list;
        boolean z;
        int i;
        boolean z2;
        long j2;
        Subscriber<? super T> subscriber = this.child;
        Producer producer2 = null;
        long j3 = 0;
        while (true) {
            synchronized (this) {
                j = this.missedRequested;
                producer = this.missedProducer;
                obj = this.missedTerminal;
                list = this.queue;
                z = true;
                i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i == 0 && producer == null && list == null && obj == null) {
                    this.emitting = false;
                    z2 = true;
                } else {
                    this.missedRequested = 0;
                    this.missedProducer = null;
                    this.queue = null;
                    this.missedTerminal = null;
                    z2 = false;
                }
            }
            if (!z2) {
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (obj != null) {
                    if (obj != Boolean.TRUE) {
                        subscriber.onError((Throwable) obj);
                        return;
                    } else if (z) {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (list != null) {
                    Iterator<T> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            j2 = ((long) list.size()) + 0;
                            break;
                        }
                        T next = it2.next();
                        if (!subscriber.isUnsubscribed()) {
                            if (this.hasError) {
                                break;
                            }
                            try {
                                subscriber.onNext(next);
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, subscriber, next);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    j2 = 0;
                }
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    if (i != 0) {
                        j4 += j;
                        if (j4 < 0) {
                            j4 = Long.MAX_VALUE;
                        }
                    }
                    if (!(j2 == 0 || j4 == Long.MAX_VALUE)) {
                        j4 -= j2;
                        if (j4 < 0) {
                            throw new IllegalStateException("More produced than requested");
                        }
                    }
                    this.requested = j4;
                }
                if (producer == null) {
                    producer = this.currentProducer;
                    if (producer != null && i != 0) {
                        j3 = BackpressureUtils.addCap(j3, j);
                    }
                } else if (producer == NULL_PRODUCER) {
                    this.currentProducer = null;
                } else {
                    this.currentProducer = producer;
                    if (j4 != 0) {
                        j3 = BackpressureUtils.addCap(j3, j4);
                    }
                }
                producer2 = producer;
            } else if (j3 != 0 && producer2 != null) {
                producer2.request(j3);
                return;
            } else {
                return;
            }
        }
    }
}
