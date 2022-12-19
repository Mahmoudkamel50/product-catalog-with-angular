import { Injectable } from "@angular/core";
import { CanActivate } from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class OrdersGuard implements CanActivate {


    canActivate(): boolean {
        return true;
    }

}