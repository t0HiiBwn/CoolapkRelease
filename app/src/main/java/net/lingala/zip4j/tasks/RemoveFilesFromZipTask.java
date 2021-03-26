package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class RemoveFilesFromZipTask extends AbstractModifyFileTask<RemoveFilesFromZipTaskParameters> {
    private HeaderWriter headerWriter;
    private ZipModel zipModel;

    public RemoveFilesFromZipTask(ZipModel zipModel2, HeaderWriter headerWriter2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
        this.headerWriter = headerWriter2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c8, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00db, code lost:
        throw r0;
     */
    public void executeTask(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        if (!this.zipModel.isSplitArchive()) {
            List<String> filterNonExistingEntries = filterNonExistingEntries(removeFilesFromZipTaskParameters.filesToRemove);
            if (!filterNonExistingEntries.isEmpty()) {
                File temporaryFile = getTemporaryFile(this.zipModel.getZipFile().getPath());
                boolean z = false;
                try {
                    SplitOutputStream splitOutputStream = new SplitOutputStream(temporaryFile);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.zipModel.getZipFile(), RandomAccessFileMode.READ.getValue());
                    List<FileHeader> cloneAndSortFileHeadersByOffset = cloneAndSortFileHeadersByOffset(this.zipModel.getCentralDirectory().getFileHeaders());
                    long j = 0;
                    for (FileHeader fileHeader : cloneAndSortFileHeadersByOffset) {
                        long offsetOfNextEntry = getOffsetOfNextEntry(cloneAndSortFileHeadersByOffset, fileHeader, this.zipModel) - splitOutputStream.getFilePointer();
                        if (shouldEntryBeRemoved(fileHeader, filterNonExistingEntries)) {
                            updateHeaders(cloneAndSortFileHeadersByOffset, fileHeader, offsetOfNextEntry);
                            if (this.zipModel.getCentralDirectory().getFileHeaders().remove(fileHeader)) {
                                j += offsetOfNextEntry;
                            } else {
                                throw new ZipException("Could not remove entry from list of central directory headers");
                            }
                        } else {
                            j += super.copyFile(randomAccessFile, splitOutputStream, j, offsetOfNextEntry, progressMonitor);
                        }
                        verifyIfTaskIsCancelled();
                    }
                    this.headerWriter.finalizeZipFile(this.zipModel, splitOutputStream, removeFilesFromZipTaskParameters.charset);
                    z = true;
                    randomAccessFile.close();
                    splitOutputStream.close();
                } finally {
                    cleanupFile(z, this.zipModel.getZipFile(), temporaryFile);
                }
            }
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters) {
        return this.zipModel.getZipFile().length();
    }

    private List<String> filterNonExistingEntries(List<String> list) throws ZipException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (HeaderUtil.getFileHeader(this.zipModel, str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private boolean shouldEntryBeRemoved(FileHeader fileHeader, List<String> list) {
        for (String str : list) {
            if (fileHeader.getFileName().startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private void updateHeaders(List<FileHeader> list, FileHeader fileHeader, long j) throws ZipException {
        updateOffsetsForAllSubsequentFileHeaders(list, this.zipModel, fileHeader, negate(j));
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory() - j);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory() - 1);
        if (endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() > 0) {
            endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() - 1);
        }
        if (this.zipModel.isZip64Format()) {
            this.zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() - j);
            this.zipModel.getZip64EndOfCentralDirectoryRecord().setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(this.zipModel.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() - 1);
            this.zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() - j);
        }
    }

    private long negate(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("long overflow");
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.REMOVE_ENTRY;
    }

    public static class RemoveFilesFromZipTaskParameters extends AbstractZipTaskParameters {
        private List<String> filesToRemove;

        public RemoveFilesFromZipTaskParameters(List<String> list, Charset charset) {
            super(charset);
            this.filesToRemove = list;
        }
    }
}
