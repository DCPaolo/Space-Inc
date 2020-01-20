package com.example.spaceinc.network


import android.util.Log
import okhttp3.*



class WebSockets : WebSocketListener() {


    var websocket : WebSocket? = null


    init {

        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081").build()
        websocket = OkHttpClient().newWebSocket(request,this)


    }


    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)


        Log.i("toto",text)
    }


    override fun onOpen(webSocket: WebSocket, response: Response) {

    }




}