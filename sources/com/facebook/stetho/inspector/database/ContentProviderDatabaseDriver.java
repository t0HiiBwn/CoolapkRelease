package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentProviderDatabaseDriver extends DatabaseDriver2<ContentProviderDatabaseDescriptor> {
    private static final String sDatabaseName = "content-providers";
    private final ContentProviderSchema[] mContentProviderSchemas;
    private List<String> mTableNames;

    static class ContentProviderDatabaseDescriptor implements DatabaseDescriptor {
        @Override // com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor
        public String name() {
            return "content-providers";
        }
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public /* bridge */ /* synthetic */ Database.ExecuteSQLResponse executeSQL(Object obj, String str, BaseDatabaseDriver.ExecuteResultHandler executeResultHandler) throws SQLiteException {
        return executeSQL((ContentProviderDatabaseDescriptor) obj, str, (BaseDatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse>) executeResultHandler);
    }

    public ContentProviderDatabaseDriver(Context context, ContentProviderSchema... contentProviderSchemaArr) {
        super(context);
        this.mContentProviderSchemas = contentProviderSchemaArr;
    }

    @Override // com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver
    public List<ContentProviderDatabaseDescriptor> getDatabaseNames() {
        return Collections.singletonList(new ContentProviderDatabaseDescriptor());
    }

    public List<String> getTableNames(ContentProviderDatabaseDescriptor contentProviderDatabaseDescriptor) {
        if (this.mTableNames == null) {
            this.mTableNames = new ArrayList();
            for (ContentProviderSchema contentProviderSchema : this.mContentProviderSchemas) {
                this.mTableNames.add(contentProviderSchema.getTableName());
            }
        }
        return this.mTableNames;
    }

    public Database.ExecuteSQLResponse executeSQL(ContentProviderDatabaseDescriptor contentProviderDatabaseDescriptor, String str, BaseDatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> executeResultHandler) throws SQLiteException {
        ContentProviderSchema contentProviderSchema = this.mContentProviderSchemas[this.mTableNames.indexOf(fetchTableName(str))];
        Cursor query = this.mContext.getContentResolver().query(contentProviderSchema.getUri(), contentProviderSchema.getProjection(), null, null, null);
        try {
            return executeResultHandler.handleSelect(query);
        } finally {
            query.close();
        }
    }

    private String fetchTableName(String str) {
        for (String str2 : this.mTableNames) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return "";
    }
}
