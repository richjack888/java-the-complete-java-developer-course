package SetChallenge;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
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

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            Key objKey = ((HeavenlyBody) obj).getKey();
            return this.key.equals(objKey);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return getKey().getName() + ": " + getKey().getBodyType() + ", " + getOrbitalPeriod();
    }


    enum BodyTypes {
        PLANET, DWARF_PLANET, MOON
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj == null) || (obj.getClass() != this.getClass())) {
                System.out.println("obj is null or not equal!");
                return false;
            }

            String objName = ((HeavenlyBody.Key) obj).getName();
            BodyTypes objBodyType = ((HeavenlyBody.Key) obj).getBodyType();
            return this.name.equals(objName) && this.bodyType.equals(objBodyType);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 37;
        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }
    }
}


class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        }
        return false;

    }
}


class DwarfPlanet extends HeavenlyBody {
    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.DWARF_PLANET);
    }
}


class Moon extends HeavenlyBody {
    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.MOON);
    }
}

