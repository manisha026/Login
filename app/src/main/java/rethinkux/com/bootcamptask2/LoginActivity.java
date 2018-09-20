package rethinkux.com.bootcamptask2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.HashMap;

import static rethinkux.com.bootcamptask2.HomeActivity.PREFS_NAME;
import static rethinkux.com.bootcamptask2.UserSessionManager.PREF_NAME;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_NAME = "LoginPrefs";
    int PRIVATE_MODE = 0;
    UserSessionManager userSessionManager;
    private EditText mEtUerId;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private TextInputLayout mTilUserId;
    private TextInputLayout mTilPassword;
    private Context context;

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userSessionManager = new UserSessionManager(getApplicationContext());

        init();

        mBtnLogin.setOnClickListener(this);

        mEtUerId.addTextChangedListener(new MyTextWatcher(mEtUerId));
        mEtPassword.addTextChangedListener(new MyTextWatcher(mEtPassword));

        context = this;
    }

    private void init() {
        mTilUserId = findViewById(R.id.til_userId);
        mTilPassword = findViewById(R.id.til_password);
        mEtUerId = findViewById(R.id.et_userId);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin = findViewById(R.id.btn_login);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                if (mEtUerId.getText().toString().trim().length() == 0) {
                    mEtUerId.setError("Username is not entered");
                    mEtUerId.requestFocus();
                } else if (mEtPassword.getText().toString().trim().length() == 0) {
                    mEtPassword.setError("Password is not entered");
                    mEtPassword.requestFocus();
                }
                else {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
        }

    }


    private boolean validateEmail() {
        String email = mEtUerId.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            mTilUserId.setError(getString(R.string.err_msg_email));
            requestFocus(mEtUerId);
            return false;
        } else {
            mTilUserId.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (mEtPassword.getText().toString().trim().isEmpty()) {
            mTilPassword.setError(getString(R.string.err_msg_password));
            requestFocus(mEtPassword);
            return false;
        } else {
            mTilPassword.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {

                case R.id.et_userId:
                    validateEmail();
                    break;
                case R.id.et_password:
                    validatePassword();
                    break;
            }
        }
    }
}
