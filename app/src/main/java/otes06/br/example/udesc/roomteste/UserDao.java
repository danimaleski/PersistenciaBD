package otes06.br.example.udesc.roomteste;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void save(User user);

    @Query("SELECT * FROM user WHERE id = :userId")
    User load(int userId);

    @Query("SELECT * FROM user")
    List<User> loadAll();

    @Query("DELETE FROM user")
    void removeAll();

    @Insert
    void insertAll(User... users);
}
