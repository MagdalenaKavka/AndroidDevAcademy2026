package com.kavkamagdalena.notes.ui.theme

import retrofit2.http.*

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("tasks/all")
    suspend fun getTasks(@Header("Authorization") token: String): List<Task>

    @POST("tasks/create")
    suspend fun createTask(
        @Header("Authorization") token: String,
        @Body request: CreateTaskRequest
    ): Task

    @GET("tasks/{id}")
    suspend fun getTask(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Task

    @PUT("tasks/{id}")
    suspend fun updateTask(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body request: CreateTaskRequest
    ): Task

    @DELETE("tasks/{id}")
    suspend fun deleteTask(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    )
}