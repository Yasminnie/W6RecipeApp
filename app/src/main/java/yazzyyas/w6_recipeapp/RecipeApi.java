package yazzyyas.w6_recipeapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApi {

	final static String BASE_URL = "https://www.food2fork.com/";
	final static String API_KEY = "751a246ddd5e249b754b4f9976168ba5";

	public static RecipeService create() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(createOkHttpClient())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		return retrofit.create(RecipeService.class);
	}

	private static OkHttpClient createOkHttpClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(new HttpLoggingInterceptor()
						.setLevel(HttpLoggingInterceptor.Level.BODY))
				.build();
	}

}
