package EspaceSimulation;

/**
 * Created by benjaminsaint-sever on 15/03/2016.
 */
public class Route
{
    private int position;
    private Direction direction;

    public Route(int position, Direction d) {
        this.position = position;
        this.direction = d;
    }

    public int getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}
