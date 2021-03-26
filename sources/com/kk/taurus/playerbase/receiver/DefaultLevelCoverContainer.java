package com.kk.taurus.playerbase.receiver;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kk.taurus.playerbase.log.PLog;

public class DefaultLevelCoverContainer extends BaseLevelCoverContainer {
    private final String TAG = "DefaultLevelCoverContainer";
    private FrameLayout mLevelHighCoverContainer;
    private FrameLayout mLevelLowCoverContainer;
    private FrameLayout mLevelMediumCoverContainer;

    public DefaultLevelCoverContainer(Context context) {
        super(context);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseLevelCoverContainer
    protected void initLevelContainers(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mLevelLowCoverContainer = frameLayout;
        frameLayout.setBackgroundColor(0);
        addLevelContainerView(this.mLevelLowCoverContainer, null);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.mLevelMediumCoverContainer = frameLayout2;
        frameLayout2.setBackgroundColor(0);
        addLevelContainerView(this.mLevelMediumCoverContainer, null);
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.mLevelHighCoverContainer = frameLayout3;
        frameLayout3.setBackgroundColor(0);
        addLevelContainerView(this.mLevelHighCoverContainer, null);
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseLevelCoverContainer, com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onAvailableCoverAdd(BaseCover baseCover) {
        super.onAvailableCoverAdd(baseCover);
        int coverLevel = baseCover.getCoverLevel();
        if (coverLevel < 32) {
            this.mLevelLowCoverContainer.addView(baseCover.getView(), getNewMatchLayoutParams());
            PLog.d("DefaultLevelCoverContainer", "Low Level Cover Add : level = " + coverLevel);
        } else if (coverLevel < 64) {
            this.mLevelMediumCoverContainer.addView(baseCover.getView(), getNewMatchLayoutParams());
            PLog.d("DefaultLevelCoverContainer", "Medium Level Cover Add : level = " + coverLevel);
        } else {
            this.mLevelHighCoverContainer.addView(baseCover.getView(), getNewMatchLayoutParams());
            PLog.d("DefaultLevelCoverContainer", "High Level Cover Add : level = " + coverLevel);
        }
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseLevelCoverContainer, com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onAvailableCoverRemove(BaseCover baseCover) {
        super.onAvailableCoverRemove(baseCover);
        this.mLevelLowCoverContainer.removeView(baseCover.getView());
        this.mLevelMediumCoverContainer.removeView(baseCover.getView());
        this.mLevelHighCoverContainer.removeView(baseCover.getView());
    }

    @Override // com.kk.taurus.playerbase.receiver.BaseLevelCoverContainer, com.kk.taurus.playerbase.receiver.AbsCoverContainer
    protected void onCoversRemoveAll() {
        super.onCoversRemoveAll();
        this.mLevelLowCoverContainer.removeAllViews();
        this.mLevelMediumCoverContainer.removeAllViews();
        this.mLevelHighCoverContainer.removeAllViews();
    }

    private ViewGroup.LayoutParams getNewMatchLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
