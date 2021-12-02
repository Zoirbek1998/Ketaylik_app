package com.example.ketaylik.Activity.a.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ketaylik.Activity.a.model.Offer;
import com.example.ketaylik.Activity.a.netWork.ApiUrl;
import com.example.ketaylik.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    Context context;
    List<Offer> list;

    public OfferAdapter(Context context, List<Offer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_offer, parent, false);

        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {

        Glide.with(context).load(ApiUrl.BASE_URL + "/sorage/offer_images/"
                + list.get(position).getImage())
                .into(holder.offerImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {

        ImageView offerImage;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);

            offerImage = itemView.findViewById(R.id.offerImage);

        }
    }

}
