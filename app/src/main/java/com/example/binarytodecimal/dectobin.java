package com.example.binarytodecimal;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dectobin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dectobin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public dectobin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dectobin.
     */
    // TODO: Rename and change types and number of parameters
    public static dectobin newInstance(String param1, String param2) {
        dectobin fragment = new dectobin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "HELLO", Toast.LENGTH_SHORT).show();
        View view= inflater.inflate(R.layout.fragment_dectobin, container, false);
        AppCompatButton appCompatButton=(AppCompatButton)view.findViewById(R.id.pressed_DEC_TO_BIN);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText)view.findViewById(R.id.enter_DEC_TO_BIN);
                String st=editText.getText().toString();
                Log.d("answ",st);
                if (st!=null && !st.equals("")){
                    dec_bin(st);
                    Log.d("answ","st "+st);
                }else {
                    Toast.makeText(getContext(), "PLEASE ENTER VALUE TO PROCEED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    public void dec_bin(String st){
        int dec=Integer.parseInt(st);
        Log.d("answ","dec "+dec);
        if(dec==0){
            Toast.makeText(getContext(),0+"\nIS THE CONVERTED NUMBER", Toast.LENGTH_SHORT).show();
        } else if (dec>0) {
            Toast.makeText(getContext(),converted(dec)+"\nIS THE CONVERTED NUMBER", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(),"CURRENTLY NOT ACCEPTING VALUES LESS THEN 0", Toast.LENGTH_SHORT).show();
        }
    }
    public String converted(int number){
        if (number==1){
            Log.d("answ","1 hit");
            return "1";
        }
        Log.d("answ","number% "+number%2);
        Log.d("answ","number/ "+number/2);

        return converted(((int)(number/2)))+number%2;
    }
}