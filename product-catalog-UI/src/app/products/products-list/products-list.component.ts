import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {
  constructor(private productsService: ProductsService) { }

  title: string = "products will appear here";
  products: any[] = [];
  categories: any[] = [];
  cart: any[] = [];

  ngOnInit(): void {
    this.getAllProducts();
    this.getAllCategories();

  }

  getAllProducts() {
    this.productsService.getAllProducts().subscribe((res: any) => {
      this.products = res;
    }, err => {
      alert(err.message)
    }
    );
  }

  getAllCategories() {
    this.productsService.getAllCategories().subscribe((res: any) => {
      console.log(res);

      this.categories = res;
    }, err => {
      alert(err.message)
    });
  }

  filterCategories(event: any) {
    let value = event.target.value;
    console.log(value, 'val');

    if (value == "all") {
      this.getAllProducts();
    }
    else {
      this.productsService.getProductsOfCategory(value).subscribe((res: any) => {
        console.log(this.products, res, "jjjj");

        this.products = res;
      });
    }

  }


  addToCart(event: any) {
    if ("cart" in localStorage) {
      this.cart = JSON.parse(localStorage.getItem("cart")!);
      let itemExist = this.cart.find(product => product.item.id === event.item.id)
      if (itemExist) {
        alert("this product is already in the cart")
      }
      else {
        this.cart.push(event);
        alert("item has been added to the cart")
        localStorage.setItem("cart", JSON.stringify(this.cart));
      }
    }
    else {
      this.cart.push(event);
      alert("item has been added to the cart")
      localStorage.setItem("cart", JSON.stringify(this.cart));
    }
  }

}
