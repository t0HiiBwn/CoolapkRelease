package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean {
    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock = new Object();
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock = new Object();

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (sExtrasLock) {
            if (sExtrasFieldAccessFailed) {
                return null;
            }
            try {
                if (sExtrasField == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                Bundle bundle = (Bundle) sExtrasField.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    sExtrasField.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                sExtrasFieldAccessFailed = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                sExtrasFieldAccessFailed = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action readAction(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        boolean z;
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        if (bundle != null) {
            remoteInputArr2 = fromBundleArray(getBundleArrayFromBundle(bundle, "android.support.remoteInputs"));
            remoteInputArr = fromBundleArray(getBundleArrayFromBundle(bundle, "android.support.dataRemoteInputs"));
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        } else {
            remoteInputArr2 = null;
            remoteInputArr = null;
            z = false;
        }
        return new NotificationCompat.Action(i, charSequence, pendingIntent, bundle, remoteInputArr2, remoteInputArr, z, 0, true, false);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat iconCompat = action.getIconCompat();
        builder.addAction(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (sActionsLock) {
            Object[] actionObjectsLocked = getActionObjectsLocked(notification);
            length = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
        }
        return length;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i) {
        SparseArray sparseParcelableArray;
        synchronized (sActionsLock) {
            try {
                Object[] actionObjectsLocked = getActionObjectsLocked(notification);
                if (actionObjectsLocked != null) {
                    Object obj = actionObjectsLocked[i];
                    Bundle extras = getExtras(notification);
                    return readAction(sActionIconField.getInt(obj), (CharSequence) sActionTitleField.get(obj), (PendingIntent) sActionIntentField.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray("android.support.actionExtras")) == null) ? null : (Bundle) sparseParcelableArray.get(i));
                }
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                sActionsAccessFailed = true;
            } catch (Throwable th) {
                throw th;
            }
            return null;
        }
    }

    private static Object[] getActionObjectsLocked(Notification notification) {
        synchronized (sActionsLock) {
            if (!ensureActionReflectionReadyLocked()) {
                return null;
            }
            try {
                return (Object[]) sActionsField.get(notification);
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                return null;
            }
        }
    }

    private static boolean ensureActionReflectionReadyLocked() {
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                sActionIconField = cls.getDeclaredField("icon");
                sActionTitleField = cls.getDeclaredField("title");
                sActionIntentField = cls.getDeclaredField("actionIntent");
                Field declaredField = Notification.class.getDeclaredField("actions");
                sActionsField = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            Log.e("NotificationCompat", "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e2) {
            Log.e("NotificationCompat", "Unable to access notification actions", e2);
            sActionsAccessFailed = true;
        }
        return !sActionsAccessFailed;
    }

    static NotificationCompat.Action getActionFromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), fromBundleArray(getBundleArrayFromBundle(bundle, "remoteInputs")), fromBundleArray(getBundleArrayFromBundle(bundle, "dataOnlyRemoteInputs")), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false);
    }

    static Bundle getBundleForAction(NotificationCompat.Action action) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        bundle2.putInt("icon", iconCompat != null ? iconCompat.getResId() : 0);
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", toBundleArray(action.getRemoteInputs()));
        bundle2.putBoolean("showsUserInterface", action.getShowsUserInterface());
        bundle2.putInt("semanticAction", action.getSemanticAction());
        return bundle2;
    }

    private static RemoteInput fromBundle(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it2 = stringArrayList.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next());
            }
        }
        return new RemoteInput(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    private static Bundle toBundle(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
            for (String str : allowedDataTypes) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static RemoteInput[] fromBundleArray(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i = 0; i < bundleArr.length; i++) {
            remoteInputArr[i] = fromBundle(bundleArr[i]);
        }
        return remoteInputArr;
    }

    private static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = toBundle(remoteInputArr[i]);
        }
        return bundleArr;
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    private NotificationCompatJellybean() {
    }
}
