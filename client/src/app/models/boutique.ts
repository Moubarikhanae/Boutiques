import { Ouverture } from "./ouverture";
import { Produit } from "./produit";

export class Boutique {
    id : number; 
    nom : string;
    conge : boolean;
    dateCreation : Date;
    produit : Produit[];
    ouvertures: Ouverture[];

}