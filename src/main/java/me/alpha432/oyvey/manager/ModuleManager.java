package me.alpha432.oyvey.manager;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.event.events.Render2DEvent;
import me.alpha432.oyvey.event.events.Render3DEvent;
import me.alpha432.oyvey.features.Feature;
import me.alpha432.oyvey.features.gui.OyVeyGui;
import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.modules.client.*;
import me.alpha432.oyvey.features.modules.combat.*;
import me.alpha432.oyvey.features.modules.misc.*;
import me.alpha432.oyvey.features.modules.module2b2t.*;
import me.alpha432.oyvey.features.modules.movement.*;
import me.alpha432.oyvey.features.modules.player.*;
import me.alpha432.oyvey.features.modules.render.*;
import me.alpha432.oyvey.features.modules.troll.*;
import me.alpha432.oyvey.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ModuleManager
        extends Feature {
    public ArrayList<Module> modules = new ArrayList<>();
    public List<Module> sortedModules = new ArrayList<>();
    public List<String> sortedModulesABC = new ArrayList<>();
    public Animation animationThread;

    public void init() {
    	//client
       this.modules.add(new ClickGui());
       this.modules.add(new CSGOWatermark());
       this.modules.add(new HUD());
       this.modules.add(new Icon());
       this.modules.add(new Logo());
       this.modules.add(new ModuleTools());
       this.modules.add(new NickHider());
       this.modules.add(new RPC());
       //troll
       this.modules.add(new FontMod());       
       this.modules.add(new PenisESP());
       this.modules.add(new TestModule());
       //combat
       this.modules.add(new AimBot());
       this.modules.add(new AutoArmor());
       this.modules.add(new AutoCrystal());
       this.modules.add(new AutoTrap());
       this.modules.add(new AutoWeb());
       this.modules.add(new BowMcBomb());
       this.modules.add(new Burrow());
       this.modules.add(new Criticals());
       this.modules.add(new GodModule());
       this.modules.add(new HoleFiller());
       this.modules.add(new Killaura());
       this.modules.add(new Offhand());
       this.modules.add(new SelfFill());
       this.modules.add(new Selftrap());
       this.modules.add(new SelfWeb());
       this.modules.add(new ShulkerAura());
       this.modules.add(new Surround());
       //module2b2t
       this.modules.add(new InstantSelfFill());
       this.modules.add(new AntiHunger());
       this.modules.add(new AutoLog());
       this.modules.add(new AutoWalk());
       this.modules.add(new ExtraTab());
       this.modules.add(new NoAFK());
       this.modules.add(new NewChunks());     
       this.modules.add(new NoSlow2b());
       this.modules.add(new QueueSkip());   
//       this.modules.add(new Speed2b2t());
       //misc
       this.modules.add(new AntiDesync());
       this.modules.add(new AntiPackets());
       this.modules.add(new Auto());
       this.modules.add(new AutoFish());
       this.modules.add(new AutoGG());
       this.modules.add(new AutoReconnect());
       this.modules.add(new AutoSignKick());
       this.modules.add(new BetterPortals());
       this.modules.add(new BookCrash());
       this.modules.add(new BuildHeight());
       this.modules.add(new ChatLogger());
       this.modules.add(new ChatModifier());
       this.modules.add(new DupeCanceller());
       this.modules.add(new FakeKick());
       this.modules.add(new FriendSettings());
       this.modules.add(new GreenText());
       this.modules.add(new Lawnmower());
       this.modules.add(new MCF());
       this.modules.add(new MountBypass());
       this.modules.add(new NoHandShake());
       this.modules.add(new NoHitBox());
       this.modules.add(new OldFagDupe());
       this.modules.add(new PacketLogger());
       this.modules.add(new PearlNotify());
       this.modules.add(new PopCounter());
       this.modules.add(new RenameBypass());
       this.modules.add(new StashLogger());
       this.modules.add(new SwapCrash());
       this.modules.add(new ToolTips());
       this.modules.add(new Tracker());
       this.modules.add(new VisualRange());
       //movement
       this.modules.add(new Anchor());
       this.modules.add(new AntiLevitate());
       this.modules.add(new AntiVoid());
       this.modules.add(new AntiWeb());
       this.modules.add(new BoatFly());
       this.modules.add(new ElytraFlight());
       this.modules.add(new EntityControl());
       this.modules.add(new IceSpeed());
       this.modules.add(new LongJump());
       this.modules.add(new NoFall());
       this.modules.add(new NoSlow());
       this.modules.add(new Phase());
       this.modules.add(new ReverseStep());
       this.modules.add(new Scaffold());
       this.modules.add(new Speed());
       this.modules.add(new Sprint());
       this.modules.add(new Step());
       this.modules.add(new Strafe());
       this.modules.add(new Velocity());
       //player
       this.modules.add(new Announcer());
       this.modules.add(new AntiKick());
       this.modules.add(new EntityDesync());
       this.modules.add(new EntityNotifier());
       this.modules.add(new FakePlayer());
       this.modules.add(new FastPlace());
       this.modules.add(new Godmode());
       this.modules.add(new HasteHack());
       this.modules.add(new InstantMine());
       this.modules.add(new LiquidInteract());
       this.modules.add(new MCP());
       this.modules.add(new MiddleClick());
       this.modules.add(new MultiTask());
       this.modules.add(new NoEntityTrace());
       this.modules.add(new NoGlitchBlocks());
       this.modules.add(new PacketMine());
       this.modules.add(new PosDesync());
       this.modules.add(new Replenish());
       this.modules.add(new TimerSpeed());
       this.modules.add(new TpsSync());
       this.modules.add(new XCarry());
       this.modules.add(new Yaw());
       //render
       this.modules.add(new Animations());
       this.modules.add(new Aspect());
       this.modules.add(new BlockHighlight());
       this.modules.add(new BurrowESP());
       this.modules.add(new CameraClip());
       this.modules.add(new CancelSwing());
       this.modules.add(new Chams());
       this.modules.add(new CityEsp());
       this.modules.add(new CrystalScale());
       this.modules.add(new ESP());
       this.modules.add(new Fullbright());
       this.modules.add(new HandChams());
       this.modules.add(new HoleESP());
       this.modules.add(new Nametags());
       this.modules.add(new NoRender());
       this.modules.add(new PopChams());
       this.modules.add(new Shaders());
       this.modules.add(new Skeleton());
       this.modules.add(new SkyColor());
       this.modules.add(new SmallShield());
       this.modules.add(new StorageESP());
       this.modules.add(new TexturedChams());
       this.modules.add(new Tracer());
       this.modules.add(new Trajectories());
       this.modules.add(new ViewModChanger());
       this.modules.add(new ViewModel());
       this.modules.add(new Wireframe());
       this.modules.add(new XRay());
    }

    public Module getModuleByName(String name) {
        for (Module module : this.modules) {
            if (!module.getName().equalsIgnoreCase(name)) continue;
            return module;
        }
        return null;
    }

    public <T extends Module> T getModuleByClass(Class<T> clazz) {
        for (Module module : this.modules) {
            if (!clazz.isInstance(module)) continue;
            return (T) module;
        }
        return null;
    }

    public void enableModule(Class<Module> clazz) {
        Module module = this.getModuleByClass(clazz);
        if (module != null) {
            module.enable();
        }
    }

    public void disableModule(Class<Module> clazz) {
        Module module = this.getModuleByClass(clazz);
        if (module != null) {
            module.disable();
        }
    }

    public void enableModule(String name) {
        Module module = this.getModuleByName(name);
        if (module != null) {
            module.enable();
        }
    }

    public void disableModule(String name) {
        Module module = this.getModuleByName(name);
        if (module != null) {
            module.disable();
        }
    }

    public boolean isModuleEnabled(String name) {
        Module module = this.getModuleByName(name);
        return module != null && module.isOn();
    }

    public boolean isModuleEnabled(Class<Module> clazz) {
        Module module = this.getModuleByClass(clazz);
        return module != null && module.isOn();
    }

    public Module getModuleByDisplayName(String displayName) {
        for (Module module : this.modules) {
            if (!module.getDisplayName().equalsIgnoreCase(displayName)) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> getEnabledModules() {
        ArrayList<Module> enabledModules = new ArrayList<>();
        for (Module module : this.modules) {
            if (!module.isEnabled()) continue;
            enabledModules.add(module);
        }
        return enabledModules;
    }

    public ArrayList<String> getEnabledModulesName() {
        ArrayList<String> enabledModules = new ArrayList<>();
        for (Module module : this.modules) {
            if (!module.isEnabled() || !module.isDrawn()) continue;
            enabledModules.add(module.getFullArrayString());
        }
        return enabledModules;
    }

    public ArrayList<Module> getModulesByCategory(Module.Category category) {
        ArrayList<Module> modulesCategory = new ArrayList<>();
        this.modules.forEach(module -> {
            if (module.getCategory() == category) {
                modulesCategory.add(module);
            }
        });
        return modulesCategory;
    }

    public List<Module.Category> getCategories() {
        return Arrays.asList(Module.Category.values());
    }

    public void onLoad() {
        this.modules.stream().filter(Module::listening).forEach(((EventBus) MinecraftForge.EVENT_BUS)::register);
        this.modules.forEach(Module::onLoad);
    }

    public void onUpdate() {
        this.modules.stream().filter(Feature::isEnabled).forEach(Module::onUpdate);
    }

    public void onTick() {
        this.modules.stream().filter(Feature::isEnabled).forEach(Module::onTick);
    }

    public void onRender2D(Render2DEvent event) {
        this.modules.stream().filter(Feature::isEnabled).forEach(module -> module.onRender2D(event));
    }

    public void onRender3D(Render3DEvent event) {
        this.modules.stream().filter(Feature::isEnabled).forEach(module -> module.onRender3D(event));
    }

    public void sortModules(boolean reverse) {
        this.sortedModules = this.getEnabledModules().stream().filter(Module::isDrawn).sorted(Comparator.comparing(module -> this.renderer.getStringWidth(module.getFullArrayString()) * (reverse ? -1 : 1))).collect(Collectors.toList());
    }

    public void sortModulesABC() {
        this.sortedModulesABC = new ArrayList<>(this.getEnabledModulesName());
        this.sortedModulesABC.sort(String.CASE_INSENSITIVE_ORDER);
    }

    public void onLogout() {
        this.modules.forEach(Module::onLogout);
    }

    public void onLogin() {
        this.modules.forEach(Module::onLogin);
    }

    public void onUnload() {
        this.modules.forEach(MinecraftForge.EVENT_BUS::unregister);
        this.modules.forEach(Module::onUnload);
    }

    public void onUnloadPost() {
        for (Module module : this.modules) {
            module.enabled.setValue(false);
        }
    }

    public void onKeyPressed(int eventKey) {
        if (eventKey == 0 || !Keyboard.getEventKeyState() || ModuleManager.mc.currentScreen instanceof OyVeyGui) {
            return;
        }
        this.modules.forEach(module -> {
            if (module.getBind().getKey() == eventKey) {
                module.toggle();
            }
        });
    }

    private class Animation
            extends Thread {
        public Module module;
        public float offset;
        public float vOffset;
        ScheduledExecutorService service;

        public Animation() {
            super("Animation");
            this.service = Executors.newSingleThreadScheduledExecutor();
        }

        @Override
        public void run() {
            if (HUD.getInstance().renderingMode.getValue(true) == HUD.RenderingMode.Length) {
                for (Module module : ModuleManager.this.sortedModules) {
                    String text = module.getDisplayName() + ChatFormatting.GRAY + (module.getDisplayInfo() != null ? " [" + ChatFormatting.WHITE + module.getDisplayInfo() + ChatFormatting.GRAY + "]" : "");
                    module.offset = (float) ModuleManager.this.renderer.getStringWidth(text) / HUD.getInstance().animationHorizontalTime.getValue(true).floatValue();
                    module.vOffset = (float) ModuleManager.this.renderer.getFontHeight() / HUD.getInstance().animationVerticalTime.getValue(true).floatValue();
                    if (module.isEnabled() && HUD.getInstance().animationHorizontalTime.getValue(true) != 1) {
                        if (!(module.arrayListOffset > module.offset) || Util.mc.world == null) continue;
                        module.arrayListOffset -= module.offset;
                        module.sliding = true;
                        continue;
                    }
                    if (!module.isDisabled() || HUD.getInstance().animationHorizontalTime.getValue(true) == 1) continue;
                    if (module.arrayListOffset < (float) ModuleManager.this.renderer.getStringWidth(text) && Util.mc.world != null) {
                        module.arrayListOffset += module.offset;
                        module.sliding = true;
                        continue;
                    }
                    module.sliding = false;
                }
            } else {
                for (String e : ModuleManager.this.sortedModulesABC) {
                    Module module = OyVey.moduleManager.getModuleByName(e);
                    String text = module.getDisplayName() + ChatFormatting.GRAY + (module.getDisplayInfo() != null ? " [" + ChatFormatting.WHITE + module.getDisplayInfo() + ChatFormatting.GRAY + "]" : "");
                    module.offset = (float) ModuleManager.this.renderer.getStringWidth(text) / HUD.getInstance().animationHorizontalTime.getValue(true).floatValue();
                    module.vOffset = (float) ModuleManager.this.renderer.getFontHeight() / HUD.getInstance().animationVerticalTime.getValue(true).floatValue();
                    if (module.isEnabled() && HUD.getInstance().animationHorizontalTime.getValue(true) != 1) {
                        if (!(module.arrayListOffset > module.offset) || Util.mc.world == null) continue;
                        module.arrayListOffset -= module.offset;
                        module.sliding = true;
                        continue;
                    }
                    if (!module.isDisabled() || HUD.getInstance().animationHorizontalTime.getValue(true) == 1) continue;
                    if (module.arrayListOffset < (float) ModuleManager.this.renderer.getStringWidth(text) && Util.mc.world != null) {
                        module.arrayListOffset += module.offset;
                        module.sliding = true;
                        continue;
                    }
                    module.sliding = false;
                }
            }
        }

        @Override
        public void start() {
            System.out.println("Starting animation thread.");
            this.service.scheduleAtFixedRate(this, 0L, 1L, TimeUnit.MILLISECONDS);
        }
    }
}
