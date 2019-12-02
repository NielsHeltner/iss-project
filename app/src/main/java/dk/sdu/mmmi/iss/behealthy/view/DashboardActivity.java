package dk.sdu.mmmi.iss.behealthy.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

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

        findViewById(R.id.fitnessPlan).setOnClickListener(v -> startActivity(new Intent(this, FitnessPlanActivity.class)));
        findViewById(R.id.nutritionPlan).setOnClickListener(v -> startActivity(new Intent(this, NutritionPlanActivity.class)));
        findViewById(R.id.achievementBtn).setOnClickListener(v -> startActivity(new Intent(this, AchievementActivity.class)));
        findViewById(R.id.imageView).setOnClickListener(v -> Toast.makeText(this, randomAdvice(), Toast.LENGTH_SHORT).show());
    }

    public String randomAdvice() {
        ArrayList<String> adviceArrayList = new ArrayList<>();
        adviceArrayList.add("You have hit your daily exercise goal!");
        adviceArrayList.add("You need to hit 2389 kcal today, you only have 843! Keep eating healthy!");
        adviceArrayList.add("Its very nice weather today, you can safely exercise outdoors!");
        adviceArrayList.add("You should go for a run!");
        adviceArrayList.add("If you want to get some extra exercise, try walking for 20 minutes!");
        adviceArrayList.add("You need to exercise more regularly to hit your goals");
        adviceArrayList.add("Well done! You only need to bike 2 km. to hit your daily goal");

        Random ran = new Random();
        int x = ran.nextInt(7) ;
        return adviceArrayList.get(x);
    }

}
