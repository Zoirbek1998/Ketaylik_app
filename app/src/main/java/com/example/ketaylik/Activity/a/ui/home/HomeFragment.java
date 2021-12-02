package com.example.ketaylik.Activity.a.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ketaylik.Activity.a.Adapter.CategorieAdapter;
import com.example.ketaylik.Activity.a.Adapter.OfferAdapter;
import com.example.ketaylik.Activity.a.Adapter.SectionAdapter;
import com.example.ketaylik.Activity.a.HomeActivity;
import com.example.ketaylik.Activity.a.Response.CategoriesReesponse;
import com.example.ketaylik.Activity.a.Response.OfferReesponse;
import com.example.ketaylik.Activity.a.Response.SectionResponse;
import com.example.ketaylik.Activity.a.ServicesActivity;
import com.example.ketaylik.Activity.a.SplashActivity;
import com.example.ketaylik.Activity.a.model.Categories;
import com.example.ketaylik.Activity.a.model.Offer;
import com.example.ketaylik.Activity.a.model.Section;
import com.example.ketaylik.Activity.a.netWork.ApiClient;
import com.example.ketaylik.Activity.a.netWork.ApiInterface;
import com.example.ketaylik.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView, recyclerOffer, recyclerCategories;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initVars(root);
        loadSection();
        loadOffers();
        loadCAtegories();
        return root;
    }


    private void initVars(View root) {
        recyclerView = root.findViewById(R.id.recyclerSections);
        recyclerOffer = root.findViewById(R.id.recyclerOffer);
        recyclerCategories = root.findViewById(R.id.recyclerCategories);

    }

    private void loadSection() {
        Call<SectionResponse> call = ApiClient.getClient().create(ApiInterface.class)
                .loadSections(ServicesActivity.CITY_ID + "", HomeActivity.SERVICE_ID + "",
                        SplashActivity.TOKEN);
        call.enqueue(new Callback<SectionResponse>() {
            @Override
            public void onResponse(Call<SectionResponse> call, Response<SectionResponse> response) {
                SectionResponse sectionResponse = response.body();
                List<Section> list = sectionResponse.getData();
                SectionAdapter sectionAdapter = new SectionAdapter(getContext(), list);
                recyclerView.setAdapter(sectionAdapter);
                Toast.makeText(getContext(), "" + list.get(0).getWorking_hours_from(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SectionResponse> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadOffers() {
        Call<OfferReesponse> call = ApiClient.getClient().create(ApiInterface.class)
                .loadOffers(SplashActivity.TOKEN, ServicesActivity.CITY_ID + "");
        call.enqueue(new Callback<OfferReesponse>() {
            @Override
            public void onResponse(Call<OfferReesponse> call, Response<OfferReesponse> response) {

                OfferReesponse offerReesponse = response.body();
                if (offerReesponse.isSuccess()) {
                    List<Offer> list = offerReesponse.getOfferList();
                    OfferAdapter offerAdapter = new OfferAdapter(getContext(), list);
                    recyclerOffer.setAdapter(offerAdapter);
                } else {
                    String message = offerReesponse.getMessage();
                    Toast.makeText(getContext(), "" + message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OfferReesponse> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadCAtegories() {
        Call<CategoriesReesponse> call = ApiClient.getClient().create(ApiInterface.class)
                .loadCategories(HomeActivity.SERVICE_ID + "", SplashActivity.TOKEN);
        call.enqueue(new Callback<CategoriesReesponse>() {
            @Override
            public void onResponse(Call<CategoriesReesponse> call, Response<CategoriesReesponse> response) {

                CategoriesReesponse categoriesReesponse = response.body();
                if (categoriesReesponse.isSuccess()) {

                    List<Categories> categoriesList = categoriesReesponse.getCategoriesList();
                    CategorieAdapter adapter = new CategorieAdapter(getContext(), categoriesList);
                    recyclerCategories.setAdapter(adapter);

                } else {
                    String message = categoriesReesponse.getMessage();
                    Toast.makeText(getContext(), "" + message, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CategoriesReesponse> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}