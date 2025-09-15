package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        //TODO
        Set<Integer> resultado = new HashSet<>();
        Set<Integer> todos = new HashSet<>();
        while (it.hasNext()) {
            Integer n = it.next();
            if (n!=0) {
                Iterator<Integer> it2 = todos.iterator();
                while (it2.hasNext()) {
                    Integer d = it2.next();
                    if (n % d == 0) {
                        resultado.add(n);
                        break;
                    } else if (d % n == 0) {
                        resultado.add(d);
                    }
                }
                todos.add(n);
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        //TODO

    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}
