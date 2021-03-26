package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;

/* compiled from: Job.kt */
final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static final DisposableHandle DisposableHandle(Function0<Unit> function0) {
        return new JobKt__JobKt$DisposableHandle$1(function0);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(job, disposableHandle));
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        for (Job job2 : job.getChildren()) {
            job2.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    public static final /* synthetic */ void cancelChildren(Job job, Throwable th) {
        for (Job job2 : job.getChildren()) {
            if (!(job2 instanceof JobSupport)) {
                job2 = null;
            }
            JobSupport jobSupport = (JobSupport) job2;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        return job != null && job.isActive();
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            JobKt.ensureActive(job);
            return;
        }
        throw new IllegalStateException(("Context cannot be checked for liveness because it does not have a job: " + coroutineContext).toString());
    }

    public static final void cancel(Job job, String str, Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return cancel(coroutineContext, th);
    }

    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element element = coroutineContext.get(Job.Key);
        if (!(element instanceof JobSupport)) {
            element = null;
        }
        JobSupport jobSupport = (JobSupport) element;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.Key);
        if (!(job == null || (children = job.getChildren()) == null)) {
            for (Job job2 : children) {
                job2.cancel(cancellationException);
            }
        }
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            for (Job job2 : job.getChildren()) {
                if (!(job2 instanceof JobSupport)) {
                    job2 = null;
                }
                JobSupport jobSupport = (JobSupport) job2;
                if (jobSupport != null) {
                    jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
                }
            }
        }
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable th, Job job) {
        return th != null ? th : new JobCancellationException("Job was cancelled", null, job);
    }
}
