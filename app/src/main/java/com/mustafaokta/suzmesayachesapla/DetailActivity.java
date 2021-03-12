package com.mustafaokta.suzmesayachesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mustafaokta.suzmesayachesapla.db.DaoMaster;
import com.mustafaokta.suzmesayachesapla.db.DaoSession;
import com.mustafaokta.suzmesayachesapla.db.Fatura;
import com.mustafaokta.suzmesayachesapla.db.FaturaDao;

import org.greenrobot.greendao.database.Database;

public class DetailActivity extends AppCompatActivity {
        private TextView sayacTanimlamasiDtyBind, faturaToplamTutarDtyBind, faturaSayacIlkEndeksDtyBind,
                faturaSayacSonEndeksDtyBind, suzmeSayacIlkEndeksDtyBind, suzmeSayacSonEndeksDtyBind, suzmeSayacHesaplananFaturaPayiDtyBind,  kayitOlusturmaTarihiDtyBind;
    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
        initDb();
        parseIntent();
    }

    private void parseIntent() {
        Intent intent=getIntent();
        Long faturaId=intent.getLongExtra("fatura-id",-1);
        Fatura fatura =session.getFaturaDao().queryBuilder().where(FaturaDao.Properties.Id.eq(faturaId)).unique();
        showFaturaDetails(fatura);
    }

    private void showFaturaDetails(Fatura fatura) {
        sayacTanimlamasiDtyBind.setText(fatura.getSayacTanimlamasi());
        faturaToplamTutarDtyBind.setText(fatura.getFaturaToplamTutar().toString());
        faturaSayacIlkEndeksDtyBind.setText(fatura.getFaturaSayacIlkEndeks().toString());
        faturaSayacSonEndeksDtyBind.setText(fatura.getFaturaSayacSonEndeks().toString());
        suzmeSayacIlkEndeksDtyBind.setText(fatura.getSuzmeSayacIlkEndeks().toString());
        suzmeSayacSonEndeksDtyBind.setText(fatura.getSuzmeSayacSonEndeks().toString());
        suzmeSayacHesaplananFaturaPayiDtyBind.setText(fatura.getSuzmeSayacHesaplananFaturaPayi().toString());
        kayitOlusturmaTarihiDtyBind.setText(fatura.getFaturaOkunmaTarihi().toString());

    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fa-db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();

    }
    private void initViews() {
        sayacTanimlamasiDtyBind=findViewById(R.id.sayacTanimlamasiDty);
        faturaToplamTutarDtyBind=findViewById(R.id.faturaToplamTutarDty);
        faturaSayacIlkEndeksDtyBind=findViewById(R.id.faturaSayacIlkEndeksDty);
        faturaSayacSonEndeksDtyBind=findViewById(R.id.faturaSayacSonEndeksDty);
        suzmeSayacIlkEndeksDtyBind=findViewById(R.id.suzmeSayacIlkEndeksDty);
        suzmeSayacSonEndeksDtyBind=findViewById(R.id.suzmeSayacSonEndeksDty);
        suzmeSayacHesaplananFaturaPayiDtyBind=findViewById(R.id.suzmeSayacHesaplananFaturaPayiDty);
        kayitOlusturmaTarihiDtyBind=findViewById(R.id.kayitOlusturmaTarihi);

    }
}