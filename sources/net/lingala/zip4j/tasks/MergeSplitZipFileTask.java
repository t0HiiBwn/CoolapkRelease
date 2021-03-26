package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

public class MergeSplitZipFileTask extends AsyncZipTask<MergeSplitZipFileTaskParameters> {
    private RawIO rawIO = new RawIO();
    private ZipModel zipModel;

    public MergeSplitZipFileTask(ZipModel zipModel2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00dc, code lost:
        r0.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e0, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A[Catch:{ all -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A[Catch:{ all -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x009a A[SYNTHETIC] */
    public void executeTask(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Throwable th2;
        int i;
        if (this.zipModel.isSplitArchive()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(mergeSplitZipFileTaskParameters.outputZipFile);
                int numberOfThisDisk = this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk();
                if (numberOfThisDisk > 0) {
                    long j = 0;
                    long j2 = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 <= numberOfThisDisk) {
                        RandomAccessFile createSplitZipFileStream = createSplitZipFileStream(this.zipModel, i3);
                        try {
                            long length = createSplitZipFileStream.length();
                            int i4 = 4;
                            if (i3 == 0) {
                                try {
                                    if (((long) this.rawIO.readIntLittleEndian(createSplitZipFileStream)) == HeaderSignature.SPLIT_ZIP.getValue()) {
                                        i = 4;
                                        if (i3 == numberOfThisDisk) {
                                            length = this.zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
                                        }
                                        long j3 = (long) i4;
                                        randomAccessFile = createSplitZipFileStream;
                                        FileUtils.copyFile(createSplitZipFileStream, fileOutputStream, j3, length, progressMonitor);
                                        long j4 = j2 + (length - j3);
                                        updateFileHeaderOffsetsForIndex(this.zipModel.getCentralDirectory().getFileHeaders(), i3 != 0 ? j : j4, i3, i);
                                        verifyIfTaskIsCancelled();
                                        if (randomAccessFile == null) {
                                            randomAccessFile.close();
                                        }
                                        i3++;
                                        j2 = j4;
                                        j = j;
                                        i2 = i;
                                    } else {
                                        createSplitZipFileStream.seek(j);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    randomAccessFile = createSplitZipFileStream;
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        th.addSuppressed(th4);
                                    }
                                }
                            }
                            i = i2;
                            i4 = 0;
                            if (i3 == numberOfThisDisk) {
                            }
                            long j3 = (long) i4;
                            randomAccessFile = createSplitZipFileStream;
                            try {
                                FileUtils.copyFile(createSplitZipFileStream, fileOutputStream, j3, length, progressMonitor);
                                long j4 = j2 + (length - j3);
                                updateFileHeaderOffsetsForIndex(this.zipModel.getCentralDirectory().getFileHeaders(), i3 != 0 ? j : j4, i3, i);
                                verifyIfTaskIsCancelled();
                                if (randomAccessFile == null) {
                                }
                                i3++;
                                j2 = j4;
                                j = j;
                                i2 = i;
                            } catch (Throwable th5) {
                                th2 = th5;
                                th = th2;
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            randomAccessFile = createSplitZipFileStream;
                            th = th2;
                            throw th;
                        }
                    }
                    updateHeadersForMergeSplitFileAction(this.zipModel, j2, fileOutputStream, mergeSplitZipFileTaskParameters.charset);
                    progressMonitor.endProgressMonitor();
                    fileOutputStream.close();
                    return;
                }
                throw new ZipException("zip archive not a split zip file");
            } catch (CloneNotSupportedException e) {
                throw new ZipException(e);
            }
        } else {
            ZipException zipException = new ZipException("archive not a split zip file");
            progressMonitor.endProgressMonitor(zipException);
            throw zipException;
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long j = 0;
        if (!this.zipModel.isSplitArchive()) {
            return 0;
        }
        for (int i = 0; i <= this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk(); i++) {
            j += getNextSplitZipFile(this.zipModel, i).length();
        }
        return j;
    }

    private void updateFileHeaderOffsetsForIndex(List<FileHeader> list, long j, int i, int i2) {
        for (FileHeader fileHeader : list) {
            if (fileHeader.getDiskNumberStart() == i) {
                fileHeader.setOffsetLocalHeader((fileHeader.getOffsetLocalHeader() + j) - ((long) i2));
                fileHeader.setDiskNumberStart(0);
            }
        }
    }

    private File getNextSplitZipFile(ZipModel zipModel2, int i) {
        if (i == zipModel2.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) {
            return zipModel2.getZipFile();
        }
        String str = i >= 9 ? ".z" : ".z0";
        String path = zipModel2.getZipFile().getPath();
        return new File(zipModel2.getZipFile().getPath().substring(0, path.lastIndexOf(".")) + str + (i + 1));
    }

    private RandomAccessFile createSplitZipFileStream(ZipModel zipModel2, int i) throws FileNotFoundException {
        return new RandomAccessFile(getNextSplitZipFile(zipModel2, i), RandomAccessFileMode.READ.getValue());
    }

    private void updateHeadersForMergeSplitFileAction(ZipModel zipModel2, long j, OutputStream outputStream, Charset charset) throws IOException, CloneNotSupportedException {
        ZipModel zipModel3 = (ZipModel) zipModel2.clone();
        zipModel3.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(j);
        updateSplitZipModel(zipModel3, j);
        new HeaderWriter().finalizeZipFileWithoutValidations(zipModel3, outputStream, charset);
    }

    private void updateSplitZipModel(ZipModel zipModel2, long j) {
        zipModel2.setSplitArchive(false);
        updateSplitEndCentralDirectory(zipModel2);
        if (zipModel2.isZip64Format()) {
            updateSplitZip64EndCentralDirLocator(zipModel2, j);
            updateSplitZip64EndCentralDirRec(zipModel2, j);
        }
    }

    private void updateSplitEndCentralDirectory(ZipModel zipModel2) {
        int size = zipModel2.getCentralDirectory().getFileHeaders().size();
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = zipModel2.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(0);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(size);
    }

    private void updateSplitZip64EndCentralDirLocator(ZipModel zipModel2, long j) {
        if (zipModel2.getZip64EndOfCentralDirectoryLocator() != null) {
            Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = zipModel2.getZip64EndOfCentralDirectoryLocator();
            zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
            zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord() + j);
            zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(1);
        }
    }

    private void updateSplitZip64EndCentralDirRec(ZipModel zipModel2, long j) {
        if (zipModel2.getZip64EndOfCentralDirectoryRecord() != null) {
            Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = zipModel2.getZip64EndOfCentralDirectoryRecord();
            zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(0);
            zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(0);
            zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk((long) zipModel2.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory());
            zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.MERGE_ZIP_FILES;
    }

    public static class MergeSplitZipFileTaskParameters extends AbstractZipTaskParameters {
        private File outputZipFile;

        public MergeSplitZipFileTaskParameters(File file, Charset charset) {
            super(charset);
            this.outputZipFile = file;
        }
    }
}
