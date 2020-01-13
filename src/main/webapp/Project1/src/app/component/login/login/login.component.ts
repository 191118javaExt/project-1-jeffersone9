import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user/user.service';
import { User } from '../../../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';

  constructor(private us: UserService, private route: Router) { }

  ngOnInit() {
  }

  sendLogin() {
    this.us.login(this.username, this.password).subscribe(
      (response: User) => {
        sessionStorage.setItem('currentUser', JSON.stringify(response));
        console.log(response);
        this.route.navigate(['/profile']);
      }
    )
  }
}
