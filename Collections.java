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
            Maps stellen eine Sammlung aus Schlüüssel-Wert-Paaren wieder. Das bedeutet jeder
            Schlüssel ist eindeutig einem Wert zuzuweisen.

            HashMaps:
            Die Reihenfolge der Wiedergabe von Elementen ist Ungeordnet undd nicht vorhersehbar.
            Die bietet eine höhe Leistung beim Löschen und einfügen von Inhalten. 
            Erlaubt Null-Werte sowohl ab Schlüssel als auch am Wert.
            nicht threadsicher. Wenn mehrere gleichzeitig laufen und einer die Map ändert, muss eine
            externe Synchronisation folgen.

            LinkedHashMap:
            Sie behält im Gegensatz zu der HashMap seine Reihenfolgen der Einfügung bei.
            Erlaubt ebenfalls Nullwerte.
            Leicht höhere Leisungseinbußen, aufgrund der einhaltung der Reihenfolge.
            Ebenfalls nicht threadsicher.

            TreeMaps:
            Die Treemaps behalten ihre Reihenfolge bei oder ihre Reihenfolge wird anhand
            eines Comparators eigens bestimmt.
            Treemaps funktionieren langsamer, aufgrund ihrer logarithmischen Zeitkomplexität.
            Erlaubt keine Null-Werte und ist nicht threadsicher.
             */

            Map<Character, Integer>
                M1 = Map.of('1', 1, '2', 2, '3', 3,
                            '4', 4, '5', 5, '6', 6),
                M2 = new HashMap<>(M1), 
                M3 = new LinkedHashMap<>(M1),
                M4 = new TreeMap<>(Character::compareTo);   // (Comparator optional)

            //Einfügen von Werten in die Map (beachte! M1 nicht möglich, da Sie unveränderlich ist)
                M2.put('7', 7);
                M4.put('1',2);
                M4.put('2',5);
            //Entfernt Werte von dem folgenden Key
                M2.remove('7');
            //Überprüft ob ein bestimmer Wert oder ein Key vorhanden ist
                M2.containsValue(4);
                M2.containsKey('2');


            //Fügt alle Schlüssel Wert Paare in eine andere Map
                M2.putAll(M4);

        /*
        Nach welchem Kriterium wird M4 soritert?
        Die Maps werden anhand des Comparators sortiert. Das heißt, Sie werden hier nach aufsteigender
        lexikographischer Reihenfolge der Unicode Tabelle soriert.

        Wo/Wie wirkt sich die Sorierung überhaupt aus?
        Die Iteration des Comparators gibt die Elemente der TreeMap in aufsteigender
        Reihenfolge der Schlüssel wieder
         */
            System.out.println(M1 + " - "+ M2 + " - "+ M3 + " - "+ M4);
        } 
    }
        

    System.out.println( "\n" + "Functions: ");

        // ### Grundlagen von Funktionsobjekten (Lambdas) in Java ###
        {
            // Beschreibung:
            // * Funktionale/deklarative Programmierung:
            //   + Der Fokus liegt daran, zu erklären, was erreicht werden soll und nicht wie
            //   + Das Ziel der Methode liegt im Vordergrund und nicht der Weg der Methode
            //   + Die Reihenfolge der Berrechnung ist nicht relevant, dies ermöglicht die
            //      Paralälität und fördert eine flexiblere Nutzung
            //   + Zwischenzustände der Variable werden implizit behandelt, Das bedeutet, dass
            //      der Fokus auf den Ergebnissen liegt.
            
            //   + Java/Lambdas: Funktionsausdrücke, funktionales 'switch'/'?:'
            // * Funktionsausdrücke insbesondere Lambdas (dargestellt als (...) -> {...},
            //      sind Werte von Funktionstypen, und können gespeichert und Parameter übergeben
            // * Eine wichtige Eigenschaft ist die Übergabe von Funktionen als Parametet an Methoden.
            //      Dies ermöglicht verschiedene Sortierverahren durch die Übergabe der Vergleichslogik
            // * Durch die Verwendung von Lambda Ausrücken wird der Code selbst wie Daten behandelt,
            //      der an geeigneten Stellen aktiviert wird.
            // * Hierbei steht die Funktion für sich selbst und ist unabhängig von spezifischen 
            //      Objekten- oder Klassenkontext

            // Beispiele:

            /*
            Function<T,R>
            Eine Funktionsschnittstelle nimmt ein Argument Typ T an und gibt R wieder.
            Eine generische Funktion, zum tansformieren von Typen.

            UnaryOperator<T>
            Ist eine spezielle Unterart der Funktion, der Eingabetyp entspricht zugleich 
            dem Ausgabetyp. Somit wird eine Operandenoperation druchgeführt und somit
            das Ergebnis des gleichen Types wiedergegeben

            Predicate<T>
            Wird verwendet und ein Argument T auf true oder false zu überprüfen.
            Es wird oft verwendet um zu Prüfen ob ein bestimmtes Ziel erreicht wird.
             */

            // String wird zu einem Double geparsed
            // Double::parseDouble --- Alternative
            Function<String, Double> A1 = S -> Double.parseDouble(S);   
            
            //Parsing von einem Double zu einem String
            Function<Double, String> A2 = D -> Double.toString(D);

            // String::toUpperCase --- Alternative
            UnaryOperator<String> A3 = S -> S.toUpperCase();

            //String::isEmpty;    --- Alternative
            Predicate<String> A4 = S -> S.isEmpty();
            
            //Überprüfung
            double
                //String to Double
                D1 = A1.apply("1234.5678E9");
            String
                //Double to String
                S1 = A2.apply(1234.5678E9),
                //Letters toUppercase
                S2 = A3.apply("hello world!");
            boolean
                //Checking for empty String
                B1 = A4.test(" ");
            
            //Ausgabe
            System.out.println("Simple Functions: ");
            System.out.println(D1+", "+S1+", "+S2+", "+B1 + "\n");
            System.out.println("Bi Functions");
    

            //String::contains;
            BiFunction<String, String, Boolean> G1 = (T, R) -> T.contains(R);   
        
            BiPredicate<String, String> G2 = String::contains;

            //String::concat; --- wird verwendet um Zeichenketten zu verbinden
            BinaryOperator<String> G3 = (T, R) -> T.concat(R);  

            //String::substring; --- wird verwendet um einen Teil des String in einen substring
            //                         zu verwenden
            BiFunction<String, Integer, String> G4 = (T, X) -> T.substring(X);  
            
            boolean
            //Zwei String als Eingabeparametet, wiedergegeben wird der Boolsche Wert, ob 
            //String zwei in String 1 vorhanden
                B2 = G1.apply("blabla", "bla"),
            //Boolsche wiedergabem ob String 2 in String 1 vorhanden ist.
                B3 = G2.test("blabla", "abc");
            String
            //Beide String Eingabeparameter werden verbunden
                S3 = G3.apply("bla", "bla"),
            //Ein Substring wird gebildet ab dem 4ten Buchstaben des Eingabestrings
                S4 = G4.apply("blabla", 3);

            System.out.println(B2+", "+B3+", "+S3+", "+S4);
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
