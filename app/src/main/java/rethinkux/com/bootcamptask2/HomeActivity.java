package rethinkux.com.bootcamptask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
//private class MyTextWatcher implements TextWatcher {
//
//    private View view;
//
//    private MyTextWatcher(View view) {
//        this.view = view;
//    }
//
//    @Override
//    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable editable) {
//
//        switch (view.getId()) {
//            case R.id.et_userId:
//                validateEmail();
//                break;
//            case R.id.et_password:
//                validatePassword();
//                break;
//        }
//
//    }
//}
//
//    private void submitForm() {
//
//        if (!validateEmail()) {
//            return;
//        }
//
//        if (!validatePassword()) {
//            return;
//        }
//
//        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
//    }
//
//    private void validateEmail() {
//
//        String email = mEtUerId.getText().toString().trim();
//
//        if (email.isEmpty() || !isValidEmail(email)) {
//            mTilUserId.setError(getString(R.string.err_msg_email));
//            requestFocus(mTilUserId);
//            return false;
//        } else {
//            mTilUserId.setErrorEnabled(false);
//        }
//
//        return true;
//
//    }