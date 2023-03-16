package com.example.pruebamvvm.domain.model

import com.example.pruebamvvm.data.database.entities.QuoteEntity
import com.example.pruebamvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)