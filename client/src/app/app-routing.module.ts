import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieDetailsComponent } from './components/categorie-details/categorie-details.component';
import { CategorieListComponent } from './components/categorie-list/categorie-list.component';
import { CategorieUpdateComponent } from './components/categorie-update/categorie-update.component';
import { CreateCategorieComponent } from './components/create-categorie/create-categorie.component';

const routes: Routes = [
  {path: "categories-list", component: CategorieListComponent},
  {path: "create-categorie", component: CreateCategorieComponent},
  { path: 'update-categorie/:id', component: CategorieUpdateComponent },
  { path: 'details-categorie/:id', component: CategorieDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
