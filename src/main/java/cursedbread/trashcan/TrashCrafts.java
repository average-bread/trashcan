package cursedbread.trashcan;

import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class TrashCrafts implements RecipeEntrypoint {
	public static final String MOD_ID = "trashcan";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void initNamespaces() {

	}
	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Item.bucketLava)
			.create("lava block", new ItemStack(Block.fluidLavaFlowing, 1));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Item.bucketWater)
			.create("water block", new ItemStack(Block.fluidWaterFlowing, 1));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Item.toolFirestriker)
			.create("fire", new ItemStack(Block.fire, 129));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Item.toolFirestrikerSteel)
			.create("fire but epic", new ItemStack(Block.fire, 4609));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("HHH", "HHH", "HHH")
			.addInput('H', Block.fire)
			.create("fire but epic", new ItemStack(Item.chainlink, 1));
	}
}

