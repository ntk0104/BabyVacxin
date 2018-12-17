package com.dmt.sannguyen.lgwfb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BeYeuActivity extends AppCompatActivity {

    TextView txtID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_yeu);

        txtID = findViewById(R.id.txtID);
        Bundle bundle = getIntent().getExtras();
        String userid = bundle.getString("userid");
        txtID.setText(userid);
    }
}
