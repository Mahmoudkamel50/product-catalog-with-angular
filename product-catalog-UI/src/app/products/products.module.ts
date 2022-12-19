import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ProductCardComponent } from './product-card/product-card.component';
import { ProductsDetailsComponent } from './products-details/products-details.component';
import { SharedModule } from '../shared/shared.module';
import { ProductsListComponent } from './products-list/products-list.component';
import { ProductsComponent } from './products.component';


@NgModule({
  declarations: [
    ProductsComponent,
    ProductCardComponent,
    ProductsDetailsComponent,
    ProductsListComponent

  ],
  imports: [
    SharedModule,
    ProductsRoutingModule,
  ]
})
export class ProductsModule {


}
