import {Product} from "./product.module";

export interface Order {
  id:String;
  date:Date;
  state:String;
  productItemList:ProductItem[];
}

export interface ProductItem {
  id:number;
  productId:String;
  quantity:number;
  price:number;
  product:Product;
}
