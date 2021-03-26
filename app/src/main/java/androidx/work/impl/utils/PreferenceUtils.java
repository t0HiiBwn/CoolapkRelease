package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

public class PreferenceUtils {
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public long getLastCancelAllTimeMillis() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue("last_cancel_all_time_ms");
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0;
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map(this.mWorkDatabase.preferenceDao().getObservableLongValue("last_cancel_all_time_ms"), new Function<Long, Long>() {
            /* class androidx.work.impl.utils.PreferenceUtils.AnonymousClass1 */

            public Long apply(Long l2) {
                return Long.valueOf(l2 != null ? l2.longValue() : 0);
            }
        });
    }

    public void setLastCancelAllTimeMillis(long j) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference("last_cancel_all_time_ms", j));
    }

    public boolean getNeedsReschedule() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue("reschedule_needed");
        return longValue != null && longValue.longValue() == 1;
    }

    public void setNeedsReschedule(boolean z) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference("reschedule_needed", z));
    }

    public static void migrateLegacyPreferences(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j = 0;
            long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j = 1;
            }
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }
}
