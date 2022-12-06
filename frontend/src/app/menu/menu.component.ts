import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from '../services/token.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isLogged = false;
  roles: string[] = [];
  persona: any = null;
  correo = '';
  isAdmin = false;
  isVendedor = false;

  constructor(
    private tokenService: TokenService,
    private router: Router) { }

  ngOnInit() {
    if (this.tokenService.getToken()) {
      this.isLogged = true;
      this.correo = this.tokenService.getUserName();
    } else {
      this.isLogged = false;
    }
    this.roles = this.tokenService.getAuthorities();
  }

  onLogOut(): void {
    this.tokenService.logOut();
    window.location.reload();
    this.router.navigate(['/']);
  }

}
