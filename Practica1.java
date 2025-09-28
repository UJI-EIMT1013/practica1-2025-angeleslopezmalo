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
        boolean anyadir1 = (cuadrados.contains(1) && noCuadrados.contains(1)) ;

        noCuadrados.addAll(cuadrados);
        Set<Integer> todos = new HashSet<>();
        cuadrados.clear();
        Iterator<Integer> it_no = noCuadrados.iterator();
        while (it_no.hasNext()) {
            Integer n = it_no.next();
            for (Integer r : todos) {
                if (r * r == n) {
                    cuadrados.add(n);
                    it_no.remove();
                    break;
                } else if (n * n == r) {
                    cuadrados.add(r);
                }
            }
            todos.add(n);
        }
        if (anyadir1) {
            cuadrados.add(1);
            noCuadrados.remove(1);
        }
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        Collection<Set<T>> resultado = new ArrayList<>();
        while (it.hasNext()) {
            T n = it.next();
            boolean anyadido = false;
            for (Set<T> s : resultado) {
                if (!s.contains(n)) {
                    s.add(n);
                    anyadido = true;
                    break;
                }
            }
            if (!anyadido) {
                Set<T> nuevo = new HashSet<>();
                nuevo.add(n);
                resultado.add(nuevo);
            }
        }
        return resultado;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u, ArrayList<Set<T>> col) {
        //TODO
        Collection<Set<T>> res = new HashSet<>();
        if (u.isEmpty()) return res;
        for (int i = 0; i < col.size(); i++) {
            Set<T> uno = col.get(i);
            if (!uno.containsAll(u)) {
                for (int j = i + 1; j < col.size(); j++) {
                    Set<T> otro = col.get(j);
                    if (!otro.containsAll(u)) {
                        Set<T> s = new HashSet<>(uno);
                        s.addAll(otro);
                        if (s.containsAll(u)) {
                            res.add(col.get(i));
                            res.add(col.get(j));
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }



}
