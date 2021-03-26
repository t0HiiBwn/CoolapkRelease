package com.alibaba.wireless.security.open.middletier.fc;

import android.content.Context;
import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "sgmiddletier")
public interface IFCComponent extends IComponent {
    public static final String KEY_BX_SLEEP = "bx-sleep";
    public static final String KEY_RESEND_DATA = "key-resend-data";

    public enum ResponseHeaderType {
        KVO,
        KVL
    }

    String getFCPluginVersion() throws SecException;

    boolean needFCProcessOrNot(int i, HashMap hashMap, ResponseHeaderType responseHeaderType) throws SecException;

    void processFCContent(int i, HashMap hashMap, IFCActionCallback iFCActionCallback, ResponseHeaderType responseHeaderType) throws SecException;

    void setUp(Context context, HashMap hashMap) throws SecException;
}
