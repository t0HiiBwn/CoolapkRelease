package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsCoverContainer implements ICoverStrategy {
    private ViewGroup mContainerRoot = initContainerRootView();
    protected Context mContext;
    private List<BaseCover> mCovers = new ArrayList();

    protected abstract ViewGroup initContainerRootView();

    protected abstract void onAvailableCoverAdd(BaseCover baseCover);

    protected abstract void onAvailableCoverRemove(BaseCover baseCover);

    protected abstract void onCoverAdd(BaseCover baseCover);

    protected abstract void onCoverRemove(BaseCover baseCover);

    protected abstract void onCoversRemoveAll();

    public AbsCoverContainer(Context context) {
        this.mContext = context;
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public void addCover(BaseCover baseCover) {
        onCoverAdd(baseCover);
        if (isAvailableCover(baseCover)) {
            this.mCovers.add(baseCover);
            onAvailableCoverAdd(baseCover);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public void removeCover(BaseCover baseCover) {
        onCoverRemove(baseCover);
        if (isAvailableCover(baseCover)) {
            this.mCovers.remove(baseCover);
            onAvailableCoverRemove(baseCover);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public void removeAllCovers() {
        this.mCovers.clear();
        onCoversRemoveAll();
    }

    protected boolean isAvailableCover(BaseCover baseCover) {
        return (baseCover == null || baseCover.getView() == null) ? false : true;
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public boolean isContainsCover(BaseCover baseCover) {
        if (!isAvailableCover(baseCover)) {
            return false;
        }
        if (rootIndexOfChild(baseCover.getView()) != -1) {
            return true;
        }
        int rootChildCount = getRootChildCount();
        if (rootChildCount <= 0) {
            return false;
        }
        for (int i = 0; i < rootChildCount; i++) {
            View rootGetChildAt = rootGetChildAt(i);
            if ((rootGetChildAt instanceof ViewGroup) && ((ViewGroup) rootGetChildAt).indexOfChild(baseCover.getView()) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public int getCoverCount() {
        List<BaseCover> list = this.mCovers;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    protected int rootIndexOfChild(View view) {
        ViewGroup viewGroup = this.mContainerRoot;
        if (viewGroup == null) {
            return -1;
        }
        return viewGroup.indexOfChild(view);
    }

    protected int getRootChildCount() {
        ViewGroup viewGroup = this.mContainerRoot;
        if (viewGroup == null) {
            return 0;
        }
        return viewGroup.getChildCount();
    }

    protected View rootGetChildAt(int i) {
        ViewGroup viewGroup = this.mContainerRoot;
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.getChildAt(i);
    }

    @Override // com.kk.taurus.playerbase.receiver.ICoverStrategy
    public ViewGroup getContainerView() {
        return this.mContainerRoot;
    }
}
