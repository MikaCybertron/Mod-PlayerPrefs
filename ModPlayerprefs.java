package com.platinmods;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.atomic.AtomicReference;

public class ModPlayerprefs {

    // Located Playerprefs = PackageName + Playerprefs

    // PackageName: com.zala.game.defense.heroes.td

    // Type Playerprefs:
    // PlayerPrefsX = v2.playerprefs
    // PlayerPrefs = playerprefs

    // Final Located Playerprefs = com.zala.game.defense.heroes.td.v2.playerprefs
    private static final String Located_Playerprefs = "com.zala.game.defense.heroes.td.v2.playerprefs";

    @SuppressLint("CommitPrefEdits")
    public static void Modded(Context context) {
        @SuppressLint("CommitPrefEdits") AtomicReference<Editor> Mod;
        Mod = new AtomicReference<>(context.getSharedPreferences(Located_Playerprefs, 0).edit());
        Mod.get().putInt("totalGem", 99999999);
        Mod.get().putInt("totalSoulStone", 88888888);
        Mod.get().putInt("totalCoin", 77777777);
        Mod.get().putInt("totalKeySummon", 66666666);
        Mod.get().putInt("totalPointTalent", 55555555);
        Mod.get().putInt("totalTicketRaid", 44444444);
        Mod.get().putInt("totalEnergy", 33333333);
        Mod.get().putInt("totalBookSkills", 22222222);
        Mod.get().apply();
    }
}