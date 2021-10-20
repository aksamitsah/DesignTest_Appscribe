package me.aksamitsah.trivia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


@RequiresApi(api = Build.VERSION_CODES.O)
public final class Function extends AppCompatActivity {


    public static String cuurentTimeAndDateMillis() {

        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("dd-MMM-yyyy, HH:mm");
        return df.format(Calendar.getInstance().getTime());

    }

    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void intentActivitySplash(Context activityThis, Class<MainScreen> activityNew) {
        Intent i = new Intent(activityThis, activityNew);
        activityThis.startActivity(i);

    }

    public static void intentActivity(Context activityThis, Class<PlayHistory> activityNew) {
        Intent i = new Intent(activityThis, activityNew);
        activityThis.startActivity(i);

    }

    public static String[] newStringArray(String[] data, String color_data) {
        String[] copy = Arrays.copyOf(data, data.length + 1);
        copy[copy.length - 1] = color_data;
        return copy;
    }


}
