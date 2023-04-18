package com.example.newsapp.models

data class NewResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)