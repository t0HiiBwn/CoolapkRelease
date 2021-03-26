package com.coolapk.market.service.work;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/service/work/StatWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: StatWorker.kt */
public final class StatWorker extends Worker {
    public static final String ACTION_DOWNLOAD_COMPLETE = "ACTION_DOWNLOAD_COMPLETE";
    public static final String ACTION_INSTALL = "ACTION_INSTALL";
    public static final String ACTION_UNINSTALL = "ACTION_UNINSTALL";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_ACTION = "ACTION";
    public static final String KEY_APK_ID = "APK_ID";
    public static final String KEY_EXTRA = "EXTRA";
    public static final String KEY_EXTRA_ANALYSIS_DATA = "EXTRA_ANALYSIS_DATA";
    public static final String KEY_IS_NEW_INSTALL = "IS_NEW_INSTALL";
    public static final String KEY_PACKAGE_NAME = "PACKAGE_NAME";
    private static final String WORK_NAME = "STAT_WORKER";

    @JvmStatic
    public static final void start(Context context, Data data) {
        Companion.start(context, data);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StatWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/service/work/StatWorker$Companion;", "", "()V", "ACTION_DOWNLOAD_COMPLETE", "", "ACTION_INSTALL", "ACTION_UNINSTALL", "KEY_ACTION", "KEY_APK_ID", "KEY_EXTRA", "KEY_EXTRA_ANALYSIS_DATA", "KEY_IS_NEW_INSTALL", "KEY_PACKAGE_NAME", "WORK_NAME", "start", "", "context", "Landroid/content/Context;", "data", "Landroidx/work/Data;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: StatWorker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(Context context, Data data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Context applicationContext = context.getApplicationContext();
            WorkRequest build = ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StatWorker.class).setInputData(data)).build();
            Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…                 .build()");
            WorkManager.getInstance(applicationContext).enqueueUniqueWork("STAT_WORKER", ExistingWorkPolicy.APPEND, (OneTimeWorkRequest) build);
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Data inputData = getInputData();
        Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
        String string = inputData.getString("ACTION");
        String string2 = inputData.getString("PACKAGE_NAME");
        String string3 = inputData.getString("APK_ID");
        String string4 = inputData.getString("EXTRA");
        String string5 = inputData.getString("EXTRA_ANALYSIS_DATA");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -1900008121) {
                if (hashCode != -802629127) {
                    if (hashCode == 2091463794 && string.equals("ACTION_INSTALL")) {
                        try {
                            DataManager.getInstance().statInstall(string2, string3, string4, inputData.getBoolean("IS_NEW_INSTALL", true), string5).toBlocking().first();
                        } catch (Exception e) {
                            LogUtils.e("Stat install failed", e);
                            ListenableWorker.Result failure = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
                            return failure;
                        }
                    }
                } else if (string.equals("ACTION_UNINSTALL")) {
                    try {
                        DataManager.getInstance().statUninstall(string2, string3, string4, string5).toBlocking().first();
                    } catch (Exception e2) {
                        LogUtils.e("Stat uninstall failed", e2);
                        ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
                        Intrinsics.checkNotNullExpressionValue(failure2, "Result.failure()");
                        return failure2;
                    }
                }
            } else if (string.equals("ACTION_DOWNLOAD_COMPLETE")) {
                try {
                    DataManager.getInstance().statDownloadComplete(string2, string3, string4, inputData.getBoolean("IS_NEW_INSTALL", true), string5).toBlocking().first();
                } catch (Exception e3) {
                    LogUtils.e("Stat download complete failed", e3);
                    ListenableWorker.Result failure3 = ListenableWorker.Result.failure();
                    Intrinsics.checkNotNullExpressionValue(failure3, "Result.failure()");
                    return failure3;
                }
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
        return success;
    }
}
