package com.wisetest.network

import com.google.common.truth.Truth.assertThat
import com.wisetest.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class ApiServicesTest:BaseTest() {

    @Test
    fun `fetch_character_test`() = runBlocking {
        val result =
            safeApiRequest.safeApiCall(call = {apiService.fetchCharacters()},successCallback = {} )

        assertThat(result.data?.results!![0].id).isEqualTo(1)
    }

}