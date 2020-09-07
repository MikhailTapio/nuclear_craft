package com.song.nuclear_craft.misc;

import com.song.nuclear_craft.NuclearCraft;
import com.song.nuclear_craft.blocks.container.C4BombContainer;
import com.song.nuclear_craft.blocks.container.C4BombContainerScreen;
import com.song.nuclear_craft.network.C4BombSettingPacket;
import com.song.nuclear_craft.network.NuclearCraftPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.screen.ModListScreen;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NuclearCraft.MODID, value = Dist.CLIENT)
public class ClientEventForgeSubscriber {

    @SubscribeEvent
    public static void onInitGuiEvent(final GuiScreenEvent.InitGuiEvent event){
        //TODO client to server
        Screen gui = event.getGui();
        if (gui instanceof C4BombContainerScreen){
            int i = (gui.width - ((C4BombContainerScreen) gui).getXSize()) / 2;
            int j = (gui.height - ((C4BombContainerScreen) gui).getYSize()) / 2;
            int input_id = 1;
            for (int row=0; row<=2; row++){
                for(int col=0; col<=3; col++){
                    int finalInput_id = input_id;
                    event.addWidget(new Button(i+14+col*30, j+57+row*30, 20, 20,
                            new StringTextComponent(""+input_id), button-> {
                        NuclearCraftPacketHandler.C4_SETTING_CHANNEL.sendToServer(new C4BombSettingPacket(((C4BombContainerScreen) gui).getContainer().tileEntity.getPos(), "add_"+ finalInput_id));
                        // TODO syn problem?
//                        ((C4BombContainerScreen) gui).getContainer().tileEntity.addNum(finalInput_id);
                    }));
                    input_id++;
                    if (row==2) {
                        row++;
                        break;
                    }
                }
            }
            event.addWidget(new Button(i+44, j+117, 20, 20,
                    new StringTextComponent("0"), button-> {
                NuclearCraftPacketHandler.C4_SETTING_CHANNEL.sendToServer(new C4BombSettingPacket(((C4BombContainerScreen) gui).getContainer().tileEntity.getPos(), "add_"+ 0));
//                ((C4BombContainerScreen) gui).getContainer().tileEntity.addNum(0);
            }));
            event.addWidget(new Button(i+74, j+117, 20, 20,
                    new StringTextComponent(""), button-> {
                NuclearCraftPacketHandler.C4_SETTING_CHANNEL.sendToServer(new C4BombSettingPacket(((C4BombContainerScreen) gui).getContainer().tileEntity.getPos(), "delete"));
//                ((C4BombContainerScreen) gui).getContainer().tileEntity.delete();
            }));
            event.addWidget(new Button(i+104, j+117, 20, 20,
                    new StringTextComponent(""), button-> {
                NuclearCraftPacketHandler.C4_SETTING_CHANNEL.sendToServer(new C4BombSettingPacket(((C4BombContainerScreen) gui).getContainer().tileEntity.getPos(), "activate"));
//                ((C4BombContainerScreen) gui).getContainer().tileEntity.activate();
            }));
        }
    }
}
