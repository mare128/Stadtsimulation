package eps.fortgeschritteneGrafik.interna;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Speichert die bisherigen Transformationen
 * 
 * @author Florian Prager, Universitaet Passau
 * @version 02.2008
 */
public class TransformationsSpeicher {
    /**
     * Haelt die aktuelle Transformationsmatrix
     */
    AffineTransform aktuelleTransformation = new AffineTransform();

    /**
     * Speichert die letzte Transformation, sofern dies eine Rotation gewesen
     * ist. Dient zur Performanz-Optimierung
     */
    Rotation letzteRotation;

    /**
     * Fuegt eine neue Transformation hinzu
     */
    public void transformationHinzufuegen(Transformation t) {
        if (t instanceof Rotation) {
            Rotation r = (Rotation) t;
            if (letzteRotation == null)
                letzteRotation = (Rotation) t;
            else if (letzteRotation.xDrehpunktGeben() == r.xDrehpunktGeben()
                    && letzteRotation.yDrehpunktGeben() == r.yDrehpunktGeben()) {
                letzteRotation = new Rotation(letzteRotation.xDrehpunktGeben(),
                        letzteRotation.yDrehpunktGeben(), letzteRotation
                                .winkelGeben()
                                + r.winkelGeben());
            } else {
                if (letzteRotation != null) {
                    aktuelleTransformation.preConcatenate(letzteRotation
                            .transformationGeben());
                    letzteRotation = null;
                }
                aktuelleTransformation.preConcatenate(t.transformationGeben());
            }
        } else {
            if (letzteRotation != null) {
                aktuelleTransformation.preConcatenate(letzteRotation
                        .transformationGeben());
                letzteRotation = null;
            }
            aktuelleTransformation.preConcatenate(t.transformationGeben());
        }
    }

    /**
     * Aktualisiert die Koordinaten nach einer Transformation
     */
    public Grenze aktuelleGrenzenGeben(double standardbreite,
            double standardhoehe) {
        Rectangle2D r = new Rectangle2D.Double(0, 0, standardbreite,
                standardhoehe);
        if (letzteRotation != null) {
            AffineTransform af = new AffineTransform();
            af.preConcatenate(aktuelleTransformation);
            af.preConcatenate(letzteRotation.transformationGeben());
            r = af.createTransformedShape(r).getBounds2D();
        } else
            r = aktuelleTransformation.createTransformedShape(r).getBounds2D();
        return new Grenze(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * Entfernt alle Transformationen
     */
    public void loeschen() {
        aktuelleTransformation.setToIdentity();
    }

    /**
     * Wendet die Transformationen an
     */
    public void anwenden(Graphics2D g) {
        if (letzteRotation != null)
            g.transform(letzteRotation.transformationGeben());
        g.transform(aktuelleTransformation);
    }
}
