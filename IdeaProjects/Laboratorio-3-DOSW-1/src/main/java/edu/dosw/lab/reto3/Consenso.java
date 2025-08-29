package edu.dosw.lab.reto3;

import java.util.*;

public class consenso {
    private static final List<Integer> FIBONACCI = Arrays.asList(1, 2, 3, 5, 8, 13);

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese número de integrantes del equipo: ");
        int integrantes = sc.nextInt();
        sc.nextLine();


        System.out.print("Ingrese el número de historias/tareas a estimar: ");
        int numHistorias = sc.nextInt();
        sc.nextLine();

        List<String> historias = new ArrayList<>();
        for (int i = 1; i <= numHistorias; i++) {
            System.out.print("Ingrese descripción de la historia " + i + ": ");
            String historia = sc.nextLine();
            historias.add(historia);
        }

        Map<String, Integer> resultados = new LinkedHashMap<>();

        for (String historia : historias) {
            System.out.println("\n Estimando: " + historia);

            boolean consenso = false;
            int votoFinal = -1;

            while (!consenso) {
                List<Integer> votosIntegrantes = new ArrayList<>();

                for (int i = 1; i <= integrantes; i++) {
                    int voto;
                    do {
                        System.out.print("Integrante " + i + " ingrese su voto (1,2,3,5,8,13): ");
                        voto = sc.nextInt();
                        if (!FIBONACCI.contains(voto)) {
                            System.out.println("El valor ingresado no hace parte de la secuencia Fibonnaci.");
                        }
                    } while (!FIBONACCI.contains(voto));
                    votosIntegrantes.add(voto);
                }

                Set<Integer> setVotos = new HashSet<>(votosIntegrantes);
                if (setVotos.size() == 1) {
                    consenso = true;
                    votoFinal = votosIntegrantes.get(0);
                } else {
                    System.out.println("Votos diferentes: " + votosIntegrantes);
                    System.out.println("Discutan y vuelvan a votar.");
                }
            }
            resultados.put(historia, votoFinal);
        }

        System.out.println("\n===== Resumen de la Votación =====");
        resultados.forEach((historia, puntos) ->
                System.out.println(historia + " → " + puntos + " puntos"));
    }
}