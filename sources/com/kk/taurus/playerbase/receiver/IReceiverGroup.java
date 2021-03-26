package com.kk.taurus.playerbase.receiver;

import java.util.Comparator;

public interface IReceiverGroup {

    public interface OnGroupValueUpdateListener {
        String[] filterKeys();

        void onValueUpdate(String str, Object obj);
    }

    public interface OnLoopListener {
        void onEach(IReceiver iReceiver);
    }

    public interface OnReceiverFilter {
        boolean filter(IReceiver iReceiver);
    }

    public interface OnReceiverGroupChangeListener {
        void onReceiverAdd(String str, IReceiver iReceiver);

        void onReceiverRemove(String str, IReceiver iReceiver);
    }

    void addOnReceiverGroupChangeListener(OnReceiverGroupChangeListener onReceiverGroupChangeListener);

    void addReceiver(String str, IReceiver iReceiver);

    void clearReceivers();

    void forEach(OnLoopListener onLoopListener);

    void forEach(OnReceiverFilter onReceiverFilter, OnLoopListener onLoopListener);

    GroupValue getGroupValue();

    <T extends IReceiver> T getReceiver(String str);

    void removeOnReceiverGroupChangeListener(OnReceiverGroupChangeListener onReceiverGroupChangeListener);

    void removeReceiver(String str);

    void sort(Comparator<IReceiver> comparator);
}
