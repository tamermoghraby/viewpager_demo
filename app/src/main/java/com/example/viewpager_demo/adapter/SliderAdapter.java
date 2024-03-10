package com.example.viewpager_demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager_demo.R;
import com.example.viewpager_demo.model.SliderItem;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {

    private final List<SliderItem> sliderItems;
    private final ViewPager2 viewPager;

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager) {
        this.sliderItems = sliderItems;
        this.viewPager = viewPager;
        configureViewPager();
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SliderViewHolder viewHolder = new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_item_container,
                parent,
                false
        ));
        viewHolder.llRewardsImages.removeAllViews();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        Picasso.get()
                .load(sliderItems.get(position).getImage())
                .into(holder.ivCover);
        holder.txtPrice.setText(String.format(Locale.getDefault(),"BD %.2f", sliderItems.get(position).getPrice()));
        holder.txtValidity.setText(String.format(Locale.getDefault(),"%d days", sliderItems.get(position).getValidity()));
        holder.txtData.setText(String.format(Locale.getDefault(),"%.1f GB", sliderItems.get(position).getData()));
        holder.llWelcomeData.setVisibility(sliderItems.get(position).hasHasWelcomeData() ? View.VISIBLE : View.GONE);
        holder.llBestSeller.setVisibility(sliderItems.get(position).isBestSeller() ? View.VISIBLE : View.GONE);
        holder.llRewardsContainer.setVisibility(sliderItems.get(position).hasRewards() ? View.VISIBLE : View.GONE);
        for (int i = 0; i <= 4; i++) {
            if (i == 4) {
                addRewardsNumber(holder.llRewardsImages);
            } else {
                addRewardItem(holder.llRewardsImages, i);
            }
        }
    }

    private void addRewardsNumber(LinearLayout llRewardsImages) {
        ConstraintLayout rewardsNumber = (ConstraintLayout) LayoutInflater.from(viewPager.getContext())
                .inflate(R.layout.rewards_number, null);
        llRewardsImages.addView(rewardsNumber);
    }

    private void addRewardItem(LinearLayout llRewardsImages ,int position) {
        String[] rewardsImages = sliderItems.get(position).getRewardsImages();
        CardView rewardItemLayout = (CardView) LayoutInflater.from(viewPager.getContext()).inflate(R.layout.reward_item, null);
        ImageView cardImage = rewardItemLayout.findViewById(R.id.cardImage);

        Picasso.get()
                .load(rewardsImages[position])
                .into(cardImage);

        llRewardsImages.addView(rewardItemLayout);
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    private void configureViewPager() {
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(80));
        compositePageTransformer.addTransformer((page, position) -> {
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
            page.setAlpha(0.6f + r * 0.6f);
        });
        viewPager.setPageTransformer(compositePageTransformer);
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView txtPrice;
        private TextView txtValidity;
        private TextView txtData;
        private TextView btnAction;
        private LinearLayout llWelcomeData;
        private LinearLayout llBestSeller;
        private LinearLayout llRewardsContainer;
        private LinearLayout llRewardsImages;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            txtPrice = itemView.findViewById(R.id.txtPriceValue);
            txtValidity = itemView.findViewById(R.id.txtValidityValue);
            txtData = itemView.findViewById(R.id.txtDataValue);
            btnAction = itemView.findViewById(R.id.btnAction);
            llWelcomeData = itemView.findViewById(R.id.llWelcomeData);
            llBestSeller = itemView.findViewById(R.id.llBestSeller);
            llRewardsContainer = itemView.findViewById(R.id.llRewardsContainer);
            llRewardsImages = itemView.findViewById(R.id.llRewardsImages);
        }
    }

}
