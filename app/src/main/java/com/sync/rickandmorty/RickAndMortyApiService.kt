package com.sync.rickandmorty

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int): Response<Character>
}


