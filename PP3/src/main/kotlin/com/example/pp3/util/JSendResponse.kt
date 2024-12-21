package com.example.pp3.util

data class JSendResponse<T>(
    val status: String,
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null,
    val errorCode: String? = null,
    val httpStatus: Int? = null
) {
    companion object {

        fun <T> success(data: T, httpStatus: Int = 200): JSendResponse<T> =
            JSendResponse(status = "success", data = data, httpStatus = httpStatus)


        fun <T> fail(message: String, data: T? = null, httpStatus: Int = 400): JSendResponse<T> =
            JSendResponse(status = "fail", message = message, data = data, httpStatus = httpStatus)


        fun <T> error(message: String, code: Int? = null, errorCode: String? = null, httpStatus: Int = 500): JSendResponse<T> =
            JSendResponse(status = "error", message = message, code = code, errorCode = errorCode, httpStatus = httpStatus)
    }
}
