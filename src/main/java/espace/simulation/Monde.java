package espace.simulation;

import domaine.voiture.Voiture;

import java.util.ArrayList;

/**
 * Monde correspond au conteneur des routes, des voitures.
 *
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class Monde {
    /**
     * Objet voiture.
     */
    private Voiture v;
    /**
     * Liste de route.
     */
    private ArrayList<Route> listedeRoute;

    /**
     * Constructeur de Monde.
     * Permet d'initialiser une voiture.
     *
     * @param voiture
     */
    public Monde(Voiture voiture) {
        this.v = voiture;
        this.listedeRoute = new ArrayList<Route>();
    }

    /**
     * Constructeur de Monde.
     * Permet d'initialiser une voiture et des routes dans ce monde.
     *
     * @param voiture      référence de la voiture.
     * @param listedeRoute référence de la liste des routes.
     */
    public Monde(Voiture voiture, ArrayList<Route> listedeRoute) {
        this.v = voiture;
        this.listedeRoute = listedeRoute;
    }

    /**
     * Ajoute une route dans la liste des routes du monde.
     *
     * @param route référence vers une route.
     */
    public void ajouterRoute(Route route) {
        this.listedeRoute.add(route);
    }


    /**
     * Accesseur get de la Voiture du Monde.
     *
     * @return la voiture
     */
    public Voiture getVoiture() {
        return this.v;
    }

    /**
     * Accesseurs get de la liste de route.
     */
    public ArrayList<Route> getListedeRoute() {
        return listedeRoute;
    }
}
