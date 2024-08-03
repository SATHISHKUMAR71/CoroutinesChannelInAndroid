package com.example.coroutineschannel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var channel:ReceiveChannel<String> = Channel()

//        Channels using Produce that automatically close the channel;
//        lifecycleScope.launch {
//            channel = produce {
//                delay(1000)
//                send("New Message from Cole!!")
//                send("New Message from Ramsey!!")
//                send("New Message from Cassie!!")
//                send("New Message from Hannah!!")
//            }
//        }
//        lifecycleScope.launch {
//            channel.consumeEach {
//                println("Message : $it")
//            }
//        }


        //    BUFFERED CHANNEL (capacity is exactly one Replace all the messages with the new one)
//        lifecycleScope.launch {
//            channel = produce(capacity = 1) {
//                delay(1000)
//                send("New Message from Cole!!")
//                println("cole message sent")
//                delay(1000)
//                send("New Message from Ramsey!!")
//                println("Ramsey message sent")
//                delay(1000)
//                send("New Message from Cassie!!")
//                println("Cassie message sent")
//                delay(1000)
//                send("New Message from Hannah!!")
//                println("Hannah message sent")
//            }
//        }
//        lifecycleScope.launch {
//
//            channel.consumeEach {
//                println("Message : $it")
//            }
//        }



//    CONFLATED CHANNEL(limits the Maximum capacity)
//
//        lifecycleScope.launch {
//            channel = produce(capacity = CONFLATED) {
//
//                send("New Message from Cole!!")
//                println("cole message sent")
//
//                send("New Message from Ramsey!!")
//                println("Ramsey message sent")
//
//                send("New Message from Cassie!!")
//                println("Cassie message sent")
//
//                send("New Message from Hannah!!")
//                println("Hannah message sent")
//            }
//        }
//
//        lifecycleScope.launch {
//            channel.consumeEach {
//                println("Message : $it")
//            }
//        }


//        RENDEZVOUS CHANNEL(limits the Maximum capacity as 0)
//
//        lifecycleScope.launch {
//            channel = produce {
//
//                send("New Message from Cole!!")
//                println("cole message sent")
//
//                send("New Message from Ramsey!!")
//                println("Ramsey message sent")
//
//                send("New Message from Cassie!!")
//                println("Cassie message sent")
//
//                send("New Message from Hannah!!")
//                println("Hannah message sent")
//            }
//        }
//
//        lifecycleScope.launch {
//            println(channel.receive())
//            println( channel.receive())
//        }

//        UNLIMITED CHANNEL(limits the Maximum capacity as many as we send)

        lifecycleScope.launch {
            channel = produce(capacity = UNLIMITED) {

                send("New Message from Cole!!")
                println("cole message sent")

                send("New Message from Ramsey!!")
                println("Ramsey message sent")

                send("New Message from Cassie!!")
                println("Cassie message sent")

                send("New Message from Hannah!!")
                println("Hannah message sent")
            }
        }

        lifecycleScope.launch {
            channel.consumeEach {
                println("Message : $it")
            }
        }

    }

}


