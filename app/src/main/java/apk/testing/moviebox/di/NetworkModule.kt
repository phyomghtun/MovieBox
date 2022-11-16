package apk.testing.moviebox.di

import apk.testing.moviebox.network.RetrofitInterface
import apk.testing.moviebox.network.base_url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitInterface(retrofit: Retrofit): RetrofitInterface{
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}