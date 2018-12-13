package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.ntd.shopping.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import model.Product;

public class ChiTietSanPham extends AppCompatActivity {
    Toolbar toolbarChitiet;
    ImageView imgChitiet;
    TextView txtten,txtgia,txtmota;
    Spinner spinner;
    Button btndatmua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        AnhXa();
        ActionToolBar();
        GetInformation();
        CatchEventSpinner();
    }

    private void CatchEventSpinner() {
        Integer[] number = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_dropdown_item,number);
        spinner.setAdapter(arrayAdapter);
    }

    private void GetInformation() {
        int id = 0;
        String Tenchitiet = "";
        int Giachitiet=0;
        String Hinhanhchitiet = "";
        String Motachitiet = "";
        int Idsanpham = 0;

        Product product = (Product) getIntent().getSerializableExtra("productData");
        id = product.getID();
        Tenchitiet = product.getProductName();
        Giachitiet = product.getPrice();
        Hinhanhchitiet = product.getImage();
        Motachitiet = product.getProductDetail();
        Idsanpham = product.getProductID();

        txtten.setText(Tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText("Giá : "+decimalFormat.format(Giachitiet)+" Đ");
        txtmota.setText(Motachitiet);
        Picasso.with(getApplicationContext()).load(Hinhanhchitiet)
                .placeholder(R.drawable.error)
                .error(R.drawable.error)
                .into(imgChitiet);
    }

    private void ActionToolBar() {
        setSupportActionBar(toolbarChitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void AnhXa() {
        toolbarChitiet= (Toolbar) findViewById(R.id.toolbarchitietsanpham);
        imgChitiet= (ImageView) findViewById(R.id.imageviewchitietsanpham);
        txtten= (TextView) findViewById(R.id.textviewtenchitietsanpham);
        txtgia= (TextView) findViewById(R.id.textviewgiachitietsanpham);
        txtmota= (TextView) findViewById(R.id.textviewmotachitietsanpham);
        spinner= (Spinner) findViewById(R.id.spinner);
        btndatmua= (Button) findViewById(R.id.buttondatmua);
    }
}
