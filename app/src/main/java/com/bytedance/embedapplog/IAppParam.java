package com.bytedance.embedapplog;

import android.content.Context;
import java.util.HashMap;

public interface IAppParam {
    HashMap<String, String> getAppSSIDs(Context context);
}
