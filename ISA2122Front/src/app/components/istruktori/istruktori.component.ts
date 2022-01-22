import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Instruktor } from 'src/app/models/instruktor';
import { Search } from 'src/app/models/search';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { InstruktorService } from 'src/app/services/instruktor.service';

@Component({
  selector: 'app-istruktori',
  templateUrl: './istruktori.component.html',
  styleUrls: ['./istruktori.component.scss']
})
export class IstruktoriComponent implements OnInit {

  klijent : {};
  instruktori : [];
  instruktoriPravo : [];
  datum : string;

  constructor(private service : AuthentificationService, private instruktorService: InstruktorService, private router : Router) { }

  ngOnInit(): void {
    this.klijent = this.service.isKlijent();
    this.instruktorService.getInstruktori().subscribe(
      result => {
        console.log(result.body);
        this.instruktori = result.body;
        this.instruktoriPravo = result.body;
      },
      error => {
        console.log(error);
      }
    );
  }

  detalji(id) : void{
    console.log(id);
    this.router.navigate(['/instruktor/'+id]);
  }

  onSearchChange(nesto : string) :void{
      console.log(nesto);
      if(nesto == "") {
        this.instruktori = this.instruktoriPravo;
        return;
      }
      this.instruktori = [] as any;
      for(let i = 0 ; i < this.instruktoriPravo.length; i++)
      {
          console.log(this.instruktoriPravo[i]);
          var v ;//= new Instruktor;
          v = this.instruktoriPravo[i];
          if(v.ime.includes(nesto) || v.prezime.includes(nesto) || v.lokacija.includes(nesto))
          {
            this.instruktori.push(v);
          }
      }
  }

  onSubmit(form : NgForm){
    console.log(form.value.dateod);
    //form.value.ocena = form.value.ocena==''?0:form.value.ocena;
    var searchObj = new Search();
    searchObj.ocena = form.value.ocena=='' || form.value.ocena==null?0:form.value.ocena;
    searchObj.datedo = form.value.datedo;
    searchObj.dateod = form.value.dateod;
    searchObj.lokacija = form.value.lokacija;
    console.log(searchObj);
    this.instruktorService.getInstruktorSearch(searchObj.dateod, searchObj.datedo,searchObj.lokacija,searchObj.ocena).subscribe(
      result => {
        console.log(result);
        this.instruktori = result;
        this.instruktoriPravo = result;
      },
      error => {
        //console.log(error);
      }
    );
  }

  setDatum(datum : string){
    this.datum = datum;
  }

  rezervisi(id:number){
    console.log(id);
    console.log(this.datum);
    if(this.datum == undefined) 
    {
      alert("Unesite datum da biste izvrsili rezervaciju");
      return;
    }
    this.router.navigate(['/rezervacija/instruktor/'+id+'/'+this.datum]); 
  }
}
