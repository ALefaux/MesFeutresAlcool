package fr.itomorrow.mesfeutresalcool.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import fr.itomorrow.mesfeutresalcool.R;
import fr.itomorrow.mesfeutresalcool.database.Modele;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class AjouterModeleFragment extends Fragment implements View.OnClickListener{

    private static String TAG = MarquesFragment.class.getSimpleName();
    private Context mContext;

    private EditText mModeleEditText;
    private EditText mCouleurEditText;
    private EditText mCodeEditeText;
    private Button mAjouterButton;
    private Button mAnnulerButton;

    private int mIdMarque;
    private int mIdModele;

    private FragmentManagerInterface mFragmentManager;

    public AjouterModeleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rView = inflater.inflate(R.layout.fragment_ajouter_modele, container, false);

        mModeleEditText = (EditText) rView.findViewById(R.id.fragment_ajoutermodele_modele_edittext);
        mCouleurEditText = (EditText) rView.findViewById(R.id.fragment_ajoutermodele_couleur_edittext);
        mCodeEditeText = (EditText) rView.findViewById(R.id.fragment_ajoutermodele_code_edittext);
        mAjouterButton = (Button) rView.findViewById(R.id.fragment_ajoutermodele_ajouter_button);
        mAnnulerButton = (Button) rView.findViewById(R.id.fragment_ajoutermodele_annuler_button);

        mIdMarque = getArguments().getInt("ID_MARQUE");

        if(getArguments() != null && getArguments().containsKey("MODELE_STRING")) {
            mIdModele = getArguments().getInt("IDMODELE_INT");
            mModeleEditText.setText(getArguments().getString("MODELE_STRING"));
            mCouleurEditText.setText(getArguments().getString("COULEUR_STRING"));
            mCodeEditeText.setText(getArguments().getString("CODE_STRING"));

            mAjouterButton.setText("Modifier");
        }else {
            mIdModele = -1;
        }

        mAjouterButton.setOnClickListener(this);
        mAnnulerButton.setOnClickListener(this);

        return rView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mFragmentManager = (FragmentManagerInterface) getActivity();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fragment_ajoutermodele_ajouter_button:
                String tModele = mModeleEditText.getText().toString();
                String tCouleur = mCouleurEditText.getText().toString();
                String tCode = mCodeEditeText.getText().toString();

                if(!tModele.equals("")){
                    Modele tModeleObject = new Modele();
                    if(mIdModele != -1)
                        tModeleObject.setmIdModele(mIdModele);
                    tModeleObject.setmModele(tModele);
                    tModeleObject.setmCouleur(tCouleur);
                    tModeleObject.setmCode(tCode);
                    tModeleObject.setmIdMarque(mIdMarque);
                    tModeleObject.save();
                }

            case R.id.fragment_ajoutermodele_annuler_button:
                ModeleFragment tFragment = new ModeleFragment();
                Bundle tBundle = new Bundle();
                tBundle.putInt("ID_MARQUE", mIdMarque);

                mFragmentManager.showFragment(tFragment, tBundle);
                break;
        }
    }
}
