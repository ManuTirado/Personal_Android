package com.example.pruebamvvm.domain

import com.example.pruebamvvm.data.QuoteRepository
import com.example.pruebamvvm.data.database.entities.toDatabase
import com.example.pruebamvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    // Esta función se llama cuando se llama al objeto con paréntesis, por ejm si creas un objeto de esta clase llamado objeto, se llama al poner objeto()
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}