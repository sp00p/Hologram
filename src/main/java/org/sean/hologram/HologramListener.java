package org.sean.hologram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class HologramListener implements CommandExecutor, Listener {

    // hologram create c [COLOR] y [y position] <bold> <itallic> <strikethrough> <magic> <message>
    //            0    1    2    3       4        5        6           7            8       9

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (plr.hasPermission("hologram.use")) {

            if (cmd.getName().equalsIgnoreCase("hologram")) {
                if (args[0].equals("create")) {

                    String message;

                    if (args[1].equalsIgnoreCase("c") && args[3].equals("y")) {

                        double yNum = Double.parseDouble(args[4]);
                        ChatColor setColor;
                        String color = args[2];

                        switch (color) {
                            case "AQUA":
                                setColor = ChatColor.AQUA;
                                break;
                            case "BLACK":
                                setColor = ChatColor.BLACK;
                                break;
                            case "BLUE":
                                setColor = ChatColor.BLUE;
                                break;
                            case "DARK_AQUA":
                                setColor = ChatColor.DARK_AQUA;
                                break;
                            case "DARK_BLUE":
                                setColor = ChatColor.DARK_BLUE;
                                break;
                            case "DARK_GRAY":
                                setColor = ChatColor.DARK_GRAY;
                                break;
                            case "DARK_GREEN":
                                setColor = ChatColor.DARK_GREEN;
                                break;
                            case "DARK_PURPLE":
                                setColor = ChatColor.DARK_PURPLE;
                                break;
                            case "DARK_RED":
                                setColor = ChatColor.DARK_RED;
                                break;
                            case "GOLD":
                                setColor = ChatColor.GOLD;
                                break;
                            case "GRAY":
                                setColor = ChatColor.GRAY;
                                break;
                            case "GREEN":
                                setColor = ChatColor.GREEN;
                                break;
                            case "LIGHT_PURPLE":
                                setColor = ChatColor.LIGHT_PURPLE;
                                break;
                            case "RED":
                                setColor = ChatColor.RED;
                                break;
                            case "YELLOW":
                                setColor = ChatColor.YELLOW;
                                break;
                            default:
                                plr.sendMessage(ChatColor.RED + "Please enter a color!");
                                plr.sendMessage(ChatColor.GRAY + "Color argument expected color but you gave it " + color);
                                setColor = ChatColor.WHITE;
                                break;
                        }


                        ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        stand.setGravity(false);
                        stand.setInvulnerable(true);

                        stand.setCustomNameVisible(true);
                        message = args[9];


                        if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("false")) { // t f f f
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("false")) { // f t f f
                            stand.setCustomName(setColor + "" + ChatColor.ITALIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("false")) { // f f t f
                            stand.setCustomName(setColor + "" + ChatColor.STRIKETHROUGH + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("true")) { // f f f t
                            stand.setCustomName(setColor + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("true")) { // t t f t
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("false")) { // f t t f
                            stand.setCustomName(setColor + "" + ChatColor.ITALIC + "" + ChatColor.STRIKETHROUGH + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("true")) { // f f t t
                            stand.setCustomName(setColor + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("false")) { // t t t f
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "" + ChatColor.STRIKETHROUGH + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("true")) { // t f t t
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("true")) { // f t f t
                            stand.setCustomName(setColor + "" + ChatColor.ITALIC + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("true")) { // f t t t
                            stand.setCustomName(setColor + "" + ChatColor.ITALIC + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("true")) { // t f f t
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("false")) { // t f t f
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("true") && args[8].equalsIgnoreCase("true")) { // t t t t
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + "" + ChatColor.STRIKETHROUGH + "" + ChatColor.MAGIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("true") && args[6].equalsIgnoreCase("true") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("false")) { // t t f f
                            stand.setCustomName(setColor + "" + ChatColor.BOLD + "" + ChatColor.ITALIC + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else if (args[5].equalsIgnoreCase("false") && args[6].equalsIgnoreCase("false") && args[7].equalsIgnoreCase("false") && args[8].equalsIgnoreCase("false")) { // f f f f
                            stand.setCustomName(setColor + message);
                            plr.sendMessage(ChatColor.GREEN + "Sucessfully created hologram with name " + message);
                        } else {
                            plr.sendMessage(ChatColor.RED + "Incorrect formatting!");
                        }
                    }
                } else if(args[0].equals("delete")) {
                    try {
                        getServer().dispatchCommand(getServer().getConsoleSender(), "kill @e[type=armor_stand] {id=" + args[1] + "}");
                        plr.sendMessage(ChatColor.GREEN + "Hologram deleted successfully!");
                    } catch (Error e) {
                        plr.sendMessage(ChatColor.RED + "Hologram does not exist!");
                    }
                }
            }
        } else {
            plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return false;
    }
}




