package androidx.recyclerview.selection;

import android.graphics.Point;
import android.view.MotionEvent;

final class MotionEvents {
    private static boolean hasBit(int i, int i2) {
        return (i & i2) != 0;
    }

    private MotionEvents() {
    }

    static boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    static boolean isTouchEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 1;
    }

    static boolean isActionMove(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 2;
    }

    static boolean isActionDown(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 0;
    }

    static boolean isActionUp(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 1;
    }

    static boolean isActionPointerUp(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 6;
    }

    static boolean isActionPointerDown(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 5;
    }

    static boolean isActionCancel(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 3;
    }

    static Point getOrigin(MotionEvent motionEvent) {
        return new Point((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    static boolean isPrimaryMouseButtonPressed(MotionEvent motionEvent) {
        return isButtonPressed(motionEvent, 1);
    }

    static boolean isSecondaryMouseButtonPressed(MotionEvent motionEvent) {
        return isButtonPressed(motionEvent, 2);
    }

    static boolean isTertiaryMouseButtonPressed(MotionEvent motionEvent) {
        return isButtonPressed(motionEvent, 4);
    }

    private static boolean isButtonPressed(MotionEvent motionEvent, int i) {
        return i != 0 && (motionEvent.getButtonState() & i) == i;
    }

    static boolean isShiftKeyPressed(MotionEvent motionEvent) {
        return hasBit(motionEvent.getMetaState(), 1);
    }

    static boolean isCtrlKeyPressed(MotionEvent motionEvent) {
        return hasBit(motionEvent.getMetaState(), 4096);
    }

    static boolean isAltKeyPressed(MotionEvent motionEvent) {
        return hasBit(motionEvent.getMetaState(), 2);
    }

    static boolean isTouchpadScroll(MotionEvent motionEvent) {
        return isMouseEvent(motionEvent) && isActionMove(motionEvent) && motionEvent.getButtonState() == 0;
    }

    static boolean isPointerDragEvent(MotionEvent motionEvent) {
        return isPrimaryMouseButtonPressed(motionEvent) && isActionMove(motionEvent);
    }
}
