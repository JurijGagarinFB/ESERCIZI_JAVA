public class OrdinaArray {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 92};
        int[] B = {3, 4, 6, 101, 103};

        int[] C = unisciArray(A, B);

        System.out.println("Array combinato:");
        for (int num : C) {
            System.out.print(num + " ");
        }
    }

    public static int[] unisciArray(int[] A, int[] B) {
        int lunghezzaA= A.length;
        int lunghezzaB = B.length;
        int[] C = new int[lunghezzaA + lunghezzaB];

        int i = 0, j = 0, k = 0;

        // Unisci i due array ordinati in modo crescente
        while (i < lunghezzaA && j < lunghezzaB) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        // Copia gli elementi rimanenti di array1, se presenti
        while (i < lunghezzaA) {
            C[k++] = A[i++];
        }

        // Copia gli elementi rimanenti di array2, se presenti
        while (j < lunghezzaB) {
            C[k++] = B[j++];
        }

        return C;
    }
}
