package AppliSimu;

import DomaineVoiture.Voiture;
import EspaceSimulation.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class IHM extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
	private Route maRoute;

	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHM(Voiture maVoiture, Route maRoute) {
		super();
		this.maVoiture = maVoiture;
		this.maRoute = maRoute;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHM() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		dessinerRoute(contexteGraphique);
        dessinerVoiture(contexteGraphique);
	}


	private void dessinerVoiture(Graphics contexteGraphique) {
		contexteGraphique.setColor(Color.red);
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
		contexteGraphique.fillRect(xPixel, 300, 30, 15);
	}

	private void dessinerRoute(Graphics contexteGraphique){
		contexteGraphique.setColor(Color.black);
		int pos = maRoute.getPosition();
		Direction dir = maRoute.getDirection();

		if ( dir == Direction.VERTICALE)
			contexteGraphique.fillRect(pos,0,30,1000);
		else
			contexteGraphique.fillRect(0,pos,1000,30);

	}



	
}
