package ru.netology.pusher2

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

import androidx.core.app.NotificationCompat


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "cVO7znqtRYaQY6G4efBfnf:APA91bGluVkHknHEypgElGNGkO620YaAOTdpR4KscD7hMQOAQiH-G-xkHw_jx_VBX0MXAbzY7eINzezCwBOMKVU3MC8MxSiROeQOjSsS3briOMAoC6wS9FUkJbzbHjCYDPICKp1Mhi1H"

    val messageLike = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Username",
          "postId": 2,
          "postAuthor": "Me"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageShare = Message.builder()
        .putData("action", "SHARE")
        .putData("content", """{
          "userId": 1,
          "userName": "Username",
          "postId": 2,
          "postAuthor": "Me"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageNewPost = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Username",
          "postId": 2,
          "postAuthor": "Me"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(messageLike)
    FirebaseMessaging.getInstance().send(messageShare)
    FirebaseMessaging.getInstance().send(messageNewPost)
    FirebaseMessaging.getInstance().send(messageShare)
}