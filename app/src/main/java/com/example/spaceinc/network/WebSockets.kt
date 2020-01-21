package com.example.spaceinc.network


import android.util.Log
import com.example.spaceinc.model.Event
import com.example.spaceinc.model.Event.*
import com.example.spaceinc.model.EventType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.*

class WebSockets : WebSocketListener() {


    var websocket : WebSocket

    init {
        val request =  Request.Builder().url("ws://vps769278.ovh.net:8081/ws").build()
        websocket = OkHttpClient().newWebSocket(request,this)
        joinRoom("azerty", 109)
        startGame()

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


    private fun startGame(){

        var readyJson : String = "{\"type\":\"READY\", \"value\":true}"

        var moshi = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(Event::class.java,"type")
                    .withSubtype(Ready::class.java, EventType.READY.name)
            )

            .add(KotlinJsonAdapterFactory())
            .build()

        val eventParser = moshi.adapter<Event>(Event::class.java)

        eventParser.fromJson(readyJson)

        websocket.send(readyJson)
    }
}