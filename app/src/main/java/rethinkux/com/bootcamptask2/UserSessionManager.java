package rethinkux.com.bootcamptask2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import rethinkux.com.bootcamptask2.LoginActivity;

public class UserSessionManager {

    public static final String KEY_EMAIL = "email";
    public static final String PREF_NAME = "BootCamp2";
    private static final String IS_USER_LOGIN = "ISUSERLOGGEDIN";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    public UserSessionManager(Context context) {

        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();

    }

    public void createLoginSession(String email) {

        editor.putBoolean(IS_USER_LOGIN, true);

        editor.putString(KEY_EMAIL, email);

        editor.commit();
    }

    public boolean checkLogout() {

        if (!this.isUserLoggedIn()) {

            Intent intent = new Intent(context, LoginActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);

            return true;
        }
        return false;
    }

    public HashMap<String, String> getUserDetails() {

        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));

        return user;
    }

    public boolean isUserLoggedIn() {

        return sharedPreferences.getBoolean(IS_USER_LOGIN, false);

    }
}
