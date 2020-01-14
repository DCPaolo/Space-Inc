package com.example.spaceinc

import android.content.ContentValues.TAG
import android.util.Log
import okhttp3.*
import okio.ByteString


class WebSockets : WebSocketListener()  {

    fun getCoinPrice(product: String) {
        val clientCoinPrice = OkHttpClient()
        val requestCoinPrice: Request = Request.Builder().url("ws://vps769278.ovh.net:8081").build()
        val webSocketListenerCoinPrice: WebSocketListener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response?) {
                webSocket.send(
                    "{\n" +
                            "    \"type\": \"subscribe\",\n" +
                            "    \"channels\": [{ \"name\": \"ticker\", \"product_ids\": [\"" + product + "\"] }]\n" +
                            "}"
                )
                Log.e(TAG, "onOpen")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.e(TAG, "MESSAGE: $text")
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                Log.e(TAG, "MESSAGE: " + bytes.hex())
            }

            override fun onClosing(
                webSocket: WebSocket,
                code: Int,
                reason: String
            ) {
                webSocket.close(1000, null)
                webSocket.cancel()
                Log.e(TAG, "CLOSE: $code $reason")
            }

            override fun onClosed(
                webSocket: WebSocket,
                code: Int,
                reason: String
            ) { //TODO: stuff
            }

            override fun onFailure(
                webSocket: WebSocket?,
                t: Throwable?,
                response: Response?
            ) { //TODO: stuff
            }
        }
        clientCoinPrice.newWebSocket(requestCoinPrice, webSocketListenerCoinPrice)
        clientCoinPrice.dispatcher().executorService().shutdown()
    }

}

