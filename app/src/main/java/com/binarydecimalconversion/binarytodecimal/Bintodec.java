package com.binarydecimalconversion.binarytodecimal;

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
 * Use the {@link Bintodec#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bintodec extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Bintodec() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bintodec.
     */
    // TODO: Rename and change types and number of parameters
    public static Bintodec newInstance(String param1, String param2) {
        Bintodec fragment = new Bintodec();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bintodec, container, false);
        AppCompatButton appCompatButton=(AppCompatButton) view.findViewById(R.id.pressed_BIN_TO_DEC);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=view.findViewById(R.id.bin_to_dec_ans);
                Log.d("ans","edittext "+editText.getText().toString());
                String st=editText.getText().toString();
                Log.d("ans","st1 "+st);
                if (st!=null && !st.equals("")){
                    Log.d("ans","st2 "+st);
                    bin_dec(st);
                }else {
                    Toast.makeText(getContext(), "PLEASE ENTER VALUE TO PROCEED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    public void bin_dec(String bin){
        if(Integer.parseInt(bin)==0){
            Toast.makeText(getContext(),0+"\nIS THE CONVERTED NUMBER", Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(bin)>0) {
            int at=0;
            int ans=0;
            for (int i = bin.length()-1; i>=0; i--){
                Character character=bin.charAt(i);
                int last=Integer.parseInt(String.valueOf(character));
                if (last==1 || last==0){
                    ans+=(int)(last*((int)Math.pow(2,at)));
                    at++;
                }else {
                    Toast.makeText(getContext(),"NUMBER ENTERED DOES NOT MATCH WITH BINARY CODES", Toast.LENGTH_SHORT).show();
                }
            }
            Toast.makeText(getContext(),ans+"\nIS THE CONVERTED NUMBER", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getContext(),"CURRENTLY NOT ACCEPTING VALUES LESS THEN 0", Toast.LENGTH_SHORT).show();
        }
    }
}