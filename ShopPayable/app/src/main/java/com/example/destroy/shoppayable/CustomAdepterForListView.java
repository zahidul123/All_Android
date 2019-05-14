package com.example.destroy.shoppayable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdepterForListView extends BaseAdapter {

   private Context context;
    private ArrayList<CustomerDetail> adapterCustomise;
    private LayoutInflater inflater;

    public CustomAdepterForListView(Context context, ArrayList<CustomerDetail> customerlist) {
        this.context=context;
        adapterCustomise=customerlist;
    }


    @Override
    public int getCount() {
        return adapterCustomise.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterCustomise.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView==null){
            convertView=inflater.inflate(R.layout.custom_list_view,null);
        }

        TextView name  = (TextView) convertView.findViewById(R.id.nameofcustom);
        TextView phone = (TextView) convertView.findViewById(R.id.phonenumcustom);
        TextView currency = (TextView) convertView.findViewById(R.id.duecustom);

        CustomerDetail customerDetail=adapterCustomise.get(position);
        name.setText(customerDetail.getCname());
        phone.setText(customerDetail.getEmail());
        currency.setText(customerDetail.getCphone());
        return convertView;
    }
}
