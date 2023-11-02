package TPN9;

public class MutantChecker {
    private static boolean hasSequenceOfFour(String sequence) {
        // Verificar si la longitud de la cadena es mayor o igual a 4 y si alguna de las secuencias objetivo se encuentra en la cadena.
        return sequence.length() >= 4 && sequence.contains("AAAA") || sequence.contains("CCCC") || sequence.contains("TTTT") || sequence.contains("GGGG");
    }

    private static boolean validateDNASequences(String[] dna) {
        int dnaLength = dna.length; // Obtiene la longitud del arreglo DNA.
        String dnaSequence; // Variable para almacenar las secuencias de ADN a verificar.
        int sequenceCounter = 0; // Variable para almacenar la cantidad de secuencias
        
        // Verificar filas
        for (String row : dna) { // Itera a través de cada fila en el arreglo DNA.
            dnaSequence = "";
            dnaSequence += row;  
            if (hasSequenceOfFour(dnaSequence)) { // Llama a una función para verificar secuencias de cuatro letras iguales.
                sequenceCounter += 1; // Si se encuentra una secuencia aumenta el valor del contador en 1.
            }
        }
        
        // Verificar Columnas
        for (int col = 0; col < dnaLength; col++) { // Itera a través de cada columna en el arreglo DNA.
            dnaSequence = "";
            for (String row : dna) {
                dnaSequence += row.charAt(col); // Concatena el carácter en la columna actual a la secuencia de ADN.
            }
            if (hasSequenceOfFour(dnaSequence)) {
                sequenceCounter += 1;
            }
        }
        
        // Verificar Diagonales
        for (int number = 0; number < dnaLength; number++) {
            
            dnaSequence = "";            
            for (int i = number; i < dnaLength; i++) {
                dnaSequence += (dna[i - number].charAt(i));
            }
            if (hasSequenceOfFour(dnaSequence)) {
                sequenceCounter += 1;
            }
            
            dnaSequence = "";
            for (int i = 0; i <= number; i++) {
                dnaSequence += dna[number - i].charAt(i);
            }
            if (hasSequenceOfFour(dnaSequence)) {
                sequenceCounter += 1;
            }
            
            if (number > 0) {
                dnaSequence = "";  
                for (int i = number; i < dnaLength; i++) {
                    dnaSequence += dna[i].charAt(i - number);
                }
                if (hasSequenceOfFour(dnaSequence)) {
                    sequenceCounter += 1;
                }
                
                dnaSequence = "";
                for (int i = dnaLength - 1; i >= number; i--) {
                    int row = i;
                    int col = dnaLength - 1 - (i - number);
                    dnaSequence += dna[row].charAt(col);
                }
                if (hasSequenceOfFour(dnaSequence)) {
                    sequenceCounter += 1;
                }
            }
        }
        
        return sequenceCounter > 1; // Si el valor de "sequenceCounter" es mayor a 1 devuelve true.
    }
    
    private static boolean validateDNAMatrix(String[] dna) {
        if (dna.length != 6) {
            // Verifica si el número de filas no es igual a 6
            return true;
        }
        for (String row : dna) {
            if (row.length() != 6) {
                // Verifica si la longitud de alguna fila no es igual a 6
                return true;
            }
        }
        return false;
    }
    
    public static Boolean isMutant(String[] dna) {
        // Verificamos si la matriz de ADN no tiene las dimensiones correctas (6x6)
        if (validateDNAMatrix(dna)) {
            return null; // Si la matriz no es de 6x6, devuelve null para indicar un error.
        }
        return validateDNASequences(dna); // Llama a un método para validar las secuencias de ADN y devuelve el resultado.
    }

}