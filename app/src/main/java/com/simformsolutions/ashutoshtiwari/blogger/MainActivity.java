package com.simformsolutions.ashutoshtiwari.blogger;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.simformsolutions.ashutoshtiwari.blogger.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.contactList.setLayoutManager(new LinearLayoutManager(this));

        List<Article> articles = new ArrayList<>();

        articles.add(new Article("How To Android", "Learn MVVM", true, "http://lorempixel.com/400/200", 10, true));
        articles.add(new Article("How to IOS", "Learn Swift", false, "http://lorempixel.com/400/200", 20, false));

        ArticleAdapter adapter = new ArticleAdapter(articles);
        binding.contactList.setAdapter(adapter);
    }
}
