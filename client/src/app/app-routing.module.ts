import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieDetailsComponent } from './components/categorie-details/categorie-details.component';
import { CategorieListComponent } from './components/categorie-list/categorie-list.component';
import { CategorieUpdateComponent } from './components/categorie-update/categorie-update.component';
import { CreateCategorieComponent } from './components/create-categorie/create-categorie.component';
import { CreateProduitComponent } from './components/create-produit/create-produit.component';
import { ListProduitsComponent } from './components/list-produits/list-produits.component';

const routes: Routes = [
  {path: "categories-list", component: CategorieListComponent},
  {path: "create-categorie", component: CreateCategorieComponent},
  { path: 'update-categorie/:id', component: CategorieUpdateComponent },
  { path: 'details-categorie/:id', component: CategorieDetailsComponent },
  { path: 'produits-list', component: ListProduitsComponent },
  { path: 'create-produit/:id', component: CreateProduitComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
