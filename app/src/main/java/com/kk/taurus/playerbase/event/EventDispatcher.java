package com.kk.taurus.playerbase.event;

import android.os.Bundle;
import android.view.MotionEvent;
import com.kk.taurus.playerbase.log.DebugLog;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.receiver.IReceiver;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;

public final class EventDispatcher implements IEventDispatcher {
    private IReceiverGroup mReceiverGroup;

    public EventDispatcher(IReceiverGroup iReceiverGroup) {
        this.mReceiverGroup = iReceiverGroup;
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchPlayEvent(final int i, final Bundle bundle) {
        DebugLog.onPlayEventLog(i, bundle);
        if (i != -99019) {
            this.mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
                /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass2 */

                @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
                public void onEach(IReceiver iReceiver) {
                    iReceiver.onPlayerEvent(i, bundle);
                }
            });
        } else {
            this.mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
                /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass1 */

                @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
                public void onEach(IReceiver iReceiver) {
                    Bundle bundle;
                    if ((iReceiver instanceof OnTimerUpdateListener) && (bundle = bundle) != null) {
                        ((OnTimerUpdateListener) iReceiver).onTimerUpdate(bundle.getInt("int_arg1"), bundle.getInt("int_arg2"), bundle.getInt("int_arg3"));
                    }
                    iReceiver.onPlayerEvent(i, bundle);
                }
            });
        }
        recycleBundle(bundle);
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchErrorEvent(final int i, final Bundle bundle) {
        DebugLog.onErrorEventLog(i, bundle);
        this.mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass3 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                iReceiver.onErrorEvent(i, bundle);
            }
        });
        recycleBundle(bundle);
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchReceiverEvent(int i, Bundle bundle) {
        dispatchReceiverEvent(i, bundle, null);
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchReceiverEvent(final int i, final Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        this.mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass4 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                iReceiver.onReceiverEvent(i, bundle);
            }
        });
        recycleBundle(bundle);
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchProducerEvent(final int i, final Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        this.mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass5 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                iReceiver.onProducerEvent(i, bundle);
            }
        });
        recycleBundle(bundle);
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchProducerData(final String str, final Object obj, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        this.mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass6 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                iReceiver.onProducerData(str, obj);
            }
        });
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchTouchEventOnSingleTabUp(final MotionEvent motionEvent) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass7 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                ((OnTouchGestureListener) iReceiver).onSingleTapUp(motionEvent);
            }
        });
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchTouchEventOnDoubleTabUp(final MotionEvent motionEvent) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass8 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                ((OnTouchGestureListener) iReceiver).onDoubleTap(motionEvent);
            }
        });
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchTouchEventOnDown(final MotionEvent motionEvent) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass9 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                ((OnTouchGestureListener) iReceiver).onDown(motionEvent);
            }
        });
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchTouchEventOnScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f, final float f2) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass10 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                ((OnTouchGestureListener) iReceiver).onScroll(motionEvent, motionEvent2, f, f2);
            }
        });
    }

    @Override // com.kk.taurus.playerbase.event.IEventDispatcher
    public void dispatchTouchEventOnEndGesture() {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass11 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                ((OnTouchGestureListener) iReceiver).onEndGesture();
            }
        });
    }

    private void filterImplOnTouchEventListener(final IReceiverGroup.OnLoopListener onLoopListener) {
        this.mReceiverGroup.forEach(new IReceiverGroup.OnReceiverFilter() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass12 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnReceiverFilter
            public boolean filter(IReceiver iReceiver) {
                return iReceiver instanceof OnTouchGestureListener;
            }
        }, new IReceiverGroup.OnLoopListener() {
            /* class com.kk.taurus.playerbase.event.EventDispatcher.AnonymousClass13 */

            @Override // com.kk.taurus.playerbase.receiver.IReceiverGroup.OnLoopListener
            public void onEach(IReceiver iReceiver) {
                onLoopListener.onEach(iReceiver);
            }
        });
    }

    private void recycleBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.clear();
        }
    }
}
