package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefe {
    SharedPreferences myPref;
    public Prefe(Context context){

        myPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);

    }

    public void setModeNoche(Boolean state){
        SharedPreferences.Editor editor = myPref.edit();
        editor.putBoolean("Modo Noche", state);
        editor.commit();
    }

    public Boolean cargarModoNoche(){
    
        Boolean state = myPref.getBoolean("Modo Noche", false);
        return  state;
    }

}
