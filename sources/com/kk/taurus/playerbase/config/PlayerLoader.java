package com.kk.taurus.playerbase.config;

import com.kk.taurus.playerbase.player.BaseInternalPlayer;
import java.lang.reflect.Constructor;

public class PlayerLoader {
    public static BaseInternalPlayer loadInternalPlayer(int i) {
        try {
            Object decoderInstance = getDecoderInstance(i);
            if (decoderInstance instanceof BaseInternalPlayer) {
                return (BaseInternalPlayer) decoderInstance;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getDecoderInstance(int i) {
        Constructor constructor;
        try {
            Class sDKClass = getSDKClass(PlayerConfig.getPlan(i).getClassPath());
            if (sDKClass == null || (constructor = getConstructor(sDKClass)) == null) {
                return null;
            }
            return constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Constructor getConstructor(Class cls) {
        try {
            return cls.getConstructor(new Class[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class getSDKClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
