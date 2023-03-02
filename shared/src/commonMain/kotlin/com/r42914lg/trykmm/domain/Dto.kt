package com.r42914lg.trykmm.domain

import kotlinx.serialization.Serializable

@Serializable
data class DomainCategory(
    val id: Int,
    val title: String,
    val clues_count: Int,
)