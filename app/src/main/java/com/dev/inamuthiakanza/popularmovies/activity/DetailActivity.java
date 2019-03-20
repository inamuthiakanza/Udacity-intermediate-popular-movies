package com.dev.inamuthiakanza.popularmovies.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.dev.inamuthiakanza.popularmovies.R;
import com.dev.inamuthiakanza.popularmovies.fragment.MovieDetailFragment;
import com.dev.inamuthiakanza.popularmovies.model.MovieData;

import butterknife.ButterKnife;

public class DetailActivity extends BaseDetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Bundle bundle = new Bundle(getIntent().getExtras());
            fragmentTransaction.add(R.id.movie_detail_container, MovieDetailFragment.newInstance(bundle)).commit();
        }
    }

    @Override
    public void onItemSelected(MovieData movieData, Bitmap posterBitmap, View view, int position) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
