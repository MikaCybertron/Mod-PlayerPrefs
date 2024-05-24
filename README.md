# How to Mod PlayerPrefs of Unity Games (including IL2CPP)
[![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/MikaCybertron/Mod-PlayerPrefs/total?style=for-the-badge&logo=windows10&link=https%3A%2F%2Fgithub.com%2FMikaCybertron%2FMod-PlayerPrefs%2Freleases)](https://github.com/MikaCybertron/Mod-PlayerPrefs/releases)

# Q & A
- Q: What is PlayerPrefs in Unity Games?
- A: `PlayerPrefs` is a class that stores Player preferences between game sessions. It can store string, float and integer values into the user’s platform registry.

- Q: Where is PlayerPrefs stored in?
- A: On Android, PlayerPrefs are stored in `/data/data/pkg-name/shared_prefs/pkg-name.v2.playerprefs.xml` or `/data/data/pkg-name/shared_prefs/pkg-name.playerprefs.xml`

- Q: How to make it works in the mods?
- A: what you have to do is build the source code with Android Studio to get the smali files then call that smali file in `OnCreate` of Launch Activity Smali Games. but make sure the path of PlayerPrefs games is correct.


# Example:
- As an example you can use this game **[Defense Heroes](https://play.google.com/store/apps/details?id=com.zala.game.defense.heroes.td)**

- Example Code:
```java
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
```

# How to call the smali file into your mods
- Copy and Place the smali files that you get from Android Studio
- Then call the file with this smali code
```smali
invoke-static {p0}, Lcom/platinmods/ModPlayerprefs;->Modded(Landroid/content/Context;)V
```
