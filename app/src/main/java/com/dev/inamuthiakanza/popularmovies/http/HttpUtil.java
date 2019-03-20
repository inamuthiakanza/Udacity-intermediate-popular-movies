package com.dev.inamuthiakanza.popularmovies.http;

import com.dev.inamuthiakanza.popularmovies.util.Constants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
public class HttpUtil {

    private static MovieDBService service;
    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MOVIE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MovieDBService.class);
    }

    public static MovieDBService getService() {
        return service;
    }
}
