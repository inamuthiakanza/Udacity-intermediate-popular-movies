package com.dev.inamuthiakanza.popularmovies.task;

import android.util.Log;
import android.widget.ProgressBar;

import com.dev.inamuthiakanza.popularmovies.BuildConfig;
import com.dev.inamuthiakanza.popularmovies.http.HttpUtil;
import com.dev.inamuthiakanza.popularmovies.model.Review;
import com.dev.inamuthiakanza.popularmovies.model.ReviewResults;

import java.io.IOException;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.Response;

public class ReviewsAsyncTask extends CommonAsyncTask<Review> {

    private static final String TAG = "ReviewsAsyncTask";
    private final long mMovieId;

    public ReviewsAsyncTask(long movieId, ProgressBar mProgressBar, FetchDataListener mListener) {
        super(mProgressBar, mListener);
        this.mMovieId = movieId;
    }

    @Override
    protected ArrayList<Review> doInBackground(Void... params) {
        Call<ReviewResults> createdCall = HttpUtil.getService().getReviewsResults(mMovieId, BuildConfig.THE_MOVIE_DB_API_KEY);
        try {
            Response<ReviewResults> result = createdCall.execute();
            return result.body().results;
        } catch (IOException e) {
            Log.e(TAG, "IOException occurred in doInBackground()");
        }
        return null;
    }
}
