package ro.goreanuvictor.laborator01;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicluViata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
        Log.w(TAG, "onStart()");
        Log.d(TAG, "onStart()");
        Log.i(TAG, "onStart()");
        Log.v(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
        Log.w(TAG, "onResume()");
        Log.d(TAG, "onResume()");
        Log.i(TAG, "onResume()");
        Log.v(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
        Log.w(TAG, "onPause()");
        Log.d(TAG, "onPause()");
        Log.i(TAG, "onPause()");
        Log.v(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
        Log.w(TAG, "onStop()");
        Log.d(TAG, "onStop()");
        Log.i(TAG, "onStop()");
        Log.v(TAG, "onStop()");
    }
}
