package com.android45.musicapp.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    static String BASE_URL = "http://demo0952224.mockable.io/";
    static IFService ifService;
    Retrofit retrofit = null;

    public static IFService getInstance() {
        if (ifService == null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            Retrofit restAdapter = newRetrofitInstance(BASE_URL, okHttpClient);
            ifService = restAdapter.create(IFService.class);
        }
        return ifService;
    }

    private static Retrofit newRetrofitInstance(String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
