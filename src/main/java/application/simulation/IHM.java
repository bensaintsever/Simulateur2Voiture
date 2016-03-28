package application.simulation;

import domaine.voiture.Voiture;
import espace.simulation.Direction;
import espace.simulation.Monde;
import espace.simulation.Route;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe IHM comprenant l'intégration du necessaire pour contruire l'IHM.
 *
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class IHM extends JFrame implements Observer {

    /**
     * Parametre de conversion Metres Pixels.
     */
    private static final double paramatreConversionMetresPixels = 0.5;
    /**
     * Objet voiture.
     */
    private Voiture maVoiture;
    /**
     * Objet commande voiture.
     */
    private CommandeVoiture maCommandeVoiture;
    /**
     * Liste d'objet route.
     */
    private ArrayList<Route> listRoute;

    /**
     * Constructeur de l'IHM.
     * Initialise l'IHM et prend en paramètre un Monde.
     *
     * @param monde un Monde déjà initialisé.
     */
    public IHM(Monde monde) {
        super();
        this.listRoute = monde.getListedeRoute();
        this.maVoiture = monde.getVoiture();
        this.maVoiture.addObserver(this);
        initGraphique();
    }

	/*public IHM(Voiture maVoiture, Route maRoute) {
        super();
		this.maVoiture = maVoiture;
		this.maRoute = maRoute;
		maVoiture.addObserver(this);
		initGraphique();
	}*/

    /**
     * Constructeur de l'IHM.
     */
    public IHM() {
        super();
        initGraphique();
        this.maVoiture = null;
    }

    /**
     * initGraphique permet d'initialisé la fenetre graphique.
     */
    private void initGraphique() {
        this.setTitle("Simulateur de Voiture");
        this.setSize(505, 505);

        this.maCommandeVoiture = new CommandeVoiture(this, this.maVoiture);
        this.setVisible(true);
    }

    /**
     * Permet de calculer la position (pixels).
     *
     * @param xMetres position de l'objet.
     * @return la position de l'objet mais convertis dans un format souhaité.
     */
    public int calculerPositionPixels(int xMetres) {
        return (int) (paramatreConversionMetresPixels * xMetres);
    }

    /**
     * Mise a jour des informations par les observateur.
     *
     * @param arg0 observateur.
     * @param arg1 Objet à mettre a jour.
     */
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    /**
     * Méthode pour dessiner les objets graphiques.
     *
     * @param contexteGraphique correspond aux paramètres souhaités à
     *                          appliquer.
     */
    public void paint(Graphics contexteGraphique) {
        super.paint(contexteGraphique);

        for (Route r : listRoute) {
            dessinerRoute(contexteGraphique, r);
        }
        dessinerVoiture(contexteGraphique);
    }

    /**
     * Permet de dessiner une voiture dans la fenêtre graphique.
     *
     * @param contexteGraphique correspond aux paramètres souhaités à
     *                          appliquer.
     */
    private void dessinerVoiture(Graphics contexteGraphique) {
        contexteGraphique.setColor(Color.red);
        int xMetres = maVoiture.getPositionX();
        int xPixel = calculerPositionPixels(xMetres);
        contexteGraphique.fillRect(xPixel, 300, 30, 15);
    }

    /**
     * Permet de dessiner une route sur la fenêtre graphique.
     *
     * @param contexteGraphique correspond aux paramètres souhaités à
     *                          appliquer.
     * @param maRoute           objet route.
     */
    private void dessinerRoute(Graphics contexteGraphique, Route maRoute) {
        contexteGraphique.setColor(Color.black);
        int pos = maRoute.getPosition();
        Direction dir = maRoute.getDirection();

        if (dir == Direction.VERTICALE)
            contexteGraphique.fillRect(pos, 0, 30, 1000);
        else
            contexteGraphique.fillRect(0, pos, 1000, 30);

    }


}
