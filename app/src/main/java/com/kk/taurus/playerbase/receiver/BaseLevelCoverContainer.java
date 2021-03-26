package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kk.taurus.playerbase.log.PLog;

public abstract class BaseLevelCoverContainer extends AbsCoverContainer {
    private final String TAG = "base_cover_container";

    protected abstract void initLevelContainers(Context context);

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onAvailableCoverRemove(BaseCover baseCover) {
    }

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onCoverAdd(BaseCover baseCover) {
    }

    public BaseLevelCoverContainer(Context context) {
        super(context);
        initLevelContainers(context);
    }

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onAvailableCoverAdd(BaseCover baseCover) {
        PLog.d("base_cover_container", "on available cover add : now count = " + getCoverCount());
    }

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onCoverRemove(BaseCover baseCover) {
        PLog.d("base_cover_container", "on cover remove : now count = " + getCoverCount());
    }

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onCoversRemoveAll() {
        PLog.d("base_cover_container", "on covers remove all ...");
    }

    @Override // com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected ViewGroup initContainerRootView() {
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    protected void addLevelContainerView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (getContainerView() != null) {
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            getContainerView().addView(viewGroup, layoutParams);
        }
    }
}
