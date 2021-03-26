package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    private final ComponentName mWorkServiceComponent;

    SystemJobInfoConverter(Context context) {
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    JobInfo convert(WorkSpec workSpec, int i) {
        Constraints constraints = workSpec.constraints;
        int convertNetworkType = convertNetworkType(constraints.getRequiredNetworkType());
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", workSpec.id);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.mWorkServiceComponent).setRequiredNetworkType(convertNetworkType).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras(persistableBundle);
        if (!constraints.requiresDeviceIdle()) {
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, workSpec.backoffPolicy == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - System.currentTimeMillis(), 0L);
        if (Build.VERSION.SDK_INT <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else {
            extras.setImportantWhileForeground(true);
        }
        if (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) {
            for (ContentUriTriggers.Trigger trigger : constraints.getContentUriTriggers().getTriggers()) {
                extras.addTriggerContentUri(convertContentUriTrigger(trigger));
            }
            extras.setTriggerContentUpdateDelay(constraints.getTriggerContentUpdateDelay());
            extras.setTriggerContentMaxDelay(constraints.getTriggerMaxContentDelay());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            extras.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        return extras.build();
    }

    private static JobInfo.TriggerContentUri convertContentUriTrigger(ContentUriTriggers.Trigger trigger) {
        return new JobInfo.TriggerContentUri(trigger.getUri(), trigger.shouldTriggerForDescendants() ? 1 : 0);
    }

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

        static {
            int[] iArr = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static int convertNetworkType(NetworkType networkType) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            if (i == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger.get().debug(TAG, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }
}
