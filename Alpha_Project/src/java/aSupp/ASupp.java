/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aSupp;

import alpha.entite.model.Categorie;
import alpha.entite.model.Modele;
import alpha.metier.modelManager.CategorieManager;
import alpha.metier.modelManager.ModeleManager;

/**
 *
 * @author INTI0224
 */
public class ASupp {

    public static void main(String[] args) {
        CategorieManager categorieManager = new CategorieManager();
        ModeleManager modeleManager = new ModeleManager();

        Modele model;
        Categorie cat;
        
        model = modeleManager.getById(1);
        cat = categorieManager.getById(1);
        model.getCategories().add(cat);
        modeleManager.update(model);
        
        model = modeleManager.getById(2);
        cat = categorieManager.getById(1);
        model.getCategories().add(cat);
        modeleManager.update(model);
        
        model = modeleManager.getById(3);
        cat = categorieManager.getById(1);
        model.getCategories().add(cat);
        modeleManager.update(model);
        
        model = modeleManager.getById(4);
        cat = categorieManager.getById(2);
        model.getCategories().add(cat);
        modeleManager.update(model);
        

    }
}
