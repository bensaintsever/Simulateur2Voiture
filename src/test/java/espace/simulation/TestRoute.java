package espace.simulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by benjaminsaint-sever on 15/03/2016.
 */
public class TestRoute {

    private Route _route;

    public void setUp() {

    }

    /**
     * Test si le paramètre Position constructeur de Route est OK
     */
    @Test
    public void testDirectionHorizontale()
    {
        Direction direction = Direction.HORIZONTALE;
        int positionY = 50;

        _route = new Route(positionY, direction);
        assertEquals(_route.getDirection(),Direction.HORIZONTALE);
    }

    /**
     * Test si le paramètre Direction du constructeur est OK
     */
    @Test
    public void testPosition()
    {
        Direction direction = Direction.HORIZONTALE;
        int positionY = 50;

        _route = new Route(positionY, direction);
        assertEquals(_route.getPosition(),50);
    }

    @Test
    public void testIntegrationVoitureSurRoute(){

    }

}



