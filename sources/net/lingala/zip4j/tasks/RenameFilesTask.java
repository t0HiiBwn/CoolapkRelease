package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class RenameFilesTask extends AbstractModifyFileTask<RenameFilesTaskParameters> {
    private Charset charset;
    private HeaderWriter headerWriter;
    private RawIO rawIO;
    private ZipModel zipModel;

    public RenameFilesTask(ZipModel zipModel2, HeaderWriter headerWriter2, RawIO rawIO2, Charset charset2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
        this.headerWriter = headerWriter2;
        this.rawIO = rawIO2;
        this.charset = charset2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f8, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0100, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0106, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0107, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010b, code lost:
        throw r0;
     */
    public void executeTask(RenameFilesTaskParameters renameFilesTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        List<FileHeader> list;
        Map<String, String> filterNonExistingEntriesAndAddSeparatorIfNeeded = filterNonExistingEntriesAndAddSeparatorIfNeeded(renameFilesTaskParameters.fileNamesMap);
        if (filterNonExistingEntriesAndAddSeparatorIfNeeded.size() != 0) {
            File temporaryFile = getTemporaryFile(this.zipModel.getZipFile().getPath());
            boolean z = false;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.zipModel.getZipFile(), RandomAccessFileMode.WRITE.getValue());
                SplitOutputStream splitOutputStream = new SplitOutputStream(temporaryFile);
                List<FileHeader> cloneAndSortFileHeadersByOffset = cloneAndSortFileHeadersByOffset(this.zipModel.getCentralDirectory().getFileHeaders());
                long j = 0;
                for (FileHeader fileHeader : cloneAndSortFileHeadersByOffset) {
                    Map.Entry<String, String> correspondingEntryFromMap = getCorrespondingEntryFromMap(fileHeader, filterNonExistingEntriesAndAddSeparatorIfNeeded);
                    progressMonitor.setFileName(fileHeader.getFileName());
                    long offsetOfNextEntry = getOffsetOfNextEntry(cloneAndSortFileHeadersByOffset, fileHeader, this.zipModel) - splitOutputStream.getFilePointer();
                    if (correspondingEntryFromMap == null) {
                        j += copyFile(randomAccessFile, splitOutputStream, j, offsetOfNextEntry, progressMonitor);
                        list = cloneAndSortFileHeadersByOffset;
                    } else {
                        String newFileName = getNewFileName(correspondingEntryFromMap.getValue(), correspondingEntryFromMap.getKey(), fileHeader.getFileName());
                        byte[] bytes = newFileName.getBytes(this.charset);
                        list = cloneAndSortFileHeadersByOffset;
                        long copyEntryAndChangeFileName = copyEntryAndChangeFileName(bytes, fileHeader, j, offsetOfNextEntry, randomAccessFile, splitOutputStream, progressMonitor);
                        updateHeadersInZipModel(list, fileHeader, newFileName, bytes, bytes.length - fileHeader.getFileNameLength());
                        j = copyEntryAndChangeFileName;
                    }
                    verifyIfTaskIsCancelled();
                    cloneAndSortFileHeadersByOffset = list;
                }
                this.headerWriter.finalizeZipFile(this.zipModel, splitOutputStream, this.charset);
                z = true;
                splitOutputStream.close();
                randomAccessFile.close();
            } finally {
                cleanupFile(z, this.zipModel.getZipFile(), temporaryFile);
            }
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(RenameFilesTaskParameters renameFilesTaskParameters) {
        return this.zipModel.getZipFile().length();
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.RENAME_FILE;
    }

    private long copyEntryAndChangeFileName(byte[] bArr, FileHeader fileHeader, long j, long j2, RandomAccessFile randomAccessFile, OutputStream outputStream, ProgressMonitor progressMonitor) throws IOException {
        this.rawIO.writeShortLittleEndian(outputStream, bArr.length);
        long copyFile = j + copyFile(randomAccessFile, outputStream, j, 26, progressMonitor) + 2;
        outputStream.write(bArr);
        long copyFile2 = copyFile + copyFile(randomAccessFile, outputStream, copyFile, 2, progressMonitor) + ((long) fileHeader.getFileNameLength());
        return copyFile2 + copyFile(randomAccessFile, outputStream, copyFile2, j2 - (copyFile2 - j), progressMonitor);
    }

    private Map.Entry<String, String> getCorrespondingEntryFromMap(FileHeader fileHeader, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (fileHeader.getFileName().startsWith(entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    private void updateHeadersInZipModel(List<FileHeader> list, FileHeader fileHeader, String str, byte[] bArr, int i) throws ZipException {
        FileHeader fileHeader2 = HeaderUtil.getFileHeader(this.zipModel, fileHeader.getFileName());
        if (fileHeader2 != null) {
            fileHeader2.setFileName(str);
            fileHeader2.setFileNameLength(bArr.length);
            long j = (long) i;
            updateOffsetsForAllSubsequentFileHeaders(list, this.zipModel, fileHeader2, j);
            this.zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory() + j);
            if (this.zipModel.isZip64Format()) {
                this.zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
                this.zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() + j);
                return;
            }
            return;
        }
        throw new ZipException("could not find any header with name: " + fileHeader.getFileName());
    }

    private Map<String, String> filterNonExistingEntriesAndAddSeparatorIfNeeded(Map<String, String> map) throws ZipException {
        FileHeader fileHeader;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (Zip4jUtil.isStringNotNullAndNotEmpty(entry.getKey()) && (fileHeader = HeaderUtil.getFileHeader(this.zipModel, entry.getKey())) != null) {
                if (!fileHeader.isDirectory() || entry.getValue().endsWith("/")) {
                    hashMap.put(entry.getKey(), entry.getValue());
                } else {
                    String key = entry.getKey();
                    hashMap.put(key, entry.getValue() + "/");
                }
            }
        }
        return hashMap;
    }

    private String getNewFileName(String str, String str2, String str3) throws ZipException {
        if (str3.equals(str2)) {
            return str;
        }
        if (str3.startsWith(str2)) {
            String substring = str3.substring(str2.length());
            return str + substring;
        }
        throw new ZipException("old file name was neither an exact match nor a partial match");
    }

    public static class RenameFilesTaskParameters {
        private Map<String, String> fileNamesMap;

        public RenameFilesTaskParameters(Map<String, String> map) {
            this.fileNamesMap = map;
        }
    }
}
