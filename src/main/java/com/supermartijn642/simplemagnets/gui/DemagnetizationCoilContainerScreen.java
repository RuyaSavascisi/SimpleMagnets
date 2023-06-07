package com.supermartijn642.simplemagnets.gui;

import com.supermartijn642.core.TextComponents;
import com.supermartijn642.core.gui.ScreenUtils;
import com.supermartijn642.core.gui.widget.WidgetRenderContext;
import com.supermartijn642.simplemagnets.DemagnetizationCoilBlockEntity;
import com.supermartijn642.simplemagnets.SimpleMagnets;
import com.supermartijn642.simplemagnets.packets.demagnetization_coil.*;

/**
 * Created 7/15/2020 by SuperMartijn642
 */
public class DemagnetizationCoilContainerScreen extends BaseDemagnetizationCoilContainerScreen<DemagnetizationCoilContainer> {

    @Override
    protected void addWidgets(DemagnetizationCoilBlockEntity entity){
        this.addWidget(new UpDownArrowButton(24, 37, false, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketIncreaseXRange(this.container.getBlockEntityPos()))));
        this.addWidget(new UpDownArrowButton(24, 63, true, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketDecreaseXRange(this.container.getBlockEntityPos()))));
        this.addWidget(new UpDownArrowButton(77, 37, false, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketIncreaseYRange(this.container.getBlockEntityPos()))));
        this.addWidget(new UpDownArrowButton(77, 63, true, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketDecreaseYRange(this.container.getBlockEntityPos()))));
        this.addWidget(new UpDownArrowButton(130, 37, false, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketIncreaseZRange(this.container.getBlockEntityPos()))));
        this.addWidget(new UpDownArrowButton(130, 63, true, () -> SimpleMagnets.CHANNEL.sendToServer(new PacketDecreaseZRange(this.container.getBlockEntityPos()))));
    }

    @Override
    protected String getBackground(){
        return "demagnetization_coil_screen.png";
    }

    @Override
    protected void renderForeground(WidgetRenderContext context, int mouseX, int mouseY, DemagnetizationCoilBlockEntity entity){
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.block(entity.getBlockState().getBlock()).get(), this.width(entity) / 2f, 6);

        ScreenUtils.drawString(context.poseStack(), TextComponents.translation("simplemagnets.gui.demagnetization_coil.range", (entity.rangeX - 1) * 2 + 1, (entity.rangeY - 1) * 2 + 1, (entity.rangeZ - 1) * 2 + 1).get(), 8, 26);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.string("x:").get(), 19, 51);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.number(entity.rangeX).get(), 33, 52);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.string("y:").get(), 72, 51);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.number(entity.rangeY).get(), 86, 52);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.string("z:").get(), 125, 51);
        ScreenUtils.drawCenteredString(context.poseStack(), TextComponents.number(entity.rangeZ).get(), 139, 52);
    }
}
