package me.mchiappinam.pdghacucar;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	  private static Main instance;

	  public static Main getInstance() {
	    return instance;
	  }

	  public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage("§3[PDGHAcucar] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHAcucar] §2Acesse: http://pdgh.net/");
	  }

	  public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHAcucar] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHAcucar] §2Acesse: http://pdgh.net/");
	    getServer().resetRecipes();
	  }
		
@EventHandler
public void onPlayerInteract(PlayerInteractEvent event) {
  if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
    int heal = 7; //Main.getInstance().getConfig().getInt("RegenHP");
    ItemStack ri = new ItemStack(Material.SUGAR, 1);

    if ((event.getPlayer().getItemInHand().getType() == Material.SUGAR)) {

      if (event.getPlayer().getHealth() < 20) {
        if (event.getPlayer().getHealth() < 20 - heal + 1) {
          event.getPlayer().setHealth(event.getPlayer().getHealth() + heal);
          event.getPlayer().getInventory().removeItem(new ItemStack[] { ri });
      	  event.getPlayer().sendMessage("§4§l[PDGH] §cSua vida não está cheia. §aAtivando sistema de regeneração.");
        } else if ((event.getPlayer().getHealth() < 20) && (event.getPlayer().getHealth() > 20 - heal)) {
          event.getPlayer().setHealth(20);
          event.getPlayer().getInventory().removeItem(new ItemStack[] { ri });
      	  event.getPlayer().sendMessage("§4§l[PDGH] §cSua vida não está cheia. §aAtivando sistema de regeneração.");
        }
      } else if ((event.getPlayer().getHealth() == 20) && (event.getPlayer().getFoodLevel() < 20)) {
              event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel() + heal);
              event.getPlayer().getInventory().removeItem(new ItemStack[] { ri });
          	   event.getPlayer().sendMessage("§4§l[PDGH] §aVocê está com a vida cheia e portanto irá usar o açucar como comida.");
             }
           }
    }
  }
}