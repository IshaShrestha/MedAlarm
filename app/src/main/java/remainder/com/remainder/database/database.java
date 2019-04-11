package remainder.com.remainder.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = User.class,version = 1)
public abstract class database extends RoomDatabase {
    public abstract DatabaseAccess databaseObject();


}
