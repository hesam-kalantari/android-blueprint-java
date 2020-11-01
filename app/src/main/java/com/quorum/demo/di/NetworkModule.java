package com.quorum.demo.di;

import com.quorum.demo.network.api.BlogService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule
{

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        final int CONNECT_TIMEOUT_SEC = 10 * 60;
        final int READ_TIMEOUT_SEC = 10 * 60;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS);
        return builder.build();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(final OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("https://open-api.xyz/placeholder/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public BlogService provideBlogService(final Retrofit retrofit) {
        return retrofit.create(BlogService.class);
    }
}
