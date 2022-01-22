import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-home-page-user',
  templateUrl: './home-page-user.component.html',
  styleUrls: ['./home-page-user.component.scss']
})
export class HomePageUserComponent implements OnInit {

  constructor(private service: AuthentificationService, private router: Router) { }

  ngOnInit(): void {
    if(!this.service.isKlijent())
      this.router.navigate(['/']);
  }

}
