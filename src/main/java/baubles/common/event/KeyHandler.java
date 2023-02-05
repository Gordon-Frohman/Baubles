package baubles.common.event;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;

import baubles.common.network.PacketHandler;
import baubles.common.network.PacketOpenBaublesInventory;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeyHandler {

    public KeyBinding key = new KeyBinding(
            StatCollector.translateToLocal("keybind.baublesinventory"),
            Keyboard.KEY_NONE,
            "key.categories.inventory");

    public KeyHandler() {
        ClientRegistry.registerKeyBinding(key);
    }

    @SideOnly(value = Side.CLIENT)
    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (key.isPressed()) {
            PacketHandler.INSTANCE.sendToServer(new PacketOpenBaublesInventory());
        }
    }
}
