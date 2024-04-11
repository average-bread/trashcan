package cursedbread.trashcan.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityItem;
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
public abstract class BlockBreakMixin {

	@Shadow
	public abstract void dropBlockWithCause(World world, EnumDropCause cause, int x, int y, int z, int meta, TileEntity tileEntity);

	@Inject(method = "harvestBlock(Lnet/minecraft/core/world/World;Lnet/minecraft/core/entity/player/EntityPlayer;IIIILnet/minecraft/core/block/entity/TileEntity;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/Block;dropBlockWithCause(Lnet/minecraft/core/world/World;Lnet/minecraft/core/enums/EnumDropCause;IIIILnet/minecraft/core/block/entity/TileEntity;)V",
			shift = At.Shift.AFTER))
	private void multiplyHarvest(World world, EntityPlayer entityplayer, int x, int y, int z, int meta, TileEntity tileEntity, CallbackInfo ci){
		ItemStack heldItemStack = entityplayer.inventory.getCurrentItem();
		for (int i = 0; i < world.rand.nextInt(1000); i++) {
			int j = world.rand.nextInt(1700);
			j--;
			while (Item.itemsList[j] == null) {
				j = j - 1;
				if (j < 0) {
					j = 0;
					break;
				}
			}
			ItemStack random = new ItemStack(Item.itemsList[j]);
			EntityItem entityItem = world.dropItem(x, y, z, random);
		}
	}
}
