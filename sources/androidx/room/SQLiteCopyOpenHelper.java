package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(Context context, String str, File file, int i, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mDatabaseVersion = i;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    private void verifyDatabaseFile() {
        String databaseName = getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath);
                } catch (IOException e) {
                    throw new RuntimeException("Unable to copy database file.", e);
                }
            } else if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    int i = this.mDatabaseVersion;
                    if (readVersion == i) {
                        copyLock.unlock();
                    } else if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, i)) {
                        copyLock.unlock();
                    } else {
                        if (this.mContext.deleteDatabase(databaseName)) {
                            try {
                                copyDatabaseFile(databasePath);
                            } catch (IOException e2) {
                                Log.w("ROOM", "Unable to copy database file.", e2);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e3) {
                    Log.w("ROOM", "Unable to read database version.", e3);
                    copyLock.unlock();
                }
            }
        } finally {
            copyLock.unlock();
        }
    }

    private void copyDatabaseFile(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.mCopyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            readableByteChannel = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }
}
