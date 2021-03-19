package com.mustafaokta.suzmesayachesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.mustafaokta.suzmesayachesapla.db.DaoMaster;
import com.mustafaokta.suzmesayachesapla.db.DaoSession;
import com.mustafaokta.suzmesayachesapla.db.Fatura;

import org.greenrobot.greendao.database.Database;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class FaturaActivity extends AppCompatActivity {
    private TextInputEditText sayacTanimlamasi, faturaSayacIlkEndeks, faturaSayacSonEndeks, suzmeSayacIlkEndeks, suzmeSayacSonEndeks, faturaToplamTutar;
    private TextView suzmeSayacHesaplananFaturaPayi, uyariBind;
    private  Integer faturaSayaciEndeksDegerFarki, suzmeSayacEndeksDegerFarki;
    private Button kaydet;
    DaoSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura);
        Toast toast2 = Toast.makeText(this, "Rakamların virgülden sonraki ondalık kısımlarını girmeyiniz.", Toast.LENGTH_LONG);
        toast2.show();
        initViews();
        initDb();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fa-db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();

    }

    private void initViews() {
        sayacTanimlamasi=findViewById(R.id.sayacTanimlamasi);
        faturaToplamTutar=findViewById(R.id.faturaToplamTutar);
        faturaSayacIlkEndeks=findViewById(R.id.faturaSayacIlkEndeks);
        faturaSayacSonEndeks=findViewById(R.id.faturaSayacSonEndeks);
        suzmeSayacIlkEndeks=findViewById(R.id.suzmeSayacIlkEndeks);
        suzmeSayacSonEndeks=findViewById(R.id.suzmeSayacSonEndeks);
        kaydet=findViewById(R.id.kaydet);
        suzmeSayacHesaplananFaturaPayi=findViewById(R.id.suzmeSayacHesaplananFaturaPayi);
        uyariBind=findViewById(R.id.uyari);


        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kaydetFatura();
            }
        });
    }

    private void kaydetFatura()  {
        Fatura fatura=new Fatura();
        String sayacTanimlamasiDeger=Objects.requireNonNull(sayacTanimlamasi.getText()).toString();
        fatura.setSayacTanimlamasi(sayacTanimlamasiDeger);
        //Log.i("sayacTanimlamasiDeger",sayacTanimlamasiDeger);

        Date faturaOkunmaTarihiDeger = Calendar.getInstance().getTime();
        fatura.setFaturaOkunmaTarihi(faturaOkunmaTarihiDeger);
       // Log.i("faturaOkunmaTarihiDeger",faturaOkunmaTarihiDeger.toString());


        Integer faturaSayacIlkEndeksDeger=Integer. parseInt(Objects.requireNonNull(faturaSayacIlkEndeks.getText()). toString());
        Integer faturaSayacSonEndeksDeger=Integer. parseInt(Objects.requireNonNull(faturaSayacSonEndeks.getText()). toString());
        if (faturaSayacSonEndeksDeger>faturaSayacIlkEndeksDeger){
            fatura.setFaturaSayacIlkEndeks(faturaSayacIlkEndeksDeger);
          //  Log.i("faturaSayacIlkEndeksDeg",faturaSayacIlkEndeksDeger.toString());
            fatura.setFaturaSayacSonEndeks(faturaSayacSonEndeksDeger);
           // Log.i("faturaSayacSonEndeksDeg",faturaSayacSonEndeksDeger.toString());

            faturaSayaciEndeksDegerFarki=(faturaSayacSonEndeksDeger-faturaSayacIlkEndeksDeger);
           // Log.i("faturaSaySonEndeksDegfr",faturaSayaciEndeksDegerFarki.toString());
        }else {
            Toast toast = Toast.makeText(this, "Son Endeks değeri, İlk Endeks değerinden büyük olmalı!", Toast.LENGTH_LONG);
            toast.show();
          //  Log.i("else girdi","else girdi");
            return;
        }




        Integer suzmeSayacIlkEndeksDeger=Integer. parseInt(Objects.requireNonNull(suzmeSayacIlkEndeks.getText()). toString());
        Integer suzmeSayacSonEndeksDeger=Integer. parseInt(Objects.requireNonNull(suzmeSayacSonEndeks.getText()). toString());
        if (suzmeSayacSonEndeksDeger>suzmeSayacIlkEndeksDeger){
        fatura.setSuzmeSayacIlkEndeks(suzmeSayacIlkEndeksDeger);
       // Log.i("suzmeSayacIlkEndeksDeg",suzmeSayacIlkEndeksDeger.toString());
        fatura.setSuzmeSayacSonEndeks(suzmeSayacSonEndeksDeger);
       // Log.i("suzmeSayacSonEndeksDeg",suzmeSayacSonEndeksDeger.toString());

        suzmeSayacEndeksDegerFarki=(suzmeSayacSonEndeksDeger-suzmeSayacIlkEndeksDeger);
       // Log.i("suzmeSayacEndeksDegFark",suzmeSayacEndeksDegerFarki.toString());
        }else {
            Toast toast = Toast.makeText(this, "Son Endeks değeri, İlk Endeks değerinden büyük olmalı!", Toast.LENGTH_LONG);

            toast.show();
            Log.i("else girdi","else girdi");
            return;
        }

        Integer faturaToplamTutarDeger = Integer. parseInt(Objects.requireNonNull(faturaToplamTutar.getText()). toString());
        //Log.i("faturaToplamTutarDeger", faturaToplamTutarDeger.toString());
        fatura.setFaturaToplamTutar(faturaToplamTutarDeger);


if (suzmeSayacEndeksDegerFarki>faturaSayaciEndeksDegerFarki){
    Toast toast = Toast.makeText(this, "Ana Fatura Sayaç Endeks değer farkı, Süzme Sayaç Endeks değer farkından büyük olmalı!", Toast.LENGTH_LONG);
    toast.show();
   // Log.i("endeks fark","hatalı veri");
    return;
}
        //Algoritma süzmeendeksfarkı/FaturaTotalendeksfarkı * Fatura miktarı
       Integer suzmeSayacHesaplananFaturaPayiDeger= Math.round ((faturaToplamTutarDeger*suzmeSayacEndeksDegerFarki) / faturaSayaciEndeksDegerFarki);//
       // Log.i("suzmeSayacHesaplanan", suzmeSayacHesaplananFaturaPayiDeger.toString());
        fatura.setSuzmeSayacHesaplananFaturaPayi(suzmeSayacHesaplananFaturaPayiDeger);
        suzmeSayacHesaplananFaturaPayi.setText(suzmeSayacHesaplananFaturaPayiDeger.toString()+" ₺");


        session.getFaturaDao().insert(fatura);

        finish();


    }
}