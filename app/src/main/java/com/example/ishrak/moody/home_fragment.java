package com.example.ishrak.moody;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moody.R;

public class home_fragment extends Fragment {
    View myView;
    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_frame,container,false);
        return myView;
    }
}
