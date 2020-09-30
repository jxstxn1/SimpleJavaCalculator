import java.util.List;

public class Rechenlogik {
    int eingabe = 0;
    int ersteZahl = 0;
    int summe = 0;
    boolean rechnen = false;
    char operator;
    RechnerOberflaeche dieOberflaeche;


    Rechenlogik(RechnerOberflaeche aOberfläche) {
        dieOberflaeche = aOberfläche;
    }

    public void geklickteZahl(int geklickteZahl) {

        if (rechnen == true){
            eingabe = eingabe * 10;
            eingabe = eingabe + geklickteZahl;
            dieOberflaeche.setzeAnzeige(eingabe);
            dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + operator + eingabe);
        }else {
            eingabe = eingabe * 10;
            eingabe = eingabe + geklickteZahl;
            dieOberflaeche.setzeAnzeige(eingabe);
            dieOberflaeche.setzeAnzeigeKomplett("" + eingabe);
        }
    }

    public void geklicktesZeichen(char zeichen) {
        switch (zeichen) {
            case '+':
                if (!rechnen) {
                    ersteZahl = eingabe;
                    eingabe = 0;
                    dieOberflaeche.setzeAnzeige(0);
                    dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + '+');
                    rechnen = true;
                    operator = '+';
                } else {
                    summe = eingabe + ersteZahl;
                    dieOberflaeche.setzeAnzeige(summe);
                }
                break;
            case '-':
                if (!rechnen) {
                    ersteZahl = eingabe;
                    eingabe = 0;
                    dieOberflaeche.setzeAnzeige(0);
                    dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + '-');
                    rechnen = true;
                    operator = '-';
                } else {
                    summe = eingabe - ersteZahl;
                    dieOberflaeche.setzeAnzeige(summe);
                }
                break;
            case '/':
                if (!rechnen) {
                    ersteZahl = eingabe;
                    eingabe = 0;
                    dieOberflaeche.setzeAnzeige(0);
                    dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + '/');
                    rechnen = true;
                    operator = '/';
                } else {
                    summe = eingabe / ersteZahl;
                    dieOberflaeche.setzeAnzeige(summe);
                }
                break;
            case '*':
                if (!rechnen) {

                    ersteZahl = eingabe;
                    eingabe = 0;
                    dieOberflaeche.setzeAnzeige(0);
                    dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + '*');
                    rechnen = true;
                    operator = '*';
                } else {
                    summe = eingabe * ersteZahl;
                    dieOberflaeche.setzeAnzeige(summe);
                }
                break;
            case 'c':
                ersteZahl = 0;
                eingabe = 0;
                dieOberflaeche.setzeAnzeige(0);
                dieOberflaeche.setzeAnzeigeKomplett("");
                rechnen = false;
                operator = 'x';
                break;
            case '=':
                if (rechnen == true) {
                    switch (operator){
                        case '+':
                            summe = ersteZahl + eingabe;
                            dieOberflaeche.setzeAnzeige(summe);
                            dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + operator + eingabe + "=" + summe);
                            break;
                        case '-':
                            summe = ersteZahl - eingabe;
                            dieOberflaeche.setzeAnzeige(summe);
                            dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + operator + eingabe + "=" + summe);
                            break;
                        case '*':
                            summe = ersteZahl * eingabe;
                            dieOberflaeche.setzeAnzeige(summe);
                            dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + operator + eingabe + "=" + summe);
                            break;
                        case '/':
                            summe = ersteZahl / eingabe;
                            dieOberflaeche.setzeAnzeige(summe);
                            dieOberflaeche.setzeAnzeigeKomplett("" + ersteZahl + operator + eingabe + "=" + summe);
                            break;
                        default:
                            dieOberflaeche.error("Hier wurde eine ungültige Operation durchgeführt");
                    }
                } else {
                    dieOberflaeche.error("Du musst erst Zahlen eingeben damit du diese Taste nutzen kannst oder du kaufst dir das DLC 'Ungültige Operationen'");
                }
                break;
            default:
                dieOberflaeche.error("Hier wurde eine ungültige Operation durchgeführt");
        }

    }
}
