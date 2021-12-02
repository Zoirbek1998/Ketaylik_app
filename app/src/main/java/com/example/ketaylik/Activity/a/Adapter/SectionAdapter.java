package com.example.ketaylik.Activity.a.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ketaylik.Activity.a.model.Section;
import com.example.ketaylik.Activity.a.netWork.ApiUrl;
import com.example.ketaylik.R;

import java.util.List;


public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {
    Context context;
    List<Section> list;

    public SectionAdapter(Context context, List<Section> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_section, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Section item = list.get(position);
        Glide.with(context)
                .load(ApiUrl.BASE_URL + "/storage/restaurant_images/" + item.getImage())
                .into(holder.sectionImage);
        holder.sectionTitel.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView sectionImage;
        TextView sectionTitel;
        CardView cardservice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sectionImage = itemView.findViewById(R.id.sectionImage);
            sectionTitel = itemView.findViewById(R.id.sectionTitle);


        }
    }
}
