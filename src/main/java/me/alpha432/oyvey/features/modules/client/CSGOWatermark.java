package me.alpha432.oyvey.features.modules.client;

import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.event.events.Render2DEvent;
import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;
import me.alpha432.oyvey.util.ColorUtil;
import me.alpha432.oyvey.util.RenderUtil;
import me.alpha432.oyvey.util.Timer;

public class CSGOWatermark extends Module {

    Timer delayTimer = new Timer();
    public Setting<Integer> X = this.register(new Setting("WatermarkX", 0, 0, 300));
    public Setting<Integer> Y = this.register(new Setting("WatermarkY", 0, 0, 300));
    public Setting<Integer> delay = this.register(new Setting<Object>("Delay", 240, 0, 600));
    public Setting<Integer> saturation = this.register(new Setting<Object>("Saturation", 127, 1, 255));
    public Setting<Integer> brightness = this.register(new Setting<Object>("Brightness", 100, 0, 255));
    public float hue;
    public int red = 1;
    public int green = 1;
    public int blue = 1;

    private String message = "";

    public CSGOWatermark() {
        super("CSGOWatermark", "noat em cee actually makes something", Module.Category.CLIENT, true, false, false);
    }

    @Override
    public void onRender2D(Render2DEvent event) {
        drawCsgoWatermark();
    }

    public void drawCsgoWatermark() {
        int padding = 5;
        message = "Incoming v1.2.6 | " + mc.player.getName() + " | " + OyVey.serverManager.getPing() + "ms";
        Integer textWidth = mc.fontRenderer.getStringWidth(message); // taken from wurst+ 3
        Integer textHeight = mc.fontRenderer.FONT_HEIGHT; // taken from wurst+ 3
        RenderUtil.drawRectangleCorrectly(X.getValue(true) - 4, Y.getValue(true) - 4, textWidth + 16, textHeight + 12, ColorUtil.toRGBA(22, 22, 22, 255));
        RenderUtil.drawRectangleCorrectly(X.getValue(true), Y.getValue(true), textWidth + 4, textHeight + 4, ColorUtil.toRGBA(0, 0, 0, 255));
        RenderUtil.drawRectangleCorrectly(X.getValue(true), Y.getValue(true), textWidth + 8, textHeight + 4, ColorUtil.toRGBA(0, 0, 0, 255));
        RenderUtil.drawRectangleCorrectly(X.getValue(true), Y.getValue(true), textWidth + 8, 1, ColorUtil.rainbow(this.delay.getValue(true)).hashCode());
        mc.fontRenderer.drawString(message, X.getValue(true) + 3, Y.getValue(true) + 3, ColorUtil.toRGBA(255, 255, 255, 255), false);
    }
}
