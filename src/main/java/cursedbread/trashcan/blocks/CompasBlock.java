package cursedbread.trashcan.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class CompasBlock extends Block {
	public CompasBlock(String key, int id) {
		super(key, id, Material.stone);
	}
	int i;
	int j;
	int k;
	int q;

	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		q = world.getBlockId(x, y, z);
		i = (int)(Math.random()-10 * 10);
		j = (int)(Math.random()-10 * 10);
		k = (int)(Math.random()-10 * 10);
		world.setBlock(x + i, y + j, z + k, q);
		return false;
	}
}
