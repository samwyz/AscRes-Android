package com.campuswatch.ascres_android;

import android.content.SharedPreferences;

import com.campuswatch.ascres_android.models.User;

import static com.campuswatch.ascres_android.Constants.USER_DATA;

/**
 * Thought of by samwyz for the most part on 4/12/17.
 */

public class UserRepository {

    public static boolean isEmergency;
    public static String alertID;
    private SharedPreferences prefs;
    private User user;

    public UserRepository(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void saveUserPrefs() {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(USER_DATA, user.serialize());
        editor.apply();
    }

    public void loadUserPrefs() {
        user = User.create(prefs.getString(USER_DATA, null));
    }

}