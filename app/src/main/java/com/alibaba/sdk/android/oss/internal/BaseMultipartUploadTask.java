package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected Uri mUploadUri;
    protected long mUploadedLength;

    protected abstract void abortThisUpload();

    protected abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    protected abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    protected void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    protected abstract void processException(Exception exc);

    protected void uploadPartFinish(PartETag partETag) throws Exception {
    }

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(i, availableProcessors, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() {
            /* class com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.AnonymousClass1 */

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        boolean z = false;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES ? true : z;
    }

    protected void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof ClientException) {
                clientException = (ClientException) e2;
            } else {
                clientException = new ClientException(e2.toString(), e2);
            }
            OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    protected void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0;
            File file = new File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                parcelFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                this.mFileLength = parcelFileDescriptor.getStatSize();
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e) {
                        OSSLog.logThrowable2Local(e);
                    }
                }
            } catch (IOException e2) {
                throw new ClientException(e2.getMessage(), e2, true);
            } catch (Throwable th) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
                throw th;
            }
        }
        if (this.mFileLength != 0) {
            checkPartSize(this.mPartAttr);
            long partSize = this.mRequest.getPartSize();
            int i = this.mPartAttr[1];
            OSSLog.logDebug("[checkInitData] - partNumber : " + i);
            OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
            if (i > 1 && partSize < 102400) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016c A[SYNTHETIC, Splitter:B:89:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0174 A[Catch:{ IOException -> 0x0170 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0179 A[Catch:{ IOException -> 0x0170 }] */
    protected void uploadPart(int i, int i2, int i3) {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        Throwable th;
        Exception e;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (this.mContext.getCancellationHandler().isCancelled()) {
                this.mPoolExecutor.getQueue().clear();
                return;
            }
            synchronized (this.mLock) {
                this.mRunPartTaskCount++;
            }
            preUploadPart(i, i2, i3);
            byte[] bArr = new byte[i2];
            long partSize = ((long) i) * this.mRequest.getPartSize();
            if (this.mUploadUri != null) {
                InputStream openInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                try {
                    bufferedInputStream = new BufferedInputStream(openInputStream);
                    try {
                        bufferedInputStream.skip(partSize);
                        bufferedInputStream.read(bArr, 0, i2);
                        randomAccessFile = null;
                        inputStream = openInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = openInputStream;
                        try {
                            processException(e);
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = openInputStream;
                        if (randomAccessFile2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = null;
                    inputStream = openInputStream;
                    processException(e);
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                    inputStream = openInputStream;
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } else {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.mUploadFile, "r");
                try {
                    randomAccessFile3.seek(partSize);
                    randomAccessFile3.readFully(bArr, 0, i2);
                    inputStream = null;
                    bufferedInputStream = null;
                    randomAccessFile = randomAccessFile3;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    bufferedInputStream = null;
                    randomAccessFile2 = randomAccessFile3;
                    processException(e);
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    bufferedInputStream = null;
                    randomAccessFile2 = randomAccessFile3;
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
            try {
                UploadPartRequest uploadPartRequest = new UploadPartRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, i + 1);
                uploadPartRequest.setPartContent(bArr);
                uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                uploadPartRequest.setCRC64(this.mRequest.getCRC64());
                UploadPartResult syncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                synchronized (this.mLock) {
                    PartETag partETag = new PartETag(uploadPartRequest.getPartNumber(), syncUploadPart.getETag());
                    long j = (long) i2;
                    partETag.setPartSize(j);
                    if (this.mCheckCRC64) {
                        partETag.setCRC64(syncUploadPart.getClientCRC().longValue());
                    }
                    this.mPartETags.add(partETag);
                    this.mUploadedLength += j;
                    uploadPartFinish(partETag);
                    if (!this.mContext.getCancellationHandler().isCancelled()) {
                        if (this.mPartETags.size() == i3 - this.mPartExceptionCount) {
                            notifyMultipartThread();
                        }
                        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                    } else if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                        TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
                        throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                        OSSLog.logThrowable2Local(e5);
                        return;
                    }
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile2 = randomAccessFile;
                processException(e);
                if (randomAccessFile2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (inputStream != null) {
                }
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            inputStream = null;
            bufferedInputStream = null;
            processException(e);
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedInputStream = null;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e8) {
                    OSSLog.logThrowable2Local(e8);
                    throw th;
                }
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    protected CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                /* class com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.AnonymousClass2 */

                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    protected void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    protected void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            } else if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            } else if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            } else {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
        }
    }

    protected boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    protected void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    protected void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        int i = (int) (j / partSize);
        if (j % partSize != 0) {
            i++;
        }
        if (i == 1) {
            partSize = j;
        } else if (i > 5000) {
            partSize = j / ((long) 5000);
            i = 5000;
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = i;
        this.mRequest.setPartSize((long) i2);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + i);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
        long j2 = this.mFileLength % partSize;
        if (j2 != 0) {
            partSize = j2;
        }
        this.mLastPartSize = partSize;
    }

    protected void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }
}
