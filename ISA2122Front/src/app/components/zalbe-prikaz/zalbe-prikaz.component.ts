import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Zalba } from 'src/app/models/zalba';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ZahteviService } from 'src/app/services/zahtevi.service';
import { ZalbaService } from 'src/app/services/zalba.service';
import { DialogComponent } from '../zahtevi-registracija-prikaz/dialog-component';
import { DialogOdgovorComponent } from './dialog-odgovor-component';

@Component({
  selector: 'app-zalbe-prikaz',
  templateUrl: './zalbe-prikaz.component.html',
  styleUrls: ['./zalbe-prikaz.component.scss']
})
export class ZalbePrikazComponent implements OnInit {

  matDialogRef: MatDialogRef<DialogComponent>;
  matDialogRefOdgovor: MatDialogRef<DialogOdgovorComponent>;
  public dataSource = new MatTableDataSource<Zalba>();
  zalbe : Zalba[];
  displayedColumns : string[];
  predefinisan : boolean;
  constructor(private zalbaService: ZalbaService, public router: Router,
    private regService : AuthentificationService, private matDialog: MatDialog) { 
    this.displayedColumns = ["id", "idrezervacije", "tip", "imeKlijenta", "prezimeKlijenta", "emailKlijenta", "imeOptuzenog", "prezimeOptuzenog", "emailOptuzenog", "Prihvati", "Odbij"];
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
    this.zalbaService.getZalbe().subscribe(
      result => {
        console.log(result);
        this.zalbe = result;
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

  itemclick(zalba: any) {
    this.matDialogRefOdgovor = this.matDialog.open(DialogOdgovorComponent, {
      data: zalba,
      disableClose: true
    });
    this.matDialogRefOdgovor.afterClosed().subscribe(() => {
      // Do stuff after the dialog has closed
      this.requestTable();
  });
    
 }
}
