package rethinkux.com.bootcamptask2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class ToggleChangeTextActivity extends AppCompatActivity {

    private Switch mSwitchChange;
    private TextView mTextViewChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_change_text);

        mSwitchChange = findViewById(R.id.switch_change);
        mTextViewChange = findViewById(R.id.textView_change);

//        mSwitchChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                mTextViewChange.setText("Absent");
//
//
//
//            }
//        });
        mSwitchChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    mTextViewChange.setText("P");
                }
                else{
                    mTextViewChange.setText("A");
                }
            }
        });

    }
}
