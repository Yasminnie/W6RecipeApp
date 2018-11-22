package yazzyyas.w6_recipeapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import yazzyyas.w6_recipeapp.models.Recipe;

public interface RecipeService {
    String BASE_URL = "https://www.food2fork.com/api/";
//    String API_KEY = "751a246ddd5e249b754b4f9976168ba5";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/search?key=751a246ddd5e249b754b4f9976168ba5&sort=r}")
    Call<Recipe> getTopRatedRecipes();

//    @GET)("/get?key=751a246ddd5e249b754b4f9976168ba5&rID="@Body(Recipe recipe))
}

// URL recepten
// https://www.food2fork.com/api/search?key=751a246ddd5e249b754b4f9976168ba5&sort=r

// URL details
// https://www.food2fork.com/api/get?key=751a246ddd5e249b754b4f9976168ba5&rId=35382