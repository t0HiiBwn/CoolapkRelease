package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.UnzipUtil;

public class ExtractAllFilesTask extends AbstractExtractFileTask<ExtractAllFilesTaskParameters> {
    private char[] password;
    private SplitInputStream splitInputStream;

    public ExtractAllFilesTask(ZipModel zipModel, char[] cArr, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, asyncTaskParameters);
        this.password = cArr;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (r0 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        throw r10;
     */
    public void executeTask(ExtractAllFilesTaskParameters extractAllFilesTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        try {
            ZipInputStream prepareZipInputStream = prepareZipInputStream(extractAllFilesTaskParameters.charset);
            for (FileHeader fileHeader : getZipModel().getCentralDirectory().getFileHeaders()) {
                if (fileHeader.getFileName().startsWith("__MACOSX")) {
                    progressMonitor.updateWorkCompleted(fileHeader.getUncompressedSize());
                } else {
                    this.splitInputStream.prepareExtractionForFileHeader(fileHeader);
                    extractFile(prepareZipInputStream, fileHeader, extractAllFilesTaskParameters.outputPath, null, progressMonitor);
                    verifyIfTaskIsCancelled();
                }
            }
            if (prepareZipInputStream != null) {
                prepareZipInputStream.close();
            }
            SplitInputStream splitInputStream2 = this.splitInputStream;
            if (splitInputStream2 != null) {
                splitInputStream2.close();
            }
        } catch (Throwable th) {
            SplitInputStream splitInputStream3 = this.splitInputStream;
            if (splitInputStream3 != null) {
                splitInputStream3.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(ExtractAllFilesTaskParameters extractAllFilesTaskParameters) {
        return HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getZipModel().getCentralDirectory().getFileHeaders());
    }

    private ZipInputStream prepareZipInputStream(Charset charset) throws IOException {
        this.splitInputStream = UnzipUtil.createSplitInputStream(getZipModel());
        FileHeader firstFileHeader = getFirstFileHeader(getZipModel());
        if (firstFileHeader != null) {
            this.splitInputStream.prepareExtractionForFileHeader(firstFileHeader);
        }
        return new ZipInputStream(this.splitInputStream, this.password, charset);
    }

    private FileHeader getFirstFileHeader(ZipModel zipModel) {
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() == 0) {
            return null;
        }
        return zipModel.getCentralDirectory().getFileHeaders().get(0);
    }

    public static class ExtractAllFilesTaskParameters extends AbstractZipTaskParameters {
        private String outputPath;

        public ExtractAllFilesTaskParameters(String str, Charset charset) {
            super(charset);
            this.outputPath = str;
        }
    }
}
