package ua.lokha.antiexplosion;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void on(BlockExplodeEvent event) {
        event.blockList().clear();
    }

    @EventHandler
    public void on(EntityExplodeEvent event) {
        event.blockList().clear();
    }

    @EventHandler
    public void on(HangingBreakByEntityEvent event) {
        if (event.getCause().equals(HangingBreakEvent.RemoveCause.EXPLOSION)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void on(HangingBreakEvent event) {
        if (event.getCause().equals(HangingBreakEvent.RemoveCause.EXPLOSION)) {
            event.setCancelled(true);
        }
    }
}
