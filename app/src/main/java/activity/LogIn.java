package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ntd.shopping.R;

import util.CheckInternetConnection;

public class LogIn extends AppCompatActivity {
    EditText name;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        name = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.userpassword);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String username,String userpassword)
    {
        if(userpassword.equals("1234"))
        {
            if(username.equals("Admin")) {
                MainActivity.islogin = true;
                Intent intent = new Intent(getApplicationContext(), loading.class);
                startActivity(intent);

            }
        }
        else
        {
            CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Wrong username or password");
        }
    }
}
