package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0291, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0292, code lost:
        r20 = r5;
        r19 = r6;
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02d3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02d4, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0301, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0302, code lost:
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x030c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x030d, code lost:
        r17 = r2;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0312, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0313, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0321, code lost:
        r22.mUploadId = null;
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0333, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0333 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0334 A[EDGE_INSN: B:113:0x0334->B:99:0x0334 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01c7 A[Catch:{ ServiceException -> 0x030c, ClientException -> 0x0312 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0312 A[ExcHandler: ClientException (r0v47 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:39:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0321  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x032b A[LOOP:0: B:35:0x017f->B:97:0x032b, LOOP_END] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void initMultipartUploadId() throws IOException, ClientException, ServiceException {
        String str;
        Map map;
        char c;
        int i;
        int i2;
        Map map2;
        String str2;
        boolean z;
        List<PartSummary> parts;
        int i3;
        ClassNotFoundException e;
        String str3 = "[initUploadId] -  ";
        OSSCompletedCallback<ListPartsRequest, ListPartsResult> oSSCompletedCallback = null;
        if (!OSSUtils.isEmptyString(((ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
                OSSLog.logDebug("[initUploadId] - mUploadFilePath : " + this.mUploadUri.getPath());
                str = BinaryUtil.calculateMd5Str(this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r").getFileDescriptor());
            } else {
                OSSLog.logDebug("[initUploadId] - mUploadFilePath : " + this.mUploadFilePath);
                str = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            OSSLog.logDebug("[initUploadId] - mRequest.getPartSize() : " + ((ResumableUploadRequest) this.mRequest).getPartSize());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(((ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(String.valueOf(((ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            File file = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + BinaryUtil.calculateMd5Str(sb.toString().getBytes()));
            this.mRecordFile = file;
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
            }
            OSSLog.logDebug("[initUploadId] - mUploadId : " + this.mUploadId);
            if (!OSSUtils.isEmptyString(this.mUploadId)) {
                if (this.mCheckCRC64) {
                    File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                    if (file2.exists()) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file2));
                        try {
                            map = (Map) objectInputStream.readObject();
                            try {
                                file2.delete();
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                            }
                        } catch (ClassNotFoundException e3) {
                            e = e3;
                            map = null;
                            try {
                                OSSLog.logThrowable2Local(e);
                                objectInputStream.close();
                                file2.delete();
                                c = 0;
                                i = 0;
                                while (true) {
                                    ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                    if (i > 0) {
                                    }
                                    OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, oSSCompletedCallback);
                                    try {
                                        ListPartsResult result = listParts.getResult();
                                        z = result.isTruncated();
                                        i = result.getNextPartNumberMarker();
                                        parts = result.getParts();
                                        int i4 = this.mPartAttr[c];
                                        int i5 = this.mPartAttr[1];
                                        i3 = 0;
                                        while (i3 < parts.size()) {
                                        }
                                        str2 = str3;
                                        i2 = i;
                                        map2 = map;
                                    } catch (ServiceException e4) {
                                        ServiceException e5 = e4;
                                        str2 = str3;
                                        map2 = map;
                                        if (e5.getStatusCode() == 404) {
                                        }
                                    } catch (ClientException e6) {
                                    }
                                    listParts.waitUntilFinished();
                                    if (z) {
                                    }
                                    str3 = str2;
                                    map = map2;
                                    oSSCompletedCallback = null;
                                    c = 0;
                                }
                                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
                            } catch (Throwable th) {
                                objectInputStream.close();
                                file2.delete();
                                throw th;
                            }
                        }
                        objectInputStream.close();
                        file2.delete();
                        c = 0;
                        i = 0;
                        while (true) {
                            ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                            if (i > 0) {
                                listPartsRequest.setPartNumberMarker(Integer.valueOf(i));
                            }
                            OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, oSSCompletedCallback);
                            ListPartsResult result = listParts.getResult();
                            z = result.isTruncated();
                            i = result.getNextPartNumberMarker();
                            parts = result.getParts();
                            int i4 = this.mPartAttr[c];
                            int i5 = this.mPartAttr[1];
                            i3 = 0;
                            while (i3 < parts.size()) {
                                PartSummary partSummary = parts.get(i3);
                                PartETag partETag = new PartETag(partSummary.getPartNumber(), partSummary.getETag());
                                partETag.setPartSize(partSummary.getSize());
                                if (map != null && map.size() > 0 && map.containsKey(Integer.valueOf(partETag.getPartNumber()))) {
                                    partETag.setCRC64(((Long) map.get(Integer.valueOf(partETag.getPartNumber()))).longValue());
                                }
                                OSSLog.logDebug(str3 + i3 + " part.getPartNumber() : " + partSummary.getPartNumber());
                                OSSLog.logDebug(str3 + i3 + " part.getSize() : " + partSummary.getSize());
                                boolean z2 = partSummary.getPartNumber() == i5;
                                if (z2) {
                                    i2 = i;
                                    map2 = map;
                                    if (partSummary.getSize() != this.mLastPartSize) {
                                        throw new ClientException("current part size " + partSummary.getSize() + " setting is inconsistent with PartSize : " + i4 + " or lastPartSize : " + this.mLastPartSize);
                                    }
                                } else {
                                    i2 = i;
                                    map2 = map;
                                }
                                if (!z2) {
                                    str2 = str3;
                                    if (partSummary.getSize() != ((long) i4)) {
                                        throw new ClientException("current part size " + partSummary.getSize() + " setting is inconsistent with PartSize : " + i4 + " or lastPartSize : " + this.mLastPartSize);
                                    }
                                } else {
                                    str2 = str3;
                                }
                                this.mPartETags.add(partETag);
                                this.mUploadedLength += partSummary.getSize();
                                this.mAlreadyUploadIndex.add(Integer.valueOf(partSummary.getPartNumber()));
                                i3++;
                                str3 = str2;
                                map = map2;
                                i = i2;
                            }
                            str2 = str3;
                            i2 = i;
                            map2 = map;
                            listParts.waitUntilFinished();
                            if (z) {
                                break;
                            }
                            str3 = str2;
                            map = map2;
                            oSSCompletedCallback = null;
                            c = 0;
                        }
                    }
                }
                map = null;
                c = 0;
                i = 0;
                while (true) {
                    ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                    if (i > 0) {
                    }
                    OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, oSSCompletedCallback);
                    ListPartsResult result = listParts.getResult();
                    z = result.isTruncated();
                    i = result.getNextPartNumberMarker();
                    parts = result.getParts();
                    int i4 = this.mPartAttr[c];
                    int i5 = this.mPartAttr[1];
                    i3 = 0;
                    while (i3 < parts.size()) {
                    }
                    str2 = str3;
                    i2 = i;
                    map2 = map;
                    listParts.waitUntilFinished();
                    if (z) {
                    }
                    str3 = str2;
                    map = map2;
                    oSSCompletedCallback = null;
                    c = 0;
                }
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (OSSUtils.isEmptyString(this.mUploadId)) {
            this.mUploadId = this.mApiOperation.initMultipartUpload(new InitiateMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), ((ResumableUploadRequest) this.mRequest).getMetadata()), null).getResult().getUploadId();
            if (this.mRecordFile != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.mRecordFile));
                bufferedWriter.write(this.mUploadId);
                bufferedWriter.close();
            }
        }
        ((ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        final int i = this.mPartAttr[0];
        final int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength <= this.mFileLength) {
                long j2 = this.mUploadedLength;
                if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                    j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                }
                if (this.mProgressCallback != null) {
                    this.mProgressCallback.onProgress(this.mRequest, j2, this.mFileLength);
                }
                this.mSp.removeKey(this.mUploadId);
            } else {
                throw new ClientException("The uploading file is inconsistent with before");
            }
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (final int i3 = 0; i3 < i2; i3++) {
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) && this.mPoolExecutor != null) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                j += (long) i;
                this.mPoolExecutor.execute(new Runnable() {
                    /* class com.alibaba.sdk.android.oss.internal.ResumableUploadTask.AnonymousClass1 */

                    @Override // java.lang.Runnable
                    public void run() {
                        ResumableUploadTask.this.uploadPart(i3, i, i2);
                    }
                });
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = null;
        if (completeMultipartUploadResult != null) {
            resumableUploadResult = new ResumableUploadResult(completeMultipartUploadResult);
        }
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        releasePool();
        return resumableUploadResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void checkException() throws IOException, ServiceException, ClientException {
        Throwable th;
        IOException e;
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else if (this.mPartETags != null && this.mPartETags.size() > 0 && this.mCheckCRC64 && ((ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                HashMap hashMap = new HashMap();
                for (PartETag partETag : this.mPartETags) {
                    hashMap.put(Integer.valueOf(partETag.getPartNumber()), Long.valueOf(partETag.getCRC64()));
                }
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file2 = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + this.mUploadId);
                    this.mCRC64RecordFile = file2;
                    if (!file2.exists()) {
                        this.mCRC64RecordFile.createNewFile();
                    }
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(this.mCRC64RecordFile));
                    try {
                        objectOutputStream2.writeObject(hashMap);
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        e = e2;
                        objectOutputStream = objectOutputStream2;
                        try {
                            OSSLog.logThrowable2Local(e);
                            if (objectOutputStream != null) {
                            }
                            super.checkException();
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    OSSLog.logThrowable2Local(e);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    super.checkException();
                }
            }
        }
        super.checkException();
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            this.mUploadException = exc;
            OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
            if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                notifyMultipartThread();
            }
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }
}
