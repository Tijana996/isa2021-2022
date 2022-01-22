import { ThrowStmt } from "@angular/compiler";
import { Component, Input, Inject } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Rezervacija } from "src/app/models/rezervacija";
import { Zalba } from "src/app/models/zalba";
import { ZalbaService } from "src/app/services/zalba.service";

@Component({
  selector: "hello",
  template: `
    <div style="width:300px">
      <h2 mat-dialog-title>Zalba</h2>
      <form class="reactiveForm" [formGroup] = "zalbaForm" (submit) = "onSubmit()">
      <div mat-dialog-content>
      <p>Unesite odgovor: </p>
      <mat-form-field class="full-width-input" appearance="fill">
                <mat-label>Odgovor</mat-label>
                <textarea matInput placeholder="Unesite odgovor" formControlName="obrazlozenje"></textarea>
            </mat-form-field>
      </div>
      <div mat-dialog-actions align="end">
        <span>
        <button
            type="button"
            mat-flat-button
            color="primary"
            type="submit"
            (click)="posaljiZalbu()"
          >
            Posalji
          </button>
        <button
        type="button"
        mat-stroked-button
        color="primary"
        (click)="CloseDialog()"
      >
        Izadji
      </button>
        </span>

        <mat-error name="errorRegister" *ngIf=wrong style="margin-top: 5%;">
            {{errorMessage}}
        </mat-error>    
        </div>
    </form>
      
    </div>
  `
})
export class DialogOdgovorComponent {
  zalba: Zalba;
  zalbaForm: FormGroup;
  errorMessage: string;
  vikendica : boolean;
  brod : boolean;
  instr : boolean;
  wrong: boolean;
  id : number;

  constructor(
    private _mdr: MatDialogRef<DialogOdgovorComponent>,
    private fb: FormBuilder,
    private zalbaService : ZalbaService,
    @Inject(MAT_DIALOG_DATA) data: any
  ) {
    console.log(data)
    this.wrong = false; 
    this.zalbaForm = this.fb.group({
      'obrazlozenje' : ['']
    });

    this.zalba = data;
  }

  CloseDialog() {
    this._mdr.close(false)
  }

  onSubmit(){}

  posaljiZalbu(){
    this.zalba.odgovor = this.zalbaForm.controls['obrazlozenje'].value;

    console.log(this.zalba);
      this.zalbaService.answerZalba(this.zalba).subscribe( 
        result => {
          alert("Odgovor je poslat strankama!");
          this.CloseDialog();
        },        
        (err:Error) =>{
          this.errorMessage = err.message;
          this.wrong = true;
        });
  }
}
