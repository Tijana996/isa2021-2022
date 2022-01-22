import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Rezervacija } from 'src/app/models/rezervacija';
import { AuthentificationService } from 'src/app/services/authentification.service';
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
  klijent : boolean;
  rezervacijaZa : string;

  constructor(private serviceAuth: AuthentificationService,private fb: FormBuilder, private route : Router, private _Activatedroute:ActivatedRoute, private service: RezervacijaService) { }

  ngOnInit(): void {
    this.klijent = this.serviceAuth.isKlijent();
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    this.rezervacijaZa = this._Activatedroute.snapshot.paramMap.get("comp");
    this.datumod = this._Activatedroute.snapshot.paramMap.get("datum");
    console.log(this.datumod);
    console.log(this.id);
    if(this.rezervacijaZa == "vikendica"){
      this.rezervacijaForm = this.fb.group({
        'start':this.datumod,
        'end':[''],
        'brgostiju':[''],
        'brdana':[''],
        'klijenti':[''],
        'vikendice':this.id
      });  
    }
    
    if(this.rezervacijaZa == "instruktor"){
      this.rezervacijaForm = this.fb.group({
        'start':this.datumod,
        'end':[''],
        'brgostiju':[''],
        'brdana':[''],
        'klijenti':[''],
        'instruktor':this.id
      });  
    }  

    if(this.rezervacijaZa == "brod"){
      this.rezervacijaForm = this.fb.group({
        'start':this.datumod,
        'end':[''],
        'brgostiju':[''],
        'brdana':[''],
        'klijenti':[''],
        'brodovi':this.id
      });  
    }  
  }


  onSubmit(){
    var rez = new Rezervacija();

    console.log(this.rezervacijaForm)
    if(this.rezervacijaZa == "vikendica")
    {
      var vikendice = this.rezervacijaForm.controls['vikendice'].value;
      rez.vikendice = vikendice;
    }
    if(this.rezervacijaZa == "brod")
    {
      var brodovi = this.rezervacijaForm.controls['brodovi'].value;
      rez.brodovi = brodovi;
    }
    if(this.rezervacijaZa == "instruktor")
    {
      var instruktor = this.rezervacijaForm.controls['instruktor'].value;
      rez.instruktor = instruktor;
    }
    var end = this.rezervacijaForm.controls['end'].value;
    var brgostiju = this.rezervacijaForm.controls['brgostiju'].value;
    var brdana = this.rezervacijaForm.controls['brdana'].value;
    var start = this.rezervacijaForm.controls['start'].value;
    var klijenti = this.rezervacijaForm.controls['klijenti'].value;

    var currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');
    rez.start = start;
    rez.end = end;
    rez.brdana = brdana;
    rez.brgostiju = brgostiju;
    rez.klijenti = currentUser.id;

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
