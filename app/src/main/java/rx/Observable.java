package rx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.BackpressureOverflow;
import rx.Emitter;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.observers.AssertableSubscriberObservable;
import rx.internal.operators.CachedObservable;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeAmb;
import rx.internal.operators.OnSubscribeCollect;
import rx.internal.operators.OnSubscribeCombineLatest;
import rx.internal.operators.OnSubscribeConcatMap;
import rx.internal.operators.OnSubscribeCreate;
import rx.internal.operators.OnSubscribeDefer;
import rx.internal.operators.OnSubscribeDelaySubscription;
import rx.internal.operators.OnSubscribeDelaySubscriptionOther;
import rx.internal.operators.OnSubscribeDelaySubscriptionWithSelector;
import rx.internal.operators.OnSubscribeDetach;
import rx.internal.operators.OnSubscribeDoOnEach;
import rx.internal.operators.OnSubscribeFilter;
import rx.internal.operators.OnSubscribeFlatMapCompletable;
import rx.internal.operators.OnSubscribeFlatMapSingle;
import rx.internal.operators.OnSubscribeFlattenIterable;
import rx.internal.operators.OnSubscribeFromArray;
import rx.internal.operators.OnSubscribeFromCallable;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OnSubscribeGroupJoin;
import rx.internal.operators.OnSubscribeJoin;
import rx.internal.operators.OnSubscribeLift;
import rx.internal.operators.OnSubscribeMap;
import rx.internal.operators.OnSubscribeRange;
import rx.internal.operators.OnSubscribeRedo;
import rx.internal.operators.OnSubscribeReduce;
import rx.internal.operators.OnSubscribeReduceSeed;
import rx.internal.operators.OnSubscribeSingle;
import rx.internal.operators.OnSubscribeSkipTimed;
import rx.internal.operators.OnSubscribeSwitchIfEmpty;
import rx.internal.operators.OnSubscribeTakeLastOne;
import rx.internal.operators.OnSubscribeThrow;
import rx.internal.operators.OnSubscribeTimeoutSelectorWithFallback;
import rx.internal.operators.OnSubscribeTimeoutTimedWithFallback;
import rx.internal.operators.OnSubscribeTimerOnce;
import rx.internal.operators.OnSubscribeTimerPeriodically;
import rx.internal.operators.OnSubscribeToMap;
import rx.internal.operators.OnSubscribeToMultimap;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OnSubscribeUsing;
import rx.internal.operators.OperatorAll;
import rx.internal.operators.OperatorAny;
import rx.internal.operators.OperatorAsObservable;
import rx.internal.operators.OperatorBufferWithSingleObservable;
import rx.internal.operators.OperatorBufferWithSize;
import rx.internal.operators.OperatorBufferWithStartEndObservable;
import rx.internal.operators.OperatorBufferWithTime;
import rx.internal.operators.OperatorCast;
import rx.internal.operators.OperatorDebounceWithSelector;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.internal.operators.OperatorDelay;
import rx.internal.operators.OperatorDelayWithSelector;
import rx.internal.operators.OperatorDematerialize;
import rx.internal.operators.OperatorDistinct;
import rx.internal.operators.OperatorDistinctUntilChanged;
import rx.internal.operators.OperatorDoAfterTerminate;
import rx.internal.operators.OperatorDoOnRequest;
import rx.internal.operators.OperatorDoOnSubscribe;
import rx.internal.operators.OperatorDoOnUnsubscribe;
import rx.internal.operators.OperatorEagerConcatMap;
import rx.internal.operators.OperatorElementAt;
import rx.internal.operators.OperatorGroupBy;
import rx.internal.operators.OperatorGroupByEvicting;
import rx.internal.operators.OperatorIgnoreElements;
import rx.internal.operators.OperatorMapNotification;
import rx.internal.operators.OperatorMapPair;
import rx.internal.operators.OperatorMaterialize;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnBackpressureBuffer;
import rx.internal.operators.OperatorOnBackpressureDrop;
import rx.internal.operators.OperatorOnBackpressureLatest;
import rx.internal.operators.OperatorOnErrorResumeNextViaFunction;
import rx.internal.operators.OperatorPublish;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.OperatorRetryWithPredicate;
import rx.internal.operators.OperatorSampleWithObservable;
import rx.internal.operators.OperatorSampleWithTime;
import rx.internal.operators.OperatorScan;
import rx.internal.operators.OperatorSequenceEqual;
import rx.internal.operators.OperatorSerialize;
import rx.internal.operators.OperatorSingle;
import rx.internal.operators.OperatorSkip;
import rx.internal.operators.OperatorSkipLast;
import rx.internal.operators.OperatorSkipLastTimed;
import rx.internal.operators.OperatorSkipUntil;
import rx.internal.operators.OperatorSkipWhile;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorSwitch;
import rx.internal.operators.OperatorTake;
import rx.internal.operators.OperatorTakeLast;
import rx.internal.operators.OperatorTakeLastTimed;
import rx.internal.operators.OperatorTakeTimed;
import rx.internal.operators.OperatorTakeUntil;
import rx.internal.operators.OperatorTakeUntilPredicate;
import rx.internal.operators.OperatorTakeWhile;
import rx.internal.operators.OperatorThrottleFirst;
import rx.internal.operators.OperatorTimeInterval;
import rx.internal.operators.OperatorTimestamp;
import rx.internal.operators.OperatorToObservableList;
import rx.internal.operators.OperatorToObservableSortedList;
import rx.internal.operators.OperatorUnsubscribeOn;
import rx.internal.operators.OperatorWindowWithObservable;
import rx.internal.operators.OperatorWindowWithObservableFactory;
import rx.internal.operators.OperatorWindowWithSize;
import rx.internal.operators.OperatorWindowWithStartEndObservable;
import rx.internal.operators.OperatorWindowWithTime;
import rx.internal.operators.OperatorWithLatestFrom;
import rx.internal.operators.OperatorWithLatestFromMany;
import rx.internal.operators.OperatorZip;
import rx.internal.operators.OperatorZipIterable;
import rx.internal.util.ActionNotificationObserver;
import rx.internal.util.ActionObserver;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ObserverSubscriber;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.observables.AsyncOnSubscribe;
import rx.observables.BlockingObservable;
import rx.observables.ConnectableObservable;
import rx.observables.GroupedObservable;
import rx.observables.SyncOnSubscribe;
import rx.observers.AssertableSubscriber;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;

public class Observable<T> {
    final OnSubscribe<T> onSubscribe;

    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    public interface Transformer<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    protected Observable(OnSubscribe<T> onSubscribe2) {
        this.onSubscribe = onSubscribe2;
    }

    @Deprecated
    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe2) {
        return new Observable<>(RxJavaHooks.onCreate(onSubscribe2));
    }

    public static <T> Observable<T> create(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        return unsafeCreate(new OnSubscribeCreate(action1, backpressureMode));
    }

    public static <T> Observable<T> unsafeCreate(OnSubscribe<T> onSubscribe2) {
        return new Observable<>(RxJavaHooks.onCreate(onSubscribe2));
    }

    public static <S, T> Observable<T> create(SyncOnSubscribe<S, T> syncOnSubscribe) {
        return unsafeCreate(syncOnSubscribe);
    }

    public static <S, T> Observable<T> create(AsyncOnSubscribe<S, T> asyncOnSubscribe) {
        return unsafeCreate(asyncOnSubscribe);
    }

    public final <R> Observable<R> lift(Operator<? extends R, ? super T> operator) {
        return unsafeCreate(new OnSubscribeLift(this.onSubscribe, operator));
    }

    public <R> Observable<R> compose(Transformer<? super T, ? extends R> transformer) {
        return (Observable) transformer.call(this);
    }

    public final <R> R to(Func1<? super Observable<T>, R> func1) {
        return func1.call(this);
    }

    public Single<T> toSingle() {
        return new Single<>(OnSubscribeSingle.create(this));
    }

    public Completable toCompletable() {
        return Completable.fromObservable(this);
    }

    public static <T> Observable<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return unsafeCreate(OnSubscribeAmb.amb(iterable));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return unsafeCreate(OnSubscribeAmb.amb(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return combineLatest(Arrays.asList(observable, observable2), Functions.fromFunc(func2));
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), Functions.fromFunc(func3));
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), Functions.fromFunc(func4));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), Functions.fromFunc(func5));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), Functions.fromFunc(func6));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), Functions.fromFunc(func7));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), Functions.fromFunc(func8));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), Functions.fromFunc(func9));
    }

    public static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return unsafeCreate(new OnSubscribeCombineLatest(list, funcN));
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return unsafeCreate(new OnSubscribeCombineLatest(iterable, funcN));
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        return unsafeCreate(new OnSubscribeCombineLatest(null, iterable, funcN, RxRingBuffer.SIZE, true));
    }

    public static <T> Observable<T> concat(Iterable<? extends Observable<? extends T>> iterable) {
        return concat(from(iterable));
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> concat(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.concatMap(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return concat(just(observable, observable2));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return concat(just(observable, observable2, observable3));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return concat(just(observable, observable2, observable3, observable4));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return concat(just(observable, observable2, observable3, observable4, observable5));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> concat(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return concat(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> concatDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.concatMapDelayError(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concatDelayError(Iterable<? extends Observable<? extends T>> iterable) {
        return concatDelayError(from(iterable));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return concatDelayError(just(observable, observable2));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return concatDelayError(just(observable, observable2, observable3));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return concatDelayError(just(observable, observable2, observable3, observable4));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return concatDelayError(just(observable, observable2, observable3, observable4, observable5));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return concatDelayError(just(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return concatDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return concatDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> concatDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return concatDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T> Observable<T> defer(Func0<Observable<T>> func0) {
        return unsafeCreate(new OnSubscribeDefer(func0));
    }

    public static <T> Observable<T> empty() {
        return EmptyObservableHolder.instance();
    }

    public static <T> Observable<T> error(Throwable th) {
        return unsafeCreate(new OnSubscribeThrow(th));
    }

    public static <T> Observable<T> from(Future<? extends T> future) {
        return unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future));
    }

    public static <T> Observable<T> from(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future, j, timeUnit));
    }

    public static <T> Observable<T> from(Future<? extends T> future, Scheduler scheduler) {
        return unsafeCreate(OnSubscribeToObservableFuture.toObservableFuture(future)).subscribeOn(scheduler);
    }

    public static <T> Observable<T> from(Iterable<? extends T> iterable) {
        return unsafeCreate(new OnSubscribeFromIterable(iterable));
    }

    public static <T> Observable<T> from(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return just(tArr[0]);
        }
        return unsafeCreate(new OnSubscribeFromArray(tArr));
    }

    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        return unsafeCreate(new OnSubscribeFromCallable(callable));
    }

    public static Observable<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.computation());
    }

    public static Observable<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.computation());
    }

    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeTimerPeriodically(j, j2, timeUnit, scheduler));
    }

    public static <T> Observable<T> just(T t) {
        return ScalarSynchronousObservable.create((Object) t);
    }

    public static <T> Observable<T> just(T t, T t2) {
        return from(new Object[]{t, t2});
    }

    public static <T> Observable<T> just(T t, T t2, T t3) {
        return from(new Object[]{t, t2, t3});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        return from(new Object[]{t, t2, t3, t4});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        return from(new Object[]{t, t2, t3, t4, t5});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        return from(new Object[]{t, t2, t3, t4, t5, t6});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9});
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        return from(new Object[]{t, t2, t3, t4, t5, t6, t7, t8, t9, t10});
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> iterable) {
        return merge(from(iterable));
    }

    public static <T> Observable<T> merge(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return merge(from(iterable), i);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> observable) {
        return observable.getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) observable).scalarFlatMap(UtilityFunctions.identity()) : (Observable<R>) observable.lift(OperatorMerge.instance(false));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> merge(Observable<? extends Observable<? extends T>> observable, int i) {
        return observable.getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) observable).scalarFlatMap(UtilityFunctions.identity()) : (Observable<R>) observable.lift(OperatorMerge.instance(false, i));
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return merge(new Observable[]{observable, observable2});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return merge(new Observable[]{observable, observable2, observable3});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return merge(new Observable[]{observable, observable2, observable3, observable4});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8});
    }

    public static <T> Observable<T> merge(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return merge(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9});
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] observableArr) {
        return merge(from(observableArr));
    }

    public static <T> Observable<T> merge(Observable<? extends T>[] observableArr, int i) {
        return merge(from(observableArr), i);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.lift(OperatorMerge.instance(true));
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> mergeDelayError(Observable<? extends Observable<? extends T>> observable, int i) {
        return (Observable<R>) observable.lift(OperatorMerge.instance(true, i));
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> iterable) {
        return mergeDelayError(from(iterable));
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return mergeDelayError(from(iterable), i);
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return mergeDelayError(just(observable, observable2));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return mergeDelayError(just(observable, observable2, observable3));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return mergeDelayError(just(observable, observable2, observable3, observable4));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> mergeDelayError(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return mergeDelayError(just(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public final Observable<Observable<T>> nest() {
        return just(this);
    }

    public static <T> Observable<T> never() {
        return NeverObservableHolder.instance();
    }

    public static Observable<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Count can not be negative");
        } else if (i2 == 0) {
            return empty();
        } else {
            if (i > (Integer.MAX_VALUE - i2) + 1) {
                throw new IllegalArgumentException("start + count can not exceed Integer.MAX_VALUE");
            } else if (i2 == 1) {
                return just(Integer.valueOf(i));
            } else {
                return unsafeCreate(new OnSubscribeRange(i, (i2 - 1) + i));
            }
        }
    }

    public static Observable<Integer> range(int i, int i2, Scheduler scheduler) {
        return range(i, i2).subscribeOn(scheduler);
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return sequenceEqual(observable, observable2, InternalObservableUtils.OBJECT_EQUALS);
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2, Func2<? super T, ? super T, Boolean> func2) {
        return OperatorSequenceEqual.sequenceEqual(observable, observable2, func2);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> switchOnNext(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.lift(OperatorSwitch.instance(false));
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> switchOnNextDelayError(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.lift(OperatorSwitch.instance(true));
    }

    @Deprecated
    public static Observable<Long> timer(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.computation());
    }

    @Deprecated
    public static Observable<Long> timer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j2, timeUnit, scheduler);
    }

    public static Observable<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.computation());
    }

    public static Observable<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeTimerOnce(j, timeUnit, scheduler));
    }

    public static <T, Resource> Observable<T> using(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1) {
        return using(func0, func1, action1, false);
    }

    public static <T, Resource> Observable<T> using(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        return unsafeCreate(new OnSubscribeUsing(func0, func1, action1, z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public static <R> Observable<R> zip(Iterable<? extends Observable<?>> iterable, FuncN<? extends R> funcN) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Observable<?>> it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList.add((Observable) it2.next());
        }
        return just(arrayList.toArray(new Observable[arrayList.size()])).lift(new OperatorZip(funcN));
    }

    public static <R> Observable<R> zip(Observable<?>[] observableArr, FuncN<? extends R> funcN) {
        return just(observableArr).lift(new OperatorZip(funcN));
    }

    public static <R> Observable<R> zip(Observable<? extends Observable<?>> observable, FuncN<? extends R> funcN) {
        return observable.toList().map(InternalObservableUtils.TO_ARRAY).lift(new OperatorZip(funcN));
    }

    public static <T1, T2, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return just(new Observable[]{observable, observable2}).lift(new OperatorZip(func2));
    }

    public static <T1, T2, T3, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return just(new Observable[]{observable, observable2, observable3}).lift(new OperatorZip(func3));
    }

    public static <T1, T2, T3, T4, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return just(new Observable[]{observable, observable2, observable3, observable4}).lift(new OperatorZip(func4));
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5}).lift(new OperatorZip(func5));
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}).lift(new OperatorZip(func6));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}).lift(new OperatorZip(func7));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}).lift(new OperatorZip(func8));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return just(new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9}).lift(new OperatorZip(func9));
    }

    public final Observable<Boolean> all(Func1<? super T, Boolean> func1) {
        return lift(new OperatorAll(func1));
    }

    public final Observable<T> ambWith(Observable<? extends T> observable) {
        return amb(this, observable);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> asObservable() {
        return (Observable<R>) lift(OperatorAsObservable.instance());
    }

    public final <TClosing> Observable<List<T>> buffer(Func0<? extends Observable<? extends TClosing>> func0) {
        return lift(new OperatorBufferWithSingleObservable(func0, 16));
    }

    public final Observable<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final Observable<List<T>> buffer(int i, int i2) {
        return lift(new OperatorBufferWithSize(i, i2));
    }

    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, Schedulers.computation());
    }

    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return lift(new OperatorBufferWithTime(j, j2, timeUnit, Integer.MAX_VALUE, scheduler));
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, Integer.MAX_VALUE, Schedulers.computation());
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return lift(new OperatorBufferWithTime(j, j, timeUnit, i, Schedulers.computation()));
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return lift(new OperatorBufferWithTime(j, j, timeUnit, i, scheduler));
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, j, timeUnit, scheduler);
    }

    public final <TOpening, TClosing> Observable<List<T>> buffer(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return lift(new OperatorBufferWithStartEndObservable(observable, func1));
    }

    public final <B> Observable<List<T>> buffer(Observable<B> observable) {
        return buffer(observable, 16);
    }

    public final <B> Observable<List<T>> buffer(Observable<B> observable, int i) {
        return lift(new OperatorBufferWithSingleObservable(observable, i));
    }

    public final Observable<T> cache() {
        return CachedObservable.from(this);
    }

    @Deprecated
    public final Observable<T> cache(int i) {
        return cacheWithInitialCapacity(i);
    }

    public final Observable<T> cacheWithInitialCapacity(int i) {
        return CachedObservable.from(this, i);
    }

    public final <R> Observable<R> cast(Class<R> cls) {
        return lift(new OperatorCast(cls));
    }

    public final <R> Observable<R> collect(Func0<R> func0, Action2<R, ? super T> action2) {
        return unsafeCreate(new OnSubscribeCollect(this, func0, action2));
    }

    public final <R> Observable<R> concatMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return unsafeCreate(new OnSubscribeConcatMap(this, func1, 2, 0));
    }

    public final <R> Observable<R> concatMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return unsafeCreate(new OnSubscribeConcatMap(this, func1, 2, 2));
    }

    public final <R> Observable<R> concatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return OnSubscribeFlattenIterable.createFrom(this, func1, RxRingBuffer.SIZE);
    }

    public final Observable<T> concatWith(Observable<? extends T> observable) {
        return concat(this, observable);
    }

    public final Observable<Boolean> contains(Object obj) {
        return exists(InternalObservableUtils.equalsWith(obj));
    }

    public final Observable<Integer> count() {
        return reduce(0, InternalObservableUtils.COUNTER);
    }

    public final Observable<Long> countLong() {
        return reduce(0L, InternalObservableUtils.LONG_COUNTER);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> debounce(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<R>) lift(new OperatorDebounceWithSelector(func1));
    }

    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorDebounceWithTime(j, timeUnit, scheduler));
    }

    public final Observable<T> defaultIfEmpty(T t) {
        return switchIfEmpty(just(t));
    }

    public final Observable<T> switchIfEmpty(Observable<? extends T> observable) {
        Objects.requireNonNull(observable, "alternate is null");
        return unsafeCreate(new OnSubscribeSwitchIfEmpty(this, observable));
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U, V> Observable<T> delay(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return (Observable<R>) delaySubscription(func0).lift(new OperatorDelayWithSelector(this, func1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> delay(Func1<? super T, ? extends Observable<U>> func1) {
        return (Observable<R>) lift(new OperatorDelayWithSelector(this, func1));
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorDelay(j, timeUnit, scheduler));
    }

    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.computation());
    }

    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeDelaySubscription(this, j, timeUnit, scheduler));
    }

    public final <U> Observable<T> delaySubscription(Func0<? extends Observable<U>> func0) {
        return unsafeCreate(new OnSubscribeDelaySubscriptionWithSelector(this, func0));
    }

    public final <U> Observable<T> delaySubscription(Observable<U> observable) {
        Objects.requireNonNull(observable);
        return unsafeCreate(new OnSubscribeDelaySubscriptionOther(this, observable));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T2> */
    public final <T2> Observable<T2> dematerialize() {
        return (Observable<R>) lift(OperatorDematerialize.instance());
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> distinct() {
        return (Observable<R>) lift(OperatorDistinct.instance());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> distinct(Func1<? super T, ? extends U> func1) {
        return (Observable<R>) lift(new OperatorDistinct(func1));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> distinctUntilChanged() {
        return (Observable<R>) lift(OperatorDistinctUntilChanged.instance());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> distinctUntilChanged(Func1<? super T, ? extends U> func1) {
        return (Observable<R>) lift(new OperatorDistinctUntilChanged(func1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> distinctUntilChanged(Func2<? super T, ? super T, Boolean> func2) {
        return (Observable<R>) lift(new OperatorDistinctUntilChanged(func2));
    }

    public final Observable<T> doOnCompleted(Action0 action0) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.empty(), Actions.empty(), action0)));
    }

    public final Observable<T> doOnEach(Action1<Notification<? super T>> action1) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionNotificationObserver(action1)));
    }

    public final Observable<T> doOnEach(Observer<? super T> observer) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, observer));
    }

    public final Observable<T> doOnError(Action1<? super Throwable> action1) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.empty(), action1, Actions.empty())));
    }

    public final Observable<T> doOnNext(Action1<? super T> action1) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(action1, Actions.empty(), Actions.empty())));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> doOnRequest(Action1<? super Long> action1) {
        return (Observable<R>) lift(new OperatorDoOnRequest(action1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> doOnSubscribe(Action0 action0) {
        return (Observable<R>) lift(new OperatorDoOnSubscribe(action0));
    }

    public final Observable<T> doOnTerminate(Action0 action0) {
        return unsafeCreate(new OnSubscribeDoOnEach(this, new ActionObserver(Actions.empty(), Actions.toAction1(action0), action0)));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> doOnUnsubscribe(Action0 action0) {
        return (Observable<R>) lift(new OperatorDoOnUnsubscribe(action0));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return concatEager(Arrays.asList(observable, observable2));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        return concatEager(Arrays.asList(observable, observable2, observable3));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8));
    }

    public static <T> Observable<T> concatEager(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        return concatEager(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9));
    }

    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> iterable) {
        return from(iterable).concatMapEager(UtilityFunctions.identity());
    }

    public static <T> Observable<T> concatEager(Iterable<? extends Observable<? extends T>> iterable, int i) {
        return from(iterable).concatMapEager(UtilityFunctions.identity(), i);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> observable) {
        return (Observable<R>) observable.concatMapEager(UtilityFunctions.identity());
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public static <T> Observable<T> concatEager(Observable<? extends Observable<? extends T>> observable, int i) {
        return (Observable<R>) observable.concatMapEager(UtilityFunctions.identity(), i);
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return concatMapEager(func1, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1, int i) {
        if (i >= 1) {
            return lift(new OperatorEagerConcatMap(func1, i, Integer.MAX_VALUE));
        }
        throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
    }

    public final <R> Observable<R> concatMapEager(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("capacityHint > 0 required but it was " + i);
        } else if (i2 >= 1) {
            return lift(new OperatorEagerConcatMap(func1, i, i2));
        } else {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
        }
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> elementAt(int i) {
        return (Observable<R>) lift(new OperatorElementAt(i));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> elementAtOrDefault(int i, T t) {
        return (Observable<R>) lift(new OperatorElementAt(i, t));
    }

    public final Observable<Boolean> exists(Func1<? super T, Boolean> func1) {
        return lift(new OperatorAny(func1, false));
    }

    public final Observable<T> filter(Func1<? super T, Boolean> func1) {
        return unsafeCreate(new OnSubscribeFilter(this, func1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    @Deprecated
    public final Observable<T> finallyDo(Action0 action0) {
        return (Observable<R>) lift(new OperatorDoAfterTerminate(action0));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> doAfterTerminate(Action0 action0) {
        return (Observable<R>) lift(new OperatorDoAfterTerminate(action0));
    }

    public final Observable<T> first() {
        return take(1).single();
    }

    public final Observable<T> first(Func1<? super T, Boolean> func1) {
        return takeFirst(func1).single();
    }

    public final Observable<T> firstOrDefault(T t) {
        return take(1).singleOrDefault(t);
    }

    public final Observable<T> firstOrDefault(T t, Func1<? super T, Boolean> func1) {
        return takeFirst(func1).singleOrDefault(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return merge(map(func1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).scalarFlatMap(func1);
        }
        return merge(map(func1), i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.Func1<? super java.lang.Throwable, ? extends rx.Observable<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.Func0<? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0) {
        return merge(mapNotification(func1, func12, func0));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: rx.functions.Func1<? super java.lang.Throwable, ? extends rx.Observable<? extends R>> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.Func0<? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends R>> func1, Func1<? super Throwable, ? extends Observable<? extends R>> func12, Func0<? extends Observable<? extends R>> func0, int i) {
        return merge(mapNotification(func1, func12, func0), i);
    }

    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return merge(lift(new OperatorMapPair(func1, func2)));
    }

    public final <U, R> Observable<R> flatMap(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i) {
        return merge(lift(new OperatorMapPair(func1, func2)), i);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> func1) {
        return flatMapCompletable(func1, false, Integer.MAX_VALUE);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> func1, boolean z) {
        return flatMapCompletable(func1, z, Integer.MAX_VALUE);
    }

    public final Observable<T> flatMapCompletable(Func1<? super T, ? extends Completable> func1, boolean z, int i) {
        return unsafeCreate(new OnSubscribeFlatMapCompletable(this, func1, z, i));
    }

    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1) {
        return flatMapIterable(func1, RxRingBuffer.SIZE);
    }

    public final <R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        return OnSubscribeFlattenIterable.createFrom(this, func1, i);
    }

    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        return flatMap(OperatorMapPair.convertSelector(func1), func2);
    }

    public final <U, R> Observable<R> flatMapIterable(Func1<? super T, ? extends Iterable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2, int i) {
        return flatMap(OperatorMapPair.convertSelector(func1), func2, i);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> func1) {
        return flatMapSingle(func1, false, Integer.MAX_VALUE);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> func1, boolean z) {
        return flatMapSingle(func1, z, Integer.MAX_VALUE);
    }

    public final <R> Observable<R> flatMapSingle(Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
        return unsafeCreate(new OnSubscribeFlatMapSingle(this, func1, z, i));
    }

    public final void forEach(Action1<? super T> action1) {
        subscribe(action1);
    }

    public final void forEach(Action1<? super T> action1, Action1<Throwable> action12) {
        subscribe(action1, action12);
    }

    public final void forEach(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        subscribe(action1, action12, action0);
    }

    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12) {
        return lift(new OperatorGroupByEvicting(func1, func12));
    }

    @Deprecated
    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        Objects.requireNonNull(func13, "evictingMapFactory cannot be null");
        return lift(new OperatorGroupBy(func1, func12, func13));
    }

    public final <K, R> Observable<GroupedObservable<K, R>> groupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12, int i, boolean z, Func1<Action1<Object>, Map<K, Object>> func13) {
        Objects.requireNonNull(func13, "evictingMapFactory cannot be null");
        return lift(new OperatorGroupByEvicting(func1, func12, i, z, func13));
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Func1<? super T, ? extends K> func1) {
        return lift(new OperatorGroupByEvicting(func1));
    }

    public final <T2, D1, D2, R> Observable<R> groupJoin(Observable<T2> observable, Func1<? super T, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T, ? super Observable<T2>, ? extends R> func2) {
        return unsafeCreate(new OnSubscribeGroupJoin(this, observable, func1, func12, func2));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> ignoreElements() {
        return (Observable<R>) lift(OperatorIgnoreElements.instance());
    }

    public final Observable<Boolean> isEmpty() {
        return lift(InternalObservableUtils.IS_EMPTY);
    }

    public final <TRight, TLeftDuration, TRightDuration, R> Observable<R> join(Observable<TRight> observable, Func1<T, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<T, TRight, R> func2) {
        return unsafeCreate(new OnSubscribeJoin(this, observable, func1, func12, func2));
    }

    public final Observable<T> last() {
        return takeLast(1).single();
    }

    public final Observable<T> last(Func1<? super T, Boolean> func1) {
        return filter(func1).takeLast(1).single();
    }

    public final Observable<T> lastOrDefault(T t) {
        return takeLast(1).singleOrDefault(t);
    }

    public final Observable<T> lastOrDefault(T t, Func1<? super T, Boolean> func1) {
        return filter(func1).takeLast(1).singleOrDefault(t);
    }

    public final Observable<T> limit(int i) {
        return take(i);
    }

    public final <R> Observable<R> map(Func1<? super T, ? extends R> func1) {
        return unsafeCreate(new OnSubscribeMap(this, func1));
    }

    private <R> Observable<R> mapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        return lift(new OperatorMapNotification(func1, func12, func0));
    }

    public final Observable<Notification<T>> materialize() {
        return lift(OperatorMaterialize.instance());
    }

    public final Observable<T> mergeWith(Observable<? extends T> observable) {
        return merge(this, observable);
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, RxRingBuffer.SIZE);
    }

    public final Observable<T> observeOn(Scheduler scheduler, int i) {
        return observeOn(scheduler, false, i);
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, RxRingBuffer.SIZE);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler) : (Observable<R>) lift(new OperatorObserveOn(scheduler, z, i));
    }

    public final <R> Observable<R> ofType(Class<R> cls) {
        return filter(InternalObservableUtils.isInstanceOf(cls)).cast(cls);
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureBuffer() {
        return (Observable<R>) lift(OperatorOnBackpressureBuffer.instance());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureBuffer(long j) {
        return (Observable<R>) lift(new OperatorOnBackpressureBuffer(j));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureBuffer(long j, Action0 action0) {
        return (Observable<R>) lift(new OperatorOnBackpressureBuffer(j, action0));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureBuffer(long j, Action0 action0, BackpressureOverflow.Strategy strategy) {
        return (Observable<R>) lift(new OperatorOnBackpressureBuffer(j, action0, strategy));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureDrop(Action1<? super T> action1) {
        return (Observable<R>) lift(new OperatorOnBackpressureDrop(action1));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureDrop() {
        return (Observable<R>) lift(OperatorOnBackpressureDrop.instance());
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onBackpressureLatest() {
        return (Observable<R>) lift(OperatorOnBackpressureLatest.instance());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onErrorResumeNext(Func1<? super Throwable, ? extends Observable<? extends T>> func1) {
        return (Observable<R>) lift(new OperatorOnErrorResumeNextViaFunction(func1));
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onErrorResumeNext(Observable<? extends T> observable) {
        return (Observable<R>) lift(OperatorOnErrorResumeNextViaFunction.withOther(observable));
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onErrorReturn(Func1<? super Throwable, ? extends T> func1) {
        return (Observable<R>) lift(OperatorOnErrorResumeNextViaFunction.withSingle(func1));
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> onExceptionResumeNext(Observable<? extends T> observable) {
        return (Observable<R>) lift(OperatorOnErrorResumeNextViaFunction.withException(observable));
    }

    public final Observable<T> onTerminateDetach() {
        return unsafeCreate(new OnSubscribeDetach(this));
    }

    public final ConnectableObservable<T> publish() {
        return OperatorPublish.create(this);
    }

    public final <R> Observable<R> publish(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorPublish.create(this, func1);
    }

    /* JADX DEBUG: Type inference failed for r4v3. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> rebatchRequests(int i) {
        if (i > 0) {
            return (Observable<R>) lift(OperatorObserveOn.rebatch(i));
        }
        throw new IllegalArgumentException("n > 0 required but it was " + i);
    }

    public final Observable<T> reduce(Func2<T, T, T> func2) {
        return unsafeCreate(new OnSubscribeReduce(this, func2));
    }

    public final <R> Observable<R> reduce(R r, Func2<R, ? super T, R> func2) {
        return unsafeCreate(new OnSubscribeReduceSeed(this, r, func2));
    }

    public final Observable<T> repeat() {
        return OnSubscribeRedo.repeat(this);
    }

    public final Observable<T> repeat(Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, scheduler);
    }

    public final Observable<T> repeat(long j) {
        return OnSubscribeRedo.repeat(this, j);
    }

    public final Observable<T> repeat(long j, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, j, scheduler);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(func1), scheduler);
    }

    public final Observable<T> repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.repeat(this, InternalObservableUtils.createRepeatDematerializer(func1));
    }

    public final ConnectableObservable<T> replay() {
        return OperatorReplay.create(this);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), func1);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i), func1);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, long j, TimeUnit timeUnit) {
        return replay(func1, i, j, timeUnit, Schedulers.computation());
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i, j, timeUnit, scheduler), func1);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, int i, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, i), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j, TimeUnit timeUnit) {
        return replay(func1, j, timeUnit, Schedulers.computation());
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this, j, timeUnit, scheduler), func1);
    }

    public final <R> Observable<R> replay(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
        return OperatorReplay.multicastSelector(InternalObservableUtils.createReplaySupplier(this), InternalObservableUtils.createReplaySelectorAndObserveOn(func1, scheduler));
    }

    public final ConnectableObservable<T> replay(int i) {
        return OperatorReplay.create(this, i);
    }

    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, Schedulers.computation());
    }

    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            return OperatorReplay.create(this, j, timeUnit, scheduler, i);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final ConnectableObservable<T> replay(int i, Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(i), scheduler);
    }

    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, Schedulers.computation());
    }

    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return OperatorReplay.create(this, j, timeUnit, scheduler);
    }

    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        return OperatorReplay.observeOn(replay(), scheduler);
    }

    public final Observable<T> retry() {
        return OnSubscribeRedo.retry(this);
    }

    public final Observable<T> retry(long j) {
        return OnSubscribeRedo.retry(this, j);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> retry(Func2<Integer, Throwable, Boolean> func2) {
        return (Observable<R>) nest().lift(new OperatorRetryWithPredicate(func2));
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(func1));
    }

    public final Observable<T> retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return OnSubscribeRedo.retry(this, InternalObservableUtils.createRetryDematerializer(func1), scheduler);
    }

    public final Observable<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorSampleWithTime(j, timeUnit, scheduler));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> sample(Observable<U> observable) {
        return (Observable<R>) lift(new OperatorSampleWithObservable(observable));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> scan(Func2<T, T, T> func2) {
        return (Observable<R>) lift(new OperatorScan(func2));
    }

    public final <R> Observable<R> scan(R r, Func2<R, ? super T, R> func2) {
        return lift(new OperatorScan((Object) r, (Func2) func2));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> serialize() {
        return (Observable<R>) lift(OperatorSerialize.instance());
    }

    public final Observable<T> share() {
        return publish().refCount();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> single() {
        return (Observable<R>) lift(OperatorSingle.instance());
    }

    public final Observable<T> single(Func1<? super T, Boolean> func1) {
        return filter(func1).single();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> singleOrDefault(T t) {
        return (Observable<R>) lift(new OperatorSingle(t));
    }

    public final Observable<T> singleOrDefault(T t, Func1<? super T, Boolean> func1) {
        return filter(func1).singleOrDefault(t);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> skip(int i) {
        return (Observable<R>) lift(new OperatorSkip(i));
    }

    public final Observable<T> skip(long j, TimeUnit timeUnit) {
        return skip(j, timeUnit, Schedulers.computation());
    }

    public final Observable<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeSkipTimed(this, j, timeUnit, scheduler));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> skipLast(int i) {
        return (Observable<R>) lift(new OperatorSkipLast(i));
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorSkipLastTimed(j, timeUnit, scheduler));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <U> Observable<T> skipUntil(Observable<U> observable) {
        return (Observable<R>) lift(new OperatorSkipUntil(observable));
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> skipWhile(Func1<? super T, Boolean> func1) {
        return (Observable<R>) lift(new OperatorSkipWhile(OperatorSkipWhile.toPredicate2(func1)));
    }

    public final Observable<T> startWith(Observable<T> observable) {
        return concat(observable, this);
    }

    public final Observable<T> startWith(Iterable<T> iterable) {
        return concat(from(iterable), this);
    }

    public final Observable<T> startWith(T t) {
        return concat(just(t), this);
    }

    public final Observable<T> startWith(T t, T t2) {
        return concat(just(t, t2), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3) {
        return concat(just(t, t2, t3), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4) {
        return concat(just(t, t2, t3, t4), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4, T t5) {
        return concat(just(t, t2, t3, t4, t5), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4, T t5, T t6) {
        return concat(just(t, t2, t3, t4, t5, t6), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        return concat(just(t, t2, t3, t4, t5, t6, t7), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        return concat(just(t, t2, t3, t4, t5, t6, t7, t8), this);
    }

    public final Observable<T> startWith(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        return concat(just(t, t2, t3, t4, t5, t6, t7, t8, t9), this);
    }

    public final Subscription subscribe() {
        return subscribe((Subscriber) new ActionSubscriber(Actions.empty(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.empty()));
    }

    public final Subscription subscribe(Action1<? super T> action1) {
        if (action1 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.empty()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final Subscription subscribe(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, action12, Actions.empty()));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public final Subscription subscribe(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        } else if (action0 != null) {
            return subscribe((Subscriber) new ActionSubscriber(action1, action12, action0));
        } else {
            throw new IllegalArgumentException("onComplete can not be null");
        }
    }

    public final Subscription subscribe(Observer<? super T> observer) {
        if (observer instanceof Subscriber) {
            return subscribe((Subscriber) ((Subscriber) observer));
        }
        Objects.requireNonNull(observer, "observer is null");
        return subscribe((Subscriber) new ObserverSubscriber(observer));
    }

    public final Subscription unsafeSubscribe(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            RxJavaHooks.onObservableStart(this, this.onSubscribe).call(subscriber);
            return RxJavaHooks.onObservableReturn(subscriber);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
            RxJavaHooks.onObservableError(onErrorFailedException);
            throw onErrorFailedException;
        }
    }

    public final Subscription subscribe(Subscriber<? super T> subscriber) {
        return subscribe(subscriber, this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: rx.Observable$OnSubscribe */
    /* JADX WARN: Multi-variable type inference failed */
    static <T> Subscription subscribe(Subscriber<? super T> subscriber, Observable<T> observable) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (observable.onSubscribe != null) {
            subscriber.onStart();
            if (!(subscriber instanceof SafeSubscriber)) {
                subscriber = new SafeSubscriber(subscriber);
            }
            try {
                RxJavaHooks.onObservableStart(observable, observable.onSubscribe).call(subscriber);
                return RxJavaHooks.onObservableReturn(subscriber);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
                RxJavaHooks.onObservableError(onErrorFailedException);
                throw onErrorFailedException;
            }
        } else {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        return subscribeOn(scheduler, !(this.onSubscribe instanceof OnSubscribeCreate));
    }

    public final Observable<T> subscribeOn(Scheduler scheduler, boolean z) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).scalarScheduleOn(scheduler);
        }
        return unsafeCreate(new OperatorSubscribeOn(this, scheduler, z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMap(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return switchOnNext(map(func1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Observable<R> switchMapDelayError(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return switchOnNextDelayError(map(func1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> take(int i) {
        return (Observable<R>) lift(new OperatorTake(i));
    }

    public final Observable<T> take(long j, TimeUnit timeUnit) {
        return take(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorTakeTimed(j, timeUnit, scheduler));
    }

    public final Observable<T> takeFirst(Func1<? super T, Boolean> func1) {
        return filter(func1).take(1);
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> takeLast(int i) {
        if (i == 0) {
            return ignoreElements();
        }
        return i == 1 ? unsafeCreate(new OnSubscribeTakeLastOne(this)) : (Observable<R>) lift(new OperatorTakeLast(i));
    }

    public final Observable<T> takeLast(int i, long j, TimeUnit timeUnit) {
        return takeLast(i, j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r8v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> takeLast(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorTakeLastTimed(i, j, timeUnit, scheduler));
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorTakeLastTimed(j, timeUnit, scheduler));
    }

    public final Observable<List<T>> takeLastBuffer(int i) {
        return takeLast(i).toList();
    }

    public final Observable<List<T>> takeLastBuffer(int i, long j, TimeUnit timeUnit) {
        return takeLast(i, j, timeUnit).toList();
    }

    public final Observable<List<T>> takeLastBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(i, j, timeUnit, scheduler).toList();
    }

    public final Observable<List<T>> takeLastBuffer(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit).toList();
    }

    public final Observable<List<T>> takeLastBuffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler).toList();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final <E> Observable<T> takeUntil(Observable<? extends E> observable) {
        return (Observable<R>) lift(new OperatorTakeUntil(observable));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> takeWhile(Func1<? super T, Boolean> func1) {
        return (Observable<R>) lift(new OperatorTakeWhile(func1));
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> takeUntil(Func1<? super T, Boolean> func1) {
        return (Observable<R>) lift(new OperatorTakeUntilPredicate(func1));
    }

    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, Schedulers.computation());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorThrottleFirst(j, timeUnit, scheduler));
    }

    public final Observable<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final Observable<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    public final Observable<TimeInterval<T>> timeInterval() {
        return timeInterval(Schedulers.computation());
    }

    public final Observable<TimeInterval<T>> timeInterval(Scheduler scheduler) {
        return lift(new OperatorTimeInterval(scheduler));
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1) {
        return timeout(func0, func1, (Observable) null);
    }

    public final <U, V> Observable<T> timeout(Func0<? extends Observable<U>> func0, Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        Objects.requireNonNull(func1, "timeoutSelector is null");
        return unsafeCreate(new OnSubscribeTimeoutSelectorWithFallback(this, func0 != null ? defer(func0) : null, func1, observable));
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> func1) {
        return timeout((Func0) null, func1, (Observable) null);
    }

    public final <V> Observable<T> timeout(Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        return timeout((Func0) null, func1, observable);
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, null, Schedulers.computation());
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, Observable<? extends T> observable) {
        return timeout(j, timeUnit, observable, Schedulers.computation());
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        return unsafeCreate(new OnSubscribeTimeoutTimedWithFallback(this, j, timeUnit, scheduler, observable));
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(j, timeUnit, null, scheduler);
    }

    public final Observable<Timestamped<T>> timestamp() {
        return timestamp(Schedulers.computation());
    }

    public final Observable<Timestamped<T>> timestamp(Scheduler scheduler) {
        return lift(new OperatorTimestamp(scheduler));
    }

    public final BlockingObservable<T> toBlocking() {
        return BlockingObservable.from(this);
    }

    public final Observable<List<T>> toList() {
        return lift(OperatorToObservableList.instance());
    }

    public final <K> Observable<Map<K, T>> toMap(Func1<? super T, ? extends K> func1) {
        return unsafeCreate(new OnSubscribeToMap(this, func1, UtilityFunctions.identity()));
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return unsafeCreate(new OnSubscribeToMap(this, func1, func12));
    }

    public final <K, V> Observable<Map<K, V>> toMap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, V>> func0) {
        return unsafeCreate(new OnSubscribeToMap(this, func1, func12, func0));
    }

    public final <K> Observable<Map<K, Collection<T>>> toMultimap(Func1<? super T, ? extends K> func1) {
        return unsafeCreate(new OnSubscribeToMultimap(this, func1, UtilityFunctions.identity()));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return unsafeCreate(new OnSubscribeToMultimap(this, func1, func12));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0) {
        return unsafeCreate(new OnSubscribeToMultimap(this, func1, func12, func0));
    }

    public final <K, V> Observable<Map<K, Collection<V>>> toMultimap(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func0<? extends Map<K, Collection<V>>> func0, Func1<? super K, ? extends Collection<V>> func13) {
        return unsafeCreate(new OnSubscribeToMultimap(this, func1, func12, func0, func13));
    }

    public final Observable<List<T>> toSortedList() {
        return lift(new OperatorToObservableSortedList(10));
    }

    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> func2) {
        return lift(new OperatorToObservableSortedList(func2, 10));
    }

    public final Observable<List<T>> toSortedList(int i) {
        return lift(new OperatorToObservableSortedList(i));
    }

    public final Observable<List<T>> toSortedList(Func2<? super T, ? super T, Integer> func2, int i) {
        return lift(new OperatorToObservableSortedList(func2, i));
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> sorted() {
        return (Observable<R>) toSortedList().flatMapIterable(UtilityFunctions.identity());
    }

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> sorted(Func2<? super T, ? super T, Integer> func2) {
        return (Observable<R>) toSortedList(func2).flatMapIterable(UtilityFunctions.identity());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: rx.Observable<R>, rx.Observable<T> */
    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        return (Observable<R>) lift(new OperatorUnsubscribeOn(scheduler));
    }

    public final <U, R> Observable<R> withLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        return lift(new OperatorWithLatestFrom(observable, func2));
    }

    public final <T1, T2, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Func3<? super T, ? super T1, ? super T2, R> func3) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2}, null, Functions.fromFunc(func3)));
    }

    public final <T1, T2, T3, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Func4<? super T, ? super T1, ? super T2, ? super T3, R> func4) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3}, null, Functions.fromFunc(func4)));
    }

    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Func5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> func5) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4}, null, Functions.fromFunc(func5)));
    }

    public final <T1, T2, T3, T4, T5, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Func6<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, R> func6) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5}, null, Functions.fromFunc(func6)));
    }

    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Func7<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, R> func7) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6}, null, Functions.fromFunc(func7)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Func8<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, R> func8) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7}, null, Functions.fromFunc(func8)));
    }

    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> withLatestFrom(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Func9<? super T, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, R> func9) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, new Observable[]{observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8}, null, Functions.fromFunc(func9)));
    }

    public final <R> Observable<R> withLatestFrom(Observable<?>[] observableArr, FuncN<R> funcN) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, observableArr, null, funcN));
    }

    public final <R> Observable<R> withLatestFrom(Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        return unsafeCreate(new OperatorWithLatestFromMany(this, null, iterable, funcN));
    }

    public final <TClosing> Observable<Observable<T>> window(Func0<? extends Observable<? extends TClosing>> func0) {
        return lift(new OperatorWindowWithObservableFactory(func0));
    }

    public final Observable<Observable<T>> window(int i) {
        return window(i, i);
    }

    public final Observable<Observable<T>> window(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("count > 0 required but it was " + i);
        } else if (i2 > 0) {
            return lift(new OperatorWindowWithSize(i, i2));
        } else {
            throw new IllegalArgumentException("skip > 0 required but it was " + i2);
        }
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, Integer.MAX_VALUE, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return lift(new OperatorWindowWithTime(j, j2, timeUnit, i, scheduler));
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit) {
        return window(j, j, timeUnit, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, int i) {
        return window(j, timeUnit, i, Schedulers.computation());
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        return window(j, j, timeUnit, i, scheduler);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public final <TOpening, TClosing> Observable<Observable<T>> window(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        return lift(new OperatorWindowWithStartEndObservable(observable, func1));
    }

    public final <U> Observable<Observable<T>> window(Observable<U> observable) {
        return lift(new OperatorWindowWithObservable(observable));
    }

    public final <T2, R> Observable<R> zipWith(Iterable<? extends T2> iterable, Func2<? super T, ? super T2, ? extends R> func2) {
        return lift(new OperatorZipIterable(iterable, func2));
    }

    public final <T2, R> Observable<R> zipWith(Observable<? extends T2> observable, Func2<? super T, ? super T2, ? extends R> func2) {
        return zip(this, observable, func2);
    }

    public final AssertableSubscriber<T> test() {
        AssertableSubscriberObservable create = AssertableSubscriberObservable.create(Long.MAX_VALUE);
        subscribe((Observer) create);
        return create;
    }

    public final AssertableSubscriber<T> test(long j) {
        AssertableSubscriberObservable create = AssertableSubscriberObservable.create(j);
        subscribe((Observer) create);
        return create;
    }
}
