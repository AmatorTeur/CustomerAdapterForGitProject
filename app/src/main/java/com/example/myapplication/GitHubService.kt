package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(
        @Path("user") user: String,
        @Query ("page") pageNumber: Int,
        @Query("per_page") perPage: Int): Call<List<Repo>>
}