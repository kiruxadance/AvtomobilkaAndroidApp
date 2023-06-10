package ru.kiruxadance.core.network.model

data class UserDto(
    val auto_count: Int,
    val avatar: AvatarDto,
    val id: Int,
    val main_auto_name: String,
    val username: String
)