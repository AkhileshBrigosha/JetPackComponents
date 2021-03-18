package com.brigosha.jetpackarchcomponents.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.brigosha.jetpackarchcomponents.DAO.UserDAO;
import com.brigosha.jetpackarchcomponents.Database.UserDatabase;
import com.brigosha.jetpackarchcomponents.Models.User;

import java.util.List;

public class UserRepository {

    private UserDAO mUserDAO;
    private LiveData<List<User>> mAllUsers;

    UserRepository(Application application){
        UserDatabase userDatabase = UserDatabase.getDbInstance(application);
        mUserDAO = userDatabase.userDAO();
        mAllUsers = mUserDAO.getAllUsers();
    }
}
