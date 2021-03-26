package com.kk.taurus.playerbase.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kk.taurus.playerbase.event.EventDispatcher;
import com.kk.taurus.playerbase.event.IEventDispatcher;
import com.kk.taurus.playerbase.extension.BaseEventProducer;
import com.kk.taurus.playerbase.extension.DelegateReceiverEventSender;
import com.kk.taurus.playerbase.extension.IProducerGroup;
import com.kk.taurus.playerbase.extension.ProducerEventSender;
import com.kk.taurus.playerbase.extension.ProducerGroup;
import com.kk.taurus.playerbase.log.PLog;
import com.kk.taurus.playerbase.receiver.BaseCover;
import com.kk.taurus.playerbase.receiver.CoverComparator;
import com.kk.taurus.playerbase.receiver.DefaultLevelCoverContainer;
import com.kk.taurus.playerbase.receiver.ICoverStrategy;
import com.kk.taurus.playerbase.receiver.IReceiver;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.OnReceiverEventListener;
import com.kk.taurus.playerbase.receiver.StateGetter;
import com.kk.taurus.playerbase.touch.BaseGestureCallbackHandler;
import com.kk.taurus.playerbase.touch.ContainerTouchHelper;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;

public class SuperContainer extends FrameLayout implements OnTouchGestureListener {
    final String TAG = "SuperContainer";
    private ICoverStrategy mCoverStrategy;
    private DelegateReceiverEventSender mDelegateReceiverEventSender = new DelegateReceiverEventSender() {
        /* class com.kk.taurus.playerbase.widget.SuperContainer.AnonymousClass1 */

        @Override // com.kk.taurus.playerbase.extension.DelegateReceiverEventSender
        public void sendEvent(int i, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
            if (SuperContainer.this.mEventDispatcher != null) {
                SuperContainer.this.mEventDispatcher.dispatchProducerEvent(i, bundle, onReceiverFilter);
            }
        }

        @Override // com.kk.taurus.playerbase.extension.DelegateReceiverEventSender
        public void sendObject(String str, Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
            if (SuperContainer.this.mEventDispatcher != null) {
                SuperContainer.this.mEventDispatcher.dispatchProducerData(str, obj, onReceiverFilter);
            }
        }
    };
    private IEventDispatcher mEventDispatcher;
    private OnReceiverEventListener mInternalReceiverEventListener = new OnReceiverEventListener() {
        /* class com.kk.taurus.playerbase.widget.SuperContainer.AnonymousClass4 */

        @Override // com.kk.taurus.playerbase.receiver.OnReceiverEventListener
        public void onReceiverEvent(int i, Bundle bundle) {
            if (SuperContainer.this.mOnReceiverEventListener != null) {
                SuperContainer.this.mOnReceiverEventListener.onReceiverEvent(i, bundle);
            }
            if (SuperContainer.this.mEventDispatcher != null) {
                SuperContainer.this.mEventDispatcher.dispatchReceiverEvent(i, bundle);
            }
        }
    };
    private IReceiverGroup.OnReceiverGroupChangeListener mInternalReceiverGroupChangeListener = new IReceiverGroup.OnReceiverGroupChangeListener() {
        /* class com.kk.taurus.playerbase.widget.SuperContainer.AnonymousClass3 */

        @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnReceiverGroupChangeListener
        public void onReceiverAdd(String str, IReceiver iReceiver) {
            SuperContainer.this.attachReceiver(iReceiver);
        }

        @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnReceiverGroupChangeListener
        public void onReceiverRemove(String str, IReceiver iReceiver) {
            SuperContainer.this.detachReceiver(iReceiver);
        }
    };
    private OnReceiverEventListener mOnReceiverEventListener;
    private IProducerGroup mProducerGroup;
    private IReceiverGroup mReceiverGroup;
    private FrameLayout mRenderContainer;
    private StateGetter mStateGetter;
    private ContainerTouchHelper mTouchHelper;

    public SuperContainer(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        initBaseInfo(context);
        initGesture(context);
        initRenderContainer(context);
        initReceiverContainer(context);
    }

    private void initBaseInfo(Context context) {
        this.mProducerGroup = new ProducerGroup(new ProducerEventSender(this.mDelegateReceiverEventSender));
    }

    protected void initGesture(Context context) {
        this.mTouchHelper = new ContainerTouchHelper(context, getGestureCallBackHandler());
        setGestureEnable(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mTouchHelper.onTouch(motionEvent);
    }

    protected BaseGestureCallbackHandler getGestureCallBackHandler() {
        return new BaseGestureCallbackHandler(this);
    }

    public void setGestureEnable(boolean z) {
        this.mTouchHelper.setGestureEnable(z);
    }

    public void setGestureScrollEnable(boolean z) {
        this.mTouchHelper.setGestureScrollEnable(z);
    }

    private void initReceiverContainer(Context context) {
        ICoverStrategy coverStrategy = getCoverStrategy(context);
        this.mCoverStrategy = coverStrategy;
        addView(coverStrategy.getContainerView(), new ViewGroup.LayoutParams(-1, -1));
    }

    protected ICoverStrategy getCoverStrategy(Context context) {
        return new DefaultLevelCoverContainer(context);
    }

    private void initRenderContainer(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.mRenderContainer = frameLayout;
        addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void setRenderView(View view) {
        removeRender();
        this.mRenderContainer.addView(view, new FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void setStateGetter(StateGetter stateGetter) {
        this.mStateGetter = stateGetter;
    }

    public final void dispatchPlayEvent(int i, Bundle bundle) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchPlayEvent(i, bundle);
        }
    }

    public final void dispatchErrorEvent(int i, Bundle bundle) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchErrorEvent(i, bundle);
        }
    }

    public void setOnReceiverEventListener(OnReceiverEventListener onReceiverEventListener) {
        this.mOnReceiverEventListener = onReceiverEventListener;
    }

    public void addEventProducer(BaseEventProducer baseEventProducer) {
        this.mProducerGroup.addEventProducer(baseEventProducer);
    }

    public boolean removeEventProducer(BaseEventProducer baseEventProducer) {
        return this.mProducerGroup.removeEventProducer(baseEventProducer);
    }

    public final void setReceiverGroup(IReceiverGroup iReceiverGroup) {
        if (iReceiverGroup != null && !iReceiverGroup.equals(this.mReceiverGroup)) {
            removeAllCovers();
            IReceiverGroup iReceiverGroup2 = this.mReceiverGroup;
            if (iReceiverGroup2 != null) {
                iReceiverGroup2.removeOnReceiverGroupChangeListener(this.mInternalReceiverGroupChangeListener);
            }
            this.mReceiverGroup = iReceiverGroup;
            this.mEventDispatcher = new EventDispatcher(iReceiverGroup);
            this.mReceiverGroup.sort(new CoverComparator());
            this.mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
                /* class com.kk.taurus.playerbase.widget.SuperContainer.AnonymousClass2 */

                @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
                public void onEach(IReceiver iReceiver) {
                    SuperContainer.this.attachReceiver(iReceiver);
                }
            });
            this.mReceiverGroup.addOnReceiverGroupChangeListener(this.mInternalReceiverGroupChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public void attachReceiver(IReceiver iReceiver) {
        iReceiver.bindReceiverEventListener(this.mInternalReceiverEventListener);
        iReceiver.bindStateGetter(this.mStateGetter);
        if (iReceiver instanceof BaseCover) {
            BaseCover baseCover = (BaseCover) iReceiver;
            this.mCoverStrategy.addCover(baseCover);
            PLog.d("SuperContainer", "on cover attach : " + baseCover.getTag() + " ," + baseCover.getCoverLevel());
        }
    }

    /* access modifiers changed from: private */
    public void detachReceiver(IReceiver iReceiver) {
        if (iReceiver instanceof BaseCover) {
            BaseCover baseCover = (BaseCover) iReceiver;
            this.mCoverStrategy.removeCover(baseCover);
            PLog.w("SuperContainer", "on cover detach : " + baseCover.getTag() + " ," + baseCover.getCoverLevel());
        }
        iReceiver.bindReceiverEventListener(null);
        iReceiver.bindStateGetter(null);
    }

    public void destroy() {
        IReceiverGroup iReceiverGroup = this.mReceiverGroup;
        if (iReceiverGroup != null) {
            iReceiverGroup.removeOnReceiverGroupChangeListener(this.mInternalReceiverGroupChangeListener);
        }
        this.mProducerGroup.destroy();
        removeRender();
        removeAllCovers();
    }

    private void removeRender() {
        FrameLayout frameLayout = this.mRenderContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    protected void removeAllCovers() {
        this.mCoverStrategy.removeAllCovers();
        PLog.d("SuperContainer", "detach all covers");
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchTouchEventOnSingleTabUp(motionEvent);
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchTouchEventOnDoubleTabUp(motionEvent);
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onDown(MotionEvent motionEvent) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchTouchEventOnDown(motionEvent);
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchTouchEventOnScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.kk.taurus.playerbase.touch.OnTouchGestureListener
    public void onEndGesture() {
        IEventDispatcher iEventDispatcher = this.mEventDispatcher;
        if (iEventDispatcher != null) {
            iEventDispatcher.dispatchTouchEventOnEndGesture();
        }
    }
}
