package com.dmt.sannguyen.lgwfb;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private BeYeuFragment beYeuFragment;
    private SoTiemFragment soTiemFragment;
    private DiemTiemChungFragment diemTiemChungFragment;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.main_frame);
        beYeuFragment = new BeYeuFragment();
        soTiemFragment = new SoTiemFragment();
        diemTiemChungFragment = new DiemTiemChungFragment();
        //Receive Bundle data of user logged in
        Bundle bundle = this.getIntent().getExtras();
        // Receive the ID of user logged in
        userID = bundle.getString("userid");
        Log.d("Track", "UserID at mainActivity:" + userID);

        setFragment(beYeuFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_beyeu :
                        setFragment(beYeuFragment);
                        return true;

                    case R.id.nav_sotiem :
                        setFragment(soTiemFragment);
                        return true;

                    case R.id.nav_tramtiemchung :
                        setFragment(diemTiemChungFragment);
                        return true;

                    default:
                        return false;

                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        Bundle bundle = new Bundle();
        bundle.putString("userid", userID);
        fragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
