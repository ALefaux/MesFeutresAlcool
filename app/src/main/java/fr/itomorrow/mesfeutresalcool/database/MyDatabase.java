package fr.itomorrow.mesfeutresalcool.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Axou on 10/12/2016.
 */

@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    public static final String NAME = "MyDatabase";
    public static final int VERSION = 1;
}
