package com.kepler.jd.Listener;

import android.os.Bundle;

public interface OpenIDCallBck {
    boolean onDateCall(int i, Bundle bundle);

    boolean onErrCall(int i, String str);
}
