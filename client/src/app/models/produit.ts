import { Categorie } from "./Categorie";

export interface Produit {
    id : number;
    nom : string;
    description: string;
    prix: number;
    quantite: number;
    categorie : Categorie;

}