package org.bukkit.event.server;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class SendMessageEvent extends ServerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final CommandSender recipient;
    private String message;
    private final String permission;

    public SendMessageEvent(final CommandSender recipient, final String message, final String permission) {
        this.recipient = recipient;
        this.message = message;
        this.permission = permission;
    }
    
    /**
     * Gets the recipient the message will be sent to
     *
     * @return Recipient that will be sent message
     */
    public CommandSender getRecipient() {
        return recipient;
    }

    /**
     * Gets the message that the recipient will be sent
     *
     * @return Message the recipient will be sent
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message that the recipient will be sent
     *
     * @param message New message that the recipient will be sent
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the permission that was required to receive this message as part of a broadcast
     *
     * @return Permission name that was required; null if not a broadcast
     */
    public String getPermission() {
        return permission;
    }

    public boolean isCancelled() {
        return cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
