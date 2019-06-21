import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class IteratorMain {
    public static void main(String[] args) throws IOException {
        Set<Person> person = new HashSet<>();
        person.add(new Person("Jan", "Kowalski", 23));
        person.add(new Person("Kamil", "Nowak", 14));
        person.add(new Person("Aneta", "Nowak", 15));
        person.add(new Person("Elzbieta", "Nowak", 19));
        person.add(new Person("Marta", "Kuz", 22));

        System.out.println(person);

        Iterator<Person> iterator = person.iterator();

        int totalAge=0;
        while (iterator.hasNext()){
            Person personP=iterator.next();
            if(personP.getAge()>20){
                iterator.remove();
            }
//            totalAge+=personP.getAge();
            //System.out.println(personP);
        }

        System.out.println(person);
     saveToCSV(person, "file.csv");
    }

    static void saveToCSV(Set persons, String fileName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter seperator");
        char seperator = scanner.next().charAt(0);
        Iterator<Person> iterator = persons.iterator();
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bfw = new BufferedWriter(fileWriter);
        while (iterator.hasNext()){
            StringBuilder strB = new StringBuilder();
            Person person1= iterator.next();
            String name=person1.getFirstName();
            strB.append(name);
            strB.append(seperator);
            bfw.write(strB.toString());
            bfw.newLine();
        }
        bfw.close();
    }
}
/*
Do zadania z poprzedniego ćwiczenia zdefiniuj metodę, która zapisze dane ze zbioru do pliku w formacie CSV.
Użytkownik powinien mieć możliwość podania separatora z klawiatury po uruchomieniu programu (np. ";" albo ",").
 */