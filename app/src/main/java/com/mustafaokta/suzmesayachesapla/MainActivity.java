package com.mustafaokta.suzmesayachesapla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mustafaokta.suzmesayachesapla.db.DaoMaster;
import com.mustafaokta.suzmesayachesapla.db.DaoSession;
import com.mustafaokta.suzmesayachesapla.db.Fatura;

import org.greenrobot.greendao.database.Database;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private DaoSession session;
    private RecyclerView faturaRecyclerView;
    private FaturaAdapter faturaAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initDb();
        initFab();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void initFab() {
        fab=findViewById(R.id.fabButonum);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FaturaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRecyclerView() {
        //recyclerVievi bağla
        faturaRecyclerView=findViewById(R.id.faturaRecycler);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        faturaRecyclerView.setLayoutManager(manager);

        //adapter i bagla
        faturaAdapter=new FaturaAdapter(this);
        faturaRecyclerView.setAdapter(faturaAdapter);

    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "fa-db");
        Database db = helper.getWritableDb();
        session = new DaoMaster(db).newSession();

    }
    @Override
    protected void onResume() {
        super.onResume();
        //fatura activity kapandığında bu listenin yenilenmesi lazım
        getFaturas();
        Toast toast = Toast.makeText(this, "Yeni fatura hesaplamak için + simgesine tıklayınız", Toast.LENGTH_LONG);
        toast.show();

    }

    private void getFaturas() {
        List<Fatura>faturaList=session.getFaturaDao().loadAll();
        faturaAdapter.setList(faturaList);
    }

    @Override
    public void onClick(int position) {
        Fatura fatura= faturaAdapter.getFatura(position);
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra("fatura-id", fatura.getId());
        startActivity(intent);
    }
}