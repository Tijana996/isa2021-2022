import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RezervacijaService } from 'src/app/services/rezervacija.service';

@Component({
  selector: 'app-rezervacije',
  templateUrl: './rezervacije.component.html',
  styleUrls: ['./rezervacije.component.scss']
})
export class RezervacijeComponent implements OnInit {

  rezervacije : [];
  id : string;

  constructor(private _Activatedroute:ActivatedRoute, private service: RezervacijaService) { }

  ngOnInit(): void {
    
    this.service.getRezervacije(0).subscribe(
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
