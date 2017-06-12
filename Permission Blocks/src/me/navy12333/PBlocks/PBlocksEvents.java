package me.navy12333.PBlocks;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;



public class PBlocksEvents implements Listener {
	
	@EventHandler
	public void onJoin (PlayerJoinEvent player) {
		Player playere = player.getPlayer();
		playere.getName();
		
		BukkitScheduler scheduler = me.navy12333.PBlocks.PBlocksMain.getPlugin().getServer().getScheduler();
	    scheduler.scheduleSyncDelayedTask(me.navy12333.PBlocks.PBlocksMain.getPlugin(), new Runnable() {
	        @Override
	      public void run() {
		playere.sendMessage(ChatColor.GRAY + "This server is using " + ChatColor.GRAY + "[" + ChatColor.AQUA + "PBLOCKS" + ChatColor.GRAY+ "] ");
		playere.sendMessage(ChatColor.GRAY + "Which can be found here: " + ChatColor.GOLD + "https://www.spigotmc.org/resources/permission-blocks.27009/");
	}
}, 80L);
}

	public Material BlockPlacedName = Material.AIR;
	public String playerSTR = "";
	@EventHandler
	public void BlockPlace (BlockPlaceEvent BPE) {
		Block BlockPlaced = BPE.getBlock();
		BlockPlacedName = BPE.getBlock().getType();
		
		Player player = BPE.getPlayer();
		playerSTR = player.getName();
		if (player.isOp()) {
			return;
		}
		else if (player.hasPermission("pblocks." + BlockPlacedName)) {
			BlockPlaced.setType(Material.AIR);
			player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "PBlocks" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You do not have the permission to place " + BlockPlacedName) ;
			
			this.GiveItem();
			
		}
		
	}
	
	public void GiveItem() {
		Player player = Bukkit.getPlayer(playerSTR);
		player.getInventory().addItem(new ItemStack (BlockPlacedName));
		player.updateInventory();
		player.getInventory().removeItem(new ItemStack (BlockPlacedName));
		player.updateInventory();
	}
	

}
