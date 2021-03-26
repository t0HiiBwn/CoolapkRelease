package net.lingala.zip4j.io.outputstream;

import java.io.IOException;

public interface OutputStreamWithSplitZipSupport {
    int getCurrentSplitFileCounter();

    long getFilePointer() throws IOException;
}
