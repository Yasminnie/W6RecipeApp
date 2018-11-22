package yazzyyas.w6_recipeapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yazzyyas.w6_recipeapp.models.Recipe;

public class MainActivity extends AppCompatActivity {

    private static final List<Recipe> recipes = new ArrayList<>();
    private SectionsPagerAdapter recipeSectionsPagerAdapter;
    private ViewPager recipeViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        vul hier recipes arraylist

        recipeSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        recipeViewPager = (ViewPager) findViewById(R.id.container);
        recipeViewPager.setAdapter(recipeSectionsPagerAdapter);
    }

    private void requestData() {
        RecipeService recipeService = RecipeService.retrofit.create(RecipeService.class);
        Call<Recipe> recipeCall = recipeService.getTopRatedRecipes();
        recipeCall.enqueue(new Callback<Recipe>() {
            @Override
            public void onResponse(Call<Recipe> call, Response<Recipe> response) {
                Log.d("response", "onResponse: ", response);
                //                ID pakken voor een tweede call?
            }

            @Override
            public void onFailure(Call<Recipe> call, Throwable t) {
                Log.d("yroo", "onFailure: ");
                t.printStackTrace();
            }
        });
    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ImageView imageView = rootView.findViewById(R.id.pictureOfRecipe);


            //            imageView.setImageResource(recipes.get(getArguments().getInt(ARG_SECTION_NUMBER)).getImageRes());
            Glide.with(context)
                    .load("hier komt bestandsnaam")
                    .into(imageView);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return recipes.size();
        }
    }
}
