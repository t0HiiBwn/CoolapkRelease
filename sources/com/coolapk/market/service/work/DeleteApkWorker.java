package com.coolapk.market.service.work;

import android.content.Context;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.widget.Toast;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/service/work/DeleteApkWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getContext", "()Landroid/content/Context;", "doWork", "Landroidx/work/ListenableWorker$Result;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DeleteApkWorker.kt */
public final class DeleteApkWorker extends Worker {
    public static final Companion Companion = new Companion(null);
    private static final String WORK_NAME = "DeleteApkWork";
    private final Context context;

    @JvmStatic
    public static final void setShouldDeleteCoolapkFilePath(String str) {
        Companion.setShouldDeleteCoolapkFilePath(str);
    }

    @JvmStatic
    public static final void start(Context context2) {
        Companion.start(context2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteApkWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/service/work/DeleteApkWorker$Companion;", "", "()V", "WORK_NAME", "", "setShouldDeleteCoolapkFilePath", "", "path", "start", "context", "Landroid/content/Context;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DeleteApkWorker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void setShouldDeleteCoolapkFilePath(String str) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                instance.getPreferencesEditor().putString("SHOULD_DELETE_COOLAPK_FILE_PATH", str).apply();
            }
        }

        @JvmStatic
        public final void start(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            WorkRequest build = ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DeleteApkWorker.class).setInitialDelay(1, TimeUnit.SECONDS)).build();
            Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…                 .build()");
            WorkManager.getInstance(applicationContext).enqueueUniqueWork("DeleteApkWork", ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build);
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        AppUtils.AppInfo apkInfo;
        try {
            LogUtils.i("Check old coolapk-xxx.apk should delete", new Object[0]);
            if (AppHolder.getAppSetting().shouldDeleteAfterInstalling()) {
                String preferencesString = DataManager.getInstance().getPreferencesString("SHOULD_DELETE_COOLAPK_FILE_PATH", "");
                Intrinsics.checkNotNullExpressionValue(preferencesString, "path");
                if (preferencesString.length() > 0) {
                    if (FileUtils.isFileExists(preferencesString) && (apkInfo = AppUtils.getApkInfo(preferencesString)) != null && apkInfo.getVersionCode() < AppHolder.getAppMetadata().getAppVersionCode()) {
                        FileUtils.delete(preferencesString);
                        Context context2 = this.context;
                        Toast.show$default(context2, context2.getString(2131887187, apkInfo.getName()), 0, false, 12, null);
                        LogUtils.i("Already delete: " + apkInfo.getVersionCode(), new Object[0]);
                    }
                    Companion.setShouldDeleteCoolapkFilePath("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
        return success;
    }
}
