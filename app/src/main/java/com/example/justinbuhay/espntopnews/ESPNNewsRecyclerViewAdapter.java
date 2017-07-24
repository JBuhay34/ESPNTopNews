package com.example.justinbuhay.espntopnews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by justinbuhay on 7/24/17.
 */

public class ESPNNewsRecyclerViewAdapter extends RecyclerView.Adapter<ESPNNewsRecyclerViewAdapter.CardViewHolder> {

    private Context mContext;
    private List<ESPNArticle> mArticles;

    public ESPNNewsRecyclerViewAdapter(Context context, List<ESPNArticle> articles){
        mContext = context;
        mArticles = articles;

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_view, parent, false);

        CardViewHolder vh = new CardViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        ESPNArticle currentESPNArticle = mArticles.get(position);

        holder.articleTitleTextView.setText(currentESPNArticle.getmArticleTitle());
        holder.articleAuthorTextView.setText(currentESPNArticle.getmArticleAuthor());
        holder.articleDescriptionTextView.setText(currentESPNArticle.getmArticleDescription());
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        public TextView articleTitleTextView;
        public TextView articleAuthorTextView;
        public TextView articleDescriptionTextView;
        public ImageView articleImageView;

        public CardViewHolder(View itemView) {
            super(itemView);

            articleTitleTextView = (TextView) itemView.findViewById(R.id.articleAuthorTextView);
            articleAuthorTextView = (TextView) itemView.findViewById(R.id.articleAuthorTextView);
            articleDescriptionTextView = (TextView) itemView.findViewById(R.id.articleDescriptionTextView);
            articleImageView = (ImageView) itemView.findViewById(R.id.articleImageView);

        }
    }

}
