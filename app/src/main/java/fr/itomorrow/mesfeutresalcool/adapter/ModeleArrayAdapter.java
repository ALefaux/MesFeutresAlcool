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
import fr.itomorrow.mesfeutresalcool.database.Modele;

/**
 * Created by Axou on 10/12/2016.
 */

public class ModeleArrayAdapter extends ArrayAdapter<Modele> {

    private Context mContext;
    private List<Modele> mModele;

    private TextView mTextViewModele;
    private TextView mTextViewCouleur;
    private TextView mTextViewCode;

    public ModeleArrayAdapter(Context sContext, int sRessource, List<Modele> sObjects){
        super(sContext, R.layout.row_modele, sObjects);

        this.mContext = sContext;
        this.mModele = sObjects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater tLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rView = tLayoutInflater.inflate(R.layout.row_modele, parent, false);

        mTextViewModele = (TextView) rView.findViewById(R.id.fragment_modele_row_modele_textview);
        mTextViewCouleur = (TextView) rView.findViewById(R.id.fragment_modele_row_couleur_textview);
        mTextViewCode = (TextView) rView.findViewById(R.id.fragment_modele_row_code_textview);

        mTextViewModele.setText(mModele.get(position).getmModele());
        mTextViewCouleur.setText(mModele.get(position).getmCouleur());
        mTextViewCode.setText(mModele.get(position).getmCode());

        return rView;
    }
}
