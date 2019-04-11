package remainder.com.remainder.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DatabaseAccess {

    @Insert
    public void addUser(User user);

    @Query("Select * from users")
    public List<User> readUser();

    @Update
    public void updateData(User user);

    @Delete
    public void deleteData(User user);

}
