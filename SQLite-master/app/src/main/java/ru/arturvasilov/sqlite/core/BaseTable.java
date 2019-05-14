package ru.arturvasilov.sqlite.core;

import android.net.Uri;
import android.support.annotation.NonNull;

import org.sqlite.database.sqlite.SQLiteDatabase;

/**
 * @author Artur Vasilov
 */
public abstract class BaseTable<T> implements Table<T> {

    @NonNull
    @Override
    public final Uri getUri() {
        return SQLiteContentProvider.getBaseUri().buildUpon().appendPath(getTableName()).build();
    }

    @Override
    public int getLastUpgradeVersion() {
        return 1;
    }

    @NonNull
    @Override
    public String getTableName() {
        return getClass().getSimpleName();
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase database) {
        database.execSQL("DROP TABLE IF EXISTS " + getTableName());
        onCreate(database);
    }
}
