package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ntd.shopping.R;

import java.util.HashMap;
import java.util.Map;

import util.CheckInternetConnection;
import util.Sever;

public class CustomerInfo extends AppCompatActivity {

    EditText edtCustomerName,edtEmail,edtPhoneNumber;
    Button btnConfirm,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        Anhxa();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(CheckInternetConnection.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else{
            CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Ban Hay kiem tra lai ket noi");
        }
    }

    private void EventButton() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Name = edtCustomerName.getText().toString().trim();
                final String Phone = edtPhoneNumber.getText().toString().trim();
                final String email = edtEmail.getText().toString().trim();
                if(Name.length()>0&& Phone.length()>0&&email.length()>0){
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.billlink, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("Ma don hang",response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap= new HashMap<String,String>();
                            hashMap.put("customername",Name);
                            hashMap.put("phonenumber",Phone);
                            hashMap.put("email",email);
                            return hashMap;
                        }
                    };
                    requestQueue.add(stringRequest);
                }else{
                    CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Kiem Tra Lai Du Lieu");
                }
            }
        });
    }

    private void Anhxa() {
        edtCustomerName = findViewById(R.id.edittextcustomername);
        edtEmail  =findViewById(R.id.edittextemail);
        edtPhoneNumber = findViewById(R.id.edittextphonenumber);
        btnConfirm = findViewById(R.id.buttonvertify);
        btnBack = findViewById(R.id.buttonback);
    }
}
