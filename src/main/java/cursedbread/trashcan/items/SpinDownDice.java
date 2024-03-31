package cursedbread.trashcan.items;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class SpinDownDice extends Item {
	public SpinDownDice(String item, int i) {
		super(item, i);
	}

	int i;
	int j;
	int k;

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		i = world.getBlockId(x, y, z);
		world.setBlock(x, y, z, i-1);
		return false;
	}
}

