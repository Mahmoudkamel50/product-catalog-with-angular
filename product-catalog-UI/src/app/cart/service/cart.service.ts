import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) { }




  placeOrder(order: any) {
    return this.http.post("http://localhost:9090/orders", order);
  }
}
