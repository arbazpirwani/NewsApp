package com.example.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Base_Url = "https://newsapi.org/"
const val Api_Key = "092992d064c04bf4a59938b965efbfd8"

interface NewsInterface{

    @GET("v2/top-headlines?apiKey=$Api_Key")
    fun getHeadlines(@Query("country")country:String, @Query("page")page:Int) : Call<News>

}

object NewsService{
     val newsInstance: NewsInterface
    init {
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
