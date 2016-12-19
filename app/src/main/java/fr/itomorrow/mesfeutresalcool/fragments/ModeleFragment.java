package fr.itomorrow.mesfeutresalcool.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.itomorrow.mesfeutresalcool.R;
import fr.itomorrow.mesfeutresalcool.adapter.ModeleArrayAdapter;
import fr.itomorrow.mesfeutresalcool.database.Modele;
import fr.itomorrow.mesfeutresalcool.database.Modele_Table;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModeleFragment extends Fragment {

    private Context mContext;

    private TextView mTextViewListeVide;
    private ListView mListViewModele;

    private FragmentManagerInterface mFragmentManager;
    private ModeleArrayAdapter mModeleArrayAdapter;

    private List<Modele> mModeles;
    private int mIdMarque;

    public ModeleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mFragmentManager = (FragmentManagerInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rView = inflater.inflate(R.layout.fragment_modele, container, false);

        mTextViewListeVide = (TextView) rView.findViewById(R.id.fragment_modele_modelevide_textview);
        mListViewModele = (ListView) rView.findViewById(R.id.fragment_modele_modele_listview);
        mIdMarque = getArguments().getInt("ID_MARQUE");

        setHasOptionsMenu(true);

        return rView;
    }

    @Override
    public void onResume() {
        super.onResume();

        mModeles = SQLite.select().from(Modele.class).where(Modele_Table.mIdMarque.is(mIdMarque)).queryList();

        if(mModeles.size() > 0){
            mTextViewListeVide.setVisibility(View.INVISIBLE);

            mModeleArrayAdapter = new ModeleArrayAdapter(getActivity(), 0, mModeles);
            mModeleArrayAdapter.setmFragmentManager(mFragmentManager);
            mListViewModele.setAdapter(mModeleArrayAdapter);
        }else {
            mListViewModele.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_marques_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_marque:
                // Création du fragment ajouter modele
                AjouterModeleFragment tFragment = new AjouterModeleFragment();

                // Création des arguments pour le fragment
                Bundle tBundle = new Bundle();
                tBundle.putInt("ID_MARQUE", mIdMarque);

                mFragmentManager.showFragment(tFragment, tBundle);

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
