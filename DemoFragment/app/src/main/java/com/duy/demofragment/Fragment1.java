package com.duy.demofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    // gán callback đc define ở activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onButtonClickCallBack = (OnButtonClickCallBack) context;
    }

    public interface OnButtonClickCallBack {
        public void onButtonClick(String text, int textSize);
    }

    OnButtonClickCallBack onButtonClickCallBack;
    int seedBarValue = 0;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    // khi các view đã đc khởi tạo => findViewById không bị null
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SeekBar seekBar = view.findViewById(R.id.seedBar);
        final EditText editText = view.findViewById(R.id.editText);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickCallBack.onButtonClick(editText.getText().toString(), seedBarValue);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seedBarValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
