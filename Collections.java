package Main;

import java.util.*;
import java.util.function.*;

public class Collections
{
    public static void main(String[] args)
    {
        // ### Grundlagen von Collections in Java ###
        {
            /*  
            Interfaces sind Zugriffsschnittstellen ohne Implementierung oder Code.
            Es gibt List<T>, (Sorted)Set<T>, (Sorted)Map<T, U> welche konkret als Klasse
            fungieren und als Interface implementiert:
                * List<T>:  ArrayList<T>, LinkedList<T>, Vector<T>
                * Set<T>:   (Linked)HashSet<T>, TreeSet<T> (sortiert+)
                * Map<T, U>:(Linked)HashMap<T>, TreeMap<U, T> (sortiert),
                            ConcurrentHashMap<T, U> u.a.
            */
            
            System.out.println("Lists: ");

            {
            /*
            Allgemeine Informationen zu Listen
            Lists präsentieren eine geordnete Sammlung an Elementen, in der Elemente
            anhand ihres Index zugänglich sind. Die indexiierung beginnt stets bei 0
            Wichtige Methoden sind: 
            add(e: element) - get(index: x) - remove(index: x) - size();

            ArrayLists:
            Haben im gegebsatz zu List.of eine Dynamische Größenänderung.
            Schneller Zugriff via dem Index.
            Einfüge und Entfernungsoperationen können bei größeren Datenmengen 
            effizent sein.
            ArrayLists eigenen sich somit besser ür häuffige Lesezugrifffe

            LinkedLists:
            Basiert auf doppelt verkettete Listen zur Speicherung von Elementen.
            Dadurch ist das Einfügen und Entfernen von Elementen, insbesondere in 
            der Mitte der Liste sehr Efizient.
            Jedoch Langsamer Zugriff über den Index im Vergleich zur ArrayList.
            Benötigt ebenso mehr Speicherplatz als die ArrayList.
            LinkedLists sind für häufige Einfüge- & Entfernungsoperationen geeignet
             */

            // Beispiele für List Implementierungen
            List<Integer>               // manche mit/ohne erlaubte 'null's
                L1 = List.of(1, 2, 3, 4, 5, 6),
                L2 = new ArrayList<>(L1), 
                L3 = new LinkedList<>(L1);                

                //Hinzufügen von Elementen
                L2.add(7);

                //Abrufen eines bestimmten Indexes
                int elementAtIndex2 = L1.get(1);
                System.out.println("Element an 2ter Stelle: "+ elementAtIndex2);

                //Entfernen eines Elementes
                L2.remove(2);

                //Abrufen der größe der Liste
                int listSize = L1.size();
                System.out.println("Größe der Liste "+ listSize);

                //Ausgabe in der Konsole
                System.out.println(L1 + " - " + L2 + " - " +  L3);
            }
            
            System.out.println( "\n" + "Sets: ");

            {
            /*
            Allgemeine Informationen zu Sets
            Sets sind eine Sammlung von eindeutigen Elementen, in der jedes Element nur
            einmal vorkommen kann.

            Sets repräsentieren eine ungeordnete Sammlung an eindeutigen Elementen.
            SortedSets sind ein Erweiterung von Sets die Elemente hier werden nach einen
            Comparator soriert.

            HashSets:
            verwendet HashTabellen zur Speicherung der Elemente. Dies ermöglicht einen 
            schnellen Zugriff auf die Elemente. Es besteht keine vorgegebene Reihenfolge

            LinkedHashSets:
            Ist eine Erweiterung der HashSets. Sie behält die Einfügereihenfolge bei.
            Sie bietet ebenso einen schnellen Zugriff auf die Elemente.

            TreeSet:
            Diese Klasse implementiert das SortedSet und benutzt ein ausgewogenes 
            Baumdiagramm zur Speicherung der Elemente.
            Elemente werden in Aufsteigender Reihenforlge sortiert (oder nach einen Comparator)
            Besitzt langsamere Einfüge und Entfernungsoperationen im Vergleich zu HS/LHS

            */
            Set<Character>
                S1 = Set.of('A', 'B', 'C', 'D', 'E', 'F'),
                S2 = new HashSet<>(S1), 
                S3 = new LinkedHashSet<>(S1);
            SortedSet<Character>
                S4 = new TreeSet<>(Character::compareTo); // (Comparator optional)
            //Hinzufügen von Elementen in ein Set
                S4.add('A');
                S4.add('B');
                S4.add('C');
            //Entfernen von Elementen
                S4.remove('C');

            /*
            Ist eine SortedSet auch ein Set?
            Ja es ist eine Variation der Sets die lediglich durch einen Comparator soriert wird.

            Kann S4 auch unter Set<Character> instantiiert werden?
            Ja, es ist möglich ein Treeset unter Set<Character> zu instzanziieren.
             */

            //Ausgabe in der Konsole
            System.out.println(S1 + " - " + S2 + " - " + S3 + " - " + S4);
            }

            System.out.println( "\n" + "Maps: ");

            {
            /*
            Allgemeine Informationen zu Maps
            


             */
            Map<Character, Integer>
                M1 = Map.of('1', 1, '2', 2, '3', 3,
                            '4', 4, '5', 5, '6', 6),
                M2 = new HashMap<>(M1), 
                M3 = new LinkedHashMap<>(M1),
                M4 = new TreeMap<>(Character::compareTo);   // (Comparator optional)

        /*
        Nach welchem Kriterium wird M4 soritert?


        Wo/Wie wirkt sich die Sorierung überhaupt aus?
        
         */
            System.out.println(M1 + " - "+ M2 + " - "+ M3 + " - "+ M4);
        } 
    }
        
        // ### Grundlagen von Funktionsobjekten (Lambdas) in Java ###
        {
            // Beschreibung:
            // * Funktionale/deklarative Programmierung:
            //   + Beschreibung dessen, *was* zu tun ist (nicht *wie*)
            //   + Ergebnis/Ziel ist relevant, nicht Weg/Methode
            //   + Reihenfolge der Berechnung nicht relevant (Parallelität)
            //   + Zwischenzustände in Variablen nur implizit (Parameter)
            //   + Java: Funktionsausdrücke, funktionales 'switch'/'?:'
            // * Funktionen sollen als Parameter an Methoden übergeben
            //   werden können (z.B. für verschiedene Sortierverfahren)
            // * Lambdas (...) -> {...} sind die Werte/Inhalte von Java-
            //   Funktionstypen: Kode kann in Variablen gespeichert und
            //   als Parameter an Methoden übergeben werden, wo der Kode
            //   aktiviert werden kann (d.h. Kode wird wie Daten behandelt)
            // * Eine Funktion besitzt 0..N Eingabe- und 1 Ausgabeparameter,
            //   hat aber keinen Objekt-/Klassenkontext (d.h. steht für sich)

            // Beispiele:
            Function<String, Double> F1 = S -> Double.parseDouble(S);   // Double::parseDouble
            Function<Double, String> F2 = D -> Double.toString(D);
            UnaryOperator<String> F3 = S -> S.toUpperCase();    // String::toUpperCase
            Predicate<String> F4 = S -> S.isEmpty();            //String::isEmpty;
            double
                D1 = F1.apply("1234.5678E9");
            String
                S2 = F2.apply(1234.5678E9),
                S3 = F3.apply("hello world!");
            boolean
                A4 = F4.test(" ");
            //System.out.println(D1+", "+S2+", "+S3+", "+A4);
    
            BiFunction<String, String, Boolean> G1 = (T, R) -> T.contains(R);   //String::contains;
            BiFunction<String, Integer, String> G2 = (T, X) -> T.substring(X);  //String::substring;
            BinaryOperator<String> G3 = (T, R) -> T.concat(R);  //String::concat;
            BiPredicate<String, String> G4 = String::contains;
            boolean
                B1 = G1.apply("blabla", "bla"),
                B4 = G4.test("blabla", "abc");
            String
                T2 = G2.apply("blabla", 3),
                T3 = G3.apply("bla", "bla");
            //System.out.println(B1+", "+B4+", "+T2+", "+T3);
        }
        
        // ### Vordefinierte Funktionen und Methoden mit Funktionsparametern ###
    
        // Filterung/Entfernung
        {
            List<Character> L = new ArrayList<>(List.of('A', '1', 'a', 'ẞ'));
            Predicate<Character> P = C -> Character.isUpperCase(C); // Character::isUpperCase

            L.removeIf(P);  // L.removeIf(P.negate());
            System.out.println();
        }
    
        // Sortierung 1
        {
            Comparator<String>
                Comp = String::compareTo,   // normaler lexikal. Stringvergleich
                CompAsc = (S1, S2) ->       // Vergleich über Stringlänge
                {
                    int L1 = S1.length(), L2 = S2.length();
                    return Integer.compare(L1, L2);     // -1, 0, +1
                },  // oder: CompAsc = Comparator.comparingInt(String::length)
                CompDesc = CompAsc.reversed();  // umgekehrter Längenvergleich
            
            List<String>
                H = List.of("blabla", "bla", "blubb", "", "haha"),
                L = new ArrayList<>(H); // veränderbare/sortierbare Liste
            
            L.sort(Comp);
            //L.sort(CompAsc);
            //L.sort(CompDesc);
            //System.out.println(L);
        }
        // Sortierung 2
        {
            Comparator<String>
                Comp = Comparator.comparingInt(String::length); // identisch mit:
                //Comp = (S1, S2) -> Integer.compare(S1.length(), S2.length());
            Map<String, Integer>
                M = new TreeMap<>(Comp),
                MM = Map.of("one", 1, "two", 2,
                            "three", 3, "four", 4);
            M.putAll(MM);
    
            //M.forEach((I, S) -> System.out.print(Map.entry(I, S)+"\t"));
            //System.out.println(M);       // Warum nur 3 als Ausgabe?
            
            // Weitere funktionale Methoden auf Maps:
            // replaceAll, compute(IfAbsent/IfPresent), merge
        }
    
        // Konsumption
        {
            List<Integer> L = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
            Predicate<Integer>
                Pred = X -> (X & 1) == 0;
            Consumer<Integer>
                Cons1 = X -> System.out.print(X+"\t"),
                Cons2 = X -> { if (Pred.test(X)) System.out.print(X+"\t"); };
        
            //L.forEach(Cons1);
            //L.forEach(Cons2);
        }
        // Konstruktion/Kreation
        {
            int N = 10;
            Random R = new Random();
            Supplier<Integer> Supp = () -> R.nextInt(N);
            UnaryOperator<Integer> Op = X -> X*X;
        
            Map<Integer, Integer> M = new HashMap<>();
            for (int I = 0; I < N; I++)
            {
                int Z = Supp.get();          // trägt Z nur ein,
                M.computeIfAbsent(Z, Op);    // wenn noch nicht vorhanden
            }
            //System.out.println(M);
        }
    
        // ### Beispiele für selbstdefinierte Funktionen ###
        
        @FunctionalInterface
        interface TriFunction<T, U, V, R>
        {
            R apply(T X, U Y, V Z);
        }
        {
            TriFunction<String, Integer, Integer, String>
                F3 = (S, X, Y) -> S.substring(X, Y);    // String::substring
            String R = F3.apply("hahaha", 1, 4);
        }

        @FunctionalInterface
        interface TriOperator<T>    //extends TriFunction<T, T, T, T>
        {
            T apply(T X, T Y, T Z);
        }
        {
            TriOperator<Long>
                Min = (X1, X2, X3) -> Math.min(X1, Math.min(X2, X3)),
                Max = (X1, X2, X3) -> Math.max(X1, Math.max(X2, X3));
            long
                L1 = Min.apply(1L, 2L, 3L),
                L2 = Max.apply(1L, 2L, 3L);
        }

        @FunctionalInterface
        interface TriPredicate<T, U, V> //extends TriFunction<T, U, V, Boolean>
        {
            boolean test(T X, U Y, V Z);
        }
        // Bsp. selbst ausdenken

        @FunctionalInterface
        interface TriConsumer<T, U, V>  // keine Ableitung von Oberklasse möglich
        {
            void accept(T X, U Y, V Z);
        }
        // Bsp. selbst ausdenken

        // ### Aufgaben ###
        {
            // Todo Fragen:
            //  * Def. eines Interfaces TriOperator bzw. TriPredicate:
            //    - Von TriFunction ableiten? Pro und Contra
            //    - Wo ist der Kode, da ja kein Kodeblock {...} vorhanden?
            //  * Frage: Was macht TriConsumer und TriSupplier?
            // Todo Aufgaben:
            //  * Equator mit Test auf gleiches Double-Vorzeichen
            //  * TriPredicate für Gleichheit dreier Werte
            //  * TriConsumer, der zwei Strings zu StringBuilder hinzufügt
            //  * Funktion, die Double-Liste/Set erhält und Mittelwert berechnet
            //  * Funktion/Interface Selector, der "?:"-Funktion nachbildet
            //  * Funktion/Interface Similator, der Wert zw. 0.0 und 1.0 liefert
            //    Beispiel: Vgl. zweier Character 'CaseConsensitive':
            //              1.0: 'A' und 'A'
            //              0.5: 'A' und 'a'
            //              0.0: 'A' und 'B'
            //    ("ABCD" und "AbcD" => 0.75 bei Mittelung der Einzelwerte)
        }
    }
    /*
    Lists und Sets:
    Gemeinsamkeiten:
    - Beide können eine sortierte Reihenfolge besitzen.
    - Mehrere Elemente können darin gespeichert werden.
    - Unterschiedliche Datentypen können darin gespeichert werden
    - Beide bieten Methoden zum Verrarbeiten ihrer Elemente (sortieren/suchen usw.)
    Unterschiede:
    - Sets können keine Duplikate besitzen, Lists dagegen schon.
    - Sets, sind in der Regel unsortiert.
    - In Sets können Elemente nicht nachträglich geändert wrden. Nur das Hinzufügen und
    Entfernen von Elementen ermöglicht dies,
    -   Elemente in Lists sind über einen Index zugreibar, in Sets nicht.
     */
}
