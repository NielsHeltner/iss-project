package dk.sdu.mmmi.iss.behealthy.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dk.sdu.mmmi.iss.behealthy.R;
import dk.sdu.mmmi.iss.behealthy.model.DataProvider;

public class MainActivity extends AppCompatActivity {

    private TextView dataProviderSelectionHeader;
    private RecyclerView dataProviderSelectionList;
    private DataProviderSelectionListAdapter exerciseProviderSelectionListAdapter;
    private DataProviderSelectionListAdapter nutritionProviderSelectionListAdapter;
    private DataProviderSelectionListAdapter healthGoalSelectionListAdapter;
    private DataProviderSelectionListAdapter exerciseFitnessSelectionListAdapter;

    private DataProvider[] exerciseDataProviders = {
            new DataProvider("Endomondo"),
            new DataProvider("Google Fit"),
            new DataProvider("RunKeeper"),
            new DataProvider("Nike Run Club"),
            new DataProvider("AllTrails"),
            new DataProvider("FitNotes"),
            new DataProvider("Stronglifts")
    };
    private DataProvider[] nutritionDataProviders = {
            new DataProvider("MyFitnessPal"),
            new DataProvider("Lifesum"),
            new DataProvider("Fooducate"),
            new DataProvider("Nourishly"),
            new DataProvider("Nutrients"),
            new DataProvider("MyNetDiary")
    };

    private DataProvider[] healthGoals = {
            new DataProvider("I want to lose weight"),
            new DataProvider("I want to maintain weight"),
            new DataProvider("I want to gain weight")
    };

    private DataProvider[] exercisePreferences = {
            new DataProvider("I prefer endurance exercises"),
            new DataProvider("I prefer strength exercises"),
            new DataProvider("I prefer both")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataProviderSelectionHeader = findViewById(R.id.dashboardHeader);

        dataProviderSelectionList = findViewById(R.id.dataProviderSelectionList);
        dataProviderSelectionList.setHasFixedSize(true);
        dataProviderSelectionList.setLayoutManager(new LinearLayoutManager(this));

        changeSelectionToExercise();
    }

    private void changeSelectionToExercise() {
        dataProviderSelectionHeader.setText("Select exercise data provider");

        exerciseProviderSelectionListAdapter = new DataProviderSelectionListAdapter(exerciseDataProviders, () -> changeSelectionToNutrition());
        dataProviderSelectionList.setAdapter(exerciseProviderSelectionListAdapter);
    }

    private void changeSelectionToNutrition() {
        dataProviderSelectionHeader.setText("Select nutrition data provider");

        nutritionProviderSelectionListAdapter = new DataProviderSelectionListAdapter(nutritionDataProviders, () -> changeSelectionToHealthGoals());
        dataProviderSelectionList.setAdapter(nutritionProviderSelectionListAdapter);
    }

    private void changeSelectionToHealthGoals() {
        dataProviderSelectionHeader.setText("Select health goals");

        healthGoalSelectionListAdapter = new DataProviderSelectionListAdapter(healthGoals, () -> changeSelectionToExercisePreferences());
        dataProviderSelectionList.setAdapter(healthGoalSelectionListAdapter);
    }

    private void changeSelectionToExercisePreferences() {
        dataProviderSelectionHeader.setText("Select exercise preferences");

        exerciseFitnessSelectionListAdapter = new DataProviderSelectionListAdapter(exercisePreferences, () -> changeActivityToDashboard());
        dataProviderSelectionList.setAdapter(exerciseFitnessSelectionListAdapter);
    }

    private void changeActivityToDashboard() {
        Intent dashboardIntent = new Intent(this, DashboardActivity.class);
        dashboardIntent.putExtra("exercise", exerciseProviderSelectionListAdapter.getSelectedDataProvider());
        dashboardIntent.putExtra("nutrition", nutritionProviderSelectionListAdapter.getSelectedDataProvider());

        startActivity(dashboardIntent);
    }

}
