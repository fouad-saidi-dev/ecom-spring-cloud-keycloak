import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Product} from "../modules/product.module";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  public getProducts():Observable<Array<Product>>{
    return this.http.get<Array<Product>>(`${environment.baseUrl}/products`);
  }
}
