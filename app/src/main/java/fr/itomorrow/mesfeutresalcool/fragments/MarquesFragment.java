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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import fr.itomorrow.mesfeutresalcool.R;
import fr.itomorrow.mesfeutresalcool.adapter.MarqueArrayAdapter;
import fr.itomorrow.mesfeutresalcool.database.Marque;
import fr.itomorrow.mesfeutresalcool.database.Marque_Table;
import fr.itomorrow.mesfeutresalcool.interfaces.FragmentManagerInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarquesFragment extends Fragment implements View.OnClickListener, ListView.OnItemClickListener {

    private Context mContext;

    private ListView mListView;
    private TextView mTextView;

    private FragmentManagerInterface mFragmentManager;
    private List<Marque> mMarques;

    public MarquesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rView = inflater.inflate(R.layout.fragment_marques, container, false);
        mListView = (ListView) rView.findViewById(R.id.fragment_marques_marques_listview);
        mTextView = (TextView) rView.findViewById(R.id.fragment_marques_listviewvide_textview);

        setHasOptionsMenu(true);

        return rView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_marques_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_marque:
                AjouterMarqueFragment tFragment = new AjouterMarqueFragment();

                /**
                 * tu utlise le manager c'est cool et beaucoup mieux :)
                 */
                mFragmentManager.showFragment(tFragment);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

        mMarques = SQLite.select(Marque_Table.marque, Marque_Table.idMarque).from(Marque.class).queryList();

        if(mMarques.size() > 0){
            mTextView.setVisibility(View.INVISIBLE);

            MarqueArrayAdapter tMarqueArrayAdapter = new MarqueArrayAdapter(getActivity(), 0, mMarques);
            tMarqueArrayAdapter.setFragmentManager(mFragmentManager);
            mListView.setAdapter(tMarqueArrayAdapter);

            mListView.setOnItemClickListener(this);
        }else {
            mListView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context;
        mFragmentManager = (FragmentManagerInterface) getActivity();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int tIdMarque = mMarques.get(i).getIdMarque();

        // Création du fragment de modèles
        ModeleFragment tFragment = new ModeleFragment();

        // Création des arguments du fragment
        Bundle tBundle = new Bundle();
        tBundle.putInt("ID_MARQUE", tIdMarque);

        mFragmentManager.showFragment(tFragment, tBundle);
    }
}
