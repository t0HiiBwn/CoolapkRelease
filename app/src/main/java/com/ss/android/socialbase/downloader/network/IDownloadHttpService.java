package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.c;
import java.io.IOException;
import java.util.List;

public interface IDownloadHttpService {
    i downloadWithConnection(int i, String str, List<c> list) throws IOException;
}
