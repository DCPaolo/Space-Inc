package com.example.spaceinc.WebSokets

import android.widget.Button
import android.widget.TextView
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import okhttp3.*
import okio.ByteString


class WebSockets : WebSocketListener() {


    private val start: Button? = null
    private val output: TextView? = null
    private val client: OkHttpClient? = null

    private val NORMAL_CLOSURE_STATUS = 1000
    override fun onOpen(webSocket: WebSocket, response: Response?) {
        webSocket.send("Hello, it's SSaurel !")
        webSocket.send("What's up ?")
        webSocket.send(ByteString.decodeHex("deadbeef"))
        webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    override fun onMessage(webSocket: WebSocket?, text: String) {
        output("Receiving : $text")
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString) {
        output("Receiving bytes : " + bytes.hex())
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        output("Closing : $code / $reason")
    }

    override fun onFailure(
        webSocket: WebSocket?,
        t: Throwable,
        response: Response?
    ) {
        output("Error : " + t.message)
    }


    fun output(String :String){

        println(String)

    }


    private fun start() {
        val request: Request = Builder().url("ws://echo.websocket.org").build()
        val listener = EchoWebSocketListener()
        val ws: WebSocket = client.newWebSocket(request, listener)
        client.dispatcher().executorService().shutdown()
    }

    private fun output(txt: String) {
        UiThreadStatement.runOnUiThread(Runnable { output.setText(output.getText().toString().toString() + "\n\n" + txt) })
    }


}