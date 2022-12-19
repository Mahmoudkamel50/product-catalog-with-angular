import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    AllOrdersComponent
  ],
  imports: [
    CommonModule,
    OrdersRoutingModule,
    SharedModule
  ]
})
export class OrdersModule { }
