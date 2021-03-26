package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;

public abstract class ResultConvert<R extends Result, S extends Result> {
    public abstract PendingResult onSuccess(Result result);

    public Status onFailed(Status status) {
        Preconditions.checkNotNull(status, "The input status cannot be null");
        if (status.getStatusCode() != 0) {
            return status;
        }
        return Status.CoreException;
    }

    public final PendingResult newFailedPendingResult(Status status) {
        Preconditions.checkNotNull(status, "The input status cannot be null");
        Preconditions.checkArgument(!status.isSuccess(), "The input status must be call with success status");
        return new FailPendingResult(status);
    }

    public class FailPendingResult extends EmptyPendingResult {
        public FailPendingResult(Status status) {
            setResult(status);
        }
    }
}
