public class Crab extends SeaCreature {

    public Crab(String name, int position, int speed, int direction) throws InvalidCreatureException {
        super(name, position, speed, direction);
    }

    @Override
    public void move(int tankWidth) {
        position += (speed + (position % 2 == 0 ? 0 : 1)) * direction;
        keepInsideTank(tankWidth);
    }

    @Override
    public String getSymbol() {
        return "=>(._.)<=";
    }
}
