package dk.sdu.mmmi.iss.behealthy.view;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import dk.sdu.mmmi.iss.behealthy.R;
import dk.sdu.mmmi.iss.behealthy.model.DataProvider;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Intent intent = getIntent();
        DataProvider exerciseProvider = (DataProvider) intent.getSerializableExtra("exercise");
        DataProvider nutritionProvider = (DataProvider) intent.getSerializableExtra("nutrition");

        TextView exerciseProviderText = findViewById(R.id.exerciseProviderText);
        TextView nutritionProviderText = findViewById(R.id.nutritionProviderText);
        exerciseProviderText.setText(exerciseProvider.getName());
        nutritionProviderText.setText(nutritionProvider.getName());

        exerciseProviderText.setOnClickListener(v -> Toast.makeText(this, "Opening " + exerciseProvider.getName() + "...", Toast.LENGTH_SHORT).show());
        nutritionProviderText.setOnClickListener(v -> Toast.makeText(this, "Opening " + nutritionProvider.getName() + "...", Toast.LENGTH_SHORT).show());
    }

}
