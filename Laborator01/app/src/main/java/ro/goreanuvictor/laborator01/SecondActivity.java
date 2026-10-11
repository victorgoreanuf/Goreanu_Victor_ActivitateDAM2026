package ro.goreanuvictor.laborator01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    static final String EXTRA_MESSAGE = "mesaj";
    static final String EXTRA_FIRST_VALUE = "valoare1";
    static final String EXTRA_SECOND_VALUE = "valoare2";
    static final String EXTRA_SUM = "suma";

    private final ActivityResultLauncher<Intent> thirdActivityLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle data = result.getData().getExtras();
                    if (data != null) {
                        String message = data.getString(EXTRA_MESSAGE);
                        int sum = data.getInt(EXTRA_SUM);
                        Toast.makeText(this, getString(R.string.received_result, message, sum),
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button openThirdActivityButton = findViewById(R.id.open_third_activity_button);
        openThirdActivityButton.setOnClickListener(view -> {
            Bundle data = new Bundle();
            data.putString(EXTRA_MESSAGE, getString(R.string.message_from_second));
            data.putInt(EXTRA_FIRST_VALUE, 10);
            data.putInt(EXTRA_SECOND_VALUE, 20);

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtras(data);
            thirdActivityLauncher.launch(intent);
        });
    }
}
