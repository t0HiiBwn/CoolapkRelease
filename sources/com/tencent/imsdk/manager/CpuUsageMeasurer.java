package com.tencent.imsdk.manager;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.FileUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CpuUsageMeasurer {
    private static final String TAG = "CpuUsageMeasurer";
    private static final long UPDATE_INTERVAL = TimeUnit.SECONDS.toMillis(2);
    private final long mClockClkInHz = NativeManager.nativeGetClockTickInHz();
    private long mIdleCpuTime = 0;
    private float mLastAppCpuTimeUsed = 0.0f;
    private float mLastAppCpuUsage = 0.0f;
    private float mLastSysCpuUsage = 0.0f;
    private long mLastUpdateTime = 0;
    private RandomAccessFile mProcessStatFile;
    private final int mProcessorCount = Runtime.getRuntime().availableProcessors();
    private RandomAccessFile mSystemStatFile;
    private long mTotalCpuTime = 0;

    public CpuUsageMeasurer() {
        try {
            this.mProcessStatFile = new RandomAccessFile(String.format(Locale.ENGLISH, "/proc/%d/stat", Integer.valueOf(Process.myPid())), "r");
        } catch (IOException e) {
            QLog.e("CpuUsageMeasurer", "open /proc/[PID]/stat failed. " + e.getMessage());
        }
        try {
            this.mSystemStatFile = new RandomAccessFile("/proc/stat", "r");
        } catch (IOException unused) {
        }
    }

    int[] getCpuUsage() {
        int[] iArr;
        synchronized (this) {
            if (NativeManager.nativeGetTimeTick() - this.mLastUpdateTime >= UPDATE_INTERVAL) {
                updateCpuUsage();
            }
            iArr = new int[]{(int) (this.mLastAppCpuUsage * 10.0f), (int) (this.mLastSysCpuUsage * 10.0f)};
        }
        return iArr;
    }

    private void updateCpuUsage() {
        long j;
        long j2;
        String[] readFirstLineAndSplit = readFirstLineAndSplit(this.mProcessStatFile);
        if (readFirstLineAndSplit != null && readFirstLineAndSplit.length >= 52) {
            long parseLong = (long) ((((float) (((Long.parseLong(readFirstLineAndSplit[13]) + Long.parseLong(readFirstLineAndSplit[14])) + Long.parseLong(readFirstLineAndSplit[15])) + Long.parseLong(readFirstLineAndSplit[16]))) * 1000.0f) / ((float) this.mClockClkInHz));
            String[] readFirstLineAndSplit2 = readFirstLineAndSplit(this.mSystemStatFile);
            if (readFirstLineAndSplit2 == null || readFirstLineAndSplit2.length < 8) {
                j = NativeManager.nativeGetTimeTick() * ((long) this.mProcessorCount);
                j2 = j;
            } else {
                long parseLong2 = Long.parseLong(readFirstLineAndSplit2[1]) + Long.parseLong(readFirstLineAndSplit2[2]) + Long.parseLong(readFirstLineAndSplit2[3]) + Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]) + Long.parseLong(readFirstLineAndSplit2[6]) + Long.parseLong(readFirstLineAndSplit2[7]);
                long parseLong3 = Long.parseLong(readFirstLineAndSplit2[4]) + Long.parseLong(readFirstLineAndSplit2[5]);
                long j3 = this.mClockClkInHz;
                j = (long) ((((float) parseLong2) * 1000.0f) / ((float) j3));
                j2 = (long) ((((float) parseLong3) * 1000.0f) / ((float) j3));
            }
            long j4 = j - this.mTotalCpuTime;
            float f = (float) parseLong;
            float f2 = (float) j4;
            this.mLastAppCpuUsage = ((f - this.mLastAppCpuTimeUsed) * 100.0f) / f2;
            this.mLastSysCpuUsage = (((float) (j4 - (j2 - this.mIdleCpuTime))) * 100.0f) / f2;
            this.mLastAppCpuTimeUsed = f;
            this.mIdleCpuTime = j2;
            this.mTotalCpuTime = j;
            this.mLastUpdateTime = NativeManager.nativeGetTimeTick();
        }
    }

    private static String[] readFirstLineAndSplit(RandomAccessFile randomAccessFile) {
        String str;
        if (randomAccessFile == null) {
            return null;
        }
        try {
            randomAccessFile.seek(0);
            str = randomAccessFile.readLine();
        } catch (IOException e) {
            QLog.e("CpuUsageMeasurer", "read line failed. " + e.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("\\s+");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        FileUtil.closeQuietly(this.mProcessStatFile);
        FileUtil.closeQuietly(this.mSystemStatFile);
        QLog.i("CpuUsageMeasurer", "measurer is released");
    }
}
