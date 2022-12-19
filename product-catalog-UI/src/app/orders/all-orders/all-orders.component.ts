import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css']
})
export class AllOrdersComponent implements OnInit {

  constructor(private service: OrderService) {

  }


  orders: any[] = []

  ngOnInit(): void {
    this.getAllOrders();
  }

  getAllOrders() {
    this.service.getAllProducts().subscribe((res: any) => {
      this.orders = res;
    })
  }
}
