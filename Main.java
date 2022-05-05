
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//wizualizacja
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.images.Resolutions;


public class Main {

    public static void main(String[] args) throws Exception {
        // Testowanie CzyPunktProstaLinia
        List<Integer> tabelaN = new ArrayList<Integer>() ;
        Collections.addAll(tabelaN,7, 1, 2, 2, 3
                , 2, 4
                , 4, 5
//               , 5, 6
//               , 6, 7
               //,5,7
               //,10,10
//            ,7,8,7,9
//            ,5,10
//            ,10,11,11,12,12,13,13,14

                ,10,11,11,12
                ,11,14,14
                ,15
                ,15,16,15,17

            ,20,21,21,22
            ,21,24,24
                ,25,25
            ,26,26
            ,27
            ,27,28,27,29

            ,30,31,31,32,31,33,33,34
        );
        //tabelaN.remove(0);
        //tabela 3 roznych rozlacznych przypadkow



        //Testowanie CzyDwieLinie
        List<Integer> tabelaY = new ArrayList<Integer>() ;
        Collections.addAll(tabelaY,969,1,2,2,3,2,4,4,5,4,6
                ,10,11,11,12,11,13
                //,13,14,14,15,14,16
                //,13,17
                //,17,40
                //,13,18,18,19,18,20,20,21,20,22

                ,30,31,31,32,31,33
        );
        //tabelaY.remove(0);



        //Testowanie Usowanie_pkt_z_wifi
        List<Integer> tabelaZ = new ArrayList<Integer>() ;
        Collections.addAll(tabelaZ,969,1,2
                ,3,4
                ,5,6,6,7
                ,8,9,9,10
                ,11,12,12,13,12,14,14,15
                ,20,21,20,22,20,23
                ,31,32,32,33,33,34,34,35
        );
        //tabelaZ.remove(0);
        List<Integer> Test = new ArrayList<Integer>();
        Collections.addAll(Test,1,2,4,5,6,7,8,10,11,13,21,22,23,32,34);



        //Testowanie CzyDwieLinieLX
        List<Integer> tabelaM = new ArrayList<Integer>() ;
        Collections.addAll(tabelaM,63
                ,1,2,2,3,2,4,4,5,4,7,4,6
                ,10,11,11,12,11,15,15,13,15,14,15,16,16,17,16,18
                //,8,4
                //,9,2
                ,21,23,23,22,23,24,24,26,24,25,24,27,27,29,29,30,29,28,29,33,33,31,33,32
                //,27,38//,38,39
                //feature - automatycnie usowa punkt jesli jest jeden podlaczony do routera,
                //przy dwoch zostawia punkt

                ,40,42,41,42,42,43,43,44,43,45,43,46,46,47,47,48,47,49
                    ,46,50,46,51
                //,50,51,51,52,52,53,53,54,54,55,52,57,53,56

                ,60,61
                ,61,62,62
                //,99,99
                ,64,62,63,64,65,64,66,66,67,62,68,68,69,69,70,69,71,71,72
                ,62,73,73,74,74,77,74,75,75,76
                //,75,77,77,78
        );
        //tabelaM.remove(0);



        // Testowanie Rozwiazanie_Koncowki
        List<Integer> tabelaK = new ArrayList<Integer>() ;
        Collections.addAll(tabelaK,969,
                1,2
                ,3,4,4,5,4,6
                ,7,9,9,8,9,10,10,11,10,12

                //testowanie blednego polaczenia
                //,10,9

//                1,2
//                ,3,4
//                ,5,6,6,7
//                ,8,9,9,10
//                ,11,12,12,13,12,14,14,15
//                ,20,21,20,22,20,23
//                ,31,32,32,33,33,34,34,35

//                1,2,2,3,2,4,4,5,4,6
//                ,10,11,11,12,11,13
//                ,13,14,14,15,14,16
//                ,13,17
//                ,17,40
//                ,13,18,18,19,18,20,20,21,20,22
//                ,30,31,31,32,31,3
        );
        //tabelaK.remove(0);



        // Testowanie CzyPunktProstaLiniaREKURENCJA
        List<Integer> tabelaR = new ArrayList<Integer>() ;
        Collections.addAll(tabelaR,49,
                1, 2, 2, 3, 4, 3, 5, 2, 6, 5, 7, 6, 8, 5, 9, 8, 10
                , 3, 11, 4, 12, 10, 13, 7, 14, 6, 15, 8, 16, 10, 17
                , 11, 18, 2, 19, 15, 20, 1, 21, 19, 22, 12, 23, 3, 24
                , 16, 25, 15, 26, 19, 27, 3, 28, 11, 29, 15, 30, 11, 31
                , 18, 32, 4, 33, 22, 34, 14, 35, 6, 36, 7, 37, 20, 38, 28
                , 39, 10, 40, 36, 41, 28, 42, 33, 43, 5, 44, 38, 45, 2, 46
                , 17, 47, 33, 48, 35, 49, 37
        );



        //
        List<Integer> tabelaD = new ArrayList<Integer>() ;
        Collections.addAll(tabelaD,33,
                1,2, 2,3, 3,4, 3,7, 2,5, 5,6, 2,24,
                24,25, 24,26, 26,27, 26,28, 1,20, 20,21, 21,22, 21,23, 1,8, 8,9, 1,10, 10,11,
                10,12,12,13, 12,14,1,15, 15,16,15,17,
                15,18,18,19,25,30,30,31,30,32,32,33,32,34
                //,30,50
                );

        List<Integer> tabelaCE = new ArrayList<Integer>() ;
        Collections.addAll(tabelaCE,999
                ,4,5
                ,5,6,6,7

                ,5,10
        );

//        List<Integer> tabelaROBERT = new ArrayList<Integer>() ;
//        Collections.addAll(tabelaROBERT,999
//                ,4,5
//                ,5,6,6,7
//
//                ,5,10
//        );


        //tabelaZ - Usowanie_pkt_z_wifi
    // a.PunktyZaliczone.addAll(Test);
        //tabelaN - CzyPunktProstaLinia
        //tabelaY - CzyDwieLinie

        //tabelaM - CzyDwieLinieLX
        //tabelaK - Rozwiazanie_Koncowki
        //tabelaD - Test wszystkich metod, poza Rozwiazanie_Koncowki

        //tabelaU - Randomowa tablica


        Zapis_do_pliku_losowej_tablicy(300);
        List<Integer> tabelaU = Odczyt_tablicyU_z_pliku();
        Start(tabelaU, 1,1,0);
        //Step_by_step(tabelaU,1);

//        List<List> zbior = new ArrayList<>();
//        List<Integer> zbior1 = new ArrayList<>();
//        List<Integer> zbior2 = new ArrayList<>();
//        List<Integer> zbior3 = new ArrayList<>();
//        Collections.addAll(zbior1,100000,10);
//        Collections.addAll(zbior2,150000,10);
//        Collections.addAll(zbior3,200000,10);
//        Collections.addAll(zbior,zbior1,zbior2,zbior3);
//
//        for (List<Integer> x : zbior){
//            Generuj_dane(x.get(0),x.get(1));
//        }
        //Generuj_dane(100000,1);

    }
    public static void Step_by_step(List<Integer> tabelaXXX, int Wyswietl_Rozwiazywanie) throws Exception {
        Bajtazar a = new Bajtazar(tabelaXXX,Wyswietl_Rozwiazywanie);
        var Dane = a.Rozwiazanie_Bajtazar();
        List<List> Step = Dane.get(4);
        List<Integer> Router_1 = Dane.get(0);
        List<Integer> Routery_2 = Dane.get(1);
        List<Integer> Pusta = new ArrayList<>();

        int licznik = 0;
        Step.add(Pusta);
//        for(List<Integer> x : Step){
//            System.out.println(x);
//        }
        for (List<Integer> setp : Step){
            if (licznik == Step.size()-1)break;
            List<List> Dane_do_przekazania = new ArrayList<>();

            List<Integer> Router_1_okrojone = new ArrayList<>(List.copyOf(Router_1));
            List<Integer> Routery_2_okrojone = new ArrayList<>(List.copyOf(Routery_2));
            Router_1_okrojone.retainAll(setp);
            Routery_2_okrojone.retainAll(setp);
            Dane_do_przekazania.add(Router_1_okrojone);
            Dane_do_przekazania.add(Routery_2_okrojone);

            Dane_do_przekazania.add(Pusta);
            Dane_do_przekazania.add(Step.get(licznik + 1));

            Integer anything = 0;
            setp.add(0,anything);

            Graph_pokaz_rozwiazanie(setp, Dane_do_przekazania,0);

            licznik += 1;
        }
    }

    public static void Generuj_dane(int wielkosc_tablicy ,int Ilosc_przetworzen) throws Exception {

        List<Integer> tabelaU = new ArrayList<Integer>();

        for (int i = 0; i < Ilosc_przetworzen; i++) {
            Collections.addAll(tabelaU,wielkosc_tablicy,1,2,2,3);
            PrintWriter zapis = new PrintWriter( new FileWriter("Dane.txt", true));
            for (int j = 4; j < wielkosc_tablicy+1 ; j++) {
                int losowa_liczba = ThreadLocalRandom.current().nextInt(1, j);
                tabelaU.add(j);
                tabelaU.add(losowa_liczba);
            }

            var Czas = Start(tabelaU, 0,0,0);
            zapis.write(wielkosc_tablicy + "\t" + Czas + "\n");
            tabelaU.clear();
            System.out.println(i);
            zapis.close();
        }

    }

    public static double Start(List<Integer> tabelaXXX, int Wyswietl_Rozwiazywanie, int Generuj_graf
    , int Zapisz_graf) throws Exception {
        var Kopia = new ArrayList<Integer>(List.copyOf(tabelaXXX));

        long start = System.currentTimeMillis();
        Bajtazar a = new Bajtazar(tabelaXXX,Wyswietl_Rozwiazywanie);
//        //
//        List<Integer> Test = new ArrayList<Integer>();
//        Collections.addAll(Test,1,2,4,5,6,7,8,10,11,13,21,22,23,32,34);
//        a.PunktyZaliczone.addAll(Test);
//        //
        var Dane = a.Rozwiazanie_Bajtazar();

        long meta = System.currentTimeMillis();
        System.out.println("\nProgram wykonał się w : " + (double)(meta - start)/1000 + " sekund");

        if(Generuj_graf == 1){
            Graph_pokaz_rozwiazanie(Kopia , Dane,Zapisz_graf);
        }

        return (double)(meta - start)/1000 ;
    }

    public static void Graph_pokaz_rozwiazanie(List<Integer> tabela, List<List> dane, int Zapisz_graf) throws Exception {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new MultiGraph("Tabela");

        Set<Integer> punkty = new HashSet<Integer>(tabela.subList(1,tabela.size()));
        for (int punkt : punkty){
            String pkt = String.valueOf(punkt);
            graph.addNode(pkt);
            graph.getNode(pkt).setAttribute("ui.label", "     "+pkt);
       }

        int zz = 1 ;
        while (zz < tabela.size()){
            String nazwa = String.valueOf(tabela.get(zz)) + " " + String.valueOf(tabela.get(zz+1));
            graph.addEdge(nazwa, String.valueOf(tabela.get(zz)), String.valueOf(tabela.get(zz+1)));
            zz += 2;
        }

        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        graph.setAttribute("ui.stylesheet",
                "node.Router1 {\n" +
                "\tshape: box;\n" +
                "\tfill-color: #e38629;\n" +
                "\tstroke-mode: plain;\n" +
                "}\n"

                + "node.Router2 {\n" +
                "\tshape: cross;\n" +
                "\tfill-color: red;\n" +
                "\tstroke-mode: plain;\n" +
                "}"

                + "node.Punkt_zostawiony {\n" +
                "\tfill-color: green;\n" +
                "}"

                + "edge {\n" +
                "\tshape: line;\n" +
                "\tarrow-size: 3px, 2px;\n" +
                "}"
///////////////////////////////////////////////////
                + "node.Punkt_z_wifi {\n" +
                "\tfill-color: purple;\n" +
                "}"

                + "node.Dowolne_polaczenie {\n" +
                "\tfill-color: red;\n" +
                "}"

                + "node.Opconalny_punkt {\n" +
                "\tfill-color: blue;\n" +
                "}"
        );

//        Viewer viewer = graph.display();
//        View view = viewer.getDefaultView();
//        view.getCamera().setViewPercent(0.2);

        List<Integer> Punkt_z_1_routerem = dane.get(0);
        for(Integer punkt : Punkt_z_1_routerem){
            String pkt = String.valueOf(punkt);
            graph.getNode(pkt).setAttribute("ui.class", "Router1");
        }


        List<Integer> Punkt_z_2_routerami = dane.get(1);
        for(Integer punkt : Punkt_z_2_routerami){
            String pkt = String.valueOf(punkt);
            graph.getNode(pkt).setAttribute("ui.class", "Router2");
        }



////////////////////
//        List<Integer> Test = new ArrayList<Integer>();
//        Collections.addAll(Test,1,2,4,5,6,7,8,10,11,13,21,22,23,32,34);
//        for(Integer punkt : Test){
//            String pkt = String.valueOf(punkt);
//            graph.getNode(pkt).setAttribute("ui.class", "Punkt_z_wifi");
//        }
        //graph.getNode("6").setAttribute("ui.class", "Dowolne_polaczenie");
        //graph.getNode("17").setAttribute("ui.class", "Opconalny_punkt");
//        graph.getNode("11").setAttribute("ui.class", "Opconalny_punkt");
//        graph.getNode("7").setAttribute("ui.class", "Opconalny_punkt");
//        graph.getNode("6").setAttribute("ui.class", "Opconalny_punkt");
//        graph.getNode("40").setAttribute("ui.class", "Opconalny_punkt");
////////////////////



        Set<Integer> tabelaN = new HashSet<Integer>(dane.get(3));
        for(Integer punkt : tabelaN){
            String pkt = String.valueOf(punkt);
            graph.getNode(pkt).setAttribute("ui.class", "Punkt_zostawiony");
        }

        if(Zapisz_graf == 1){
            FileSinkImages pic = FileSinkImages.createDefault();
            pic.setOutputType(FileSinkImages.OutputType.PNG);
            pic.setResolution(Resolutions.UHD_4K);
            pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
            pic.setQuality(FileSinkImages.Quality.HIGH);
            pic.writeAll(graph, "Graf.png");
        }

        graph.display();
    }

    public static void Zapis_do_pliku_losowej_tablicy(int wielkosc_tablicy) throws IOException {
        // Randomowa tablica
        List<Integer> tabelaU = new ArrayList<Integer>();
        Collections.addAll(tabelaU,wielkosc_tablicy,1,2,2,3);

        for (int i = 4; i < wielkosc_tablicy+1 ; i++) {
            int losowa_liczba = ThreadLocalRandom.current().nextInt(1, i);
            tabelaU.add(i);
            tabelaU.add(losowa_liczba);
        }

        FileOutputStream fos = new FileOutputStream("tabelaU.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tabelaU);
        oos.close();
    }

    public static ArrayList Odczyt_tablicyU_z_pliku() throws IOException, ClassNotFoundException {
        // import z .tmp
        FileInputStream fis = new FileInputStream("tabelaU.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        var tabelaU = (ArrayList) ois.readObject();

        ois.close();
        fis.close();
        return tabelaU;
    }
}