package ro.goreanuvictor.laborator01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle data = getIntent().getExtras();
        if (data == null) {
            finish();
            return;
        }

        String message = data.getString(SecondActivity.EXTRA_MESSAGE);
        int firstValue = data.getInt(SecondActivity.EXTRA_FIRST_VALUE);
        int secondValue = data.getInt(SecondActivity.EXTRA_SECOND_VALUE);
        if (savedInstanceState == null) {
            Toast.makeText(this, getString(R.string.received_values, message, firstValue, secondValue),
                    Toast.LENGTH_LONG).show();
        }

        Button returnResultButton = findViewById(R.id.return_result_button);
        returnResultButton.setOnClickListener(view -> {
            Bundle resultData = new Bundle();
            resultData.putString(SecondActivity.EXTRA_MESSAGE, getString(R.string.message_from_third));
            resultData.putInt(SecondActivity.EXTRA_SUM, firstValue + secondValue);

            Intent result = new Intent();
            result.putExtras(resultData);
            setResult(RESULT_OK, result);
            finish();
        });
    }
}
