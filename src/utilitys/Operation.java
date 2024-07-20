package utilitys;

import java.util.stream.Stream;

public interface Operation {

    /*
    private void interfacePrivateMethod() {
        System.out.println("Llamando al metodo privado de una interfaz");
        interfaceStaticMethod();
    }
     */

    static void interfaceStaticMethod(){
        System.out.println("Llamando al metodo estatico de una interfaz");
    }

    default void interfaceDefaultMethod(){
//        interfacePrivateMethod();
        interfaceStaticMethod();
        System.out.println("Llamando al metodo default de una interfaz");
    }
}
