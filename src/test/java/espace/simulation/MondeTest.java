package espace.simulation;

import domaine.voiture.Voiture;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class MondeTest {

    private Monde m;
    private Voiture v;

    @Before
    public void setUp() throws Exception {
        v = new Voiture(0, 0, 0);
        m = new Monde(v);
    }

    @Test
    public void testAjouterRoute() throws Exception {
        Route route = new Route(0, Direction.HORIZONTALE);
        m.ajouterRoute(route);
        assertTrue(m.getListedeRoute().contains(route));
    }

    @Test
    public void testGetVoiture() throws Exception {
        assertTrue(m.getVoiture().equals(v));
    }

    @Test
    public void testGetListedeRoute() throws Exception {

        ArrayList<Route> listeRoute = new ArrayList<Route>();

        Route r1 = new Route(0, Direction.VERTICALE);
        Route r2 = new Route(10, Direction.HORIZONTALE);

        listeRoute.add(r1);
        listeRoute.add(r2);

        Monde m2 = new Monde(v,listeRoute);

        for (Route r : m2.getListedeRoute()) {
            if (!listeRoute.contains(r))
                assertTrue(false);
        }

    }
}