package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;

public class SimulatorDetect {
    private Context context;

    public SimulatorDetect(Context context2) {
        if (context2 != null) {
            this.context = context2.getApplicationContext();
        }
    }

    public boolean isSimulator() throws JAQException {
        try {
            ISimulatorDetectComponent simulatorDetectComp = SecurityGuardManager.getInstance(this.context).getSimulatorDetectComp();
            if (simulatorDetectComp != null) {
                return simulatorDetectComp.isSimulator();
            }
            throw new SecException(1598);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
