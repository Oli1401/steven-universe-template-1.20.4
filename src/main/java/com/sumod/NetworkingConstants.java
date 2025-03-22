package com.sumod;

import com.sumod.StevenUniverse;
import net.minecraft.util.Identifier;

public class NetworkingConstants {
    public static final Identifier SELECT_GEM_PACKET_ID = new Identifier(StevenUniverse.MOD_ID, "select_gem");
    public static final Identifier POOF_PACKET_ID = new Identifier(StevenUniverse.MOD_ID, "poof_gem");
    public static final Identifier SHATTER_PACKET_ID = new Identifier(StevenUniverse.MOD_ID, "shatter_gem");
    public static final Identifier FUSION_REQUEST_PACKET_ID = new Identifier(StevenUniverse.MOD_ID, "fusion_request");
    public static final Identifier FUSION_ACCEPT_PACKET_ID = new Identifier(StevenUniverse.MOD_ID, "fusion_accept");
}