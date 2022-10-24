package com.pkasemer.myshell.Fragments;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.pkasemer.myshell.Apis.TakaApiBase;
import com.pkasemer.myshell.Apis.TakaApiService;
import com.pkasemer.myshell.HelperClasses.SharedPrefManager;
import com.pkasemer.myshell.Models.PickupResponse;
import com.pkasemer.myshell.Models.RequestPickupModel;
import com.pkasemer.myshell.Models.UserModel;
import com.pkasemer.myshell.R;
import com.pkasemer.myshell.ShiftActivity;

import java.util.concurrent.TimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Trash extends Fragment {

    public Trash() {
        // Required empty public constructor
    }

    RelativeLayout day_shift_layout, night_shift_layout;
    View view;
    private TakaApiService takaApiService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trash, container, false);
        day_shift_layout = view.findViewById(R.id.day_shift_layout);
        night_shift_layout = view.findViewById(R.id.night_shift_layout);

        day_shift_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), ShiftActivity.class);
                intent.putExtra(getString(R.string.shift_lable), "Day Shift");
                intent.putExtra(getString(R.string.shift_type_id), "shell_day_001");
                startActivity(intent);

            }
        });

        night_shift_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ShiftActivity.class);
                intent.putExtra(getString(R.string.shift_lable), "Night Shift");
                intent.putExtra(getString(R.string.shift_type_id), "shell_night_002");
                startActivity(intent);
            }
        });

        takaApiService = TakaApiBase.getClient(getContext()).create(TakaApiService.class);

        return view;
    }




}