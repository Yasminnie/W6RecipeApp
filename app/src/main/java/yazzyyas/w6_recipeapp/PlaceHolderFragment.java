package yazzyyas.w6_recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import yazzyyas.w6_recipeapp.models.Recipe;

class PlaceholderFragment extends Fragment {
	private Recipe recipeData;

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_RECIPE_NUMBER = "section_number";
	ImageView imageView;
	TextView recipeTitle;

	public PlaceholderFragment() {
	}

	/**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	public static PlaceholderFragment newInstance(Recipe recipe) {
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putParcelable(ARG_RECIPE_NUMBER, recipe);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		recipeData = getArguments().getParcelable(ARG_RECIPE_NUMBER);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		imageView = rootView.findViewById(R.id.pictureOfRecipe);
		recipeTitle = rootView.findViewById(R.id.titleOfRecipe);
		recipeTitle.setText(recipeData.getTitle());

		Glide.with(this)
				.load(recipeData.getImageUrl())
				.into(imageView);
		return rootView;
	}
}

class SectionsPagerAdapter extends FragmentPagerAdapter {
	private List<Recipe> recipes;

	public SectionsPagerAdapter(FragmentManager fm, List<Recipe> recipes) {
		super(fm);
		this.recipes = recipes;
	}

	@Override
	public Fragment getItem(int position) {
		return PlaceholderFragment.newInstance(recipes.get(position));
	}

	@Override
	public int getCount() {
		return recipes.size();
	}
}
