package com.cristian.desarrollo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main( String[] args ){
        Person p1 = new Person(1, "Mito", 24);
        Person p2 = new Person(2, "Code", 14);
        Person p3 = new Person(3, "Jaime", 34);
        Person p4 = new Person(4, "Duke", 15);
        Person p5 = new Person(5, "James", 27);

        Product pr1 = new Product(1, "Ceviche", 15.0);
        Product pr2 = new Product(2, "Chilaquiles", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(5, "Ceviche", 15.0);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);

        // Lambda
        //persons.forEach(p -> System.out.println(p));

        /*  Metodos a referencia (Si el parametro de la izquierda es igual al parametro
        de la derecha) */
        //persons.forEach(System.out::println);

        // 1-Filter (param: Predicate)
        // Stream: método que permite trabajar con las colecciones
        List<Person> filteredList = persons.stream() 
                                    .filter(p -> p.getAge() >= 18) // Filtrar los datos
                                    .collect(Collectors.toList()); // coleccionarlos en una lista

        //App.printList(filteredList);

        // 2-Map (param: function) (Transforma un dato de un tipo a a un tipo b)
        List<Integer> filteredList2 = persons.stream()
                                      .filter(p -> p.getAge() >= 18) // Filtrar los datos
                                      .map(p -> p.getAge())
                                      .collect(Collectors.toList());
        App.printList(filteredList2);                                      
    }

    public static void printList(List<?> list){
        list.forEach(p -> System.out.println(p));
    }
    // 

}
