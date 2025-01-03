import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListProductsComponent} from "./components/products/list-products/list-products.component";
import {AuthGuard} from "./guards/auth.guard";
import {ListOrdersComponent} from "./components/orders/list-orders/list-orders.component";
import {OrderDetailsComponent} from "./components/orders/order-details/order-details.component";

const routes: Routes = [
  {path:'products',component:ListProductsComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path:'orders',component:ListOrdersComponent,canActivate:[AuthGuard]},
  {path:'order-details/:id',component:OrderDetailsComponent,canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
