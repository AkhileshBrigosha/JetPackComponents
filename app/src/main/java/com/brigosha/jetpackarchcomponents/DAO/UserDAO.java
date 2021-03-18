package com.brigosha.jetpackarchcomponents.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brigosha.jetpackarchcomponents.Models.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("Select * From User")
    public LiveData<List<User>> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);

    @Delete
    public void deleteAllUsers();
}
