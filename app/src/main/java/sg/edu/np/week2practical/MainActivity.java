package sg.edu.np.week2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    private int randomnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent recievedata = getIntent();
        randomnum = recievedata.getIntExtra("randomnumber", 0);

        TextView helloworld = findViewById(R.id.helloworld);
        helloworld.setText("MAD " + randomnum);
        User user = new User("Sherwin", "Phone's Owner",2, false);

        Button followbutton = (Button) findViewById(R.id.followbutton);
        followbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if (user.followed == true){
                    followbutton.setText("Unfollow");
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    
                    Log.v(TAG, "Followed");
                }

                else if (user.followed == false){
                    followbutton.setText("Follow");
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "Unfollowed");
                }

                else{
                    Log.v(TAG, "Cannot find user follow or not");
                }

            }
        });


        Log.v(TAG, "On Create!");
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy!");
    }


}

