package fr.itomorrow.mesfeutresalcool.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Axou on 10/12/2016.
 */

@Table(database = MyDatabase.class)
public class Marque extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int idMarque;

    @Column
    @Unique
    public String marque;

    public int getIdMarque(){
        return idMarque;
    }

    public String getMarque(){
        return marque;
    }

    public void setMarque(String marque){
        this.marque = marque;
    }
}
