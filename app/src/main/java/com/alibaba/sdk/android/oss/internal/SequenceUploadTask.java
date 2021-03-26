package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
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
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class SequenceUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public SequenceUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0174 A[Catch:{ ServiceException -> 0x01e1, ClientException -> 0x01df }] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    protected void initMultipartUploadId() throws IOException, ClientException, ServiceException {
        String str;
        Map map;
        int i;
        boolean z;
        List<PartSummary> parts;
        int i2;
        ClassNotFoundException e;
        if (!OSSUtils.isEmptyString(((ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
                str = BinaryUtil.calculateMd5Str(this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r").getFileDescriptor());
            } else {
                str = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(((ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(String.valueOf(((ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            sb.append("-sequence");
            File file = new File(((ResumableUploadRequest) this.mRequest).getRecordDirectory() + File.separator + BinaryUtil.calculateMd5Str(sb.toString().getBytes()));
            this.mRecordFile = file;
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
                OSSLog.logDebug("sequence [initUploadId] - Found record file, uploadid: " + this.mUploadId);
            }
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
                                i = 0;
                                do {
                                    ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                    if (i > 0) {
                                    }
                                    OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, null);
                                    try {
                                        ListPartsResult result = listParts.getResult();
                                        z = result.isTruncated();
                                        i = result.getNextPartNumberMarker();
                                        parts = result.getParts();
                                        while (i2 < parts.size()) {
                                        }
                                    } catch (ServiceException e4) {
                                        if (e4.getStatusCode() == 404) {
                                            this.mUploadId = null;
                                            z = false;
                                        } else {
                                            throw e4;
                                        }
                                    } catch (ClientException e5) {
                                        throw e5;
                                    }
                                    listParts.waitUntilFinished();
                                } while (z);
                                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
                            } catch (Throwable th) {
                                objectInputStream.close();
                                file2.delete();
                                throw th;
                            }
                        }
                        objectInputStream.close();
                        file2.delete();
                        i = 0;
                        do {
                            ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                            if (i > 0) {
                                listPartsRequest.setPartNumberMarker(Integer.valueOf(i));
                            }
                            OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, null);
                            ListPartsResult result = listParts.getResult();
                            z = result.isTruncated();
                            i = result.getNextPartNumberMarker();
                            parts = result.getParts();
                            for (i2 = 0; i2 < parts.size(); i2++) {
                                PartSummary partSummary = parts.get(i2);
                                PartETag partETag = new PartETag(partSummary.getPartNumber(), partSummary.getETag());
                                partETag.setPartSize(partSummary.getSize());
                                if (map != null && map.size() > 0 && map.containsKey(Integer.valueOf(partETag.getPartNumber()))) {
                                    partETag.setCRC64(((Long) map.get(Integer.valueOf(partETag.getPartNumber()))).longValue());
                                }
                                this.mPartETags.add(partETag);
                                this.mUploadedLength += partSummary.getSize();
                                this.mAlreadyUploadIndex.add(Integer.valueOf(partSummary.getPartNumber()));
                                if (i2 == 0) {
                                    this.mFirstPartSize = partSummary.getSize();
                                }
                            }
                            listParts.waitUntilFinished();
                        } while (z);
                    }
                }
                map = null;
                i = 0;
                do {
                    ListPartsRequest listPartsRequest = new ListPartsRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                    if (i > 0) {
                    }
                    OSSAsyncTask<ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, null);
                    ListPartsResult result = listParts.getResult();
                    z = result.isTruncated();
                    i = result.getNextPartNumberMarker();
                    parts = result.getParts();
                    while (i2 < parts.size()) {
                    }
                    listParts.waitUntilFinished();
                } while (z);
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (OSSUtils.isEmptyString(this.mUploadId)) {
            InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), ((ResumableUploadRequest) this.mRequest).getMetadata());
            initiateMultipartUploadRequest.isSequential = true;
            this.mUploadId = this.mApiOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult().getUploadId();
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
        int i = this.mPartAttr[0];
        int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength > this.mFileLength) {
                throw new ClientException("The uploading file is inconsistent with before");
            } else if (this.mFirstPartSize == ((long) i)) {
                long j2 = this.mUploadedLength;
                if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                    j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                }
                if (this.mProgressCallback != null) {
                    this.mProgressCallback.onProgress(this.mRequest, j2, this.mFileLength);
                }
                this.mSp.removeKey(this.mUploadId);
            } else {
                throw new ClientException("The part size setting is inconsistent with before");
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                OSSLog.logDebug("upload part readByte : " + i);
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
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
        return resumableUploadResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x013f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0147, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0163, code lost:
        processException(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0167, code lost:
        r2 = new com.alibaba.sdk.android.oss.model.PartETag(r1.getPartNumber(), r0.getPartEtag());
        r2.setPartSize((long) r1.getPartContent().length);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017f, code lost:
        if (r15.mCheckCRC64 != false) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0181, code lost:
        r2.setCRC64(new java.util.zip.CheckedInputStream(new java.io.ByteArrayInputStream(r1.getPartContent()), new com.alibaba.sdk.android.oss.common.utils.CRC64()).getChecksum().getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x019f, code lost:
        r15.mPartETags.add(r2);
        r15.mUploadedLength += (long) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ac, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b1, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b6, code lost:
        r11.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c7 A[Catch:{ IOException -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01cc A[Catch:{ IOException -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011b A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:32:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0163 A[Catch:{ all -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0167 A[Catch:{ all -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bf A[SYNTHETIC, Splitter:B:96:0x01bf] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPart(int i, int i2, int i3) {
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        Throwable th;
        RandomAccessFile randomAccessFile;
        ServiceException e;
        Exception e2;
        UploadPartRequest uploadPartRequest;
        BufferedInputStream bufferedInputStream2;
        UploadPartRequest uploadPartRequest2 = null;
        r1 = null;
        r1 = null;
        uploadPartRequest2 = null;
        uploadPartRequest2 = null;
        uploadPartRequest2 = null;
        r1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (!this.mContext.getCancellationHandler().isCancelled()) {
                this.mRunPartTaskCount++;
                preUploadPart(i, i2, i3);
                long partSize = ((long) i) * ((ResumableUploadRequest) this.mRequest).getPartSize();
                byte[] bArr = new byte[i2];
                if (this.mUploadUri != null) {
                    InputStream openInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                    try {
                        bufferedInputStream2 = new BufferedInputStream(openInputStream);
                    } catch (ServiceException e3) {
                        e = e3;
                        randomAccessFile = null;
                        bufferedInputStream = null;
                        inputStream = openInputStream;
                        try {
                            if (e.getStatusCode() == 409) {
                            }
                            if (randomAccessFile != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            if (randomAccessFile2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedInputStream = null;
                        inputStream = openInputStream;
                        try {
                            processException(e2);
                            if (randomAccessFile2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (randomAccessFile2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream = null;
                        inputStream = openInputStream;
                        if (randomAccessFile2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        bufferedInputStream2.skip(partSize);
                        bufferedInputStream2.read(bArr, 0, i2);
                        randomAccessFile = null;
                        bufferedInputStream = bufferedInputStream2;
                        inputStream = openInputStream;
                    } catch (ServiceException e5) {
                        e = e5;
                        randomAccessFile = null;
                        bufferedInputStream = bufferedInputStream2;
                        inputStream = openInputStream;
                        if (e.getStatusCode() == 409) {
                        }
                        if (randomAccessFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream == null) {
                        }
                    } catch (Exception e6) {
                        e2 = e6;
                        bufferedInputStream = bufferedInputStream2;
                        inputStream = openInputStream;
                        processException(e2);
                        if (randomAccessFile2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        inputStream = openInputStream;
                        if (randomAccessFile2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream != null) {
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
                    } catch (ServiceException e7) {
                        e = e7;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile = randomAccessFile3;
                        if (e.getStatusCode() == 409) {
                        }
                        if (randomAccessFile != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream == null) {
                        }
                    } catch (Exception e8) {
                        e2 = e8;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                        processException(e2);
                        if (randomAccessFile2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e9) {
                                OSSLog.logThrowable2Local(e9);
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                }
                try {
                    uploadPartRequest = new UploadPartRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i + 1);
                    uploadPartRequest.setPartContent(bArr);
                    uploadPartRequest.setMd5Digest(BinaryUtil.calculateBase64Md5(bArr));
                    uploadPartRequest.setCRC64(((ResumableUploadRequest) this.mRequest).getCRC64());
                    UploadPartResult syncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
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
                        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e10) {
                                OSSLog.logThrowable2Local(e10);
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            return;
                        }
                        return;
                    }
                    TaskCancelException taskCancelException = new TaskCancelException("sequence upload task cancel");
                    throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
                } catch (ServiceException e11) {
                    e = e11;
                    uploadPartRequest2 = uploadPartRequest;
                    if (e.getStatusCode() == 409) {
                    }
                    if (randomAccessFile != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (bufferedInputStream == null) {
                    }
                } catch (Exception e12) {
                }
            }
        } catch (ServiceException e13) {
            e = e13;
            randomAccessFile = null;
            inputStream = null;
            bufferedInputStream = null;
            if (e.getStatusCode() == 409) {
            }
            if (randomAccessFile != null) {
            }
            if (inputStream != null) {
            }
            if (bufferedInputStream == null) {
            }
        } catch (Exception e14) {
            e2 = e14;
            inputStream = null;
            bufferedInputStream = null;
            processException(e2);
            if (randomAccessFile2 != null) {
            }
            if (inputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedInputStream = null;
            if (randomAccessFile2 != null) {
            }
            if (inputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
            throw th;
        }
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
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        OSSLog.logThrowable2Local(exc);
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
            this.mIsCancel = true;
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
