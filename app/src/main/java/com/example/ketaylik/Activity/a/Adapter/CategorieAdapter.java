package com.example.ketaylik.Activity.a.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ketaylik.Activity.a.model.Categories;
import com.example.ketaylik.Activity.a.netWork.ApiUrl;
import com.example.ketaylik.R;

import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.OfferViewHolder> {

    Context context;
    List<Categories> list;

    public CategorieAdapter(Context context, List<Categories> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_categories, parent, false);

        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {

        Glide.with(context).load(ApiUrl.BASE_URL + "/sorage/caregory_icons/"
                + list.get(position).getImage())
                .into(holder.categoriesImage);
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {

        ImageView categoriesImage;
        TextView name;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.categoreTitel);
            categoriesImage = itemView.findViewById(R.id.categoreTitel);

        }
    }

}
