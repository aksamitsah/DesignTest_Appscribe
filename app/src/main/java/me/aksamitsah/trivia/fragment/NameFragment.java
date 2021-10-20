package me.aksamitsah.trivia.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import me.aksamitsah.trivia.Function;
import me.aksamitsah.trivia.R;

public class NameFragment extends Fragment {


    public static final String KEY_TAG = "my_key_value";

    View view;
    Button btnNext;
    EditText text_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_name, container, false);

        btnNext = view.findViewById(R.id.btn_next);
        text_name = view.findViewById(R.id.etxt_name);


        btnNext.setOnClickListener(v -> {

            String name_value = text_name.getText().toString();

            if (name_value.isEmpty()) {
                Function.toastMessage(getContext(), "Enter Your Name");
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_TAG, name_value);

                CricketerFragment fragment = new CricketerFragment();
                fragment.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
            }
        });
        return view;
    }
}