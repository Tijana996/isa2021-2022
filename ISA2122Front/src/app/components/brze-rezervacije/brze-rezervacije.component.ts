import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RezervacijaService } from 'src/app/services/rezervacija.service';

@Component({
  selector: 'app-brze-rezervacije',
  templateUrl: './brze-rezervacije.component.html',
  styleUrls: ['./brze-rezervacije.component.scss']
})
export class BrzeRezervacijeComponent implements OnInit {

  rezervacije : [];
  id : string;

  constructor(private _Activatedroute:ActivatedRoute, private service: RezervacijaService) { }

  ngOnInit(): void {
    console.log("dhdka");
    
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
}
