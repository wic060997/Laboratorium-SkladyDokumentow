import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;

public class Program {
    static Scanner scanner;
    static boolean koniec = false;

    private static String user = "datebase01";
    private static String password = "datebase01";
    private static String host = "localhost";
    private static int port = 27017;
    private static String datebase = "DatebasePSRLab2";

    private static MongoCollection<Document> collection;

    private static void initialize() {
        MongoClient mongoClient = new MongoClient(host, port);
        MongoCredential credential = MongoCredential.createCredential(user, datebase, password.toCharArray());

        MongoDatabase db = mongoClient.getDatabase(datebase);

        db.getCollection("przychodnia").drop();

        collection = db.getCollection("przychodnia");
    }

    private static void addNew() {
        Wizyta wizyta = new Wizyta();
        System.out.println("\n Podaj numer identyfikacyjny wizyty:");
        wizyta._id = Integer.parseInt(scanner.nextLine());
        System.out.println(" Podaj date wizyty: ");
        wizyta.data = scanner.nextLine();
        System.out.println(" Podaj imie pacjenta: ");
        wizyta.ImiePacjenta = scanner.nextLine();
        System.out.println(" Podaj nazwisko pacjenta: ");
        wizyta.NazwiskoPacjenta = scanner.nextLine();
        System.out.println(" Podaj pesel pacjenta: ");
        wizyta.peselPacjenta = Integer.parseInt(scanner.nextLine());
        System.out.println(" Podaj nazwe lekarza: ");
        wizyta.nazwaLekarza = scanner.nextLine();

        Document wiz = new Document("id", wizyta._id)
                .append("data", wizyta.data)
                .append("nazwaLekarza", wizyta.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", wizyta.ImiePacjenta)
                                .append("Nazwisko", wizyta.NazwiskoPacjenta)
                                .append("Pesel", wizyta.peselPacjenta)
                );

        collection.insertOne(wiz);

    }

    private static void startData(){
        Wizyta w1 = new Wizyta();
        w1._id = 1;
        w1.data = "2020-05-04";
        w1.nazwaLekarza="ginekolog";
        w1.peselPacjenta=987654321;
        w1.ImiePacjenta="Marian";
        w1.NazwiskoPacjenta="Kowalski";
        Document d1 = new Document("id", w1._id)
                .append("data", w1.data)
                .append("nazwaLekarza", w1.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w1.ImiePacjenta)
                                .append("Nazwisko", w1.NazwiskoPacjenta)
                                .append("Pesel", w1.peselPacjenta)
                );
        collection.insertOne(d1);

        Wizyta w2 = new Wizyta();
        w2._id = 2;
        w2.data = "2020-05-24";
        w2.nazwaLekarza="ginekolog";
        w2.peselPacjenta=956321478;
        w2.ImiePacjenta="Piotr";
        w2.NazwiskoPacjenta="Mak";
        Document d2 = new Document("id", w2._id)
                .append("data", w2.data)
                .append("nazwaLekarza", w2.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w2.ImiePacjenta)
                                .append("Nazwisko", w2.NazwiskoPacjenta)
                                .append("Pesel", w2.peselPacjenta)
                );
        collection.insertOne(d2);

        Wizyta w3 = new Wizyta();
        w3._id = 3;
        w3.data = "2020-05-12";
        w3.nazwaLekarza="ortopeda";
        w3.peselPacjenta=632598741;
        w3.ImiePacjenta="Natalia";
        w3.NazwiskoPacjenta="Kupa";
        Document d3 = new Document("id", w3._id)
                .append("data", w3.data)
                .append("nazwaLekarza", w3.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w3.ImiePacjenta)
                                .append("Nazwisko", w3.NazwiskoPacjenta)
                                .append("Pesel", w3.peselPacjenta)
                );
        collection.insertOne(d3);

        Wizyta w4 = new Wizyta();
        w4._id = 4;
        w4.data = "2020-05-07";
        w4.nazwaLekarza="urolog";
        w4.peselPacjenta=321789654;
        w4.ImiePacjenta="Julka";
        w4.NazwiskoPacjenta="Pawłowska";
        Document d4 = new Document("id", w4._id)
                .append("data", w4.data)
                .append("nazwaLekarza", w4.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w4.ImiePacjenta)
                                .append("Nazwisko", w4.NazwiskoPacjenta)
                                .append("Pesel", w4.peselPacjenta)
                );
        collection.insertOne(d4);

        Wizyta w5 = new Wizyta();
        w5._id = 5;
        w5.data = "2020-05-01";
        w5.nazwaLekarza="neurolog";
        w5.peselPacjenta=852147963;
        w5.ImiePacjenta="Filip";
        w5.NazwiskoPacjenta="Laska";
        Document d5 = new Document("id", w5._id)
                .append("data", w5.data)
                .append("nazwaLekarza", w5.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w5.ImiePacjenta)
                                .append("Nazwisko", w5.NazwiskoPacjenta)
                                .append("Pesel", w5.peselPacjenta)
                );
        collection.insertOne(d5);

        Wizyta w6 = new Wizyta();
        w6._id = 6;
        w6.data = "2020-05-15";
        w6.nazwaLekarza="ortopeda";
        w6.peselPacjenta=963258741;
        w6.ImiePacjenta="Agnieszka";
        w6.NazwiskoPacjenta="Rak";
        Document d6 = new Document("id", w6._id)
                .append("data", w6.data)
                .append("nazwaLekarza", w6.nazwaLekarza)
                .append("pacjent",
                        new Document("Imie", w6.ImiePacjenta)
                                .append("Nazwisko", w6.NazwiskoPacjenta)
                                .append("Pesel", w6.peselPacjenta)
                );
        collection.insertOne(d6);
    }

    private static void showAll() {
        System.out.println("\n Wszystkie wizyty znajdujące sie w dokumencie:");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    private static void showOneElement() {
        System.out.println("Podaj id wizyty do wyświetlenia:");
        int id = Integer.parseInt(scanner.nextLine());
        Document doc = collection.find(lte("id", id)).first();
        System.out.println(doc.toJson());
    }

    private static void update() {
        System.out.println("Podaj id wizyty do wyświetlenia:");
        int id = Integer.parseInt(scanner.nextLine());
        Document doc = collection.find(lte("id", id)).first();
        System.out.println(doc.toJson());

        System.out.println("ABY POMINĄĆ WCIŚNIJ 0");
        System.out.println("Aktualizacja id:");
        String idn = scanner.nextLine();
        if (idn.equals("0") == false) {
            id = Integer.parseInt(idn);
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("_id", Integer.parseInt(idn))
                    )
            );
        }

        System.out.println("Aktualizacja daty");
        String datan = scanner.nextLine();
        if (datan.equals("0") == false) {
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("data", datan)
                    )
            );
        }

        System.out.println("Aktualizacja nazwy lekarza:");
        String lekarzN = scanner.nextLine();
        if (lekarzN.equals("0") == false) {
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("nazwaLekarza", lekarzN)
                    )
            );
        }

        System.out.println("Aktualizacja imienia pacjenta:");
        String imieN = scanner.nextLine();
        if (imieN.equals("0") == false) {
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("pacjent.Imie", imieN)
                    )
            );
        }

        System.out.println("Aktualizacja nazwiska pajenta:");
        String nazwisko = scanner.nextLine();
        if (nazwisko.equals("0") == false) {
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("pacjent.Nazwisko", nazwisko)
                    )
            );
        }

        System.out.println("Aktualizacja peselu paqcjenta:");
        String peselN = scanner.nextLine();
        if (peselN.equals("0") == false) {
            collection.updateOne(eq("_id", id),
                    new Document("$set",
                            new Document("pacjent.Pesel", Integer.parseInt(peselN))
                    )
            );
        }


    }

    private static void deleteOne() {
        System.out.println("\n Podaj numer identyfikacyjny wizyty:");
        int id = Integer.parseInt(scanner.nextLine());

        collection.deleteOne(eq("id", id));
    }

    private static void expendedQuery() {
        System.out.println("\n Podaj nazwę lekarza:");
        String nazwa = scanner.nextLine();

        FindIterable<Document> result = collection.find(lte("nazwaLekarza",nazwa));

        for (Document doc : collection.find(lte("nazwaLekarza",nazwa))
        ) {
            System.out.println(doc.toJson());
        }
    }

    static private void showMenu() {
        System.out.println("\n**************  MENU:  ***************");
        System.out.println("1 - Dodaj nowa wizytę ");
        System.out.println("2 - Wyświetl wszystkie wizyty ");
        System.out.println("3 - Wyświetl wizytę po jego id ");
        System.out.println("4 - Zaaktualizuj wizytę");
        System.out.println("5 - Usuń wizytę");
        System.out.println("6 - Wyświetl wszystkie wizyty danego lekarza ");
        System.out.println("0 - WYJŚCIE\n");
    }

    static private int getWyborMenu() {
        int choice = -1;
        do {
            System.out.println("Podaj wybór:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 6) {
                System.out.println("Brak takiej opcji!");
            }
        } while (choice < 0 || choice > 6);
        return choice;
    }

    static private void akcja(int wybor) {
        switch (wybor) {
            case 1:
                addNew();
                break;
            case 2:
                showAll();
                break;
            case 3:
                showOneElement();
                break;
            case 4:
                update();
                break;
            case 5:
                deleteOne();
                break;
            case 6:
                expendedQuery();
                break;
            case 0:
                koniec = true;
                break;
            default:
                System.out.println("BŁĄD");
        }
    }

    static void menu() {
        while (!koniec) {
            showMenu();
            int wybor = getWyborMenu();
            akcja(wybor);
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        initialize();

        startData();

        menu();
        scanner.nextInt();
    }

}
