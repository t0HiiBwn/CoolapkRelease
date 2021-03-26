package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.FileUtils;

public class AddFolderToZipTask extends AbstractAddFileToZipTask<AddFolderToZipTaskParameters> {
    public AddFolderToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    public void executeTask(AddFolderToZipTaskParameters addFolderToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        List<File> filesToAdd = getFilesToAdd(addFolderToZipTaskParameters);
        setDefaultFolderPath(addFolderToZipTaskParameters);
        addFilesToZip(filesToAdd, progressMonitor, addFolderToZipTaskParameters.zipParameters, addFolderToZipTaskParameters.charset);
    }

    /* access modifiers changed from: protected */
    public long calculateTotalWork(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws ZipException {
        List<File> filesInDirectoryRecursive = FileUtils.getFilesInDirectoryRecursive(addFolderToZipTaskParameters.folderToAdd, addFolderToZipTaskParameters.zipParameters.isReadHiddenFiles(), addFolderToZipTaskParameters.zipParameters.isReadHiddenFolders(), addFolderToZipTaskParameters.zipParameters.getExcludeFileFilter());
        if (addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder()) {
            filesInDirectoryRecursive.add(addFolderToZipTaskParameters.folderToAdd);
        }
        return calculateWorkForFiles(filesInDirectoryRecursive, addFolderToZipTaskParameters.zipParameters);
    }

    private void setDefaultFolderPath(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws IOException {
        String str;
        File file = addFolderToZipTaskParameters.folderToAdd;
        if (!addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder()) {
            str = file.getCanonicalPath();
        } else if (file.getCanonicalFile().getParentFile() == null) {
            str = file.getCanonicalPath();
        } else {
            str = file.getCanonicalFile().getParentFile().getCanonicalPath();
        }
        addFolderToZipTaskParameters.zipParameters.setDefaultFolderPath(str);
    }

    private List<File> getFilesToAdd(AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws ZipException {
        List<File> filesInDirectoryRecursive = FileUtils.getFilesInDirectoryRecursive(addFolderToZipTaskParameters.folderToAdd, addFolderToZipTaskParameters.zipParameters.isReadHiddenFiles(), addFolderToZipTaskParameters.zipParameters.isReadHiddenFolders(), addFolderToZipTaskParameters.zipParameters.getExcludeFileFilter());
        if (addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder()) {
            filesInDirectoryRecursive.add(addFolderToZipTaskParameters.folderToAdd);
        }
        return filesInDirectoryRecursive;
    }

    public static class AddFolderToZipTaskParameters extends AbstractZipTaskParameters {
        private File folderToAdd;
        private ZipParameters zipParameters;

        public AddFolderToZipTaskParameters(File file, ZipParameters zipParameters2, Charset charset) {
            super(charset);
            this.folderToAdd = file;
            this.zipParameters = zipParameters2;
        }
    }
}
