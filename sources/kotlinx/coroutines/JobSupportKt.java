package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: JobSupport.kt */
public final class JobSupportKt {
    private static final Symbol COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
    private static final Symbol COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
    public static final Symbol COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
    private static final Empty EMPTY_ACTIVE = new Empty(true);
    private static final Empty EMPTY_NEW = new Empty(false);
    private static final int FALSE = 0;
    private static final int RETRY = -1;
    private static final Symbol SEALED = new Symbol("SEALED");
    private static final Symbol TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
    private static final int TRUE = 1;

    private static /* synthetic */ void getCOMPLETING_ALREADY$annotations() {
    }

    private static /* synthetic */ void getCOMPLETING_RETRY$annotations() {
    }

    public static /* synthetic */ void getCOMPLETING_WAITING_CHILDREN$annotations() {
    }

    private static /* synthetic */ void getEMPTY_ACTIVE$annotations() {
    }

    private static /* synthetic */ void getEMPTY_NEW$annotations() {
    }

    private static /* synthetic */ void getSEALED$annotations() {
    }

    private static /* synthetic */ void getTOO_LATE_TO_CANCEL$annotations() {
    }

    public static final Object boxIncomplete(Object obj) {
        return obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
    }

    public static final Object unboxState(Object obj) {
        Incomplete incomplete;
        IncompleteStateBox incompleteStateBox = (IncompleteStateBox) (!(obj instanceof IncompleteStateBox) ? null : obj);
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.state) == null) ? obj : incomplete;
    }
}
