package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkMeteredController extends ConstraintController<NetworkState> {
    private static final String TAG = Logger.tagWithPrefix("NetworkMeteredCtrlr");

    public NetworkMeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getNetworkStateTracker());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.getRequiredNetworkType() == NetworkType.METERED;
    }

    /* access modifiers changed from: package-private */
    public boolean isConstrained(NetworkState networkState) {
        if (Build.VERSION.SDK_INT < 26) {
            Logger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !networkState.isConnected();
        } else if (!networkState.isConnected() || !networkState.isMetered()) {
            return true;
        } else {
            return false;
        }
    }
}
