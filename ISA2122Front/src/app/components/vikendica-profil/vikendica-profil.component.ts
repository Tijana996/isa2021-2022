import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Vikendica } from 'src/app/models/vikendica';
import { VikendicaService } from 'src/app/services/vikendica.service';

@Component({
  selector: 'app-vikendica-profil',
  templateUrl: './vikendica-profil.component.html',
  styleUrls: ['./vikendica-profil.component.scss']
})
export class VikendicaProfilComponent implements OnInit {
  
  id : {} ;
  vikendica: Vikendica;
  vikendicaForm: FormGroup;


  constructor(private fb: FormBuilder, private _Activatedroute:ActivatedRoute, private vikendicaService: VikendicaService,) { }

  ngOnInit(): void {
    this.vikendicaForm = this.fb.group({
      'naziv':[''],
      'opis':[''],
      'sobe':[''],
      'kreveti':[''],
      'pravila':[''],
      'cenovnik':[''],
      'maxosoba':[''],
      'adresa':[''],
      'ocena':['']
    })
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    //console.log(this.id);
    this.vikendicaService.getVikendica(this.id).subscribe(
      result => {
        console.log(result.body);
        this.vikendica = result.body;
        this.vikendicaForm.patchValue({
          'naziv' : this.vikendica.naziv,
          'opis':this.vikendica.opis,
          'sobe':this.vikendica.sobe,
          'kreveti':this.vikendica.kreveti,
          'pravila':this.vikendica.pravila,
          'cenovnik':this.vikendica.cenovnik,
          'maxosoba':this.vikendica.maxosoba,
          'adresa':this.vikendica.adresa,
          'ocena':this.vikendica.ocena
        });
      },
      error => {
        console.log(error);
      }
    );

  }

  onSubmit(): void{}

}
