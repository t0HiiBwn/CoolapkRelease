package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;

public interface DFA {
    void loadGDTApk();

    void startInstall(Context context, GDTApk gDTApk);
}
