import { Categorie } from "./categorie";

export interface Produit {
    id : number;
    nom : string;
    description: string;
    prix: number;
    quantite: number;
    categorieSet : Categorie[];

}