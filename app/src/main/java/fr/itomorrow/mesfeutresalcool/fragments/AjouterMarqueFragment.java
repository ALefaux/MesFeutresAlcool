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
import fr.itomorrow.mesfeutresalcool.database.Marque;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class AjouterMarqueFragment extends Fragment implements View.OnClickListener {

    private static String TAG = MarquesFragment.class.getSimpleName();
    private Context mContext;

    private EditText mEditTextMarque;
    private Button mButtonAjouter;
    private Button mButtonAnnuler;

    private FragmentManagerInterface mFragmentManager;

    public AjouterMarqueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rView = inflater.inflate(R.layout.fragment_ajouter_marque, container, false);
        mEditTextMarque = (EditText) rView.findViewById(R.id.fragment_ajouter_marque_marque_edittext);
        mButtonAjouter = (Button) rView.findViewById(R.id.fragment_ajouter_marque_ajouter_button);
        mButtonAnnuler = (Button) rView.findViewById(R.id.fragment_ajouter_marque_annuler_button);

        mButtonAjouter.setOnClickListener(this);
        mButtonAnnuler.setOnClickListener(this);

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
            case R.id.fragment_ajouter_marque_ajouter_button:
                String tMarqueString = mEditTextMarque.getText().toString();
                if(!tMarqueString.equals("")){
                    Marque tMarque = new Marque();
                    tMarque.setMarque(tMarqueString);
                    tMarque.save();

                }
            case R.id.fragment_ajouter_marque_annuler_button:
                MarquesFragment tFragment = new MarquesFragment();

                mFragmentManager.showFragment(tFragment);

                break;
        }
    }
}
