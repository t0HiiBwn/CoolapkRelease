package net.lingala.zip4j.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.NumberedSplitInputStream;
import net.lingala.zip4j.io.inputstream.SplitInputStream;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.io.inputstream.ZipStandardSplitInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;

public class UnzipUtil {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    public static ZipInputStream createZipInputStream(ZipModel zipModel, FileHeader fileHeader, char[] cArr) throws IOException {
        IOException e;
        SplitInputStream splitInputStream;
        try {
            splitInputStream = createSplitInputStream(zipModel);
            try {
                splitInputStream.prepareExtractionForFileHeader(fileHeader);
                ZipInputStream zipInputStream = new ZipInputStream(splitInputStream, cArr);
                if (zipInputStream.getNextEntry(fileHeader) != null) {
                    return zipInputStream;
                }
                throw new ZipException("Could not locate local file header for corresponding file header");
            } catch (IOException e2) {
                e = e2;
                if (splitInputStream != null) {
                    splitInputStream.close();
                }
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            splitInputStream = null;
            if (splitInputStream != null) {
            }
            throw e;
        }
    }

    public static void applyFileAttributes(FileHeader fileHeader, File file) {
        try {
            Path path = file.toPath();
            FileUtils.setFileAttributes(path, fileHeader.getExternalFileAttributes());
            FileUtils.setFileLastModifiedTime(path, fileHeader.getLastModifiedTime());
        } catch (NoSuchMethodError unused) {
            FileUtils.setFileLastModifiedTimeWithoutNio(file, fileHeader.getLastModifiedTime());
        }
    }

    public static SplitInputStream createSplitInputStream(ZipModel zipModel) throws IOException {
        if (zipModel.getZipFile().getName().endsWith(".zip.001")) {
            return new NumberedSplitInputStream(zipModel.getZipFile(), true, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        }
        return new ZipStandardSplitInputStream(zipModel.getZipFile(), zipModel.isSplitArchive(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
    }
}
