package me.alpha432.oyvey.features.modules.client;

import me.alpha432.oyvey.DiscordPresence;
import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;

public
class RPC
        extends Module {
    public static RPC INSTANCE;
    public Setting < Boolean > showIP = this.register ( new Setting <> ( "ShowIP" , Boolean.TRUE , "Shows the server IP in your discord presence." ) );
    public Setting < String > state = this.register ( new Setting <> ( "State" , "Incoming v1.2.6" , "Sets the state of the DiscordRPC." ) );

    public
    RPC ( ) {
        super ( "RPC" , "Discord rich presence" , Category.CLIENT , false , false , false );
        INSTANCE = this;
    }

    @Override
    public
    void onEnable ( ) {
        me.alpha432.oyvey.DiscordPresence.start ( );
    }

    @Override
    public
    void onDisable ( ) {
        me.alpha432.oyvey.DiscordPresence.stop ( );
    }
}

