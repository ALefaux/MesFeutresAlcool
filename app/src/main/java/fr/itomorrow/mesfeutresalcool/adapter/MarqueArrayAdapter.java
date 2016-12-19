package fr.itomorrow.mesfeutresalcool.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import fr.itomorrow.mesfeutresalcool.R;
import fr.itomorrow.mesfeutresalcool.database.Marque;
import fr.itomorrow.mesfeutresalcool.fragments.AjouterMarqueFragment;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * Created by Axou on 10/12/2016.
 */

public class MarqueArrayAdapter extends ArrayAdapter<Marque> implements View.OnClickListener {

    private Context mContext;

    private List<Marque> mListMarques;
    private Marque mCurrentMarque;

    private TextView mTextViewMarque;
    private ImageButton mModifierImageButton;

    private FragmentManagerInterface mFragmentManager;

    public MarqueArrayAdapter(Context context, int ressource, List<Marque> objects){
        super(context, R.layout.row_marque, objects);

        mContext = context;
        this.mListMarques = objects;
    }

    public void setFragmentManager(FragmentManagerInterface sFragmentManager){
        this.mFragmentManager = sFragmentManager;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rView = inflater.inflate(R.layout.row_marque, parent, false);

        mTextViewMarque = (TextView) rView.findViewById(R.id.fragment_marque_row_marque_textview);
        mModifierImageButton = (ImageButton) rView.findViewById(R.id.fragment_marque_modifier_imagebutton);

        mTextViewMarque.setText(mListMarques.get(position).getMarque());
        mModifierImageButton.setOnClickListener(this);

        mCurrentMarque = mListMarques.get(position);

        return rView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_marque_modifier_imagebutton:

                AjouterMarqueFragment tFragment = new AjouterMarqueFragment();

                Log.i(getClass().getName(), "IDMARQUE : " + mCurrentMarque.getIdMarque());

                Bundle tBundle = new Bundle();
                tBundle.putInt("INT_MARQUE", mCurrentMarque.getIdMarque());
                tBundle.putString("STRING_MARQUE", mCurrentMarque.getMarque());

                mFragmentManager.showFragment(tFragment, tBundle);

                break;
        }
    }
}
