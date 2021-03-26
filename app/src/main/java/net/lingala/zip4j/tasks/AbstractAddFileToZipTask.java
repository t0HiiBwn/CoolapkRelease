package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.CrcUtil;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractAddFileToZipTask<T> extends AsyncZipTask<T> {
    private HeaderWriter headerWriter;
    private char[] password;
    private byte[] readBuff = new byte[4096];
    private int readLen = -1;
    private ZipModel zipModel;

    AbstractAddFileToZipTask(ZipModel zipModel2, char[] cArr, HeaderWriter headerWriter2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
        this.password = cArr;
        this.headerWriter = headerWriter2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006f, code lost:
        if (r11 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        r8.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        r8.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
        throw r9;
     */
    void addFilesToZip(List<File> list, ProgressMonitor progressMonitor, ZipParameters zipParameters, Charset charset) throws IOException {
        FileUtils.assertFilesExist(list, zipParameters.getSymbolicLinkAction());
        List<File> removeFilesIfExists = removeFilesIfExists(list, zipParameters, progressMonitor, charset);
        SplitOutputStream splitOutputStream = new SplitOutputStream(this.zipModel.getZipFile(), this.zipModel.getSplitLength());
        ZipOutputStream initializeOutputStream = initializeOutputStream(splitOutputStream, charset);
        for (File file : removeFilesIfExists) {
            verifyIfTaskIsCancelled();
            ZipParameters cloneAndAdjustZipParameters = cloneAndAdjustZipParameters(zipParameters, file, progressMonitor);
            progressMonitor.setFileName(file.getAbsolutePath());
            if (FileUtils.isSymbolicLink(file) && addSymlink(cloneAndAdjustZipParameters)) {
                addSymlinkToZip(file, initializeOutputStream, cloneAndAdjustZipParameters, splitOutputStream);
                if (ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(cloneAndAdjustZipParameters.getSymbolicLinkAction())) {
                }
            }
            addFileToZip(file, initializeOutputStream, cloneAndAdjustZipParameters, splitOutputStream, progressMonitor);
        }
        if (initializeOutputStream != null) {
            initializeOutputStream.close();
        }
        splitOutputStream.close();
    }

    private void addSymlinkToZip(File file, ZipOutputStream zipOutputStream, ZipParameters zipParameters, SplitOutputStream splitOutputStream) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        zipParameters2.setFileNameInZip(replaceFileNameInZip(zipParameters.getFileNameInZip(), file.getName()));
        zipParameters2.setEncryptFiles(false);
        zipParameters2.setCompressionMethod(CompressionMethod.STORE);
        zipOutputStream.putNextEntry(zipParameters2);
        zipOutputStream.write(FileUtils.readSymbolicLink(file).getBytes());
        closeEntry(zipOutputStream, splitOutputStream, file, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r4.addSuppressed(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        throw r5;
     */
    private void addFileToZip(File file, ZipOutputStream zipOutputStream, ZipParameters zipParameters, SplitOutputStream splitOutputStream, ProgressMonitor progressMonitor) throws IOException {
        zipOutputStream.putNextEntry(zipParameters);
        if (!file.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(this.readBuff);
                this.readLen = read;
                if (read == -1) {
                    fileInputStream.close();
                    break;
                }
                zipOutputStream.write(this.readBuff, 0, read);
                progressMonitor.updateWorkCompleted((long) this.readLen);
                verifyIfTaskIsCancelled();
            }
        }
        closeEntry(zipOutputStream, splitOutputStream, file, false);
    }

    private void closeEntry(ZipOutputStream zipOutputStream, SplitOutputStream splitOutputStream, File file, boolean z) throws IOException {
        FileHeader closeEntry = zipOutputStream.closeEntry();
        byte[] fileAttributes = FileUtils.getFileAttributes(file);
        if (!z) {
            fileAttributes[3] = BitUtils.unsetBit(fileAttributes[3], 5);
        }
        closeEntry.setExternalFileAttributes(fileAttributes);
        updateLocalFileHeader(closeEntry, splitOutputStream);
    }

    long calculateWorkForFiles(List<File> list, ZipParameters zipParameters) throws ZipException {
        long j;
        long j2 = 0;
        for (File file : list) {
            if (file.exists()) {
                if (!zipParameters.isEncryptFiles() || zipParameters.getEncryptionMethod() != EncryptionMethod.ZIP_STANDARD) {
                    j = file.length();
                } else {
                    j = file.length() * 2;
                }
                j2 += j;
                FileHeader fileHeader = HeaderUtil.getFileHeader(getZipModel(), FileUtils.getRelativeFileName(file, zipParameters));
                if (fileHeader != null) {
                    j2 += getZipModel().getZipFile().length() - fileHeader.getCompressedSize();
                }
            }
        }
        return j2;
    }

    ZipOutputStream initializeOutputStream(SplitOutputStream splitOutputStream, Charset charset) throws IOException {
        if (this.zipModel.getZipFile().exists()) {
            splitOutputStream.seek(HeaderUtil.getOffsetStartOfCentralDirectory(this.zipModel));
        }
        return new ZipOutputStream(splitOutputStream, this.password, charset, this.zipModel);
    }

    void verifyZipParameters(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("cannot validate zip parameters");
        } else if (zipParameters.getCompressionMethod() != CompressionMethod.STORE && zipParameters.getCompressionMethod() != CompressionMethod.DEFLATE) {
            throw new ZipException("unsupported compression type");
        } else if (!zipParameters.isEncryptFiles()) {
            zipParameters.setEncryptionMethod(EncryptionMethod.NONE);
        } else if (zipParameters.getEncryptionMethod() != EncryptionMethod.NONE) {
            char[] cArr = this.password;
            if (cArr == null || cArr.length <= 0) {
                throw new ZipException("input password is empty or null");
            }
        } else {
            throw new ZipException("Encryption method has to be set, when encrypt files flag is set");
        }
    }

    void updateLocalFileHeader(FileHeader fileHeader, SplitOutputStream splitOutputStream) throws IOException {
        this.headerWriter.updateLocalFileHeader(fileHeader, getZipModel(), splitOutputStream);
    }

    private ZipParameters cloneAndAdjustZipParameters(ZipParameters zipParameters, File file, ProgressMonitor progressMonitor) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        zipParameters2.setLastModifiedFileTime(Zip4jUtil.epochToExtendedDosTime(file.lastModified()));
        if (file.isDirectory()) {
            zipParameters2.setEntrySize(0);
        } else {
            zipParameters2.setEntrySize(file.length());
        }
        zipParameters2.setWriteExtendedLocalFileHeader(false);
        zipParameters2.setLastModifiedFileTime(file.lastModified());
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getFileNameInZip())) {
            zipParameters2.setFileNameInZip(FileUtils.getRelativeFileName(file, zipParameters));
        }
        if (file.isDirectory()) {
            zipParameters2.setCompressionMethod(CompressionMethod.STORE);
            zipParameters2.setEncryptionMethod(EncryptionMethod.NONE);
            zipParameters2.setEncryptFiles(false);
        } else {
            if (zipParameters2.isEncryptFiles() && zipParameters2.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
                progressMonitor.setCurrentTask(ProgressMonitor.Task.CALCULATE_CRC);
                zipParameters2.setEntryCRC(CrcUtil.computeFileCrc(file, progressMonitor));
                progressMonitor.setCurrentTask(ProgressMonitor.Task.ADD_ENTRY);
            }
            if (file.length() == 0) {
                zipParameters2.setCompressionMethod(CompressionMethod.STORE);
            }
        }
        return zipParameters2;
    }

    private List<File> removeFilesIfExists(List<File> list, ZipParameters zipParameters, ProgressMonitor progressMonitor, Charset charset) throws ZipException {
        ArrayList arrayList = new ArrayList(list);
        if (!this.zipModel.getZipFile().exists()) {
            return arrayList;
        }
        for (File file : list) {
            FileHeader fileHeader = HeaderUtil.getFileHeader(this.zipModel, FileUtils.getRelativeFileName(file, zipParameters));
            if (fileHeader != null) {
                if (zipParameters.isOverrideExistingFilesInZip()) {
                    progressMonitor.setCurrentTask(ProgressMonitor.Task.REMOVE_ENTRY);
                    removeFile(fileHeader, progressMonitor, charset);
                    verifyIfTaskIsCancelled();
                    progressMonitor.setCurrentTask(ProgressMonitor.Task.ADD_ENTRY);
                } else {
                    arrayList.remove(file);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: net.lingala.zip4j.tasks.RemoveFilesFromZipTask */
    /* JADX WARN: Multi-variable type inference failed */
    void removeFile(FileHeader fileHeader, ProgressMonitor progressMonitor, Charset charset) throws ZipException {
        new RemoveFilesFromZipTask(this.zipModel, this.headerWriter, new AsyncZipTask.AsyncTaskParameters(null, false, progressMonitor)).execute(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(Collections.singletonList(fileHeader.getFileName()), charset));
    }

    private String replaceFileNameInZip(String str, String str2) {
        if (!str.contains("/")) {
            return str2;
        }
        return str.substring(0, str.lastIndexOf("/") + 1) + str2;
    }

    private boolean addSymlink(ZipParameters zipParameters) {
        return ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(zipParameters.getSymbolicLinkAction()) || ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE.equals(zipParameters.getSymbolicLinkAction());
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.ADD_ENTRY;
    }

    protected ZipModel getZipModel() {
        return this.zipModel;
    }
}
