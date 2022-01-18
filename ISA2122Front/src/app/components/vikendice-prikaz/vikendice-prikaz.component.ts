import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Search } from 'src/app/models/search';
import { Vikendica } from 'src/app/models/vikendica';
import { VikendicaService } from 'src/app/services/vikendica.service';

@Component({
  selector: 'app-vikendice-prikaz',
  templateUrl: './vikendice-prikaz.component.html',
  styleUrls: ['./vikendice-prikaz.component.scss']
})
export class VikendicePrikazComponent implements OnInit {

  vikendice : any[];
  vikendicePravo: [];
  datum : string;

  constructor(private vikendicaService: VikendicaService, public router: Router) { }

  ngOnInit(): void {
    this.vikendicaService.getVikendice().subscribe(
      result => {
        console.log(result.body);
        this.vikendice = result.body;
        this.vikendicePravo = result.body;
      },
      error => {
        console.log(error);
      }
    );
    //console.log(this.vikendicaService.getVikendice());
  }

  detalji(id) : void{
    console.log(id);
    this.router.navigate(['/vikendica/'+id]);
  }

  onSearchChange(nesto : string) :void{
      console.log(nesto);
      if(nesto == "") {
        this.vikendice = this.vikendicePravo;
        return;
      }
      this.vikendice = [] as any;
      for(let i = 0 ; i < this.vikendicePravo.length; i++)
      {
          console.log(this.vikendicePravo[i]);
          var v = new Vikendica;
          v = this.vikendicePravo[i];
          if(v.naziv.includes(nesto) || v.adresa.includes(nesto))
          {
            this.vikendice.push(v);
          }
      }
  }

  dateChange(nesto: string){
    console.log(nesto);
  }

  onSubmit(form : NgForm){
    console.log(form.value.dateod);
    //form.value.ocena = form.value.ocena==''?0:form.value.ocena;
    var searchObj = new Search();
    searchObj.ocena = form.value.ocena==''?0:form.value.ocena;
    searchObj.datedo = form.value.datedo;
    searchObj.dateod = form.value.dateod;
    searchObj.lokacija = form.value.lokacija;
    console.log(searchObj);
    this.vikendicaService.getVikendiceSearch(searchObj.dateod, searchObj.datedo,searchObj.lokacija,searchObj.ocena).subscribe(
      result => {
        console.log(result);
        this.vikendice = result;
        this.vikendicePravo = result;
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
    if(this.datum == undefined) alert("Unesite datum da biste izvrsili rezervaciju");
    this.router.navigate(['/rezervacija/'+id+'/'+this.datum]); 
  }
}
