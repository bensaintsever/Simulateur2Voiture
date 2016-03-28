package application.simulation;

import domaine.voiture.Voiture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe contient les différentes actions permettant de manipuler
 * la voiture.
 *
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class CommandeVoiture extends JPanel implements ActionListener {

    private JButton boutonAccelerer;
    private JButton boutonInverserDirection;
    private Voiture maVoiture;

    /**
     * Constructeur de la classe, avec l'initialisation des boutons et de
     * la jFrame.
     *
     * @param fenetre   jframe.
     * @param maVoiture object voiture.
     */

    public CommandeVoiture(JFrame fenetre, Voiture maVoiture) {

        super();
        this.setLayout(new FlowLayout());


        boutonAccelerer = new JButton("Accelerer");
        boutonAccelerer.addActionListener(this);
        this.add(boutonAccelerer);

        boutonInverserDirection = new JButton("Changer direction");
        boutonInverserDirection.addActionListener(this);
        this.add(boutonInverserDirection);

        fenetre.add(this);
        this.maVoiture = maVoiture;

    }

    /**
     * Action à effectuer lors de l'appuie d'un des boutons, accelerer
     * ou inverserDirection.
     *
     * @param event Evenement correspondant au clic sur bouton.
     */
    public void actionPerformed(ActionEvent event) {
        Object bouton = event.getSource();
        if (bouton == boutonAccelerer)
            maVoiture.accelerer();
        else
            maVoiture.inverserDirection();
    }


}
