import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { RezervacijaService } from 'src/app/services/rezervacija.service';

@Component({
  selector: 'app-brze-rezervacije',
  templateUrl: './brze-rezervacije.component.html',
  styleUrls: ['./brze-rezervacije.component.scss']
})
export class BrzeRezervacijeComponent implements OnInit {

  rezervacije : [];
  id : string;

  constructor(private _Activatedroute:ActivatedRoute, private service: RezervacijaService, private authService: AuthentificationService, private router : Router) { }

  ngOnInit(): void {
    if(!this.authService.isKlijent())
      this.router.navigate(['/']);
    
    this.service.getRezervacije(1).subscribe(
      result => {
        console.log(result.body);
        this.rezervacije = result.body;
      },
      error => {
        //console.log(error);
      }
    );
    
  }

  rezervisi(idrez):void{
    this.service.rezervisi(idrez).subscribe(
      result => {
        console.log(result.body);
        this.rezervacije = result.body;
      },
      error => {
        //console.log(error);
      }
    );
  }
}
