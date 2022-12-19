import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from '../service/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  data = { name: "", phone: "", userName: "", password: "" };

  constructor(private service: SignupService, private router: Router) { }

  signUp(event: any) {
    event.preventDefault();

    this.service.sendSignUpData(this.data).subscribe((res: any) => {
      this.router.navigate([''])
    });
    alert("user created successfully")

  }






}
