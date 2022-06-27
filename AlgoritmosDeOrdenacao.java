import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class AlgoritmosDeOrdenacao {
    public static void main(String[] args) {

        int[] zap = new int[50000];
        // int[] zap = new int[75000];
        // int[] zap = new int[100000];
        // int[] zap = new int[200000];
        // int[] zap = new int[500000];
        // int[] zap = new int[1000000];
        // int[] zap = new int[2000000];

        // int numero = zap.length - 1;
        for (int i = 0; i < zap.length; i++) {
            // zap[i] = i;
            // zap[i] = numero--;

            zap[i] = (int)(Math.random() * 100);

        }

        Instant momentoInicial = Instant.now();

        // arraySort(zap);
        // aSort(zap, 0, zap.length-1);
        // bubble(zap);
        // insertion(zap);
        // selection(zap);
        quickSort(zap, 0, zap.length - 1);
        // merge(zap, 0, zap.length);

        Instant momentoFinal = Instant.now();

        Duration duracao = Duration.between(momentoInicial, momentoFinal);
        System.out.println(duracao.toMillis());
    }

    // ARRAY SORT
    /*
     * static void arraySort(int[] vetor) {
     * Arrays.sort(vetor);
     * }
     */

    // ARRAY SORT
    static void aSort(int[] vetor, int inicio, int termino) {
        for (int atual = inicio; atual < termino - 1; atual++) {
            for (int posicao = inicio; posicao < termino - 1 - atual; posicao++) {
                if (vetor[posicao] > vetor[posicao + 1]) {

                }
            }
        }
    }

    static void troca(int[] vetor, int origem, int destino) {
        int valorOrigem = vetor[origem];
        int valorDestino = vetor[destino];

        vetor[origem] = valorDestino;
        vetor[destino] = valorOrigem;
    }

    // BUBBLE SORT
    static void bubble(int[] vetor) {
        boolean troca = true;
        int aux;

        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }
        }
    }

    // INSERTION SORT
    static void insertion(int[] vetor) {
        int j;
        int valor;
        int i;

        for (j = 1; j < vetor.length; j++) {
            valor = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > valor); i--) {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = valor;
        }
    }

    // SELECTION SORT
    static void selection(int[] vetor) {
        for (int sContador = 0; sContador < vetor.length - 1; sContador++) {
            int sValor = sContador;

            for (int i = sValor + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[sValor]) {
                    sValor = i;
                }
            }
            if (sValor != sContador) {
                int t = vetor[sContador];
                vetor[sContador] = vetor[sValor];
                vetor[sValor] = t;
            }
        }
    }

    /* QUICK SORT */
    static int partition(int vetor[], int low, int high) {
        int pivot = vetor[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (vetor[j] <= pivot) {
                i++;

                // swap vetor[i] and vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        // swap vetor[i+1] and vetor[high] (or pivot)
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[high];
        vetor[high] = temp;

        return i + 1;
    }

    static void quickSort(int vetor[], int low, int high) {
        if (low < high) {
            int pi = partition(vetor, low, high);

            quickSort(vetor, low, pi - 1);
            quickSort(vetor, pi + 1, high);
        }
    }

    static void printArray(int vetor[]) {
        int n = vetor.length;
        for (int i = 0; i < n; ++i)
            System.out.print(vetor[i] + " ");
        System.out.println();
    }
    /* /////////// */

    /* MERGE SORT */
    static void merge(int[] vetor, int momentoInicio, int momentoTermino) {
        if (momentoTermino - momentoInicio >= 2) {
            int quebra = (momentoInicio + momentoTermino) / 2;

            merge(vetor, momentoInicio, quebra);

            merge(vetor, quebra, momentoTermino);

            mescla(vetor, momentoInicio, quebra, momentoTermino);
        }
    }

    static void mescla(int[] original, int momentoInicio, int meio, int momentoTermino) {
        int tamanhoA = meio;
        int tamanhoB = momentoTermino;
        int tamanhoC = momentoTermino - momentoInicio;
        int[] c = new int[tamanhoC];
        int posicaoA, posicaoB, posicaoC;
        posicaoA = momentoInicio;
        posicaoB = meio;
        posicaoC = 0;

        while (posicaoA < tamanhoA && posicaoB < tamanhoB) {
            if (original[posicaoA] < original[posicaoB]) {
                c[posicaoC++] = original[posicaoA++];
            } else {
                c[posicaoC++] = original[posicaoB++];
            }
        }

        while (posicaoA < tamanhoA) {
            c[posicaoC++] = original[posicaoA++];
        }

        while (posicaoB < tamanhoB) {
            c[posicaoC++] = original[posicaoB++];
        }

        for (int atual = 0; atual < c.length; atual++) {
            original[atual + momentoInicio] = c[atual];
        }

    }
    /* /////////// */
}

// array sort OK
// quick sort OK
// merge sort OK

// selection sort OK
// insertion sort OK
// bubble sort OK

// ARRAY SORT - FUNCIONAMENTO
/*
 * No procedimento do array sort, são ordenados os elementos do próprio array e,
 * depois, o array é retornado.
 * A ordenação não é necessariamente estável.
 * A complexidade do tempo de execução e a quantidade de memória utilizada pela
 * ordenação são voláteis
 * e dependem da maneira em que a ordenação foi implementada.
 * 
 * Crescente
 * Organizou 100000 elementos em 3 milissegundos;
 * Organizou 1000000 elementos em 5 milissegundos;
 * Organizou 2000000 elementos em 6 milissegundos.
 * 
 * Decrescente
 * Organizou 100000 elementos em 3 milissegundos;
 * Organizou 1000000 elementos em 7 milissegundos;
 * Organizou 2000000 elementos em 36 milissegundos.
 * 
 * Aleatório
 * Organizou 100000 elementos em 9 milissegundos;
 * Organizou 1000000 elementos em 10 milissegundos;
 * Organizou 2000000 elementos em 14 milissegundos.
 * 
 * Funciona mais eficientemente de forma crescente. No geral, ele faz o seu
 * trabalho muito bem.
 * 
 */

// BUBBLE SORT - FUNCIONAMENTO
/*
 * É um dos algoritmos mais simples, e também o menos eficiente.
 * O Bubble Sort funciona examinando cada conjunto de elementos adjacentes
 * vindos da esquerda pra direita e trocando suas posições, verificando como
 * valores booleanos, no caso de estarem fora de ordem.
 * 
 * Crescente
 * Organizou 100000 elementos em 3 milissegundos;
 * Organizou 200000 elementos em 4 milissegundos;
 * Organizou 500000 elementos em 5 milissegundos.
 * 
 * Decrescente
 * Organizou 100000 elementos em 11873 milissegundos;
 * Organizou 200000 elementos em 51126 milissegundos;
 * Organizou 500000 elementos em 302637 milissegundos.
 * 
 * Aleatório
 * Organizou 100000 elementos em 16327 milissegundos;
 * Organizou 200000 elementos em 69601 milissegundos;
 * Organizou 500000 elementos em 421540 milissegundos.
 * 
 * 
 * Organizou 50000 elementos em 4189 milissegundos;
 * Organizou 50000 elementos em 4208 milissegundos;
 * Organizou 50000 elementos em 3980 milissegundos;
 * 
 * Organizou 75000 elementos em 9522 milissegundos;
 * Organizou 75000 elementos em 9682 milissegundos;
 * Organizou 75000 elementos em 9212 milissegundos.
 * 
 * Organizou 100000 elementos em 17412 milissegundos;
 * Organizou 100000 elementos em 17449 milissegundos;
 * Organizou 100000 elementos em 17267 milissegundos.
 * 
 * 
 * É o método de organização menos eficiente, principalmente em forma aleatória
 * e em decrescente.
 * No geral, não recomendo.
 * 
 */

// SELECTION SORT - FUNCIONAMENTO
/*
 * O selection sort se baseia em, dependendo da ordem requerida, sempre passar o
 * menor ou o maior valor
 * para a posição inicial. Após isso, ele vai pegar o segundo menor/maior e
 * passar para a segunda posição, e assim ele seguirá.
 * 
 * Crescente
 * Organizou 100000 elementos em 885 milissegundos;
 * Organizou 200000 elementos em 3496 milissegundos;
 * Organizou 500000 elementos em 22674 milissegundos.
 * 
 * Decrescente
 * Organizou 100000 elementos em 2993 milissegundos;
 * Organizou 200000 elementos em 11764 milissegundos;
 * Organizou 500000 elementos em 69817 milissegundos.
 * 
 * Aleatório
 * Organizou 100000 elementos em 2175 milissegundos;
 * Organizou 200000 elementos em 8727 milissegundos;
 * Organizou 500000 elementos em 52172 milissegundos.
 * 
 * Organizou 50000 elementos em 539 milissegundos;
 * Organizou 50000 elementos em 590 milissegundos;
 * Organizou 50000 elementos em 539 milissegundos.
 * 
 * Organizou 75000 elementos em 1208 milissegundos;
 * Organizou 75000 elementos em 1218 milissegundos;
 * Organizou 75000 elementos em 1201 milissegundos;
 * 
 * Organizou 100000 elementos em 2141 milissegundos;
 * Organizou 100000 elementos em 2117 milissegundos;
 * Organizou 100000 elementos em 2135 milissegundos;
 * 
 */

// INSERTION SORT - FUNCIONAMENTO
/*
 * Quando aplicado em pequenas listas, esse provavelmente é um dos melhores
 * algoritmos de ordenação.
 * Ele funciona percorrendo todos elementos da lista, começando pela esquerda e
 * indo sempre mais à direita.
 * À medida que ele avança, os elementos na esquerda vão se tornando cada vez
 * mais organizados.
 * Seu método é semelhante ao método que usamos para organizar baralhos.
 * 
 * Crescente
 * Organizou 100000 elementos em 4 milissegundos;
 * Organizou 200000 elementos em 6 milissegundos;
 * Organizou 500000 elementos em 7 milissegundos.
 * 
 * Decrescente
 * Organizou 100000 elementos em 5200 milissegundos;
 * Organizou 200000 elementos em 19943 milissegundos;
 * Organizou 500000 elementos em 129017 milissegundos.
 * 
 * Aleatório
 * Organizou 100000 elementos em 2587 milissegundos;
 * Organizou 200000 elementos em 10272 milissegundos;
 * Organizou 500000 elementos em 62437 milissegundos.
 * 
 * 
 * Organizou 50000 elementos em 537 milissegundos;
 * Organizou 50000 elementos em 533 milissegundos;
 * Organizou 50000 elementos em 537 milissegundos.
 * 
 * Organizou 75000 elementos em 1216 milissegundos;
 * Organizou 75000 elementos em 1198 milissegundos;
 * Organizou 75000 elementos em 1209 milissegundos.
 * 
 * Organizou 100000 elementos em 2136 milissegundos;
 * Organizou 100000 elementos em 2133 milissegundos;
 * Organizou 100000 elementos em 2139 milissegundos.
 * 
 * 
 */

// QUICK SORT - FUNCIONAMENTO
/*
 * Crescente
 * Organizou 100000 elementos em  milissegundos;
 * Organizou 200000 elementos em  milissegundos;
 * Organizou 500000 elementos em  milissegundos;
 * 
 * Decrescente
 * Organizou 100000 elementos em  milissegundos;
 * Organizou 200000 elementos em  milissegundos;
 * Organizou 500000 elementos em  milissegundos;
 * 
 * Aleatório
 * Organizou 100000 elementos em 64 milissegundos;
 * Organizou 200000 elementos em 364 milissegundos;
 * Organizou 500000 elementos em 1269 milissegundos;
 * 
 * Organizou 50000 elementos em 26 milissegundos;
 * Organizou 50000 elementos em 21 milissegundos;
 * Organizou 50000 elementos em 27 milissegundos.
 * 
 * Organizou 75000 elementos em 35 milissegundos;
 * Organizou 75000 elementos em 51 milissegundos;
 * Organizou 75000 elementos em 36 milissegundos.
 * 
 * Organizou 100000 elementos em 59 milissegundos;
 * Organizou 100000 elementos em 56 milissegundos;
 * Organizou 100000 elementos em 57 milissegundos.
 * 
 */

// MERGE SORT - FUNCIONAMENTO
/*
 * Organizou 50000 elementos em 10 milissegundos;
 * Organizou 50000 elementos em 10 milissegundos;
 * Organizou 50000 elementos em 10 milissegundos.
 * 
 * Organizou 75000 elementos em 15 milissegundos;
 * Organizou 75000 elementos em 18 milissegundos;
 * Organizou 75000 elementos em 15 milissegundos.
 * 
 * Organizou 100000 elementos em 19 milissegundos;
 * Organizou 100000 elementos em 19 milissegundos;
 * Organizou 100000 elementos em 20 milissegundos.
 * 
 */