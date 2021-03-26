package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class SetCommentTask extends AsyncZipTask<SetCommentTaskTaskParameters> {
    private ZipModel zipModel;

    /* access modifiers changed from: protected */
    public long calculateTotalWork(SetCommentTaskTaskParameters setCommentTaskTaskParameters) {
        return 0;
    }

    public SetCommentTask(ZipModel zipModel2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        throw r5;
     */
    public void executeTask(SetCommentTaskTaskParameters setCommentTaskTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        if (setCommentTaskTaskParameters.comment != null) {
            EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
            endOfCentralDirectoryRecord.setComment(setCommentTaskTaskParameters.comment);
            SplitOutputStream splitOutputStream = new SplitOutputStream(this.zipModel.getZipFile());
            if (this.zipModel.isZip64Format()) {
                splitOutputStream.seek(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber());
            } else {
                splitOutputStream.seek(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory());
            }
            new HeaderWriter().finalizeZipFileWithoutValidations(this.zipModel, splitOutputStream, setCommentTaskTaskParameters.charset);
            splitOutputStream.close();
            return;
        }
        throw new ZipException("comment is null, cannot update Zip file with comment");
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.SET_COMMENT;
    }

    public static class SetCommentTaskTaskParameters extends AbstractZipTaskParameters {
        private String comment;

        public SetCommentTaskTaskParameters(String str, Charset charset) {
            super(charset);
            this.comment = str;
        }
    }
}
