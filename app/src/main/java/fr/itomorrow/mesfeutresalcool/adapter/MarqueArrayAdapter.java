package fr.itomorrow.mesfeutresalcool.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.itomorrow.mesfeutresalcool.R;
import fr.itomorrow.mesfeutresalcool.database.Marque;

/**
 * Created by Axou on 10/12/2016.
 */

public class MarqueArrayAdapter extends ArrayAdapter<Marque> {

    private Context mContext;
    private List<Marque> mMarques;
    private TextView mTextViewMarque;

    public MarqueArrayAdapter(Context context, int ressource, List<Marque> objects){
        super(context, R.layout.row_marque, objects);

        this.mContext = context;
        this.mMarques = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rView = inflater.inflate(R.layout.row_marque, parent, false);

        mTextViewMarque = (TextView) rView.findViewById(R.id.fragment_marque_row_marque_textview);
        mTextViewMarque.setText(mMarques.get(position).getMarque());
        return rView;
    }
}
