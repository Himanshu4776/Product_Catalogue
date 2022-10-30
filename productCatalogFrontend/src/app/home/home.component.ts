import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCatalogService } from '../services/product-catalog.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private productCatalog:ProductCatalogService,private router:Router) { }

  ngOnInit(): void {
  }

  logcheck() {
    return this.productCatalog.isLoggedIn();
  }

  goToProductSearch() {
    this.router.navigate(['/productgrid']);
  }
}
