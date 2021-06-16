package SetChallenge;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        ;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyType);


    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    enum BodyTypes {
        PLANET, DWARF_PLANET, MOON
    }

    private class Key {
        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyTypes.hashCode() + 37;
        }

        @Override
        public String toString() {
            return name + " : " + bodyTypes;
        }
    }

}
//
//class Planet extends HeavenlyBody {
//    private String name;
//    private double orbitalPeriod;
//
//    public Planet(String name, double orbitalPeriod) {
//        super(name, orbitalPeriod);
//    }
//}
//
//class DwarfPlanet extends HeavenlyBody {
//    private String name;
//    private double orbitalPeriod;
//
//    public DwarfPlanet(String name, double orbitalPeriod) {
//        super(name, orbitalPeriod);
//    }
//}
//
//class Moon extends HeavenlyBody {
//    private String name;
//    private double orbitalPeriod;
//
//    public Moon(String name, double orbitalPeriod) {
//        super(name, orbitalPeriod);
//    }
//}
