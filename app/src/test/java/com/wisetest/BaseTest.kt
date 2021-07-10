package com.wisetest

import com.wisetest.data.network.ApiService
import com.wisetest.utils.Constant.BASE_URL
import com.wisetest.utils.RequestDispatcher
import com.wisetest.utils.SafeApiRequest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal open class BaseTest {
    private lateinit var server: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    lateinit var apiService: ApiService

    lateinit var safeApiRequest: SafeApiRequest

    @Before
    open fun setup() {
        server = MockWebServer()

        server.dispatcher = RequestDispatcher()
        server.start()

        safeApiRequest = object : SafeApiRequest() {}

        loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()


        apiService = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @After
    open fun tearDown() {
        server.shutdown()
    }

}