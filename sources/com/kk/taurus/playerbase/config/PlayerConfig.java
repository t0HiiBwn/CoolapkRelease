package com.kk.taurus.playerbase.config;

import androidx.collection.SparseArrayCompat;
import com.kk.taurus.playerbase.entity.DecoderPlan;
import com.kk.taurus.playerbase.player.SysMediaPlayer;

public class PlayerConfig {
    public static final int DEFAULT_PLAN_ID = 0;
    private static int defaultPlanId;
    private static SparseArrayCompat<DecoderPlan> mPlans = new SparseArrayCompat<>(2);
    private static boolean useDefaultNetworkEventProducer;

    static {
        addDecoderPlan(new DecoderPlan(0, SysMediaPlayer.class.getName(), "MediaPlayer"));
        setDefaultPlanId(0);
    }

    public static void addDecoderPlan(DecoderPlan decoderPlan) {
        mPlans.put(decoderPlan.getIdNumber(), decoderPlan);
    }

    public static void setDefaultPlanId(int i) {
        defaultPlanId = i;
    }

    public static int getDefaultPlanId() {
        return defaultPlanId;
    }

    public static DecoderPlan getDefaultPlan() {
        return getPlan(defaultPlanId);
    }

    public static DecoderPlan getPlan(int i) {
        return mPlans.get(i);
    }

    public static boolean isLegalPlanId(int i) {
        return getPlan(i) != null;
    }

    public static void setUseDefaultNetworkEventProducer(boolean z) {
        useDefaultNetworkEventProducer = z;
    }

    public static boolean isUseDefaultNetworkEventProducer() {
        return useDefaultNetworkEventProducer;
    }
}
