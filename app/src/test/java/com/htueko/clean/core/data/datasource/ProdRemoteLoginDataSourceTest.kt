package com.htueko.clean.core.data.datasource

import com.google.common.truth.Truth.assertThat
import com.htueko.clean.ApiDispatcher
import com.htueko.clean.TestEndPoint
import com.htueko.clean.core.data.remote.dto.UserDto
import com.htueko.clean.core.data.remote.service.ApiService
import com.squareup.moshi.Moshi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.nio.charset.StandardCharsets


@RunWith(JUnit4::class)
class ProdRemoteLoginDataSourceTest {

    private lateinit var apiService: ApiService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()

        val moshi = Moshi.Builder()
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    private fun MockWebServer.enqueueResponse(fileName: String, code: Int) {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        val source = inputStream?.use { inputStream.source().buffer() }
        source?.use {
            enqueue(
                MockResponse()
                    .setResponseCode(code)
                    .setBody(source.readString(StandardCharsets.UTF_8))
            )
        }
    }

    @Test
    fun `should fetch user objects given 200 response`() = runTest {
        try {
            mockWebServer.apply {
                dispatcher = ApiDispatcher()
                url(TestEndPoint.USERS.value)
                enqueueResponse("user-register-success.json", 200)
            }
            val response = apiService.getUsers()
            val expected = listOf(
                UserDto(
                  id = "1",
                  name = "jerry",
                  email = "jerry@abc.com"
                ),
                UserDto(
                    id = "2",
                    name = "tom",
                    email = "tom@abc.com"
                ),
            )
            assertThat(response.raw().request.url).isEqualTo(TestEndPoint.USERS.value)
            assertThat(response.body()?.size).isEqualTo(2)
            assertThat(response.isSuccessful).isTrue()
            assertThat(response.code()).isEqualTo(200)
            assertThat(response.body()?.get(0)?.id).isEqualTo(expected[0].id)
            assertThat(response.body()?.get(1)?.id).isEqualTo(expected[1].id)
        } catch (e: Exception) {
        }

    }

}