package com.pgl.sys.ces.out;

import android.content.Context;
import java.util.HashMap;

public interface ISdkLite {
    public static final int REGION_INTERNEL = 0;
    public static final int REGION_SINGAPOER = 2;
    public static final int REGION_UNSET = 255;
    public static final int REGION_USA_EAST = 3;

    void SetRegionType(int i);

    String debugEntry(Context context, int i);

    String onEvent();

    String pullSg();

    String pullVer(String str);

    void reportNow(String str);

    void setCustomInfo(HashMap<String, Object> hashMap);

    void setEfficientDebug(boolean z);

    void setParams(String str, String str2);
}
