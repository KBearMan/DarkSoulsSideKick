package zeik.darksoulsequipmentcalculator;

/**
 * Created by Zeik on 1/13/2015.
 */
public class Weapon {
    String Name;
    enum WeaponType
    {
        Axes,
        Bows,
        Crossbows,
        Curved_Swords,
        Daggers,
        Fist,
        Great_Axes,
        Greatbows,
        Great_Hammer,
        GreatSwords,
        Halberds,
        Hammer,
        Katanas,
        Large_Shield,
        Normal_Shield,
        Shields,
        Small_Shields,
        Spears,
        Straight_Swords,
        Thrusting_Swords,
        Ultra_GreatSwords,
        Unique_Shield,
        Whips
    }

    int Damage[] = new int[6]; //Physical,Magic,Fire,Lightning
    boolean DamageTypes[] = new boolean[4]; //Regular,Strike,Slash,Thrust
    int AuxDamage[] = new int[4]; //Bleed,Poison,Holy,Occult
    int Critical;
    int Durability;
    float Weight;
    int Requirements[] = new int[4]; //Str,Dex,Int,Faith
    char StatBonus[] = new char[4]; //Str,Dex,Int,Faith
    int DmgRedux[] = new int[4]; //Physical,Magic,Fire,Lightning
    int Stability;
    int SoulValue;
    int PurchaseCost;
}
