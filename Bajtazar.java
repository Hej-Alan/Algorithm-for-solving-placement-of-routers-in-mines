

import java.util.*;

public class Bajtazar {
    public List<Integer> Punkt_z_1_routerem;
    public List<Integer> Punkt_z_2_routerami;
    //public List<Integer> Potencjalne;
    public Set<Integer> PunktyZaliczone;
    //public List<Integer> Koncowki;

    public List<Integer> tabelaN;
    public int Wyswietl;

    public List<Integer> Sprawdzenie_LX_Punkt_O;
    public List<List> Sprawdzenie_LX_LPP;
    // Sprawdzenie wyjatku dwielinie z dwielinieLX



    public Bajtazar(List<Integer> tabelaN, int Wyswietl){
        Punkt_z_1_routerem = new ArrayList<Integer>();
        Punkt_z_2_routerami = new ArrayList<Integer>();
        PunktyZaliczone = new HashSet<Integer>();
        //Koncowki = new ArrayList<Integer>();
        this.Wyswietl = Wyswietl;
        this.tabelaN = tabelaN;

        tabelaN.remove(0);
        //var LIPO = listaIlosciPolaczen (tabelaN);
        //var PPTab = TABpolaczenia(tabelaN);
        //PPTab to tablica z polaczeniami punktu np punkt 1 do 2,3,4

        Sprawdzenie_LX_Punkt_O = new ArrayList<Integer>();
        Sprawdzenie_LX_LPP = Bajtazar.TABpolaczenia(tabelaN);
    }

///////////////////////////////////////////////////////////////////////////////////////

    public static List<List> listaIlosciPolaczen (List<List> LPPtab){

        List<List> TWynik = new ArrayList<>();
        for (List<Integer> liczba : LPPtab) {
            List<Integer> wynik = new ArrayList<>();
            wynik.add(liczba.get(0));
            wynik.add(liczba.size()-1);
            TWynik.add(wynik);
        }
//        Set<Integer> tab = new HashSet<Integer>();
//        tab.addAll(tablica);
//        for (int i : tab) {
//            List<Integer> wynik = new ArrayList<>();
//            int c = Collections.frequency(tablica,i);
//
//            Collections.addAll(wynik,i,c);
//            TWynik.add(wynik);
//        }
        //Zamiast iterowac sie po calej tablicy xxx razy i szukac ilosc wystapien, zobie to szybciej w ten sposob
        return TWynik;
    }



    public static List<List> TABpolaczenia(List<Integer> tabela){
        List<List> Wynik = new ArrayList<>() ;
        Set<Integer> tab = new HashSet<Integer>(tabela);

        for (int i: tab) {
            List<Integer> AktualnePunkty = new ArrayList<Integer>();
            AktualnePunkty.add(i);
            for (int j = 0; j < tabela.size() ; j+=2) {
                if (tabela.get(j) == i || tabela.get(j+1) == i){
                    if(tabela.get(j) == i){
                        AktualnePunkty.add(tabela.get(j+1));}
                    else{
                        AktualnePunkty.add(tabela.get(j));}
                }
            }
            Wynik.add(AktualnePunkty);
        }
        return Wynik;
    }



    public static Integer LPolaczenPunktu (int punkt, List<List> LIPO){
        List<Integer> wynik = new ArrayList<Integer>();
        for (List<Integer> i:LIPO) {
            if(i.get(0) == punkt){
                wynik = i.subList(1,i.size());
                break;
            }
        }
        return wynik.get(0);
    }



    public List<Integer> polaczeniaPunktu (int punkt, List<List> LPPtab1){
        List<Integer> wynik = new ArrayList<Integer>();
        for (List<Integer> i:LPPtab1) {
            if(i.get(0) == punkt){
                wynik = i.subList(1,i.size());
                break;
            }
        }
        return wynik;
    }



    public void Usuwanie(List<Integer>DoUsuniecia){
        Set<Integer> Tab_do_usuniecia = new HashSet<Integer>(DoUsuniecia);
        //int h = Tab_do_usuniecia.size();
        int zz = 0;
        //int k = 0;
        while (zz < tabelaN.size()) {
            for (Integer b : Tab_do_usuniecia) {
                if (tabelaN.subList(zz,zz+2).contains(b)){
                    //System.out.println(b);
                    //PunktyZaliczone.remove(b);
                    // To niedziala poniewaz mozemy nigdy nie wykryc punktu ktory usowamy
                    // np mamy 2 zaliczone pojedyncze punkty polaczone z soba
                    // z zaliczonych usunie tylko b, a z tablicy oba
                    tabelaN.remove(zz);
                    tabelaN.remove(zz);
                    zz -= 2;
                    break;
                    // Jesli trafimy na danym indexie na jedna z liczb np na indexie 2, najpierw zz-=2 czyli =0
                    //potem +=2 czyli = 2. Czyli sprawdzamy ten sam index wszystkimi liczbami z fora od nowa
                    //Bo teraz znajduja sie tu inne liczby
                    //k += 1;
                    //if (k == h) return;
                    //Nie da sie bardziej tego zoptymalizowac
                    //Nie mozna tego uzyc bo moze byc wiecej miejsc w tablicy gdzei trzeba usunac dana liczbe
                    //Niz samych liczb
                }
            }
            zz += 2;
        }
        for (Integer b : Tab_do_usuniecia) {
            PunktyZaliczone.remove(b);
        }
    }



    public void CzyPunktProstaLinia(List<Integer>Koncowki,List<List> LPPtab, List<List> LIPO){

        List<Integer> DoUsusniecia = new ArrayList<Integer>();
        List<Integer> JzTegoSamegoI =new ArrayList<Integer>();
        List<Integer> Punkty_vb =new ArrayList<Integer>();

        //outerloop:
        //uzywalem tego zanim zauwazylem ze mozemy przerabiac kilka koncowek na raz
        for (Integer p: Koncowki ) {

            List<Integer> PotencjalnePunktyZ1Routerem = new ArrayList<Integer>();
            Integer j = polaczeniaPunktu(p, LPPtab).get(0);
            // i ma jedno polaczenie czyli zawsze zwroci 1 liczbe
            List<Integer> PotencjalneDoUsusniecia = new ArrayList<Integer>();
            PotencjalneDoUsusniecia.add(j);
            PotencjalnePunktyZ1Routerem.add(j);
            int licznik = 0;
            if (JzTegoSamegoI.contains(j)){
                continue;
                //To znaczy ze trafilismy do tego samego j z innego punktu i
            }
            Integer Punkt_vb = null;
            Integer Punkt_x = null;

            for (int x : polaczeniaPunktu(j, LPPtab)) {
                int c = LPolaczenPunktu(x, LIPO);
                PotencjalneDoUsusniecia.add(x);

                if (c == 2) {
                    licznik += 1;
                    if(licznik == 2)break;

                    List<Integer> vb = new ArrayList<Integer>(List.copyOf(polaczeniaPunktu(x, LPPtab)));
                    vb.remove(j);
                    Punkt_vb = vb.get(0);

                    if (LPolaczenPunktu(Punkt_vb, LIPO) == 1){
                        PotencjalnePunktyZ1Routerem.add(Punkt_vb);
                        PotencjalneDoUsusniecia.add(Punkt_vb);
                        Punkt_x = x;

                        //DoUsusniecia.addAll(PotencjalneDoUsusniecia);
                        //Punkt_z_1_routerem.addAll(PotencjalnePunktyZ1Routerem);
                        //Było używane razem z outerloop:

                        //To znaczy ze mamy 4 punkty i jest to koncowka
                    }
                }
                else if (c > 2){
                    licznik += 2;
                    //jednak ten warunek byl potrzebny gdyby punkt j mial 1 polaczenie o LPP =2 i jedno ktore ma wiecej
                }
            }
            if (licznik == 1){
                DoUsusniecia.addAll(PotencjalneDoUsusniecia);
                JzTegoSamegoI.add(j);
                Punkty_vb.add(Punkt_vb);
                Punkt_z_1_routerem.addAll(PotencjalnePunktyZ1Routerem);

                if(Punkt_x != null)JzTegoSamegoI.add(Punkt_x);
                //Jesli to linia 4 polaczonych punktow to ponowne przejscie,
                // bez tego warunku da nam router w kazdym z 4 punktow
            }
        }
        //Mozna to zoptymalizowac sprawdzajac punktz 1 routerem zamist robic Jztegosamego I
        //ale tak jest bardziej czytelne

        Set<Integer> check = new HashSet<Integer>(DoUsusniecia);
        Set<Integer> Punkty_vb2 = new HashSet<Integer>(Punkty_vb);
        //Punkty vb to punkty x do ktorych przylaczona jest struktura
        Punkty_vb2.removeAll(check);

        Usuwanie(DoUsusniecia);
        Set<Integer> Punkty_tabelaN = new HashSet<Integer>(tabelaN);

        for ( Integer PunktGrupy : Punkty_vb2) {
            if(!Punkty_tabelaN.contains(PunktGrupy)){
                Punkt_z_1_routerem.add(PunktGrupy);
                // Zabezpiecza to przed prawie nie mozliwym przypadkiem, gdzie same struktury tej metody
                //są przyłączone do jednego punktu vb i przy procesie usówania, z względu na to jak
                //punkty sa przechowywane punkt vb zostaje usuniety pomimo braku wifi
            }
        }
    }



    public void CzyDwieLinie(List<Integer> Koncowki,List<List> LPPtab, List<List> LIPO){
        List<Integer> Potencjalne = new ArrayList<Integer>();
        // Tu przechowujemy punkty w których mogą być 2 routery

        List<Integer> JzTegoSamegoI = new ArrayList<Integer>();
        for (Integer i : Koncowki) {

            int j = polaczeniaPunktu(i, LPPtab).get(0);
            if(JzTegoSamegoI.contains(j))continue;

            JzTegoSamegoI.add(j);
            int licznik = 0;
            int Potencjalny_X =0;

            for (Integer x : polaczeniaPunktu(j, LPPtab)){
                if(LPolaczenPunktu(x, LIPO) > 1) {
                    //Dzieki temu zabezpieczamy sie przed tym ze j 1 punkt polaczony do x wstawi nam wiele routerow
                    licznik += 1;
                    if(licznik == 2) break;
                    Potencjalny_X= x;
                }
            }
            if(licznik == 1){
                Potencjalne.add(Potencjalny_X);
            }
        }

        List<Integer> Wynik = new ArrayList<Integer>();
        Set<Integer> Pot = new HashSet<Integer>(Potencjalne);
        for (Integer x : Pot){
            if (Collections.frequency(Potencjalne,x) > 1){
                Punkt_z_2_routerami.add(x);
                Wynik.add(x);
            }
        }
        Set<Integer> Zaliczone = new HashSet<Integer>();
        List<Integer> Pojedyncze_Punkty = new ArrayList<Integer>();

        for (Integer X0P : Wynik){
            List<Integer> X1 = new ArrayList<Integer>(polaczeniaPunktu(X0P, LPPtab));
            //X1 to lista punktow a X1P to 1 punkt, idziemy do X2 bo taki zasieg maja 2 routery
            for (Integer X1P : X1) {

                List<Integer> X2 = new ArrayList<Integer>(polaczeniaPunktu(X1P, LPPtab));
                if (X2.size() > 1){
                    // size = 1 oznacza ze punk wskazuje na punkt X0P
                    Zaliczone.addAll(X2);
                    Zaliczone.add(X1P);
                }
                else Pojedyncze_Punkty.addAll(X2);
                //Zapobiega to problemom z usowaniem pojedynczych punktow polaczonych do X1P
            }
            Zaliczone.remove(X0P);
            // Zeby punkt usuniety nie zostal w zaliczonych
        }
        PunktyZaliczone.addAll(Zaliczone);
        Wynik.addAll(Pojedyncze_Punkty);
        Usuwanie(Wynik);
    }



    public void Usowanie_pkt_z_wifi() {
        while (1 == 1) {
            /////////////////////////////////////////////////////////////////
            var LPPtab = Bajtazar.TABpolaczenia(tabelaN);
            var LIPO = Bajtazar.listaIlosciPolaczen(LPPtab);
            List<Integer> Koncowki = new ArrayList<Integer>();
            for (List<Integer> i:LIPO) {
                if(i.get(1) == 1) Koncowki.add(i.get(0));
            }

            List<Integer> Koncowki_z_Wifi = new ArrayList<Integer>(PunktyZaliczone);
            Koncowki_z_Wifi.retainAll(Koncowki);
            //Czesc wspolna zbiorow
            if(Koncowki_z_Wifi.size() == 0) break;
            /////////////////////////////////////////////////////////////////

            List<Integer> JzTegoSamegoI = new ArrayList<Integer>();
            for (Integer i : Koncowki_z_Wifi) {
                Integer j = polaczeniaPunktu(i, LPPtab).get(0);
                if (!JzTegoSamegoI.contains(j)) JzTegoSamegoI.add(j);
            }

            List<Integer> Srodek_Zaliczony = new ArrayList<Integer>(List.copyOf(JzTegoSamegoI));
            JzTegoSamegoI.removeAll(PunktyZaliczone);
            Srodek_Zaliczony.retainAll(PunktyZaliczone);

            Usuwanie(Koncowki_z_Wifi);

            // JzTegoSamegoI Zawiera teraz wszystkie punkty do ktorych byly podlaczone Koncowki_z_Wifi, ktore nie maja wifi
            for (Integer Srodek : JzTegoSamegoI) {
                if (!tabelaN.contains(Srodek)) {
                    // jesli nie ma punktu Srodek w tabelaN, oznacza to ze zostal usuniety w struktórze 3 punktow,
                    // gdzie 2 skrajne mialy wifi, albo 2 punktow, gdzie 1 z nich mial wifi. Dlatego dodajemy do niego 1 router
                    Punkt_z_1_routerem.add(Srodek);
                }
            }
            for (Integer Srodek_Z : Srodek_Zaliczony) {
                if (!tabelaN.contains(Srodek_Z)) {
                    // jesli nie ma punktu Srodek w tabelaN, oznacza to ze zostal usuniety w struktórze 3 punktow,
                    // tylko tu usowamy z punktow z wifi zamiast dac router
                    PunktyZaliczone.remove(Srodek_Z);
                }
            }
        }
    }



    public void CzyDwieLinieLX(List<Integer> Koncowki,List<List> LPPtab, List<List> LIPO){
        List<List> Punkty_X_J_o = new ArrayList<List>();
        List<Integer> JzTegoSamegoI = new ArrayList<Integer>();

        for (Integer i : Koncowki){
            // punkt i

            Integer j = polaczeniaPunktu(i, LPPtab).get(0);
            if (JzTegoSamegoI.contains(j)) continue;
            JzTegoSamegoI.add(j);

            int licznik1 = 0;
            int licznik2 = 0;
            Integer Mozliwy_X = 0;
            Integer Mozliwe_o = 0;
            // punkt j

            for (Integer o : polaczeniaPunktu(j, LPPtab)){
                Integer Liczba_Polaczen_o = LPolaczenPunktu(o, LIPO);
                if(Liczba_Polaczen_o > 1){
                    //punkt o
                    licznik1 += 1;
                    if (licznik1 > 1)break;
                    Mozliwe_o = o;

                    List<Integer> Lista_Mozliwych_X = new ArrayList<Integer>(List.copyOf(polaczeniaPunktu(o, LPPtab)));
                    Lista_Mozliwych_X.remove(j);
                    for (Integer X : Lista_Mozliwych_X){
                        Integer Liczba_Polaczen_X = LPolaczenPunktu(X, LIPO);
                        if (Liczba_Polaczen_X > 1){
                            // punkt X
                            licznik2 += 1;
                            if (licznik2 > 1)break;
                            Mozliwy_X = X;
                        }
                    }
                }
            }
            if (licznik1 == 1 && licznik2 == 1){
                List<Integer> XJo = new ArrayList<Integer>();
                XJo.add(Mozliwy_X);
                XJo.add(j);
                XJo.add(Mozliwe_o);
                // Kolejnosc punktow zgodna z nazwą
                Punkty_X_J_o.add(XJo);
            }
        }
        //System.out.println("Punkty X,J,o : " + Punkty_X_J_o);


        List<Integer> Lista_X = new ArrayList<>();
        List<Integer> Lista_J = new ArrayList<>();
        List<Integer> Lista_O = new ArrayList<>();
        for (List <Integer> XJo : Punkty_X_J_o){
            Lista_X.add(XJo.get(0));
            Lista_J.add(XJo.get(1));
            Lista_O.add(XJo.get(2));
        }

        List<Integer> Lista_Wykorzystanych_X = new ArrayList<>();
        //List<Integer> Lista_Wykorzystanych_J = new ArrayList<>();
        List<Integer> Lista_Wykorzystanych_O = new ArrayList<>();

        List<Integer> Do_Usuniecia = new ArrayList<>();
        for (List <Integer> XJo : Punkty_X_J_o){
            Integer Punkt_X = XJo.get(0);


            if (Collections.frequency(Lista_X,Punkt_X) > 1){
                if (!Lista_Wykorzystanych_X.contains(Punkt_X)) {
                    Lista_Wykorzystanych_X.add(Punkt_X);
                    Punkt_z_2_routerami.add(Punkt_X);

                    for (Integer Punkt_oddalony_o_1_od_X : polaczeniaPunktu(Punkt_X, LPPtab)){
                        PunktyZaliczone.addAll(polaczeniaPunktu(Punkt_oddalony_o_1_od_X, LPPtab));
                    }
                    PunktyZaliczone.addAll(polaczeniaPunktu(Punkt_X, LPPtab));
                }
                Punkt_z_1_routerem.add(XJo.get(1));
                //Przypadek stykania sie struktur w punkcie X
                Do_Usuniecia.addAll(polaczeniaPunktu(XJo.get(1), LPPtab));
                Do_Usuniecia.addAll(polaczeniaPunktu(XJo.get(2), LPPtab));
            }


            else{
                Integer Punkt_J = XJo.get(1);
                Integer Punkt_O = XJo.get(2);
                if (Lista_Wykorzystanych_O.contains(Punkt_X)){
                    Punkt_z_1_routerem.add(Punkt_J);
                    //Lista_Wykorzystanych_J.add(Punkt_J);
                    // nie potrzebna narazie lista wykorzystanych J

                    // Dla przypadku gdzie struktury nachodza na siebie z przesunieciem 1
                    //Sprawdzamy czy jest przesuniecie, czyli czy nasz X jest juz w wstawionych O
                    // jesli jest potrzebujemy tylko 1 router w punkcie J, jak nie idziemy dalej i wstawiamy do punktu O
                    Do_Usuniecia.addAll(polaczeniaPunktu(Punkt_J, LPPtab));
                    Do_Usuniecia.addAll(polaczeniaPunktu(Punkt_O, LPPtab));
                    //druga czesc do usuniecia dodal warunek wczesniej spelniony :
                    //else if (!Lista_Wykorzystanych_O.contains(Punkt_O))
                }


                else if (!Lista_Wykorzystanych_O.contains(Punkt_O)){
                    Punkt_z_2_routerami.add(Punkt_O);
                    Lista_Wykorzystanych_O.add(Punkt_O);
                    // Dla przypadku gdzie oba konce zaczynaja i wstawiaja punkt w punkcie O dwukrotnie
                    // zeby O nie zostalo ponownie wstawione przez inny poczatek
                    // inaczej kiedy j == x
                    // lub normalny przypadek
                    Do_Usuniecia.addAll(polaczeniaPunktu(Punkt_J, LPPtab));
                    Do_Usuniecia.addAll(polaczeniaPunktu(Punkt_O, LPPtab));
                    Do_Usuniecia.remove(Punkt_X);

                    PunktyZaliczone.add(Punkt_X);
                    PunktyZaliczone.addAll(polaczeniaPunktu(Punkt_X, LPPtab));

                    //Nowy warunek do sprawdzania poprzez czasami nie najlepsze rozwiązanie
                    Sprawdzenie_LX_Punkt_O.add(Punkt_O);
                }
                else if (Lista_Wykorzystanych_O.contains(Punkt_O)){
                    //warunek niepotrzebny ale daje dla zrozumienia kodu
                    Do_Usuniecia.addAll(polaczeniaPunktu(Punkt_J, LPPtab));
                    Do_Usuniecia.add(Punkt_J);
                    // dla przypadku j == x, musimy dodatkowo usunac kawalek Xz poprzedniego wykonania, czyli tutaj to j
                }
            }
        }
        //System.out.println("Lista X,J,o : " + Lista_X + Lista_J + Lista_O);
        Usuwanie(Do_Usuniecia);
    }



    public void Rozwiazanie_Koncowki(List<Integer> Koncowki,List<List> LPPtab, List<List> LIPO) {
        List<Integer> JzTegoSamegoI = new ArrayList<Integer>();
        List<Integer> Do_Usuniecia = new ArrayList<Integer>();

        for (Integer i : Koncowki){

            Integer j = polaczeniaPunktu(i, LPPtab).get(0);
            if (JzTegoSamegoI.contains(j)) continue;
            JzTegoSamegoI.add(j);


            if (LPolaczenPunktu(j, LIPO) == 1){
                Collections.addAll(Do_Usuniecia,i,j);
                Punkt_z_1_routerem.add(j);
                JzTegoSamegoI.add(i);
                // dodane zeby zaczynajac od i nie wstawilo tu routera 2 razy
                //   0-0
                continue;
            }

            int licznik = 0;
            int X = 0;
            for (Integer x : polaczeniaPunktu(j, LPPtab)){
                if (LPolaczenPunktu(x, LIPO) > 1){
                    licznik +=1;
                    X = x;
                    List<Integer> Lista_Xi = new ArrayList<Integer>(List.copyOf(polaczeniaPunktu(x, LPPtab)));
                    Lista_Xi.remove(j);

                    for (Integer ix : Lista_Xi){
                        if (LPolaczenPunktu(ix, LIPO) > 1) licznik += 1;
                    }
                }
            }
            if (licznik == 1){
                Punkt_z_2_routerami.add(j);
                Do_Usuniecia.addAll(polaczeniaPunktu(X, LPPtab));
                Do_Usuniecia.addAll(polaczeniaPunktu(j, LPPtab));
                JzTegoSamegoI.add(X);

            }
            else if (licznik == 0){
                Punkt_z_1_routerem.add(j);
                Do_Usuniecia.add(j);
                Do_Usuniecia.addAll(polaczeniaPunktu(j, LPPtab));
            }
        }
        Usuwanie(Do_Usuniecia);
    }



    public void Sprawdzenie_LX(){
        var LIPO = Bajtazar.listaIlosciPolaczen(Sprawdzenie_LX_LPP);
        //Sprawdzenie_LX_LPP

        for (Integer Punkt_O : Sprawdzenie_LX_Punkt_O){

            for(Integer Punkt_X : polaczeniaPunktu(Punkt_O, Sprawdzenie_LX_LPP)){
                if (Punkt_z_2_routerami.contains(Punkt_X)){
                    // mamy przypadek do zmiany Z 2 routerów w punkcie O do 1 w punkcjie J

                    List<Integer> Lista_Potencjalny_punkt_J = new ArrayList<>(List.copyOf(polaczeniaPunktu(Punkt_O, Sprawdzenie_LX_LPP)));
                    Lista_Potencjalny_punkt_J.remove(Punkt_X);

                    for (Integer Potencjalny_punkt_J : Lista_Potencjalny_punkt_J){
                        if (LPolaczenPunktu(Potencjalny_punkt_J, LIPO) > 1){
                            Punkt_z_1_routerem.add(Potencjalny_punkt_J);
                            Punkt_z_2_routerami.remove(Punkt_O);
                            // Dla przypadku z poznym rozponaniem metody dwie linie
                            System.out.println(Punkt_O);
                        }
                    }
                }
            }
        }
    }



    public List<List> Rozwiazanie_Bajtazar(){
        int Numer_Funkcji = 0;
//////////////////////////////////////
        List<List> Punkty = new ArrayList<>();
//////////////////////////////////////
        while (!tabelaN.isEmpty()){
//////////////////////////////////////
            Punkty.add(new ArrayList(List.copyOf(tabelaN)));
//////////////////////////////////////
            int Len_tableaN = tabelaN.size();
            //bedziemy sprawdzac po kazdej funkcji czy funkcja zmniejszyla rozmiar tabeli, inaczej
            // oznacza to ze sprawdzamy czy rozmiar sie zmniejszyl, jesli nie przechodzimy do kolejnej funkcji

            if(Numer_Funkcji == 0){
                var LPPtab = Bajtazar.TABpolaczenia(tabelaN);
                var LIPO = Bajtazar.listaIlosciPolaczen(LPPtab);
                List<Integer> Koncowki = new ArrayList<Integer>();
                for (List<Integer> i:LIPO) {
                    if(i.get(1) == 1){
                        Koncowki.add(i.get(0));
                    }
                }
                //////////////////////////////////////////////////////////
                System.out.println("\nCzyPunktProstaLinia");
                CzyPunktProstaLinia(Koncowki,LPPtab, LIPO);
                Usowanie_pkt_z_wifi();
                System.out.println("Size tabelaN : " + tabelaN.size());

                if (Wyswietl == 1){
                    System.out.println("1 Router :" + Punkt_z_1_routerem);
                    System.out.println("2 Routery : " + Punkt_z_2_routerami);
                    System.out.println("Pkt z wifi : " + PunktyZaliczone);
                    System.out.println("tabelaN : " + tabelaN);
                }

//                if (Len_tableaN == tabelaN.size() || Len_tableaN * 0.90 < tabelaN.size()){
//                    Numer_Funkcji += 1;
//                }
                if (Len_tableaN == tabelaN.size()){
                    Numer_Funkcji += 1;
                }
            }


            else if(Numer_Funkcji == 1){
                var LPPtab = Bajtazar.TABpolaczenia(tabelaN);
                var LIPO = Bajtazar.listaIlosciPolaczen(LPPtab);
                List<Integer> Koncowki = new ArrayList<Integer>();
                for (List<Integer> i:LIPO) {
                    if(i.get(1) == 1){
                        Koncowki.add(i.get(0));
                    }
                }
                //////////////////////////////////////////////////////////
                System.out.println("\nCzyDwieLinie");
                CzyDwieLinie(Koncowki,LPPtab, LIPO);
                Usowanie_pkt_z_wifi();
                System.out.println("Size tabelaN : " + tabelaN.size());

                if (Wyswietl == 1){
                    System.out.println("1 Router :" + Punkt_z_1_routerem);
                    System.out.println("2 Routery : " + Punkt_z_2_routerami);
                    System.out.println("Pkt z wifi : " + PunktyZaliczone);
                    System.out.println("tabelaN : " + tabelaN);
                }

                if (Len_tableaN == tabelaN.size()){
                    Numer_Funkcji += 1;
                }
                else{
                    Numer_Funkcji = 0;
                }
            }


            else if(Numer_Funkcji == 2){
                var LPPtab = Bajtazar.TABpolaczenia(tabelaN);
                var LIPO = Bajtazar.listaIlosciPolaczen(LPPtab);
                List<Integer> Koncowki = new ArrayList<Integer>();
                for (List<Integer> i:LIPO) {
                    if(i.get(1) == 1){
                        Koncowki.add(i.get(0));
                    }
                }
                //////////////////////////////////////////////////////////
                System.out.println("\nCzyDwieLinieLX");
                CzyDwieLinieLX(Koncowki,LPPtab, LIPO);
                Usowanie_pkt_z_wifi();
                System.out.println("Size tabelaN : " + tabelaN.size());

                if (Wyswietl == 1){
                    System.out.println("1 Router :" + Punkt_z_1_routerem);
                    System.out.println("2 Routery : " + Punkt_z_2_routerami);
                    System.out.println("Pkt z wifi : " + PunktyZaliczone);
                    System.out.println("tabelaN : " + tabelaN);
                }

                if (Len_tableaN == tabelaN.size()){
                    Numer_Funkcji += 1;
                }
                else{
                    Numer_Funkcji = 0;
                }
            }


            else if(Numer_Funkcji == 3){
                var LPPtab = Bajtazar.TABpolaczenia(tabelaN);
                var LIPO = Bajtazar.listaIlosciPolaczen(LPPtab);
                List<Integer> Koncowki = new ArrayList<Integer>();
                for (List<Integer> i:LIPO) {
                    if(i.get(1) == 1){
                        Koncowki.add(i.get(0));
                    }
                }
                //////////////////////////////////////////////////////////
                System.out.println("\nRozwiazanie_Koncowki");
                Rozwiazanie_Koncowki(Koncowki,LPPtab, LIPO);
                Usowanie_pkt_z_wifi();
                System.out.println("Size tabelaN : " + tabelaN.size());

                if (Wyswietl == 1){
                    System.out.println("1 Router :" + Punkt_z_1_routerem);
                    System.out.println("2 Routery : " + Punkt_z_2_routerami);
                    System.out.println("Pkt z wifi : " + PunktyZaliczone);
                    System.out.println("tabelaN : " + tabelaN);
                }

                if (Len_tableaN == tabelaN.size()){
                    Numer_Funkcji += 1;
                }
                else{
                    Numer_Funkcji = 0;
                }
            }


            else if(Numer_Funkcji == 4){
                System.out.println("\nThere is exception in structure, check it. Or you made a mistake in connecting points.");
                System.out.println("tabelaN : " + tabelaN);
                break;
            }
        }

        Sprawdzenie_LX();

        Collections.sort(Punkt_z_1_routerem);
        Collections.sort(Punkt_z_2_routerami);
        int Liczba_Routerow = Punkt_z_1_routerem.size() + Punkt_z_2_routerami.size()*2;
//        System.out.println("Punkt_z_1_routerem : " + Punkt_z_1_routerem + "\nPunkt_z_2_routerami : " + Punkt_z_2_routerami +
//                "\ntabelaN : " + tabelaN);
        System.out.println("\nCałkowita liczba Routerów : " + Liczba_Routerow);

        List<List> Dane = new ArrayList<List>();
        Dane.add(Punkt_z_1_routerem);
        Dane.add(Punkt_z_2_routerami);
        List<List> L_Routerow = new ArrayList<List>(Liczba_Routerow);
        Dane.add(L_Routerow);
        Dane.add(tabelaN);
        Dane.add(Punkty);
        return Dane ;
    }
}
