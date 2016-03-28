package domaine.voiture;

import java.util.Observable;

/**
 * Voiture corresponds aux informations relatives à une voiture.
 *
 * @author Benjamin Saint-Sever
 * @author Thomas Guillou
 */
public class Voiture extends Observable {
    /**
     * Position de la voiture en abscisse.
     */
    private int positionX;
    /**
     * Position de la voiture en ordonnée.
     */
    private int positionY;
    /**
     * Vitesse de la voiture, exprimé en metre/seconde.
     */
    private int vitesseMetreSeconde;
    /**
     * Direction de la voiture, exprimé en dégrés.
     */
    private int directionEnDegres;

    /**
     * Constructeur de la voiture.
     *
     * @param positionX position en abcisse sur le monde de la voiture.
     * @param positionY position en ordonnée sur le monde de la voiture.
     * @param vitesse   vitesse de la voiture.
     */
    public Voiture(int positionX, int positionY, int vitesse) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.vitesseMetreSeconde = vitesse;
        this.directionEnDegres = 0;
    }

    /**
     * Met à jour la position.
     * Notifie les observateurs.
     */
    public void miseAJourPosition() {
        miseAJourPositionX();
        notificationObservateur();
    }

    /**
     * Met à jour la position X de la voiture.
     */
    private void miseAJourPositionX() {
        if (directionEnDegres == 0) {
            positionX += vitesseMetreSeconde;
        } else {
            positionX -= vitesseMetreSeconde;
        }

        if (positionX > 1000) {
            positionX = 1000;
        } else {
            if (positionX < 0) {
                positionX = 0;
            }
        }
    }

    /**
     * Notifie les observateurs.
     */
    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Accesseurs get de la position abscisse de la voiture.
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Accesseurs get de la position en ordonnée de la voiture.
     */
    public int getPositionY() {
        return positionY;
    }


    /**
     * Augmente la vitesse de 10.
     */
    public void accelerer() {
        if (vitesseMetreSeconde < 100)
            vitesseMetreSeconde += 10;
    }

    /**
     * Accesseurs get de de la vitesse.
     */
    public Object getVitesse() {
        return vitesseMetreSeconde;
    }

    /**
     * Attribue la valeur en paramètre à vitesse de la voiture.
     *
     * @param vitesse vitesse à attribuer à la voiture.
     */
    public void setVitesse(int vitesse) {
        vitesseMetreSeconde = vitesse;
    }

    /**
     * Inverse la direction de la voiture.
     */
    public void inverserDirection() {
        directionEnDegres += 180;
        directionEnDegres = directionEnDegres % 360;

    }

    /**
     * Accesseur get de la direction (en degrès) de la voiture.
     */
    public Object getDirection() {
        return directionEnDegres;
    }

    /**
     * Affecte la valeur en paramètre à la valeur de l'angle.
     *
     * @param angleDirection
     */
    public void setDirection(int angleDirection) {
        this.directionEnDegres = angleDirection;

    }


}
