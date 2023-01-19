import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AcceuilComponent } from './components/acceuil/acceuil/acceuil.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { AjoutBoutiqueComponent } from './components/dialogs/ajoutBoutique/ajout-boutique/ajout-boutique.component';
import { AjoutCategorieComponent } from './components/dialogs/ajoutCategorie/ajout-categorie/ajout-categorie.component';
import { AjoutProduitComponent } from './components/dialogs/ajoutProduit/ajout-produit/ajout-produit.component';

const routes: Routes = [
  {
    path: 'acceuil',
    component: AcceuilComponent
  },
  {
    path: 'boutique',
    component: BoutiqueComponent
  },
  {
    path: 'ajoutBoutique',
    component: AjoutBoutiqueComponent
  },
  {
    path: 'ajoutProduit',
    component: AjoutProduitComponent,
  },
  {
    path: 'ajoutCategorie',
    component: AjoutCategorieComponent,
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
