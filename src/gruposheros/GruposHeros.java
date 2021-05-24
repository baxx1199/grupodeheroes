
package gruposheros;

import controlador.Control;
import modelo.Hero;
import vista.FirstVista;
import vista.RegisterVista;

public class GruposHeros {

    
    public static void main(String[] args) {
       Hero hero = new Hero();
       FirstVista fv = new FirstVista();
       RegisterVista rv = new RegisterVista();
       
       Control control = new Control(hero, fv, rv);
       
       fv.setVisible(true);
    }
    
}
