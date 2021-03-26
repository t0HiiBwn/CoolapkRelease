package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.FileUtils;

abstract class AbstractModifyFileTask<T> extends AsyncZipTask<T> {
    AbstractModifyFileTask(AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
    }

    File getTemporaryFile(String str) {
        Random random = new Random();
        File file = new File(str + random.nextInt(10000));
        while (file.exists()) {
            file = new File(str + random.nextInt(10000));
        }
        return file;
    }

    void updateOffsetsForAllSubsequentFileHeaders(List<FileHeader> list, ZipModel zipModel, FileHeader fileHeader, long j) throws ZipException {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        if (indexOfFileHeader != -1) {
            while (true) {
                indexOfFileHeader++;
                if (indexOfFileHeader < list.size()) {
                    FileHeader fileHeader2 = list.get(indexOfFileHeader);
                    fileHeader2.setOffsetLocalHeader(fileHeader2.getOffsetLocalHeader() + j);
                    if (!(!zipModel.isZip64Format() || fileHeader2.getZip64ExtendedInfo() == null || fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() == -1)) {
                        fileHeader2.getZip64ExtendedInfo().setOffsetLocalHeader(fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() + j);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new ZipException("Could not locate modified file header in zipModel");
        }
    }

    void cleanupFile(boolean z, File file, File file2) throws ZipException {
        if (z) {
            restoreFileName(file, file2);
        } else if (!file2.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    long copyFile(RandomAccessFile randomAccessFile, OutputStream outputStream, long j, long j2, ProgressMonitor progressMonitor) throws IOException {
        FileUtils.copyFile(randomAccessFile, outputStream, j, j + j2, progressMonitor);
        return j2;
    }

    List<FileHeader> cloneAndSortFileHeadersByOffset(List<FileHeader> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.sort($$Lambda$AbstractModifyFileTask$Pb5YDsqiBqkvoAOriKWyPWYFZ8E.INSTANCE);
        return arrayList;
    }

    static /* synthetic */ int lambda$cloneAndSortFileHeadersByOffset$0(FileHeader fileHeader, FileHeader fileHeader2) {
        if (fileHeader.getFileName().equals(fileHeader2.getFileName())) {
            return 0;
        }
        return fileHeader.getOffsetLocalHeader() < fileHeader2.getOffsetLocalHeader() ? -1 : 1;
    }

    long getOffsetOfNextEntry(List<FileHeader> list, FileHeader fileHeader, ZipModel zipModel) throws ZipException {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        if (indexOfFileHeader == list.size() - 1) {
            return HeaderUtil.getOffsetStartOfCentralDirectory(zipModel);
        }
        return list.get(indexOfFileHeader + 1).getOffsetLocalHeader();
    }

    private void restoreFileName(File file, File file2) throws ZipException {
        if (!file.delete()) {
            throw new ZipException("cannot delete old zip file");
        } else if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }

    private int getIndexOfFileHeader(List<FileHeader> list, FileHeader fileHeader) throws ZipException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(fileHeader)) {
                return i;
            }
        }
        throw new ZipException("Could not find file header in list of central directory file headers");
    }
}
