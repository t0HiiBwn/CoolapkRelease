package com.coolapk.market.download;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.coolapk.market.model.Extra;
import com.coolapk.market.util.LogUtils;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class DownloadJob {
    public static final int STATE_DONE = 2;
    public static final int STATE_RUNNING = 1;
    public static final int STATE_WAIT = 0;
    private final Callback callback;
    private long currentLength;
    private final File downloadDir;
    private boolean downloadedBefore = false;
    private Extra extra;
    private String fileExtension;
    private String fileName;
    private boolean isCancelled = false;
    private final NetworkExecutor networkExecutor;
    private int state = 0;
    private final String storageeName;
    private File storeFile;
    private final File temporaryFile;
    private long totalLength;
    private final String uniqueFileName;
    private final String url;

    public interface Callback {
        void onProcess(DownloadJob downloadJob);
    }

    public DownloadJob(String str, String str2, String str3, Callback callback2, Extra extra2, NetworkExecutor networkExecutor2) {
        this.networkExecutor = networkExecutor2;
        this.url = str;
        this.callback = callback2;
        this.storageeName = str3;
        File file = new File(str2);
        this.downloadDir = file;
        String generateFileName = DownloadUtils.generateFileName(str);
        this.uniqueFileName = generateFileName;
        this.fileName = DownloadUtils.tryGetFileNameFromUrl(str, generateFileName);
        this.temporaryFile = new File(file, generateFileName + ".dl");
        this.extra = extra2;
        if (extra2.containsKey("RESUME_ON_ERROR")) {
            this.extra.put("RESUME_ON_ERROR", false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b8 A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bc A[Catch:{ all -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x022d A[Catch:{ all -> 0x0223 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x025f A[Catch:{ all -> 0x0223 }] */
    void run() throws Throwable {
        Throwable th;
        String str;
        DownloadResponse downloadResponse;
        boolean z;
        RandomAccessFile randomAccessFile;
        Throwable th2;
        byte[] bArr;
        boolean z2;
        long j;
        Callback callback2;
        int i = 1;
        int i2 = 0;
        LogUtils.v("Job is running, [%s]", this.fileName);
        this.state = 1;
        DownloadResponse downloadResponse2 = null;
        try {
            if (this.isCancelled) {
                LogUtils.v("Job is cancel before execute, [%s]", this.fileName);
                this.state = 2;
                return;
            }
            downloadResponse2 = this.networkExecutor.execute(Uri.parse(this.url).buildUpon().appendQueryParameter("resume_on_error", String.valueOf(this.extra.getBoolean("RESUME_ON_ERROR"))).appendQueryParameter("extra_analysis_data", this.extra.getString("EXTRA_ANALYSIS_DATA")).toString());
            try {
                this.extra.put("REDIRECT_URL", downloadResponse2.getUrl());
                if (!downloadResponse2.isSuccessful()) {
                    downloadResponse2.close();
                    throw new HttpException(downloadResponse2);
                } else if (this.isCancelled) {
                    LogUtils.v("Job is cancel after response, [%s]", this.fileName);
                    if (downloadResponse2 != null) {
                        downloadResponse2.close();
                    }
                    this.state = 2;
                } else {
                    String header = downloadResponse2.getHeader("Accept-Ranges");
                    String header2 = downloadResponse2.getHeader("Content-Range");
                    String fileName2 = downloadResponse2.getFileName();
                    if (!TextUtils.isEmpty(fileName2)) {
                        this.fileName = fileName2;
                    }
                    this.fileExtension = downloadResponse2.getFileExtension();
                    if (!TextUtils.isEmpty(this.storageeName)) {
                        str = this.storageeName;
                    } else {
                        str = this.uniqueFileName;
                    }
                    if (!TextUtils.isEmpty(this.fileExtension)) {
                        str = str + "." + this.fileExtension;
                    }
                    this.storeFile = new File(this.downloadDir, str);
                    if (this.downloadDir.exists() || this.downloadDir.mkdirs()) {
                        long contentLength = downloadResponse2.getContentLength();
                        int i3 = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                        if (i3 <= 0) {
                            LogUtils.w("Response doesn't present Content-Length!, [%s]", this.fileName);
                        }
                        long length = this.temporaryFile.length();
                        boolean equals = TextUtils.equals(header, "bytes");
                        if (!equals) {
                            equals = header2 != null && header2.startsWith("bytes");
                        }
                        if (equals) {
                            if (i3 <= 0) {
                                contentLength = Long.valueOf(header2.substring(header2.indexOf("/") + 1)).longValue() - Long.valueOf(header2.substring(header2.indexOf(" ") + 1, header2.indexOf("-"))).longValue();
                            }
                            contentLength += length;
                            if (!TextUtils.isEmpty(header2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("bytes ");
                                sb.append(length);
                                sb.append("-");
                                downloadResponse = downloadResponse2;
                                try {
                                    sb.append(contentLength - 1);
                                    String sb2 = sb.toString();
                                    LogUtils.d("The Content-Range Header Assume[%s] vs Real[%s], [%s]", sb2, header2, this.fileName);
                                    if (TextUtils.indexOf(header2, sb2) != -1) {
                                        this.currentLength = length;
                                        this.totalLength = contentLength;
                                        z = contentLength <= 0 && this.storeFile.length() == contentLength;
                                        this.downloadedBefore = z;
                                        if (!z) {
                                            this.currentLength = contentLength;
                                        } else {
                                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.temporaryFile, "rw");
                                            if (equals) {
                                                try {
                                                    randomAccessFile2.seek(length);
                                                } catch (Throwable th3) {
                                                    th2 = th3;
                                                    randomAccessFile = randomAccessFile2;
                                                    randomAccessFile.close();
                                                    throw th2;
                                                }
                                            } else {
                                                randomAccessFile2.setLength(0);
                                                length = 0;
                                            }
                                            InputStream byteStream = downloadResponse.getByteStream();
                                            byte[] bArr2 = new byte[6144];
                                            long j2 = length;
                                            long j3 = j2;
                                            long j4 = 0;
                                            while (true) {
                                                int read = byteStream.read(bArr2);
                                                if (read == -1) {
                                                    break;
                                                } else if (this.isCancelled) {
                                                    Object[] objArr = new Object[i];
                                                    objArr[i2] = this.fileName;
                                                    LogUtils.v("Job is cancel on running, [%s]", objArr);
                                                    break;
                                                } else {
                                                    randomAccessFile2.write(bArr2, i2, read);
                                                    long j5 = j2 + ((long) read);
                                                    this.currentLength = j5;
                                                    long uptimeMillis = SystemClock.uptimeMillis();
                                                    if (uptimeMillis - j4 > 1000) {
                                                        randomAccessFile = randomAccessFile2;
                                                        bArr = bArr2;
                                                        try {
                                                            if ((((float) (j5 - j3)) * 100.0f) / ((float) this.totalLength) >= 0.1f) {
                                                                z2 = true;
                                                                if (!z2) {
                                                                    if (contentLength != j5) {
                                                                        j = j5;
                                                                        j2 = j;
                                                                        randomAccessFile2 = randomAccessFile;
                                                                        bArr2 = bArr;
                                                                        i = 1;
                                                                        i2 = 0;
                                                                    }
                                                                }
                                                                j = j5;
                                                                LogUtils.d("Job process: [%s] %.2f%%, downloadedSize: %d, fileSize: %d", this.fileName, Float.valueOf((((float) j5) * 100.0f) / ((float) contentLength)), Long.valueOf(j5), Long.valueOf(contentLength));
                                                                callback2 = this.callback;
                                                                if (callback2 != null) {
                                                                    callback2.onProcess(this);
                                                                }
                                                                j3 = j;
                                                                j4 = uptimeMillis;
                                                                j2 = j;
                                                                randomAccessFile2 = randomAccessFile;
                                                                bArr2 = bArr;
                                                                i = 1;
                                                                i2 = 0;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th2 = th4;
                                                            randomAccessFile.close();
                                                            throw th2;
                                                        }
                                                    } else {
                                                        randomAccessFile = randomAccessFile2;
                                                        bArr = bArr2;
                                                    }
                                                    z2 = false;
                                                    if (!z2) {
                                                    }
                                                    j = j5;
                                                    LogUtils.d("Job process: [%s] %.2f%%, downloadedSize: %d, fileSize: %d", this.fileName, Float.valueOf((((float) j5) * 100.0f) / ((float) contentLength)), Long.valueOf(j5), Long.valueOf(contentLength));
                                                    callback2 = this.callback;
                                                    if (callback2 != null) {
                                                    }
                                                    j3 = j;
                                                    j4 = uptimeMillis;
                                                    j2 = j;
                                                    randomAccessFile2 = randomAccessFile;
                                                    bArr2 = bArr;
                                                    i = 1;
                                                    i2 = 0;
                                                }
                                            }
                                            randomAccessFile2.close();
                                        }
                                        if (!this.isCancelled) {
                                            LogUtils.v("Job is cancel, [%s]", this.fileName);
                                            if (downloadResponse != null) {
                                                downloadResponse.close();
                                            }
                                            this.state = 2;
                                            return;
                                        }
                                        LogUtils.v("Job is downloaded complete, [%s]", this.fileName);
                                        if (!this.downloadedBefore) {
                                            if (!this.temporaryFile.canRead() || this.temporaryFile.length() <= 0) {
                                                throw new DownloadException("Download temporary file was invalid!");
                                            } else if (this.temporaryFile.renameTo(this.storeFile)) {
                                                LogUtils.i("Success to rename! %s, [%s]", this.fileName, this.storeFile.getPath());
                                            } else {
                                                throw new DownloadException("Can't rename the download temporary file!");
                                            }
                                        }
                                        if (downloadResponse != null) {
                                            downloadResponse.close();
                                        }
                                        this.state = 2;
                                        return;
                                    }
                                    LogUtils.w("The Content-Range Header is invalid Assume[%s] vs Real[%s], please remove the temporary file [%s].", sb2, header2, this.temporaryFile);
                                    throw new DownloadException(1);
                                } catch (Throwable th5) {
                                    th = th5;
                                    downloadResponse2 = downloadResponse;
                                    if (downloadResponse2 != null) {
                                    }
                                    this.state = 2;
                                    throw th;
                                }
                            }
                        }
                        downloadResponse = downloadResponse2;
                        this.currentLength = length;
                        this.totalLength = contentLength;
                        if (contentLength <= 0) {
                        }
                        this.downloadedBefore = z;
                        if (!z) {
                        }
                        if (!this.isCancelled) {
                        }
                    } else {
                        throw new DownloadException(2);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (downloadResponse2 != null) {
                    downloadResponse2.close();
                }
                this.state = 2;
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            if (downloadResponse2 != null) {
            }
            this.state = 2;
            throw th;
        }
    }

    void markCancel() {
        this.isCancelled = true;
    }

    public long getCurrentLength() {
        return this.currentLength;
    }

    public long getTotalLength() {
        return this.totalLength;
    }

    public File getStoreFile() {
        return this.storeFile;
    }

    public File getTemporaryFile() {
        return this.temporaryFile;
    }

    public String getFileName() {
        return this.fileName;
    }

    public boolean isDownloadedBefore() {
        return this.downloadedBefore;
    }

    public String getUrl() {
        return this.url;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public boolean isWait() {
        return this.state == 0;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public boolean isAdded() {
        int i = this.state;
        return i == 0 || i == 1;
    }

    public boolean isRunning() {
        return this.state == 1;
    }

    public boolean isDone() {
        return this.state == 2;
    }

    public Extra getExtra() {
        if (this.extra == null) {
            this.extra = new Extra();
        }
        return this.extra;
    }
}
