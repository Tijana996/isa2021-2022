import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from './services/authentification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ISA2122 Front';
  constructor(private authService: AuthentificationService,
    private router: Router){}

  ngOnInit(): void {
    if(this.authService.isLoggedIn())
      this.router.navigate(['/home-page-user']); 
  }

  loggedIn():boolean{
    if(this.authService.isLoggedIn()){
      return true;
    }
    return false;
  }

  logout():void{
    this.authService.logout();
    this.router.navigate(['']);
  }
}