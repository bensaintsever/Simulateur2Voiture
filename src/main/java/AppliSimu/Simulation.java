package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import DomaineVoiture.Voiture;
import EspaceSimulation.*;

public class Simulation {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

        final Voiture maVoiture = new Voiture (100, 0, 10);
		final Route maRoute = new Route(300, Direction.HORIZONTALE);
		IHM monTriangle = new IHM(maVoiture,maRoute);
		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		
		timerAvancer.start();
		
		while(true){
		}

	}

}