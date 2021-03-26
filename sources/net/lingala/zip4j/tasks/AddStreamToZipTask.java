package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.Zip4jUtil;

public class AddStreamToZipTask extends AbstractAddFileToZipTask<AddStreamToZipTaskParameters> {
    /* access modifiers changed from: protected */
    public long calculateTotalWork(AddStreamToZipTaskParameters addStreamToZipTaskParameters) {
        return 0;
    }

    public AddStreamToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b3, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b4, code lost:
        if (r0 != null) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bb, code lost:
        r6.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00be, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r6.addSuppressed(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        throw r0;
     */
    public void executeTask(AddStreamToZipTaskParameters addStreamToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        verifyZipParameters(addStreamToZipTaskParameters.zipParameters);
        if (Zip4jUtil.isStringNotNullAndNotEmpty(addStreamToZipTaskParameters.zipParameters.getFileNameInZip())) {
            removeFileIfExists(getZipModel(), addStreamToZipTaskParameters.charset, addStreamToZipTaskParameters.zipParameters.getFileNameInZip(), progressMonitor);
            addStreamToZipTaskParameters.zipParameters.setWriteExtendedLocalFileHeader(true);
            if (addStreamToZipTaskParameters.zipParameters.getCompressionMethod().equals(CompressionMethod.STORE)) {
                addStreamToZipTaskParameters.zipParameters.setEntrySize(0);
            }
            SplitOutputStream splitOutputStream = new SplitOutputStream(getZipModel().getZipFile(), getZipModel().getSplitLength());
            ZipOutputStream initializeOutputStream = initializeOutputStream(splitOutputStream, addStreamToZipTaskParameters.charset);
            byte[] bArr = new byte[4096];
            ZipParameters zipParameters = addStreamToZipTaskParameters.zipParameters;
            initializeOutputStream.putNextEntry(zipParameters);
            if (!zipParameters.getFileNameInZip().endsWith("/") && !zipParameters.getFileNameInZip().endsWith("\\")) {
                while (true) {
                    int read = addStreamToZipTaskParameters.inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    initializeOutputStream.write(bArr, 0, read);
                }
            }
            FileHeader closeEntry = initializeOutputStream.closeEntry();
            if (closeEntry.getCompressionMethod().equals(CompressionMethod.STORE)) {
                updateLocalFileHeader(closeEntry, splitOutputStream);
            }
            if (initializeOutputStream != null) {
                initializeOutputStream.close();
            }
            splitOutputStream.close();
            return;
        }
        throw new ZipException("fileNameInZip has to be set in zipParameters when adding stream");
    }

    private void removeFileIfExists(ZipModel zipModel, Charset charset, String str, ProgressMonitor progressMonitor) throws ZipException {
        FileHeader fileHeader = HeaderUtil.getFileHeader(zipModel, str);
        if (fileHeader != null) {
            removeFile(fileHeader, progressMonitor, charset);
        }
    }

    public static class AddStreamToZipTaskParameters extends AbstractZipTaskParameters {
        private InputStream inputStream;
        private ZipParameters zipParameters;

        public AddStreamToZipTaskParameters(InputStream inputStream2, ZipParameters zipParameters2, Charset charset) {
            super(charset);
            this.inputStream = inputStream2;
            this.zipParameters = zipParameters2;
        }
    }
}
