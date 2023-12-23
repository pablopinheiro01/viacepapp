package br.com.viacepapp.di.modules

import br.com.viacepapp.network.services.ViaCepService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestApiModule{

    @Provides
    @Singleton
    @ViaCepRetrofit
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://viacep.com.br/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideViaCepService(@ViaCepRetrofit retrofit: Retrofit): ViaCepService{
        return retrofit.create(ViaCepService::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ViaCepRetrofit
