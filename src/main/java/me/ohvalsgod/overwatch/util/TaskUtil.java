package me.ohvalsgod.overwatch.util;

import me.ohvalsgod.basic.Basic;

import org.bukkit.scheduler.BukkitRunnable;

public class TaskUtil {

    public static void run(Runnable runnable) {
        Basic.getInstance().getServer().getScheduler().runTask(Basic.getInstance(), runnable);
    }

    public static void runTimer(Runnable runnable, long delay, long timer) {
        Basic.getInstance().getServer().getScheduler().runTaskTimer(Basic.getInstance(), runnable, delay, timer);
    }

    public static void runTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(Basic.getInstance(), delay, timer);
    }

    public static void runLater(Runnable runnable, long delay) {
        Basic.getInstance().getServer().getScheduler().runTaskLater(Basic.getInstance(), runnable, delay);
    }

    public static void runAsync(Runnable runnable) {
        Basic.getInstance().getServer().getScheduler().runTaskAsynchronously(Basic.getInstance(), runnable);
    }

}
