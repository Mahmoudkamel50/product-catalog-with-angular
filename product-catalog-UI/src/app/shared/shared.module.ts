import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from './nav/nav.component';
import { Router, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    NavComponent
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    RouterModule
  ],
  exports:[
    FormsModule,
    CommonModule,
    NavComponent,
    HttpClientModule,
    RouterModule
  ]
})
export class SharedModule { }
