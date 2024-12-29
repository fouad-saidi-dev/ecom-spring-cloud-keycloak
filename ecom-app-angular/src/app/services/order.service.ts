import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../modules/order.module";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  public getOrders():Observable<Array<Order>> {
    return this.http.get<Array<Order>>("http://localhost:8082/api/orders");
  }
}
