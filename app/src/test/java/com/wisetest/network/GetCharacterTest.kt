package com.wisetest.network

import characterSuccess
import com.wisetest.BaseTest
import com.wisetest.cache.AppDatabaseFake
import com.wisetest.cache.CharacterDaoFake
import com.wisetest.data.network.ApiService
import com.wisetest.data.repository.Repository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import java.net.HttpURLConnection

/**
 * 1. Retrieve Character details from network and cache
 */
internal class GetCharacterTest:BaseTest() {

    private val appDatabase = AppDatabaseFake()
    private lateinit var mockWebServer: MockWebServer
    private lateinit var baseUrl: HttpUrl

    // system in test
    private lateinit var getCharacter: Repository

    // dependencies
    private lateinit var service: ApiService
    private lateinit var accountDao: CharacterDaoFake



    @Test
    fun getCharacterSuccess() = runBlocking {

        // condition the response
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(characterSuccess)
        )

        val emission = getCharacter.getCharacter()
//        assert(emission.first()) //Todo assert loading state

            //Todo assert data saved to db
            //Todo assert network call was successfull
    }
}