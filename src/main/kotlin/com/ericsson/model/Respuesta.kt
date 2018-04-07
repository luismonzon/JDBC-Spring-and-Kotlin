package com.ericsson.model


data class Respuesta (
    val message:String = "",
    val code: String ="",
    val data: Any?
)