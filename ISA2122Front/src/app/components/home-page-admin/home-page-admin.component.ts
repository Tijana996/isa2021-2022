import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-home-page-admin',
  templateUrl: './home-page-admin.component.html',
  styleUrls: ['./home-page-admin.component.scss']
})
export class HomePageAdminComponent implements OnInit {

  predefinisan : boolean;

  constructor(public router: Router,
    private regService : AuthentificationService,) { }

  ngOnInit(): void {
    this.regService.checkIfPredefinisan().subscribe(
      result => {
        console.log(result);
        if (result)
          this.predefinisan = true;
        else
          this.predefinisan = false;
      },
      error => {
        console.log(error);
      }
    );
  }

}
