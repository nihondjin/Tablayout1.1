package com.example.tablayout.model

import java.io.Serializable

data class CharacterModel(
    var imageUrl: String,
    var name: String,
    var age: Int,

) : Serializable