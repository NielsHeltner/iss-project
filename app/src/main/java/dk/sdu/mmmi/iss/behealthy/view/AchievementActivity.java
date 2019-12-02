package dk.sdu.mmmi.iss.behealthy.view;

import androidx.appcompat.app.AppCompatActivity;
import dk.sdu.mmmi.iss.behealthy.R;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AchievementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        findViewById(R.id.achievementImageView).setOnClickListener(v -> Toast.makeText(this, randomToast(), Toast.LENGTH_SHORT).show());
    }

    public String randomToast() {
        ArrayList<String> adviceArrayList = new ArrayList<>();
        adviceArrayList.add("Nice! You're only 10 % away from your daily step goal!");
        adviceArrayList.add("Nice! You're only 5 % away from your daily running goal!");
        adviceArrayList.add("Its very nice weather today, you can safely exercise outdoors!");
        adviceArrayList.add("Well done! You have achieved your daily goal!");
        adviceArrayList.add("Well done! You have run 250 km. in total!");
        adviceArrayList.add("Well done! You have biked 1000 km. in total!");
        adviceArrayList.add("Well done! You have achieved a new blood pressure high score!");
        adviceArrayList.add("Well done! You have achieved a new record in running!");

        Random ran = new Random();
        int x = ran.nextInt(8) ;
        return adviceArrayList.get(x);
    }
}
