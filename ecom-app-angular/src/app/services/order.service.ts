import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../modules/order.module";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  baseUrl:string="http://localhost:8082/api/orders";
  constructor(private http: HttpClient) { }

  public getOrders():Observable<Array<Order>> {
    return this.http.get<Array<Order>>(`${this.baseUrl}`);
  }

  public getOrder(id:string):Observable<Order> {
    return this.http.get<Order>(`${this.baseUrl}/${id}`);
  }
}
