package com.dev.inamuthiakanza.popularmovies.loader;

import android.content.Context;

import com.dev.inamuthiakanza.popularmovies.model.MovieData;
import com.dev.inamuthiakanza.popularmovies.provider.FavoriteMovieContentProvider;

import java.util.List;

public class FavoriteResultsLoader extends CommonTaskLoader {
    private static final String TAG = "FavoriteResultsLoader";

    public FavoriteResultsLoader(Context context) {
        super(context);
    }

    @Override
    public List<MovieData> loadInBackground() {
        return FavoriteMovieContentProvider.getFavorites(getContext());
    }
}