package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static Switch sw1;
    Prefe sharedpref;
    private TextView tv1;

    private static SeekBar seek_bar;
    private static TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedpref = new Prefe(this);
        if(sharedpref.cargarModoNoche()==true){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = (TextView)findViewById(R.id.tv1);
        sw1=(Switch)findViewById(R.id.sw1);
        if(sharedpref.cargarModoNoche()==true){
            sw1.setChecked(true);
        }
        sw1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                    sharedpref.setModeNoche(true);
                restartApp();
            }
            else{
                sharedpref.setModeNoche(false);
                restartApp();
            }
        });
        seebbar();
    }

    public void restartApp(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
    public void seebbar(){
        seek_bar = (SeekBar)findViewById(R.id.sb);
        text_view = (TextView)findViewById(R.id.tv1);


        seek_bar.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {
                    int value_pro;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                         TextView tvText;
                        tvText=(TextView)findViewById(R.id.cambio);
                        tvText.setTextSize(progress);
                       /* value_pro = progress;
                        text_view.setText("Covered:" + seek_bar.getProgress() + "/"+ seek_bar.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar", Toast.LENGTH_LONG).show();*/
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar2", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    if(seek_bar.getProgress()>=2){
                        text_view.setTextSize(14);

                    }else if(seek_bar.getProgress()>=8){
                        text_view.setTextSize(30);
                    }

                    }
                }
        );
    }
}