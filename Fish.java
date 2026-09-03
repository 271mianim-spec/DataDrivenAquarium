public class Fish extends SeaCreature {

    private String symbol;

    public Fish(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        if (symbol.isEmpty()) {
            throw new InvalidCreatureException("Fish must be given a valid symbol");
        }
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }



    private String reverseSymbol(String text) {
        String fishString = new StringBuilder(text).reverse().toString();
        String finalFishString = "";

        for (char c : fishString.toCharArray()) {
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
            finalFishString = finalFishString.concat(c + "");
        }

        return finalFishString;
    }
}
