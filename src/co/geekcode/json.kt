package co.geekcode

import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by @david3pabon on 6/1/2017.
 */
fun requestJSON(url: String) : String {
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    val response  = client.newCall(request).execute()
    val body = response.body()
    return if (body != null) body.string() else ""
}