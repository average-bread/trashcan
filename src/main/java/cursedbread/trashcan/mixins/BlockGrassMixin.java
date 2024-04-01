package cursedbread.trashcan.mixins;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockGrass;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value= Block.class,remap=false)
public abstract class BlockGrassMixin {

	@Shadow
	public abstract void dropBlockWithCause(World world, EnumDropCause cause, int x, int y, int z, int meta, TileEntity tileEntity);

	@Inject(method = "harvestBlock(Lnet/minecraft/core/world/World;Lnet/minecraft/core/entity/player/EntityPlayer;IIIILnet/minecraft/core/block/entity/TileEntity;)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/Block;dropBlockWithCause(Lnet/minecraft/core/world/World;Lnet/minecraft/core/enums/EnumDropCause;IIIILnet/minecraft/core/block/entity/TileEntity;)V"))
	private void randomHarvest(World world, EntityPlayer entityplayer, int x, int y, int z, int meta, TileEntity tileEntity, CallbackInfo ci){
		for (int i = 0; i < world.rand.nextInt(100); i++) {
			this.dropBlockWithCause(world, EnumDropCause.PROPER_TOOL, x, y, z, meta, tileEntity);
		}
	}
}
