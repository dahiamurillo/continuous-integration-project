import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from '../services/token.service';


@Injectable({
  providedIn: 'root'
})
export class UsersGuardService implements CanActivate {

  realRol= '';

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRol = route.data['expectedRol'];
    const roles = this.tokenService.getAuthorities();
    this.realRol = 'user';
    roles.forEach(rol =>{
      if(rol === 'ROL_ADMIN'){
        this.realRol = 'admin';
      }else if(rol === 'ROL_USUARIO'){
        this.realRol = 'usuario';
      }
    });
    if(!this.tokenService.getToken() || expectedRol.indexOf(this.realRol) === -1){
      this.router.navigate(['/']);
      return false;
    }
    return true;
  }
}