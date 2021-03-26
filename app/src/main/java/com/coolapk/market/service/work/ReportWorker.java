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
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/service/work/ReportWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReportWorker.kt */
public final class ReportWorker extends Worker {
    public static final String APK_NAME = "APK_NAME";
    public static final Companion Companion = new Companion(null);
    public static final String DOWNLOAD_URL = "DOWNLOAD_URL";
    public static final String KEY_AD_APP_ID = "AD_APP_ID";
    public static final String KEY_AD_DESC = "AD_DESC";
    public static final String KEY_AD_ID = "AD_ID";
    public static final String KEY_AD_INFO = "AD_INFO";
    public static final String KEY_AD_PICS = "AD_PICS";
    public static final String KEY_AD_PLATFORM = "AD_PLATFORM";
    public static final String KEY_AD_POS_ID = "AD_POS_ID";
    public static final String KEY_AD_REASON = "AD_REASON";
    public static final String KEY_AD_TITLE = "AD_TITLE";
    public static final String KEY_COUPON_APK_ID = "COUPON_APK_ID";
    public static final String KEY_COUPON_DATA = "COUPON_DATA";
    public static final String KEY_COUPON_INDEX = "COUPON_INDEX";
    public static final String KEY_DATA_SET = "DATA_SET";
    public static final String REPORT_DOWNLOAD_URL = "REPORT_DOWNLOAD_URL";
    public static final String REPORT_PACKAGE_NAME = "REPORT_PACKAGE_NAME";
    public static final String REPORT_TITLE = "REPORT_TITLE";
    public static final String REPORT_TYPE = "REPORT_TYPE";
    public static final String REPORT_TYPE_AD_CLOSE = "AD_CLOSE";
    public static final String REPORT_TYPE_COUPON = "COUPON";
    public static final String REPORT_TYPE_EXPOSURE = "EXPOSURE";
    public static final String REPORT_TYPE_HIJACK = "HIJACK";
    public static final String REPORT_TYPE_UNKNOWN = "UNKNOWN";
    public static final String REPORT_VERSION_CODE = "REPORT_VERSION_CODE";
    public static final String REPORT_VERSION_NAME = "REPORT_VERSION_NAME";
    private static final String WORK_NAME = "REPORT_WORKER";

    @JvmStatic
    public static final void start(Context context, Data data) {
        Companion.start(context, data);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReportWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/coolapk/market/service/work/ReportWorker$Companion;", "", "()V", "APK_NAME", "", "DOWNLOAD_URL", "KEY_AD_APP_ID", "KEY_AD_DESC", "KEY_AD_ID", "KEY_AD_INFO", "KEY_AD_PICS", "KEY_AD_PLATFORM", "KEY_AD_POS_ID", "KEY_AD_REASON", "KEY_AD_TITLE", "KEY_COUPON_APK_ID", "KEY_COUPON_DATA", "KEY_COUPON_INDEX", "KEY_DATA_SET", "REPORT_DOWNLOAD_URL", "REPORT_PACKAGE_NAME", "REPORT_TITLE", "REPORT_TYPE", "REPORT_TYPE_AD_CLOSE", "REPORT_TYPE_COUPON", "REPORT_TYPE_EXPOSURE", "REPORT_TYPE_HIJACK", "REPORT_TYPE_UNKNOWN", "REPORT_VERSION_CODE", "REPORT_VERSION_NAME", "WORK_NAME", "start", "", "context", "Landroid/content/Context;", "data", "Landroidx/work/Data;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReportWorker.kt */
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
            WorkRequest build = ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ReportWorker.class).setInputData(data)).build();
            Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…                 .build()");
            WorkManager.getInstance(applicationContext).enqueueUniqueWork("REPORT_WORKER", ExistingWorkPolicy.APPEND, (OneTimeWorkRequest) build);
        }
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Data inputData = getInputData();
        Intrinsics.checkNotNullExpressionValue(inputData, "inputData");
        String string = inputData.getString("REPORT_TYPE");
        if (string != null) {
            switch (string.hashCode()) {
                case -1143378681:
                    if (string.equals("EXPOSURE")) {
                        try {
                            DataManager instance = DataManager.getInstance();
                            String[] stringArray = inputData.getStringArray("DATA_SET");
                            Intrinsics.checkNotNull(stringArray);
                            Intrinsics.checkNotNullExpressionValue(stringArray, "data.getStringArray(KEY_DATA_SET)!!");
                            instance.reportExposure(ArraysKt.toList(stringArray)).toBlocking().first();
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                            ListenableWorker.Result failure = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
                            return failure;
                        }
                    }
                    break;
                case 323250876:
                    if (string.equals("AD_CLOSE")) {
                        try {
                            DataManager.getInstance().reportSponsorClose(inputData.getString("AD_ID"), inputData.getString("AD_PLATFORM"), inputData.getString("AD_APP_ID"), inputData.getString("AD_POS_ID"), inputData.getString("AD_TITLE"), inputData.getString("AD_DESC"), inputData.getString("AD_PICS"), inputData.getString("AD_INFO"), inputData.getInt("AD_REASON", 0)).toBlocking().first();
                            break;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure2, "Result.failure()");
                            return failure2;
                        }
                    }
                    break;
                case 433141802:
                    if (string.equals("UNKNOWN")) {
                        try {
                            DataManager.getInstance().reportUnknown(inputData.getString("APK_NAME"), inputData.getString("DOWNLOAD_URL"), inputData.getString("REPORT_DOWNLOAD_URL")).toBlocking().first();
                            break;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            ListenableWorker.Result failure3 = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure3, "Result.failure()");
                            return failure3;
                        }
                    }
                    break;
                case 1993722918:
                    if (string.equals("COUPON")) {
                        try {
                            DataManager.getInstance().reportCoupon(inputData.getString("COUPON_DATA"), inputData.getInt("COUPON_INDEX", 0), inputData.getString("COUPON_APK_ID")).toBlocking().first();
                            break;
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            ListenableWorker.Result failure4 = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure4, "Result.failure()");
                            return failure4;
                        }
                    }
                    break;
                case 2130985056:
                    if (string.equals("HIJACK")) {
                        try {
                            DataManager.getInstance().reportHijack(inputData.getString("APK_NAME"), inputData.getString("DOWNLOAD_URL"), inputData.getString("REPORT_DOWNLOAD_URL"), inputData.getString("REPORT_PACKAGE_NAME"), inputData.getString("REPORT_TITLE"), inputData.getString("REPORT_VERSION_NAME"), inputData.getInt("REPORT_VERSION_CODE", 0)).toBlocking().first();
                            break;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            ListenableWorker.Result failure5 = ListenableWorker.Result.failure();
                            Intrinsics.checkNotNullExpressionValue(failure5, "Result.failure()");
                            return failure5;
                        }
                    }
                    break;
            }
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
        return success;
    }
}
