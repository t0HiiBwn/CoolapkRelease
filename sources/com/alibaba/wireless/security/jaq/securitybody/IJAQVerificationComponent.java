package com.alibaba.wireless.security.jaq.securitybody;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.open.IComponent;
import java.util.HashMap;

@InterfacePluginInfo(pluginName = "securitybody")
public interface IJAQVerificationComponent extends IComponent {
    String doJAQVerfificationSync(HashMap<String, String> hashMap, int i) throws JAQException;
}
