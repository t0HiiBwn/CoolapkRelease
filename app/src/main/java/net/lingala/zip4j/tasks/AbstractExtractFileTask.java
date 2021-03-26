package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.regex.Matcher;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractExtractFileTask<T> extends AsyncZipTask<T> {
    private byte[] buff = new byte[4096];
    private ZipModel zipModel;

    public AbstractExtractFileTask(ZipModel zipModel2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
    }

    protected void extractFile(ZipInputStream zipInputStream, FileHeader fileHeader, String str, String str2, ProgressMonitor progressMonitor) throws IOException {
        if (!str.endsWith(InternalZipConstants.FILE_SEPARATOR)) {
            str = str + InternalZipConstants.FILE_SEPARATOR;
        }
        File determineOutputFile = determineOutputFile(fileHeader, str, str2);
        progressMonitor.setFileName(determineOutputFile.getAbsolutePath());
        if (determineOutputFile.getCanonicalPath().startsWith(new File(str).getCanonicalPath() + File.separator)) {
            verifyNextEntry(zipInputStream, fileHeader);
            if (fileHeader.isDirectory()) {
                if (!determineOutputFile.exists() && !determineOutputFile.mkdirs()) {
                    throw new ZipException("Could not create directory: " + determineOutputFile);
                }
            } else if (isSymbolicLink(fileHeader)) {
                createSymLink(zipInputStream, fileHeader, determineOutputFile, progressMonitor);
            } else {
                checkOutputDirectoryStructure(determineOutputFile);
                unzipFile(zipInputStream, fileHeader, determineOutputFile, progressMonitor);
            }
        } else {
            throw new ZipException("illegal file name that breaks out of the target directory: " + fileHeader.getFileName());
        }
    }

    private boolean isSymbolicLink(FileHeader fileHeader) {
        byte[] externalFileAttributes = fileHeader.getExternalFileAttributes();
        if (externalFileAttributes == null || externalFileAttributes.length < 4) {
            return false;
        }
        return BitUtils.isBitSet(externalFileAttributes[3], 5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r5.addSuppressed(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        throw r6;
     */
    private void unzipFile(ZipInputStream zipInputStream, FileHeader fileHeader, File file, ProgressMonitor progressMonitor) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                int read = zipInputStream.read(this.buff);
                if (read != -1) {
                    fileOutputStream.write(this.buff, 0, read);
                    progressMonitor.updateWorkCompleted((long) read);
                    verifyIfTaskIsCancelled();
                } else {
                    fileOutputStream.close();
                    UnzipUtil.applyFileAttributes(fileHeader, file);
                    return;
                }
            }
        } catch (Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r4.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        throw r5;
     */
    private void createSymLink(ZipInputStream zipInputStream, FileHeader fileHeader, File file, ProgressMonitor progressMonitor) throws IOException {
        String str = new String(readCompleteEntry(zipInputStream, fileHeader, progressMonitor));
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            try {
                Files.createSymbolicLink(file.toPath(), Paths.get(str, new String[0]), new FileAttribute[0]);
                UnzipUtil.applyFileAttributes(fileHeader, file);
            } catch (NoSuchMethodError unused) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            }
        } else {
            throw new ZipException("Could not create parent directories");
        }
    }

    private byte[] readCompleteEntry(ZipInputStream zipInputStream, FileHeader fileHeader, ProgressMonitor progressMonitor) throws IOException {
        int uncompressedSize = (int) fileHeader.getUncompressedSize();
        byte[] bArr = new byte[uncompressedSize];
        if (zipInputStream.read(bArr) == uncompressedSize) {
            progressMonitor.updateWorkCompleted((long) uncompressedSize);
            return bArr;
        }
        throw new ZipException("Could not read complete entry");
    }

    private void verifyNextEntry(ZipInputStream zipInputStream, FileHeader fileHeader) throws IOException {
        if (!BitUtils.isBitSet(fileHeader.getGeneralPurposeFlag()[0], 6)) {
            LocalFileHeader nextEntry = zipInputStream.getNextEntry(fileHeader);
            if (nextEntry == null) {
                throw new ZipException("Could not read corresponding local file header for file header: " + fileHeader.getFileName());
            } else if (!fileHeader.getFileName().equals(nextEntry.getFileName())) {
                throw new ZipException("File header and local file header mismatch");
            }
        } else {
            throw new ZipException("Entry with name " + fileHeader.getFileName() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
    }

    private void checkOutputDirectoryStructure(File file) throws ZipException {
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new ZipException("Unable to create parent directories: " + file.getParentFile());
        }
    }

    private File determineOutputFile(FileHeader fileHeader, String str, String str2) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = getFileNameWithSystemFileSeparators(fileHeader.getFileName());
        }
        return new File(str + InternalZipConstants.FILE_SEPARATOR + str2);
    }

    private String getFileNameWithSystemFileSeparators(String str) {
        return str.replaceAll("[/\\\\]", Matcher.quoteReplacement(InternalZipConstants.FILE_SEPARATOR));
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    public ZipModel getZipModel() {
        return this.zipModel;
    }
}
