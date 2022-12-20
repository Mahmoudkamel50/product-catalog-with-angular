import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent {

 @Input() data:any = {}
 @Output() item=new EventEmitter();
 addButton:boolean = false;
  amount:number=1;
  constructor(){}

  add(){
    this.item.emit({item:this.data,quantity:this.amount})
  }
}
