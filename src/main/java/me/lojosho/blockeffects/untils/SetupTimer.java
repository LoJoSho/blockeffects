package me.lojosho.blockeffects.untils;

import me.lojosho.blockeffects.BlockEffects;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SetupTimer {

    private final BlockEffects plugin;

    public SetupTimer(BlockEffects plugin) {
        this.plugin = plugin;
        starttimer();
    }

    public void starttimer() {

        int duration = 100;
        int amp = 1;

        PotionEffectType Speed = PotionEffectType.SPEED;
        PotionEffectType JUMP = PotionEffectType.JUMP;
        PotionEffectType STRENGTH = PotionEffectType.INCREASE_DAMAGE;


        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                switch (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType()) {
                    case YELLOW_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(Speed, duration, amp));
                        break;
                    case GREEN_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(JUMP, duration, amp));
                        break;
                    case RED_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(STRENGTH, duration, amp));
                        break;
                }
            }
        }, 0, 10);
    }
}
