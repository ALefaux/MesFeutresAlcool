package fr.itomorrow.mesfeutresalcool.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Axou on 10/12/2016.
 */

@Table(database = MyDatabase.class)
public class Modele extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int mIdModele;

    @Column
    public String mModele;

    @Column
    @Unique
    public String mCode;

    @Column
    public String mCouleur;

    @Column
    public int mIdMarque;

    public int getmIdModele(){
        return mIdModele;
    }

    public void setmIdModele(int sIdModele){
        this.mIdModele = sIdModele;
    }

    public String getmModele(){
        return mModele;
    }

    public void setmModele(String sModele){
        this.mModele = sModele;
    }

    public String getmCode(){
        return mCode;
    }

    public void setmCode(String sCode){
        this.mCode = sCode;
    }

    public String getmCouleur(){
        return mCouleur;
    }

    public void setmCouleur(String sCouleur){
        this.mCouleur = sCouleur;
    }

    public int getmIdMarque(){
        return mIdMarque;
    }

    public void setmIdMarque(int sIdMarque){
        this.mIdMarque = sIdMarque;
    }

}
