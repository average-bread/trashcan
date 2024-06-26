package cursedbread.trashcan;

import cursedbread.trashcan.blocks.ClockBlock;
import cursedbread.trashcan.blocks.CompasBlock;
import cursedbread.trashcan.items.IdDetector;
import cursedbread.trashcan.items.SpinDownDice;
import cursedbread.trashcan.items.SpinUpDice;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFire;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;

import java.util.Properties;


public class TrashMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "trashcan";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static BlockBuilder fullBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelRenderBlocks(0));

	public static int blockId;
	public static int itemId;
	public static Item upDice;
	public static Item downDice;
	public static Item idDetector;
	public static Block fireBlock;
	public static Block clockBlock;
	public static Block compassBlock;
	static{
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","2000");
		prop.setProperty("starting_item_id","17000");

		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");


		config.updateConfig();
	}
	@Override
	public void onInitialize() {
		LOGGER.info("Entering the trash");
	}

	@Override
	public void beforeGameStart() {
		fireBlock = fullBlock
			.setTextures("fireblock.png")
			.build(new BlockFire("fireblock", blockId++));

		clockBlock = fullBlock
			.setSideTextures("clockblock_side.png")
			.setTopBottomTexture("clockblock_top.png")
			.build(new ClockBlock("clockblock", blockId++));

		compassBlock = fullBlock
			.setSideTextures("compasblock_side.png")
			.setTopBottomTexture("compasblock_top.png")
			.build(new CompasBlock("compasblock", blockId++));

		upDice = ItemHelper.createItem(MOD_ID, new SpinUpDice("upDice", itemId++), "upDice.png");
		downDice = ItemHelper.createItem(MOD_ID, new SpinDownDice("downDice", itemId++), "downDice.png");
		idDetector = ItemHelper.createItem(MOD_ID, new IdDetector("idDetector", itemId++), "idDetector.png");
	}

	@Override
	public void afterGameStart() {

	}
}
