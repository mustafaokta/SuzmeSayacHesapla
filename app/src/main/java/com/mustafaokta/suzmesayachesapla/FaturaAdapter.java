package com.mustafaokta.suzmesayachesapla;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafaokta.suzmesayachesapla.db.Fatura;

import java.util.ArrayList;
import java.util.List;

public class FaturaAdapter extends RecyclerView.Adapter<FaturaAdapter.ViewHolder> {
    private final ItemClickListener itemClickListener;
    private List<Fatura>faturaList=new ArrayList<>();

    public FaturaAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View imizi oluşturalım
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fatura, parent,false);
        return new ViewHolder(view, itemClickListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //son olarak burada artık ekrana yazdırıcağız, burada ilgili position ı method bize veriyor
        Fatura fatura= faturaList.get(position);
        holder.faturaRowIdBag.setText(fatura.getId().toString()+" Nolu Fatura Kaydı");
        holder.faturaRowTanimlamasiBag.setText(fatura.getSayacTanimlamasi());
        holder.suzmeRowtutariBag.setText(fatura.getSuzmeSayacHesaplananFaturaPayi().toString()+" ₺");

    }

    @Override
    public int getItemCount() {
        return faturaList.size();
    }

    public void setList(List<Fatura> faturaList) {
        this.faturaList=faturaList;
        notifyDataSetChanged();
    }

    public Fatura getFatura(int position) {
        return faturaList.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView faturaRowTanimlamasiBag, faturaRowIdBag, suzmeRowtutariBag;
        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener=itemClickListener;
            faturaRowTanimlamasiBag =itemView.findViewById(R.id.faturaRowTanimlamasi);
            faturaRowIdBag=itemView.findViewById(R.id.faturaRowId);
            suzmeRowtutariBag=itemView.findViewById(R.id.suzmeRowtutari);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            itemClickListener.onClick(getAdapterPosition());
        }
    }
}
