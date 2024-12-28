import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProductsComponent} from "./components/products/list-products/list-products.component";
import {AuthGuard} from "./guards/auth.guard";

const routes: Routes = [
  {path:'products',component:ListProductsComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
