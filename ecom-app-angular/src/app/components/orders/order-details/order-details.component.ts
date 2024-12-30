import {Component, OnInit} from '@angular/core';
import {OrderService} from "../../../services/order.service";
import {ActivatedRoute} from "@angular/router";
import {Order, ProductItem} from "../../../modules/order.module";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrl: './order-details.component.css'
})
export class OrderDetailsComponent implements OnInit{
  orderId!:string;
  orderItems!: Array<ProductItem>;
  order!:Order;
  constructor(private orderService:OrderService,private activatedRoute:ActivatedRoute) {
  }
  ngOnInit(): void {
    this.orderId = this.activatedRoute.snapshot.params['id'];
    this.getOrder()
  }

  getOrder() {
    this.orderService.getOrder(this.orderId).subscribe({
      next: (data) => {
        console.log(data);
        this.order = data
        this.orderItems = data.productItemList
      },
      error: (e) => console.error(e),
      complete: () => console.info('complete')
    });
  }

}
