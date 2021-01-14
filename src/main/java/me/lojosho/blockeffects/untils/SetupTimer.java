package me.lojosho.blockeffects.untils;

import me.lojosho.blockeffects.BlockEffects;
import org.bukkit.Bukkit;
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
        // duration = how long it will last in tickets
        // amp = how strong it is
        int duration = 100;
        int amp = 1;
        // potion effects
        PotionEffectType Speed = PotionEffectType.SPEED;
        PotionEffectType JUMP = PotionEffectType.JUMP;
        PotionEffectType STRENGTH = PotionEffectType.INCREASE_DAMAGE;
        PotionEffectType BLIND = PotionEffectType.BLINDNESS;
        PotionEffectType REGEN = PotionEffectType.REGENERATION;
        PotionEffectType FIRERESIST = PotionEffectType.FIRE_RESISTANCE;
        PotionEffectType INVIS = PotionEffectType.INVISIBILITY;
        // Sets up the timer
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
                    case BLACK_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(BLIND, duration, amp));
                        break;
                    case PINK_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(REGEN, duration, amp));
                        break;
                    case ORANGE_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(FIRERESIST, duration, amp));
                        break;
                    case GRAY_GLAZED_TERRACOTTA:
                        player.addPotionEffect(new PotionEffect(INVIS, duration, amp));
                        break;
                }
            }
        }, 0, 5);
    }
}
