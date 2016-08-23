package error998.tutor;

import java.util.Locale;

public class Reference 
{
	public static final String MOD_ID = "tutor";
	public static final String NAME = "Error's Tutor Mod";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_VERSION = "[1.10.2]";
	public static final String DOMAIN = MOD_ID.toLowerCase(Locale.US);
	
	public static final String CLIENT_PROXY_CLASS = "error998.tutor.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "error998.tutor.proxy.ServerProxy";
	
	// Declare all items here
	public static enum TutorItems {
		CHEESE("cheese", "ItemCheese"),
		CRACKER("cracker", "ItemCracker"),
		CHEESECRACKER("cheese_cracker", "ItemCheeseCracker"),
		TOMATOSAUCE("tomato_sauce", "ItemTomatoSauce");
		
		private String unlocalizedName;
		private String registryName;
		
		TutorItems(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName(){
			return unlocalizedName;
		}
		
		public String getRegistryName(){
			return registryName;
		}
	}
	
	
	// Declare all blocks here
	public static enum TutorBlocks {
		BASIC_BLOCK("basicblock", "BlockBasic"),
		CHEESE("cheese", "BlockCheese"),
		JAR("jar", "BlockJar"),
		CHEESE_MAKER("cheesemaker","BlockCheeseMaker");
		
		private String unlocalizedName;
		private String registryName;
		
		TutorBlocks(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName(){
			return unlocalizedName;
		}
		
		public String getRegistryName(){
			return registryName;
		}
	}
}
