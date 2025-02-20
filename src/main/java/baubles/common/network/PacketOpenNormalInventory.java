package baubles.common.network;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class PacketOpenNormalInventory implements IMessage, IMessageHandler<PacketOpenNormalInventory, IMessage> {

    public PacketOpenNormalInventory() {}

    public PacketOpenNormalInventory(EntityPlayer player) {}

    @Override
    public void toBytes(ByteBuf buffer) {}

    @Override
    public void fromBytes(ByteBuf buffer) {}

    @Override
    public IMessage onMessage(PacketOpenNormalInventory message, MessageContext ctx) {
        ctx.getServerHandler().playerEntity.openContainer.onContainerClosed(ctx.getServerHandler().playerEntity);
        ctx.getServerHandler().playerEntity.openContainer = ctx.getServerHandler().playerEntity.inventoryContainer;
        return null;
    }

}
