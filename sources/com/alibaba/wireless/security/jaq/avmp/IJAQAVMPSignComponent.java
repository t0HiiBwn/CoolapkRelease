package com.alibaba.wireless.security.jaq.avmp;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.jaq.JAQException;

@InterfacePluginInfo(pluginName = "avmp")
public interface IJAQAVMPSignComponent {
    public static final int JAQ_SIGNTYPE_HMACSHA1 = 1;
    public static final int JAQ_SIGNTYPE_MWUA = 0;

    byte[] avmpSign(int i, byte[] bArr) throws JAQException;

    boolean initialize() throws JAQException;

    boolean uninitialize() throws JAQException;
}
