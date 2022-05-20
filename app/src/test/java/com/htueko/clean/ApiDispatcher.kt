package com.htueko.clean

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class ApiDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            TestEndPoint.USERS.value -> MockResponse().setResponseCode(200)
            TestEndPoint.ERROR.value -> MockResponse().setResponseCode(403)
            else -> MockResponse().setResponseCode(404)
        }
    }

}

enum class TestEndPoint(val value: String) {
    USERS("/users"),
    ERROR("/error"),
}