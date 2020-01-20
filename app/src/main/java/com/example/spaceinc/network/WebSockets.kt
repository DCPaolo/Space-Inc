package com.example.spaceinc.network


import android.util.Log
import okhttp3.*

class WebSockets : WebSocketListener() {

    var websocket : WebSocket? = null

    init {
        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081/ws").build()
        websocket = OkHttpClient().newWebSocket(request,this)

    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)

        Log.i("test", text)
    }


    override fun onOpen(webSocket: WebSocket, response: Response) {

    }

    private fun joinRoom(roomName:String, userId:Int) {
        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081/ws/join/$roomName/$userId").build()
        websocket = OkHttpClient().newWebSocket(request,this)
    }




}