import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Rezervacija } from 'src/app/models/rezervacija';
import { RezervacijaService } from 'src/app/services/rezervacija.service';
import { VikendicaService } from 'src/app/services/vikendica.service';

@Component({
  selector: 'app-vikendica-rezervacija',
  templateUrl: './vikendica-rezervacija.component.html',
  styleUrls: ['./vikendica-rezervacija.component.scss']
})
export class VikendicaRezervacijaComponent implements OnInit {

  id : string;
  datumod : string;
  rezervacijaForm : FormGroup;

  constructor(private fb: FormBuilder, private route : Router, private _Activatedroute:ActivatedRoute, private service: RezervacijaService) { }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.datumod = this._Activatedroute.snapshot.paramMap.get("datum");
    console.log(this.datumod);
    console.log(this.id);
    this.rezervacijaForm = this.fb.group({
      'start':this.datumod,
      'end':[''],
      'brgostiju':[''],
      'brdana':[''],
      'klijenti':[''],
      'vikendice':this.id
    })    
  }

  onSubmit(){
    var end = this.rezervacijaForm.controls['end'].value;
    var brgostiju = this.rezervacijaForm.controls['brgostiju'].value;
    var brdana = this.rezervacijaForm.controls['brdana'].value;
    var start = this.rezervacijaForm.controls['start'].value;
    var klijenti = this.rezervacijaForm.controls['klijenti'].value;
    var vikendice = this.rezervacijaForm.controls['vikendice'].value;

    var currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');
    var rez = new Rezervacija();
    rez.start = start;
    rez.end = end;
    rez.brdana = brdana;
    rez.brgostiju = brgostiju;
    rez.klijenti = currentUser.id;
    rez.vikendice = vikendice;

    this.service.addRezervacija(rez).subscribe( 
      result => {
        this.route.navigate(['/']);
      },        
      (err:Error) =>{
        console.log(err);
      });
    

    console.log(currentUser.id);
  }


}
