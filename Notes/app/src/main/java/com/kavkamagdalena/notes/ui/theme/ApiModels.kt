package com.kavkamagdalena.notes.ui.theme

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val token: String
)

data class Task(
    val id: Int,
    val title: String,
    val body: String
)

data class CreateTaskRequest(
    val title: String,
    val body: String
)