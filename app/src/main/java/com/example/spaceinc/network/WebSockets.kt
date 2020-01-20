package com.example.spaceinc.network


import android.util.Log
import okhttp3.*



class WebSockets : WebSocketListener() {


    var websocket : WebSocket? = null


    init {

        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081/ws").build()
        websocket = OkHttpClient().newWebSocket(request,this)
        joinRoom("Test", 109)


    }


    override fun onMessage(webSocket: WebSocket, text: String) {
        Log.i("Socket",text)
    }


    override fun onOpen(webSocket: WebSocket, response: Response) {
        Log.i("Socket", "je suis ouvert")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.i("Socket", t.message)
    }

    private fun joinRoom(roomName:String, userID:Int){
        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081/ws/join/$roomName/$userID").build()
        websocket = OkHttpClient().newWebSocket(request,this)
    }

}