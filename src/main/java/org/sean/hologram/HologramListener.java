package org.sean.hologram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramListener implements CommandExecutor {

    // hologram create [c] [COLOR] <message>
    //             0    1     2        3

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("hologram")){
            if (args[0].equalsIgnoreCase("create")) {

                String message;

                if (args[1].equalsIgnoreCase("c")) {
                    ChatColor setColor;
                    String color = args[2];

                    if (color.equals("AQUA")){
                        setColor = ChatColor.AQUA;
                    } else if (color.equals("BLACK")) {
                        setColor = ChatColor.BLACK;
                    } else if (color.equals("BLUE")) {
                        setColor = ChatColor.BLUE;
                    } else if (color.equals("DARK_AQUA")) {
                        setColor = ChatColor.DARK_AQUA;
                    } else if (color.equals("DARK_BLUE")) {
                        setColor = ChatColor.DARK_BLUE;
                    } else if (color.equals("DARK_GRAY")) {
                        setColor = ChatColor.DARK_GRAY;
                    } else if (color.equals("DARK_GREEN")) {
                        setColor = ChatColor.DARK_GREEN;
                    } else if (color.equals("DARK_PURPLE")) {
                        setColor = ChatColor.DARK_PURPLE;
                    } else if (color.equals("DARK_RED")) {
                        setColor = ChatColor.DARK_RED;
                    } else if (color.equals("GOLD")) {
                        setColor = ChatColor.GOLD;
                    } else if (color.equals("GRAY")) {
                        setColor = ChatColor.GRAY;
                    } else if (color.equals("GREEN")) {
                        setColor = ChatColor.GREEN;
                    } else if (color.equals("LIGHT_PURPLE")) {
                        setColor = ChatColor.LIGHT_PURPLE;
                    } else if (color.equals("RED")) {
                        setColor = ChatColor.RED;
                    } else if (color.equals("YELLOW")){
                        setColor = ChatColor.YELLOW;
                    } else {
                        plr.sendMessage(ChatColor.RED + "Please enter a color!");
                        plr.sendMessage(ChatColor.GRAY + "Color argument expected color but you gave it " + color);
                        setColor = ChatColor.WHITE;

                    }

                    ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, 1.5, 0), EntityType.ARMOR_STAND);
                    stand.setVisible(false);
                    stand.setGravity(false);
                    stand.setInvulnerable(true);

                    stand.setCustomNameVisible(true);
                    message = args[3];
                    stand.setCustomName(setColor + message);
                } else {
                    message = args[1];

                    ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, 1.5, 0), EntityType.ARMOR_STAND);
                    stand.setVisible(false);
                    stand.setGravity(false);
                    stand.setInvulnerable(true);

                    stand.setCustomNameVisible(true);
                    stand.setCustomName(message);
                }

                try {
                    plr.sendMessage(ChatColor.GREEN + "Your hologram was created successfully " + ChatColor.BLUE + plr.getName() + "!");
                } catch (Exception e) {
                    plr.sendMessage(ChatColor.RED + "There was an error creating your hologram " + ChatColor.BLUE + plr.getName() + "!");
                    plr.sendMessage("The format for this command is: hologram create <message>");
                }
            } else {
                plr.sendMessage(ChatColor.RED + "There was an error creating your hologram " + plr.getName());
                plr.sendMessage(ChatColor.GRAY + "The format for this command is: hologram create [c] [COLOR] <message>");
                plr.sendMessage("Refer to the Spigot ChatColor documentation for text colors: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/ChatColor.html");
            }
        }

        return false;
    }
}
