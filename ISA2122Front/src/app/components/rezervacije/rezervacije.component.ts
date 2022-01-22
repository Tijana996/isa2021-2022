import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { RezervacijaService } from 'src/app/services/rezervacija.service';
import { DialogZalbaComponent } from './dialog-zalba-component';

@Component({
  selector: 'app-rezervacije',
  templateUrl: './rezervacije.component.html',
  styleUrls: ['./rezervacije.component.scss']
})
export class RezervacijeComponent implements OnInit {

  rezervacije : [];
  id : string;
  matDialogRef: MatDialogRef<DialogZalbaComponent>;

  constructor(private _Activatedroute:ActivatedRoute, private service: RezervacijaService, private authService : AuthentificationService, private matDialog: MatDialog, private router: Router) { }

  ngOnInit(): void {
    
    if(!this.authService.isKlijent())
      this.router.navigate(['/']);

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

  napisiZalbu(rezervacija):void{
    this.matDialogRef = this.matDialog.open(DialogZalbaComponent, {
      data: rezervacija,
      disableClose: true
    });
  }
  
  otkazi(id):void{
    
  }

}
