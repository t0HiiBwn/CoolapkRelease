package com.coolapk.market.widget;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.material.appbar.AppBarLayout;

@Deprecated
public class AppBarScrollStateHelper {
    private AppBarLayout mAppbar;
    private int mCurrent;
    private int mDirection;
    private boolean mDirectionValid;
    private int mTouchSlop;

    public AppBarScrollStateHelper(AppBarLayout appBarLayout) {
        this.mTouchSlop = ViewConfiguration.get(appBarLayout.getContext()).getScaledTouchSlop();
        this.mAppbar = appBarLayout;
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarLayout.OnOffsetChangedListener() {
            /* class com.coolapk.market.widget.AppBarScrollStateHelper.AnonymousClass1 */

            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (Math.abs(i - AppBarScrollStateHelper.this.mCurrent) >= AppBarScrollStateHelper.this.mTouchSlop) {
                    int signum = (int) Math.signum((float) (i - AppBarScrollStateHelper.this.mCurrent));
                    if (signum != 0 && AppBarScrollStateHelper.this.mDirectionValid) {
                        if (AppBarScrollStateHelper.this.mDirection + signum > 0) {
                            AppBarScrollStateHelper.this.mDirection = signum;
                        } else if (AppBarScrollStateHelper.this.mDirection + signum < 0) {
                            AppBarScrollStateHelper.this.mDirection = signum;
                        } else {
                            AppBarScrollStateHelper.this.mDirection = 0;
                            AppBarScrollStateHelper.this.mDirectionValid = false;
                        }
                    }
                    AppBarScrollStateHelper.this.mCurrent = i;
                }
            }
        });
    }

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.mDirectionValid) {
                int i = this.mDirection;
                if (i > 0) {
                    if (Math.abs(this.mCurrent) > (-this.mAppbar.getTotalScrollRange()) + this.mTouchSlop) {
                        this.mAppbar.setExpanded(true, true);
                    } else {
                        this.mAppbar.setExpanded(false, true);
                    }
                } else if (i >= 0) {
                } else {
                    if (Math.abs(this.mCurrent) > this.mTouchSlop) {
                        this.mAppbar.setExpanded(false, true);
                    } else {
                        this.mAppbar.setExpanded(true, true);
                    }
                }
            } else if (this.mCurrent < (-this.mAppbar.getTotalScrollRange()) / 2) {
                this.mAppbar.setExpanded(false, true);
            } else {
                this.mAppbar.setExpanded(true, true);
            }
        } else if (motionEvent.getAction() == 0) {
            this.mDirectionValid = true;
            this.mDirection = 0;
        }
    }
}
