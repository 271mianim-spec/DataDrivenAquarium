public class Jellyfish extends SeaCreature {

    private String symbol;
    private boolean canMove;

    public Jellyfish(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
        this.canMove = true;
    }

    @Override
    public void move(int tankWidth) {
        if (canMove) {
            canMove = false;
            position += speed * direction;
            keepInsideTank(tankWidth);
        } else {
            canMove = true;
        }
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }

    private String reverseSymbol(String text) {
        String jellyFishString = new StringBuilder(text).reverse().toString();
        String finalJellyFishString = "";

        for (char c : jellyFishString.toCharArray()) {
            if (c == '(') {
                c = ')';
            }
            else if (c == ')') {
                c = '(';
            }
            else if (c == '>') {
                c = '<';
            }
            else if (c == '<') {
                c = '>';
            }
            finalJellyFishString = finalJellyFishString.concat(c + "");
        }

        return finalJellyFishString;
    }
}
