package com.dev.inamuthiakanza.popularmovies.http;

import com.dev.inamuthiakanza.popularmovies.model.MovieResults;
import com.dev.inamuthiakanza.popularmovies.model.ReviewResults;
import com.dev.inamuthiakanza.popularmovies.model.TrailersResults;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface MovieDBService {

    @GET("/3/discover/movie")
    Call<MovieResults> getMovieResults(@Query("api_key") String apiKey, @Query("sort_by") String sortBy);

    @GET("/3/movie/{id}/videos")
    Call<TrailersResults> getTrailersResults(@Path("id") long movieId, @Query("api_key") String apiKey);

    @GET("/3/movie/{id}/reviews")
    Call<ReviewResults> getReviewsResults(@Path("id") long movieId, @Query("api_key") String apiKey);

}
