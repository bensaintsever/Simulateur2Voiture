package application.simulation;

import domaine.voiture.Voiture;
import espace.simulation.Direction;
import espace.simulation.Monde;
import espace.simulation.Route;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Entrée du programme qui initialise la creation d'un monde graphique.
 */
public class Simulation {

    /**
     * Durée exprimé en millisecondes.
     */
    public static final int dureeUneSecondeEnMilliSecondes = 1000;

    /**
     * Entrée du programme principal.
     *
     * @param args inutilisé dans ce cas.
     */
    public static void main(String[] args) {

        final Voiture maVoiture = new Voiture(100, 0, 10);
        final Route maRouteHorizontale = new Route(300, Direction.HORIZONTALE);
        final Route maRouteVerticale = new Route(300, Direction.VERTICALE);
        final Route maRouteVerticale2 = new Route(200, Direction.VERTICALE);
        Monde monMonde = new Monde(maVoiture);
        monMonde.ajouterRoute(maRouteHorizontale);
        monMonde.ajouterRoute(maRouteVerticale);
        monMonde.ajouterRoute(maRouteVerticale2);
        new IHM(monMonde);


        Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new
                ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        maVoiture.miseAJourPosition();
                    }
                });

        timerAvancer.start();

        while (true) {
        }

    }

}
