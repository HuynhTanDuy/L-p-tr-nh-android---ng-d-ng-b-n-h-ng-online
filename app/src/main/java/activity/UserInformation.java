package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import util.CheckInternetConnection;
import com.example.ntd.shopping.R;

public class UserInformation extends AppCompatActivity {
    Button btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        btnlogout = (Button)findViewById(R.id.button);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.islogin=false;
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Logout Success");
            }
        });
    }

}
