package ru.kiruxadance.core.network.model

data class UserDetailsDto(
    val about: String,
    val auto_count: Int,
    val avatar: AvatarDto,
    val email: String,
    val id: Int,
    val main_auto_name: String,
    val username: String
)