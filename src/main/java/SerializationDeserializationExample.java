import java.io.*;
import java.util.Base64;

public class SerializationDeserializationExample {

    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }
    public static byte[] serialize(Person person) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        return byteArrayOutputStream.toByteArray();
    }
    public static Person deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        Person person = (Person) objectInputStream.readObject();
        objectInputStream.close();

        return person;
    }
    public static String toHexString(byte[] array) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : array) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static String toBinaryString(byte[] array) {
        StringBuilder binaryString = new StringBuilder();
        for (byte b : array) {
            String binary = Integer.toBinaryString(0xff & b);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            binaryString.append(binary).append(" ");
        }
        return binaryString.toString();
    }


    public static void main(String[] args) {
        try {
            Person personToSerialize = new Person("Max Mustermann", 30);
            System.out.println("Original Objekt: " + personToSerialize);

            // Serialisieren

            byte[] serializedData = serialize(personToSerialize);
            System.out.println("Serialisierte Daten in Binär: " + toBinaryString(serializedData));


            /*
            byte[] serializedData = serialize(personToSerialize);
            System.out.println("Serialisierte Daten: " + toHexString(serializedData));
            */

            /*
            byte[] serializedData = serialize(personToSerialize);
            String base64Data = Base64.getEncoder().encodeToString(serializedData);
            System.out.println("Serialisierte Daten: " + base64Data);
            */

            // Deserialisieren
            /*
            Person deserializedPerson = deserialize(serializedData);
            System.out.println("Deserialisiertes Objekt: " + deserializedPerson);
            */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
