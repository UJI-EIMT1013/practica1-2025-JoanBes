package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        List<Integer> numeros = new ArrayList<>();
        while (it.hasNext()) {
            int n = it.next();
            if (n != 0) {
                numeros.add(n);
            }
        }

        Set<Integer> resultado = new HashSet<>();

        for (int i = 0; i < numeros.size(); i++) {
            int a = numeros.get(i);
            for (int j = 0; j < numeros.size(); j++) {
                if (i != j && a % numeros.get(j) == 0) {
                    resultado.add(a);
                    break;
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> newCuadrados = new HashSet<>();

        for (int i: cuadrados) {
            if (cuadrados.contains(i*i) && i != 0 && i != 1) {
                newCuadrados.add(i*i);
            }
            if (noCuadrados.contains(i*i)) {
                newCuadrados.add(i*i);
            }
        }


        for (int i: noCuadrados) {
            if (noCuadrados.contains(i*i) && i != 0 && i != 1) {
                newCuadrados.add(i*i);
            }
            if (cuadrados.contains(i*i)) {
                newCuadrados.add(i*i);
            }
        }

        noCuadrados.addAll(cuadrados);
        noCuadrados.removeAll(newCuadrados);
        cuadrados.clear();
        cuadrados.addAll(newCuadrados);

    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {

        Collection<Set<T>> resultado = new ArrayList<>();

        while (it.hasNext()) {
            boolean esta = false;
            if (resultado.isEmpty()) resultado.add(new HashSet<>());

            T elemento = it.next();
            for(Set<T> currentSet: resultado) {
                if (!currentSet.contains(elemento)) {
                    currentSet.add(elemento);
                    esta = true;
                    break;
                }
            }
            if (!esta) {
                Set<T> nuevoSet = new HashSet<>();
                nuevoSet.add(elemento);
                resultado.add(nuevoSet);
            }

        }
        return resultado;
    }

    //EJERCICIO 4
    public static <T> Collection<Set<T>> coverageSet2(Set<T> u, ArrayList<Set<T>> col) {
        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {
                Set<T> set1 = col.get(i);
                Set<T> set2 = col.get(j);
                // Skip if either set is equal to u
                if (set1.equals(u) || set2.equals(u)) continue;
                Set<T> union = new HashSet<>(set1);
                union.addAll(set2);
                if (union.equals(u)) {
                    Collection<Set<T>> result = new HashSet<>();
                    result.add(new HashSet<>(set1));
                    result.add(new HashSet<>(set2));
                    return result;
                }
            }
        }
        return new HashSet<>();
    }



}
