package com.coolapk.market.view.danmaku.easy.danmaku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.android.example.text.styling.roundedbg.RoundedBgTextView;
import com.coolapk.market.view.danmaku.easy.danmaku.Danmaku;
import com.coolapk.market.view.danmaku.easy.utils.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DanmakuView extends RoundedBgTextView {
    private Danmaku mDanmaku;
    private int mDuration;
    private ListenerInfo mListenerInfo;
    private Scroller mScroller;

    public interface OnEnterListener {
        void onEnter(DanmakuView danmakuView);
    }

    public interface OnExitListener {
        void onExit(DanmakuView danmakuView);
    }

    private class ListenerInfo {
        private ArrayList<OnEnterListener> mOnEnterListeners;
        private List<OnExitListener> mOnExitListener;

        private ListenerInfo() {
        }

        /* synthetic */ ListenerInfo(DanmakuView danmakuView, AnonymousClass1 r2) {
            this();
        }
    }

    public DanmakuView(Context context) {
        super(context);
    }

    public DanmakuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanmakuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDanmaku(Danmaku danmaku) {
        this.mDanmaku = danmaku;
        setText(danmaku.text);
        int i = AnonymousClass1.$SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[danmaku.mode.ordinal()];
        if (i == 1 || i == 2) {
            setGravity(17);
        } else {
            setGravity(8388627);
        }
    }

    /* renamed from: com.coolapk.market.view.danmaku.easy.danmaku.DanmakuView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode;

        static {
            int[] iArr = new int[Danmaku.Mode.values().length];
            $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode = iArr;
            try {
                iArr[Danmaku.Mode.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[Danmaku.Mode.scroll.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Danmaku getDanmaku() {
        return this.mDanmaku;
    }

    public void show(ViewGroup viewGroup, int i) {
        this.mDuration = i;
        int i2 = AnonymousClass1.$SwitchMap$com$coolapk$market$view$danmaku$easy$danmaku$Danmaku$Mode[this.mDanmaku.mode.ordinal()];
        if (i2 == 1 || i2 == 2) {
            showFixedDanmaku(viewGroup, i);
        } else {
            showScrollDanmaku(viewGroup, i);
        }
        if (hasOnEnterListener()) {
            Iterator it2 = getListenerInfo().mOnEnterListeners.iterator();
            while (it2.hasNext()) {
                ((OnEnterListener) it2.next()).onEnter(this);
            }
        }
        postDelayed(new Runnable(viewGroup) {
            /* class com.coolapk.market.view.danmaku.easy.danmaku.$$Lambda$DanmakuView$1ERjIFLzFQgL3cXU4k83UGmyq6Q */
            public final /* synthetic */ ViewGroup f$1;

            {
                this.f$1 = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DanmakuView.this.lambda$show$0$DanmakuView(this.f$1);
            }
        }, (long) i);
    }

    public /* synthetic */ void lambda$show$0$DanmakuView(ViewGroup viewGroup) {
        setVisibility(8);
        if (hasOnExitListener()) {
            for (OnExitListener onExitListener : getListenerInfo().mOnExitListener) {
                onExitListener.onExit(this);
            }
        }
        viewGroup.removeView(this);
    }

    private void showScrollDanmaku(ViewGroup viewGroup, int i) {
        int screenWidth = ScreenUtil.getScreenWidth();
        int textLength = getTextLength();
        scrollTo(-screenWidth, 0);
        viewGroup.addView(this);
        smoothScrollTo(textLength, 0, i);
    }

    private void showFixedDanmaku(ViewGroup viewGroup, int i) {
        setGravity(17);
        viewGroup.addView(this);
    }

    private ListenerInfo getListenerInfo() {
        if (this.mListenerInfo == null) {
            this.mListenerInfo = new ListenerInfo(this, null);
        }
        return this.mListenerInfo;
    }

    public void addOnEnterListener(OnEnterListener onEnterListener) {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnEnterListeners == null) {
            listenerInfo.mOnEnterListeners = new ArrayList();
        }
        if (!listenerInfo.mOnEnterListeners.contains(onEnterListener)) {
            listenerInfo.mOnEnterListeners.add(onEnterListener);
        }
    }

    public void clearOnEnterListeners() {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnEnterListeners != null && listenerInfo.mOnEnterListeners.size() != 0) {
            listenerInfo.mOnEnterListeners.clear();
        }
    }

    public void addOnExitListener(OnExitListener onExitListener) {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnExitListener == null) {
            listenerInfo.mOnExitListener = new CopyOnWriteArrayList();
        }
        if (!listenerInfo.mOnExitListener.contains(onExitListener)) {
            listenerInfo.mOnExitListener.add(onExitListener);
        }
    }

    public void clearOnExitListeners() {
        ListenerInfo listenerInfo = getListenerInfo();
        if (listenerInfo.mOnExitListener != null && listenerInfo.mOnExitListener.size() != 0) {
            listenerInfo.mOnExitListener.clear();
        }
    }

    public boolean hasOnEnterListener() {
        ListenerInfo listenerInfo = getListenerInfo();
        return (listenerInfo.mOnEnterListeners == null || listenerInfo.mOnEnterListeners.size() == 0) ? false : true;
    }

    public boolean hasOnExitListener() {
        ListenerInfo listenerInfo = getListenerInfo();
        return (listenerInfo.mOnExitListener == null || listenerInfo.mOnExitListener.size() == 0) ? false : true;
    }

    public int getTextLength() {
        return (int) getPaint().measureText(getText().toString());
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void restore() {
        clearOnEnterListeners();
        clearOnExitListeners();
        setVisibility(0);
        setScrollX(0);
        setScrollY(0);
    }

    public void smoothScrollTo(int i, int i2, int i3) {
        if (this.mScroller == null) {
            Scroller scroller = new Scroller(getContext(), new LinearInterpolator());
            this.mScroller = scroller;
            setScroller(scroller);
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        this.mScroller.startScroll(scrollX, scrollY, i - scrollX, i2 - scrollY, i3);
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        Scroller scroller = this.mScroller;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
    }

    void callExitListener() {
        for (OnExitListener onExitListener : getListenerInfo().mOnExitListener) {
            onExitListener.onExit(this);
        }
    }
}
