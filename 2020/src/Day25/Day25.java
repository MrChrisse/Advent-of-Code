package Day25;

public class Day25 {

    public static void main(String[] args) {
        int cardKey = 13233401;
        int doorKey = 6552760;

        int cardLoopSize = getLoopSize(cardKey, 7);
        int doorLoopSize = getLoopSize(doorKey, 7);
        int encryptionKey1 = getEncryptionKey(cardKey, doorLoopSize);
        int encryptionKey2 = getEncryptionKey(doorKey, cardLoopSize);

        System.out.println(encryptionKey1);

    }

    private static int getEncryptionKey(int key, int size) {
        long value = 1;
        for (int i = 1; i <= size; i++) {
            value *= key;
            value %= 20201227;
        }
        return (int) value;
    }

    private static int getLoopSize(long key, long subNum) {
        int value = 1;

        int size = 0;
        while (value != key) {
            value *= subNum;
            value %= 20201227;
            size++;
        }

        return size;
    }
}
