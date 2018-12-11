package yazzyyas.w6_recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yazzyyas.w6_recipeapp.models.Recipe;
import yazzyyas.w6_recipeapp.models.Recipes;

public class MainActivity extends AppCompatActivity {

	private static final List<Recipe> recipes = new ArrayList<>();
	private SectionsPagerAdapter recipeSectionsPagerAdapter;
	private ViewPager recipeViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		requestData();

		recipeSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), recipes);
		recipeViewPager = findViewById(R.id.container);
		recipeViewPager.setAdapter(recipeSectionsPagerAdapter);
	}

	private void requestData() {
		RecipeService recipeService = RecipeApi.create();
		Call<Recipes> recipeCall = recipeService.getTopRatedRecipes();
		recipeCall.enqueue(new Callback<Recipes>() {
			@Override
			public void onResponse(Call<Recipes> call, Response<Recipes> response) {
				// Voeg alle recepten toe aan lijst
				recipes.addAll(Arrays.asList(response.body().recipes));
				recipeSectionsPagerAdapter.notifyDataSetChanged();
			}

			@Override
			public void onFailure(Call<Recipes> call, Throwable t) {
				Log.i("yroo", "onFailure: ");
				t.printStackTrace();
			}
		});
	}
}
