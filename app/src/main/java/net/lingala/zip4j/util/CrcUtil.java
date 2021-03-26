package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public class CrcUtil {
    private static final int BUF_SIZE = 16384;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        throw r6;
     */
    public static long computeFileCrc(File file, ProgressMonitor progressMonitor) throws IOException {
        if (file == null || !file.exists() || !file.canRead()) {
            throw new ZipException("input file is null or does not exist or cannot read. Cannot calculate CRC for the file");
        }
        byte[] bArr = new byte[16384];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
                if (progressMonitor != null) {
                    progressMonitor.updateWorkCompleted((long) read);
                    if (progressMonitor.isCancelAllTasks()) {
                        progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
                        progressMonitor.setState(ProgressMonitor.State.READY);
                        fileInputStream.close();
                        return 0;
                    }
                }
            } else {
                long value = crc32.getValue();
                fileInputStream.close();
                return value;
            }
        }
    }
}
