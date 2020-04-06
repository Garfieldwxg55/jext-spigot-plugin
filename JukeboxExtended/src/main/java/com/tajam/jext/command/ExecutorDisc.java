package com.tajam.jext.command;

import com.tajam.jext.config.ConfigDiscManager;
import com.tajam.jext.disc.DiscContainer;

import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ExecutorDisc extends ExecutorAdapter {

  public ExecutorDisc(ConsoleCommandSender consoleSender, String permissionString, int[] argsLength) {
    super(consoleSender, permissionString, argsLength);
  }

  @Override
  protected boolean executePlayer(Player sender, int argv, String[] args) {
    ConfigDiscManager manager = ConfigDiscManager.getInstance();
    DiscContainer disc = manager.getDisc(args[0]);
    if (disc == null) {
      sender.sendMessage(ChatColor.DARK_RED + "That disc doesn't exists.");
      return true;
    }
    sender.getInventory().addItem(disc.getDiscItem());
    return true;
  }
}