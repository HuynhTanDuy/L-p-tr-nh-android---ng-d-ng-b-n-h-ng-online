package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.ntd.shopping.R;

import java.text.DecimalFormat;
import java.util.List;

import adapter.CartAdapter;
import model.Cart;

public class CartActivity extends AppCompatActivity {
    ListView lvcart;
    TextView txtNotify;
    TextView txtTotalCash;
    Button btnPay,btnContinueBuy;
    android.support.v7.widget.Toolbar toolbarcart;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Anhxa();
        ActionToolbar();
        CheckData();
        EvenUtils();
    }
    private void EvenUtils(){
        long totalcash = 0;
        for(int i=0;i<MainActivity.arrCart.size();i++)
        {
            totalcash += MainActivity.arrCart.get(i).getPrice();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTotalCash.setText(decimalFormat.format(totalcash)+"D");
    }
    private void CheckData() {
        if(MainActivity.arrCart.size()<=0)
        {
            cartAdapter.notifyDataSetChanged();
            txtNotify.setVisibility(View.VISIBLE);
            lvcart.setVisibility(View.INVISIBLE);
        }else {
            cartAdapter.notifyDataSetChanged();
            txtNotify.setVisibility(View.INVISIBLE);
            lvcart.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolbar() {
        setSupportActionBar(toolbarcart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarcart.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        lvcart = (ListView) findViewById(R.id.listviewcart);
        txtNotify = findViewById(R.id.textviewnotify);
        txtTotalCash = findViewById(R.id.textviewtotalcash);
        btnPay = findViewById(R.id.buttonpaycart);
        btnContinueBuy = findViewById(R.id.buttoncontinueshopping);
        toolbarcart = findViewById(R.id.toolbarcart);
        cartAdapter = new CartAdapter(CartActivity.this,MainActivity.arrCart);
        lvcart.setAdapter(cartAdapter);
    }
}
