import { Categorie } from "./categorie";

export class Produit {
    id : number;
    nom : string;
    description: string;
    prix: number;
    quantite: number;
    categorieSet : Categorie[];

}