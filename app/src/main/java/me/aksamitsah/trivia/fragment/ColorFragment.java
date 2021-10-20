package me.aksamitsah.trivia.fragment;

import static me.aksamitsah.trivia.fragment.NameFragment.KEY_TAG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

import me.aksamitsah.trivia.Function;
import me.aksamitsah.trivia.R;

public class ColorFragment extends Fragment {

    View view;
    Button btnNext;
    CheckBox checkBox_white, checkBox_yellow, checkBox_green, checkBox_orange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_color, container, false);
        btnNext = view.findViewById(R.id.btn_next);


        btnNext.setOnClickListener(v -> {

            String color_data = getcolorData();
            if (color_data.isEmpty()) {
                Function.toastMessage(getContext(), "Check at least One of them");
            } else {
                Bundle bundle = this.getArguments();
                assert bundle != null;
                String[] data = bundle.getStringArray(KEY_TAG);

                String[] newData = Function.newStringArray(data, color_data);

                bundle.putStringArray(KEY_TAG, newData);
                SummeryFragment fragment = new SummeryFragment();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
            }

        });

        return view;
    }


    private String getcolorData() {

        checkBox_white = view.findViewById(R.id.checkBox_white_three);
        checkBox_yellow = view.findViewById(R.id.checkBox_yellow_three);
        checkBox_green = view.findViewById(R.id.checkBox_green_three);
        checkBox_orange = view.findViewById(R.id.checkBox_orange_three);


        StringBuilder data = new StringBuilder();
        if (checkBox_white.isChecked()) {
            data.append("White");
        }
        if (checkBox_yellow.isChecked()) {
            checkClicked(data);
            data.append("Yellow");
        }
        if (checkBox_green.isChecked()) {
            checkClicked(data);
            data.append("Green");
        }
        if (checkBox_orange.isChecked()) {
            checkClicked(data);
            data.append("Orange");
        }

        return data.toString();
    }

    private void checkClicked(StringBuilder data) {
        if (data.length()!=0)
        {
            data.append(", ");
        }
    }
}