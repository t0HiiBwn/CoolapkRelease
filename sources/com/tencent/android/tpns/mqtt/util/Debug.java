package com.tencent.android.tpns.mqtt.util;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Enumeration;
import java.util.Properties;

public class Debug {
    private static final String CLASS_NAME = "ClientComms";
    private static final String lineSep = System.getProperty("line.separator", "\n");
    private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientComms");
    private static final String separator = "==============";
    private String clientID;
    private ClientComms comms;

    public Debug(String str, ClientComms clientComms) {
        this.clientID = str;
        this.comms = clientComms;
        log.setResourceName(str);
    }

    public void dumpClientDebug() {
        dumpClientComms();
        dumpConOptions();
        dumpClientState();
        dumpBaseDebug();
    }

    public void dumpBaseDebug() {
        dumpVersion();
        dumpSystemProperties();
        dumpMemoryTrace();
    }

    protected void dumpMemoryTrace() {
        log.dumpTrace();
    }

    protected void dumpVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        String str = lineSep;
        sb.append(str);
        sb.append("==============");
        sb.append(" Version Info ");
        sb.append("==============");
        sb.append(str);
        stringBuffer.append(sb.toString());
        stringBuffer.append(left("Version", 20, ' ') + ":  " + ClientComms.VERSION + str);
        stringBuffer.append(left("Build Level", 20, ' ') + ":  " + ClientComms.BUILD_LEVEL + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==========================================");
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        log.fine("ClientComms", "dumpVersion", stringBuffer.toString());
    }

    public void dumpSystemProperties() {
        log.fine("ClientComms", "dumpSystemProperties", dumpProperties(System.getProperties(), "SystemProperties").toString());
    }

    public void dumpClientState() {
        ClientComms clientComms = this.comms;
        if (clientComms != null && clientComms.getClientState() != null) {
            Properties debug = this.comms.getClientState().getDebug();
            Logger logger = log;
            logger.fine("ClientComms", "dumpClientState", dumpProperties(debug, this.clientID + " : ClientState").toString());
        }
    }

    public void dumpClientComms() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getDebug();
            Logger logger = log;
            logger.fine("ClientComms", "dumpClientComms", dumpProperties(debug, this.clientID + " : ClientComms").toString());
        }
    }

    public void dumpConOptions() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            Properties debug = clientComms.getConOptions().getDebug();
            Logger logger = log;
            logger.fine("ClientComms", "dumpConOptions", dumpProperties(debug, this.clientID + " : Connect Options").toString());
        }
    }

    public static String dumpProperties(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = properties.propertyNames();
        StringBuilder sb = new StringBuilder();
        String str2 = lineSep;
        sb.append(str2);
        sb.append("==============");
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append("==============");
        sb.append(str2);
        stringBuffer.append(sb.toString());
        while (propertyNames.hasMoreElements()) {
            String str3 = (String) propertyNames.nextElement();
            stringBuffer.append(left(str3, 28, ' ') + ":  " + properties.get(str3) + lineSep);
        }
        stringBuffer.append("==========================================" + lineSep);
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c);
        }
    }
}
