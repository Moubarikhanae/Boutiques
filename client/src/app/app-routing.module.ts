import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieListComponent } from './components/categorie-list/categorie-list.component';
import { CreateCategorieComponent } from './components/create-categorie/create-categorie.component';

const routes: Routes = [
  {path: "categories-list", component: CategorieListComponent},
  {path: "create-categorie", component: CreateCategorieComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
