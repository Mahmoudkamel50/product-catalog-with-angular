import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }



  sendSignUpData(data: any) {
    console.log(data);

    return this.http.post("http://localhost:9090/customers", data);
  }
}
