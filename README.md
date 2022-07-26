# Algorithm-for-solving-placement-of-routers-in-mines

Here is code for algorithm in paper with same title as this repository, presented on ICAISC 2022

Name of variables and comments are made in polish.

You have to download Graphstream, you can do it throught Maven.

In main file you have this functions to operate (line 189-206):

        - Zapis_do_pliku_losowej_tablicy(n);
        Saves randomly genereted graph with "n" rooms into tmp file.
        
        - List<Integer> tabelaU = Odczyt_tablicyU_z_pliku();
        Reads from .tmp file to List
        
        - Start(tabelaU, x,y,z);
        Runs algorithm with given parameters:
        tabelaU - Table of connections for given grap for example [3, 1,2, 2,3] (first number is number of total nodes, it can be anything it doesent get used later on)
        x - Either 1 or 0, Shows process of solving graph in command line
        y - Either 1 or 0, Generates solved graph in GraphStream
        z - Either 1 or 0, Saves graph into 4K .png file (takes some time, if you don't generate graph this wont run.)
        
        - Step_by_step(tabelaU,x);
        Shows in Graphstream process of solving Graph step by step
        tabelaU - Table of connections for given grap for example [3, 1,2, 2,3] (first number is number of total nodes, it can be anything it doesent get used later on)
        x - Either 1 or 0, Shows process of solving graph in command line
        
        Generuj_dane(LEN, REPEAT);
        Generates data for how fast algorithm solved graph with "LEN" nodes, "REPEAT" times and saves it to Dane.txt
        For example :
        Generuj_dane(1000, 2);
        Dane.txt:
        1000	0.095
        1000	0.079
        
        
Some times for smaller graphs may varry with results from paper, because in this version List that is used by Step_by_step slows down a little bit process of solving graphs. If you want peak preformance (difference in ms) just delete those lines in Bajtazar.java
