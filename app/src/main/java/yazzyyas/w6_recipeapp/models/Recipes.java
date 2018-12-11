package yazzyyas.w6_recipeapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipes {
	@SerializedName("count")
	@Expose
	private Integer count;
	@SerializedName("recipes")
	@Expose
	public Recipe[] recipes = null;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Recipe[] getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe[] recipes) {
		this.recipes = recipes;
	}
}
