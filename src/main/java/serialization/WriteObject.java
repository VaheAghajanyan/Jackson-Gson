package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) throws IOException {
        var person1 = new Person(1, "person1");
        var person2 = new Person(2, "person2");

        FileOutputStream fileOutputStream = new FileOutputStream("people.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person1);
        objectOutputStream.writeObject(person2);

        objectOutputStream.close();
    }

    public static void WriteArrayOfObject() throws IOException {
        Person[] persons = new Person[]{new Person(1, "person1"), new Person(2, "person2")};

        FileOutputStream fileOutputStream = new FileOutputStream("people.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeInt(persons.length);

        for (Person person : persons) {
            objectOutputStream.writeObject(person);
        }
        objectOutputStream.close();
    }
}
