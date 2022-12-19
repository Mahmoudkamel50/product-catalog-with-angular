import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  data = {userName:"",pass:""}


  constructor(private service:LoginService,private router:Router){}


  signIn(event:any){
    event.preventDefault();
    this.service.login(this.data).subscribe((res:any) => {
      alert("login successfully")
      this.router.navigate(['']);
    },
    (error:any) => {
      alert("please check your data again")
    }
    );
  }
}
