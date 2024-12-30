import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../services/order.service";
import {Order} from "../../../modules/order.module";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-orders',
  templateUrl: './list-orders.component.html',
  styleUrl: './list-orders.component.css'
})
export class ListOrdersComponent implements OnInit{
  public orders : Array<Order> = []
  constructor(private orderService:OrderService,private route:Router) {
  }
  ngOnInit(): void {
  this.getOrders()
  }

  getOrders() {
    return this.orderService.getOrders().subscribe({
      next: (data) => {
        console.log(data);
        this.orders = data
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  handleEdit(id: String) {

  }

  handleDelete(id: String) {

  }

  handleView(id: String) {
    this.route.navigateByUrl(`/order-details/${id}`);
  }
}
