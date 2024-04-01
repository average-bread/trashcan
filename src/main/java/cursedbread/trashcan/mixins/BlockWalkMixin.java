package cursedbread.trashcan.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= Block.class,remap=false)
public abstract class BlockWalkMixin {

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		int i = world.rand.nextInt(910);
		i--;
		while (Block.blocksList[i] == null) {
			i = i - 1;
			if (i < 0) {
				i = 0;
				break;
			}
		}
		world.setBlock(x, y, z, i);
	}
}
