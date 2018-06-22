package com.example.admin.luckycup.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.luckycup.Beans.Partida;
import com.example.admin.luckycup.Beans.Selecao;

import java.util.List;

/**
 * Created by Admin on 19/06/2018.
 */

public class SelecaoSpinnerAdapter extends ArrayAdapter<Selecao> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<Selecao> values;

    public SelecaoSpinnerAdapter(Context context, List<Selecao> values) {
        super(context, android.R.layout.simple_list_item_1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount(){
        return values.size();
    }

    @Override
    public Selecao getItem(int position){
        return values.get( position );
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(android.R.layout.simple_list_item_1, null);
        }

        Selecao s = getItem(position);

        if (s != null) {

            TextView label = v.findViewById( android.R.id.text1 );
            label.setTextColor( Color.BLACK );

            label.setText( s.getNome() );
        }

        return v;
    }
}
