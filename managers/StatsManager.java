package com.mycompany.projetjava.managers;

import com.mycompany.projetjava.Categorie;
import com.mycompany.projetjava.StatisticStrategy;

public class StatsManager {

    private StatisticStrategy strategy;

    public StatsManager(StatisticStrategy strategy) {
        this.strategy = strategy;
    }

    public void process(int mois, int annee, Categorie[] TabCat, int NbCat) {
        strategy.generateStatistics( mois,  annee,  TabCat,  NbCat);
    }
}