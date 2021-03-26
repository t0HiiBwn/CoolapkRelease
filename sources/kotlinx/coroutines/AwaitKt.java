package kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* compiled from: Await.kt */
public final class AwaitKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$1 awaitKt$awaitAll$1;
        int i;
        if (continuation instanceof AwaitKt$awaitAll$1) {
            awaitKt$awaitAll$1 = (AwaitKt$awaitAll$1) continuation;
            if ((awaitKt$awaitAll$1.label & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$1.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$awaitAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (deferredArr.length == 0) {
                        return CollectionsKt.emptyList();
                    }
                    AwaitAll awaitAll = new AwaitAll(deferredArr);
                    awaitKt$awaitAll$1.L$0 = deferredArr;
                    awaitKt$awaitAll$1.label = 1;
                    obj = awaitAll.await(awaitKt$awaitAll$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Deferred[] deferredArr2 = (Deferred[]) awaitKt$awaitAll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$1 = new AwaitKt$awaitAll$1(continuation);
        Object obj = awaitKt$awaitAll$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitAll$1.label;
        if (i != 0) {
        }
        return (List) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$2 awaitKt$awaitAll$2;
        int i;
        if (continuation instanceof AwaitKt$awaitAll$2) {
            awaitKt$awaitAll$2 = (AwaitKt$awaitAll$2) continuation;
            if ((awaitKt$awaitAll$2.label & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$2.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$awaitAll$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitAll$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (collection.isEmpty()) {
                        return CollectionsKt.emptyList();
                    }
                    Object[] array = collection.toArray(new Deferred[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    AwaitAll awaitAll = new AwaitAll((Deferred[]) array);
                    awaitKt$awaitAll$2.L$0 = collection;
                    awaitKt$awaitAll$2.label = 1;
                    obj = awaitAll.await(awaitKt$awaitAll$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    Collection collection2 = (Collection) awaitKt$awaitAll$2.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$2 = new AwaitKt$awaitAll$2(continuation);
        Object obj = awaitKt$awaitAll$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitAll$2.label;
        if (i != 0) {
        }
        return (List) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object joinAll(Job[] jobArr, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        int i;
        Job[] jobArr2;
        int i2;
        int i3;
        Object obj;
        AwaitKt$joinAll$1 awaitKt$joinAll$12;
        Job[] jobArr3;
        Job[] jobArr4;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            if ((awaitKt$joinAll$1.label & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label -= Integer.MIN_VALUE;
                Object obj2 = awaitKt$joinAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    i3 = jobArr.length;
                    awaitKt$joinAll$12 = awaitKt$joinAll$1;
                    obj = coroutine_suspended;
                    jobArr2 = jobArr;
                    jobArr4 = jobArr2;
                    jobArr3 = jobArr4;
                    i2 = 0;
                } else if (i == 1) {
                    Job job = (Job) awaitKt$joinAll$1.L$4;
                    Job job2 = (Job) awaitKt$joinAll$1.L$3;
                    i2 = awaitKt$joinAll$1.I$1;
                    int i4 = awaitKt$joinAll$1.I$0;
                    ResultKt.throwOnFailure(obj2);
                    jobArr2 = (Job[]) awaitKt$joinAll$1.L$2;
                    obj = coroutine_suspended;
                    jobArr3 = (Job[]) awaitKt$joinAll$1.L$1;
                    i3 = i4;
                    awaitKt$joinAll$12 = awaitKt$joinAll$1;
                    jobArr4 = (Job[]) awaitKt$joinAll$1.L$0;
                    i2++;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (i2 < i3) {
                    Job job3 = jobArr2[i2];
                    awaitKt$joinAll$12.L$0 = jobArr4;
                    awaitKt$joinAll$12.L$1 = jobArr3;
                    awaitKt$joinAll$12.L$2 = jobArr2;
                    awaitKt$joinAll$12.I$0 = i3;
                    awaitKt$joinAll$12.I$1 = i2;
                    awaitKt$joinAll$12.L$3 = job3;
                    awaitKt$joinAll$12.L$4 = job3;
                    awaitKt$joinAll$12.label = 1;
                    if (job3.join(awaitKt$joinAll$12) == obj) {
                        return obj;
                    }
                    i2++;
                    if (i2 < i3) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        Object obj2 = awaitKt$joinAll$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$1.label;
        if (i != 0) {
        }
        if (i2 < i3) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final Object joinAll(Collection<? extends Job> collection, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        int i;
        Collection<? extends Job> collection2;
        Iterator<T> it2;
        Iterable iterable;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            if ((awaitKt$joinAll$3.label & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Collection<? extends Job> collection3 = collection;
                    Iterator<T> it3 = collection3.iterator();
                    collection2 = collection;
                    it2 = it3;
                    iterable = collection3;
                } else if (i == 1) {
                    Job job = (Job) awaitKt$joinAll$3.L$4;
                    Object obj2 = awaitKt$joinAll$3.L$3;
                    it2 = (Iterator) awaitKt$joinAll$3.L$2;
                    iterable = (Iterable) awaitKt$joinAll$3.L$1;
                    ResultKt.throwOnFailure(obj);
                    collection2 = (Collection) awaitKt$joinAll$3.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                while (it2.hasNext()) {
                    Object next = it2.next();
                    Job job2 = (Job) next;
                    awaitKt$joinAll$3.L$0 = collection2;
                    awaitKt$joinAll$3.L$1 = iterable;
                    awaitKt$joinAll$3.L$2 = it2;
                    awaitKt$joinAll$3.L$3 = next;
                    awaitKt$joinAll$3.L$4 = job2;
                    awaitKt$joinAll$3.label = 1;
                    if (job2.join(awaitKt$joinAll$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        Object obj = awaitKt$joinAll$3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$3.label;
        if (i != 0) {
        }
        while (it2.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
