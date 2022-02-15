package game;

public class Cell {

    private CellState state;

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public enum CellState {
        UNKNOWN("?"),
        CLEAR(" "),
        SHOOTED_WATER("."),
        SHOOTED_SHIP("@"),
        SHIP("O");

        private final String representation;

        CellState(String representation){
            this.representation = representation;
        }

        public String getRepresentation() {
            return representation;
        }
    }
}
