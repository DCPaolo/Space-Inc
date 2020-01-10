package com.example.spaceinc

import android.widget.Button
import okhttp3.*
import kotlin.concurrent.thread
import okio.ByteString
import okhttp3.OkHttpClient
import android.widget.TextView




class WebSockets : WebSocketListener()  {

    private val start: Button? = null
    private val output: TextView? = null
    private val client: OkHttpClient? = null



    override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosed(webSocket, code, reason)
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        super.onClosing(webSocket, code, reason)
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        super.onFailure(webSocket, t, response)
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
        super.onMessage(webSocket, bytes)
    }

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
    }

    private fun start() {
        val request = Request.Builder().url("ws://vps769278.ovh.net:8081 ").build()
        val listener = EchoWebSocketListener()
        val ws = client.newWebSocket(request, listener)
        client.dispatcher().executorService().shutdown()
    }
}

