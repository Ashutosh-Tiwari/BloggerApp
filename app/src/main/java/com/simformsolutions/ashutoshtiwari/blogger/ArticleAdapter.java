package com.simformsolutions.ashutoshtiwari.blogger;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.simformsolutions.ashutoshtiwari.blogger.databinding.ArticleItemBinding;

import java.util.List;

/**
 * Created by Ashutosh.tiwari on 20/07/17.
 * Custom adapter for binding article(s) inside the recycler view
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {

    private ArticleItemBinding itemBinding;
    private List<Article> articles;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.article_item, parent, false);
        return new BindingHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        itemBinding = holder.itemBinding;
        itemBinding.setArticle(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {

        private ArticleItemBinding itemBinding;

        public BindingHolder(ArticleItemBinding itemBinding) {
            super(itemBinding.contactCard);
            this.itemBinding = itemBinding;
        }
    }
}
