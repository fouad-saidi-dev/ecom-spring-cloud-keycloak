import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {Product} from "../../../modules/product.module";

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrl: './list-products.component.css'
})
export class ListProductsComponent implements OnInit{
  public products:Array<Product> = [];
  constructor(private productService:ProductService) {
  }
  ngOnInit(): void {
  this.getProducts()
  }

  public getProducts(){
    this.productService.getProducts().subscribe({
      next:(data)=>{
        this.products = data
        console.log("Products ==>",data);
      },
      error:(err)=>{
        console.log(err);
      }
    })
  }

  deleteProduct(id: string) {
    
  }

  handleEdit(id: string) {
    
  }
}
