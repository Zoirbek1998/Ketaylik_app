package com.example.ketaylik.Activity.a.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ketaylik.Activity.a.HomeActivity;
import com.example.ketaylik.Activity.a.model.Services;
import com.example.ketaylik.Activity.a.netWork.ApiUrl;
import com.example.ketaylik.R;

import java.util.List;


public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    Context context;
    List<Services> list;

    public ServicesAdapter(Context context, List<Services> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Services services = list.get(position);
        Glide.with(context)
                .load(ApiUrl.BASE_URL + "/storage/service_images/" + services.getImage())
                .into(holder.serviceImage);
        holder.serviceTitel.setText(services.getName());
        holder.cardservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("service_id", services.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView serviceImage;
        TextView serviceTitel;
        CardView cardservice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceImage = itemView.findViewById(R.id.serviceImage);
            serviceTitel = itemView.findViewById(R.id.serviceTitle);
            cardservice = itemView.findViewById(R.id.cardName);
        }
    }
}
