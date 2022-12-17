import { Produit } from "./produit";

export interface Boutique {
    id : number; 
    nom : string;
    conge : boolean;
    dateCreation : Date;
    produit : Produit[];

}