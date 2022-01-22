import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ZahteviZaBrisanjeService } from 'src/app/services/zahtevizabrisanje.service';

@Component({
  selector: 'app-zahtevi-brisanje-naloga',
  templateUrl: './zahtevi-brisanje-naloga.component.html',
  styleUrls: ['./zahtevi-brisanje-naloga.component.scss']
})
export class ZahteviBrisanjeNalogaComponent implements OnInit {

  zahtevi : [];

  constructor(private zahteviService: ZahteviZaBrisanjeService, private router: Router) { }

  ngOnInit(): void {
    this.zahteviService.getZahtevi().subscribe(
      result => {
        this.zahtevi = result;
      },
      error => {
        console.log(error);
      }
    );
  }

  delete(id): void{
    this.zahteviService.deleteZahtev(id).subscribe(
      result => {
        //alert(result.body);
        this.router.navigate(['/home-page-admin']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
