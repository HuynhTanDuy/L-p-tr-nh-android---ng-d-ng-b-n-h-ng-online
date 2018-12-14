package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ntd.shopping.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.Cart;

public class CartAdapter extends BaseAdapter {
    Context context;
    ArrayList<Cart> arrCart;

    public CartAdapter(Context context, ArrayList<Cart> arrCart) {
        this.context = context;
        this.arrCart = arrCart;
    }

    @Override
    public int getCount() {
        return arrCart.size();
    }

    @Override
    public Object getItem(int position) {
        return arrCart.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txtcartname,txtcartcost;
        public ImageView imgcart;
        public Button btnminus,btnvalues,btnplus;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.dong_cart,null);
            viewHolder.txtcartname = (TextView) convertView.findViewById(R.id.textviewcartname);
            viewHolder.txtcartcost = (TextView) convertView.findViewById(R.id.textviewcartcost);
            viewHolder.imgcart = (ImageView) convertView.findViewById(R.id.imageviewcart);
            viewHolder.btnminus = (Button) convertView.findViewById(R.id.buttonminus);
            viewHolder.btnvalues = (Button) convertView.findViewById(R.id.buttonvalue);
            viewHolder.btnplus = (Button) convertView.findViewById(R.id.buttonplus);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Cart cart= (Cart) getItem(position);
        viewHolder.txtcartname.setText(cart.getProductName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtcartcost.setText(decimalFormat.format(cart.getPrice() + " Đ"));
        Picasso.with(context).load(cart.getProductImage())
                .error(R.drawable.error)
                .into(viewHolder.imgcart);
        viewHolder.btnvalues.setText(cart.getProductNumber());
        return convertView;
    }
}
