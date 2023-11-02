package TPN9;

import java.util.Scanner;

public class MutantTestCases {
    public static void main(String[] args) {
        String[] dna = new String[6]; // Se crea un arreglo de cadenas para almacenar las filas de ADN.

        // Se solicita al usuario ingresar las filas de ADN.
        for (int i = 0; i < dna.length; i++) {
            dna[i] = validateDnaSequence("Ingresa la fila " + (i + 1) + " de ADN (debe contener 6 letras de A, C, G o T):");
        }

        System.out.println("\nMatriz de ADN: \n");

        // Se imprime la matriz de ADN en la consola.
        for (String row : dna) {
            for (int i = 0; i < row.length(); i++) {
                System.out.printf("%-2s", row.charAt(i)); // Se muestran los carácteres de la fila correspondiente.
            }
            System.out.println(""); // Salto de línea al final de cada fila.
        }

        // Se llama a la función isMutant de la clase MutantChecker para verificar si la secuencia es mutante.
        Boolean resultDna = MutantChecker.isMutant(dna);

        System.out.println("\nEs Mutante: " + resultDna + "\n"); // Se muestra en la consola si la secuencia es mutante o no.
    }

    
    private static String validateDnaSequence(String message) {
        Scanner scanner = new Scanner(System.in);
        String dnaSequence;

        while (true) {
            System.out.println(message); // Muestra el mensaje proporcionado
            dnaSequence = scanner.nextLine().toUpperCase(); // Lee la entrada del usuario y la convierte a mayúsculas

            if (dnaSequence.length() == 6) { // Comprueba si la secuencia tiene una longitud de 6 caracteres
                boolean isValid = true; // Variable para rastrear si la secuencia es válida

                for (char character : dnaSequence.toCharArray()) {
                    if (character != 'A' && character != 'C' && character != 'G' && character != 'T') {
                        isValid = false; // Si se encuentra un carácter inválido, marca la secuencia como no válida
                        break;
                    }
                }
                if (isValid) {
                    return dnaSequence; // Si la secuencia es válida, la función la retorna
                }
            }
            // Se muestra en la consola si la secuencia no es válida
            System.out.println("La secuencia de ADN ingresada no es válida.");
        }
    }
}
