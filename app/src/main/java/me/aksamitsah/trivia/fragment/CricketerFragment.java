package me.aksamitsah.trivia.fragment;

import static me.aksamitsah.trivia.fragment.NameFragment.KEY_TAG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import me.aksamitsah.trivia.Function;
import me.aksamitsah.trivia.R;


public class CricketerFragment extends Fragment {


    View view;
    Button btnNext;
    RadioGroup radioGrp;
    RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_cricketer, container, false);

        btnNext = view.findViewById(R.id.btn_next);
        radioGrp = view.findViewById(R.id.rdo_ans_two);

        btnNext.setOnClickListener(v -> {

            radioButton = radioGrp.findViewById(radioGrp.getCheckedRadioButtonId());
            try {
                if (radioButton.getText().length() != 0) {
                    Bundle bundle = this.getArguments();

                    String data = (String) radioButton.getText();

                    assert bundle != null;
                    String[] arr = {bundle.getString(KEY_TAG), data};
                    bundle.putStringArray(KEY_TAG, arr);

                    ColorFragment fragment = new ColorFragment();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();

                }
            } catch (Exception e) {
                Function.toastMessage(getContext(), "Check any one");
            }
        });
        return view;
    }

}