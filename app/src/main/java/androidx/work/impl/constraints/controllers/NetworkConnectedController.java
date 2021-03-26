package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getNetworkStateTracker());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.getRequiredNetworkType() == NetworkType.CONNECTED;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstrained(NetworkState networkState) {
        if (Build.VERSION.SDK_INT < 26) {
            return !networkState.isConnected();
        }
        if (!networkState.isConnected() || !networkState.isValidated()) {
            return true;
        }
        return false;
    }
}
