import { DataSource } from '@angular/cdk/collections';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ZahtevReg } from 'src/app/models/zahtev';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ZahteviService } from 'src/app/services/zahtevi.service';
import { DialogComponent } from './dialog-component';

@Component({
  selector: 'app-zahtevi-registracija-prikaz',
  templateUrl: './zahtevi-registracija-prikaz.component.html',
  styleUrls: ['./zahtevi-registracija-prikaz.component.scss']
})
export class ZahteviRegistracijaPrikazComponent implements OnInit {

  matDialogRef: MatDialogRef<DialogComponent>;
  public dataSource = new MatTableDataSource<ZahtevReg>();
  zahtevi : ZahtevReg[];
  displayedColumns : string[];
  predefinisan : boolean;
  constructor(private zahteviService: ZahteviService, public router: Router,
    private regService : AuthentificationService, private matDialog: MatDialog) { 
    this.displayedColumns = ["email", "ime", "prezime", "adresa", "grad", "Obrazlozenje", "Prihvati", "Odbij"];
  }

  ngOnInit(): void {
    this.regService.checkIfPredefinisan().subscribe(
      result => {
        console.log(result);
        if (result)
          this.predefinisan = true;
        else
          this.predefinisan = false;
      },
      error => {
        console.log(error);
      }
    );

    this.requestTable();
  }

  requestTable() : void {
    this.zahteviService.getZahtevi().subscribe(
      result => {
        console.log(result);
        this.zahtevi = result;
        this.dataSource.data = result;
      },
      error => {
        console.log(error);
      }
    );
  }

  clickObrazlozenje(obrazlozenje: any) {
    this.matDialogRef = this.matDialog.open(DialogComponent, {
      data: obrazlozenje,
      disableClose: true
    });
 }

  itemclick(token: any) {
    this.regService.confirmRegistration(token).subscribe(
      result => {
        console.log(result);
        this.requestTable();
      },
      error => {
        this.requestTable();
      }
    );
 }

 itemclickReject(token: any) {
  this.regService.rejectRegistration(token).subscribe(
    result => {
      console.log(result);
      this.requestTable();
    },
    error => {
      this.requestTable();
    }
  );
}

}
