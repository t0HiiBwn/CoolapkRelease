package com.huawei.updatesdk.fileprovider;

import android.net.Uri;
import java.io.File;

interface a {
    Uri a(File file);

    File a(Uri uri);

    void a(String str, File file);
}
