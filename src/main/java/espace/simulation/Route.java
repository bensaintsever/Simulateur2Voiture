package espace.simulation;

/**
 * Route corresponds aux informations relatives à une route.
 *
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class Route {
    private int position;
    private Direction direction;

    /**
     * Constructeur de Route.
     *
     * @param position position de la route.
     * @param d        Direction de la route.
     */
    public Route(int position, Direction d) {
        this.position = position;
        this.direction = d;
    }

    /**
     * Permet de recupérer la postion de la route.
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * Permet de recuperer la direction de la route.
     *
     * @return
     */
    public Direction getDirection() {
        return direction;
    }
}
