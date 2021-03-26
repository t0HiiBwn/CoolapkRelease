package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ExtractFileTask extends AbstractExtractFileTask<ExtractFileTaskParameters> {
    private char[] password;
    private SplitInputStream splitInputStream;

    public ExtractFileTask(ZipModel zipModel, char[] cArr, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, asyncTaskParameters);
        this.password = cArr;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r0 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        throw r10;
     */
    public void executeTask(ExtractFileTaskParameters extractFileTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        try {
            ZipInputStream createZipInputStream = createZipInputStream(extractFileTaskParameters.fileHeader, extractFileTaskParameters.charset);
            for (FileHeader fileHeader : getFileHeadersToExtract(extractFileTaskParameters.fileHeader)) {
                extractFile(createZipInputStream, fileHeader, extractFileTaskParameters.outputPath, determineNewFileName(extractFileTaskParameters.newFileName, extractFileTaskParameters.fileHeader, fileHeader), progressMonitor);
            }
            if (createZipInputStream != null) {
                createZipInputStream.close();
            }
        } finally {
            SplitInputStream splitInputStream2 = this.splitInputStream;
            if (splitInputStream2 != null) {
                splitInputStream2.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(ExtractFileTaskParameters extractFileTaskParameters) {
        return HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getFileHeadersToExtract(extractFileTaskParameters.fileHeader));
    }

    private List<FileHeader> getFileHeadersToExtract(FileHeader fileHeader) {
        if (!fileHeader.isDirectory()) {
            return Collections.singletonList(fileHeader);
        }
        return HeaderUtil.getFileHeadersUnderDirectory(getZipModel().getCentralDirectory().getFileHeaders(), fileHeader);
    }

    private ZipInputStream createZipInputStream(FileHeader fileHeader, Charset charset) throws IOException {
        SplitInputStream createSplitInputStream = UnzipUtil.createSplitInputStream(getZipModel());
        this.splitInputStream = createSplitInputStream;
        createSplitInputStream.prepareExtractionForFileHeader(fileHeader);
        return new ZipInputStream(this.splitInputStream, this.password, charset);
    }

    private String determineNewFileName(String str, FileHeader fileHeader, FileHeader fileHeader2) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str) || !fileHeader.isDirectory()) {
            return str;
        }
        String str2 = "/";
        if (str.endsWith(str2)) {
            str2 = "";
        }
        String fileName = fileHeader2.getFileName();
        String fileName2 = fileHeader.getFileName();
        return fileName.replaceFirst(fileName2, str + str2);
    }

    public static class ExtractFileTaskParameters extends AbstractZipTaskParameters {
        private FileHeader fileHeader;
        private String newFileName;
        private String outputPath;

        public ExtractFileTaskParameters(String str, FileHeader fileHeader2, String str2, Charset charset) {
            super(charset);
            this.outputPath = str;
            this.fileHeader = fileHeader2;
            this.newFileName = str2;
        }
    }
}
