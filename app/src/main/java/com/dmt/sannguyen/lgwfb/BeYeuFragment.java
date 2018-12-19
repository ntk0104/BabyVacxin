package com.dmt.sannguyen.lgwfb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeYeuFragment extends Fragment {

    private String userID;


    public BeYeuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Receive the bundle data of user logged in from MainActivity
        Bundle bundle = getArguments();
        //Receive the ID of user logged in
        userID = bundle.getString("userid");
        Log.d("Track", "UserID at BeYeuFragment:" + userID);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_be_yeu, container, false);
    }

}
