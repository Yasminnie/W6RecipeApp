package yazzyyas.w6_recipeapp;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import yazzyyas.w6_recipeapp.models.Recipes;

import static yazzyyas.w6_recipeapp.RecipeApi.API_KEY;

public interface RecipeService {
    @GET("/api/search?key=" + API_KEY + "&sort=r}")
    Call<Recipes> getTopRatedRecipes();
}
