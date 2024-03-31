package cursedbread.trashcan.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class ClockBlock extends Block {
	public ClockBlock(String key, int id) {
		super(key, id, Material.stone);
	}
	int i;
	int j;
	int k;

	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		i = (int) world.getWorldTime();
		j = (int)(Math.random() * 999999999);
		world.setWorldTime(i + j);
		return false;
	}
}
