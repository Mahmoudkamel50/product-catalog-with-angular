import { Component , OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-products-details',
  templateUrl: './products-details.component.html',
  styleUrls: ['./products-details.component.css']
})
export class ProductsDetailsComponent implements OnInit {

  id:any;
  product:any = {}
  constructor(private route:ActivatedRoute,private service:ProductsService){
    this.id = route.snapshot.paramMap.get("id");
  }
  ngOnInit(): void {
    this.getProductById();
  }



  getProductById(){
    console.log(this.id);
    
    this.service.getProductById(this.id).subscribe((res:any) =>{
      console.log(res);
      
      this.product = res;
    })
  }
}
