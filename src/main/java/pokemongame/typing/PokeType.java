package pokemongame.typing;

import java.util.EnumMap;
import java.util.Map;

public class PokeType {

     // All possible types
     public static enum ALL_TYPES
     {Normal, 
     Fire,
     Water, 
     Grass, 
     Electric, 
     Ice, 
     Fighting, 
     Poison, 
     Ground, 
     Flying, 
     Psychic, 
     Bug, 
     Rock, 
     Ghost, 
     Dark, 
     Dragon, 
     Steel, 
     Fairy};

     // default effectiveness
    private static final double DEFAULT_EFFECTIVENESS = 1.0;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // EFFECTIVENESS MAPPING FOR EACH TYPE
    ////////////////////////////////////////////////////////////////////////////////////////////////////

     // NORMAL TYPE ATTACKER
     private static final Map<ALL_TYPES, Double> NORMAL_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

     static {
        NORMAL_TYPE.put(ALL_TYPES.Rock, 0.5);
        NORMAL_TYPE.put(ALL_TYPES.Ghost, 0.0);
        NORMAL_TYPE.put(ALL_TYPES.Steel, 0.5);
     }

     // FIRE TYPE ATTACKER
     private static final Map<ALL_TYPES, Double> FIRE_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

     static {
        FIRE_TYPE.put(ALL_TYPES.Fire, 0.5);
        FIRE_TYPE.put(ALL_TYPES.Water, 0.5);
        FIRE_TYPE.put(ALL_TYPES.Grass, 2.0);
        FIRE_TYPE.put(ALL_TYPES.Ice, 2.0);
        FIRE_TYPE.put(ALL_TYPES.Bug, 2.0);
        FIRE_TYPE.put(ALL_TYPES.Rock, 0.5);
        FIRE_TYPE.put(ALL_TYPES.Dragon, 0.5);
        FIRE_TYPE.put(ALL_TYPES.Steel, 2.0);
     }

     // WATER TYPE ATTACKER
     private static final Map<ALL_TYPES, Double> WATER_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

     static {
        WATER_TYPE.put(ALL_TYPES.Fire, 2.0);
        WATER_TYPE.put(ALL_TYPES.Water, 0.5);
        WATER_TYPE.put(ALL_TYPES.Grass, 0.5);
        WATER_TYPE.put(ALL_TYPES.Ground, 2.0);
        WATER_TYPE.put(ALL_TYPES.Rock, 2.0);
        WATER_TYPE.put(ALL_TYPES.Dragon, 0.5);
     }

    // GRASS TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> GRASS_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        GRASS_TYPE.put(ALL_TYPES.Fire, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Water, 2.0);
        GRASS_TYPE.put(ALL_TYPES.Grass, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Poison, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Ground, 2.0);
        GRASS_TYPE.put(ALL_TYPES.Flying, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Bug, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Rock, 2.0);
        GRASS_TYPE.put(ALL_TYPES.Dragon, 0.5);
        GRASS_TYPE.put(ALL_TYPES.Steel, 0.5);
    }
    
    // ELECTRIC TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> ELECTRIC_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        ELECTRIC_TYPE.put(ALL_TYPES.Water, 2.0);
        ELECTRIC_TYPE.put(ALL_TYPES.Grass, 0.5);
        ELECTRIC_TYPE.put(ALL_TYPES.Electric, 0.5);
        ELECTRIC_TYPE.put(ALL_TYPES.Ground, 0.0);
        ELECTRIC_TYPE.put(ALL_TYPES.Flying, 2.0);
        ELECTRIC_TYPE.put(ALL_TYPES.Dragon, 0.5);
    }

    // ICE TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> ICE_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        ICE_TYPE.put(ALL_TYPES.Fire, 0.5);
        ICE_TYPE.put(ALL_TYPES.Water, 0.5);
        ICE_TYPE.put(ALL_TYPES.Grass, 2.0);
        ICE_TYPE.put(ALL_TYPES.Ice, 0.5);
        ICE_TYPE.put(ALL_TYPES.Ground, 2.0);
        ICE_TYPE.put(ALL_TYPES.Flying, 2.0);
        ICE_TYPE.put(ALL_TYPES.Dragon, 2.0);
        ICE_TYPE.put(ALL_TYPES.Steel, 0.5);
    }

    // FIGHTING TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> FIGHTING_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        FIGHTING_TYPE.put(ALL_TYPES.Normal, 2.0);
        FIGHTING_TYPE.put(ALL_TYPES.Ice, 2.0);
        FIGHTING_TYPE.put(ALL_TYPES.Poison, 0.5);
        FIGHTING_TYPE.put(ALL_TYPES.Flying, 0.5);
        FIGHTING_TYPE.put(ALL_TYPES.Psychic, 0.5);
        FIGHTING_TYPE.put(ALL_TYPES.Bug, 0.5);
        FIGHTING_TYPE.put(ALL_TYPES.Rock, 2.0);
        FIGHTING_TYPE.put(ALL_TYPES.Ghost, 0.0);
        FIGHTING_TYPE.put(ALL_TYPES.Dark, 2.0);
        FIGHTING_TYPE.put(ALL_TYPES.Steel, 2.0);
        FIGHTING_TYPE.put(ALL_TYPES.Fairy, 0.5);
    }

    // POISON TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> POISON_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        POISON_TYPE.put(ALL_TYPES.Grass, 2.0);
        POISON_TYPE.put(ALL_TYPES.Poison, 0.5);
        POISON_TYPE.put(ALL_TYPES.Ground, 0.5);
        POISON_TYPE.put(ALL_TYPES.Rock, 0.5);
        POISON_TYPE.put(ALL_TYPES.Ghost, 0.5);
        POISON_TYPE.put(ALL_TYPES.Steel, 0.0);
        POISON_TYPE.put(ALL_TYPES.Fairy, 2.0);
    }

    // GROUND TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> GROUND_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        GROUND_TYPE.put(ALL_TYPES.Fire, 2.0);
        GROUND_TYPE.put(ALL_TYPES.Grass, 0.5);
        GROUND_TYPE.put(ALL_TYPES.Electric, 2.0);
        GROUND_TYPE.put(ALL_TYPES.Poison, 2.0);
        GROUND_TYPE.put(ALL_TYPES.Flying, 0.0);
        GROUND_TYPE.put(ALL_TYPES.Bug, 0.5);
        GROUND_TYPE.put(ALL_TYPES.Rock, 2.0);
        GROUND_TYPE.put(ALL_TYPES.Steel, 2.0);
    }

    // FLYING TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> FLYING_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        FLYING_TYPE.put(ALL_TYPES.Grass, 2.0);
        FLYING_TYPE.put(ALL_TYPES.Electric, 0.5);
        FLYING_TYPE.put(ALL_TYPES.Fighting, 2.0);
        FLYING_TYPE.put(ALL_TYPES.Bug, 2.0);
        FLYING_TYPE.put(ALL_TYPES.Rock, 0.5);
        FLYING_TYPE.put(ALL_TYPES.Steel, 0.5);
    }

    // PSYCHIC TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> PSYCHIC_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        PSYCHIC_TYPE.put(ALL_TYPES.Fighting, 2.0);
        PSYCHIC_TYPE.put(ALL_TYPES.Poison, 2.0);
        PSYCHIC_TYPE.put(ALL_TYPES.Psychic, 0.5);
        PSYCHIC_TYPE.put(ALL_TYPES.Dark, 0.0);
        PSYCHIC_TYPE.put(ALL_TYPES.Steel, 0.5);
    }

    // BUG TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> BUG_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        BUG_TYPE.put(ALL_TYPES.Fire, 0.5);
        BUG_TYPE.put(ALL_TYPES.Grass, 2.0);
        BUG_TYPE.put(ALL_TYPES.Fighting, 0.5);
        BUG_TYPE.put(ALL_TYPES.Poison, 0.5);
        BUG_TYPE.put(ALL_TYPES.Flying, 0.5);
        BUG_TYPE.put(ALL_TYPES.Psychic, 2.0);
        BUG_TYPE.put(ALL_TYPES.Ghost, 0.5);
        BUG_TYPE.put(ALL_TYPES.Dark, 2.0);
        BUG_TYPE.put(ALL_TYPES.Steel, 0.5);
        BUG_TYPE.put(ALL_TYPES.Fairy, 0.5);
    }

    // ROCK TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> ROCK_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        ROCK_TYPE.put(ALL_TYPES.Fire, 2.0);
        ROCK_TYPE.put(ALL_TYPES.Ice, 2.0);
        ROCK_TYPE.put(ALL_TYPES.Fighting, 0.5);
        ROCK_TYPE.put(ALL_TYPES.Ground, 0.5);
        ROCK_TYPE.put(ALL_TYPES.Flying, 2.0);
        ROCK_TYPE.put(ALL_TYPES.Bug, 2.0);
        ROCK_TYPE.put(ALL_TYPES.Steel, 0.5);
    }

    // GHOST TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> GHOST_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        GHOST_TYPE.put(ALL_TYPES.Normal, 0.0);
        GHOST_TYPE.put(ALL_TYPES.Psychic, 2.0);
        GHOST_TYPE.put(ALL_TYPES.Ghost, 2.0);
        GHOST_TYPE.put(ALL_TYPES.Dark, 0.5);
    }

    // DRAGON TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> DRAGON_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        DRAGON_TYPE.put(ALL_TYPES.Dragon, 2.0);
        DRAGON_TYPE.put(ALL_TYPES.Steel, 0.5);
        DRAGON_TYPE.put(ALL_TYPES.Fairy, 0.0);
    }

    // DARK TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> DARK_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        DARK_TYPE.put(ALL_TYPES.Fighting, 0.5);
        DARK_TYPE.put(ALL_TYPES.Psychic, 2.0);
        DARK_TYPE.put(ALL_TYPES.Ghost, 2.0);
        DARK_TYPE.put(ALL_TYPES.Dark, 0.5);
        DARK_TYPE.put(ALL_TYPES.Fairy, 0.5);
    }

    // STEEL TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> STEEL_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        STEEL_TYPE.put(ALL_TYPES.Fire, 0.5);
        STEEL_TYPE.put(ALL_TYPES.Water, 0.5);
        STEEL_TYPE.put(ALL_TYPES.Electric, 0.5);
        STEEL_TYPE.put(ALL_TYPES.Ice, 2.0);
        STEEL_TYPE.put(ALL_TYPES.Rock, 2.0);
        STEEL_TYPE.put(ALL_TYPES.Steel, 0.5);
        STEEL_TYPE.put(ALL_TYPES.Fairy, 2.0);
    }

    // FAIRY TYPE ATTACKER
    private static final Map<ALL_TYPES, Double> FAIRY_TYPE = new EnumMap<ALL_TYPES, Double>(ALL_TYPES.class);

    static {
        FAIRY_TYPE.put(ALL_TYPES.Fire, 0.5);
        FAIRY_TYPE.put(ALL_TYPES.Fighting, 2.0);
        FAIRY_TYPE.put(ALL_TYPES.Poison, 0.5);
        FAIRY_TYPE.put(ALL_TYPES.Dragon, 2.0);
        FAIRY_TYPE.put(ALL_TYPES.Dark, 2.0);
        FAIRY_TYPE.put(ALL_TYPES.Steel, 0.5);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // FULL EFFECTIVENESS LOOK UP TABLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // static type effectiveness look up table
    private static final Map<ALL_TYPES, Map<ALL_TYPES, Double>> TYPE_EFFECTIVENESS_TABLE = new EnumMap<ALL_TYPES, Map<ALL_TYPES, Double>>(ALL_TYPES.class);

    static {
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Normal, NORMAL_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Fire, FIRE_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Water, WATER_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Grass, GRASS_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Electric, ELECTRIC_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Ice, ICE_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Fighting, FIGHTING_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Poison, POISON_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Ground, GROUND_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Flying, FLYING_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Psychic, PSYCHIC_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Bug, BUG_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Rock, ROCK_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Ghost, GHOST_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Dragon, DRAGON_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Dark, DARK_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Steel, STEEL_TYPE);
        TYPE_EFFECTIVENESS_TABLE.put(ALL_TYPES.Fairy, FAIRY_TYPE);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // STATIC METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double calculateEffectiveness(ALL_TYPES moveType, ALL_TYPES[] pokeTypes) {
        double final_multiplier = DEFAULT_EFFECTIVENESS;
        for (ALL_TYPES type: pokeTypes) {
            final_multiplier = final_multiplier*(TYPE_EFFECTIVENESS_TABLE.get(moveType).getOrDefault(type, DEFAULT_EFFECTIVENESS));
        }
        return final_multiplier;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // TESTING
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        ALL_TYPES[] pokemon = {ALL_TYPES.Fighting, ALL_TYPES.Fairy};
        System.out.println(calculateEffectiveness(ALL_TYPES.Steel, pokemon));
        System.out.println(TYPE_EFFECTIVENESS_TABLE.entrySet());
    }
}    
