package cursedbread.trashcan.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(value= Block.class,remap=false)
public abstract class BlockRandomMixin {

	private float movementScale;

	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int i = world.rand.nextInt(910);
		i++;
		while (Block.blocksList[i] == null) {
			i = i - 1;
			if (i < 0) {
				i = 0;
				break;
			}
		}
		world.setBlock(x, y, z, i);

		this.movementScale = 0.98f;
	}
}
