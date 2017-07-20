package com.simformsolutions.ashutoshtiwari.blogger;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Ashutosh.tiwari on 20/07/17.
 * POJO model for Article
 */

public class Article extends BaseObservable {

    private String title;
    private String excerpt;
    private boolean highlight;
    private String imageUrl;
    private int commentsNumber;
    private boolean read;

    public Article(String title, String excerpt, boolean highlight, String imageUrl, int commentsNumber, boolean read) {
        this.title = title;
        this.excerpt = excerpt;
        this.highlight = highlight;
        this.imageUrl = imageUrl;
        this.commentsNumber = commentsNumber;
        this.read = read;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
        notifyPropertyChanged(BR.excerpt);
    }

    @Bindable
    public boolean getHighlight() {
        return highlight;
    }


    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
        notifyPropertyChanged(BR.highlight);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public int getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(int commentsNumber) {
        this.commentsNumber = commentsNumber;
        notifyPropertyChanged(BR.commentsNumber);
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        if (read && !this.read) {
            setTitle("READ" + getTitle());
        }
        this.read = read;
    }

    public View.OnClickListener onReadMoreClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Opens article Detail", Toast.LENGTH_SHORT).show();
                setRead(true);
            }
        };
    }

    public View.OnClickListener onCommentsClicked() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Opens comments Detail", Toast.LENGTH_SHORT).show();
                setRead(true);
            }
        };
    }

    @BindingAdapter({"image"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).centerCrop().into(imageView);
    }
}
