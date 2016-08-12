package error998.tutor.init;

import error998.tutor.Reference;
import error998.tutor.tileenity.TileEntityCheeseMaker;
import error998.tutor.tileenity.TileEntityJar;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {

	public static void register(){
		GameRegistry.registerTileEntity(TileEntityJar.class, Reference.MOD_ID + "TileEntityJar");
		GameRegistry.registerTileEntity(TileEntityCheeseMaker.class, Reference.MOD_ID + "TileEntityCheeseMaker");
	}
}
