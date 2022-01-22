import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-korisnici',
  templateUrl: './korisnici.component.html',
  styleUrls: ['./korisnici.component.scss']
})
export class KorisniciComponent implements OnInit {

  korisnici : []

  constructor(public service : AuthentificationService, private router : Router) { }

  ngOnInit(): void {
    this.service.getUsers().subscribe(
      result=>{
        this.korisnici = result;
      }
    );
  }

  delete(id): void{
    this.service.deleteUser(id).subscribe(
      result=>{
        this.router.navigate(['/home-page-admin']);
      }
    );
  }

}
