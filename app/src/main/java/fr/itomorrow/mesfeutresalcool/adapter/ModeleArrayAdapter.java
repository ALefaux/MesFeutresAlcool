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
import fr.itomorrow.mesfeutresalcool.database.Modele;
import fr.itomorrow.mesfeutresalcool.fragments.AjouterModeleFragment;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * Created by Axou on 10/12/2016.
 */

public class ModeleArrayAdapter extends ArrayAdapter<Modele> {

    private Context mContext;

    private List<Modele> mListModeles;
    private Modele mCurrentModele;

    private TextView mTextViewModele;
    private TextView mTextViewCouleur;
    private TextView mTextViewCode;
    private ImageButton mImageButtonModifier;
    private ImageButton mImageButtonSupprimer;

    private FragmentManagerInterface mFragmentManager;

    public ModeleArrayAdapter(Context sContext, int sRessource, List<Modele> sObjects){
        super(sContext, R.layout.row_modele, sObjects);

        this.mContext = sContext;
        this.mListModeles = sObjects;
    }

    public void setmFragmentManager(FragmentManagerInterface sFragmentManager){
        this.mFragmentManager = sFragmentManager;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater tLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rView = tLayoutInflater.inflate(R.layout.row_modele, parent, false);
        mCurrentModele = mListModeles.get(position);

        mTextViewModele = (TextView) rView.findViewById(R.id.fragment_modele_row_modele_textview);
        mTextViewCouleur = (TextView) rView.findViewById(R.id.fragment_modele_row_couleur_textview);
        mTextViewCode = (TextView) rView.findViewById(R.id.fragment_modele_row_code_textview);
        mImageButtonModifier = (ImageButton) rView.findViewById(R.id.fragment_rowmodele_modifier_imagebutton);
        mImageButtonSupprimer = (ImageButton) rView.findViewById(R.id.fragment_rowmodele_supprimer_imagebutton);

        mImageButtonModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(getClass().getName(), "ID_MODELE_MODELEARRAYADAPTER : " + mCurrentModele.getmIdModele());
            }
        });
        //mImageButtonSupprimer.setOnClickListener(this);

        mTextViewModele.setText(mCurrentModele.getmModele());
        mTextViewCouleur.setText(mCurrentModele.getmCouleur());
        mTextViewCode.setText(mCurrentModele.getmCode());

        return rView;
    }
/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_rowmodele_modifier_imagebutton:
                AjouterModeleFragment tFragment = new AjouterModeleFragment();

                Bundle tBundle = new Bundle();
                Log.i(getClass().getName(), "ID_MODELE : " + mCurrentModele.getmIdModele());
                tBundle.putInt("IDMODELE_INT", mCurrentModele.getmIdModele());
                tBundle.putString("MODELE_STRING", mCurrentModele.getmModele());
                tBundle.putString("COULEUR_STRING", mCurrentModele.getmCouleur());
                tBundle.putString("CODE_STRING", mCurrentModele.getmCode());
                tBundle.putInt("ID_MARQUE", mCurrentModele.getmIdMarque());

                mFragmentManager.showFragment(tFragment, tBundle);

                break;
            case R.id.fragment_rowmodele_supprimer_imagebutton:
                break;
        }
    }*/
}
