package me.aksamitsah.trivia.fragment;

import static me.aksamitsah.trivia.fragment.NameFragment.KEY_TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import me.aksamitsah.trivia.Function;
import me.aksamitsah.trivia.R;
import me.aksamitsah.trivia.database.DBHandler;

public class SummeryFragment extends Fragment {

    View view;
    TextView txt_name, txt_indianColor, txt_bestCricketer;
    Button btnTryAgain;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_summery, container, false);

        txt_name = view.findViewById(R.id.txt_name);
        txt_indianColor = view.findViewById(R.id.txt_indianColor);
        txt_bestCricketer = view.findViewById(R.id.txt_bestCricketer);

        btnTryAgain = view.findViewById(R.id.btnTryAgain);

        displayValue();

        btnTryAgain.setOnClickListener(v -> getFragmentManager().beginTransaction().replace(R.id.frameLayout, new NameFragment()).commit());

        return view;
    }

    @SuppressLint("SetTextI18n")
    public void displayValue() {

        Bundle bundle = this.getArguments();
        assert bundle != null;
        String[] data = bundle.getStringArray(KEY_TAG);

        headingName(data[0]);
        txt_bestCricketer.setText("Answer: " + data[1]);
        txt_indianColor.setText("Answer: \" " + data[2] + " \"");

        DBHandler dbhandler = new DBHandler(getContext());
        dbhandler.addScoreData(data[0], data[1], data[2], Function.cuurentTimeAndDateMillis());
    }

    public void headingName(String name) {
        String s = "Hello, \"" + name +" \",";
        SpannableString spannableString = new SpannableString(s);
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.5f);
        spannableString.setSpan(sizeSpan, 7, s.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        txt_name.setText(spannableString);
    }
}