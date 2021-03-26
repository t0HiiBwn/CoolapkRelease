package com.kk.taurus.playerbase.receiver;

import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ReceiverGroup implements IReceiverGroup {
    private GroupValue mGroupValue;
    private List<IReceiverGroup.OnReceiverGroupChangeListener> mOnReceiverGroupChangeListeners;
    private List<IReceiver> mReceiverArray;
    private Map<String, IReceiver> mReceivers;

    public ReceiverGroup() {
        this(null);
    }

    public ReceiverGroup(GroupValue groupValue) {
        this.mReceivers = new ConcurrentHashMap(16);
        this.mReceiverArray = Collections.synchronizedList(new ArrayList());
        this.mOnReceiverGroupChangeListeners = new CopyOnWriteArrayList();
        if (groupValue == null) {
            this.mGroupValue = new GroupValue();
        } else {
            this.mGroupValue = groupValue;
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void addOnReceiverGroupChangeListener(IReceiverGroup.OnReceiverGroupChangeListener onReceiverGroupChangeListener) {
        if (!this.mOnReceiverGroupChangeListeners.contains(onReceiverGroupChangeListener)) {
            this.mOnReceiverGroupChangeListeners.add(onReceiverGroupChangeListener);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void removeOnReceiverGroupChangeListener(IReceiverGroup.OnReceiverGroupChangeListener onReceiverGroupChangeListener) {
        this.mOnReceiverGroupChangeListeners.remove(onReceiverGroupChangeListener);
    }

    void callBackOnReceiverAdd(String str, IReceiver iReceiver) {
        for (IReceiverGroup.OnReceiverGroupChangeListener onReceiverGroupChangeListener : this.mOnReceiverGroupChangeListeners) {
            onReceiverGroupChangeListener.onReceiverAdd(str, iReceiver);
        }
    }

    void callBackOnReceiverRemove(String str, IReceiver iReceiver) {
        for (IReceiverGroup.OnReceiverGroupChangeListener onReceiverGroupChangeListener : this.mOnReceiverGroupChangeListeners) {
            onReceiverGroupChangeListener.onReceiverRemove(str, iReceiver);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void addReceiver(String str, IReceiver iReceiver) {
        ((BaseReceiver) iReceiver).setKey(str);
        iReceiver.bindGroup(this);
        iReceiver.onReceiverBind();
        this.mReceivers.put(str, iReceiver);
        this.mReceiverArray.add(iReceiver);
        callBackOnReceiverAdd(str, iReceiver);
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void removeReceiver(String str) {
        IReceiver remove = this.mReceivers.remove(str);
        this.mReceiverArray.remove(remove);
        onReceiverRemove(str, remove);
    }

    private void onReceiverRemove(String str, IReceiver iReceiver) {
        if (iReceiver != null) {
            callBackOnReceiverRemove(str, iReceiver);
            iReceiver.onReceiverUnBind();
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void sort(Comparator<IReceiver> comparator) {
        Collections.sort(this.mReceiverArray, comparator);
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void forEach(IReceiverGroup.OnLoopListener onLoopListener) {
        forEach(null, onLoopListener);
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void forEach(IReceiverGroup.OnReceiverFilter onReceiverFilter, IReceiverGroup.OnLoopListener onLoopListener) {
        for (IReceiver iReceiver : this.mReceiverArray) {
            if (onReceiverFilter == null || onReceiverFilter.filter(iReceiver)) {
                onLoopListener.onEach(iReceiver);
            }
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public <T extends IReceiver> T getReceiver(String str) {
        Map<String, IReceiver> map = this.mReceivers;
        if (map != null) {
            return (T) map.get(str);
        }
        return null;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public GroupValue getGroupValue() {
        return this.mGroupValue;
    }

    @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup
    public void clearReceivers() {
        for (IReceiver iReceiver : this.mReceiverArray) {
            onReceiverRemove(iReceiver.getKey(), iReceiver);
        }
        this.mReceiverArray.clear();
        this.mReceivers.clear();
    }
}
