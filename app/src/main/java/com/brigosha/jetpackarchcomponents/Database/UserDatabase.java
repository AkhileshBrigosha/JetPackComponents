package com.brigosha.jetpackarchcomponents.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.brigosha.jetpackarchcomponents.DAO.UserDAO;
import com.brigosha.jetpackarchcomponents.Models.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//singleton
@Database(entities = {User.class}, version = 1,exportSchema = true)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    static UserDatabase DBINSTANCE;

    // We've created an ExecutorService with a fixed thread pool
    // that you will use to run database operations asynchronously on a background thread.
    static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(4);

    public static UserDatabase getDbInstance(final Context context){
        if (DBINSTANCE == null){
            synchronized (UserDatabase.class){
                if (DBINSTANCE == null){
                    DBINSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"user_database").build();
                }
            }
        }
        return DBINSTANCE;
    }
}
